
package com.skynet.retailscm.levelonedepartment;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.levelonedepartment.LevelOneDepartment;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartmentTable;




public class LevelOneDepartmentManagerImpl extends RetailScmCheckerManager implements LevelOneDepartmentManager {
	
	private static final String SERVICE_TYPE = "LevelOneDepartment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  LevelOneDepartmentDAO  levelOneDepartmentDAO;
 	public void setLevelOneDepartmentDAO(LevelOneDepartmentDAO  levelOneDepartmentDAO){
 	
 		if(levelOneDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelOneDepartmentDAO to null.");
 		}
	 	this.levelOneDepartmentDAO = levelOneDepartmentDAO;
 	}
 	public LevelOneDepartmentDAO getLevelOneDepartmentDAO(){
 		if(this.levelOneDepartmentDAO == null){
 			throw new IllegalStateException("The LevelOneDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelOneDepartmentDAO;
 	}
 	
 	protected LevelOneDepartment saveLevelOneDepartment(RetailScmUserContext userContext, LevelOneDepartment levelOneDepartment, String [] tokensExpr) throws Exception{	
 		//return getLevelOneDepartmentDAO().save(levelOneDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelOneDepartment(userContext, levelOneDepartment, tokens);
 	}
 	
 	protected LevelOneDepartment saveLevelOneDepartmentDetail(RetailScmUserContext userContext, LevelOneDepartment levelOneDepartment) throws Exception{	

 		
 		return saveLevelOneDepartment(userContext, levelOneDepartment, allTokens());
 	}
 	
 	public LevelOneDepartment loadLevelOneDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, String [] tokensExpr) throws Exception{				
 
 		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");
		
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment( userContext, levelOneDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneDepartment, tokens);
 	}
 	
 	protected LevelOneDepartment present(RetailScmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelOneDepartment,tokens);
		
		
		return this.getLevelOneDepartmentDAO().present(levelOneDepartment, tokens);
	}
 
 	
 	
