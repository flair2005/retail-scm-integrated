
package com.skynet.retailscm.retailstoreorderpicking;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


public class RetailStoreOrderPickingSerializer extends BaseJsonSerializer<RetailStoreOrderPicking>{

	

	@Override
	public void serialize(RetailStoreOrderPicking retailStoreOrderPicking, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrderPicking,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrderPicking.ID_PROPERTY,retailStoreOrderPicking.getId());
		jgen.writeStringField(RetailStoreOrderPicking.WHO_PROPERTY,retailStoreOrderPicking.getWho());
		jgen.writeObjectField(RetailStoreOrderPicking.PROCESS_TIME_PROPERTY,retailStoreOrderPicking.getProcessTime());
		jgen.writeNumberField(RetailStoreOrderPicking.VERSION_PROPERTY,retailStoreOrderPicking.getVersion());
		writeRetailStoreOrderList(RetailStoreOrderPicking.RETAIL_STORE_ORDER_LIST,retailStoreOrderPicking,jgen,provider);
		
		writeEndObject(retailStoreOrderPicking,jgen,provider);
	}
	
	protected void writeRetailStoreOrderList(String fieldName, RetailStoreOrderPicking retailStoreOrderPicking, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();
		
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


