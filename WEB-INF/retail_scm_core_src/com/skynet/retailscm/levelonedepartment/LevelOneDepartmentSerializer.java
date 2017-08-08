
package com.skynet.retailscm.levelonedepartment;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartment;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;


public class LevelOneDepartmentSerializer extends BaseJsonSerializer<LevelOneDepartment>{

	

	@Override
	public void serialize(LevelOneDepartment levelOneDepartment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(levelOneDepartment,jgen,provider);
		
		jgen.writeStringField(LevelOneDepartment.ID_PROPERTY,levelOneDepartment.getId());
		writeBelongsTo(LevelOneDepartment.BELONGS_TO_PROPERTY,levelOneDepartment,jgen,provider);
		jgen.writeStringField(LevelOneDepartment.NAME_PROPERTY,levelOneDepartment.getName());
		jgen.writeStringField(LevelOneDepartment.DESCRIPTION_PROPERTY,levelOneDepartment.getDescription());
		jgen.writeStringField(LevelOneDepartment.MANAGER_PROPERTY,levelOneDepartment.getManager());
		jgen.writeObjectField(LevelOneDepartment.FOUNDED_PROPERTY,levelOneDepartment.getFounded());
		jgen.writeNumberField(LevelOneDepartment.VERSION_PROPERTY,levelOneDepartment.getVersion());
		writeLevelTwoDepartmentList(LevelOneDepartment.LEVEL_TWO_DEPARTMENT_LIST,levelOneDepartment,jgen,provider);
		
		writeEndObject(levelOneDepartment,jgen,provider);
	}
	
	protected void writeBelongsTo(String fieldName, LevelOneDepartment levelOneDepartment, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter belongsTo = levelOneDepartment.getBelongsTo();
		
		if(belongsTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,belongsTo.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,belongsTo.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,belongsTo.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,belongsTo.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,belongsTo.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,belongsTo.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,belongsTo.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,belongsTo.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,belongsTo.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,belongsTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeLevelTwoDepartmentList(String fieldName, LevelOneDepartment levelOneDepartment, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<LevelTwoDepartment> levelTwoDepartmentList = levelOneDepartment.getLevelTwoDepartmentList();
		
		if(levelTwoDepartmentList == null){
			return;//do nothing when null found for this field.
		}
		if(levelTwoDepartmentList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(LevelTwoDepartment levelTwoDepartment: levelTwoDepartmentList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(LevelTwoDepartment.ID_PROPERTY,levelTwoDepartment.getId());
			jgen.writeStringField(LevelTwoDepartment.NAME_PROPERTY,levelTwoDepartment.getName());
			jgen.writeStringField(LevelTwoDepartment.DESCRIPTION_PROPERTY,levelTwoDepartment.getDescription());
			jgen.writeObjectField(LevelTwoDepartment.FOUNDED_PROPERTY,levelTwoDepartment.getFounded());
			jgen.writeNumberField(LevelTwoDepartment.VERSION_PROPERTY,levelTwoDepartment.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


