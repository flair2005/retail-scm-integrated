
package com.skynet.retailscm.employeeleave;
import com.skynet.retailscm.EntityNotFoundException;

public class EmployeeLeaveVersionChangedException extends EmployeeLeaveManagerException {
	private static final long serialVersionUID = 1L;
	public EmployeeLeaveVersionChangedException(String string) {
		super(string);
	}

}


