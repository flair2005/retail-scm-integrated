
package com.skynet.retailscm.storagespace;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.goodsshelf.GoodsShelf;

import com.skynet.retailscm.warehouse.WarehouseDAO;

import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.supplierspace.SupplierSpace;


import com.skynet.retailscm.goodsshelf.GoodsShelfTable;
import com.skynet.retailscm.warehouse.WarehouseTable;




public class StorageSpaceManagerImpl extends RetailScmCheckerManager implements StorageSpaceManager {
	
	private static final String SERVICE_TYPE = "StorageSpace";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  StorageSpaceDAO  storageSpaceDAO;
 	public void setStorageSpaceDAO(StorageSpaceDAO  storageSpaceDAO){
 	
 		if(storageSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set storageSpaceDAO to null.");
 		}
	 	this.storageSpaceDAO = storageSpaceDAO;
 	}
 	public StorageSpaceDAO getStorageSpaceDAO(){
 		if(this.storageSpaceDAO == null){
 			throw new IllegalStateException("The StorageSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.storageSpaceDAO;
 	}
 	
 	protected StorageSpace saveStorageSpace(RetailScmUserContext userContext, StorageSpace storageSpace, String [] tokensExpr) throws Exception{	
 		//return getStorageSpaceDAO().save(storageSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveStorageSpace(userContext, storageSpace, tokens);
 	}
 	
 	protected StorageSpace saveStorageSpaceDetail(RetailScmUserContext userContext, StorageSpace storageSpace) throws Exception{	

 		
 		return saveStorageSpace(userContext, storageSpace, allTokens());
 	}
 	
 	public StorageSpace loadStorageSpace(RetailScmUserContext userContext, String storageSpaceId, String [] tokensExpr) throws Exception{				
 
 		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");
		
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,storageSpace, tokens);
 	}
 	
 	protected StorageSpace present(RetailScmUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,storageSpace,tokens);
		
		
		return this.getStorageSpaceDAO().present(storageSpace, tokens);
	}
 
 	
 	
 	public StorageSpace loadStorageSpaceDetail(RetailScmUserContext userContext, String storageSpaceId) throws Exception{	
 		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");
		
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, allTokens());

 		return present(userContext,storageSpace, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String storageSpaceId) throws Exception{	
 		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");
		
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, allTokens());

