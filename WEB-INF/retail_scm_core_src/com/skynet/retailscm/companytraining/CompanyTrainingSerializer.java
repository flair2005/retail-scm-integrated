
package com.skynet.retailscm.companytraining;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;


public class CompanyTrainingSerializer extends BaseJsonSerializer<CompanyTraining>{

	

	@Override
	public void serialize(CompanyTraining companyTraining, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(companyTraining,jgen,provider);
		
		jgen.writeStringField(CompanyTraining.ID_PROPERTY,companyTraining.getId());
		jgen.writeStringField(CompanyTraining.TITLE_PROPERTY,companyTraining.getTitle());
		writeCompany(CompanyTraining.COMPANY_PROPERTY,companyTraining,jgen,provider);
		writeInstructor(CompanyTraining.INSTRUCTOR_PROPERTY,companyTraining,jgen,provider);
		writeTrainingCourseType(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY,companyTraining,jgen,provider);
		jgen.writeObjectField(CompanyTraining.TIME_START_PROPERTY,companyTraining.getTimeStart());
		jgen.writeNumberField(CompanyTraining.DURATION_HOURS_PROPERTY,companyTraining.getDurationHours());
		jgen.writeNumberField(CompanyTraining.VERSION_PROPERTY,companyTraining.getVersion());
		writeEmployeeCompanyTrainingList(CompanyTraining.EMPLOYEE_COMPANY_TRAINING_LIST,companyTraining,jgen,provider);
		
		writeEndObject(companyTraining,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, CompanyTraining companyTraining, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = companyTraining.getCompany();
		
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
	
	protected void writeInstructor(String fieldName, CompanyTraining companyTraining, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Instructor instructor = companyTraining.getInstructor();
		
		if(instructor == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Instructor.ID_PROPERTY,instructor.getId()); 
		jgen.writeStringField(Instructor.TITLE_PROPERTY,instructor.getTitle()); 
		jgen.writeStringField(Instructor.FAMILY_NAME_PROPERTY,instructor.getFamilyName()); 
		jgen.writeStringField(Instructor.GIVEN_NAME_PROPERTY,instructor.getGivenName()); 
		jgen.writeStringField(Instructor.CELL_PHONE_PROPERTY,instructor.getCellPhone()); 
		jgen.writeStringField(Instructor.EMAIL_PROPERTY,instructor.getEmail()); 
		jgen.writeStringField(Instructor.INTRODUCTION_PROPERTY,instructor.getIntroduction()); 
		jgen.writeNumberField(Instructor.VERSION_PROPERTY,instructor.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeTrainingCourseType(String fieldName, CompanyTraining companyTraining, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TrainingCourseType trainingCourseType = companyTraining.getTrainingCourseType();
		
		if(trainingCourseType == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(TrainingCourseType.ID_PROPERTY,trainingCourseType.getId()); 
		jgen.writeStringField(TrainingCourseType.CODE_PROPERTY,trainingCourseType.getCode()); 
		jgen.writeStringField(TrainingCourseType.NAME_PROPERTY,trainingCourseType.getName()); 
		jgen.writeStringField(TrainingCourseType.DESCRIPTION_PROPERTY,trainingCourseType.getDescription()); 
		jgen.writeNumberField(TrainingCourseType.VERSION_PROPERTY,trainingCourseType.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeEmployeeCompanyTrainingList(String fieldName, CompanyTraining companyTraining, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();
		
		if(employeeCompanyTrainingList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeCompanyTrainingList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeCompanyTraining employeeCompanyTraining: employeeCompanyTrainingList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeCompanyTraining.ID_PROPERTY,employeeCompanyTraining.getId());
			jgen.writeStringField(EmployeeCompanyTraining.CURRENT_STATUS_PROPERTY,employeeCompanyTraining.getCurrentStatus());
			jgen.writeNumberField(EmployeeCompanyTraining.VERSION_PROPERTY,employeeCompanyTraining.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


