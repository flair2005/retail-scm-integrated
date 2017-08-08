
package com.skynet.retailscm.userapp;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.secuser.SecUser;
import com.skynet.retailscm.objectaccess.ObjectAccess;

import com.skynet.retailscm.secuser.SecUserDAO;

import com.skynet.retailscm.userapp.UserApp;


import com.skynet.retailscm.objectaccess.ObjectAccessTable;
import com.skynet.retailscm.secuser.SecUserTable;




public class UserAppManagerImpl extends RetailScmCheckerManager implements UserAppManager {
	
	private static final String SERVICE_TYPE = "UserApp";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  UserAppDAO  userAppDAO;
 	public void setUserAppDAO(UserAppDAO  userAppDAO){
 	
 		if(userAppDAO == null){
 			throw new IllegalStateException("Do not try to set userAppDAO to null.");
 		}
	 	this.userAppDAO = userAppDAO;
 	}
 	public UserAppDAO getUserAppDAO(){
 		if(this.userAppDAO == null){
 			throw new IllegalStateException("The UserAppDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAppDAO;
 	}
 	
 	protected UserApp saveUserApp(RetailScmUserContext userContext, UserApp userApp, String [] tokensExpr) throws Exception{	
 		//return getUserAppDAO().save(userApp, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUserApp(userContext, userApp, tokens);
 	}
 	
 	protected UserApp saveUserAppDetail(RetailScmUserContext userContext, UserApp userApp) throws Exception{	

 		
 		return saveUserApp(userContext, userApp, allTokens());
 	}
 	
 	public UserApp loadUserApp(RetailScmUserContext userContext, String userAppId, String [] tokensExpr) throws Exception{				
 
 		UserAppManagerException exception = new UserAppManagerException("Error Occured");
		
		checkIdOfUserApp(userContext, userAppId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserApp userApp = loadUserApp( userContext, userAppId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userApp, tokens);
 	}
 	
 	protected UserApp present(RetailScmUserContext userContext, UserApp userApp, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userApp,tokens);
		
		
		return this.getUserAppDAO().present(userApp, tokens);
	}
 
 	
 	
 	public UserApp loadUserAppDetail(RetailScmUserContext userContext, String userAppId) throws Exception{	
 		UserAppManagerException exception = new UserAppManagerException("Error Occured");
		
		checkIdOfUserApp(userContext, userAppId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		UserApp userApp = loadUserApp( userContext, userAppId, allTokens());

 		return present(userContext,userApp, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String userAppId) throws Exception{	
 		UserAppManagerException exception = new UserAppManagerException("Error Occured");
		
		checkIdOfUserApp(userContext, userAppId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		UserApp userApp = loadUserApp( userContext, userAppId, allTokens());

 		return present(userContext,userApp, allTokens());
		
 	}
 	protected UserApp saveUserApp(RetailScmUserContext userContext, UserApp userApp, Map<String,Object>tokens) throws Exception{	
 		return getUserAppDAO().save(userApp, tokens);
 	}
 	protected UserApp loadUserApp(RetailScmUserContext userContext, String userAppId, Map<String,Object>tokens) throws Exception{	
 		return getUserAppDAO().load(userAppId, tokens);
 	}

	



 	 
 	
 	private  SecUserDAO  secUserDAO;
 	public void setSecUserDAO(SecUserDAO secUserDAO){
	 	this.secUserDAO = secUserDAO;
 	}
 	//------------------------------------
 	public SecUserDAO getSecUserDAO(){
	 	return this.secUserDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, UserApp userApp, Map<String, Object> tokens){
		super.addActions(userContext, userApp, tokens);
		
		addAction(userContext, userApp, tokens,"@create","createUserApp","createUserApp/","main","primary");
		addAction(userContext, userApp, tokens,"@update","updateUserApp","updateUserApp/"+userApp.getId()+"/","main","primary");
		addAction(userContext, userApp, tokens,"@copy","cloneUserApp","cloneUserApp/"+userApp.getId()+"/","main","primary");
		
		addAction(userContext, userApp, tokens,"user_app.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+userApp.getId()+"/","main","primary");
		addAction(userContext, userApp, tokens,"user_app.addObjectAccess","addObjectAccess","addObjectAccess/"+userApp.getId()+"/","objectAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.removeObjectAccess","removeObjectAccess","removeObjectAccess/"+userApp.getId()+"/","objectAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.updateObjectAccess","updateObjectAccess","updateObjectAccess/"+userApp.getId()+"/","objectAccessList","primary");
		addAction(userContext, userApp, tokens,"user_app.copyObjectAccessFrom","copyObjectAccessFrom","copyObjectAccessFrom/"+userApp.getId()+"/","objectAccessList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, UserApp userApp, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public UserApp createUserApp(RetailScmUserContext userContext,String title, String secUserId, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location
) throws Exception
	{
		
		UserAppManagerException exception = new UserAppManagerException("Error Occured");

		

		checkTitleOfUserApp(userContext,  title, exception);
		checkAppIconOfUserApp(userContext,  appIcon, exception);
		checkFullAccessOfUserApp(userContext,  fullAccess, exception);
		checkPermissionOfUserApp(userContext,  permission, exception);
		checkObjectTypeOfUserApp(userContext,  objectType, exception);
		checkObjectIdOfUserApp(userContext,  objectId, exception);
		checkLocationOfUserApp(userContext,  location, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		UserApp userApp=createNewUserApp();	

		userApp.setTitle(title);
		SecUser secUser = loadSecUser(secUserId,emptyOptions());
		userApp.setSecUser(secUser);
		userApp.setAppIcon(appIcon);
		userApp.setFullAccess(fullAccess);
		userApp.setPermission(permission);
		userApp.setObjectType(objectType);
		userApp.setObjectId(objectId);
		userApp.setLocation(location);

		return saveUserApp(userContext, userApp, emptyOptions());
		

		
	}
	protected UserApp createNewUserApp() 
	{
		
		return new UserApp();		
	}
	
	protected void checkParamsForUpdatingUserApp(RetailScmUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		UserAppManagerException exception = new UserAppManagerException("Error Occured");
		
		checkIdOfUserApp(userContext, userAppId, exception);
		checkVersionOfUserApp(userContext, userAppVersion, exception);
		

		if(UserApp.TITLE_PROPERTY.equals(property)){
			checkTitleOfUserApp(userContext, parseString(newValueExpr), exception);
		}		

		
		if(UserApp.APP_ICON_PROPERTY.equals(property)){
			checkAppIconOfUserApp(userContext, parseString(newValueExpr), exception);
		}
		if(UserApp.FULL_ACCESS_PROPERTY.equals(property)){
			checkFullAccessOfUserApp(userContext, parseBoolean(newValueExpr), exception);
		}
		if(UserApp.PERMISSION_PROPERTY.equals(property)){
			checkPermissionOfUserApp(userContext, parseString(newValueExpr), exception);
		}
		if(UserApp.OBJECT_TYPE_PROPERTY.equals(property)){
			checkObjectTypeOfUserApp(userContext, parseString(newValueExpr), exception);
		}
		if(UserApp.OBJECT_ID_PROPERTY.equals(property)){
			checkObjectIdOfUserApp(userContext, parseString(newValueExpr), exception);
		}
		if(UserApp.LOCATION_PROPERTY.equals(property)){
			checkLocationOfUserApp(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public UserApp clone(RetailScmUserContext userContext, String fromUserAppId) throws Exception{
		
		return this.getUserAppDAO().clone(fromUserAppId, this.allTokens());
	}
	
	public UserApp updateUserApp(RetailScmUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserApp(userContext, userAppId, userAppVersion, property, newValueExpr, tokensExpr);
		
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		if(userApp.getVersion() != userAppVersion){
			String message = "The target version("+userApp.getVersion()+") is not equals to version("+userAppVersion+") provided";
			throw new UserAppManagerException(message);
		}
		synchronized(userApp){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserApp.
			
			userApp.changePropery(property, newValueExpr);
			userApp = saveUserApp(userContext, userApp, tokens().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
			//return saveUserApp(userContext, userApp, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected UserAppTokens tokens(){
		return UserAppTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserAppTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserAppTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherSecUser(RetailScmUserContext userContext, String userAppId, String anotherSecUserId) throws Exception
 	{
 		UserAppManagerException exception = new UserAppManagerException("Error Occured");
 		checkIdOfUserApp(userContext, userAppId,exception);
 		checkIdOfSecUser(userContext, anotherSecUserId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public UserApp transferToAnotherSecUser(RetailScmUserContext userContext, String userAppId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, userAppId,anotherSecUserId);
 
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());	
		synchronized(userApp){
			//will be good when the userApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(anotherSecUserId, emptyOptions());		
			userApp.setSecUser(secUser);		
			userApp = saveUserApp(userContext, userApp, emptyOptions());
			
			return present(userContext,userApp, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected SecUser loadSecUser(String newSecUserId, Map<String,Object> options) throws Exception
 	{
		
 		return getSecUserDAO().load(newSecUserId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String userAppId, int userAppVersion) throws Exception {
		
		deleteInternal(userContext, userAppId, userAppVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String userAppId, int userAppVersion) throws Exception{
		getUserAppDAO().delete(userAppId, userAppVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserAppManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getUserAppDAO().deleteAll();
	}

	protected void checkParamsForAddingObjectAccess(RetailScmUserContext userContext, String userAppId, String displayName, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9,String [] tokensExpr) throws Exception{
		
		

		UserAppManagerException exception = new UserAppManagerException("Error Occured");
		
		checkIdOfUserApp(userContext, userAppId, exception);

		checkDisplayNameOfObjectAccess(userContext,  displayName, exception);
		checkObjectTypeOfObjectAccess(userContext,  objectType, exception);
		checkList1OfObjectAccess(userContext,  list1, exception);
		checkList2OfObjectAccess(userContext,  list2, exception);
		checkList3OfObjectAccess(userContext,  list3, exception);
		checkList4OfObjectAccess(userContext,  list4, exception);
		checkList5OfObjectAccess(userContext,  list5, exception);
		checkList6OfObjectAccess(userContext,  list6, exception);
		checkList7OfObjectAccess(userContext,  list7, exception);
		checkList8OfObjectAccess(userContext,  list8, exception);
		checkList9OfObjectAccess(userContext,  list9, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  UserApp addObjectAccess(RetailScmUserContext userContext, String userAppId, String displayName, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingObjectAccess(userContext,userAppId,displayName, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9,tokensExpr);
		
		ObjectAccess objectAccess = createObjectAccess(userContext,displayName, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9);
		
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.addObjectAccess( objectAccess );		
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
	}
	protected ObjectAccess createObjectAccess(RetailScmUserContext userContext, String displayName, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9) throws Exception{

		ObjectAccess objectAccess = new ObjectAccess();
		
		
		objectAccess.setDisplayName(displayName);		
		objectAccess.setObjectType(objectType);		
		objectAccess.setList1(list1);		
		objectAccess.setList2(list2);		
		objectAccess.setList3(list3);		
		objectAccess.setList4(list4);		
		objectAccess.setList5(list5);		
		objectAccess.setList6(list6);		
		objectAccess.setList7(list7);		
		objectAccess.setList8(list8);		
		objectAccess.setList9(list9);
	
		
		return objectAccess;
	
		
	}
	
	protected ObjectAccess createIndexedObjectAccess(String id, int version){

		ObjectAccess objectAccess = new ObjectAccess();
		objectAccess.setId(id);
		objectAccess.setVersion(version);
		return objectAccess;			
		
	}
	protected void checkParamsForRemovingObjectAccess(RetailScmUserContext userContext, String userAppId, 
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		

		UserAppManagerException exception = new UserAppManagerException("Error Occured");
		
		checkIdOfUserApp(userContext, userAppId, exception);
		checkIdOfObjectAccess(userContext, objectAccessId, exception);
		checkVersionOfObjectAccess(userContext, objectAccessVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  UserApp removeObjectAccess(RetailScmUserContext userContext, String userAppId, 
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingObjectAccess(userContext,userAppId, objectAccessId, objectAccessVersion,tokensExpr);
		
		ObjectAccess objectAccess = createIndexedObjectAccess(objectAccessId, objectAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.removeObjectAccess( objectAccess );		
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingObjectAccess(RetailScmUserContext userContext, String userAppId, 
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		

		UserAppManagerException exception = new UserAppManagerException("Error Occured");
		
		checkIdOfUserApp(userContext, userAppId, exception);
		checkIdOfObjectAccess(userContext, objectAccessId, exception);
		checkVersionOfObjectAccess(userContext, objectAccessVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  UserApp copyObjectAccessFrom(RetailScmUserContext userContext, String userAppId, 
		String objectAccessId, int objectAccessVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingObjectAccess(userContext,userAppId, objectAccessId, objectAccessVersion,tokensExpr);
		
		ObjectAccess objectAccess = createIndexedObjectAccess(objectAccessId, objectAccessVersion);
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userApp.copyObjectAccessFrom( objectAccess );		
			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingObjectAccess(RetailScmUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		UserAppManagerException exception = new UserAppManagerException("Error Occured");
		
		checkIdOfUserApp(userContext, userAppId, exception);
		checkIdOfObjectAccess(userContext, objectAccessId, exception);
		checkVersionOfObjectAccess(userContext, objectAccessVersion, exception);
		

		if(ObjectAccess.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.OBJECT_TYPE_PROPERTY.equals(property)){
			checkObjectTypeOfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.LIST1_PROPERTY.equals(property)){
			checkList1OfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.LIST2_PROPERTY.equals(property)){
			checkList2OfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.LIST3_PROPERTY.equals(property)){
			checkList3OfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.LIST4_PROPERTY.equals(property)){
			checkList4OfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.LIST5_PROPERTY.equals(property)){
			checkList5OfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.LIST6_PROPERTY.equals(property)){
			checkList6OfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.LIST7_PROPERTY.equals(property)){
			checkList7OfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.LIST8_PROPERTY.equals(property)){
			checkList8OfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
		if(ObjectAccess.LIST9_PROPERTY.equals(property)){
			checkList9OfObjectAccess(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  UserApp updateObjectAccess(RetailScmUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingObjectAccess(userContext, userAppId, objectAccessId, objectAccessVersion, property, newValueExpr,  tokensExpr);
		
		
		UserApp userApp = loadUserApp(userContext, userAppId, allTokens());
		
		synchronized(userApp){ 
			//Will be good when the userApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userApp.removeObjectAccess( objectAccess );	
			//make changes to AcceleraterAccount.
			ObjectAccess objectAccessIndex = createIndexedObjectAccess(objectAccessId, objectAccessVersion);
		
			ObjectAccess objectAccess = userApp.findTheObjectAccess(objectAccessIndex);
			if(objectAccess == null){
				throw new UserAppManagerException(objectAccess+"Not found" );
			}
			
			objectAccess.changePropery(property, newValueExpr);

			userApp = saveUserApp(userContext, userApp, tokens().withObjectAccessList().done());
			return present(userContext,userApp, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


