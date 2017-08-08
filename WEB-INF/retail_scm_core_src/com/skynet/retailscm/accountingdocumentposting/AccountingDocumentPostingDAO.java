
package com.skynet.retailscm.accountingdocumentposting;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountingDocumentPostingDAO{

	
	public AccountingDocumentPosting load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountingDocumentPosting present(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options) throws Exception;
	public AccountingDocumentPosting clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentPosting save(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options);
	public SmartList<AccountingDocumentPosting> saveAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options);
	public SmartList<AccountingDocumentPosting> removeAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options);
	
	public void delete(String accountingDocumentPostingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


