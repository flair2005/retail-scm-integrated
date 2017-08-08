
package com.skynet.retailscm.supplyorder;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.skynet.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;

@JsonSerialize(using = SupplyOrderSerializer.class)
public class SupplyOrder extends BaseEntity implements  java.io.Serializable{

	
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

	public static final String SUPPLY_ORDER_LINE_ITEM_LIST              = "supplyOrderLineItemList";
	public static final String SUPPLY_ORDER_SHIPPING_GROUP_LIST         = "supplyOrderShippingGroupList";
	public static final String SUPPLY_ORDER_PAYMENT_GROUP_LIST          = "supplyOrderPaymentGroupList";
	public static final String GOODS_LIST                               = "goodsList"         ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		RetailStoreCountryCenter	mBuyer              ;
	protected		GoodsSupplier       	mSeller             ;
	protected		String              	mTitle              ;
	protected		double              	mTotalAmount        ;
	protected		SupplyOrderConfirmation	mConfirmation       ;
	protected		SupplyOrderApproval 	mApproval           ;
	protected		SupplyOrderProcessing	mProcessing         ;
	protected		SupplyOrderPicking  	mPicking            ;
	protected		SupplyOrderShipment 	mShipment           ;
	protected		SupplyOrderDelivery 	mDelivery           ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<SupplyOrderLineItem>	mSupplyOrderLineItemList;
	protected		SmartList<SupplyOrderShippingGroup>	mSupplyOrderShippingGroupList;
	protected		SmartList<SupplyOrderPaymentGroup>	mSupplyOrderPaymentGroupList;
	protected		SmartList<Goods>    	mGoodsList          ;
	
		
	public 	SupplyOrder(){
		//lazy load for all the properties
	}
	
	public 	SupplyOrder(RetailStoreCountryCenter buyer, GoodsSupplier seller, String title, double totalAmount, String currentStatus
)
	{
		setBuyer(buyer);
		setSeller(seller);
		setTitle(title);
		setTotalAmount(totalAmount);
		setCurrentStatus(currentStatus);

		this.mSupplyOrderLineItemList = new SmartList<SupplyOrderLineItem>();
		this.mSupplyOrderShippingGroupList = new SmartList<SupplyOrderShippingGroup>();
		this.mSupplyOrderPaymentGroupList = new SmartList<SupplyOrderPaymentGroup>();
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
	
	
	public void setBuyer(RetailStoreCountryCenter buyer){
		this.mBuyer = buyer;;
	}
	public RetailStoreCountryCenter getBuyer(){
		return this.mBuyer;
	}
	
	
	public void setSeller(GoodsSupplier seller){
		this.mSeller = seller;;
	}
	public GoodsSupplier getSeller(){
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
	
	
	public void setPicking(SupplyOrderPicking picking){
		this.mPicking = picking;;
	}
	public SupplyOrderPicking getPicking(){
		return this.mPicking;
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
	
	
	public  SmartList<SupplyOrderLineItem> getSupplyOrderLineItemList(){
		if(this.mSupplyOrderLineItemList == null){
			this.mSupplyOrderLineItemList = new SmartList<SupplyOrderLineItem>();
		}
		return this.mSupplyOrderLineItemList;	
	}
	public  void setSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList){
		for( SupplyOrderLineItem supplyOrderLineItem:supplyOrderLineItemList){
			supplyOrderLineItem.setBizOrder(this);
		}
		
		this.mSupplyOrderLineItemList = supplyOrderLineItemList;
		
	}
	
	public  void addSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem){
		supplyOrderLineItem.setBizOrder(this);
		getSupplyOrderLineItemList().add(supplyOrderLineItem);
	}
	public  void addSupplyOrderLineItems(SmartList<SupplyOrderLineItem> supplyOrderLineItemList){
		for( SupplyOrderLineItem supplyOrderLineItem:supplyOrderLineItemList){
			supplyOrderLineItem.setBizOrder(this);
		}
		getSupplyOrderLineItemList().addAll(supplyOrderLineItemList);
	}
	
	public  void removeSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem){
	
		boolean result = getSupplyOrderLineItemList().planToRemove(supplyOrderLineItem);
        if(!result){
        	String message = "SupplyOrderLineItem("+supplyOrderLineItem.getId()+") with version='"+supplyOrderLineItem.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSupplyOrderLineItemList", supplyOrderLineItem);
		//the constant "toSupplyOrderLineItem" will be replaced after refactoried.
	
	}
	
	public void copySupplyOrderLineItemFrom(SupplyOrderLineItem supplyOrderLineItem) {
		// TODO Auto-generated method stub
		
        SupplyOrderLineItem supplyOrderLineItemInList = findTheSupplyOrderLineItem(supplyOrderLineItem);
        SupplyOrderLineItem newSupplyOrderLineItem = new SupplyOrderLineItem();
        supplyOrderLineItemInList.copyTo(newSupplyOrderLineItem);
        newSupplyOrderLineItem.setVersion(0);//will trigger copy
        getSupplyOrderLineItemList().add(newSupplyOrderLineItem);
	}
	
	public  SupplyOrderLineItem findTheSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem){
		
		int index =  getSupplyOrderLineItemList().indexOf(supplyOrderLineItem);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SupplyOrderLineItem("+supplyOrderLineItem.getId()+") with version='"+supplyOrderLineItem.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSupplyOrderLineItemList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderLineItemList(){
		getSupplyOrderLineItemList().clear();
	}
	
	
	
	
	public  SmartList<SupplyOrderShippingGroup> getSupplyOrderShippingGroupList(){
		if(this.mSupplyOrderShippingGroupList == null){
			this.mSupplyOrderShippingGroupList = new SmartList<SupplyOrderShippingGroup>();
		}
		return this.mSupplyOrderShippingGroupList;	
	}
	public  void setSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		for( SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList){
			supplyOrderShippingGroup.setBizOrder(this);
		}
		
