
package com.skynet.retailscm.transporttasktrack;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.transporttasktrack.TransportTaskTrack;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.transporttask.TransportTask;


public class TransportTaskTrackSerializer extends BaseJsonSerializer<TransportTaskTrack>{

	

	@Override
	public void serialize(TransportTaskTrack transportTaskTrack, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(transportTaskTrack,jgen,provider);
		
		jgen.writeStringField(TransportTaskTrack.ID_PROPERTY,transportTaskTrack.getId());
		jgen.writeObjectField(TransportTaskTrack.TRACK_TIME_PROPERTY,transportTaskTrack.getTrackTime());
		jgen.writeNumberField(TransportTaskTrack.LATITUDE_PROPERTY,transportTaskTrack.getLatitude());
		jgen.writeNumberField(TransportTaskTrack.LONGITUDE_PROPERTY,transportTaskTrack.getLongitude());
		writeMovement(TransportTaskTrack.MOVEMENT_PROPERTY,transportTaskTrack,jgen,provider);
		jgen.writeNumberField(TransportTaskTrack.VERSION_PROPERTY,transportTaskTrack.getVersion());
		
		writeEndObject(transportTaskTrack,jgen,provider);
	}
	
	protected void writeMovement(String fieldName, TransportTaskTrack transportTaskTrack, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TransportTask movement = transportTaskTrack.getMovement();
		
		if(movement == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(TransportTask.ID_PROPERTY,movement.getId()); 
		jgen.writeStringField(TransportTask.NAME_PROPERTY,movement.getName()); 
		jgen.writeStringField(TransportTask.START_PROPERTY,movement.getStart()); 
		jgen.writeObjectField(TransportTask.BEGIN_TIME_PROPERTY,movement.getBeginTime()); 
		jgen.writeNumberField(TransportTask.LATITUDE_PROPERTY,movement.getLatitude()); 
		jgen.writeNumberField(TransportTask.LONGITUDE_PROPERTY,movement.getLongitude()); 
		jgen.writeNumberField(TransportTask.VERSION_PROPERTY,movement.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


