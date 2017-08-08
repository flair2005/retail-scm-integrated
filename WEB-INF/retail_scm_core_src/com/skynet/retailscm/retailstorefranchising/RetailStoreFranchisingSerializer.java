
package com.skynet.retailscm.retailstorefranchising;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstore.RetailStore;


public class RetailStoreFranchisingSerializer extends BaseJsonSerializer<RetailStoreFranchising>{

	

	@Override
	public void serialize(RetailStoreFranchising retailStoreFranchising, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreFranchising,jgen,provider);
		
		jgen.writeStringField(RetailStoreFranchising.ID_PROPERTY,retailStoreFranchising.getId());
		jgen.writeStringField(RetailStoreFranchising.COMMENT_PROPERTY,retailStoreFranchising.getComment());
		jgen.writeNumberField(RetailStoreFranchising.VERSION_PROPERTY,retailStoreFranchising.getVersion());
		writeRetailStoreList(RetailStoreFranchising.RETAIL_STORE_LIST,retailStoreFranchising,jgen,provider);
		
		writeEndObject(retailStoreFranchising,jgen,provider);
	}
	
	protected void writeRetailStoreList(String fieldName, RetailStoreFranchising retailStoreFranchising, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();
		
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


