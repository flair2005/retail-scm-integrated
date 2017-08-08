
package com.skynet.retailscm.transporttask;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttasktrack.TransportTaskTrack;
import com.skynet.retailscm.truckdriver.TruckDriver;


public class TransportTaskSerializer extends BaseJsonSerializer<TransportTask>{

	

	@Override
	public void serialize(TransportTask transportTask, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(transportTask,jgen,provider);
		
		jgen.writeStringField(TransportTask.ID_PROPERTY,transportTask.getId());
		jgen.writeStringField(TransportTask.NAME_PROPERTY,transportTask.getName());
		jgen.writeStringField(TransportTask.START_PROPERTY,transportTask.getStart());
		jgen.writeObjectField(TransportTask.BEGIN_TIME_PROPERTY,transportTask.getBeginTime());
		writeEnd(TransportTask.END_PROPERTY,transportTask,jgen,provider);
		writeDriver(TransportTask.DRIVER_PROPERTY,transportTask,jgen,provider);
		writeTruck(TransportTask.TRUCK_PROPERTY,transportTask,jgen,provider);
		writeBelongsTo(TransportTask.BELONGS_TO_PROPERTY,transportTask,jgen,provider);
		jgen.writeNumberField(TransportTask.LATITUDE_PROPERTY,transportTask.getLatitude());
		jgen.writeNumberField(TransportTask.LONGITUDE_PROPERTY,transportTask.getLongitude());
		jgen.writeNumberField(TransportTask.VERSION_PROPERTY,transportTask.getVersion());
		writeGoodsList(TransportTask.GOODS_LIST,transportTask,jgen,provider);
		writeTransportTaskTrackList(TransportTask.TRANSPORT_TASK_TRACK_LIST,transportTask,jgen,provider);
		
		writeEndObject(transportTask,jgen,provider);
	}
	
	protected void writeEnd(String fieldName, TransportTask transportTask, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStore end = transportTask.getEnd();
		
		if(end == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStore.ID_PROPERTY,end.getId()); 
		jgen.writeStringField(RetailStore.NAME_PROPERTY,end.getName()); 
		jgen.writeStringField(RetailStore.TELEPHONE_PROPERTY,end.getTelephone()); 
		jgen.writeStringField(RetailStore.OWNER_PROPERTY,end.getOwner()); 
		jgen.writeObjectField(RetailStore.FOUNDED_PROPERTY,end.getFounded()); 
		jgen.writeNumberField(RetailStore.LATITUDE_PROPERTY,end.getLatitude()); 
		jgen.writeNumberField(RetailStore.LONGITUDE_PROPERTY,end.getLongitude()); 
		jgen.writeStringField(RetailStore.DESCRIPTION_PROPERTY,end.getDescription()); 
		jgen.writeStringField(RetailStore.CURRENT_STATUS_PROPERTY,end.getCurrentStatus()); 
		jgen.writeNumberField(RetailStore.VERSION_PROPERTY,end.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeDriver(String fieldName, TransportTask transportTask, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TruckDriver driver = transportTask.getDriver();
		
		if(driver == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(TruckDriver.ID_PROPERTY,driver.getId()); 
		jgen.writeStringField(TruckDriver.NAME_PROPERTY,driver.getName()); 
		jgen.writeStringField(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY,driver.getDriverLicenseNumber()); 
		jgen.writeStringField(TruckDriver.CONTACT_NUMBER_PROPERTY,driver.getContactNumber()); 
		jgen.writeNumberField(TruckDriver.VERSION_PROPERTY,driver.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeTruck(String fieldName, TransportTask transportTask, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TransportTruck truck = transportTask.getTruck();
		
		if(truck == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(TransportTruck.ID_PROPERTY,truck.getId()); 
		jgen.writeStringField(TransportTruck.NAME_PROPERTY,truck.getName()); 
		jgen.writeStringField(TransportTruck.PLATE_NUMBER_PROPERTY,truck.getPlateNumber()); 
		jgen.writeStringField(TransportTruck.CONTACT_NUMBER_PROPERTY,truck.getContactNumber()); 
		jgen.writeStringField(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY,truck.getVehicleLicenseNumber()); 
		jgen.writeStringField(TransportTruck.ENGINE_NUMBER_PROPERTY,truck.getEngineNumber()); 
		jgen.writeObjectField(TransportTruck.MAKE_DATE_PROPERTY,truck.getMakeDate()); 
		jgen.writeStringField(TransportTruck.MILEAGE_PROPERTY,truck.getMileage()); 
		jgen.writeStringField(TransportTruck.BODY_COLOR_PROPERTY,truck.getBodyColor()); 
		jgen.writeNumberField(TransportTruck.VERSION_PROPERTY,truck.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeBelongsTo(String fieldName, TransportTask transportTask, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TransportFleet belongsTo = transportTask.getBelongsTo();
		
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
	
	protected void writeGoodsList(String fieldName, TransportTask transportTask, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = transportTask.getGoodsList();
		
		if(goodsList == null){
			return;//do nothing when null found for this field.
		}
		if(goodsList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Goods goods: goodsList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Goods.ID_PROPERTY,goods.getId());
			jgen.writeStringField(Goods.NAME_PROPERTY,goods.getName());
			jgen.writeStringField(Goods.RFID_PROPERTY,goods.getRfid());
			jgen.writeStringField(Goods.UOM_PROPERTY,goods.getUom());
			jgen.writeNumberField(Goods.MAX_PACKAGE_PROPERTY,goods.getMaxPackage());
			jgen.writeObjectField(Goods.EXPIRE_TIME_PROPERTY,goods.getExpireTime());
			jgen.writeStringField(Goods.CURRENT_STATUS_PROPERTY,goods.getCurrentStatus());
			jgen.writeNumberField(Goods.VERSION_PROPERTY,goods.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeTransportTaskTrackList(String fieldName, TransportTask transportTask, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		
		if(transportTaskTrackList == null){
			return;//do nothing when null found for this field.
		}
		if(transportTaskTrackList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(TransportTaskTrack transportTaskTrack: transportTaskTrackList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(TransportTaskTrack.ID_PROPERTY,transportTaskTrack.getId());
			jgen.writeObjectField(TransportTaskTrack.TRACK_TIME_PROPERTY,transportTaskTrack.getTrackTime());
			jgen.writeNumberField(TransportTaskTrack.LATITUDE_PROPERTY,transportTaskTrack.getLatitude());
			jgen.writeNumberField(TransportTaskTrack.LONGITUDE_PROPERTY,transportTaskTrack.getLongitude());
			jgen.writeNumberField(TransportTaskTrack.VERSION_PROPERTY,transportTaskTrack.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


