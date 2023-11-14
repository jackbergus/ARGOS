package jackbergus.ARGA.utils;

import DundeeLogic.*;
import uk.jackbergus.ARGA.structure.annotations.HypertextualLink;
import uk.jackbergus.ARGA.structure.annotations.Sentence;
import uk.jackbergus.ARGA.structure.directoryentry.ArgaDocumentEntry;
import uk.jackbergus.ARGA.structure.locutors.Locutor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class Conversions {


    public static ArgNode toArgNode(Sentence fromSentence) {
        ArgNode self = new ArgNode();
        self.nodeID = String.valueOf(System.identityHashCode(fromSentence));
        self.text = fromSentence.text;
        self.timestamp = fromSentence.time.toString();
        if ((fromSentence.dep != null) && (!fromSentence.dep.isEmpty())) {
            String[] var = fromSentence.dep.split(";");
            if (var.length >= 1) {
                self.type = var[0];
            }
            if (var.length >= 2) {
                self.scheme = var[1];
            }
            if (var.length >= 3) {
                self.schemeID = var[2];
            }
        }
        return self;
    }

    public static Locutor asLocutor(Locutions l) {
        var loc = new Locutor();
        loc.name = l.personID;
        loc.affiliation = l.source;
        loc.role = "annotation";
        return loc;
    }

    public static ArgEdge asArgumentationEdge(HypertextualLink link) {
        var res = new ArgEdge();
        res.fromID = Integer.toString(System.identityHashCode(link.linkArguments.get(0).atomicReference));
        res.toID = Integer.toString(System.identityHashCode(link.linkArguments.get(1).atomicReference));
        res.edgeID = Integer.toString(System.identityHashCode(link));
        return res;
    }

    public static Locutions asLocutions(Locutor from) {
        var self = new Locutions();
        self.nodeID = String.valueOf(System.identityHashCode(from));
        self.personID = from.name;
        self.source = from.affiliation;
        return self;
    }

    public static Sentence asSentence(ArgNode self,
                               ArgaDocumentEntry key,
                               HashMap<String, Sentence> map) {
        Sentence sentence = new Sentence();
        sentence.main = false;
        sentence.confidenceScore = 1.0; // Missing value from the annotator
        sentence.ancestorMainSentence = null;
        sentence.speakerAnnotationConfidence = 1.0;
        sentence.dep = self.type;
        if ((self.scheme != null) && (!self.scheme.isEmpty())) {
            sentence.dep =  sentence.dep+";"+self.scheme;
            if ((self.schemeID != null) && (!self.schemeID.isEmpty())) {
                sentence.dep =  sentence.dep+";"+self.schemeID;
            }
        }

        sentence.start  = key.text.indexOf(self.text);
        sentence.end = self.text.isEmpty() ? sentence.start : sentence.start+self.text.length();
        sentence.text = self.text;
        if ((self.timestamp != null) && (!self.timestamp.isEmpty())) {
            sentence.time = Date.from(LocalDateTime.parse(self.timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant());
        }
        return sentence;
    }

    public static void fillInArgumentationGraph(HypertextualLink link, ArgGraph g) {
        ArgNode dundeeArgumentationNode = new ArgNode();
        dundeeArgumentationNode.nodeID =  Integer.toString(System.identityHashCode(dundeeArgumentationNode));
        dundeeArgumentationNode.type = link.annotationName;
        dundeeArgumentationNode.text = DundeeUtils.getTextFromEdgeType(link.annotationName);
        dundeeArgumentationNode.scheme = DundeeUtils.getSchemeFromEdgeType(link.annotationName);
        dundeeArgumentationNode.schemeID = DundeeUtils.getSchemeIDFromEdgeType(link.annotationName);
        g.nodes.add(dundeeArgumentationNode);
        String src = Integer.toString(System.identityHashCode(link.linkArguments.get(0).atomicReference));
        String dst = Integer.toString(System.identityHashCode(link.linkArguments.get(1).atomicReference));
        ArgEdge srcEdge = new ArgEdge();
        srcEdge.edgeID = Integer.toString(System.identityHashCode(srcEdge));
        srcEdge.fromID = src;
        srcEdge.toID = Integer.toString(System.identityHashCode(dundeeArgumentationNode));
        g.edges.add(srcEdge);
        ArgEdge dstEdge = new ArgEdge();
        dstEdge.edgeID = Integer.toString(System.identityHashCode(dstEdge));
        dstEdge.fromID = Integer.toString(System.identityHashCode(dundeeArgumentationNode));
        dstEdge.toID = dst;
        g.edges.add(dstEdge);
    }

}
