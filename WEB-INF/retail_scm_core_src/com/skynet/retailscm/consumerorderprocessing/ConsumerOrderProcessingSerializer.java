
package com.skynet.retailscm.consumerorderprocessing;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerorderprocessing.ConsumerOrderProcessing;
import com.skynet.retailscm.BaseJsonSerializer;



public class ConsumerOrderProcessingSerializer extends BaseJsonSerializer<ConsumerOrderProcessing>{

	

	@Override
	public void serialize(ConsumerOrderProcessing consumerOrderProcessing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrderProcessing,jgen,provider);
		
		jgen.writeStringField(ConsumerOrderProcessing.ID_PROPERTY,consumerOrderProcessing.getId());
		jgen.writeStringField(ConsumerOrderProcessing.WHO_PROPERTY,consumerOrderProcessing.getWho());
		jgen.writeObjectField(ConsumerOrderProcessing.PROCESS_TIME_PROPERTY,consumerOrderProcessing.getProcessTime());
		jgen.writeNumberField(ConsumerOrderProcessing.VERSION_PROPERTY,consumerOrderProcessing.getVersion());
		
		writeEndObject(consumerOrderProcessing,jgen,provider);
	}
	
	
}


