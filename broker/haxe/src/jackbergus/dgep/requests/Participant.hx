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

package jackbergus.dgep.requests;

import haxe.Json;
//import json2object.JsonWriter.JsonWriter;

/**
 * Dundee's representation of a participant from the participant list to be sent via HTTP request by the initiator
 */
class RawParticipantToJSON  {
    public var name:String;
    public var player:String;

    public function new(n:String="", p:String="") {
        name=n;
        player=p;
    }
}

/**
 * Dundee's representation of a participoant list from the one sent via HTTP request
 */
class RawParticipantObjectToJSON  {
    public var participants:List<RawParticipantToJSON>;

    public function new() {
        participants = new List<RawParticipantToJSON>();
    }
}

/**
 * More OO-structured representation of a participant list, to be then sent via HTTP request
 */
 @:keep
class Participant {
    var participants:Map<String,String>;
    var parser:json2object.JsonWriter<RawParticipantObjectToJSON>;

    @:keep
    public function new() {
        participants = new Map<String,String>();
        parser = new json2object.JsonWriter<RawParticipantObjectToJSON>();
    }

    /**
     * Adding a participant name to the game with a specific role
     * @param name  Name
     * @param role  Role (player)
     */
     @:keep
    public function add(name:String, role:String) {
        participants.set(name, role);
    }

    /**
     * Returning the role associated to a specific name
     * @param x     Name
     */
     @:keep
    public function get(x:String) {
        var n:Null<String> = null;
        if (participants.exists(x)) {
            n = participants.get(x);
        }
        return n;
    }

    /**
     * Serialising the proper OO object for an HTTP request
     */
     @:keep
    public function toJSONString() {
        var obj:RawParticipantObjectToJSON = new RawParticipantObjectToJSON();
        for (user => age in participants) {
            obj.participants.add(new RawParticipantToJSON(user,age));
        }
        //return Json.stringify(obj);
        return parser.write(obj);
    }
}
