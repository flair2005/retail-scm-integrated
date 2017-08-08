
package com.skynet.retailscm.consumerorderapproval;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.consumerorderapproval.ConsumerOrderApproval;
import com.skynet.retailscm.BaseJsonSerializer;



public class ConsumerOrderApprovalSerializer extends BaseJsonSerializer<ConsumerOrderApproval>{

	

	@Override
	public void serialize(ConsumerOrderApproval consumerOrderApproval, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(consumerOrderApproval,jgen,provider);
		
		jgen.writeStringField(ConsumerOrderApproval.ID_PROPERTY,consumerOrderApproval.getId());
		jgen.writeStringField(ConsumerOrderApproval.WHO_PROPERTY,consumerOrderApproval.getWho());
		jgen.writeObjectField(ConsumerOrderApproval.APPROVE_TIME_PROPERTY,consumerOrderApproval.getApproveTime());
		jgen.writeNumberField(ConsumerOrderApproval.VERSION_PROPERTY,consumerOrderApproval.getVersion());
		
		writeEndObject(consumerOrderApproval,jgen,provider);
	}
	
	
}


