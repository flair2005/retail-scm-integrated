
package com.skynet.retailscm.secuser;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.secuser.SecUser;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.userdomain.UserDomain;
import com.skynet.retailscm.userapp.UserApp;


public class SecUserSerializer extends BaseJsonSerializer<SecUser>{

	

	@Override
	public void serialize(SecUser secUser, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(secUser,jgen,provider);
		
		jgen.writeStringField(SecUser.ID_PROPERTY,secUser.getId());
		jgen.writeStringField(SecUser.LOGIN_PROPERTY,secUser.getLogin());
		jgen.writeStringField(SecUser.MOBILE_PROPERTY,secUser.getMobile());
		jgen.writeStringField(SecUser.EMAIL_PROPERTY,secUser.getEmail());
		jgen.writeStringField(SecUser.PWD_PROPERTY,secUser.getPwd());
		jgen.writeObjectField(SecUser.LAST_LOGIN_PROPERTY,secUser.getLastLogin());
		writeDomain(SecUser.DOMAIN_PROPERTY,secUser,jgen,provider);
		jgen.writeNumberField(SecUser.VERSION_PROPERTY,secUser.getVersion());
		writeUserAppList(SecUser.USER_APP_LIST,secUser,jgen,provider);
		
		writeEndObject(secUser,jgen,provider);
	}
	
	protected void writeDomain(String fieldName, SecUser secUser, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		UserDomain domain = secUser.getDomain();
		
		if(domain == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(UserDomain.ID_PROPERTY,domain.getId()); 
		jgen.writeStringField(UserDomain.NAME_PROPERTY,domain.getName()); 
		jgen.writeNumberField(UserDomain.VERSION_PROPERTY,domain.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeUserAppList(String fieldName, SecUser secUser, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<UserApp> userAppList = secUser.getUserAppList();
		
		if(userAppList == null){
			return;//do nothing when null found for this field.
		}
		if(userAppList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(UserApp userApp: userAppList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(UserApp.ID_PROPERTY,userApp.getId());
			jgen.writeStringField(UserApp.TITLE_PROPERTY,userApp.getTitle());
			jgen.writeStringField(UserApp.APP_ICON_PROPERTY,userApp.getAppIcon());
			jgen.writeBooleanField(UserApp.FULL_ACCESS_PROPERTY,userApp.getFullAccess());
			jgen.writeStringField(UserApp.PERMISSION_PROPERTY,userApp.getPermission());
			jgen.writeStringField(UserApp.OBJECT_TYPE_PROPERTY,userApp.getObjectType());
			jgen.writeStringField(UserApp.OBJECT_ID_PROPERTY,userApp.getObjectId());
			jgen.writeStringField(UserApp.LOCATION_PROPERTY,userApp.getLocation());
			jgen.writeNumberField(UserApp.VERSION_PROPERTY,userApp.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


