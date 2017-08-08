
package com.skynet.retailscm.employeeperformance;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeeperformance.EmployeePerformance;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;


public class EmployeePerformanceSerializer extends BaseJsonSerializer<EmployeePerformance>{

	

	@Override
	public void serialize(EmployeePerformance employeePerformance, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeePerformance,jgen,provider);
		
		jgen.writeStringField(EmployeePerformance.ID_PROPERTY,employeePerformance.getId());
		writeEmployee(EmployeePerformance.EMPLOYEE_PROPERTY,employeePerformance,jgen,provider);
		jgen.writeStringField(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY,employeePerformance.getPerformanceComment());
		jgen.writeNumberField(EmployeePerformance.VERSION_PROPERTY,employeePerformance.getVersion());
		
		writeEndObject(employeePerformance,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeePerformance employeePerformance, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeePerformance.getEmployee();
		
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


