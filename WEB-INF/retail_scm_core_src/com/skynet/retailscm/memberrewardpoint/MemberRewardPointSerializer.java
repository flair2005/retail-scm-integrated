
package com.skynet.retailscm.memberrewardpoint;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.memberrewardpoint.MemberRewardPoint;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoremember.RetailStoreMember;


public class MemberRewardPointSerializer extends BaseJsonSerializer<MemberRewardPoint>{

	

	@Override
	public void serialize(MemberRewardPoint memberRewardPoint, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(memberRewardPoint,jgen,provider);
		
		jgen.writeStringField(MemberRewardPoint.ID_PROPERTY,memberRewardPoint.getId());
		jgen.writeStringField(MemberRewardPoint.NAME_PROPERTY,memberRewardPoint.getName());
		jgen.writeNumberField(MemberRewardPoint.POINT_PROPERTY,memberRewardPoint.getPoint());
		writeOwner(MemberRewardPoint.OWNER_PROPERTY,memberRewardPoint,jgen,provider);
		jgen.writeNumberField(MemberRewardPoint.VERSION_PROPERTY,memberRewardPoint.getVersion());
		
		writeEndObject(memberRewardPoint,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, MemberRewardPoint memberRewardPoint, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreMember owner = memberRewardPoint.getOwner();
		
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


