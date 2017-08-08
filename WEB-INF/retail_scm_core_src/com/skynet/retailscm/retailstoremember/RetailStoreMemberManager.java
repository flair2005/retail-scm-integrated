
package com.skynet.retailscm.retailstoremember;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreMemberManager{

	public RetailStoreMember createRetailStoreMember(RetailScmUserContext userContext, String name, String mobilePhone, String ownerId
) throws Exception;	
	public RetailStoreMember updateRetailStoreMember(RetailScmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreMember transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreMemberId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreMember addConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, String title, String storeId ,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, String name, String number ,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, String name ,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, String name, int point ,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, String name, int point ,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address ,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, String name, String number, double remain ,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


