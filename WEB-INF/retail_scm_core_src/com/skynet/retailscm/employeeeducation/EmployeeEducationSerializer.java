
package com.skynet.retailscm.employeeeducation;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeeeducation.EmployeeEducation;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;


public class EmployeeEducationSerializer extends BaseJsonSerializer<EmployeeEducation>{

	

	@Override
	public void serialize(EmployeeEducation employeeEducation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeEducation,jgen,provider);
		
		jgen.writeStringField(EmployeeEducation.ID_PROPERTY,employeeEducation.getId());
		writeEmployee(EmployeeEducation.EMPLOYEE_PROPERTY,employeeEducation,jgen,provider);
		jgen.writeObjectField(EmployeeEducation.COMPLETE_TIME_PROPERTY,employeeEducation.getCompleteTime());
		jgen.writeStringField(EmployeeEducation.TYPE_PROPERTY,employeeEducation.getType());
		jgen.writeStringField(EmployeeEducation.REMARK_PROPERTY,employeeEducation.getRemark());
		jgen.writeNumberField(EmployeeEducation.VERSION_PROPERTY,employeeEducation.getVersion());
		
		writeEndObject(employeeEducation,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeeEducation employeeEducation, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeeEducation.getEmployee();
		
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


