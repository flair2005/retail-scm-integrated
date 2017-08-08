
package com.skynet.retailscm.termination;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.termination.Termination;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.terminationreason.TerminationReason;
import com.skynet.retailscm.terminationtype.TerminationType;
import com.skynet.retailscm.employee.Employee;


public class TerminationSerializer extends BaseJsonSerializer<Termination>{

	

	@Override
	public void serialize(Termination termination, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(termination,jgen,provider);
		
		jgen.writeStringField(Termination.ID_PROPERTY,termination.getId());
		writeReason(Termination.REASON_PROPERTY,termination,jgen,provider);
		writeType(Termination.TYPE_PROPERTY,termination,jgen,provider);
		jgen.writeStringField(Termination.COMMENT_PROPERTY,termination.getComment());
		jgen.writeNumberField(Termination.VERSION_PROPERTY,termination.getVersion());
		writeEmployeeList(Termination.EMPLOYEE_LIST,termination,jgen,provider);
		
		writeEndObject(termination,jgen,provider);
	}
	
	protected void writeReason(String fieldName, Termination termination, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TerminationReason reason = termination.getReason();
		
		if(reason == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(TerminationReason.ID_PROPERTY,reason.getId()); 
		jgen.writeStringField(TerminationReason.CODE_PROPERTY,reason.getCode()); 
		jgen.writeStringField(TerminationReason.DESCRIPTION_PROPERTY,reason.getDescription()); 
		jgen.writeNumberField(TerminationReason.VERSION_PROPERTY,reason.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeType(String fieldName, Termination termination, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TerminationType type = termination.getType();
		
		if(type == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(TerminationType.ID_PROPERTY,type.getId()); 
		jgen.writeStringField(TerminationType.CODE_PROPERTY,type.getCode()); 
		jgen.writeStringField(TerminationType.BASE_DESCRIPTION_PROPERTY,type.getBaseDescription()); 
		jgen.writeStringField(TerminationType.DETAIL_DESCRIPTION_PROPERTY,type.getDetailDescription()); 
		jgen.writeNumberField(TerminationType.VERSION_PROPERTY,type.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeEmployeeList(String fieldName, Termination termination, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Employee> employeeList = termination.getEmployeeList();
		
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


