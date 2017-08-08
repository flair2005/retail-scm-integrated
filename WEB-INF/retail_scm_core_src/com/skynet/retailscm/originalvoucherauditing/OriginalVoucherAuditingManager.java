
package com.skynet.retailscm.originalvoucherauditing;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface OriginalVoucherAuditingManager{

	public OriginalVoucherAuditing createOriginalVoucherAuditing(RetailScmUserContext userContext, String who, String comments, Date makeDate
) throws Exception;	
	public OriginalVoucherAuditing updateOriginalVoucherAuditing(RetailScmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String originalVoucherAuditingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  OriginalVoucherAuditing addOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId ,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherAuditing removeOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherAuditing updateOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


