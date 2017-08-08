
package com.skynet.retailscm.accountingdocumenttype;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountingDocumentTypeDAO{

	
	public AccountingDocumentType load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountingDocumentType present(AccountingDocumentType accountingDocumentType,Map<String,Object> options) throws Exception;
	public AccountingDocumentType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentType save(AccountingDocumentType accountingDocumentType,Map<String,Object> options);
	public SmartList<AccountingDocumentType> saveAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList,Map<String,Object> options);
	public SmartList<AccountingDocumentType> removeAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList,Map<String,Object> options);
	
	public void delete(String accountingDocumentTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<AccountingDocumentType> findAccountingDocumentTypeByAccountingPeriod(String accountSetId, Map<String,Object> options);
 	public int countAccountingDocumentTypeByAccountingPeriod(String accountSetId, Map<String,Object> options);
 	public SmartList<AccountingDocumentType> findAccountingDocumentTypeByAccountingPeriod(String accountSetId, int start, int count, Map<String,Object> options);
 
 }


