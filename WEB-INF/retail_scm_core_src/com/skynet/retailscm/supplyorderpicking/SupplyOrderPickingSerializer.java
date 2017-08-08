
package com.skynet.retailscm.supplyorderpicking;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.supplyorder.SupplyOrder;


public class SupplyOrderPickingSerializer extends BaseJsonSerializer<SupplyOrderPicking>{

	

	@Override
	public void serialize(SupplyOrderPicking supplyOrderPicking, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(supplyOrderPicking,jgen,provider);
		
		jgen.writeStringField(SupplyOrderPicking.ID_PROPERTY,supplyOrderPicking.getId());
		jgen.writeStringField(SupplyOrderPicking.WHO_PROPERTY,supplyOrderPicking.getWho());
		jgen.writeObjectField(SupplyOrderPicking.PROCESS_TIME_PROPERTY,supplyOrderPicking.getProcessTime());
		jgen.writeNumberField(SupplyOrderPicking.VERSION_PROPERTY,supplyOrderPicking.getVersion());
		writeSupplyOrderList(SupplyOrderPicking.SUPPLY_ORDER_LIST,supplyOrderPicking,jgen,provider);
		
		writeEndObject(supplyOrderPicking,jgen,provider);
	}
	
	protected void writeSupplyOrderList(String fieldName, SupplyOrderPicking supplyOrderPicking, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();
		
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


