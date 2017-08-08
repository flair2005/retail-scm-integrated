
package com.skynet.retailscm.provincecenterdepartment;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class ProvinceCenterDepartmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="provinceCenterDepartment";
	
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
	protected ProvinceCenterDepartmentTokens(){
		//ensure not initialized outside the class
	}
	
	public ProvinceCenterDepartmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProvinceCenterDepartmentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProvinceCenterDepartmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProvinceCenterDepartmentTokens start(){
		return new ProvinceCenterDepartmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProvinceCenterDepartmentTokens allTokens(){
		
		return start()
			.withProvinceCenter()
			.withProvinceCenterEmployeeList();
	
	}
	protected static ProvinceCenterDepartmentTokens withoutListsTokens(){
		
		return start()
			.withProvinceCenter();
	
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

	protected static final String PROVINCECENTER = "provinceCenter";
	public String getProvinceCenter(){
		return PROVINCECENTER;
	}
	public ProvinceCenterDepartmentTokens withProvinceCenter(){		
		addSimpleOptions(PROVINCECENTER);
		return this;
	}
	
	
	protected static final String PROVINCE_CENTER_EMPLOYEE_LIST = "provinceCenterEmployeeList";
	public String getProvinceCenterEmployeeList(){
		return PROVINCE_CENTER_EMPLOYEE_LIST;
	}
	public ProvinceCenterDepartmentTokens withProvinceCenterEmployeeList(){		
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST);
		return this;
	}	
		
}

