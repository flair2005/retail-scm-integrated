
package com.skynet.retailscm.memberwishlistproduct;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface MemberWishlistProductManager{

	public MemberWishlistProduct createMemberWishlistProduct(RetailScmUserContext userContext, String name, String ownerId
) throws Exception;	
	public MemberWishlistProduct updateMemberWishlistProduct(RetailScmUserContext userContext,String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public MemberWishlistProduct transferToAnotherOwner(RetailScmUserContext userContext, String memberWishlistProductId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String memberWishlistProductId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


