
package com.skynet.retailscm.supplierspace;

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




public class SupplierSpaceManagerImpl extends RetailScmCheckerManager implements SupplierSpaceManager {
	
	private static final String SERVICE_TYPE = "SupplierSpace";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplierSpaceDAO  supplierSpaceDAO;
 	public void setSupplierSpaceDAO(SupplierSpaceDAO  supplierSpaceDAO){
 	
 		if(supplierSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set supplierSpaceDAO to null.");
 		}
	 	this.supplierSpaceDAO = supplierSpaceDAO;
 	}
 	public SupplierSpaceDAO getSupplierSpaceDAO(){
 		if(this.supplierSpaceDAO == null){
 			throw new IllegalStateException("The SupplierSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplierSpaceDAO;
 	}
 	
 	protected SupplierSpace saveSupplierSpace(RetailScmUserContext userContext, SupplierSpace supplierSpace, String [] tokensExpr) throws Exception{	
 		//return getSupplierSpaceDAO().save(supplierSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplierSpace(userContext, supplierSpace, tokens);
 	}
 	
 	protected SupplierSpace saveSupplierSpaceDetail(RetailScmUserContext userContext, SupplierSpace supplierSpace) throws Exception{	

 		
 		return saveSupplierSpace(userContext, supplierSpace, allTokens());
 	}
 	
 	public SupplierSpace loadSupplierSpace(RetailScmUserContext userContext, String supplierSpaceId, String [] tokensExpr) throws Exception{				
 
 		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");
		
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplierSpace supplierSpace = loadSupplierSpace( userContext, supplierSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierSpace, tokens);
 	}
 	
 	protected SupplierSpace present(RetailScmUserContext userContext, SupplierSpace supplierSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplierSpace,tokens);
		
		
		return this.getSupplierSpaceDAO().present(supplierSpace, tokens);
	}
 
 	
 	
 	public SupplierSpace loadSupplierSpaceDetail(RetailScmUserContext userContext, String supplierSpaceId) throws Exception{	
 		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");
		
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplierSpace supplierSpace = loadSupplierSpace( userContext, supplierSpaceId, allTokens());

 		return present(userContext,supplierSpace, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplierSpaceId) throws Exception{	
 		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");
		
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplierSpace supplierSpace = loadSupplierSpace( userContext, supplierSpaceId, allTokens());

 		return present(userContext,supplierSpace, allTokens());
		
 	}
 	protected SupplierSpace saveSupplierSpace(RetailScmUserContext userContext, SupplierSpace supplierSpace, Map<String,Object>tokens) throws Exception{	
 		return getSupplierSpaceDAO().save(supplierSpace, tokens);
 	}
 	protected SupplierSpace loadSupplierSpace(RetailScmUserContext userContext, String supplierSpaceId, Map<String,Object>tokens) throws Exception{	
 		return getSupplierSpaceDAO().load(supplierSpaceId, tokens);
 	}

	



 	 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	//------------------------------------
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplierSpace supplierSpace, Map<String, Object> tokens){
		super.addActions(userContext, supplierSpace, tokens);
		
		addAction(userContext, supplierSpace, tokens,"@create","createSupplierSpace","createSupplierSpace/","main","primary");
		addAction(userContext, supplierSpace, tokens,"@update","updateSupplierSpace","updateSupplierSpace/"+supplierSpace.getId()+"/","main","primary");
		addAction(userContext, supplierSpace, tokens,"@copy","cloneSupplierSpace","cloneSupplierSpace/"+supplierSpace.getId()+"/","main","primary");
		
		addAction(userContext, supplierSpace, tokens,"supplier_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+supplierSpace.getId()+"/","main","primary");
		addAction(userContext, supplierSpace, tokens,"supplier_space.addGoodsShelf","addGoodsShelf","addGoodsShelf/"+supplierSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, supplierSpace, tokens,"supplier_space.removeGoodsShelf","removeGoodsShelf","removeGoodsShelf/"+supplierSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, supplierSpace, tokens,"supplier_space.updateGoodsShelf","updateGoodsShelf","updateGoodsShelf/"+supplierSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, supplierSpace, tokens,"supplier_space.copyGoodsShelfFrom","copyGoodsShelfFrom","copyGoodsShelfFrom/"+supplierSpace.getId()+"/","goodsShelfList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplierSpace supplierSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplierSpace createSupplierSpace(RetailScmUserContext userContext,String location, String contactNumber, String totalArea, String warehouseId, double latitude, double longitude
) throws Exception
	{
		
		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");

		

		checkLocationOfSupplierSpace(userContext,  location, exception);
		checkContactNumberOfSupplierSpace(userContext,  contactNumber, exception);
		checkTotalAreaOfSupplierSpace(userContext,  totalArea, exception);
		checkLatitudeOfSupplierSpace(userContext,  latitude, exception);
		checkLongitudeOfSupplierSpace(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplierSpace supplierSpace=createNewSupplierSpace();	

		supplierSpace.setLocation(location);
		supplierSpace.setContactNumber(contactNumber);
		supplierSpace.setTotalArea(totalArea);
		Warehouse warehouse = loadWarehouse(warehouseId,emptyOptions());
		supplierSpace.setWarehouse(warehouse);
		supplierSpace.setLatitude(latitude);
		supplierSpace.setLongitude(longitude);

		return saveSupplierSpace(userContext, supplierSpace, emptyOptions());
		

		
	}
	protected SupplierSpace createNewSupplierSpace() 
	{
		
		return new SupplierSpace();		
	}
	
	protected void checkParamsForUpdatingSupplierSpace(RetailScmUserContext userContext,String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");
		
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
	
	
	
	public SupplierSpace clone(RetailScmUserContext userContext, String fromSupplierSpaceId) throws Exception{
		
		return this.getSupplierSpaceDAO().clone(fromSupplierSpaceId, this.allTokens());
	}
	
	public SupplierSpace updateSupplierSpace(RetailScmUserContext userContext,String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplierSpace(userContext, supplierSpaceId, supplierSpaceVersion, property, newValueExpr, tokensExpr);
		
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		if(supplierSpace.getVersion() != supplierSpaceVersion){
			String message = "The target version("+supplierSpace.getVersion()+") is not equals to version("+supplierSpaceVersion+") provided";
			throw new SupplierSpaceManagerException(message);
		}
		synchronized(supplierSpace){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplierSpace.
			
			supplierSpace.changePropery(property, newValueExpr);
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().done());
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
			//return saveSupplierSpace(userContext, supplierSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplierSpaceTokens tokens(){
		return SupplierSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplierSpaceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplierSpaceTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailScmUserContext userContext, String supplierSpaceId, String anotherWarehouseId) throws Exception
 	{
 		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");
 		checkIdOfSupplierSpace(userContext, supplierSpaceId,exception);
 		checkIdOfWarehouse(userContext, anotherWarehouseId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SupplierSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String supplierSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, supplierSpaceId,anotherWarehouseId);
 
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());	
		synchronized(supplierSpace){
			//will be good when the supplierSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(anotherWarehouseId, emptyOptions());		
			supplierSpace.setWarehouse(warehouse);		
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, emptyOptions());
			
			return present(userContext,supplierSpace, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(String newWarehouseId, Map<String,Object> options) throws Exception
 	{
		
 		return getWarehouseDAO().load(newWarehouseId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String supplierSpaceId, int supplierSpaceVersion) throws Exception {
		
		deleteInternal(userContext, supplierSpaceId, supplierSpaceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplierSpaceId, int supplierSpaceVersion) throws Exception{
		getSupplierSpaceDAO().delete(supplierSpaceId, supplierSpaceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplierSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplierSpaceDAO().deleteAll();
	}

	protected void checkParamsForAddingGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId,String [] tokensExpr) throws Exception{
		
		

		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");
		
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);

		checkLocationOfGoodsShelf(userContext,  location, exception);		
		
		checkIdOfStorageSpace(userContext,  storageSpaceId, exception);		
		
		checkIdOfDamageSpace(userContext,  damageSpaceId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplierSpace addGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsShelf(userContext,supplierSpaceId,location, storageSpaceId, damageSpaceId,tokensExpr);
		
		GoodsShelf goodsShelf = createGoodsShelf(userContext,location, storageSpaceId, damageSpaceId);
		
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		synchronized(supplierSpace){ 
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierSpace.addGoodsShelf( goodsShelf );		
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected GoodsShelf createGoodsShelf(RetailScmUserContext userContext, String location, String storageSpaceId, String damageSpaceId) throws Exception{

		GoodsShelf goodsShelf = new GoodsShelf();
		
		
		goodsShelf.setLocation(location);		
		StorageSpace  storageSpace = new StorageSpace();
		storageSpace.setId(storageSpaceId);		
		goodsShelf.setStorageSpace(storageSpace);		
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
	protected void checkParamsForRemovingGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		

		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");
		
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplierSpace removeGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsShelf(userContext,supplierSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		synchronized(supplierSpace){ 
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierSpace.removeGoodsShelf( goodsShelf );		
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		

		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");
		
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplierSpace copyGoodsShelfFrom(RetailScmUserContext userContext, String supplierSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsShelf(userContext,supplierSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		synchronized(supplierSpace){ 
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierSpace.copyGoodsShelfFrom( goodsShelf );		
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplierSpaceManagerException exception = new SupplierSpaceManagerException("Error Occured");
		
		checkIdOfSupplierSpace(userContext, supplierSpaceId, exception);
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);
		

		if(GoodsShelf.LOCATION_PROPERTY.equals(property)){
			checkLocationOfGoodsShelf(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplierSpace updateGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsShelf(userContext, supplierSpaceId, goodsShelfId, goodsShelfVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		
		synchronized(supplierSpace){ 
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplierSpace.removeGoodsShelf( goodsShelf );	
			//make changes to AcceleraterAccount.
			GoodsShelf goodsShelfIndex = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		
			GoodsShelf goodsShelf = supplierSpace.findTheGoodsShelf(goodsShelfIndex);
			if(goodsShelf == null){
				throw new SupplierSpaceManagerException(goodsShelf+"Not found" );
			}
			
			goodsShelf.changePropery(property, newValueExpr);

			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


