
package com.skynet.retailscm.goodssupplier;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class GoodsSupplierTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goodsSupplier";
	
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
	protected GoodsSupplierTokens(){
		//ensure not initialized outside the class
	}
	
	public GoodsSupplierTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsSupplierTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsSupplierTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static GoodsSupplierTokens start(){
		return new GoodsSupplierTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static GoodsSupplierTokens allTokens(){
		
		return start()
			.withBelongTo()
			.withSupplierProductList()
			.withSupplyOrderList()
			.withAccountSetList();
	
	}
	protected static GoodsSupplierTokens withoutListsTokens(){
		
		return start()
			.withBelongTo();
	
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

	protected static final String BELONGTO = "belongTo";
	public String getBelongTo(){
		return BELONGTO;
	}
	public GoodsSupplierTokens withBelongTo(){		
		addSimpleOptions(BELONGTO);
		return this;
	}
	
	
	protected static final String SUPPLIER_PRODUCT_LIST = "supplierProductList";
	public String getSupplierProductList(){
		return SUPPLIER_PRODUCT_LIST;
	}
	public GoodsSupplierTokens withSupplierProductList(){		
		addSimpleOptions(SUPPLIER_PRODUCT_LIST);
		return this;
	}	
		
	protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	public String getSupplyOrderList(){
		return SUPPLY_ORDER_LIST;
	}
	public GoodsSupplierTokens withSupplyOrderList(){		
		addSimpleOptions(SUPPLY_ORDER_LIST);
		return this;
	}	
		
	protected static final String ACCOUNT_SET_LIST = "accountSetList";
	public String getAccountSetList(){
		return ACCOUNT_SET_LIST;
	}
	public GoodsSupplierTokens withAccountSetList(){		
		addSimpleOptions(ACCOUNT_SET_LIST);
		return this;
	}	
		
}

