
package com.skynet.retailscm.retailstoreorder;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.skynet.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.skynet.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;


public class RetailStoreOrderSerializer extends BaseJsonSerializer<RetailStoreOrder>{

	

	@Override
	public void serialize(RetailStoreOrder retailStoreOrder, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrder,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrder.ID_PROPERTY,retailStoreOrder.getId());
		writeBuyer(RetailStoreOrder.BUYER_PROPERTY,retailStoreOrder,jgen,provider);
		writeSeller(RetailStoreOrder.SELLER_PROPERTY,retailStoreOrder,jgen,provider);
		jgen.writeStringField(RetailStoreOrder.TITLE_PROPERTY,retailStoreOrder.getTitle());
		jgen.writeNumberField(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY,retailStoreOrder.getTotalAmount());
		writeConfirmation(RetailStoreOrder.CONFIRMATION_PROPERTY,retailStoreOrder,jgen,provider);
		writeApproval(RetailStoreOrder.APPROVAL_PROPERTY,retailStoreOrder,jgen,provider);
		writeProcessing(RetailStoreOrder.PROCESSING_PROPERTY,retailStoreOrder,jgen,provider);
		writePicking(RetailStoreOrder.PICKING_PROPERTY,retailStoreOrder,jgen,provider);
		writeShipment(RetailStoreOrder.SHIPMENT_PROPERTY,retailStoreOrder,jgen,provider);
		writeDelivery(RetailStoreOrder.DELIVERY_PROPERTY,retailStoreOrder,jgen,provider);
		jgen.writeStringField(RetailStoreOrder.CURRENT_STATUS_PROPERTY,retailStoreOrder.getCurrentStatus());
		jgen.writeNumberField(RetailStoreOrder.VERSION_PROPERTY,retailStoreOrder.getVersion());
		writeRetailStoreOrderLineItemList(RetailStoreOrder.RETAIL_STORE_ORDER_LINE_ITEM_LIST,retailStoreOrder,jgen,provider);
		writeRetailStoreOrderShippingGroupList(RetailStoreOrder.RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST,retailStoreOrder,jgen,provider);
		writeRetailStoreOrderPaymentGroupList(RetailStoreOrder.RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST,retailStoreOrder,jgen,provider);
		writeGoodsList(RetailStoreOrder.GOODS_LIST,retailStoreOrder,jgen,provider);
		
