
package com.skynet.retailscm.objectaccess;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.objectaccess.ObjectAccess;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.userapp.UserApp;


public class ObjectAccessSerializer extends BaseJsonSerializer<ObjectAccess>{

	

	@Override
	public void serialize(ObjectAccess objectAccess, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(objectAccess,jgen,provider);
		
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
		writeApp(ObjectAccess.APP_PROPERTY,objectAccess,jgen,provider);
		jgen.writeNumberField(ObjectAccess.VERSION_PROPERTY,objectAccess.getVersion());
		
		writeEndObject(objectAccess,jgen,provider);
	}
	
	protected void writeApp(String fieldName, ObjectAccess objectAccess, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		UserApp app = objectAccess.getApp();
		
		if(app == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(UserApp.ID_PROPERTY,app.getId()); 
		jgen.writeStringField(UserApp.TITLE_PROPERTY,app.getTitle()); 
		jgen.writeStringField(UserApp.APP_ICON_PROPERTY,app.getAppIcon()); 
		jgen.writeBooleanField(UserApp.FULL_ACCESS_PROPERTY,app.getFullAccess()); 
		jgen.writeStringField(UserApp.PERMISSION_PROPERTY,app.getPermission()); 
		jgen.writeStringField(UserApp.OBJECT_TYPE_PROPERTY,app.getObjectType()); 
		jgen.writeStringField(UserApp.OBJECT_ID_PROPERTY,app.getObjectId()); 
		jgen.writeStringField(UserApp.LOCATION_PROPERTY,app.getLocation()); 
		jgen.writeNumberField(UserApp.VERSION_PROPERTY,app.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


