
package com.skynet.retailscm.accountingdocumenttype;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountingDocumentTypeManager{

	public AccountingDocumentType createAccountingDocumentType(RetailScmUserContext userContext, String name, String description, String accountingPeriodId
) throws Exception;	
	public AccountingDocumentType updateAccountingDocumentType(RetailScmUserContext userContext,String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public AccountingDocumentType transferToAnotherAccountingPeriod(RetailScmUserContext userContext, String accountingDocumentTypeId, String anotherAccountingPeriodId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String accountingDocumentTypeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  AccountingDocumentType addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId ,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentType removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentType updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


