
package com.skynet.retailscm.shippingspace;
import com.skynet.retailscm.EntityNotFoundException;

public class ShippingSpaceVersionChangedException extends ShippingSpaceManagerException {
	private static final long serialVersionUID = 1L;
	public ShippingSpaceVersionChangedException(String string) {
		super(string);
	}

}


