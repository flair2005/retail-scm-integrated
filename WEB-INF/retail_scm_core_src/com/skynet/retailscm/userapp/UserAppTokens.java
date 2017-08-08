
package com.skynet.retailscm.userapp;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class UserAppTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="userApp";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected UserAppTokens(){
		//ensure not initialized outside the class
	}
	
	public UserAppTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static UserAppTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected UserAppTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static UserAppTokens start(){
		return new UserAppTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static UserAppTokens allTokens(){
		
		return start()
			.withSecUser()
			.withObjectAccessList();
	
	}
	protected static UserAppTokens withoutListsTokens(){
		
		return start()
			.withSecUser();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String SECUSER = "secUser";
	public String getSecUser(){
		return SECUSER;
	}
	public UserAppTokens withSecUser(){		
		addSimpleOptions(SECUSER);
		return this;
	}
	
	
	protected static final String OBJECT_ACCESS_LIST = "objectAccessList";
	public String getObjectAccessList(){
		return OBJECT_ACCESS_LIST;
	}
	public UserAppTokens withObjectAccessList(){		
		addSimpleOptions(OBJECT_ACCESS_LIST);
		return this;
	}	
		
}

