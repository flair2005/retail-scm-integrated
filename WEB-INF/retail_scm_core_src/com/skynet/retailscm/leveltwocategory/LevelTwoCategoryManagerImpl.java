
package com.skynet.retailscm.leveltwocategory;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.levelonecategory.LevelOneCategory;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;

import com.skynet.retailscm.levelonecategory.LevelOneCategoryDAO;

import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;


import com.skynet.retailscm.levelthreecategory.LevelThreeCategoryTable;
import com.skynet.retailscm.levelonecategory.LevelOneCategoryTable;




public class LevelTwoCategoryManagerImpl extends RetailScmCheckerManager implements LevelTwoCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelTwoCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  LevelTwoCategoryDAO  levelTwoCategoryDAO;
 	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO  levelTwoCategoryDAO){
 	
 		if(levelTwoCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelTwoCategoryDAO to null.");
 		}
	 	this.levelTwoCategoryDAO = levelTwoCategoryDAO;
 	}
 	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
 		if(this.levelTwoCategoryDAO == null){
 			throw new IllegalStateException("The LevelTwoCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelTwoCategoryDAO;
 	}
 	
 	protected LevelTwoCategory saveLevelTwoCategory(RetailScmUserContext userContext, LevelTwoCategory levelTwoCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelTwoCategoryDAO().save(levelTwoCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelTwoCategory(userContext, levelTwoCategory, tokens);
 	}
 	
 	protected LevelTwoCategory saveLevelTwoCategoryDetail(RetailScmUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception{	

 		
 		return saveLevelTwoCategory(userContext, levelTwoCategory, allTokens());
 	}
 	
 	public LevelTwoCategory loadLevelTwoCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String [] tokensExpr) throws Exception{				
 
 		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");
		
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoCategory, tokens);
 	}
 	
 	protected LevelTwoCategory present(RetailScmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelTwoCategory,tokens);
		
		
		return this.getLevelTwoCategoryDAO().present(levelTwoCategory, tokens);
	}
 
 	
 	
 	public LevelTwoCategory loadLevelTwoCategoryDetail(RetailScmUserContext userContext, String levelTwoCategoryId) throws Exception{	
 		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");
		
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, allTokens());

 		return present(userContext,levelTwoCategory, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String levelTwoCategoryId) throws Exception{	
 		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");
		
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, allTokens());

 		return present(userContext,levelTwoCategory, allTokens());
		
 	}
 	protected LevelTwoCategory saveLevelTwoCategory(RetailScmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String,Object>tokens) throws Exception{	
 		return getLevelTwoCategoryDAO().save(levelTwoCategory, tokens);
 	}
 	protected LevelTwoCategory loadLevelTwoCategory(RetailScmUserContext userContext, String levelTwoCategoryId, Map<String,Object>tokens) throws Exception{	
 		return getLevelTwoCategoryDAO().load(levelTwoCategoryId, tokens);
 	}

	



 	 
 	
 	private  LevelOneCategoryDAO  levelOneCategoryDAO;
 	public void setLevelOneCategoryDAO(LevelOneCategoryDAO levelOneCategoryDAO){
	 	this.levelOneCategoryDAO = levelOneCategoryDAO;
 	}
 	//------------------------------------
 	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
	 	return this.levelOneCategoryDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelTwoCategory, tokens);
		
		addAction(userContext, levelTwoCategory, tokens,"@create","createLevelTwoCategory","createLevelTwoCategory/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"@update","updateLevelTwoCategory","updateLevelTwoCategory/"+levelTwoCategory.getId()+"/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"@copy","cloneLevelTwoCategory","cloneLevelTwoCategory/"+levelTwoCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+levelTwoCategory.getId()+"/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.addLevelThreeCategory","addLevelThreeCategory","addLevelThreeCategory/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.removeLevelThreeCategory","removeLevelThreeCategory","removeLevelThreeCategory/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.updateLevelThreeCategory","updateLevelThreeCategory","updateLevelThreeCategory/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.copyLevelThreeCategoryFrom","copyLevelThreeCategoryFrom","copyLevelThreeCategoryFrom/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelTwoCategory createLevelTwoCategory(RetailScmUserContext userContext,String parentCategoryId, String displayName
) throws Exception
	{
		
		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");

		

		checkDisplayNameOfLevelTwoCategory(userContext,  displayName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		LevelTwoCategory levelTwoCategory=createNewLevelTwoCategory();	

		LevelOneCategory parentCategory = loadLevelOneCategory(parentCategoryId,emptyOptions());
		levelTwoCategory.setParentCategory(parentCategory);
		levelTwoCategory.setDisplayName(displayName);

		return saveLevelTwoCategory(userContext, levelTwoCategory, emptyOptions());
		

		
	}
	protected LevelTwoCategory createNewLevelTwoCategory() 
	{
		
		return new LevelTwoCategory();		
	}
	
	protected void checkParamsForUpdatingLevelTwoCategory(RetailScmUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");
		
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		checkVersionOfLevelTwoCategory(userContext, levelTwoCategoryVersion, exception);
		
		

		
		if(LevelTwoCategory.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfLevelTwoCategory(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public LevelTwoCategory clone(RetailScmUserContext userContext, String fromLevelTwoCategoryId) throws Exception{
		
		return this.getLevelTwoCategoryDAO().clone(fromLevelTwoCategoryId, this.allTokens());
	}
	
	public LevelTwoCategory updateLevelTwoCategory(RetailScmUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		if(levelTwoCategory.getVersion() != levelTwoCategoryVersion){
			String message = "The target version("+levelTwoCategory.getVersion()+") is not equals to version("+levelTwoCategoryVersion+") provided";
			throw new LevelTwoCategoryManagerException(message);
		}
		synchronized(levelTwoCategory){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.
			
			levelTwoCategory.changePropery(property, newValueExpr);
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			//return saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelTwoCategoryTokens tokens(){
		return LevelTwoCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelTwoCategoryTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelTwoCategoryTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherParentCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");
 		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId,exception);
 		checkIdOfLevelOneCategory(userContext, anotherParentCategoryId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public LevelTwoCategory transferToAnotherParentCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, levelTwoCategoryId,anotherParentCategoryId);
 
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());	
		synchronized(levelTwoCategory){
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelOneCategory parentCategory = loadLevelOneCategory(anotherParentCategoryId, emptyOptions());		
			levelTwoCategory.setParentCategory(parentCategory);		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, emptyOptions());
			
			return present(userContext,levelTwoCategory, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelOneCategory loadLevelOneCategory(String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return getLevelOneCategoryDAO().load(newParentCategoryId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception {
		
		deleteInternal(userContext, levelTwoCategoryId, levelTwoCategoryVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception{
		getLevelTwoCategoryDAO().delete(levelTwoCategoryId, levelTwoCategoryVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelTwoCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getLevelTwoCategoryDAO().deleteAll();
	}

	protected void checkParamsForAddingLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String displayName,String [] tokensExpr) throws Exception{
		
		

		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");
		
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);

		checkDisplayNameOfLevelThreeCategory(userContext,  displayName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  LevelTwoCategory addLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String displayName, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelThreeCategory(userContext,levelTwoCategoryId,displayName,tokensExpr);
		
		LevelThreeCategory levelThreeCategory = createLevelThreeCategory(userContext,displayName);
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoCategory.addLevelThreeCategory( levelThreeCategory );		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected LevelThreeCategory createLevelThreeCategory(RetailScmUserContext userContext, String displayName) throws Exception{

		LevelThreeCategory levelThreeCategory = new LevelThreeCategory();
		
		
		levelThreeCategory.setDisplayName(displayName);
	
		
		return levelThreeCategory;
	
		
	}
	
	protected LevelThreeCategory createIndexedLevelThreeCategory(String id, int version){

		LevelThreeCategory levelThreeCategory = new LevelThreeCategory();
		levelThreeCategory.setId(id);
		levelThreeCategory.setVersion(version);
		return levelThreeCategory;			
		
	}
	protected void checkParamsForRemovingLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, 
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		

		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");
		
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
		checkVersionOfLevelThreeCategory(userContext, levelThreeCategoryVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelTwoCategory removeLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, 
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelThreeCategory(userContext,levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion,tokensExpr);
		
		LevelThreeCategory levelThreeCategory = createIndexedLevelThreeCategory(levelThreeCategoryId, levelThreeCategoryVersion);
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoCategory.removeLevelThreeCategory( levelThreeCategory );		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, 
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		

		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");
		
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
		checkVersionOfLevelThreeCategory(userContext, levelThreeCategoryVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelTwoCategory copyLevelThreeCategoryFrom(RetailScmUserContext userContext, String levelTwoCategoryId, 
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelThreeCategory(userContext,levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion,tokensExpr);
		
		LevelThreeCategory levelThreeCategory = createIndexedLevelThreeCategory(levelThreeCategoryId, levelThreeCategoryVersion);
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoCategory.copyLevelThreeCategoryFrom( levelThreeCategory );		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		LevelTwoCategoryManagerException exception = new LevelTwoCategoryManagerException("Error Occured");
		
		checkIdOfLevelTwoCategory(userContext, levelTwoCategoryId, exception);
		checkIdOfLevelThreeCategory(userContext, levelThreeCategoryId, exception);
		checkVersionOfLevelThreeCategory(userContext, levelThreeCategoryVersion, exception);
		

		if(LevelThreeCategory.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfLevelThreeCategory(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  LevelTwoCategory updateLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelThreeCategory(userContext, levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion, property, newValueExpr,  tokensExpr);
		
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelTwoCategory.removeLevelThreeCategory( levelThreeCategory );	
			//make changes to AcceleraterAccount.
			LevelThreeCategory levelThreeCategoryIndex = createIndexedLevelThreeCategory(levelThreeCategoryId, levelThreeCategoryVersion);
		
			LevelThreeCategory levelThreeCategory = levelTwoCategory.findTheLevelThreeCategory(levelThreeCategoryIndex);
			if(levelThreeCategory == null){
				throw new LevelTwoCategoryManagerException(levelThreeCategory+"Not found" );
			}
			
			levelThreeCategory.changePropery(property, newValueExpr);

			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


