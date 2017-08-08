
package com.skynet.retailscm.retailstoreprovincecenter;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;


public class RetailStoreProvinceCenterSerializer extends BaseJsonSerializer<RetailStoreProvinceCenter>{

	

	@Override
	public void serialize(RetailStoreProvinceCenter retailStoreProvinceCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreProvinceCenter,jgen,provider);
		
		jgen.writeStringField(RetailStoreProvinceCenter.ID_PROPERTY,retailStoreProvinceCenter.getId());
		jgen.writeStringField(RetailStoreProvinceCenter.NAME_PROPERTY,retailStoreProvinceCenter.getName());
		jgen.writeObjectField(RetailStoreProvinceCenter.FOUNDED_PROPERTY,retailStoreProvinceCenter.getFounded());
		writeCountry(RetailStoreProvinceCenter.COUNTRY_PROPERTY,retailStoreProvinceCenter,jgen,provider);
		jgen.writeNumberField(RetailStoreProvinceCenter.VERSION_PROPERTY,retailStoreProvinceCenter.getVersion());
		writeProvinceCenterDepartmentList(RetailStoreProvinceCenter.PROVINCE_CENTER_DEPARTMENT_LIST,retailStoreProvinceCenter,jgen,provider);
		writeProvinceCenterEmployeeList(RetailStoreProvinceCenter.PROVINCE_CENTER_EMPLOYEE_LIST,retailStoreProvinceCenter,jgen,provider);
		writeRetailStoreCityServiceCenterList(RetailStoreProvinceCenter.RETAIL_STORE_CITY_SERVICE_CENTER_LIST,retailStoreProvinceCenter,jgen,provider);
		
		writeEndObject(retailStoreProvinceCenter,jgen,provider);
	}
	
	protected void writeCountry(String fieldName, RetailStoreProvinceCenter retailStoreProvinceCenter, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter country = retailStoreProvinceCenter.getCountry();
		
		if(country == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,country.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,country.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,country.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,country.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,country.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,country.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,country.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,country.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,country.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,country.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProvinceCenterDepartmentList(String fieldName, RetailStoreProvinceCenter retailStoreProvinceCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ProvinceCenterDepartment> provinceCenterDepartmentList = retailStoreProvinceCenter.getProvinceCenterDepartmentList();
		
		if(provinceCenterDepartmentList == null){
			return;//do nothing when null found for this field.
		}
		if(provinceCenterDepartmentList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ProvinceCenterDepartment provinceCenterDepartment: provinceCenterDepartmentList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ProvinceCenterDepartment.ID_PROPERTY,provinceCenterDepartment.getId());
			jgen.writeStringField(ProvinceCenterDepartment.NAME_PROPERTY,provinceCenterDepartment.getName());
			jgen.writeObjectField(ProvinceCenterDepartment.FOUNDED_PROPERTY,provinceCenterDepartment.getFounded());
			jgen.writeStringField(ProvinceCenterDepartment.MANAGER_PROPERTY,provinceCenterDepartment.getManager());
			jgen.writeNumberField(ProvinceCenterDepartment.VERSION_PROPERTY,provinceCenterDepartment.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeProvinceCenterEmployeeList(String fieldName, RetailStoreProvinceCenter retailStoreProvinceCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();
		
		if(provinceCenterEmployeeList == null){
			return;//do nothing when null found for this field.
		}
		if(provinceCenterEmployeeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ProvinceCenterEmployee provinceCenterEmployee: provinceCenterEmployeeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ProvinceCenterEmployee.ID_PROPERTY,provinceCenterEmployee.getId());
			jgen.writeStringField(ProvinceCenterEmployee.NAME_PROPERTY,provinceCenterEmployee.getName());
			jgen.writeStringField(ProvinceCenterEmployee.MOBILE_PROPERTY,provinceCenterEmployee.getMobile());
			jgen.writeStringField(ProvinceCenterEmployee.EMAIL_PROPERTY,provinceCenterEmployee.getEmail());
			jgen.writeObjectField(ProvinceCenterEmployee.FOUNDED_PROPERTY,provinceCenterEmployee.getFounded());
			jgen.writeNumberField(ProvinceCenterEmployee.VERSION_PROPERTY,provinceCenterEmployee.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreCityServiceCenterList(String fieldName, RetailStoreProvinceCenter retailStoreProvinceCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = retailStoreProvinceCenter.getRetailStoreCityServiceCenterList();
		
		if(retailStoreCityServiceCenterList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreCityServiceCenterList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenter: retailStoreCityServiceCenterList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreCityServiceCenter.ID_PROPERTY,retailStoreCityServiceCenter.getId());
			jgen.writeStringField(RetailStoreCityServiceCenter.NAME_PROPERTY,retailStoreCityServiceCenter.getName());
			jgen.writeObjectField(RetailStoreCityServiceCenter.FOUNDED_PROPERTY,retailStoreCityServiceCenter.getFounded());
			jgen.writeNumberField(RetailStoreCityServiceCenter.VERSION_PROPERTY,retailStoreCityServiceCenter.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


