
package com.skynet.retailscm.goodsshelf;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class GoodsShelfTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goodsShelf";
	
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
	protected GoodsShelfTokens(){
		//ensure not initialized outside the class
	}
	
	public GoodsShelfTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsShelfTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsShelfTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static GoodsShelfTokens start(){
		return new GoodsShelfTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static GoodsShelfTokens allTokens(){
		
		return start()
			.withStorageSpace()
			.withSupplierSpace()
			.withDamageSpace()
			.withGoodsShelfStockCountList()
			.withGoodsAllocationList();
	
	}
	protected static GoodsShelfTokens withoutListsTokens(){
		
		return start()
			.withStorageSpace()
			.withSupplierSpace()
			.withDamageSpace();
	
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

	protected static final String STORAGESPACE = "storageSpace";
	public String getStorageSpace(){
		return STORAGESPACE;
	}
	public GoodsShelfTokens withStorageSpace(){		
		addSimpleOptions(STORAGESPACE);
		return this;
	}
	
	
	protected static final String SUPPLIERSPACE = "supplierSpace";
	public String getSupplierSpace(){
		return SUPPLIERSPACE;
	}
	public GoodsShelfTokens withSupplierSpace(){		
		addSimpleOptions(SUPPLIERSPACE);
		return this;
	}
	
	
	protected static final String DAMAGESPACE = "damageSpace";
	public String getDamageSpace(){
		return DAMAGESPACE;
	}
	public GoodsShelfTokens withDamageSpace(){		
		addSimpleOptions(DAMAGESPACE);
		return this;
	}
	
	
	protected static final String GOODS_SHELF_STOCK_COUNT_LIST = "goodsShelfStockCountList";
	public String getGoodsShelfStockCountList(){
		return GOODS_SHELF_STOCK_COUNT_LIST;
	}
	public GoodsShelfTokens withGoodsShelfStockCountList(){		
		addSimpleOptions(GOODS_SHELF_STOCK_COUNT_LIST);
		return this;
	}	
		
	protected static final String GOODS_ALLOCATION_LIST = "goodsAllocationList";
	public String getGoodsAllocationList(){
		return GOODS_ALLOCATION_LIST;
	}
	public GoodsShelfTokens withGoodsAllocationList(){		
		addSimpleOptions(GOODS_ALLOCATION_LIST);
		return this;
	}	
		
}

