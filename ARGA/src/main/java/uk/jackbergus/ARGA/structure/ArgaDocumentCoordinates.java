package uk.jackbergus.ARGA.structure;

import uk.jackbergus.ARGA.structure.directoryentry.ArgaDirectoryEntry;

/**
 * 
 */
//@uk.jackbergus.ARGA.semantics.Entity
//@Table(name = "arga_document_coordinates")
public class ArgaDocumentCoordinates {
//	@Id
//	@GeneratedValue
	private Long id;

//	@OneToOne(mappedBy = "main_source", cascade = CascadeType.ALL)
	public ArgaDocument mainSource;

//	@OneToOne(mappedBy = "entry_reference", cascade = CascadeType.ALL)
	public ArgaDirectoryEntry entryReference;

//	@OneToOne(mappedBy = "entry_reference", cascade = CascadeType.ALL)
	public ArgaBlock atomicReference;
}