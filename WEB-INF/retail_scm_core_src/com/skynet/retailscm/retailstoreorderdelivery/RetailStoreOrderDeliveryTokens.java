
package com.skynet.retailscm.retailstoreorderdelivery;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreOrderDeliveryTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreOrderDelivery";
	
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
	protected RetailStoreOrderDeliveryTokens(){
		//ensure not initialized outside the class
	}
	
	public RetailStoreOrderDeliveryTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreOrderDeliveryTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreOrderDeliveryTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RetailStoreOrderDeliveryTokens start(){
		return new RetailStoreOrderDeliveryTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RetailStoreOrderDeliveryTokens allTokens(){
		
		return start()
			.withRetailStoreOrderList();
	
	}
	protected static RetailStoreOrderDeliveryTokens withoutListsTokens(){
		
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

	protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	public String getRetailStoreOrderList(){
		return RETAIL_STORE_ORDER_LIST;
	}
	public RetailStoreOrderDeliveryTokens withRetailStoreOrderList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST);
		return this;
	}	
		
}

