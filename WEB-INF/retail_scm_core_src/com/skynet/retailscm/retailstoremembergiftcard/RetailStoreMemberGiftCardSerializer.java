
package com.skynet.retailscm.retailstoremembergiftcard;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;


public class RetailStoreMemberGiftCardSerializer extends BaseJsonSerializer<RetailStoreMemberGiftCard>{

	

	@Override
	public void serialize(RetailStoreMemberGiftCard retailStoreMemberGiftCard, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreMemberGiftCard,jgen,provider);
		
		jgen.writeStringField(RetailStoreMemberGiftCard.ID_PROPERTY,retailStoreMemberGiftCard.getId());
		jgen.writeStringField(RetailStoreMemberGiftCard.NAME_PROPERTY,retailStoreMemberGiftCard.getName());
		writeOwner(RetailStoreMemberGiftCard.OWNER_PROPERTY,retailStoreMemberGiftCard,jgen,provider);
		jgen.writeStringField(RetailStoreMemberGiftCard.NUMBER_PROPERTY,retailStoreMemberGiftCard.getNumber());
		jgen.writeNumberField(RetailStoreMemberGiftCard.REMAIN_PROPERTY,retailStoreMemberGiftCard.getRemain());
		jgen.writeNumberField(RetailStoreMemberGiftCard.VERSION_PROPERTY,retailStoreMemberGiftCard.getVersion());
		writeRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCard.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST,retailStoreMemberGiftCard,jgen,provider);
		
		writeEndObject(retailStoreMemberGiftCard,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, RetailStoreMemberGiftCard retailStoreMemberGiftCard, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreMember owner = retailStoreMemberGiftCard.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreMember.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(RetailStoreMember.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(RetailStoreMember.MOBILE_PHONE_PROPERTY,owner.getMobilePhone()); 
		jgen.writeNumberField(RetailStoreMember.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeRetailStoreMemberGiftCardConsumeRecordList(String fieldName, RetailStoreMemberGiftCard retailStoreMemberGiftCard, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();
		
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord: retailStoreMemberGiftCardConsumeRecordList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getId());
			jgen.writeObjectField(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getOccureTime());
			jgen.writeStringField(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getNumber());
			jgen.writeNumberField(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getAmount());
			jgen.writeNumberField(RetailStoreMemberGiftCardConsumeRecord.VERSION_PROPERTY,retailStoreMemberGiftCardConsumeRecord.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


