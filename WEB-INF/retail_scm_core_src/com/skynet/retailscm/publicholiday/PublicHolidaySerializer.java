
package com.skynet.retailscm.publicholiday;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.publicholiday.PublicHoliday;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;


public class PublicHolidaySerializer extends BaseJsonSerializer<PublicHoliday>{

	

	@Override
	public void serialize(PublicHoliday publicHoliday, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(publicHoliday,jgen,provider);
		
		jgen.writeStringField(PublicHoliday.ID_PROPERTY,publicHoliday.getId());
		jgen.writeStringField(PublicHoliday.CODE_PROPERTY,publicHoliday.getCode());
		writeCompany(PublicHoliday.COMPANY_PROPERTY,publicHoliday,jgen,provider);
		jgen.writeStringField(PublicHoliday.NAME_PROPERTY,publicHoliday.getName());
		jgen.writeStringField(PublicHoliday.DESCRIPTION_PROPERTY,publicHoliday.getDescription());
		jgen.writeNumberField(PublicHoliday.VERSION_PROPERTY,publicHoliday.getVersion());
		
		writeEndObject(publicHoliday,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, PublicHoliday publicHoliday, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = publicHoliday.getCompany();
		
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
	
	
}


