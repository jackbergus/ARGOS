package uk.jackbergus.ARGA.logic.semantics;

import java.io.*;
import java.util.*;

/**
 * Providing a specific interpretation of a world
 */
public class PlausibleWorld {


	/**
	 * confidence score associated to the plausible world
	 */
	public double probability = 1.0;

	/**
	 * Set of possible truth assignments
	 */
	public List<PropScores> truthAssignment = new ArrayList<>();

}