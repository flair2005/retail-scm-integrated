
package com.skynet.retailscm.warehouse;
import com.skynet.retailscm.EntityNotFoundException;

public class WarehouseVersionChangedException extends WarehouseManagerException {
	private static final long serialVersionUID = 1L;
	public WarehouseVersionChangedException(String string) {
		super(string);
	}

}


