
package com.skynet.retailscm.potentialcustomercontactperson;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;


public class PotentialCustomerContactPersonSerializer extends BaseJsonSerializer<PotentialCustomerContactPerson>{

	

	@Override
	public void serialize(PotentialCustomerContactPerson potentialCustomerContactPerson, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(potentialCustomerContactPerson,jgen,provider);
		
		jgen.writeStringField(PotentialCustomerContactPerson.ID_PROPERTY,potentialCustomerContactPerson.getId());
		jgen.writeStringField(PotentialCustomerContactPerson.NAME_PROPERTY,potentialCustomerContactPerson.getName());
		jgen.writeStringField(PotentialCustomerContactPerson.MOBILE_PROPERTY,potentialCustomerContactPerson.getMobile());
		writePotentialCustomer(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY,potentialCustomerContactPerson,jgen,provider);
		jgen.writeStringField(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY,potentialCustomerContactPerson.getDescription());
		jgen.writeNumberField(PotentialCustomerContactPerson.VERSION_PROPERTY,potentialCustomerContactPerson.getVersion());
		writePotentialCustomerContactList(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_CONTACT_LIST,potentialCustomerContactPerson,jgen,provider);
		
		writeEndObject(potentialCustomerContactPerson,jgen,provider);
	}
	
	protected void writePotentialCustomer(String fieldName, PotentialCustomerContactPerson potentialCustomerContactPerson, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		PotentialCustomer potentialCustomer = potentialCustomerContactPerson.getPotentialCustomer();
		
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
	
	protected void writePotentialCustomerContactList(String fieldName, PotentialCustomerContactPerson potentialCustomerContactPerson, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();
		
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


