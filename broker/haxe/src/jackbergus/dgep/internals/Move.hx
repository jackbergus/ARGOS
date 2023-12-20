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
package jackbergus.dgep.internals;

import haxe.macro.Type.Ref;
import json2object.JsonParser;

using Lambda;

class Move {
    @:default(new Map<String,String>())
    public var reply:Map<String,String>;

    @:default("")
    public var opener:String;

    @:default("")
    public var moveID:String;

    @:default("")
    public var target:String;

    public function new() {
        reply = new Map<String,String>();
        opener = "";
        moveID = "";
        target = "";
    }

    public function nameMatch(pred : String -> Bool) : Bool {
        return pred(this.moveID);
    }
}

/**
 * Current implementation of the protocol only distinguishes between next and future moves.
 */
/*class UserMoves {
    public var next:List<Move>;
    public var future:List<Move>;

    public function new() {
        next = new List<Move>();
        future = new List<Move>();
    }

    public function availableNext(pred: String -> Bool) : List<String> {
        return next.filter(function(x) return x.nameMatch(pred)).map(function(x) return x.moveID);
    }

    public function availableFuture(pred: String -> Bool) : List<String> {
        return future.filter(function(x) return x.nameMatch(pred)).map(function(x) return x.moveID);
    }
}*/


function parseJSONMoves(parse) {
    var map:Map<String, List<Move>>=new Map<String, List<Move>>();
    for (username in Reflect.fields(parse)) {
        var obj = Reflect.field(parse, username);
        var um = new List<Move>();
        var parser = new json2object.JsonParser<List<Move>>();
        um = parser.fromJson(obj);
        /*var um = new UserMoves();
        for (time in obj) {
            if (time == "next") {
                var json = Reflect.field( obj, time);
                for (i in 0...json.length) {
                    var x:Move = json[i];
                    um.next.add(x);
                  }
            } else if (time == "future") {
                var json = Reflect.field( obj,time);
                for (i in 0...json.length) {
                    var x:Move = json[i];
                    um.future.add(x);
                  }
            }
        }*/
        map.set(username, um);
    }
    return map;
}

class ResponseAndData {
    public var response:Map<String, List<Move>>;
    @:default(new Map<String, String>())
    public var data:Map<String,String>;
    
    public function new() {
        /*switch (parse.value) {
            case JString(x): return;
            case JNull: return;
            case JBool(bool): return;
            case JNumber(number): return;
            case JArray(values): return;
            case JObject(fields): {
                for (field in fields) {
                    if (field.name == "data") {

                    } else if (field.name == "response") {

                    }
                }
            };
        }
        data = parseJSONData(Reflect.field(parse, "data"));
        var parser = new json2object.JsonParser<Map<String, List<Move>>>();
        parseJsonMoves = parser.fromJson(Reflect.field(parse, "response"));*/
        response = new Map<String, List<Move>>();
        data = new Map<String, String>();
    }

    public function available(user:String, pred:String->Bool) : List<String> {
        var l = new List<String>();
        if (!response.exists(user))
            return l;
        else 
            return response
                        .get(user)
                        .filter(function(x) return x.nameMatch(pred))
                        .map(function(x) return x.moveID);
    }


}

