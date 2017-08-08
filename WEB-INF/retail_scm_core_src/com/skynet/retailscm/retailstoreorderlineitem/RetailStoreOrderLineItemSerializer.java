
package com.skynet.retailscm.retailstoreorderlineitem;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


public class RetailStoreOrderLineItemSerializer extends BaseJsonSerializer<RetailStoreOrderLineItem>{

	

	@Override
	public void serialize(RetailStoreOrderLineItem retailStoreOrderLineItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrderLineItem,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrderLineItem.ID_PROPERTY,retailStoreOrderLineItem.getId());
		writeBizOrder(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY,retailStoreOrderLineItem,jgen,provider);
		jgen.writeStringField(RetailStoreOrderLineItem.SKU_ID_PROPERTY,retailStoreOrderLineItem.getSkuId());
		jgen.writeStringField(RetailStoreOrderLineItem.SKU_NAME_PROPERTY,retailStoreOrderLineItem.getSkuName());
		jgen.writeNumberField(RetailStoreOrderLineItem.AMOUNT_PROPERTY,retailStoreOrderLineItem.getAmount());
		jgen.writeNumberField(RetailStoreOrderLineItem.QUANTITY_PROPERTY,retailStoreOrderLineItem.getQuantity());
		jgen.writeStringField(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY,retailStoreOrderLineItem.getUnitOfMeasurement());
		jgen.writeNumberField(RetailStoreOrderLineItem.VERSION_PROPERTY,retailStoreOrderLineItem.getVersion());
		
		writeEndObject(retailStoreOrderLineItem,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, RetailStoreOrderLineItem retailStoreOrderLineItem, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrder bizOrder = retailStoreOrderLineItem.getBizOrder();
		
		if(bizOrder == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOrder.ID_PROPERTY,bizOrder.getId()); 
		jgen.writeStringField(RetailStoreOrder.TITLE_PROPERTY,bizOrder.getTitle()); 
		jgen.writeNumberField(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY,bizOrder.getTotalAmount()); 
		jgen.writeStringField(RetailStoreOrder.CURRENT_STATUS_PROPERTY,bizOrder.getCurrentStatus()); 
		jgen.writeNumberField(RetailStoreOrder.VERSION_PROPERTY,bizOrder.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


