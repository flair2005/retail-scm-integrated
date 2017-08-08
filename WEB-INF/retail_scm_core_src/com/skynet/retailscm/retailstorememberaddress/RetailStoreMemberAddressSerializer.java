
package com.skynet.retailscm.retailstorememberaddress;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoremember.RetailStoreMember;


public class RetailStoreMemberAddressSerializer extends BaseJsonSerializer<RetailStoreMemberAddress>{

	

	@Override
	public void serialize(RetailStoreMemberAddress retailStoreMemberAddress, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreMemberAddress,jgen,provider);
		
		jgen.writeStringField(RetailStoreMemberAddress.ID_PROPERTY,retailStoreMemberAddress.getId());
		jgen.writeStringField(RetailStoreMemberAddress.NAME_PROPERTY,retailStoreMemberAddress.getName());
		writeOwner(RetailStoreMemberAddress.OWNER_PROPERTY,retailStoreMemberAddress,jgen,provider);
		jgen.writeStringField(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY,retailStoreMemberAddress.getMobilePhone());
		jgen.writeStringField(RetailStoreMemberAddress.ADDRESS_PROPERTY,retailStoreMemberAddress.getAddress());
		jgen.writeNumberField(RetailStoreMemberAddress.VERSION_PROPERTY,retailStoreMemberAddress.getVersion());
		
		writeEndObject(retailStoreMemberAddress,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, RetailStoreMemberAddress retailStoreMemberAddress, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreMember owner = retailStoreMemberAddress.getOwner();
		
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


