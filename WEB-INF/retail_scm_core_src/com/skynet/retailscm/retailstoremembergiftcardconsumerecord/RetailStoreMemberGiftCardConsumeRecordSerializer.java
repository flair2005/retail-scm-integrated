
package com.skynet.retailscm.retailstoremembergiftcardconsumerecord;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.consumerorder.ConsumerOrder;


public class RetailStoreMemberGiftCardConsumeRecordSerializer extends BaseJsonSerializer<RetailStoreMemberGiftCardConsumeRecord>{

	

	@Override
	public void serialize(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreMemberGiftCardConsumeRecord,jgen,provider);
		
		jgen.writeStringField(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getId());
		jgen.writeObjectField(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getOccureTime());
		writeOwner(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY,retailStoreMemberGiftCardConsumeRecord,jgen,provider);
		writeBizOrder(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY,retailStoreMemberGiftCardConsumeRecord,jgen,provider);
		jgen.writeStringField(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getNumber());
		jgen.writeNumberField(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getAmount());
		jgen.writeNumberField(RetailStoreMemberGiftCardConsumeRecord.VERSION_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getVersion());
		
		writeEndObject(retailStoreMemberGiftCardConsumeRecord,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreMemberGiftCard owner = retailStoreMemberGiftCardConsumeRecord.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreMemberGiftCard.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(RetailStoreMemberGiftCard.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(RetailStoreMemberGiftCard.NUMBER_PROPERTY,owner.getNumber()); 
		jgen.writeNumberField(RetailStoreMemberGiftCard.REMAIN_PROPERTY,owner.getRemain()); 
		jgen.writeNumberField(RetailStoreMemberGiftCard.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeBizOrder(String fieldName, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ConsumerOrder bizOrder = retailStoreMemberGiftCardConsumeRecord.getBizOrder();
		
		if(bizOrder == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(ConsumerOrder.ID_PROPERTY,bizOrder.getId()); 
		jgen.writeStringField(ConsumerOrder.TITLE_PROPERTY,bizOrder.getTitle()); 
		jgen.writeStringField(ConsumerOrder.CURRENT_STATUS_PROPERTY,bizOrder.getCurrentStatus()); 
		jgen.writeNumberField(ConsumerOrder.VERSION_PROPERTY,bizOrder.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


