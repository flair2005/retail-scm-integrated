
package com.skynet.retailscm.potentialcustomer;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.citypartner.CityPartner;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;


public class PotentialCustomerSerializer extends BaseJsonSerializer<PotentialCustomer>{

	

	@Override
	public void serialize(PotentialCustomer potentialCustomer, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(potentialCustomer,jgen,provider);
		
		jgen.writeStringField(PotentialCustomer.ID_PROPERTY,potentialCustomer.getId());
		jgen.writeStringField(PotentialCustomer.NAME_PROPERTY,potentialCustomer.getName());
		jgen.writeStringField(PotentialCustomer.MOBILE_PROPERTY,potentialCustomer.getMobile());
		writeCityServiceCenter(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY,potentialCustomer,jgen,provider);
		writeCityPartner(PotentialCustomer.CITY_PARTNER_PROPERTY,potentialCustomer,jgen,provider);
		jgen.writeStringField(PotentialCustomer.DESCRIPTION_PROPERTY,potentialCustomer.getDescription());
		jgen.writeNumberField(PotentialCustomer.VERSION_PROPERTY,potentialCustomer.getVersion());
		writePotentialCustomerContactPersonList(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST,potentialCustomer,jgen,provider);
		writePotentialCustomerContactList(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_LIST,potentialCustomer,jgen,provider);
		writeEventAttendanceList(PotentialCustomer.EVENT_ATTENDANCE_LIST,potentialCustomer,jgen,provider);
		
		writeEndObject(potentialCustomer,jgen,provider);
	}
	
	protected void writeCityServiceCenter(String fieldName, PotentialCustomer potentialCustomer, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCityServiceCenter cityServiceCenter = potentialCustomer.getCityServiceCenter();
		
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
	
	protected void writeCityPartner(String fieldName, PotentialCustomer potentialCustomer, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		CityPartner cityPartner = potentialCustomer.getCityPartner();
		
		if(cityPartner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(CityPartner.ID_PROPERTY,cityPartner.getId()); 
		jgen.writeStringField(CityPartner.NAME_PROPERTY,cityPartner.getName()); 
		jgen.writeStringField(CityPartner.MOBILE_PROPERTY,cityPartner.getMobile()); 
		jgen.writeStringField(CityPartner.DESCRIPTION_PROPERTY,cityPartner.getDescription()); 
		jgen.writeNumberField(CityPartner.VERSION_PROPERTY,cityPartner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writePotentialCustomerContactPersonList(String fieldName, PotentialCustomer potentialCustomer, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PotentialCustomerContactPerson> potentialCustomerContactPersonList = potentialCustomer.getPotentialCustomerContactPersonList();
		
		if(potentialCustomerContactPersonList == null){
			return;//do nothing when null found for this field.
		}
		if(potentialCustomerContactPersonList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(PotentialCustomerContactPerson potentialCustomerContactPerson: potentialCustomerContactPersonList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(PotentialCustomerContactPerson.ID_PROPERTY,potentialCustomerContactPerson.getId());
			jgen.writeStringField(PotentialCustomerContactPerson.NAME_PROPERTY,potentialCustomerContactPerson.getName());
			jgen.writeStringField(PotentialCustomerContactPerson.MOBILE_PROPERTY,potentialCustomerContactPerson.getMobile());
			jgen.writeStringField(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY,potentialCustomerContactPerson.getDescription());
			jgen.writeNumberField(PotentialCustomerContactPerson.VERSION_PROPERTY,potentialCustomerContactPerson.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writePotentialCustomerContactList(String fieldName, PotentialCustomer potentialCustomer, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();
		
		if(potentialCustomerContactList == null){
			return;//do nothing when null found for this field.
		}
		if(potentialCustomerContactList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(PotentialCustomerContact potentialCustomerContact: potentialCustomerContactList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(PotentialCustomerContact.ID_PROPERTY,potentialCustomerContact.getId());
			jgen.writeStringField(PotentialCustomerContact.NAME_PROPERTY,potentialCustomerContact.getName());
			jgen.writeObjectField(PotentialCustomerContact.CONTACT_DATE_PROPERTY,potentialCustomerContact.getContactDate());
			jgen.writeStringField(PotentialCustomerContact.CONTACT_METHOD_PROPERTY,potentialCustomerContact.getContactMethod());
			jgen.writeStringField(PotentialCustomerContact.DESCRIPTION_PROPERTY,potentialCustomerContact.getDescription());
			jgen.writeNumberField(PotentialCustomerContact.VERSION_PROPERTY,potentialCustomerContact.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEventAttendanceList(String fieldName, PotentialCustomer potentialCustomer, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();
		
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


