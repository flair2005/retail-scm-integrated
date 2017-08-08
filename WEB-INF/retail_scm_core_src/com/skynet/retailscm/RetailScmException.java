
package com.skynet.retailscm;
import java.util.ArrayList;
import java.util.List;

public class RetailScmException extends Exception implements MessageContainer {
    static final long serialVersionUID = -1;

    public RetailScmException() {
        super();
    }


    public RetailScmException(String message) {
        super(message);
    }


    public RetailScmException(String message, Throwable cause) {
        super(message, cause);
    }


    public RetailScmException(Throwable cause) {
        super(cause);
    }
	private List<Message> errorMessageList;
    
    public List<Message> getErrorMessageList() {
		
    	ensureErrorList();
		
		return errorMessageList;
	}
	public void setErrorMessageList(List<Message> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	
	protected void ensureErrorList(){
		if(errorMessageList ==  null){
			errorMessageList =  new ArrayList<Message>();
		}
	}
	
	public void addErrorMessage(Message errorMessage) {
		ensureErrorList();
		errorMessageList.add(errorMessage);
		
	}
	public boolean hasErrors(){
		if(errorMessageList == null){
			return false;
		}
		if(errorMessageList.isEmpty()){
			return false;
		}
		return true;
	}

   
}

