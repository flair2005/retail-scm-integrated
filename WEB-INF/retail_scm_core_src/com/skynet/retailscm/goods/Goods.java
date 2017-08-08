
package com.skynet.retailscm.goods;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.goodsmovement.GoodsMovement;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;

@JsonSerialize(using = GoodsSerializer.class)
public class Goods extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String RFID_PROPERTY                  = "rfid"              ;
	public static final String UOM_PROPERTY                   = "uom"               ;
	public static final String MAX_PACKAGE_PROPERTY           = "maxPackage"        ;
	public static final String EXPIRE_TIME_PROPERTY           = "expireTime"        ;
	public static final String SKU_PROPERTY                   = "sku"               ;
	public static final String RECEIVING_SPACE_PROPERTY       = "receivingSpace"    ;
	public static final String GOODS_ALLOCATION_PROPERTY      = "goodsAllocation"   ;
	public static final String SMART_PALLET_PROPERTY          = "smartPallet"       ;
	public static final String SHIPPING_SPACE_PROPERTY        = "shippingSpace"     ;
	public static final String TRANSPORT_TASK_PROPERTY        = "transportTask"     ;
	public static final String RETAIL_STORE_PROPERTY          = "retailStore"       ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String RETAIL_STORE_ORDER_PROPERTY    = "retailStoreOrder"  ;
	public static final String PACKAGING_PROPERTY             = "packaging"         ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_MOVEMENT_LIST                      = "goodsMovementList" ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mRfid               ;
	protected		String              	mUom                ;
	protected		int                 	mMaxPackage         ;
	protected		Date                	mExpireTime         ;
	protected		Sku                 	mSku                ;
	protected		ReceivingSpace      	mReceivingSpace     ;
	protected		GoodsAllocation     	mGoodsAllocation    ;
	protected		SmartPallet         	mSmartPallet        ;
	protected		ShippingSpace       	mShippingSpace      ;
	protected		TransportTask       	mTransportTask      ;
	protected		RetailStore         	mRetailStore        ;
	protected		SupplyOrder         	mBizOrder           ;
	protected		RetailStoreOrder    	mRetailStoreOrder   ;
	protected		GoodsPackaging      	mPackaging          ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<GoodsMovement>	mGoodsMovementList  ;
	
		
	public 	Goods(){
		//lazy load for all the properties
	}
	
	public 	Goods(String name, String rfid, String uom, int maxPackage, Date expireTime, Sku sku, ReceivingSpace receivingSpace, GoodsAllocation goodsAllocation, SmartPallet smartPallet, ShippingSpace shippingSpace, TransportTask transportTask, RetailStore retailStore, SupplyOrder bizOrder, RetailStoreOrder retailStoreOrder, String currentStatus
)
	{
		setName(name);
		setRfid(rfid);
		setUom(uom);
		setMaxPackage(maxPackage);
		setExpireTime(expireTime);
		setSku(sku);
		setReceivingSpace(receivingSpace);
		setGoodsAllocation(goodsAllocation);
		setSmartPallet(smartPallet);
		setShippingSpace(shippingSpace);
		setTransportTask(transportTask);
		setRetailStore(retailStore);
		setBizOrder(bizOrder);
		setRetailStoreOrder(retailStoreOrder);
		setCurrentStatus(currentStatus);

		this.mGoodsMovementList = new SmartList<GoodsMovement>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(RFID_PROPERTY.equals(property)){
			changeRfidProperty(newValueExpr);
		}
		if(UOM_PROPERTY.equals(property)){
			changeUomProperty(newValueExpr);
		}
		if(MAX_PACKAGE_PROPERTY.equals(property)){
			changeMaxPackageProperty(newValueExpr);
		}
		if(EXPIRE_TIME_PROPERTY.equals(property)){
			changeExpireTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setName(newValue);
		//they are surely different each other
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeRfidProperty(String newValueExpr){
		String oldValue = getRfid();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setRfid(newValue);
		//they are surely different each other
		this.onChangeProperty(RFID_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeUomProperty(String newValueExpr){
		String oldValue = getUom();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setUom(newValue);
		//they are surely different each other
		this.onChangeProperty(UOM_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMaxPackageProperty(String newValueExpr){
		int oldValue = getMaxPackage();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMaxPackage(newValue);
		//they are surely different each other
		this.onChangeProperty(MAX_PACKAGE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeExpireTimeProperty(String newValueExpr){
		Date oldValue = getExpireTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setExpireTime(newValue);
		//they are surely different each other
		this.onChangeProperty(EXPIRE_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	
	
	public void setRfid(String rfid){
		this.mRfid = trimString(rfid);;
	}
	public String getRfid(){
		return this.mRfid;
	}
	
	
	public void setUom(String uom){
		this.mUom = trimString(uom);;
	}
	public String getUom(){
		return this.mUom;
	}
	
	
	public void setMaxPackage(int maxPackage){
		this.mMaxPackage = maxPackage;;
	}
	public int getMaxPackage(){
		return this.mMaxPackage;
	}
	
	
	public void setExpireTime(Date expireTime){
		this.mExpireTime = expireTime;;
	}
	public Date getExpireTime(){
		return this.mExpireTime;
	}
	
	
	public void setSku(Sku sku){
		this.mSku = sku;;
	}
	public Sku getSku(){
		return this.mSku;
	}
	
	
	public void setReceivingSpace(ReceivingSpace receivingSpace){
		this.mReceivingSpace = receivingSpace;;
	}
	public ReceivingSpace getReceivingSpace(){
		return this.mReceivingSpace;
	}
	
	
	public void setGoodsAllocation(GoodsAllocation goodsAllocation){
		this.mGoodsAllocation = goodsAllocation;;
	}
	public GoodsAllocation getGoodsAllocation(){
		return this.mGoodsAllocation;
	}
	
	
	public void setSmartPallet(SmartPallet smartPallet){
		this.mSmartPallet = smartPallet;;
	}
	public SmartPallet getSmartPallet(){
		return this.mSmartPallet;
	}
	
	
	public void setShippingSpace(ShippingSpace shippingSpace){
		this.mShippingSpace = shippingSpace;;
	}
	public ShippingSpace getShippingSpace(){
		return this.mShippingSpace;
	}
	
	
	public void setTransportTask(TransportTask transportTask){
		this.mTransportTask = transportTask;;
	}
	public TransportTask getTransportTask(){
		return this.mTransportTask;
	}
	
	
	public void setRetailStore(RetailStore retailStore){
		this.mRetailStore = retailStore;;
	}
	public RetailStore getRetailStore(){
		return this.mRetailStore;
	}
	
	
	public void setBizOrder(SupplyOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public SupplyOrder getBizOrder(){
		return this.mBizOrder;
	}
	
	
	public void setRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		this.mRetailStoreOrder = retailStoreOrder;;
	}
	public RetailStoreOrder getRetailStoreOrder(){
		return this.mRetailStoreOrder;
	}
	
	
	public void setPackaging(GoodsPackaging packaging){
		this.mPackaging = packaging;;
	}
	public GoodsPackaging getPackaging(){
		return this.mPackaging;
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
	
	
	public  SmartList<GoodsMovement> getGoodsMovementList(){
		if(this.mGoodsMovementList == null){
			this.mGoodsMovementList = new SmartList<GoodsMovement>();
		}
		return this.mGoodsMovementList;	
	}
	public  void setGoodsMovementList(SmartList<GoodsMovement> goodsMovementList){
		for( GoodsMovement goodsMovement:goodsMovementList){
			goodsMovement.setGoods(this);
		}
		
		this.mGoodsMovementList = goodsMovementList;
		
	}
	
	public  void addGoodsMovement(GoodsMovement goodsMovement){
		goodsMovement.setGoods(this);
		getGoodsMovementList().add(goodsMovement);
	}
	public  void addGoodsMovements(SmartList<GoodsMovement> goodsMovementList){
		for( GoodsMovement goodsMovement:goodsMovementList){
			goodsMovement.setGoods(this);
		}
		getGoodsMovementList().addAll(goodsMovementList);
	}
	
	public  void removeGoodsMovement(GoodsMovement goodsMovement){
	
		boolean result = getGoodsMovementList().planToRemove(goodsMovement);
        if(!result){
        	String message = "GoodsMovement("+goodsMovement.getId()+") with version='"+goodsMovement.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveGoodsMovementList", goodsMovement);
		//the constant "toGoodsMovement" will be replaced after refactoried.
	
	}
	
	public void copyGoodsMovementFrom(GoodsMovement goodsMovement) {
		// TODO Auto-generated method stub
		
        GoodsMovement goodsMovementInList = findTheGoodsMovement(goodsMovement);
        GoodsMovement newGoodsMovement = new GoodsMovement();
        goodsMovementInList.copyTo(newGoodsMovement);
        newGoodsMovement.setVersion(0);//will trigger copy
        getGoodsMovementList().add(newGoodsMovement);
	}
	
	public  GoodsMovement findTheGoodsMovement(GoodsMovement goodsMovement){
		
		int index =  getGoodsMovementList().indexOf(goodsMovement);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "GoodsMovement("+goodsMovement.getId()+") with version='"+goodsMovement.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getGoodsMovementList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsMovementList(){
		getGoodsMovementList().clear();
	}
	
	
	
	
 	
	
	public Goods copyTo(Goods dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setRfid(getRfid());
		dest.setUom(getUom());
		dest.setMaxPackage(getMaxPackage());
		dest.setExpireTime(getExpireTime());
		dest.setSku(getSku());
		dest.setReceivingSpace(getReceivingSpace());
		dest.setGoodsAllocation(getGoodsAllocation());
		dest.setSmartPallet(getSmartPallet());
		dest.setShippingSpace(getShippingSpace());
		dest.setTransportTask(getTransportTask());
		dest.setRetailStore(getRetailStore());
		dest.setBizOrder(getBizOrder());
		dest.setRetailStoreOrder(getRetailStoreOrder());
		dest.setPackaging(getPackaging());
		dest.setCurrentStatus(getCurrentStatus());
		dest.setVersion(getVersion());
		dest.setGoodsMovementList(getGoodsMovementList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("goods{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\trfid='"+getRfid()+"';");
		stringBuilder.append("\tuom='"+getUom()+"';");
		stringBuilder.append("\tmax_package='"+getMaxPackage()+"';");
		stringBuilder.append("\texpire_time='"+getExpireTime()+"';");
		if(getSku() != null ){
 			stringBuilder.append("\tsku='sku("+getSku().getId()+")';");
 		}
		if(getReceivingSpace() != null ){
 			stringBuilder.append("\treceiving_space='receiving_space("+getReceivingSpace().getId()+")';");
 		}
		if(getGoodsAllocation() != null ){
 			stringBuilder.append("\tgoods_allocation='goods_allocation("+getGoodsAllocation().getId()+")';");
 		}
		if(getSmartPallet() != null ){
 			stringBuilder.append("\tsmart_pallet='smart_pallet("+getSmartPallet().getId()+")';");
 		}
		if(getShippingSpace() != null ){
 			stringBuilder.append("\tshipping_space='shipping_space("+getShippingSpace().getId()+")';");
 		}
		if(getTransportTask() != null ){
 			stringBuilder.append("\ttransport_task='transport_task("+getTransportTask().getId()+")';");
 		}
		if(getRetailStore() != null ){
 			stringBuilder.append("\tretail_store='retail_store("+getRetailStore().getId()+")';");
 		}
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbiz_order='supply_order("+getBizOrder().getId()+")';");
 		}
		if(getRetailStoreOrder() != null ){
 			stringBuilder.append("\tretail_store_order='retail_store_order("+getRetailStoreOrder().getId()+")';");
 		}
		if(getPackaging() != null ){
 			stringBuilder.append("\tpackaging='goods_packaging("+getPackaging().getId()+")';");
 		}
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

