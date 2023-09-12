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

import jackbergus.dgep.requests.Interaction;
import jackbergus.dgep.internals.Move;

/**
 * Dundee's representation of a Dialogue
 */
 @:keep
class Dialogue {
    public var dgdl:String;
    
    public var content_source:String;

    public var players:List<Player>;

    public var turntaking:String;

    public var backtracking:Bool;

    public var current_speaker:String;

    public var status:String;

    public var available_moves:Map<String,UserMoves>;

    public var current_speakers:List<String>;

    public var runtimevars:Map<String,List<String>>;

    public var dialogue_history:Map<String,List<Interaction>>;

    public var extURI:List<String>;

    @:keep
    public function new() {
        players = new List<Player>();
        available_moves = new Map<String, UserMoves>();
        dialogue_history = new Map<String, List<Interaction>>();
    }
}