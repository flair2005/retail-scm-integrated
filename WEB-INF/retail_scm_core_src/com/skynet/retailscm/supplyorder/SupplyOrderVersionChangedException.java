
package com.skynet.retailscm.supplyorder;
import com.skynet.retailscm.EntityNotFoundException;

public class SupplyOrderVersionChangedException extends SupplyOrderManagerException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderVersionChangedException(String string) {
		super(string);
	}

}


