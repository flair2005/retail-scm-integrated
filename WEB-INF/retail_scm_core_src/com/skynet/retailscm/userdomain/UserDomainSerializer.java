
package com.skynet.retailscm.userdomain;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.userdomain.UserDomain;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.secuser.SecUser;


public class UserDomainSerializer extends BaseJsonSerializer<UserDomain>{

	

	@Override
	public void serialize(UserDomain userDomain, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(userDomain,jgen,provider);
		
		jgen.writeStringField(UserDomain.ID_PROPERTY,userDomain.getId());
		jgen.writeStringField(UserDomain.NAME_PROPERTY,userDomain.getName());
		jgen.writeNumberField(UserDomain.VERSION_PROPERTY,userDomain.getVersion());
		writeSecUserList(UserDomain.SEC_USER_LIST,userDomain,jgen,provider);
		
		writeEndObject(userDomain,jgen,provider);
	}
	
	protected void writeSecUserList(String fieldName, UserDomain userDomain, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SecUser> secUserList = userDomain.getSecUserList();
		
		if(secUserList == null){
			return;//do nothing when null found for this field.
		}
		if(secUserList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SecUser secUser: secUserList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SecUser.ID_PROPERTY,secUser.getId());
			jgen.writeStringField(SecUser.LOGIN_PROPERTY,secUser.getLogin());
			jgen.writeStringField(SecUser.MOBILE_PROPERTY,secUser.getMobile());
			jgen.writeStringField(SecUser.EMAIL_PROPERTY,secUser.getEmail());
			jgen.writeStringField(SecUser.PWD_PROPERTY,secUser.getPwd());
			jgen.writeObjectField(SecUser.LAST_LOGIN_PROPERTY,secUser.getLastLogin());
			jgen.writeNumberField(SecUser.VERSION_PROPERTY,secUser.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


