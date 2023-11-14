package uk.jackbergus.ARGA.logic.semantics;

import uk.jackbergus.ARGA.logic.FOL.arguments.Constant;
import uk.jackbergus.ARGA.semantics.Entity;

/**
 * A semantic interpretation of a term relates it to a specific entity describing the semantics of the text
 */
public class TermAssignment {

	/**
	 * Resolved interpretation
	 */
	public Entity interpretation;
	/**
	 * Term that we are interpreting
	 */
	public Constant term;

}