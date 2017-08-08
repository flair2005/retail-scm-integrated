
package com.skynet.retailscm.originalvouchercreation;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.originalvoucher.OriginalVoucher;


public class OriginalVoucherCreationSerializer extends BaseJsonSerializer<OriginalVoucherCreation>{

	

	@Override
	public void serialize(OriginalVoucherCreation originalVoucherCreation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(originalVoucherCreation,jgen,provider);
		
		jgen.writeStringField(OriginalVoucherCreation.ID_PROPERTY,originalVoucherCreation.getId());
		jgen.writeStringField(OriginalVoucherCreation.WHO_PROPERTY,originalVoucherCreation.getWho());
		jgen.writeStringField(OriginalVoucherCreation.COMMENTS_PROPERTY,originalVoucherCreation.getComments());
		jgen.writeObjectField(OriginalVoucherCreation.MAKE_DATE_PROPERTY,originalVoucherCreation.getMakeDate());
		jgen.writeNumberField(OriginalVoucherCreation.VERSION_PROPERTY,originalVoucherCreation.getVersion());
		writeOriginalVoucherList(OriginalVoucherCreation.ORIGINAL_VOUCHER_LIST,originalVoucherCreation,jgen,provider);
		
		writeEndObject(originalVoucherCreation,jgen,provider);
	}
	
	protected void writeOriginalVoucherList(String fieldName, OriginalVoucherCreation originalVoucherCreation, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<OriginalVoucher> originalVoucherList = originalVoucherCreation.getOriginalVoucherList();
		
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


