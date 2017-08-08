
package com.skynet.retailscm.consumerorderpaymentgroup;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.consumerorder.ConsumerOrder;


public class ConsumerOrderPaymentGroupSerializer extends BaseJsonSerializer<ConsumerOrderPaymentGroup>{

	

	@Override
	public void serialize(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrderPaymentGroup,jgen,provider);
		
		jgen.writeStringField(ConsumerOrderPaymentGroup.ID_PROPERTY,consumerOrderPaymentGroup.getId());
		jgen.writeStringField(ConsumerOrderPaymentGroup.NAME_PROPERTY,consumerOrderPaymentGroup.getName());
		writeBizOrder(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY,consumerOrderPaymentGroup,jgen,provider);
		jgen.writeStringField(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY,consumerOrderPaymentGroup.getCardNumber());
		jgen.writeNumberField(ConsumerOrderPaymentGroup.VERSION_PROPERTY,consumerOrderPaymentGroup.getVersion());
		
		writeEndObject(consumerOrderPaymentGroup,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ConsumerOrder bizOrder = consumerOrderPaymentGroup.getBizOrder();
		
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


