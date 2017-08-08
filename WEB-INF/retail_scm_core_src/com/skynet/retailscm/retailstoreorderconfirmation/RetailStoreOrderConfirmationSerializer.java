
package com.skynet.retailscm.retailstoreorderconfirmation;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


public class RetailStoreOrderConfirmationSerializer extends BaseJsonSerializer<RetailStoreOrderConfirmation>{

	

	@Override
	public void serialize(RetailStoreOrderConfirmation retailStoreOrderConfirmation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrderConfirmation,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrderConfirmation.ID_PROPERTY,retailStoreOrderConfirmation.getId());
		jgen.writeStringField(RetailStoreOrderConfirmation.WHO_PROPERTY,retailStoreOrderConfirmation.getWho());
		jgen.writeObjectField(RetailStoreOrderConfirmation.CONFIRM_TIME_PROPERTY,retailStoreOrderConfirmation.getConfirmTime());
		jgen.writeNumberField(RetailStoreOrderConfirmation.VERSION_PROPERTY,retailStoreOrderConfirmation.getVersion());
		writeRetailStoreOrderList(RetailStoreOrderConfirmation.RETAIL_STORE_ORDER_LIST,retailStoreOrderConfirmation,jgen,provider);
		
		writeEndObject(retailStoreOrderConfirmation,jgen,provider);
	}
	
	protected void writeRetailStoreOrderList(String fieldName, RetailStoreOrderConfirmation retailStoreOrderConfirmation, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();
		
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


