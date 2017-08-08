
package com.skynet.retailscm.consumerordershippinggroup;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.consumerorder.ConsumerOrder;


public class ConsumerOrderShippingGroupSerializer extends BaseJsonSerializer<ConsumerOrderShippingGroup>{

	

	@Override
	public void serialize(ConsumerOrderShippingGroup consumerOrderShippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrderShippingGroup,jgen,provider);
		
		jgen.writeStringField(ConsumerOrderShippingGroup.ID_PROPERTY,consumerOrderShippingGroup.getId());
		jgen.writeStringField(ConsumerOrderShippingGroup.NAME_PROPERTY,consumerOrderShippingGroup.getName());
		writeBizOrder(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY,consumerOrderShippingGroup,jgen,provider);
		jgen.writeNumberField(ConsumerOrderShippingGroup.AMOUNT_PROPERTY,consumerOrderShippingGroup.getAmount());
		jgen.writeNumberField(ConsumerOrderShippingGroup.VERSION_PROPERTY,consumerOrderShippingGroup.getVersion());
		
		writeEndObject(consumerOrderShippingGroup,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, ConsumerOrderShippingGroup consumerOrderShippingGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ConsumerOrder bizOrder = consumerOrderShippingGroup.getBizOrder();
		
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


