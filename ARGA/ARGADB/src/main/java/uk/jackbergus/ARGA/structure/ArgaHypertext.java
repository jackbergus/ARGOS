package uk.jackbergus.ARGA.structure;
//import uk.jackbergus.withReflection.model.UniqueIndex;

//import javax.persistence.*;

import java.util.*;

/**
 * An ARGA Hypertext is defined as a collection of documents, which might (or might be not) interlinked between each
 * other. In order to disambiguate this, we are considering the ARGA report specification as per project requirement
 * as an instance of an ARGA Hypertext (document).
 */
public class ArgaHypertext {
	/**
	 * identifying a specific instance of the ARGA Hypertext, providing the root of
	 */
//	@UniqueIndex
	public String mnemonicName;

	/**
	 * The Arga Hypertext is then defined as a collection of documents.
	 */
	public List<ArgaDocument> references;

	public ArgaHypertext(String mnemonic) {
		mnemonicName = mnemonic;
		references = new ArrayList<>();
	}

	public void addDocument(ArgaDocument doc) {
		references.add(doc);
	}
}