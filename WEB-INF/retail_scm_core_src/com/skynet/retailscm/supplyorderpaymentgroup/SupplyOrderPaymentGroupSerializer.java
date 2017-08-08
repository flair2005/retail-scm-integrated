
package com.skynet.retailscm.supplyorderpaymentgroup;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.supplyorder.SupplyOrder;


public class SupplyOrderPaymentGroupSerializer extends BaseJsonSerializer<SupplyOrderPaymentGroup>{

	

	@Override
	public void serialize(SupplyOrderPaymentGroup supplyOrderPaymentGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(supplyOrderPaymentGroup,jgen,provider);
		
		jgen.writeStringField(SupplyOrderPaymentGroup.ID_PROPERTY,supplyOrderPaymentGroup.getId());
		jgen.writeStringField(SupplyOrderPaymentGroup.NAME_PROPERTY,supplyOrderPaymentGroup.getName());
		writeBizOrder(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY,supplyOrderPaymentGroup,jgen,provider);
		jgen.writeStringField(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY,supplyOrderPaymentGroup.getCardNumber());
		jgen.writeNumberField(SupplyOrderPaymentGroup.VERSION_PROPERTY,supplyOrderPaymentGroup.getVersion());
		
		writeEndObject(supplyOrderPaymentGroup,jgen,provider);
	}
	
	protected void writeBizOrder(String fieldName, SupplyOrderPaymentGroup supplyOrderPaymentGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrder bizOrder = supplyOrderPaymentGroup.getBizOrder();
		
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


