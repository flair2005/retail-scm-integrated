
package com.skynet.retailscm.jobapplication;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.jobapplication.JobApplication;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;


public class JobApplicationSerializer extends BaseJsonSerializer<JobApplication>{

	

	@Override
	public void serialize(JobApplication jobApplication, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(jobApplication,jgen,provider);
		
		jgen.writeStringField(JobApplication.ID_PROPERTY,jobApplication.getId());
		jgen.writeObjectField(JobApplication.APPLICATION_TIME_PROPERTY,jobApplication.getApplicationTime());
		jgen.writeStringField(JobApplication.WHO_PROPERTY,jobApplication.getWho());
		jgen.writeStringField(JobApplication.COMMENTS_PROPERTY,jobApplication.getComments());
		jgen.writeNumberField(JobApplication.VERSION_PROPERTY,jobApplication.getVersion());
		writeEmployeeList(JobApplication.EMPLOYEE_LIST,jobApplication,jgen,provider);
		
		writeEndObject(jobApplication,jgen,provider);
	}
	
	protected void writeEmployeeList(String fieldName, JobApplication jobApplication, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Employee> employeeList = jobApplication.getEmployeeList();
		
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


