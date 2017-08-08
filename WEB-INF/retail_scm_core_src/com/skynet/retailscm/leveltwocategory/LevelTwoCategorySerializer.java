
package com.skynet.retailscm.leveltwocategory;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.levelonecategory.LevelOneCategory;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;


public class LevelTwoCategorySerializer extends BaseJsonSerializer<LevelTwoCategory>{

	

	@Override
	public void serialize(LevelTwoCategory levelTwoCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(levelTwoCategory,jgen,provider);
		
		jgen.writeStringField(LevelTwoCategory.ID_PROPERTY,levelTwoCategory.getId());
		writeParentCategory(LevelTwoCategory.PARENT_CATEGORY_PROPERTY,levelTwoCategory,jgen,provider);
		jgen.writeStringField(LevelTwoCategory.DISPLAY_NAME_PROPERTY,levelTwoCategory.getDisplayName());
		jgen.writeNumberField(LevelTwoCategory.VERSION_PROPERTY,levelTwoCategory.getVersion());
		writeLevelThreeCategoryList(LevelTwoCategory.LEVEL_THREE_CATEGORY_LIST,levelTwoCategory,jgen,provider);
		
		writeEndObject(levelTwoCategory,jgen,provider);
	}
	
	protected void writeParentCategory(String fieldName, LevelTwoCategory levelTwoCategory, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		LevelOneCategory parentCategory = levelTwoCategory.getParentCategory();
		
		if(parentCategory == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(LevelOneCategory.ID_PROPERTY,parentCategory.getId()); 
		jgen.writeStringField(LevelOneCategory.DISPLAY_NAME_PROPERTY,parentCategory.getDisplayName()); 
		jgen.writeNumberField(LevelOneCategory.VERSION_PROPERTY,parentCategory.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeLevelThreeCategoryList(String fieldName, LevelTwoCategory levelTwoCategory, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<LevelThreeCategory> levelThreeCategoryList = levelTwoCategory.getLevelThreeCategoryList();
		
		if(levelThreeCategoryList == null){
			return;//do nothing when null found for this field.
		}
		if(levelThreeCategoryList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(LevelThreeCategory levelThreeCategory: levelThreeCategoryList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(LevelThreeCategory.ID_PROPERTY,levelThreeCategory.getId());
			jgen.writeStringField(LevelThreeCategory.DISPLAY_NAME_PROPERTY,levelThreeCategory.getDisplayName());
			jgen.writeNumberField(LevelThreeCategory.VERSION_PROPERTY,levelThreeCategory.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


