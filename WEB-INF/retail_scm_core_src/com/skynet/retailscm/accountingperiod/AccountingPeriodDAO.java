
package com.skynet.retailscm.accountingperiod;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountingPeriodDAO{

	
	public AccountingPeriod load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountingPeriod present(AccountingPeriod accountingPeriod,Map<String,Object> options) throws Exception;
	public AccountingPeriod clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingPeriod save(AccountingPeriod accountingPeriod,Map<String,Object> options);
	public SmartList<AccountingPeriod> saveAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList,Map<String,Object> options);
	public SmartList<AccountingPeriod> removeAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList,Map<String,Object> options);
	
	public void delete(String accountingPeriodId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<AccountingPeriod> findAccountingPeriodByAccountSet(String accountSetId, Map<String,Object> options);
 	public int countAccountingPeriodByAccountSet(String accountSetId, Map<String,Object> options);
 	public SmartList<AccountingPeriod> findAccountingPeriodByAccountSet(String accountSetId, int start, int count, Map<String,Object> options);
 
 }


