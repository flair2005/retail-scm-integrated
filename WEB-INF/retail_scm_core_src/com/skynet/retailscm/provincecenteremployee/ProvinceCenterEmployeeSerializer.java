
package com.skynet.retailscm.provincecenteremployee;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;


public class ProvinceCenterEmployeeSerializer extends BaseJsonSerializer<ProvinceCenterEmployee>{

	

	@Override
	public void serialize(ProvinceCenterEmployee provinceCenterEmployee, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(provinceCenterEmployee,jgen,provider);
		
		jgen.writeStringField(ProvinceCenterEmployee.ID_PROPERTY,provinceCenterEmployee.getId());
		jgen.writeStringField(ProvinceCenterEmployee.NAME_PROPERTY,provinceCenterEmployee.getName());
		jgen.writeStringField(ProvinceCenterEmployee.MOBILE_PROPERTY,provinceCenterEmployee.getMobile());
		jgen.writeStringField(ProvinceCenterEmployee.EMAIL_PROPERTY,provinceCenterEmployee.getEmail());
		jgen.writeObjectField(ProvinceCenterEmployee.FOUNDED_PROPERTY,provinceCenterEmployee.getFounded());
		writeDepartment(ProvinceCenterEmployee.DEPARTMENT_PROPERTY,provinceCenterEmployee,jgen,provider);
		writeProvinceCenter(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY,provinceCenterEmployee,jgen,provider);
		jgen.writeNumberField(ProvinceCenterEmployee.VERSION_PROPERTY,provinceCenterEmployee.getVersion());
		
		writeEndObject(provinceCenterEmployee,jgen,provider);
	}
	
	protected void writeDepartment(String fieldName, ProvinceCenterEmployee provinceCenterEmployee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ProvinceCenterDepartment department = provinceCenterEmployee.getDepartment();
		
		if(department == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(ProvinceCenterDepartment.ID_PROPERTY,department.getId()); 
		jgen.writeStringField(ProvinceCenterDepartment.NAME_PROPERTY,department.getName()); 
		jgen.writeObjectField(ProvinceCenterDepartment.FOUNDED_PROPERTY,department.getFounded()); 
		jgen.writeStringField(ProvinceCenterDepartment.MANAGER_PROPERTY,department.getManager()); 
		jgen.writeNumberField(ProvinceCenterDepartment.VERSION_PROPERTY,department.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProvinceCenter(String fieldName, ProvinceCenterEmployee provinceCenterEmployee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreProvinceCenter provinceCenter = provinceCenterEmployee.getProvinceCenter();
		
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
	
	
}


