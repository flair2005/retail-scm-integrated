
package com.skynet.retailscm.goodspackaging;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.goods.Goods;


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




public class GoodsPackagingManagerImpl extends RetailScmCheckerManager implements GoodsPackagingManager {
	
	private static final String SERVICE_TYPE = "GoodsPackaging";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  GoodsPackagingDAO  goodsPackagingDAO;
 	public void setGoodsPackagingDAO(GoodsPackagingDAO  goodsPackagingDAO){
 	
 		if(goodsPackagingDAO == null){
 			throw new IllegalStateException("Do not try to set goodsPackagingDAO to null.");
 		}
	 	this.goodsPackagingDAO = goodsPackagingDAO;
 	}
 	public GoodsPackagingDAO getGoodsPackagingDAO(){
 		if(this.goodsPackagingDAO == null){
 			throw new IllegalStateException("The GoodsPackagingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsPackagingDAO;
 	}
 	
 	protected GoodsPackaging saveGoodsPackaging(RetailScmUserContext userContext, GoodsPackaging goodsPackaging, String [] tokensExpr) throws Exception{	
 		//return getGoodsPackagingDAO().save(goodsPackaging, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsPackaging(userContext, goodsPackaging, tokens);
 	}
 	
 	protected GoodsPackaging saveGoodsPackagingDetail(RetailScmUserContext userContext, GoodsPackaging goodsPackaging) throws Exception{	

 		
 		return saveGoodsPackaging(userContext, goodsPackaging, allTokens());
 	}
 	
 	public GoodsPackaging loadGoodsPackaging(RetailScmUserContext userContext, String goodsPackagingId, String [] tokensExpr) throws Exception{				
 
 		GoodsPackagingManagerException exception = new GoodsPackagingManagerException("Error Occured");
		
		checkIdOfGoodsPackaging(userContext, goodsPackagingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsPackaging, tokens);
 	}
 	
 	protected GoodsPackaging present(RetailScmUserContext userContext, GoodsPackaging goodsPackaging, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsPackaging,tokens);
		
		
		return this.getGoodsPackagingDAO().present(goodsPackaging, tokens);
	}
 
 	
 	
 	public GoodsPackaging loadGoodsPackagingDetail(RetailScmUserContext userContext, String goodsPackagingId) throws Exception{	
 		GoodsPackagingManagerException exception = new GoodsPackagingManagerException("Error Occured");
		
		checkIdOfGoodsPackaging(userContext, goodsPackagingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, allTokens());

 		return present(userContext,goodsPackaging, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String goodsPackagingId) throws Exception{	
 		GoodsPackagingManagerException exception = new GoodsPackagingManagerException("Error Occured");
		
		checkIdOfGoodsPackaging(userContext, goodsPackagingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, allTokens());

 		return present(userContext,goodsPackaging, allTokens());
		
 	}
 	protected GoodsPackaging saveGoodsPackaging(RetailScmUserContext userContext, GoodsPackaging goodsPackaging, Map<String,Object>tokens) throws Exception{	
 		return getGoodsPackagingDAO().save(goodsPackaging, tokens);
 	}
 	protected GoodsPackaging loadGoodsPackaging(RetailScmUserContext userContext, String goodsPackagingId, Map<String,Object>tokens) throws Exception{	
 		return getGoodsPackagingDAO().load(goodsPackagingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsPackaging goodsPackaging, Map<String, Object> tokens){
		super.addActions(userContext, goodsPackaging, tokens);
		
		addAction(userContext, goodsPackaging, tokens,"@create","createGoodsPackaging","createGoodsPackaging/","main","primary");
		addAction(userContext, goodsPackaging, tokens,"@update","updateGoodsPackaging","updateGoodsPackaging/"+goodsPackaging.getId()+"/","main","primary");
		addAction(userContext, goodsPackaging, tokens,"@copy","cloneGoodsPackaging","cloneGoodsPackaging/"+goodsPackaging.getId()+"/","main","primary");
		
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.addGoods","addGoods","addGoods/"+goodsPackaging.getId()+"/","goodsList","primary");
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.removeGoods","removeGoods","removeGoods/"+goodsPackaging.getId()+"/","goodsList","primary");
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.updateGoods","updateGoods","updateGoods/"+goodsPackaging.getId()+"/","goodsList","primary");
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+goodsPackaging.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsPackaging goodsPackaging, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public GoodsPackaging createGoodsPackaging(RetailScmUserContext userContext,String packageName, String rfid, Date packageTime, String description
) throws Exception
	{
		
		GoodsPackagingManagerException exception = new GoodsPackagingManagerException("Error Occured");

		

		checkPackageNameOfGoodsPackaging(userContext,  packageName, exception);
		checkRfidOfGoodsPackaging(userContext,  rfid, exception);
		checkPackageTimeOfGoodsPackaging(userContext,  packageTime, exception);
		checkDescriptionOfGoodsPackaging(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		GoodsPackaging goodsPackaging=createNewGoodsPackaging();	

		goodsPackaging.setPackageName(packageName);
		goodsPackaging.setRfid(rfid);
		goodsPackaging.setPackageTime(packageTime);
		goodsPackaging.setDescription(description);

		return saveGoodsPackaging(userContext, goodsPackaging, emptyOptions());
		

		
	}
	protected GoodsPackaging createNewGoodsPackaging() 
	{
		
		return new GoodsPackaging();		
	}
	
	protected void checkParamsForUpdatingGoodsPackaging(RetailScmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		GoodsPackagingManagerException exception = new GoodsPackagingManagerException("Error Occured");
		
		checkIdOfGoodsPackaging(userContext, goodsPackagingId, exception);
		checkVersionOfGoodsPackaging(userContext, goodsPackagingVersion, exception);
		

		if(GoodsPackaging.PACKAGE_NAME_PROPERTY.equals(property)){
			checkPackageNameOfGoodsPackaging(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsPackaging.RFID_PROPERTY.equals(property)){
			checkRfidOfGoodsPackaging(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsPackaging.PACKAGE_TIME_PROPERTY.equals(property)){
			checkPackageTimeOfGoodsPackaging(userContext, parseDate(newValueExpr), exception);
		}
		if(GoodsPackaging.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfGoodsPackaging(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public GoodsPackaging clone(RetailScmUserContext userContext, String fromGoodsPackagingId) throws Exception{
		
		return this.getGoodsPackagingDAO().clone(fromGoodsPackagingId, this.allTokens());
	}
	
	public GoodsPackaging updateGoodsPackaging(RetailScmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsPackaging(userContext, goodsPackagingId, goodsPackagingVersion, property, newValueExpr, tokensExpr);
		
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		if(goodsPackaging.getVersion() != goodsPackagingVersion){
			String message = "The target version("+goodsPackaging.getVersion()+") is not equals to version("+goodsPackagingVersion+") provided";
			throw new GoodsPackagingManagerException(message);
		}
		synchronized(goodsPackaging){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsPackaging.
			
			goodsPackaging.changePropery(property, newValueExpr);
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
			//return saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsPackagingTokens tokens(){
		return GoodsPackagingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsPackagingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsPackagingTokens.mergeAll(tokens).done();
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
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String goodsPackagingId, int goodsPackagingVersion) throws Exception {
		
		deleteInternal(userContext, goodsPackagingId, goodsPackagingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String goodsPackagingId, int goodsPackagingVersion) throws Exception{
		getGoodsPackagingDAO().delete(goodsPackagingId, goodsPackagingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsPackagingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getGoodsPackagingDAO().deleteAll();
	}

	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		GoodsPackagingManagerException exception = new GoodsPackagingManagerException("Error Occured");
		
		checkIdOfGoodsPackaging(userContext, goodsPackagingId, exception);

		checkNameOfGoods(userContext,  name, exception);
		checkRfidOfGoods(userContext,  rfid, exception);
		checkUomOfGoods(userContext,  uom, exception);
		checkMaxPackageOfGoods(userContext,  maxPackage, exception);
		checkExpireTimeOfGoods(userContext,  expireTime, exception);		
		
		checkIdOfSku(userContext,  skuId, exception);		
		
		checkIdOfReceivingSpace(userContext,  receivingSpaceId, exception);		
		
		checkIdOfGoodsAllocation(userContext,  goodsAllocationId, exception);		
		
		checkIdOfSmartPallet(userContext,  smartPalletId, exception);		
		
		checkIdOfShippingSpace(userContext,  shippingSpaceId, exception);		
		
		checkIdOfTransportTask(userContext,  transportTaskId, exception);		
		
		checkIdOfRetailStore(userContext,  retailStoreId, exception);		
		
		checkIdOfSupplyOrder(userContext,  bizOrderId, exception);		
		
		checkIdOfRetailStoreOrder(userContext,  retailStoreOrderId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  GoodsPackaging addGoods(RetailScmUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,goodsPackagingId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		synchronized(goodsPackaging){ 
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsPackaging.addGoods( goods );		
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

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
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String goodsPackagingId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		GoodsPackagingManagerException exception = new GoodsPackagingManagerException("Error Occured");
		
		checkIdOfGoodsPackaging(userContext, goodsPackagingId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsPackaging removeGoods(RetailScmUserContext userContext, String goodsPackagingId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,goodsPackagingId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		synchronized(goodsPackaging){ 
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsPackaging.removeGoods( goods );		
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String goodsPackagingId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		GoodsPackagingManagerException exception = new GoodsPackagingManagerException("Error Occured");
		
		checkIdOfGoodsPackaging(userContext, goodsPackagingId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsPackaging copyGoodsFrom(RetailScmUserContext userContext, String goodsPackagingId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,goodsPackagingId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		synchronized(goodsPackaging){ 
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsPackaging.copyGoodsFrom( goods );		
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		GoodsPackagingManagerException exception = new GoodsPackagingManagerException("Error Occured");
		
		checkIdOfGoodsPackaging(userContext, goodsPackagingId, exception);
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
	
	public  GoodsPackaging updateGoods(RetailScmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, goodsPackagingId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		
		synchronized(goodsPackaging){ 
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsPackaging.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = goodsPackaging.findTheGoods(goodsIndex);
			if(goods == null){
				throw new GoodsPackagingManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