 	public LevelOneDepartment loadLevelOneDepartmentDetail(RetailScmUserContext userContext, String levelOneDepartmentId) throws Exception{	
 		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");
		
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment( userContext, levelOneDepartmentId, allTokens());

 		return present(userContext,levelOneDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String levelOneDepartmentId) throws Exception{	
 		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");
		
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment( userContext, levelOneDepartmentId, allTokens());

 		return present(userContext,levelOneDepartment, allTokens());
		
 	}
 	protected LevelOneDepartment saveLevelOneDepartment(RetailScmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String,Object>tokens) throws Exception{	
 		return getLevelOneDepartmentDAO().save(levelOneDepartment, tokens);
 	}
 	protected LevelOneDepartment loadLevelOneDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, Map<String,Object>tokens) throws Exception{	
 		return getLevelOneDepartmentDAO().load(levelOneDepartmentId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String, Object> tokens){
		super.addActions(userContext, levelOneDepartment, tokens);
		
		addAction(userContext, levelOneDepartment, tokens,"@create","createLevelOneDepartment","createLevelOneDepartment/","main","primary");
		addAction(userContext, levelOneDepartment, tokens,"@update","updateLevelOneDepartment","updateLevelOneDepartment/"+levelOneDepartment.getId()+"/","main","primary");
		addAction(userContext, levelOneDepartment, tokens,"@copy","cloneLevelOneDepartment","cloneLevelOneDepartment/"+levelOneDepartment.getId()+"/","main","primary");
		
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+levelOneDepartment.getId()+"/","main","primary");
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.addLevelTwoDepartment","addLevelTwoDepartment","addLevelTwoDepartment/"+levelOneDepartment.getId()+"/","levelTwoDepartmentList","primary");
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.removeLevelTwoDepartment","removeLevelTwoDepartment","removeLevelTwoDepartment/"+levelOneDepartment.getId()+"/","levelTwoDepartmentList","primary");
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.updateLevelTwoDepartment","updateLevelTwoDepartment","updateLevelTwoDepartment/"+levelOneDepartment.getId()+"/","levelTwoDepartmentList","primary");
		addAction(userContext, levelOneDepartment, tokens,"level_one_department.copyLevelTwoDepartmentFrom","copyLevelTwoDepartmentFrom","copyLevelTwoDepartmentFrom/"+levelOneDepartment.getId()+"/","levelTwoDepartmentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelOneDepartment levelOneDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelOneDepartment createLevelOneDepartment(RetailScmUserContext userContext,String belongsToId, String name, String description, String manager, Date founded
) throws Exception
	{
		
		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");

		

		checkNameOfLevelOneDepartment(userContext,  name, exception);
		checkDescriptionOfLevelOneDepartment(userContext,  description, exception);
		checkManagerOfLevelOneDepartment(userContext,  manager, exception);
		checkFoundedOfLevelOneDepartment(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		LevelOneDepartment levelOneDepartment=createNewLevelOneDepartment();	

		RetailStoreCountryCenter belongsTo = loadRetailStoreCountryCenter(belongsToId,emptyOptions());
		levelOneDepartment.setBelongsTo(belongsTo);
		levelOneDepartment.setName(name);
		levelOneDepartment.setDescription(description);
		levelOneDepartment.setManager(manager);
		levelOneDepartment.setFounded(founded);

		return saveLevelOneDepartment(userContext, levelOneDepartment, emptyOptions());
		

		
	}
	protected LevelOneDepartment createNewLevelOneDepartment() 
	{
		
		return new LevelOneDepartment();		
	}
	
	protected void checkParamsForUpdatingLevelOneDepartment(RetailScmUserContext userContext,String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");
		
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		checkVersionOfLevelOneDepartment(userContext, levelOneDepartmentVersion, exception);
		
		

		
		if(LevelOneDepartment.NAME_PROPERTY.equals(property)){
			checkNameOfLevelOneDepartment(userContext, parseString(newValueExpr), exception);
		}
		if(LevelOneDepartment.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfLevelOneDepartment(userContext, parseString(newValueExpr), exception);
		}
		if(LevelOneDepartment.MANAGER_PROPERTY.equals(property)){
			checkManagerOfLevelOneDepartment(userContext, parseString(newValueExpr), exception);
		}
		if(LevelOneDepartment.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfLevelOneDepartment(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public LevelOneDepartment clone(RetailScmUserContext userContext, String fromLevelOneDepartmentId) throws Exception{
		
		return this.getLevelOneDepartmentDAO().clone(fromLevelOneDepartmentId, this.allTokens());
	}
	
	public LevelOneDepartment updateLevelOneDepartment(RetailScmUserContext userContext,String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelOneDepartment(userContext, levelOneDepartmentId, levelOneDepartmentVersion, property, newValueExpr, tokensExpr);
		
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		if(levelOneDepartment.getVersion() != levelOneDepartmentVersion){
			String message = "The target version("+levelOneDepartment.getVersion()+") is not equals to version("+levelOneDepartmentVersion+") provided";
			throw new LevelOneDepartmentManagerException(message);
		}
		synchronized(levelOneDepartment){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneDepartment.
			
			levelOneDepartment.changePropery(property, newValueExpr);
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().done());
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelOneDepartment(userContext, levelOneDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelOneDepartmentTokens tokens(){
		return LevelOneDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelOneDepartmentTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelOneDepartmentTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailScmUserContext userContext, String levelOneDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");
 		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherBelongsToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public LevelOneDepartment transferToAnotherBelongsTo(RetailScmUserContext userContext, String levelOneDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, levelOneDepartmentId,anotherBelongsToId);
 
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());	
		synchronized(levelOneDepartment){
			//will be good when the levelOneDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter belongsTo = loadRetailStoreCountryCenter(anotherBelongsToId, emptyOptions());		
			levelOneDepartment.setBelongsTo(belongsTo);		
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, emptyOptions());
			
			return present(userContext,levelOneDepartment, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newBelongsToId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception {
		
		deleteInternal(userContext, levelOneDepartmentId, levelOneDepartmentVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String levelOneDepartmentId, int levelOneDepartmentVersion) throws Exception{
		getLevelOneDepartmentDAO().delete(levelOneDepartmentId, levelOneDepartmentVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelOneDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getLevelOneDepartmentDAO().deleteAll();
	}

	protected void checkParamsForAddingLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded,String [] tokensExpr) throws Exception{
		
		

		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");
		
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);

		checkNameOfLevelTwoDepartment(userContext,  name, exception);
		checkDescriptionOfLevelTwoDepartment(userContext,  description, exception);
		checkFoundedOfLevelTwoDepartment(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  LevelOneDepartment addLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelTwoDepartment(userContext,levelOneDepartmentId,name, description, founded,tokensExpr);
		
		LevelTwoDepartment levelTwoDepartment = createLevelTwoDepartment(userContext,name, description, founded);
		
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		synchronized(levelOneDepartment){ 
			//Will be good when the levelOneDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneDepartment.addLevelTwoDepartment( levelTwoDepartment );		
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected LevelTwoDepartment createLevelTwoDepartment(RetailScmUserContext userContext, String name, String description, Date founded) throws Exception{

		LevelTwoDepartment levelTwoDepartment = new LevelTwoDepartment();
		
		
		levelTwoDepartment.setName(name);		
		levelTwoDepartment.setDescription(description);		
		levelTwoDepartment.setFounded(founded);
	
		
		return levelTwoDepartment;
	
		
	}
	
	protected LevelTwoDepartment createIndexedLevelTwoDepartment(String id, int version){

		LevelTwoDepartment levelTwoDepartment = new LevelTwoDepartment();
		levelTwoDepartment.setId(id);
		levelTwoDepartment.setVersion(version);
		return levelTwoDepartment;			
		
	}
	protected void checkParamsForRemovingLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, 
		String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr) throws Exception{
		

		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");
		
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);
		checkVersionOfLevelTwoDepartment(userContext, levelTwoDepartmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelOneDepartment removeLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, 
		String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelTwoDepartment(userContext,levelOneDepartmentId, levelTwoDepartmentId, levelTwoDepartmentVersion,tokensExpr);
		
		LevelTwoDepartment levelTwoDepartment = createIndexedLevelTwoDepartment(levelTwoDepartmentId, levelTwoDepartmentVersion);
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		synchronized(levelOneDepartment){ 
			//Will be good when the levelOneDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneDepartment.removeLevelTwoDepartment( levelTwoDepartment );		
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, 
		String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr) throws Exception{
		

		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");
		
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);
		checkVersionOfLevelTwoDepartment(userContext, levelTwoDepartmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelOneDepartment copyLevelTwoDepartmentFrom(RetailScmUserContext userContext, String levelOneDepartmentId, 
		String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelTwoDepartment(userContext,levelOneDepartmentId, levelTwoDepartmentId, levelTwoDepartmentVersion,tokensExpr);
		
		LevelTwoDepartment levelTwoDepartment = createIndexedLevelTwoDepartment(levelTwoDepartmentId, levelTwoDepartmentVersion);
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		synchronized(levelOneDepartment){ 
			//Will be good when the levelOneDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneDepartment.copyLevelTwoDepartmentFrom( levelTwoDepartment );		
			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		LevelOneDepartmentManagerException exception = new LevelOneDepartmentManagerException("Error Occured");
		
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);
		checkVersionOfLevelTwoDepartment(userContext, levelTwoDepartmentVersion, exception);
		

		if(LevelTwoDepartment.NAME_PROPERTY.equals(property)){
			checkNameOfLevelTwoDepartment(userContext, parseString(newValueExpr), exception);
		}
		
		if(LevelTwoDepartment.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfLevelTwoDepartment(userContext, parseString(newValueExpr), exception);
		}
		
		if(LevelTwoDepartment.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfLevelTwoDepartment(userContext, parseDate(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  LevelOneDepartment updateLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelTwoDepartment(userContext, levelOneDepartmentId, levelTwoDepartmentId, levelTwoDepartmentVersion, property, newValueExpr,  tokensExpr);
		
		
		LevelOneDepartment levelOneDepartment = loadLevelOneDepartment(userContext, levelOneDepartmentId, allTokens());
		
		synchronized(levelOneDepartment){ 
			//Will be good when the levelOneDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelOneDepartment.removeLevelTwoDepartment( levelTwoDepartment );	
			//make changes to AcceleraterAccount.
			LevelTwoDepartment levelTwoDepartmentIndex = createIndexedLevelTwoDepartment(levelTwoDepartmentId, levelTwoDepartmentVersion);
		
			LevelTwoDepartment levelTwoDepartment = levelOneDepartment.findTheLevelTwoDepartment(levelTwoDepartmentIndex);
			if(levelTwoDepartment == null){
				throw new LevelOneDepartmentManagerException(levelTwoDepartment+"Not found" );
			}
			
			levelTwoDepartment.changePropery(property, newValueExpr);

			levelOneDepartment = saveLevelOneDepartment(userContext, levelOneDepartment, tokens().withLevelTwoDepartmentList().done());
			return present(userContext,levelOneDepartment, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


