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

/**
 * Payload associated to a movement
 */
 @:keep
class Interaction {
    public var moveId:String;
    public var speaker:String;
    public var target:String;
    public var reply:Map<String,String>;
    
    @:keep
    public function new(move:String,s:String,t:String) {
        moveId = move;
        speaker = s;
        target = t;
        reply = new Map<String,String>();
    }

    @:keep
    public function add(key:String,val:String) {
        reply.set(key, val);
    }
}