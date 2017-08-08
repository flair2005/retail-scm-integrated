
package com.skynet.retailscm.userapp;
import com.skynet.retailscm.EntityNotFoundException;

public class UserAppVersionChangedException extends UserAppManagerException {
	private static final long serialVersionUID = 1L;
	public UserAppVersionChangedException(String string) {
		super(string);
	}

}


