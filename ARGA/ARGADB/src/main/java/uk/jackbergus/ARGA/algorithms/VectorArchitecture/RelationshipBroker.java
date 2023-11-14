package uk.jackbergus.ARGA.algorithms.VectorArchitecture;

//import uk.jackbergus.withReflection.model.ForeignKey;
import uk.jackbergus.ARGA.algorithms.ontology.NAryRelationshipInstance;
import uk.jackbergus.ARGA.structure.annotations.VectorSpace;

/**
 * Establishing a correlation between an edge and a relationship embedding
 */
public class RelationshipBroker extends VectorSpace {
//	@ForeignKey(table = NAryRelationshipInstance.class)
	public NAryRelationshipInstance from;
//	@ForeignKey(table = RelationshipEmbedding.class)
	public RelationshipEmbedding to;
}