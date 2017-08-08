
package com.skynet.retailscm.damagespace;

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




public class DamageSpaceManagerImpl extends RetailScmCheckerManager implements DamageSpaceManager {
	
	private static final String SERVICE_TYPE = "DamageSpace";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  DamageSpaceDAO  damageSpaceDAO;
 	public void setDamageSpaceDAO(DamageSpaceDAO  damageSpaceDAO){
 	
 		if(damageSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set damageSpaceDAO to null.");
 		}
	 	this.damageSpaceDAO = damageSpaceDAO;
 	}
 	public DamageSpaceDAO getDamageSpaceDAO(){
 		if(this.damageSpaceDAO == null){
 			throw new IllegalStateException("The DamageSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.damageSpaceDAO;
 	}
 	
 	protected DamageSpace saveDamageSpace(RetailScmUserContext userContext, DamageSpace damageSpace, String [] tokensExpr) throws Exception{	
 		//return getDamageSpaceDAO().save(damageSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveDamageSpace(userContext, damageSpace, tokens);
 	}
 	
 	protected DamageSpace saveDamageSpaceDetail(RetailScmUserContext userContext, DamageSpace damageSpace) throws Exception{	

 		
 		return saveDamageSpace(userContext, damageSpace, allTokens());
 	}
 	
 	public DamageSpace loadDamageSpace(RetailScmUserContext userContext, String damageSpaceId, String [] tokensExpr) throws Exception{				
 
 		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");
		
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		DamageSpace damageSpace = loadDamageSpace( userContext, damageSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,damageSpace, tokens);
 	}
 	
 	protected DamageSpace present(RetailScmUserContext userContext, DamageSpace damageSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,damageSpace,tokens);
		
		
		return this.getDamageSpaceDAO().present(damageSpace, tokens);
	}
 
 	
 	
 	public DamageSpace loadDamageSpaceDetail(RetailScmUserContext userContext, String damageSpaceId) throws Exception{	
 		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");
		
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		DamageSpace damageSpace = loadDamageSpace( userContext, damageSpaceId, allTokens());

 		return present(userContext,damageSpace, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String damageSpaceId) throws Exception{	
 		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");
		
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		DamageSpace damageSpace = loadDamageSpace( userContext, damageSpaceId, allTokens());

 		return present(userContext,damageSpace, allTokens());
		
 	}
 	protected DamageSpace saveDamageSpace(RetailScmUserContext userContext, DamageSpace damageSpace, Map<String,Object>tokens) throws Exception{	
 		return getDamageSpaceDAO().save(damageSpace, tokens);
 	}
 	protected DamageSpace loadDamageSpace(RetailScmUserContext userContext, String damageSpaceId, Map<String,Object>tokens) throws Exception{	
 		return getDamageSpaceDAO().load(damageSpaceId, tokens);
 	}

	



 	 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	//------------------------------------
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, DamageSpace damageSpace, Map<String, Object> tokens){
		super.addActions(userContext, damageSpace, tokens);
		
		addAction(userContext, damageSpace, tokens,"@create","createDamageSpace","createDamageSpace/","main","primary");
		addAction(userContext, damageSpace, tokens,"@update","updateDamageSpace","updateDamageSpace/"+damageSpace.getId()+"/","main","primary");
		addAction(userContext, damageSpace, tokens,"@copy","cloneDamageSpace","cloneDamageSpace/"+damageSpace.getId()+"/","main","primary");
		
		addAction(userContext, damageSpace, tokens,"damage_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+damageSpace.getId()+"/","main","primary");
		addAction(userContext, damageSpace, tokens,"damage_space.addGoodsShelf","addGoodsShelf","addGoodsShelf/"+damageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, damageSpace, tokens,"damage_space.removeGoodsShelf","removeGoodsShelf","removeGoodsShelf/"+damageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, damageSpace, tokens,"damage_space.updateGoodsShelf","updateGoodsShelf","updateGoodsShelf/"+damageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, damageSpace, tokens,"damage_space.copyGoodsShelfFrom","copyGoodsShelfFrom","copyGoodsShelfFrom/"+damageSpace.getId()+"/","goodsShelfList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, DamageSpace damageSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public DamageSpace createDamageSpace(RetailScmUserContext userContext,String location, String contactNumber, String totalArea, double latitude, double longitude, String warehouseId
) throws Exception
	{
		
		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");

		

		checkLocationOfDamageSpace(userContext,  location, exception);
		checkContactNumberOfDamageSpace(userContext,  contactNumber, exception);
		checkTotalAreaOfDamageSpace(userContext,  totalArea, exception);
		checkLatitudeOfDamageSpace(userContext,  latitude, exception);
		checkLongitudeOfDamageSpace(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		DamageSpace damageSpace=createNewDamageSpace();	

		damageSpace.setLocation(location);
		damageSpace.setContactNumber(contactNumber);
		damageSpace.setTotalArea(totalArea);
		damageSpace.setLatitude(latitude);
		damageSpace.setLongitude(longitude);
		Warehouse warehouse = loadWarehouse(warehouseId,emptyOptions());
		damageSpace.setWarehouse(warehouse);

		return saveDamageSpace(userContext, damageSpace, emptyOptions());
		

		
	}
	protected DamageSpace createNewDamageSpace() 
	{
		
		return new DamageSpace();		
	}
	
	protected void checkParamsForUpdatingDamageSpace(RetailScmUserContext userContext,String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");
		
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
	
	
	
	public DamageSpace clone(RetailScmUserContext userContext, String fromDamageSpaceId) throws Exception{
		
		return this.getDamageSpaceDAO().clone(fromDamageSpaceId, this.allTokens());
	}
	
	public DamageSpace updateDamageSpace(RetailScmUserContext userContext,String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDamageSpace(userContext, damageSpaceId, damageSpaceVersion, property, newValueExpr, tokensExpr);
		
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		if(damageSpace.getVersion() != damageSpaceVersion){
			String message = "The target version("+damageSpace.getVersion()+") is not equals to version("+damageSpaceVersion+") provided";
			throw new DamageSpaceManagerException(message);
		}
		synchronized(damageSpace){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DamageSpace.
			
			damageSpace.changePropery(property, newValueExpr);
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().done());
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
			//return saveDamageSpace(userContext, damageSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected DamageSpaceTokens tokens(){
		return DamageSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return DamageSpaceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return DamageSpaceTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailScmUserContext userContext, String damageSpaceId, String anotherWarehouseId) throws Exception
 	{
 		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");
 		checkIdOfDamageSpace(userContext, damageSpaceId,exception);
 		checkIdOfWarehouse(userContext, anotherWarehouseId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public DamageSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String damageSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, damageSpaceId,anotherWarehouseId);
 
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());	
		synchronized(damageSpace){
			//will be good when the damageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(anotherWarehouseId, emptyOptions());		
			damageSpace.setWarehouse(warehouse);		
			damageSpace = saveDamageSpace(userContext, damageSpace, emptyOptions());
			
			return present(userContext,damageSpace, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(String newWarehouseId, Map<String,Object> options) throws Exception
 	{
		
 		return getWarehouseDAO().load(newWarehouseId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String damageSpaceId, int damageSpaceVersion) throws Exception {
		
		deleteInternal(userContext, damageSpaceId, damageSpaceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String damageSpaceId, int damageSpaceVersion) throws Exception{
		getDamageSpaceDAO().delete(damageSpaceId, damageSpaceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new DamageSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getDamageSpaceDAO().deleteAll();
	}

	protected void checkParamsForAddingGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, String location, String storageSpaceId, String supplierSpaceId,String [] tokensExpr) throws Exception{
		
		

		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");
		
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);

		checkLocationOfGoodsShelf(userContext,  location, exception);		
		
		checkIdOfStorageSpace(userContext,  storageSpaceId, exception);		
		
		checkIdOfSupplierSpace(userContext,  supplierSpaceId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  DamageSpace addGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, String location, String storageSpaceId, String supplierSpaceId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsShelf(userContext,damageSpaceId,location, storageSpaceId, supplierSpaceId,tokensExpr);
		
		GoodsShelf goodsShelf = createGoodsShelf(userContext,location, storageSpaceId, supplierSpaceId);
		
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		synchronized(damageSpace){ 
			//Will be good when the damageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			damageSpace.addGoodsShelf( goodsShelf );		
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected GoodsShelf createGoodsShelf(RetailScmUserContext userContext, String location, String storageSpaceId, String supplierSpaceId) throws Exception{

		GoodsShelf goodsShelf = new GoodsShelf();
		
		
		goodsShelf.setLocation(location);		
		StorageSpace  storageSpace = new StorageSpace();
		storageSpace.setId(storageSpaceId);		
		goodsShelf.setStorageSpace(storageSpace);		
		SupplierSpace  supplierSpace = new SupplierSpace();
		supplierSpace.setId(supplierSpaceId);		
		goodsShelf.setSupplierSpace(supplierSpace);
	
		
		return goodsShelf;
	
		
	}
	
	protected GoodsShelf createIndexedGoodsShelf(String id, int version){

		GoodsShelf goodsShelf = new GoodsShelf();
		goodsShelf.setId(id);
		goodsShelf.setVersion(version);
		return goodsShelf;			
		
	}
	protected void checkParamsForRemovingGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		

		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");
		
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  DamageSpace removeGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsShelf(userContext,damageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		synchronized(damageSpace){ 
			//Will be good when the damageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			damageSpace.removeGoodsShelf( goodsShelf );		
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		

		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");
		
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  DamageSpace copyGoodsShelfFrom(RetailScmUserContext userContext, String damageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsShelf(userContext,damageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		synchronized(damageSpace){ 
			//Will be good when the damageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			damageSpace.copyGoodsShelfFrom( goodsShelf );		
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		DamageSpaceManagerException exception = new DamageSpaceManagerException("Error Occured");
		
		checkIdOfDamageSpace(userContext, damageSpaceId, exception);
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);
		

		if(GoodsShelf.LOCATION_PROPERTY.equals(property)){
			checkLocationOfGoodsShelf(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  DamageSpace updateGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsShelf(userContext, damageSpaceId, goodsShelfId, goodsShelfVersion, property, newValueExpr,  tokensExpr);
		
		
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		
		synchronized(damageSpace){ 
			//Will be good when the damageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//damageSpace.removeGoodsShelf( goodsShelf );	
			//make changes to AcceleraterAccount.
			GoodsShelf goodsShelfIndex = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		
			GoodsShelf goodsShelf = damageSpace.findTheGoodsShelf(goodsShelfIndex);
			if(goodsShelf == null){
				throw new DamageSpaceManagerException(goodsShelf+"Not found" );
			}
			
			goodsShelf.changePropery(property, newValueExpr);

			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


