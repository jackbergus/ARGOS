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
import jackbergus.dgep.internals.Move.ResponseAndData;
import jackbergus.dgep.messages.DialogueMessage;
import haxe.Json;
import jackbergus.dgep.internals.MongoDB;
import jackbergus.dgep.messages.ProtocolList.ProtocolList;
import json2object.JsonParser;

/**
 * Low level API providing a 1-1 match with the 
 */
@:keep
class ConnectionRaw {
    /**
     * Wrapper over the HTTP Restful requests
     */
    var url:RestfulHTTPConnections;

    /**
     * Parser over JSON data received through HTTP requests
     */
    var protocolListParser:json2object.JsonParser<Map<String,ProtocolList>>;
    @:keep

    /**
     * Creating a raw connection between a host (addr) running on a given port
     * @param addr 
     * @param port 
     */
    public function new(addr:String, port:Int) {
        url = new RestfulHTTPConnections(addr,port);
       protocolListParser = new json2object.JsonParser<Map<String,ProtocolList>>();
    }

    /**
     * Loading a DB containing the whole status of the Broker
     * @param json 
     */
    @:keep
    public function loadDB(json:String) {
        return url.postFile("/load/", json);
    }

    /**
     * Retrieving the DB as a JSON string, and then returning it
     * as a HAXE object.
     */
    @:keep
    public function dump() {
        var x = url.get("/dump/");
        //var obj:MongoDB = haxe.Json.parse(x);
        //var obj:MongoDB = mongoParser.fromJson(x);
        var mongoParser = new json2object.JsonParser<MongoDB>();
        var obj:MongoDB = mongoParser.fromJson(x);
        return obj;
    }

    /**
     * Defining a new protocol
     * @param protocol      Protocol ID
     * @param dialogue      New dialogue ID
     * @param data          Participants represented as a JSON payload
     * @param initiator     Potential initiator of the dialogue
     */
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

    /**
     * Declaring to the broker the intent of performing an action
     * @param dialogue          Dialogue id
     * @param interactionId     Action name on \forall DGDL+
     * @param json              Data payload expressing the data argument providing the parameters
     *                          for the RMI
     */
    @:keep
    public function interaction(dialogue:String, interactionId:String, json:String) {
        var str = "/"+dialogue+"/interaction/"+interactionId;
        var x = url.postFile(str, json);
        var parser = new json2object.JsonParser<ResponseAndData>();
        //var parse = Json.parse(x);
        return parser.fromJson(x);
    }

    /**
     * Determining the set of the allowed moves for a specific player
     * @param dialogue      Dialogue id
     * @param initiator     Player name
     */
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

    /**
     * Returning the information
     * @param id    Protocol ID
     */
    @:keep
    public function getProtocol2(id:String) {
        var x=url.get("/"+id);
        return x;
    }

    /**
     * Lists the registered protocols as a map associating a protocol name
     * to a list of possible players and a description associated to the
     * game.
     */
    @:keep
    public function list() {
        var x = url.putFile("/list/");
        var obj = protocolListParser.fromJson(x);
        return obj;
    }

    /**
     * Establishing a new protocol. 
     * @param name      Protocol ID/Name
     * @param data      Protocol specification in \forall DGDL+
     */
    @:keep
    public function newProtocol(name:String, data:String) : ProtocolMessage {
        var x = url.putFile("/new/"+name, data);
        var parser = new json2object.JsonParser<ProtocolMessage>();
        var obj:ProtocolMessage = parser.fromJson(x);
        return obj;
    }

}