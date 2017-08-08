
package com.skynet.retailscm.shippingspace;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class ShippingSpaceTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="shippingSpace";
	
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
	protected ShippingSpaceTokens(){
		//ensure not initialized outside the class
	}
	
	public ShippingSpaceTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ShippingSpaceTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ShippingSpaceTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ShippingSpaceTokens start(){
		return new ShippingSpaceTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ShippingSpaceTokens allTokens(){
		
		return start()
			.withWarehouse()
			.withGoodsList();
	
	}
	protected static ShippingSpaceTokens withoutListsTokens(){
		
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
	public ShippingSpaceTokens withWarehouse(){		
		addSimpleOptions(WAREHOUSE);
		return this;
	}
	
	
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public ShippingSpaceTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}	
		
}

