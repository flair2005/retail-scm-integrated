
package com.skynet.retailscm.retailstoreorderapproval;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


public class RetailStoreOrderApprovalSerializer extends BaseJsonSerializer<RetailStoreOrderApproval>{

	

	@Override
	public void serialize(RetailStoreOrderApproval retailStoreOrderApproval, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreOrderApproval,jgen,provider);
		
		jgen.writeStringField(RetailStoreOrderApproval.ID_PROPERTY,retailStoreOrderApproval.getId());
		jgen.writeStringField(RetailStoreOrderApproval.WHO_PROPERTY,retailStoreOrderApproval.getWho());
		jgen.writeObjectField(RetailStoreOrderApproval.APPROVE_TIME_PROPERTY,retailStoreOrderApproval.getApproveTime());
		jgen.writeNumberField(RetailStoreOrderApproval.VERSION_PROPERTY,retailStoreOrderApproval.getVersion());
		writeRetailStoreOrderList(RetailStoreOrderApproval.RETAIL_STORE_ORDER_LIST,retailStoreOrderApproval,jgen,provider);
		
		writeEndObject(retailStoreOrderApproval,jgen,provider);
	}
	
	protected void writeRetailStoreOrderList(String fieldName, RetailStoreOrderApproval retailStoreOrderApproval, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();
		
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


