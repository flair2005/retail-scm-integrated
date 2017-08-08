
package com.skynet.retailscm.retailstorefranchising;

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




public class RetailStoreFranchisingManagerImpl extends RetailScmCheckerManager implements RetailStoreFranchisingManager {
	
	private static final String SERVICE_TYPE = "RetailStoreFranchising";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreFranchisingDAO  retailStoreFranchisingDAO;
 	public void setRetailStoreFranchisingDAO(RetailStoreFranchisingDAO  retailStoreFranchisingDAO){
 	
 		if(retailStoreFranchisingDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreFranchisingDAO to null.");
 		}
	 	this.retailStoreFranchisingDAO = retailStoreFranchisingDAO;
 	}
 	public RetailStoreFranchisingDAO getRetailStoreFranchisingDAO(){
 		if(this.retailStoreFranchisingDAO == null){
 			throw new IllegalStateException("The RetailStoreFranchisingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreFranchisingDAO;
 	}
 	
 	protected RetailStoreFranchising saveRetailStoreFranchising(RetailScmUserContext userContext, RetailStoreFranchising retailStoreFranchising, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreFranchisingDAO().save(retailStoreFranchising, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens);
 	}
 	
 	protected RetailStoreFranchising saveRetailStoreFranchisingDetail(RetailScmUserContext userContext, RetailStoreFranchising retailStoreFranchising) throws Exception{	

 		
 		return saveRetailStoreFranchising(userContext, retailStoreFranchising, allTokens());
 	}
 	
 	public RetailStoreFranchising loadRetailStoreFranchising(RetailScmUserContext userContext, String retailStoreFranchisingId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreFranchisingManagerException exception = new RetailStoreFranchisingManagerException("Error Occured");
		
		checkIdOfRetailStoreFranchising(userContext, retailStoreFranchisingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreFranchising, tokens);
 	}
 	
 	protected RetailStoreFranchising present(RetailScmUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreFranchising,tokens);
		
		
		return this.getRetailStoreFranchisingDAO().present(retailStoreFranchising, tokens);
	}
 
 	
 	
 	public RetailStoreFranchising loadRetailStoreFranchisingDetail(RetailScmUserContext userContext, String retailStoreFranchisingId) throws Exception{	
 		RetailStoreFranchisingManagerException exception = new RetailStoreFranchisingManagerException("Error Occured");
		
		checkIdOfRetailStoreFranchising(userContext, retailStoreFranchisingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, allTokens());

 		return present(userContext,retailStoreFranchising, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreFranchisingId) throws Exception{	
 		RetailStoreFranchisingManagerException exception = new RetailStoreFranchisingManagerException("Error Occured");
		
		checkIdOfRetailStoreFranchising(userContext, retailStoreFranchisingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, allTokens());

 		return present(userContext,retailStoreFranchising, allTokens());
		
 	}
 	protected RetailStoreFranchising saveRetailStoreFranchising(RetailScmUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreFranchisingDAO().save(retailStoreFranchising, tokens);
 	}
 	protected RetailStoreFranchising loadRetailStoreFranchising(RetailScmUserContext userContext, String retailStoreFranchisingId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreFranchisingDAO().load(retailStoreFranchisingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreFranchising, tokens);
		
		addAction(userContext, retailStoreFranchising, tokens,"@create","createRetailStoreFranchising","createRetailStoreFranchising/","main","primary");
		addAction(userContext, retailStoreFranchising, tokens,"@update","updateRetailStoreFranchising","updateRetailStoreFranchising/"+retailStoreFranchising.getId()+"/","main","primary");
		addAction(userContext, retailStoreFranchising, tokens,"@copy","cloneRetailStoreFranchising","cloneRetailStoreFranchising/"+retailStoreFranchising.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.addRetailStore","addRetailStore","addRetailStore/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreFranchising createRetailStoreFranchising(RetailScmUserContext userContext,String comment
) throws Exception
	{
		
		RetailStoreFranchisingManagerException exception = new RetailStoreFranchisingManagerException("Error Occured");

		

		checkCommentOfRetailStoreFranchising(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreFranchising retailStoreFranchising=createNewRetailStoreFranchising();	

		retailStoreFranchising.setComment(comment);

		return saveRetailStoreFranchising(userContext, retailStoreFranchising, emptyOptions());
		

		
	}
	protected RetailStoreFranchising createNewRetailStoreFranchising() 
	{
		
		return new RetailStoreFranchising();		
	}
	
	protected void checkParamsForUpdatingRetailStoreFranchising(RetailScmUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreFranchisingManagerException exception = new RetailStoreFranchisingManagerException("Error Occured");
		
		checkIdOfRetailStoreFranchising(userContext, retailStoreFranchisingId, exception);
		checkVersionOfRetailStoreFranchising(userContext, retailStoreFranchisingVersion, exception);
		

		if(RetailStoreFranchising.COMMENT_PROPERTY.equals(property)){
			checkCommentOfRetailStoreFranchising(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreFranchising clone(RetailScmUserContext userContext, String fromRetailStoreFranchisingId) throws Exception{
		
		return this.getRetailStoreFranchisingDAO().clone(fromRetailStoreFranchisingId, this.allTokens());
	}
	
	public RetailStoreFranchising updateRetailStoreFranchising(RetailScmUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreFranchising(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		if(retailStoreFranchising.getVersion() != retailStoreFranchisingVersion){
			String message = "The target version("+retailStoreFranchising.getVersion()+") is not equals to version("+retailStoreFranchisingVersion+") provided";
			throw new RetailStoreFranchisingManagerException(message);
		}
		synchronized(retailStoreFranchising){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreFranchising.
			
			retailStoreFranchising.changePropery(property, newValueExpr);
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
			//return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreFranchisingTokens tokens(){
		return RetailStoreFranchisingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreFranchisingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreFranchisingTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception{
		getRetailStoreFranchisingDAO().delete(retailStoreFranchisingId, retailStoreFranchisingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreFranchisingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreFranchisingDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreFranchisingManagerException exception = new RetailStoreFranchisingManagerException("Error Occured");
		
		checkIdOfRetailStoreFranchising(userContext, retailStoreFranchisingId, exception);

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
	public  RetailStoreFranchising addRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreFranchisingId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		synchronized(retailStoreFranchising){ 
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreFranchising.addRetailStore( retailStore );		
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreFranchisingManagerException exception = new RetailStoreFranchisingManagerException("Error Occured");
		
		checkIdOfRetailStoreFranchising(userContext, retailStoreFranchisingId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreFranchising removeRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreFranchisingId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		synchronized(retailStoreFranchising){ 
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreFranchising.removeRetailStore( retailStore );		
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreFranchisingManagerException exception = new RetailStoreFranchisingManagerException("Error Occured");
		
		checkIdOfRetailStoreFranchising(userContext, retailStoreFranchisingId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreFranchising copyRetailStoreFrom(RetailScmUserContext userContext, String retailStoreFranchisingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreFranchisingId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		synchronized(retailStoreFranchising){ 
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreFranchising.copyRetailStoreFrom( retailStore );		
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreFranchisingManagerException exception = new RetailStoreFranchisingManagerException("Error Occured");
		
		checkIdOfRetailStoreFranchising(userContext, retailStoreFranchisingId, exception);
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
	
	public  RetailStoreFranchising updateRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreFranchisingId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		
		synchronized(retailStoreFranchising){ 
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreFranchising.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreFranchising.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreFranchisingManagerException(retailStore+"Not found" );
			}
			
			retailStore.changePropery(property, newValueExpr);

			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


