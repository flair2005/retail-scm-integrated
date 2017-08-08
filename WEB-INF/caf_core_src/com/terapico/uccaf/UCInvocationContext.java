package com.terapico.uccaf;

import com.terapico.caf.SimpleInvocationContext;

public class UCInvocationContext extends SimpleInvocationContext {
	private BaseUserContext userContext;

	public void setUserContext(BaseUserContext userContext){
		this.userContext = userContext;
	}
	public BaseUserContext getUserContext(){
		return this.userContext;
	}
}
