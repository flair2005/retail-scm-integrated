
package com.skynet.retailscm.view;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.view.View;
import com.skynet.retailscm.BaseJsonSerializer;



public class ViewSerializer extends BaseJsonSerializer<View>{

	

	@Override
	public void serialize(View view, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(view,jgen,provider);
		
		jgen.writeStringField(View.ID_PROPERTY,view.getId());
		jgen.writeStringField(View.WHO_PROPERTY,view.getWho());
		jgen.writeStringField(View.ASSESSMENT_PROPERTY,view.getAssessment());
		jgen.writeObjectField(View.INTERVIEW_TIME_PROPERTY,view.getInterviewTime());
		jgen.writeNumberField(View.VERSION_PROPERTY,view.getVersion());
		
		writeEndObject(view,jgen,provider);
	}
	
	
}


