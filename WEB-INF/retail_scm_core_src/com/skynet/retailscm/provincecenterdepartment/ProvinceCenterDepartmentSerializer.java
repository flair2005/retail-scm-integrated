
package com.skynet.retailscm.provincecenterdepartment;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;


public class ProvinceCenterDepartmentSerializer extends BaseJsonSerializer<ProvinceCenterDepartment>{

	

	@Override
	public void serialize(ProvinceCenterDepartment provinceCenterDepartment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(provinceCenterDepartment,jgen,provider);
		
		jgen.writeStringField(ProvinceCenterDepartment.ID_PROPERTY,provinceCenterDepartment.getId());
		jgen.writeStringField(ProvinceCenterDepartment.NAME_PROPERTY,provinceCenterDepartment.getName());
		jgen.writeObjectField(ProvinceCenterDepartment.FOUNDED_PROPERTY,provinceCenterDepartment.getFounded());
		writeProvinceCenter(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY,provinceCenterDepartment,jgen,provider);
		jgen.writeStringField(ProvinceCenterDepartment.MANAGER_PROPERTY,provinceCenterDepartment.getManager());
		jgen.writeNumberField(ProvinceCenterDepartment.VERSION_PROPERTY,provinceCenterDepartment.getVersion());
		writeProvinceCenterEmployeeList(ProvinceCenterDepartment.PROVINCE_CENTER_EMPLOYEE_LIST,provinceCenterDepartment,jgen,provider);
		
		writeEndObject(provinceCenterDepartment,jgen,provider);
	}
	
	protected void writeProvinceCenter(String fieldName, ProvinceCenterDepartment provinceCenterDepartment, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreProvinceCenter provinceCenter = provinceCenterDepartment.getProvinceCenter();
		
		if(provinceCenter == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreProvinceCenter.ID_PROPERTY,provinceCenter.getId()); 
		jgen.writeStringField(RetailStoreProvinceCenter.NAME_PROPERTY,provinceCenter.getName()); 
		jgen.writeObjectField(RetailStoreProvinceCenter.FOUNDED_PROPERTY,provinceCenter.getFounded()); 
		jgen.writeNumberField(RetailStoreProvinceCenter.VERSION_PROPERTY,provinceCenter.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProvinceCenterEmployeeList(String fieldName, ProvinceCenterDepartment provinceCenterDepartment, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();
		
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
	
}


