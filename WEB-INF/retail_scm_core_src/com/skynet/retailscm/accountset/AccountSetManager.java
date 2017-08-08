
package com.skynet.retailscm.accountset;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountSetManager{

	public AccountSet createAccountSet(RetailScmUserContext userContext, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId, String goodsSupplierId
) throws Exception;	
	public AccountSet updateAccountSet(RetailScmUserContext userContext,String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public AccountSet transferToAnotherCountryCenter(RetailScmUserContext userContext, String accountSetId, String anotherCountryCenterId)  throws Exception;
 	public AccountSet transferToAnotherRetailStore(RetailScmUserContext userContext, String accountSetId, String anotherRetailStoreId)  throws Exception;
 	public AccountSet transferToAnotherGoodsSupplier(RetailScmUserContext userContext, String accountSetId, String anotherGoodsSupplierId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String accountSetId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  AccountSet addAccountingSubject(RetailScmUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName ,String [] tokensExpr)  throws Exception;
	public  AccountSet removeAccountingSubject(RetailScmUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr)  throws Exception;
	public  AccountSet updateAccountingSubject(RetailScmUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  AccountSet addAccountingPeriod(RetailScmUserContext userContext, String accountSetId, String name, Date startDate, Date endDate ,String [] tokensExpr)  throws Exception;
	public  AccountSet removeAccountingPeriod(RetailScmUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr)  throws Exception;
	public  AccountSet updateAccountingPeriod(RetailScmUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  AccountSet addAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, String name, String description ,String [] tokensExpr)  throws Exception;
	public  AccountSet removeAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr)  throws Exception;
	public  AccountSet updateAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


