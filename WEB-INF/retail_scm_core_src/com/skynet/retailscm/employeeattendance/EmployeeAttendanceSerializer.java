
package com.skynet.retailscm.employeeattendance;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeeattendance.EmployeeAttendance;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;


public class EmployeeAttendanceSerializer extends BaseJsonSerializer<EmployeeAttendance>{

	

	@Override
	public void serialize(EmployeeAttendance employeeAttendance, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeAttendance,jgen,provider);
		
		jgen.writeStringField(EmployeeAttendance.ID_PROPERTY,employeeAttendance.getId());
		writeEmployee(EmployeeAttendance.EMPLOYEE_PROPERTY,employeeAttendance,jgen,provider);
		jgen.writeObjectField(EmployeeAttendance.ENTER_TIME_PROPERTY,employeeAttendance.getEnterTime());
		jgen.writeObjectField(EmployeeAttendance.LEAVE_TIME_PROPERTY,employeeAttendance.getLeaveTime());
		jgen.writeNumberField(EmployeeAttendance.DURATION_HOURS_PROPERTY,employeeAttendance.getDurationHours());
		jgen.writeStringField(EmployeeAttendance.REMARK_PROPERTY,employeeAttendance.getRemark());
		jgen.writeNumberField(EmployeeAttendance.VERSION_PROPERTY,employeeAttendance.getVersion());
		
		writeEndObject(employeeAttendance,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeeAttendance employeeAttendance, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeeAttendance.getEmployee();
		
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


