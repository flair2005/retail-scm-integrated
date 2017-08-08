
package com.skynet.retailscm.userdomain;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class UserDomainTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="userDomain";
	
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
	protected UserDomainTokens(){
		//ensure not initialized outside the class
	}
	
	public UserDomainTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static UserDomainTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected UserDomainTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static UserDomainTokens start(){
		return new UserDomainTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static UserDomainTokens allTokens(){
		
		return start()
			.withSecUserList();
	
	}
	protected static UserDomainTokens withoutListsTokens(){
		
		return start();
	
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

	protected static final String SEC_USER_LIST = "secUserList";
	public String getSecUserList(){
		return SEC_USER_LIST;
	}
	public UserDomainTokens withSecUserList(){		
		addSimpleOptions(SEC_USER_LIST);
		return this;
	}	
		
}

