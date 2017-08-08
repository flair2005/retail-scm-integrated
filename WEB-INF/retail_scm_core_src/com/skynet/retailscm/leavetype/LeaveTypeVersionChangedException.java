
package com.skynet.retailscm.leavetype;
import com.skynet.retailscm.EntityNotFoundException;

public class LeaveTypeVersionChangedException extends LeaveTypeManagerException {
	private static final long serialVersionUID = 1L;
	public LeaveTypeVersionChangedException(String string) {
		super(string);
	}

}


