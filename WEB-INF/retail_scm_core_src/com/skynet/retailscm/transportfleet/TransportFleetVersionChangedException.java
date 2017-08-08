
package com.skynet.retailscm.transportfleet;
import com.skynet.retailscm.EntityNotFoundException;

public class TransportFleetVersionChangedException extends TransportFleetManagerException {
	private static final long serialVersionUID = 1L;
	public TransportFleetVersionChangedException(String string) {
		super(string);
	}

}


