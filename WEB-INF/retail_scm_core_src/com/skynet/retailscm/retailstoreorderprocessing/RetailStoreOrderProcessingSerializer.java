
package com.skynet.retailscm.retailstoreorderprocessing;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


public class RetailStoreOrderProcessingSerializer extends BaseJsonSerializer<RetailStoreOrderProcessing>{

	

	@Override
	public void serialize(RetailStoreOrderProcessing retailStoreOrderProcessing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrderProcessing,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrderProcessing.ID_PROPERTY,retailStoreOrderProcessing.getId());
		jgen.writeStringField(RetailStoreOrderProcessing.WHO_PROPERTY,retailStoreOrderProcessing.getWho());
		jgen.writeObjectField(RetailStoreOrderProcessing.PROCESS_TIME_PROPERTY,retailStoreOrderProcessing.getProcessTime());
		jgen.writeNumberField(RetailStoreOrderProcessing.VERSION_PROPERTY,retailStoreOrderProcessing.getVersion());
		writeRetailStoreOrderList(RetailStoreOrderProcessing.RETAIL_STORE_ORDER_LIST,retailStoreOrderProcessing,jgen,provider);
		
		writeEndObject(retailStoreOrderProcessing,jgen,provider);
	}
	
	protected void writeRetailStoreOrderList(String fieldName, RetailStoreOrderProcessing retailStoreOrderProcessing, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();
		
		if(retailStoreOrderList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreOrderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreOrder.ID_PROPERTY,retailStoreOrder.getId());
			jgen.writeStringField(RetailStoreOrder.TITLE_PROPERTY,retailStoreOrder.getTitle());
			jgen.writeNumberField(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY,retailStoreOrder.getTotalAmount());
			jgen.writeStringField(RetailStoreOrder.CURRENT_STATUS_PROPERTY,retailStoreOrder.getCurrentStatus());
			jgen.writeNumberField(RetailStoreOrder.VERSION_PROPERTY,retailStoreOrder.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


