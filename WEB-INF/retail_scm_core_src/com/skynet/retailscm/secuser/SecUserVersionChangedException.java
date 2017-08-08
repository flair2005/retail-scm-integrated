
package com.skynet.retailscm.secuser;
import com.skynet.retailscm.EntityNotFoundException;

public class SecUserVersionChangedException extends SecUserManagerException {
	private static final long serialVersionUID = 1L;
	public SecUserVersionChangedException(String string) {
		super(string);
	}

}


