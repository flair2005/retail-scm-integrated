
package com.skynet.retailscm.originalvoucherconfirmation;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.originalvoucher.OriginalVoucher;


public class OriginalVoucherConfirmationSerializer extends BaseJsonSerializer<OriginalVoucherConfirmation>{

	

	@Override
	public void serialize(OriginalVoucherConfirmation originalVoucherConfirmation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(originalVoucherConfirmation,jgen,provider);
		
		jgen.writeStringField(OriginalVoucherConfirmation.ID_PROPERTY,originalVoucherConfirmation.getId());
		jgen.writeStringField(OriginalVoucherConfirmation.WHO_PROPERTY,originalVoucherConfirmation.getWho());
		jgen.writeStringField(OriginalVoucherConfirmation.COMMENTS_PROPERTY,originalVoucherConfirmation.getComments());
		jgen.writeObjectField(OriginalVoucherConfirmation.MAKE_DATE_PROPERTY,originalVoucherConfirmation.getMakeDate());
		jgen.writeNumberField(OriginalVoucherConfirmation.VERSION_PROPERTY,originalVoucherConfirmation.getVersion());
		writeOriginalVoucherList(OriginalVoucherConfirmation.ORIGINAL_VOUCHER_LIST,originalVoucherConfirmation,jgen,provider);
		
		writeEndObject(originalVoucherConfirmation,jgen,provider);
	}
	
	protected void writeOriginalVoucherList(String fieldName, OriginalVoucherConfirmation originalVoucherConfirmation, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();
		
		if(originalVoucherList == null){
			return;//do nothing when null found for this field.
		}
		if(originalVoucherList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(OriginalVoucher originalVoucher: originalVoucherList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(OriginalVoucher.ID_PROPERTY,originalVoucher.getId());
			jgen.writeStringField(OriginalVoucher.TITLE_PROPERTY,originalVoucher.getTitle());
			jgen.writeStringField(OriginalVoucher.MADE_BY_PROPERTY,originalVoucher.getMadeBy());
			jgen.writeStringField(OriginalVoucher.RECEIVED_BY_PROPERTY,originalVoucher.getReceivedBy());
			jgen.writeStringField(OriginalVoucher.VOUCHER_TYPE_PROPERTY,originalVoucher.getVoucherType());
			jgen.writeStringField(OriginalVoucher.VOUCHER_IMAGE_PROPERTY,originalVoucher.getVoucherImage());
			jgen.writeStringField(OriginalVoucher.CURRENT_STATUS_PROPERTY,originalVoucher.getCurrentStatus());
			jgen.writeNumberField(OriginalVoucher.VERSION_PROPERTY,originalVoucher.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


