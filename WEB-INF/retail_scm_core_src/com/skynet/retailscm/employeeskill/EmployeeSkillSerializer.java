
package com.skynet.retailscm.employeeskill;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeeskill.EmployeeSkill;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.skilltype.SkillType;
import com.skynet.retailscm.employee.Employee;


public class EmployeeSkillSerializer extends BaseJsonSerializer<EmployeeSkill>{

	

	@Override
	public void serialize(EmployeeSkill employeeSkill, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeSkill,jgen,provider);
		
		jgen.writeStringField(EmployeeSkill.ID_PROPERTY,employeeSkill.getId());
		writeEmployee(EmployeeSkill.EMPLOYEE_PROPERTY,employeeSkill,jgen,provider);
		writeSkillType(EmployeeSkill.SKILL_TYPE_PROPERTY,employeeSkill,jgen,provider);
		jgen.writeStringField(EmployeeSkill.DESCRIPTION_PROPERTY,employeeSkill.getDescription());
		jgen.writeNumberField(EmployeeSkill.VERSION_PROPERTY,employeeSkill.getVersion());
		
		writeEndObject(employeeSkill,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeeSkill employeeSkill, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeeSkill.getEmployee();
		
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
	
	protected void writeSkillType(String fieldName, EmployeeSkill employeeSkill, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SkillType skillType = employeeSkill.getSkillType();
		
		if(skillType == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SkillType.ID_PROPERTY,skillType.getId()); 
		jgen.writeStringField(SkillType.CODE_PROPERTY,skillType.getCode()); 
		jgen.writeStringField(SkillType.DESCRIPTION_PROPERTY,skillType.getDescription()); 
		jgen.writeNumberField(SkillType.VERSION_PROPERTY,skillType.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


