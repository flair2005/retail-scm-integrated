
package com.skynet.retailscm.accountingdocument;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountingDocumentDAO{

	
	public AccountingDocument load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountingDocument present(AccountingDocument accountingDocument,Map<String,Object> options) throws Exception;
	public AccountingDocument clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocument save(AccountingDocument accountingDocument,Map<String,Object> options);
	public SmartList<AccountingDocument> saveAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options);
	public SmartList<AccountingDocument> removeAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options);
	
	public void delete(String accountingDocumentId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId, Map<String,Object> options);
 	public int countAccountingDocumentByAccountingPeriod(String accountingPeriodId, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId, Map<String,Object> options);
 	public int countAccountingDocumentByDocumentType(String accountingDocumentTypeId, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByCreation(String accountingDocumentCreationId, Map<String,Object> options);
 	public int countAccountingDocumentByCreation(String accountingDocumentCreationId, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByCreation(String accountingDocumentCreationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByConfirmation(String accountingDocumentConfirmationId, Map<String,Object> options);
 	public int countAccountingDocumentByConfirmation(String accountingDocumentConfirmationId, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByConfirmation(String accountingDocumentConfirmationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByAuditing(String accountingDocumentAuditingId, Map<String,Object> options);
 	public int countAccountingDocumentByAuditing(String accountingDocumentAuditingId, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByAuditing(String accountingDocumentAuditingId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByPosting(String accountingDocumentPostingId, Map<String,Object> options);
 	public int countAccountingDocumentByPosting(String accountingDocumentPostingId, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByPosting(String accountingDocumentPostingId, int start, int count, Map<String,Object> options);
 
 }


