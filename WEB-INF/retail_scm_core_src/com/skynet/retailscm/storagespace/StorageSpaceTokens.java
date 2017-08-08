
package com.skynet.retailscm.storagespace;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class StorageSpaceTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="storageSpace";
	
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
	protected StorageSpaceTokens(){
		//ensure not initialized outside the class
	}
	
	public StorageSpaceTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static StorageSpaceTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected StorageSpaceTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static StorageSpaceTokens start(){
		return new StorageSpaceTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static StorageSpaceTokens allTokens(){
		
		return start()
			.withWarehouse()
			.withGoodsShelfList();
	
	}
	protected static StorageSpaceTokens withoutListsTokens(){
		
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
	public StorageSpaceTokens withWarehouse(){		
		addSimpleOptions(WAREHOUSE);
		return this;
	}
	
	
	protected static final String GOODS_SHELF_LIST = "goodsShelfList";
	public String getGoodsShelfList(){
		return GOODS_SHELF_LIST;
	}
	public StorageSpaceTokens withGoodsShelfList(){		
		addSimpleOptions(GOODS_SHELF_LIST);
		return this;
	}	
		
}

