package uk.jackbergus.communication_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
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
import uk.jackbergus.DundeeLogic.MinedLinks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class APINonDGDL {
    static CollectionType listOfStringType = TypeFactory.defaultInstance().constructCollectionType(List.class, String.class);
    static CollectionType minedLinksType = TypeFactory.defaultInstance().constructCollectionType(List.class, MinedLinks.class);
    static ObjectMapper mapper = new ObjectMapper();


    public static void main(String args[]) {
        ArgaHypertext resultingHyperText = new ArgaHypertext("demo");

        var mock_miner = new AlgorithmicInstance();
        mock_miner.affiliation = "pipeline";
        mock_miner.name = "mock_miner";
        mock_miner.port = 8000;
        mock_miner.url = "http://127.0.0.1";
        mock_miner.isMultiPartContent = false;
        mock_miner.publisher = new Algorithm(mock_miner.name);

        var dundee_linker = new AlgorithmicInstance();
        dundee_linker.affiliation = "pipeline";
        dundee_linker.name = "dundee_linker";
        dundee_linker.port = 8001;
        dundee_linker.url = "http://127.0.0.1";
        dundee_linker.isMultiPartContent = false;
        dundee_linker.publisher = new Algorithm(mock_miner.name);

        NAryRelationship argaLinkType = new NAryRelationship();
        argaLinkType.name = "argGraphLink";
        argaLinkType.arguments.add(new NAryRelationship.NAryRelationshipArgument("src"));
        argaLinkType.arguments.add(new NAryRelationship.NAryRelationshipArgument("dst"));

        NAryRelationship argaCrossLinkType = new NAryRelationship();
        argaCrossLinkType.name = "argCrossLink";
        argaCrossLinkType.arguments.add(new NAryRelationship.NAryRelationshipArgument("src"));
        argaCrossLinkType.arguments.add(new NAryRelationship.NAryRelationshipArgument("dst"));

        String corpus = "US2016";
        HashMap<String, String> resolver = new HashMap<>();
        Set<String> someDocuments = Arrays.stream( new String[]{"nodeset10032","nodeset10042","nodeset10050","nodeset10056","nodeset10057","nodeset10058","nodeset10063","nodeset10229","nodeset10239","nodeset10240","nodeset10241","nodeset10243","nodeset10244","nodeset10247","nodeset10248","nodeset10250","nodeset10253","nodeset10273","nodeset10281","nodeset10285","nodeset10299","nodeset10300","nodeset10306","nodeset10310","nodeset10312","nodeset10314","nodeset10317","nodeset10320","nodeset10322","nodeset10324","nodeset10337","nodeset10363","nodeset10365","nodeset10367","nodeset10370","nodeset10371","nodeset10375","nodeset10376","nodeset10384","nodeset10385","nodeset10388","nodeset10389","nodeset10391","nodeset10393","nodeset10395","nodeset10400","nodeset10402","nodeset10405","nodeset10406","nodeset10407","nodeset10409","nodeset10410","nodeset10411","nodeset10412","nodeset10413","nodeset10414","nodeset10416","nodeset10419","nodeset10436","nodeset10443","nodeset10444","nodeset10445","nodeset10450","nodeset10453","nodeset10454","nodeset10457","nodeset10459","nodeset10462","nodeset10465","nodeset10474","nodeset10477","nodeset10482","nodeset10484","nodeset10488","nodeset10489","nodeset10492","nodeset10493","nodeset10494","nodeset10495","nodeset10498","nodeset10499","nodeset10506","nodeset10508","nodeset10510","nodeset10513","nodeset10514","nodeset10540","nodeset10546","nodeset10547","nodeset10549","nodeset10556","nodeset10557","nodeset10558","nodeset10559","nodeset10561","nodeset10562","nodeset10563","nodeset10566","nodeset10567","nodeset10569","nodeset10570","nodeset10573","nodeset10574","nodeset10576","nodeset10579","nodeset10581","nodeset10586","nodeset10588","nodeset10589","nodeset10590","nodeset10591","nodeset10593","nodeset10594","nodeset10595","nodeset10607","nodeset10608","nodeset10610","nodeset10621","nodeset10622","nodeset10627","nodeset10631","nodeset10632","nodeset10634","nodeset10660","nodeset10664","nodeset10665","nodeset10670","nodeset10700","nodeset10701","nodeset10810","nodeset10811","nodeset10814","nodeset10815","nodeset10820","nodeset10825","nodeset10827","nodeset10832","nodeset10834","nodeset10836","nodeset10837","nodeset10840","nodeset10842","nodeset10848","nodeset10849","nodeset10854","nodeset10857","nodeset10860","nodeset10862","nodeset10864","nodeset10867","nodeset11321","nodeset9675","nodeset9679","nodeset9706","nodeset9751","nodeset9801","nodeset9812","nodeset9839","nodeset9840","nodeset9842","nodeset9845","nodeset9846","nodeset9851","nodeset9854","nodeset9877"}).collect(Collectors.toUnmodifiableSet());
        for (var x : new Corpora(mock_miner).listCorpora()) {
            for (var id :  x.getDocumentIDs()) {
                if (!someDocuments.contains(id)) continue;
                resolver.put(id, x.getArga(id).json);
                // Loading the FullTextDocument as part of the hypertext
                Pair<ArgaDocumentEntry, ArgaDocument> cp =
                        loadFullTextDocument(resultingHyperText, mock_miner, x.getText(id), id);

                // Loading the ArgumentationGraph as part of the hypertext
                loadArgumentationGraph(resultingHyperText, mock_miner, argaLinkType, x, id, cp);
            }
        }

        HashSet<String> alreadyVisited = new HashSet<>();
        var linker = new LinkExtractor(dundee_linker);
        var cpLinker = generateGraphObjects(dundee_linker, "corpus_linker");
        resultingHyperText.addDocument(cpLinker.getValue());
        for (var src : someDocuments) {
            var srcDocument = slowDocumentRetrievalScanningByName(resultingHyperText, src);
            for (var dst : someDocuments) {
                String left = src+"."+dst;
                String right = dst+"."+src;
                if ((!dst.equals(src)) && (!alreadyVisited.contains(left)) && (!alreadyVisited.contains(right))) {
                    System.out.println(left);
                    alreadyVisited.add(left);
                    alreadyVisited.add(right);
                    var dstDocument = slowDocumentRetrievalScanningByName(resultingHyperText, dst);
                    crossLink(resolver, argaCrossLinkType, linker, cpLinker, srcDocument, dstDocument);
                    crossLink(resolver, argaCrossLinkType, linker, cpLinker, dstDocument, srcDocument);
                }
            }
        }
    }

    private static void crossLink(HashMap<String, String> resolver, NAryRelationship argaCrossLinkType, LinkExtractor linker, Pair<ArgaAnnotationEntry, ArgaDocument> cpLinker, ArgaDocument srcDocument, ArgaDocument dstDocument) {
        var resolvedLinks = linker.linkDocuments(resolver, srcDocument, dstDocument);
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

    private static ArgaDocument slowDocumentRetrievalScanningByName(ArgaHypertext db, String name) {
        for (var x : db.references) {
            if (x.mnemonicName.equals(name+"_argumentation"))
                return x;
        }
        return null;
    }

    private static void loadArgumentationGraph(ArgaHypertext resultingHyperText, AlgorithmicInstance mock_miner, NAryRelationship argaLinkType, Corpus x, String id, Pair<ArgaDocumentEntry, ArgaDocument> cp) {
        var graph = x.getArga(id);
        if (graph != null) {
            var cpGraph = generateArgumentationGraphObjects(mock_miner, id);

            HashMap<String, Sentence> map = new HashMap<>();
            for (var cp3 : graph.nodeMap.entrySet()) {
                cp.getKey().isAnnotated = true;
                var node = cp3.getValue();

                Sentence sentence = new Sentence();
                sentence.main = false;
                sentence.confidenceScore = 1.0; // Missing value from the annotator
                sentence.ancestorMainSentence = null;
                sentence.speakerAnnotationConfidence = 1.0;
                sentence.start  = cp.getKey().text.indexOf(node.text);
                sentence.end = node.text.isEmpty() ? sentence.start : sentence.start+node.text.length();
                sentence.text = node.text;
                if ((node.timestamp != null) && (!node.timestamp.isEmpty())) {
                    sentence.time = Date.from(LocalDateTime.parse(node.timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant());
                }
                cpGraph.getKey().references.add(sentence);
                map.put(node.nodeID, sentence);
            }
            for (var cp3 : graph.edgeMap.entrySet()) {
                var src = cp3.getKey();
                for (var cp2 : cp3.getValue().entrySet()) {
                    var dst = cp2.getKey();

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

    private static Pair<ArgaAnnotationEntry, ArgaDocument> generateGraphObjects(AlgorithmicInstance mock_miner, String id) {
        Pair<ArgaAnnotationEntry, ArgaDocument> cp = new ImmutablePair<>(new ArgaAnnotationEntry(), new ArgaDocument());
        cp.getKey().authorship = new ArrayList<>();
        cp.getKey().authorship.add(mock_miner);

        cp.getValue().mnemonicName = id;
        cp.getValue().retrieval_time =
                Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        cp.getValue().publisher = mock_miner;
        cp.getValue().publication_time = null;
        cp.getValue().content = cp.getKey();
        return cp;
    }

    private static Pair<ArgaAnnotationEntry, ArgaDocument> generateArgumentationGraphObjects(AlgorithmicInstance mock_miner, String id) {
        return generateGraphObjects(mock_miner, id+"_argumentation");
    }

    private static Pair<ArgaDocumentEntry, ArgaDocument> loadFullTextDocument(ArgaHypertext resultingHyperText, AlgorithmicInstance mock_miner, String x, String id) {
        Pair<ArgaDocumentEntry, ArgaDocument> cp = new ImmutablePair<>(new ArgaDocumentEntry(), new ArgaDocument());
        cp.getKey().authorship = new ArrayList<>();
        cp.getKey().authorship.add(mock_miner);
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
