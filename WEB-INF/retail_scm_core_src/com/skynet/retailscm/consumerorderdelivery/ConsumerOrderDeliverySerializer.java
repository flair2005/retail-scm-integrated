
package com.skynet.retailscm.consumerorderdelivery;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerorderdelivery.ConsumerOrderDelivery;
import com.skynet.retailscm.BaseJsonSerializer;



public class ConsumerOrderDeliverySerializer extends BaseJsonSerializer<ConsumerOrderDelivery>{

	

	@Override
	public void serialize(ConsumerOrderDelivery consumerOrderDelivery, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrderDelivery,jgen,provider);
		
		jgen.writeStringField(ConsumerOrderDelivery.ID_PROPERTY,consumerOrderDelivery.getId());
		jgen.writeStringField(ConsumerOrderDelivery.WHO_PROPERTY,consumerOrderDelivery.getWho());
		jgen.writeObjectField(ConsumerOrderDelivery.DELIVERY_TIME_PROPERTY,consumerOrderDelivery.getDeliveryTime());
		jgen.writeNumberField(ConsumerOrderDelivery.VERSION_PROPERTY,consumerOrderDelivery.getVersion());
		
		writeEndObject(consumerOrderDelivery,jgen,provider);
	}
	
	
}


