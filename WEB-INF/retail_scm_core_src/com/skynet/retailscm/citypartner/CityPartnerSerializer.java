
package com.skynet.retailscm.citypartner;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.citypartner.CityPartner;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;


public class CityPartnerSerializer extends BaseJsonSerializer<CityPartner>{

	

	@Override
	public void serialize(CityPartner cityPartner, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(cityPartner,jgen,provider);
		
		jgen.writeStringField(CityPartner.ID_PROPERTY,cityPartner.getId());
		jgen.writeStringField(CityPartner.NAME_PROPERTY,cityPartner.getName());
		jgen.writeStringField(CityPartner.MOBILE_PROPERTY,cityPartner.getMobile());
		writeCityServiceCenter(CityPartner.CITY_SERVICE_CENTER_PROPERTY,cityPartner,jgen,provider);
		jgen.writeStringField(CityPartner.DESCRIPTION_PROPERTY,cityPartner.getDescription());
		jgen.writeNumberField(CityPartner.VERSION_PROPERTY,cityPartner.getVersion());
		writePotentialCustomerList(CityPartner.POTENTIAL_CUSTOMER_LIST,cityPartner,jgen,provider);
		writePotentialCustomerContactList(CityPartner.POTENTIAL_CUSTOMER_CONTACT_LIST,cityPartner,jgen,provider);
		
		writeEndObject(cityPartner,jgen,provider);
	}
	
	protected void writeCityServiceCenter(String fieldName, CityPartner cityPartner, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCityServiceCenter cityServiceCenter = cityPartner.getCityServiceCenter();
		
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
	
	protected void writePotentialCustomerList(String fieldName, CityPartner cityPartner, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();
		
		if(potentialCustomerList == null){
			return;//do nothing when null found for this field.
		}
		if(potentialCustomerList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(PotentialCustomer potentialCustomer: potentialCustomerList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(PotentialCustomer.ID_PROPERTY,potentialCustomer.getId());
			jgen.writeStringField(PotentialCustomer.NAME_PROPERTY,potentialCustomer.getName());
			jgen.writeStringField(PotentialCustomer.MOBILE_PROPERTY,potentialCustomer.getMobile());
			jgen.writeStringField(PotentialCustomer.DESCRIPTION_PROPERTY,potentialCustomer.getDescription());
			jgen.writeNumberField(PotentialCustomer.VERSION_PROPERTY,potentialCustomer.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writePotentialCustomerContactList(String fieldName, CityPartner cityPartner, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();
		
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
	
}


