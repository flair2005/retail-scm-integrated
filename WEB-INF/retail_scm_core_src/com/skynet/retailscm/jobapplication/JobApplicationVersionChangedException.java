
package com.skynet.retailscm.jobapplication;
import com.skynet.retailscm.EntityNotFoundException;

public class JobApplicationVersionChangedException extends JobApplicationManagerException {
	private static final long serialVersionUID = 1L;
	public JobApplicationVersionChangedException(String string) {
		super(string);
	}

}


