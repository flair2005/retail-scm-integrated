
package com.skynet.retailscm.hrinterview;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.hrinterview.HrInterview;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;


public class HrInterviewSerializer extends BaseJsonSerializer<HrInterview>{

	

	@Override
	public void serialize(HrInterview hrInterview, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(hrInterview,jgen,provider);
		
		jgen.writeStringField(HrInterview.ID_PROPERTY,hrInterview.getId());
		jgen.writeStringField(HrInterview.WHO_PROPERTY,hrInterview.getWho());
		jgen.writeObjectField(HrInterview.INTERVIEW_TIME_PROPERTY,hrInterview.getInterviewTime());
		jgen.writeStringField(HrInterview.COMMENTS_PROPERTY,hrInterview.getComments());
		jgen.writeNumberField(HrInterview.VERSION_PROPERTY,hrInterview.getVersion());
		writeEmployeeList(HrInterview.EMPLOYEE_LIST,hrInterview,jgen,provider);
		
		writeEndObject(hrInterview,jgen,provider);
	}
	
	protected void writeEmployeeList(String fieldName, HrInterview hrInterview, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Employee> employeeList = hrInterview.getEmployeeList();
		
		if(employeeList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Employee employee: employeeList){
				
			jgen.writeStartObject();// {
		
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

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


