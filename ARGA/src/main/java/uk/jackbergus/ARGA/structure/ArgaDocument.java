package uk.jackbergus.ARGA.structure;

import uk.jackbergus.withReflection.model.UniqueIndex;
import uk.jackbergus.ARGA.structure.directoryentry.ArgaDirectoryEntry;
import uk.jackbergus.ARGA.structure.locutors.Locutor;

import java.util.Date;

/**
 * A single document contained in the overall hypertext
 */
public class ArgaDocument {

	/**
	 * Mnemonic name associated to the object
	 */
	@UniqueIndex
	public String mnemonicName;

	/**
	 * When the document was published
	 */
	public Date publication_time;

	/**
	 * When the document was retrieved
	 */
	public Date retrieval_time;

	/**
	 * Who published the document
	 */
	public Locutor publisher;

	/**
	 * The pointer to the actual content.
	 */
	public ArgaDirectoryEntry content;
}