package uk.jackbergus.ARGA.structure.annotations;

import uk.jackbergus.withReflection.model.SQLType;
import uk.jackbergus.withReflection.model.UniqueIndex;
import uk.jackbergus.ARGA.structure.ArgaBlock;

/**
 * 
 */
//@uk.jackbergus.ARGA.semantics.Entity
public class Annotation extends ArgaBlock {

	@UniqueIndex
	public Long id;

	/**
	 * A textual description remarking the type of annotation
	 */
	@SQLType(type = "varchar")
	public String annotationName;

	/**
	 * The confidence score associated to the locutor generating a specific confidence score
	 */
	@SQLType(type = "float")
	public double confidenceScore;

}