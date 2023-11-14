package uk.jackbergus.ARGA.structure.annotations;

//import haxe.root.Sys;
import uk.jackbergus.ARGA.semantics.Relationship;
import uk.jackbergus.ARGA.structure.ArgaDocumentCoordinates;
//import uk.jackbergus.DundeeLogic.ArgEdge;
//import uk.jackbergus.DundeeLogic.ArgGraph;
//import uk.jackbergus.DundeeLogic.ArgNode;
//import uk.jackbergus.DundeeLogic.DundeeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * An hypertextual link is a link across ARGA documents (or within the same document), which interpretation is an N-Ary
 * relationship belonging to a specific ontology
 */
public class HypertextualLink extends Annotation {

    public List<ArgaDocumentCoordinates> linkArguments = new ArrayList<>();
    public Relationship interpretation;


}