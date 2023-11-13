package uk.jackbergus.communication_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import jackbergus.dgep.connections.ConnectionLogic;
import jackbergus.dgep.connections.ProtocolLogic;
import jackbergus.dgep.requests.Participant;
import jackbergus.protocol.ProposerOrPublisher;
import uk.jackbergus.utils.UnionType;

import java.io.*;
import java.util.*;

public class MainCommunication {

    private ProposerOrPublisher ARGAServer = null;

    public MainCommunication(String yamlConfigurationFilePath) {
        Properties conf = new Properties();
        try {
            FileReader reader = new FileReader(yamlConfigurationFilePath);
            conf.load(reader);
        } catch (IOException e) {
            System.err.println("ERROR: unable to correctly parse the configuration file: " + yamlConfigurationFilePath);
            System.exit(1);
        }
        if (!conf.containsKey("service")) {
            System.err.println("ERROR: the service requires a service name: please specify it in 'service'");
            System.exit(1);
        }
        String service = (String) conf.get("service");
        String game = "";
        if (!conf.containsKey("game_location")) {
            System.err.println("ERROR: please specify the location where the game dialogue is located: 'game_location'");
            System.exit(1);
        }
        if (conf.containsKey("isGameFOL") && Objects.equals(conf.get("isGameFOL"), "true")) {
            System.err.println("ERROR: Java does not support generic Dialogue specification. Please provide the grounded version of it!");
            System.exit(1);
        } else {
            try {
                BufferedReader gameReader = new BufferedReader(new FileReader((String) conf.getProperty("game_location")));
                String gameLine;
                StringBuilder gameContent = new StringBuilder();
                while ((gameLine = gameReader.readLine()) != null) {
                    gameContent.append(gameLine);
                }
                gameReader.close();
                game = gameContent.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        var participants = new Participant();
        if (!conf.containsKey("participants")) {
            System.err.println("ERROR: please specify the location where the participants are declared: 'participants'");
            System.exit(1);
        }
        try {
            BufferedReader participantsReader = new BufferedReader(new FileReader((String) conf.getProperty("participants")));
            StringBuilder participantsContent = new StringBuilder();
            String participantsLine;
            while ((participantsLine = participantsReader.readLine()) != null) {
                participantsContent.append(participantsLine);
            }
            participantsReader.close();
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> participantsMap = mapper.readValue(new File((String) conf.get("participants")), Map.class);
            for (Map.Entry<String, String> entry : participantsMap.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                participants.add(k, v);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = "127.0.0.1";
        int port = 5000;
        if (conf.containsKey("broker_ip"))
            url = conf.getProperty("broker_ip");
        if (conf.containsKey("port"))
            port = Integer.parseInt(conf.getProperty("broker_port"));
        ConnectionLogic cl = new ConnectionLogic(url, port);
        if (!conf.containsKey("protocol")) {
            System.err.println("ERROR: please specify the location where the participants are declared: 'participants'");
            System.exit(1);
        }
        ProtocolLogic pl = cl.newProtocol(conf.getProperty("protocol"), game);
        if (!conf.containsKey("new_dialogue")) {
            System.err.println("ERROR: please specify the name of the current dialogue instance: 'new_dialogue'");
            System.exit(1);
        }
        var dl = pl.newDialogue(conf.getProperty("new_dialogue"), participants, "Proposer");
        this.ARGAServer = new ProposerOrPublisher(dl,  service, null, null);
    }
    public UnionType<String,Map<String,String>> run(String action, String data) {
        var monad = ARGAServer.returnResultsFromSubscribers(action, data);
        Map<String, String> servicesReply = new HashMap<>();
        if (monad.params[0] instanceof haxe.ds.StringMap) {
            var m = (haxe.ds.StringMap) (monad.params[0]);
            var it = (haxe.ds._StringMap.StringMapKeyIterator<String>) (m.keys());
            while (it.hasNext()) {
                var x = it.next();
                servicesReply.put(x, m.get(x).toString());
            }
            return UnionType.generateRight(servicesReply);
        } else {
            return UnionType.generateLeft(Arrays.toString(monad.params));
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        legacy_runner();
        var arga = new MainCommunication("/home/giacomo/projects/tweetyPrEAF/ARGA/arga.properties");
        System.out.println(arga.run("interactionA", "/corpora").toString());
    }

    private static void legacy_runner() throws InterruptedException {
        String game = "\n" +
                "\n" +
                "BOGUS {\n" +
                "    turns{magnitude:single,ordering:strict}\n" +
                "    roles{speaker,listener}\n" +
                "    players{min:2, max:undefined}\n" +
                "    player{id:Proposer,roles{speaker}}\n" +
                "    player{id:Evaluator,roles{listener}}\n" +
                "\n" +
                "     // This is mainly to store the request: it might be renamed\n" +
                "    store { id: StackinteractionA, owner: shared, structure: stack, visibility : public   }\n" +
                "\n" +
                "    // Players subscribing to the supplier to privde the information in broadcast\n" +
                "    store { id: PlayersinteractionA, owner: shared, structure: stack, visibility : public  }\n" +
                "\n" +
                "    // Whether the player has already read the information from the broadcaster\n" +
                "    store { id: AlreadyReadinteractionA, owner: shared, structure: stack, visibility : public  }\n" +
                "\n" +
                "    // The reply associated to the player\n" +
                "    store { id: ReplyinteractionA, owner: shared, structure: stack, visibility : public  }\n" +
                "\n" +
                "    // The reply associated to the player\n" +
                "    store { id: ReplyAuthorinteractionA, owner: shared, structure: stack, visibility : public  }\n" +
                "      // This is mainly to store the request: it might be renamed\n" +
                "    store { id: StackinteractionB, owner: shared, structure: stack, visibility : public   }\n" +
                "\n" +
                "    // Players subscribing to the supplier to privde the information in broadcast\n" +
                "    store { id: PlayersinteractionB, owner: shared, structure: stack, visibility : public  }\n" +
                "\n" +
                "    // Whether the player has already read the information from the broadcaster\n" +
                "    store { id: AlreadyReadinteractionB, owner: shared, structure: stack, visibility : public  }\n" +
                "\n" +
                "    // The reply associated to the player\n" +
                "    store { id: ReplyinteractionB, owner: shared, structure: stack, visibility : public  }\n" +
                "\n" +
                "    // The reply associated to the player\n" +
                "    store { id: ReplyAuthorinteractionB, owner: shared, structure: stack, visibility : public  }\n" +
                "    \n" +
                "\n" +
                "    rule{id:StartingRule, scope:initial, {  move(add, next, SubscribeinteractionA, Evaluator)\n" +
                "     &  move(add, next, SubscribeinteractionB, Evaluator)\n" +
                "     }}\n" +
                "\n" +
                "\n" +
                "    // First, someone can publish only if someone subscribed. This still allows other services to subscribe, and enables\n" +
                "    // the client to start publishing. Still, I can subscribe only if I haven’t done so yet.\n" +
                "    interaction { SubscribeinteractionA, { if { inspect(!in, {s}, PlayersinteractionA ) }  then {\n" +
                "                                         store(add, {s}, PlayersinteractionA, listener) &\n" +
                "                                         move(add, next, StartPublishinteractionA, $Proposer, Proposer) &\n" +
                "                                         move(add, next, SubscribeinteractionA, Evaluator)\n" +
                "                                     }\n" +
                "                                }\n" +
                "                }\n" +
                "\n" +
                "    // The publisher stops all the subscribers to register and to do whatsoever operation, then, it starts adding the data\n" +
                "    interaction { StartPublishinteractionA, { move(delete, next, SubscribeinteractionA, $Evaluator, Evaluator) &\n" +
                "                                     move(add, next, PublishinteractionA, $Proposer, {p}, Proposer)\n" +
                "                                   }\n" +
                "                }\n" +
                "\n" +
                "    // Now, the publisher starts sending the data to the subscribers, that are going to reply to the data being passed with some\n" +
                "    //  data replyThis might have been better expressed with a while-true loop, but anyway, expressing that the publisher shall\n" +
                "    // repeat in the stack as many arguments as the number of players, while allowing the players only to publish\n" +
                "    interaction { PublishinteractionA , {  if { magnitude(StackinteractionA, shared, smaller, PlayersinteractionA, shared) } then {\n" +
                "                                          store(add, {d}, StackinteractionA, listener) &\n" +
                "                                          move(add, next, PublishinteractionA, $Proposer, {d}, Proposer)\n" +
                "                                     } else {\n" +
                "                                          move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)\n" +
                "                                     }\n" +
                "                               }\n" +
                "                }\n" +
                "\n" +
                "\n" +
                "\n" +
                "    // I can consume only if I was previously subscribed to this and if I haven’t read yet\n" +
                "    interaction { ConsumeinteractionA , { if { inspect(!in, {s}, AlreadyReadinteractionA )  &\n" +
                "                                      inspect(in, {s}, PlayersinteractionA ) }  then {\n" +
                "\n" +
                "                                          store(pop, {p}, StackinteractionA, listener) & // reading the data for me on the stack\n" +
                "                                          store(add, {s}, AlreadyReadinteractionA, listener) & // Setting myself as already read the data\n" +
                "                                          move(add, next, PushOutcomeinteractionA, $Evaluator, Evaluator) &\n" +
                "                                          move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)\n" +
                "                                     }\n" +
                "                               }\n" +
                "                }\n" +
                "\n" +
                "    interaction { PushOutcomeinteractionA, {    if { inspect(in, {s}, PlayersinteractionA) &\n" +
                "                                            inspect(in, {s}, AlreadyReadinteractionA ) } then {\n" +
                "\n" +
                "                                              store(add, {o}, ReplyinteractionA, listener) &\n" +
                "                                              store(add, {s}, ReplyAuthorinteractionA, listener) &\n" +
                "                                              // Action that will be done effectively only by the last subscriber\n" +
                "                                              move(add, next, TestLastinteractionA, $Evaluator, Evaluator) &\n" +
                "                                              move(add, next, PushOutcomeinteractionA, $Evaluator, Evaluator) &\n" +
                "                                              move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)\n" +
                "                                          }\n" +
                "                                  }\n" +
                "                }\n" +
                "\n" +
                "        interaction { TestLastinteractionA, { if { magnitude(PlayersinteractionA, shared, equal, ReplyAuthorinteractionA, shared) &\n" +
                "                                          magnitude(ReplyinteractionA, shared, equal, AlreadyReadinteractionA, shared) } then {\n" +
                "\n" +
                "                                                move(add, next, PopOutcomeinteractionA, $Proposer, Proposer)\n" +
                "                                        } else {\n" +
                "                                                                                      move(add, next, TestLastinteractionA, $Evaluator, Evaluator) &\n" +
                "                                              move(add, next, TestLastinteractionA, $Evaluator, Evaluator) &\n" +
                "                                              move(add, next, PushOutcomeinteractionA, $Evaluator, Evaluator) &\n" +
                "                                              move(add, next, ConsumeinteractionA, $Evaluator, Evaluator)\n" +
                "                                        }\n" +
                "                                   }\n" +
                "                    }\n" +
                "\n" +
                "    interaction { PopOutcomeinteractionA, { if { size(ReplyinteractionA, Proposer, !empty) &\n" +
                "                                        size(ReplyAuthorinteractionA, Proposer, !empty)  } then {\n" +
                "\n" +
                "                                           store(pop, {o}, ReplyinteractionA, speaker) &\n" +
                "                                           store(pop, {s}, ReplyAuthorinteractionA, speaker) &\n" +
                "                                           move(add, next, PopOutcomeinteractionA, $Evaluator, Proposer)\n" +
                "                                      } else {\n" +
                "                                            // When I reach the maximum capacity, I enforce all the players to re-register if they\n" +
                "                                            // want to subscribe to the next round, and allowing all the players to consume.\n" +
                "                                            store(empty, PlayersinteractionA, listener) &\n" +
                "                                            store(empty, AlreadyReadinteractionA, listener) &\n" +
                "                                            store(empty, ReplyinteractionA, listener) &\n" +
                "                                            store(empty, ReplyAuthorinteractionA, listener) &\n" +
                "                                            store(empty, StackinteractionA, listener) &\n" +
                "                                            move(add, next, SubscribeinteractionA, Evaluator) // Going back to allowing the next process to subscribe itself\n" +
                "                                     }\n" +
                "                                 }\n" +
                "                 }\n" +
                "}\n";
//        System.out.println(game);

        var p = new Participant();
        p.add("client", "Proposer");
        p.add("service1", "Evaluator");
        p.add("service2", "Evaluator");
        ConnectionLogic cl = new ConnectionLogic("127.0.0.1", 5000);
        ProtocolLogic protocolLogic = cl.newProtocol("game", game);
        var dl = protocolLogic.newDialogue("0", p, "Proposer");

        ProposerOrPublisher ARGAServer = new ProposerOrPublisher(dl,  "client", null, null);
        while (true) {
            var monad = ARGAServer.returnResultsFromSubscribers("interactionA", "/corpora");
            if (monad.params[0] instanceof haxe.ds.StringMap) {
                var m = (haxe.ds.StringMap) (monad.params[0]);
                var it = (haxe.ds._StringMap.StringMapKeyIterator<String>) (m.keys());
                while (it.hasNext()) {
                    var x = it.next();
                    System.out.println(x+"-->"+m.get(x).toString());
                }
            } else {
                System.out.println(Arrays.toString(monad.params));
                Thread.sleep(10000);
            }
        }
    }


}
