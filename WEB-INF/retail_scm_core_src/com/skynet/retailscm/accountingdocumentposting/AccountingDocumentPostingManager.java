
package com.skynet.retailscm.accountingdocumentposting;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountingDocumentPostingManager{

	public AccountingDocumentPosting createAccountingDocumentPosting(RetailScmUserContext userContext, String who, String comments, Date makeDate
) throws Exception;	
	public AccountingDocumentPosting updateAccountingDocumentPosting(RetailScmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String accountingDocumentPostingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  AccountingDocumentPosting addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId ,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentPosting removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentPosting updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


