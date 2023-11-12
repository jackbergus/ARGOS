package uk.jackbergus.DundeeLogic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.tweetyproject.arg.peaf.syntax.aif.AIFJSONEdge;
import org.tweetyproject.arg.peaf.syntax.aif.AIFJSONNode;
import org.tweetyproject.arg.peaf.syntax.aif.AIFJSONTheory;
import org.tweetyproject.arg.peaf.syntax.aif.analysis.AIFJSONAnalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.function.IntFunction;

public class ArgGraph {
    public ArrayList<ArgNode> nodes;
    public ArrayList<ArgEdge> edges;
    public ArrayList<Locutions> locutions;

    /**
     * A Southampton theory is a Dundee argumentation graph with some additional queries associated to them
     * @param ls    List of queries of interest
     * @return      Argumentation graph extended with some queries
     */
    public AIFJSONTheory asSouthamptonQuery(AIFJSONAnalysis... ls) {
        var result = new AIFJSONTheory();
        if ((nodes != null) && (!nodes.isEmpty())) {
            result.nodes = new AIFJSONNode[nodes.size()];
            for (int i = 0; i<nodes.size(); i++) {
                result.nodes[i] = nodes.get(i).asSouthamptonNode();
            }
        } else {
            result.nodes = new AIFJSONNode[0];
        }
        if ((edges != null) && (!edges.isEmpty())) {
            result.edges = new AIFJSONEdge[edges.size()];
            for (int i = 0; i<edges.size(); i++) {
                result.edges[i] = edges.get(i).asSouthamptonEdge();
            }
        } else {
            result.edges = new AIFJSONEdge[0];
        }
        result.analyses = ls;
        // Ignore locutions
        return result;
    }

}
