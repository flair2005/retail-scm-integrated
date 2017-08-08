
package com.skynet.retailscm.levelonecategory;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.levelonecategory.LevelOneCategory;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.catalog.Catalog;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;


public class LevelOneCategorySerializer extends BaseJsonSerializer<LevelOneCategory>{

	

	@Override
	public void serialize(LevelOneCategory levelOneCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(levelOneCategory,jgen,provider);
		
		jgen.writeStringField(LevelOneCategory.ID_PROPERTY,levelOneCategory.getId());
		writeCatalog(LevelOneCategory.CATALOG_PROPERTY,levelOneCategory,jgen,provider);
		jgen.writeStringField(LevelOneCategory.DISPLAY_NAME_PROPERTY,levelOneCategory.getDisplayName());
		jgen.writeNumberField(LevelOneCategory.VERSION_PROPERTY,levelOneCategory.getVersion());
		writeLevelTwoCategoryList(LevelOneCategory.LEVEL_TWO_CATEGORY_LIST,levelOneCategory,jgen,provider);
		
		writeEndObject(levelOneCategory,jgen,provider);
	}
	
	protected void writeCatalog(String fieldName, LevelOneCategory levelOneCategory, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Catalog catalog = levelOneCategory.getCatalog();
		
		if(catalog == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Catalog.ID_PROPERTY,catalog.getId()); 
		jgen.writeStringField(Catalog.DISPLAY_NAME_PROPERTY,catalog.getDisplayName()); 
		jgen.writeNumberField(Catalog.VERSION_PROPERTY,catalog.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeLevelTwoCategoryList(String fieldName, LevelOneCategory levelOneCategory, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<LevelTwoCategory> levelTwoCategoryList = levelOneCategory.getLevelTwoCategoryList();
		
		if(levelTwoCategoryList == null){
			return;//do nothing when null found for this field.
		}
		if(levelTwoCategoryList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(LevelTwoCategory levelTwoCategory: levelTwoCategoryList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(LevelTwoCategory.ID_PROPERTY,levelTwoCategory.getId());
			jgen.writeStringField(LevelTwoCategory.DISPLAY_NAME_PROPERTY,levelTwoCategory.getDisplayName());
			jgen.writeNumberField(LevelTwoCategory.VERSION_PROPERTY,levelTwoCategory.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


