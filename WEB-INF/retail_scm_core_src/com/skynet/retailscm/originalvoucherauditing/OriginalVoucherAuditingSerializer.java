
package com.skynet.retailscm.originalvoucherauditing;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.originalvoucher.OriginalVoucher;


public class OriginalVoucherAuditingSerializer extends BaseJsonSerializer<OriginalVoucherAuditing>{

	

	@Override
	public void serialize(OriginalVoucherAuditing originalVoucherAuditing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(originalVoucherAuditing,jgen,provider);
		
		jgen.writeStringField(OriginalVoucherAuditing.ID_PROPERTY,originalVoucherAuditing.getId());
		jgen.writeStringField(OriginalVoucherAuditing.WHO_PROPERTY,originalVoucherAuditing.getWho());
		jgen.writeStringField(OriginalVoucherAuditing.COMMENTS_PROPERTY,originalVoucherAuditing.getComments());
		jgen.writeObjectField(OriginalVoucherAuditing.MAKE_DATE_PROPERTY,originalVoucherAuditing.getMakeDate());
		jgen.writeNumberField(OriginalVoucherAuditing.VERSION_PROPERTY,originalVoucherAuditing.getVersion());
		writeOriginalVoucherList(OriginalVoucherAuditing.ORIGINAL_VOUCHER_LIST,originalVoucherAuditing,jgen,provider);
		
		writeEndObject(originalVoucherAuditing,jgen,provider);
	}
	
	protected void writeOriginalVoucherList(String fieldName, OriginalVoucherAuditing originalVoucherAuditing, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();
		
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


