package org.tweetyproject.math.opt.problem;

import org.tweetyproject.math.term.OptProbElement;

import java.util.Collection;
import java.util.HashSet;

public abstract class GeneralConstraintSatisfactionProblem extends  HashSet<OptProbElement>{
	
	public GeneralConstraintSatisfactionProblem()
	{
		super();
	}
	
	public GeneralConstraintSatisfactionProblem(Collection<? extends OptProbElement> opts)
	{
		super(opts);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
