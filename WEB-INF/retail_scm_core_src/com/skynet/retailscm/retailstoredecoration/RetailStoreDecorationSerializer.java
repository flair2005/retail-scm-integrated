
package com.skynet.retailscm.retailstoredecoration;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstore.RetailStore;


public class RetailStoreDecorationSerializer extends BaseJsonSerializer<RetailStoreDecoration>{

	

	@Override
	public void serialize(RetailStoreDecoration retailStoreDecoration, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreDecoration,jgen,provider);
		
		jgen.writeStringField(RetailStoreDecoration.ID_PROPERTY,retailStoreDecoration.getId());
		jgen.writeStringField(RetailStoreDecoration.COMMENT_PROPERTY,retailStoreDecoration.getComment());
		jgen.writeNumberField(RetailStoreDecoration.VERSION_PROPERTY,retailStoreDecoration.getVersion());
		writeRetailStoreList(RetailStoreDecoration.RETAIL_STORE_LIST,retailStoreDecoration,jgen,provider);
		
		writeEndObject(retailStoreDecoration,jgen,provider);
	}
	
	protected void writeRetailStoreList(String fieldName, RetailStoreDecoration retailStoreDecoration, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();
		
		if(retailStoreList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStore retailStore: retailStoreList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStore.ID_PROPERTY,retailStore.getId());
			jgen.writeStringField(RetailStore.NAME_PROPERTY,retailStore.getName());
			jgen.writeStringField(RetailStore.TELEPHONE_PROPERTY,retailStore.getTelephone());
			jgen.writeStringField(RetailStore.OWNER_PROPERTY,retailStore.getOwner());
			jgen.writeObjectField(RetailStore.FOUNDED_PROPERTY,retailStore.getFounded());
			jgen.writeNumberField(RetailStore.LATITUDE_PROPERTY,retailStore.getLatitude());
			jgen.writeNumberField(RetailStore.LONGITUDE_PROPERTY,retailStore.getLongitude());
			jgen.writeStringField(RetailStore.DESCRIPTION_PROPERTY,retailStore.getDescription());
			jgen.writeStringField(RetailStore.CURRENT_STATUS_PROPERTY,retailStore.getCurrentStatus());
			jgen.writeNumberField(RetailStore.VERSION_PROPERTY,retailStore.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


