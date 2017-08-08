
package com.skynet.retailscm.consumerorder;
import com.skynet.retailscm.EntityNotFoundException;

public class ConsumerOrderVersionChangedException extends ConsumerOrderManagerException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderVersionChangedException(String string) {
		super(string);
	}

}


