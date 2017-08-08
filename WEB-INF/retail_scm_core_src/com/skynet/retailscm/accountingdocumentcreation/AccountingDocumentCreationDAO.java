
package com.skynet.retailscm.accountingdocumentcreation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountingDocumentCreationDAO{

	
	public AccountingDocumentCreation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountingDocumentCreation present(AccountingDocumentCreation accountingDocumentCreation,Map<String,Object> options) throws Exception;
	public AccountingDocumentCreation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentCreation save(AccountingDocumentCreation accountingDocumentCreation,Map<String,Object> options);
	public SmartList<AccountingDocumentCreation> saveAccountingDocumentCreationList(SmartList<AccountingDocumentCreation> accountingDocumentCreationList,Map<String,Object> options);
	public SmartList<AccountingDocumentCreation> removeAccountingDocumentCreationList(SmartList<AccountingDocumentCreation> accountingDocumentCreationList,Map<String,Object> options);
	
	public void delete(String accountingDocumentCreationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


