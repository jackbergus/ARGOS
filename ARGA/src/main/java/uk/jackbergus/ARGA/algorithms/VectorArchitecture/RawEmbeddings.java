package uk.jackbergus.ARGA.algorithms.VectorArchitecture;

import uk.jackbergus.withReflection.model.ConvertList;
import uk.jackbergus.withReflection.model.SQLType;
import uk.jackbergus.withReflection.model.Table;
import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

import java.util.List;

//@uk.jackbergus.ARGA.semantics.Entity
//@Table(name = "raw_embeddings")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(sqlTable="raw_embeddings")
public class RawEmbeddings extends TableWithIdPrimaryIndex {

    public static final Class<List<Double>> ref = ((Class<List<Double>>)(Object)List.class);

//    @Convert(converter = VectorConverter.class)
//    @Column(columnDefinition = "varchar")
    @ConvertList(converter = VectorConverter.class, javaType = Double.class, dbTypeInJava = String.class)
    @SQLType(type = "varchar")
    private List<Double> embedding;

}