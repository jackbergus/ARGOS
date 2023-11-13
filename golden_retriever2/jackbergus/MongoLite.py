"""
Copyright (C) 2023  Giacomo Bergami <giacomobergami@gmail.com>

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
import json
import threading
import uuid
from readerwriterlock import rwlock

class LockedMap:
    """
    Implementing a thread-safe map allowing read-write operators
    """
    def __init__(self, x = None):
        self.lock = rwlock.RWLockFairD()
        if x is not None:
            self.data = dict(x)
        else:
            self.data = dict()

    def add(self, key, value):
        """
        Associating a key to a value. Triggers the writer lock

        :param key:
        :param value:
        :return:
        """
        with self.lock.gen_wlock():
            self.data[key] = value

    def get(self, key):
        """
        Returns the value associated to the key, and None otherwise
        :param key:
        :return:
        """
        with self.lock.gen_rlock():
            if key in self.data:
                return self.data[key]
        return None

    def delete(self, key):
        """
        Removes the key associated to the map
        :param key:
        :return:
        """
        with self.lock.gen_wlock():
            if key in self.data:
                del self.data[key]

    def deepCopy(self, lam_):
        """
        Deep-copying the data structure into a JSON serialisable way, thus removing all the non-serializable fields
        :param lam_:    Lambda function being used to potentially rebuild the value associated to the key (JSON-ready serialiser)
        :return:
        """
        result = dict()
        with self.lock.gen_rlock():
            for key in self.data:
                tmp = self.data[key]
                if lam_ is not None:
                    tmp = lam_(tmp)
                result[key] = tmp
        return result

class MongoLite:
    """
    Mimicking MongoDB operations in primary memory for reducing the amount of dependencies with externals
    """
    def __init__(self, j=None, allPerifrasi=None):
        """
        Initialises the key-value store
        :param j:               Previous data to be loaded as a database
        :param allPerifrasi:    Specific keys representing maps, to be also safeguarded by locks
        """
        if allPerifrasi is None:
            allPerifrasi = ["dialogues", "protocols"]
        self.globalLock = rwlock.RWLockFairD()
        self.locks = {}
        if allPerifrasi is None:
            self.perifrastica = set()
        else:
            self.perifrastica = set(allPerifrasi)
        self.mongo = dict()
        if j is None:
            j = {}
        elif len(self.perifrastica)>0:
            for x in j:
                if x in allPerifrasi:
                    self.mongo[x] = LockedMap(j[x])
                else:
                    self.mongo[x] = j[x]
        else:
            self.mongo = j
        if isinstance(allPerifrasi, list):
            for x in allPerifrasi:
                self.locks[x] = threading.RLock()


    def __contains__(self, x):
        if self.mongo is None:
            return False
        else:
            return x in self.mongo

    def addString(self, content, id, perifrasi):
        assert perifrasi in self.perifrastica
        if id is None:
            id = str(uuid.uuid4())
        with self.globalLock.gen_wlock():
            if perifrasi not in self.mongo:
                self.mongo[perifrasi] = LockedMap()
            self.mongo[perifrasi].add(id, content)
        return id

    def getStringP(self, id, prerifrasi):
        assert prerifrasi in self.perifrastica
        result = None
        with self.globalLock.gen_rlock():
            if prerifrasi in self.mongo:
                result = self.mongo[prerifrasi].get(id)
        return result

    def getDeepCopy(self, key):
        val = None
        with self.globalLock.gen_rlock():
            if key in self.mongo:
                if key in self.perifrastica:
                    val = self.mongo[key].deepCopy()
                else:
                    val = self.mongo[key]
        return val


    def addProtocol(self, content, protocolID = None):
        """
        Associating a protocolID to some content (the raw language)

        :param content:
        :param protocolID:
        :return:
        """
        return self.addString(content, protocolID, "protocols")

    def addDialogue(self, content, dialogueID = None):
        """
        Associating a dialogueID to its Dialouge class

        :param content:
        :param dialogueID:
        :return:
        """
        return self.addString(content, dialogueID, "dialogues")

    def getDialogue(self, dialogueID):
        """
        Returning the dialogue associated to the DialogueID if any
        :param dialogueID:
        :return:
        """
        return self.getStringP(dialogueID, "dialogues")

    def getProtocol(self, protocolId):
        """
        Returning the protocol associoated to the ProtocolId if any
        :param protocolId:
        :return:
        """
        return self.getStringP(protocolId, "protocols")

    def jsonDump(self, lam_):
        """
        Providing the json-string associated to the database
        :param lam_:
        :return:
        """
        val = dict()
        with self.globalLock.gen_rlock():
            for x in self.mongo:
                if x in self.perifrastica:
                    val[x] = self.mongo[x].deepCopy(lam_(x))
                else:
                    val[x] = self.mongo[x]
        return json.dumps(val)