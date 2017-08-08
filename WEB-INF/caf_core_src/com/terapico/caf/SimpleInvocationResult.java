package com.terapico.caf;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleInvocationResult implements InvocationResult {

	private InvocationContext invocationContext;
	private Object actualResult;
	public void setActualResult(Object actualResult) {
		this.actualResult=actualResult;
	}
	public void setInvocationContext(InvocationContext context) {
		this.invocationContext=context;
	}
	public InvocationContext getInvocationContext() {
		return invocationContext;
	}
	public Object getActualResult() {
		
		if(actualResult==null){
			return Boolean.TRUE;
		}
		
		return actualResult;
	}
	
	public Object getResultExpr() {
		return getObjectExpr(actualResult);
	}
	
	protected String getObjectExpr(Object target) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return "class: '" + target.getClass().getName() + "'\r\n" + mapper.writeValueAsString(target);
		} catch (Throwable e) {
			return e.getMessage();
		}
	}

	
	

}