 		return present(userContext,storageSpace, allTokens());
		
 	}
 	protected StorageSpace saveStorageSpace(RetailScmUserContext userContext, StorageSpace storageSpace, Map<String,Object>tokens) throws Exception{	
 		return getStorageSpaceDAO().save(storageSpace, tokens);
 	}
 	protected StorageSpace loadStorageSpace(RetailScmUserContext userContext, String storageSpaceId, Map<String,Object>tokens) throws Exception{	
 		return getStorageSpaceDAO().load(storageSpaceId, tokens);
 	}

	



 	 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	//------------------------------------
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens){
		super.addActions(userContext, storageSpace, tokens);
		
		addAction(userContext, storageSpace, tokens,"@create","createStorageSpace","createStorageSpace/","main","primary");
		addAction(userContext, storageSpace, tokens,"@update","updateStorageSpace","updateStorageSpace/"+storageSpace.getId()+"/","main","primary");
		addAction(userContext, storageSpace, tokens,"@copy","cloneStorageSpace","cloneStorageSpace/"+storageSpace.getId()+"/","main","primary");
		
		addAction(userContext, storageSpace, tokens,"storage_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+storageSpace.getId()+"/","main","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.addGoodsShelf","addGoodsShelf","addGoodsShelf/"+storageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.removeGoodsShelf","removeGoodsShelf","removeGoodsShelf/"+storageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.updateGoodsShelf","updateGoodsShelf","updateGoodsShelf/"+storageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.copyGoodsShelfFrom","copyGoodsShelfFrom","copyGoodsShelfFrom/"+storageSpace.getId()+"/","goodsShelfList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public StorageSpace createStorageSpace(RetailScmUserContext userContext,String location, String contactNumber, String totalArea, String warehouseId, double latitude, double longitude
) throws Exception
	{
		
		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");

		

		checkLocationOfStorageSpace(userContext,  location, exception);
		checkContactNumberOfStorageSpace(userContext,  contactNumber, exception);
		checkTotalAreaOfStorageSpace(userContext,  totalArea, exception);
		checkLatitudeOfStorageSpace(userContext,  latitude, exception);
		checkLongitudeOfStorageSpace(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		StorageSpace storageSpace=createNewStorageSpace();	

		storageSpace.setLocation(location);
		storageSpace.setContactNumber(contactNumber);
		storageSpace.setTotalArea(totalArea);
		Warehouse warehouse = loadWarehouse(warehouseId,emptyOptions());
		storageSpace.setWarehouse(warehouse);
		storageSpace.setLatitude(latitude);
		storageSpace.setLongitude(longitude);

		return saveStorageSpace(userContext, storageSpace, emptyOptions());
		

		
	}
	protected StorageSpace createNewStorageSpace() 
	{
		
		return new StorageSpace();		
	}
	
	protected void checkParamsForUpdatingStorageSpace(RetailScmUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");
		
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
	
	
	
	public StorageSpace clone(RetailScmUserContext userContext, String fromStorageSpaceId) throws Exception{
		
		return this.getStorageSpaceDAO().clone(fromStorageSpaceId, this.allTokens());
	}
	
	public StorageSpace updateStorageSpace(RetailScmUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingStorageSpace(userContext, storageSpaceId, storageSpaceVersion, property, newValueExpr, tokensExpr);
		
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		if(storageSpace.getVersion() != storageSpaceVersion){
			String message = "The target version("+storageSpace.getVersion()+") is not equals to version("+storageSpaceVersion+") provided";
			throw new StorageSpaceManagerException(message);
		}
		synchronized(storageSpace){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StorageSpace.
			
			storageSpace.changePropery(property, newValueExpr);
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
			//return saveStorageSpace(userContext, storageSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected StorageSpaceTokens tokens(){
		return StorageSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return StorageSpaceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return StorageSpaceTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailScmUserContext userContext, String storageSpaceId, String anotherWarehouseId) throws Exception
 	{
 		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");
 		checkIdOfStorageSpace(userContext, storageSpaceId,exception);
 		checkIdOfWarehouse(userContext, anotherWarehouseId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public StorageSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String storageSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, storageSpaceId,anotherWarehouseId);
 
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());	
		synchronized(storageSpace){
			//will be good when the storageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(anotherWarehouseId, emptyOptions());		
			storageSpace.setWarehouse(warehouse);		
			storageSpace = saveStorageSpace(userContext, storageSpace, emptyOptions());
			
			return present(userContext,storageSpace, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(String newWarehouseId, Map<String,Object> options) throws Exception
 	{
		
 		return getWarehouseDAO().load(newWarehouseId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String storageSpaceId, int storageSpaceVersion) throws Exception {
		
		deleteInternal(userContext, storageSpaceId, storageSpaceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String storageSpaceId, int storageSpaceVersion) throws Exception{
		getStorageSpaceDAO().delete(storageSpaceId, storageSpaceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new StorageSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getStorageSpaceDAO().deleteAll();
	}

	protected void checkParamsForAddingGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId,String [] tokensExpr) throws Exception{
		
		

		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");
		
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);

		checkLocationOfGoodsShelf(userContext,  location, exception);		
		
		checkIdOfSupplierSpace(userContext,  supplierSpaceId, exception);		
		
		checkIdOfDamageSpace(userContext,  damageSpaceId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  StorageSpace addGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsShelf(userContext,storageSpaceId,location, supplierSpaceId, damageSpaceId,tokensExpr);
		
		GoodsShelf goodsShelf = createGoodsShelf(userContext,location, supplierSpaceId, damageSpaceId);
		
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		synchronized(storageSpace){ 
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			storageSpace.addGoodsShelf( goodsShelf );		
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected GoodsShelf createGoodsShelf(RetailScmUserContext userContext, String location, String supplierSpaceId, String damageSpaceId) throws Exception{

		GoodsShelf goodsShelf = new GoodsShelf();
		
		
		goodsShelf.setLocation(location);		
		SupplierSpace  supplierSpace = new SupplierSpace();
		supplierSpace.setId(supplierSpaceId);		
		goodsShelf.setSupplierSpace(supplierSpace);		
		DamageSpace  damageSpace = new DamageSpace();
		damageSpace.setId(damageSpaceId);		
		goodsShelf.setDamageSpace(damageSpace);
	
		
		return goodsShelf;
	
		
	}
	
	protected GoodsShelf createIndexedGoodsShelf(String id, int version){

		GoodsShelf goodsShelf = new GoodsShelf();
		goodsShelf.setId(id);
		goodsShelf.setVersion(version);
		return goodsShelf;			
		
	}
	protected void checkParamsForRemovingGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		

		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");
		
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  StorageSpace removeGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsShelf(userContext,storageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		synchronized(storageSpace){ 
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			storageSpace.removeGoodsShelf( goodsShelf );		
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		

		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");
		
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  StorageSpace copyGoodsShelfFrom(RetailScmUserContext userContext, String storageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsShelf(userContext,storageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		synchronized(storageSpace){ 
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			storageSpace.copyGoodsShelfFrom( goodsShelf );		
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		StorageSpaceManagerException exception = new StorageSpaceManagerException("Error Occured");
		
		checkIdOfStorageSpace(userContext, storageSpaceId, exception);
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);
		

		if(GoodsShelf.LOCATION_PROPERTY.equals(property)){
			checkLocationOfGoodsShelf(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  StorageSpace updateGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsShelf(userContext, storageSpaceId, goodsShelfId, goodsShelfVersion, property, newValueExpr,  tokensExpr);
		
		
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		
		synchronized(storageSpace){ 
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//storageSpace.removeGoodsShelf( goodsShelf );	
			//make changes to AcceleraterAccount.
			GoodsShelf goodsShelfIndex = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		
			GoodsShelf goodsShelf = storageSpace.findTheGoodsShelf(goodsShelfIndex);
			if(goodsShelf == null){
				throw new StorageSpaceManagerException(goodsShelf+"Not found" );
			}
			
			goodsShelf.changePropery(property, newValueExpr);

			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


