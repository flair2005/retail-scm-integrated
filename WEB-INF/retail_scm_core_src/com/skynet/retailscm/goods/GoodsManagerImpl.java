
package com.skynet.retailscm.goods;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.goodsmovement.GoodsMovement;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;

import com.skynet.retailscm.goodsallocation.GoodsAllocationDAO;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.skynet.retailscm.receivingspace.ReceivingSpaceDAO;
import com.skynet.retailscm.supplyorder.SupplyOrderDAO;
import com.skynet.retailscm.smartpallet.SmartPalletDAO;
import com.skynet.retailscm.shippingspace.ShippingSpaceDAO;
import com.skynet.retailscm.transporttask.TransportTaskDAO;
import com.skynet.retailscm.goodspackaging.GoodsPackagingDAO;
import com.skynet.retailscm.sku.SkuDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;

import com.skynet.retailscm.goods.Goods;


import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.goodsallocation.GoodsAllocationTable;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrderTable;
import com.skynet.retailscm.shippingspace.ShippingSpaceTable;
import com.skynet.retailscm.supplyorder.SupplyOrderTable;
import com.skynet.retailscm.smartpallet.SmartPalletTable;
import com.skynet.retailscm.goodsmovement.GoodsMovementTable;
import com.skynet.retailscm.transporttask.TransportTaskTable;
import com.skynet.retailscm.receivingspace.ReceivingSpaceTable;
import com.skynet.retailscm.sku.SkuTable;
import com.skynet.retailscm.goodspackaging.GoodsPackagingTable;




public class GoodsManagerImpl extends RetailScmCheckerManager implements GoodsManager {
	
