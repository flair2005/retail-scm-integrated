
package com.skynet.retailscm.retailstoredecoration;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstore.RetailStore;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpening;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosing;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreation;


import com.skynet.retailscm.retailstore.RetailStoreTable;




public class RetailStoreDecorationManagerImpl extends RetailScmCheckerManager implements RetailStoreDecorationManager {
	
	private static final String SERVICE_TYPE = "RetailStoreDecoration";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreDecorationDAO  retailStoreDecorationDAO;
 	public void setRetailStoreDecorationDAO(RetailStoreDecorationDAO  retailStoreDecorationDAO){
 	
 		if(retailStoreDecorationDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDecorationDAO to null.");
 		}
	 	this.retailStoreDecorationDAO = retailStoreDecorationDAO;
 	}
 	public RetailStoreDecorationDAO getRetailStoreDecorationDAO(){
 		if(this.retailStoreDecorationDAO == null){
 			throw new IllegalStateException("The RetailStoreDecorationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDecorationDAO;
 	}
 	
 	protected RetailStoreDecoration saveRetailStoreDecoration(RetailScmUserContext userContext, RetailStoreDecoration retailStoreDecoration, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreDecorationDAO().save(retailStoreDecoration, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens);
 	}
 	
 	protected RetailStoreDecoration saveRetailStoreDecorationDetail(RetailScmUserContext userContext, RetailStoreDecoration retailStoreDecoration) throws Exception{	

 		
 		return saveRetailStoreDecoration(userContext, retailStoreDecoration, allTokens());
 	}
 	
 	public RetailStoreDecoration loadRetailStoreDecoration(RetailScmUserContext userContext, String retailStoreDecorationId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreDecorationManagerException exception = new RetailStoreDecorationManagerException("Error Occured");
		
		checkIdOfRetailStoreDecoration(userContext, retailStoreDecorationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration( userContext, retailStoreDecorationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreDecoration, tokens);
 	}
 	
 	protected RetailStoreDecoration present(RetailScmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreDecoration,tokens);
		
		
		return this.getRetailStoreDecorationDAO().present(retailStoreDecoration, tokens);
	}
 
 	
 	
 	public RetailStoreDecoration loadRetailStoreDecorationDetail(RetailScmUserContext userContext, String retailStoreDecorationId) throws Exception{	
 		RetailStoreDecorationManagerException exception = new RetailStoreDecorationManagerException("Error Occured");
		
		checkIdOfRetailStoreDecoration(userContext, retailStoreDecorationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration( userContext, retailStoreDecorationId, allTokens());

 		return present(userContext,retailStoreDecoration, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreDecorationId) throws Exception{	
 		RetailStoreDecorationManagerException exception = new RetailStoreDecorationManagerException("Error Occured");
		
		checkIdOfRetailStoreDecoration(userContext, retailStoreDecorationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration( userContext, retailStoreDecorationId, allTokens());

 		return present(userContext,retailStoreDecoration, allTokens());
		
 	}
 	protected RetailStoreDecoration saveRetailStoreDecoration(RetailScmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreDecorationDAO().save(retailStoreDecoration, tokens);
 	}
 	protected RetailStoreDecoration loadRetailStoreDecoration(RetailScmUserContext userContext, String retailStoreDecorationId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreDecorationDAO().load(retailStoreDecorationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreDecoration, tokens);
		
		addAction(userContext, retailStoreDecoration, tokens,"@create","createRetailStoreDecoration","createRetailStoreDecoration/","main","primary");
		addAction(userContext, retailStoreDecoration, tokens,"@update","updateRetailStoreDecoration","updateRetailStoreDecoration/"+retailStoreDecoration.getId()+"/","main","primary");
		addAction(userContext, retailStoreDecoration, tokens,"@copy","cloneRetailStoreDecoration","cloneRetailStoreDecoration/"+retailStoreDecoration.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreDecoration, tokens,"retail_store_decoration.addRetailStore","addRetailStore","addRetailStore/"+retailStoreDecoration.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreDecoration, tokens,"retail_store_decoration.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreDecoration.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreDecoration, tokens,"retail_store_decoration.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreDecoration.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreDecoration, tokens,"retail_store_decoration.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreDecoration.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreDecoration createRetailStoreDecoration(RetailScmUserContext userContext,String comment
) throws Exception
	{
		
		RetailStoreDecorationManagerException exception = new RetailStoreDecorationManagerException("Error Occured");

		

		checkCommentOfRetailStoreDecoration(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreDecoration retailStoreDecoration=createNewRetailStoreDecoration();	

		retailStoreDecoration.setComment(comment);

		return saveRetailStoreDecoration(userContext, retailStoreDecoration, emptyOptions());
		

		
	}
	protected RetailStoreDecoration createNewRetailStoreDecoration() 
	{
		
		return new RetailStoreDecoration();		
	}
	
	protected void checkParamsForUpdatingRetailStoreDecoration(RetailScmUserContext userContext,String retailStoreDecorationId, int retailStoreDecorationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreDecorationManagerException exception = new RetailStoreDecorationManagerException("Error Occured");
		
		checkIdOfRetailStoreDecoration(userContext, retailStoreDecorationId, exception);
		checkVersionOfRetailStoreDecoration(userContext, retailStoreDecorationVersion, exception);
		

		if(RetailStoreDecoration.COMMENT_PROPERTY.equals(property)){
			checkCommentOfRetailStoreDecoration(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreDecoration clone(RetailScmUserContext userContext, String fromRetailStoreDecorationId) throws Exception{
		
		return this.getRetailStoreDecorationDAO().clone(fromRetailStoreDecorationId, this.allTokens());
	}
	
	public RetailStoreDecoration updateRetailStoreDecoration(RetailScmUserContext userContext,String retailStoreDecorationId, int retailStoreDecorationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreDecoration(userContext, retailStoreDecorationId, retailStoreDecorationVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		if(retailStoreDecoration.getVersion() != retailStoreDecorationVersion){
			String message = "The target version("+retailStoreDecoration.getVersion()+") is not equals to version("+retailStoreDecorationVersion+") provided";
			throw new RetailStoreDecorationManagerException(message);
		}
		synchronized(retailStoreDecoration){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreDecoration.
			
			retailStoreDecoration.changePropery(property, newValueExpr);
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
			//return saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreDecorationTokens tokens(){
		return RetailStoreDecorationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreDecorationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreDecorationTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreDecorationId, int retailStoreDecorationVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreDecorationId, retailStoreDecorationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreDecorationId, int retailStoreDecorationVersion) throws Exception{
		getRetailStoreDecorationDAO().delete(retailStoreDecorationId, retailStoreDecorationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreDecorationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreDecorationDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreDecorationManagerException exception = new RetailStoreDecorationManagerException("Error Occured");
		
		checkIdOfRetailStoreDecoration(userContext, retailStoreDecorationId, exception);

		checkNameOfRetailStore(userContext,  name, exception);
		checkTelephoneOfRetailStore(userContext,  telephone, exception);
		checkOwnerOfRetailStore(userContext,  owner, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  retailStoreCountryCenterId, exception);		
		
		checkIdOfRetailStoreCityServiceCenter(userContext,  cityServiceCenterId, exception);
		checkFoundedOfRetailStore(userContext,  founded, exception);
		checkLatitudeOfRetailStore(userContext,  latitude, exception);
		checkLongitudeOfRetailStore(userContext,  longitude, exception);
		checkDescriptionOfRetailStore(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreDecoration addRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreDecorationId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		synchronized(retailStoreDecoration){ 
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreDecoration.addRetailStore( retailStore );		
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStore createRetailStore(RetailScmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description) throws Exception{

		RetailStore retailStore = new RetailStore();
		
		
		retailStore.setName(name);		
		retailStore.setTelephone(telephone);		
		retailStore.setOwner(owner);		
		RetailStoreCountryCenter  retailStoreCountryCenter = new RetailStoreCountryCenter();
		retailStoreCountryCenter.setId(retailStoreCountryCenterId);		
		retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);		
		RetailStoreCityServiceCenter  cityServiceCenter = new RetailStoreCityServiceCenter();
		cityServiceCenter.setId(cityServiceCenterId);		
		retailStore.setCityServiceCenter(cityServiceCenter);		
		retailStore.setFounded(founded);		
		retailStore.setLatitude(latitude);		
		retailStore.setLongitude(longitude);		
		retailStore.setDescription(description);
	
		
		return retailStore;
	
		
	}
	
	protected RetailStore createIndexedRetailStore(String id, int version){

		RetailStore retailStore = new RetailStore();
		retailStore.setId(id);
		retailStore.setVersion(version);
		return retailStore;			
		
	}
	protected void checkParamsForRemovingRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreDecorationManagerException exception = new RetailStoreDecorationManagerException("Error Occured");
		
		checkIdOfRetailStoreDecoration(userContext, retailStoreDecorationId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreDecoration removeRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreDecorationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		synchronized(retailStoreDecoration){ 
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreDecoration.removeRetailStore( retailStore );		
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreDecorationManagerException exception = new RetailStoreDecorationManagerException("Error Occured");
		
		checkIdOfRetailStoreDecoration(userContext, retailStoreDecorationId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreDecoration copyRetailStoreFrom(RetailScmUserContext userContext, String retailStoreDecorationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreDecorationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		synchronized(retailStoreDecoration){ 
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreDecoration.copyRetailStoreFrom( retailStore );		
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreDecorationManagerException exception = new RetailStoreDecorationManagerException("Error Occured");
		
		checkIdOfRetailStoreDecoration(userContext, retailStoreDecorationId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);
		

		if(RetailStore.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
			checkTelephoneOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStore.OWNER_PROPERTY.equals(property)){
			checkOwnerOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfRetailStore(userContext, parseDate(newValueExpr), exception);
		}
		
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfRetailStore(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfRetailStore(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreDecoration updateRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreDecorationId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		
		synchronized(retailStoreDecoration){ 
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreDecoration.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreDecoration.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreDecorationManagerException(retailStore+"Not found" );
			}
			
			retailStore.changePropery(property, newValueExpr);

			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


