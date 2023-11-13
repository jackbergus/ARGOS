package uk.jackbergus.communication_test;

import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class ARGA_API {
    static CollectionType listOfStringType = TypeFactory.defaultInstance().constructCollectionType(List.class, String.class);
    static CollectionType minedLinksType = TypeFactory.defaultInstance().constructCollectionType(List.class, MinedLinks.class);
    static ObjectMapper mapper = new ObjectMapper();

    AlgorithmicInstance mock_miner, dundee_linker, southamptonQuerier;
    ArgaHypertext resultingHyperText;

    NAryRelationship argaLinkType, argaCrossLinkType;


    HashMap<String, HashMap<String, String>> resolver;

    Corpora corpora;
    LinkExtractor linker;

    SouthamptonInterrogator sq;

    Pair<ArgaAnnotationEntry, ArgaDocument> cpLinker;
    HashSet<String> alreadyVisited;

    HashMap<String, Locutor> corpusAsLocutor;

    HashSet<Pair<Pair<String,String>,Pair<String,String>>> visitedPairs;

    public ARGA_API() {
        // Single contact point for the database
        corpusAsLocutor = new HashMap<>();
        resultingHyperText = new ArgaHypertext("demo");

        // Assuming one single service: getting the information for the mock miner
        mock_miner = new AlgorithmicInstance();
        mock_miner.affiliation = "pipeline";
        mock_miner.name = "mock_miner";
        mock_miner.port = 8000;
        mock_miner.url = "http://127.0.0.1";
        mock_miner.isMultiPartContent = false;
        mock_miner.publisher = new Algorithm(mock_miner.name);


        southamptonQuerier = new AlgorithmicInstance();
        southamptonQuerier.affiliation = "pipeline";
        southamptonQuerier.name = "southampton_querier";
        southamptonQuerier.port = 8888;
        southamptonQuerier.url = "http://127.0.0.1";
        southamptonQuerier.isMultiPartContent = false;
        southamptonQuerier.publisher = new Algorithm(southamptonQuerier.name);
        sq = new SouthamptonInterrogator(southamptonQuerier);


        // Access to the service
        corpora = new Corpora(mock_miner);

        // Assuming one single service: getting the information for the linker across documents
        dundee_linker = new AlgorithmicInstance();
        dundee_linker.affiliation = "pipeline";
        dundee_linker.name = "dundee_linker";
        dundee_linker.port = 8001;
        dundee_linker.url = "http://127.0.0.1";
        dundee_linker.isMultiPartContent = false;
        dundee_linker.publisher = new Algorithm(mock_miner.name);

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

        linker = new LinkExtractor(dundee_linker);
        cpLinker = generateGraphObjects("ARGA", dundee_linker, "corpus_linker");
        resultingHyperText.addDocument(cpLinker.getValue());

        alreadyVisited = new HashSet<>();
        visitedPairs = new HashSet<>();
    }

    private Pair<Pair<String,String>,Pair<String, String>> createSRCDSTRef(String corpusSRC, String documentSRC, String corpusDST, String documentDST) {
        return new ImmutablePair<>(new ImmutablePair<>(corpusSRC, documentSRC), new ImmutablePair<>(corpusDST, documentDST));
    }

    private Locutor corpusIdAsLocutor(String corpusId) {
        if (!corpusAsLocutor.containsKey(corpusId)) {
            var loc = new Locutor();
            loc.affiliation = "ARGA Document";
            loc.role = "Corpus";
            loc.name = corpusId;
            corpusAsLocutor.put(corpusId, loc);
        }
        return corpusAsLocutor.get(corpusId);
    }

    private boolean isLocutorCorpus(Locutor loc, String corpusId) {
        return (loc != null) && (Objects.equals(loc.affiliation, "ARGA Document") && Objects.equals(loc.role, "Corpus") && Objects.equals(loc.name, corpusId));
    }

    public boolean hasGoldenRetriever() {
        return corpora.hasGoldenRetriever();
    }

    /**
     * Listing all the corpora being available
     * @return  List of corpora of interest
     */
    public List<String> listCorpora() {
        return corpora.listCorpora().stream().map(Corpus::getCorpus).collect(Collectors.toList());
    }

    /**
     * Returning all the documents associated to a given corpus
     * @param corpusID  Corpus over which scanning the documents
     * @return          Documents associated to the given corpus
     */
    public Set<String> getDocumentWithinCorpus(String corpusID) {
        return corpora.listCorpora().stream().filter(x -> Objects.equals(x.getCorpus(),corpusID)).flatMap(x->x.getDocumentIDs().stream()).collect(Collectors.toSet());
    }

    /**
     * Returns the full-text associated to the document
     * @param corpusID  Corpus containing the document
     * @param documentID    Document to be retrieved
     * @return          Full-Text representation of the document
     */
    public String getDocumentFullText(String corpusID, String documentID) {
        for (var x : corpora.listCorpora())
            if (Objects.equals(x.getCorpus(), corpusID)) {
                return x.getText(documentID);
            }
        return "";
    }

    /**
     * Returns the argumentation graph associated to the document
     * @param corpusID      Corpus containing the document
     * @param documentID    Document to be retrieved
     * @return              JSON-String representation of the argumentation graph
     */
    public String getDocumentArgumentationGraph(String corpusID, String documentID) {
        for (var x : corpora.listCorpora())
            if (Objects.equals(x.getCorpus(), corpusID)) {
                return x.getArga(documentID).json;
            }
        return "";
    }

    public ArgGraph getDocumentArgumentationGraphOriginal(String corpusID, String documentID) {
        for (var x : corpora.listCorpora())
            if (Objects.equals(x.getCorpus(), corpusID)) {
                return x.getArga(documentID);
            }
        return null;
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
        for (var x : corpora.listCorpora()) {
            if (Objects.equals(x.getCorpus(), corpusID)) {
                if (!resolver.containsKey(corpusID))
                    resolver.put(corpusID, new HashMap<>());
                if (x.getDocumentIDs().contains(documentID)) {
                    resolver.get(corpusID).put(documentID, x.getArga(documentID).json);
                    // Loading the FullTextDocument as part of the hypertext
                    Pair<ArgaDocumentEntry, ArgaDocument> cp =
                            loadFullTextDocument(corpusID, resultingHyperText, mock_miner, x.getText(documentID), documentID);

                    // Loading the ArgumentationGraph as part of the hypertext
                    loadArgumentationGraph(corpusID, resultingHyperText, mock_miner, argaLinkType, x, documentID, cp);
                    return true;
                }
            }
        }
        return false;
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
            crossLink(resolver, argaCrossLinkType, linker, corpusSRC, srcDocument, corpusDST, dstDocument);
            return true;
        }
        return false;
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
        return sq.query(g, args);
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

    public boolean isDocumentLoaded(String corpusSRC, String documentID) {
        return slowDocumentRetrievalScanningByName(corpusSRC, documentID) != null;
    }


    public static void main(String[] args) {
        String corpus = "US2016";
        Set<String> someDocuments = Arrays.stream( new String[]{"nodeset10032","nodeset10042"/*,"nodeset10050","nodeset10056","nodeset10057","nodeset10058","nodeset10063","nodeset10229","nodeset10239","nodeset10240","nodeset10241","nodeset10243","nodeset10244","nodeset10247","nodeset10248","nodeset10250","nodeset10253","nodeset10273","nodeset10281","nodeset10285","nodeset10299","nodeset10300","nodeset10306","nodeset10310","nodeset10312","nodeset10314","nodeset10317","nodeset10320","nodeset10322","nodeset10324","nodeset10337","nodeset10363","nodeset10365","nodeset10367","nodeset10370","nodeset10371","nodeset10375","nodeset10376","nodeset10384","nodeset10385","nodeset10388","nodeset10389","nodeset10391","nodeset10393","nodeset10395","nodeset10400","nodeset10402","nodeset10405","nodeset10406","nodeset10407","nodeset10409","nodeset10410","nodeset10411","nodeset10412","nodeset10413","nodeset10414","nodeset10416","nodeset10419","nodeset10436","nodeset10443","nodeset10444","nodeset10445","nodeset10450","nodeset10453","nodeset10454","nodeset10457","nodeset10459","nodeset10462","nodeset10465","nodeset10474","nodeset10477","nodeset10482","nodeset10484","nodeset10488","nodeset10489","nodeset10492","nodeset10493","nodeset10494","nodeset10495","nodeset10498","nodeset10499","nodeset10506","nodeset10508","nodeset10510","nodeset10513","nodeset10514","nodeset10540","nodeset10546","nodeset10547","nodeset10549","nodeset10556","nodeset10557","nodeset10558","nodeset10559","nodeset10561","nodeset10562","nodeset10563","nodeset10566","nodeset10567","nodeset10569","nodeset10570","nodeset10573","nodeset10574","nodeset10576","nodeset10579","nodeset10581","nodeset10586","nodeset10588","nodeset10589","nodeset10590","nodeset10591","nodeset10593","nodeset10594","nodeset10595","nodeset10607","nodeset10608","nodeset10610","nodeset10621","nodeset10622","nodeset10627","nodeset10631","nodeset10632","nodeset10634","nodeset10660","nodeset10664","nodeset10665","nodeset10670","nodeset10700","nodeset10701","nodeset10810","nodeset10811","nodeset10814","nodeset10815","nodeset10820","nodeset10825","nodeset10827","nodeset10832","nodeset10834","nodeset10836","nodeset10837","nodeset10840","nodeset10842","nodeset10848","nodeset10849","nodeset10854","nodeset10857","nodeset10860","nodeset10862","nodeset10864","nodeset10867","nodeset11321","nodeset9675","nodeset9679","nodeset9706","nodeset9751","nodeset9801","nodeset9812","nodeset9839","nodeset9840","nodeset9842","nodeset9845","nodeset9846","nodeset9851","nodeset9854","nodeset9877"*/}).collect(Collectors.toUnmodifiableSet());
        var client = new ARGA_API();

        var corpora = client.listCorpora();
        if (corpora.contains(corpus)) {
            client.corpusIdAsLocutor(corpus); // Optional initialisation
            var documents =  client.getDocumentWithinCorpus(corpus);
            for (var id : documents) {
                if (someDocuments.contains(id)) {
                    client.storeDocumentIntoARGADocument(corpus, id);
                }
            }
            for (var src: someDocuments) {
                for (var dst: someDocuments) {
                    if (!Objects.equals(src, dst)) {
                        if (client.linkDocumentAcrossCorpora(corpus, src, corpus, dst)) {
                            System.out.println(src+"-->"+dst);
                        }
                    }
                }
            }
            try {
                String json = mapper.writeValueAsString(
                        client.representLoadedAsArgGraph());
                System.out.println(json);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("UNEXPECTED ERROR: expecting the dataset to contain the corpus");
        }
    }

    public boolean hasARGALinker() {
        return linker.hasARGALinker();
    }

    private void crossLink(HashMap<String, HashMap<String, String>> resolver,
                                  NAryRelationship argaCrossLinkType,
                                  LinkExtractor linker,
                                  String corpusSRC,
                                  ArgaDocument srcDocument,
                                  String corpusDST,
                                  ArgaDocument dstDocument) {
        var resolvedLinks = linker.linkDocuments(resolver, corpusSRC, srcDocument, corpusDST, dstDocument);
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

    public boolean containsDocument(String corpusId, String documentID) {
        return slowDocumentRetrievalScanningByName(corpusId, documentID) != null;
    }

    private ArgaDocument slowDocumentRetrievalScanningByName(String corpusId, String documentID) {
        for (var x : resultingHyperText.references) {
            if (x.content.authorship.stream().anyMatch(y -> isLocutorCorpus(y, corpusId)) && Objects.equals(x.mnemonicName, documentID+"_argumentation"))
                return x;
        }
        return null;
    }

    private void loadArgumentationGraph(String corpusId, ArgaHypertext resultingHyperText, AlgorithmicInstance mock_miner, NAryRelationship argaLinkType, Corpus x, String id, Pair<ArgaDocumentEntry, ArgaDocument> cp) {
        var graph = x.getArga(id);
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
}
