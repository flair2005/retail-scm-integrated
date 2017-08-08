
package com.skynet.retailscm.accountingdocumentauditing;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountingDocumentAuditingDAO{

	
	public AccountingDocumentAuditing load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountingDocumentAuditing present(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options) throws Exception;
	public AccountingDocumentAuditing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentAuditing save(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options);
	public SmartList<AccountingDocumentAuditing> saveAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options);
	public SmartList<AccountingDocumentAuditing> removeAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options);
	
	public void delete(String accountingDocumentAuditingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


