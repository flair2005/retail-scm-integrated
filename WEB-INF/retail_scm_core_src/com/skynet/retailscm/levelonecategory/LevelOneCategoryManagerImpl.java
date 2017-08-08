
package com.skynet.retailscm.levelonecategory;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.catalog.Catalog;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;

import com.skynet.retailscm.catalog.CatalogDAO;

import com.skynet.retailscm.levelonecategory.LevelOneCategory;


import com.skynet.retailscm.catalog.CatalogTable;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategoryTable;




public class LevelOneCategoryManagerImpl extends RetailScmCheckerManager implements LevelOneCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelOneCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  LevelOneCategoryDAO  levelOneCategoryDAO;
 	public void setLevelOneCategoryDAO(LevelOneCategoryDAO  levelOneCategoryDAO){
 	
 		if(levelOneCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelOneCategoryDAO to null.");
 		}
	 	this.levelOneCategoryDAO = levelOneCategoryDAO;
 	}
 	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
 		if(this.levelOneCategoryDAO == null){
 			throw new IllegalStateException("The LevelOneCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelOneCategoryDAO;
 	}
 	
 	protected LevelOneCategory saveLevelOneCategory(RetailScmUserContext userContext, LevelOneCategory levelOneCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelOneCategoryDAO().save(levelOneCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelOneCategory(userContext, levelOneCategory, tokens);
 	}
 	
 	protected LevelOneCategory saveLevelOneCategoryDetail(RetailScmUserContext userContext, LevelOneCategory levelOneCategory) throws Exception{	

 		
 		return saveLevelOneCategory(userContext, levelOneCategory, allTokens());
 	}
 	
 	public LevelOneCategory loadLevelOneCategory(RetailScmUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception{				
 
 		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");
		
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneCategory, tokens);
 	}
 	
 	protected LevelOneCategory present(RetailScmUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelOneCategory,tokens);
		
		
		return this.getLevelOneCategoryDAO().present(levelOneCategory, tokens);
	}
 
 	
 	
 	public LevelOneCategory loadLevelOneCategoryDetail(RetailScmUserContext userContext, String levelOneCategoryId) throws Exception{	
 		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");
		
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, allTokens());

 		return present(userContext,levelOneCategory, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String levelOneCategoryId) throws Exception{	
 		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");
		
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, allTokens());

 		return present(userContext,levelOneCategory, allTokens());
		
 	}
 	protected LevelOneCategory saveLevelOneCategory(RetailScmUserContext userContext, LevelOneCategory levelOneCategory, Map<String,Object>tokens) throws Exception{	
 		return getLevelOneCategoryDAO().save(levelOneCategory, tokens);
 	}
 	protected LevelOneCategory loadLevelOneCategory(RetailScmUserContext userContext, String levelOneCategoryId, Map<String,Object>tokens) throws Exception{	
 		return getLevelOneCategoryDAO().load(levelOneCategoryId, tokens);
 	}

	



 	 
 	
 	private  CatalogDAO  catalogDAO;
 	public void setCatalogDAO(CatalogDAO catalogDAO){
	 	this.catalogDAO = catalogDAO;
 	}
 	//------------------------------------
 	public CatalogDAO getCatalogDAO(){
	 	return this.catalogDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelOneCategory, tokens);
		
		addAction(userContext, levelOneCategory, tokens,"@create","createLevelOneCategory","createLevelOneCategory/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"@update","updateLevelOneCategory","updateLevelOneCategory/"+levelOneCategory.getId()+"/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"@copy","cloneLevelOneCategory","cloneLevelOneCategory/"+levelOneCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelOneCategory, tokens,"level_one_category.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+levelOneCategory.getId()+"/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.addLevelTwoCategory","addLevelTwoCategory","addLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.removeLevelTwoCategory","removeLevelTwoCategory","removeLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.updateLevelTwoCategory","updateLevelTwoCategory","updateLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.copyLevelTwoCategoryFrom","copyLevelTwoCategoryFrom","copyLevelTwoCategoryFrom/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelOneCategory createLevelOneCategory(RetailScmUserContext userContext,String catalogId, String displayName
) throws Exception
	{
		
		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");

		

		checkDisplayNameOfLevelOneCategory(userContext,  displayName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		LevelOneCategory levelOneCategory=createNewLevelOneCategory();	

		Catalog catalog = loadCatalog(catalogId,emptyOptions());
		levelOneCategory.setCatalog(catalog);
		levelOneCategory.setDisplayName(displayName);

		return saveLevelOneCategory(userContext, levelOneCategory, emptyOptions());
		

		
	}
	protected LevelOneCategory createNewLevelOneCategory() 
	{
		
		return new LevelOneCategory();		
	}
	
	protected void checkParamsForUpdatingLevelOneCategory(RetailScmUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");
		
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		checkVersionOfLevelOneCategory(userContext, levelOneCategoryVersion, exception);
		
		

		
		if(LevelOneCategory.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfLevelOneCategory(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public LevelOneCategory clone(RetailScmUserContext userContext, String fromLevelOneCategoryId) throws Exception{
		
		return this.getLevelOneCategoryDAO().clone(fromLevelOneCategoryId, this.allTokens());
	}
	
	public LevelOneCategory updateLevelOneCategory(RetailScmUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		if(levelOneCategory.getVersion() != levelOneCategoryVersion){
			String message = "The target version("+levelOneCategory.getVersion()+") is not equals to version("+levelOneCategoryVersion+") provided";
			throw new LevelOneCategoryManagerException(message);
		}
		synchronized(levelOneCategory){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.
			
			levelOneCategory.changePropery(property, newValueExpr);
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			//return saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelOneCategoryTokens tokens(){
		return LevelOneCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelOneCategoryTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelOneCategoryTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCatalog(RetailScmUserContext userContext, String levelOneCategoryId, String anotherCatalogId) throws Exception
 	{
 		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");
 		checkIdOfLevelOneCategory(userContext, levelOneCategoryId,exception);
 		checkIdOfCatalog(userContext, anotherCatalogId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public LevelOneCategory transferToAnotherCatalog(RetailScmUserContext userContext, String levelOneCategoryId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, levelOneCategoryId,anotherCatalogId);
 
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());	
		synchronized(levelOneCategory){
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(anotherCatalogId, emptyOptions());		
			levelOneCategory.setCatalog(catalog);		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, emptyOptions());
			
			return present(userContext,levelOneCategory, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Catalog loadCatalog(String newCatalogId, Map<String,Object> options) throws Exception
 	{
		
 		return getCatalogDAO().load(newCatalogId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String levelOneCategoryId, int levelOneCategoryVersion) throws Exception {
		
		deleteInternal(userContext, levelOneCategoryId, levelOneCategoryVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String levelOneCategoryId, int levelOneCategoryVersion) throws Exception{
		getLevelOneCategoryDAO().delete(levelOneCategoryId, levelOneCategoryVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelOneCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getLevelOneCategoryDAO().deleteAll();
	}

	protected void checkParamsForAddingLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, String displayName,String [] tokensExpr) throws Exception{
		
		

		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");
		
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);

		checkDisplayNameOfLevelTwoCategory(userContext,  displayName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  LevelOneCategory addLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, String displayName, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelTwoCategory(userContext,levelOneCategoryId,displayName,tokensExpr);
		
		LevelTwoCategory levelTwoCategory = createLevelTwoCategory(userContext,displayName);
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneCategory.addLevelTwoCategory( levelTwoCategory );		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected LevelTwoCategory createLevelTwoCategory(RetailScmUserContext userContext, String displayName) throws Exception{

		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		
		
		levelTwoCategory.setDisplayName(displayName);
	
		
		return levelTwoCategory;
	
		
	}
	
	protected LevelTwoCategory createIndexedLevelTwoCategory(String id, int version){

		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		levelTwoCategory.setId(id);
		levelTwoCategory.setVersion(version);
		return levelTwoCategory;			
		
	}
	protected void checkParamsForRemovingLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		

		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");
		
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		checkVersionOfLevelTwoCategory(userContext, levelTwoCategoryVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelOneCategory removeLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelTwoCategory(userContext,levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion,tokensExpr);
		
		LevelTwoCategory levelTwoCategory = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneCategory.removeLevelTwoCategory( levelTwoCategory );		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		

		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");
		
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		checkVersionOfLevelTwoCategory(userContext, levelTwoCategoryVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelOneCategory copyLevelTwoCategoryFrom(RetailScmUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelTwoCategory(userContext,levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion,tokensExpr);
		
		LevelTwoCategory levelTwoCategory = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneCategory.copyLevelTwoCategoryFrom( levelTwoCategory );		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		LevelOneCategoryManagerException exception = new LevelOneCategoryManagerException("Error Occured");
		
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		checkVersionOfLevelTwoCategory(userContext, levelTwoCategoryVersion, exception);
		

		if(LevelTwoCategory.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfLevelTwoCategory(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  LevelOneCategory updateLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelTwoCategory(userContext, levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr,  tokensExpr);
		
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelOneCategory.removeLevelTwoCategory( levelTwoCategory );	
			//make changes to AcceleraterAccount.
			LevelTwoCategory levelTwoCategoryIndex = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		
			LevelTwoCategory levelTwoCategory = levelOneCategory.findTheLevelTwoCategory(levelTwoCategoryIndex);
			if(levelTwoCategory == null){
				throw new LevelOneCategoryManagerException(levelTwoCategory+"Not found" );
			}
			
			levelTwoCategory.changePropery(property, newValueExpr);

			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


