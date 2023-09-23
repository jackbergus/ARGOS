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

import jackbergus.dgep.messages.ProtocolMessage;
import jackbergus.dgep.messages.ProtocolMessage;
import jackbergus.dgep.internals.Move.ResponseAndData;
import jackbergus.dgep.messages.DialogueMessage;
import haxe.Json;
import jackbergus.dgep.internals.MongoDB;
import jackbergus.dgep.messages.ProtocolList.ProtocolList;
import json2object.JsonParser;

@:keep
class ConnectionRaw {
    var url:RestfulHTTPConnections;
    var protocolListParser:json2object.JsonParser<Map<String,ProtocolList>>;
    @:keep
    public function new(addr:String, port:Int) {
        url = new RestfulHTTPConnections(addr,port);
       protocolListParser = new json2object.JsonParser<Map<String,ProtocolList>>();
    }
    @:keep
    public function loadDB(json:String) {
        return url.postFile("/load/", json);
    }
    @:keep
    public function dump() {
        var x = url.get("/dump/");
        var obj:MongoDB = haxe.Json.parse(x);
        //var obj:MongoDB = mongoParser.fromJson(x);
        return obj;
    }

    @:keep
    public function newDialogueFromProtocol(protocol:String, dialogue:String, data:String,initiator:String="") {
        var str = "/new/"+protocol+"/"+dialogue;
        if (initiator.length>0)
            str = str+"/"+initiator;
        var x = url.postFile(str, data);
        //var js = hxjsonast.Parser.parse(x, "filename");
        var msgParser = new json2object.JsonParser<DialogueMessage>();
        var msg:DialogueMessage = msgParser.fromJson(x);
        return msg;
    }
    @:keep
    public function interaction(dialogue:String, interactionId:String, json:String) {
        var str = "/"+dialogue+"/interaction/"+interactionId;
        var x = url.postFile(str, json);
        var parser = new json2object.JsonParser<ResponseAndData>();
        //var parse = Json.parse(x);
        return parser.fromJson(x);
    }
    @:keep
    public function dialogueMoves(dialogue:String, initiator:String="") {
        var str = "/"+dialogue+"/moves/";
        if (initiator.length>0)
            str = str+initiator;
        var x = url.get(str);
        var parser = new json2object.JsonParser<ResponseAndData>();
        //var parse = Json.parse(x);
        return parser.fromJson(x);
    }

    @:keep
    public function getProtocol2(id:String) {
        var x=url.get("/"+id);
        return x;
    }
    @:keep
    public function list() {
        var x = url.putFile("/list/");
        var obj = protocolListParser.fromJson(x);
        return obj;
    }

    @:keep
    public function newProtocol(name:String, data:String) {
        var x = url.putFile("/new/"+name, data);
        var parser = new json2object.JsonParser<ProtocolMessage>();
        var obj:ProtocolMessage = parser.fromJson(x);
        return obj;
    }

}