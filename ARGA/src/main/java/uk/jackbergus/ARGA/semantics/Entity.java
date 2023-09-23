package uk.jackbergus.ARGA.semantics;

import uk.jackbergus.ARGA.algorithms.ontology.Lexeme;

/**
 * A semantics for an entity can be associated to a Lexeme/Entity within an ontology
 */
public class Entity extends Semantics {
	/**
	 * The interpretation associated to the Ontology
	 */
	public Lexeme interpretation;
}