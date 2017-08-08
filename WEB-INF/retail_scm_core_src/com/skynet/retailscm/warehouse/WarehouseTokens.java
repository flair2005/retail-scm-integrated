
package com.skynet.retailscm.warehouse;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class WarehouseTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="warehouse";
	
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
	protected WarehouseTokens(){
		//ensure not initialized outside the class
	}
	
	public WarehouseTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static WarehouseTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected WarehouseTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static WarehouseTokens start(){
		return new WarehouseTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static WarehouseTokens allTokens(){
		
		return start()
			.withOwner()
			.withStorageSpaceList()
			.withSmartPalletList()
			.withSupplierSpaceList()
			.withReceivingSpaceList()
			.withShippingSpaceList()
			.withDamageSpaceList()
			.withWarehouseAssetList();
	
	}
	protected static WarehouseTokens withoutListsTokens(){
		
		return start()
			.withOwner();
	
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

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	public WarehouseTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
	protected static final String STORAGE_SPACE_LIST = "storageSpaceList";
	public String getStorageSpaceList(){
		return STORAGE_SPACE_LIST;
	}
	public WarehouseTokens withStorageSpaceList(){		
		addSimpleOptions(STORAGE_SPACE_LIST);
		return this;
	}	
		
	protected static final String SMART_PALLET_LIST = "smartPalletList";
	public String getSmartPalletList(){
		return SMART_PALLET_LIST;
	}
	public WarehouseTokens withSmartPalletList(){		
		addSimpleOptions(SMART_PALLET_LIST);
		return this;
	}	
		
	protected static final String SUPPLIER_SPACE_LIST = "supplierSpaceList";
	public String getSupplierSpaceList(){
		return SUPPLIER_SPACE_LIST;
	}
	public WarehouseTokens withSupplierSpaceList(){		
		addSimpleOptions(SUPPLIER_SPACE_LIST);
		return this;
	}	
		
	protected static final String RECEIVING_SPACE_LIST = "receivingSpaceList";
	public String getReceivingSpaceList(){
		return RECEIVING_SPACE_LIST;
	}
	public WarehouseTokens withReceivingSpaceList(){		
		addSimpleOptions(RECEIVING_SPACE_LIST);
		return this;
	}	
		
	protected static final String SHIPPING_SPACE_LIST = "shippingSpaceList";
	public String getShippingSpaceList(){
		return SHIPPING_SPACE_LIST;
	}
	public WarehouseTokens withShippingSpaceList(){		
		addSimpleOptions(SHIPPING_SPACE_LIST);
		return this;
	}	
		
	protected static final String DAMAGE_SPACE_LIST = "damageSpaceList";
	public String getDamageSpaceList(){
		return DAMAGE_SPACE_LIST;
	}
	public WarehouseTokens withDamageSpaceList(){		
		addSimpleOptions(DAMAGE_SPACE_LIST);
		return this;
	}	
		
	protected static final String WAREHOUSE_ASSET_LIST = "warehouseAssetList";
	public String getWarehouseAssetList(){
		return WAREHOUSE_ASSET_LIST;
	}
	public WarehouseTokens withWarehouseAssetList(){		
		addSimpleOptions(WAREHOUSE_ASSET_LIST);
		return this;
	}	
		
}

