
package com.skynet.retailscm.catalog;
import com.skynet.retailscm.EntityNotFoundException;

public class CatalogVersionChangedException extends CatalogManagerException {
	private static final long serialVersionUID = 1L;
	public CatalogVersionChangedException(String string) {
		super(string);
	}

}


