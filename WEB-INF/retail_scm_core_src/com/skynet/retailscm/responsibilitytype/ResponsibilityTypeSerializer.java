
package com.skynet.retailscm.responsibilitytype;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.responsibilitytype.ResponsibilityType;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employee.Employee;


public class ResponsibilityTypeSerializer extends BaseJsonSerializer<ResponsibilityType>{

	

	@Override
	public void serialize(ResponsibilityType responsibilityType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(responsibilityType,jgen,provider);
		
		jgen.writeStringField(ResponsibilityType.ID_PROPERTY,responsibilityType.getId());
		jgen.writeStringField(ResponsibilityType.CODE_PROPERTY,responsibilityType.getCode());
		writeCompany(ResponsibilityType.COMPANY_PROPERTY,responsibilityType,jgen,provider);
		jgen.writeStringField(ResponsibilityType.BASE_DESCRIPTION_PROPERTY,responsibilityType.getBaseDescription());
		jgen.writeStringField(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY,responsibilityType.getDetailDescription());
		jgen.writeNumberField(ResponsibilityType.VERSION_PROPERTY,responsibilityType.getVersion());
		writeEmployeeList(ResponsibilityType.EMPLOYEE_LIST,responsibilityType,jgen,provider);
		
		writeEndObject(responsibilityType,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, ResponsibilityType responsibilityType, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = responsibilityType.getCompany();
		
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
	
	protected void writeEmployeeList(String fieldName, ResponsibilityType responsibilityType, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Employee> employeeList = responsibilityType.getEmployeeList();
		
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


