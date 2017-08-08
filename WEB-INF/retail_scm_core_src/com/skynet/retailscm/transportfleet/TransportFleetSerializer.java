
package com.skynet.retailscm.transportfleet;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.truckdriver.TruckDriver;


public class TransportFleetSerializer extends BaseJsonSerializer<TransportFleet>{

	

	@Override
	public void serialize(TransportFleet transportFleet, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(transportFleet,jgen,provider);
		
		jgen.writeStringField(TransportFleet.ID_PROPERTY,transportFleet.getId());
		jgen.writeStringField(TransportFleet.NAME_PROPERTY,transportFleet.getName());
		jgen.writeStringField(TransportFleet.CONTACT_NUMBER_PROPERTY,transportFleet.getContactNumber());
		writeOwner(TransportFleet.OWNER_PROPERTY,transportFleet,jgen,provider);
		jgen.writeNumberField(TransportFleet.VERSION_PROPERTY,transportFleet.getVersion());
		writeTransportTruckList(TransportFleet.TRANSPORT_TRUCK_LIST,transportFleet,jgen,provider);
		writeTruckDriverList(TransportFleet.TRUCK_DRIVER_LIST,transportFleet,jgen,provider);
		writeTransportTaskList(TransportFleet.TRANSPORT_TASK_LIST,transportFleet,jgen,provider);
		
		writeEndObject(transportFleet,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, TransportFleet transportFleet, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter owner = transportFleet.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,owner.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,owner.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,owner.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,owner.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,owner.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,owner.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,owner.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeTransportTruckList(String fieldName, TransportFleet transportFleet, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TransportTruck> transportTruckList = transportFleet.getTransportTruckList();
		
		if(transportTruckList == null){
			return;//do nothing when null found for this field.
		}
		if(transportTruckList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(TransportTruck transportTruck: transportTruckList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(TransportTruck.ID_PROPERTY,transportTruck.getId());
			jgen.writeStringField(TransportTruck.NAME_PROPERTY,transportTruck.getName());
			jgen.writeStringField(TransportTruck.PLATE_NUMBER_PROPERTY,transportTruck.getPlateNumber());
			jgen.writeStringField(TransportTruck.CONTACT_NUMBER_PROPERTY,transportTruck.getContactNumber());
			jgen.writeStringField(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY,transportTruck.getVehicleLicenseNumber());
			jgen.writeStringField(TransportTruck.ENGINE_NUMBER_PROPERTY,transportTruck.getEngineNumber());
			jgen.writeObjectField(TransportTruck.MAKE_DATE_PROPERTY,transportTruck.getMakeDate());
			jgen.writeStringField(TransportTruck.MILEAGE_PROPERTY,transportTruck.getMileage());
			jgen.writeStringField(TransportTruck.BODY_COLOR_PROPERTY,transportTruck.getBodyColor());
			jgen.writeNumberField(TransportTruck.VERSION_PROPERTY,transportTruck.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeTruckDriverList(String fieldName, TransportFleet transportFleet, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TruckDriver> truckDriverList = transportFleet.getTruckDriverList();
		
		if(truckDriverList == null){
			return;//do nothing when null found for this field.
		}
		if(truckDriverList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(TruckDriver truckDriver: truckDriverList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(TruckDriver.ID_PROPERTY,truckDriver.getId());
			jgen.writeStringField(TruckDriver.NAME_PROPERTY,truckDriver.getName());
			jgen.writeStringField(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY,truckDriver.getDriverLicenseNumber());
			jgen.writeStringField(TruckDriver.CONTACT_NUMBER_PROPERTY,truckDriver.getContactNumber());
			jgen.writeNumberField(TruckDriver.VERSION_PROPERTY,truckDriver.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeTransportTaskList(String fieldName, TransportFleet transportFleet, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		
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


