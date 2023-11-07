package uk.jackbergus.ARGA.structure.pot;

import java.util.ArrayList;
import java.util.List;

/**
 * Grouping together relevant part of text
 */
public class BlockToken extends PartOfText {


	public List<PartOfText> content = new ArrayList<>();

	/**
	 * Determining the start and end index from the collected objects
	 * @param text		Text summarising the content "faithfully"
	 * @param content	Actual content
	 */
	public BlockToken(String text, List<PartOfText> content) {
		this.content = content;
//		this.id = id;
		this.text = text;
		start = Integer.MAX_VALUE;
		end = Integer.MIN_VALUE;
		if (content != null)
			for (var x : content) {
				start = Integer.min(start, x.start);
				end = Integer.max(end, x.end);
			}
	}

	/**
	 * Test whether this is a valid BlockTocken actually containing all the PartOfText tokens inside of it.
	 * @return whether the object is valid
	 */
	public boolean testValidity() {
		if (content != null)
		for (var x : content) {
			if ((x.start < start) || (x.end > end))
				return false;
		}
		return true;
	}
}