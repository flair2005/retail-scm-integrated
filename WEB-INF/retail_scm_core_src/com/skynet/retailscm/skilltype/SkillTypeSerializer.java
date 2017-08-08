
package com.skynet.retailscm.skilltype;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.skilltype.SkillType;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeskill.EmployeeSkill;


public class SkillTypeSerializer extends BaseJsonSerializer<SkillType>{

	

	@Override
	public void serialize(SkillType skillType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(skillType,jgen,provider);
		
		jgen.writeStringField(SkillType.ID_PROPERTY,skillType.getId());
		jgen.writeStringField(SkillType.CODE_PROPERTY,skillType.getCode());
		writeCompany(SkillType.COMPANY_PROPERTY,skillType,jgen,provider);
		jgen.writeStringField(SkillType.DESCRIPTION_PROPERTY,skillType.getDescription());
		jgen.writeNumberField(SkillType.VERSION_PROPERTY,skillType.getVersion());
		writeEmployeeSkillList(SkillType.EMPLOYEE_SKILL_LIST,skillType,jgen,provider);
		
		writeEndObject(skillType,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, SkillType skillType, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = skillType.getCompany();
		
		if(company == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,company.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,company.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,company.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,company.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,company.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,company.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,company.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,company.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,company.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,company.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeEmployeeSkillList(String fieldName, SkillType skillType, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeSkill> employeeSkillList = skillType.getEmployeeSkillList();
		
		if(employeeSkillList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeSkillList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeSkill employeeSkill: employeeSkillList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeSkill.ID_PROPERTY,employeeSkill.getId());
			jgen.writeStringField(EmployeeSkill.DESCRIPTION_PROPERTY,employeeSkill.getDescription());
			jgen.writeNumberField(EmployeeSkill.VERSION_PROPERTY,employeeSkill.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


