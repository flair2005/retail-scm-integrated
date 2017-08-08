
package com.skynet.retailscm.supplyordershipment;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.consumerorder.ConsumerOrder;


public class SupplyOrderShipmentSerializer extends BaseJsonSerializer<SupplyOrderShipment>{

	

	@Override
	public void serialize(SupplyOrderShipment supplyOrderShipment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(supplyOrderShipment,jgen,provider);
		
		jgen.writeStringField(SupplyOrderShipment.ID_PROPERTY,supplyOrderShipment.getId());
		jgen.writeStringField(SupplyOrderShipment.WHO_PROPERTY,supplyOrderShipment.getWho());
		jgen.writeObjectField(SupplyOrderShipment.SHIP_TIME_PROPERTY,supplyOrderShipment.getShipTime());
		jgen.writeNumberField(SupplyOrderShipment.VERSION_PROPERTY,supplyOrderShipment.getVersion());
		writeConsumerOrderList(SupplyOrderShipment.CONSUMER_ORDER_LIST,supplyOrderShipment,jgen,provider);
		writeSupplyOrderList(SupplyOrderShipment.SUPPLY_ORDER_LIST,supplyOrderShipment,jgen,provider);
		
		writeEndObject(supplyOrderShipment,jgen,provider);
	}
	
	protected void writeConsumerOrderList(String fieldName, SupplyOrderShipment supplyOrderShipment, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();
		
		if(consumerOrderList == null){
			return;//do nothing when null found for this field.
		}
		if(consumerOrderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ConsumerOrder consumerOrder: consumerOrderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ConsumerOrder.ID_PROPERTY,consumerOrder.getId());
			jgen.writeStringField(ConsumerOrder.TITLE_PROPERTY,consumerOrder.getTitle());
			jgen.writeStringField(ConsumerOrder.CURRENT_STATUS_PROPERTY,consumerOrder.getCurrentStatus());
			jgen.writeNumberField(ConsumerOrder.VERSION_PROPERTY,consumerOrder.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeSupplyOrderList(String fieldName, SupplyOrderShipment supplyOrderShipment, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();
		
		if(supplyOrderList == null){
			return;//do nothing when null found for this field.
		}
		if(supplyOrderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SupplyOrder supplyOrder: supplyOrderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SupplyOrder.ID_PROPERTY,supplyOrder.getId());
			jgen.writeStringField(SupplyOrder.TITLE_PROPERTY,supplyOrder.getTitle());
			jgen.writeNumberField(SupplyOrder.TOTAL_AMOUNT_PROPERTY,supplyOrder.getTotalAmount());
			jgen.writeStringField(SupplyOrder.CURRENT_STATUS_PROPERTY,supplyOrder.getCurrentStatus());
			jgen.writeNumberField(SupplyOrder.VERSION_PROPERTY,supplyOrder.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


