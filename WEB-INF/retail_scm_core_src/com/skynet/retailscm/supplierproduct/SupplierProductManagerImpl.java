
package com.skynet.retailscm.supplierproduct;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.productsupplyduration.ProductSupplyDuration;

import com.skynet.retailscm.goodssupplier.GoodsSupplierDAO;

import com.skynet.retailscm.supplierproduct.SupplierProduct;


import com.skynet.retailscm.productsupplyduration.ProductSupplyDurationTable;
import com.skynet.retailscm.goodssupplier.GoodsSupplierTable;




public class SupplierProductManagerImpl extends RetailScmCheckerManager implements SupplierProductManager {
	
	private static final String SERVICE_TYPE = "SupplierProduct";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplierProductDAO  supplierProductDAO;
 	public void setSupplierProductDAO(SupplierProductDAO  supplierProductDAO){
 	
 		if(supplierProductDAO == null){
 			throw new IllegalStateException("Do not try to set supplierProductDAO to null.");
 		}
	 	this.supplierProductDAO = supplierProductDAO;
 	}
 	public SupplierProductDAO getSupplierProductDAO(){
 		if(this.supplierProductDAO == null){
 			throw new IllegalStateException("The SupplierProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplierProductDAO;
 	}
 	
 	protected SupplierProduct saveSupplierProduct(RetailScmUserContext userContext, SupplierProduct supplierProduct, String [] tokensExpr) throws Exception{	
 		//return getSupplierProductDAO().save(supplierProduct, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplierProduct(userContext, supplierProduct, tokens);
 	}
 	
 	protected SupplierProduct saveSupplierProductDetail(RetailScmUserContext userContext, SupplierProduct supplierProduct) throws Exception{	

 		
 		return saveSupplierProduct(userContext, supplierProduct, allTokens());
 	}
 	
 	public SupplierProduct loadSupplierProduct(RetailScmUserContext userContext, String supplierProductId, String [] tokensExpr) throws Exception{				
 
 		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");
		
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplierProduct supplierProduct = loadSupplierProduct( userContext, supplierProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierProduct, tokens);
 	}
 	
 	protected SupplierProduct present(RetailScmUserContext userContext, SupplierProduct supplierProduct, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplierProduct,tokens);
		
		
		return this.getSupplierProductDAO().present(supplierProduct, tokens);
	}
 
 	
 	
 	public SupplierProduct loadSupplierProductDetail(RetailScmUserContext userContext, String supplierProductId) throws Exception{	
 		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");
		
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplierProduct supplierProduct = loadSupplierProduct( userContext, supplierProductId, allTokens());

 		return present(userContext,supplierProduct, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplierProductId) throws Exception{	
 		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");
		
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplierProduct supplierProduct = loadSupplierProduct( userContext, supplierProductId, allTokens());

 		return present(userContext,supplierProduct, allTokens());
		
 	}
 	protected SupplierProduct saveSupplierProduct(RetailScmUserContext userContext, SupplierProduct supplierProduct, Map<String,Object>tokens) throws Exception{	
 		return getSupplierProductDAO().save(supplierProduct, tokens);
 	}
 	protected SupplierProduct loadSupplierProduct(RetailScmUserContext userContext, String supplierProductId, Map<String,Object>tokens) throws Exception{	
 		return getSupplierProductDAO().load(supplierProductId, tokens);
 	}

	



 	 
 	
 	private  GoodsSupplierDAO  goodsSupplierDAO;
 	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	//------------------------------------
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
	 	return this.goodsSupplierDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplierProduct supplierProduct, Map<String, Object> tokens){
		super.addActions(userContext, supplierProduct, tokens);
		
		addAction(userContext, supplierProduct, tokens,"@create","createSupplierProduct","createSupplierProduct/","main","primary");
		addAction(userContext, supplierProduct, tokens,"@update","updateSupplierProduct","updateSupplierProduct/"+supplierProduct.getId()+"/","main","primary");
		addAction(userContext, supplierProduct, tokens,"@copy","cloneSupplierProduct","cloneSupplierProduct/"+supplierProduct.getId()+"/","main","primary");
		
		addAction(userContext, supplierProduct, tokens,"supplier_product.transfer_to_supplier","transferToAnotherSupplier","transferToAnotherSupplier/"+supplierProduct.getId()+"/","main","primary");
		addAction(userContext, supplierProduct, tokens,"supplier_product.addProductSupplyDuration","addProductSupplyDuration","addProductSupplyDuration/"+supplierProduct.getId()+"/","productSupplyDurationList","primary");
		addAction(userContext, supplierProduct, tokens,"supplier_product.removeProductSupplyDuration","removeProductSupplyDuration","removeProductSupplyDuration/"+supplierProduct.getId()+"/","productSupplyDurationList","primary");
		addAction(userContext, supplierProduct, tokens,"supplier_product.updateProductSupplyDuration","updateProductSupplyDuration","updateProductSupplyDuration/"+supplierProduct.getId()+"/","productSupplyDurationList","primary");
		addAction(userContext, supplierProduct, tokens,"supplier_product.copyProductSupplyDurationFrom","copyProductSupplyDurationFrom","copyProductSupplyDurationFrom/"+supplierProduct.getId()+"/","productSupplyDurationList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplierProduct supplierProduct, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplierProduct createSupplierProduct(RetailScmUserContext userContext,String productName, String productDescription, String productUnit, String supplierId
) throws Exception
	{
		
		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");

		

		checkProductNameOfSupplierProduct(userContext,  productName, exception);
		checkProductDescriptionOfSupplierProduct(userContext,  productDescription, exception);
		checkProductUnitOfSupplierProduct(userContext,  productUnit, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplierProduct supplierProduct=createNewSupplierProduct();	

		supplierProduct.setProductName(productName);
		supplierProduct.setProductDescription(productDescription);
		supplierProduct.setProductUnit(productUnit);
		GoodsSupplier supplier = loadGoodsSupplier(supplierId,emptyOptions());
		supplierProduct.setSupplier(supplier);

		return saveSupplierProduct(userContext, supplierProduct, emptyOptions());
		

		
	}
	protected SupplierProduct createNewSupplierProduct() 
	{
		
		return new SupplierProduct();		
	}
	
	protected void checkParamsForUpdatingSupplierProduct(RetailScmUserContext userContext,String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");
		
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
	
	
	
	public SupplierProduct clone(RetailScmUserContext userContext, String fromSupplierProductId) throws Exception{
		
		return this.getSupplierProductDAO().clone(fromSupplierProductId, this.allTokens());
	}
	
	public SupplierProduct updateSupplierProduct(RetailScmUserContext userContext,String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplierProduct(userContext, supplierProductId, supplierProductVersion, property, newValueExpr, tokensExpr);
		
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
		if(supplierProduct.getVersion() != supplierProductVersion){
			String message = "The target version("+supplierProduct.getVersion()+") is not equals to version("+supplierProductVersion+") provided";
			throw new SupplierProductManagerException(message);
		}
		synchronized(supplierProduct){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplierProduct.
			
			supplierProduct.changePropery(property, newValueExpr);
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().done());
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
			//return saveSupplierProduct(userContext, supplierProduct, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplierProductTokens tokens(){
		return SupplierProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplierProductTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplierProductTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherSupplier(RetailScmUserContext userContext, String supplierProductId, String anotherSupplierId) throws Exception
 	{
 		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");
 		checkIdOfSupplierProduct(userContext, supplierProductId,exception);
 		checkIdOfGoodsSupplier(userContext, anotherSupplierId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SupplierProduct transferToAnotherSupplier(RetailScmUserContext userContext, String supplierProductId, String anotherSupplierId) throws Exception
 	{
 		checkParamsForTransferingAnotherSupplier(userContext, supplierProductId,anotherSupplierId);
 
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());	
		synchronized(supplierProduct){
			//will be good when the supplierProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsSupplier supplier = loadGoodsSupplier(anotherSupplierId, emptyOptions());		
			supplierProduct.setSupplier(supplier);		
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, emptyOptions());
			
			return present(userContext,supplierProduct, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected GoodsSupplier loadGoodsSupplier(String newSupplierId, Map<String,Object> options) throws Exception
 	{
		
 		return getGoodsSupplierDAO().load(newSupplierId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String supplierProductId, int supplierProductVersion) throws Exception {
		
		deleteInternal(userContext, supplierProductId, supplierProductVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplierProductId, int supplierProductVersion) throws Exception{
		getSupplierProductDAO().delete(supplierProductId, supplierProductVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplierProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplierProductDAO().deleteAll();
	}

	protected void checkParamsForAddingProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, int quantity, String duration, double price,String [] tokensExpr) throws Exception{
		
		

		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");
		
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);

		checkQuantityOfProductSupplyDuration(userContext,  quantity, exception);
		checkDurationOfProductSupplyDuration(userContext,  duration, exception);
		checkPriceOfProductSupplyDuration(userContext,  price, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplierProduct addProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, int quantity, String duration, double price, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProductSupplyDuration(userContext,supplierProductId,quantity, duration, price,tokensExpr);
		
		ProductSupplyDuration productSupplyDuration = createProductSupplyDuration(userContext,quantity, duration, price);
		
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
		synchronized(supplierProduct){ 
			//Will be good when the supplierProduct loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierProduct.addProductSupplyDuration( productSupplyDuration );		
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
		}
	}
	protected ProductSupplyDuration createProductSupplyDuration(RetailScmUserContext userContext, int quantity, String duration, double price) throws Exception{

		ProductSupplyDuration productSupplyDuration = new ProductSupplyDuration();
		
		
		productSupplyDuration.setQuantity(quantity);		
		productSupplyDuration.setDuration(duration);		
		productSupplyDuration.setPrice(price);
	
		
		return productSupplyDuration;
	
		
	}
	
	protected ProductSupplyDuration createIndexedProductSupplyDuration(String id, int version){

		ProductSupplyDuration productSupplyDuration = new ProductSupplyDuration();
		productSupplyDuration.setId(id);
		productSupplyDuration.setVersion(version);
		return productSupplyDuration;			
		
	}
	protected void checkParamsForRemovingProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, 
		String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr) throws Exception{
		

		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");
		
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);
		checkIdOfProductSupplyDuration(userContext, productSupplyDurationId, exception);
		checkVersionOfProductSupplyDuration(userContext, productSupplyDurationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplierProduct removeProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, 
		String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProductSupplyDuration(userContext,supplierProductId, productSupplyDurationId, productSupplyDurationVersion,tokensExpr);
		
		ProductSupplyDuration productSupplyDuration = createIndexedProductSupplyDuration(productSupplyDurationId, productSupplyDurationVersion);
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
		synchronized(supplierProduct){ 
			//Will be good when the supplierProduct loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierProduct.removeProductSupplyDuration( productSupplyDuration );		
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, 
		String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr) throws Exception{
		

		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");
		
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);
		checkIdOfProductSupplyDuration(userContext, productSupplyDurationId, exception);
		checkVersionOfProductSupplyDuration(userContext, productSupplyDurationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplierProduct copyProductSupplyDurationFrom(RetailScmUserContext userContext, String supplierProductId, 
		String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProductSupplyDuration(userContext,supplierProductId, productSupplyDurationId, productSupplyDurationVersion,tokensExpr);
		
		ProductSupplyDuration productSupplyDuration = createIndexedProductSupplyDuration(productSupplyDurationId, productSupplyDurationVersion);
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
		synchronized(supplierProduct){ 
			//Will be good when the supplierProduct loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierProduct.copyProductSupplyDurationFrom( productSupplyDuration );		
			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplierProductManagerException exception = new SupplierProductManagerException("Error Occured");
		
		checkIdOfSupplierProduct(userContext, supplierProductId, exception);
		checkIdOfProductSupplyDuration(userContext, productSupplyDurationId, exception);
		checkVersionOfProductSupplyDuration(userContext, productSupplyDurationVersion, exception);
		

		if(ProductSupplyDuration.QUANTITY_PROPERTY.equals(property)){
			checkQuantityOfProductSupplyDuration(userContext, parseInt(newValueExpr), exception);
		}
		
		if(ProductSupplyDuration.DURATION_PROPERTY.equals(property)){
			checkDurationOfProductSupplyDuration(userContext, parseString(newValueExpr), exception);
		}
		
		if(ProductSupplyDuration.PRICE_PROPERTY.equals(property)){
			checkPriceOfProductSupplyDuration(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplierProduct updateProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProductSupplyDuration(userContext, supplierProductId, productSupplyDurationId, productSupplyDurationVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, allTokens());
		
		synchronized(supplierProduct){ 
			//Will be good when the supplierProduct loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplierProduct.removeProductSupplyDuration( productSupplyDuration );	
			//make changes to AcceleraterAccount.
			ProductSupplyDuration productSupplyDurationIndex = createIndexedProductSupplyDuration(productSupplyDurationId, productSupplyDurationVersion);
		
			ProductSupplyDuration productSupplyDuration = supplierProduct.findTheProductSupplyDuration(productSupplyDurationIndex);
			if(productSupplyDuration == null){
				throw new SupplierProductManagerException(productSupplyDuration+"Not found" );
			}
			
			productSupplyDuration.changePropery(property, newValueExpr);

			supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
			return present(userContext,supplierProduct, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


