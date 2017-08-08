
package com.skynet.retailscm.retailstoremembercoupon;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreMemberCouponManager{

	public RetailStoreMemberCoupon createRetailStoreMemberCoupon(RetailScmUserContext userContext, String name, String ownerId, String number
) throws Exception;	
	public RetailStoreMemberCoupon updateRetailStoreMemberCoupon(RetailScmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreMemberCoupon transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberCouponId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreMemberCouponId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


