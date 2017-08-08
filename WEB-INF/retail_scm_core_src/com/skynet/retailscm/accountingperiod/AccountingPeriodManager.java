
package com.skynet.retailscm.accountingperiod;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountingPeriodManager{

	public AccountingPeriod createAccountingPeriod(RetailScmUserContext userContext, String name, Date startDate, Date endDate, String accountSetId
) throws Exception;	
	public AccountingPeriod updateAccountingPeriod(RetailScmUserContext userContext,String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public AccountingPeriod transferToAnotherAccountSet(RetailScmUserContext userContext, String accountingPeriodId, String anotherAccountSetId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String accountingPeriodId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  AccountingPeriod addAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String documentTypeId ,String [] tokensExpr)  throws Exception;
	public  AccountingPeriod removeAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingPeriod updateAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


