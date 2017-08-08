
package com.skynet.retailscm.consumerordershipment;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerordershipment.ConsumerOrderShipment;
import com.skynet.retailscm.BaseJsonSerializer;



public class ConsumerOrderShipmentSerializer extends BaseJsonSerializer<ConsumerOrderShipment>{

	

	@Override
	public void serialize(ConsumerOrderShipment consumerOrderShipment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrderShipment,jgen,provider);
		
		jgen.writeStringField(ConsumerOrderShipment.ID_PROPERTY,consumerOrderShipment.getId());
		jgen.writeStringField(ConsumerOrderShipment.WHO_PROPERTY,consumerOrderShipment.getWho());
		jgen.writeObjectField(ConsumerOrderShipment.SHIP_TIME_PROPERTY,consumerOrderShipment.getShipTime());
		jgen.writeNumberField(ConsumerOrderShipment.VERSION_PROPERTY,consumerOrderShipment.getVersion());
		
		writeEndObject(consumerOrderShipment,jgen,provider);
	}
	
	
}


