
package com.skynet.retailscm.sku;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.goods.Goods;

import com.skynet.retailscm.product.ProductDAO;

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
import com.skynet.retailscm.product.ProductTable;




public class SkuManagerImpl extends RetailScmCheckerManager implements SkuManager {
	
	private static final String SERVICE_TYPE = "Sku";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SkuDAO  skuDAO;
 	public void setSkuDAO(SkuDAO  skuDAO){
 	
 		if(skuDAO == null){
 			throw new IllegalStateException("Do not try to set skuDAO to null.");
 		}
	 	this.skuDAO = skuDAO;
 	}
 	public SkuDAO getSkuDAO(){
 		if(this.skuDAO == null){
 			throw new IllegalStateException("The SkuDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.skuDAO;
 	}
 	
 	protected Sku saveSku(RetailScmUserContext userContext, Sku sku, String [] tokensExpr) throws Exception{	
 		//return getSkuDAO().save(sku, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSku(userContext, sku, tokens);
 	}
 	
 	protected Sku saveSkuDetail(RetailScmUserContext userContext, Sku sku) throws Exception{	

 		
 		return saveSku(userContext, sku, allTokens());
 	}
 	
 	public Sku loadSku(RetailScmUserContext userContext, String skuId, String [] tokensExpr) throws Exception{				
 
 		SkuManagerException exception = new SkuManagerException("Error Occured");
		
		checkIdOfSku(userContext, skuId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	protected Sku present(RetailScmUserContext userContext, Sku sku, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,sku,tokens);
		
		
		return this.getSkuDAO().present(sku, tokens);
	}
 
 	
 	
 	public Sku loadSkuDetail(RetailScmUserContext userContext, String skuId) throws Exception{	
 		SkuManagerException exception = new SkuManagerException("Error Occured");
		
		checkIdOfSku(userContext, skuId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Sku sku = loadSku( userContext, skuId, allTokens());

 		return present(userContext,sku, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String skuId) throws Exception{	
 		SkuManagerException exception = new SkuManagerException("Error Occured");
		
		checkIdOfSku(userContext, skuId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Sku sku = loadSku( userContext, skuId, allTokens());

 		return present(userContext,sku, allTokens());
		
 	}
 	protected Sku saveSku(RetailScmUserContext userContext, Sku sku, Map<String,Object>tokens) throws Exception{	
 		return getSkuDAO().save(sku, tokens);
 	}
 	protected Sku loadSku(RetailScmUserContext userContext, String skuId, Map<String,Object>tokens) throws Exception{	
 		return getSkuDAO().load(skuId, tokens);
 	}

	



 	 
 	
 	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO productDAO){
	 	this.productDAO = productDAO;
 	}
 	//------------------------------------
 	public ProductDAO getProductDAO(){
	 	return this.productDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Sku sku, Map<String, Object> tokens){
		super.addActions(userContext, sku, tokens);
		
		addAction(userContext, sku, tokens,"@create","createSku","createSku/","main","primary");
		addAction(userContext, sku, tokens,"@update","updateSku","updateSku/"+sku.getId()+"/","main","primary");
		addAction(userContext, sku, tokens,"@copy","cloneSku","cloneSku/"+sku.getId()+"/","main","primary");
		
		addAction(userContext, sku, tokens,"sku.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+sku.getId()+"/","main","primary");
		addAction(userContext, sku, tokens,"sku.addGoods","addGoods","addGoods/"+sku.getId()+"/","goodsList","primary");
		addAction(userContext, sku, tokens,"sku.removeGoods","removeGoods","removeGoods/"+sku.getId()+"/","goodsList","primary");
		addAction(userContext, sku, tokens,"sku.updateGoods","updateGoods","updateGoods/"+sku.getId()+"/","goodsList","primary");
		addAction(userContext, sku, tokens,"sku.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+sku.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Sku sku, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Sku createSku(RetailScmUserContext userContext,String displayName, String size, String productId, String barcode, String packageType, String netContent, double price, String picture
) throws Exception
	{
		
		SkuManagerException exception = new SkuManagerException("Error Occured");

		

		checkDisplayNameOfSku(userContext,  displayName, exception);
		checkSizeOfSku(userContext,  size, exception);
		checkBarcodeOfSku(userContext,  barcode, exception);
		checkPackageTypeOfSku(userContext,  packageType, exception);
		checkNetContentOfSku(userContext,  netContent, exception);
		checkPriceOfSku(userContext,  price, exception);
		checkPictureOfSku(userContext,  picture, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Sku sku=createNewSku();	

		sku.setDisplayName(displayName);
		sku.setSize(size);
		Product product = loadProduct(productId,emptyOptions());
		sku.setProduct(product);
		sku.setBarcode(barcode);
		sku.setPackageType(packageType);
		sku.setNetContent(netContent);
		sku.setPrice(price);
		sku.setPicture(picture);

		return saveSku(userContext, sku, emptyOptions());
		

		
	}
	protected Sku createNewSku() 
	{
		
		return new Sku();		
	}
	
	protected void checkParamsForUpdatingSku(RetailScmUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SkuManagerException exception = new SkuManagerException("Error Occured");
		
		checkIdOfSku(userContext, skuId, exception);
		checkVersionOfSku(userContext, skuVersion, exception);
		

		if(Sku.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfSku(userContext, parseString(newValueExpr), exception);
		}
		if(Sku.SIZE_PROPERTY.equals(property)){
			checkSizeOfSku(userContext, parseString(newValueExpr), exception);
		}		

		
		if(Sku.BARCODE_PROPERTY.equals(property)){
			checkBarcodeOfSku(userContext, parseString(newValueExpr), exception);
		}
		if(Sku.PACKAGE_TYPE_PROPERTY.equals(property)){
			checkPackageTypeOfSku(userContext, parseString(newValueExpr), exception);
		}
		if(Sku.NET_CONTENT_PROPERTY.equals(property)){
			checkNetContentOfSku(userContext, parseString(newValueExpr), exception);
		}
		if(Sku.PRICE_PROPERTY.equals(property)){
			checkPriceOfSku(userContext, parseDouble(newValueExpr), exception);
		}
		if(Sku.PICTURE_PROPERTY.equals(property)){
			checkPictureOfSku(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public Sku clone(RetailScmUserContext userContext, String fromSkuId) throws Exception{
		
		return this.getSkuDAO().clone(fromSkuId, this.allTokens());
	}
	
	public Sku updateSku(RetailScmUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		if(sku.getVersion() != skuVersion){
			String message = "The target version("+sku.getVersion()+") is not equals to version("+skuVersion+") provided";
			throw new SkuManagerException(message);
		}
		synchronized(sku){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			sku.changePropery(property, newValueExpr);
			sku = saveSku(userContext, sku, tokens().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
			//return saveSku(userContext, sku, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SkuTokens tokens(){
		return SkuTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SkuTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SkuTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherProduct(RetailScmUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{
 		SkuManagerException exception = new SkuManagerException("Error Occured");
 		checkIdOfSku(userContext, skuId,exception);
 		checkIdOfProduct(userContext, anotherProductId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Sku transferToAnotherProduct(RetailScmUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, skuId,anotherProductId);
 
		Sku sku = loadSku(userContext, skuId, allTokens());	
		synchronized(sku){
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Product product = loadProduct(anotherProductId, emptyOptions());		
			sku.setProduct(product);		
			sku = saveSku(userContext, sku, emptyOptions());
			
			return present(userContext,sku, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Product loadProduct(String newProductId, Map<String,Object> options) throws Exception
 	{
		
 		return getProductDAO().load(newProductId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String skuId, int skuVersion) throws Exception {
		
		deleteInternal(userContext, skuId, skuVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String skuId, int skuVersion) throws Exception{
		getSkuDAO().delete(skuId, skuVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SkuManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSkuDAO().deleteAll();
	}

	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String skuId, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		SkuManagerException exception = new SkuManagerException("Error Occured");
		
		checkIdOfSku(userContext, skuId, exception);

		checkNameOfGoods(userContext,  name, exception);
		checkRfidOfGoods(userContext,  rfid, exception);
		checkUomOfGoods(userContext,  uom, exception);
		checkMaxPackageOfGoods(userContext,  maxPackage, exception);
		checkExpireTimeOfGoods(userContext,  expireTime, exception);		
		
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
	public  Sku addGoods(RetailScmUserContext userContext, String skuId, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,skuId,name, rfid, uom, maxPackage, expireTime, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		synchronized(sku){ 
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			sku.addGoods( goods );		
			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
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
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String skuId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		SkuManagerException exception = new SkuManagerException("Error Occured");
		
		checkIdOfSku(userContext, skuId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Sku removeGoods(RetailScmUserContext userContext, String skuId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,skuId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		Sku sku = loadSku(userContext, skuId, allTokens());
		synchronized(sku){ 
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			sku.removeGoods( goods );		
			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String skuId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		SkuManagerException exception = new SkuManagerException("Error Occured");
		
		checkIdOfSku(userContext, skuId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Sku copyGoodsFrom(RetailScmUserContext userContext, String skuId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,skuId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		Sku sku = loadSku(userContext, skuId, allTokens());
		synchronized(sku){ 
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			sku.copyGoodsFrom( goods );		
			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String skuId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SkuManagerException exception = new SkuManagerException("Error Occured");
		
		checkIdOfSku(userContext, skuId, exception);
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
	
	public  Sku updateGoods(RetailScmUserContext userContext, String skuId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, skuId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		
		synchronized(sku){ 
			//Will be good when the sku loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//sku.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = sku.findTheGoods(goodsIndex);
			if(goods == null){
				throw new SkuManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			sku = saveSku(userContext, sku, tokens().withGoodsList().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


