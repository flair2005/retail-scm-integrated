
package com.skynet.retailscm.product;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;

import com.skynet.retailscm.levelthreecategory.LevelThreeCategoryDAO;

import com.skynet.retailscm.product.Product;


import com.skynet.retailscm.levelthreecategory.LevelThreeCategoryTable;
import com.skynet.retailscm.sku.SkuTable;




public class ProductManagerImpl extends RetailScmCheckerManager implements ProductManager {
	
	private static final String SERVICE_TYPE = "Product";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO  productDAO){
 	
 		if(productDAO == null){
 			throw new IllegalStateException("Do not try to set productDAO to null.");
 		}
	 	this.productDAO = productDAO;
 	}
 	public ProductDAO getProductDAO(){
 		if(this.productDAO == null){
 			throw new IllegalStateException("The ProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productDAO;
 	}
 	
 	protected Product saveProduct(RetailScmUserContext userContext, Product product, String [] tokensExpr) throws Exception{	
 		//return getProductDAO().save(product, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProduct(userContext, product, tokens);
 	}
 	
 	protected Product saveProductDetail(RetailScmUserContext userContext, Product product) throws Exception{	

 		
 		return saveProduct(userContext, product, allTokens());
 	}
 	
 	public Product loadProduct(RetailScmUserContext userContext, String productId, String [] tokensExpr) throws Exception{				
 
 		ProductManagerException exception = new ProductManagerException("Error Occured");
		
		checkIdOfProduct(userContext, productId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	protected Product present(RetailScmUserContext userContext, Product product, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,product,tokens);
		
		
		return this.getProductDAO().present(product, tokens);
	}
 
 	
 	
 	public Product loadProductDetail(RetailScmUserContext userContext, String productId) throws Exception{	
 		ProductManagerException exception = new ProductManagerException("Error Occured");
		
		checkIdOfProduct(userContext, productId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Product product = loadProduct( userContext, productId, allTokens());

 		return present(userContext,product, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String productId) throws Exception{	
 		ProductManagerException exception = new ProductManagerException("Error Occured");
		
		checkIdOfProduct(userContext, productId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Product product = loadProduct( userContext, productId, allTokens());

 		return present(userContext,product, allTokens());
		
 	}
 	protected Product saveProduct(RetailScmUserContext userContext, Product product, Map<String,Object>tokens) throws Exception{	
 		return getProductDAO().save(product, tokens);
 	}
 	protected Product loadProduct(RetailScmUserContext userContext, String productId, Map<String,Object>tokens) throws Exception{	
 		return getProductDAO().load(productId, tokens);
 	}

	



 	 
 	
 	private  LevelThreeCategoryDAO  levelThreeCategoryDAO;
 	public void setLevelThreeCategoryDAO(LevelThreeCategoryDAO levelThreeCategoryDAO){
	 	this.levelThreeCategoryDAO = levelThreeCategoryDAO;
 	}
 	//------------------------------------
 	public LevelThreeCategoryDAO getLevelThreeCategoryDAO(){
	 	return this.levelThreeCategoryDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Product product, Map<String, Object> tokens){
		super.addActions(userContext, product, tokens);
		
		addAction(userContext, product, tokens,"@create","createProduct","createProduct/","main","primary");
		addAction(userContext, product, tokens,"@update","updateProduct","updateProduct/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"@copy","cloneProduct","cloneProduct/"+product.getId()+"/","main","primary");
		
		addAction(userContext, product, tokens,"product.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.addSku","addSku","addSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.removeSku","removeSku","removeSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.updateSku","updateSku","updateSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.copySkuFrom","copySkuFrom","copySkuFrom/"+product.getId()+"/","skuList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Product product, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Product createProduct(RetailScmUserContext userContext,String displayName, String parentCategoryId, String origin, String remark, String brand, String picture
) throws Exception
	{
		
		ProductManagerException exception = new ProductManagerException("Error Occured");

		

		checkDisplayNameOfProduct(userContext,  displayName, exception);
		checkOriginOfProduct(userContext,  origin, exception);
		checkRemarkOfProduct(userContext,  remark, exception);
		checkBrandOfProduct(userContext,  brand, exception);
		checkPictureOfProduct(userContext,  picture, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Product product=createNewProduct();	

		product.setDisplayName(displayName);
		LevelThreeCategory parentCategory = loadLevelThreeCategory(parentCategoryId,emptyOptions());
		product.setParentCategory(parentCategory);
		product.setOrigin(origin);
		product.setRemark(remark);
		product.setBrand(brand);
		product.setPicture(picture);

		return saveProduct(userContext, product, emptyOptions());
		

		
	}
	protected Product createNewProduct() 
	{
		
		return new Product();		
	}
	
	protected void checkParamsForUpdatingProduct(RetailScmUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ProductManagerException exception = new ProductManagerException("Error Occured");
		
		checkIdOfProduct(userContext, productId, exception);
		checkVersionOfProduct(userContext, productVersion, exception);
		

		if(Product.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfProduct(userContext, parseString(newValueExpr), exception);
		}		

		
		if(Product.ORIGIN_PROPERTY.equals(property)){
			checkOriginOfProduct(userContext, parseString(newValueExpr), exception);
		}
		if(Product.REMARK_PROPERTY.equals(property)){
			checkRemarkOfProduct(userContext, parseString(newValueExpr), exception);
		}
		if(Product.BRAND_PROPERTY.equals(property)){
			checkBrandOfProduct(userContext, parseString(newValueExpr), exception);
		}
		if(Product.PICTURE_PROPERTY.equals(property)){
			checkPictureOfProduct(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public Product clone(RetailScmUserContext userContext, String fromProductId) throws Exception{
		
		return this.getProductDAO().clone(fromProductId, this.allTokens());
	}
	
	public Product updateProduct(RetailScmUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		Product product = loadProduct(userContext, productId, allTokens());
		if(product.getVersion() != productVersion){
			String message = "The target version("+product.getVersion()+") is not equals to version("+productVersion+") provided";
			throw new ProductManagerException(message);
		}
		synchronized(product){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			product.changePropery(property, newValueExpr);
			product = saveProduct(userContext, product, tokens().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
			//return saveProduct(userContext, product, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProductTokens tokens(){
		return ProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProductTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherParentCategory(RetailScmUserContext userContext, String productId, String anotherParentCategoryId) throws Exception
 	{
 		ProductManagerException exception = new ProductManagerException("Error Occured");
 		checkIdOfProduct(userContext, productId,exception);
 		checkIdOfLevelThreeCategory(userContext, anotherParentCategoryId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Product transferToAnotherParentCategory(RetailScmUserContext userContext, String productId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, productId,anotherParentCategoryId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelThreeCategory parentCategory = loadLevelThreeCategory(anotherParentCategoryId, emptyOptions());		
			product.setParentCategory(parentCategory);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelThreeCategory loadLevelThreeCategory(String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return getLevelThreeCategoryDAO().load(newParentCategoryId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String productId, int productVersion) throws Exception {
		
		deleteInternal(userContext, productId, productVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String productId, int productVersion) throws Exception{
		getProductDAO().delete(productId, productVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getProductDAO().deleteAll();
	}

	protected void checkParamsForAddingSku(RetailScmUserContext userContext, String productId, String displayName, String size, String barcode, String packageType, String netContent, double price, String picture,String [] tokensExpr) throws Exception{
		
		

		ProductManagerException exception = new ProductManagerException("Error Occured");
		
		checkIdOfProduct(userContext, productId, exception);

		checkDisplayNameOfSku(userContext,  displayName, exception);
		checkSizeOfSku(userContext,  size, exception);
		checkBarcodeOfSku(userContext,  barcode, exception);
		checkPackageTypeOfSku(userContext,  packageType, exception);
		checkNetContentOfSku(userContext,  netContent, exception);
		checkPriceOfSku(userContext,  price, exception);
		checkPictureOfSku(userContext,  picture, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Product addSku(RetailScmUserContext userContext, String productId, String displayName, String size, String barcode, String packageType, String netContent, double price, String picture, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSku(userContext,productId,displayName, size, barcode, packageType, netContent, price, picture,tokensExpr);
		
		Sku sku = createSku(userContext,displayName, size, barcode, packageType, netContent, price, picture);
		
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.addSku( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	protected Sku createSku(RetailScmUserContext userContext, String displayName, String size, String barcode, String packageType, String netContent, double price, String picture) throws Exception{

		Sku sku = new Sku();
		
		
		sku.setDisplayName(displayName);		
		sku.setSize(size);		
		sku.setBarcode(barcode);		
		sku.setPackageType(packageType);		
		sku.setNetContent(netContent);		
		sku.setPrice(price);		
		sku.setPicture(picture);
	
		
		return sku;
	
		
	}
	
	protected Sku createIndexedSku(String id, int version){

		Sku sku = new Sku();
		sku.setId(id);
		sku.setVersion(version);
		return sku;			
		
	}
	protected void checkParamsForRemovingSku(RetailScmUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		

		ProductManagerException exception = new ProductManagerException("Error Occured");
		
		checkIdOfProduct(userContext, productId, exception);
		checkIdOfSku(userContext, skuId, exception);
		checkVersionOfSku(userContext, skuVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Product removeSku(RetailScmUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSku(userContext,productId, skuId, skuVersion,tokensExpr);
		
		Sku sku = createIndexedSku(skuId, skuVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.removeSku( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSku(RetailScmUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		

		ProductManagerException exception = new ProductManagerException("Error Occured");
		
		checkIdOfProduct(userContext, productId, exception);
		checkIdOfSku(userContext, skuId, exception);
		checkVersionOfSku(userContext, skuVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Product copySkuFrom(RetailScmUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSku(userContext,productId, skuId, skuVersion,tokensExpr);
		
		Sku sku = createIndexedSku(skuId, skuVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.copySkuFrom( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSku(RetailScmUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ProductManagerException exception = new ProductManagerException("Error Occured");
		
		checkIdOfProduct(userContext, productId, exception);
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
	
	public  Product updateSku(RetailScmUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSku(userContext, productId, skuId, skuVersion, property, newValueExpr,  tokensExpr);
		
		
		Product product = loadProduct(userContext, productId, allTokens());
		
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//product.removeSku( sku );	
			//make changes to AcceleraterAccount.
			Sku skuIndex = createIndexedSku(skuId, skuVersion);
		
			Sku sku = product.findTheSku(skuIndex);
			if(sku == null){
				throw new ProductManagerException(sku+"Not found" );
			}
			
			sku.changePropery(property, newValueExpr);

			product = saveProduct(userContext, product, tokens().withSkuList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


