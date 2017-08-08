
package com.skynet.retailscm.accountingdocumentline;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountingDocumentLineManager{

	public AccountingDocumentLine createAccountingDocumentLine(RetailScmUserContext userContext, String name, String code, String direct, double amount, String belongsToId, String accountingSubjectId
) throws Exception;	
	public AccountingDocumentLine updateAccountingDocumentLine(RetailScmUserContext userContext,String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public AccountingDocumentLine transferToAnotherBelongsTo(RetailScmUserContext userContext, String accountingDocumentLineId, String anotherBelongsToId)  throws Exception;
 	public AccountingDocumentLine transferToAnotherAccountingSubject(RetailScmUserContext userContext, String accountingDocumentLineId, String anotherAccountingSubjectId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String accountingDocumentLineId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