	private static final String SERVICE_TYPE = "Goods";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  GoodsDAO  goodsDAO;
 	public void setGoodsDAO(GoodsDAO  goodsDAO){
 	
 		if(goodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = goodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The GoodsDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsDAO;
 	}
 	
 	protected Goods saveGoods(RetailScmUserContext userContext, Goods goods, String [] tokensExpr) throws Exception{	
 		//return getGoodsDAO().save(goods, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoods(userContext, goods, tokens);
 	}
 	
 	protected Goods saveGoodsDetail(RetailScmUserContext userContext, Goods goods) throws Exception{	

 		
 		return saveGoods(userContext, goods, allTokens());
 	}
 	
 	public Goods loadGoods(RetailScmUserContext userContext, String goodsId, String [] tokensExpr) throws Exception{				
 
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
		
		checkIdOfGoods(userContext, goodsId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Goods goods = loadGoods( userContext, goodsId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goods, tokens);
 	}
 	
 	protected Goods present(RetailScmUserContext userContext, Goods goods, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goods,tokens);
		
		
		return this.getGoodsDAO().present(goods, tokens);
	}
 
 	
 	
 	public Goods loadGoodsDetail(RetailScmUserContext userContext, String goodsId) throws Exception{	
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
		
		checkIdOfGoods(userContext, goodsId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Goods goods = loadGoods( userContext, goodsId, allTokens());

 		return present(userContext,goods, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String goodsId) throws Exception{	
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
		
		checkIdOfGoods(userContext, goodsId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Goods goods = loadGoods( userContext, goodsId, allTokens());

 		return present(userContext,goods, allTokens());
		
 	}
 	protected Goods saveGoods(RetailScmUserContext userContext, Goods goods, Map<String,Object>tokens) throws Exception{	
 		return getGoodsDAO().save(goods, tokens);
 	}
 	protected Goods loadGoods(RetailScmUserContext userContext, String goodsId, Map<String,Object>tokens) throws Exception{	
 		return getGoodsDAO().load(goodsId, tokens);
 	}

	



 	 
 	
 	private  GoodsAllocationDAO  goodsAllocationDAO;
 	public void setGoodsAllocationDAO(GoodsAllocationDAO goodsAllocationDAO){
	 	this.goodsAllocationDAO = goodsAllocationDAO;
 	}
 	//------------------------------------
 	public GoodsAllocationDAO getGoodsAllocationDAO(){
	 	return this.goodsAllocationDAO;
 	}
 
 	
 	private  ShippingSpaceDAO  shippingSpaceDAO;
 	public void setShippingSpaceDAO(ShippingSpaceDAO shippingSpaceDAO){
	 	this.shippingSpaceDAO = shippingSpaceDAO;
 	}
 	//------------------------------------
 	public ShippingSpaceDAO getShippingSpaceDAO(){
	 	return this.shippingSpaceDAO;
 	}
 
 	
 	private  GoodsPackagingDAO  goodsPackagingDAO;
 	public void setGoodsPackagingDAO(GoodsPackagingDAO goodsPackagingDAO){
	 	this.goodsPackagingDAO = goodsPackagingDAO;
 	}
 	//------------------------------------
 	public GoodsPackagingDAO getGoodsPackagingDAO(){
	 	return this.goodsPackagingDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	//------------------------------------
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}
 
 	
 	private  SkuDAO  skuDAO;
 	public void setSkuDAO(SkuDAO skuDAO){
	 	this.skuDAO = skuDAO;
 	}
 	//------------------------------------
 	public SkuDAO getSkuDAO(){
	 	return this.skuDAO;
 	}
 
 	
 	private  TransportTaskDAO  transportTaskDAO;
 	public void setTransportTaskDAO(TransportTaskDAO transportTaskDAO){
	 	this.transportTaskDAO = transportTaskDAO;
 	}
 	//------------------------------------
 	public TransportTaskDAO getTransportTaskDAO(){
	 	return this.transportTaskDAO;
 	}
 
 	
 	private  SmartPalletDAO  smartPalletDAO;
 	public void setSmartPalletDAO(SmartPalletDAO smartPalletDAO){
	 	this.smartPalletDAO = smartPalletDAO;
 	}
 	//------------------------------------
 	public SmartPalletDAO getSmartPalletDAO(){
	 	return this.smartPalletDAO;
 	}
 
 	
 	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	//------------------------------------
 	public SupplyOrderDAO getSupplyOrderDAO(){
	 	return this.supplyOrderDAO;
 	}
 
 	
 	private  ReceivingSpaceDAO  receivingSpaceDAO;
 	public void setReceivingSpaceDAO(ReceivingSpaceDAO receivingSpaceDAO){
	 	this.receivingSpaceDAO = receivingSpaceDAO;
 	}
 	//------------------------------------
 	public ReceivingSpaceDAO getReceivingSpaceDAO(){
	 	return this.receivingSpaceDAO;
 	}
 
 	
 	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
	 	return this.retailStoreOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Goods goods, Map<String, Object> tokens){
		super.addActions(userContext, goods, tokens);
		
		addAction(userContext, goods, tokens,"@create","createGoods","createGoods/","main","primary");
		addAction(userContext, goods, tokens,"@update","updateGoods","updateGoods/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"@copy","cloneGoods","cloneGoods/"+goods.getId()+"/","main","primary");
		
		addAction(userContext, goods, tokens,"goods.transfer_to_sku","transferToAnotherSku","transferToAnotherSku/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_receiving_space","transferToAnotherReceivingSpace","transferToAnotherReceivingSpace/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_goods_allocation","transferToAnotherGoodsAllocation","transferToAnotherGoodsAllocation/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_smart_pallet","transferToAnotherSmartPallet","transferToAnotherSmartPallet/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_shipping_space","transferToAnotherShippingSpace","transferToAnotherShippingSpace/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_transport_task","transferToAnotherTransportTask","transferToAnotherTransportTask/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_retail_store","transferToAnotherRetailStore","transferToAnotherRetailStore/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.transfer_to_retail_store_order","transferToAnotherRetailStoreOrder","transferToAnotherRetailStoreOrder/"+goods.getId()+"/","main","primary");
		addAction(userContext, goods, tokens,"goods.pack","pack","pack/"+goods.getId()+"/","main","info");
		addAction(userContext, goods, tokens,"goods.addGoodsMovement","addGoodsMovement","addGoodsMovement/"+goods.getId()+"/","goodsMovementList","primary");
		addAction(userContext, goods, tokens,"goods.removeGoodsMovement","removeGoodsMovement","removeGoodsMovement/"+goods.getId()+"/","goodsMovementList","primary");
		addAction(userContext, goods, tokens,"goods.updateGoodsMovement","updateGoodsMovement","updateGoodsMovement/"+goods.getId()+"/","goodsMovementList","primary");
		addAction(userContext, goods, tokens,"goods.copyGoodsMovementFrom","copyGoodsMovementFrom","copyGoodsMovementFrom/"+goods.getId()+"/","goodsMovementList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Goods goods, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Goods createGoods(RetailScmUserContext userContext,String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId
) throws Exception
	{
		
		GoodsManagerException exception = new GoodsManagerException("Error Occured");

		

		checkNameOfGoods(userContext,  name, exception);
		checkRfidOfGoods(userContext,  rfid, exception);
		checkUomOfGoods(userContext,  uom, exception);
		checkMaxPackageOfGoods(userContext,  maxPackage, exception);
		checkExpireTimeOfGoods(userContext,  expireTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Goods goods=createNewGoods();	

		goods.setName(name);
		goods.setRfid(rfid);
		goods.setUom(uom);
		goods.setMaxPackage(maxPackage);
		goods.setExpireTime(expireTime);
		Sku sku = loadSku(skuId,emptyOptions());
		goods.setSku(sku);
		ReceivingSpace receivingSpace = loadReceivingSpace(receivingSpaceId,emptyOptions());
		goods.setReceivingSpace(receivingSpace);
		GoodsAllocation goodsAllocation = loadGoodsAllocation(goodsAllocationId,emptyOptions());
		goods.setGoodsAllocation(goodsAllocation);
		SmartPallet smartPallet = loadSmartPallet(smartPalletId,emptyOptions());
		goods.setSmartPallet(smartPallet);
		ShippingSpace shippingSpace = loadShippingSpace(shippingSpaceId,emptyOptions());
		goods.setShippingSpace(shippingSpace);
		TransportTask transportTask = loadTransportTask(transportTaskId,emptyOptions());
		goods.setTransportTask(transportTask);
		RetailStore retailStore = loadRetailStore(retailStoreId,emptyOptions());
		goods.setRetailStore(retailStore);
		SupplyOrder bizOrder = loadSupplyOrder(bizOrderId,emptyOptions());
		goods.setBizOrder(bizOrder);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(retailStoreOrderId,emptyOptions());
		goods.setRetailStoreOrder(retailStoreOrder);

		return saveGoods(userContext, goods, emptyOptions());
		

		
	}
	protected Goods createNewGoods() 
	{
		
		return new Goods();		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext,String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		GoodsManagerException exception = new GoodsManagerException("Error Occured");
		
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
	
	
	
	public Goods clone(RetailScmUserContext userContext, String fromGoodsId) throws Exception{
		
		return this.getGoodsDAO().clone(fromGoodsId, this.allTokens());
	}
	
	public Goods updateGoods(RetailScmUserContext userContext,String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoods(userContext, goodsId, goodsVersion, property, newValueExpr, tokensExpr);
		
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		if(goods.getVersion() != goodsVersion){
			String message = "The target version("+goods.getVersion()+") is not equals to version("+goodsVersion+") provided";
			throw new GoodsManagerException(message);
		}
		synchronized(goods){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Goods.
			
			goods.changePropery(property, newValueExpr);
			goods = saveGoods(userContext, goods, tokens().done());
			return present(userContext,goods, mergedAllTokens(tokensExpr));
			//return saveGoods(userContext, goods, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsTokens tokens(){
		return GoodsTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={"PACKED"};
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
	
	protected void checkParamsForTransferingAnotherSku(RetailScmUserContext userContext, String goodsId, String anotherSkuId) throws Exception
 	{
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
 		checkIdOfGoods(userContext, goodsId,exception);
 		checkIdOfSku(userContext, anotherSkuId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Goods transferToAnotherSku(RetailScmUserContext userContext, String goodsId, String anotherSkuId) throws Exception
 	{
 		checkParamsForTransferingAnotherSku(userContext, goodsId,anotherSkuId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Sku sku = loadSku(anotherSkuId, emptyOptions());		
			goods.setSku(sku);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherReceivingSpace(RetailScmUserContext userContext, String goodsId, String anotherReceivingSpaceId) throws Exception
 	{
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
 		checkIdOfGoods(userContext, goodsId,exception);
 		checkIdOfReceivingSpace(userContext, anotherReceivingSpaceId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Goods transferToAnotherReceivingSpace(RetailScmUserContext userContext, String goodsId, String anotherReceivingSpaceId) throws Exception
 	{
 		checkParamsForTransferingAnotherReceivingSpace(userContext, goodsId,anotherReceivingSpaceId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ReceivingSpace receivingSpace = loadReceivingSpace(anotherReceivingSpaceId, emptyOptions());		
			goods.setReceivingSpace(receivingSpace);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherGoodsAllocation(RetailScmUserContext userContext, String goodsId, String anotherGoodsAllocationId) throws Exception
 	{
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
 		checkIdOfGoods(userContext, goodsId,exception);
 		checkIdOfGoodsAllocation(userContext, anotherGoodsAllocationId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Goods transferToAnotherGoodsAllocation(RetailScmUserContext userContext, String goodsId, String anotherGoodsAllocationId) throws Exception
 	{
 		checkParamsForTransferingAnotherGoodsAllocation(userContext, goodsId,anotherGoodsAllocationId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsAllocation goodsAllocation = loadGoodsAllocation(anotherGoodsAllocationId, emptyOptions());		
			goods.setGoodsAllocation(goodsAllocation);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherSmartPallet(RetailScmUserContext userContext, String goodsId, String anotherSmartPalletId) throws Exception
 	{
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
 		checkIdOfGoods(userContext, goodsId,exception);
 		checkIdOfSmartPallet(userContext, anotherSmartPalletId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Goods transferToAnotherSmartPallet(RetailScmUserContext userContext, String goodsId, String anotherSmartPalletId) throws Exception
 	{
 		checkParamsForTransferingAnotherSmartPallet(userContext, goodsId,anotherSmartPalletId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SmartPallet smartPallet = loadSmartPallet(anotherSmartPalletId, emptyOptions());		
			goods.setSmartPallet(smartPallet);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherShippingSpace(RetailScmUserContext userContext, String goodsId, String anotherShippingSpaceId) throws Exception
 	{
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
 		checkIdOfGoods(userContext, goodsId,exception);
 		checkIdOfShippingSpace(userContext, anotherShippingSpaceId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Goods transferToAnotherShippingSpace(RetailScmUserContext userContext, String goodsId, String anotherShippingSpaceId) throws Exception
 	{
 		checkParamsForTransferingAnotherShippingSpace(userContext, goodsId,anotherShippingSpaceId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ShippingSpace shippingSpace = loadShippingSpace(anotherShippingSpaceId, emptyOptions());		
			goods.setShippingSpace(shippingSpace);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherTransportTask(RetailScmUserContext userContext, String goodsId, String anotherTransportTaskId) throws Exception
 	{
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
 		checkIdOfGoods(userContext, goodsId,exception);
 		checkIdOfTransportTask(userContext, anotherTransportTaskId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Goods transferToAnotherTransportTask(RetailScmUserContext userContext, String goodsId, String anotherTransportTaskId) throws Exception
 	{
 		checkParamsForTransferingAnotherTransportTask(userContext, goodsId,anotherTransportTaskId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportTask transportTask = loadTransportTask(anotherTransportTaskId, emptyOptions());		
			goods.setTransportTask(transportTask);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherRetailStore(RetailScmUserContext userContext, String goodsId, String anotherRetailStoreId) throws Exception
 	{
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
 		checkIdOfGoods(userContext, goodsId,exception);
 		checkIdOfRetailStore(userContext, anotherRetailStoreId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Goods transferToAnotherRetailStore(RetailScmUserContext userContext, String goodsId, String anotherRetailStoreId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStore(userContext, goodsId,anotherRetailStoreId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore retailStore = loadRetailStore(anotherRetailStoreId, emptyOptions());		
			goods.setRetailStore(retailStore);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String goodsId, String anotherBizOrderId) throws Exception
 	{
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
 		checkIdOfGoods(userContext, goodsId,exception);
 		checkIdOfSupplyOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Goods transferToAnotherBizOrder(RetailScmUserContext userContext, String goodsId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, goodsId,anotherBizOrderId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(anotherBizOrderId, emptyOptions());		
			goods.setBizOrder(bizOrder);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherRetailStoreOrder(RetailScmUserContext userContext, String goodsId, String anotherRetailStoreOrderId) throws Exception
 	{
 		GoodsManagerException exception = new GoodsManagerException("Error Occured");
 		checkIdOfGoods(userContext, goodsId,exception);
 		checkIdOfRetailStoreOrder(userContext, anotherRetailStoreOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Goods transferToAnotherRetailStoreOrder(RetailScmUserContext userContext, String goodsId, String anotherRetailStoreOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStoreOrder(userContext, goodsId,anotherRetailStoreOrderId);
 
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(anotherRetailStoreOrderId, emptyOptions());		
			goods.setRetailStoreOrder(retailStoreOrder);		
			goods = saveGoods(userContext, goods, emptyOptions());
			
			return present(userContext,goods, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForPackaging(RetailScmUserContext userContext, String goodsId, String packageName, String rfid, Date packageTime, String description
) throws Exception
 	{
 		

		GoodsManagerException exception = new GoodsManagerException("Error Occured");
		
		checkIdOfGoods(userContext, goodsId, exception);
		checkPackageNameOfGoodsPackaging(userContext,packageName,exception);
		checkRfidOfGoodsPackaging(userContext,rfid,exception);
		checkPackageTimeOfGoodsPackaging(userContext,packageTime,exception);
		checkDescriptionOfGoodsPackaging(userContext,description,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public Goods pack(RetailScmUserContext userContext, String goodsId, String packageName, String rfid, Date packageTime, String description
) throws Exception
 	{
		checkParamsForPackaging(userContext, goodsId, packageName, rfid, packageTime, description);
		Goods goods = loadGoods(userContext, goodsId, allTokens());	
		synchronized(goods){
			//will be good when the goods loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForGoodsPackaging(userContext,goods);
 		

			goods.setCurrentStatus("PACKED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			GoodsPackaging packaging = createGoodsPackaging(packageName, rfid, packageTime, description);		
			goods.setPackaging(packaging);		
			goods = saveGoods(userContext, goods, tokens().withPackaging().done());
			
			return present(userContext,goods, allTokens());
			
		}

 	}
 	protected GoodsPackaging createGoodsPackaging(String packageName, String rfid, Date packageTime, String description){
 		GoodsPackaging packaging = new GoodsPackaging(packageName, rfid, packageTime, description);
 		return getGoodsPackagingDAO().save(packaging,emptyOptions());
 	}
 	protected void checkIfEligibleForGoodsPackaging(RetailScmUserContext userContext, Goods goods) throws Exception{
 		
 		
 		String currentStatus = goods.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'PACKED'";
 			throw new GoodsManagerException(message);
 		}
 		
 		if(!("PACKED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'PACKED'";
 			throw new GoodsManagerException(message);
 		}
 		
 		
 		GoodsPackaging packaging = goods.getPackaging();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = packaging 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( packaging != null){
				throw new GoodsManagerException("The Goods("+goods.getId()+") has already been PACKED");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected GoodsAllocation loadGoodsAllocation(String newGoodsAllocationId, Map<String,Object> options) throws Exception
 	{
		
 		return getGoodsAllocationDAO().load(newGoodsAllocationId, options);
 	}
	
	 	
 	protected ShippingSpace loadShippingSpace(String newShippingSpaceId, Map<String,Object> options) throws Exception
 	{
		
 		return getShippingSpaceDAO().load(newShippingSpaceId, options);
 	}
	
	 	
 	protected GoodsPackaging loadGoodsPackaging(String newPackagingId, Map<String,Object> options) throws Exception
 	{
		
 		return getGoodsPackagingDAO().load(newPackagingId, options);
 	}
	
	 	
 	protected RetailStore loadRetailStore(String newRetailStoreId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreDAO().load(newRetailStoreId, options);
 	}
	
	 	
 	protected Sku loadSku(String newSkuId, Map<String,Object> options) throws Exception
 	{
		
 		return getSkuDAO().load(newSkuId, options);
 	}
	
	 	
 	protected TransportTask loadTransportTask(String newTransportTaskId, Map<String,Object> options) throws Exception
 	{
		
 		return getTransportTaskDAO().load(newTransportTaskId, options);
 	}
	
	 	
 	protected SmartPallet loadSmartPallet(String newSmartPalletId, Map<String,Object> options) throws Exception
 	{
		
 		return getSmartPalletDAO().load(newSmartPalletId, options);
 	}
	
	 	
 	protected SupplyOrder loadSupplyOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderDAO().load(newBizOrderId, options);
 	}
	
	 	
 	protected ReceivingSpace loadReceivingSpace(String newReceivingSpaceId, Map<String,Object> options) throws Exception
 	{
		
 		return getReceivingSpaceDAO().load(newReceivingSpaceId, options);
 	}
	
	 	
 	protected RetailStoreOrder loadRetailStoreOrder(String newRetailStoreOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderDAO().load(newRetailStoreOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String goodsId, int goodsVersion) throws Exception {
		
		deleteInternal(userContext, goodsId, goodsVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String goodsId, int goodsVersion) throws Exception{
		getGoodsDAO().delete(goodsId, goodsVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getGoodsDAO().deleteAll();
	}

	protected void checkParamsForAddingGoodsMovement(RetailScmUserContext userContext, String goodsId, Date moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		GoodsManagerException exception = new GoodsManagerException("Error Occured");
		
		checkIdOfGoods(userContext, goodsId, exception);

		checkMoveTimeOfGoodsMovement(userContext,  moveTime, exception);
		checkFacilityOfGoodsMovement(userContext,  facility, exception);
		checkFacilityIdOfGoodsMovement(userContext,  facilityId, exception);
		checkFromIpOfGoodsMovement(userContext,  fromIp, exception);
		checkUserAgentOfGoodsMovement(userContext,  userAgent, exception);
		checkSessionIdOfGoodsMovement(userContext,  sessionId, exception);
		checkLatitudeOfGoodsMovement(userContext,  latitude, exception);
		checkLongitudeOfGoodsMovement(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Goods addGoodsMovement(RetailScmUserContext userContext, String goodsId, Date moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsMovement(userContext,goodsId,moveTime, facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude,tokensExpr);
		
		GoodsMovement goodsMovement = createGoodsMovement(userContext,moveTime, facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude);
		
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		synchronized(goods){ 
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goods.addGoodsMovement( goodsMovement );		
			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}
	}
	protected GoodsMovement createGoodsMovement(RetailScmUserContext userContext, Date moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, double latitude, double longitude) throws Exception{

		GoodsMovement goodsMovement = new GoodsMovement();
		
		
		goodsMovement.setMoveTime(moveTime);		
		goodsMovement.setFacility(facility);		
		goodsMovement.setFacilityId(facilityId);		
		goodsMovement.setFromIp(fromIp);		
		goodsMovement.setUserAgent(userAgent);		
		goodsMovement.setSessionId(sessionId);		
		goodsMovement.setLatitude(latitude);		
		goodsMovement.setLongitude(longitude);
	
		
		return goodsMovement;
	
		
	}
	
	protected GoodsMovement createIndexedGoodsMovement(String id, int version){

		GoodsMovement goodsMovement = new GoodsMovement();
		goodsMovement.setId(id);
		goodsMovement.setVersion(version);
		return goodsMovement;			
		
	}
	protected void checkParamsForRemovingGoodsMovement(RetailScmUserContext userContext, String goodsId, 
		String goodsMovementId, int goodsMovementVersion,String [] tokensExpr) throws Exception{
		

		GoodsManagerException exception = new GoodsManagerException("Error Occured");
		
		checkIdOfGoods(userContext, goodsId, exception);
		checkIdOfGoodsMovement(userContext, goodsMovementId, exception);
		checkVersionOfGoodsMovement(userContext, goodsMovementVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Goods removeGoodsMovement(RetailScmUserContext userContext, String goodsId, 
		String goodsMovementId, int goodsMovementVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsMovement(userContext,goodsId, goodsMovementId, goodsMovementVersion,tokensExpr);
		
		GoodsMovement goodsMovement = createIndexedGoodsMovement(goodsMovementId, goodsMovementVersion);
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		synchronized(goods){ 
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goods.removeGoodsMovement( goodsMovement );		
			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoodsMovement(RetailScmUserContext userContext, String goodsId, 
		String goodsMovementId, int goodsMovementVersion,String [] tokensExpr) throws Exception{
		

		GoodsManagerException exception = new GoodsManagerException("Error Occured");
		
		checkIdOfGoods(userContext, goodsId, exception);
		checkIdOfGoodsMovement(userContext, goodsMovementId, exception);
		checkVersionOfGoodsMovement(userContext, goodsMovementVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Goods copyGoodsMovementFrom(RetailScmUserContext userContext, String goodsId, 
		String goodsMovementId, int goodsMovementVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsMovement(userContext,goodsId, goodsMovementId, goodsMovementVersion,tokensExpr);
		
		GoodsMovement goodsMovement = createIndexedGoodsMovement(goodsMovementId, goodsMovementVersion);
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		synchronized(goods){ 
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goods.copyGoodsMovementFrom( goodsMovement );		
			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoodsMovement(RetailScmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		GoodsManagerException exception = new GoodsManagerException("Error Occured");
		
		checkIdOfGoods(userContext, goodsId, exception);
		checkIdOfGoodsMovement(userContext, goodsMovementId, exception);
		checkVersionOfGoodsMovement(userContext, goodsMovementVersion, exception);
		

		if(GoodsMovement.MOVE_TIME_PROPERTY.equals(property)){
			checkMoveTimeOfGoodsMovement(userContext, parseTimestamp(newValueExpr), exception);
		}
		
		if(GoodsMovement.FACILITY_PROPERTY.equals(property)){
			checkFacilityOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsMovement.FACILITY_ID_PROPERTY.equals(property)){
			checkFacilityIdOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsMovement.FROM_IP_PROPERTY.equals(property)){
			checkFromIpOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsMovement.USER_AGENT_PROPERTY.equals(property)){
			checkUserAgentOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsMovement.SESSION_ID_PROPERTY.equals(property)){
			checkSessionIdOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsMovement.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfGoodsMovement(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(GoodsMovement.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfGoodsMovement(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Goods updateGoodsMovement(RetailScmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsMovement(userContext, goodsId, goodsMovementId, goodsMovementVersion, property, newValueExpr,  tokensExpr);
		
		
		Goods goods = loadGoods(userContext, goodsId, allTokens());
		
		synchronized(goods){ 
			//Will be good when the goods loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goods.removeGoodsMovement( goodsMovement );	
			//make changes to AcceleraterAccount.
			GoodsMovement goodsMovementIndex = createIndexedGoodsMovement(goodsMovementId, goodsMovementVersion);
		
			GoodsMovement goodsMovement = goods.findTheGoodsMovement(goodsMovementIndex);
			if(goodsMovement == null){
				throw new GoodsManagerException(goodsMovement+"Not found" );
			}
			
			goodsMovement.changePropery(property, newValueExpr);

			goods = saveGoods(userContext, goods, tokens().withGoodsMovementList().done());
			return present(userContext,goods, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


