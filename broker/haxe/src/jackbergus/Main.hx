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

import jackbergus.utils.Monad.ErrorMonad;
import jackbergus.protocol.ProposerOrPublisher;
import jackbergus.protocol.EvaluatorOrSubscriber.EvaluatorOrSubscriberServer;
import jackbergus.dgep.connections.ConnectionLogic;
import haxe.Json;
import jackbergus.dgep.requests.Interaction;
import jackbergus.dgep.requests.Participant;

class Testing extends EvaluatorOrSubscriberServer {
  public function processInstruction(input:String):String {
    trace(input);
    return "Reply from bogus service!";
  }
}

@:keep
class Main {
     static function main() {
          game(1);
     }

    static function game(serviceID:Int = 1) {

        var game="


        BOGUS {
          turns{magnitude:single,ordering:strict}
          roles{speaker,listener}
          players{min:2, max:undefined}
          player{id:Proposer,roles{speaker}}
          player{id:Evaluator,roles{listener}}
      
           // This is mainly to store the request: it might be renamed
          store { id: StackinteractionA, owner: shared, structure: stack, visibility : public   }
      
          // Players subscribing to the supplier to privde the information in broadcast
          store { id: PlayersinteractionA, owner: shared, structure: stack, visibility : public  }
      
          // Whether the player has already read the information from the broadcaster
          store { id: AlreadyReadinteractionA, owner: shared, structure: stack, visibility : public  }
      
          // The reply associated to the player
          store { id: ReplyinteractionA, owner: shared, structure: stack, visibility : public  }
      
          // The reply associated to the player
          store { id: ReplyAuthorinteractionA, owner: shared, structure: stack, visibility : public  }
            // This is mainly to store the request: it might be renamed
          store { id: StackinteractionB, owner: shared, structure: stack, visibility : public   }
      
          // Players subscribing to the supplier to privde the information in broadcast
          store { id: PlayersinteractionB, owner: shared, structure: stack, visibility : public  }
      
          // Whether the player has already read the information from the broadcaster
          store { id: AlreadyReadinteractionB, owner: shared, structure: stack, visibility : public  }
      
          // The reply associated to the player
          store { id: ReplyinteractionB, owner: shared, structure: stack, visibility : public  }
      
          // The reply associated to the player
          store { id: ReplyAuthorinteractionB, owner: shared, structure: stack, visibility : public  }
          
      
          rule{id:StartingRule, scope:initial, {  move(add, next, SubscribeinteractionA, Evaluator)
           &  move(add, next, SubscribeinteractionB, Evaluator)
           }}
      
      
          // First, someone can publish only if someone subscribed. This still allows other services to subscribe, and enables
          // the client to start publishing. Still, I can subscribe only if I haven’t done so yet.
          interaction { SubscribeinteractionA, { if { inspect(!in, {s}, PlayersinteractionA ) }  then {
                                               store(add, {s}, PlayersinteractionA, listener) &
                                               move(add, next, StartPublishinteractionA, $Proposer, Proposer) &
                                               move(add, next, SubscribeinteractionA, Evaluator)
                                           }
                                      }
                      }
      
          // The publisher stops all the subscribers to register and to do whatsoever operation, then, it starts adding the data
          interaction { StartPublishinteractionA, { move(delete, next, SubscribeinteractionA, $Evaluator, Evaluator) &
                                           move(add, next, PublishinteractionA, $Proposer, {p}, Proposer)
                                         }
                      }
      
          // Now, the publisher starts sending the data to the subscribers, that are going to reply to the data being passed with some
          //  data replyThis might have been better expressed with a while-true loop, but anyway, expressing that the publisher shall
          // repeat in the stack as many arguments as the number of players, while allowing the players only to publish
          interaction { PublishinteractionA , {  if { magnitude(StackinteractionA, shared, smaller, PlayersinteractionA, shared) } then {
                                                store(add, {d}, StackinteractionA, listener) &
                                                move(add, next, PublishinteractionA, $Proposer, {d}, Proposer) &
                                                store(copy, {l}, PlayersinteractionA, listener)
                                           } else {
                                                move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)
                                           }
                                     }
                      }
      
      
      
          // I can consume only if I was previously subscribed to this and if I haven’t read yet
          interaction { ConsumeinteractionA , { if { inspect(!in, {s}, AlreadyReadinteractionA )  &
                                            inspect(in, {s}, PlayersinteractionA ) }  then {
      
                                                store(pop, {p}, StackinteractionA, listener) & // reading the data for me on the stack
                                                store(add, {s}, AlreadyReadinteractionA, listener) & // Setting myself as already read the data
                                                move(add, next, PushOutcomeinteractionA, $Evaluator, Evaluator) &
                                                move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)
                                           }
                                     }
                      }
      