		writeEndObject(retailStoreOrder,jgen,provider);
	}
	
	protected void writeBuyer(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStore buyer = retailStoreOrder.getBuyer();
		
		if(buyer == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStore.ID_PROPERTY,buyer.getId()); 
		jgen.writeStringField(RetailStore.NAME_PROPERTY,buyer.getName()); 
		jgen.writeStringField(RetailStore.TELEPHONE_PROPERTY,buyer.getTelephone()); 
		jgen.writeStringField(RetailStore.OWNER_PROPERTY,buyer.getOwner()); 
		jgen.writeObjectField(RetailStore.FOUNDED_PROPERTY,buyer.getFounded()); 
		jgen.writeNumberField(RetailStore.LATITUDE_PROPERTY,buyer.getLatitude()); 
		jgen.writeNumberField(RetailStore.LONGITUDE_PROPERTY,buyer.getLongitude()); 
		jgen.writeStringField(RetailStore.DESCRIPTION_PROPERTY,buyer.getDescription()); 
		jgen.writeStringField(RetailStore.CURRENT_STATUS_PROPERTY,buyer.getCurrentStatus()); 
		jgen.writeNumberField(RetailStore.VERSION_PROPERTY,buyer.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeSeller(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter seller = retailStoreOrder.getSeller();
		
		if(seller == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,seller.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,seller.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,seller.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,seller.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,seller.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,seller.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,seller.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,seller.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,seller.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,seller.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeConfirmation(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrderConfirmation confirmation = retailStoreOrder.getConfirmation();
		
		if(confirmation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOrderConfirmation.ID_PROPERTY,confirmation.getId()); 
		jgen.writeStringField(RetailStoreOrderConfirmation.WHO_PROPERTY,confirmation.getWho()); 
		jgen.writeObjectField(RetailStoreOrderConfirmation.CONFIRM_TIME_PROPERTY,confirmation.getConfirmTime()); 
		jgen.writeNumberField(RetailStoreOrderConfirmation.VERSION_PROPERTY,confirmation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeApproval(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrderApproval approval = retailStoreOrder.getApproval();
		
		if(approval == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOrderApproval.ID_PROPERTY,approval.getId()); 
		jgen.writeStringField(RetailStoreOrderApproval.WHO_PROPERTY,approval.getWho()); 
		jgen.writeObjectField(RetailStoreOrderApproval.APPROVE_TIME_PROPERTY,approval.getApproveTime()); 
		jgen.writeNumberField(RetailStoreOrderApproval.VERSION_PROPERTY,approval.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProcessing(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrderProcessing processing = retailStoreOrder.getProcessing();
		
		if(processing == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOrderProcessing.ID_PROPERTY,processing.getId()); 
		jgen.writeStringField(RetailStoreOrderProcessing.WHO_PROPERTY,processing.getWho()); 
		jgen.writeObjectField(RetailStoreOrderProcessing.PROCESS_TIME_PROPERTY,processing.getProcessTime()); 
		jgen.writeNumberField(RetailStoreOrderProcessing.VERSION_PROPERTY,processing.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writePicking(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrderPicking picking = retailStoreOrder.getPicking();
		
		if(picking == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOrderPicking.ID_PROPERTY,picking.getId()); 
		jgen.writeStringField(RetailStoreOrderPicking.WHO_PROPERTY,picking.getWho()); 
		jgen.writeObjectField(RetailStoreOrderPicking.PROCESS_TIME_PROPERTY,picking.getProcessTime()); 
		jgen.writeNumberField(RetailStoreOrderPicking.VERSION_PROPERTY,picking.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeShipment(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrderShipment shipment = retailStoreOrder.getShipment();
		
		if(shipment == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOrderShipment.ID_PROPERTY,shipment.getId()); 
		jgen.writeStringField(RetailStoreOrderShipment.WHO_PROPERTY,shipment.getWho()); 
		jgen.writeObjectField(RetailStoreOrderShipment.SHIP_TIME_PROPERTY,shipment.getShipTime()); 
		jgen.writeNumberField(RetailStoreOrderShipment.VERSION_PROPERTY,shipment.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeDelivery(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrderDelivery delivery = retailStoreOrder.getDelivery();
		
		if(delivery == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOrderDelivery.ID_PROPERTY,delivery.getId()); 
		jgen.writeStringField(RetailStoreOrderDelivery.WHO_PROPERTY,delivery.getWho()); 
		jgen.writeObjectField(RetailStoreOrderDelivery.DELIVERY_TIME_PROPERTY,delivery.getDeliveryTime()); 
		jgen.writeNumberField(RetailStoreOrderDelivery.VERSION_PROPERTY,delivery.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeRetailStoreOrderLineItemList(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();
		
		if(retailStoreOrderLineItemList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreOrderLineItemList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreOrderLineItem retailStoreOrderLineItem: retailStoreOrderLineItemList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreOrderLineItem.ID_PROPERTY,retailStoreOrderLineItem.getId());
			jgen.writeStringField(RetailStoreOrderLineItem.SKU_ID_PROPERTY,retailStoreOrderLineItem.getSkuId());
			jgen.writeStringField(RetailStoreOrderLineItem.SKU_NAME_PROPERTY,retailStoreOrderLineItem.getSkuName());
			jgen.writeNumberField(RetailStoreOrderLineItem.AMOUNT_PROPERTY,retailStoreOrderLineItem.getAmount());
			jgen.writeNumberField(RetailStoreOrderLineItem.QUANTITY_PROPERTY,retailStoreOrderLineItem.getQuantity());
			jgen.writeStringField(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY,retailStoreOrderLineItem.getUnitOfMeasurement());
			jgen.writeNumberField(RetailStoreOrderLineItem.VERSION_PROPERTY,retailStoreOrderLineItem.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreOrderShippingGroupList(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = retailStoreOrder.getRetailStoreOrderShippingGroupList();
		
		if(retailStoreOrderShippingGroupList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreOrderShippingGroupList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup: retailStoreOrderShippingGroupList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreOrderShippingGroup.ID_PROPERTY,retailStoreOrderShippingGroup.getId());
			jgen.writeStringField(RetailStoreOrderShippingGroup.NAME_PROPERTY,retailStoreOrderShippingGroup.getName());
			jgen.writeNumberField(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY,retailStoreOrderShippingGroup.getAmount());
			jgen.writeNumberField(RetailStoreOrderShippingGroup.VERSION_PROPERTY,retailStoreOrderShippingGroup.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreOrderPaymentGroupList(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = retailStoreOrder.getRetailStoreOrderPaymentGroupList();
		
		if(retailStoreOrderPaymentGroupList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreOrderPaymentGroupList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup: retailStoreOrderPaymentGroupList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreOrderPaymentGroup.ID_PROPERTY,retailStoreOrderPaymentGroup.getId());
			jgen.writeStringField(RetailStoreOrderPaymentGroup.NAME_PROPERTY,retailStoreOrderPaymentGroup.getName());
			jgen.writeStringField(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY,retailStoreOrderPaymentGroup.getCardNumber());
			jgen.writeNumberField(RetailStoreOrderPaymentGroup.VERSION_PROPERTY,retailStoreOrderPaymentGroup.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeGoodsList(String fieldName, RetailStoreOrder retailStoreOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = retailStoreOrder.getGoodsList();
		
		if(goodsList == null){
			return;//do nothing when null found for this field.
		}
		if(goodsList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Goods goods: goodsList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Goods.ID_PROPERTY,goods.getId());
			jgen.writeStringField(Goods.NAME_PROPERTY,goods.getName());
			jgen.writeStringField(Goods.RFID_PROPERTY,goods.getRfid());
			jgen.writeStringField(Goods.UOM_PROPERTY,goods.getUom());
			jgen.writeNumberField(Goods.MAX_PACKAGE_PROPERTY,goods.getMaxPackage());
			jgen.writeObjectField(Goods.EXPIRE_TIME_PROPERTY,goods.getExpireTime());
			jgen.writeStringField(Goods.CURRENT_STATUS_PROPERTY,goods.getCurrentStatus());
			jgen.writeNumberField(Goods.VERSION_PROPERTY,goods.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


