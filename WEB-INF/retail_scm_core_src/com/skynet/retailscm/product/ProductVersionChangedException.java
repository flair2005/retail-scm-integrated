
package com.skynet.retailscm.product;
import com.skynet.retailscm.EntityNotFoundException;

public class ProductVersionChangedException extends ProductManagerException {
	private static final long serialVersionUID = 1L;
	public ProductVersionChangedException(String string) {
		super(string);
	}

}


