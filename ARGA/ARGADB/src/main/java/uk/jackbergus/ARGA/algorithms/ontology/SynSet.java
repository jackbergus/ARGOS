package uk.jackbergus.ARGA.algorithms.ontology;

//import uk.jackbergus.withReflection.model.ManyToMany;
//import uk.jackbergus.withReflection.model.SQLType;
//import uk.jackbergus.withReflection.model.Table;
//import uk.jackbergus.withReflection.model.UniqueIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * A meta-entity grouping together all the entities that are synonyms. This can be also interpreted as a Type if all the
 * terms are data objects and those are associated to types.
 */
//@Table(sqlTable="sensenet")
public class SynSet {

	/**
	 * Unique indentifier for the SenseSet
	 */
//	@UniqueIndex @SQLType(type = "varchar")
//	public String id;

	/**
	 * Collection of disambiguated Lexemes by Polysemy-id referring to the same concept. This provides the type definition
	 * as a set
	 */
//	@ManyToMany(targetClass = Lexeme.class)
	public List<Lexeme> synonyms = new ArrayList<>();

	/**
	 * List of all the  antinomies
	 */
//	@ManyToMany(targetClass = SynSet.class)
	public List<SynSet>  antinomies = new ArrayList<>();

	/**
	 * List of all the related concepts
	 */
//	@ManyToMany(targetClass = SynSet.class)
	public List<SynSet>  relatedness = new ArrayList<>();

}