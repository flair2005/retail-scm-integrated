
package com.skynet.retailscm.retailstorecityservicecenter;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreCityServiceCenterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreCityServiceCenter";
	
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
	protected RetailStoreCityServiceCenterTokens(){
		//ensure not initialized outside the class
	}
	
	public RetailStoreCityServiceCenterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreCityServiceCenterTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreCityServiceCenterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RetailStoreCityServiceCenterTokens start(){
		return new RetailStoreCityServiceCenterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RetailStoreCityServiceCenterTokens allTokens(){
		
		return start()
			.withBelongsTo()
			.withCityPartnerList()
			.withPotentialCustomerList()
			.withCityEventList()
			.withRetailStoreList();
	
	}
	protected static RetailStoreCityServiceCenterTokens withoutListsTokens(){
		
		return start()
			.withBelongsTo();
	
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

	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	public RetailStoreCityServiceCenterTokens withBelongsTo(){		
		addSimpleOptions(BELONGSTO);
		return this;
	}
	
	
	protected static final String CITY_PARTNER_LIST = "cityPartnerList";
	public String getCityPartnerList(){
		return CITY_PARTNER_LIST;
	}
	public RetailStoreCityServiceCenterTokens withCityPartnerList(){		
		addSimpleOptions(CITY_PARTNER_LIST);
		return this;
	}	
		
	protected static final String POTENTIAL_CUSTOMER_LIST = "potentialCustomerList";
	public String getPotentialCustomerList(){
		return POTENTIAL_CUSTOMER_LIST;
	}
	public RetailStoreCityServiceCenterTokens withPotentialCustomerList(){		
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST);
		return this;
	}	
		
	protected static final String CITY_EVENT_LIST = "cityEventList";
	public String getCityEventList(){
		return CITY_EVENT_LIST;
	}
	public RetailStoreCityServiceCenterTokens withCityEventList(){		
		addSimpleOptions(CITY_EVENT_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_LIST = "retailStoreList";
	public String getRetailStoreList(){
		return RETAIL_STORE_LIST;
	}
	public RetailStoreCityServiceCenterTokens withRetailStoreList(){		
		addSimpleOptions(RETAIL_STORE_LIST);
		return this;
	}	
		
}

