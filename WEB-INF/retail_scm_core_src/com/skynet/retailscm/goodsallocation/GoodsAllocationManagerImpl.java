
package com.skynet.retailscm.goodsallocation;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.goodsshelf.GoodsShelf;

import com.skynet.retailscm.goodsshelf.GoodsShelfDAO;

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
import com.skynet.retailscm.goodsshelf.GoodsShelfTable;




public class GoodsAllocationManagerImpl extends RetailScmCheckerManager implements GoodsAllocationManager {
	
	private static final String SERVICE_TYPE = "GoodsAllocation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  GoodsAllocationDAO  goodsAllocationDAO;
 	public void setGoodsAllocationDAO(GoodsAllocationDAO  goodsAllocationDAO){
 	
 		if(goodsAllocationDAO == null){
 			throw new IllegalStateException("Do not try to set goodsAllocationDAO to null.");
 		}
	 	this.goodsAllocationDAO = goodsAllocationDAO;
 	}
 	public GoodsAllocationDAO getGoodsAllocationDAO(){
 		if(this.goodsAllocationDAO == null){
 			throw new IllegalStateException("The GoodsAllocationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsAllocationDAO;
 	}
 	
 	protected GoodsAllocation saveGoodsAllocation(RetailScmUserContext userContext, GoodsAllocation goodsAllocation, String [] tokensExpr) throws Exception{	
 		//return getGoodsAllocationDAO().save(goodsAllocation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsAllocation(userContext, goodsAllocation, tokens);
 	}
 	
 	protected GoodsAllocation saveGoodsAllocationDetail(RetailScmUserContext userContext, GoodsAllocation goodsAllocation) throws Exception{	

 		
 		return saveGoodsAllocation(userContext, goodsAllocation, allTokens());
 	}
 	
 	public GoodsAllocation loadGoodsAllocation(RetailScmUserContext userContext, String goodsAllocationId, String [] tokensExpr) throws Exception{				
 
 		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");
		
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsAllocation goodsAllocation = loadGoodsAllocation( userContext, goodsAllocationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsAllocation, tokens);
 	}
 	
 	protected GoodsAllocation present(RetailScmUserContext userContext, GoodsAllocation goodsAllocation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsAllocation,tokens);
		
		
		return this.getGoodsAllocationDAO().present(goodsAllocation, tokens);
	}
 
 	
 	
 	public GoodsAllocation loadGoodsAllocationDetail(RetailScmUserContext userContext, String goodsAllocationId) throws Exception{	
 		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");
		
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsAllocation goodsAllocation = loadGoodsAllocation( userContext, goodsAllocationId, allTokens());

 		return present(userContext,goodsAllocation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String goodsAllocationId) throws Exception{	
 		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");
		
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsAllocation goodsAllocation = loadGoodsAllocation( userContext, goodsAllocationId, allTokens());

 		return present(userContext,goodsAllocation, allTokens());
		
 	}
 	protected GoodsAllocation saveGoodsAllocation(RetailScmUserContext userContext, GoodsAllocation goodsAllocation, Map<String,Object>tokens) throws Exception{	
 		return getGoodsAllocationDAO().save(goodsAllocation, tokens);
 	}
 	protected GoodsAllocation loadGoodsAllocation(RetailScmUserContext userContext, String goodsAllocationId, Map<String,Object>tokens) throws Exception{	
 		return getGoodsAllocationDAO().load(goodsAllocationId, tokens);
 	}

	



 	 
 	
 	private  GoodsShelfDAO  goodsShelfDAO;
 	public void setGoodsShelfDAO(GoodsShelfDAO goodsShelfDAO){
	 	this.goodsShelfDAO = goodsShelfDAO;
 	}
 	//------------------------------------
 	public GoodsShelfDAO getGoodsShelfDAO(){
	 	return this.goodsShelfDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsAllocation goodsAllocation, Map<String, Object> tokens){
		super.addActions(userContext, goodsAllocation, tokens);
		
		addAction(userContext, goodsAllocation, tokens,"@create","createGoodsAllocation","createGoodsAllocation/","main","primary");
		addAction(userContext, goodsAllocation, tokens,"@update","updateGoodsAllocation","updateGoodsAllocation/"+goodsAllocation.getId()+"/","main","primary");
		addAction(userContext, goodsAllocation, tokens,"@copy","cloneGoodsAllocation","cloneGoodsAllocation/"+goodsAllocation.getId()+"/","main","primary");
		
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.transfer_to_goods_shelf","transferToAnotherGoodsShelf","transferToAnotherGoodsShelf/"+goodsAllocation.getId()+"/","main","primary");
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.addGoods","addGoods","addGoods/"+goodsAllocation.getId()+"/","goodsList","primary");
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.removeGoods","removeGoods","removeGoods/"+goodsAllocation.getId()+"/","goodsList","primary");
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.updateGoods","updateGoods","updateGoods/"+goodsAllocation.getId()+"/","goodsList","primary");
		addAction(userContext, goodsAllocation, tokens,"goods_allocation.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+goodsAllocation.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsAllocation goodsAllocation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public GoodsAllocation createGoodsAllocation(RetailScmUserContext userContext,String location, double latitude, double longitude, String goodsShelfId
) throws Exception
	{
		
		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");

		

		checkLocationOfGoodsAllocation(userContext,  location, exception);
		checkLatitudeOfGoodsAllocation(userContext,  latitude, exception);
		checkLongitudeOfGoodsAllocation(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		GoodsAllocation goodsAllocation=createNewGoodsAllocation();	

		goodsAllocation.setLocation(location);
		goodsAllocation.setLatitude(latitude);
		goodsAllocation.setLongitude(longitude);
		GoodsShelf goodsShelf = loadGoodsShelf(goodsShelfId,emptyOptions());
		goodsAllocation.setGoodsShelf(goodsShelf);

		return saveGoodsAllocation(userContext, goodsAllocation, emptyOptions());
		

		
	}
	protected GoodsAllocation createNewGoodsAllocation() 
	{
		
		return new GoodsAllocation();		
	}
	
	protected void checkParamsForUpdatingGoodsAllocation(RetailScmUserContext userContext,String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");
		
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
		checkVersionOfGoodsAllocation(userContext, goodsAllocationVersion, exception);
		

		if(GoodsAllocation.LOCATION_PROPERTY.equals(property)){
			checkLocationOfGoodsAllocation(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsAllocation.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfGoodsAllocation(userContext, parseDouble(newValueExpr), exception);
		}
		if(GoodsAllocation.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfGoodsAllocation(userContext, parseDouble(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public GoodsAllocation clone(RetailScmUserContext userContext, String fromGoodsAllocationId) throws Exception{
		
		return this.getGoodsAllocationDAO().clone(fromGoodsAllocationId, this.allTokens());
	}
	
	public GoodsAllocation updateGoodsAllocation(RetailScmUserContext userContext,String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsAllocation(userContext, goodsAllocationId, goodsAllocationVersion, property, newValueExpr, tokensExpr);
		
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		if(goodsAllocation.getVersion() != goodsAllocationVersion){
			String message = "The target version("+goodsAllocation.getVersion()+") is not equals to version("+goodsAllocationVersion+") provided";
			throw new GoodsAllocationManagerException(message);
		}
		synchronized(goodsAllocation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsAllocation.
			
			goodsAllocation.changePropery(property, newValueExpr);
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().done());
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
			//return saveGoodsAllocation(userContext, goodsAllocation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsAllocationTokens tokens(){
		return GoodsAllocationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsAllocationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsAllocationTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherGoodsShelf(RetailScmUserContext userContext, String goodsAllocationId, String anotherGoodsShelfId) throws Exception
 	{
 		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");
 		checkIdOfGoodsAllocation(userContext, goodsAllocationId,exception);
 		checkIdOfGoodsShelf(userContext, anotherGoodsShelfId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public GoodsAllocation transferToAnotherGoodsShelf(RetailScmUserContext userContext, String goodsAllocationId, String anotherGoodsShelfId) throws Exception
 	{
 		checkParamsForTransferingAnotherGoodsShelf(userContext, goodsAllocationId,anotherGoodsShelfId);
 
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());	
		synchronized(goodsAllocation){
			//will be good when the goodsAllocation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsShelf goodsShelf = loadGoodsShelf(anotherGoodsShelfId, emptyOptions());		
			goodsAllocation.setGoodsShelf(goodsShelf);		
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, emptyOptions());
			
			return present(userContext,goodsAllocation, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected GoodsShelf loadGoodsShelf(String newGoodsShelfId, Map<String,Object> options) throws Exception
 	{
		
 		return getGoodsShelfDAO().load(newGoodsShelfId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String goodsAllocationId, int goodsAllocationVersion) throws Exception {
		
		deleteInternal(userContext, goodsAllocationId, goodsAllocationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String goodsAllocationId, int goodsAllocationVersion) throws Exception{
		getGoodsAllocationDAO().delete(goodsAllocationId, goodsAllocationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsAllocationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getGoodsAllocationDAO().deleteAll();
	}

	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");
		
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);

		checkNameOfGoods(userContext,  name, exception);
		checkRfidOfGoods(userContext,  rfid, exception);
		checkUomOfGoods(userContext,  uom, exception);
		checkMaxPackageOfGoods(userContext,  maxPackage, exception);
		checkExpireTimeOfGoods(userContext,  expireTime, exception);		
		
		checkIdOfSku(userContext,  skuId, exception);		
		
		checkIdOfReceivingSpace(userContext,  receivingSpaceId, exception);		
		
		checkIdOfSmartPallet(userContext,  smartPalletId, exception);		
		
		checkIdOfShippingSpace(userContext,  shippingSpaceId, exception);		
		
		checkIdOfTransportTask(userContext,  transportTaskId, exception);		
		
		checkIdOfRetailStore(userContext,  retailStoreId, exception);		
		
		checkIdOfSupplyOrder(userContext,  bizOrderId, exception);		
		
		checkIdOfRetailStoreOrder(userContext,  retailStoreOrderId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  GoodsAllocation addGoods(RetailScmUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,goodsAllocationId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		synchronized(goodsAllocation){ 
			//Will be good when the goodsAllocation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsAllocation.addGoods( goods );		
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

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
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String goodsAllocationId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");
		
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsAllocation removeGoods(RetailScmUserContext userContext, String goodsAllocationId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,goodsAllocationId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		synchronized(goodsAllocation){ 
			//Will be good when the goodsAllocation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsAllocation.removeGoods( goods );		
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String goodsAllocationId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");
		
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsAllocation copyGoodsFrom(RetailScmUserContext userContext, String goodsAllocationId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,goodsAllocationId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		synchronized(goodsAllocation){ 
			//Will be good when the goodsAllocation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsAllocation.copyGoodsFrom( goods );		
			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		GoodsAllocationManagerException exception = new GoodsAllocationManagerException("Error Occured");
		
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
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
	
	public  GoodsAllocation updateGoods(RetailScmUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, goodsAllocationId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		GoodsAllocation goodsAllocation = loadGoodsAllocation(userContext, goodsAllocationId, allTokens());
		
		synchronized(goodsAllocation){ 
			//Will be good when the goodsAllocation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsAllocation.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = goodsAllocation.findTheGoods(goodsIndex);
			if(goods == null){
				throw new GoodsAllocationManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			goodsAllocation = saveGoodsAllocation(userContext, goodsAllocation, tokens().withGoodsList().done());
			return present(userContext,goodsAllocation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


