package uk.jackbergus.ARGA.logic.FOL;

//import uk.jackbergus.withReflection.model.Table;
import uk.jackbergus.ARGA.logic.FOL.arguments.Term;
//import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

import java.util.*;

/**
 * An n-ary predicate
 */
//@Table(sqlTable = "prop")
public class Predicate  implements Formula  {

	/**
	 * Predicate name. This will eventually correspond to a representation of a relationship
	 */
	public String propName;

	/**
	 * List of arguments associated to the predicate. Those are unnamed. A semantics associated to an ontology
	 * will then provide a meaning to the specific arguments
	 */
	public List<Term> argumentList;

}