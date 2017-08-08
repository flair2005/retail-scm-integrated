
package com.skynet.retailscm.secuser;
import com.skynet.retailscm.EntityNotFoundException;
public class SecUserNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public SecUserNotFoundException(String string) {
		super(string);
	}

}

