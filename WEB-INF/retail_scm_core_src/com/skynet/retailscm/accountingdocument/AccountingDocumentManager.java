
package com.skynet.retailscm.accountingdocument;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface AccountingDocumentManager{

	public AccountingDocument createAccountingDocument(RetailScmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId
) throws Exception;	
	public AccountingDocument updateAccountingDocument(RetailScmUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public AccountingDocument transferToAnotherAccountingPeriod(RetailScmUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId)  throws Exception;
 	public AccountingDocument transferToAnotherDocumentType(RetailScmUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId)  throws Exception;
 	public AccountingDocument create(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
)  throws Exception;
	public AccountingDocument confirm(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
)  throws Exception;
	public AccountingDocument audit(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
)  throws Exception;
	public AccountingDocument post(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
)  throws Exception;


	public void delete(RetailScmUserContext userContext, String accountingDocumentId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  AccountingDocument addOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage ,String [] tokensExpr)  throws Exception;
	public  AccountingDocument removeOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocument updateOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  AccountingDocument addAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, String name, String code, String direct, double amount, String accountingSubjectId ,String [] tokensExpr)  throws Exception;
	public  AccountingDocument removeAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocument updateAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


