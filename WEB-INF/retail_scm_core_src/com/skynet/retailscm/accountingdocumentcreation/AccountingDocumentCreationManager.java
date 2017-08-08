
package com.skynet.retailscm.accountingdocumentcreation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountingDocumentCreationManager{

	public AccountingDocumentCreation createAccountingDocumentCreation(RetailScmUserContext userContext, String who, String comments, Date makeDate
) throws Exception;	
	public AccountingDocumentCreation updateAccountingDocumentCreation(RetailScmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String accountingDocumentCreationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  AccountingDocumentCreation addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId ,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentCreation removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentCreation updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


