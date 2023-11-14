package uk.jackbergus.ARGA.algorithms.VectorArchitecture;

//import uk.jackbergus.withReflection.model.*;
import uk.jackbergus.ARGA.structure.locutors.Locutor;
//import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

import java.util.ArrayList;
import java.util.List;


//@Table(name = "vector_embedding")
//@uk.jackbergus.ARGA.semantics.Entity
//@Table(sqlTable="vec_embeddings")
public class VectorEmbedding   {
////    @Id
////    @GeneratedValue
//    @UniqueIndex @SQLType(type = "bigint")
//    private Long id;

//    @Column
//    @SQLType(type = "varchar")
    public String name;

    /**
     * Encompassing that an entity might be associated to different embeddings, depending on the specific architecture
     */
//    @OneToMany(mappedBy = "embeddings", cascade = CascadeType.ALL)
//    @ManyToMany(targetClass = RawEmbeddings.class)
    public List<RawEmbeddings> embeddings = new ArrayList<>();

//    @OneToOne(mappedBy = "publisher", fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false)
//    @ForeignKey(table = Locutor.class)
    public Locutor publisher;
}
