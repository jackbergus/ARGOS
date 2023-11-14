package DundeeLogic;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArgGraph {
    public ArrayList<ArgNode> nodes;
    public ArrayList<ArgEdge> edges;
    public ArrayList<Locutions> locutions;

    @JsonIgnore
    public String json;
    @JsonIgnore
    public HashMap<String, ArgNode> nodeMap = null;
    @JsonIgnore
    public HashMap<String, HashMap<String, List<ArgEdge>>> outgoings = null;
    @JsonIgnore
    public HashMap<String, HashMap<String, List<ArgEdge>>> ingoings = null;
    @JsonIgnore
    public HashMap<String, HashSet<String>> locutorMap = null;


    @JsonIgnore
    public boolean initialised = false;

    public ArgGraph init() {
        nodeMap = new HashMap<>();
        ingoings = new HashMap<>();
        outgoings = new HashMap<>();
        if (nodes != null) {
            for (var x : nodes) {
                nodeMap.put(x.nodeID, x);
            }
//            nodes.clear();
        }
        if (edges != null) {
            for (var x : edges) {
                if (!outgoings.containsKey(x.fromID))
                    outgoings.put(x.fromID, new HashMap<>());
                if (!ingoings.containsKey(x.toID))
                    ingoings.put(x.toID, new HashMap<>());
                if (!outgoings.get(x.fromID).containsKey(x.toID)) {
                    outgoings.get(x.fromID).put(x.toID, new ArrayList<>());
                }
                if (!ingoings.get(x.toID).containsKey(x.fromID)) {
                    ingoings.get(x.toID).put(x.fromID, new ArrayList<>());
                }
                outgoings.get(x.fromID).get(x.toID).add(x);
                ingoings.get(x.toID).get(x.fromID).add(x);
            }
//            edges.clear();
        }
        if (locutions != null) {
            locutorMap = new HashMap<>();
            for (var x : locutions) {
                if (!locutorMap.containsKey(x.personID)) {
                    locutorMap.put(x.personID, new HashSet<>());
                }
                locutorMap.get(x.personID).add(x.nodeID);
            }
//            locutions.clear();
        }
        initialised = true;
        return this;
    }
}
