
package com.skynet.retailscm.employeeboarding;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class EmployeeBoardingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="employeeBoarding";
	
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
	protected EmployeeBoardingTokens(){
		//ensure not initialized outside the class
	}
	
	public EmployeeBoardingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static EmployeeBoardingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected EmployeeBoardingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static EmployeeBoardingTokens start(){
		return new EmployeeBoardingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static EmployeeBoardingTokens allTokens(){
		
		return start()
			.withEmployeeList();
	
	}
	protected static EmployeeBoardingTokens withoutListsTokens(){
		
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

	protected static final String EMPLOYEE_LIST = "employeeList";
	public String getEmployeeList(){
		return EMPLOYEE_LIST;
	}
	public EmployeeBoardingTokens withEmployeeList(){		
		addSimpleOptions(EMPLOYEE_LIST);
		return this;
	}	
		
}

