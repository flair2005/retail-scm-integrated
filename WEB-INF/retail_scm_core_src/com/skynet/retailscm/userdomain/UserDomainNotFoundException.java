
package com.skynet.retailscm.userdomain;
import com.skynet.retailscm.EntityNotFoundException;
public class UserDomainNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public UserDomainNotFoundException(String string) {
		super(string);
	}

}

