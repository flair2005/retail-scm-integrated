
package com.skynet.retailscm.terminationreason;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.terminationreason.TerminationReason;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.termination.Termination;


public class TerminationReasonSerializer extends BaseJsonSerializer<TerminationReason>{

	

	@Override
	public void serialize(TerminationReason terminationReason, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(terminationReason,jgen,provider);
		
		jgen.writeStringField(TerminationReason.ID_PROPERTY,terminationReason.getId());
		jgen.writeStringField(TerminationReason.CODE_PROPERTY,terminationReason.getCode());
		writeCompany(TerminationReason.COMPANY_PROPERTY,terminationReason,jgen,provider);
		jgen.writeStringField(TerminationReason.DESCRIPTION_PROPERTY,terminationReason.getDescription());
		jgen.writeNumberField(TerminationReason.VERSION_PROPERTY,terminationReason.getVersion());
		writeTerminationList(TerminationReason.TERMINATION_LIST,terminationReason,jgen,provider);
		
		writeEndObject(terminationReason,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, TerminationReason terminationReason, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = terminationReason.getCompany();
		
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
	
	protected void writeTerminationList(String fieldName, TerminationReason terminationReason, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Termination> terminationList = terminationReason.getTerminationList();
		
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


