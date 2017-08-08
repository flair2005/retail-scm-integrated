
package com.skynet.retailscm.transporttruck;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttask.TransportTask;


public class TransportTruckSerializer extends BaseJsonSerializer<TransportTruck>{

	

	@Override
	public void serialize(TransportTruck transportTruck, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(transportTruck,jgen,provider);
		
		jgen.writeStringField(TransportTruck.ID_PROPERTY,transportTruck.getId());
		jgen.writeStringField(TransportTruck.NAME_PROPERTY,transportTruck.getName());
		jgen.writeStringField(TransportTruck.PLATE_NUMBER_PROPERTY,transportTruck.getPlateNumber());
		jgen.writeStringField(TransportTruck.CONTACT_NUMBER_PROPERTY,transportTruck.getContactNumber());
		jgen.writeStringField(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY,transportTruck.getVehicleLicenseNumber());
		jgen.writeStringField(TransportTruck.ENGINE_NUMBER_PROPERTY,transportTruck.getEngineNumber());
		jgen.writeObjectField(TransportTruck.MAKE_DATE_PROPERTY,transportTruck.getMakeDate());
		jgen.writeStringField(TransportTruck.MILEAGE_PROPERTY,transportTruck.getMileage());
		jgen.writeStringField(TransportTruck.BODY_COLOR_PROPERTY,transportTruck.getBodyColor());
		writeOwner(TransportTruck.OWNER_PROPERTY,transportTruck,jgen,provider);
		jgen.writeNumberField(TransportTruck.VERSION_PROPERTY,transportTruck.getVersion());
		writeTransportTaskList(TransportTruck.TRANSPORT_TASK_LIST,transportTruck,jgen,provider);
		
		writeEndObject(transportTruck,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, TransportTruck transportTruck, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TransportFleet owner = transportTruck.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(TransportFleet.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(TransportFleet.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(TransportFleet.CONTACT_NUMBER_PROPERTY,owner.getContactNumber()); 
		jgen.writeNumberField(TransportFleet.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeTransportTaskList(String fieldName, TransportTruck transportTruck, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TransportTask> transportTaskList = transportTruck.getTransportTaskList();
		
		if(transportTaskList == null){
			return;//do nothing when null found for this field.
		}
		if(transportTaskList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(TransportTask transportTask: transportTaskList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(TransportTask.ID_PROPERTY,transportTask.getId());
			jgen.writeStringField(TransportTask.NAME_PROPERTY,transportTask.getName());
			jgen.writeStringField(TransportTask.START_PROPERTY,transportTask.getStart());
			jgen.writeObjectField(TransportTask.BEGIN_TIME_PROPERTY,transportTask.getBeginTime());
			jgen.writeNumberField(TransportTask.LATITUDE_PROPERTY,transportTask.getLatitude());
			jgen.writeNumberField(TransportTask.LONGITUDE_PROPERTY,transportTask.getLongitude());
			jgen.writeNumberField(TransportTask.VERSION_PROPERTY,transportTask.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


