package com.skynet.retailscm;
public class Message {
	
	
	
	
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSourcePostion() {
		return sourcePostion;
	}

	protected String body;
	protected String level; //level is info, success, warning and danger as well
	protected String subject; 
	//subject is like 
	
	public String getBody() {
		return body;
	}

	public void setBody(String messageBody) {
		this.body = messageBody;
	}
	
	protected String sourcePostion;
	protected Object[] parameters;

	public String getSourcePosition() {
		return sourcePostion;
	}
	
	public void setSourcePostion(String sourcePosition) {
		this.sourcePostion = sourcePosition;
	}
	
	public Object[] getParameters() {
		return parameters;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
	public String getFirstParam(){
		if(parameters==null){
			return null;
		}
		if(parameters.length<1){
			return null;
		}
		return (String)parameters[0];
	}
	public void setFirstParam(String newValue){
		if(parameters==null){
			return ;
		}
		if(parameters.length<1){
			return;
		}
		 parameters[0] = newValue;
	}
	
	
	
}




