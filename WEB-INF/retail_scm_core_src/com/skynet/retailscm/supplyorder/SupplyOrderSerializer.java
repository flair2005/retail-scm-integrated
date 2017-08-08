
package com.skynet.retailscm.supplyorder;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.skynet.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;


public class SupplyOrderSerializer extends BaseJsonSerializer<SupplyOrder>{

	

	@Override
	public void serialize(SupplyOrder supplyOrder, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(supplyOrder,jgen,provider);
		
		jgen.writeStringField(SupplyOrder.ID_PROPERTY,supplyOrder.getId());
		writeBuyer(SupplyOrder.BUYER_PROPERTY,supplyOrder,jgen,provider);
		writeSeller(SupplyOrder.SELLER_PROPERTY,supplyOrder,jgen,provider);
		jgen.writeStringField(SupplyOrder.TITLE_PROPERTY,supplyOrder.getTitle());
		jgen.writeNumberField(SupplyOrder.TOTAL_AMOUNT_PROPERTY,supplyOrder.getTotalAmount());
		writeConfirmation(SupplyOrder.CONFIRMATION_PROPERTY,supplyOrder,jgen,provider);
		writeApproval(SupplyOrder.APPROVAL_PROPERTY,supplyOrder,jgen,provider);
		writeProcessing(SupplyOrder.PROCESSING_PROPERTY,supplyOrder,jgen,provider);
		writePicking(SupplyOrder.PICKING_PROPERTY,supplyOrder,jgen,provider);
		writeShipment(SupplyOrder.SHIPMENT_PROPERTY,supplyOrder,jgen,provider);
		writeDelivery(SupplyOrder.DELIVERY_PROPERTY,supplyOrder,jgen,provider);
		jgen.writeStringField(SupplyOrder.CURRENT_STATUS_PROPERTY,supplyOrder.getCurrentStatus());
		jgen.writeNumberField(SupplyOrder.VERSION_PROPERTY,supplyOrder.getVersion());
		writeSupplyOrderLineItemList(SupplyOrder.SUPPLY_ORDER_LINE_ITEM_LIST,supplyOrder,jgen,provider);
		writeSupplyOrderShippingGroupList(SupplyOrder.SUPPLY_ORDER_SHIPPING_GROUP_LIST,supplyOrder,jgen,provider);
		writeSupplyOrderPaymentGroupList(SupplyOrder.SUPPLY_ORDER_PAYMENT_GROUP_LIST,supplyOrder,jgen,provider);
		writeGoodsList(SupplyOrder.GOODS_LIST,supplyOrder,jgen,provider);
		
		writeEndObject(supplyOrder,jgen,provider);
	}
	
	protected void writeBuyer(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter buyer = supplyOrder.getBuyer();
		
		if(buyer == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,buyer.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,buyer.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,buyer.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,buyer.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,buyer.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,buyer.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,buyer.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,buyer.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,buyer.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,buyer.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeSeller(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		GoodsSupplier seller = supplyOrder.getSeller();
		
		if(seller == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(GoodsSupplier.ID_PROPERTY,seller.getId()); 
		jgen.writeStringField(GoodsSupplier.NAME_PROPERTY,seller.getName()); 
		jgen.writeStringField(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY,seller.getSupplyProduct()); 
		jgen.writeStringField(GoodsSupplier.CONTACT_NUMBER_PROPERTY,seller.getContactNumber()); 
		jgen.writeStringField(GoodsSupplier.DESCRIPTION_PROPERTY,seller.getDescription()); 
		jgen.writeNumberField(GoodsSupplier.VERSION_PROPERTY,seller.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeConfirmation(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderConfirmation confirmation = supplyOrder.getConfirmation();
		
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
	
	protected void writeApproval(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderApproval approval = supplyOrder.getApproval();
		
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
	
	protected void writeProcessing(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderProcessing processing = supplyOrder.getProcessing();
		
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
	
	protected void writePicking(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderPicking picking = supplyOrder.getPicking();
		
		if(picking == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplyOrderPicking.ID_PROPERTY,picking.getId()); 
		jgen.writeStringField(SupplyOrderPicking.WHO_PROPERTY,picking.getWho()); 
		jgen.writeObjectField(SupplyOrderPicking.PROCESS_TIME_PROPERTY,picking.getProcessTime()); 
		jgen.writeNumberField(SupplyOrderPicking.VERSION_PROPERTY,picking.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeShipment(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderShipment shipment = supplyOrder.getShipment();
		
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
	
	protected void writeDelivery(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrderDelivery delivery = supplyOrder.getDelivery();
		
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
	
	protected void writeSupplyOrderLineItemList(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();
		
		if(supplyOrderLineItemList == null){
			return;//do nothing when null found for this field.
		}
		if(supplyOrderLineItemList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SupplyOrderLineItem supplyOrderLineItem: supplyOrderLineItemList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SupplyOrderLineItem.ID_PROPERTY,supplyOrderLineItem.getId());
			jgen.writeStringField(SupplyOrderLineItem.SKU_ID_PROPERTY,supplyOrderLineItem.getSkuId());
			jgen.writeStringField(SupplyOrderLineItem.SKU_NAME_PROPERTY,supplyOrderLineItem.getSkuName());
			jgen.writeNumberField(SupplyOrderLineItem.AMOUNT_PROPERTY,supplyOrderLineItem.getAmount());
			jgen.writeNumberField(SupplyOrderLineItem.QUANTITY_PROPERTY,supplyOrderLineItem.getQuantity());
			jgen.writeStringField(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY,supplyOrderLineItem.getUnitOfMeasurement());
			jgen.writeNumberField(SupplyOrderLineItem.VERSION_PROPERTY,supplyOrderLineItem.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeSupplyOrderShippingGroupList(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SupplyOrderShippingGroup> supplyOrderShippingGroupList = supplyOrder.getSupplyOrderShippingGroupList();
		
		if(supplyOrderShippingGroupList == null){
			return;//do nothing when null found for this field.
		}
		if(supplyOrderShippingGroupList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SupplyOrderShippingGroup supplyOrderShippingGroup: supplyOrderShippingGroupList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SupplyOrderShippingGroup.ID_PROPERTY,supplyOrderShippingGroup.getId());
			jgen.writeStringField(SupplyOrderShippingGroup.NAME_PROPERTY,supplyOrderShippingGroup.getName());
			jgen.writeNumberField(SupplyOrderShippingGroup.AMOUNT_PROPERTY,supplyOrderShippingGroup.getAmount());
			jgen.writeNumberField(SupplyOrderShippingGroup.VERSION_PROPERTY,supplyOrderShippingGroup.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeSupplyOrderPaymentGroupList(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = supplyOrder.getSupplyOrderPaymentGroupList();
		
		if(supplyOrderPaymentGroupList == null){
			return;//do nothing when null found for this field.
		}
		if(supplyOrderPaymentGroupList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup: supplyOrderPaymentGroupList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SupplyOrderPaymentGroup.ID_PROPERTY,supplyOrderPaymentGroup.getId());
			jgen.writeStringField(SupplyOrderPaymentGroup.NAME_PROPERTY,supplyOrderPaymentGroup.getName());
			jgen.writeStringField(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY,supplyOrderPaymentGroup.getCardNumber());
			jgen.writeNumberField(SupplyOrderPaymentGroup.VERSION_PROPERTY,supplyOrderPaymentGroup.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeGoodsList(String fieldName, SupplyOrder supplyOrder, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = supplyOrder.getGoodsList();
		
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


