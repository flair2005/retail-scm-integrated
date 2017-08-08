
package com.skynet.retailscm.retailstoreopening;

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




public class RetailStoreOpeningManagerImpl extends RetailScmCheckerManager implements RetailStoreOpeningManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOpening";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOpeningDAO  retailStoreOpeningDAO;
 	public void setRetailStoreOpeningDAO(RetailStoreOpeningDAO  retailStoreOpeningDAO){
 	
 		if(retailStoreOpeningDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOpeningDAO to null.");
 		}
	 	this.retailStoreOpeningDAO = retailStoreOpeningDAO;
 	}
 	public RetailStoreOpeningDAO getRetailStoreOpeningDAO(){
 		if(this.retailStoreOpeningDAO == null){
 			throw new IllegalStateException("The RetailStoreOpeningDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOpeningDAO;
 	}
 	
 	protected RetailStoreOpening saveRetailStoreOpening(RetailScmUserContext userContext, RetailStoreOpening retailStoreOpening, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOpeningDAO().save(retailStoreOpening, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOpening(userContext, retailStoreOpening, tokens);
 	}
 	
 	protected RetailStoreOpening saveRetailStoreOpeningDetail(RetailScmUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception{	

 		
 		return saveRetailStoreOpening(userContext, retailStoreOpening, allTokens());
 	}
 	
 	public RetailStoreOpening loadRetailStoreOpening(RetailScmUserContext userContext, String retailStoreOpeningId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOpeningManagerException exception = new RetailStoreOpeningManagerException("Error Occured");
		
		checkIdOfRetailStoreOpening(userContext, retailStoreOpeningId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOpening, tokens);
 	}
 	
 	protected RetailStoreOpening present(RetailScmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOpening,tokens);
		
		
		return this.getRetailStoreOpeningDAO().present(retailStoreOpening, tokens);
	}
 
 	
 	
 	public RetailStoreOpening loadRetailStoreOpeningDetail(RetailScmUserContext userContext, String retailStoreOpeningId) throws Exception{	
 		RetailStoreOpeningManagerException exception = new RetailStoreOpeningManagerException("Error Occured");
		
		checkIdOfRetailStoreOpening(userContext, retailStoreOpeningId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, allTokens());

 		return present(userContext,retailStoreOpening, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOpeningId) throws Exception{	
 		RetailStoreOpeningManagerException exception = new RetailStoreOpeningManagerException("Error Occured");
		
		checkIdOfRetailStoreOpening(userContext, retailStoreOpeningId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, allTokens());

 		return present(userContext,retailStoreOpening, allTokens());
		
 	}
 	protected RetailStoreOpening saveRetailStoreOpening(RetailScmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOpeningDAO().save(retailStoreOpening, tokens);
 	}
 	protected RetailStoreOpening loadRetailStoreOpening(RetailScmUserContext userContext, String retailStoreOpeningId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOpeningDAO().load(retailStoreOpeningId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOpening, tokens);
		
		addAction(userContext, retailStoreOpening, tokens,"@create","createRetailStoreOpening","createRetailStoreOpening/","main","primary");
		addAction(userContext, retailStoreOpening, tokens,"@update","updateRetailStoreOpening","updateRetailStoreOpening/"+retailStoreOpening.getId()+"/","main","primary");
		addAction(userContext, retailStoreOpening, tokens,"@copy","cloneRetailStoreOpening","cloneRetailStoreOpening/"+retailStoreOpening.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.addRetailStore","addRetailStore","addRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOpening createRetailStoreOpening(RetailScmUserContext userContext,String comment
) throws Exception
	{
		
		RetailStoreOpeningManagerException exception = new RetailStoreOpeningManagerException("Error Occured");

		

		checkCommentOfRetailStoreOpening(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOpening retailStoreOpening=createNewRetailStoreOpening();	

		retailStoreOpening.setComment(comment);

		return saveRetailStoreOpening(userContext, retailStoreOpening, emptyOptions());
		

		
	}
	protected RetailStoreOpening createNewRetailStoreOpening() 
	{
		
		return new RetailStoreOpening();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOpening(RetailScmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOpeningManagerException exception = new RetailStoreOpeningManagerException("Error Occured");
		
		checkIdOfRetailStoreOpening(userContext, retailStoreOpeningId, exception);
		checkVersionOfRetailStoreOpening(userContext, retailStoreOpeningVersion, exception);
		

		if(RetailStoreOpening.COMMENT_PROPERTY.equals(property)){
			checkCommentOfRetailStoreOpening(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreOpening clone(RetailScmUserContext userContext, String fromRetailStoreOpeningId) throws Exception{
		
		return this.getRetailStoreOpeningDAO().clone(fromRetailStoreOpeningId, this.allTokens());
	}
	
	public RetailStoreOpening updateRetailStoreOpening(RetailScmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		if(retailStoreOpening.getVersion() != retailStoreOpeningVersion){
			String message = "The target version("+retailStoreOpening.getVersion()+") is not equals to version("+retailStoreOpeningVersion+") provided";
			throw new RetailStoreOpeningManagerException(message);
		}
		synchronized(retailStoreOpening){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.
			
			retailStoreOpening.changePropery(property, newValueExpr);
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOpeningTokens tokens(){
		return RetailStoreOpeningTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOpeningTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOpeningTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOpeningId, retailStoreOpeningVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception{
		getRetailStoreOpeningDAO().delete(retailStoreOpeningId, retailStoreOpeningVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOpeningManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOpeningDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOpeningManagerException exception = new RetailStoreOpeningManagerException("Error Occured");
		
		checkIdOfRetailStoreOpening(userContext, retailStoreOpeningId, exception);

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
	public  RetailStoreOpening addRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreOpeningId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){ 
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOpening.addRetailStore( retailStore );		
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOpeningManagerException exception = new RetailStoreOpeningManagerException("Error Occured");
		
		checkIdOfRetailStoreOpening(userContext, retailStoreOpeningId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOpening removeRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreOpeningId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){ 
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOpening.removeRetailStore( retailStore );		
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOpeningManagerException exception = new RetailStoreOpeningManagerException("Error Occured");
		
		checkIdOfRetailStoreOpening(userContext, retailStoreOpeningId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOpening copyRetailStoreFrom(RetailScmUserContext userContext, String retailStoreOpeningId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreOpeningId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){ 
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOpening.copyRetailStoreFrom( retailStore );		
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOpeningManagerException exception = new RetailStoreOpeningManagerException("Error Occured");
		
		checkIdOfRetailStoreOpening(userContext, retailStoreOpeningId, exception);
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
	
	public  RetailStoreOpening updateRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreOpeningId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		
		synchronized(retailStoreOpening){ 
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOpening.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreOpening.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreOpeningManagerException(retailStore+"Not found" );
			}
			
			retailStore.changePropery(property, newValueExpr);

			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


