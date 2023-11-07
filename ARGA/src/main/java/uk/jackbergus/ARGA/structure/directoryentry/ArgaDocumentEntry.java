package uk.jackbergus.ARGA.structure.directoryentry;

/**
 * 
 */
//@uk.jackbergus.ARGA.semantics.Entity(name = "arga_document_entry")
public class ArgaDocumentEntry extends ArgaDirectoryEntry {

	/**
	 * Whether this is an original document
	 */
//	@Column(name="original")
	public boolean isOriginalDocument;

	/**
	 * Whether the document comes with annotation (to be found in another directory entry)
	 */
//	@Column(name = "annotated")
	public boolean isAnnotated;

	public String text; // ADDED!

}