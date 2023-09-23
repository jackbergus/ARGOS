/*
 * GNU General Public License, Version 3.0
 *
 * Copyright (c) 2023 Giacomo Bergami
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jackbergus.dgep.connections;

import jackbergus.dgep.requests.Participant.Participant;
import jackbergus.dgep.internals.Move.Move;
import haxe.Json;
import jackbergus.dgep.internals.MongoDB;
import jackbergus.dgep.messages.ProtocolMessage;
import jackbergus.dgep.messages.DialogueMessage;
import jackbergus.dgep.requests.Interaction;

@:keep
class DialogueLogic {
    var x:ConnectionRaw;
    var protocolName:String;
    var dialogueName:String;
    var msg:Null<DialogueMessage>;
    //var iWriter:json2object.JsonWriter<Interaction>; // Creating a writer for Cls class

    @:keep
    public function getMovesFromMessage():Map<String, List<Move>> {
        var r:Null<Map<String, List<Move>>>=null;
        if (msg != null) {
            r = msg.moves.response;
        }
        return r;
    }

    @:keep
    public function new(x:ConnectionRaw, protocol:String, dialogue:String, msg:Null<DialogueMessage>) {
        this.x = x;
        protocolName = protocol;
        dialogueName = dialogue;
        this.msg = msg;
        //iWriter = new json2object.JsonWriter<Interaction>();
    }

    @:keep
    public function interaction(i:Interaction) {
        //var json = iWriter.write(i);
        var json = Json.stringify(i);
        return x.interaction(dialogueName, i.moveId, json);
    }

    @:keep
    public function moves(initiator:String="") {
        var z = x.dialogueMoves(dialogueName, initiator);
        if (z == null)
            trace("Communication ERROR!");
        return z;
    }
}

@:keep
class ProtocolLogic {
    var x:ConnectionRaw;
    var msg:Null<ProtocolMessage>;
    var protocol:String;
    var dialogues:Map<String,DialogueLogic>;

    @:keep
    public function new(x:ConnectionRaw, protocolName:String, msg:Null<ProtocolMessage>) {
        this.x = x;
        this.msg = msg;
        this.protocol = protocolName;
        dialogues = new Map<String,DialogueLogic>();
    }

    @:keep
    public function newDialogue(name:String, 
                                p:Participant, 
                                initiator:String="") {
        var msg:DialogueMessage = x.newDialogueFromProtocol(protocol, name, p.toJSONString(), initiator);
        var dl = new DialogueLogic(this.x, protocol, name, msg);
        dialogues.set(name, dl);
        return dl;
    }

    @:keep
    public function getMessage() {
        return msg;
    }
}


@:keep
class ConnectionLogic {
    var x:ConnectionRaw;
   // var mongoWriter:json2object.JsonWriter<MongoDB>;
    var protocols:Map<String,ProtocolLogic>;

    @:keep
    public function new(addr:String, port:Int) {
        x = new ConnectionRaw(addr, port);
        protocols = new Map<String,ProtocolLogic>();
       // mongoWriter = new json2object.JsonWriter<MongoDB>(); // Creating a writer for Cls class
    }

    @:keep
    public function dumpDB() {
        return x.dump();
    }

    @:keep
    public function loadDB(db:MongoDB) {
        var json = Json.stringify(db); // mongoWriter.write(db);
        return x.loadDB(json);
    }

    @:keep
    public function getProtocol(name:String) {
        var obj = x.getProtocol2(name);
        var protocol:Null<ProtocolLogic> = null;
        if (obj != "Protocol not found") {
            if (protocols.exists(name))
                protocol = protocols.get(name);
            else {
                var pm:ProtocolMessage=new ProtocolMessage("saved",name);
                protocols.set(name, new ProtocolLogic(x, name, pm));
                protocol = protocols.get(name);
            }
        }
        return protocol;
    }


    @:keep
    public function list() {
        return x.list();
    }

    @:keep
    public function newProtocol(name:String, data:String) {
        var obj = x.newProtocol(name, data);
        var pl = new ProtocolLogic(x, name, obj);
        protocols.set(name, pl);
        return pl;
    }
}