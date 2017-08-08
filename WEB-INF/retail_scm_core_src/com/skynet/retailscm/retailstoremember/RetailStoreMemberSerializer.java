
package com.skynet.retailscm.retailstoremember;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.skynet.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.skynet.retailscm.memberwishlist.MemberWishlist;
import com.skynet.retailscm.consumerorder.ConsumerOrder;
import com.skynet.retailscm.memberrewardpoint.MemberRewardPoint;
import com.skynet.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;


public class RetailStoreMemberSerializer extends BaseJsonSerializer<RetailStoreMember>{

	

	@Override
	public void serialize(RetailStoreMember retailStoreMember, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreMember,jgen,provider);
		
		jgen.writeStringField(RetailStoreMember.ID_PROPERTY,retailStoreMember.getId());
		jgen.writeStringField(RetailStoreMember.NAME_PROPERTY,retailStoreMember.getName());
		jgen.writeStringField(RetailStoreMember.MOBILE_PHONE_PROPERTY,retailStoreMember.getMobilePhone());
		writeOwner(RetailStoreMember.OWNER_PROPERTY,retailStoreMember,jgen,provider);
		jgen.writeNumberField(RetailStoreMember.VERSION_PROPERTY,retailStoreMember.getVersion());
		writeConsumerOrderList(RetailStoreMember.CONSUMER_ORDER_LIST,retailStoreMember,jgen,provider);
		writeRetailStoreMemberCouponList(RetailStoreMember.RETAIL_STORE_MEMBER_COUPON_LIST,retailStoreMember,jgen,provider);
		writeMemberWishlistList(RetailStoreMember.MEMBER_WISHLIST_LIST,retailStoreMember,jgen,provider);
		writeMemberRewardPointList(RetailStoreMember.MEMBER_REWARD_POINT_LIST,retailStoreMember,jgen,provider);
		writeMemberRewardPointRedemptionList(RetailStoreMember.MEMBER_REWARD_POINT_REDEMPTION_LIST,retailStoreMember,jgen,provider);
		writeRetailStoreMemberAddressList(RetailStoreMember.RETAIL_STORE_MEMBER_ADDRESS_LIST,retailStoreMember,jgen,provider);
		writeRetailStoreMemberGiftCardList(RetailStoreMember.RETAIL_STORE_MEMBER_GIFT_CARD_LIST,retailStoreMember,jgen,provider);
		
