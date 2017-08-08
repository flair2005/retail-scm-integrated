
package com.skynet.retailscm.employeeattendance;
import com.skynet.retailscm.EntityNotFoundException;

public class EmployeeAttendanceVersionChangedException extends EmployeeAttendanceManagerException {
	private static final long serialVersionUID = 1L;
	public EmployeeAttendanceVersionChangedException(String string) {
		super(string);
	}

}


