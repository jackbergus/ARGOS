package uk.jackbergus.ARGA.structure.annotations;

import uk.jackbergus.ARGA.structure.locutors.Locutor;

/**
 * Annotating the logical structure of the text (logical analysis)
 */
public class Sentence extends Annotation {

	/**
	 * Whether this is a main sentence or not
	 */
	public boolean main;

	/**
	 * Representing if (main=false) the kind of dependency with the main sentence
	 */
	public String dep;

	/**
	 * If this is not a main sentence, this points to the main sentence to which this subordinate is depending from.
	 */
	public Sentence ancestorMainSentence;

	/**
	 * The inferred speaker from the text
	 */
	public Locutor speaker;

	/**
	 * Specific confidence score just referring to the attribution of the speaker
	 */
	public double speakerAnnotationConfidence = 1.0;

}