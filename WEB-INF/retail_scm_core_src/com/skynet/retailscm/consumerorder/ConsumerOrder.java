
package com.skynet.retailscm.consumerorder;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.skynet.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.skynet.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;

@JsonSerialize(using = ConsumerOrderSerializer.class)
public class ConsumerOrder extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String CONSUMER_PROPERTY              = "consumer"          ;
	public static final String CONFIRMATION_PROPERTY          = "confirmation"      ;
	public static final String APPROVAL_PROPERTY              = "approval"          ;
	public static final String PROCESSING_PROPERTY            = "processing"        ;
	public static final String SHIPMENT_PROPERTY              = "shipment"          ;
	public static final String DELIVERY_PROPERTY              = "delivery"          ;
	public static final String STORE_PROPERTY                 = "store"             ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LINE_ITEM_LIST            = "consumerOrderLineItemList";
	public static final String CONSUMER_ORDER_SHIPPING_GROUP_LIST       = "consumerOrderShippingGroupList";
	public static final String CONSUMER_ORDER_PAYMENT_GROUP_LIST        = "consumerOrderPaymentGroupList";
	public static final String CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST     = "consumerOrderPriceAdjustmentList";
	public static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST = "retailStoreMemberGiftCardConsumeRecordList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		RetailStoreMember   	mConsumer           ;
	protected		SupplyOrderConfirmation	mConfirmation       ;
	protected		SupplyOrderApproval 	mApproval           ;
	protected		SupplyOrderProcessing	mProcessing         ;
	protected		SupplyOrderShipment 	mShipment           ;
	protected		SupplyOrderDelivery 	mDelivery           ;
	protected		RetailStore         	mStore              ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrderLineItem>	mConsumerOrderLineItemList;
	protected		SmartList<ConsumerOrderShippingGroup>	mConsumerOrderShippingGroupList;
	protected		SmartList<ConsumerOrderPaymentGroup>	mConsumerOrderPaymentGroupList;
	protected		SmartList<ConsumerOrderPriceAdjustment>	mConsumerOrderPriceAdjustmentList;
	protected		SmartList<RetailStoreMemberGiftCardConsumeRecord>	mRetailStoreMemberGiftCardConsumeRecordList;
	
		
	public 	ConsumerOrder(){
		//lazy load for all the properties
	}
	
	public 	ConsumerOrder(String title, RetailStoreMember consumer, RetailStore store, String currentStatus
)
	{
		setTitle(title);
		setConsumer(consumer);
		setStore(store);
		setCurrentStatus(currentStatus);

		this.mConsumerOrderLineItemList = new SmartList<ConsumerOrderLineItem>();
		this.mConsumerOrderShippingGroupList = new SmartList<ConsumerOrderShippingGroup>();
		this.mConsumerOrderPaymentGroupList = new SmartList<ConsumerOrderPaymentGroup>();
		this.mConsumerOrderPriceAdjustmentList = new SmartList<ConsumerOrderPriceAdjustment>();
		this.mRetailStoreMemberGiftCardConsumeRecordList = new SmartList<RetailStoreMemberGiftCardConsumeRecord>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTitle(newValue);
		//they are surely different each other
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	
	
	public void setConsumer(RetailStoreMember consumer){
		this.mConsumer = consumer;;
	}
	public RetailStoreMember getConsumer(){
		return this.mConsumer;
	}
	
	
	public void setConfirmation(SupplyOrderConfirmation confirmation){
		this.mConfirmation = confirmation;;
	}
	public SupplyOrderConfirmation getConfirmation(){
		return this.mConfirmation;
	}
	
	
	public void setApproval(SupplyOrderApproval approval){
		this.mApproval = approval;;
	}
	public SupplyOrderApproval getApproval(){
		return this.mApproval;
	}
	
	
	public void setProcessing(SupplyOrderProcessing processing){
		this.mProcessing = processing;;
	}
	public SupplyOrderProcessing getProcessing(){
		return this.mProcessing;
	}
	
	
	public void setShipment(SupplyOrderShipment shipment){
		this.mShipment = shipment;;
	}
	public SupplyOrderShipment getShipment(){
		return this.mShipment;
	}
	
	
	public void setDelivery(SupplyOrderDelivery delivery){
		this.mDelivery = delivery;;
	}
	public SupplyOrderDelivery getDelivery(){
		return this.mDelivery;
	}
	
	
	public void setStore(RetailStore store){
		this.mStore = store;;
	}
	public RetailStore getStore(){
		return this.mStore;
	}
	
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<ConsumerOrderLineItem> getConsumerOrderLineItemList(){
		if(this.mConsumerOrderLineItemList == null){
			this.mConsumerOrderLineItemList = new SmartList<ConsumerOrderLineItem>();
		}
		return this.mConsumerOrderLineItemList;	
	}
	public  void setConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList){
		for( ConsumerOrderLineItem consumerOrderLineItem:consumerOrderLineItemList){
			consumerOrderLineItem.setBizOrder(this);
		}
		
		this.mConsumerOrderLineItemList = consumerOrderLineItemList;
		
	}
	
	public  void addConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItem){
		consumerOrderLineItem.setBizOrder(this);
		getConsumerOrderLineItemList().add(consumerOrderLineItem);
	}
	public  void addConsumerOrderLineItems(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList){
		for( ConsumerOrderLineItem consumerOrderLineItem:consumerOrderLineItemList){
			consumerOrderLineItem.setBizOrder(this);
		}
		getConsumerOrderLineItemList().addAll(consumerOrderLineItemList);
	}
	
	public  void removeConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItem){
	
		boolean result = getConsumerOrderLineItemList().planToRemove(consumerOrderLineItem);
        if(!result){
        	String message = "ConsumerOrderLineItem("+consumerOrderLineItem.getId()+") with version='"+consumerOrderLineItem.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveConsumerOrderLineItemList", consumerOrderLineItem);
		//the constant "toConsumerOrderLineItem" will be replaced after refactoried.
	
	}
	
	public void copyConsumerOrderLineItemFrom(ConsumerOrderLineItem consumerOrderLineItem) {
		// TODO Auto-generated method stub
		
        ConsumerOrderLineItem consumerOrderLineItemInList = findTheConsumerOrderLineItem(consumerOrderLineItem);
        ConsumerOrderLineItem newConsumerOrderLineItem = new ConsumerOrderLineItem();
        consumerOrderLineItemInList.copyTo(newConsumerOrderLineItem);
        newConsumerOrderLineItem.setVersion(0);//will trigger copy
        getConsumerOrderLineItemList().add(newConsumerOrderLineItem);
	}
	
	public  ConsumerOrderLineItem findTheConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItem){
		
		int index =  getConsumerOrderLineItemList().indexOf(consumerOrderLineItem);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ConsumerOrderLineItem("+consumerOrderLineItem.getId()+") with version='"+consumerOrderLineItem.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getConsumerOrderLineItemList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpConsumerOrderLineItemList(){
		getConsumerOrderLineItemList().clear();
	}
	
	
	
	
	public  SmartList<ConsumerOrderShippingGroup> getConsumerOrderShippingGroupList(){
		if(this.mConsumerOrderShippingGroupList == null){
			this.mConsumerOrderShippingGroupList = new SmartList<ConsumerOrderShippingGroup>();
		}
		return this.mConsumerOrderShippingGroupList;	
	}
	public  void setConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		for( ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList){
			consumerOrderShippingGroup.setBizOrder(this);
		}
		
		this.mConsumerOrderShippingGroupList = consumerOrderShippingGroupList;
		
	}
	
	public  void addConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup){
		consumerOrderShippingGroup.setBizOrder(this);
		getConsumerOrderShippingGroupList().add(consumerOrderShippingGroup);
	}
	public  void addConsumerOrderShippingGroups(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		for( ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList){
			consumerOrderShippingGroup.setBizOrder(this);
		}
		getConsumerOrderShippingGroupList().addAll(consumerOrderShippingGroupList);
	}
	
	public  void removeConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup){
	
		boolean result = getConsumerOrderShippingGroupList().planToRemove(consumerOrderShippingGroup);
        if(!result){
        	String message = "ConsumerOrderShippingGroup("+consumerOrderShippingGroup.getId()+") with version='"+consumerOrderShippingGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveConsumerOrderShippingGroupList", consumerOrderShippingGroup);
		//the constant "toConsumerOrderShippingGroup" will be replaced after refactoried.
	
	}
	
	public void copyConsumerOrderShippingGroupFrom(ConsumerOrderShippingGroup consumerOrderShippingGroup) {
		// TODO Auto-generated method stub
		
        ConsumerOrderShippingGroup consumerOrderShippingGroupInList = findTheConsumerOrderShippingGroup(consumerOrderShippingGroup);
        ConsumerOrderShippingGroup newConsumerOrderShippingGroup = new ConsumerOrderShippingGroup();
        consumerOrderShippingGroupInList.copyTo(newConsumerOrderShippingGroup);
        newConsumerOrderShippingGroup.setVersion(0);//will trigger copy
        getConsumerOrderShippingGroupList().add(newConsumerOrderShippingGroup);
	}
	
	public  ConsumerOrderShippingGroup findTheConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup){
		
		int index =  getConsumerOrderShippingGroupList().indexOf(consumerOrderShippingGroup);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ConsumerOrderShippingGroup("+consumerOrderShippingGroup.getId()+") with version='"+consumerOrderShippingGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getConsumerOrderShippingGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpConsumerOrderShippingGroupList(){
		getConsumerOrderShippingGroupList().clear();
	}
	
	
	
	
	public  SmartList<ConsumerOrderPaymentGroup> getConsumerOrderPaymentGroupList(){
		if(this.mConsumerOrderPaymentGroupList == null){
			this.mConsumerOrderPaymentGroupList = new SmartList<ConsumerOrderPaymentGroup>();
		}
		return this.mConsumerOrderPaymentGroupList;	
	}
	public  void setConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		for( ConsumerOrderPaymentGroup consumerOrderPaymentGroup:consumerOrderPaymentGroupList){
			consumerOrderPaymentGroup.setBizOrder(this);
		}
		
		this.mConsumerOrderPaymentGroupList = consumerOrderPaymentGroupList;
		
	}
	
	public  void addConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
		consumerOrderPaymentGroup.setBizOrder(this);
		getConsumerOrderPaymentGroupList().add(consumerOrderPaymentGroup);
	}
	public  void addConsumerOrderPaymentGroups(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		for( ConsumerOrderPaymentGroup consumerOrderPaymentGroup:consumerOrderPaymentGroupList){
			consumerOrderPaymentGroup.setBizOrder(this);
		}
		getConsumerOrderPaymentGroupList().addAll(consumerOrderPaymentGroupList);
	}
	
	public  void removeConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
	
		boolean result = getConsumerOrderPaymentGroupList().planToRemove(consumerOrderPaymentGroup);
        if(!result){
        	String message = "ConsumerOrderPaymentGroup("+consumerOrderPaymentGroup.getId()+") with version='"+consumerOrderPaymentGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveConsumerOrderPaymentGroupList", consumerOrderPaymentGroup);
		//the constant "toConsumerOrderPaymentGroup" will be replaced after refactoried.
	
	}
	
	public void copyConsumerOrderPaymentGroupFrom(ConsumerOrderPaymentGroup consumerOrderPaymentGroup) {
		// TODO Auto-generated method stub
		
        ConsumerOrderPaymentGroup consumerOrderPaymentGroupInList = findTheConsumerOrderPaymentGroup(consumerOrderPaymentGroup);
        ConsumerOrderPaymentGroup newConsumerOrderPaymentGroup = new ConsumerOrderPaymentGroup();
        consumerOrderPaymentGroupInList.copyTo(newConsumerOrderPaymentGroup);
        newConsumerOrderPaymentGroup.setVersion(0);//will trigger copy
        getConsumerOrderPaymentGroupList().add(newConsumerOrderPaymentGroup);
	}
	
	public  ConsumerOrderPaymentGroup findTheConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
		
		int index =  getConsumerOrderPaymentGroupList().indexOf(consumerOrderPaymentGroup);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ConsumerOrderPaymentGroup("+consumerOrderPaymentGroup.getId()+") with version='"+consumerOrderPaymentGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getConsumerOrderPaymentGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpConsumerOrderPaymentGroupList(){
		getConsumerOrderPaymentGroupList().clear();
	}
	
	
	
	
	public  SmartList<ConsumerOrderPriceAdjustment> getConsumerOrderPriceAdjustmentList(){
		if(this.mConsumerOrderPriceAdjustmentList == null){
			this.mConsumerOrderPriceAdjustmentList = new SmartList<ConsumerOrderPriceAdjustment>();
		}
		return this.mConsumerOrderPriceAdjustmentList;	
	}
	public  void setConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		for( ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList){
			consumerOrderPriceAdjustment.setBizOrder(this);
		}
		
		this.mConsumerOrderPriceAdjustmentList = consumerOrderPriceAdjustmentList;
		
	}
	
	public  void addConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
		consumerOrderPriceAdjustment.setBizOrder(this);
		getConsumerOrderPriceAdjustmentList().add(consumerOrderPriceAdjustment);
	}
	public  void addConsumerOrderPriceAdjustments(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		for( ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList){
			consumerOrderPriceAdjustment.setBizOrder(this);
		}
		getConsumerOrderPriceAdjustmentList().addAll(consumerOrderPriceAdjustmentList);
	}
	
	public  void removeConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
	
		boolean result = getConsumerOrderPriceAdjustmentList().planToRemove(consumerOrderPriceAdjustment);
        if(!result){
        	String message = "ConsumerOrderPriceAdjustment("+consumerOrderPriceAdjustment.getId()+") with version='"+consumerOrderPriceAdjustment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveConsumerOrderPriceAdjustmentList", consumerOrderPriceAdjustment);
		//the constant "toConsumerOrderPriceAdjustment" will be replaced after refactoried.
	
	}
	
	public void copyConsumerOrderPriceAdjustmentFrom(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) {
		// TODO Auto-generated method stub
		
        ConsumerOrderPriceAdjustment consumerOrderPriceAdjustmentInList = findTheConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment);
        ConsumerOrderPriceAdjustment newConsumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
        consumerOrderPriceAdjustmentInList.copyTo(newConsumerOrderPriceAdjustment);
        newConsumerOrderPriceAdjustment.setVersion(0);//will trigger copy
        getConsumerOrderPriceAdjustmentList().add(newConsumerOrderPriceAdjustment);
	}
	
	public  ConsumerOrderPriceAdjustment findTheConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
		
		int index =  getConsumerOrderPriceAdjustmentList().indexOf(consumerOrderPriceAdjustment);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ConsumerOrderPriceAdjustment("+consumerOrderPriceAdjustment.getId()+") with version='"+consumerOrderPriceAdjustment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getConsumerOrderPriceAdjustmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpConsumerOrderPriceAdjustmentList(){
		getConsumerOrderPriceAdjustmentList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreMemberGiftCardConsumeRecord> getRetailStoreMemberGiftCardConsumeRecordList(){
		if(this.mRetailStoreMemberGiftCardConsumeRecordList == null){
			this.mRetailStoreMemberGiftCardConsumeRecordList = new SmartList<RetailStoreMemberGiftCardConsumeRecord>();
		}
		return this.mRetailStoreMemberGiftCardConsumeRecordList;	
	}
	public  void setRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setBizOrder(this);
		}
		
		this.mRetailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList;
		
	}
	
	public  void addRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		retailStoreMemberGiftCardConsumeRecord.setBizOrder(this);
		getRetailStoreMemberGiftCardConsumeRecordList().add(retailStoreMemberGiftCardConsumeRecord);
	}
	public  void addRetailStoreMemberGiftCardConsumeRecords(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setBizOrder(this);
		}
		getRetailStoreMemberGiftCardConsumeRecordList().addAll(retailStoreMemberGiftCardConsumeRecordList);
	}
	
	public  void removeRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
	
		boolean result = getRetailStoreMemberGiftCardConsumeRecordList().planToRemove(retailStoreMemberGiftCardConsumeRecord);
        if(!result){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecord.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecord.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreMemberGiftCardConsumeRecordList", retailStoreMemberGiftCardConsumeRecord);
		//the constant "toRetailStoreMemberGiftCardConsumeRecord" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreMemberGiftCardConsumeRecordFrom(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {
		// TODO Auto-generated method stub
		
        RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordInList = findTheRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord);
        RetailStoreMemberGiftCardConsumeRecord newRetailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
        retailStoreMemberGiftCardConsumeRecordInList.copyTo(newRetailStoreMemberGiftCardConsumeRecord);
        newRetailStoreMemberGiftCardConsumeRecord.setVersion(0);//will trigger copy
        getRetailStoreMemberGiftCardConsumeRecordList().add(newRetailStoreMemberGiftCardConsumeRecord);
	}
	
	public  RetailStoreMemberGiftCardConsumeRecord findTheRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		
		int index =  getRetailStoreMemberGiftCardConsumeRecordList().indexOf(retailStoreMemberGiftCardConsumeRecord);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecord.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecord.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreMemberGiftCardConsumeRecordList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberGiftCardConsumeRecordList(){
		getRetailStoreMemberGiftCardConsumeRecordList().clear();
	}
	
	
	
	
 	
	
	public ConsumerOrder copyTo(ConsumerOrder dest){

		dest.setId(getId());
		dest.setTitle(getTitle());
		dest.setConsumer(getConsumer());
		dest.setConfirmation(getConfirmation());
		dest.setApproval(getApproval());
		dest.setProcessing(getProcessing());
		dest.setShipment(getShipment());
		dest.setDelivery(getDelivery());
		dest.setStore(getStore());
		dest.setCurrentStatus(getCurrentStatus());
		dest.setVersion(getVersion());
		dest.setConsumerOrderLineItemList(getConsumerOrderLineItemList());
		dest.setConsumerOrderShippingGroupList(getConsumerOrderShippingGroupList());
		dest.setConsumerOrderPaymentGroupList(getConsumerOrderPaymentGroupList());
		dest.setConsumerOrderPriceAdjustmentList(getConsumerOrderPriceAdjustmentList());
		dest.setRetailStoreMemberGiftCardConsumeRecordList(getRetailStoreMemberGiftCardConsumeRecordList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("consumer_order{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getConsumer() != null ){
 			stringBuilder.append("\tconsumer='retail_store_member("+getConsumer().getId()+")';");
 		}
		if(getConfirmation() != null ){
 			stringBuilder.append("\tconfirmation='supply_order_confirmation("+getConfirmation().getId()+")';");
 		}
		if(getApproval() != null ){
 			stringBuilder.append("\tapproval='supply_order_approval("+getApproval().getId()+")';");
 		}
		if(getProcessing() != null ){
 			stringBuilder.append("\tprocessing='supply_order_processing("+getProcessing().getId()+")';");
 		}
		if(getShipment() != null ){
 			stringBuilder.append("\tshipment='supply_order_shipment("+getShipment().getId()+")';");
 		}
		if(getDelivery() != null ){
 			stringBuilder.append("\tdelivery='supply_order_delivery("+getDelivery().getId()+")';");
 		}
		if(getStore() != null ){
 			stringBuilder.append("\tstore='retail_store("+getStore().getId()+")';");
 		}
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

