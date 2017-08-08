
package com.skynet.retailscm.objectaccess;
import com.skynet.retailscm.EntityNotFoundException;
public class ObjectAccessNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessNotFoundException(String string) {
		super(string);
	}

}

