
package com.skynet.retailscm.secuser;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.userdomain.UserDomain;
import com.skynet.retailscm.userapp.UserApp;

import com.skynet.retailscm.userdomain.UserDomainDAO;

import com.skynet.retailscm.secuser.SecUser;


import com.skynet.retailscm.userapp.UserAppTable;
import com.skynet.retailscm.userdomain.UserDomainTable;




public class SecUserManagerImpl extends RetailScmCheckerManager implements SecUserManager {
	
	private static final String SERVICE_TYPE = "SecUser";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SecUserDAO  secUserDAO;
 	public void setSecUserDAO(SecUserDAO  secUserDAO){
 	
 		if(secUserDAO == null){
 			throw new IllegalStateException("Do not try to set secUserDAO to null.");
 		}
	 	this.secUserDAO = secUserDAO;
 	}
 	public SecUserDAO getSecUserDAO(){
 		if(this.secUserDAO == null){
 			throw new IllegalStateException("The SecUserDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.secUserDAO;
 	}
 	
 	protected SecUser saveSecUser(RetailScmUserContext userContext, SecUser secUser, String [] tokensExpr) throws Exception{	
 		//return getSecUserDAO().save(secUser, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSecUser(userContext, secUser, tokens);
 	}
 	
 	protected SecUser saveSecUserDetail(RetailScmUserContext userContext, SecUser secUser) throws Exception{	

 		
 		return saveSecUser(userContext, secUser, allTokens());
 	}
 	
 	public SecUser loadSecUser(RetailScmUserContext userContext, String secUserId, String [] tokensExpr) throws Exception{				
 
 		SecUserManagerException exception = new SecUserManagerException("Error Occured");
		
		checkIdOfSecUser(userContext, secUserId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SecUser secUser = loadSecUser( userContext, secUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,secUser, tokens);
 	}
 	
 	protected SecUser present(RetailScmUserContext userContext, SecUser secUser, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,secUser,tokens);
		
		
		return this.getSecUserDAO().present(secUser, tokens);
	}
 
 	
 	
 	public SecUser loadSecUserDetail(RetailScmUserContext userContext, String secUserId) throws Exception{	
 		SecUserManagerException exception = new SecUserManagerException("Error Occured");
		
		checkIdOfSecUser(userContext, secUserId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SecUser secUser = loadSecUser( userContext, secUserId, allTokens());

 		return present(userContext,secUser, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String secUserId) throws Exception{	
 		SecUserManagerException exception = new SecUserManagerException("Error Occured");
		
		checkIdOfSecUser(userContext, secUserId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SecUser secUser = loadSecUser( userContext, secUserId, allTokens());

 		return present(userContext,secUser, allTokens());
		
 	}
 	protected SecUser saveSecUser(RetailScmUserContext userContext, SecUser secUser, Map<String,Object>tokens) throws Exception{	
 		return getSecUserDAO().save(secUser, tokens);
 	}
 	protected SecUser loadSecUser(RetailScmUserContext userContext, String secUserId, Map<String,Object>tokens) throws Exception{	
 		return getSecUserDAO().load(secUserId, tokens);
 	}

	



 	 
 	
 	private  UserDomainDAO  userDomainDAO;
 	public void setUserDomainDAO(UserDomainDAO userDomainDAO){
	 	this.userDomainDAO = userDomainDAO;
 	}
 	//------------------------------------
 	public UserDomainDAO getUserDomainDAO(){
	 	return this.userDomainDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SecUser secUser, Map<String, Object> tokens){
		super.addActions(userContext, secUser, tokens);
		
		addAction(userContext, secUser, tokens,"@create","createSecUser","createSecUser/","main","primary");
		addAction(userContext, secUser, tokens,"@update","updateSecUser","updateSecUser/"+secUser.getId()+"/","main","primary");
		addAction(userContext, secUser, tokens,"@copy","cloneSecUser","cloneSecUser/"+secUser.getId()+"/","main","primary");
		
		addAction(userContext, secUser, tokens,"sec_user.transfer_to_domain","transferToAnotherDomain","transferToAnotherDomain/"+secUser.getId()+"/","main","primary");
		addAction(userContext, secUser, tokens,"sec_user.addUserApp","addUserApp","addUserApp/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeUserApp","removeUserApp","removeUserApp/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateUserApp","updateUserApp","updateUserApp/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyUserAppFrom","copyUserAppFrom","copyUserAppFrom/"+secUser.getId()+"/","userAppList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SecUser secUser, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SecUser createSecUser(RetailScmUserContext userContext,String login, String mobile, String email, String pwd, Date lastLogin, String domainId
) throws Exception
	{
		
		SecUserManagerException exception = new SecUserManagerException("Error Occured");

		

		checkLoginOfSecUser(userContext,  login, exception);
		checkMobileOfSecUser(userContext,  mobile, exception);
		checkEmailOfSecUser(userContext,  email, exception);
		checkPwdOfSecUser(userContext,  pwd, exception);
		checkLastLoginOfSecUser(userContext,  lastLogin, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SecUser secUser=createNewSecUser();	

		secUser.setLogin(login);
		secUser.setMobile(mobile);
		secUser.setEmail(email);
		secUser.setClearTextOfPwd(pwd);
		secUser.setLastLogin(lastLogin);
		UserDomain domain = loadUserDomain(domainId,emptyOptions());
		secUser.setDomain(domain);

		return saveSecUser(userContext, secUser, emptyOptions());
		

		
	}
	protected SecUser createNewSecUser() 
	{
		
		return new SecUser();		
	}
	
	protected void checkParamsForUpdatingSecUser(RetailScmUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SecUserManagerException exception = new SecUserManagerException("Error Occured");
		
		checkIdOfSecUser(userContext, secUserId, exception);
		checkVersionOfSecUser(userContext, secUserVersion, exception);
		

		if(SecUser.LOGIN_PROPERTY.equals(property)){
			checkLoginOfSecUser(userContext, parseString(newValueExpr), exception);
		}
		if(SecUser.MOBILE_PROPERTY.equals(property)){
			checkMobileOfSecUser(userContext, parseString(newValueExpr), exception);
		}
		if(SecUser.EMAIL_PROPERTY.equals(property)){
			checkEmailOfSecUser(userContext, parseString(newValueExpr), exception);
		}
		if(SecUser.PWD_PROPERTY.equals(property)){
			checkPwdOfSecUser(userContext, parseString(newValueExpr), exception);
		}
		if(SecUser.LAST_LOGIN_PROPERTY.equals(property)){
			checkLastLoginOfSecUser(userContext, parseDate(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SecUser clone(RetailScmUserContext userContext, String fromSecUserId) throws Exception{
		
		return this.getSecUserDAO().clone(fromSecUserId, this.allTokens());
	}
	
	public SecUser updateSecUser(RetailScmUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSecUser(userContext, secUserId, secUserVersion, property, newValueExpr, tokensExpr);
		
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		if(secUser.getVersion() != secUserVersion){
			String message = "The target version("+secUser.getVersion()+") is not equals to version("+secUserVersion+") provided";
			throw new SecUserManagerException(message);
		}
		synchronized(secUser){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUser.
			
			secUser.changePropery(property, newValueExpr);
			secUser = saveSecUser(userContext, secUser, tokens().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
			//return saveSecUser(userContext, secUser, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SecUserTokens tokens(){
		return SecUserTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SecUserTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SecUserTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherDomain(RetailScmUserContext userContext, String secUserId, String anotherDomainId) throws Exception
 	{
 		SecUserManagerException exception = new SecUserManagerException("Error Occured");
 		checkIdOfSecUser(userContext, secUserId,exception);
 		checkIdOfUserDomain(userContext, anotherDomainId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SecUser transferToAnotherDomain(RetailScmUserContext userContext, String secUserId, String anotherDomainId) throws Exception
 	{
 		checkParamsForTransferingAnotherDomain(userContext, secUserId,anotherDomainId);
 
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());	
		synchronized(secUser){
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserDomain domain = loadUserDomain(anotherDomainId, emptyOptions());		
			secUser.setDomain(domain);		
			secUser = saveSecUser(userContext, secUser, emptyOptions());
			
			return present(userContext,secUser, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected UserDomain loadUserDomain(String newDomainId, Map<String,Object> options) throws Exception
 	{
		
 		return getUserDomainDAO().load(newDomainId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String secUserId, int secUserVersion) throws Exception {
		
		deleteInternal(userContext, secUserId, secUserVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String secUserId, int secUserVersion) throws Exception{
		getSecUserDAO().delete(secUserId, secUserVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SecUserManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSecUserDAO().deleteAll();
	}

	protected void checkParamsForAddingUserApp(RetailScmUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location,String [] tokensExpr) throws Exception{
		
		

		SecUserManagerException exception = new SecUserManagerException("Error Occured");
		
		checkIdOfSecUser(userContext, secUserId, exception);

		checkTitleOfUserApp(userContext,  title, exception);
		checkAppIconOfUserApp(userContext,  appIcon, exception);
		checkFullAccessOfUserApp(userContext,  fullAccess, exception);
		checkPermissionOfUserApp(userContext,  permission, exception);
		checkObjectTypeOfUserApp(userContext,  objectType, exception);
		checkObjectIdOfUserApp(userContext,  objectId, exception);
		checkLocationOfUserApp(userContext,  location, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SecUser addUserApp(RetailScmUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingUserApp(userContext,secUserId,title, appIcon, fullAccess, permission, objectType, objectId, location,tokensExpr);
		
		UserApp userApp = createUserApp(userContext,title, appIcon, fullAccess, permission, objectType, objectId, location);
		
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addUserApp( userApp );		
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected UserApp createUserApp(RetailScmUserContext userContext, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location) throws Exception{

		UserApp userApp = new UserApp();
		
		
		userApp.setTitle(title);		
		userApp.setAppIcon(appIcon);		
		userApp.setFullAccess(fullAccess);		
		userApp.setPermission(permission);		
		userApp.setObjectType(objectType);		
		userApp.setObjectId(objectId);		
		userApp.setLocation(location);
	
		
		return userApp;
	
		
	}
	
	protected UserApp createIndexedUserApp(String id, int version){

		UserApp userApp = new UserApp();
		userApp.setId(id);
		userApp.setVersion(version);
		return userApp;			
		
	}
	protected void checkParamsForRemovingUserApp(RetailScmUserContext userContext, String secUserId, 
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		

		SecUserManagerException exception = new SecUserManagerException("Error Occured");
		
		checkIdOfSecUser(userContext, secUserId, exception);
		checkIdOfUserApp(userContext, userAppId, exception);
		checkVersionOfUserApp(userContext, userAppVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SecUser removeUserApp(RetailScmUserContext userContext, String secUserId, 
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingUserApp(userContext,secUserId, userAppId, userAppVersion,tokensExpr);
		
		UserApp userApp = createIndexedUserApp(userAppId, userAppVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeUserApp( userApp );		
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingUserApp(RetailScmUserContext userContext, String secUserId, 
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		

		SecUserManagerException exception = new SecUserManagerException("Error Occured");
		
		checkIdOfSecUser(userContext, secUserId, exception);
		checkIdOfUserApp(userContext, userAppId, exception);
		checkVersionOfUserApp(userContext, userAppVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SecUser copyUserAppFrom(RetailScmUserContext userContext, String secUserId, 
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingUserApp(userContext,secUserId, userAppId, userAppVersion,tokensExpr);
		
		UserApp userApp = createIndexedUserApp(userAppId, userAppVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.copyUserAppFrom( userApp );		
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingUserApp(RetailScmUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SecUserManagerException exception = new SecUserManagerException("Error Occured");
		
		checkIdOfSecUser(userContext, secUserId, exception);
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
	
	public  SecUser updateUserApp(RetailScmUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingUserApp(userContext, secUserId, userAppId, userAppVersion, property, newValueExpr,  tokensExpr);
		
		
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeUserApp( userApp );	
			//make changes to AcceleraterAccount.
			UserApp userAppIndex = createIndexedUserApp(userAppId, userAppVersion);
		
			UserApp userApp = secUser.findTheUserApp(userAppIndex);
			if(userApp == null){
				throw new SecUserManagerException(userApp+"Not found" );
			}
			
			userApp.changePropery(property, newValueExpr);

			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


