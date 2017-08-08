
package com.skynet.retailscm.employeecompanytraining;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.scoring.Scoring;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.employee.Employee;


public class EmployeeCompanyTrainingSerializer extends BaseJsonSerializer<EmployeeCompanyTraining>{

	

	@Override
	public void serialize(EmployeeCompanyTraining employeeCompanyTraining, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeCompanyTraining,jgen,provider);
		
		jgen.writeStringField(EmployeeCompanyTraining.ID_PROPERTY,employeeCompanyTraining.getId());
		writeEmployee(EmployeeCompanyTraining.EMPLOYEE_PROPERTY,employeeCompanyTraining,jgen,provider);
		writeTraining(EmployeeCompanyTraining.TRAINING_PROPERTY,employeeCompanyTraining,jgen,provider);
		writeScoring(EmployeeCompanyTraining.SCORING_PROPERTY,employeeCompanyTraining,jgen,provider);
		jgen.writeStringField(EmployeeCompanyTraining.CURRENT_STATUS_PROPERTY,employeeCompanyTraining.getCurrentStatus());
		jgen.writeNumberField(EmployeeCompanyTraining.VERSION_PROPERTY,employeeCompanyTraining.getVersion());
		
		writeEndObject(employeeCompanyTraining,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeeCompanyTraining employeeCompanyTraining, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeeCompanyTraining.getEmployee();
		
		if(employee == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Employee.ID_PROPERTY,employee.getId()); 
		jgen.writeStringField(Employee.TITLE_PROPERTY,employee.getTitle()); 
		jgen.writeStringField(Employee.FAMILY_NAME_PROPERTY,employee.getFamilyName()); 
		jgen.writeStringField(Employee.GIVEN_NAME_PROPERTY,employee.getGivenName()); 
		jgen.writeStringField(Employee.EMAIL_PROPERTY,employee.getEmail()); 
		jgen.writeStringField(Employee.CITY_PROPERTY,employee.getCity()); 
		jgen.writeStringField(Employee.ADDRESS_PROPERTY,employee.getAddress()); 
		jgen.writeStringField(Employee.CELL_PHONE_PROPERTY,employee.getCellPhone()); 
		jgen.writeStringField(Employee.SALARY_ACCOUNT_PROPERTY,employee.getSalaryAccount()); 
		jgen.writeStringField(Employee.CURRENT_STATUS_PROPERTY,employee.getCurrentStatus()); 
		jgen.writeNumberField(Employee.VERSION_PROPERTY,employee.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeTraining(String fieldName, EmployeeCompanyTraining employeeCompanyTraining, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		CompanyTraining training = employeeCompanyTraining.getTraining();
		
		if(training == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(CompanyTraining.ID_PROPERTY,training.getId()); 
		jgen.writeStringField(CompanyTraining.TITLE_PROPERTY,training.getTitle()); 
		jgen.writeObjectField(CompanyTraining.TIME_START_PROPERTY,training.getTimeStart()); 
		jgen.writeNumberField(CompanyTraining.DURATION_HOURS_PROPERTY,training.getDurationHours()); 
		jgen.writeNumberField(CompanyTraining.VERSION_PROPERTY,training.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeScoring(String fieldName, EmployeeCompanyTraining employeeCompanyTraining, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Scoring scoring = employeeCompanyTraining.getScoring();
		
		if(scoring == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Scoring.ID_PROPERTY,scoring.getId()); 
		jgen.writeStringField(Scoring.SCORED_BY_PROPERTY,scoring.getScoredBy()); 
		jgen.writeNumberField(Scoring.SCORE_PROPERTY,scoring.getScore()); 
		jgen.writeStringField(Scoring.COMMENT_PROPERTY,scoring.getComment()); 
		jgen.writeNumberField(Scoring.VERSION_PROPERTY,scoring.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


