
package com.skynet.retailscm.retailstoreorderpaymentgroup;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


public class RetailStoreOrderPaymentGroupSerializer extends BaseJsonSerializer<RetailStoreOrderPaymentGroup>{

	

	@Override
	public void serialize(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrderPaymentGroup,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrderPaymentGroup.ID_PROPERTY,retailStoreOrderPaymentGroup.getId());
		jgen.writeStringField(RetailStoreOrderPaymentGroup.NAME_PROPERTY,retailStoreOrderPaymentGroup.getName());
		writeBizOrder(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY,retailStoreOrderPaymentGroup,jgen,provider);
		jgen.writeStringField(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY,retailStoreOrderPaymentGroup.getCardNumber());
		jgen.writeNumberField(RetailStoreOrderPaymentGroup.VERSION_PROPERTY,retailStoreOrderPaymentGroup.getVersion());
		
		writeEndObject(retailStoreOrderPaymentGroup,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrder bizOrder = retailStoreOrderPaymentGroup.getBizOrder();
		
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


