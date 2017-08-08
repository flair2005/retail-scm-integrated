
package com.skynet.retailscm.accountingsubject;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountingSubjectDAO{

	
	public AccountingSubject load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountingSubject present(AccountingSubject accountingSubject,Map<String,Object> options) throws Exception;
	public AccountingSubject clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingSubject save(AccountingSubject accountingSubject,Map<String,Object> options);
	public SmartList<AccountingSubject> saveAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options);
	public SmartList<AccountingSubject> removeAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options);
	
	public void delete(String accountingSubjectId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId, Map<String,Object> options);
 	public int countAccountingSubjectByAccountSet(String accountSetId, Map<String,Object> options);
 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId, int start, int count, Map<String,Object> options);
 
 }


