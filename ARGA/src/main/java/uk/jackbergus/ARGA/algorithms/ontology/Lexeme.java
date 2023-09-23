package uk.jackbergus.ARGA.algorithms.ontology;

import uk.jackbergus.withReflection.model.ManyToMany;
import uk.jackbergus.withReflection.model.SQLType;
import uk.jackbergus.withReflection.model.Table;
import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * An atomic entity within a specific ontology
 */
@Table(sqlTable="lexeme")
public class Lexeme extends TableWithIdPrimaryIndex {

	/**
	 * Text associated to the entity, providing a human-readable description
	 */
	@SQLType(type = "varchar")
	public String text;

	/**
	 * Disambiguation id, referring to the specific Polysemy instance of a word in the text.
	 */
	@SQLType(type = "bigint")
	public Long disambiguation_id;

	/**
	 * Language associated to the specific term
	 */
	@SQLType(type = "varchar")
	public String language;

	/**
	 * Part-Of-Speech information associated to the text
	 */
	@SQLType(type = "varchar")
	public String pos;

	/**
	 *
	 */
	@ManyToMany(targetClass = SynSet.class)
	public List<SynSet> synonyms = new ArrayList<>();

}