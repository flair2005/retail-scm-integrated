
package com.skynet.retailscm.accountingperiod;
import com.skynet.retailscm.EntityNotFoundException;

public class AccountingPeriodVersionChangedException extends AccountingPeriodManagerException {
	private static final long serialVersionUID = 1L;
	public AccountingPeriodVersionChangedException(String string) {
		super(string);
	}

}


