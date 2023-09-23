package uk.jackbergus.ARGA.structure.annotations;

import uk.jackbergus.ARGA.semantics.Relationship;
import uk.jackbergus.ARGA.structure.ArgaDocumentCoordinates;

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