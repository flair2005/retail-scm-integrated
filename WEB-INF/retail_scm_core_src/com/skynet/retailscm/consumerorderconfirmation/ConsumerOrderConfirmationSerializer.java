
package com.skynet.retailscm.consumerorderconfirmation;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerorderconfirmation.ConsumerOrderConfirmation;
import com.skynet.retailscm.BaseJsonSerializer;



public class ConsumerOrderConfirmationSerializer extends BaseJsonSerializer<ConsumerOrderConfirmation>{

	

	@Override
	public void serialize(ConsumerOrderConfirmation consumerOrderConfirmation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrderConfirmation,jgen,provider);
		
		jgen.writeStringField(ConsumerOrderConfirmation.ID_PROPERTY,consumerOrderConfirmation.getId());
		jgen.writeStringField(ConsumerOrderConfirmation.WHO_PROPERTY,consumerOrderConfirmation.getWho());
		jgen.writeObjectField(ConsumerOrderConfirmation.CONFIRM_TIME_PROPERTY,consumerOrderConfirmation.getConfirmTime());
		jgen.writeNumberField(ConsumerOrderConfirmation.VERSION_PROPERTY,consumerOrderConfirmation.getVersion());
		
		writeEndObject(consumerOrderConfirmation,jgen,provider);
	}
	
	
}


