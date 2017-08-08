
package com.skynet.retailscm.warehouse;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.warehouseasset.WarehouseAsset;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.supplierspace.SupplierSpace;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.warehouse.Warehouse;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.damagespace.DamageSpaceTable;
import com.skynet.retailscm.storagespace.StorageSpaceTable;
import com.skynet.retailscm.shippingspace.ShippingSpaceTable;
import com.skynet.retailscm.smartpallet.SmartPalletTable;
import com.skynet.retailscm.warehouseasset.WarehouseAssetTable;
import com.skynet.retailscm.supplierspace.SupplierSpaceTable;
import com.skynet.retailscm.receivingspace.ReceivingSpaceTable;




public class WarehouseManagerImpl extends RetailScmCheckerManager implements WarehouseManager {
	
	private static final String SERVICE_TYPE = "Warehouse";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO  warehouseDAO){
 	
 		if(warehouseDAO == null){
 			throw new IllegalStateException("Do not try to set warehouseDAO to null.");
 		}
	 	this.warehouseDAO = warehouseDAO;
 	}
 	public WarehouseDAO getWarehouseDAO(){
 		if(this.warehouseDAO == null){
 			throw new IllegalStateException("The WarehouseDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.warehouseDAO;
 	}
 	
 	protected Warehouse saveWarehouse(RetailScmUserContext userContext, Warehouse warehouse, String [] tokensExpr) throws Exception{	
 		//return getWarehouseDAO().save(warehouse, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWarehouse(userContext, warehouse, tokens);
 	}
 	
 	protected Warehouse saveWarehouseDetail(RetailScmUserContext userContext, Warehouse warehouse) throws Exception{	

 		
 		return saveWarehouse(userContext, warehouse, allTokens());
 	}
 	
 	public Warehouse loadWarehouse(RetailScmUserContext userContext, String warehouseId, String [] tokensExpr) throws Exception{				
 
 		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Warehouse warehouse = loadWarehouse( userContext, warehouseId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,warehouse, tokens);
 	}
 	
 	protected Warehouse present(RetailScmUserContext userContext, Warehouse warehouse, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,warehouse,tokens);
		
		
		return this.getWarehouseDAO().present(warehouse, tokens);
	}
 
 	
 	
 	public Warehouse loadWarehouseDetail(RetailScmUserContext userContext, String warehouseId) throws Exception{	
 		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Warehouse warehouse = loadWarehouse( userContext, warehouseId, allTokens());

 		return present(userContext,warehouse, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String warehouseId) throws Exception{	
 		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Warehouse warehouse = loadWarehouse( userContext, warehouseId, allTokens());

 		return present(userContext,warehouse, allTokens());
		
 	}
 	protected Warehouse saveWarehouse(RetailScmUserContext userContext, Warehouse warehouse, Map<String,Object>tokens) throws Exception{	
 		return getWarehouseDAO().save(warehouse, tokens);
 	}
 	protected Warehouse loadWarehouse(RetailScmUserContext userContext, String warehouseId, Map<String,Object>tokens) throws Exception{	
 		return getWarehouseDAO().load(warehouseId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Warehouse warehouse, Map<String, Object> tokens){
		super.addActions(userContext, warehouse, tokens);
		
		addAction(userContext, warehouse, tokens,"@create","createWarehouse","createWarehouse/","main","primary");
		addAction(userContext, warehouse, tokens,"@update","updateWarehouse","updateWarehouse/"+warehouse.getId()+"/","main","primary");
		addAction(userContext, warehouse, tokens,"@copy","cloneWarehouse","cloneWarehouse/"+warehouse.getId()+"/","main","primary");
		
		addAction(userContext, warehouse, tokens,"warehouse.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+warehouse.getId()+"/","main","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addStorageSpace","addStorageSpace","addStorageSpace/"+warehouse.getId()+"/","storageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeStorageSpace","removeStorageSpace","removeStorageSpace/"+warehouse.getId()+"/","storageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateStorageSpace","updateStorageSpace","updateStorageSpace/"+warehouse.getId()+"/","storageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyStorageSpaceFrom","copyStorageSpaceFrom","copyStorageSpaceFrom/"+warehouse.getId()+"/","storageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addSmartPallet","addSmartPallet","addSmartPallet/"+warehouse.getId()+"/","smartPalletList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeSmartPallet","removeSmartPallet","removeSmartPallet/"+warehouse.getId()+"/","smartPalletList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateSmartPallet","updateSmartPallet","updateSmartPallet/"+warehouse.getId()+"/","smartPalletList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copySmartPalletFrom","copySmartPalletFrom","copySmartPalletFrom/"+warehouse.getId()+"/","smartPalletList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addSupplierSpace","addSupplierSpace","addSupplierSpace/"+warehouse.getId()+"/","supplierSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeSupplierSpace","removeSupplierSpace","removeSupplierSpace/"+warehouse.getId()+"/","supplierSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateSupplierSpace","updateSupplierSpace","updateSupplierSpace/"+warehouse.getId()+"/","supplierSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copySupplierSpaceFrom","copySupplierSpaceFrom","copySupplierSpaceFrom/"+warehouse.getId()+"/","supplierSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addReceivingSpace","addReceivingSpace","addReceivingSpace/"+warehouse.getId()+"/","receivingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeReceivingSpace","removeReceivingSpace","removeReceivingSpace/"+warehouse.getId()+"/","receivingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateReceivingSpace","updateReceivingSpace","updateReceivingSpace/"+warehouse.getId()+"/","receivingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyReceivingSpaceFrom","copyReceivingSpaceFrom","copyReceivingSpaceFrom/"+warehouse.getId()+"/","receivingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addShippingSpace","addShippingSpace","addShippingSpace/"+warehouse.getId()+"/","shippingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeShippingSpace","removeShippingSpace","removeShippingSpace/"+warehouse.getId()+"/","shippingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateShippingSpace","updateShippingSpace","updateShippingSpace/"+warehouse.getId()+"/","shippingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyShippingSpaceFrom","copyShippingSpaceFrom","copyShippingSpaceFrom/"+warehouse.getId()+"/","shippingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addDamageSpace","addDamageSpace","addDamageSpace/"+warehouse.getId()+"/","damageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeDamageSpace","removeDamageSpace","removeDamageSpace/"+warehouse.getId()+"/","damageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateDamageSpace","updateDamageSpace","updateDamageSpace/"+warehouse.getId()+"/","damageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyDamageSpaceFrom","copyDamageSpaceFrom","copyDamageSpaceFrom/"+warehouse.getId()+"/","damageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addWarehouseAsset","addWarehouseAsset","addWarehouseAsset/"+warehouse.getId()+"/","warehouseAssetList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeWarehouseAsset","removeWarehouseAsset","removeWarehouseAsset/"+warehouse.getId()+"/","warehouseAssetList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateWarehouseAsset","updateWarehouseAsset","updateWarehouseAsset/"+warehouse.getId()+"/","warehouseAssetList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyWarehouseAssetFrom","copyWarehouseAssetFrom","copyWarehouseAssetFrom/"+warehouse.getId()+"/","warehouseAssetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Warehouse warehouse, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Warehouse createWarehouse(RetailScmUserContext userContext,String location, String contactNumber, String totalArea, String ownerId, double latitude, double longitude
) throws Exception
	{
		
		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");

		

		checkLocationOfWarehouse(userContext,  location, exception);
		checkContactNumberOfWarehouse(userContext,  contactNumber, exception);
		checkTotalAreaOfWarehouse(userContext,  totalArea, exception);
		checkLatitudeOfWarehouse(userContext,  latitude, exception);
		checkLongitudeOfWarehouse(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Warehouse warehouse=createNewWarehouse();	

		warehouse.setLocation(location);
		warehouse.setContactNumber(contactNumber);
		warehouse.setTotalArea(totalArea);
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(ownerId,emptyOptions());
		warehouse.setOwner(owner);
		warehouse.setLatitude(latitude);
		warehouse.setLongitude(longitude);

		return saveWarehouse(userContext, warehouse, emptyOptions());
		

		
	}
	protected Warehouse createNewWarehouse() 
	{
		
		return new Warehouse();		
	}
	
	protected void checkParamsForUpdatingWarehouse(RetailScmUserContext userContext,String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkVersionOfWarehouse(userContext, warehouseVersion, exception);
		

		if(Warehouse.LOCATION_PROPERTY.equals(property)){
			checkLocationOfWarehouse(userContext, parseString(newValueExpr), exception);
		}
		if(Warehouse.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfWarehouse(userContext, parseString(newValueExpr), exception);
		}
		if(Warehouse.TOTAL_AREA_PROPERTY.equals(property)){
			checkTotalAreaOfWarehouse(userContext, parseString(newValueExpr), exception);
		}		

		
		if(Warehouse.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfWarehouse(userContext, parseDouble(newValueExpr), exception);
		}
		if(Warehouse.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfWarehouse(userContext, parseDouble(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public Warehouse clone(RetailScmUserContext userContext, String fromWarehouseId) throws Exception{
		
		return this.getWarehouseDAO().clone(fromWarehouseId, this.allTokens());
	}
	
	public Warehouse updateWarehouse(RetailScmUserContext userContext,String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWarehouse(userContext, warehouseId, warehouseVersion, property, newValueExpr, tokensExpr);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		if(warehouse.getVersion() != warehouseVersion){
			String message = "The target version("+warehouse.getVersion()+") is not equals to version("+warehouseVersion+") provided";
			throw new WarehouseManagerException(message);
		}
		synchronized(warehouse){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Warehouse.
			
			warehouse.changePropery(property, newValueExpr);
			warehouse = saveWarehouse(userContext, warehouse, tokens().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			//return saveWarehouse(userContext, warehouse, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected WarehouseTokens tokens(){
		return WarehouseTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WarehouseTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WarehouseTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={};
 	protected String getNextStatus(RetailScmUserContext userContext, String currentStatus){
 	
 		if(currentStatus == null){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE[0];
 		}
 	
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throw new IllegalArgumentException("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		//this is not the last one, just return it.
 		
 		return STATUS_SEQUENCE[index+1];
 	
 	}/**/
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String warehouseId, String anotherOwnerId) throws Exception
 	{
 		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
 		checkIdOfWarehouse(userContext, warehouseId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Warehouse transferToAnotherOwner(RetailScmUserContext userContext, String warehouseId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, warehouseId,anotherOwnerId);
 
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());	
		synchronized(warehouse){
			//will be good when the warehouse loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(anotherOwnerId, emptyOptions());		
			warehouse.setOwner(owner);		
			warehouse = saveWarehouse(userContext, warehouse, emptyOptions());
			
			return present(userContext,warehouse, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String warehouseId, int warehouseVersion) throws Exception {
		
		deleteInternal(userContext, warehouseId, warehouseVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String warehouseId, int warehouseVersion) throws Exception{
		getWarehouseDAO().delete(warehouseId, warehouseVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WarehouseManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getWarehouseDAO().deleteAll();
	}

	protected void checkParamsForAddingStorageSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);

		checkLocationOfStorageSpace(userContext,  location, exception);
		checkContactNumberOfStorageSpace(userContext,  contactNumber, exception);
		checkTotalAreaOfStorageSpace(userContext,  totalArea, exception);
		checkLatitudeOfStorageSpace(userContext,  latitude, exception);
		checkLongitudeOfStorageSpace(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Warehouse addStorageSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingStorageSpace(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);
		
		StorageSpace storageSpace = createStorageSpace(userContext,location, contactNumber, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addStorageSpace( storageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withStorageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected StorageSpace createStorageSpace(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, double latitude, double longitude) throws Exception{

		StorageSpace storageSpace = new StorageSpace();
		
		
		storageSpace.setLocation(location);		
		storageSpace.setContactNumber(contactNumber);		
		storageSpace.setTotalArea(totalArea);		
		storageSpace.setLatitude(latitude);		
		storageSpace.setLongitude(longitude);
	
		
		return storageSpace;
	
		
	}
	
	protected StorageSpace createIndexedStorageSpace(String id, int version){

		StorageSpace storageSpace = new StorageSpace();
		storageSpace.setId(id);
		storageSpace.setVersion(version);
		return storageSpace;			
		
	}
	protected void checkParamsForRemovingStorageSpace(RetailScmUserContext userContext, String warehouseId, 
		String storageSpaceId, int storageSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);
		checkVersionOfStorageSpace(userContext, storageSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse removeStorageSpace(RetailScmUserContext userContext, String warehouseId, 
		String storageSpaceId, int storageSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingStorageSpace(userContext,warehouseId, storageSpaceId, storageSpaceVersion,tokensExpr);
		
		StorageSpace storageSpace = createIndexedStorageSpace(storageSpaceId, storageSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeStorageSpace( storageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withStorageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingStorageSpace(RetailScmUserContext userContext, String warehouseId, 
		String storageSpaceId, int storageSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);
		checkVersionOfStorageSpace(userContext, storageSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse copyStorageSpaceFrom(RetailScmUserContext userContext, String warehouseId, 
		String storageSpaceId, int storageSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingStorageSpace(userContext,warehouseId, storageSpaceId, storageSpaceVersion,tokensExpr);
		
		StorageSpace storageSpace = createIndexedStorageSpace(storageSpaceId, storageSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.copyStorageSpaceFrom( storageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withStorageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingStorageSpace(RetailScmUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);
		checkVersionOfStorageSpace(userContext, storageSpaceVersion, exception);
		

		if(StorageSpace.LOCATION_PROPERTY.equals(property)){
			checkLocationOfStorageSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(StorageSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfStorageSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(StorageSpace.TOTAL_AREA_PROPERTY.equals(property)){
			checkTotalAreaOfStorageSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(StorageSpace.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfStorageSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(StorageSpace.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfStorageSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Warehouse updateStorageSpace(RetailScmUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingStorageSpace(userContext, warehouseId, storageSpaceId, storageSpaceVersion, property, newValueExpr,  tokensExpr);
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeStorageSpace( storageSpace );	
			//make changes to AcceleraterAccount.
			StorageSpace storageSpaceIndex = createIndexedStorageSpace(storageSpaceId, storageSpaceVersion);
		
			StorageSpace storageSpace = warehouse.findTheStorageSpace(storageSpaceIndex);
			if(storageSpace == null){
				throw new WarehouseManagerException(storageSpace+"Not found" );
			}
			
			storageSpace.changePropery(property, newValueExpr);

			warehouse = saveWarehouse(userContext, warehouse, tokens().withStorageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSmartPallet(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);

		checkLocationOfSmartPallet(userContext,  location, exception);
		checkContactNumberOfSmartPallet(userContext,  contactNumber, exception);
		checkTotalAreaOfSmartPallet(userContext,  totalArea, exception);
		checkLatitudeOfSmartPallet(userContext,  latitude, exception);
		checkLongitudeOfSmartPallet(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Warehouse addSmartPallet(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSmartPallet(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);
		
		SmartPallet smartPallet = createSmartPallet(userContext,location, contactNumber, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addSmartPallet( smartPallet );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSmartPalletList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected SmartPallet createSmartPallet(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, double latitude, double longitude) throws Exception{

		SmartPallet smartPallet = new SmartPallet();
		
		
		smartPallet.setLocation(location);		
		smartPallet.setContactNumber(contactNumber);		
		smartPallet.setTotalArea(totalArea);		
		smartPallet.setLatitude(latitude);		
		smartPallet.setLongitude(longitude);
	
		
		return smartPallet;
	
		
	}
	
	protected SmartPallet createIndexedSmartPallet(String id, int version){

		SmartPallet smartPallet = new SmartPallet();
		smartPallet.setId(id);
		smartPallet.setVersion(version);
		return smartPallet;			
		
	}
	protected void checkParamsForRemovingSmartPallet(RetailScmUserContext userContext, String warehouseId, 
		String smartPalletId, int smartPalletVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfSmartPallet(userContext, smartPalletId, exception);
		checkVersionOfSmartPallet(userContext, smartPalletVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse removeSmartPallet(RetailScmUserContext userContext, String warehouseId, 
		String smartPalletId, int smartPalletVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSmartPallet(userContext,warehouseId, smartPalletId, smartPalletVersion,tokensExpr);
		
		SmartPallet smartPallet = createIndexedSmartPallet(smartPalletId, smartPalletVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeSmartPallet( smartPallet );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSmartPalletList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSmartPallet(RetailScmUserContext userContext, String warehouseId, 
		String smartPalletId, int smartPalletVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfSmartPallet(userContext, smartPalletId, exception);
		checkVersionOfSmartPallet(userContext, smartPalletVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse copySmartPalletFrom(RetailScmUserContext userContext, String warehouseId, 
		String smartPalletId, int smartPalletVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSmartPallet(userContext,warehouseId, smartPalletId, smartPalletVersion,tokensExpr);
		
		SmartPallet smartPallet = createIndexedSmartPallet(smartPalletId, smartPalletVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.copySmartPalletFrom( smartPallet );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSmartPalletList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSmartPallet(RetailScmUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfSmartPallet(userContext, smartPalletId, exception);
		checkVersionOfSmartPallet(userContext, smartPalletVersion, exception);
		

		if(SmartPallet.LOCATION_PROPERTY.equals(property)){
			checkLocationOfSmartPallet(userContext, parseString(newValueExpr), exception);
		}
		
		if(SmartPallet.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfSmartPallet(userContext, parseString(newValueExpr), exception);
		}
		
		if(SmartPallet.TOTAL_AREA_PROPERTY.equals(property)){
			checkTotalAreaOfSmartPallet(userContext, parseString(newValueExpr), exception);
		}
		
		if(SmartPallet.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfSmartPallet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(SmartPallet.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfSmartPallet(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Warehouse updateSmartPallet(RetailScmUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSmartPallet(userContext, warehouseId, smartPalletId, smartPalletVersion, property, newValueExpr,  tokensExpr);
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeSmartPallet( smartPallet );	
			//make changes to AcceleraterAccount.
			SmartPallet smartPalletIndex = createIndexedSmartPallet(smartPalletId, smartPalletVersion);
		
			SmartPallet smartPallet = warehouse.findTheSmartPallet(smartPalletIndex);
			if(smartPallet == null){
				throw new WarehouseManagerException(smartPallet+"Not found" );
			}
			
			smartPallet.changePropery(property, newValueExpr);

			warehouse = saveWarehouse(userContext, warehouse, tokens().withSmartPalletList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplierSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);

		checkLocationOfSupplierSpace(userContext,  location, exception);
		checkContactNumberOfSupplierSpace(userContext,  contactNumber, exception);
		checkTotalAreaOfSupplierSpace(userContext,  totalArea, exception);
		checkLatitudeOfSupplierSpace(userContext,  latitude, exception);
		checkLongitudeOfSupplierSpace(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Warehouse addSupplierSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplierSpace(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);
		
		SupplierSpace supplierSpace = createSupplierSpace(userContext,location, contactNumber, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addSupplierSpace( supplierSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSupplierSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected SupplierSpace createSupplierSpace(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, double latitude, double longitude) throws Exception{

		SupplierSpace supplierSpace = new SupplierSpace();
		
		
		supplierSpace.setLocation(location);		
		supplierSpace.setContactNumber(contactNumber);		
		supplierSpace.setTotalArea(totalArea);		
		supplierSpace.setLatitude(latitude);		
		supplierSpace.setLongitude(longitude);
	
		
		return supplierSpace;
	
		
	}
	
	protected SupplierSpace createIndexedSupplierSpace(String id, int version){

		SupplierSpace supplierSpace = new SupplierSpace();
		supplierSpace.setId(id);
		supplierSpace.setVersion(version);
		return supplierSpace;			
		
	}
	protected void checkParamsForRemovingSupplierSpace(RetailScmUserContext userContext, String warehouseId, 
		String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);
		checkVersionOfSupplierSpace(userContext, supplierSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse removeSupplierSpace(RetailScmUserContext userContext, String warehouseId, 
		String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplierSpace(userContext,warehouseId, supplierSpaceId, supplierSpaceVersion,tokensExpr);
		
		SupplierSpace supplierSpace = createIndexedSupplierSpace(supplierSpaceId, supplierSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeSupplierSpace( supplierSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSupplierSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplierSpace(RetailScmUserContext userContext, String warehouseId, 
		String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);
		checkVersionOfSupplierSpace(userContext, supplierSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse copySupplierSpaceFrom(RetailScmUserContext userContext, String warehouseId, 
		String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplierSpace(userContext,warehouseId, supplierSpaceId, supplierSpaceVersion,tokensExpr);
		
		SupplierSpace supplierSpace = createIndexedSupplierSpace(supplierSpaceId, supplierSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.copySupplierSpaceFrom( supplierSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSupplierSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplierSpace(RetailScmUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);
		checkVersionOfSupplierSpace(userContext, supplierSpaceVersion, exception);
		

		if(SupplierSpace.LOCATION_PROPERTY.equals(property)){
			checkLocationOfSupplierSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplierSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfSupplierSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplierSpace.TOTAL_AREA_PROPERTY.equals(property)){
			checkTotalAreaOfSupplierSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplierSpace.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfSupplierSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(SupplierSpace.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfSupplierSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Warehouse updateSupplierSpace(RetailScmUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplierSpace(userContext, warehouseId, supplierSpaceId, supplierSpaceVersion, property, newValueExpr,  tokensExpr);
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeSupplierSpace( supplierSpace );	
			//make changes to AcceleraterAccount.
			SupplierSpace supplierSpaceIndex = createIndexedSupplierSpace(supplierSpaceId, supplierSpaceVersion);
		
			SupplierSpace supplierSpace = warehouse.findTheSupplierSpace(supplierSpaceIndex);
			if(supplierSpace == null){
				throw new WarehouseManagerException(supplierSpace+"Not found" );
			}
			
			supplierSpace.changePropery(property, newValueExpr);

			warehouse = saveWarehouse(userContext, warehouse, tokens().withSupplierSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingReceivingSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String description, String totalArea, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);

		checkLocationOfReceivingSpace(userContext,  location, exception);
		checkContactNumberOfReceivingSpace(userContext,  contactNumber, exception);
		checkDescriptionOfReceivingSpace(userContext,  description, exception);
		checkTotalAreaOfReceivingSpace(userContext,  totalArea, exception);
		checkLatitudeOfReceivingSpace(userContext,  latitude, exception);
		checkLongitudeOfReceivingSpace(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Warehouse addReceivingSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String description, String totalArea, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingReceivingSpace(userContext,warehouseId,location, contactNumber, description, totalArea, latitude, longitude,tokensExpr);
		
		ReceivingSpace receivingSpace = createReceivingSpace(userContext,location, contactNumber, description, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addReceivingSpace( receivingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withReceivingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected ReceivingSpace createReceivingSpace(RetailScmUserContext userContext, String location, String contactNumber, String description, String totalArea, double latitude, double longitude) throws Exception{

		ReceivingSpace receivingSpace = new ReceivingSpace();
		
		
		receivingSpace.setLocation(location);		
		receivingSpace.setContactNumber(contactNumber);		
		receivingSpace.setDescription(description);		
		receivingSpace.setTotalArea(totalArea);		
		receivingSpace.setLatitude(latitude);		
		receivingSpace.setLongitude(longitude);
	
		
		return receivingSpace;
	
		
	}
	
	protected ReceivingSpace createIndexedReceivingSpace(String id, int version){

		ReceivingSpace receivingSpace = new ReceivingSpace();
		receivingSpace.setId(id);
		receivingSpace.setVersion(version);
		return receivingSpace;			
		
	}
	protected void checkParamsForRemovingReceivingSpace(RetailScmUserContext userContext, String warehouseId, 
		String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);
		checkVersionOfReceivingSpace(userContext, receivingSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse removeReceivingSpace(RetailScmUserContext userContext, String warehouseId, 
		String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingReceivingSpace(userContext,warehouseId, receivingSpaceId, receivingSpaceVersion,tokensExpr);
		
		ReceivingSpace receivingSpace = createIndexedReceivingSpace(receivingSpaceId, receivingSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeReceivingSpace( receivingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withReceivingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingReceivingSpace(RetailScmUserContext userContext, String warehouseId, 
		String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);
		checkVersionOfReceivingSpace(userContext, receivingSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse copyReceivingSpaceFrom(RetailScmUserContext userContext, String warehouseId, 
		String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingReceivingSpace(userContext,warehouseId, receivingSpaceId, receivingSpaceVersion,tokensExpr);
		
		ReceivingSpace receivingSpace = createIndexedReceivingSpace(receivingSpaceId, receivingSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.copyReceivingSpaceFrom( receivingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withReceivingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingReceivingSpace(RetailScmUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);
		checkVersionOfReceivingSpace(userContext, receivingSpaceVersion, exception);
		

		if(ReceivingSpace.LOCATION_PROPERTY.equals(property)){
			checkLocationOfReceivingSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(ReceivingSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfReceivingSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(ReceivingSpace.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfReceivingSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(ReceivingSpace.TOTAL_AREA_PROPERTY.equals(property)){
			checkTotalAreaOfReceivingSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(ReceivingSpace.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfReceivingSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(ReceivingSpace.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfReceivingSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Warehouse updateReceivingSpace(RetailScmUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingReceivingSpace(userContext, warehouseId, receivingSpaceId, receivingSpaceVersion, property, newValueExpr,  tokensExpr);
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeReceivingSpace( receivingSpace );	
			//make changes to AcceleraterAccount.
			ReceivingSpace receivingSpaceIndex = createIndexedReceivingSpace(receivingSpaceId, receivingSpaceVersion);
		
			ReceivingSpace receivingSpace = warehouse.findTheReceivingSpace(receivingSpaceIndex);
			if(receivingSpace == null){
				throw new WarehouseManagerException(receivingSpace+"Not found" );
			}
			
			receivingSpace.changePropery(property, newValueExpr);

			warehouse = saveWarehouse(userContext, warehouse, tokens().withReceivingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingShippingSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude, String description,String [] tokensExpr) throws Exception{
		
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);

		checkLocationOfShippingSpace(userContext,  location, exception);
		checkContactNumberOfShippingSpace(userContext,  contactNumber, exception);
		checkTotalAreaOfShippingSpace(userContext,  totalArea, exception);
		checkLatitudeOfShippingSpace(userContext,  latitude, exception);
		checkLongitudeOfShippingSpace(userContext,  longitude, exception);
		checkDescriptionOfShippingSpace(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Warehouse addShippingSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingShippingSpace(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude, description,tokensExpr);
		
		ShippingSpace shippingSpace = createShippingSpace(userContext,location, contactNumber, totalArea, latitude, longitude, description);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addShippingSpace( shippingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withShippingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected ShippingSpace createShippingSpace(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, double latitude, double longitude, String description) throws Exception{

		ShippingSpace shippingSpace = new ShippingSpace();
		
		
		shippingSpace.setLocation(location);		
		shippingSpace.setContactNumber(contactNumber);		
		shippingSpace.setTotalArea(totalArea);		
		shippingSpace.setLatitude(latitude);		
		shippingSpace.setLongitude(longitude);		
		shippingSpace.setDescription(description);
	
		
		return shippingSpace;
	
		
	}
	
	protected ShippingSpace createIndexedShippingSpace(String id, int version){

		ShippingSpace shippingSpace = new ShippingSpace();
		shippingSpace.setId(id);
		shippingSpace.setVersion(version);
		return shippingSpace;			
		
	}
	protected void checkParamsForRemovingShippingSpace(RetailScmUserContext userContext, String warehouseId, 
		String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);
		checkVersionOfShippingSpace(userContext, shippingSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse removeShippingSpace(RetailScmUserContext userContext, String warehouseId, 
		String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingShippingSpace(userContext,warehouseId, shippingSpaceId, shippingSpaceVersion,tokensExpr);
		
		ShippingSpace shippingSpace = createIndexedShippingSpace(shippingSpaceId, shippingSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeShippingSpace( shippingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withShippingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingShippingSpace(RetailScmUserContext userContext, String warehouseId, 
		String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);
		checkVersionOfShippingSpace(userContext, shippingSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse copyShippingSpaceFrom(RetailScmUserContext userContext, String warehouseId, 
		String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingShippingSpace(userContext,warehouseId, shippingSpaceId, shippingSpaceVersion,tokensExpr);
		
		ShippingSpace shippingSpace = createIndexedShippingSpace(shippingSpaceId, shippingSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.copyShippingSpaceFrom( shippingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withShippingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingShippingSpace(RetailScmUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);
		checkVersionOfShippingSpace(userContext, shippingSpaceVersion, exception);
		

		if(ShippingSpace.LOCATION_PROPERTY.equals(property)){
			checkLocationOfShippingSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(ShippingSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfShippingSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(ShippingSpace.TOTAL_AREA_PROPERTY.equals(property)){
			checkTotalAreaOfShippingSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(ShippingSpace.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfShippingSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(ShippingSpace.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfShippingSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(ShippingSpace.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfShippingSpace(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Warehouse updateShippingSpace(RetailScmUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingShippingSpace(userContext, warehouseId, shippingSpaceId, shippingSpaceVersion, property, newValueExpr,  tokensExpr);
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeShippingSpace( shippingSpace );	
			//make changes to AcceleraterAccount.
			ShippingSpace shippingSpaceIndex = createIndexedShippingSpace(shippingSpaceId, shippingSpaceVersion);
		
			ShippingSpace shippingSpace = warehouse.findTheShippingSpace(shippingSpaceIndex);
			if(shippingSpace == null){
				throw new WarehouseManagerException(shippingSpace+"Not found" );
			}
			
			shippingSpace.changePropery(property, newValueExpr);

			warehouse = saveWarehouse(userContext, warehouse, tokens().withShippingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingDamageSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);

		checkLocationOfDamageSpace(userContext,  location, exception);
		checkContactNumberOfDamageSpace(userContext,  contactNumber, exception);
		checkTotalAreaOfDamageSpace(userContext,  totalArea, exception);
		checkLatitudeOfDamageSpace(userContext,  latitude, exception);
		checkLongitudeOfDamageSpace(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Warehouse addDamageSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDamageSpace(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);
		
		DamageSpace damageSpace = createDamageSpace(userContext,location, contactNumber, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addDamageSpace( damageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withDamageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected DamageSpace createDamageSpace(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, double latitude, double longitude) throws Exception{

		DamageSpace damageSpace = new DamageSpace();
		
		
		damageSpace.setLocation(location);		
		damageSpace.setContactNumber(contactNumber);		
		damageSpace.setTotalArea(totalArea);		
		damageSpace.setLatitude(latitude);		
		damageSpace.setLongitude(longitude);
	
		
		return damageSpace;
	
		
	}
	
	protected DamageSpace createIndexedDamageSpace(String id, int version){

		DamageSpace damageSpace = new DamageSpace();
		damageSpace.setId(id);
		damageSpace.setVersion(version);
		return damageSpace;			
		
	}
	protected void checkParamsForRemovingDamageSpace(RetailScmUserContext userContext, String warehouseId, 
		String damageSpaceId, int damageSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);
		checkVersionOfDamageSpace(userContext, damageSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse removeDamageSpace(RetailScmUserContext userContext, String warehouseId, 
		String damageSpaceId, int damageSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDamageSpace(userContext,warehouseId, damageSpaceId, damageSpaceVersion,tokensExpr);
		
		DamageSpace damageSpace = createIndexedDamageSpace(damageSpaceId, damageSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeDamageSpace( damageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withDamageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingDamageSpace(RetailScmUserContext userContext, String warehouseId, 
		String damageSpaceId, int damageSpaceVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);
		checkVersionOfDamageSpace(userContext, damageSpaceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse copyDamageSpaceFrom(RetailScmUserContext userContext, String warehouseId, 
		String damageSpaceId, int damageSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDamageSpace(userContext,warehouseId, damageSpaceId, damageSpaceVersion,tokensExpr);
		
		DamageSpace damageSpace = createIndexedDamageSpace(damageSpaceId, damageSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.copyDamageSpaceFrom( damageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withDamageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingDamageSpace(RetailScmUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);
		checkVersionOfDamageSpace(userContext, damageSpaceVersion, exception);
		

		if(DamageSpace.LOCATION_PROPERTY.equals(property)){
			checkLocationOfDamageSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(DamageSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfDamageSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(DamageSpace.TOTAL_AREA_PROPERTY.equals(property)){
			checkTotalAreaOfDamageSpace(userContext, parseString(newValueExpr), exception);
		}
		
		if(DamageSpace.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfDamageSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(DamageSpace.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfDamageSpace(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Warehouse updateDamageSpace(RetailScmUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDamageSpace(userContext, warehouseId, damageSpaceId, damageSpaceVersion, property, newValueExpr,  tokensExpr);
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeDamageSpace( damageSpace );	
			//make changes to AcceleraterAccount.
			DamageSpace damageSpaceIndex = createIndexedDamageSpace(damageSpaceId, damageSpaceVersion);
		
			DamageSpace damageSpace = warehouse.findTheDamageSpace(damageSpaceIndex);
			if(damageSpace == null){
				throw new WarehouseManagerException(damageSpace+"Not found" );
			}
			
			damageSpace.changePropery(property, newValueExpr);

			warehouse = saveWarehouse(userContext, warehouse, tokens().withDamageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingWarehouseAsset(RetailScmUserContext userContext, String warehouseId, String name, String position,String [] tokensExpr) throws Exception{
		
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);

		checkNameOfWarehouseAsset(userContext,  name, exception);
		checkPositionOfWarehouseAsset(userContext,  position, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Warehouse addWarehouseAsset(RetailScmUserContext userContext, String warehouseId, String name, String position, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingWarehouseAsset(userContext,warehouseId,name, position,tokensExpr);
		
		WarehouseAsset warehouseAsset = createWarehouseAsset(userContext,name, position);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addWarehouseAsset( warehouseAsset );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withWarehouseAssetList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected WarehouseAsset createWarehouseAsset(RetailScmUserContext userContext, String name, String position) throws Exception{

		WarehouseAsset warehouseAsset = new WarehouseAsset();
		
		
		warehouseAsset.setName(name);		
		warehouseAsset.setPosition(position);
	
		
		return warehouseAsset;
	
		
	}
	
	protected WarehouseAsset createIndexedWarehouseAsset(String id, int version){

		WarehouseAsset warehouseAsset = new WarehouseAsset();
		warehouseAsset.setId(id);
		warehouseAsset.setVersion(version);
		return warehouseAsset;			
		
	}
	protected void checkParamsForRemovingWarehouseAsset(RetailScmUserContext userContext, String warehouseId, 
		String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfWarehouseAsset(userContext, warehouseAssetId, exception);
		checkVersionOfWarehouseAsset(userContext, warehouseAssetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse removeWarehouseAsset(RetailScmUserContext userContext, String warehouseId, 
		String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingWarehouseAsset(userContext,warehouseId, warehouseAssetId, warehouseAssetVersion,tokensExpr);
		
		WarehouseAsset warehouseAsset = createIndexedWarehouseAsset(warehouseAssetId, warehouseAssetVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeWarehouseAsset( warehouseAsset );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withWarehouseAssetList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingWarehouseAsset(RetailScmUserContext userContext, String warehouseId, 
		String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfWarehouseAsset(userContext, warehouseAssetId, exception);
		checkVersionOfWarehouseAsset(userContext, warehouseAssetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Warehouse copyWarehouseAssetFrom(RetailScmUserContext userContext, String warehouseId, 
		String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingWarehouseAsset(userContext,warehouseId, warehouseAssetId, warehouseAssetVersion,tokensExpr);
		
		WarehouseAsset warehouseAsset = createIndexedWarehouseAsset(warehouseAssetId, warehouseAssetVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.copyWarehouseAssetFrom( warehouseAsset );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withWarehouseAssetList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingWarehouseAsset(RetailScmUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		WarehouseManagerException exception = new WarehouseManagerException("Error Occured");
		
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkIdOfWarehouseAsset(userContext, warehouseAssetId, exception);
		checkVersionOfWarehouseAsset(userContext, warehouseAssetVersion, exception);
		

		if(WarehouseAsset.NAME_PROPERTY.equals(property)){
			checkNameOfWarehouseAsset(userContext, parseString(newValueExpr), exception);
		}
		
		if(WarehouseAsset.POSITION_PROPERTY.equals(property)){
			checkPositionOfWarehouseAsset(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Warehouse updateWarehouseAsset(RetailScmUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingWarehouseAsset(userContext, warehouseId, warehouseAssetId, warehouseAssetVersion, property, newValueExpr,  tokensExpr);
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeWarehouseAsset( warehouseAsset );	
			//make changes to AcceleraterAccount.
			WarehouseAsset warehouseAssetIndex = createIndexedWarehouseAsset(warehouseAssetId, warehouseAssetVersion);
		
			WarehouseAsset warehouseAsset = warehouse.findTheWarehouseAsset(warehouseAssetIndex);
			if(warehouseAsset == null){
				throw new WarehouseManagerException(warehouseAsset+"Not found" );
			}
			
			warehouseAsset.changePropery(property, newValueExpr);

			warehouse = saveWarehouse(userContext, warehouse, tokens().withWarehouseAssetList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


