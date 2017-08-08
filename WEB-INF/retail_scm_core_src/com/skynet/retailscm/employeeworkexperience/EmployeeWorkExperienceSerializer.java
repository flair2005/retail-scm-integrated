
package com.skynet.retailscm.employeeworkexperience;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;


public class EmployeeWorkExperienceSerializer extends BaseJsonSerializer<EmployeeWorkExperience>{

	

	@Override
	public void serialize(EmployeeWorkExperience employeeWorkExperience, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeWorkExperience,jgen,provider);
		
		jgen.writeStringField(EmployeeWorkExperience.ID_PROPERTY,employeeWorkExperience.getId());
		writeEmployee(EmployeeWorkExperience.EMPLOYEE_PROPERTY,employeeWorkExperience,jgen,provider);
		jgen.writeObjectField(EmployeeWorkExperience.START_PROPERTY,employeeWorkExperience.getStart());
		jgen.writeObjectField(EmployeeWorkExperience.END_PROPERTY,employeeWorkExperience.getEnd());
		jgen.writeStringField(EmployeeWorkExperience.COMPANY_PROPERTY,employeeWorkExperience.getCompany());
		jgen.writeStringField(EmployeeWorkExperience.DESCRIPTION_PROPERTY,employeeWorkExperience.getDescription());
		jgen.writeNumberField(EmployeeWorkExperience.VERSION_PROPERTY,employeeWorkExperience.getVersion());
		
		writeEndObject(employeeWorkExperience,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeeWorkExperience employeeWorkExperience, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeeWorkExperience.getEmployee();
		
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
	
	
}


