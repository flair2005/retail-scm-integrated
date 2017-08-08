
package com.skynet.retailscm.employeequalifier;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeequalifier.EmployeeQualifier;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;


public class EmployeeQualifierSerializer extends BaseJsonSerializer<EmployeeQualifier>{

	

	@Override
	public void serialize(EmployeeQualifier employeeQualifier, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeQualifier,jgen,provider);
		
		jgen.writeStringField(EmployeeQualifier.ID_PROPERTY,employeeQualifier.getId());
		writeEmployee(EmployeeQualifier.EMPLOYEE_PROPERTY,employeeQualifier,jgen,provider);
		jgen.writeObjectField(EmployeeQualifier.QUALIFIED_TIME_PROPERTY,employeeQualifier.getQualifiedTime());
		jgen.writeStringField(EmployeeQualifier.TYPE_PROPERTY,employeeQualifier.getType());
		jgen.writeStringField(EmployeeQualifier.LEVEL_PROPERTY,employeeQualifier.getLevel());
		jgen.writeStringField(EmployeeQualifier.REMARK_PROPERTY,employeeQualifier.getRemark());
		jgen.writeNumberField(EmployeeQualifier.VERSION_PROPERTY,employeeQualifier.getVersion());
		
		writeEndObject(employeeQualifier,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeeQualifier employeeQualifier, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeeQualifier.getEmployee();
		
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


