package uk.jackbergus.ARGA.logic.FOL.operators;

//import uk.jackbergus.withReflection.model.Table;
import uk.jackbergus.ARGA.logic.FOL.Formula;
//import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

/**
 * Represents the disjunction of formulae
 */

//@Table(sqlTable = "or")
public class Disjunction   implements Formula {

	/**
	 * Operator's operands
	 */
	public Formula lhs, rhs;

}