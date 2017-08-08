
package com.skynet.retailscm.consumerorderpriceadjustment;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.consumerorder.ConsumerOrder;


public class ConsumerOrderPriceAdjustmentSerializer extends BaseJsonSerializer<ConsumerOrderPriceAdjustment>{

	

	@Override
	public void serialize(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrderPriceAdjustment,jgen,provider);
		
		jgen.writeStringField(ConsumerOrderPriceAdjustment.ID_PROPERTY,consumerOrderPriceAdjustment.getId());
		jgen.writeStringField(ConsumerOrderPriceAdjustment.NAME_PROPERTY,consumerOrderPriceAdjustment.getName());
		writeBizOrder(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY,consumerOrderPriceAdjustment,jgen,provider);
		jgen.writeNumberField(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY,consumerOrderPriceAdjustment.getAmount());
		jgen.writeStringField(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY,consumerOrderPriceAdjustment.getProvider());
		jgen.writeNumberField(ConsumerOrderPriceAdjustment.VERSION_PROPERTY,consumerOrderPriceAdjustment.getVersion());
		
		writeEndObject(consumerOrderPriceAdjustment,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ConsumerOrder bizOrder = consumerOrderPriceAdjustment.getBizOrder();
		
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


