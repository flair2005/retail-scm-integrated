
package com.skynet.retailscm.warehouse;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.warehouseasset.WarehouseAsset;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.supplierspace.SupplierSpace;

@JsonSerialize(using = WarehouseSerializer.class)
public class Warehouse extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String TOTAL_AREA_PROPERTY            = "totalArea"         ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String STORAGE_SPACE_LIST                       = "storageSpaceList"  ;
	public static final String SMART_PALLET_LIST                        = "smartPalletList"   ;
	public static final String SUPPLIER_SPACE_LIST                      = "supplierSpaceList" ;
	public static final String RECEIVING_SPACE_LIST                     = "receivingSpaceList";
	public static final String SHIPPING_SPACE_LIST                      = "shippingSpaceList" ;
	public static final String DAMAGE_SPACE_LIST                        = "damageSpaceList"   ;
	public static final String WAREHOUSE_ASSET_LIST                     = "warehouseAssetList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mLocation           ;
	protected		String              	mContactNumber      ;
	protected		String              	mTotalArea          ;
	protected		RetailStoreCountryCenter	mOwner              ;
	protected		double              	mLatitude           ;
	protected		double              	mLongitude          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<StorageSpace>	mStorageSpaceList   ;
	protected		SmartList<SmartPallet>	mSmartPalletList    ;
	protected		SmartList<SupplierSpace>	mSupplierSpaceList  ;
	protected		SmartList<ReceivingSpace>	mReceivingSpaceList ;
	protected		SmartList<ShippingSpace>	mShippingSpaceList  ;
	protected		SmartList<DamageSpace>	mDamageSpaceList    ;
	protected		SmartList<WarehouseAsset>	mWarehouseAssetList ;
	
		
	public 	Warehouse(){
		//lazy load for all the properties
	}
	
	public 	Warehouse(String location, String contactNumber, String totalArea, RetailStoreCountryCenter owner, double latitude, double longitude
)
	{
		setLocation(location);
		setContactNumber(contactNumber);
		setTotalArea(totalArea);
		setOwner(owner);
		setLatitude(latitude);
		setLongitude(longitude);

		this.mStorageSpaceList = new SmartList<StorageSpace>();
		this.mSmartPalletList = new SmartList<SmartPallet>();
		this.mSupplierSpaceList = new SmartList<SupplierSpace>();
		this.mReceivingSpaceList = new SmartList<ReceivingSpace>();
		this.mShippingSpaceList = new SmartList<ShippingSpace>();
		this.mDamageSpaceList = new SmartList<DamageSpace>();
		this.mWarehouseAssetList = new SmartList<WarehouseAsset>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
		}
		if(TOTAL_AREA_PROPERTY.equals(property)){
			changeTotalAreaProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
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
			
			
			
	protected void changeContactNumberProperty(String newValueExpr){
		String oldValue = getContactNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setContactNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(CONTACT_NUMBER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeTotalAreaProperty(String newValueExpr){
		String oldValue = getTotalArea();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTotalArea(newValue);
		//they are surely different each other
		this.onChangeProperty(TOTAL_AREA_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLatitudeProperty(String newValueExpr){
		double oldValue = getLatitude();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLatitude(newValue);
		//they are surely different each other
		this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLongitudeProperty(String newValueExpr){
		double oldValue = getLongitude();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLongitude(newValue);
		//they are surely different each other
		this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
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
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	
	
	public void setTotalArea(String totalArea){
		this.mTotalArea = trimString(totalArea);;
	}
	public String getTotalArea(){
		return this.mTotalArea;
	}
	
	
	public void setOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
	}
	public RetailStoreCountryCenter getOwner(){
		return this.mOwner;
	}
	
	
	public void setLatitude(double latitude){
		this.mLatitude = latitude;;
	}
	public double getLatitude(){
		return this.mLatitude;
	}
	
	
	public void setLongitude(double longitude){
		this.mLongitude = longitude;;
	}
	public double getLongitude(){
		return this.mLongitude;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<StorageSpace> getStorageSpaceList(){
		if(this.mStorageSpaceList == null){
			this.mStorageSpaceList = new SmartList<StorageSpace>();
		}
		return this.mStorageSpaceList;	
	}
	public  void setStorageSpaceList(SmartList<StorageSpace> storageSpaceList){
		for( StorageSpace storageSpace:storageSpaceList){
			storageSpace.setWarehouse(this);
		}
		
		this.mStorageSpaceList = storageSpaceList;
		
	}
	
	public  void addStorageSpace(StorageSpace storageSpace){
		storageSpace.setWarehouse(this);
		getStorageSpaceList().add(storageSpace);
	}
	public  void addStorageSpaces(SmartList<StorageSpace> storageSpaceList){
		for( StorageSpace storageSpace:storageSpaceList){
			storageSpace.setWarehouse(this);
		}
		getStorageSpaceList().addAll(storageSpaceList);
	}
	
	public  void removeStorageSpace(StorageSpace storageSpace){
	
		boolean result = getStorageSpaceList().planToRemove(storageSpace);
        if(!result){
        	String message = "StorageSpace("+storageSpace.getId()+") with version='"+storageSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveStorageSpaceList", storageSpace);
		//the constant "toStorageSpace" will be replaced after refactoried.
	
	}
	
	public void copyStorageSpaceFrom(StorageSpace storageSpace) {
		// TODO Auto-generated method stub
		
        StorageSpace storageSpaceInList = findTheStorageSpace(storageSpace);
        StorageSpace newStorageSpace = new StorageSpace();
        storageSpaceInList.copyTo(newStorageSpace);
        newStorageSpace.setVersion(0);//will trigger copy
        getStorageSpaceList().add(newStorageSpace);
	}
	
	public  StorageSpace findTheStorageSpace(StorageSpace storageSpace){
		
		int index =  getStorageSpaceList().indexOf(storageSpace);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "StorageSpace("+storageSpace.getId()+") with version='"+storageSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getStorageSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpStorageSpaceList(){
		getStorageSpaceList().clear();
	}
	
	
	
	
	public  SmartList<SmartPallet> getSmartPalletList(){
		if(this.mSmartPalletList == null){
			this.mSmartPalletList = new SmartList<SmartPallet>();
		}
		return this.mSmartPalletList;	
	}
	public  void setSmartPalletList(SmartList<SmartPallet> smartPalletList){
		for( SmartPallet smartPallet:smartPalletList){
			smartPallet.setWarehouse(this);
		}
		
		this.mSmartPalletList = smartPalletList;
		
	}
	
	public  void addSmartPallet(SmartPallet smartPallet){
		smartPallet.setWarehouse(this);
		getSmartPalletList().add(smartPallet);
	}
	public  void addSmartPallets(SmartList<SmartPallet> smartPalletList){
		for( SmartPallet smartPallet:smartPalletList){
			smartPallet.setWarehouse(this);
		}
		getSmartPalletList().addAll(smartPalletList);
	}
	
	public  void removeSmartPallet(SmartPallet smartPallet){
	
		boolean result = getSmartPalletList().planToRemove(smartPallet);
        if(!result){
        	String message = "SmartPallet("+smartPallet.getId()+") with version='"+smartPallet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSmartPalletList", smartPallet);
		//the constant "toSmartPallet" will be replaced after refactoried.
	
	}
	
	public void copySmartPalletFrom(SmartPallet smartPallet) {
		// TODO Auto-generated method stub
		
        SmartPallet smartPalletInList = findTheSmartPallet(smartPallet);
        SmartPallet newSmartPallet = new SmartPallet();
        smartPalletInList.copyTo(newSmartPallet);
        newSmartPallet.setVersion(0);//will trigger copy
        getSmartPalletList().add(newSmartPallet);
	}
	
	public  SmartPallet findTheSmartPallet(SmartPallet smartPallet){
		
		int index =  getSmartPalletList().indexOf(smartPallet);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SmartPallet("+smartPallet.getId()+") with version='"+smartPallet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSmartPalletList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSmartPalletList(){
		getSmartPalletList().clear();
	}
	
	
	
	
	public  SmartList<SupplierSpace> getSupplierSpaceList(){
		if(this.mSupplierSpaceList == null){
			this.mSupplierSpaceList = new SmartList<SupplierSpace>();
		}
		return this.mSupplierSpaceList;	
	}
	public  void setSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList){
		for( SupplierSpace supplierSpace:supplierSpaceList){
			supplierSpace.setWarehouse(this);
		}
		
		this.mSupplierSpaceList = supplierSpaceList;
		
	}
	
	public  void addSupplierSpace(SupplierSpace supplierSpace){
		supplierSpace.setWarehouse(this);
		getSupplierSpaceList().add(supplierSpace);
	}
	public  void addSupplierSpaces(SmartList<SupplierSpace> supplierSpaceList){
		for( SupplierSpace supplierSpace:supplierSpaceList){
			supplierSpace.setWarehouse(this);
		}
		getSupplierSpaceList().addAll(supplierSpaceList);
	}
	
	public  void removeSupplierSpace(SupplierSpace supplierSpace){
	
		boolean result = getSupplierSpaceList().planToRemove(supplierSpace);
        if(!result){
        	String message = "SupplierSpace("+supplierSpace.getId()+") with version='"+supplierSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSupplierSpaceList", supplierSpace);
		//the constant "toSupplierSpace" will be replaced after refactoried.
	
	}
	
	public void copySupplierSpaceFrom(SupplierSpace supplierSpace) {
		// TODO Auto-generated method stub
		
        SupplierSpace supplierSpaceInList = findTheSupplierSpace(supplierSpace);
        SupplierSpace newSupplierSpace = new SupplierSpace();
        supplierSpaceInList.copyTo(newSupplierSpace);
        newSupplierSpace.setVersion(0);//will trigger copy
        getSupplierSpaceList().add(newSupplierSpace);
	}
	
	public  SupplierSpace findTheSupplierSpace(SupplierSpace supplierSpace){
		
		int index =  getSupplierSpaceList().indexOf(supplierSpace);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SupplierSpace("+supplierSpace.getId()+") with version='"+supplierSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSupplierSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplierSpaceList(){
		getSupplierSpaceList().clear();
	}
	
	
	
	
	public  SmartList<ReceivingSpace> getReceivingSpaceList(){
		if(this.mReceivingSpaceList == null){
			this.mReceivingSpaceList = new SmartList<ReceivingSpace>();
		}
		return this.mReceivingSpaceList;	
	}
	public  void setReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList){
		for( ReceivingSpace receivingSpace:receivingSpaceList){
			receivingSpace.setWarehouse(this);
		}
		
		this.mReceivingSpaceList = receivingSpaceList;
		
	}
	
	public  void addReceivingSpace(ReceivingSpace receivingSpace){
		receivingSpace.setWarehouse(this);
		getReceivingSpaceList().add(receivingSpace);
	}
	public  void addReceivingSpaces(SmartList<ReceivingSpace> receivingSpaceList){
		for( ReceivingSpace receivingSpace:receivingSpaceList){
			receivingSpace.setWarehouse(this);
		}
		getReceivingSpaceList().addAll(receivingSpaceList);
	}
	
	public  void removeReceivingSpace(ReceivingSpace receivingSpace){
	
		boolean result = getReceivingSpaceList().planToRemove(receivingSpace);
        if(!result){
        	String message = "ReceivingSpace("+receivingSpace.getId()+") with version='"+receivingSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveReceivingSpaceList", receivingSpace);
		//the constant "toReceivingSpace" will be replaced after refactoried.
	
	}
	
	public void copyReceivingSpaceFrom(ReceivingSpace receivingSpace) {
		// TODO Auto-generated method stub
		
        ReceivingSpace receivingSpaceInList = findTheReceivingSpace(receivingSpace);
        ReceivingSpace newReceivingSpace = new ReceivingSpace();
        receivingSpaceInList.copyTo(newReceivingSpace);
        newReceivingSpace.setVersion(0);//will trigger copy
        getReceivingSpaceList().add(newReceivingSpace);
	}
	
	public  ReceivingSpace findTheReceivingSpace(ReceivingSpace receivingSpace){
		
		int index =  getReceivingSpaceList().indexOf(receivingSpace);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ReceivingSpace("+receivingSpace.getId()+") with version='"+receivingSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getReceivingSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpReceivingSpaceList(){
		getReceivingSpaceList().clear();
	}
	
	
	
	
	public  SmartList<ShippingSpace> getShippingSpaceList(){
		if(this.mShippingSpaceList == null){
			this.mShippingSpaceList = new SmartList<ShippingSpace>();
		}
		return this.mShippingSpaceList;	
	}
	public  void setShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList){
		for( ShippingSpace shippingSpace:shippingSpaceList){
			shippingSpace.setWarehouse(this);
		}
		
		this.mShippingSpaceList = shippingSpaceList;
		
	}
	
	public  void addShippingSpace(ShippingSpace shippingSpace){
		shippingSpace.setWarehouse(this);
		getShippingSpaceList().add(shippingSpace);
	}
	public  void addShippingSpaces(SmartList<ShippingSpace> shippingSpaceList){
		for( ShippingSpace shippingSpace:shippingSpaceList){
			shippingSpace.setWarehouse(this);
		}
		getShippingSpaceList().addAll(shippingSpaceList);
	}
	
	public  void removeShippingSpace(ShippingSpace shippingSpace){
	
		boolean result = getShippingSpaceList().planToRemove(shippingSpace);
        if(!result){
        	String message = "ShippingSpace("+shippingSpace.getId()+") with version='"+shippingSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveShippingSpaceList", shippingSpace);
		//the constant "toShippingSpace" will be replaced after refactoried.
	
	}
	
	public void copyShippingSpaceFrom(ShippingSpace shippingSpace) {
		// TODO Auto-generated method stub
		
        ShippingSpace shippingSpaceInList = findTheShippingSpace(shippingSpace);
        ShippingSpace newShippingSpace = new ShippingSpace();
        shippingSpaceInList.copyTo(newShippingSpace);
        newShippingSpace.setVersion(0);//will trigger copy
        getShippingSpaceList().add(newShippingSpace);
	}
	
	public  ShippingSpace findTheShippingSpace(ShippingSpace shippingSpace){
		
		int index =  getShippingSpaceList().indexOf(shippingSpace);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ShippingSpace("+shippingSpace.getId()+") with version='"+shippingSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getShippingSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpShippingSpaceList(){
		getShippingSpaceList().clear();
	}
	
	
	
	
	public  SmartList<DamageSpace> getDamageSpaceList(){
		if(this.mDamageSpaceList == null){
			this.mDamageSpaceList = new SmartList<DamageSpace>();
		}
		return this.mDamageSpaceList;	
	}
	public  void setDamageSpaceList(SmartList<DamageSpace> damageSpaceList){
		for( DamageSpace damageSpace:damageSpaceList){
			damageSpace.setWarehouse(this);
		}
		
		this.mDamageSpaceList = damageSpaceList;
		
	}
	
	public  void addDamageSpace(DamageSpace damageSpace){
		damageSpace.setWarehouse(this);
		getDamageSpaceList().add(damageSpace);
	}
	public  void addDamageSpaces(SmartList<DamageSpace> damageSpaceList){
		for( DamageSpace damageSpace:damageSpaceList){
			damageSpace.setWarehouse(this);
		}
		getDamageSpaceList().addAll(damageSpaceList);
	}
	
	public  void removeDamageSpace(DamageSpace damageSpace){
	
		boolean result = getDamageSpaceList().planToRemove(damageSpace);
        if(!result){
        	String message = "DamageSpace("+damageSpace.getId()+") with version='"+damageSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveDamageSpaceList", damageSpace);
		//the constant "toDamageSpace" will be replaced after refactoried.
	
	}
	
	public void copyDamageSpaceFrom(DamageSpace damageSpace) {
		// TODO Auto-generated method stub
		
        DamageSpace damageSpaceInList = findTheDamageSpace(damageSpace);
        DamageSpace newDamageSpace = new DamageSpace();
        damageSpaceInList.copyTo(newDamageSpace);
        newDamageSpace.setVersion(0);//will trigger copy
        getDamageSpaceList().add(newDamageSpace);
	}
	
	public  DamageSpace findTheDamageSpace(DamageSpace damageSpace){
		
		int index =  getDamageSpaceList().indexOf(damageSpace);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "DamageSpace("+damageSpace.getId()+") with version='"+damageSpace.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getDamageSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpDamageSpaceList(){
		getDamageSpaceList().clear();
	}
	
	
	
	
	public  SmartList<WarehouseAsset> getWarehouseAssetList(){
		if(this.mWarehouseAssetList == null){
			this.mWarehouseAssetList = new SmartList<WarehouseAsset>();
		}
		return this.mWarehouseAssetList;	
	}
	public  void setWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList){
		for( WarehouseAsset warehouseAsset:warehouseAssetList){
			warehouseAsset.setOwner(this);
		}
		
		this.mWarehouseAssetList = warehouseAssetList;
		
	}
	
	public  void addWarehouseAsset(WarehouseAsset warehouseAsset){
		warehouseAsset.setOwner(this);
		getWarehouseAssetList().add(warehouseAsset);
	}
	public  void addWarehouseAssets(SmartList<WarehouseAsset> warehouseAssetList){
		for( WarehouseAsset warehouseAsset:warehouseAssetList){
			warehouseAsset.setOwner(this);
		}
		getWarehouseAssetList().addAll(warehouseAssetList);
	}
	
	public  void removeWarehouseAsset(WarehouseAsset warehouseAsset){
	
		boolean result = getWarehouseAssetList().planToRemove(warehouseAsset);
        if(!result){
        	String message = "WarehouseAsset("+warehouseAsset.getId()+") with version='"+warehouseAsset.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveWarehouseAssetList", warehouseAsset);
		//the constant "toWarehouseAsset" will be replaced after refactoried.
	
	}
	
	public void copyWarehouseAssetFrom(WarehouseAsset warehouseAsset) {
		// TODO Auto-generated method stub
		
        WarehouseAsset warehouseAssetInList = findTheWarehouseAsset(warehouseAsset);
        WarehouseAsset newWarehouseAsset = new WarehouseAsset();
        warehouseAssetInList.copyTo(newWarehouseAsset);
        newWarehouseAsset.setVersion(0);//will trigger copy
        getWarehouseAssetList().add(newWarehouseAsset);
	}
	
	public  WarehouseAsset findTheWarehouseAsset(WarehouseAsset warehouseAsset){
		
		int index =  getWarehouseAssetList().indexOf(warehouseAsset);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "WarehouseAsset("+warehouseAsset.getId()+") with version='"+warehouseAsset.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getWarehouseAssetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpWarehouseAssetList(){
		getWarehouseAssetList().clear();
	}
	
	
	
	
 	
	
	public Warehouse copyTo(Warehouse dest){

		dest.setId(getId());
		dest.setLocation(getLocation());
		dest.setContactNumber(getContactNumber());
		dest.setTotalArea(getTotalArea());
		dest.setOwner(getOwner());
		dest.setLatitude(getLatitude());
		dest.setLongitude(getLongitude());
		dest.setVersion(getVersion());
		dest.setStorageSpaceList(getStorageSpaceList());
		dest.setSmartPalletList(getSmartPalletList());
		dest.setSupplierSpaceList(getSupplierSpaceList());
		dest.setReceivingSpaceList(getReceivingSpaceList());
		dest.setShippingSpaceList(getShippingSpaceList());
		dest.setDamageSpaceList(getDamageSpaceList());
		dest.setWarehouseAssetList(getWarehouseAssetList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("warehouse{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tcontact_number='"+getContactNumber()+"';");
		stringBuilder.append("\ttotal_area='"+getTotalArea()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_country_center("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

