package uk.jackbergus.ARGA.logic.semantics;

import uk.jackbergus.ARGA.algorithms.ontology.Ontology;
import uk.jackbergus.ARGA.logic.FOL.Reasoner;

import java.util.ArrayList;
import java.util.List;

/**
 * Describing a semantic interpretaion of a logic in terms of an ontology/conceptnet describing the relevant information
 */
public class SemanticInterpretation {
    /**
     * Specific ontology providing the interpretations that will follow
     */
    public Ontology overOntology;

    /**
     * Reasoner providing the results listed in this class
     */
    public Reasoner locutor;

    /**
     * Generation of a list of possible truth assignment and confidence scores associated to the possible worlds
     */
    public List<PlausibleWorld> possibleWorlds = new ArrayList<>();

    /**
     * List of interpretation of logical terms in terms of entities described by an ontology
     */
    public List<TermAssignment> terms = new ArrayList<>();

    /**
     * List of interpretations of propositions as relationships among entities
     */
    public List<PredicateInterpretation> propositions = new ArrayList<>();

}
