
package com.skynet.retailscm.terminationtype;
import com.skynet.retailscm.EntityNotFoundException;

public class TerminationTypeVersionChangedException extends TerminationTypeManagerException {
	private static final long serialVersionUID = 1L;
	public TerminationTypeVersionChangedException(String string) {
		super(string);
	}

}


