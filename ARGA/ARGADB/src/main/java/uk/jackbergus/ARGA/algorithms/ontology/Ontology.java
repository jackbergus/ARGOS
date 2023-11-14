package uk.jackbergus.ARGA.algorithms.ontology;

//import uk.jackbergus.withReflection.model.*;
import uk.jackbergus.ARGA.algorithms.AlgorithmicInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * For Argumentation, this can be an AIF ontology, For ER extraction from text, this can be Conceptnet/Wordnet of any
 * commonsense network conveying meaning to objects. Mainly this provides an interpretation what Entity and
 * Relationships should be about.
 *
 * If referring to the actual structure of the ARGA pipeline, this could be also the ontology providing the requirements
 * for the algorithms to "live in" the framework.
 */
//@Table(sqlTable="ontology")
public class Ontology extends AlgorithmicInstance {
	/**
	 * Readable name differentiating this ontology from other ones
	 */
//	@UniqueIndex @SQLType(type = "varchar")
	public String name;

//	@ForeignKey(table = OntologyScheme.class)
	public OntologyScheme withSchema;

	/**
	 * List of all the entities described by the given ontology
	 */
//	@ManyToMany(targetClass = Lexeme.class)
	public List<Lexeme> entities = new ArrayList<>();

	/**
	 * Instantiation of the n-ary relationships among entities as tuples
	 */
//	@ManyToMany(targetClass = NAryRelationshipInstance.class)
	public List<NAryRelationshipInstance> relationships = new ArrayList<>();

}