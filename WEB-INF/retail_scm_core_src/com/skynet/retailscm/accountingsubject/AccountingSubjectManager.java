
package com.skynet.retailscm.accountingsubject;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountingSubjectManager{

	public AccountingSubject createAccountingSubject(RetailScmUserContext userContext, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName, String accountSetId
) throws Exception;	
	public AccountingSubject updateAccountingSubject(RetailScmUserContext userContext,String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public AccountingSubject transferToAnotherAccountSet(RetailScmUserContext userContext, String accountingSubjectId, String anotherAccountSetId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String accountingSubjectId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  AccountingSubject addAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, String name, String code, String direct, double amount, String belongsToId ,String [] tokensExpr)  throws Exception;
	public  AccountingSubject removeAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr)  throws Exception;
	public  AccountingSubject updateAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


