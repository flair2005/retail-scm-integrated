
package com.skynet.retailscm.catalog;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.catalog.Catalog;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.levelonecategory.LevelOneCategory;


public class CatalogSerializer extends BaseJsonSerializer<Catalog>{

	

	@Override
	public void serialize(Catalog catalog, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(catalog,jgen,provider);
		
		jgen.writeStringField(Catalog.ID_PROPERTY,catalog.getId());
		jgen.writeStringField(Catalog.DISPLAY_NAME_PROPERTY,catalog.getDisplayName());
		writeOwner(Catalog.OWNER_PROPERTY,catalog,jgen,provider);
		jgen.writeNumberField(Catalog.VERSION_PROPERTY,catalog.getVersion());
		writeLevelOneCategoryList(Catalog.LEVEL_ONE_CATEGORY_LIST,catalog,jgen,provider);
		
		writeEndObject(catalog,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, Catalog catalog, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter owner = catalog.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,owner.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,owner.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,owner.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,owner.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,owner.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,owner.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,owner.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeLevelOneCategoryList(String fieldName, Catalog catalog, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		
		if(levelOneCategoryList == null){
			return;//do nothing when null found for this field.
		}
		if(levelOneCategoryList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(LevelOneCategory levelOneCategory: levelOneCategoryList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(LevelOneCategory.ID_PROPERTY,levelOneCategory.getId());
			jgen.writeStringField(LevelOneCategory.DISPLAY_NAME_PROPERTY,levelOneCategory.getDisplayName());
			jgen.writeNumberField(LevelOneCategory.VERSION_PROPERTY,levelOneCategory.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


