
package com.skynet.retailscm.originalvouchercreation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface OriginalVoucherCreationManager{

	public OriginalVoucherCreation createOriginalVoucherCreation(RetailScmUserContext userContext, String who, String comments, Date makeDate
) throws Exception;	
	public OriginalVoucherCreation updateOriginalVoucherCreation(RetailScmUserContext userContext,String originalVoucherCreationId, int originalVoucherCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String originalVoucherCreationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  OriginalVoucherCreation addOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId ,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherCreation removeOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherCreation updateOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


