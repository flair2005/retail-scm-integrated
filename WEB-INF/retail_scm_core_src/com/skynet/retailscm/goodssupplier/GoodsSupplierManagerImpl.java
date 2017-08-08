
package com.skynet.retailscm.goodssupplier;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.supplierproduct.SupplierProduct;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.supplierproduct.SupplierProductTable;
import com.skynet.retailscm.supplyorder.SupplyOrderTable;
import com.skynet.retailscm.accountset.AccountSetTable;




public class GoodsSupplierManagerImpl extends RetailScmCheckerManager implements GoodsSupplierManager {
	
	private static final String SERVICE_TYPE = "GoodsSupplier";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  GoodsSupplierDAO  goodsSupplierDAO;
 	public void setGoodsSupplierDAO(GoodsSupplierDAO  goodsSupplierDAO){
 	
 		if(goodsSupplierDAO == null){
 			throw new IllegalStateException("Do not try to set goodsSupplierDAO to null.");
 		}
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
 		if(this.goodsSupplierDAO == null){
 			throw new IllegalStateException("The GoodsSupplierDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsSupplierDAO;
 	}
 	
 	protected GoodsSupplier saveGoodsSupplier(RetailScmUserContext userContext, GoodsSupplier goodsSupplier, String [] tokensExpr) throws Exception{	
 		//return getGoodsSupplierDAO().save(goodsSupplier, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsSupplier(userContext, goodsSupplier, tokens);
 	}
 	
 	protected GoodsSupplier saveGoodsSupplierDetail(RetailScmUserContext userContext, GoodsSupplier goodsSupplier) throws Exception{	

 		
 		return saveGoodsSupplier(userContext, goodsSupplier, allTokens());
 	}
 	
 	public GoodsSupplier loadGoodsSupplier(RetailScmUserContext userContext, String goodsSupplierId, String [] tokensExpr) throws Exception{				
 
 		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsSupplier goodsSupplier = loadGoodsSupplier( userContext, goodsSupplierId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsSupplier, tokens);
 	}
 	
 	protected GoodsSupplier present(RetailScmUserContext userContext, GoodsSupplier goodsSupplier, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsSupplier,tokens);
		
		
		return this.getGoodsSupplierDAO().present(goodsSupplier, tokens);
	}
 
 	
 	
 	public GoodsSupplier loadGoodsSupplierDetail(RetailScmUserContext userContext, String goodsSupplierId) throws Exception{	
 		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsSupplier goodsSupplier = loadGoodsSupplier( userContext, goodsSupplierId, allTokens());

 		return present(userContext,goodsSupplier, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String goodsSupplierId) throws Exception{	
 		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsSupplier goodsSupplier = loadGoodsSupplier( userContext, goodsSupplierId, allTokens());

 		return present(userContext,goodsSupplier, allTokens());
		
 	}
 	protected GoodsSupplier saveGoodsSupplier(RetailScmUserContext userContext, GoodsSupplier goodsSupplier, Map<String,Object>tokens) throws Exception{	
 		return getGoodsSupplierDAO().save(goodsSupplier, tokens);
 	}
 	protected GoodsSupplier loadGoodsSupplier(RetailScmUserContext userContext, String goodsSupplierId, Map<String,Object>tokens) throws Exception{	
 		return getGoodsSupplierDAO().load(goodsSupplierId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsSupplier goodsSupplier, Map<String, Object> tokens){
		super.addActions(userContext, goodsSupplier, tokens);
		
		addAction(userContext, goodsSupplier, tokens,"@create","createGoodsSupplier","createGoodsSupplier/","main","primary");
		addAction(userContext, goodsSupplier, tokens,"@update","updateGoodsSupplier","updateGoodsSupplier/"+goodsSupplier.getId()+"/","main","primary");
		addAction(userContext, goodsSupplier, tokens,"@copy","cloneGoodsSupplier","cloneGoodsSupplier/"+goodsSupplier.getId()+"/","main","primary");
		
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.transfer_to_belong_to","transferToAnotherBelongTo","transferToAnotherBelongTo/"+goodsSupplier.getId()+"/","main","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.addSupplierProduct","addSupplierProduct","addSupplierProduct/"+goodsSupplier.getId()+"/","supplierProductList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.removeSupplierProduct","removeSupplierProduct","removeSupplierProduct/"+goodsSupplier.getId()+"/","supplierProductList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.updateSupplierProduct","updateSupplierProduct","updateSupplierProduct/"+goodsSupplier.getId()+"/","supplierProductList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.copySupplierProductFrom","copySupplierProductFrom","copySupplierProductFrom/"+goodsSupplier.getId()+"/","supplierProductList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+goodsSupplier.getId()+"/","supplyOrderList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+goodsSupplier.getId()+"/","supplyOrderList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+goodsSupplier.getId()+"/","supplyOrderList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+goodsSupplier.getId()+"/","supplyOrderList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.addAccountSet","addAccountSet","addAccountSet/"+goodsSupplier.getId()+"/","accountSetList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.removeAccountSet","removeAccountSet","removeAccountSet/"+goodsSupplier.getId()+"/","accountSetList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.updateAccountSet","updateAccountSet","updateAccountSet/"+goodsSupplier.getId()+"/","accountSetList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.copyAccountSetFrom","copyAccountSetFrom","copyAccountSetFrom/"+goodsSupplier.getId()+"/","accountSetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsSupplier goodsSupplier, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public GoodsSupplier createGoodsSupplier(RetailScmUserContext userContext,String name, String supplyProduct, String belongToId, String contactNumber, String description
) throws Exception
	{
		
		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");

		

		checkNameOfGoodsSupplier(userContext,  name, exception);
		checkSupplyProductOfGoodsSupplier(userContext,  supplyProduct, exception);
		checkContactNumberOfGoodsSupplier(userContext,  contactNumber, exception);
		checkDescriptionOfGoodsSupplier(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		GoodsSupplier goodsSupplier=createNewGoodsSupplier();	

		goodsSupplier.setName(name);
		goodsSupplier.setSupplyProduct(supplyProduct);
		RetailStoreCountryCenter belongTo = loadRetailStoreCountryCenter(belongToId,emptyOptions());
		goodsSupplier.setBelongTo(belongTo);
		goodsSupplier.setContactNumber(contactNumber);
		goodsSupplier.setDescription(description);

		return saveGoodsSupplier(userContext, goodsSupplier, emptyOptions());
		

		
	}
	protected GoodsSupplier createNewGoodsSupplier() 
	{
		
		return new GoodsSupplier();		
	}
	
	protected void checkParamsForUpdatingGoodsSupplier(RetailScmUserContext userContext,String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkVersionOfGoodsSupplier(userContext, goodsSupplierVersion, exception);
		

		if(GoodsSupplier.NAME_PROPERTY.equals(property)){
			checkNameOfGoodsSupplier(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY.equals(property)){
			checkSupplyProductOfGoodsSupplier(userContext, parseString(newValueExpr), exception);
		}		

		
		if(GoodsSupplier.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfGoodsSupplier(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsSupplier.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfGoodsSupplier(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public GoodsSupplier clone(RetailScmUserContext userContext, String fromGoodsSupplierId) throws Exception{
		
		return this.getGoodsSupplierDAO().clone(fromGoodsSupplierId, this.allTokens());
	}
	
	public GoodsSupplier updateGoodsSupplier(RetailScmUserContext userContext,String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsSupplier(userContext, goodsSupplierId, goodsSupplierVersion, property, newValueExpr, tokensExpr);
		
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		if(goodsSupplier.getVersion() != goodsSupplierVersion){
			String message = "The target version("+goodsSupplier.getVersion()+") is not equals to version("+goodsSupplierVersion+") provided";
			throw new GoodsSupplierManagerException(message);
		}
		synchronized(goodsSupplier){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsSupplier.
			
			goodsSupplier.changePropery(property, newValueExpr);
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
			//return saveGoodsSupplier(userContext, goodsSupplier, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsSupplierTokens tokens(){
		return GoodsSupplierTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsSupplierTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsSupplierTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBelongTo(RetailScmUserContext userContext, String goodsSupplierId, String anotherBelongToId) throws Exception
 	{
 		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
 		checkIdOfGoodsSupplier(userContext, goodsSupplierId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherBelongToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public GoodsSupplier transferToAnotherBelongTo(RetailScmUserContext userContext, String goodsSupplierId, String anotherBelongToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongTo(userContext, goodsSupplierId,anotherBelongToId);
 
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());	
		synchronized(goodsSupplier){
			//will be good when the goodsSupplier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter belongTo = loadRetailStoreCountryCenter(anotherBelongToId, emptyOptions());		
			goodsSupplier.setBelongTo(belongTo);		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, emptyOptions());
			
			return present(userContext,goodsSupplier, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newBelongToId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newBelongToId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String goodsSupplierId, int goodsSupplierVersion) throws Exception {
		
		deleteInternal(userContext, goodsSupplierId, goodsSupplierVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String goodsSupplierId, int goodsSupplierVersion) throws Exception{
		getGoodsSupplierDAO().delete(goodsSupplierId, goodsSupplierVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsSupplierManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getGoodsSupplierDAO().deleteAll();
	}

	protected void checkParamsForAddingSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit,String [] tokensExpr) throws Exception{
		
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);

		checkProductNameOfSupplierProduct(userContext,  productName, exception);
		checkProductDescriptionOfSupplierProduct(userContext,  productDescription, exception);
		checkProductUnitOfSupplierProduct(userContext,  productUnit, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  GoodsSupplier addSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplierProduct(userContext,goodsSupplierId,productName, productDescription, productUnit,tokensExpr);
		
		SupplierProduct supplierProduct = createSupplierProduct(userContext,productName, productDescription, productUnit);
		
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.addSupplierProduct( supplierProduct );		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplierProductList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
	}
	protected SupplierProduct createSupplierProduct(RetailScmUserContext userContext, String productName, String productDescription, String productUnit) throws Exception{

		SupplierProduct supplierProduct = new SupplierProduct();
		
		
		supplierProduct.setProductName(productName);		
		supplierProduct.setProductDescription(productDescription);		
		supplierProduct.setProductUnit(productUnit);
	
		
		return supplierProduct;
	
		
	}
	
	protected SupplierProduct createIndexedSupplierProduct(String id, int version){

		SupplierProduct supplierProduct = new SupplierProduct();
		supplierProduct.setId(id);
		supplierProduct.setVersion(version);
		return supplierProduct;			
		
	}
	protected void checkParamsForRemovingSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, 
		String supplierProductId, int supplierProductVersion,String [] tokensExpr) throws Exception{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);
		checkVersionOfSupplierProduct(userContext, supplierProductVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsSupplier removeSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, 
		String supplierProductId, int supplierProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplierProduct(userContext,goodsSupplierId, supplierProductId, supplierProductVersion,tokensExpr);
		
		SupplierProduct supplierProduct = createIndexedSupplierProduct(supplierProductId, supplierProductVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.removeSupplierProduct( supplierProduct );		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplierProductList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, 
		String supplierProductId, int supplierProductVersion,String [] tokensExpr) throws Exception{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);
		checkVersionOfSupplierProduct(userContext, supplierProductVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsSupplier copySupplierProductFrom(RetailScmUserContext userContext, String goodsSupplierId, 
		String supplierProductId, int supplierProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplierProduct(userContext,goodsSupplierId, supplierProductId, supplierProductVersion,tokensExpr);
		
		SupplierProduct supplierProduct = createIndexedSupplierProduct(supplierProductId, supplierProductVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.copySupplierProductFrom( supplierProduct );		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplierProductList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);
		checkVersionOfSupplierProduct(userContext, supplierProductVersion, exception);
		

		if(SupplierProduct.PRODUCT_NAME_PROPERTY.equals(property)){
			checkProductNameOfSupplierProduct(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY.equals(property)){
			checkProductDescriptionOfSupplierProduct(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplierProduct.PRODUCT_UNIT_PROPERTY.equals(property)){
			checkProductUnitOfSupplierProduct(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  GoodsSupplier updateSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplierProduct(userContext, goodsSupplierId, supplierProductId, supplierProductVersion, property, newValueExpr,  tokensExpr);
		
		
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsSupplier.removeSupplierProduct( supplierProduct );	
			//make changes to AcceleraterAccount.
			SupplierProduct supplierProductIndex = createIndexedSupplierProduct(supplierProductId, supplierProductVersion);
		
			SupplierProduct supplierProduct = goodsSupplier.findTheSupplierProduct(supplierProductIndex);
			if(supplierProduct == null){
				throw new GoodsSupplierManagerException(supplierProduct+"Not found" );
			}
			
			supplierProduct.changePropery(property, newValueExpr);

			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplierProductList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, String buyerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  buyerId, exception);
		checkTitleOfSupplyOrder(userContext,  title, exception);
		checkTotalAmountOfSupplyOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  GoodsSupplier addSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, String buyerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,goodsSupplierId,buyerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, title, totalAmount);
		
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.addSupplyOrder( supplyOrder );		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
	}
	protected SupplyOrder createSupplyOrder(RetailScmUserContext userContext, String buyerId, String title, double totalAmount) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		RetailStoreCountryCenter  buyer = new RetailStoreCountryCenter();
		buyer.setId(buyerId);		
		supplyOrder.setBuyer(buyer);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);
	
		
		return supplyOrder;
	
		
	}
	
	protected SupplyOrder createIndexedSupplyOrder(String id, int version){

		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(version);
		return supplyOrder;			
		
	}
	protected void checkParamsForRemovingSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsSupplier removeSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,goodsSupplierId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.removeSupplyOrder( supplyOrder );		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsSupplier copySupplyOrderFrom(RetailScmUserContext userContext, String goodsSupplierId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,goodsSupplierId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.copySupplyOrderFrom( supplyOrder );		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfSupplyOrder(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkTotalAmountOfSupplyOrder(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  GoodsSupplier updateSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, goodsSupplierId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsSupplier.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = goodsSupplier.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new GoodsSupplierManagerException(supplyOrder+"Not found" );
			}
			
			supplyOrder.changePropery(property, newValueExpr);

			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingAccountSet(RetailScmUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId,String [] tokensExpr) throws Exception{
		
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);

		checkNameOfAccountSet(userContext,  name, exception);
		checkYearSetOfAccountSet(userContext,  yearSet, exception);
		checkEffectiveDateOfAccountSet(userContext,  effectiveDate, exception);
		checkAccountingSystemOfAccountSet(userContext,  accountingSystem, exception);
		checkDomesticCurrencyCodeOfAccountSet(userContext,  domesticCurrencyCode, exception);
		checkDomesticCurrencyNameOfAccountSet(userContext,  domesticCurrencyName, exception);
		checkOpeningBankOfAccountSet(userContext,  openingBank, exception);
		checkAccountNumberOfAccountSet(userContext,  accountNumber, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  countryCenterId, exception);		
		
		checkIdOfRetailStore(userContext,  retailStoreId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  GoodsSupplier addAccountSet(RetailScmUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountSet(userContext,goodsSupplierId,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, retailStoreId,tokensExpr);
		
		AccountSet accountSet = createAccountSet(userContext,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, retailStoreId);
		
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.addAccountSet( accountSet );		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountSet createAccountSet(RetailScmUserContext userContext, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId) throws Exception{

		AccountSet accountSet = new AccountSet();
		
		
		accountSet.setName(name);		
		accountSet.setYearSet(yearSet);		
		accountSet.setEffectiveDate(effectiveDate);		
		accountSet.setAccountingSystem(accountingSystem);		
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);		
		accountSet.setDomesticCurrencyName(domesticCurrencyName);		
		accountSet.setOpeningBank(openingBank);		
		accountSet.setAccountNumber(accountNumber);		
		RetailStoreCountryCenter  countryCenter = new RetailStoreCountryCenter();
		countryCenter.setId(countryCenterId);		
		accountSet.setCountryCenter(countryCenter);		
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		accountSet.setRetailStore(retailStore);
	
		
		return accountSet;
	
		
	}
	
	protected AccountSet createIndexedAccountSet(String id, int version){

		AccountSet accountSet = new AccountSet();
		accountSet.setId(id);
		accountSet.setVersion(version);
		return accountSet;			
		
	}
	protected void checkParamsForRemovingAccountSet(RetailScmUserContext userContext, String goodsSupplierId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsSupplier removeAccountSet(RetailScmUserContext userContext, String goodsSupplierId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountSet(userContext,goodsSupplierId, accountSetId, accountSetVersion,tokensExpr);
		
		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.removeAccountSet( accountSet );		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountSet(RetailScmUserContext userContext, String goodsSupplierId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsSupplier copyAccountSetFrom(RetailScmUserContext userContext, String goodsSupplierId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountSet(userContext,goodsSupplierId, accountSetId, accountSetVersion,tokensExpr);
		
		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.copyAccountSetFrom( accountSet );		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountSet(RetailScmUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		GoodsSupplierManagerException exception = new GoodsSupplierManagerException("Error Occured");
		
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);
		

		if(AccountSet.NAME_PROPERTY.equals(property)){
			checkNameOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.YEAR_SET_PROPERTY.equals(property)){
			checkYearSetOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.EFFECTIVE_DATE_PROPERTY.equals(property)){
			checkEffectiveDateOfAccountSet(userContext, parseDate(newValueExpr), exception);
		}
		
		if(AccountSet.ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			checkAccountingSystemOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			checkDomesticCurrencyCodeOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			checkDomesticCurrencyNameOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.OPENING_BANK_PROPERTY.equals(property)){
			checkOpeningBankOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.ACCOUNT_NUMBER_PROPERTY.equals(property)){
			checkAccountNumberOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  GoodsSupplier updateAccountSet(RetailScmUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountSet(userContext, goodsSupplierId, accountSetId, accountSetVersion, property, newValueExpr,  tokensExpr);
		
		
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		
		synchronized(goodsSupplier){ 
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsSupplier.removeAccountSet( accountSet );	
			//make changes to AcceleraterAccount.
			AccountSet accountSetIndex = createIndexedAccountSet(accountSetId, accountSetVersion);
		
			AccountSet accountSet = goodsSupplier.findTheAccountSet(accountSetIndex);
			if(accountSet == null){
				throw new GoodsSupplierManagerException(accountSet+"Not found" );
			}
			
			accountSet.changePropery(property, newValueExpr);

			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


