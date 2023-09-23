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

package jackbergus.dgep.messages;

import jackbergus.dgep.internals.Move.ResponseAndData;

@:keep
class DialogueMessage {
    public var moves:ResponseAndData;
    @:default("")
    public var dialogueID:String;

    @:keep
    public function new(/*js:hxjsonast.Json*/) {
        moves = new ResponseAndData();
        dialogueID = "";
        /*switch (js.value){
            case JNull: return;
            case JString(string): return;
            case JBool(bool): return;
            case JNumber(number): return;
            case JArray(values): return;
            case JObject(fields):{
                for (field in fields) {
                    if (field.name == "dialogueID") {
                        switch (field.value.value) {
                            case JString(x): dialogueID = x;
                            case JNull: return;
                            case JBool(bool): return;
                            case JNumber(number): return;
                            case JArray(values): return;
                            case JObject(fields): return;
                        }
                    } else if (field.name == "moves") {
                        moves = new ResponseAndData(field.value.value);
                    }
                }
            }
        }*/
    }
}