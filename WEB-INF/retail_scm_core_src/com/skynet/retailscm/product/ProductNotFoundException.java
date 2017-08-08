
package com.skynet.retailscm.product;
import com.skynet.retailscm.EntityNotFoundException;
public class ProductNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(String string) {
		super(string);
	}

}

