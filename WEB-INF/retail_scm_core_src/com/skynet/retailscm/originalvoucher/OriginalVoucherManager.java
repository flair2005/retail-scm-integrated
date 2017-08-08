
package com.skynet.retailscm.originalvoucher;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface OriginalVoucherManager{

	public OriginalVoucher createOriginalVoucher(RetailScmUserContext userContext, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId
) throws Exception;	
	public OriginalVoucher updateOriginalVoucher(RetailScmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public OriginalVoucher transferToAnotherBelongsTo(RetailScmUserContext userContext, String originalVoucherId, String anotherBelongsToId)  throws Exception;
 	public OriginalVoucher create(RetailScmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
)  throws Exception;
	public OriginalVoucher confirm(RetailScmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
)  throws Exception;
	public OriginalVoucher audit(RetailScmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
)  throws Exception;


	public void delete(RetailScmUserContext userContext, String originalVoucherId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


