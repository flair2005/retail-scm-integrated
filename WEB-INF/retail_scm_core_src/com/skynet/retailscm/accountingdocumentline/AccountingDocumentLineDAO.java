
package com.skynet.retailscm.accountingdocumentline;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountingDocumentLineDAO{

	
	public AccountingDocumentLine load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountingDocumentLine present(AccountingDocumentLine accountingDocumentLine,Map<String,Object> options) throws Exception;
	public AccountingDocumentLine clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentLine save(AccountingDocumentLine accountingDocumentLine,Map<String,Object> options);
	public SmartList<AccountingDocumentLine> saveAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList,Map<String,Object> options);
	public SmartList<AccountingDocumentLine> removeAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList,Map<String,Object> options);
	
	public void delete(String accountingDocumentLineId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByBelongsTo(String accountingDocumentId, Map<String,Object> options);
 	public int countAccountingDocumentLineByBelongsTo(String accountingDocumentId, Map<String,Object> options);
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByBelongsTo(String accountingDocumentId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByAccountingSubject(String accountingSubjectId, Map<String,Object> options);
 	public int countAccountingDocumentLineByAccountingSubject(String accountingSubjectId, Map<String,Object> options);
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByAccountingSubject(String accountingSubjectId, int start, int count, Map<String,Object> options);
 
 }


