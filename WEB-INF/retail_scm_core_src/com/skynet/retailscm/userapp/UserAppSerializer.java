
package com.skynet.retailscm.userapp;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.userapp.UserApp;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.secuser.SecUser;
import com.skynet.retailscm.objectaccess.ObjectAccess;


public class UserAppSerializer extends BaseJsonSerializer<UserApp>{

	

	@Override
	public void serialize(UserApp userApp, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(userApp,jgen,provider);
		
		jgen.writeStringField(UserApp.ID_PROPERTY,userApp.getId());
		jgen.writeStringField(UserApp.TITLE_PROPERTY,userApp.getTitle());
		writeSecUser(UserApp.SEC_USER_PROPERTY,userApp,jgen,provider);
		jgen.writeStringField(UserApp.APP_ICON_PROPERTY,userApp.getAppIcon());
		jgen.writeBooleanField(UserApp.FULL_ACCESS_PROPERTY,userApp.getFullAccess());
		jgen.writeStringField(UserApp.PERMISSION_PROPERTY,userApp.getPermission());
		jgen.writeStringField(UserApp.OBJECT_TYPE_PROPERTY,userApp.getObjectType());
		jgen.writeStringField(UserApp.OBJECT_ID_PROPERTY,userApp.getObjectId());
		jgen.writeStringField(UserApp.LOCATION_PROPERTY,userApp.getLocation());
		jgen.writeNumberField(UserApp.VERSION_PROPERTY,userApp.getVersion());
		writeObjectAccessList(UserApp.OBJECT_ACCESS_LIST,userApp,jgen,provider);
		
		writeEndObject(userApp,jgen,provider);
	}
	
	protected void writeSecUser(String fieldName, UserApp userApp, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SecUser secUser = userApp.getSecUser();
		
		if(secUser == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SecUser.ID_PROPERTY,secUser.getId()); 
		jgen.writeStringField(SecUser.LOGIN_PROPERTY,secUser.getLogin()); 
		jgen.writeStringField(SecUser.MOBILE_PROPERTY,secUser.getMobile()); 
		jgen.writeStringField(SecUser.EMAIL_PROPERTY,secUser.getEmail()); 
		jgen.writeStringField(SecUser.PWD_PROPERTY,secUser.getPwd()); 
		jgen.writeObjectField(SecUser.LAST_LOGIN_PROPERTY,secUser.getLastLogin()); 
		jgen.writeNumberField(SecUser.VERSION_PROPERTY,secUser.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeObjectAccessList(String fieldName, UserApp userApp, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ObjectAccess> objectAccessList = userApp.getObjectAccessList();
		
		if(objectAccessList == null){
			return;//do nothing when null found for this field.
		}
		if(objectAccessList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ObjectAccess objectAccess: objectAccessList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ObjectAccess.ID_PROPERTY,objectAccess.getId());
			jgen.writeStringField(ObjectAccess.DISPLAY_NAME_PROPERTY,objectAccess.getDisplayName());
			jgen.writeStringField(ObjectAccess.OBJECT_TYPE_PROPERTY,objectAccess.getObjectType());
			jgen.writeStringField(ObjectAccess.LIST1_PROPERTY,objectAccess.getList1());
			jgen.writeStringField(ObjectAccess.LIST2_PROPERTY,objectAccess.getList2());
			jgen.writeStringField(ObjectAccess.LIST3_PROPERTY,objectAccess.getList3());
			jgen.writeStringField(ObjectAccess.LIST4_PROPERTY,objectAccess.getList4());
			jgen.writeStringField(ObjectAccess.LIST5_PROPERTY,objectAccess.getList5());
			jgen.writeStringField(ObjectAccess.LIST6_PROPERTY,objectAccess.getList6());
			jgen.writeStringField(ObjectAccess.LIST7_PROPERTY,objectAccess.getList7());
			jgen.writeStringField(ObjectAccess.LIST8_PROPERTY,objectAccess.getList8());
			jgen.writeStringField(ObjectAccess.LIST9_PROPERTY,objectAccess.getList9());
			jgen.writeNumberField(ObjectAccess.VERSION_PROPERTY,objectAccess.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


