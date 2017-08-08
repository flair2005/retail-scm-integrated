
package com.skynet.retailscm.terminationtype;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.terminationtype.TerminationType;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.termination.Termination;


public class TerminationTypeSerializer extends BaseJsonSerializer<TerminationType>{

	

	@Override
	public void serialize(TerminationType terminationType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(terminationType,jgen,provider);
		
		jgen.writeStringField(TerminationType.ID_PROPERTY,terminationType.getId());
		jgen.writeStringField(TerminationType.CODE_PROPERTY,terminationType.getCode());
		writeCompany(TerminationType.COMPANY_PROPERTY,terminationType,jgen,provider);
		jgen.writeStringField(TerminationType.BASE_DESCRIPTION_PROPERTY,terminationType.getBaseDescription());
		jgen.writeStringField(TerminationType.DETAIL_DESCRIPTION_PROPERTY,terminationType.getDetailDescription());
		jgen.writeNumberField(TerminationType.VERSION_PROPERTY,terminationType.getVersion());
		writeTerminationList(TerminationType.TERMINATION_LIST,terminationType,jgen,provider);
		
		writeEndObject(terminationType,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, TerminationType terminationType, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = terminationType.getCompany();
		
		if(company == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,company.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,company.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,company.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,company.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,company.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,company.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,company.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,company.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,company.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,company.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeTerminationList(String fieldName, TerminationType terminationType, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Termination> terminationList = terminationType.getTerminationList();
		
		if(terminationList == null){
			return;//do nothing when null found for this field.
		}
		if(terminationList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Termination termination: terminationList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Termination.ID_PROPERTY,termination.getId());
			jgen.writeStringField(Termination.COMMENT_PROPERTY,termination.getComment());
			jgen.writeNumberField(Termination.VERSION_PROPERTY,termination.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


