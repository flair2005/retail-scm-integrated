
package com.skynet.retailscm.levelthreedepartment;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.skynet.retailscm.employee.Employee;


public class LevelThreeDepartmentSerializer extends BaseJsonSerializer<LevelThreeDepartment>{

	

	@Override
	public void serialize(LevelThreeDepartment levelThreeDepartment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(levelThreeDepartment,jgen,provider);
		
		jgen.writeStringField(LevelThreeDepartment.ID_PROPERTY,levelThreeDepartment.getId());
		writeBelongsTo(LevelThreeDepartment.BELONGS_TO_PROPERTY,levelThreeDepartment,jgen,provider);
		jgen.writeStringField(LevelThreeDepartment.NAME_PROPERTY,levelThreeDepartment.getName());
		jgen.writeStringField(LevelThreeDepartment.DESCRIPTION_PROPERTY,levelThreeDepartment.getDescription());
		jgen.writeObjectField(LevelThreeDepartment.FOUNDED_PROPERTY,levelThreeDepartment.getFounded());
		jgen.writeNumberField(LevelThreeDepartment.VERSION_PROPERTY,levelThreeDepartment.getVersion());
		writeEmployeeList(LevelThreeDepartment.EMPLOYEE_LIST,levelThreeDepartment,jgen,provider);
		
		writeEndObject(levelThreeDepartment,jgen,provider);
	}
	
	protected void writeBelongsTo(String fieldName, LevelThreeDepartment levelThreeDepartment, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		LevelTwoDepartment belongsTo = levelThreeDepartment.getBelongsTo();
		
		if(belongsTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(LevelTwoDepartment.ID_PROPERTY,belongsTo.getId()); 
		jgen.writeStringField(LevelTwoDepartment.NAME_PROPERTY,belongsTo.getName()); 
		jgen.writeStringField(LevelTwoDepartment.DESCRIPTION_PROPERTY,belongsTo.getDescription()); 
		jgen.writeObjectField(LevelTwoDepartment.FOUNDED_PROPERTY,belongsTo.getFounded()); 
		jgen.writeNumberField(LevelTwoDepartment.VERSION_PROPERTY,belongsTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeEmployeeList(String fieldName, LevelThreeDepartment levelThreeDepartment, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		
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


