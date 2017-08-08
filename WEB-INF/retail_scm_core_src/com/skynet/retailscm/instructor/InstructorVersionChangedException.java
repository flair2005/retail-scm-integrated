
package com.skynet.retailscm.instructor;
import com.skynet.retailscm.EntityNotFoundException;

public class InstructorVersionChangedException extends InstructorManagerException {
	private static final long serialVersionUID = 1L;
	public InstructorVersionChangedException(String string) {
		super(string);
	}

}


