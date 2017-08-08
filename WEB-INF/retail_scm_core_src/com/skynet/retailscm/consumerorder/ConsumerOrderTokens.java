
package com.skynet.retailscm.consumerorder;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class ConsumerOrderTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="consumerOrder";
	
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
	protected ConsumerOrderTokens(){
		//ensure not initialized outside the class
	}
	
	public ConsumerOrderTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ConsumerOrderTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ConsumerOrderTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ConsumerOrderTokens start(){
		return new ConsumerOrderTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ConsumerOrderTokens allTokens(){
		
		return start()
			.withConsumer()
			.withConfirmation()
			.withApproval()
			.withProcessing()
			.withShipment()
			.withDelivery()
			.withStore()
			.withConsumerOrderLineItemList()
			.withConsumerOrderShippingGroupList()
			.withConsumerOrderPaymentGroupList()
			.withConsumerOrderPriceAdjustmentList()
			.withRetailStoreMemberGiftCardConsumeRecordList();
	
	}
	protected static ConsumerOrderTokens withoutListsTokens(){
		
		return start()
			.withConsumer()
			.withConfirmation()
			.withApproval()
			.withProcessing()
			.withShipment()
			.withDelivery()
			.withStore();
	
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

	protected static final String CONSUMER = "consumer";
	public String getConsumer(){
		return CONSUMER;
	}
	public ConsumerOrderTokens withConsumer(){		
		addSimpleOptions(CONSUMER);
		return this;
	}
	
	
	protected static final String CONFIRMATION = "confirmation";
	public String getConfirmation(){
		return CONFIRMATION;
	}
	public ConsumerOrderTokens withConfirmation(){		
		addSimpleOptions(CONFIRMATION);
		return this;
	}
	
	
	protected static final String APPROVAL = "approval";
	public String getApproval(){
		return APPROVAL;
	}
	public ConsumerOrderTokens withApproval(){		
		addSimpleOptions(APPROVAL);
		return this;
	}
	
	
	protected static final String PROCESSING = "processing";
	public String getProcessing(){
		return PROCESSING;
	}
	public ConsumerOrderTokens withProcessing(){		
		addSimpleOptions(PROCESSING);
		return this;
	}
	
	
	protected static final String SHIPMENT = "shipment";
	public String getShipment(){
		return SHIPMENT;
	}
	public ConsumerOrderTokens withShipment(){		
		addSimpleOptions(SHIPMENT);
		return this;
	}
	
	
	protected static final String DELIVERY = "delivery";
	public String getDelivery(){
		return DELIVERY;
	}
	public ConsumerOrderTokens withDelivery(){		
		addSimpleOptions(DELIVERY);
		return this;
	}
	
	
	protected static final String STORE = "store";
	public String getStore(){
		return STORE;
	}
	public ConsumerOrderTokens withStore(){		
		addSimpleOptions(STORE);
		return this;
	}
	
	
	protected static final String CONSUMER_ORDER_LINE_ITEM_LIST = "consumerOrderLineItemList";
	public String getConsumerOrderLineItemList(){
		return CONSUMER_ORDER_LINE_ITEM_LIST;
	}
	public ConsumerOrderTokens withConsumerOrderLineItemList(){		
		addSimpleOptions(CONSUMER_ORDER_LINE_ITEM_LIST);
		return this;
	}	
		
	protected static final String CONSUMER_ORDER_SHIPPING_GROUP_LIST = "consumerOrderShippingGroupList";
	public String getConsumerOrderShippingGroupList(){
		return CONSUMER_ORDER_SHIPPING_GROUP_LIST;
	}
	public ConsumerOrderTokens withConsumerOrderShippingGroupList(){		
		addSimpleOptions(CONSUMER_ORDER_SHIPPING_GROUP_LIST);
		return this;
	}	
		
	protected static final String CONSUMER_ORDER_PAYMENT_GROUP_LIST = "consumerOrderPaymentGroupList";
	public String getConsumerOrderPaymentGroupList(){
		return CONSUMER_ORDER_PAYMENT_GROUP_LIST;
	}
	public ConsumerOrderTokens withConsumerOrderPaymentGroupList(){		
		addSimpleOptions(CONSUMER_ORDER_PAYMENT_GROUP_LIST);
		return this;
	}	
		
	protected static final String CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST = "consumerOrderPriceAdjustmentList";
	public String getConsumerOrderPriceAdjustmentList(){
		return CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST;
	}
	public ConsumerOrderTokens withConsumerOrderPriceAdjustmentList(){		
		addSimpleOptions(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST = "retailStoreMemberGiftCardConsumeRecordList";
	public String getRetailStoreMemberGiftCardConsumeRecordList(){
		return RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST;
	}
	public ConsumerOrderTokens withRetailStoreMemberGiftCardConsumeRecordList(){		
		addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
		return this;
	}	
		
}

