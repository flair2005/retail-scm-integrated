
package com.skynet.retailscm.retailstoreopening;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpening;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstore.RetailStore;


public class RetailStoreOpeningSerializer extends BaseJsonSerializer<RetailStoreOpening>{

	

	@Override
	public void serialize(RetailStoreOpening retailStoreOpening, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOpening,jgen,provider);
		
		jgen.writeStringField(RetailStoreOpening.ID_PROPERTY,retailStoreOpening.getId());
		jgen.writeStringField(RetailStoreOpening.COMMENT_PROPERTY,retailStoreOpening.getComment());
		jgen.writeNumberField(RetailStoreOpening.VERSION_PROPERTY,retailStoreOpening.getVersion());
		writeRetailStoreList(RetailStoreOpening.RETAIL_STORE_LIST,retailStoreOpening,jgen,provider);
		
		writeEndObject(retailStoreOpening,jgen,provider);
	}
	
	protected void writeRetailStoreList(String fieldName, RetailStoreOpening retailStoreOpening, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
		
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


