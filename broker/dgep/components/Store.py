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

from .Component import Component
from readerwriterlock import rwlock

class Store(Component):
    def __init__(self, id, owner, structure, visibility, content):
        self.id = id
        self.owner = owner
        self.structure = structure
        self.visibility = visibility
        if content is None:
            content = list()
        self.content = content
        self.globalLock = rwlock.RWLockFairD()



    def copyWithoutLock(self):
        return {"owner": self.owner, "structure":self.structure, "visibility":self.visibility, "content":self.content}

    def get(self, pos:int):
        val = None
        with self.globalLock.gen_rlock():
            if len(self.content)>=pos and len(self.content)>0:
                val = None
            else:
                val = self.content[pos]
        return val

    def copy(self):
        ls = list()
        with self.globalLock.gen_rlock():
            for x in self.content:
                ls.append(x)
        return ls

    def pop(self):
        result = None
        with self.globalLock.gen_wlock():
            if len(self.content)>0:
                result = self.content.pop()
        return result

    def remove(self, content):
        with self.globalLock.gen_wlock():
            self.content.remove(content)
    def append(self, content):
        with self.globalLock.gen_wlock():
            self.content.append(content)

    def contains(self, content, negated=False):
        result = None
        with self.globalLock.gen_rlock():
            result = content in self.content
            if negated:
                result = not result
        return result