		this.mSupplyOrderShippingGroupList = supplyOrderShippingGroupList;
		
	}
	
	public  void addSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup){
		supplyOrderShippingGroup.setBizOrder(this);
		getSupplyOrderShippingGroupList().add(supplyOrderShippingGroup);
	}
	public  void addSupplyOrderShippingGroups(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		for( SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList){
			supplyOrderShippingGroup.setBizOrder(this);
		}
		getSupplyOrderShippingGroupList().addAll(supplyOrderShippingGroupList);
	}
	
	public  void removeSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup){
	
		boolean result = getSupplyOrderShippingGroupList().planToRemove(supplyOrderShippingGroup);
        if(!result){
        	String message = "SupplyOrderShippingGroup("+supplyOrderShippingGroup.getId()+") with version='"+supplyOrderShippingGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSupplyOrderShippingGroupList", supplyOrderShippingGroup);
		//the constant "toSupplyOrderShippingGroup" will be replaced after refactoried.
	
	}
	
	public void copySupplyOrderShippingGroupFrom(SupplyOrderShippingGroup supplyOrderShippingGroup) {
		// TODO Auto-generated method stub
		
        SupplyOrderShippingGroup supplyOrderShippingGroupInList = findTheSupplyOrderShippingGroup(supplyOrderShippingGroup);
        SupplyOrderShippingGroup newSupplyOrderShippingGroup = new SupplyOrderShippingGroup();
        supplyOrderShippingGroupInList.copyTo(newSupplyOrderShippingGroup);
        newSupplyOrderShippingGroup.setVersion(0);//will trigger copy
        getSupplyOrderShippingGroupList().add(newSupplyOrderShippingGroup);
	}
	
	public  SupplyOrderShippingGroup findTheSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup){
		
		int index =  getSupplyOrderShippingGroupList().indexOf(supplyOrderShippingGroup);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SupplyOrderShippingGroup("+supplyOrderShippingGroup.getId()+") with version='"+supplyOrderShippingGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSupplyOrderShippingGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderShippingGroupList(){
		getSupplyOrderShippingGroupList().clear();
	}
	
	
	
	
	public  SmartList<SupplyOrderPaymentGroup> getSupplyOrderPaymentGroupList(){
		if(this.mSupplyOrderPaymentGroupList == null){
			this.mSupplyOrderPaymentGroupList = new SmartList<SupplyOrderPaymentGroup>();
		}
		return this.mSupplyOrderPaymentGroupList;	
	}
	public  void setSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		for( SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList){
			supplyOrderPaymentGroup.setBizOrder(this);
		}
		
		this.mSupplyOrderPaymentGroupList = supplyOrderPaymentGroupList;
		
	}
	
	public  void addSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
		supplyOrderPaymentGroup.setBizOrder(this);
		getSupplyOrderPaymentGroupList().add(supplyOrderPaymentGroup);
	}
	public  void addSupplyOrderPaymentGroups(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		for( SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList){
			supplyOrderPaymentGroup.setBizOrder(this);
		}
		getSupplyOrderPaymentGroupList().addAll(supplyOrderPaymentGroupList);
	}
	
	public  void removeSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
	
		boolean result = getSupplyOrderPaymentGroupList().planToRemove(supplyOrderPaymentGroup);
        if(!result){
        	String message = "SupplyOrderPaymentGroup("+supplyOrderPaymentGroup.getId()+") with version='"+supplyOrderPaymentGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSupplyOrderPaymentGroupList", supplyOrderPaymentGroup);
		//the constant "toSupplyOrderPaymentGroup" will be replaced after refactoried.
	
	}
	
	public void copySupplyOrderPaymentGroupFrom(SupplyOrderPaymentGroup supplyOrderPaymentGroup) {
		// TODO Auto-generated method stub
		
        SupplyOrderPaymentGroup supplyOrderPaymentGroupInList = findTheSupplyOrderPaymentGroup(supplyOrderPaymentGroup);
        SupplyOrderPaymentGroup newSupplyOrderPaymentGroup = new SupplyOrderPaymentGroup();
        supplyOrderPaymentGroupInList.copyTo(newSupplyOrderPaymentGroup);
        newSupplyOrderPaymentGroup.setVersion(0);//will trigger copy
        getSupplyOrderPaymentGroupList().add(newSupplyOrderPaymentGroup);
	}
	
	public  SupplyOrderPaymentGroup findTheSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
		
		int index =  getSupplyOrderPaymentGroupList().indexOf(supplyOrderPaymentGroup);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SupplyOrderPaymentGroup("+supplyOrderPaymentGroup.getId()+") with version='"+supplyOrderPaymentGroup.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSupplyOrderPaymentGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderPaymentGroupList(){
		getSupplyOrderPaymentGroupList().clear();
	}
	
	
	
	
	public  SmartList<Goods> getGoodsList(){
		if(this.mGoodsList == null){
			this.mGoodsList = new SmartList<Goods>();
		}
		return this.mGoodsList;	
	}
	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setBizOrder(this);
		}
		
		this.mGoodsList = goodsList;
		
	}
	
	public  void addGoods(Goods goods){
		goods.setBizOrder(this);
		getGoodsList().add(goods);
	}
	public  void addGoodses(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setBizOrder(this);
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
	
	
	
	
 	
	
	public SupplyOrder copyTo(SupplyOrder dest){

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
		dest.setSupplyOrderLineItemList(getSupplyOrderLineItemList());
		dest.setSupplyOrderShippingGroupList(getSupplyOrderShippingGroupList());
		dest.setSupplyOrderPaymentGroupList(getSupplyOrderPaymentGroupList());
		dest.setGoodsList(getGoodsList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("supply_order{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBuyer() != null ){
 			stringBuilder.append("\tbuyer='retail_store_country_center("+getBuyer().getId()+")';");
 		}
		if(getSeller() != null ){
 			stringBuilder.append("\tseller='goods_supplier("+getSeller().getId()+")';");
 		}
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\ttotal_amount='"+getTotalAmount()+"';");
		if(getConfirmation() != null ){
 			stringBuilder.append("\tconfirmation='supply_order_confirmation("+getConfirmation().getId()+")';");
 		}
		if(getApproval() != null ){
 			stringBuilder.append("\tapproval='supply_order_approval("+getApproval().getId()+")';");
 		}
		if(getProcessing() != null ){
 			stringBuilder.append("\tprocessing='supply_order_processing("+getProcessing().getId()+")';");
 		}
		if(getPicking() != null ){
 			stringBuilder.append("\tpicking='supply_order_picking("+getPicking().getId()+")';");
 		}
		if(getShipment() != null ){
 			stringBuilder.append("\tshipment='supply_order_shipment("+getShipment().getId()+")';");
 		}
		if(getDelivery() != null ){
 			stringBuilder.append("\tdelivery='supply_order_delivery("+getDelivery().getId()+")';");
 		}
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

