
package com.skynet.retailscm.supplyorder;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class SupplyOrderTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplyOrder";
	
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
	protected SupplyOrderTokens(){
		//ensure not initialized outside the class
	}
	
	public SupplyOrderTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SupplyOrderTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SupplyOrderTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SupplyOrderTokens start(){
		return new SupplyOrderTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SupplyOrderTokens allTokens(){
		
		return start()
			.withBuyer()
			.withSeller()
			.withConfirmation()
			.withApproval()
			.withProcessing()
			.withPicking()
			.withShipment()
			.withDelivery()
			.withSupplyOrderLineItemList()
			.withSupplyOrderShippingGroupList()
			.withSupplyOrderPaymentGroupList()
			.withGoodsList();
	
	}
	protected static SupplyOrderTokens withoutListsTokens(){
		
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
	public SupplyOrderTokens withBuyer(){		
		addSimpleOptions(BUYER);
		return this;
	}
	
	
	protected static final String SELLER = "seller";
	public String getSeller(){
		return SELLER;
	}
	public SupplyOrderTokens withSeller(){		
		addSimpleOptions(SELLER);
		return this;
	}
	
	
	protected static final String CONFIRMATION = "confirmation";
	public String getConfirmation(){
		return CONFIRMATION;
	}
	public SupplyOrderTokens withConfirmation(){		
		addSimpleOptions(CONFIRMATION);
		return this;
	}
	
	
	protected static final String APPROVAL = "approval";
	public String getApproval(){
		return APPROVAL;
	}
	public SupplyOrderTokens withApproval(){		
		addSimpleOptions(APPROVAL);
		return this;
	}
	
	
	protected static final String PROCESSING = "processing";
	public String getProcessing(){
		return PROCESSING;
	}
	public SupplyOrderTokens withProcessing(){		
		addSimpleOptions(PROCESSING);
		return this;
	}
	
	
	protected static final String PICKING = "picking";
	public String getPicking(){
		return PICKING;
	}
	public SupplyOrderTokens withPicking(){		
		addSimpleOptions(PICKING);
		return this;
	}
	
	
	protected static final String SHIPMENT = "shipment";
	public String getShipment(){
		return SHIPMENT;
	}
	public SupplyOrderTokens withShipment(){		
		addSimpleOptions(SHIPMENT);
		return this;
	}
	
	
	protected static final String DELIVERY = "delivery";
	public String getDelivery(){
		return DELIVERY;
	}
	public SupplyOrderTokens withDelivery(){		
		addSimpleOptions(DELIVERY);
		return this;
	}
	
	
	protected static final String SUPPLY_ORDER_LINE_ITEM_LIST = "supplyOrderLineItemList";
	public String getSupplyOrderLineItemList(){
		return SUPPLY_ORDER_LINE_ITEM_LIST;
	}
	public SupplyOrderTokens withSupplyOrderLineItemList(){		
		addSimpleOptions(SUPPLY_ORDER_LINE_ITEM_LIST);
		return this;
	}	
		
	protected static final String SUPPLY_ORDER_SHIPPING_GROUP_LIST = "supplyOrderShippingGroupList";
	public String getSupplyOrderShippingGroupList(){
		return SUPPLY_ORDER_SHIPPING_GROUP_LIST;
	}
	public SupplyOrderTokens withSupplyOrderShippingGroupList(){		
		addSimpleOptions(SUPPLY_ORDER_SHIPPING_GROUP_LIST);
		return this;
	}	
		
	protected static final String SUPPLY_ORDER_PAYMENT_GROUP_LIST = "supplyOrderPaymentGroupList";
	public String getSupplyOrderPaymentGroupList(){
		return SUPPLY_ORDER_PAYMENT_GROUP_LIST;
	}
	public SupplyOrderTokens withSupplyOrderPaymentGroupList(){		
		addSimpleOptions(SUPPLY_ORDER_PAYMENT_GROUP_LIST);
		return this;
	}	
		
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public SupplyOrderTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}	
		
}

