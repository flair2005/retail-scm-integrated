
package com.skynet.retailscm.potentialcustomer;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class PotentialCustomerTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="potentialCustomer";
	
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
	protected PotentialCustomerTokens(){
		//ensure not initialized outside the class
	}
	
	public PotentialCustomerTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PotentialCustomerTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PotentialCustomerTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PotentialCustomerTokens start(){
		return new PotentialCustomerTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PotentialCustomerTokens allTokens(){
		
		return start()
			.withCityServiceCenter()
			.withCityPartner()
			.withPotentialCustomerContactPersonList()
			.withPotentialCustomerContactList()
			.withEventAttendanceList();
	
	}
	protected static PotentialCustomerTokens withoutListsTokens(){
		
		return start()
			.withCityServiceCenter()
			.withCityPartner();
	
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
	public PotentialCustomerTokens withCityServiceCenter(){		
		addSimpleOptions(CITYSERVICECENTER);
		return this;
	}
	
	
	protected static final String CITYPARTNER = "cityPartner";
	public String getCityPartner(){
		return CITYPARTNER;
	}
	public PotentialCustomerTokens withCityPartner(){		
		addSimpleOptions(CITYPARTNER);
		return this;
	}
	
	
	protected static final String POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST = "potentialCustomerContactPersonList";
	public String getPotentialCustomerContactPersonList(){
		return POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST;
	}
	public PotentialCustomerTokens withPotentialCustomerContactPersonList(){		
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
		return this;
	}	
		
	protected static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";
	public String getPotentialCustomerContactList(){
		return POTENTIAL_CUSTOMER_CONTACT_LIST;
	}
	public PotentialCustomerTokens withPotentialCustomerContactList(){		
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
		return this;
	}	
		
	protected static final String EVENT_ATTENDANCE_LIST = "eventAttendanceList";
	public String getEventAttendanceList(){
		return EVENT_ATTENDANCE_LIST;
	}
	public PotentialCustomerTokens withEventAttendanceList(){		
		addSimpleOptions(EVENT_ATTENDANCE_LIST);
		return this;
	}	
		
}

