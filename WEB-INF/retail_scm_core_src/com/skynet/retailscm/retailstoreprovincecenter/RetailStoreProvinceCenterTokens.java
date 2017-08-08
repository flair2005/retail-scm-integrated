
package com.skynet.retailscm.retailstoreprovincecenter;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreProvinceCenterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreProvinceCenter";
	
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
	protected RetailStoreProvinceCenterTokens(){
		//ensure not initialized outside the class
	}
	
	public RetailStoreProvinceCenterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreProvinceCenterTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreProvinceCenterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RetailStoreProvinceCenterTokens start(){
		return new RetailStoreProvinceCenterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RetailStoreProvinceCenterTokens allTokens(){
		
		return start()
			.withCountry()
			.withProvinceCenterDepartmentList()
			.withProvinceCenterEmployeeList()
			.withRetailStoreCityServiceCenterList();
	
	}
	protected static RetailStoreProvinceCenterTokens withoutListsTokens(){
		
		return start()
			.withCountry();
	
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

	protected static final String COUNTRY = "country";
	public String getCountry(){
		return COUNTRY;
	}
	public RetailStoreProvinceCenterTokens withCountry(){		
		addSimpleOptions(COUNTRY);
		return this;
	}
	
	
	protected static final String PROVINCE_CENTER_DEPARTMENT_LIST = "provinceCenterDepartmentList";
	public String getProvinceCenterDepartmentList(){
		return PROVINCE_CENTER_DEPARTMENT_LIST;
	}
	public RetailStoreProvinceCenterTokens withProvinceCenterDepartmentList(){		
		addSimpleOptions(PROVINCE_CENTER_DEPARTMENT_LIST);
		return this;
	}	
		
	protected static final String PROVINCE_CENTER_EMPLOYEE_LIST = "provinceCenterEmployeeList";
	public String getProvinceCenterEmployeeList(){
		return PROVINCE_CENTER_EMPLOYEE_LIST;
	}
	public RetailStoreProvinceCenterTokens withProvinceCenterEmployeeList(){		
		addSimpleOptions(PROVINCE_CENTER_EMPLOYEE_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_CITY_SERVICE_CENTER_LIST = "retailStoreCityServiceCenterList";
	public String getRetailStoreCityServiceCenterList(){
		return RETAIL_STORE_CITY_SERVICE_CENTER_LIST;
	}
	public RetailStoreProvinceCenterTokens withRetailStoreCityServiceCenterList(){		
		addSimpleOptions(RETAIL_STORE_CITY_SERVICE_CENTER_LIST);
		return this;
	}	
		
}

