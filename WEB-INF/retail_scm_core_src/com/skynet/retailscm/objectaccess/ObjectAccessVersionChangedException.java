
package com.skynet.retailscm.objectaccess;
import com.skynet.retailscm.EntityNotFoundException;

public class ObjectAccessVersionChangedException extends ObjectAccessManagerException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessVersionChangedException(String string) {
		super(string);
	}

}


