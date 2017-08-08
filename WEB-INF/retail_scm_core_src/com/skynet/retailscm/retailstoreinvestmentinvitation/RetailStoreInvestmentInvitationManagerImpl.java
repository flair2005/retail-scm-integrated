
package com.skynet.retailscm.retailstoreinvestmentinvitation;

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




public class RetailStoreInvestmentInvitationManagerImpl extends RetailScmCheckerManager implements RetailStoreInvestmentInvitationManager {
	
	private static final String SERVICE_TYPE = "RetailStoreInvestmentInvitation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreInvestmentInvitationDAO  retailStoreInvestmentInvitationDAO;
 	public void setRetailStoreInvestmentInvitationDAO(RetailStoreInvestmentInvitationDAO  retailStoreInvestmentInvitationDAO){
 	
 		if(retailStoreInvestmentInvitationDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreInvestmentInvitationDAO to null.");
 		}
	 	this.retailStoreInvestmentInvitationDAO = retailStoreInvestmentInvitationDAO;
 	}
 	public RetailStoreInvestmentInvitationDAO getRetailStoreInvestmentInvitationDAO(){
 		if(this.retailStoreInvestmentInvitationDAO == null){
 			throw new IllegalStateException("The RetailStoreInvestmentInvitationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreInvestmentInvitationDAO;
 	}
 	
 	protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitation(RetailScmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreInvestmentInvitationDAO().save(retailStoreInvestmentInvitation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens);
 	}
 	
 	protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitationDetail(RetailScmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation) throws Exception{	

 		
 		return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, allTokens());
 	}
 	
 	public RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreInvestmentInvitationManagerException exception = new RetailStoreInvestmentInvitationManagerException("Error Occured");
		
		checkIdOfRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation( userContext, retailStoreInvestmentInvitationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreInvestmentInvitation, tokens);
 	}
 	
