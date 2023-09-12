"""
Copyright (C) 2020  Centre for Argument Technology (http://arg.tech)
              2023  Giacomo Bergami <giacomobergami@gmail.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
"""

import dgdl
import ast
from .components import *
import json
from .handlers import *
import uuid
import sys
# import pymongo
# from bson.objectid import ObjectId
from readerwriterlock import rwlock

class Dialogue:
    """
    Class to represent and manage a dialogue based on a DGDL protocol
    """

    def __init__(self, dialogue=None):
        self.parser = dgdl.DGDLParser()
        self.globalLock = rwlock.RWLockFairD()

        if dialogue is not None:
            self.load(dialogue)
        else:
            self.dgdl = None
            self.game = None

            # dialogue properties
            self.players = {}
            self.stores = {}
            self.turntaking = "strict"
            self.backtracking = False
            self.available_moves = {}
            self.current_speaker = None
            self.current_speakers = []
            self.runtimevars = {}
            self.dialogue_history = []
            self.status = "inactive"
            self.extURI = {}
            self.content_source = None


    def new_dialogue(self, dgdl, initiator, **data):
        """
        Creates a new dialogue based on the given game
        :param str protocol: the protocol corresponding to a DGDL file
        :param dict data: the data to instantiate the protocol into a dialogue

        :return dictionary representation of the dialogue
        :rtype dict
        """

        if data is None:
            data = {}

        if dgdl is not None:
            self.dgdl = dgdl
            self.game = self.parser.parse(input=dgdl)
            if isinstance(self.game, list):
                return {"errors": self.game}

            self.turntaking = self.game.turntaking
            self.backtracking = self.game.backtracking

            self.extURI = self.game.extURI
            resolveType = {}
            playerName = {}

            if "participants" in data:
                participantID = 1
                for participant in data["participants"]:
                    name = participant["name"]
                    player = participant["player"]
                    roles = [r for p in self.game.players for r in p.roles if p.playerID==player]
                    if player not in resolveType:
                        resolveType[player] = list()
                    resolveType[player].append(name)

                    self.players[name] = Player(name, player, roles, participantID)
                    participantID = participantID + 1
                    self.available_moves[name] = {"next":[], "future":[]}

            for store in self.game.stores:
                id = store.storeID
                actualStoreOwner = []
                for x in store.owner:
                    if x in playerName:
                        actualStoreOwner.append(x)
                    elif x in resolveType:
                        for l in resolveType[x]:
                            actualStoreOwner.append(l)
                self.stores[id] = Store(id, actualStoreOwner, store.structure, store.visibility, store.content)

            self.content_source = data.get("contentSource", None)

            self.start(initiator)
            return self.save()
        else:
            return {"error":"No game specification provided"}

    def start(self, initiator):
        """
        Starts this dialogue, executing all rules with "initial" scope
        """
        self.current_speaker = initiator
        for rule in self.game.rules:
            if rule.scope == "initial":
                handle_effects(self, rule.effects)
                if rule.conditional is not None:
                    effects = handle_conditional(self, rule.conditional)
                    handle_effects(self, effects)

        self.status = "active"

    def validate(self):
        ''' Checks that this dialogue satisfies the constraints of the
            game specification '''

        ''' TODO:
            - Check max + min participants
            - Check max + min participants in roles
        '''

        return

    def get_available_moves(self, initiator=None, data=None):
        """
        Returns the available moves based on 1) the current speaker(s) and 2)
            whether or not backtracking is allowed
        """
        response = {}
        if data is None:
            data = {}
        if initiator is None:
            initiator = self.current_speaker
        if self.turntaking == "strict":
            if initiator in self.available_moves:
                moves = self.available_moves[initiator]

                if moves["next"]:
                    response[initiator] = moves["next"]
                elif self.backtracking:
                    response[initiator] = moves["future"]
                else:
                    response[initiator] = []
        else:
            for player, moves in self.available_moves.items():
                if moves["next"]:
                    response[player] = moves["next"]
                elif self.backtracking and moves["future"]:
                    response[player] = moves["future"]

        return {"response":response,"data":data}

    def perform_interaction(self, interactionID, **data):
        """
        Performs the given interaction, based on the given data

        :param str interactionID: the interaction ID (move name)
        :param dict data: the data that instantiates the interaction
        :return the available moves following the interaction
        :rtype dict
        """

        '''data is expected in the following format:

           data = {
           "speaker": <User>,
            "target": <User>,
            "reply": {
                "p": "content",
                "q": "content",
                ...
            }
        }'''

        interaction = None
        self.current_speaker = data["speaker"]

        if "moveID" not in data:
            data["moveID"] = interactionID

        for i in self.game.interactions:
            if i.id == interactionID:
                interaction = i
                break

        # empty everyone's "next" moves
        for k in list(self.available_moves.keys()):
            self.available_moves[k]["next"] = []

        if interaction is not None:
            if interaction.effects:
                data = handle_effects(self, interaction.effects, data)

            if interaction.conditional is not None:
                effects = handle_conditional(self, interaction.conditional, data)
                data = handle_effects(self, effects, data)

            self.dialogue_history.append(data)
            return self.get_available_moves(initiator=self.current_speaker, data=data["reply"])
        else:
            return "Interaction not found"

    def load(self, dialogue):
        """
        Load the dialogue with the given ID from mongoDB
        :param str dialogueID: the dialogueID to load
        :return the loaded Dialogue
        :rtype Dialogue
        """

        self.dgdl = dialogue["dgdl"]

        # self.dialogueID = dialogue["dialogueID"]
        self.game = self.parser.parse(input=self.dgdl)
        self.available_moves = dialogue["available_moves"]
        self.current_speaker = dialogue["current_speaker"]
        self.backtracking = dialogue["backtracking"]
        self.turntaking = dialogue["turntaking"]
        self.dialogue_history = dialogue["dialogue_history"]
        self.current_speakers = dialogue["current_speakers"]
        self.runtimevars = dialogue["runtimevars"]
        self.status = dialogue["status"]
        self.extURI = dialogue["extURI"]
        self.content_source = dialogue["content_source"]

        self.players = {}
        self.stores = {}

        for name, player in dialogue["players"].items():
            self.players[name] = Player(player["name"], player["player"], player["roles"])

        for name, store in dialogue["stores"].items():
            self.stores[name] = Store(store["id"], store["owner"], store["structure"],store["visibility"], store["content"])

        return self

    def save(self):
        ''' Get a dict representation of this dialogue '''

        to_return = {
            "dgdl": self.dgdl,
            "players": {key: value.__dict__ for key,value in self.players.items()},
            "turntaking": self.turntaking,
            "backtracking": self.backtracking,
            "stores": {key: value.copyWithoutLock() for key, value in self.stores.items()},
            "current_speaker": self.current_speaker,
            "available_moves": self.available_moves,
            "dialogue_history": self.dialogue_history,
            "current_speakers": self.current_speakers,
            "runtimevars": self.runtimevars,
            "status": self.status,
            "extURI": self.extURI,
            "content_source": self.content_source
        }

        return to_return
