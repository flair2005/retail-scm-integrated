
package com.skynet.retailscm.supplyorderlineitem;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.supplyorder.SupplyOrder;


public class SupplyOrderLineItemSerializer extends BaseJsonSerializer<SupplyOrderLineItem>{

	

	@Override
	public void serialize(SupplyOrderLineItem supplyOrderLineItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(supplyOrderLineItem,jgen,provider);
		
		jgen.writeStringField(SupplyOrderLineItem.ID_PROPERTY,supplyOrderLineItem.getId());
		writeBizOrder(SupplyOrderLineItem.BIZ_ORDER_PROPERTY,supplyOrderLineItem,jgen,provider);
		jgen.writeStringField(SupplyOrderLineItem.SKU_ID_PROPERTY,supplyOrderLineItem.getSkuId());
		jgen.writeStringField(SupplyOrderLineItem.SKU_NAME_PROPERTY,supplyOrderLineItem.getSkuName());
		jgen.writeNumberField(SupplyOrderLineItem.AMOUNT_PROPERTY,supplyOrderLineItem.getAmount());
		jgen.writeNumberField(SupplyOrderLineItem.QUANTITY_PROPERTY,supplyOrderLineItem.getQuantity());
		jgen.writeStringField(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY,supplyOrderLineItem.getUnitOfMeasurement());
		jgen.writeNumberField(SupplyOrderLineItem.VERSION_PROPERTY,supplyOrderLineItem.getVersion());
		
		writeEndObject(supplyOrderLineItem,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, SupplyOrderLineItem supplyOrderLineItem, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrder bizOrder = supplyOrderLineItem.getBizOrder();
		
		if(bizOrder == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplyOrder.ID_PROPERTY,bizOrder.getId()); 
		jgen.writeStringField(SupplyOrder.TITLE_PROPERTY,bizOrder.getTitle()); 
		jgen.writeNumberField(SupplyOrder.TOTAL_AMOUNT_PROPERTY,bizOrder.getTotalAmount()); 
		jgen.writeStringField(SupplyOrder.CURRENT_STATUS_PROPERTY,bizOrder.getCurrentStatus()); 
		jgen.writeNumberField(SupplyOrder.VERSION_PROPERTY,bizOrder.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


