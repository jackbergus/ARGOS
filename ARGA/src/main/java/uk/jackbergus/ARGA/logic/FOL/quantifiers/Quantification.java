package uk.jackbergus.ARGA.logic.FOL.quantifiers;

import uk.jackbergus.withReflection.model.ForeignKey;
import uk.jackbergus.ARGA.logic.FOL.Formula;
import uk.jackbergus.ARGA.logic.FOL.arguments.Variable;
import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

/**
 * Provides the general structure for a Universal/Existantial quantification
 */
public class Quantification implements Formula {

	/**
	 * Variable over which performing a quantification
	 */
	@ForeignKey(table = Variable.class)
	public Variable overVariable;

	/**
	 * Part of the formula after the quantification
	 */
	@ForeignKey(table = Formula.class)
	public Formula body;

}