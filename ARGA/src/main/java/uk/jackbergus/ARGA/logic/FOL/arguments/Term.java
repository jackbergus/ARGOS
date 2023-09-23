package uk.jackbergus.ARGA.logic.FOL.arguments;

import uk.jackbergus.withReflection.model.SQLType;
import uk.jackbergus.ARGA.logic.FOL.Formula;
import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

/**
 * Any possible type of argument
 */
public class Term extends TableWithIdPrimaryIndex {
	/**
	 * Representation name associated to this
	 */
	@SQLType(type = "varchar")
	public String name;
}