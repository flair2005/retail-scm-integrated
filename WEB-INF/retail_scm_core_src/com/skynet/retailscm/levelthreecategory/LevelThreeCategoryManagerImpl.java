
package com.skynet.retailscm.levelthreecategory;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;

import com.skynet.retailscm.leveltwocategory.LevelTwoCategoryDAO;

import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;


import com.skynet.retailscm.leveltwocategory.LevelTwoCategoryTable;
import com.skynet.retailscm.product.ProductTable;




public class LevelThreeCategoryManagerImpl extends RetailScmCheckerManager implements LevelThreeCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelThreeCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  LevelThreeCategoryDAO  levelThreeCategoryDAO;
 	public void setLevelThreeCategoryDAO(LevelThreeCategoryDAO  levelThreeCategoryDAO){
 	
 		if(levelThreeCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelThreeCategoryDAO to null.");
 		}
	 	this.levelThreeCategoryDAO = levelThreeCategoryDAO;
 	}
 	public LevelThreeCategoryDAO getLevelThreeCategoryDAO(){
 		if(this.levelThreeCategoryDAO == null){
 			throw new IllegalStateException("The LevelThreeCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelThreeCategoryDAO;
 	}
 	
 	protected LevelThreeCategory saveLevelThreeCategory(RetailScmUserContext userContext, LevelThreeCategory levelThreeCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelThreeCategoryDAO().save(levelThreeCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelThreeCategory(userContext, levelThreeCategory, tokens);
 	}
 	
 	protected LevelThreeCategory saveLevelThreeCategoryDetail(RetailScmUserContext userContext, LevelThreeCategory levelThreeCategory) throws Exception{	

 		
 		return saveLevelThreeCategory(userContext, levelThreeCategory, allTokens());
 	}
 	
 	public LevelThreeCategory loadLevelThreeCategory(RetailScmUserContext userContext, String levelThreeCategoryId, String [] tokensExpr) throws Exception{				
 
 		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");
		
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory( userContext, levelThreeCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeCategory, tokens);
 	}
 	
 	protected LevelThreeCategory present(RetailScmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelThreeCategory,tokens);
		
		
		return this.getLevelThreeCategoryDAO().present(levelThreeCategory, tokens);
	}
 
 	
 	
 	public LevelThreeCategory loadLevelThreeCategoryDetail(RetailScmUserContext userContext, String levelThreeCategoryId) throws Exception{	
 		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");
		
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory( userContext, levelThreeCategoryId, allTokens());

 		return present(userContext,levelThreeCategory, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String levelThreeCategoryId) throws Exception{	
 		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");
		
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory( userContext, levelThreeCategoryId, allTokens());

 		return present(userContext,levelThreeCategory, allTokens());
		
 	}
 	protected LevelThreeCategory saveLevelThreeCategory(RetailScmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String,Object>tokens) throws Exception{	
 		return getLevelThreeCategoryDAO().save(levelThreeCategory, tokens);
 	}
 	protected LevelThreeCategory loadLevelThreeCategory(RetailScmUserContext userContext, String levelThreeCategoryId, Map<String,Object>tokens) throws Exception{	
 		return getLevelThreeCategoryDAO().load(levelThreeCategoryId, tokens);
 	}

	



 	 
 	
 	private  LevelTwoCategoryDAO  levelTwoCategoryDAO;
 	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO levelTwoCategoryDAO){
	 	this.levelTwoCategoryDAO = levelTwoCategoryDAO;
 	}
 	//------------------------------------
 	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
	 	return this.levelTwoCategoryDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelThreeCategory, tokens);
		
		addAction(userContext, levelThreeCategory, tokens,"@create","createLevelThreeCategory","createLevelThreeCategory/","main","primary");
		addAction(userContext, levelThreeCategory, tokens,"@update","updateLevelThreeCategory","updateLevelThreeCategory/"+levelThreeCategory.getId()+"/","main","primary");
		addAction(userContext, levelThreeCategory, tokens,"@copy","cloneLevelThreeCategory","cloneLevelThreeCategory/"+levelThreeCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+levelThreeCategory.getId()+"/","main","primary");
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.addProduct","addProduct","addProduct/"+levelThreeCategory.getId()+"/","productList","primary");
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.removeProduct","removeProduct","removeProduct/"+levelThreeCategory.getId()+"/","productList","primary");
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.updateProduct","updateProduct","updateProduct/"+levelThreeCategory.getId()+"/","productList","primary");
		addAction(userContext, levelThreeCategory, tokens,"level_three_category.copyProductFrom","copyProductFrom","copyProductFrom/"+levelThreeCategory.getId()+"/","productList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelThreeCategory levelThreeCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelThreeCategory createLevelThreeCategory(RetailScmUserContext userContext,String parentCategoryId, String displayName
) throws Exception
	{
		
		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");

		

		checkDisplayNameOfLevelThreeCategory(userContext,  displayName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		LevelThreeCategory levelThreeCategory=createNewLevelThreeCategory();	

		LevelTwoCategory parentCategory = loadLevelTwoCategory(parentCategoryId,emptyOptions());
		levelThreeCategory.setParentCategory(parentCategory);
		levelThreeCategory.setDisplayName(displayName);

		return saveLevelThreeCategory(userContext, levelThreeCategory, emptyOptions());
		

		
	}
	protected LevelThreeCategory createNewLevelThreeCategory() 
	{
		
		return new LevelThreeCategory();		
	}
	
	protected void checkParamsForUpdatingLevelThreeCategory(RetailScmUserContext userContext,String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");
		
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
		checkVersionOfLevelThreeCategory(userContext, levelThreeCategoryVersion, exception);
		
		

		
		if(LevelThreeCategory.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfLevelThreeCategory(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public LevelThreeCategory clone(RetailScmUserContext userContext, String fromLevelThreeCategoryId) throws Exception{
		
		return this.getLevelThreeCategoryDAO().clone(fromLevelThreeCategoryId, this.allTokens());
	}
	
	public LevelThreeCategory updateLevelThreeCategory(RetailScmUserContext userContext,String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelThreeCategory(userContext, levelThreeCategoryId, levelThreeCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		if(levelThreeCategory.getVersion() != levelThreeCategoryVersion){
			String message = "The target version("+levelThreeCategory.getVersion()+") is not equals to version("+levelThreeCategoryVersion+") provided";
			throw new LevelThreeCategoryManagerException(message);
		}
		synchronized(levelThreeCategory){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeCategory.
			
			levelThreeCategory.changePropery(property, newValueExpr);
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().done());
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
			//return saveLevelThreeCategory(userContext, levelThreeCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelThreeCategoryTokens tokens(){
		return LevelThreeCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelThreeCategoryTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelThreeCategoryTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherParentCategory(RetailScmUserContext userContext, String levelThreeCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");
 		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId,exception);
 		checkIdOfLevelTwoCategory(userContext, anotherParentCategoryId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public LevelThreeCategory transferToAnotherParentCategory(RetailScmUserContext userContext, String levelThreeCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, levelThreeCategoryId,anotherParentCategoryId);
 
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());	
		synchronized(levelThreeCategory){
			//will be good when the levelThreeCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelTwoCategory parentCategory = loadLevelTwoCategory(anotherParentCategoryId, emptyOptions());		
			levelThreeCategory.setParentCategory(parentCategory);		
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, emptyOptions());
			
			return present(userContext,levelThreeCategory, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelTwoCategory loadLevelTwoCategory(String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return getLevelTwoCategoryDAO().load(newParentCategoryId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception {
		
		deleteInternal(userContext, levelThreeCategoryId, levelThreeCategoryVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String levelThreeCategoryId, int levelThreeCategoryVersion) throws Exception{
		getLevelThreeCategoryDAO().delete(levelThreeCategoryId, levelThreeCategoryVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelThreeCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getLevelThreeCategoryDAO().deleteAll();
	}

	protected void checkParamsForAddingProduct(RetailScmUserContext userContext, String levelThreeCategoryId, String displayName, String origin, String remark, String brand, String picture,String [] tokensExpr) throws Exception{
		
		

		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");
		
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);

		checkDisplayNameOfProduct(userContext,  displayName, exception);
		checkOriginOfProduct(userContext,  origin, exception);
		checkRemarkOfProduct(userContext,  remark, exception);
		checkBrandOfProduct(userContext,  brand, exception);
		checkPictureOfProduct(userContext,  picture, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  LevelThreeCategory addProduct(RetailScmUserContext userContext, String levelThreeCategoryId, String displayName, String origin, String remark, String brand, String picture, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,levelThreeCategoryId,displayName, origin, remark, brand, picture,tokensExpr);
		
		Product product = createProduct(userContext,displayName, origin, remark, brand, picture);
		
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		synchronized(levelThreeCategory){ 
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeCategory.addProduct( product );		
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected Product createProduct(RetailScmUserContext userContext, String displayName, String origin, String remark, String brand, String picture) throws Exception{

		Product product = new Product();
		
		
		product.setDisplayName(displayName);		
		product.setOrigin(origin);		
		product.setRemark(remark);		
		product.setBrand(brand);		
		product.setPicture(picture);
	
		
		return product;
	
		
	}
	
	protected Product createIndexedProduct(String id, int version){

		Product product = new Product();
		product.setId(id);
		product.setVersion(version);
		return product;			
		
	}
	protected void checkParamsForRemovingProduct(RetailScmUserContext userContext, String levelThreeCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		

		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");
		
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
		checkIdOfProduct(userContext, productId, exception);
		checkVersionOfProduct(userContext, productVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelThreeCategory removeProduct(RetailScmUserContext userContext, String levelThreeCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,levelThreeCategoryId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		synchronized(levelThreeCategory){ 
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeCategory.removeProduct( product );		
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingProduct(RetailScmUserContext userContext, String levelThreeCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		

		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");
		
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
		checkIdOfProduct(userContext, productId, exception);
		checkVersionOfProduct(userContext, productVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelThreeCategory copyProductFrom(RetailScmUserContext userContext, String levelThreeCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,levelThreeCategoryId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		synchronized(levelThreeCategory){ 
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeCategory.copyProductFrom( product );		
			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingProduct(RetailScmUserContext userContext, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		LevelThreeCategoryManagerException exception = new LevelThreeCategoryManagerException("Error Occured");
		
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
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
	
	public  LevelThreeCategory updateProduct(RetailScmUserContext userContext, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, levelThreeCategoryId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		
		LevelThreeCategory levelThreeCategory = loadLevelThreeCategory(userContext, levelThreeCategoryId, allTokens());
		
		synchronized(levelThreeCategory){ 
			//Will be good when the levelThreeCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelThreeCategory.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = levelThreeCategory.findTheProduct(productIndex);
			if(product == null){
				throw new LevelThreeCategoryManagerException(product+"Not found" );
			}
			
			product.changePropery(property, newValueExpr);

			levelThreeCategory = saveLevelThreeCategory(userContext, levelThreeCategory, tokens().withProductList().done());
			return present(userContext,levelThreeCategory, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


