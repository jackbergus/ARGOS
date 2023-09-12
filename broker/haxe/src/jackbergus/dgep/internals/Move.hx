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

import jackbergus.dgep.Utils.parseJSONData;

using Lambda;

class Move {
    @:default(new List<String>())
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
class UserMoves {
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
}

function parseJSONMoves(parse) {
    var map:Map<String, UserMoves>=new Map<String, UserMoves>();
    for (username in Reflect.fields(parse)) {
        var obj = Reflect.field(parse, username);
        var um = new UserMoves();
        for (time in Reflect.fields(obj)) {
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
        }
        map.set(username, um);
    }
    return map;
}

class ResponseAndData {
    public var parseJsonMoves:Map<String, UserMoves>;
    public var data:Map<String,String>;
    
    public function new(parse) {
        data = parseJSONData(Reflect.field(parse, "data"));
        parseJsonMoves = parseJSONMoves(Reflect.field(parse, "response"));
    }

    public function availableNext(user:String, pred:String->Bool) : List<String> {
        var l = new List<String>();
        if (!parseJsonMoves.exists(user))
            return l;
        else 
            return parseJsonMoves.get(user).availableNext(pred);
    }

    public function availableFuture(user:String, pred:String->Bool)  : List<String>{
        var l = new List<String>();
        if (!parseJsonMoves.exists(user))
            return l;
        else 
            return parseJsonMoves.get(user).availableFuture(pred);
    }
}

