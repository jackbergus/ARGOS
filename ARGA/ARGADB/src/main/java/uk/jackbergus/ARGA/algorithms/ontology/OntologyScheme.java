package uk.jackbergus.ARGA.algorithms.ontology;

//import uk.jackbergus.withReflection.model.ManyToMany;
//import uk.jackbergus.withReflection.model.SQLType;
//import uk.jackbergus.withReflection.model.UniqueIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * A scheme for an ontology describes all the possible types that are permitted
 */
public class OntologyScheme {
//    @UniqueIndex
//    @SQLType(type = "bigint")
    public Long id;

    /**
     * Set of all the possible types associable to lexems
     */
//    @ManyToMany(targetClass = SynSet.class)
    public List<SynSet> possibleSenses = new ArrayList<>();

    /**
     * Set of all the possible types associable to relationships
     */
//    @ManyToMany(targetClass = NAryRelationship.class)
    public List<NAryRelationship> possibleRelationships = new ArrayList<>();
}
