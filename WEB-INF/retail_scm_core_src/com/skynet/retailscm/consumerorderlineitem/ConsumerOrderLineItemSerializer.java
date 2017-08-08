
package com.skynet.retailscm.consumerorderlineitem;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.consumerorder.ConsumerOrder;


public class ConsumerOrderLineItemSerializer extends BaseJsonSerializer<ConsumerOrderLineItem>{

	

	@Override
	public void serialize(ConsumerOrderLineItem consumerOrderLineItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrderLineItem,jgen,provider);
		
		jgen.writeStringField(ConsumerOrderLineItem.ID_PROPERTY,consumerOrderLineItem.getId());
		writeBizOrder(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY,consumerOrderLineItem,jgen,provider);
		jgen.writeStringField(ConsumerOrderLineItem.SKU_ID_PROPERTY,consumerOrderLineItem.getSkuId());
		jgen.writeStringField(ConsumerOrderLineItem.SKU_NAME_PROPERTY,consumerOrderLineItem.getSkuName());
		jgen.writeNumberField(ConsumerOrderLineItem.PRICE_PROPERTY,consumerOrderLineItem.getPrice());
		jgen.writeNumberField(ConsumerOrderLineItem.QUANTITY_PROPERTY,consumerOrderLineItem.getQuantity());
		jgen.writeNumberField(ConsumerOrderLineItem.AMOUNT_PROPERTY,consumerOrderLineItem.getAmount());
		jgen.writeNumberField(ConsumerOrderLineItem.VERSION_PROPERTY,consumerOrderLineItem.getVersion());
		
		writeEndObject(consumerOrderLineItem,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, ConsumerOrderLineItem consumerOrderLineItem, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ConsumerOrder bizOrder = consumerOrderLineItem.getBizOrder();
		
		if(bizOrder == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(ConsumerOrder.ID_PROPERTY,bizOrder.getId()); 
		jgen.writeStringField(ConsumerOrder.TITLE_PROPERTY,bizOrder.getTitle()); 
		jgen.writeStringField(ConsumerOrder.CURRENT_STATUS_PROPERTY,bizOrder.getCurrentStatus()); 
		jgen.writeNumberField(ConsumerOrder.VERSION_PROPERTY,bizOrder.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


