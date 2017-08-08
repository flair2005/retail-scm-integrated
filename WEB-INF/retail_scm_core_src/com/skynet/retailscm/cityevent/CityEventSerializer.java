
package com.skynet.retailscm.cityevent;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;


public class CityEventSerializer extends BaseJsonSerializer<CityEvent>{

	

	@Override
	public void serialize(CityEvent cityEvent, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(cityEvent,jgen,provider);
		
		jgen.writeStringField(CityEvent.ID_PROPERTY,cityEvent.getId());
		jgen.writeStringField(CityEvent.NAME_PROPERTY,cityEvent.getName());
		jgen.writeStringField(CityEvent.MOBILE_PROPERTY,cityEvent.getMobile());
		writeCityServiceCenter(CityEvent.CITY_SERVICE_CENTER_PROPERTY,cityEvent,jgen,provider);
		jgen.writeStringField(CityEvent.DESCRIPTION_PROPERTY,cityEvent.getDescription());
		jgen.writeNumberField(CityEvent.VERSION_PROPERTY,cityEvent.getVersion());
		writeEventAttendanceList(CityEvent.EVENT_ATTENDANCE_LIST,cityEvent,jgen,provider);
		
		writeEndObject(cityEvent,jgen,provider);
	}
	
	protected void writeCityServiceCenter(String fieldName, CityEvent cityEvent, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCityServiceCenter cityServiceCenter = cityEvent.getCityServiceCenter();
		
		if(cityServiceCenter == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCityServiceCenter.ID_PROPERTY,cityServiceCenter.getId()); 
		jgen.writeStringField(RetailStoreCityServiceCenter.NAME_PROPERTY,cityServiceCenter.getName()); 
		jgen.writeObjectField(RetailStoreCityServiceCenter.FOUNDED_PROPERTY,cityServiceCenter.getFounded()); 
		jgen.writeNumberField(RetailStoreCityServiceCenter.VERSION_PROPERTY,cityServiceCenter.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeEventAttendanceList(String fieldName, CityEvent cityEvent, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();
		
		if(eventAttendanceList == null){
			return;//do nothing when null found for this field.
		}
		if(eventAttendanceList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EventAttendance eventAttendance: eventAttendanceList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EventAttendance.ID_PROPERTY,eventAttendance.getId());
			jgen.writeStringField(EventAttendance.NAME_PROPERTY,eventAttendance.getName());
			jgen.writeStringField(EventAttendance.DESCRIPTION_PROPERTY,eventAttendance.getDescription());
			jgen.writeNumberField(EventAttendance.VERSION_PROPERTY,eventAttendance.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


