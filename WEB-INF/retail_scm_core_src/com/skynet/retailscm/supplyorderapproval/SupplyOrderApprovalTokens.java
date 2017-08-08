
package com.skynet.retailscm.supplyorderapproval;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class SupplyOrderApprovalTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplyOrderApproval";
	
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
	protected SupplyOrderApprovalTokens(){
		//ensure not initialized outside the class
	}
	
	public SupplyOrderApprovalTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SupplyOrderApprovalTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SupplyOrderApprovalTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SupplyOrderApprovalTokens start(){
		return new SupplyOrderApprovalTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SupplyOrderApprovalTokens allTokens(){
		
		return start()
			.withConsumerOrderList()
			.withSupplyOrderList();
	
	}
	protected static SupplyOrderApprovalTokens withoutListsTokens(){
		
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
	public SupplyOrderApprovalTokens withConsumerOrderList(){		
		addSimpleOptions(CONSUMER_ORDER_LIST);
		return this;
	}	
		
	protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	public String getSupplyOrderList(){
		return SUPPLY_ORDER_LIST;
	}
	public SupplyOrderApprovalTokens withSupplyOrderList(){		
		addSimpleOptions(SUPPLY_ORDER_LIST);
		return this;
	}	
		
}

