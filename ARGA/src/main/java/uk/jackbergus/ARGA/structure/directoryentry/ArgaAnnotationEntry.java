package uk.jackbergus.ARGA.structure.directoryentry;

import uk.jackbergus.ARGA.structure.annotations.Annotation;

import java.util.ArrayList;
import java.util.List;

//@uk.jackbergus.ARGA.semantics.Entity
public class ArgaAnnotationEntry extends ArgaDirectoryEntry {

//    @OneToMany(mappedBy = "annotations", cascade = CascadeType.ALL)
    public List<Annotation> references = new ArrayList<>();

}