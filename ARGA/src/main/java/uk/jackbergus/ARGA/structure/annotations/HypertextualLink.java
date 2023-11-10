package uk.jackbergus.ARGA.structure.annotations;

import haxe.root.Sys;
import uk.jackbergus.ARGA.semantics.Relationship;
import uk.jackbergus.ARGA.structure.ArgaDocumentCoordinates;
import uk.jackbergus.DundeeLogic.ArgEdge;
import uk.jackbergus.DundeeLogic.ArgGraph;
import uk.jackbergus.DundeeLogic.ArgNode;
import uk.jackbergus.DundeeLogic.DundeeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * An hypertextual link is a link across ARGA documents (or within the same document), which interpretation is an N-Ary
 * relationship belonging to a specific ontology
 */
public class HypertextualLink extends Annotation {

    public List<ArgaDocumentCoordinates> linkArguments = new ArrayList<>();
    public Relationship interpretation;

    public ArgEdge asArgumentationEdge() {
        var res = new ArgEdge();
        res.fromID = Integer.toString(System.identityHashCode(linkArguments.get(0).atomicReference));
        res.toID = Integer.toString(System.identityHashCode(linkArguments.get(1).atomicReference));
        res.edgeID = Integer.toString(System.identityHashCode(this));
        return res;
    }

    public void fillInArgumentationGraph(ArgGraph g) {
        ArgNode dundeeArgumentationNode = new ArgNode();
        dundeeArgumentationNode.nodeID =  Integer.toString(System.identityHashCode(dundeeArgumentationNode));
        dundeeArgumentationNode.type = annotationName;
        dundeeArgumentationNode.text = DundeeUtils.getTextFromEdgeType(annotationName);
        dundeeArgumentationNode.scheme = DundeeUtils.getSchemeFromEdgeType(annotationName);
        dundeeArgumentationNode.schemeID = DundeeUtils.getSchemeIDFromEdgeType(annotationName);
        g.nodes.add(dundeeArgumentationNode);
        String src = Integer.toString(System.identityHashCode(linkArguments.get(0).atomicReference));
        String dst = Integer.toString(System.identityHashCode(linkArguments.get(1).atomicReference));
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