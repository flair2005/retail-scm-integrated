
package com.skynet.retailscm.smartpallet;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class SmartPalletTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="smartPallet";
	
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
	protected SmartPalletTokens(){
		//ensure not initialized outside the class
	}
	
	public SmartPalletTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SmartPalletTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SmartPalletTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SmartPalletTokens start(){
		return new SmartPalletTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SmartPalletTokens allTokens(){
		
		return start()
			.withWarehouse()
			.withGoodsList();
	
	}
	protected static SmartPalletTokens withoutListsTokens(){
		
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
	public SmartPalletTokens withWarehouse(){		
		addSimpleOptions(WAREHOUSE);
		return this;
	}
	
	
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public SmartPalletTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}	
		
}

