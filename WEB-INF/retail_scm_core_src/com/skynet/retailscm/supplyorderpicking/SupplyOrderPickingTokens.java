
package com.skynet.retailscm.supplyorderpicking;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class SupplyOrderPickingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplyOrderPicking";
	
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
	protected SupplyOrderPickingTokens(){
		//ensure not initialized outside the class
	}
	
	public SupplyOrderPickingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SupplyOrderPickingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SupplyOrderPickingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SupplyOrderPickingTokens start(){
		return new SupplyOrderPickingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SupplyOrderPickingTokens allTokens(){
		
		return start()
			.withSupplyOrderList();
	
	}
	protected static SupplyOrderPickingTokens withoutListsTokens(){
		
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

	protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	public String getSupplyOrderList(){
		return SUPPLY_ORDER_LIST;
	}
	public SupplyOrderPickingTokens withSupplyOrderList(){		
		addSimpleOptions(SUPPLY_ORDER_LIST);
		return this;
	}	
		
}

