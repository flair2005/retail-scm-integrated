
package com.skynet.retailscm.retailstoremember;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.skynet.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.skynet.retailscm.memberwishlist.MemberWishlist;
import com.skynet.retailscm.consumerorder.ConsumerOrder;
import com.skynet.retailscm.memberrewardpoint.MemberRewardPoint;
import com.skynet.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;

@JsonSerialize(using = RetailStoreMemberSerializer.class)
public class RetailStoreMember extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PHONE_PROPERTY          = "mobilePhone"       ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LIST                      = "consumerOrderList" ;
	public static final String RETAIL_STORE_MEMBER_COUPON_LIST          = "retailStoreMemberCouponList";
	public static final String MEMBER_WISHLIST_LIST                     = "memberWishlistList";
	public static final String MEMBER_REWARD_POINT_LIST                 = "memberRewardPointList";
	public static final String MEMBER_REWARD_POINT_REDEMPTION_LIST      = "memberRewardPointRedemptionList";
	public static final String RETAIL_STORE_MEMBER_ADDRESS_LIST         = "retailStoreMemberAddressList";
	public static final String RETAIL_STORE_MEMBER_GIFT_CARD_LIST       = "retailStoreMemberGiftCardList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mMobilePhone        ;
	protected		RetailStoreCountryCenter	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrder>	mConsumerOrderList  ;
	protected		SmartList<RetailStoreMemberCoupon>	mRetailStoreMemberCouponList;
	protected		SmartList<MemberWishlist>	mMemberWishlistList ;
	protected		SmartList<MemberRewardPoint>	mMemberRewardPointList;
	protected		SmartList<MemberRewardPointRedemption>	mMemberRewardPointRedemptionList;
	protected		SmartList<RetailStoreMemberAddress>	mRetailStoreMemberAddressList;
	protected		SmartList<RetailStoreMemberGiftCard>	mRetailStoreMemberGiftCardList;
	
		
	public 	RetailStoreMember(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreMember(String name, String mobilePhone, RetailStoreCountryCenter owner
)
	{
		setName(name);
		setMobilePhone(mobilePhone);
		setOwner(owner);

		this.mConsumerOrderList = new SmartList<ConsumerOrder>();
		this.mRetailStoreMemberCouponList = new SmartList<RetailStoreMemberCoupon>();
		this.mMemberWishlistList = new SmartList<MemberWishlist>();
		this.mMemberRewardPointList = new SmartList<MemberRewardPoint>();
		this.mMemberRewardPointRedemptionList = new SmartList<MemberRewardPointRedemption>();
		this.mRetailStoreMemberAddressList = new SmartList<RetailStoreMemberAddress>();
		this.mRetailStoreMemberGiftCardList = new SmartList<RetailStoreMemberGiftCard>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PHONE_PROPERTY.equals(property)){
			changeMobilePhoneProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setName(newValue);
		//they are surely different each other
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMobilePhoneProperty(String newValueExpr){
		String oldValue = getMobilePhone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMobilePhone(newValue);
		//they are surely different each other
		this.onChangeProperty(MOBILE_PHONE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	
	
	public void setMobilePhone(String mobilePhone){
		this.mMobilePhone = trimString(mobilePhone);;
	}
	public String getMobilePhone(){
		return this.mMobilePhone;
	}
	
	
	
	public String getMaskedMobilePhone(){
		String mobilePhoneNumber = getMobilePhone();
		if(mobilePhoneNumber == null){
			return null;
		}
		if(mobilePhoneNumber.length()!=11){
			return mobilePhoneNumber;//残缺的手机号，无需屏蔽
		}
		return mobilePhoneNumber.substring(0,3)
			+"****"
			+mobilePhoneNumber.substring(7);
	}
	
		
	public void setOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
	}
	public RetailStoreCountryCenter getOwner(){
		return this.mOwner;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<ConsumerOrder> getConsumerOrderList(){
		if(this.mConsumerOrderList == null){
			this.mConsumerOrderList = new SmartList<ConsumerOrder>();
		}
		return this.mConsumerOrderList;	
	}
	public  void setConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setConsumer(this);
		}
		
		this.mConsumerOrderList = consumerOrderList;
		
	}
	
	public  void addConsumerOrder(ConsumerOrder consumerOrder){
		consumerOrder.setConsumer(this);
		getConsumerOrderList().add(consumerOrder);
	}
	public  void addConsumerOrders(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setConsumer(this);
		}
		getConsumerOrderList().addAll(consumerOrderList);
	}
	
	public  void removeConsumerOrder(ConsumerOrder consumerOrder){
	
		boolean result = getConsumerOrderList().planToRemove(consumerOrder);
        if(!result){
        	String message = "ConsumerOrder("+consumerOrder.getId()+") with version='"+consumerOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveConsumerOrderList", consumerOrder);
		//the constant "toConsumerOrder" will be replaced after refactoried.
	
	}
	
	public void copyConsumerOrderFrom(ConsumerOrder consumerOrder) {
		// TODO Auto-generated method stub
		
        ConsumerOrder consumerOrderInList = findTheConsumerOrder(consumerOrder);
        ConsumerOrder newConsumerOrder = new ConsumerOrder();
        consumerOrderInList.copyTo(newConsumerOrder);
        newConsumerOrder.setVersion(0);//will trigger copy
        getConsumerOrderList().add(newConsumerOrder);
	}
	
	public  ConsumerOrder findTheConsumerOrder(ConsumerOrder consumerOrder){
		
		int index =  getConsumerOrderList().indexOf(consumerOrder);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ConsumerOrder("+consumerOrder.getId()+") with version='"+consumerOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getConsumerOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpConsumerOrderList(){
		getConsumerOrderList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreMemberCoupon> getRetailStoreMemberCouponList(){
		if(this.mRetailStoreMemberCouponList == null){
			this.mRetailStoreMemberCouponList = new SmartList<RetailStoreMemberCoupon>();
		}
		return this.mRetailStoreMemberCouponList;	
	}
	public  void setRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		for( RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList){
			retailStoreMemberCoupon.setOwner(this);
		}
		
		this.mRetailStoreMemberCouponList = retailStoreMemberCouponList;
		
	}
	
	public  void addRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCoupon){
		retailStoreMemberCoupon.setOwner(this);
		getRetailStoreMemberCouponList().add(retailStoreMemberCoupon);
	}
	public  void addRetailStoreMemberCoupons(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		for( RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList){
			retailStoreMemberCoupon.setOwner(this);
		}
		getRetailStoreMemberCouponList().addAll(retailStoreMemberCouponList);
	}
	
	public  void removeRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCoupon){
	
		boolean result = getRetailStoreMemberCouponList().planToRemove(retailStoreMemberCoupon);
        if(!result){
        	String message = "RetailStoreMemberCoupon("+retailStoreMemberCoupon.getId()+") with version='"+retailStoreMemberCoupon.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreMemberCouponList", retailStoreMemberCoupon);
		//the constant "toRetailStoreMemberCoupon" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreMemberCouponFrom(RetailStoreMemberCoupon retailStoreMemberCoupon) {
		// TODO Auto-generated method stub
		
        RetailStoreMemberCoupon retailStoreMemberCouponInList = findTheRetailStoreMemberCoupon(retailStoreMemberCoupon);
        RetailStoreMemberCoupon newRetailStoreMemberCoupon = new RetailStoreMemberCoupon();
        retailStoreMemberCouponInList.copyTo(newRetailStoreMemberCoupon);
        newRetailStoreMemberCoupon.setVersion(0);//will trigger copy
        getRetailStoreMemberCouponList().add(newRetailStoreMemberCoupon);
	}
	
	public  RetailStoreMemberCoupon findTheRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCoupon){
		
		int index =  getRetailStoreMemberCouponList().indexOf(retailStoreMemberCoupon);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreMemberCoupon("+retailStoreMemberCoupon.getId()+") with version='"+retailStoreMemberCoupon.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreMemberCouponList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberCouponList(){
		getRetailStoreMemberCouponList().clear();
	}
	
	
	
	
	public  SmartList<MemberWishlist> getMemberWishlistList(){
		if(this.mMemberWishlistList == null){
			this.mMemberWishlistList = new SmartList<MemberWishlist>();
		}
		return this.mMemberWishlistList;	
	}
	public  void setMemberWishlistList(SmartList<MemberWishlist> memberWishlistList){
		for( MemberWishlist memberWishlist:memberWishlistList){
			memberWishlist.setOwner(this);
		}
		
		this.mMemberWishlistList = memberWishlistList;
		
	}
	
	public  void addMemberWishlist(MemberWishlist memberWishlist){
		memberWishlist.setOwner(this);
		getMemberWishlistList().add(memberWishlist);
	}
	public  void addMemberWishlists(SmartList<MemberWishlist> memberWishlistList){
		for( MemberWishlist memberWishlist:memberWishlistList){
			memberWishlist.setOwner(this);
		}
		getMemberWishlistList().addAll(memberWishlistList);
	}
	
	public  void removeMemberWishlist(MemberWishlist memberWishlist){
	
		boolean result = getMemberWishlistList().planToRemove(memberWishlist);
        if(!result){
        	String message = "MemberWishlist("+memberWishlist.getId()+") with version='"+memberWishlist.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveMemberWishlistList", memberWishlist);
		//the constant "toMemberWishlist" will be replaced after refactoried.
	
	}
	
	public void copyMemberWishlistFrom(MemberWishlist memberWishlist) {
		// TODO Auto-generated method stub
		
        MemberWishlist memberWishlistInList = findTheMemberWishlist(memberWishlist);
        MemberWishlist newMemberWishlist = new MemberWishlist();
        memberWishlistInList.copyTo(newMemberWishlist);
        newMemberWishlist.setVersion(0);//will trigger copy
        getMemberWishlistList().add(newMemberWishlist);
	}
	
	public  MemberWishlist findTheMemberWishlist(MemberWishlist memberWishlist){
		
		int index =  getMemberWishlistList().indexOf(memberWishlist);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "MemberWishlist("+memberWishlist.getId()+") with version='"+memberWishlist.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getMemberWishlistList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMemberWishlistList(){
		getMemberWishlistList().clear();
	}
	
	
	
	
	public  SmartList<MemberRewardPoint> getMemberRewardPointList(){
		if(this.mMemberRewardPointList == null){
			this.mMemberRewardPointList = new SmartList<MemberRewardPoint>();
		}
		return this.mMemberRewardPointList;	
	}
	public  void setMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList){
		for( MemberRewardPoint memberRewardPoint:memberRewardPointList){
			memberRewardPoint.setOwner(this);
		}
		
		this.mMemberRewardPointList = memberRewardPointList;
		
	}
	
	public  void addMemberRewardPoint(MemberRewardPoint memberRewardPoint){
		memberRewardPoint.setOwner(this);
		getMemberRewardPointList().add(memberRewardPoint);
	}
	public  void addMemberRewardPoints(SmartList<MemberRewardPoint> memberRewardPointList){
		for( MemberRewardPoint memberRewardPoint:memberRewardPointList){
			memberRewardPoint.setOwner(this);
		}
		getMemberRewardPointList().addAll(memberRewardPointList);
	}
	
	public  void removeMemberRewardPoint(MemberRewardPoint memberRewardPoint){
	
		boolean result = getMemberRewardPointList().planToRemove(memberRewardPoint);
        if(!result){
        	String message = "MemberRewardPoint("+memberRewardPoint.getId()+") with version='"+memberRewardPoint.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveMemberRewardPointList", memberRewardPoint);
		//the constant "toMemberRewardPoint" will be replaced after refactoried.
	
	}
	
	public void copyMemberRewardPointFrom(MemberRewardPoint memberRewardPoint) {
		// TODO Auto-generated method stub
		
        MemberRewardPoint memberRewardPointInList = findTheMemberRewardPoint(memberRewardPoint);
        MemberRewardPoint newMemberRewardPoint = new MemberRewardPoint();
        memberRewardPointInList.copyTo(newMemberRewardPoint);
        newMemberRewardPoint.setVersion(0);//will trigger copy
        getMemberRewardPointList().add(newMemberRewardPoint);
	}
	
	public  MemberRewardPoint findTheMemberRewardPoint(MemberRewardPoint memberRewardPoint){
		
		int index =  getMemberRewardPointList().indexOf(memberRewardPoint);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "MemberRewardPoint("+memberRewardPoint.getId()+") with version='"+memberRewardPoint.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getMemberRewardPointList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMemberRewardPointList(){
		getMemberRewardPointList().clear();
	}
	
	
	
	
	public  SmartList<MemberRewardPointRedemption> getMemberRewardPointRedemptionList(){
		if(this.mMemberRewardPointRedemptionList == null){
			this.mMemberRewardPointRedemptionList = new SmartList<MemberRewardPointRedemption>();
		}
		return this.mMemberRewardPointRedemptionList;	
	}
	public  void setMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		for( MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList){
			memberRewardPointRedemption.setOwner(this);
		}
		
		this.mMemberRewardPointRedemptionList = memberRewardPointRedemptionList;
		
	}
	
	public  void addMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemption){
		memberRewardPointRedemption.setOwner(this);
		getMemberRewardPointRedemptionList().add(memberRewardPointRedemption);
	}
	public  void addMemberRewardPointRedemptions(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		for( MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList){
			memberRewardPointRedemption.setOwner(this);
		}
		getMemberRewardPointRedemptionList().addAll(memberRewardPointRedemptionList);
	}
	
	public  void removeMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemption){
	
		boolean result = getMemberRewardPointRedemptionList().planToRemove(memberRewardPointRedemption);
        if(!result){
        	String message = "MemberRewardPointRedemption("+memberRewardPointRedemption.getId()+") with version='"+memberRewardPointRedemption.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveMemberRewardPointRedemptionList", memberRewardPointRedemption);
		//the constant "toMemberRewardPointRedemption" will be replaced after refactoried.
	
	}
	
	public void copyMemberRewardPointRedemptionFrom(MemberRewardPointRedemption memberRewardPointRedemption) {
		// TODO Auto-generated method stub
		
        MemberRewardPointRedemption memberRewardPointRedemptionInList = findTheMemberRewardPointRedemption(memberRewardPointRedemption);
        MemberRewardPointRedemption newMemberRewardPointRedemption = new MemberRewardPointRedemption();
        memberRewardPointRedemptionInList.copyTo(newMemberRewardPointRedemption);
        newMemberRewardPointRedemption.setVersion(0);//will trigger copy
        getMemberRewardPointRedemptionList().add(newMemberRewardPointRedemption);
	}
	
	public  MemberRewardPointRedemption findTheMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemption){
		
		int index =  getMemberRewardPointRedemptionList().indexOf(memberRewardPointRedemption);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "MemberRewardPointRedemption("+memberRewardPointRedemption.getId()+") with version='"+memberRewardPointRedemption.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getMemberRewardPointRedemptionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMemberRewardPointRedemptionList(){
		getMemberRewardPointRedemptionList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreMemberAddress> getRetailStoreMemberAddressList(){
		if(this.mRetailStoreMemberAddressList == null){
			this.mRetailStoreMemberAddressList = new SmartList<RetailStoreMemberAddress>();
		}
		return this.mRetailStoreMemberAddressList;	
	}
	public  void setRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList){
		for( RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList){
			retailStoreMemberAddress.setOwner(this);
		}
		
		this.mRetailStoreMemberAddressList = retailStoreMemberAddressList;
		
	}
	
	public  void addRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddress){
		retailStoreMemberAddress.setOwner(this);
		getRetailStoreMemberAddressList().add(retailStoreMemberAddress);
	}
	public  void addRetailStoreMemberAddresses(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList){
		for( RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList){
			retailStoreMemberAddress.setOwner(this);
		}
		getRetailStoreMemberAddressList().addAll(retailStoreMemberAddressList);
	}
	
	public  void removeRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddress){
	
		boolean result = getRetailStoreMemberAddressList().planToRemove(retailStoreMemberAddress);
        if(!result){
        	String message = "RetailStoreMemberAddress("+retailStoreMemberAddress.getId()+") with version='"+retailStoreMemberAddress.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreMemberAddressList", retailStoreMemberAddress);
		//the constant "toRetailStoreMemberAddress" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreMemberAddressFrom(RetailStoreMemberAddress retailStoreMemberAddress) {
		// TODO Auto-generated method stub
		
        RetailStoreMemberAddress retailStoreMemberAddressInList = findTheRetailStoreMemberAddress(retailStoreMemberAddress);
        RetailStoreMemberAddress newRetailStoreMemberAddress = new RetailStoreMemberAddress();
        retailStoreMemberAddressInList.copyTo(newRetailStoreMemberAddress);
        newRetailStoreMemberAddress.setVersion(0);//will trigger copy
        getRetailStoreMemberAddressList().add(newRetailStoreMemberAddress);
	}
	
	public  RetailStoreMemberAddress findTheRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddress){
		
		int index =  getRetailStoreMemberAddressList().indexOf(retailStoreMemberAddress);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreMemberAddress("+retailStoreMemberAddress.getId()+") with version='"+retailStoreMemberAddress.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreMemberAddressList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberAddressList(){
		getRetailStoreMemberAddressList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreMemberGiftCard> getRetailStoreMemberGiftCardList(){
		if(this.mRetailStoreMemberGiftCardList == null){
			this.mRetailStoreMemberGiftCardList = new SmartList<RetailStoreMemberGiftCard>();
		}
		return this.mRetailStoreMemberGiftCardList;	
	}
	public  void setRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		for( RetailStoreMemberGiftCard retailStoreMemberGiftCard:retailStoreMemberGiftCardList){
			retailStoreMemberGiftCard.setOwner(this);
		}
		
		this.mRetailStoreMemberGiftCardList = retailStoreMemberGiftCardList;
		
	}
	
	public  void addRetailStoreMemberGiftCard(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
		retailStoreMemberGiftCard.setOwner(this);
		getRetailStoreMemberGiftCardList().add(retailStoreMemberGiftCard);
	}
	public  void addRetailStoreMemberGiftCards(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		for( RetailStoreMemberGiftCard retailStoreMemberGiftCard:retailStoreMemberGiftCardList){
			retailStoreMemberGiftCard.setOwner(this);
		}
		getRetailStoreMemberGiftCardList().addAll(retailStoreMemberGiftCardList);
	}
	
	public  void removeRetailStoreMemberGiftCard(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
	
		boolean result = getRetailStoreMemberGiftCardList().planToRemove(retailStoreMemberGiftCard);
        if(!result){
        	String message = "RetailStoreMemberGiftCard("+retailStoreMemberGiftCard.getId()+") with version='"+retailStoreMemberGiftCard.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreMemberGiftCardList", retailStoreMemberGiftCard);
		//the constant "toRetailStoreMemberGiftCard" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreMemberGiftCardFrom(RetailStoreMemberGiftCard retailStoreMemberGiftCard) {
		// TODO Auto-generated method stub
		
        RetailStoreMemberGiftCard retailStoreMemberGiftCardInList = findTheRetailStoreMemberGiftCard(retailStoreMemberGiftCard);
        RetailStoreMemberGiftCard newRetailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
        retailStoreMemberGiftCardInList.copyTo(newRetailStoreMemberGiftCard);
        newRetailStoreMemberGiftCard.setVersion(0);//will trigger copy
        getRetailStoreMemberGiftCardList().add(newRetailStoreMemberGiftCard);
	}
	
	public  RetailStoreMemberGiftCard findTheRetailStoreMemberGiftCard(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
		
		int index =  getRetailStoreMemberGiftCardList().indexOf(retailStoreMemberGiftCard);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreMemberGiftCard("+retailStoreMemberGiftCard.getId()+") with version='"+retailStoreMemberGiftCard.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreMemberGiftCardList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberGiftCardList(){
		getRetailStoreMemberGiftCardList().clear();
	}
	
	
	
	
 	
	
	public RetailStoreMember copyTo(RetailStoreMember dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setMobilePhone(getMobilePhone());
		dest.setOwner(getOwner());
		dest.setVersion(getVersion());
		dest.setConsumerOrderList(getConsumerOrderList());
		dest.setRetailStoreMemberCouponList(getRetailStoreMemberCouponList());
		dest.setMemberWishlistList(getMemberWishlistList());
		dest.setMemberRewardPointList(getMemberRewardPointList());
		dest.setMemberRewardPointRedemptionList(getMemberRewardPointRedemptionList());
		dest.setRetailStoreMemberAddressList(getRetailStoreMemberAddressList());
		dest.setRetailStoreMemberGiftCardList(getRetailStoreMemberGiftCardList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_member{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile_phone='"+getMobilePhone()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_country_center("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