 	protected RetailStoreInvestmentInvitation present(RetailScmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreInvestmentInvitation,tokens);
		
		
		return this.getRetailStoreInvestmentInvitationDAO().present(retailStoreInvestmentInvitation, tokens);
	}
 
 	
 	
 	public RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitationDetail(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId) throws Exception{	
 		RetailStoreInvestmentInvitationManagerException exception = new RetailStoreInvestmentInvitationManagerException("Error Occured");
		
		checkIdOfRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation( userContext, retailStoreInvestmentInvitationId, allTokens());

 		return present(userContext,retailStoreInvestmentInvitation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId) throws Exception{	
 		RetailStoreInvestmentInvitationManagerException exception = new RetailStoreInvestmentInvitationManagerException("Error Occured");
		
		checkIdOfRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation( userContext, retailStoreInvestmentInvitationId, allTokens());

 		return present(userContext,retailStoreInvestmentInvitation, allTokens());
		
 	}
 	protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitation(RetailScmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreInvestmentInvitationDAO().save(retailStoreInvestmentInvitation, tokens);
 	}
 	protected RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreInvestmentInvitationDAO().load(retailStoreInvestmentInvitationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreInvestmentInvitation, tokens);
		
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"@create","createRetailStoreInvestmentInvitation","createRetailStoreInvestmentInvitation/","main","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"@update","updateRetailStoreInvestmentInvitation","updateRetailStoreInvestmentInvitation/"+retailStoreInvestmentInvitation.getId()+"/","main","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"@copy","cloneRetailStoreInvestmentInvitation","cloneRetailStoreInvestmentInvitation/"+retailStoreInvestmentInvitation.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"retail_store_investment_invitation.addRetailStore","addRetailStore","addRetailStore/"+retailStoreInvestmentInvitation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"retail_store_investment_invitation.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreInvestmentInvitation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"retail_store_investment_invitation.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreInvestmentInvitation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"retail_store_investment_invitation.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreInvestmentInvitation.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(RetailScmUserContext userContext,String comment
) throws Exception
	{
		
		RetailStoreInvestmentInvitationManagerException exception = new RetailStoreInvestmentInvitationManagerException("Error Occured");

		

		checkCommentOfRetailStoreInvestmentInvitation(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation=createNewRetailStoreInvestmentInvitation();	

		retailStoreInvestmentInvitation.setComment(comment);

		return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, emptyOptions());
		

		
	}
	protected RetailStoreInvestmentInvitation createNewRetailStoreInvestmentInvitation() 
	{
		
		return new RetailStoreInvestmentInvitation();		
	}
	
	protected void checkParamsForUpdatingRetailStoreInvestmentInvitation(RetailScmUserContext userContext,String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreInvestmentInvitationManagerException exception = new RetailStoreInvestmentInvitationManagerException("Error Occured");
		
		checkIdOfRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, exception);
		checkVersionOfRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationVersion, exception);
		

		if(RetailStoreInvestmentInvitation.COMMENT_PROPERTY.equals(property)){
			checkCommentOfRetailStoreInvestmentInvitation(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreInvestmentInvitation clone(RetailScmUserContext userContext, String fromRetailStoreInvestmentInvitationId) throws Exception{
		
		return this.getRetailStoreInvestmentInvitationDAO().clone(fromRetailStoreInvestmentInvitationId, this.allTokens());
	}
	
	public RetailStoreInvestmentInvitation updateRetailStoreInvestmentInvitation(RetailScmUserContext userContext,String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		if(retailStoreInvestmentInvitation.getVersion() != retailStoreInvestmentInvitationVersion){
			String message = "The target version("+retailStoreInvestmentInvitation.getVersion()+") is not equals to version("+retailStoreInvestmentInvitationVersion+") provided";
			throw new RetailStoreInvestmentInvitationManagerException(message);
		}
		synchronized(retailStoreInvestmentInvitation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreInvestmentInvitation.
			
			retailStoreInvestmentInvitation.changePropery(property, newValueExpr);
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().done());
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
			//return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreInvestmentInvitationTokens tokens(){
		return RetailStoreInvestmentInvitationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreInvestmentInvitationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreInvestmentInvitationTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion) throws Exception{
		getRetailStoreInvestmentInvitationDAO().delete(retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreInvestmentInvitationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreInvestmentInvitationDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreInvestmentInvitationManagerException exception = new RetailStoreInvestmentInvitationManagerException("Error Occured");
		
		checkIdOfRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, exception);

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
	public  RetailStoreInvestmentInvitation addRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreInvestmentInvitationId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		synchronized(retailStoreInvestmentInvitation){ 
			//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreInvestmentInvitation.addRetailStore( retailStore );		
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreInvestmentInvitationManagerException exception = new RetailStoreInvestmentInvitationManagerException("Error Occured");
		
		checkIdOfRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreInvestmentInvitation removeRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreInvestmentInvitationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		synchronized(retailStoreInvestmentInvitation){ 
			//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreInvestmentInvitation.removeRetailStore( retailStore );		
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreInvestmentInvitationManagerException exception = new RetailStoreInvestmentInvitationManagerException("Error Occured");
		
		checkIdOfRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreInvestmentInvitation copyRetailStoreFrom(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreInvestmentInvitationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		synchronized(retailStoreInvestmentInvitation){ 
			//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreInvestmentInvitation.copyRetailStoreFrom( retailStore );		
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreInvestmentInvitationManagerException exception = new RetailStoreInvestmentInvitationManagerException("Error Occured");
		
		checkIdOfRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, exception);
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
	
	public  RetailStoreInvestmentInvitation updateRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreInvestmentInvitationId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		
		synchronized(retailStoreInvestmentInvitation){ 
			//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreInvestmentInvitation.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreInvestmentInvitation.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreInvestmentInvitationManagerException(retailStore+"Not found" );
			}
			
			retailStore.changePropery(property, newValueExpr);

			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


