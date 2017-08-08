
package com.skynet.retailscm.secuser;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class SecUserTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="secUser";
	
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
	protected SecUserTokens(){
		//ensure not initialized outside the class
	}
	
	public SecUserTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SecUserTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SecUserTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SecUserTokens start(){
		return new SecUserTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SecUserTokens allTokens(){
		
		return start()
			.withDomain()
			.withUserAppList();
	
	}
	protected static SecUserTokens withoutListsTokens(){
		
		return start()
			.withDomain();
	
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

	protected static final String DOMAIN = "domain";
	public String getDomain(){
		return DOMAIN;
	}
	public SecUserTokens withDomain(){		
		addSimpleOptions(DOMAIN);
		return this;
	}
	
	
	protected static final String USER_APP_LIST = "userAppList";
	public String getUserAppList(){
		return USER_APP_LIST;
	}
	public SecUserTokens withUserAppList(){		
		addSimpleOptions(USER_APP_LIST);
		return this;
	}	
		
}

