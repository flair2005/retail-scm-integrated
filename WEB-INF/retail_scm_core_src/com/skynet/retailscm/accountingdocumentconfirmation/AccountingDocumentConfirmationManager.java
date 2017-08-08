
package com.skynet.retailscm.accountingdocumentconfirmation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountingDocumentConfirmationManager{

	public AccountingDocumentConfirmation createAccountingDocumentConfirmation(RetailScmUserContext userContext, String who, String comments, Date makeDate
) throws Exception;	
	public AccountingDocumentConfirmation updateAccountingDocumentConfirmation(RetailScmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String accountingDocumentConfirmationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  AccountingDocumentConfirmation addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId ,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentConfirmation removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentConfirmation updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


