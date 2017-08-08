
package com.skynet.retailscm.catalog;
import com.skynet.retailscm.EntityNotFoundException;
public class CatalogNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public CatalogNotFoundException(String string) {
		super(string);
	}

}

