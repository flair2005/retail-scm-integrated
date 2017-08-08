
package com.skynet.retailscm.leveltwodepartment;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartment;

import com.skynet.retailscm.levelonedepartment.LevelOneDepartmentDAO;

import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;


import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartmentTable;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartmentTable;




public class LevelTwoDepartmentManagerImpl extends RetailScmCheckerManager implements LevelTwoDepartmentManager {
	
	private static final String SERVICE_TYPE = "LevelTwoDepartment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  LevelTwoDepartmentDAO  levelTwoDepartmentDAO;
 	public void setLevelTwoDepartmentDAO(LevelTwoDepartmentDAO  levelTwoDepartmentDAO){
 	
 		if(levelTwoDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelTwoDepartmentDAO to null.");
 		}
	 	this.levelTwoDepartmentDAO = levelTwoDepartmentDAO;
 	}
 	public LevelTwoDepartmentDAO getLevelTwoDepartmentDAO(){
 		if(this.levelTwoDepartmentDAO == null){
 			throw new IllegalStateException("The LevelTwoDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelTwoDepartmentDAO;
 	}
 	
 	protected LevelTwoDepartment saveLevelTwoDepartment(RetailScmUserContext userContext, LevelTwoDepartment levelTwoDepartment, String [] tokensExpr) throws Exception{	
 		//return getLevelTwoDepartmentDAO().save(levelTwoDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens);
 	}
 	
 	protected LevelTwoDepartment saveLevelTwoDepartmentDetail(RetailScmUserContext userContext, LevelTwoDepartment levelTwoDepartment) throws Exception{	

 		
 		return saveLevelTwoDepartment(userContext, levelTwoDepartment, allTokens());
 	}
 	
 	public LevelTwoDepartment loadLevelTwoDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, String [] tokensExpr) throws Exception{				
 
 		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");
		
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoDepartment, tokens);
 	}
 	
