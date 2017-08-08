
package com.skynet.retailscm.truckdriver;
import com.skynet.retailscm.EntityNotFoundException;

public class TruckDriverVersionChangedException extends TruckDriverManagerException {
	private static final long serialVersionUID = 1L;
	public TruckDriverVersionChangedException(String string) {
		super(string);
	}

}


