
package com.skynet.retailscm.employeeleave;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeeleave.EmployeeLeave;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.leavetype.LeaveType;


public class EmployeeLeaveSerializer extends BaseJsonSerializer<EmployeeLeave>{

	

	@Override
	public void serialize(EmployeeLeave employeeLeave, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeLeave,jgen,provider);
		
		jgen.writeStringField(EmployeeLeave.ID_PROPERTY,employeeLeave.getId());
		writeWho(EmployeeLeave.WHO_PROPERTY,employeeLeave,jgen,provider);
		writeType(EmployeeLeave.TYPE_PROPERTY,employeeLeave,jgen,provider);
		jgen.writeNumberField(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY,employeeLeave.getLeaveDurationHour());
		jgen.writeStringField(EmployeeLeave.REMARK_PROPERTY,employeeLeave.getRemark());
		jgen.writeNumberField(EmployeeLeave.VERSION_PROPERTY,employeeLeave.getVersion());
		
		writeEndObject(employeeLeave,jgen,provider);
	}
	
	protected void writeWho(String fieldName, EmployeeLeave employeeLeave, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee who = employeeLeave.getWho();
		
		if(who == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Employee.ID_PROPERTY,who.getId()); 
		jgen.writeStringField(Employee.TITLE_PROPERTY,who.getTitle()); 
		jgen.writeStringField(Employee.FAMILY_NAME_PROPERTY,who.getFamilyName()); 
		jgen.writeStringField(Employee.GIVEN_NAME_PROPERTY,who.getGivenName()); 
		jgen.writeStringField(Employee.EMAIL_PROPERTY,who.getEmail()); 
		jgen.writeStringField(Employee.CITY_PROPERTY,who.getCity()); 
		jgen.writeStringField(Employee.ADDRESS_PROPERTY,who.getAddress()); 
		jgen.writeStringField(Employee.CELL_PHONE_PROPERTY,who.getCellPhone()); 
		jgen.writeStringField(Employee.SALARY_ACCOUNT_PROPERTY,who.getSalaryAccount()); 
		jgen.writeStringField(Employee.CURRENT_STATUS_PROPERTY,who.getCurrentStatus()); 
		jgen.writeNumberField(Employee.VERSION_PROPERTY,who.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeType(String fieldName, EmployeeLeave employeeLeave, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		LeaveType type = employeeLeave.getType();
		
		if(type == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(LeaveType.ID_PROPERTY,type.getId()); 
		jgen.writeStringField(LeaveType.CODE_PROPERTY,type.getCode()); 
		jgen.writeStringField(LeaveType.DESCRIPTION_PROPERTY,type.getDescription()); 
		jgen.writeStringField(LeaveType.DETAIL_DESCRIPTION_PROPERTY,type.getDetailDescription()); 
		jgen.writeNumberField(LeaveType.VERSION_PROPERTY,type.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


