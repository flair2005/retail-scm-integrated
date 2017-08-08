
package com.skynet.retailscm.retailstoreordershipment;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


public class RetailStoreOrderShipmentSerializer extends BaseJsonSerializer<RetailStoreOrderShipment>{

	

	@Override
	public void serialize(RetailStoreOrderShipment retailStoreOrderShipment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrderShipment,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrderShipment.ID_PROPERTY,retailStoreOrderShipment.getId());
		jgen.writeStringField(RetailStoreOrderShipment.WHO_PROPERTY,retailStoreOrderShipment.getWho());
		jgen.writeObjectField(RetailStoreOrderShipment.SHIP_TIME_PROPERTY,retailStoreOrderShipment.getShipTime());
		jgen.writeNumberField(RetailStoreOrderShipment.VERSION_PROPERTY,retailStoreOrderShipment.getVersion());
		writeRetailStoreOrderList(RetailStoreOrderShipment.RETAIL_STORE_ORDER_LIST,retailStoreOrderShipment,jgen,provider);
		
		writeEndObject(retailStoreOrderShipment,jgen,provider);
	}
	
	protected void writeRetailStoreOrderList(String fieldName, RetailStoreOrderShipment retailStoreOrderShipment, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();
		
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


