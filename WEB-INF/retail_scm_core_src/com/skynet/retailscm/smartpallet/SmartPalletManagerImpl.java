
package com.skynet.retailscm.smartpallet;

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




public class SmartPalletManagerImpl extends RetailScmCheckerManager implements SmartPalletManager {
	
	private static final String SERVICE_TYPE = "SmartPallet";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SmartPalletDAO  smartPalletDAO;
 	public void setSmartPalletDAO(SmartPalletDAO  smartPalletDAO){
 	
 		if(smartPalletDAO == null){
 			throw new IllegalStateException("Do not try to set smartPalletDAO to null.");
 		}
	 	this.smartPalletDAO = smartPalletDAO;
 	}
 	public SmartPalletDAO getSmartPalletDAO(){
 		if(this.smartPalletDAO == null){
 			throw new IllegalStateException("The SmartPalletDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.smartPalletDAO;
 	}
 	
 	protected SmartPallet saveSmartPallet(RetailScmUserContext userContext, SmartPallet smartPallet, String [] tokensExpr) throws Exception{	
 		//return getSmartPalletDAO().save(smartPallet, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSmartPallet(userContext, smartPallet, tokens);
 	}
 	
 	protected SmartPallet saveSmartPalletDetail(RetailScmUserContext userContext, SmartPallet smartPallet) throws Exception{	

 		
 		return saveSmartPallet(userContext, smartPallet, allTokens());
 	}
 	
 	public SmartPallet loadSmartPallet(RetailScmUserContext userContext, String smartPalletId, String [] tokensExpr) throws Exception{				
 
 		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");
		
		checkIdOfSmartPallet(userContext, smartPalletId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,smartPallet, tokens);
 	}
 	
 	protected SmartPallet present(RetailScmUserContext userContext, SmartPallet smartPallet, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,smartPallet,tokens);
		
		
		return this.getSmartPalletDAO().present(smartPallet, tokens);
	}
 
 	
 	
 	public SmartPallet loadSmartPalletDetail(RetailScmUserContext userContext, String smartPalletId) throws Exception{	
 		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");
		
		checkIdOfSmartPallet(userContext, smartPalletId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, allTokens());

 		return present(userContext,smartPallet, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String smartPalletId) throws Exception{	
 		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");
		
		checkIdOfSmartPallet(userContext, smartPalletId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SmartPallet smartPallet = loadSmartPallet( userContext, smartPalletId, allTokens());

 		return present(userContext,smartPallet, allTokens());
		
 	}
 	protected SmartPallet saveSmartPallet(RetailScmUserContext userContext, SmartPallet smartPallet, Map<String,Object>tokens) throws Exception{	
 		return getSmartPalletDAO().save(smartPallet, tokens);
 	}
 	protected SmartPallet loadSmartPallet(RetailScmUserContext userContext, String smartPalletId, Map<String,Object>tokens) throws Exception{	
 		return getSmartPalletDAO().load(smartPalletId, tokens);
 	}

	



 	 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	//------------------------------------
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SmartPallet smartPallet, Map<String, Object> tokens){
		super.addActions(userContext, smartPallet, tokens);
		
		addAction(userContext, smartPallet, tokens,"@create","createSmartPallet","createSmartPallet/","main","primary");
		addAction(userContext, smartPallet, tokens,"@update","updateSmartPallet","updateSmartPallet/"+smartPallet.getId()+"/","main","primary");
		addAction(userContext, smartPallet, tokens,"@copy","cloneSmartPallet","cloneSmartPallet/"+smartPallet.getId()+"/","main","primary");
		
		addAction(userContext, smartPallet, tokens,"smart_pallet.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+smartPallet.getId()+"/","main","primary");
		addAction(userContext, smartPallet, tokens,"smart_pallet.addGoods","addGoods","addGoods/"+smartPallet.getId()+"/","goodsList","primary");
		addAction(userContext, smartPallet, tokens,"smart_pallet.removeGoods","removeGoods","removeGoods/"+smartPallet.getId()+"/","goodsList","primary");
		addAction(userContext, smartPallet, tokens,"smart_pallet.updateGoods","updateGoods","updateGoods/"+smartPallet.getId()+"/","goodsList","primary");
		addAction(userContext, smartPallet, tokens,"smart_pallet.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+smartPallet.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SmartPallet smartPallet, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SmartPallet createSmartPallet(RetailScmUserContext userContext,String location, String contactNumber, String totalArea, double latitude, double longitude, String warehouseId
) throws Exception
	{
		
		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");

		

		checkLocationOfSmartPallet(userContext,  location, exception);
		checkContactNumberOfSmartPallet(userContext,  contactNumber, exception);
		checkTotalAreaOfSmartPallet(userContext,  totalArea, exception);
		checkLatitudeOfSmartPallet(userContext,  latitude, exception);
		checkLongitudeOfSmartPallet(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SmartPallet smartPallet=createNewSmartPallet();	

		smartPallet.setLocation(location);
		smartPallet.setContactNumber(contactNumber);
		smartPallet.setTotalArea(totalArea);
		smartPallet.setLatitude(latitude);
		smartPallet.setLongitude(longitude);
		Warehouse warehouse = loadWarehouse(warehouseId,emptyOptions());
		smartPallet.setWarehouse(warehouse);

		return saveSmartPallet(userContext, smartPallet, emptyOptions());
		

		
	}
	protected SmartPallet createNewSmartPallet() 
	{
		
		return new SmartPallet();		
	}
	
	protected void checkParamsForUpdatingSmartPallet(RetailScmUserContext userContext,String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");
		
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
	
	
	
	public SmartPallet clone(RetailScmUserContext userContext, String fromSmartPalletId) throws Exception{
		
		return this.getSmartPalletDAO().clone(fromSmartPalletId, this.allTokens());
	}
	
	public SmartPallet updateSmartPallet(RetailScmUserContext userContext,String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSmartPallet(userContext, smartPalletId, smartPalletVersion, property, newValueExpr, tokensExpr);
		
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		if(smartPallet.getVersion() != smartPalletVersion){
			String message = "The target version("+smartPallet.getVersion()+") is not equals to version("+smartPalletVersion+") provided";
			throw new SmartPalletManagerException(message);
		}
		synchronized(smartPallet){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SmartPallet.
			
			smartPallet.changePropery(property, newValueExpr);
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().done());
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
			//return saveSmartPallet(userContext, smartPallet, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SmartPalletTokens tokens(){
		return SmartPalletTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SmartPalletTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SmartPalletTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailScmUserContext userContext, String smartPalletId, String anotherWarehouseId) throws Exception
 	{
 		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");
 		checkIdOfSmartPallet(userContext, smartPalletId,exception);
 		checkIdOfWarehouse(userContext, anotherWarehouseId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SmartPallet transferToAnotherWarehouse(RetailScmUserContext userContext, String smartPalletId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, smartPalletId,anotherWarehouseId);
 
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());	
		synchronized(smartPallet){
			//will be good when the smartPallet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(anotherWarehouseId, emptyOptions());		
			smartPallet.setWarehouse(warehouse);		
			smartPallet = saveSmartPallet(userContext, smartPallet, emptyOptions());
			
			return present(userContext,smartPallet, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(String newWarehouseId, Map<String,Object> options) throws Exception
 	{
		
 		return getWarehouseDAO().load(newWarehouseId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String smartPalletId, int smartPalletVersion) throws Exception {
		
		deleteInternal(userContext, smartPalletId, smartPalletVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String smartPalletId, int smartPalletVersion) throws Exception{
		getSmartPalletDAO().delete(smartPalletId, smartPalletVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SmartPalletManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSmartPalletDAO().deleteAll();
	}

	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");
		
		checkIdOfSmartPallet(userContext, smartPalletId, exception);

		checkNameOfGoods(userContext,  name, exception);
		checkRfidOfGoods(userContext,  rfid, exception);
		checkUomOfGoods(userContext,  uom, exception);
		checkMaxPackageOfGoods(userContext,  maxPackage, exception);
		checkExpireTimeOfGoods(userContext,  expireTime, exception);		
		
		checkIdOfSku(userContext,  skuId, exception);		
		
		checkIdOfReceivingSpace(userContext,  receivingSpaceId, exception);		
		
		checkIdOfGoodsAllocation(userContext,  goodsAllocationId, exception);		
		
		checkIdOfShippingSpace(userContext,  shippingSpaceId, exception);		
		
		checkIdOfTransportTask(userContext,  transportTaskId, exception);		
		
		checkIdOfRetailStore(userContext,  retailStoreId, exception);		
		
		checkIdOfSupplyOrder(userContext,  bizOrderId, exception);		
		
		checkIdOfRetailStoreOrder(userContext,  retailStoreOrderId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SmartPallet addGoods(RetailScmUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,smartPalletId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		synchronized(smartPallet){ 
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			smartPallet.addGoods( goods );		
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

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
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String smartPalletId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");
		
		checkIdOfSmartPallet(userContext, smartPalletId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SmartPallet removeGoods(RetailScmUserContext userContext, String smartPalletId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,smartPalletId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		synchronized(smartPallet){ 
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			smartPallet.removeGoods( goods );		
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String smartPalletId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");
		
		checkIdOfSmartPallet(userContext, smartPalletId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SmartPallet copyGoodsFrom(RetailScmUserContext userContext, String smartPalletId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,smartPalletId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		synchronized(smartPallet){ 
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			smartPallet.copyGoodsFrom( goods );		
			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SmartPalletManagerException exception = new SmartPalletManagerException("Error Occured");
		
		checkIdOfSmartPallet(userContext, smartPalletId, exception);
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
	
	public  SmartPallet updateGoods(RetailScmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, smartPalletId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		SmartPallet smartPallet = loadSmartPallet(userContext, smartPalletId, allTokens());
		
		synchronized(smartPallet){ 
			//Will be good when the smartPallet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//smartPallet.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = smartPallet.findTheGoods(goodsIndex);
			if(goods == null){
				throw new SmartPalletManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			smartPallet = saveSmartPallet(userContext, smartPallet, tokens().withGoodsList().done());
			return present(userContext,smartPallet, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


