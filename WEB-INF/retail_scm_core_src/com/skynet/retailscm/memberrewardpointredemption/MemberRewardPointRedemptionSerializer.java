
package com.skynet.retailscm.memberrewardpointredemption;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoremember.RetailStoreMember;


public class MemberRewardPointRedemptionSerializer extends BaseJsonSerializer<MemberRewardPointRedemption>{

	

	@Override
	public void serialize(MemberRewardPointRedemption memberRewardPointRedemption, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(memberRewardPointRedemption,jgen,provider);
		
		jgen.writeStringField(MemberRewardPointRedemption.ID_PROPERTY,memberRewardPointRedemption.getId());
		jgen.writeStringField(MemberRewardPointRedemption.NAME_PROPERTY,memberRewardPointRedemption.getName());
		jgen.writeNumberField(MemberRewardPointRedemption.POINT_PROPERTY,memberRewardPointRedemption.getPoint());
		writeOwner(MemberRewardPointRedemption.OWNER_PROPERTY,memberRewardPointRedemption,jgen,provider);
		jgen.writeNumberField(MemberRewardPointRedemption.VERSION_PROPERTY,memberRewardPointRedemption.getVersion());
		
		writeEndObject(memberRewardPointRedemption,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, MemberRewardPointRedemption memberRewardPointRedemption, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreMember owner = memberRewardPointRedemption.getOwner();
		
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


