
package com.skynet.retailscm.employeeboarding;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeeboarding.EmployeeBoarding;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;


public class EmployeeBoardingSerializer extends BaseJsonSerializer<EmployeeBoarding>{

	

	@Override
	public void serialize(EmployeeBoarding employeeBoarding, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeBoarding,jgen,provider);
		
		jgen.writeStringField(EmployeeBoarding.ID_PROPERTY,employeeBoarding.getId());
		jgen.writeStringField(EmployeeBoarding.WHO_PROPERTY,employeeBoarding.getWho());
		jgen.writeObjectField(EmployeeBoarding.EMPLOY_TIME_PROPERTY,employeeBoarding.getEmployTime());
		jgen.writeStringField(EmployeeBoarding.COMMENTS_PROPERTY,employeeBoarding.getComments());
		jgen.writeNumberField(EmployeeBoarding.VERSION_PROPERTY,employeeBoarding.getVersion());
		writeEmployeeList(EmployeeBoarding.EMPLOYEE_LIST,employeeBoarding,jgen,provider);
		
		writeEndObject(employeeBoarding,jgen,provider);
	}
	
	protected void writeEmployeeList(String fieldName, EmployeeBoarding employeeBoarding, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Employee> employeeList = employeeBoarding.getEmployeeList();
		
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


