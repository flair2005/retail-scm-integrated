
package com.skynet.retailscm.citypartner;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class CityPartnerTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="cityPartner";
	
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
	protected CityPartnerTokens(){
		//ensure not initialized outside the class
	}
	
	public CityPartnerTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static CityPartnerTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected CityPartnerTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static CityPartnerTokens start(){
		return new CityPartnerTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static CityPartnerTokens allTokens(){
		
		return start()
			.withCityServiceCenter()
			.withPotentialCustomerList()
			.withPotentialCustomerContactList();
	
	}
	protected static CityPartnerTokens withoutListsTokens(){
		
		return start()
			.withCityServiceCenter();
	
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

	protected static final String CITYSERVICECENTER = "cityServiceCenter";
	public String getCityServiceCenter(){
		return CITYSERVICECENTER;
	}
	public CityPartnerTokens withCityServiceCenter(){		
		addSimpleOptions(CITYSERVICECENTER);
		return this;
	}
	
	
	protected static final String POTENTIAL_CUSTOMER_LIST = "potentialCustomerList";
	public String getPotentialCustomerList(){
		return POTENTIAL_CUSTOMER_LIST;
	}
	public CityPartnerTokens withPotentialCustomerList(){		
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST);
		return this;
	}	
		
	protected static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";
	public String getPotentialCustomerContactList(){
		return POTENTIAL_CUSTOMER_CONTACT_LIST;
	}
	public CityPartnerTokens withPotentialCustomerContactList(){		
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
		return this;
	}	
		
}

