
package com.skynet.retailscm.originalvoucherconfirmation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface OriginalVoucherConfirmationManager{

	public OriginalVoucherConfirmation createOriginalVoucherConfirmation(RetailScmUserContext userContext, String who, String comments, Date makeDate
) throws Exception;	
	public OriginalVoucherConfirmation updateOriginalVoucherConfirmation(RetailScmUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String originalVoucherConfirmationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  OriginalVoucherConfirmation addOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId ,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherConfirmation removeOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherConfirmation updateOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


