
package com.skynet.retailscm.userdomain;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.secuser.SecUser;


import com.skynet.retailscm.userdomain.UserDomain;


import com.skynet.retailscm.secuser.SecUserTable;




public class UserDomainManagerImpl extends RetailScmCheckerManager implements UserDomainManager {
	
	private static final String SERVICE_TYPE = "UserDomain";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  UserDomainDAO  userDomainDAO;
 	public void setUserDomainDAO(UserDomainDAO  userDomainDAO){
 	
 		if(userDomainDAO == null){
 			throw new IllegalStateException("Do not try to set userDomainDAO to null.");
 		}
	 	this.userDomainDAO = userDomainDAO;
 	}
 	public UserDomainDAO getUserDomainDAO(){
 		if(this.userDomainDAO == null){
 			throw new IllegalStateException("The UserDomainDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userDomainDAO;
 	}
 	
 	protected UserDomain saveUserDomain(RetailScmUserContext userContext, UserDomain userDomain, String [] tokensExpr) throws Exception{	
 		//return getUserDomainDAO().save(userDomain, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUserDomain(userContext, userDomain, tokens);
 	}
 	
 	protected UserDomain saveUserDomainDetail(RetailScmUserContext userContext, UserDomain userDomain) throws Exception{	

 		
 		return saveUserDomain(userContext, userDomain, allTokens());
 	}
 	
 	public UserDomain loadUserDomain(RetailScmUserContext userContext, String userDomainId, String [] tokensExpr) throws Exception{				
 
 		UserDomainManagerException exception = new UserDomainManagerException("Error Occured");
		
		checkIdOfUserDomain(userContext, userDomainId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserDomain userDomain = loadUserDomain( userContext, userDomainId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userDomain, tokens);
 	}
 	
 	protected UserDomain present(RetailScmUserContext userContext, UserDomain userDomain, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userDomain,tokens);
		
		
		return this.getUserDomainDAO().present(userDomain, tokens);
	}
 
 	
 	
 	public UserDomain loadUserDomainDetail(RetailScmUserContext userContext, String userDomainId) throws Exception{	
 		UserDomainManagerException exception = new UserDomainManagerException("Error Occured");
		
		checkIdOfUserDomain(userContext, userDomainId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		UserDomain userDomain = loadUserDomain( userContext, userDomainId, allTokens());

 		return present(userContext,userDomain, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String userDomainId) throws Exception{	
 		UserDomainManagerException exception = new UserDomainManagerException("Error Occured");
		
		checkIdOfUserDomain(userContext, userDomainId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		UserDomain userDomain = loadUserDomain( userContext, userDomainId, allTokens());

 		return present(userContext,userDomain, allTokens());
		
 	}
 	protected UserDomain saveUserDomain(RetailScmUserContext userContext, UserDomain userDomain, Map<String,Object>tokens) throws Exception{	
 		return getUserDomainDAO().save(userDomain, tokens);
 	}
 	protected UserDomain loadUserDomain(RetailScmUserContext userContext, String userDomainId, Map<String,Object>tokens) throws Exception{	
 		return getUserDomainDAO().load(userDomainId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, UserDomain userDomain, Map<String, Object> tokens){
		super.addActions(userContext, userDomain, tokens);
		
		addAction(userContext, userDomain, tokens,"@create","createUserDomain","createUserDomain/","main","primary");
		addAction(userContext, userDomain, tokens,"@update","updateUserDomain","updateUserDomain/"+userDomain.getId()+"/","main","primary");
		addAction(userContext, userDomain, tokens,"@copy","cloneUserDomain","cloneUserDomain/"+userDomain.getId()+"/","main","primary");
		
		addAction(userContext, userDomain, tokens,"user_domain.addSecUser","addSecUser","addSecUser/"+userDomain.getId()+"/","secUserList","primary");
		addAction(userContext, userDomain, tokens,"user_domain.removeSecUser","removeSecUser","removeSecUser/"+userDomain.getId()+"/","secUserList","primary");
		addAction(userContext, userDomain, tokens,"user_domain.updateSecUser","updateSecUser","updateSecUser/"+userDomain.getId()+"/","secUserList","primary");
		addAction(userContext, userDomain, tokens,"user_domain.copySecUserFrom","copySecUserFrom","copySecUserFrom/"+userDomain.getId()+"/","secUserList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, UserDomain userDomain, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public UserDomain createUserDomain(RetailScmUserContext userContext,String name
) throws Exception
	{
		
		UserDomainManagerException exception = new UserDomainManagerException("Error Occured");

		

		checkNameOfUserDomain(userContext,  name, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		UserDomain userDomain=createNewUserDomain();	

		userDomain.setName(name);

		return saveUserDomain(userContext, userDomain, emptyOptions());
		

		
	}
	protected UserDomain createNewUserDomain() 
	{
		
		return new UserDomain();		
	}
	
	protected void checkParamsForUpdatingUserDomain(RetailScmUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		UserDomainManagerException exception = new UserDomainManagerException("Error Occured");
		
		checkIdOfUserDomain(userContext, userDomainId, exception);
		checkVersionOfUserDomain(userContext, userDomainVersion, exception);
		

		if(UserDomain.NAME_PROPERTY.equals(property)){
			checkNameOfUserDomain(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public UserDomain clone(RetailScmUserContext userContext, String fromUserDomainId) throws Exception{
		
		return this.getUserDomainDAO().clone(fromUserDomainId, this.allTokens());
	}
	
	public UserDomain updateUserDomain(RetailScmUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserDomain(userContext, userDomainId, userDomainVersion, property, newValueExpr, tokensExpr);
		
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		if(userDomain.getVersion() != userDomainVersion){
			String message = "The target version("+userDomain.getVersion()+") is not equals to version("+userDomainVersion+") provided";
			throw new UserDomainManagerException(message);
		}
		synchronized(userDomain){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserDomain.
			
			userDomain.changePropery(property, newValueExpr);
			userDomain = saveUserDomain(userContext, userDomain, tokens().done());
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
			//return saveUserDomain(userContext, userDomain, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected UserDomainTokens tokens(){
		return UserDomainTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserDomainTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserDomainTokens.mergeAll(tokens).done();
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
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String userDomainId, int userDomainVersion) throws Exception {
		
		deleteInternal(userContext, userDomainId, userDomainVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String userDomainId, int userDomainVersion) throws Exception{
		getUserDomainDAO().delete(userDomainId, userDomainVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserDomainManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getUserDomainDAO().deleteAll();
	}

	protected void checkParamsForAddingSecUser(RetailScmUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, Date lastLogin,String [] tokensExpr) throws Exception{
		
		

		UserDomainManagerException exception = new UserDomainManagerException("Error Occured");
		
		checkIdOfUserDomain(userContext, userDomainId, exception);

		checkLoginOfSecUser(userContext,  login, exception);
		checkMobileOfSecUser(userContext,  mobile, exception);
		checkEmailOfSecUser(userContext,  email, exception);
		checkPwdOfSecUser(userContext,  pwd, exception);
		checkLastLoginOfSecUser(userContext,  lastLogin, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  UserDomain addSecUser(RetailScmUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, Date lastLogin, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSecUser(userContext,userDomainId,login, mobile, email, pwd, lastLogin,tokensExpr);
		
		SecUser secUser = createSecUser(userContext,login, mobile, email, pwd, lastLogin);
		
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		synchronized(userDomain){ 
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userDomain.addSecUser( secUser );		
			userDomain = saveUserDomain(userContext, userDomain, tokens().withSecUserList().done());
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}
	}
	protected SecUser createSecUser(RetailScmUserContext userContext, String login, String mobile, String email, String pwd, Date lastLogin) throws Exception{

		SecUser secUser = new SecUser();
		
		
		secUser.setLogin(login);		
		secUser.setMobile(mobile);		
		secUser.setEmail(email);		
		secUser.setClearTextOfPwd(pwd);		
		secUser.setLastLogin(lastLogin);
	
		
		return secUser;
	
		
	}
	
	protected SecUser createIndexedSecUser(String id, int version){

		SecUser secUser = new SecUser();
		secUser.setId(id);
		secUser.setVersion(version);
		return secUser;			
		
	}
	protected void checkParamsForRemovingSecUser(RetailScmUserContext userContext, String userDomainId, 
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		

		UserDomainManagerException exception = new UserDomainManagerException("Error Occured");
		
		checkIdOfUserDomain(userContext, userDomainId, exception);
		checkIdOfSecUser(userContext, secUserId, exception);
		checkVersionOfSecUser(userContext, secUserVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  UserDomain removeSecUser(RetailScmUserContext userContext, String userDomainId, 
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSecUser(userContext,userDomainId, secUserId, secUserVersion,tokensExpr);
		
		SecUser secUser = createIndexedSecUser(secUserId, secUserVersion);
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		synchronized(userDomain){ 
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userDomain.removeSecUser( secUser );		
			userDomain = saveUserDomain(userContext, userDomain, tokens().withSecUserList().done());
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSecUser(RetailScmUserContext userContext, String userDomainId, 
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		

		UserDomainManagerException exception = new UserDomainManagerException("Error Occured");
		
		checkIdOfUserDomain(userContext, userDomainId, exception);
		checkIdOfSecUser(userContext, secUserId, exception);
		checkVersionOfSecUser(userContext, secUserVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  UserDomain copySecUserFrom(RetailScmUserContext userContext, String userDomainId, 
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSecUser(userContext,userDomainId, secUserId, secUserVersion,tokensExpr);
		
		SecUser secUser = createIndexedSecUser(secUserId, secUserVersion);
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		synchronized(userDomain){ 
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userDomain.copySecUserFrom( secUser );		
			userDomain = saveUserDomain(userContext, userDomain, tokens().withSecUserList().done());
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSecUser(RetailScmUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		UserDomainManagerException exception = new UserDomainManagerException("Error Occured");
		
		checkIdOfUserDomain(userContext, userDomainId, exception);
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
	
	public  UserDomain updateSecUser(RetailScmUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSecUser(userContext, userDomainId, secUserId, secUserVersion, property, newValueExpr,  tokensExpr);
		
		
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		
		synchronized(userDomain){ 
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userDomain.removeSecUser( secUser );	
			//make changes to AcceleraterAccount.
			SecUser secUserIndex = createIndexedSecUser(secUserId, secUserVersion);
		
			SecUser secUser = userDomain.findTheSecUser(secUserIndex);
			if(secUser == null){
				throw new UserDomainManagerException(secUser+"Not found" );
			}
			
			secUser.changePropery(property, newValueExpr);

			userDomain = saveUserDomain(userContext, userDomain, tokens().withSecUserList().done());
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


