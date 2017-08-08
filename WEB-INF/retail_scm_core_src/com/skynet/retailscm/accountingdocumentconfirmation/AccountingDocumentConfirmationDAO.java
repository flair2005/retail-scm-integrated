
package com.skynet.retailscm.accountingdocumentconfirmation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountingDocumentConfirmationDAO{

	
	public AccountingDocumentConfirmation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountingDocumentConfirmation present(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options) throws Exception;
	public AccountingDocumentConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentConfirmation save(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options);
	public SmartList<AccountingDocumentConfirmation> saveAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options);
	public SmartList<AccountingDocumentConfirmation> removeAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options);
	
	public void delete(String accountingDocumentConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


