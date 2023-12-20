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
 package jackbergus.dgep;

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
 import haxe.Http;
 import restclient.RestClient;
 
 @:keep
 /**
  * Abstraction of a low-level HTTP request
  */
 class RestfulHTTPConnections {
     var url:String;
 
     @:keep
     /**
      * Associating all the requests to the same address and port. This simulates a DB connection
      * @param addr 
      * @param port 
      */
     public function new(addr:String, port:Int) {
         url = "http://"+addr+":"+port;
         
     }

     public function fileRequest(path:String, content:String="", isPut:Bool=true) {
        var req = new Http(url+path);
        var responseBytes = new haxe.io.BytesOutput();
        if (content.length > 0)
            req.setPostData(content);
        req.onError = function(error:String) { throw error; };
        if (isPut)
            req.customRequest( true, responseBytes, "PUT" );
        else // Post
            req.customRequest( true, responseBytes);
        var response = responseBytes.getBytes();
        return response.toString();
     }
 
     /**
      * Post request to a given path, while post data is specified
      * @param path         Rest of the URL
      * @param content      Payload
      */
     @:keep
     public function postFile(path:String, content:String="") {
         return fileRequest(path, content, false);
     }
     
 
     /**
      * Simple GET request
      * @param path         Rest of the URL
      */
     @:keep
     public function get(path:String) {
         return RestClient.get(url+path);
     }
 
     /**
      * Put request where file content is specified in the payload
      * @param path         Rest of the URL
      * @param content      Payload
      */
     @:keep
     public function putFile(path:String, content:String="") {
         return fileRequest(path, content, true);
     }
 
 }