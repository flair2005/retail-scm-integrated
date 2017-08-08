
package com.skynet.retailscm.eventattendance;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;


public class EventAttendanceSerializer extends BaseJsonSerializer<EventAttendance>{

	

	@Override
	public void serialize(EventAttendance eventAttendance, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(eventAttendance,jgen,provider);
		
		jgen.writeStringField(EventAttendance.ID_PROPERTY,eventAttendance.getId());
		jgen.writeStringField(EventAttendance.NAME_PROPERTY,eventAttendance.getName());
		writePotentialCustomer(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY,eventAttendance,jgen,provider);
		writeCityEvent(EventAttendance.CITY_EVENT_PROPERTY,eventAttendance,jgen,provider);
		jgen.writeStringField(EventAttendance.DESCRIPTION_PROPERTY,eventAttendance.getDescription());
		jgen.writeNumberField(EventAttendance.VERSION_PROPERTY,eventAttendance.getVersion());
		
		writeEndObject(eventAttendance,jgen,provider);
	}
	
	protected void writePotentialCustomer(String fieldName, EventAttendance eventAttendance, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		PotentialCustomer potentialCustomer = eventAttendance.getPotentialCustomer();
		
		if(potentialCustomer == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(PotentialCustomer.ID_PROPERTY,potentialCustomer.getId()); 
		jgen.writeStringField(PotentialCustomer.NAME_PROPERTY,potentialCustomer.getName()); 
		jgen.writeStringField(PotentialCustomer.MOBILE_PROPERTY,potentialCustomer.getMobile()); 
		jgen.writeStringField(PotentialCustomer.DESCRIPTION_PROPERTY,potentialCustomer.getDescription()); 
		jgen.writeNumberField(PotentialCustomer.VERSION_PROPERTY,potentialCustomer.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeCityEvent(String fieldName, EventAttendance eventAttendance, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		CityEvent cityEvent = eventAttendance.getCityEvent();
		
		if(cityEvent == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(CityEvent.ID_PROPERTY,cityEvent.getId()); 
		jgen.writeStringField(CityEvent.NAME_PROPERTY,cityEvent.getName()); 
		jgen.writeStringField(CityEvent.MOBILE_PROPERTY,cityEvent.getMobile()); 
		jgen.writeStringField(CityEvent.DESCRIPTION_PROPERTY,cityEvent.getDescription()); 
		jgen.writeNumberField(CityEvent.VERSION_PROPERTY,cityEvent.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


