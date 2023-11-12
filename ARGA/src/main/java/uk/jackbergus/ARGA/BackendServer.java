package uk.jackbergus.ARGA;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.jackbergus.DundeeLogic.ArgGraph;
import uk.jackbergus.communication_test.ARGA_API;

import java.util.List;

@SpringBootApplication
@RestController
public class BackendServer {

    private ARGA_API backend = new ARGA_API();
    private ObjectMapper mapper = new ObjectMapper();

    public static void main(String args[])  {
        SpringApplication.run(BackendServer.class, args);
    }

    @GetMapping("/error")
    public String error() {
        return "ERROR";
    }

    @GetMapping("/has/GoldenRetriever")
    public boolean hasGoldenRetriever() {
        return backend.hasGoldenRetriever();
    }

    @GetMapping("/has/ARGALinker")
    public boolean hasARGALinker() {
        return backend.hasARGALinker();
    }

    @GetMapping("/list-corpora")
    public List<String> listCorpora() {
        // In this case, we return the plain text response "ok"
        return backend.listCorpora();
    }

    @GetMapping("/list-documents/{corpusId}")
    public List<String> listDocuments(@PathVariable(name = "corpusId") String corpusId) {
        return backend.getDocumentWithinCorpus(corpusId).stream().toList();
    }

    @GetMapping("/document/{corpusId}/{documentId}")
    public String getDocument(@PathVariable(name = "corpusId") String corpusId, @PathVariable(name = "documentId") String documentId) {
        return backend.getDocumentFullText(corpusId, documentId);
    }

    @GetMapping("/argument/{corpusId}/{documentId}")
    public ArgGraph getArgumentationGraph(@PathVariable(name = "corpusId") String corpusId, @PathVariable(name = "documentId") String documentId) {
        return backend.getDocumentArgumentationGraphOriginal(corpusId, documentId);
    }

    @PostMapping("/load/{corpusId}/{documentId}")
    public String loadIntoDB(@PathVariable(name = "corpusId") String corpusId, @PathVariable(name = "documentId") String documentId) {
       return String.valueOf(backend.storeDocumentIntoARGADocument(corpusId, documentId));
    }

    @PostMapping("/link/{corpusSRC}/{documentSRC}/{corpusDST}/{documentDST}")
    public String linkGraphs(@PathVariable(name = "corpusSRC") String corpusSRC, @PathVariable(name = "documentSRC") String documentSRC,
                     @PathVariable(name = "corpusDST") String corpusDST, @PathVariable(name = "documentDST") String documentDST) {
        return String.valueOf(backend.linkDocumentAcrossCorpora(corpusSRC, documentSRC, corpusDST, documentDST));
    }

    @GetMapping("/joined")
    public ArgGraph returnDumpedArgumentation() {
        return backend.representLoadedAsArgGraph();
    }

}
