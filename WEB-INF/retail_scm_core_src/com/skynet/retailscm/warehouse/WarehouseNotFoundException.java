
package com.skynet.retailscm.warehouse;
import com.skynet.retailscm.EntityNotFoundException;
public class WarehouseNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public WarehouseNotFoundException(String string) {
		super(string);
	}

}

