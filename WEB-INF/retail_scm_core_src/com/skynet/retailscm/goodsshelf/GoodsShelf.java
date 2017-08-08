
package com.skynet.retailscm.goodsshelf;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.skynet.retailscm.supplierspace.SupplierSpace;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;

@JsonSerialize(using = GoodsShelfSerializer.class)
public class GoodsShelf extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String STORAGE_SPACE_PROPERTY         = "storageSpace"      ;
	public static final String SUPPLIER_SPACE_PROPERTY        = "supplierSpace"     ;
	public static final String DAMAGE_SPACE_PROPERTY          = "damageSpace"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_SHELF_STOCK_COUNT_LIST             = "goodsShelfStockCountList";
	public static final String GOODS_ALLOCATION_LIST                    = "goodsAllocationList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mLocation           ;
	protected		StorageSpace        	mStorageSpace       ;
	protected		SupplierSpace       	mSupplierSpace      ;
	protected		DamageSpace         	mDamageSpace        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<GoodsShelfStockCount>	mGoodsShelfStockCountList;
	protected		SmartList<GoodsAllocation>	mGoodsAllocationList;
	
		
	public 	GoodsShelf(){
		//lazy load for all the properties
	}
	
	public 	GoodsShelf(String location, StorageSpace storageSpace, SupplierSpace supplierSpace, DamageSpace damageSpace
)
	{
		setLocation(location);
		setStorageSpace(storageSpace);
		setSupplierSpace(supplierSpace);
		setDamageSpace(damageSpace);

		this.mGoodsShelfStockCountList = new SmartList<GoodsShelfStockCount>();
		this.mGoodsAllocationList = new SmartList<GoodsAllocation>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLocationProperty(String newValueExpr){
		String oldValue = getLocation();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLocation(newValue);
		//they are surely different each other
		this.onChangeProperty(LOCATION_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setLocation(String location){
		this.mLocation = trimString(location);;
	}
	public String getLocation(){
		return this.mLocation;
	}
	
	
	public void setStorageSpace(StorageSpace storageSpace){
		this.mStorageSpace = storageSpace;;
	}
	public StorageSpace getStorageSpace(){
		return this.mStorageSpace;
	}
	
	
	public void setSupplierSpace(SupplierSpace supplierSpace){
		this.mSupplierSpace = supplierSpace;;
	}
	public SupplierSpace getSupplierSpace(){
		return this.mSupplierSpace;
	}
	
	
	public void setDamageSpace(DamageSpace damageSpace){
		this.mDamageSpace = damageSpace;;
	}
	public DamageSpace getDamageSpace(){
		return this.mDamageSpace;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<GoodsShelfStockCount> getGoodsShelfStockCountList(){
		if(this.mGoodsShelfStockCountList == null){
			this.mGoodsShelfStockCountList = new SmartList<GoodsShelfStockCount>();
		}
		return this.mGoodsShelfStockCountList;	
	}
	public  void setGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList){
		for( GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList){
			goodsShelfStockCount.setShelf(this);
		}
		
		this.mGoodsShelfStockCountList = goodsShelfStockCountList;
		
	}
	
	public  void addGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount){
		goodsShelfStockCount.setShelf(this);
		getGoodsShelfStockCountList().add(goodsShelfStockCount);
	}
	public  void addGoodsShelfStockCounts(SmartList<GoodsShelfStockCount> goodsShelfStockCountList){
		for( GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList){
			goodsShelfStockCount.setShelf(this);
		}
		getGoodsShelfStockCountList().addAll(goodsShelfStockCountList);
	}
	
	public  void removeGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount){
	
		boolean result = getGoodsShelfStockCountList().planToRemove(goodsShelfStockCount);
        if(!result){
        	String message = "GoodsShelfStockCount("+goodsShelfStockCount.getId()+") with version='"+goodsShelfStockCount.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveGoodsShelfStockCountList", goodsShelfStockCount);
		//the constant "toGoodsShelfStockCount" will be replaced after refactoried.
	
	}
	
	public void copyGoodsShelfStockCountFrom(GoodsShelfStockCount goodsShelfStockCount) {
		// TODO Auto-generated method stub
		
        GoodsShelfStockCount goodsShelfStockCountInList = findTheGoodsShelfStockCount(goodsShelfStockCount);
        GoodsShelfStockCount newGoodsShelfStockCount = new GoodsShelfStockCount();
        goodsShelfStockCountInList.copyTo(newGoodsShelfStockCount);
        newGoodsShelfStockCount.setVersion(0);//will trigger copy
        getGoodsShelfStockCountList().add(newGoodsShelfStockCount);
	}
	
	public  GoodsShelfStockCount findTheGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount){
		
		int index =  getGoodsShelfStockCountList().indexOf(goodsShelfStockCount);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "GoodsShelfStockCount("+goodsShelfStockCount.getId()+") with version='"+goodsShelfStockCount.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getGoodsShelfStockCountList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsShelfStockCountList(){
		getGoodsShelfStockCountList().clear();
	}
	
	
	
	
	public  SmartList<GoodsAllocation> getGoodsAllocationList(){
		if(this.mGoodsAllocationList == null){
			this.mGoodsAllocationList = new SmartList<GoodsAllocation>();
		}
		return this.mGoodsAllocationList;	
	}
	public  void setGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList){
		for( GoodsAllocation goodsAllocation:goodsAllocationList){
			goodsAllocation.setGoodsShelf(this);
		}
		
		this.mGoodsAllocationList = goodsAllocationList;
		
	}
	
	public  void addGoodsAllocation(GoodsAllocation goodsAllocation){
		goodsAllocation.setGoodsShelf(this);
		getGoodsAllocationList().add(goodsAllocation);
	}
	public  void addGoodsAllocations(SmartList<GoodsAllocation> goodsAllocationList){
		for( GoodsAllocation goodsAllocation:goodsAllocationList){
			goodsAllocation.setGoodsShelf(this);
		}
		getGoodsAllocationList().addAll(goodsAllocationList);
	}
	
	public  void removeGoodsAllocation(GoodsAllocation goodsAllocation){
	
		boolean result = getGoodsAllocationList().planToRemove(goodsAllocation);
        if(!result){
        	String message = "GoodsAllocation("+goodsAllocation.getId()+") with version='"+goodsAllocation.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveGoodsAllocationList", goodsAllocation);
		//the constant "toGoodsAllocation" will be replaced after refactoried.
	
	}
	
	public void copyGoodsAllocationFrom(GoodsAllocation goodsAllocation) {
		// TODO Auto-generated method stub
		
        GoodsAllocation goodsAllocationInList = findTheGoodsAllocation(goodsAllocation);
        GoodsAllocation newGoodsAllocation = new GoodsAllocation();
        goodsAllocationInList.copyTo(newGoodsAllocation);
        newGoodsAllocation.setVersion(0);//will trigger copy
        getGoodsAllocationList().add(newGoodsAllocation);
	}
	
	public  GoodsAllocation findTheGoodsAllocation(GoodsAllocation goodsAllocation){
		
		int index =  getGoodsAllocationList().indexOf(goodsAllocation);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "GoodsAllocation("+goodsAllocation.getId()+") with version='"+goodsAllocation.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getGoodsAllocationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsAllocationList(){
		getGoodsAllocationList().clear();
	}
	
	
	
	
 	
	
	public GoodsShelf copyTo(GoodsShelf dest){

		dest.setId(getId());
		dest.setLocation(getLocation());
		dest.setStorageSpace(getStorageSpace());
		dest.setSupplierSpace(getSupplierSpace());
		dest.setDamageSpace(getDamageSpace());
		dest.setVersion(getVersion());
		dest.setGoodsShelfStockCountList(getGoodsShelfStockCountList());
		dest.setGoodsAllocationList(getGoodsAllocationList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("goods_shelf{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		if(getStorageSpace() != null ){
 			stringBuilder.append("\tstorage_space='storage_space("+getStorageSpace().getId()+")';");
 		}
		if(getSupplierSpace() != null ){
 			stringBuilder.append("\tsupplier_space='supplier_space("+getSupplierSpace().getId()+")';");
 		}
		if(getDamageSpace() != null ){
 			stringBuilder.append("\tdamage_space='damage_space("+getDamageSpace().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

