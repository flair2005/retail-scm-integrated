
package com.skynet.retailscm.receivingspace;

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




public class ReceivingSpaceManagerImpl extends RetailScmCheckerManager implements ReceivingSpaceManager {
	
	private static final String SERVICE_TYPE = "ReceivingSpace";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ReceivingSpaceDAO  receivingSpaceDAO;
 	public void setReceivingSpaceDAO(ReceivingSpaceDAO  receivingSpaceDAO){
 	
 		if(receivingSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set receivingSpaceDAO to null.");
 		}
	 	this.receivingSpaceDAO = receivingSpaceDAO;
 	}
 	public ReceivingSpaceDAO getReceivingSpaceDAO(){
 		if(this.receivingSpaceDAO == null){
 			throw new IllegalStateException("The ReceivingSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.receivingSpaceDAO;
 	}
 	
 	protected ReceivingSpace saveReceivingSpace(RetailScmUserContext userContext, ReceivingSpace receivingSpace, String [] tokensExpr) throws Exception{	
 		//return getReceivingSpaceDAO().save(receivingSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveReceivingSpace(userContext, receivingSpace, tokens);
 	}
 	
 	protected ReceivingSpace saveReceivingSpaceDetail(RetailScmUserContext userContext, ReceivingSpace receivingSpace) throws Exception{	

 		
 		return saveReceivingSpace(userContext, receivingSpace, allTokens());
 	}
 	
 	public ReceivingSpace loadReceivingSpace(RetailScmUserContext userContext, String receivingSpaceId, String [] tokensExpr) throws Exception{				
 
 		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");
		
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ReceivingSpace receivingSpace = loadReceivingSpace( userContext, receivingSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,receivingSpace, tokens);
 	}
 	
 	protected ReceivingSpace present(RetailScmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,receivingSpace,tokens);
		
		
		return this.getReceivingSpaceDAO().present(receivingSpace, tokens);
	}
 
 	
 	
 	public ReceivingSpace loadReceivingSpaceDetail(RetailScmUserContext userContext, String receivingSpaceId) throws Exception{	
 		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");
		
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ReceivingSpace receivingSpace = loadReceivingSpace( userContext, receivingSpaceId, allTokens());

 		return present(userContext,receivingSpace, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String receivingSpaceId) throws Exception{	
 		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");
		
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ReceivingSpace receivingSpace = loadReceivingSpace( userContext, receivingSpaceId, allTokens());

 		return present(userContext,receivingSpace, allTokens());
		
 	}
 	protected ReceivingSpace saveReceivingSpace(RetailScmUserContext userContext, ReceivingSpace receivingSpace, Map<String,Object>tokens) throws Exception{	
 		return getReceivingSpaceDAO().save(receivingSpace, tokens);
 	}
 	protected ReceivingSpace loadReceivingSpace(RetailScmUserContext userContext, String receivingSpaceId, Map<String,Object>tokens) throws Exception{	
 		return getReceivingSpaceDAO().load(receivingSpaceId, tokens);
 	}

	



 	 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	//------------------------------------
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens){
		super.addActions(userContext, receivingSpace, tokens);
		
		addAction(userContext, receivingSpace, tokens,"@create","createReceivingSpace","createReceivingSpace/","main","primary");
		addAction(userContext, receivingSpace, tokens,"@update","updateReceivingSpace","updateReceivingSpace/"+receivingSpace.getId()+"/","main","primary");
		addAction(userContext, receivingSpace, tokens,"@copy","cloneReceivingSpace","cloneReceivingSpace/"+receivingSpace.getId()+"/","main","primary");
		
		addAction(userContext, receivingSpace, tokens,"receiving_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+receivingSpace.getId()+"/","main","primary");
		addAction(userContext, receivingSpace, tokens,"receiving_space.addGoods","addGoods","addGoods/"+receivingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, receivingSpace, tokens,"receiving_space.removeGoods","removeGoods","removeGoods/"+receivingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, receivingSpace, tokens,"receiving_space.updateGoods","updateGoods","updateGoods/"+receivingSpace.getId()+"/","goodsList","primary");
		addAction(userContext, receivingSpace, tokens,"receiving_space.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+receivingSpace.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ReceivingSpace createReceivingSpace(RetailScmUserContext userContext,String location, String contactNumber, String description, String totalArea, String warehouseId, double latitude, double longitude
) throws Exception
	{
		
		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");

		

		checkLocationOfReceivingSpace(userContext,  location, exception);
		checkContactNumberOfReceivingSpace(userContext,  contactNumber, exception);
		checkDescriptionOfReceivingSpace(userContext,  description, exception);
		checkTotalAreaOfReceivingSpace(userContext,  totalArea, exception);
		checkLatitudeOfReceivingSpace(userContext,  latitude, exception);
		checkLongitudeOfReceivingSpace(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ReceivingSpace receivingSpace=createNewReceivingSpace();	

		receivingSpace.setLocation(location);
		receivingSpace.setContactNumber(contactNumber);
		receivingSpace.setDescription(description);
		receivingSpace.setTotalArea(totalArea);
		Warehouse warehouse = loadWarehouse(warehouseId,emptyOptions());
		receivingSpace.setWarehouse(warehouse);
		receivingSpace.setLatitude(latitude);
		receivingSpace.setLongitude(longitude);

		return saveReceivingSpace(userContext, receivingSpace, emptyOptions());
		

		
	}
	protected ReceivingSpace createNewReceivingSpace() 
	{
		
		return new ReceivingSpace();		
	}
	
	protected void checkParamsForUpdatingReceivingSpace(RetailScmUserContext userContext,String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");
		
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
	
	
	
	public ReceivingSpace clone(RetailScmUserContext userContext, String fromReceivingSpaceId) throws Exception{
		
		return this.getReceivingSpaceDAO().clone(fromReceivingSpaceId, this.allTokens());
	}
	
	public ReceivingSpace updateReceivingSpace(RetailScmUserContext userContext,String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingReceivingSpace(userContext, receivingSpaceId, receivingSpaceVersion, property, newValueExpr, tokensExpr);
		
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		if(receivingSpace.getVersion() != receivingSpaceVersion){
			String message = "The target version("+receivingSpace.getVersion()+") is not equals to version("+receivingSpaceVersion+") provided";
			throw new ReceivingSpaceManagerException(message);
		}
		synchronized(receivingSpace){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ReceivingSpace.
			
			receivingSpace.changePropery(property, newValueExpr);
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().done());
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
			//return saveReceivingSpace(userContext, receivingSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ReceivingSpaceTokens tokens(){
		return ReceivingSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ReceivingSpaceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ReceivingSpaceTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailScmUserContext userContext, String receivingSpaceId, String anotherWarehouseId) throws Exception
 	{
 		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");
 		checkIdOfReceivingSpace(userContext, receivingSpaceId,exception);
 		checkIdOfWarehouse(userContext, anotherWarehouseId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ReceivingSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String receivingSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, receivingSpaceId,anotherWarehouseId);
 
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());	
		synchronized(receivingSpace){
			//will be good when the receivingSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(anotherWarehouseId, emptyOptions());		
			receivingSpace.setWarehouse(warehouse);		
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, emptyOptions());
			
			return present(userContext,receivingSpace, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(String newWarehouseId, Map<String,Object> options) throws Exception
 	{
		
 		return getWarehouseDAO().load(newWarehouseId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String receivingSpaceId, int receivingSpaceVersion) throws Exception {
		
		deleteInternal(userContext, receivingSpaceId, receivingSpaceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String receivingSpaceId, int receivingSpaceVersion) throws Exception{
		getReceivingSpaceDAO().delete(receivingSpaceId, receivingSpaceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ReceivingSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getReceivingSpaceDAO().deleteAll();
	}

	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String receivingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");
		
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);

		checkNameOfGoods(userContext,  name, exception);
		checkRfidOfGoods(userContext,  rfid, exception);
		checkUomOfGoods(userContext,  uom, exception);
		checkMaxPackageOfGoods(userContext,  maxPackage, exception);
		checkExpireTimeOfGoods(userContext,  expireTime, exception);		
		
		checkIdOfSku(userContext,  skuId, exception);		
		
		checkIdOfGoodsAllocation(userContext,  goodsAllocationId, exception);		
		
		checkIdOfSmartPallet(userContext,  smartPalletId, exception);		
		
		checkIdOfShippingSpace(userContext,  shippingSpaceId, exception);		
		
		checkIdOfTransportTask(userContext,  transportTaskId, exception);		
		
		checkIdOfRetailStore(userContext,  retailStoreId, exception);		
		
		checkIdOfSupplyOrder(userContext,  bizOrderId, exception);		
		
		checkIdOfRetailStoreOrder(userContext,  retailStoreOrderId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  ReceivingSpace addGoods(RetailScmUserContext userContext, String receivingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,receivingSpaceId,name, rfid, uom, maxPackage, expireTime, skuId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		synchronized(receivingSpace){ 
			//Will be good when the receivingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			receivingSpace.addGoods( goods );		
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
		GoodsAllocation  goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(goodsAllocationId);		
		goods.setGoodsAllocation(goodsAllocation);		
		SmartPallet  smartPallet = new SmartPallet();
		smartPallet.setId(smartPalletId);		
		goods.setSmartPallet(smartPallet);		
		ShippingSpace  shippingSpace = new ShippingSpace();
		shippingSpace.setId(shippingSpaceId);		
		goods.setShippingSpace(shippingSpace);		
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
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String receivingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");
		
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ReceivingSpace removeGoods(RetailScmUserContext userContext, String receivingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,receivingSpaceId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		synchronized(receivingSpace){ 
			//Will be good when the receivingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			receivingSpace.removeGoods( goods );		
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String receivingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");
		
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ReceivingSpace copyGoodsFrom(RetailScmUserContext userContext, String receivingSpaceId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,receivingSpaceId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		synchronized(receivingSpace){ 
			//Will be good when the receivingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			receivingSpace.copyGoodsFrom( goods );		
			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String receivingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ReceivingSpaceManagerException exception = new ReceivingSpaceManagerException("Error Occured");
		
		checkIdOfReceivingSpace(userContext, receivingSpaceId, exception);
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
	
	public  ReceivingSpace updateGoods(RetailScmUserContext userContext, String receivingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, receivingSpaceId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
		
		synchronized(receivingSpace){ 
			//Will be good when the receivingSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//receivingSpace.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = receivingSpace.findTheGoods(goodsIndex);
			if(goods == null){
				throw new ReceivingSpaceManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
			return present(userContext,receivingSpace, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


