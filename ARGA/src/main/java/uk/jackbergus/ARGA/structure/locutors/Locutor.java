package uk.jackbergus.ARGA.structure.locutors;

import uk.jackbergus.withReflection.model.SQLType;
import uk.jackbergus.withReflection.model.Table;
import uk.jackbergus.ARGA.utils.TableWithIdPrimaryIndex;

/**
 * 
 */
//@uk.jackbergus.ARGA.semantics.Entity
//@Table(name="locutor")
	@Table(sqlTable = "locutor")
public class Locutor extends TableWithIdPrimaryIndex {
	/**
	 * Uniquely accepted name
	 */
//	@Column(name="name")
	@SQLType(type = "varchar")
	public String name;

	/**
	 * Role of the locutor
	 */
//	@Column(name="role")

	@SQLType(type = "varchar")
	public String role;

	/**
	 * Affiliation of the locutor
	 */
//	@Column(name="affiliation")
	@SQLType(type = "varchar")
	public String affiliation;


}