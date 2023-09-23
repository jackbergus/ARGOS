import json
import re

from flask import Flask
from flask import request
from readerwriterlock import rwlock

from jackbergus.MongoLite import MongoLite
from dgep import Dialogue as DGEPDialogue
# from .protocol import Protocol
_protocol_player_regex = re.compile(r"player\(([^\(\)]+)\)")
_protocol_player_spec_regex = re.compile(r"([^:{}, ]+):(?:([^:,{} ]+)|{([^{}]+)})")
_protocol_description_regex = re.compile(r"\/\*[\s]+description:[\s]+(.*)\*\/",re.IGNORECASE)

app = Flask(__name__)

dialogueLock = rwlock.RWLockFairD()
protocolLock = rwlock.RWLockFairD()

@app.route('/')
def hello_world():  # put application's code here
    return 'Hello World!'

mongo = MongoLite()

def save_dialogue(dialogue, dialogueID=None):
        """
        Save the dialogue with the given ID, or insert a new dialogue
        if no or an unmatched ID is provided
        """
        dialogueID = mongo.addDialogue(dialogue, dialogueID) #.save(), dialogueID)
        return "ok", dialogueID

@app.route('/load/', methods=['POST'])
def load():
    global mongo
    mongo = MongoLite(request.get_json())

def extractor(key, obj):
    if key == "dialogues":
        return obj.save()
    else:
        return obj

@app.route('/dump/', methods=['GET'])
def beaker():
    global mongo
    response = app.response_class(
        response=mongo.jsonDump(lambda x: (lambda y: extractor(x, y))),
        status=200,
        mimetype='application/json'
    )
    return response

@app.route('/new/<protocol>/<dialogueId>', methods = ['POST'])
@app.route('/new/<protocol>/<dialogueId>/<initiator>', methods = ['POST'])
def new(protocol,dialogueId,initiator=None):
    with dialogueLock.gen_wlock():
        status, d = load_dialogue(dialogueId)
        if status == "ok":
            return {"dialogueID": "alreadyExisting", "moves": d.get_available_moves(initiator=initiator)}, 201
        data = request.stream.read().decode("utf-8")
        try:
            data = json.loads(data)
        except:
            data = {}
        dgdl = get_protocol(protocol)
        if dgdl is not None:
            d = DGEPDialogue()
            response = d.new_dialogue(dgdl, initiator, **data)
            if "error" not in response:
                response, result = save_dialogue(d, dialogueId)
                if response == "error" and result == "owner":
                    return "ERROR 401", 401
                return {"dialogueID": result, "moves": d.get_available_moves(initiator=initiator)}, 200
            else:
                return response, 500
        else:
            return "Protocol not found", 404

def load_dialogue(dialogueID):
        dialogue = mongo.getDialogue(dialogueID)
        if dialogue is not None:
            return "ok", dialogue# DGEPDialogue(dialogue)
        else:
            return "error", "Dialogue not found"

@app.route('/<dialogueID>/moves', methods = ['GET'])
@app.route('/<dialogueID>/moves/<initiator>', methods = ['GET'])
def moves(dialogueID,initiator=None):
    with dialogueLock.gen_wlock():
        status, d = load_dialogue(dialogueID)
        if status == "ok":
            talk_talk = d.get_available_moves(initiator)
            print("Checking moves from: " + dialogueID + "/moves/" + initiator+" ["+",".join(map(lambda x : x["moveID"], talk_talk["response"][initiator]))+"]")
            return talk_talk, 200
        elif status == "error":
            if d == "owner":
                return "ERROR 401", 401
            else:
                return d, 404

@app.route("/<dialogueID>/interaction/<interactionID>",methods=["POST"])
def interaction(dialogueID, interactionID):
    with dialogueLock.gen_wlock():
        status, d = load_dialogue(dialogueID)
        if status == "ok":
            if interactionID=="PublishinteractionA":
                print("DEBUG")
            data = json.loads(request.stream.read().decode("utf-8"))
            result = d.perform_interaction(interactionID, **data)
            save_dialogue(d, dialogueID)
            print("/"+dialogueID+"/interaction/"+interactionID+" from "+data["speaker"]+": ["+",".join(map(lambda x : x["moveID"], result["response"][data["speaker"]]))+"] ## "+d.collectStores())
            return result, 200
        elif status == "error":
            if d == "owner":
                return "ERROR 401", 401
            else:
                return d, 404
        return "DialogueID: {}; interactionID: {}".format(dialogueID,interactionID), 200

@app.route("/<dialogueID>/status",methods=["GET"])
def status(dialogueID):
    with dialogueLock.gen_rlock():
        status, d = load_dialogue(dialogueID)
        if status == "ok":
            return d.save(), 200
        elif status == "error":
            if d == "owner":
                return "ERROR 401", 401
            else:
                return d, 404


def get_protocol(protocol):
        """
        Get the given protocol from mongodb
        """
        return mongo.getProtocol(protocol)

@app.route("/<protocol>",methods=["GET"])
def get(protocol):
        with protocolLock.gen_rlock():
            result = get_protocol(protocol)
            if result is not None:
                return result, 200
            else:
                return "Protocol not found", 404

def get_players(dgdl):
        """
        Extract the player specifications from the given dgdl
        """
        matches = re.findall(_protocol_player_regex, dgdl)
        players = []

        for m in matches:
            if m.strip() != "":
                player = {}
                for p in re.findall(_protocol_player_spec_regex, m.strip()):
                    p = [x for x in p if x.strip() != ""]
                    if p[0] == "roles":
                        player[p[0]] = [r.strip() for r in p[1].split(",")]
                    else:
                        player[p[0]] = p[1]
                players.append(player)

        return players

def get_description(dgdl):
        """
        Extract the content of the 'description' keyword from the DGDL spec
        """
        matches = re.findall(_protocol_description_regex, dgdl)

        for m in matches:
            m = m.strip()
            if m != "":
                return m

        return ""

@app.route("/list",methods=["GET"])
def list():
        with protocolLock.gen_rlock():
            if "protocols" not in mongo:
                return {}, 200
            else:
                protocols = mongo.getDeepCopy("protocols")
                to_return = {}
                for name in protocols:
                    dgdl = protocols[name]
                    to_return[name] = {
                        "players": get_players(dgdl),
                        "description": get_description(dgdl)
                    }
                return to_return, 200

@app.route("/new/<name>",methods=["PUT"])
def new_protocol(name):
        with protocolLock.gen_wlock():
            existingProtocol = mongo.getProtocol(name)
            if existingProtocol is None:
                content = request.data
                name = mongo.addProtocol(content.decode("utf-8"),name)
                return {"message":"saved","protocol":name}, 201
            else:
                return {"message":"alreadyExisting","protocol":name}, 201


if __name__ == '__main__':
    app.run()
