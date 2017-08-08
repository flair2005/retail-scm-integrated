
package com.skynet.retailscm.objectaccess;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.userapp.UserApp;

import com.skynet.retailscm.userapp.UserAppDAO;



import com.skynet.retailscm.userapp.UserAppTable;




public class ObjectAccessManagerImpl extends RetailScmCheckerManager implements ObjectAccessManager {
	
	private static final String SERVICE_TYPE = "ObjectAccess";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ObjectAccessDAO  objectAccessDAO;
 	public void setObjectAccessDAO(ObjectAccessDAO  objectAccessDAO){
 	
 		if(objectAccessDAO == null){
 			throw new IllegalStateException("Do not try to set objectAccessDAO to null.");
 		}
	 	this.objectAccessDAO = objectAccessDAO;
 	}
 	public ObjectAccessDAO getObjectAccessDAO(){
 		if(this.objectAccessDAO == null){
 			throw new IllegalStateException("The ObjectAccessDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.objectAccessDAO;
 	}
 	
 	protected ObjectAccess saveObjectAccess(RetailScmUserContext userContext, ObjectAccess objectAccess, String [] tokensExpr) throws Exception{	
 		//return getObjectAccessDAO().save(objectAccess, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveObjectAccess(userContext, objectAccess, tokens);
 	}
 	
 	protected ObjectAccess saveObjectAccessDetail(RetailScmUserContext userContext, ObjectAccess objectAccess) throws Exception{	

 		
 		return saveObjectAccess(userContext, objectAccess, allTokens());
 	}
 	
 	public ObjectAccess loadObjectAccess(RetailScmUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception{				
 
 		ObjectAccessManagerException exception = new ObjectAccessManagerException("Error Occured");
		
		checkIdOfObjectAccess(userContext, objectAccessId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,objectAccess, tokens);
 	}
 	
 	protected ObjectAccess present(RetailScmUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,objectAccess,tokens);
		
		
		return this.getObjectAccessDAO().present(objectAccess, tokens);
	}
 
 	
 	
 	public ObjectAccess loadObjectAccessDetail(RetailScmUserContext userContext, String objectAccessId) throws Exception{	
 		ObjectAccessManagerException exception = new ObjectAccessManagerException("Error Occured");
		
		checkIdOfObjectAccess(userContext, objectAccessId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, allTokens());

 		return present(userContext,objectAccess, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String objectAccessId) throws Exception{	
 		ObjectAccessManagerException exception = new ObjectAccessManagerException("Error Occured");
		
		checkIdOfObjectAccess(userContext, objectAccessId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, allTokens());

 		return present(userContext,objectAccess, allTokens());
		
 	}
 	protected ObjectAccess saveObjectAccess(RetailScmUserContext userContext, ObjectAccess objectAccess, Map<String,Object>tokens) throws Exception{	
 		return getObjectAccessDAO().save(objectAccess, tokens);
 	}
 	protected ObjectAccess loadObjectAccess(RetailScmUserContext userContext, String objectAccessId, Map<String,Object>tokens) throws Exception{	
 		return getObjectAccessDAO().load(objectAccessId, tokens);
 	}

	



 	 
 	
 	private  UserAppDAO  userAppDAO;
 	public void setUserAppDAO(UserAppDAO userAppDAO){
	 	this.userAppDAO = userAppDAO;
 	}
 	//------------------------------------
 	public UserAppDAO getUserAppDAO(){
	 	return this.userAppDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens){
		super.addActions(userContext, objectAccess, tokens);
		
		addAction(userContext, objectAccess, tokens,"@create","createObjectAccess","createObjectAccess/","main","primary");
		addAction(userContext, objectAccess, tokens,"@update","updateObjectAccess","updateObjectAccess/"+objectAccess.getId()+"/","main","primary");
		addAction(userContext, objectAccess, tokens,"@copy","cloneObjectAccess","cloneObjectAccess/"+objectAccess.getId()+"/","main","primary");
		
		addAction(userContext, objectAccess, tokens,"object_access.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+objectAccess.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ObjectAccess createObjectAccess(RetailScmUserContext userContext,String displayName, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId
) throws Exception
	{
		
		ObjectAccessManagerException exception = new ObjectAccessManagerException("Error Occured");

		

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


		ObjectAccess objectAccess=createNewObjectAccess();	

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
		UserApp app = loadUserApp(appId,emptyOptions());
		objectAccess.setApp(app);

		return saveObjectAccess(userContext, objectAccess, emptyOptions());
		

		
	}
	protected ObjectAccess createNewObjectAccess() 
	{
		
		return new ObjectAccess();		
	}
	
	protected void checkParamsForUpdatingObjectAccess(RetailScmUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ObjectAccessManagerException exception = new ObjectAccessManagerException("Error Occured");
		
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
	
	
	
	public ObjectAccess clone(RetailScmUserContext userContext, String fromObjectAccessId) throws Exception{
		
		return this.getObjectAccessDAO().clone(fromObjectAccessId, this.allTokens());
	}
	
	public ObjectAccess updateObjectAccess(RetailScmUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);
		
		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());
		if(objectAccess.getVersion() != objectAccessVersion){
			String message = "The target version("+objectAccess.getVersion()+") is not equals to version("+objectAccessVersion+") provided";
			throw new ObjectAccessManagerException(message);
		}
		synchronized(objectAccess){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.
			
			objectAccess.changePropery(property, newValueExpr);
			objectAccess = saveObjectAccess(userContext, objectAccess, tokens().done());
			return present(userContext,objectAccess, mergedAllTokens(tokensExpr));
			//return saveObjectAccess(userContext, objectAccess, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ObjectAccessTokens tokens(){
		return ObjectAccessTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ObjectAccessTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ObjectAccessTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherApp(RetailScmUserContext userContext, String objectAccessId, String anotherAppId) throws Exception
 	{
 		ObjectAccessManagerException exception = new ObjectAccessManagerException("Error Occured");
 		checkIdOfObjectAccess(userContext, objectAccessId,exception);
 		checkIdOfUserApp(userContext, anotherAppId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ObjectAccess transferToAnotherApp(RetailScmUserContext userContext, String objectAccessId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, objectAccessId,anotherAppId);
 
		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());	
		synchronized(objectAccess){
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(anotherAppId, emptyOptions());		
			objectAccess.setApp(app);		
			objectAccess = saveObjectAccess(userContext, objectAccess, emptyOptions());
			
			return present(userContext,objectAccess, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected UserApp loadUserApp(String newAppId, Map<String,Object> options) throws Exception
 	{
		
 		return getUserAppDAO().load(newAppId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String objectAccessId, int objectAccessVersion) throws Exception {
		
		deleteInternal(userContext, objectAccessId, objectAccessVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String objectAccessId, int objectAccessVersion) throws Exception{
		getObjectAccessDAO().delete(objectAccessId, objectAccessVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ObjectAccessManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getObjectAccessDAO().deleteAll();
	}


}


