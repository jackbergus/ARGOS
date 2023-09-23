package uk.jackbergus.ARGA.logic.FOL.operators;

import uk.jackbergus.withReflection.model.Table;
import uk.jackbergus.ARGA.logic.FOL.Formula;
import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

/**
 * Represents the conjunction of two formulae
 */
@Table(sqlTable = "and")
public class Conjunction extends TableWithIdPrimaryIndex implements Formula {

	/**
	 * Operator's operands
	 */
	public Formula lhs;
	public Formula rhs;

}