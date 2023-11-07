package uk.jackbergus.ARGA.structure.directoryentry;

import uk.jackbergus.withReflection.model.UniqueIndex;
import uk.jackbergus.ARGA.structure.locutors.Locutor;

//import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
//@Entity
//@Table(name = "arga_directory_entry")
public class ArgaDirectoryEntry {
//	@Id
//	@GeneratedValue
//	@UniqueIndex
//	private Long id;

//	@OneToMany(mappedBy = "authorship", cascade = CascadeType.ALL)
	public List<Locutor> authorship = new ArrayList<>();
}