 	protected LevelTwoDepartment present(RetailScmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelTwoDepartment,tokens);
		
		
		return this.getLevelTwoDepartmentDAO().present(levelTwoDepartment, tokens);
	}
 
 	
 	
 	public LevelTwoDepartment loadLevelTwoDepartmentDetail(RetailScmUserContext userContext, String levelTwoDepartmentId) throws Exception{	
 		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");
		
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, allTokens());

 		return present(userContext,levelTwoDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String levelTwoDepartmentId) throws Exception{	
 		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");
		
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, allTokens());

 		return present(userContext,levelTwoDepartment, allTokens());
		
 	}
 	protected LevelTwoDepartment saveLevelTwoDepartment(RetailScmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String,Object>tokens) throws Exception{	
 		return getLevelTwoDepartmentDAO().save(levelTwoDepartment, tokens);
 	}
 	protected LevelTwoDepartment loadLevelTwoDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, Map<String,Object>tokens) throws Exception{	
 		return getLevelTwoDepartmentDAO().load(levelTwoDepartmentId, tokens);
 	}

	



 	 
 	
 	private  LevelOneDepartmentDAO  levelOneDepartmentDAO;
 	public void setLevelOneDepartmentDAO(LevelOneDepartmentDAO levelOneDepartmentDAO){
	 	this.levelOneDepartmentDAO = levelOneDepartmentDAO;
 	}
 	//------------------------------------
 	public LevelOneDepartmentDAO getLevelOneDepartmentDAO(){
	 	return this.levelOneDepartmentDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String, Object> tokens){
		super.addActions(userContext, levelTwoDepartment, tokens);
		
		addAction(userContext, levelTwoDepartment, tokens,"@create","createLevelTwoDepartment","createLevelTwoDepartment/","main","primary");
		addAction(userContext, levelTwoDepartment, tokens,"@update","updateLevelTwoDepartment","updateLevelTwoDepartment/"+levelTwoDepartment.getId()+"/","main","primary");
		addAction(userContext, levelTwoDepartment, tokens,"@copy","cloneLevelTwoDepartment","cloneLevelTwoDepartment/"+levelTwoDepartment.getId()+"/","main","primary");
		
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+levelTwoDepartment.getId()+"/","main","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.addLevelThreeDepartment","addLevelThreeDepartment","addLevelThreeDepartment/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.removeLevelThreeDepartment","removeLevelThreeDepartment","removeLevelThreeDepartment/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.updateLevelThreeDepartment","updateLevelThreeDepartment","updateLevelThreeDepartment/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.copyLevelThreeDepartmentFrom","copyLevelThreeDepartmentFrom","copyLevelThreeDepartmentFrom/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelTwoDepartment createLevelTwoDepartment(RetailScmUserContext userContext,String belongsToId, String name, String description, Date founded
) throws Exception
	{
		
		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");

		

		checkNameOfLevelTwoDepartment(userContext,  name, exception);
		checkDescriptionOfLevelTwoDepartment(userContext,  description, exception);
		checkFoundedOfLevelTwoDepartment(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		LevelTwoDepartment levelTwoDepartment=createNewLevelTwoDepartment();	

		LevelOneDepartment belongsTo = loadLevelOneDepartment(belongsToId,emptyOptions());
		levelTwoDepartment.setBelongsTo(belongsTo);
		levelTwoDepartment.setName(name);
		levelTwoDepartment.setDescription(description);
		levelTwoDepartment.setFounded(founded);

		return saveLevelTwoDepartment(userContext, levelTwoDepartment, emptyOptions());
		

		
	}
	protected LevelTwoDepartment createNewLevelTwoDepartment() 
	{
		
		return new LevelTwoDepartment();		
	}
	
	protected void checkParamsForUpdatingLevelTwoDepartment(RetailScmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");
		
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
	
	
	
	public LevelTwoDepartment clone(RetailScmUserContext userContext, String fromLevelTwoDepartmentId) throws Exception{
		
		return this.getLevelTwoDepartmentDAO().clone(fromLevelTwoDepartmentId, this.allTokens());
	}
	
	public LevelTwoDepartment updateLevelTwoDepartment(RetailScmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelTwoDepartment(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion, property, newValueExpr, tokensExpr);
		
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		if(levelTwoDepartment.getVersion() != levelTwoDepartmentVersion){
			String message = "The target version("+levelTwoDepartment.getVersion()+") is not equals to version("+levelTwoDepartmentVersion+") provided";
			throw new LevelTwoDepartmentManagerException(message);
		}
		synchronized(levelTwoDepartment){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoDepartment.
			
			levelTwoDepartment.changePropery(property, newValueExpr);
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelTwoDepartmentTokens tokens(){
		return LevelTwoDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelTwoDepartmentTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelTwoDepartmentTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailScmUserContext userContext, String levelTwoDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");
 		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId,exception);
 		checkIdOfLevelOneDepartment(userContext, anotherBelongsToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public LevelTwoDepartment transferToAnotherBelongsTo(RetailScmUserContext userContext, String levelTwoDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, levelTwoDepartmentId,anotherBelongsToId);
 
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());	
		synchronized(levelTwoDepartment){
			//will be good when the levelTwoDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelOneDepartment belongsTo = loadLevelOneDepartment(anotherBelongsToId, emptyOptions());		
			levelTwoDepartment.setBelongsTo(belongsTo);		
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, emptyOptions());
			
			return present(userContext,levelTwoDepartment, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelOneDepartment loadLevelOneDepartment(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return getLevelOneDepartmentDAO().load(newBelongsToId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception {
		
		deleteInternal(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception{
		getLevelTwoDepartmentDAO().delete(levelTwoDepartmentId, levelTwoDepartmentVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelTwoDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getLevelTwoDepartmentDAO().deleteAll();
	}

	protected void checkParamsForAddingLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded,String [] tokensExpr) throws Exception{
		
		

		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");
		
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);

		checkNameOfLevelThreeDepartment(userContext,  name, exception);
		checkDescriptionOfLevelThreeDepartment(userContext,  description, exception);
		checkFoundedOfLevelThreeDepartment(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  LevelTwoDepartment addLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelThreeDepartment(userContext,levelTwoDepartmentId,name, description, founded,tokensExpr);
		
		LevelThreeDepartment levelThreeDepartment = createLevelThreeDepartment(userContext,name, description, founded);
		
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		synchronized(levelTwoDepartment){ 
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoDepartment.addLevelThreeDepartment( levelThreeDepartment );		
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected LevelThreeDepartment createLevelThreeDepartment(RetailScmUserContext userContext, String name, String description, Date founded) throws Exception{

		LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
		
		
		levelThreeDepartment.setName(name);		
		levelThreeDepartment.setDescription(description);		
		levelThreeDepartment.setFounded(founded);
	
		
		return levelThreeDepartment;
	
		
	}
	
	protected LevelThreeDepartment createIndexedLevelThreeDepartment(String id, int version){

		LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
		levelThreeDepartment.setId(id);
		levelThreeDepartment.setVersion(version);
		return levelThreeDepartment;			
		
	}
	protected void checkParamsForRemovingLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, 
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		

		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");
		
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		checkVersionOfLevelThreeDepartment(userContext, levelThreeDepartmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelTwoDepartment removeLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, 
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelThreeDepartment(userContext,levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion,tokensExpr);
		
		LevelThreeDepartment levelThreeDepartment = createIndexedLevelThreeDepartment(levelThreeDepartmentId, levelThreeDepartmentVersion);
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		synchronized(levelTwoDepartment){ 
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoDepartment.removeLevelThreeDepartment( levelThreeDepartment );		
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, 
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		

		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");
		
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		checkVersionOfLevelThreeDepartment(userContext, levelThreeDepartmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelTwoDepartment copyLevelThreeDepartmentFrom(RetailScmUserContext userContext, String levelTwoDepartmentId, 
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelThreeDepartment(userContext,levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion,tokensExpr);
		
		LevelThreeDepartment levelThreeDepartment = createIndexedLevelThreeDepartment(levelThreeDepartmentId, levelThreeDepartmentVersion);
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		synchronized(levelTwoDepartment){ 
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoDepartment.copyLevelThreeDepartmentFrom( levelThreeDepartment );		
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		LevelTwoDepartmentManagerException exception = new LevelTwoDepartmentManagerException("Error Occured");
		
		checkIdOfLevelTwoDepartment(userContext, levelTwoDepartmentId, exception);
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		checkVersionOfLevelThreeDepartment(userContext, levelThreeDepartmentVersion, exception);
		

		if(LevelThreeDepartment.NAME_PROPERTY.equals(property)){
			checkNameOfLevelThreeDepartment(userContext, parseString(newValueExpr), exception);
		}
		
		if(LevelThreeDepartment.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfLevelThreeDepartment(userContext, parseString(newValueExpr), exception);
		}
		
		if(LevelThreeDepartment.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfLevelThreeDepartment(userContext, parseDate(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  LevelTwoDepartment updateLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelThreeDepartment(userContext, levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr,  tokensExpr);
		
		
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		
		synchronized(levelTwoDepartment){ 
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelTwoDepartment.removeLevelThreeDepartment( levelThreeDepartment );	
			//make changes to AcceleraterAccount.
			LevelThreeDepartment levelThreeDepartmentIndex = createIndexedLevelThreeDepartment(levelThreeDepartmentId, levelThreeDepartmentVersion);
		
			LevelThreeDepartment levelThreeDepartment = levelTwoDepartment.findTheLevelThreeDepartment(levelThreeDepartmentIndex);
			if(levelThreeDepartment == null){
				throw new LevelTwoDepartmentManagerException(levelThreeDepartment+"Not found" );
			}
			
			levelThreeDepartment.changePropery(property, newValueExpr);

			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


