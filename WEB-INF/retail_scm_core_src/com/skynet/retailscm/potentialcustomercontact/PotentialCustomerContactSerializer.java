
package com.skynet.retailscm.potentialcustomercontact;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;


public class PotentialCustomerContactSerializer extends BaseJsonSerializer<PotentialCustomerContact>{

	

	@Override
	public void serialize(PotentialCustomerContact potentialCustomerContact, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(potentialCustomerContact,jgen,provider);
		
		jgen.writeStringField(PotentialCustomerContact.ID_PROPERTY,potentialCustomerContact.getId());
		jgen.writeStringField(PotentialCustomerContact.NAME_PROPERTY,potentialCustomerContact.getName());
		jgen.writeObjectField(PotentialCustomerContact.CONTACT_DATE_PROPERTY,potentialCustomerContact.getContactDate());
		jgen.writeStringField(PotentialCustomerContact.CONTACT_METHOD_PROPERTY,potentialCustomerContact.getContactMethod());
		writePotentialCustomer(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY,potentialCustomerContact,jgen,provider);
		writeCityPartner(PotentialCustomerContact.CITY_PARTNER_PROPERTY,potentialCustomerContact,jgen,provider);
		writeContactTo(PotentialCustomerContact.CONTACT_TO_PROPERTY,potentialCustomerContact,jgen,provider);
		jgen.writeStringField(PotentialCustomerContact.DESCRIPTION_PROPERTY,potentialCustomerContact.getDescription());
		jgen.writeNumberField(PotentialCustomerContact.VERSION_PROPERTY,potentialCustomerContact.getVersion());
		
		writeEndObject(potentialCustomerContact,jgen,provider);
	}
	
	protected void writePotentialCustomer(String fieldName, PotentialCustomerContact potentialCustomerContact, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		PotentialCustomer potentialCustomer = potentialCustomerContact.getPotentialCustomer();
		
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
	
	protected void writeCityPartner(String fieldName, PotentialCustomerContact potentialCustomerContact, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		CityPartner cityPartner = potentialCustomerContact.getCityPartner();
		
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
	
	protected void writeContactTo(String fieldName, PotentialCustomerContact potentialCustomerContact, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		PotentialCustomerContactPerson contactTo = potentialCustomerContact.getContactTo();
		
		if(contactTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(PotentialCustomerContactPerson.ID_PROPERTY,contactTo.getId()); 
		jgen.writeStringField(PotentialCustomerContactPerson.NAME_PROPERTY,contactTo.getName()); 
		jgen.writeStringField(PotentialCustomerContactPerson.MOBILE_PROPERTY,contactTo.getMobile()); 
		jgen.writeStringField(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY,contactTo.getDescription()); 
		jgen.writeNumberField(PotentialCustomerContactPerson.VERSION_PROPERTY,contactTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


