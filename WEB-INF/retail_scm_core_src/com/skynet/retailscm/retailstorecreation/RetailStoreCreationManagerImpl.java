
package com.skynet.retailscm.retailstorecreation;

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




public class RetailStoreCreationManagerImpl extends RetailScmCheckerManager implements RetailStoreCreationManager {
	
	private static final String SERVICE_TYPE = "RetailStoreCreation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreCreationDAO  retailStoreCreationDAO;
 	public void setRetailStoreCreationDAO(RetailStoreCreationDAO  retailStoreCreationDAO){
 	
 		if(retailStoreCreationDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCreationDAO to null.");
 		}
	 	this.retailStoreCreationDAO = retailStoreCreationDAO;
 	}
 	public RetailStoreCreationDAO getRetailStoreCreationDAO(){
 		if(this.retailStoreCreationDAO == null){
 			throw new IllegalStateException("The RetailStoreCreationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreCreationDAO;
 	}
 	
 	protected RetailStoreCreation saveRetailStoreCreation(RetailScmUserContext userContext, RetailStoreCreation retailStoreCreation, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreCreationDAO().save(retailStoreCreation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreCreation(userContext, retailStoreCreation, tokens);
 	}
 	
 	protected RetailStoreCreation saveRetailStoreCreationDetail(RetailScmUserContext userContext, RetailStoreCreation retailStoreCreation) throws Exception{	

 		
 		return saveRetailStoreCreation(userContext, retailStoreCreation, allTokens());
 	}
 	
 	public RetailStoreCreation loadRetailStoreCreation(RetailScmUserContext userContext, String retailStoreCreationId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreCreationManagerException exception = new RetailStoreCreationManagerException("Error Occured");
		
		checkIdOfRetailStoreCreation(userContext, retailStoreCreationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation( userContext, retailStoreCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreCreation, tokens);
 	}
 	
 	protected RetailStoreCreation present(RetailScmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreCreation,tokens);
		
		
		return this.getRetailStoreCreationDAO().present(retailStoreCreation, tokens);
	}
 
 	
 	
 	public RetailStoreCreation loadRetailStoreCreationDetail(RetailScmUserContext userContext, String retailStoreCreationId) throws Exception{	
 		RetailStoreCreationManagerException exception = new RetailStoreCreationManagerException("Error Occured");
		
		checkIdOfRetailStoreCreation(userContext, retailStoreCreationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation( userContext, retailStoreCreationId, allTokens());

 		return present(userContext,retailStoreCreation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreCreationId) throws Exception{	
 		RetailStoreCreationManagerException exception = new RetailStoreCreationManagerException("Error Occured");
		
		checkIdOfRetailStoreCreation(userContext, retailStoreCreationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation( userContext, retailStoreCreationId, allTokens());

 		return present(userContext,retailStoreCreation, allTokens());
		
 	}
 	protected RetailStoreCreation saveRetailStoreCreation(RetailScmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreCreationDAO().save(retailStoreCreation, tokens);
 	}
 	protected RetailStoreCreation loadRetailStoreCreation(RetailScmUserContext userContext, String retailStoreCreationId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreCreationDAO().load(retailStoreCreationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreCreation, tokens);
		
		addAction(userContext, retailStoreCreation, tokens,"@create","createRetailStoreCreation","createRetailStoreCreation/","main","primary");
		addAction(userContext, retailStoreCreation, tokens,"@update","updateRetailStoreCreation","updateRetailStoreCreation/"+retailStoreCreation.getId()+"/","main","primary");
		addAction(userContext, retailStoreCreation, tokens,"@copy","cloneRetailStoreCreation","cloneRetailStoreCreation/"+retailStoreCreation.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreCreation, tokens,"retail_store_creation.addRetailStore","addRetailStore","addRetailStore/"+retailStoreCreation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCreation, tokens,"retail_store_creation.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreCreation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCreation, tokens,"retail_store_creation.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreCreation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCreation, tokens,"retail_store_creation.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreCreation.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreCreation createRetailStoreCreation(RetailScmUserContext userContext,String comment
) throws Exception
	{
		
		RetailStoreCreationManagerException exception = new RetailStoreCreationManagerException("Error Occured");

		

		checkCommentOfRetailStoreCreation(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreCreation retailStoreCreation=createNewRetailStoreCreation();	

		retailStoreCreation.setComment(comment);

		return saveRetailStoreCreation(userContext, retailStoreCreation, emptyOptions());
		

		
	}
	protected RetailStoreCreation createNewRetailStoreCreation() 
	{
		
		return new RetailStoreCreation();		
	}
	
	protected void checkParamsForUpdatingRetailStoreCreation(RetailScmUserContext userContext,String retailStoreCreationId, int retailStoreCreationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreCreationManagerException exception = new RetailStoreCreationManagerException("Error Occured");
		
		checkIdOfRetailStoreCreation(userContext, retailStoreCreationId, exception);
		checkVersionOfRetailStoreCreation(userContext, retailStoreCreationVersion, exception);
		

		if(RetailStoreCreation.COMMENT_PROPERTY.equals(property)){
			checkCommentOfRetailStoreCreation(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreCreation clone(RetailScmUserContext userContext, String fromRetailStoreCreationId) throws Exception{
		
		return this.getRetailStoreCreationDAO().clone(fromRetailStoreCreationId, this.allTokens());
	}
	
	public RetailStoreCreation updateRetailStoreCreation(RetailScmUserContext userContext,String retailStoreCreationId, int retailStoreCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreCreation(userContext, retailStoreCreationId, retailStoreCreationVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		if(retailStoreCreation.getVersion() != retailStoreCreationVersion){
			String message = "The target version("+retailStoreCreation.getVersion()+") is not equals to version("+retailStoreCreationVersion+") provided";
			throw new RetailStoreCreationManagerException(message);
		}
		synchronized(retailStoreCreation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreCreation.
			
			retailStoreCreation.changePropery(property, newValueExpr);
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
			//return saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreCreationTokens tokens(){
		return RetailStoreCreationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreCreationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreCreationTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreCreationId, int retailStoreCreationVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreCreationId, retailStoreCreationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreCreationId, int retailStoreCreationVersion) throws Exception{
		getRetailStoreCreationDAO().delete(retailStoreCreationId, retailStoreCreationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreCreationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreCreationDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCreationManagerException exception = new RetailStoreCreationManagerException("Error Occured");
		
		checkIdOfRetailStoreCreation(userContext, retailStoreCreationId, exception);

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
	public  RetailStoreCreation addRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreCreationId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		synchronized(retailStoreCreation){ 
			//Will be good when the retailStoreCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCreation.addRetailStore( retailStore );		
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCreationManagerException exception = new RetailStoreCreationManagerException("Error Occured");
		
		checkIdOfRetailStoreCreation(userContext, retailStoreCreationId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCreation removeRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreCreationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		synchronized(retailStoreCreation){ 
			//Will be good when the retailStoreCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCreation.removeRetailStore( retailStore );		
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCreationManagerException exception = new RetailStoreCreationManagerException("Error Occured");
		
		checkIdOfRetailStoreCreation(userContext, retailStoreCreationId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCreation copyRetailStoreFrom(RetailScmUserContext userContext, String retailStoreCreationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreCreationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		synchronized(retailStoreCreation){ 
			//Will be good when the retailStoreCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCreation.copyRetailStoreFrom( retailStore );		
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCreationManagerException exception = new RetailStoreCreationManagerException("Error Occured");
		
		checkIdOfRetailStoreCreation(userContext, retailStoreCreationId, exception);
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
	
	public  RetailStoreCreation updateRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreCreationId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		
		synchronized(retailStoreCreation){ 
			//Will be good when the retailStoreCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCreation.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreCreation.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreCreationManagerException(retailStore+"Not found" );
			}
			
			retailStore.changePropery(property, newValueExpr);

			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


