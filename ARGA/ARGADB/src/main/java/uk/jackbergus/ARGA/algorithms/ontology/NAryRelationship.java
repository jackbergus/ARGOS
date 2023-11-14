package uk.jackbergus.ARGA.algorithms.ontology;

//import uk.jackbergus.withReflection.model.ManyToMany;
//import uk.jackbergus.withReflection.model.SQLType;
//import uk.jackbergus.withReflection.model.Table;
//import uk.jackbergus.withReflection.model.UniqueIndex;
//import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

import java.util.ArrayList;
import java.util.List;

//@Table(sqlTable="nAryRelationship")
public class NAryRelationship {


    /**
     * Name of the n-ary relationship
     */
//    @SQLType(type = "varchar")
    public String name;

    /**
     * Description of the arguments describing the n-ary relationship
     */
//    @ManyToMany(targetClass = NAryRelationshipArgument.class)
    public List<NAryRelationshipArgument> arguments = new ArrayList<>();

    /**
     * This requires that the argument of a relationship should be associated to a specific type.
     */
    public static class NAryRelationshipArgument {

//        @UniqueIndex @SQLType(type = "bigint")
//        public Long id;

        /**
         * Mnemonic and semantic-providing of the n-th argument
         */
//        @SQLType(type = "varchar")
        public String argumentName;

        /**
         * Type associated to the argument
         */
//        @SQLType(type = "varchar")
        public SynSet type;

        public NAryRelationshipArgument(String argumentName) {
            this.argumentName = argumentName;
            this.type = null;
        }
    }

}
