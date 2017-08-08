
package com.skynet.retailscm.damagespace;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class DamageSpaceTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="damageSpace";
	
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
	protected DamageSpaceTokens(){
		//ensure not initialized outside the class
	}
	
	public DamageSpaceTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static DamageSpaceTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected DamageSpaceTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static DamageSpaceTokens start(){
		return new DamageSpaceTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static DamageSpaceTokens allTokens(){
		
		return start()
			.withWarehouse()
			.withGoodsShelfList();
	
	}
	protected static DamageSpaceTokens withoutListsTokens(){
		
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
	public DamageSpaceTokens withWarehouse(){		
		addSimpleOptions(WAREHOUSE);
		return this;
	}
	
	
	protected static final String GOODS_SHELF_LIST = "goodsShelfList";
	public String getGoodsShelfList(){
		return GOODS_SHELF_LIST;
	}
	public DamageSpaceTokens withGoodsShelfList(){		
		addSimpleOptions(GOODS_SHELF_LIST);
		return this;
	}	
		
}

