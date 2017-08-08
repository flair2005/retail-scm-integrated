
package com.skynet.retailscm.employeeaward;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeeaward.EmployeeAward;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;


public class EmployeeAwardSerializer extends BaseJsonSerializer<EmployeeAward>{

	

	@Override
	public void serialize(EmployeeAward employeeAward, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeAward,jgen,provider);
		
		jgen.writeStringField(EmployeeAward.ID_PROPERTY,employeeAward.getId());
		writeEmployee(EmployeeAward.EMPLOYEE_PROPERTY,employeeAward,jgen,provider);
		jgen.writeObjectField(EmployeeAward.COMPLETE_TIME_PROPERTY,employeeAward.getCompleteTime());
		jgen.writeStringField(EmployeeAward.TYPE_PROPERTY,employeeAward.getType());
		jgen.writeStringField(EmployeeAward.REMARK_PROPERTY,employeeAward.getRemark());
		jgen.writeNumberField(EmployeeAward.VERSION_PROPERTY,employeeAward.getVersion());
		
		writeEndObject(employeeAward,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeeAward employeeAward, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeeAward.getEmployee();
		
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


