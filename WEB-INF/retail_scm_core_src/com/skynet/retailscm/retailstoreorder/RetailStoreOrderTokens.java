
package com.skynet.retailscm.retailstoreorder;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreOrderTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreOrder";
	
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
	protected RetailStoreOrderTokens(){
		//ensure not initialized outside the class
	}
	
	public RetailStoreOrderTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreOrderTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreOrderTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RetailStoreOrderTokens start(){
		return new RetailStoreOrderTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RetailStoreOrderTokens allTokens(){
		
		return start()
			.withBuyer()
			.withSeller()
			.withConfirmation()
			.withApproval()
			.withProcessing()
			.withPicking()
			.withShipment()
			.withDelivery()
			.withRetailStoreOrderLineItemList()
			.withRetailStoreOrderShippingGroupList()
			.withRetailStoreOrderPaymentGroupList()
			.withGoodsList();
	
	}
	protected static RetailStoreOrderTokens withoutListsTokens(){
		
		return start()
			.withBuyer()
			.withSeller()
			.withConfirmation()
			.withApproval()
			.withProcessing()
			.withPicking()
			.withShipment()
			.withDelivery();
	
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

	protected static final String BUYER = "buyer";
	public String getBuyer(){
		return BUYER;
	}
	public RetailStoreOrderTokens withBuyer(){		
		addSimpleOptions(BUYER);
		return this;
	}
	
	
	protected static final String SELLER = "seller";
	public String getSeller(){
		return SELLER;
	}
	public RetailStoreOrderTokens withSeller(){		
		addSimpleOptions(SELLER);
		return this;
	}
	
	
	protected static final String CONFIRMATION = "confirmation";
	public String getConfirmation(){
		return CONFIRMATION;
	}
	public RetailStoreOrderTokens withConfirmation(){		
		addSimpleOptions(CONFIRMATION);
		return this;
	}
	
	
	protected static final String APPROVAL = "approval";
	public String getApproval(){
		return APPROVAL;
	}
	public RetailStoreOrderTokens withApproval(){		
		addSimpleOptions(APPROVAL);
		return this;
	}
	
	
	protected static final String PROCESSING = "processing";
	public String getProcessing(){
		return PROCESSING;
	}
	public RetailStoreOrderTokens withProcessing(){		
		addSimpleOptions(PROCESSING);
		return this;
	}
	
	
	protected static final String PICKING = "picking";
	public String getPicking(){
		return PICKING;
	}
	public RetailStoreOrderTokens withPicking(){		
		addSimpleOptions(PICKING);
		return this;
	}
	
	
	protected static final String SHIPMENT = "shipment";
	public String getShipment(){
		return SHIPMENT;
	}
	public RetailStoreOrderTokens withShipment(){		
		addSimpleOptions(SHIPMENT);
		return this;
	}
	
	
	protected static final String DELIVERY = "delivery";
	public String getDelivery(){
		return DELIVERY;
	}
	public RetailStoreOrderTokens withDelivery(){		
		addSimpleOptions(DELIVERY);
		return this;
	}
	
	
	protected static final String RETAIL_STORE_ORDER_LINE_ITEM_LIST = "retailStoreOrderLineItemList";
	public String getRetailStoreOrderLineItemList(){
		return RETAIL_STORE_ORDER_LINE_ITEM_LIST;
	}
	public RetailStoreOrderTokens withRetailStoreOrderLineItemList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LINE_ITEM_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST = "retailStoreOrderShippingGroupList";
	public String getRetailStoreOrderShippingGroupList(){
		return RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST;
	}
	public RetailStoreOrderTokens withRetailStoreOrderShippingGroupList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST = "retailStoreOrderPaymentGroupList";
	public String getRetailStoreOrderPaymentGroupList(){
		return RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST;
	}
	public RetailStoreOrderTokens withRetailStoreOrderPaymentGroupList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST);
		return this;
	}	
		
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public RetailStoreOrderTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}	
		
}

