package uk.jackbergus.DundeeLogic;

import org.tweetyproject.arg.peaf.syntax.aif.AIFJSONNode;

public class ArgNode {
    public String nodeID;
    public String text;
    public String type;
    public String timestamp;
    public String scheme;
    public String schemeID;

    public ArgNode() {
    }

    public AIFJSONNode asSouthamptonNode() {
        var result = new AIFJSONNode();
        result.nodeID = nodeID;
        result.text = text;
        result.type = type;
        return result;
    }
}
