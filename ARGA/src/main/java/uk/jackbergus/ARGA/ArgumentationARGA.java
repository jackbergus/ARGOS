package uk.jackbergus.ARGA;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jackbergus.dgep.connections.ConnectionLogic;
import jackbergus.dgep.connections.ProtocolLogic;
import jackbergus.dgep.requests.Participant;
import jackbergus.protocol.ProposerOrPublisher;
import org.springframework.util.MultiValueMap;
import scala.util.parsing.combinator.testing.Str;
import uk.jackbergus.ARGA.utils.Service;
import uk.jackbergus.DundeeLogic.ArgGraph;
import uk.jackbergus.DundeeLogic.MinedLinks;
import uk.jackbergus.utils.UnionType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class ArgumentationARGA extends ARGAAPI {

    private final Participant participants;
    private ObjectMapper mapper;
    private ProposerOrPublisher ARGAServer = null;

    protected ArgumentationARGA(Service miner, Service linker, Service querier) {
        super(miner, linker, querier);
        this.participants = new Participant();
    }

    void init(Properties conf) {
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
                BufferedReader gameReader = new BufferedReader(new FileReader(conf.getProperty("game_location")));
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
        if (!conf.containsKey("participants")) {
            System.err.println("ERROR: please specify the location where the participants are declared: 'participants'");
            System.exit(1);
        }
        try {
            BufferedReader participantsReader = new BufferedReader(new FileReader(conf.getProperty("participants")));
            StringBuilder participantsContent = new StringBuilder();
            String participantsLine;
            while ((participantsLine = participantsReader.readLine()) != null) {
                participantsContent.append(participantsLine);
            }
            participantsReader.close();
            this.mapper = new ObjectMapper();
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

    private Map<String,String> retrieveRightOutcome(String action, String data)  {
        Set<String> tmp = new HashSet<>();
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        UnionType<String,Map<String,String>> outcome = null;
        do {
            outcome = run(action, data);
            if (outcome.isLeft()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
            }
        } while (outcome.isLeft());
        return outcome.getRight();
    }


    @Override
    public List<String> listCorpora() {
        Set<String> tmp = new HashSet<>();
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        var outcome = retrieveRightOutcome("interactionA", "/corpora");
        for (var cp : outcome.entrySet()) {
            if (participants.participants.exists(cp.getKey())) {
                List<String> yourClassList = new Gson().fromJson(cp.getValue(), listType);
                tmp.addAll(yourClassList);
            }
        }
        return new ArrayList<>(tmp);
    }

    @Override
    public List<String> listDocuments(String corpusId)  {
        Set<String> tmp = new HashSet<>();
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        Map<String,String> outcome = retrieveRightOutcome("interactionA", "/corpora/"+corpusId);
        for (var cp : outcome.entrySet()) {
            if (participants.participants.exists(cp.getKey())) {
                List<String> yourClassList = new Gson().fromJson(cp.getValue(), listType);
                tmp.addAll(yourClassList);
            }
        }
        return new ArrayList<>(tmp);
    }

    @Override
    public String getDocument(String corpusId, String documentId) {
        ///get/{corpora}/{document}
        Set<String> tmp = new HashSet<>();
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        Map<String,String> outcome = retrieveRightOutcome("interactionA", "/get/"+corpusId+"/"+documentId);
        for (var cp : outcome.entrySet()) {
            if (participants.participants.exists(cp.getKey())) {
                List<String> yourClassList = new Gson().fromJson(cp.getValue(), listType);
                tmp.addAll(yourClassList);
            }
        }
        assert (tmp.size() == 1);
        return tmp.iterator().next();
    }

    @Override
    public ArgGraph getArgumentationGraph(String corpusId, String documentId) {
        List<ArgGraph> tmp = new ArrayList<>();
        Map<String,String> outcome = retrieveRightOutcome("interactionA", "/mine/"+corpusId+"/"+documentId);
        for (var cp : outcome.entrySet()) {
            if (participants.participants.exists(cp.getKey())) {
                ArgGraph itemWithOwner = null;
                try {
                    itemWithOwner = mapper.readValue(cp.getValue(), ArgGraph.class);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                itemWithOwner.init();
                itemWithOwner.json = cp.getValue();
            }
        }
        assert (tmp.size() == 1);
        return tmp.iterator().next();
    }

    @Override
    public boolean hasGoldenRetriever() {
        return true;
    }

    @Override
    public boolean hasARGALinker() {
        return true;
    }

    private static class SouthamptonRequest {
        Map<String, Collection<String>> query;
        ArgGraph g;

    }

    @Override
    public String southamptonQuery(ArgGraph g, MultiValueMap<String, String> args) {
        SouthamptonRequest q = new SouthamptonRequest();
        Multimap<String, String> query = HashMultimap.create();
        for (var x : args.keySet()) {
            query.putAll(x, args.get(x));
        }
        q.query= query.asMap();
        q.g = g;
        String str = null;
        try {
            str = mapper.writeValueAsString(q);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        StringBuilder sb = new StringBuilder();
        Map<String,String> outcome = retrieveRightOutcome("interactionC", str);
        for (var cp : outcome.entrySet()) {
            if (participants.participants.exists(cp.getKey())) {
                sb.append(cp.getValue());
            }
        }
        return sb.toString();
    }

    private static class LinkDGDLRequest {
        String src_id;
        String dst_id;
        String src;
        String dst;

        public String getSrc_id() {
            return src_id;
        }

        public String getDst_id() {
            return dst_id;
        }

        public String getSrc() {
            return src;
        }

        public String getDst() {
            return dst;
        }
    }

    @Override
    public String link(String src, String dst, HashMap<String, String> map) {
        LinkDGDLRequest req = new LinkDGDLRequest();
        req.src_id = src;
        req.dst_id = dst;
        req.src = map.get("src");
        req.dst = map.get("dst");
        String str;
        List<MinedLinks> ls = new ArrayList<>();

        CollectionType minedLinksType = TypeFactory.defaultInstance().constructCollectionType(List.class, MinedLinks.class);
        try {
            str = mapper.writeValueAsString(req);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Map<String,String> outcome = retrieveRightOutcome("interactionB", str);
        for (var cp : outcome.entrySet()) {
            if (participants.participants.exists(cp.getKey())) {
                try {
                    ls.addAll((( List<MinedLinks>)mapper.readValue(cp.getValue(), minedLinksType)));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            return mapper.writeValueAsString(ls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
