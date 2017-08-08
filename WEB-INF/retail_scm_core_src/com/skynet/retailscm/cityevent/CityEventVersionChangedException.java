
package com.skynet.retailscm.cityevent;
import com.skynet.retailscm.EntityNotFoundException;

public class CityEventVersionChangedException extends CityEventManagerException {
	private static final long serialVersionUID = 1L;
	public CityEventVersionChangedException(String string) {
		super(string);
	}

}


