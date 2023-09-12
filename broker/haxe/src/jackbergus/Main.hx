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
package jackbergus;

import jackbergus.dgep.connections.ConnectionLogic;
import haxe.Json;
import jackbergus.dgep.requests.Interaction;
import jackbergus.dgep.requests.Participant;



@:keep
class Main {
    static function main() {

        var game="
        BOGUS {
            turns{magnitude:single,ordering:strict}
            roles{speaker,listener}
            players{min:2, max:undefined}
            player{id:Proposer,roles{speaker}}
            player{id:Evaluator,roles{listener}}
            store { id: Stack, owner: shared, structure: stack, visibility : public   }
            store { id: Players, owner: shared, structure: stack, visibility : public  }
        
            rule{id:StartingRule, scope:initial, { move(add, next, Subscribe, Evaluator)  }}
        
            // The publisher stops all the subscribers to register and to do whatsever operation, then, it starts adding the data
            interaction { StartPublish , { move(delete, next, Subscribe, $Evaluator, Evaluator) &
                                           move(add, next, Publish, $Proposer, {p}, Proposer)
                                         }
                        }
            // This might have been better expressed with a while-true loop, but anyway, expressing that the publisher shall
            // repeat in the stack as many arguments as the number of players, while allowing the players only to publish
            interaction { Publish , {
                                        if { magnitude(Stack, shared, smaller, Players, shared) } then
                                        { store(add, {p}, Stack, listener) &
                                          move(add, next, Publish, $Proposer, {p}, Proposer) }
                                        // When I reach the maximum capacity, I enforce all the players to re-register if they want to
                                        // subscribe to the next round, and allowing all the players to consume. The language seems
                                        else
                                        { store(empty, {\"bogus\"}, Players, listener) &
                                          move(add, next, Consume, $Evaluator, Evaluator)  }
                                    }
                        }
        
            //interaction { Consume , { store(get, {p}, Stack, listener) } }
        
            // First, someone can publish only if someone subscribed. This still allows other services to subscribe, and enables
            // the client to start publishing
            interaction { Subscribe, { move(add, next, StartPublish, $Proposer, Proposer) &
                                       store(add, {s}, Players, listener) &
                                       move(add, next, Subscribe, Evaluator)
                                     }
                        }
        
        }
        ";
        

        var participants = new Participant();
        participants.add("client", "Proposer");
        participants.add("service1", "Evaluator");
        participants.add("service2", "Evaluator");

        var connection:ConnectionLogic = new ConnectionLogic("127.0.0.1",5000);
        var pl:ProtocolLogic = connection.newProtocol("test_game", game);//connection.getProtocol("test_game"); //
        var dl:DialogueLogic = pl.newDialogue("0", participants);
        
        var i1 = new Interaction("Subscribe", "service1", "client");
        i1.add("s", "service1");
        var i1moves = dl.interaction(i1);
        var db = connection.dumpDB();
        trace(Json.stringify(i1));
    }
}