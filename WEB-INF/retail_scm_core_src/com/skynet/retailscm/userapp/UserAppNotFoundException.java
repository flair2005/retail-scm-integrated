
package com.skynet.retailscm.userapp;
import com.skynet.retailscm.EntityNotFoundException;
public class UserAppNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public UserAppNotFoundException(String string) {
		super(string);
	}

}

