package jackbergus.ARGA;

import DundeeLogic.ArgGraph;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import jackbergus.ARGA.javanatives.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * Running ARGA as an HTTP server
 */
@SpringBootApplication
@RestController
public class BackendServer {

    static ARGAAPI api;
    static Database db;

    static {
        initialize();
    }

    private static void initialize() {
        Properties conf = new Properties();
        try {
            FileReader reader = new FileReader("arga.properties");
            conf.load(reader);
        } catch (IOException e) {
            System.err.println("ERROR: unable to correctly parse the configuration file: ");
            System.exit(1);
        }
        var mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Service.class);
        if (!conf.containsKey("services")) {
            System.err.println("ERROR: unable to correctly detect the 'services' file.");
            System.exit(1);
        }
        HashMap<String, Service> map;
        Service miner = null,  linker = null,  querier = null;
        try {
            map = mapper.readValue(new FileReader(new File(conf.getProperty("services"))), mapType);
            miner = map.get("miner");
            linker = map.get("linker");
            querier = map.get("querier");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        if ((!conf.containsKey("isRESTful"))|| (conf.getProperty("isRESTful").equals("false"))) {
            api = new ArgumentationARGA(miner, linker, querier);
            ((ArgumentationARGA)api).init(conf);
        } else {
            api = new RestfulARGA(miner, linker, querier);
        }
        db = new Database(api);
    }

    public static void main(String args[])  {
        SpringApplication.run(BackendServer.class, args);
    }

    @GetMapping("/has/GoldenRetriever")
    public boolean hasGoldenRetriever() {
        return api.hasGoldenRetriever();
    }

    @GetMapping("/has/ARGALinker")
    public boolean hasARGALinker() {
        return api.hasARGALinker();
    }

    @GetMapping("/southampton")
    public String southamptonQuery(@RequestHeader MultiValueMap<String, String> args) {
        return db.southamptonQuery(args);
    }

    @GetMapping("/list-corpora")
    public List<String> listCorpora() {
        // In this case, we return the plain text response "ok"
        return api.listCorpora();
    }

    @GetMapping("/list-documents/{corpusId}")
    public List<String> listDocuments(@PathVariable(name = "corpusId") String corpusId) {
        return api.listDocuments(corpusId);
    }

    public boolean isDocumentLoaded(String corpusID, String documentID) {
        return db.isDocumentLoaded(corpusID, documentID);
    }

    @GetMapping("/document/{corpusId}/{documentId}")
    public String getDocument(@PathVariable(name = "corpusId") String corpusId, @PathVariable(name = "documentId") String documentId) {
        return api.getDocument(corpusId, documentId);
    }

    @GetMapping("/argument/{corpusId}/{documentId}")
    public ArgGraph getArgumentationGraph(@PathVariable(name = "corpusId") String corpusId, @PathVariable(name = "documentId") String documentId) {
        return api.getArgumentationGraph(corpusId, documentId);
    }

    public Object[][] getQueryableNodeWithInfo() {
        return db.listQueryNodes();
    }

    @PostMapping("/load/{corpusId}/{documentId}")
    public String loadIntoDB(@PathVariable(name = "corpusId") String corpusId, @PathVariable(name = "documentId") String documentId) {
       return String.valueOf(db.loadIntoDB(corpusId, documentId));
    }

    @PostMapping("/link/{corpusSRC}/{documentSRC}/{corpusDST}/{documentDST}")
    public String linkGraphs(@PathVariable(name = "corpusSRC") String corpusSRC, @PathVariable(name = "documentSRC") String documentSRC,
                     @PathVariable(name = "corpusDST") String corpusDST, @PathVariable(name = "documentDST") String documentDST) {
        return String.valueOf(db.linkDocumentAcrossCorpora(corpusSRC, documentSRC, corpusDST, documentDST));
    }

    @GetMapping("/joined")
    public ArgGraph returnDumpedArgumentation() {
        return db.representLoadedAsArgGraph();
    }

}
