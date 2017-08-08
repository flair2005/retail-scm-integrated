
package com.skynet.retailscm.shippingspace;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.warehouse.Warehouse;

import com.skynet.retailscm.warehouse.WarehouseDAO;

import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;


import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.warehouse.WarehouseTable;




public class ShippingSpaceManagerImpl extends RetailScmCheckerManager implements ShippingSpaceManager {
	
	private static final String SERVICE_TYPE = "ShippingSpace";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ShippingSpaceDAO  shippingSpaceDAO;
 	public void setShippingSpaceDAO(ShippingSpaceDAO  shippingSpaceDAO){
 	
 		if(shippingSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set shippingSpaceDAO to null.");
 		}
	 	this.shippingSpaceDAO = shippingSpaceDAO;
 	}
 	public ShippingSpaceDAO getShippingSpaceDAO(){
 		if(this.shippingSpaceDAO == null){
 			throw new IllegalStateException("The ShippingSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingSpaceDAO;
 	}
 	
 	protected ShippingSpace saveShippingSpace(RetailScmUserContext userContext, ShippingSpace shippingSpace, String [] tokensExpr) throws Exception{	
 		//return getShippingSpaceDAO().save(shippingSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveShippingSpace(userContext, shippingSpace, tokens);
 	}
 	
 	protected ShippingSpace saveShippingSpaceDetail(RetailScmUserContext userContext, ShippingSpace shippingSpace) throws Exception{	

 		
 		return saveShippingSpace(userContext, shippingSpace, allTokens());
 	}
 	
 	public ShippingSpace loadShippingSpace(RetailScmUserContext userContext, String shippingSpaceId, String [] tokensExpr) throws Exception{				
 
 		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");
		
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ShippingSpace shippingSpace = loadShippingSpace( userContext, shippingSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,shippingSpace, tokens);
 	}
 	
 	protected ShippingSpace present(RetailScmUserContext userContext, ShippingSpace shippingSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,shippingSpace,tokens);
		
		
		return this.getShippingSpaceDAO().present(shippingSpace, tokens);
	}
 
 	
 	
 	public ShippingSpace loadShippingSpaceDetail(RetailScmUserContext userContext, String shippingSpaceId) throws Exception{	
 		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");
		
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ShippingSpace shippingSpace = loadShippingSpace( userContext, shippingSpaceId, allTokens());

 		return present(userContext,shippingSpace, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String shippingSpaceId) throws Exception{	
 		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");
		
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ShippingSpace shippingSpace = loadShippingSpace( userContext, shippingSpaceId, allTokens());

 		return present(userContext,shippingSpace, allTokens());
		
 	}
 	protected ShippingSpace saveShippingSpace(RetailScmUserContext userContext, ShippingSpace shippingSpace, Map<String,Object>tokens) throws Exception{	
 		return getShippingSpaceDAO().save(shippingSpace, tokens);
 	}
 	protected ShippingSpace loadShippingSpace(RetailScmUserContext userContext, String shippingSpaceId, Map<String,Object>tokens) throws Exception{	
 		return getShippingSpaceDAO().load(shippingSpaceId, tokens);
 	}

	



 	 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	//------------------------------------
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ShippingSpace shippingSpace, Map<String, Object> tokens){
		super.addActions(userContext, shippingSpace, tokens);
		
		addAction(userContext, shippingSpace, tokens,"@create","createShippingSpace","createShippingSpace/","main","primary");
		addAction(userContext, shippingSpace, tokens,"@update","updateShippingSpace","updateShippingSpace/"+shippingSpace.getId()+"/","main","primary");
		addAction(userContext, shippingSpace, tokens,"@copy","cloneShippingSpace","cloneShippingSpace/"+shippingSpace.getId()+"/","main","primary");
		
		addAction(userContext, shippingSpace, tokens,"shipping_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+shippingSpace.getId()+"/","main","primary");
		addAction(userContext, shippingSpace, tokens,"shipping_space.addGoods","addGoods","addGoods/"+shippingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, shippingSpace, tokens,"shipping_space.removeGoods","removeGoods","removeGoods/"+shippingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, shippingSpace, tokens,"shipping_space.updateGoods","updateGoods","updateGoods/"+shippingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, shippingSpace, tokens,"shipping_space.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+shippingSpace.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ShippingSpace shippingSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ShippingSpace createShippingSpace(RetailScmUserContext userContext,String location, String contactNumber, String totalArea, String warehouseId, double latitude, double longitude, String description
) throws Exception
	{
		
		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");

		

		checkLocationOfShippingSpace(userContext,  location, exception);
		checkContactNumberOfShippingSpace(userContext,  contactNumber, exception);
		checkTotalAreaOfShippingSpace(userContext,  totalArea, exception);
		checkLatitudeOfShippingSpace(userContext,  latitude, exception);
		checkLongitudeOfShippingSpace(userContext,  longitude, exception);
		checkDescriptionOfShippingSpace(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ShippingSpace shippingSpace=createNewShippingSpace();	

		shippingSpace.setLocation(location);
		shippingSpace.setContactNumber(contactNumber);
		shippingSpace.setTotalArea(totalArea);
		Warehouse warehouse = loadWarehouse(warehouseId,emptyOptions());
		shippingSpace.setWarehouse(warehouse);
		shippingSpace.setLatitude(latitude);
		shippingSpace.setLongitude(longitude);
		shippingSpace.setDescription(description);

		return saveShippingSpace(userContext, shippingSpace, emptyOptions());
		

		
	}
	protected ShippingSpace createNewShippingSpace() 
	{
		
		return new ShippingSpace();		
	}
	
	protected void checkParamsForUpdatingShippingSpace(RetailScmUserContext userContext,String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");
		
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
	
	
	
	public ShippingSpace clone(RetailScmUserContext userContext, String fromShippingSpaceId) throws Exception{
		
		return this.getShippingSpaceDAO().clone(fromShippingSpaceId, this.allTokens());
	}
	
	public ShippingSpace updateShippingSpace(RetailScmUserContext userContext,String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingShippingSpace(userContext, shippingSpaceId, shippingSpaceVersion, property, newValueExpr, tokensExpr);
		
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
		if(shippingSpace.getVersion() != shippingSpaceVersion){
			String message = "The target version("+shippingSpace.getVersion()+") is not equals to version("+shippingSpaceVersion+") provided";
			throw new ShippingSpaceManagerException(message);
		}
		synchronized(shippingSpace){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingSpace.
			
			shippingSpace.changePropery(property, newValueExpr);
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().done());
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
			//return saveShippingSpace(userContext, shippingSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ShippingSpaceTokens tokens(){
		return ShippingSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ShippingSpaceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ShippingSpaceTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailScmUserContext userContext, String shippingSpaceId, String anotherWarehouseId) throws Exception
 	{
 		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");
 		checkIdOfShippingSpace(userContext, shippingSpaceId,exception);
 		checkIdOfWarehouse(userContext, anotherWarehouseId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ShippingSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String shippingSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, shippingSpaceId,anotherWarehouseId);
 
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());	
		synchronized(shippingSpace){
			//will be good when the shippingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(anotherWarehouseId, emptyOptions());		
			shippingSpace.setWarehouse(warehouse);		
			shippingSpace = saveShippingSpace(userContext, shippingSpace, emptyOptions());
			
			return present(userContext,shippingSpace, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(String newWarehouseId, Map<String,Object> options) throws Exception
 	{
		
 		return getWarehouseDAO().load(newWarehouseId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String shippingSpaceId, int shippingSpaceVersion) throws Exception {
		
		deleteInternal(userContext, shippingSpaceId, shippingSpaceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String shippingSpaceId, int shippingSpaceVersion) throws Exception{
		getShippingSpaceDAO().delete(shippingSpaceId, shippingSpaceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ShippingSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getShippingSpaceDAO().deleteAll();
	}

	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String shippingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");
		
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);

		checkNameOfGoods(userContext,  name, exception);
		checkRfidOfGoods(userContext,  rfid, exception);
		checkUomOfGoods(userContext,  uom, exception);
		checkMaxPackageOfGoods(userContext,  maxPackage, exception);
		checkExpireTimeOfGoods(userContext,  expireTime, exception);		
		
		checkIdOfSku(userContext,  skuId, exception);		
		
		checkIdOfReceivingSpace(userContext,  receivingSpaceId, exception);		
		
		checkIdOfGoodsAllocation(userContext,  goodsAllocationId, exception);		
		
		checkIdOfSmartPallet(userContext,  smartPalletId, exception);		
		
		checkIdOfTransportTask(userContext,  transportTaskId, exception);		
		
		checkIdOfRetailStore(userContext,  retailStoreId, exception);		
		
		checkIdOfSupplyOrder(userContext,  bizOrderId, exception);		
		
		checkIdOfRetailStoreOrder(userContext,  retailStoreOrderId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  ShippingSpace addGoods(RetailScmUserContext userContext, String shippingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,shippingSpaceId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
		synchronized(shippingSpace){ 
			//Will be good when the shippingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			shippingSpace.addGoods( goods );		
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
		ReceivingSpace  receivingSpace = new ReceivingSpace();
		receivingSpace.setId(receivingSpaceId);		
		goods.setReceivingSpace(receivingSpace);		
		GoodsAllocation  goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(goodsAllocationId);		
		goods.setGoodsAllocation(goodsAllocation);		
		SmartPallet  smartPallet = new SmartPallet();
		smartPallet.setId(smartPalletId);		
		goods.setSmartPallet(smartPallet);		
		TransportTask  transportTask = new TransportTask();
		transportTask.setId(transportTaskId);		
		goods.setTransportTask(transportTask);		
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		goods.setRetailStore(retailStore);		
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);		
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);
	
		
		return goods;
	
		
	}
	
	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;			
		
	}
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String shippingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");
		
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ShippingSpace removeGoods(RetailScmUserContext userContext, String shippingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,shippingSpaceId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
		synchronized(shippingSpace){ 
			//Will be good when the shippingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			shippingSpace.removeGoods( goods );		
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String shippingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");
		
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ShippingSpace copyGoodsFrom(RetailScmUserContext userContext, String shippingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,shippingSpaceId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
		synchronized(shippingSpace){ 
			//Will be good when the shippingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			shippingSpace.copyGoodsFrom( goods );		
			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String shippingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ShippingSpaceManagerException exception = new ShippingSpaceManagerException("Error Occured");
		
		checkIdOfShippingSpace(userContext, shippingSpaceId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);
		

		if(Goods.NAME_PROPERTY.equals(property)){
			checkNameOfGoods(userContext, parseString(newValueExpr), exception);
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
			checkRfidOfGoods(userContext, parseString(newValueExpr), exception);
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
			checkUomOfGoods(userContext, parseString(newValueExpr), exception);
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
			checkMaxPackageOfGoods(userContext, parseInt(newValueExpr), exception);
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
			checkExpireTimeOfGoods(userContext, parseDate(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  ShippingSpace updateGoods(RetailScmUserContext userContext, String shippingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, shippingSpaceId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		ShippingSpace shippingSpace = loadShippingSpace(userContext, shippingSpaceId, allTokens());
		
		synchronized(shippingSpace){ 
			//Will be good when the shippingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//shippingSpace.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = shippingSpace.findTheGoods(goodsIndex);
			if(goods == null){
				throw new ShippingSpaceManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			shippingSpace = saveShippingSpace(userContext, shippingSpace, tokens().withGoodsList().done());
			return present(userContext,shippingSpace, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


