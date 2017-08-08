
package com.skynet.retailscm.employeeinterview;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeeinterview.EmployeeInterview;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.interviewtype.InterviewType;
import com.skynet.retailscm.employee.Employee;


public class EmployeeInterviewSerializer extends BaseJsonSerializer<EmployeeInterview>{

	

	@Override
	public void serialize(EmployeeInterview employeeInterview, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeInterview,jgen,provider);
		
		jgen.writeStringField(EmployeeInterview.ID_PROPERTY,employeeInterview.getId());
		writeEmployee(EmployeeInterview.EMPLOYEE_PROPERTY,employeeInterview,jgen,provider);
		writeInterviewType(EmployeeInterview.INTERVIEW_TYPE_PROPERTY,employeeInterview,jgen,provider);
		jgen.writeStringField(EmployeeInterview.REMARK_PROPERTY,employeeInterview.getRemark());
		jgen.writeNumberField(EmployeeInterview.VERSION_PROPERTY,employeeInterview.getVersion());
		
		writeEndObject(employeeInterview,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeeInterview employeeInterview, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeeInterview.getEmployee();
		
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
	
	protected void writeInterviewType(String fieldName, EmployeeInterview employeeInterview, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		InterviewType interviewType = employeeInterview.getInterviewType();
		
		if(interviewType == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(InterviewType.ID_PROPERTY,interviewType.getId()); 
		jgen.writeStringField(InterviewType.CODE_PROPERTY,interviewType.getCode()); 
		jgen.writeStringField(InterviewType.DESCRIPTION_PROPERTY,interviewType.getDescription()); 
		jgen.writeStringField(InterviewType.DETAIL_DESCRIPTION_PROPERTY,interviewType.getDetailDescription()); 
		jgen.writeNumberField(InterviewType.VERSION_PROPERTY,interviewType.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


