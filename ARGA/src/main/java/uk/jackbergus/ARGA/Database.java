package uk.jackbergus.ARGA;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.MultiValueMap;
import uk.jackbergus.ARGA.algorithms.AlgorithmicInstance;
import uk.jackbergus.ARGA.algorithms.ontology.NAryRelationship;
import uk.jackbergus.ARGA.algorithms.ontology.NAryRelationshipInstance;
import uk.jackbergus.ARGA.semantics.Relationship;
import uk.jackbergus.ARGA.structure.ArgaDocument;
import uk.jackbergus.ARGA.structure.ArgaDocumentCoordinates;
import uk.jackbergus.ARGA.structure.ArgaHypertext;
import uk.jackbergus.ARGA.structure.annotations.HypertextualLink;
import uk.jackbergus.ARGA.structure.annotations.Sentence;
import uk.jackbergus.ARGA.structure.directoryentry.ArgaAnnotationEntry;
import uk.jackbergus.ARGA.structure.directoryentry.ArgaDocumentEntry;
import uk.jackbergus.ARGA.structure.locutors.Algorithm;
import uk.jackbergus.ARGA.structure.locutors.Locutor;
import uk.jackbergus.DundeeLogic.ArgGraph;
import uk.jackbergus.DundeeLogic.ArgNode;
import uk.jackbergus.DundeeLogic.MinedLinks;
import uk.jackbergus.communication_test.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Database  {
    private ObjectMapper mapper;
    private final ArgaHypertext resultingHyperText;
    private final ARGAAPI api;
    HashMap<String, Locutor> corpusAsLocutor;
    HashMap<String, HashMap<String, String>> resolver;
    AlgorithmicInstance mock_miner, dundee_linker, southamptonQuerier;

    NAryRelationship argaLinkType, argaCrossLinkType;


//    Corpora corpora;
//    LinkExtractor linker;

//    SouthamptonInterrogator sq;
    Pair<ArgaAnnotationEntry, ArgaDocument> cpLinker;

    HashSet<String> alreadyVisited;
    HashSet<Pair<Pair<String,String>,Pair<String,String>>> visitedPairs;

    public Database(ARGAAPI api) {
        this.api = api;
        this.mapper = new ObjectMapper();

        // Single contact point for the database
        corpusAsLocutor = new HashMap<>();
        resultingHyperText = new ArgaHypertext("demo");
        resolver = new HashMap<>();

        // Assuming one single service: getting the information for the mock miner
        mock_miner = new AlgorithmicInstance();
        mock_miner.affiliation = "pipeline";
        mock_miner.name = api.getRetrieverServiceName();//"mock_miner";
        mock_miner.port = api.getRetrieverPort();//8000
        mock_miner.url = api.getRetrieverServer();//"http://127.0.0.1";
        mock_miner.isMultiPartContent = false;
        mock_miner.publisher = new Algorithm(mock_miner.name);


        southamptonQuerier = new AlgorithmicInstance();
        southamptonQuerier.affiliation = "pipeline";
        southamptonQuerier.name = api.getProbServiceName();//"southampton_querier";
        southamptonQuerier.port = api.getProbPort();//8888;
        southamptonQuerier.url = api.getProbServer();//"http://127.0.0.1";
        southamptonQuerier.isMultiPartContent = false;
        southamptonQuerier.publisher = new Algorithm(southamptonQuerier.name);
//        sq = new SouthamptonInterrogator(southamptonQuerier);

        // Access to the service
//        corpora = new Corpora(api);

        // Assuming one single service: getting the information for the linker across documents
        dundee_linker = new AlgorithmicInstance();
        dundee_linker.affiliation = "pipeline";
        dundee_linker.name = api.getLinkerServiceName();//"dundee_linker";
        dundee_linker.port = api.getLinkerPort();//8001;
        dundee_linker.url = api.getLinkerServer();//"http://127.0.0.1";
        dundee_linker.isMultiPartContent = false;
        dundee_linker.publisher = new Algorithm(dundee_linker.name);

        // Specifying the links within the same document
        argaLinkType = new NAryRelationship();
        argaLinkType.name = "argGraphLink";
        argaLinkType.arguments.add(new NAryRelationship.NAryRelationshipArgument("src"));
        argaLinkType.arguments.add(new NAryRelationship.NAryRelationshipArgument("dst"));

        // Specifying the links across documents
        argaCrossLinkType = new NAryRelationship();
        argaCrossLinkType.name = "argCrossLink";
        argaCrossLinkType.arguments.add(new NAryRelationship.NAryRelationshipArgument("src"));
        argaCrossLinkType.arguments.add(new NAryRelationship.NAryRelationshipArgument("dst"));
        resolver = new HashMap<>();

//        linker = new LinkExtractor(dundee_linker);
        cpLinker = generateGraphObjects("ARGA", dundee_linker, "corpus_linker");
        resultingHyperText.addDocument(cpLinker.getValue());

        alreadyVisited = new HashSet<>();
        visitedPairs = new HashSet<>();
    }


    /**
     * Using the local storage for storing a document (i.e., using JAVA to actually store the GSM as a OO-database)
     * @param corpusID      Corpus ID
     * @param documentID    Document ID
     * @return              Whether the corpus and document exist, for which the document was stored.
     */
    public boolean storeDocumentIntoARGADocument(String corpusID, String documentID) {
        if (containsDocument(corpusID, documentID))
            return false;
        for (var x : api.listCorpora()) {
            if (Objects.equals(x, corpusID)) {
                if (!resolver.containsKey(corpusID))
                    resolver.put(corpusID, new HashMap<>());
                if (api.listDocuments(corpusID).contains(documentID)) {
                    resolver.get(corpusID).put(documentID, getDocumentArgumentationGraphOriginal(corpusID, documentID).json);

                    // Loading the FullTextDocument as part of the hypertext
                    Pair<ArgaDocumentEntry, ArgaDocument> cp =
                            loadFullTextDocument(corpusID, resultingHyperText, mock_miner, api.getDocument(corpusID, documentID), documentID);

                    // Loading the ArgumentationGraph as part of the hypertext
                    loadArgumentationGraph(corpusID, resultingHyperText, mock_miner, argaLinkType, documentID, cp);
                    return true;
                }
            }
        }
        return false;
    }

    public String loadIntoDB( String corpusId, String documentId) {
        return String.valueOf(storeDocumentIntoARGADocument(corpusId, documentId));
    }

    public ArgGraph returnDumpedArgumentation() {
        return representLoadedAsArgGraph();
    }

    public boolean containsDocument(String corpusId, String documentID) {
        return slowDocumentRetrievalScanningByName(corpusId, documentID) != null;
    }

    private boolean isLocutorCorpus(Locutor loc, String corpusId) {
        return (loc != null) && (Objects.equals(loc.affiliation, "ARGA Document") &&
                                 Objects.equals(loc.role, "Corpus") &&
                                 Objects.equals(loc.name, corpusId));
    }

    private ArgaDocument slowDocumentRetrievalScanningByName(String corpusId, String documentID) {
        for (var x : resultingHyperText.references) {
            if (x.content.authorship.stream().anyMatch(y -> isLocutorCorpus(y, corpusId)) && Objects.equals(x.mnemonicName, documentID+"_argumentation"))
                return x;
        }
        return null;
    }

    public ArgGraph getDocumentArgumentationGraphOriginal(String corpusID, String documentID) {
        for (var x : api.listCorpora())
            if (Objects.equals(x, corpusID)) {
                return api.getArgumentationGraph(corpusID, documentID);
            }
        return null;
    }

    private void loadArgumentationGraph(String corpusId, ArgaHypertext resultingHyperText, AlgorithmicInstance mock_miner, NAryRelationship argaLinkType, String id, Pair<ArgaDocumentEntry, ArgaDocument> cp) {
        var graph = getDocumentArgumentationGraphOriginal(corpusId, id);
        if (graph != null) {
            var cpGraph = generateArgumentationGraphObjects(corpusId, mock_miner, id);

            HashMap<String, Sentence> map = new HashMap<>();
            for (var locutor : graph.locutions) {
                cpGraph.getKey().authorship.add(locutor.asLocutor());
            }
            for (var indexedArgumentationNodes : graph.nodeMap.entrySet()) {
                cp.getKey().isAnnotated = true;
                var node = indexedArgumentationNodes.getValue();
                Sentence sentence = node.asSentence(cp.getKey(), map);
                cpGraph.getKey().references.add(sentence);
                map.put(node.nodeID, sentence);
            }
            for (var indexedArgumentationEdges : graph.outgoings.entrySet()) {
                var src = indexedArgumentationEdges.getKey();
                for (var outgoingEdgesInfo : indexedArgumentationEdges.getValue().entrySet()) {
                    var dst = outgoingEdgesInfo.getKey();

                    var srcNode = map.get(src);
                    var dstNode = map.get(dst);

                    HypertextualLink link = new HypertextualLink();
                    link.confidenceScore = 1.0;
                    link.annotationName = "missing";

                    ArgaDocumentCoordinates srcPart = new ArgaDocumentCoordinates();
                    ArgaDocumentCoordinates dstPart = new ArgaDocumentCoordinates();
                    srcPart.atomicReference = srcNode;
                    dstPart.atomicReference = dstNode;
                    srcPart.entryReference = dstPart.entryReference = cpGraph.getKey();
                    srcPart.mainSource = dstPart.mainSource = cpGraph.getValue();
                    link.linkArguments.add(srcPart);
                    link.linkArguments.add(dstPart);

                    link.interpretation = new Relationship();
                    NAryRelationshipInstance argaLinkTypeHolder = new NAryRelationshipInstance();
                    link.interpretation.interpretation = argaLinkTypeHolder;
                    argaLinkTypeHolder.type = argaLinkType;

                    cpGraph.getKey().references.add(link);
                }
            }
            resultingHyperText.addDocument(cpGraph.getValue());
        }
    }

    private Pair<ArgaAnnotationEntry, ArgaDocument> generateGraphObjects(String corpusId, AlgorithmicInstance mock_miner, String id) {
        Pair<ArgaAnnotationEntry, ArgaDocument> cp = new ImmutablePair<>(new ArgaAnnotationEntry(), new ArgaDocument());
        cp.getKey().authorship = new ArrayList<>();
        cp.getKey().authorship.add(mock_miner);
        if (corpusId != null)
            cp.getKey().authorship.add(corpusIdAsLocutor(corpusId));

        cp.getValue().mnemonicName = id;
        cp.getValue().retrieval_time =
                Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        cp.getValue().publisher = mock_miner;
        cp.getValue().publication_time = null;
        cp.getValue().content = cp.getKey();
        return cp;
    }

    private static final String forArgumentationName = "_argumentation";

    private Pair<ArgaAnnotationEntry, ArgaDocument> generateArgumentationGraphObjects(String corpusId, AlgorithmicInstance mock_miner, String id) {
        return generateGraphObjects(corpusId, mock_miner, id+forArgumentationName);
    }

    private Pair<ArgaDocumentEntry, ArgaDocument> loadFullTextDocument(String corpusId, ArgaHypertext resultingHyperText, AlgorithmicInstance mock_miner, String x, String id) {
        Pair<ArgaDocumentEntry, ArgaDocument> cp = new ImmutablePair<>(new ArgaDocumentEntry(), new ArgaDocument());
        cp.getKey().authorship = new ArrayList<>();
        cp.getKey().authorship.add(mock_miner);
        cp.getKey().authorship.add(corpusIdAsLocutor(corpusId));
        cp.getKey().isOriginalDocument = true;
        cp.getKey().isAnnotated = false;
        cp.getKey().text =  x;

        cp.getValue().mnemonicName = id;
        cp.getValue().retrieval_time =
                Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        cp.getValue().publisher = mock_miner;
        cp.getValue().publication_time = null;
        cp.getValue().content = cp.getKey();
        resultingHyperText.addDocument(cp.getValue());
        return cp;
    }

    public Locutor corpusIdAsLocutor(String corpusId) {
        if (!corpusAsLocutor.containsKey(corpusId)) {
            var loc = new Locutor();
            loc.affiliation = "ARGA Document";
            loc.role = "Corpus";
            loc.name = corpusId;
            corpusAsLocutor.put(corpusId, loc);
        }
        return corpusAsLocutor.get(corpusId);
    }

    private Pair<Pair<String,String>,Pair<String, String>> createSRCDSTRef(String corpusSRC, String documentSRC, String corpusDST, String documentDST) {
        return new ImmutablePair<>(new ImmutablePair<>(corpusSRC, documentSRC), new ImmutablePair<>(corpusDST, documentDST));
    }

    /**
     * Mines the link across documents
     * @param corpusSRC     Corpus source ID
     * @param documentSRC   Document source ID
     * @param corpusDST     Corpus destination ID
     * @param documentDST   Document destination ID
     * @return              Whether the link was newly insterted in the document. Otherwise, nothing is inserted.
     */
    public boolean linkDocumentAcrossCorpora(String corpusSRC, String documentSRC, String corpusDST, String documentDST) {
        var ref = createSRCDSTRef(corpusSRC, documentSRC, corpusDST, documentDST);
        if (visitedPairs.add(ref)) {
            var srcDocument = slowDocumentRetrievalScanningByName(corpusSRC, documentSRC);
            var dstDocument = slowDocumentRetrievalScanningByName(corpusDST, documentDST);
            crossLink(resolver, argaCrossLinkType, corpusSRC, srcDocument, corpusDST, dstDocument);
            return true;
        }
        return false;
    }

    public boolean isDocumentLoaded(String corpusSRC, String documentID) {
        return slowDocumentRetrievalScanningByName(corpusSRC, documentID) != null;
    }

    public Object[][] listQueryNodes() {
        Set<Pair<String,String>> element = new HashSet<>();
        var g = representLoadedAsArgGraph().init();
        for (var documents : resultingHyperText.references) {
            if ((documents.mnemonicName != null) && (documents.mnemonicName.endsWith(forArgumentationName))) {
                if (documents.content instanceof ArgaAnnotationEntry) {
                    var casted = ((ArgaAnnotationEntry)documents.content);
                    for (var object : casted.references) {
                        if (object instanceof Sentence) {
                            var node = new ArgNode(((Sentence) object));
                            if (node.type.equals("I") && (!g.ingoings.get(node.nodeID).isEmpty())) {
                                element.add(new ImmutablePair<>(node.nodeID, node.text));
                            }
                        }
                    }
                }
            }
        }
        return element.stream().map(x -> new String[]{x.getKey(), x.getValue()}).toList().toArray(value -> new Object[value][2]);
    }



    /**
     * Representing the whole bulk of loaded documents as a single Dundee Argumentation graph
     *
     * @return Flattened Argumentation Graph
     */
    public ArgGraph representLoadedAsArgGraph() {
        var g = new ArgGraph();
        g.nodes = new ArrayList<>();
        g.edges = new ArrayList<>();
        g.locutions = new ArrayList<>();
        for (var documents : resultingHyperText.references) {
            if ((documents.mnemonicName != null) && (documents.mnemonicName.endsWith(forArgumentationName))) {
                if (documents.content instanceof ArgaAnnotationEntry) {
                    var casted = ((ArgaAnnotationEntry)documents.content);
                    for (var object : casted.references) {
                        if (object instanceof Sentence) {
                            g.nodes.add(new ArgNode(((Sentence) object)));
                        } else if (object instanceof HypertextualLink) {
                            g.edges.add(((HypertextualLink) object).asArgumentationEdge());
                        }
                    }
                }
            }
        }

        // Putting cross-links as links within the same argumentation
        for (var object:  cpLinker.getKey().references) {
            if (object instanceof HypertextualLink) {
                ((HypertextualLink) object).fillInArgumentationGraph(g);
            }
        }

        return g;
    }


    public String southamptonQuery(MultiValueMap<String, String> args) {
        var g = representLoadedAsArgGraph();
        if (g == null) {
            return null;
        }
        return api.southamptonQuery(g, args);
//        return sq.query(g, args);
    }

    private void crossLink(HashMap<String, HashMap<String, String>> resolver,
                           NAryRelationship argaCrossLinkType,
                           String corpusSRC,
                           ArgaDocument srcDocument,
                           String corpusDST,
                           ArgaDocument dstDocument) {
        var resolvedLinks = linkDocuments(resolver, corpusSRC, srcDocument, corpusDST, dstDocument);
        if (resolvedLinks != null) {
            for (var link : resolvedLinks) {
                HypertextualLink newLink = new HypertextualLink();
                newLink.confidenceScore = 1.0;
                newLink.annotationName = link.type;
                for (var annotation : ((ArgaAnnotationEntry) srcDocument.content).references) {
                    if ((annotation instanceof Sentence) && (annotation.text.equals(link.src))) {
                        ArgaDocumentCoordinates srcPart = new ArgaDocumentCoordinates();
                        srcPart.atomicReference = annotation;
                        srcPart.entryReference = srcDocument.content;
                        srcPart.mainSource = srcDocument;
                        newLink.linkArguments.add(srcPart);
                        break;
                    }
                }
                for (var annotation : ((ArgaAnnotationEntry) dstDocument.content).references) {
                    if ((annotation instanceof Sentence) && (annotation.text.equals(link.dst))) {
                        ArgaDocumentCoordinates dstPart = new ArgaDocumentCoordinates();
                        dstPart.atomicReference = annotation;
                        dstPart.entryReference = dstDocument.content;
                        dstPart.mainSource = dstDocument;
                        newLink.linkArguments.add(dstPart);
                        break;
                    }
                }
                newLink.interpretation = new Relationship();
                NAryRelationshipInstance argaLinkTypeHolder = new NAryRelationshipInstance();
                newLink.interpretation.interpretation = argaLinkTypeHolder;
                argaLinkTypeHolder.type = argaCrossLinkType;
                cpLinker.getKey().references.add(newLink);
            }
        }
    }

    static CollectionType minedLinksType = TypeFactory.defaultInstance().constructCollectionType(List.class, MinedLinks.class);

    private List<MinedLinks> linkDocuments(HashMap<String, HashMap<String, String>> resolver,
                                          String ArgaCorpusSRC, ArgaDocument src,
                                          String ArgaCorpusDST, ArgaDocument dst) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("src", resolver.get(ArgaCorpusSRC).get(src.mnemonicName.replace("_argumentation", "")));
            map.put("dst", resolver.get(ArgaCorpusDST).get(dst.mnemonicName.replace("_argumentation", "")));
            String x = api.link(src.mnemonicName.replace("_argumentation", ""),
                    dst.mnemonicName.replace("_argumentation", ""),
                    map);
            return mapper.readValue(x, minedLinksType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
