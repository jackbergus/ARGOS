package uk.jackbergus.ARGA.algorithms.VectorArchitecture;

import uk.jackbergus.ARGA.algorithms.AlgorithmicInstance;
import uk.jackbergus.ARGA.algorithms.ontology.Lexeme;
import uk.jackbergus.ARGA.algorithms.ontology.NAryRelationshipInstance;
import uk.jackbergus.ARGA.algorithms.ontology.Ontology;

public abstract class Embedder extends AlgorithmicInstance {
    /**
     * Graph representation being the source for the embedding generation
     */
    public Ontology graph;

    /**
     * Function that, given an entity, it returns the associated embedding.
     * @param arg   Entity to embed
     * @return      Resulting embedding
     */
    public abstract VectorEmbedding generateEmbedding(Lexeme arg);

    /**
     * Function that, given a n-ary instance of a relationship,  returns the associated embedding.
     * @param arg   N-ary instance of a relationship among entities to embed
     * @return      Resulting embedding
     */
    public abstract RelationshipEmbedding generateEmbedding(NAryRelationshipInstance arg);
}