          interaction { PushOutcomeinteractionA, {    if { inspect(in, {s}, PlayersinteractionA) &
                                                  inspect(in, {s}, AlreadyReadinteractionA ) } then {
      
                                                    store(add, {o}, ReplyinteractionA, listener) &
                                                    store(add, {s}, ReplyAuthorinteractionA, listener) &
                                                    // Action that will be done effectively only by the last subscriber
                                                    move(add, next, TestLastinteractionA, $Evaluator, Evaluator) &
                                                    move(add, next, PushOutcomeinteractionA, $Evaluator, Evaluator) &
                                                    move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)
                                                }
                                        }
                      }
      
              interaction { TestLastinteractionA, { if { magnitude(PlayersinteractionA, shared, equal, ReplyAuthorinteractionA, shared) &
                                                magnitude(ReplyinteractionA, shared, equal, AlreadyReadinteractionA, shared) &
                                                magnitude(PlayersinteractionA, shared, equal, AlreadyReadinteractionA, shared) } then {
      
                                                      move(add, next, PopOutcomeinteractionA, $Proposer, Proposer)
                                              } else {
                                                                                            move(add, next, TestLastinteractionA, $Evaluator, Evaluator) &
                                                    move(add, next, TestLastinteractionA, $Evaluator, Evaluator) &
                                                    move(add, next, PushOutcomeinteractionA, $Evaluator, Evaluator) &
                                                    move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)
                                              }
                                         }
                          }
      
          interaction { PopOutcomeinteractionA, { if { size(ReplyinteractionA, Proposer, !empty) &
                                              size(ReplyAuthorinteractionA, Proposer, !empty)  } then {
      
                                                 store(pop, {o}, ReplyinteractionA, speaker) &
                                                 store(pop, {s}, ReplyAuthorinteractionA, speaker) &
                                                 move(add, next, PopOutcomeinteractionA, $Evaluator, Proposer)
                                            } else {
                                                  // When I reach the maximum capacity, I enforce all the players to re-register if they
                                                  // want to subscribe to the next round, and allowing all the players to consume.
                                                  store(empty, PlayersinteractionA, listener) &
                                                  store(empty, AlreadyReadinteractionA, listener) &
                                                  store(empty, ReplyinteractionA, listener) &
                                                  store(empty, ReplyAuthorinteractionA, listener) &
                                                  store(empty, StackinteractionA, listener) &
                                                  move(add, next, SubscribeinteractionA, Evaluator) // Going back to allowing the next process to subscribe itself
                                           }
                                       }
                       }
      }

        ";
        
        // Determining the service name
        var service = "service"+serviceID;

        // Programmatically defining the participant name and its role
        var participants = new Participant();
        participants.add("client", "Proposer");
        participants.add("service1", "Evaluator");
        participants.add("service2", "Evaluator");

        // Defining a connection as an host with a port
        var connection:ConnectionLogic = new ConnectionLogic("127.0.0.1",5000);
        // The connection generates a protocol by associating a name to a \forall DGDL+ instance
        // Alternatively, if the protocol already exists, we can call connection.getProtocol("test_game")
        // instead
        var pl:ProtocolLogic = connection.newProtocol("test_game", game);
        // Establishing a new instance of a dialogue from the protocol, which name is "0"
        var dl:DialogueLogic = pl.newDialogue("0", participants, service);
        // Defining a new server class
        var service1 = new Testing(dl, serviceID, "interactionA");
        // Running it as a single-threaded service
        service1.server();
        // Service exiting with an error
        trace("EXIT");
    }
}