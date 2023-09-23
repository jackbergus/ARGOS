package uk.jackbergus.ARGA.algorithms.ontology;


import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;
import uk.jackbergus.withReflection.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * An instantiation of a specific relationship as a tuple across lexemes
 */
@Table(sqlTable="nAryRelationshipInstance")
public class NAryRelationshipInstance extends TableWithIdPrimaryIndex {


	/**
	 * Type associated to the relationship
	 */
	@ForeignKey(table = NAryRelationship.class)
	public NAryRelationship type;

	/**
	 * List of all the possible instantiations
	 */
	@ManyToMany(targetClass = Lexeme.class)
	public List<Lexeme> arguments = new ArrayList<>();

}