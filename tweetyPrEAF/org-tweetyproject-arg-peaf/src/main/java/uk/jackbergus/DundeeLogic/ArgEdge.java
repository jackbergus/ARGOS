package uk.jackbergus.DundeeLogic;

import org.tweetyproject.arg.peaf.syntax.aif.AIFJSONEdge;

public class ArgEdge {
    public String edgeID;
    public String fromID;
    public String toID;
    public String formEdgeID;

    public AIFJSONEdge asSouthamptonEdge() {
        var result = new AIFJSONEdge();
        result.edgeID = edgeID;
        result.fromID = fromID;
        result.toID = toID;
        return result;
    }
}
