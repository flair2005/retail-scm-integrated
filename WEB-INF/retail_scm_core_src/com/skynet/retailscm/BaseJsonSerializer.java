package com.skynet.retailscm;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public abstract class BaseJsonSerializer<T extends BaseEntity> extends JsonSerializer<T> {

	@Override
	public void serialize(BaseEntity baseEntity, JsonGenerator jgen,
			SerializerProvider serialierProvider) throws IOException,
			JsonProcessingException {
		//the method must stay here for compiling
	}
	
	private static final String CLASS = "class";
	
	
	protected void writeStartObject(BaseEntity baseEntity, JsonGenerator jgen,SerializerProvider provider)throws IOException,JsonProcessingException{
		jgen.writeStartObject();
		writeStringField(CLASS,baseEntity,jgen,provider);
	}
	
	private static final String ACTION_LIST = "actionList";
	protected void writeEndObject(BaseEntity baseEntity, JsonGenerator jgen,SerializerProvider provider)throws IOException,JsonProcessingException{
		
		writeActionList(ACTION_LIST,baseEntity,jgen,provider);
		jgen.writeEndObject();
	}
	protected void writeStringField(String fieldName, BaseEntity baseEntity,
			JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		if(baseEntity == null){
			return; //do nothing when base entity is null
		}
		
		jgen.writeStringField(fieldName,baseEntity.getClass().getName());
		
	}
	
	
	protected void writeActionList(String fieldName, BaseEntity baseEntity,
			JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		if(baseEntity == null){
			return; //do nothing when base entity is null
		}
	
		List<Action> actionList = baseEntity.getActionList();

		if (actionList == null) {
			return;// do nothing when null found for this field.
		}
		if (actionList.isEmpty()) {
			return;// do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		// start an array [
		for (Action action : actionList) {

			jgen.writeStartObject();// {
			
			jgen.writeStringField("actionName", action.getActionName());
			jgen.writeStringField("actionPath", action.getActionPath());
			jgen.writeStringField("actionKey", action.getActionKey());
			jgen.writeStringField("localeKey", action.getLocaleKey());
			jgen.writeStringField("actionGroup", action.getActionGroup());
			jgen.writeStringField("actionLevel", action.getActionLevel());

			jgen.writeEndObject();//

		}
		jgen.writeEndArray();
		// end the array ]
	}

	
}








