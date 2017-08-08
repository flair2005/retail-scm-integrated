
package com.skynet.retailscm.memberwishlist;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface MemberWishlistManager{

	public MemberWishlist createMemberWishlist(RetailScmUserContext userContext, String name, String ownerId
) throws Exception;	
	public MemberWishlist updateMemberWishlist(RetailScmUserContext userContext,String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public MemberWishlist transferToAnotherOwner(RetailScmUserContext userContext, String memberWishlistId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String memberWishlistId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  MemberWishlist addMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, String name ,String [] tokensExpr)  throws Exception;
	public  MemberWishlist removeMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr)  throws Exception;
	public  MemberWishlist updateMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


