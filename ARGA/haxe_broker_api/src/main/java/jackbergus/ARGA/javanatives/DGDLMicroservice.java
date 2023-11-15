package jackbergus.ARGA.javanatives;

import com.amihaiemil.eoyaml.Scalar;
import com.amihaiemil.eoyaml.Yaml;
import com.amihaiemil.eoyaml.YamlMapping;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackbergus.dgep.connections.ConnectionLogic;
import jackbergus.dgep.connections.DialogueLogic;
import jackbergus.dgep.requests.Participant;
import jackbergus.protocol.EvaluatorOrSubscriberServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.function.Function;

public class DGDLMicroservice extends EvaluatorOrSubscriberServer {

    private Function<String, String> microservice;

    public DGDLMicroservice(DialogueLogic c,
                            int serviceId,
                            String registerFor,
                            Object sleep,
                            Object inFuture,
                            Object inNext,
                            Object busyWait,
                            String servicePrefix) {
        super(c, serviceId, registerFor, sleep, inFuture, inNext, busyWait, servicePrefix);
    }

    public static void setup_microservice(File YAMLFile, Function<String, String> microservice) throws FileNotFoundException {
        YamlMapping config;
        try {
            config = Yaml.createYamlInput(
                    YAMLFile
            ).readYamlMapping();
        } catch (IOException e) {
            System.err.println("ERROR: unable to correctly parse the configuration file: "+YAMLFile);
            throw new RuntimeException(e);
        }
        var keys = config.keys().stream().filter(x-> x instanceof Scalar).map(x-> ((Scalar)x).value()).toList();
        if (!keys.contains("service")) {
            throw new RuntimeException("ERROR: the service requires a service name: please specify it in 'service'");
        }
        var service = config.string("service");
        if (!keys.contains("interaction")) {
            throw new RuntimeException("ERROR: a service must register for an interaction. Please specify it in 'interaction'");
        }
        var interaction = config.string("interaction");
        if (!keys.contains("game_location")) {
            throw new RuntimeException("ERROR: please specify the location where the game dialogue is located: 'game_location'");
        }
        if ((keys.contains("isGameFOL")) && (config.string("isGameFOL").toLowerCase().equals("true"))) {
            throw new RuntimeException("ERROR: this version does not support FOL Dialogues. Please ground it using the 'generalizer' script");
        }
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(config.string("game_location")));
        } catch (IOException e) {
            throw new RuntimeException("ERROR: please specify the location where the game dialogue is located: 'game_location'");
        }
        var game =  new String(bytes, StandardCharsets.UTF_8);
        Participant p = new Participant();
        if (!(keys.contains("participants"))) {
            throw new RuntimeException("ERROR: please specify the location where the participants are declared: 'participants'");
        }
        {
            TypeReference<HashMap<String,String>> typeRef
                    = new TypeReference<>() {
            };
            try {
                for (var cp :
                        new ObjectMapper().readValue(new File(config.string("participants")), typeRef).entrySet()) {
                    p.add(cp.getKey(), cp.getValue());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String url = "127.0.0.1";
        int port = 5000;
        if (keys.contains("broker_ip"))
            url = config.string("broker_ip");
        if (keys.contains("broker_port"))
            port = config.integer("broker_port");
        ConnectionLogic cl = new ConnectionLogic(url, port);
        if (!keys.contains("protocol")) {
            throw new RuntimeException("ERROR: please specify the name of the game: 'protocol'");
        }
        var pl = cl.newProtocol(config.string("protocol"), game);
        if (!keys.contains("new_dialogue")) {
            throw new RuntimeException("ERROR: please specify the name of the current dialogue instance: 'new_dialogue'");
        }
        var dl = pl.newDialogue(config.string("new_dialogue"), p, service);
        var service1 = new DGDLMicroservice(dl, -1, interaction, 5.0, null, null, null, service);
        service1.setMicroservice(microservice);
        service1.server();
    }

    @Override
    public String processInstruction(String input) {
        System.out.println("Input: "+input);
        var result = microservice.apply(input);
        System.out.println("Output: "+result);
        return result;
    }

    public void setMicroservice(Function<String, String> microservice) {
        this.microservice = microservice;
    }
}
