
package com.skynet.retailscm.retailstoreordershippinggroup;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


public class RetailStoreOrderShippingGroupSerializer extends BaseJsonSerializer<RetailStoreOrderShippingGroup>{

	

	@Override
	public void serialize(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrderShippingGroup,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrderShippingGroup.ID_PROPERTY,retailStoreOrderShippingGroup.getId());
		jgen.writeStringField(RetailStoreOrderShippingGroup.NAME_PROPERTY,retailStoreOrderShippingGroup.getName());
		writeBizOrder(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY,retailStoreOrderShippingGroup,jgen,provider);
		jgen.writeNumberField(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY,retailStoreOrderShippingGroup.getAmount());
		jgen.writeNumberField(RetailStoreOrderShippingGroup.VERSION_PROPERTY,retailStoreOrderShippingGroup.getVersion());
		
		writeEndObject(retailStoreOrderShippingGroup,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrder bizOrder = retailStoreOrderShippingGroup.getBizOrder();
		
		if(bizOrder == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOrder.ID_PROPERTY,bizOrder.getId()); 
		jgen.writeStringField(RetailStoreOrder.TITLE_PROPERTY,bizOrder.getTitle()); 
		jgen.writeNumberField(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY,bizOrder.getTotalAmount()); 
		jgen.writeStringField(RetailStoreOrder.CURRENT_STATUS_PROPERTY,bizOrder.getCurrentStatus()); 
		jgen.writeNumberField(RetailStoreOrder.VERSION_PROPERTY,bizOrder.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


