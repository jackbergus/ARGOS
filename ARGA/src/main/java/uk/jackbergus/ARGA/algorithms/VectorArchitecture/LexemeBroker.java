package uk.jackbergus.ARGA.algorithms.VectorArchitecture;

import uk.jackbergus.withReflection.model.ForeignKey;
import uk.jackbergus.ARGA.algorithms.ontology.Lexeme;
import uk.jackbergus.ARGA.structure.annotations.VectorSpace;

/**
 * Establishing a correspondence between a Lexeme and an embedding
 */
public class LexemeBroker extends VectorSpace {
	@ForeignKey(table = Lexeme.class)
	public Lexeme from;
	@ForeignKey(table = EntityEmbedding.class)
	public EntityEmbedding to;
}