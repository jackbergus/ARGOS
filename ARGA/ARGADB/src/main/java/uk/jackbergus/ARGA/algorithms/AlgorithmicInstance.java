package uk.jackbergus.ARGA.algorithms;

//import uk.jackbergus.withReflection.model.SQLType;
//import uk.jackbergus.withReflection.model.Table;
import uk.jackbergus.ARGA.structure.locutors.Algorithm;
import uk.jackbergus.ARGA.structure.locutors.Locutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes an algorithmic instance as a running service with address as url:port/service to be invoked with a specific
 * restMethod.
 */
//@uk.jackbergus.ARGA.semantics.Entity(name="locutor")
//@Table(sqlTable="algo_instance")
public class AlgorithmicInstance extends Locutor {

	/**
	 * Service name, if required (rest of the URL
	 */
//	@Column
//	@SQLType(type = "String")
	public String service;

	/**
	 * Port where the service is running
	 */
//	@Column
//	@SQLType(type = "int")
	public int port;

	/**
	 * uk.jackbergus.ARGA.Main address
	 */
//	@Column
//	@SQLType(type = "String")
	public String url;

	/**
	 * REST method to be used for the remote HTTP invocation
	 */
//	@Column
//	@SQLType(type = "String")
	public String restMethod;

	/**
	 * Whether the service request supports the multipart payload
	 */
//	@Column
	public boolean isMultiPartContent = false;

//	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
//	@CollectionTable(name = "arguments", joinColumns = @JoinColumn(name = "argument_key"))
//	@Column(name = "payloadRequestArguments", nullable = true)
	public List<String> payloadRequestArguments = new ArrayList<>();

//	@OneToOne(mappedBy = "instanceOf", fetch = FetchType.LAZY)
//	@JoinColumn(nullable = false)
	public Algorithm publisher;

	/**
	 * Required arguments to be passed to the program for running the service
	 */
	public List<AlgorithmicParameter> parameters = new ArrayList<>();

}