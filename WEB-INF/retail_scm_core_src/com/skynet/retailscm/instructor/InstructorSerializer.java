
package com.skynet.retailscm.instructor;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.companytraining.CompanyTraining;


public class InstructorSerializer extends BaseJsonSerializer<Instructor>{

	

	@Override
	public void serialize(Instructor instructor, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(instructor,jgen,provider);
		
		jgen.writeStringField(Instructor.ID_PROPERTY,instructor.getId());
		jgen.writeStringField(Instructor.TITLE_PROPERTY,instructor.getTitle());
		jgen.writeStringField(Instructor.FAMILY_NAME_PROPERTY,instructor.getFamilyName());
		jgen.writeStringField(Instructor.GIVEN_NAME_PROPERTY,instructor.getGivenName());
		jgen.writeStringField(Instructor.CELL_PHONE_PROPERTY,instructor.getCellPhone());
		jgen.writeStringField(Instructor.EMAIL_PROPERTY,instructor.getEmail());
		writeCompany(Instructor.COMPANY_PROPERTY,instructor,jgen,provider);
		jgen.writeStringField(Instructor.INTRODUCTION_PROPERTY,instructor.getIntroduction());
		jgen.writeNumberField(Instructor.VERSION_PROPERTY,instructor.getVersion());
		writeCompanyTrainingList(Instructor.COMPANY_TRAINING_LIST,instructor,jgen,provider);
		
		writeEndObject(instructor,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, Instructor instructor, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = instructor.getCompany();
		
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
	
	protected void writeCompanyTrainingList(String fieldName, Instructor instructor, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
		
		if(companyTrainingList == null){
			return;//do nothing when null found for this field.
		}
		if(companyTrainingList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(CompanyTraining companyTraining: companyTrainingList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(CompanyTraining.ID_PROPERTY,companyTraining.getId());
			jgen.writeStringField(CompanyTraining.TITLE_PROPERTY,companyTraining.getTitle());
			jgen.writeObjectField(CompanyTraining.TIME_START_PROPERTY,companyTraining.getTimeStart());
			jgen.writeNumberField(CompanyTraining.DURATION_HOURS_PROPERTY,companyTraining.getDurationHours());
			jgen.writeNumberField(CompanyTraining.VERSION_PROPERTY,companyTraining.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


