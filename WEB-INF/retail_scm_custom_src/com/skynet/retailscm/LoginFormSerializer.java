package com.skynet.retailscm;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LoginFormSerializer  extends JsonSerializer<LoginForm>{

	

	
	
	@Override
	public void serialize(LoginForm loginForm, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeStringField("usernameParmeter", loginForm.getUsernameParmeter());
		jgen.writeStringField("passwordParmeter", loginForm.getPasswordParmeter());
		
		
		jgen.writeEndObject();
		
		
	}

}


