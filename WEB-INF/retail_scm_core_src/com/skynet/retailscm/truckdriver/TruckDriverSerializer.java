
package com.skynet.retailscm.truckdriver;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.truckdriver.TruckDriver;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttask.TransportTask;


public class TruckDriverSerializer extends BaseJsonSerializer<TruckDriver>{

	

	@Override
	public void serialize(TruckDriver truckDriver, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(truckDriver,jgen,provider);
		
		jgen.writeStringField(TruckDriver.ID_PROPERTY,truckDriver.getId());
		jgen.writeStringField(TruckDriver.NAME_PROPERTY,truckDriver.getName());
		jgen.writeStringField(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY,truckDriver.getDriverLicenseNumber());
		jgen.writeStringField(TruckDriver.CONTACT_NUMBER_PROPERTY,truckDriver.getContactNumber());
		writeBelongsTo(TruckDriver.BELONGS_TO_PROPERTY,truckDriver,jgen,provider);
		jgen.writeNumberField(TruckDriver.VERSION_PROPERTY,truckDriver.getVersion());
		writeTransportTaskList(TruckDriver.TRANSPORT_TASK_LIST,truckDriver,jgen,provider);
		
		writeEndObject(truckDriver,jgen,provider);
	}
	
	protected void writeBelongsTo(String fieldName, TruckDriver truckDriver, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TransportFleet belongsTo = truckDriver.getBelongsTo();
		
		if(belongsTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(TransportFleet.ID_PROPERTY,belongsTo.getId()); 
		jgen.writeStringField(TransportFleet.NAME_PROPERTY,belongsTo.getName()); 
		jgen.writeStringField(TransportFleet.CONTACT_NUMBER_PROPERTY,belongsTo.getContactNumber()); 
		jgen.writeNumberField(TransportFleet.VERSION_PROPERTY,belongsTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeTransportTaskList(String fieldName, TruckDriver truckDriver, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		
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


