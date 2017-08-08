
package com.skynet.retailscm.retailstoremembercoupon;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoremember.RetailStoreMember;


public class RetailStoreMemberCouponSerializer extends BaseJsonSerializer<RetailStoreMemberCoupon>{

	

	@Override
	public void serialize(RetailStoreMemberCoupon retailStoreMemberCoupon, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreMemberCoupon,jgen,provider);
		
		jgen.writeStringField(RetailStoreMemberCoupon.ID_PROPERTY,retailStoreMemberCoupon.getId());
		jgen.writeStringField(RetailStoreMemberCoupon.NAME_PROPERTY,retailStoreMemberCoupon.getName());
		writeOwner(RetailStoreMemberCoupon.OWNER_PROPERTY,retailStoreMemberCoupon,jgen,provider);
		jgen.writeStringField(RetailStoreMemberCoupon.NUMBER_PROPERTY,retailStoreMemberCoupon.getNumber());
		jgen.writeNumberField(RetailStoreMemberCoupon.VERSION_PROPERTY,retailStoreMemberCoupon.getVersion());
		
		writeEndObject(retailStoreMemberCoupon,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, RetailStoreMemberCoupon retailStoreMemberCoupon, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreMember owner = retailStoreMemberCoupon.getOwner();
		
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
	
	
}


