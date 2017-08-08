
package com.skynet.retailscm.retailstoremember;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreMemberTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreMember";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected RetailStoreMemberTokens(){
		//ensure not initialized outside the class
	}
	
	public RetailStoreMemberTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreMemberTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreMemberTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RetailStoreMemberTokens start(){
		return new RetailStoreMemberTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RetailStoreMemberTokens allTokens(){
		
		return start()
			.withOwner()
			.withConsumerOrderList()
			.withRetailStoreMemberCouponList()
			.withMemberWishlistList()
			.withMemberRewardPointList()
			.withMemberRewardPointRedemptionList()
			.withRetailStoreMemberAddressList()
			.withRetailStoreMemberGiftCardList();
	
	}
	protected static RetailStoreMemberTokens withoutListsTokens(){
		
		return start()
			.withOwner();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	public RetailStoreMemberTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
	protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	public String getConsumerOrderList(){
		return CONSUMER_ORDER_LIST;
	}
	public RetailStoreMemberTokens withConsumerOrderList(){		
		addSimpleOptions(CONSUMER_ORDER_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_MEMBER_COUPON_LIST = "retailStoreMemberCouponList";
	public String getRetailStoreMemberCouponList(){
		return RETAIL_STORE_MEMBER_COUPON_LIST;
	}
	public RetailStoreMemberTokens withRetailStoreMemberCouponList(){		
		addSimpleOptions(RETAIL_STORE_MEMBER_COUPON_LIST);
		return this;
	}	
		
	protected static final String MEMBER_WISHLIST_LIST = "memberWishlistList";
	public String getMemberWishlistList(){
		return MEMBER_WISHLIST_LIST;
	}
	public RetailStoreMemberTokens withMemberWishlistList(){		
		addSimpleOptions(MEMBER_WISHLIST_LIST);
		return this;
	}	
		
	protected static final String MEMBER_REWARD_POINT_LIST = "memberRewardPointList";
	public String getMemberRewardPointList(){
		return MEMBER_REWARD_POINT_LIST;
	}
	public RetailStoreMemberTokens withMemberRewardPointList(){		
		addSimpleOptions(MEMBER_REWARD_POINT_LIST);
		return this;
	}	
		
	protected static final String MEMBER_REWARD_POINT_REDEMPTION_LIST = "memberRewardPointRedemptionList";
	public String getMemberRewardPointRedemptionList(){
		return MEMBER_REWARD_POINT_REDEMPTION_LIST;
	}
	public RetailStoreMemberTokens withMemberRewardPointRedemptionList(){		
		addSimpleOptions(MEMBER_REWARD_POINT_REDEMPTION_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_MEMBER_ADDRESS_LIST = "retailStoreMemberAddressList";
	public String getRetailStoreMemberAddressList(){
		return RETAIL_STORE_MEMBER_ADDRESS_LIST;
	}
	public RetailStoreMemberTokens withRetailStoreMemberAddressList(){		
		addSimpleOptions(RETAIL_STORE_MEMBER_ADDRESS_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_MEMBER_GIFT_CARD_LIST = "retailStoreMemberGiftCardList";
	public String getRetailStoreMemberGiftCardList(){
		return RETAIL_STORE_MEMBER_GIFT_CARD_LIST;
	}
	public RetailStoreMemberTokens withRetailStoreMemberGiftCardList(){		
		addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_LIST);
		return this;
	}	
		
}

