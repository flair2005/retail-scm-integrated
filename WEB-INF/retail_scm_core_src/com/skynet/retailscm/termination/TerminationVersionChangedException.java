
package com.skynet.retailscm.termination;
import com.skynet.retailscm.EntityNotFoundException;

public class TerminationVersionChangedException extends TerminationManagerException {
	private static final long serialVersionUID = 1L;
	public TerminationVersionChangedException(String string) {
		super(string);
	}

}


