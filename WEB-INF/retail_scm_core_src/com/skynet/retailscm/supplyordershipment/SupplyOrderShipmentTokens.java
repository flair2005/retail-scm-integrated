
package com.skynet.retailscm.supplyordershipment;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class SupplyOrderShipmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplyOrderShipment";
	
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
	protected SupplyOrderShipmentTokens(){
		//ensure not initialized outside the class
	}
	
	public SupplyOrderShipmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SupplyOrderShipmentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SupplyOrderShipmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SupplyOrderShipmentTokens start(){
		return new SupplyOrderShipmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SupplyOrderShipmentTokens allTokens(){
		
		return start()
			.withConsumerOrderList()
			.withSupplyOrderList();
	
	}
	protected static SupplyOrderShipmentTokens withoutListsTokens(){
		
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

	protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	public String getConsumerOrderList(){
		return CONSUMER_ORDER_LIST;
	}
	public SupplyOrderShipmentTokens withConsumerOrderList(){		
		addSimpleOptions(CONSUMER_ORDER_LIST);
		return this;
	}	
		
	protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	public String getSupplyOrderList(){
		return SUPPLY_ORDER_LIST;
	}
	public SupplyOrderShipmentTokens withSupplyOrderList(){		
		addSimpleOptions(SUPPLY_ORDER_LIST);
		return this;
	}	
		
}

