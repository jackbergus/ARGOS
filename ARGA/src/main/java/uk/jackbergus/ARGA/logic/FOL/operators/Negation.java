package uk.jackbergus.ARGA.logic.FOL.operators;

import uk.jackbergus.withReflection.model.Table;
import uk.jackbergus.ARGA.logic.FOL.Formula;
import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

/**
 * Logical negation
 */
@Table(sqlTable = "neg")
public class Negation  extends TableWithIdPrimaryIndex implements Formula {

	/**
	 * Operator's sole operand
	 */
	public Formula argument;

}