
package com.skynet.retailscm.accountingdocumentauditing;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountingDocumentAuditingManager{

	public AccountingDocumentAuditing createAccountingDocumentAuditing(RetailScmUserContext userContext, String who, String comments, Date makeDate
) throws Exception;	
	public AccountingDocumentAuditing updateAccountingDocumentAuditing(RetailScmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String accountingDocumentAuditingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  AccountingDocumentAuditing addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId ,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentAuditing removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentAuditing updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


