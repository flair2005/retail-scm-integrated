
package com.skynet.retailscm.goods;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class GoodsTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goods";
	
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
	protected GoodsTokens(){
		//ensure not initialized outside the class
	}
	
	public GoodsTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static GoodsTokens start(){
		return new GoodsTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static GoodsTokens allTokens(){
		
		return start()
			.withSku()
			.withReceivingSpace()
			.withGoodsAllocation()
			.withSmartPallet()
			.withShippingSpace()
			.withTransportTask()
			.withRetailStore()
			.withBizOrder()
			.withRetailStoreOrder()
			.withPackaging()
			.withGoodsMovementList();
	
	}
	protected static GoodsTokens withoutListsTokens(){
		
		return start()
			.withSku()
			.withReceivingSpace()
			.withGoodsAllocation()
			.withSmartPallet()
			.withShippingSpace()
			.withTransportTask()
			.withRetailStore()
			.withBizOrder()
			.withRetailStoreOrder()
			.withPackaging();
	
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

	protected static final String SKU = "sku";
	public String getSku(){
		return SKU;
	}
	public GoodsTokens withSku(){		
		addSimpleOptions(SKU);
		return this;
	}
	
	
	protected static final String RECEIVINGSPACE = "receivingSpace";
	public String getReceivingSpace(){
		return RECEIVINGSPACE;
	}
	public GoodsTokens withReceivingSpace(){		
		addSimpleOptions(RECEIVINGSPACE);
		return this;
	}
	
	
	protected static final String GOODSALLOCATION = "goodsAllocation";
	public String getGoodsAllocation(){
		return GOODSALLOCATION;
	}
	public GoodsTokens withGoodsAllocation(){		
		addSimpleOptions(GOODSALLOCATION);
		return this;
	}
	
	
	protected static final String SMARTPALLET = "smartPallet";
	public String getSmartPallet(){
		return SMARTPALLET;
	}
	public GoodsTokens withSmartPallet(){		
		addSimpleOptions(SMARTPALLET);
		return this;
	}
	
	
	protected static final String SHIPPINGSPACE = "shippingSpace";
	public String getShippingSpace(){
		return SHIPPINGSPACE;
	}
	public GoodsTokens withShippingSpace(){		
		addSimpleOptions(SHIPPINGSPACE);
		return this;
	}
	
	
	protected static final String TRANSPORTTASK = "transportTask";
	public String getTransportTask(){
		return TRANSPORTTASK;
	}
	public GoodsTokens withTransportTask(){		
		addSimpleOptions(TRANSPORTTASK);
		return this;
	}
	
	
	protected static final String RETAILSTORE = "retailStore";
	public String getRetailStore(){
		return RETAILSTORE;
	}
	public GoodsTokens withRetailStore(){		
		addSimpleOptions(RETAILSTORE);
		return this;
	}
	
	
	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	public GoodsTokens withBizOrder(){		
		addSimpleOptions(BIZORDER);
		return this;
	}
	
	
	protected static final String RETAILSTOREORDER = "retailStoreOrder";
	public String getRetailStoreOrder(){
		return RETAILSTOREORDER;
	}
	public GoodsTokens withRetailStoreOrder(){		
		addSimpleOptions(RETAILSTOREORDER);
		return this;
	}
	
	
	protected static final String PACKAGING = "packaging";
	public String getPackaging(){
		return PACKAGING;
	}
	public GoodsTokens withPackaging(){		
		addSimpleOptions(PACKAGING);
		return this;
	}
	
	
	protected static final String GOODS_MOVEMENT_LIST = "goodsMovementList";
	public String getGoodsMovementList(){
		return GOODS_MOVEMENT_LIST;
	}
	public GoodsTokens withGoodsMovementList(){		
		addSimpleOptions(GOODS_MOVEMENT_LIST);
		return this;
	}	
		
}
