package uk.jackbergus.DundeeLogic;

import org.apache.xpath.Arg;
import uk.jackbergus.ARGA.structure.annotations.Sentence;
import uk.jackbergus.ARGA.structure.directoryentry.ArgaDocumentEntry;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class ArgNode {
    public String nodeID;
    public String text;
    public String type;
    public String timestamp;
    public String scheme;
    public String schemeID;

    public ArgNode() {

    }

    public ArgNode(Sentence fromSentence) {
        nodeID = String.valueOf(System.identityHashCode(fromSentence));
        text = fromSentence.text;
        timestamp = fromSentence.time.toString();
        if ((fromSentence.dep != null) && (!fromSentence.dep.isEmpty())) {
            String[] var = fromSentence.dep.split(";");
            if (var.length >= 1) {
                type = var[0];
            }
            if (var.length >= 2) {
                scheme = var[1];
            }
            if (var.length >= 3) {
                schemeID = var[2];
            }
        }
    }

    public Sentence asSentence(ArgaDocumentEntry key, HashMap<String, Sentence> map) {
        Sentence sentence = new Sentence();
        sentence.main = false;
        sentence.confidenceScore = 1.0; // Missing value from the annotator
        sentence.ancestorMainSentence = null;
        sentence.speakerAnnotationConfidence = 1.0;
        sentence.dep = type;
        if ((scheme != null) && (!scheme.isEmpty())) {
            sentence.dep =  sentence.dep+";"+scheme;
            if ((schemeID != null) && (!schemeID.isEmpty())) {
                sentence.dep =  sentence.dep+";"+schemeID;
            }
        }

        sentence.start  = key.text.indexOf(text);
        sentence.end = text.isEmpty() ? sentence.start : sentence.start+text.length();
        sentence.text = text;
        if ((timestamp != null) && (!timestamp.isEmpty())) {
            sentence.time = Date.from(LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant());
        }
        return sentence;
    }
}
