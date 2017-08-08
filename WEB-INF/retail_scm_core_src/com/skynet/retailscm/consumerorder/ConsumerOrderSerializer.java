
package com.skynet.retailscm.consumerorder;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerorder.ConsumerOrder;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.skynet.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.skynet.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;


public class ConsumerOrderSerializer extends BaseJsonSerializer<ConsumerOrder>{

	

	@Override
	public void serialize(ConsumerOrder consumerOrder, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrder,jgen,provider);
		
		jgen.writeStringField(ConsumerOrder.ID_PROPERTY,consumerOrder.getId());
		jgen.writeStringField(ConsumerOrder.TITLE_PROPERTY,consumerOrder.getTitle());
		writeConsumer(ConsumerOrder.CONSUMER_PROPERTY,consumerOrder,jgen,provider);
		writeConfirmation(ConsumerOrder.CONFIRMATION_PROPERTY,consumerOrder,jgen,provider);
		writeApproval(ConsumerOrder.APPROVAL_PROPERTY,consumerOrder,jgen,provider);
		writeProcessing(ConsumerOrder.PROCESSING_PROPERTY,consumerOrder,jgen,provider);
		writeShipment(ConsumerOrder.SHIPMENT_PROPERTY,consumerOrder,jgen,provider);
		writeDelivery(ConsumerOrder.DELIVERY_PROPERTY,consumerOrder,jgen,provider);
		writeStore(ConsumerOrder.STORE_PROPERTY,consumerOrder,jgen,provider);
		jgen.writeStringField(ConsumerOrder.CURRENT_STATUS_PROPERTY,consumerOrder.getCurrentStatus());
		jgen.writeNumberField(ConsumerOrder.VERSION_PROPERTY,consumerOrder.getVersion());
		writeConsumerOrderLineItemList(ConsumerOrder.CONSUMER_ORDER_LINE_ITEM_LIST,consumerOrder,jgen,provider);
		writeConsumerOrderShippingGroupList(ConsumerOrder.CONSUMER_ORDER_SHIPPING_GROUP_LIST,consumerOrder,jgen,provider);
		writeConsumerOrderPaymentGroupList(ConsumerOrder.CONSUMER_ORDER_PAYMENT_GROUP_LIST,consumerOrder,jgen,provider);
		writeConsumerOrderPriceAdjustmentList(ConsumerOrder.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST,consumerOrder,jgen,provider);
		writeRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST,consumerOrder,jgen,provider);
		
		writeEndObject(consumerOrder,jgen,provider);
	}
	
	protected void writeConsumer(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreMember consumer = consumerOrder.getConsumer();
		
		if(consumer == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreMember.ID_PROPERTY,consumer.getId()); 
		jgen.writeStringField(RetailStoreMember.NAME_PROPERTY,consumer.getName()); 
		jgen.writeStringField(RetailStoreMember.MOBILE_PHONE_PROPERTY,consumer.getMobilePhone()); 
		jgen.writeNumberField(RetailStoreMember.VERSION_PROPERTY,consumer.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeConfirmation(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderConfirmation confirmation = consumerOrder.getConfirmation();
		
		if(confirmation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplyOrderConfirmation.ID_PROPERTY,confirmation.getId()); 
		jgen.writeStringField(SupplyOrderConfirmation.WHO_PROPERTY,confirmation.getWho()); 
		jgen.writeObjectField(SupplyOrderConfirmation.CONFIRM_TIME_PROPERTY,confirmation.getConfirmTime()); 
		jgen.writeNumberField(SupplyOrderConfirmation.VERSION_PROPERTY,confirmation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeApproval(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderApproval approval = consumerOrder.getApproval();
		
		if(approval == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplyOrderApproval.ID_PROPERTY,approval.getId()); 
		jgen.writeStringField(SupplyOrderApproval.WHO_PROPERTY,approval.getWho()); 
		jgen.writeObjectField(SupplyOrderApproval.APPROVE_TIME_PROPERTY,approval.getApproveTime()); 
		jgen.writeNumberField(SupplyOrderApproval.VERSION_PROPERTY,approval.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProcessing(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderProcessing processing = consumerOrder.getProcessing();
		
		if(processing == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplyOrderProcessing.ID_PROPERTY,processing.getId()); 
		jgen.writeStringField(SupplyOrderProcessing.WHO_PROPERTY,processing.getWho()); 
		jgen.writeObjectField(SupplyOrderProcessing.PROCESS_TIME_PROPERTY,processing.getProcessTime()); 
		jgen.writeNumberField(SupplyOrderProcessing.VERSION_PROPERTY,processing.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeShipment(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderShipment shipment = consumerOrder.getShipment();
		
		if(shipment == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplyOrderShipment.ID_PROPERTY,shipment.getId()); 
		jgen.writeStringField(SupplyOrderShipment.WHO_PROPERTY,shipment.getWho()); 
		jgen.writeObjectField(SupplyOrderShipment.SHIP_TIME_PROPERTY,shipment.getShipTime()); 
		jgen.writeNumberField(SupplyOrderShipment.VERSION_PROPERTY,shipment.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeDelivery(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderDelivery delivery = consumerOrder.getDelivery();
		
		if(delivery == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplyOrderDelivery.ID_PROPERTY,delivery.getId()); 
		jgen.writeStringField(SupplyOrderDelivery.WHO_PROPERTY,delivery.getWho()); 
		jgen.writeObjectField(SupplyOrderDelivery.DELIVERY_TIME_PROPERTY,delivery.getDeliveryTime()); 
		jgen.writeNumberField(SupplyOrderDelivery.VERSION_PROPERTY,delivery.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeStore(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStore store = consumerOrder.getStore();
		
		if(store == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStore.ID_PROPERTY,store.getId()); 
		jgen.writeStringField(RetailStore.NAME_PROPERTY,store.getName()); 
		jgen.writeStringField(RetailStore.TELEPHONE_PROPERTY,store.getTelephone()); 
		jgen.writeStringField(RetailStore.OWNER_PROPERTY,store.getOwner()); 
		jgen.writeObjectField(RetailStore.FOUNDED_PROPERTY,store.getFounded()); 
		jgen.writeNumberField(RetailStore.LATITUDE_PROPERTY,store.getLatitude()); 
		jgen.writeNumberField(RetailStore.LONGITUDE_PROPERTY,store.getLongitude()); 
		jgen.writeStringField(RetailStore.DESCRIPTION_PROPERTY,store.getDescription()); 
		jgen.writeStringField(RetailStore.CURRENT_STATUS_PROPERTY,store.getCurrentStatus()); 
		jgen.writeNumberField(RetailStore.VERSION_PROPERTY,store.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeConsumerOrderLineItemList(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();
		
		if(consumerOrderLineItemList == null){
			return;//do nothing when null found for this field.
		}
		if(consumerOrderLineItemList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ConsumerOrderLineItem consumerOrderLineItem: consumerOrderLineItemList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ConsumerOrderLineItem.ID_PROPERTY,consumerOrderLineItem.getId());
			jgen.writeStringField(ConsumerOrderLineItem.SKU_ID_PROPERTY,consumerOrderLineItem.getSkuId());
			jgen.writeStringField(ConsumerOrderLineItem.SKU_NAME_PROPERTY,consumerOrderLineItem.getSkuName());
			jgen.writeNumberField(ConsumerOrderLineItem.PRICE_PROPERTY,consumerOrderLineItem.getPrice());
			jgen.writeNumberField(ConsumerOrderLineItem.QUANTITY_PROPERTY,consumerOrderLineItem.getQuantity());
			jgen.writeNumberField(ConsumerOrderLineItem.AMOUNT_PROPERTY,consumerOrderLineItem.getAmount());
			jgen.writeNumberField(ConsumerOrderLineItem.VERSION_PROPERTY,consumerOrderLineItem.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeConsumerOrderShippingGroupList(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = consumerOrder.getConsumerOrderShippingGroupList();
		
		if(consumerOrderShippingGroupList == null){
			return;//do nothing when null found for this field.
		}
		if(consumerOrderShippingGroupList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ConsumerOrderShippingGroup consumerOrderShippingGroup: consumerOrderShippingGroupList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ConsumerOrderShippingGroup.ID_PROPERTY,consumerOrderShippingGroup.getId());
			jgen.writeStringField(ConsumerOrderShippingGroup.NAME_PROPERTY,consumerOrderShippingGroup.getName());
			jgen.writeNumberField(ConsumerOrderShippingGroup.AMOUNT_PROPERTY,consumerOrderShippingGroup.getAmount());
			jgen.writeNumberField(ConsumerOrderShippingGroup.VERSION_PROPERTY,consumerOrderShippingGroup.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeConsumerOrderPaymentGroupList(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = consumerOrder.getConsumerOrderPaymentGroupList();
		
		if(consumerOrderPaymentGroupList == null){
			return;//do nothing when null found for this field.
		}
		if(consumerOrderPaymentGroupList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ConsumerOrderPaymentGroup consumerOrderPaymentGroup: consumerOrderPaymentGroupList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ConsumerOrderPaymentGroup.ID_PROPERTY,consumerOrderPaymentGroup.getId());
			jgen.writeStringField(ConsumerOrderPaymentGroup.NAME_PROPERTY,consumerOrderPaymentGroup.getName());
			jgen.writeStringField(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY,consumerOrderPaymentGroup.getCardNumber());
			jgen.writeNumberField(ConsumerOrderPaymentGroup.VERSION_PROPERTY,consumerOrderPaymentGroup.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeConsumerOrderPriceAdjustmentList(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = consumerOrder.getConsumerOrderPriceAdjustmentList();
		
		if(consumerOrderPriceAdjustmentList == null){
			return;//do nothing when null found for this field.
		}
		if(consumerOrderPriceAdjustmentList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment: consumerOrderPriceAdjustmentList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ConsumerOrderPriceAdjustment.ID_PROPERTY,consumerOrderPriceAdjustment.getId());
			jgen.writeStringField(ConsumerOrderPriceAdjustment.NAME_PROPERTY,consumerOrderPriceAdjustment.getName());
			jgen.writeNumberField(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY,consumerOrderPriceAdjustment.getAmount());
			jgen.writeStringField(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY,consumerOrderPriceAdjustment.getProvider());
			jgen.writeNumberField(ConsumerOrderPriceAdjustment.VERSION_PROPERTY,consumerOrderPriceAdjustment.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreMemberGiftCardConsumeRecordList(String fieldName, ConsumerOrder consumerOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();
		
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord: retailStoreMemberGiftCardConsumeRecordList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getId());
			jgen.writeObjectField(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getOccureTime());
			jgen.writeStringField(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getNumber());
			jgen.writeNumberField(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getAmount());
			jgen.writeNumberField(RetailStoreMemberGiftCardConsumeRecord.VERSION_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


