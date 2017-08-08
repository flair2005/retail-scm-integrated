
package com.skynet.retailscm.supplyordershippinggroup;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.supplyorder.SupplyOrder;


public class SupplyOrderShippingGroupSerializer extends BaseJsonSerializer<SupplyOrderShippingGroup>{

	

	@Override
	public void serialize(SupplyOrderShippingGroup supplyOrderShippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(supplyOrderShippingGroup,jgen,provider);
		
		jgen.writeStringField(SupplyOrderShippingGroup.ID_PROPERTY,supplyOrderShippingGroup.getId());
		jgen.writeStringField(SupplyOrderShippingGroup.NAME_PROPERTY,supplyOrderShippingGroup.getName());
		writeBizOrder(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY,supplyOrderShippingGroup,jgen,provider);
		jgen.writeNumberField(SupplyOrderShippingGroup.AMOUNT_PROPERTY,supplyOrderShippingGroup.getAmount());
		jgen.writeNumberField(SupplyOrderShippingGroup.VERSION_PROPERTY,supplyOrderShippingGroup.getVersion());
		
		writeEndObject(supplyOrderShippingGroup,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, SupplyOrderShippingGroup supplyOrderShippingGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrder bizOrder = supplyOrderShippingGroup.getBizOrder();
		
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


