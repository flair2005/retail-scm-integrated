
package com.skynet.retailscm.terminationreason;
import com.skynet.retailscm.EntityNotFoundException;

public class TerminationReasonVersionChangedException extends TerminationReasonManagerException {
	private static final long serialVersionUID = 1L;
	public TerminationReasonVersionChangedException(String string) {
		super(string);
	}

}


