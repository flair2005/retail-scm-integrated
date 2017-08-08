
package com.skynet.retailscm.employee;
import com.skynet.retailscm.EntityNotFoundException;

public class EmployeeVersionChangedException extends EmployeeManagerException {
	private static final long serialVersionUID = 1L;
	public EmployeeVersionChangedException(String string) {
		super(string);
	}

}


