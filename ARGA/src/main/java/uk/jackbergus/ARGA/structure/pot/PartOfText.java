package uk.jackbergus.ARGA.structure.pot;

import uk.jackbergus.ARGA.structure.ArgaBlock;

/**
 * 
 */

//@uk.jackbergus.ARGA.semantics.Entity(name="part_of_text")
public class PartOfText extends ArgaBlock {
//	@Id
//	@GeneratedValue
	public Long id;

	/**
	 * Starting offset within the original full-text document
	 */
//	@Column
	public int start;

	/**
	 * Ending offset within the original full-text document
	 */
//	@Column
	public int end;

	/**
	 * Actual textual content
	 */
//	@Column
	public String text;

}