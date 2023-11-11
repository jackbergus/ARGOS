package uk.jackbergus.DundeeLogic;

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
    public HashMap<String, HashMap<String, List<ArgEdge>>> edgeMap = null;
    @JsonIgnore
    public HashMap<String, HashSet<String>> locutorMap = null;


    @JsonIgnore
    public boolean initialised = false;

    public void init() {
        nodeMap = new HashMap<>();
        edgeMap = new HashMap<>();
        if (nodes != null) {
            for (var x : nodes) {
                nodeMap.put(x.nodeID, x);
            }
//            nodes.clear();
        }
        if (edges != null) {
            for (var x : edges) {
                if (!edgeMap.containsKey(x.fromID))
                    edgeMap.put(x.fromID, new HashMap<>());
                if (!edgeMap.get(x.fromID).containsKey(x.toID)) {
                    edgeMap.get(x.fromID).put(x.toID, new ArrayList<>());
                }
                edgeMap.get(x.fromID).get(x.toID).add(x);
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
    }
}
