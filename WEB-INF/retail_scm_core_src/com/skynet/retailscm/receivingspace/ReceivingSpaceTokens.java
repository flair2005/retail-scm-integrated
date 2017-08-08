
package com.skynet.retailscm.receivingspace;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class ReceivingSpaceTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="receivingSpace";
	
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
	protected ReceivingSpaceTokens(){
		//ensure not initialized outside the class
	}
	
	public ReceivingSpaceTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ReceivingSpaceTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ReceivingSpaceTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ReceivingSpaceTokens start(){
		return new ReceivingSpaceTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ReceivingSpaceTokens allTokens(){
		
		return start()
			.withWarehouse()
			.withGoodsList();
	
	}
	protected static ReceivingSpaceTokens withoutListsTokens(){
		
		return start()
			.withWarehouse();
	
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

	protected static final String WAREHOUSE = "warehouse";
	public String getWarehouse(){
		return WAREHOUSE;
	}
	public ReceivingSpaceTokens withWarehouse(){		
		addSimpleOptions(WAREHOUSE);
		return this;
	}
	
	
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public ReceivingSpaceTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}	
		
}

