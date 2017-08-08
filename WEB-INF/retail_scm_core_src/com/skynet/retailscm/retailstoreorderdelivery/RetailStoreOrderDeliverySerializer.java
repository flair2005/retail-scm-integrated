
package com.skynet.retailscm.retailstoreorderdelivery;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


public class RetailStoreOrderDeliverySerializer extends BaseJsonSerializer<RetailStoreOrderDelivery>{

	

	@Override
	public void serialize(RetailStoreOrderDelivery retailStoreOrderDelivery, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrderDelivery,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrderDelivery.ID_PROPERTY,retailStoreOrderDelivery.getId());
		jgen.writeStringField(RetailStoreOrderDelivery.WHO_PROPERTY,retailStoreOrderDelivery.getWho());
		jgen.writeObjectField(RetailStoreOrderDelivery.DELIVERY_TIME_PROPERTY,retailStoreOrderDelivery.getDeliveryTime());
		jgen.writeNumberField(RetailStoreOrderDelivery.VERSION_PROPERTY,retailStoreOrderDelivery.getVersion());
		writeRetailStoreOrderList(RetailStoreOrderDelivery.RETAIL_STORE_ORDER_LIST,retailStoreOrderDelivery,jgen,provider);
		
		writeEndObject(retailStoreOrderDelivery,jgen,provider);
	}
	
	protected void writeRetailStoreOrderList(String fieldName, RetailStoreOrderDelivery retailStoreOrderDelivery, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();
		
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


