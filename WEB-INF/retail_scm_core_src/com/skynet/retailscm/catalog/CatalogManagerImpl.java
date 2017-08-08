
package com.skynet.retailscm.catalog;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.levelonecategory.LevelOneCategory;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.catalog.Catalog;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.levelonecategory.LevelOneCategoryTable;




public class CatalogManagerImpl extends RetailScmCheckerManager implements CatalogManager {
	
	private static final String SERVICE_TYPE = "Catalog";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  CatalogDAO  catalogDAO;
 	public void setCatalogDAO(CatalogDAO  catalogDAO){
 	
 		if(catalogDAO == null){
 			throw new IllegalStateException("Do not try to set catalogDAO to null.");
 		}
	 	this.catalogDAO = catalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
 		if(this.catalogDAO == null){
 			throw new IllegalStateException("The CatalogDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.catalogDAO;
 	}
 	
 	protected Catalog saveCatalog(RetailScmUserContext userContext, Catalog catalog, String [] tokensExpr) throws Exception{	
 		//return getCatalogDAO().save(catalog, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCatalog(userContext, catalog, tokens);
 	}
 	
 	protected Catalog saveCatalogDetail(RetailScmUserContext userContext, Catalog catalog) throws Exception{	

 		
 		return saveCatalog(userContext, catalog, allTokens());
 	}
 	
 	public Catalog loadCatalog(RetailScmUserContext userContext, String catalogId, String [] tokensExpr) throws Exception{				
 
 		CatalogManagerException exception = new CatalogManagerException("Error Occured");
		
		checkIdOfCatalog(userContext, catalogId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Catalog catalog = loadCatalog( userContext, catalogId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,catalog, tokens);
 	}
 	
 	protected Catalog present(RetailScmUserContext userContext, Catalog catalog, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,catalog,tokens);
		
		
		return this.getCatalogDAO().present(catalog, tokens);
	}
 
 	
 	
 	public Catalog loadCatalogDetail(RetailScmUserContext userContext, String catalogId) throws Exception{	
 		CatalogManagerException exception = new CatalogManagerException("Error Occured");
		
		checkIdOfCatalog(userContext, catalogId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Catalog catalog = loadCatalog( userContext, catalogId, allTokens());

 		return present(userContext,catalog, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String catalogId) throws Exception{	
 		CatalogManagerException exception = new CatalogManagerException("Error Occured");
		
		checkIdOfCatalog(userContext, catalogId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Catalog catalog = loadCatalog( userContext, catalogId, allTokens());

 		return present(userContext,catalog, allTokens());
		
 	}
 	protected Catalog saveCatalog(RetailScmUserContext userContext, Catalog catalog, Map<String,Object>tokens) throws Exception{	
 		return getCatalogDAO().save(catalog, tokens);
 	}
 	protected Catalog loadCatalog(RetailScmUserContext userContext, String catalogId, Map<String,Object>tokens) throws Exception{	
 		return getCatalogDAO().load(catalogId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Catalog catalog, Map<String, Object> tokens){
		super.addActions(userContext, catalog, tokens);
		
		addAction(userContext, catalog, tokens,"@create","createCatalog","createCatalog/","main","primary");
		addAction(userContext, catalog, tokens,"@update","updateCatalog","updateCatalog/"+catalog.getId()+"/","main","primary");
		addAction(userContext, catalog, tokens,"@copy","cloneCatalog","cloneCatalog/"+catalog.getId()+"/","main","primary");
		
		addAction(userContext, catalog, tokens,"catalog.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+catalog.getId()+"/","main","primary");
		addAction(userContext, catalog, tokens,"catalog.addLevelOneCategory","addLevelOneCategory","addLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.removeLevelOneCategory","removeLevelOneCategory","removeLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.updateLevelOneCategory","updateLevelOneCategory","updateLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.copyLevelOneCategoryFrom","copyLevelOneCategoryFrom","copyLevelOneCategoryFrom/"+catalog.getId()+"/","levelOneCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Catalog catalog, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Catalog createCatalog(RetailScmUserContext userContext,String displayName, String ownerId
) throws Exception
	{
		
		CatalogManagerException exception = new CatalogManagerException("Error Occured");

		

		checkDisplayNameOfCatalog(userContext,  displayName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Catalog catalog=createNewCatalog();	

		catalog.setDisplayName(displayName);
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(ownerId,emptyOptions());
		catalog.setOwner(owner);

		return saveCatalog(userContext, catalog, emptyOptions());
		

		
	}
	protected Catalog createNewCatalog() 
	{
		
		return new Catalog();		
	}
	
	protected void checkParamsForUpdatingCatalog(RetailScmUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		CatalogManagerException exception = new CatalogManagerException("Error Occured");
		
		checkIdOfCatalog(userContext, catalogId, exception);
		checkVersionOfCatalog(userContext, catalogVersion, exception);
		

		if(Catalog.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfCatalog(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public Catalog clone(RetailScmUserContext userContext, String fromCatalogId) throws Exception{
		
		return this.getCatalogDAO().clone(fromCatalogId, this.allTokens());
	}
	
	public Catalog updateCatalog(RetailScmUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		if(catalog.getVersion() != catalogVersion){
			String message = "The target version("+catalog.getVersion()+") is not equals to version("+catalogVersion+") provided";
			throw new CatalogManagerException(message);
		}
		synchronized(catalog){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.
			
			catalog.changePropery(property, newValueExpr);
			catalog = saveCatalog(userContext, catalog, tokens().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
			//return saveCatalog(userContext, catalog, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CatalogTokens tokens(){
		return CatalogTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CatalogTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CatalogTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String catalogId, String anotherOwnerId) throws Exception
 	{
 		CatalogManagerException exception = new CatalogManagerException("Error Occured");
 		checkIdOfCatalog(userContext, catalogId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Catalog transferToAnotherOwner(RetailScmUserContext userContext, String catalogId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, catalogId,anotherOwnerId);
 
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());	
		synchronized(catalog){
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(anotherOwnerId, emptyOptions());		
			catalog.setOwner(owner);		
			catalog = saveCatalog(userContext, catalog, emptyOptions());
			
			return present(userContext,catalog, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String catalogId, int catalogVersion) throws Exception {
		
		deleteInternal(userContext, catalogId, catalogVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String catalogId, int catalogVersion) throws Exception{
		getCatalogDAO().delete(catalogId, catalogVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CatalogManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getCatalogDAO().deleteAll();
	}

	protected void checkParamsForAddingLevelOneCategory(RetailScmUserContext userContext, String catalogId, String displayName,String [] tokensExpr) throws Exception{
		
		

		CatalogManagerException exception = new CatalogManagerException("Error Occured");
		
		checkIdOfCatalog(userContext, catalogId, exception);

		checkDisplayNameOfLevelOneCategory(userContext,  displayName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Catalog addLevelOneCategory(RetailScmUserContext userContext, String catalogId, String displayName, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelOneCategory(userContext,catalogId,displayName,tokensExpr);
		
		LevelOneCategory levelOneCategory = createLevelOneCategory(userContext,displayName);
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.addLevelOneCategory( levelOneCategory );		
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	protected LevelOneCategory createLevelOneCategory(RetailScmUserContext userContext, String displayName) throws Exception{

		LevelOneCategory levelOneCategory = new LevelOneCategory();
		
		
		levelOneCategory.setDisplayName(displayName);
	
		
		return levelOneCategory;
	
		
	}
	
	protected LevelOneCategory createIndexedLevelOneCategory(String id, int version){

		LevelOneCategory levelOneCategory = new LevelOneCategory();
		levelOneCategory.setId(id);
		levelOneCategory.setVersion(version);
		return levelOneCategory;			
		
	}
	protected void checkParamsForRemovingLevelOneCategory(RetailScmUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		

		CatalogManagerException exception = new CatalogManagerException("Error Occured");
		
		checkIdOfCatalog(userContext, catalogId, exception);
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		checkVersionOfLevelOneCategory(userContext, levelOneCategoryVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Catalog removeLevelOneCategory(RetailScmUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelOneCategory(userContext,catalogId, levelOneCategoryId, levelOneCategoryVersion,tokensExpr);
		
		LevelOneCategory levelOneCategory = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.removeLevelOneCategory( levelOneCategory );		
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingLevelOneCategory(RetailScmUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		

		CatalogManagerException exception = new CatalogManagerException("Error Occured");
		
		checkIdOfCatalog(userContext, catalogId, exception);
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		checkVersionOfLevelOneCategory(userContext, levelOneCategoryVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Catalog copyLevelOneCategoryFrom(RetailScmUserContext userContext, String catalogId, 
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelOneCategory(userContext,catalogId, levelOneCategoryId, levelOneCategoryVersion,tokensExpr);
		
		LevelOneCategory levelOneCategory = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.copyLevelOneCategoryFrom( levelOneCategory );		
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingLevelOneCategory(RetailScmUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		CatalogManagerException exception = new CatalogManagerException("Error Occured");
		
		checkIdOfCatalog(userContext, catalogId, exception);
		checkIdOfLevelOneCategory(userContext, levelOneCategoryId, exception);
		checkVersionOfLevelOneCategory(userContext, levelOneCategoryVersion, exception);
		

		if(LevelOneCategory.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfLevelOneCategory(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Catalog updateLevelOneCategory(RetailScmUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelOneCategory(userContext, catalogId, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr,  tokensExpr);
		
		
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		
		synchronized(catalog){ 
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//catalog.removeLevelOneCategory( levelOneCategory );	
			//make changes to AcceleraterAccount.
			LevelOneCategory levelOneCategoryIndex = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		
			LevelOneCategory levelOneCategory = catalog.findTheLevelOneCategory(levelOneCategoryIndex);
			if(levelOneCategory == null){
				throw new CatalogManagerException(levelOneCategory+"Not found" );
			}
			
			levelOneCategory.changePropery(property, newValueExpr);

			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


