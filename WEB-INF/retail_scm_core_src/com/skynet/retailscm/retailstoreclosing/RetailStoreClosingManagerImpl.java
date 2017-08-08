
package com.skynet.retailscm.retailstoreclosing;

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




public class RetailStoreClosingManagerImpl extends RetailScmCheckerManager implements RetailStoreClosingManager {
	
	private static final String SERVICE_TYPE = "RetailStoreClosing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreClosingDAO  retailStoreClosingDAO;
 	public void setRetailStoreClosingDAO(RetailStoreClosingDAO  retailStoreClosingDAO){
 	
 		if(retailStoreClosingDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreClosingDAO to null.");
 		}
	 	this.retailStoreClosingDAO = retailStoreClosingDAO;
 	}
 	public RetailStoreClosingDAO getRetailStoreClosingDAO(){
 		if(this.retailStoreClosingDAO == null){
 			throw new IllegalStateException("The RetailStoreClosingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreClosingDAO;
 	}
 	
 	protected RetailStoreClosing saveRetailStoreClosing(RetailScmUserContext userContext, RetailStoreClosing retailStoreClosing, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreClosingDAO().save(retailStoreClosing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreClosing(userContext, retailStoreClosing, tokens);
 	}
 	
 	protected RetailStoreClosing saveRetailStoreClosingDetail(RetailScmUserContext userContext, RetailStoreClosing retailStoreClosing) throws Exception{	

 		
 		return saveRetailStoreClosing(userContext, retailStoreClosing, allTokens());
 	}
 	
 	public RetailStoreClosing loadRetailStoreClosing(RetailScmUserContext userContext, String retailStoreClosingId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreClosingManagerException exception = new RetailStoreClosingManagerException("Error Occured");
		
		checkIdOfRetailStoreClosing(userContext, retailStoreClosingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreClosing, tokens);
 	}
 	
 	protected RetailStoreClosing present(RetailScmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreClosing,tokens);
		
		
		return this.getRetailStoreClosingDAO().present(retailStoreClosing, tokens);
	}
 
 	
 	
 	public RetailStoreClosing loadRetailStoreClosingDetail(RetailScmUserContext userContext, String retailStoreClosingId) throws Exception{	
 		RetailStoreClosingManagerException exception = new RetailStoreClosingManagerException("Error Occured");
		
		checkIdOfRetailStoreClosing(userContext, retailStoreClosingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, allTokens());

 		return present(userContext,retailStoreClosing, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreClosingId) throws Exception{	
 		RetailStoreClosingManagerException exception = new RetailStoreClosingManagerException("Error Occured");
		
		checkIdOfRetailStoreClosing(userContext, retailStoreClosingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, allTokens());

 		return present(userContext,retailStoreClosing, allTokens());
		
 	}
 	protected RetailStoreClosing saveRetailStoreClosing(RetailScmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreClosingDAO().save(retailStoreClosing, tokens);
 	}
 	protected RetailStoreClosing loadRetailStoreClosing(RetailScmUserContext userContext, String retailStoreClosingId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreClosingDAO().load(retailStoreClosingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreClosing, tokens);
		
		addAction(userContext, retailStoreClosing, tokens,"@create","createRetailStoreClosing","createRetailStoreClosing/","main","primary");
		addAction(userContext, retailStoreClosing, tokens,"@update","updateRetailStoreClosing","updateRetailStoreClosing/"+retailStoreClosing.getId()+"/","main","primary");
		addAction(userContext, retailStoreClosing, tokens,"@copy","cloneRetailStoreClosing","cloneRetailStoreClosing/"+retailStoreClosing.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.addRetailStore","addRetailStore","addRetailStore/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreClosing createRetailStoreClosing(RetailScmUserContext userContext,String comment
) throws Exception
	{
		
		RetailStoreClosingManagerException exception = new RetailStoreClosingManagerException("Error Occured");

		

		checkCommentOfRetailStoreClosing(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreClosing retailStoreClosing=createNewRetailStoreClosing();	

		retailStoreClosing.setComment(comment);

		return saveRetailStoreClosing(userContext, retailStoreClosing, emptyOptions());
		

		
	}
	protected RetailStoreClosing createNewRetailStoreClosing() 
	{
		
		return new RetailStoreClosing();		
	}
	
	protected void checkParamsForUpdatingRetailStoreClosing(RetailScmUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreClosingManagerException exception = new RetailStoreClosingManagerException("Error Occured");
		
		checkIdOfRetailStoreClosing(userContext, retailStoreClosingId, exception);
		checkVersionOfRetailStoreClosing(userContext, retailStoreClosingVersion, exception);
		

		if(RetailStoreClosing.COMMENT_PROPERTY.equals(property)){
			checkCommentOfRetailStoreClosing(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreClosing clone(RetailScmUserContext userContext, String fromRetailStoreClosingId) throws Exception{
		
		return this.getRetailStoreClosingDAO().clone(fromRetailStoreClosingId, this.allTokens());
	}
	
	public RetailStoreClosing updateRetailStoreClosing(RetailScmUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreClosing(userContext, retailStoreClosingId, retailStoreClosingVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		if(retailStoreClosing.getVersion() != retailStoreClosingVersion){
			String message = "The target version("+retailStoreClosing.getVersion()+") is not equals to version("+retailStoreClosingVersion+") provided";
			throw new RetailStoreClosingManagerException(message);
		}
		synchronized(retailStoreClosing){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreClosing.
			
			retailStoreClosing.changePropery(property, newValueExpr);
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
			//return saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreClosingTokens tokens(){
		return RetailStoreClosingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreClosingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreClosingTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreClosingId, int retailStoreClosingVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreClosingId, retailStoreClosingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreClosingId, int retailStoreClosingVersion) throws Exception{
		getRetailStoreClosingDAO().delete(retailStoreClosingId, retailStoreClosingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreClosingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreClosingDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreClosingManagerException exception = new RetailStoreClosingManagerException("Error Occured");
		
		checkIdOfRetailStoreClosing(userContext, retailStoreClosingId, exception);

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
	public  RetailStoreClosing addRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreClosingId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		synchronized(retailStoreClosing){ 
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreClosing.addRetailStore( retailStore );		
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreClosingManagerException exception = new RetailStoreClosingManagerException("Error Occured");
		
		checkIdOfRetailStoreClosing(userContext, retailStoreClosingId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreClosing removeRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreClosingId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		synchronized(retailStoreClosing){ 
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreClosing.removeRetailStore( retailStore );		
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreClosingManagerException exception = new RetailStoreClosingManagerException("Error Occured");
		
		checkIdOfRetailStoreClosing(userContext, retailStoreClosingId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreClosing copyRetailStoreFrom(RetailScmUserContext userContext, String retailStoreClosingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreClosingId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		synchronized(retailStoreClosing){ 
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreClosing.copyRetailStoreFrom( retailStore );		
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreClosingManagerException exception = new RetailStoreClosingManagerException("Error Occured");
		
		checkIdOfRetailStoreClosing(userContext, retailStoreClosingId, exception);
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
	
	public  RetailStoreClosing updateRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreClosingId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		
		synchronized(retailStoreClosing){ 
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreClosing.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreClosing.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreClosingManagerException(retailStore+"Not found" );
			}
			
			retailStore.changePropery(property, newValueExpr);

			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


