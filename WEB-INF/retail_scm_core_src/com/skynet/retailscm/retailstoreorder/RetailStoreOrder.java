
package com.skynet.retailscm.retailstoreorder;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.skynet.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.skynet.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;

@JsonSerialize(using = RetailStoreOrderSerializer.class)
public class RetailStoreOrder extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BUYER_PROPERTY                 = "buyer"             ;
	public static final String SELLER_PROPERTY                = "seller"            ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String TOTAL_AMOUNT_PROPERTY          = "totalAmount"       ;
	public static final String CONFIRMATION_PROPERTY          = "confirmation"      ;
	public static final String APPROVAL_PROPERTY              = "approval"          ;
	public static final String PROCESSING_PROPERTY            = "processing"        ;
	public static final String PICKING_PROPERTY               = "picking"           ;
	public static final String SHIPMENT_PROPERTY              = "shipment"          ;
	public static final String DELIVERY_PROPERTY              = "delivery"          ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_ORDER_LINE_ITEM_LIST        = "retailStoreOrderLineItemList";
	public static final String RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST   = "retailStoreOrderShippingGroupList";
	public static final String RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST    = "retailStoreOrderPaymentGroupList";
	public static final String GOODS_LIST                               = "goodsList"         ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		RetailStore         	mBuyer              ;
	protected		RetailStoreCountryCenter	mSeller             ;
	protected		String              	mTitle              ;
	protected		double              	mTotalAmount        ;
	protected		RetailStoreOrderConfirmation	mConfirmation       ;
	protected		RetailStoreOrderApproval	mApproval           ;
	protected		RetailStoreOrderProcessing	mProcessing         ;
	protected		RetailStoreOrderPicking	mPicking            ;
	protected		RetailStoreOrderShipment	mShipment           ;
	protected		RetailStoreOrderDelivery	mDelivery           ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<RetailStoreOrderLineItem>	mRetailStoreOrderLineItemList;
	protected		SmartList<RetailStoreOrderShippingGroup>	mRetailStoreOrderShippingGroupList;
	protected		SmartList<RetailStoreOrderPaymentGroup>	mRetailStoreOrderPaymentGroupList;
	protected		SmartList<Goods>    	mGoodsList          ;
	
		
	public 	RetailStoreOrder(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreOrder(RetailStore buyer, RetailStoreCountryCenter seller, String title, double totalAmount, String currentStatus
)
	{
		setBuyer(buyer);
		setSeller(seller);
		setTitle(title);
		setTotalAmount(totalAmount);
		setCurrentStatus(currentStatus);

		this.mRetailStoreOrderLineItemList = new SmartList<RetailStoreOrderLineItem>();
		this.mRetailStoreOrderShippingGroupList = new SmartList<RetailStoreOrderShippingGroup>();
		this.mRetailStoreOrderPaymentGroupList = new SmartList<RetailStoreOrderPaymentGroup>();
		this.mGoodsList = new SmartList<Goods>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(TOTAL_AMOUNT_PROPERTY.equals(property)){
			changeTotalAmountProperty(newValueExpr);
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
			
			
			
	protected void changeTotalAmountProperty(String newValueExpr){
		double oldValue = getTotalAmount();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTotalAmount(newValue);
		//they are surely different each other
		this.onChangeProperty(TOTAL_AMOUNT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setBuyer(RetailStore buyer){
		this.mBuyer = buyer;;
	}
	public RetailStore getBuyer(){
		return this.mBuyer;
	}
	
	
	public void setSeller(RetailStoreCountryCenter seller){
		this.mSeller = seller;;
	}
	public RetailStoreCountryCenter getSeller(){
		return this.mSeller;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	
	
	public void setTotalAmount(double totalAmount){
		this.mTotalAmount = totalAmount;;
	}
	public double getTotalAmount(){
		return this.mTotalAmount;
	}
	
	
	public void setConfirmation(RetailStoreOrderConfirmation confirmation){
		this.mConfirmation = confirmation;;
	}
	public RetailStoreOrderConfirmation getConfirmation(){
		return this.mConfirmation;
	}
	
	
	public void setApproval(RetailStoreOrderApproval approval){
		this.mApproval = approval;;
	}
	public RetailStoreOrderApproval getApproval(){
		return this.mApproval;
	}
	
	
	public void setProcessing(RetailStoreOrderProcessing processing){
		this.mProcessing = processing;;
	}
	public RetailStoreOrderProcessing getProcessing(){
		return this.mProcessing;
	}
	
	
	public void setPicking(RetailStoreOrderPicking picking){
		this.mPicking = picking;;
	}
	public RetailStoreOrderPicking getPicking(){
		return this.mPicking;
	}
	
	
	public void setShipment(RetailStoreOrderShipment shipment){
		this.mShipment = shipment;;
	}
	public RetailStoreOrderShipment getShipment(){
		return this.mShipment;
	}
	
	
	public void setDelivery(RetailStoreOrderDelivery delivery){
		this.mDelivery = delivery;;
	}
	public RetailStoreOrderDelivery getDelivery(){
		return this.mDelivery;
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
	
	
	public  SmartList<RetailStoreOrderLineItem> getRetailStoreOrderLineItemList(){
		if(this.mRetailStoreOrderLineItemList == null){
			this.mRetailStoreOrderLineItemList = new SmartList<RetailStoreOrderLineItem>();
		}
		return this.mRetailStoreOrderLineItemList;	
	}
	public  void setRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		for( RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList){
			retailStoreOrderLineItem.setBizOrder(this);
		}
		
		this.mRetailStoreOrderLineItemList = retailStoreOrderLineItemList;
		
	}
	
	public  void addRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem){
		retailStoreOrderLineItem.setBizOrder(this);
		getRetailStoreOrderLineItemList().add(retailStoreOrderLineItem);
	}
	public  void addRetailStoreOrderLineItems(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		for( RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList){
			retailStoreOrderLineItem.setBizOrder(this);
		}
		getRetailStoreOrderLineItemList().addAll(retailStoreOrderLineItemList);
	}
	
	public  void removeRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem){
	
		boolean result = getRetailStoreOrderLineItemList().planToRemove(retailStoreOrderLineItem);
        if(!result){
        	String message = "RetailStoreOrderLineItem("+retailStoreOrderLineItem.getId()+") with version='"+retailStoreOrderLineItem.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreOrderLineItemList", retailStoreOrderLineItem);
		//the constant "toRetailStoreOrderLineItem" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreOrderLineItemFrom(RetailStoreOrderLineItem retailStoreOrderLineItem) {
		// TODO Auto-generated method stub
		
        RetailStoreOrderLineItem retailStoreOrderLineItemInList = findTheRetailStoreOrderLineItem(retailStoreOrderLineItem);
        RetailStoreOrderLineItem newRetailStoreOrderLineItem = new RetailStoreOrderLineItem();
        retailStoreOrderLineItemInList.copyTo(newRetailStoreOrderLineItem);
        newRetailStoreOrderLineItem.setVersion(0);//will trigger copy
        getRetailStoreOrderLineItemList().add(newRetailStoreOrderLineItem);
	}
	
	public  RetailStoreOrderLineItem findTheRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem){
		
		int index =  getRetailStoreOrderLineItemList().indexOf(retailStoreOrderLineItem);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreOrderLineItem("+retailStoreOrderLineItem.getId()+") with version='"+retailStoreOrderLineItem.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreOrderLineItemList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderLineItemList(){
		getRetailStoreOrderLineItemList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreOrderShippingGroup> getRetailStoreOrderShippingGroupList(){
		if(this.mRetailStoreOrderShippingGroupList == null){
			this.mRetailStoreOrderShippingGroupList = new SmartList<RetailStoreOrderShippingGroup>();
		}
		return this.mRetailStoreOrderShippingGroupList;	
	}
	public  void setRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		for( RetailStoreOrderShippingGroup retailStoreOrderShippingGroup:retailStoreOrderShippingGroupList){
			retailStoreOrderShippingGroup.setBizOrder(this);
		}
		
		this.mRetailStoreOrderShippingGroupList = retailStoreOrderShippingGroupList;
		
	}
	
	public  void addRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
		retailStoreOrderShippingGroup.setBizOrder(this);
		getRetailStoreOrderShippingGroupList().add(retailStoreOrderShippingGroup);
	}
	public  void addRetailStoreOrderShippingGroups(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		for( RetailStoreOrderShippingGroup retailStoreOrderShippingGroup:retailStoreOrderShippingGroupList){
			retailStoreOrderShippingGroup.setBizOrder(this);
		}
		getRetailStoreOrderShippingGroupList().addAll(retailStoreOrderShippingGroupList);
	}
	
	public  void removeRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
	
		boolean result = getRetailStoreOrderShippingGroupList().planToRemove(retailStoreOrderShippingGroup);
        if(!result){
        	String message = "RetailStoreOrderShippingGroup("+retailStoreOrderShippingGroup.getId()+") with version='"+retailStoreOrderShippingGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreOrderShippingGroupList", retailStoreOrderShippingGroup);
		//the constant "toRetailStoreOrderShippingGroup" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreOrderShippingGroupFrom(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) {
		// TODO Auto-generated method stub
		
        RetailStoreOrderShippingGroup retailStoreOrderShippingGroupInList = findTheRetailStoreOrderShippingGroup(retailStoreOrderShippingGroup);
        RetailStoreOrderShippingGroup newRetailStoreOrderShippingGroup = new RetailStoreOrderShippingGroup();
        retailStoreOrderShippingGroupInList.copyTo(newRetailStoreOrderShippingGroup);
        newRetailStoreOrderShippingGroup.setVersion(0);//will trigger copy
        getRetailStoreOrderShippingGroupList().add(newRetailStoreOrderShippingGroup);
	}
	
	public  RetailStoreOrderShippingGroup findTheRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
		
		int index =  getRetailStoreOrderShippingGroupList().indexOf(retailStoreOrderShippingGroup);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreOrderShippingGroup("+retailStoreOrderShippingGroup.getId()+") with version='"+retailStoreOrderShippingGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreOrderShippingGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderShippingGroupList(){
		getRetailStoreOrderShippingGroupList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreOrderPaymentGroup> getRetailStoreOrderPaymentGroupList(){
		if(this.mRetailStoreOrderPaymentGroupList == null){
			this.mRetailStoreOrderPaymentGroupList = new SmartList<RetailStoreOrderPaymentGroup>();
		}
		return this.mRetailStoreOrderPaymentGroupList;	
	}
	public  void setRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		for( RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList){
			retailStoreOrderPaymentGroup.setBizOrder(this);
		}
		
		this.mRetailStoreOrderPaymentGroupList = retailStoreOrderPaymentGroupList;
		
	}
	
	public  void addRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
		retailStoreOrderPaymentGroup.setBizOrder(this);
		getRetailStoreOrderPaymentGroupList().add(retailStoreOrderPaymentGroup);
	}
	public  void addRetailStoreOrderPaymentGroups(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		for( RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList){
			retailStoreOrderPaymentGroup.setBizOrder(this);
		}
		getRetailStoreOrderPaymentGroupList().addAll(retailStoreOrderPaymentGroupList);
	}
	
	public  void removeRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
	
		boolean result = getRetailStoreOrderPaymentGroupList().planToRemove(retailStoreOrderPaymentGroup);
        if(!result){
        	String message = "RetailStoreOrderPaymentGroup("+retailStoreOrderPaymentGroup.getId()+") with version='"+retailStoreOrderPaymentGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreOrderPaymentGroupList", retailStoreOrderPaymentGroup);
		//the constant "toRetailStoreOrderPaymentGroup" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreOrderPaymentGroupFrom(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) {
		// TODO Auto-generated method stub
		
        RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroupInList = findTheRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroup);
        RetailStoreOrderPaymentGroup newRetailStoreOrderPaymentGroup = new RetailStoreOrderPaymentGroup();
        retailStoreOrderPaymentGroupInList.copyTo(newRetailStoreOrderPaymentGroup);
        newRetailStoreOrderPaymentGroup.setVersion(0);//will trigger copy
        getRetailStoreOrderPaymentGroupList().add(newRetailStoreOrderPaymentGroup);
	}
	
	public  RetailStoreOrderPaymentGroup findTheRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
		
		int index =  getRetailStoreOrderPaymentGroupList().indexOf(retailStoreOrderPaymentGroup);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreOrderPaymentGroup("+retailStoreOrderPaymentGroup.getId()+") with version='"+retailStoreOrderPaymentGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreOrderPaymentGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderPaymentGroupList(){
		getRetailStoreOrderPaymentGroupList().clear();
	}
	
	
	
	
	public  SmartList<Goods> getGoodsList(){
		if(this.mGoodsList == null){
			this.mGoodsList = new SmartList<Goods>();
		}
		return this.mGoodsList;	
	}
	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setRetailStoreOrder(this);
		}
		
		this.mGoodsList = goodsList;
		
	}
	
	public  void addGoods(Goods goods){
		goods.setRetailStoreOrder(this);
		getGoodsList().add(goods);
	}
	public  void addGoodses(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setRetailStoreOrder(this);
		}
		getGoodsList().addAll(goodsList);
	}
	
	public  void removeGoods(Goods goods){
	
		boolean result = getGoodsList().planToRemove(goods);
        if(!result){
        	String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveGoodsList", goods);
		//the constant "toGoods" will be replaced after refactoried.
	
	}
	
	public void copyGoodsFrom(Goods goods) {
		// TODO Auto-generated method stub
		
        Goods goodsInList = findTheGoods(goods);
        Goods newGoods = new Goods();
        goodsInList.copyTo(newGoods);
        newGoods.setVersion(0);//will trigger copy
        getGoodsList().add(newGoods);
	}
	
	public  Goods findTheGoods(Goods goods){
		
		int index =  getGoodsList().indexOf(goods);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getGoodsList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsList(){
		getGoodsList().clear();
	}
	
	
	
	
 	
	
	public RetailStoreOrder copyTo(RetailStoreOrder dest){

		dest.setId(getId());
		dest.setBuyer(getBuyer());
		dest.setSeller(getSeller());
		dest.setTitle(getTitle());
		dest.setTotalAmount(getTotalAmount());
		dest.setConfirmation(getConfirmation());
		dest.setApproval(getApproval());
		dest.setProcessing(getProcessing());
		dest.setPicking(getPicking());
		dest.setShipment(getShipment());
		dest.setDelivery(getDelivery());
		dest.setCurrentStatus(getCurrentStatus());
		dest.setVersion(getVersion());
		dest.setRetailStoreOrderLineItemList(getRetailStoreOrderLineItemList());
		dest.setRetailStoreOrderShippingGroupList(getRetailStoreOrderShippingGroupList());
		dest.setRetailStoreOrderPaymentGroupList(getRetailStoreOrderPaymentGroupList());
		dest.setGoodsList(getGoodsList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_order{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBuyer() != null ){
 			stringBuilder.append("\tbuyer='retail_store("+getBuyer().getId()+")';");
 		}
		if(getSeller() != null ){
 			stringBuilder.append("\tseller='retail_store_country_center("+getSeller().getId()+")';");
 		}
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\ttotal_amount='"+getTotalAmount()+"';");
		if(getConfirmation() != null ){
 			stringBuilder.append("\tconfirmation='retail_store_order_confirmation("+getConfirmation().getId()+")';");
 		}
		if(getApproval() != null ){
 			stringBuilder.append("\tapproval='retail_store_order_approval("+getApproval().getId()+")';");
 		}
		if(getProcessing() != null ){
 			stringBuilder.append("\tprocessing='retail_store_order_processing("+getProcessing().getId()+")';");
 		}
		if(getPicking() != null ){
 			stringBuilder.append("\tpicking='retail_store_order_picking("+getPicking().getId()+")';");
 		}
		if(getShipment() != null ){
 			stringBuilder.append("\tshipment='retail_store_order_shipment("+getShipment().getId()+")';");
 		}
		if(getDelivery() != null ){
 			stringBuilder.append("\tdelivery='retail_store_order_delivery("+getDelivery().getId()+")';");
 		}
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