		writeEndObject(retailStoreMember,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, RetailStoreMember retailStoreMember, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter owner = retailStoreMember.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,owner.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,owner.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,owner.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,owner.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,owner.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,owner.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,owner.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeConsumerOrderList(String fieldName, RetailStoreMember retailStoreMember, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();
		
		if(consumerOrderList == null){
			return;//do nothing when null found for this field.
		}
		if(consumerOrderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ConsumerOrder consumerOrder: consumerOrderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ConsumerOrder.ID_PROPERTY,consumerOrder.getId());
			jgen.writeStringField(ConsumerOrder.TITLE_PROPERTY,consumerOrder.getTitle());
			jgen.writeStringField(ConsumerOrder.CURRENT_STATUS_PROPERTY,consumerOrder.getCurrentStatus());
			jgen.writeNumberField(ConsumerOrder.VERSION_PROPERTY,consumerOrder.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreMemberCouponList(String fieldName, RetailStoreMember retailStoreMember, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreMemberCoupon> retailStoreMemberCouponList = retailStoreMember.getRetailStoreMemberCouponList();
		
		if(retailStoreMemberCouponList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreMemberCouponList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreMemberCoupon retailStoreMemberCoupon: retailStoreMemberCouponList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreMemberCoupon.ID_PROPERTY,retailStoreMemberCoupon.getId());
			jgen.writeStringField(RetailStoreMemberCoupon.NAME_PROPERTY,retailStoreMemberCoupon.getName());
			jgen.writeStringField(RetailStoreMemberCoupon.NUMBER_PROPERTY,retailStoreMemberCoupon.getNumber());
			jgen.writeNumberField(RetailStoreMemberCoupon.VERSION_PROPERTY,retailStoreMemberCoupon.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeMemberWishlistList(String fieldName, RetailStoreMember retailStoreMember, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<MemberWishlist> memberWishlistList = retailStoreMember.getMemberWishlistList();
		
		if(memberWishlistList == null){
			return;//do nothing when null found for this field.
		}
		if(memberWishlistList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(MemberWishlist memberWishlist: memberWishlistList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(MemberWishlist.ID_PROPERTY,memberWishlist.getId());
			jgen.writeStringField(MemberWishlist.NAME_PROPERTY,memberWishlist.getName());
			jgen.writeNumberField(MemberWishlist.VERSION_PROPERTY,memberWishlist.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeMemberRewardPointList(String fieldName, RetailStoreMember retailStoreMember, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<MemberRewardPoint> memberRewardPointList = retailStoreMember.getMemberRewardPointList();
		
		if(memberRewardPointList == null){
			return;//do nothing when null found for this field.
		}
		if(memberRewardPointList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(MemberRewardPoint memberRewardPoint: memberRewardPointList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(MemberRewardPoint.ID_PROPERTY,memberRewardPoint.getId());
			jgen.writeStringField(MemberRewardPoint.NAME_PROPERTY,memberRewardPoint.getName());
			jgen.writeNumberField(MemberRewardPoint.POINT_PROPERTY,memberRewardPoint.getPoint());
			jgen.writeNumberField(MemberRewardPoint.VERSION_PROPERTY,memberRewardPoint.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeMemberRewardPointRedemptionList(String fieldName, RetailStoreMember retailStoreMember, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<MemberRewardPointRedemption> memberRewardPointRedemptionList = retailStoreMember.getMemberRewardPointRedemptionList();
		
		if(memberRewardPointRedemptionList == null){
			return;//do nothing when null found for this field.
		}
		if(memberRewardPointRedemptionList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(MemberRewardPointRedemption memberRewardPointRedemption: memberRewardPointRedemptionList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(MemberRewardPointRedemption.ID_PROPERTY,memberRewardPointRedemption.getId());
			jgen.writeStringField(MemberRewardPointRedemption.NAME_PROPERTY,memberRewardPointRedemption.getName());
			jgen.writeNumberField(MemberRewardPointRedemption.POINT_PROPERTY,memberRewardPointRedemption.getPoint());
			jgen.writeNumberField(MemberRewardPointRedemption.VERSION_PROPERTY,memberRewardPointRedemption.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreMemberAddressList(String fieldName, RetailStoreMember retailStoreMember, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreMemberAddress> retailStoreMemberAddressList = retailStoreMember.getRetailStoreMemberAddressList();
		
		if(retailStoreMemberAddressList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreMemberAddressList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreMemberAddress retailStoreMemberAddress: retailStoreMemberAddressList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreMemberAddress.ID_PROPERTY,retailStoreMemberAddress.getId());
			jgen.writeStringField(RetailStoreMemberAddress.NAME_PROPERTY,retailStoreMemberAddress.getName());
			jgen.writeStringField(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY,retailStoreMemberAddress.getMobilePhone());
			jgen.writeStringField(RetailStoreMemberAddress.ADDRESS_PROPERTY,retailStoreMemberAddress.getAddress());
			jgen.writeNumberField(RetailStoreMemberAddress.VERSION_PROPERTY,retailStoreMemberAddress.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreMemberGiftCardList(String fieldName, RetailStoreMember retailStoreMember, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = retailStoreMember.getRetailStoreMemberGiftCardList();
		
		if(retailStoreMemberGiftCardList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreMemberGiftCardList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreMemberGiftCard retailStoreMemberGiftCard: retailStoreMemberGiftCardList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreMemberGiftCard.ID_PROPERTY,retailStoreMemberGiftCard.getId());
			jgen.writeStringField(RetailStoreMemberGiftCard.NAME_PROPERTY,retailStoreMemberGiftCard.getName());
			jgen.writeStringField(RetailStoreMemberGiftCard.NUMBER_PROPERTY,retailStoreMemberGiftCard.getNumber());
			jgen.writeNumberField(RetailStoreMemberGiftCard.REMAIN_PROPERTY,retailStoreMemberGiftCard.getRemain());
			jgen.writeNumberField(RetailStoreMemberGiftCard.VERSION_PROPERTY,retailStoreMemberGiftCard.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


