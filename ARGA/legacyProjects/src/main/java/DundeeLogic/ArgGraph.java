package DundeeLogic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.checkerframework.checker.units.qual.A;
import scala.io.BytePickle;

import java.util.*;
import java.util.function.Predicate;

public class ArgGraph {
    public ArrayList<ArgNode> nodes;
    public ArrayList<ArgEdge> edges;
    public ArrayList<Locutions> locutions;

    @JsonIgnore
    public String json;
    @JsonIgnore
    public HashMap<String, ArgNode> nodeMap = null;
    @JsonIgnore
    public HashMap<String, Map<String, List<ArgEdge>>> outgoings = null;
    @JsonIgnore
    public HashMap<String, Map<String, List<ArgEdge>>> ingoings = null;
    @JsonIgnore
    public HashMap<String, HashSet<String>> locutorMap = null;


    public ArgGraph makeSouthamptonCompliant() {
//        public AIFTheory read(AIFJSONTheory aifJSON) {
        ArgGraph aif = new ArgGraph();
        aif.nodes = new ArrayList<>();
        aif.edges = new ArrayList<>();
        aif.locutions = new ArrayList<>(locutions);
        var AIFNodeType = Sets.newHashSet("RA","CA","I","MA");
        Set<String> ignoredNodeTypes = Sets.newHashSet("L", "YA", "TA");
        HashMap<String, ArgNode> map = new HashMap<>();

            Set<String> illocutionaryNodeIDs = Sets.newHashSet();
            // Iterate and add all nodes
            for (var aifjsonNode : nodes) {
                if (!AIFNodeType.contains(aifjsonNode.type)) {
                    if (ignoredNodeTypes.contains(aifjsonNode.type)) {
                        // Ignore illocutionary nodes
                        illocutionaryNodeIDs.add(aifjsonNode.nodeID);
                        continue;
                    }
                    System.err.println("The given AIF has an unsupported node type: "
                            + aifjsonNode.type + " nodeID: " + aifjsonNode.nodeID + " text: " + aifjsonNode.text + "\n in " );
                    continue;
                }
                if (map.containsKey(aifjsonNode.nodeID)) {
                    System.err.println("The node ID: " + aifjsonNode.nodeID + " is a duplicate." + "\n in ");
                    continue;
                }
                aif.nodes.add(aifjsonNode);
                map.put(aifjsonNode.nodeID, aifjsonNode);
            }

            // Add edges of the nodes
            for (var edge : edges) {
                String fromID = edge.fromID;
                String toID = edge.toID;

                if (illocutionaryNodeIDs.contains(fromID) || illocutionaryNodeIDs.contains(toID)) {
                    continue;
                }

                var fromNode = map.get(fromID);
                if (fromNode == null) {
                    System.err.println("Warning: The given edge with id: " + edge.edgeID + " fromID: " + fromID + " node does not exist." + "\n in " );
                    continue;
                }

                var toNode = map.get(toID);
                if (toNode == null) {
                    System.err.println("Warning: The given edge with id: " + edge.edgeID + " toID: " + toID + " node does not exist." + "\n in " );
                    continue;
                }

                boolean valid = isValid(fromNode, toNode);
                valid = valid || isValid(toNode, fromNode);

                if (valid) {
                    aif.edges.add(edge);
                } else {
                    System.err.println("Warning: The edge id: " + edge.edgeID + " is not supported by tweetyPrEAF since, toID: " + toID + " fromID: " +
                            fromID + " fromType: " + fromNode.type.toString() + " toType: " + toNode.type.toString() + "\n in " );
                }
            }



            var g = aif.init(null);
        boolean nodeRemoved = false;
        boolean edgesRemoved = false;
            Set<String> toRemove = new HashSet<>();
            do {
                toRemove.clear();
                for (var node : g.nodes) {
                    if ((Objects.equals(node.type,"RA")) && (!g.ingoings.getOrDefault(node.nodeID, Collections.emptyMap()).isEmpty())) {
                        continue;
                    } else if (Objects.equals(node.type,"MA") &&
                            (g.ingoings.getOrDefault(node.nodeID, Collections.emptyMap()).size() == 1) &&
                            (g.outgoings.getOrDefault(node.nodeID, Collections.emptyMap()).size() == 1) &&
                            (Objects.equals(g.nodeMap.get(g.ingoings.get(node.nodeID).keySet().iterator().next()).type, "I"))&&
                            (Objects.equals(g.nodeMap.get(g.outgoings.get(node.nodeID).keySet().iterator().next()).type, "I"))) {
                        continue;
                    } else if ((Objects.equals(node.type,"CA")||(Objects.equals(node.type,"I"))) ) {
                        continue;
                    } else {
                        toRemove.add(node.nodeID);
                    }
                }
                nodeRemoved = g.nodes.removeIf(x -> toRemove.contains(x.nodeID));
                edgesRemoved = g.edges.removeIf(x-> toRemove.contains(x.fromID)||toRemove.contains(x.toID));
                if (nodeRemoved||edgesRemoved) {
                    g = g.init(null);
                }
            } while (nodeRemoved || edgesRemoved);

//        }
return g;
    }

    private static boolean isValid(ArgNode node1, ArgNode node2) {
        return Objects.equals(node1.type, "I") && (Objects.equals(node2.type, "CA") || Objects.equals(node2.type, "RA")|| Objects.equals(node2.type, "MA"));
    }

    @JsonIgnore
    public boolean initialised = false;

    public ArgGraph init(Predicate<ArgNode> testNode) {
        nodeMap = new HashMap<>();
        ingoings = new HashMap<>();
        outgoings = new HashMap<>();
        if (nodes != null) {
            for (var x : nodes) {
                if ((testNode == null) || (testNode.test(x)))
                    nodeMap.put(x.nodeID, x);
            }
//            nodes.clear();
        }
        if (edges != null) {
            for (var x : edges) {
                if (!nodeMap.containsKey(x.fromID)) continue;
                if (!nodeMap.containsKey(x.toID)) continue;
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
