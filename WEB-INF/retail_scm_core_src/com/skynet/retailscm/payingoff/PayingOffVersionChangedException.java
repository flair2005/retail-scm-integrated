
package com.skynet.retailscm.payingoff;
import com.skynet.retailscm.EntityNotFoundException;

public class PayingOffVersionChangedException extends PayingOffManagerException {
	private static final long serialVersionUID = 1L;
	public PayingOffVersionChangedException(String string) {
		super(string);
	}

}


