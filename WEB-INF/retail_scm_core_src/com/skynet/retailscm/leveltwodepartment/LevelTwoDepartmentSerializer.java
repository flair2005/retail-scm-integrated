
package com.skynet.retailscm.leveltwodepartment;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartment;


public class LevelTwoDepartmentSerializer extends BaseJsonSerializer<LevelTwoDepartment>{

	

	@Override
	public void serialize(LevelTwoDepartment levelTwoDepartment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(levelTwoDepartment,jgen,provider);
		
		jgen.writeStringField(LevelTwoDepartment.ID_PROPERTY,levelTwoDepartment.getId());
		writeBelongsTo(LevelTwoDepartment.BELONGS_TO_PROPERTY,levelTwoDepartment,jgen,provider);
		jgen.writeStringField(LevelTwoDepartment.NAME_PROPERTY,levelTwoDepartment.getName());
		jgen.writeStringField(LevelTwoDepartment.DESCRIPTION_PROPERTY,levelTwoDepartment.getDescription());
		jgen.writeObjectField(LevelTwoDepartment.FOUNDED_PROPERTY,levelTwoDepartment.getFounded());
		jgen.writeNumberField(LevelTwoDepartment.VERSION_PROPERTY,levelTwoDepartment.getVersion());
		writeLevelThreeDepartmentList(LevelTwoDepartment.LEVEL_THREE_DEPARTMENT_LIST,levelTwoDepartment,jgen,provider);
		
		writeEndObject(levelTwoDepartment,jgen,provider);
	}
	
	protected void writeBelongsTo(String fieldName, LevelTwoDepartment levelTwoDepartment, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		LevelOneDepartment belongsTo = levelTwoDepartment.getBelongsTo();
		
		if(belongsTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(LevelOneDepartment.ID_PROPERTY,belongsTo.getId()); 
		jgen.writeStringField(LevelOneDepartment.NAME_PROPERTY,belongsTo.getName()); 
		jgen.writeStringField(LevelOneDepartment.DESCRIPTION_PROPERTY,belongsTo.getDescription()); 
		jgen.writeStringField(LevelOneDepartment.MANAGER_PROPERTY,belongsTo.getManager()); 
		jgen.writeObjectField(LevelOneDepartment.FOUNDED_PROPERTY,belongsTo.getFounded()); 
		jgen.writeNumberField(LevelOneDepartment.VERSION_PROPERTY,belongsTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeLevelThreeDepartmentList(String fieldName, LevelTwoDepartment levelTwoDepartment, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<LevelThreeDepartment> levelThreeDepartmentList = levelTwoDepartment.getLevelThreeDepartmentList();
		
		if(levelThreeDepartmentList == null){
			return;//do nothing when null found for this field.
		}
		if(levelThreeDepartmentList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(LevelThreeDepartment levelThreeDepartment: levelThreeDepartmentList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(LevelThreeDepartment.ID_PROPERTY,levelThreeDepartment.getId());
			jgen.writeStringField(LevelThreeDepartment.NAME_PROPERTY,levelThreeDepartment.getName());
			jgen.writeStringField(LevelThreeDepartment.DESCRIPTION_PROPERTY,levelThreeDepartment.getDescription());
			jgen.writeObjectField(LevelThreeDepartment.FOUNDED_PROPERTY,levelThreeDepartment.getFounded());
			jgen.writeNumberField(LevelThreeDepartment.VERSION_PROPERTY,levelThreeDepartment.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


