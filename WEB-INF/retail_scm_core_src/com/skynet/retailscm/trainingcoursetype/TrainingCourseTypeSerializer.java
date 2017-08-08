
package com.skynet.retailscm.trainingcoursetype;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.companytraining.CompanyTraining;


public class TrainingCourseTypeSerializer extends BaseJsonSerializer<TrainingCourseType>{

	

	@Override
	public void serialize(TrainingCourseType trainingCourseType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(trainingCourseType,jgen,provider);
		
		jgen.writeStringField(TrainingCourseType.ID_PROPERTY,trainingCourseType.getId());
		jgen.writeStringField(TrainingCourseType.CODE_PROPERTY,trainingCourseType.getCode());
		writeCompany(TrainingCourseType.COMPANY_PROPERTY,trainingCourseType,jgen,provider);
		jgen.writeStringField(TrainingCourseType.NAME_PROPERTY,trainingCourseType.getName());
		jgen.writeStringField(TrainingCourseType.DESCRIPTION_PROPERTY,trainingCourseType.getDescription());
		jgen.writeNumberField(TrainingCourseType.VERSION_PROPERTY,trainingCourseType.getVersion());
		writeCompanyTrainingList(TrainingCourseType.COMPANY_TRAINING_LIST,trainingCourseType,jgen,provider);
		
		writeEndObject(trainingCourseType,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, TrainingCourseType trainingCourseType, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = trainingCourseType.getCompany();
		
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
	
	protected void writeCompanyTrainingList(String fieldName, TrainingCourseType trainingCourseType, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();
		
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


