
package com.skynet.retailscm.responsibilitytype;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class ResponsibilityTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="responsibilityType";
	
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
	protected ResponsibilityTypeTokens(){
		//ensure not initialized outside the class
	}
	
	public ResponsibilityTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ResponsibilityTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ResponsibilityTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ResponsibilityTypeTokens start(){
		return new ResponsibilityTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ResponsibilityTypeTokens allTokens(){
		
		return start()
			.withCompany()
			.withEmployeeList();
	
	}
	protected static ResponsibilityTypeTokens withoutListsTokens(){
		
		return start()
			.withCompany();
	
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

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	public ResponsibilityTypeTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String EMPLOYEE_LIST = "employeeList";
	public String getEmployeeList(){
		return EMPLOYEE_LIST;
	}
	public ResponsibilityTypeTokens withEmployeeList(){		
		addSimpleOptions(EMPLOYEE_LIST);
		return this;
	}	
		
}

