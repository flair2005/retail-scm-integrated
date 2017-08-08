
package com.skynet.retailscm.productsupplyduration;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.supplierproduct.SupplierProduct;

import com.skynet.retailscm.supplierproduct.SupplierProductDAO;



import com.skynet.retailscm.supplierproduct.SupplierProductTable;




public class ProductSupplyDurationManagerImpl extends RetailScmCheckerManager implements ProductSupplyDurationManager {
	
	private static final String SERVICE_TYPE = "ProductSupplyDuration";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ProductSupplyDurationDAO  productSupplyDurationDAO;
 	public void setProductSupplyDurationDAO(ProductSupplyDurationDAO  productSupplyDurationDAO){
 	
 		if(productSupplyDurationDAO == null){
 			throw new IllegalStateException("Do not try to set productSupplyDurationDAO to null.");
 		}
	 	this.productSupplyDurationDAO = productSupplyDurationDAO;
 	}
 	public ProductSupplyDurationDAO getProductSupplyDurationDAO(){
 		if(this.productSupplyDurationDAO == null){
 			throw new IllegalStateException("The ProductSupplyDurationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productSupplyDurationDAO;
 	}
 	
 	protected ProductSupplyDuration saveProductSupplyDuration(RetailScmUserContext userContext, ProductSupplyDuration productSupplyDuration, String [] tokensExpr) throws Exception{	
 		//return getProductSupplyDurationDAO().save(productSupplyDuration, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProductSupplyDuration(userContext, productSupplyDuration, tokens);
 	}
 	
 	protected ProductSupplyDuration saveProductSupplyDurationDetail(RetailScmUserContext userContext, ProductSupplyDuration productSupplyDuration) throws Exception{	

 		
 		return saveProductSupplyDuration(userContext, productSupplyDuration, allTokens());
 	}
 	
 	public ProductSupplyDuration loadProductSupplyDuration(RetailScmUserContext userContext, String productSupplyDurationId, String [] tokensExpr) throws Exception{				
 
 		ProductSupplyDurationManagerException exception = new ProductSupplyDurationManagerException("Error Occured");
		
		checkIdOfProductSupplyDuration(userContext, productSupplyDurationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,productSupplyDuration, tokens);
 	}
 	
 	protected ProductSupplyDuration present(RetailScmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,productSupplyDuration,tokens);
		
		
		return this.getProductSupplyDurationDAO().present(productSupplyDuration, tokens);
	}
 
 	
 	
 	public ProductSupplyDuration loadProductSupplyDurationDetail(RetailScmUserContext userContext, String productSupplyDurationId) throws Exception{	
 		ProductSupplyDurationManagerException exception = new ProductSupplyDurationManagerException("Error Occured");
		
		checkIdOfProductSupplyDuration(userContext, productSupplyDurationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, allTokens());

 		return present(userContext,productSupplyDuration, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String productSupplyDurationId) throws Exception{	
 		ProductSupplyDurationManagerException exception = new ProductSupplyDurationManagerException("Error Occured");
		
		checkIdOfProductSupplyDuration(userContext, productSupplyDurationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration( userContext, productSupplyDurationId, allTokens());

 		return present(userContext,productSupplyDuration, allTokens());
		
 	}
 	protected ProductSupplyDuration saveProductSupplyDuration(RetailScmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String,Object>tokens) throws Exception{	
 		return getProductSupplyDurationDAO().save(productSupplyDuration, tokens);
 	}
 	protected ProductSupplyDuration loadProductSupplyDuration(RetailScmUserContext userContext, String productSupplyDurationId, Map<String,Object>tokens) throws Exception{	
 		return getProductSupplyDurationDAO().load(productSupplyDurationId, tokens);
 	}

	



 	 
 	
 	private  SupplierProductDAO  supplierProductDAO;
 	public void setSupplierProductDAO(SupplierProductDAO supplierProductDAO){
	 	this.supplierProductDAO = supplierProductDAO;
 	}
 	//------------------------------------
 	public SupplierProductDAO getSupplierProductDAO(){
	 	return this.supplierProductDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens){
		super.addActions(userContext, productSupplyDuration, tokens);
		
		addAction(userContext, productSupplyDuration, tokens,"@create","createProductSupplyDuration","createProductSupplyDuration/","main","primary");
		addAction(userContext, productSupplyDuration, tokens,"@update","updateProductSupplyDuration","updateProductSupplyDuration/"+productSupplyDuration.getId()+"/","main","primary");
		addAction(userContext, productSupplyDuration, tokens,"@copy","cloneProductSupplyDuration","cloneProductSupplyDuration/"+productSupplyDuration.getId()+"/","main","primary");
		
		addAction(userContext, productSupplyDuration, tokens,"product_supply_duration.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+productSupplyDuration.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ProductSupplyDuration createProductSupplyDuration(RetailScmUserContext userContext,int quantity, String duration, double price, String productId
) throws Exception
	{
		
		ProductSupplyDurationManagerException exception = new ProductSupplyDurationManagerException("Error Occured");

		

		checkQuantityOfProductSupplyDuration(userContext,  quantity, exception);
		checkDurationOfProductSupplyDuration(userContext,  duration, exception);
		checkPriceOfProductSupplyDuration(userContext,  price, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ProductSupplyDuration productSupplyDuration=createNewProductSupplyDuration();	

		productSupplyDuration.setQuantity(quantity);
		productSupplyDuration.setDuration(duration);
		productSupplyDuration.setPrice(price);
		SupplierProduct product = loadSupplierProduct(productId,emptyOptions());
		productSupplyDuration.setProduct(product);

		return saveProductSupplyDuration(userContext, productSupplyDuration, emptyOptions());
		

		
	}
	protected ProductSupplyDuration createNewProductSupplyDuration() 
	{
		
		return new ProductSupplyDuration();		
	}
	
	protected void checkParamsForUpdatingProductSupplyDuration(RetailScmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ProductSupplyDurationManagerException exception = new ProductSupplyDurationManagerException("Error Occured");
		
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
	
	
	
	public ProductSupplyDuration clone(RetailScmUserContext userContext, String fromProductSupplyDurationId) throws Exception{
		
		return this.getProductSupplyDurationDAO().clone(fromProductSupplyDurationId, this.allTokens());
	}
	
	public ProductSupplyDuration updateProductSupplyDuration(RetailScmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProductSupplyDuration(userContext, productSupplyDurationId, productSupplyDurationVersion, property, newValueExpr, tokensExpr);
		
		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());
		if(productSupplyDuration.getVersion() != productSupplyDurationVersion){
			String message = "The target version("+productSupplyDuration.getVersion()+") is not equals to version("+productSupplyDurationVersion+") provided";
			throw new ProductSupplyDurationManagerException(message);
		}
		synchronized(productSupplyDuration){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductSupplyDuration.
			
			productSupplyDuration.changePropery(property, newValueExpr);
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
			return present(userContext,productSupplyDuration, mergedAllTokens(tokensExpr));
			//return saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProductSupplyDurationTokens tokens(){
		return ProductSupplyDurationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProductSupplyDurationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductSupplyDurationTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherProduct(RetailScmUserContext userContext, String productSupplyDurationId, String anotherProductId) throws Exception
 	{
 		ProductSupplyDurationManagerException exception = new ProductSupplyDurationManagerException("Error Occured");
 		checkIdOfProductSupplyDuration(userContext, productSupplyDurationId,exception);
 		checkIdOfSupplierProduct(userContext, anotherProductId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ProductSupplyDuration transferToAnotherProduct(RetailScmUserContext userContext, String productSupplyDurationId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, productSupplyDurationId,anotherProductId);
 
		ProductSupplyDuration productSupplyDuration = loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());	
		synchronized(productSupplyDuration){
			//will be good when the productSupplyDuration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplierProduct product = loadSupplierProduct(anotherProductId, emptyOptions());		
			productSupplyDuration.setProduct(product);		
			productSupplyDuration = saveProductSupplyDuration(userContext, productSupplyDuration, emptyOptions());
			
			return present(userContext,productSupplyDuration, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected SupplierProduct loadSupplierProduct(String newProductId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplierProductDAO().load(newProductId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String productSupplyDurationId, int productSupplyDurationVersion) throws Exception {
		
		deleteInternal(userContext, productSupplyDurationId, productSupplyDurationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String productSupplyDurationId, int productSupplyDurationVersion) throws Exception{
		getProductSupplyDurationDAO().delete(productSupplyDurationId, productSupplyDurationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProductSupplyDurationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getProductSupplyDurationDAO().deleteAll();
	}


}


