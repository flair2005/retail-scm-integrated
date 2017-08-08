
package com.skynet.retailscm.retailstoreorderconfirmation;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;


import com.skynet.retailscm.retailstoreorder.RetailStoreOrderTable;




public class RetailStoreOrderConfirmationManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderConfirmationManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderConfirmation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderConfirmationDAO  retailStoreOrderConfirmationDAO;
 	public void setRetailStoreOrderConfirmationDAO(RetailStoreOrderConfirmationDAO  retailStoreOrderConfirmationDAO){
 	
 		if(retailStoreOrderConfirmationDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderConfirmationDAO to null.");
 		}
	 	this.retailStoreOrderConfirmationDAO = retailStoreOrderConfirmationDAO;
 	}
 	public RetailStoreOrderConfirmationDAO getRetailStoreOrderConfirmationDAO(){
 		if(this.retailStoreOrderConfirmationDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderConfirmationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderConfirmationDAO;
 	}
 	
 	protected RetailStoreOrderConfirmation saveRetailStoreOrderConfirmation(RetailScmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderConfirmationDAO().save(retailStoreOrderConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmation, tokens);
 	}
 	
 	protected RetailStoreOrderConfirmation saveRetailStoreOrderConfirmationDetail(RetailScmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation) throws Exception{	

 		
 		return saveRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmation, allTokens());
 	}
 	
 	public RetailStoreOrderConfirmation loadRetailStoreOrderConfirmation(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderConfirmationManagerException exception = new RetailStoreOrderConfirmationManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadRetailStoreOrderConfirmation( userContext, retailStoreOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderConfirmation, tokens);
 	}
 	
 	protected RetailStoreOrderConfirmation present(RetailScmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderConfirmation,tokens);
		
		
		return this.getRetailStoreOrderConfirmationDAO().present(retailStoreOrderConfirmation, tokens);
	}
 
 	
 	
 	public RetailStoreOrderConfirmation loadRetailStoreOrderConfirmationDetail(RetailScmUserContext userContext, String retailStoreOrderConfirmationId) throws Exception{	
 		RetailStoreOrderConfirmationManagerException exception = new RetailStoreOrderConfirmationManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadRetailStoreOrderConfirmation( userContext, retailStoreOrderConfirmationId, allTokens());

 		return present(userContext,retailStoreOrderConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderConfirmationId) throws Exception{	
 		RetailStoreOrderConfirmationManagerException exception = new RetailStoreOrderConfirmationManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadRetailStoreOrderConfirmation( userContext, retailStoreOrderConfirmationId, allTokens());

 		return present(userContext,retailStoreOrderConfirmation, allTokens());
		
 	}
 	protected RetailStoreOrderConfirmation saveRetailStoreOrderConfirmation(RetailScmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderConfirmationDAO().save(retailStoreOrderConfirmation, tokens);
 	}
 	protected RetailStoreOrderConfirmation loadRetailStoreOrderConfirmation(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderConfirmationDAO().load(retailStoreOrderConfirmationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderConfirmation, tokens);
		
		addAction(userContext, retailStoreOrderConfirmation, tokens,"@create","createRetailStoreOrderConfirmation","createRetailStoreOrderConfirmation/","main","primary");
		addAction(userContext, retailStoreOrderConfirmation, tokens,"@update","updateRetailStoreOrderConfirmation","updateRetailStoreOrderConfirmation/"+retailStoreOrderConfirmation.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderConfirmation, tokens,"@copy","cloneRetailStoreOrderConfirmation","cloneRetailStoreOrderConfirmation/"+retailStoreOrderConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderConfirmation, tokens,"retail_store_order_confirmation.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderConfirmation.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderConfirmation, tokens,"retail_store_order_confirmation.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderConfirmation.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderConfirmation, tokens,"retail_store_order_confirmation.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderConfirmation.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderConfirmation, tokens,"retail_store_order_confirmation.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderConfirmation.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderConfirmation createRetailStoreOrderConfirmation(RetailScmUserContext userContext,String who, Date confirmTime
) throws Exception
	{
		
		RetailStoreOrderConfirmationManagerException exception = new RetailStoreOrderConfirmationManagerException("Error Occured");

		

		checkWhoOfRetailStoreOrderConfirmation(userContext,  who, exception);
		checkConfirmTimeOfRetailStoreOrderConfirmation(userContext,  confirmTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrderConfirmation retailStoreOrderConfirmation=createNewRetailStoreOrderConfirmation();	

		retailStoreOrderConfirmation.setWho(who);
		retailStoreOrderConfirmation.setConfirmTime(confirmTime);

		return saveRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmation, emptyOptions());
		

		
	}
	protected RetailStoreOrderConfirmation createNewRetailStoreOrderConfirmation() 
	{
		
		return new RetailStoreOrderConfirmation();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderConfirmation(RetailScmUserContext userContext,String retailStoreOrderConfirmationId, int retailStoreOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderConfirmationManagerException exception = new RetailStoreOrderConfirmationManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, exception);
		checkVersionOfRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationVersion, exception);
		

		if(RetailStoreOrderConfirmation.WHO_PROPERTY.equals(property)){
			checkWhoOfRetailStoreOrderConfirmation(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreOrderConfirmation.CONFIRM_TIME_PROPERTY.equals(property)){
			checkConfirmTimeOfRetailStoreOrderConfirmation(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreOrderConfirmation clone(RetailScmUserContext userContext, String fromRetailStoreOrderConfirmationId) throws Exception{
		
		return this.getRetailStoreOrderConfirmationDAO().clone(fromRetailStoreOrderConfirmationId, this.allTokens());
	}
	
	public RetailStoreOrderConfirmation updateRetailStoreOrderConfirmation(RetailScmUserContext userContext,String retailStoreOrderConfirmationId, int retailStoreOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, retailStoreOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, allTokens());
		if(retailStoreOrderConfirmation.getVersion() != retailStoreOrderConfirmationVersion){
			String message = "The target version("+retailStoreOrderConfirmation.getVersion()+") is not equals to version("+retailStoreOrderConfirmationVersion+") provided";
			throw new RetailStoreOrderConfirmationManagerException(message);
		}
		synchronized(retailStoreOrderConfirmation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderConfirmation.
			
			retailStoreOrderConfirmation.changePropery(property, newValueExpr);
			retailStoreOrderConfirmation = saveRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmation, tokens().done());
			return present(userContext,retailStoreOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderConfirmationTokens tokens(){
		return RetailStoreOrderConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderConfirmationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderConfirmationTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, int retailStoreOrderConfirmationVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderConfirmationId, retailStoreOrderConfirmationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderConfirmationId, int retailStoreOrderConfirmationVersion) throws Exception{
		getRetailStoreOrderConfirmationDAO().delete(retailStoreOrderConfirmationId, retailStoreOrderConfirmationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderConfirmationDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderConfirmationManagerException exception = new RetailStoreOrderConfirmationManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, exception);
		
		
		checkIdOfRetailStore(userContext,  buyerId, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  sellerId, exception);
		checkTitleOfRetailStoreOrder(userContext,  title, exception);
		checkTotalAmountOfRetailStoreOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrderConfirmation addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderConfirmationId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, allTokens());
		synchronized(retailStoreOrderConfirmation){ 
			//Will be good when the retailStoreOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderConfirmation.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderConfirmation = saveRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmation, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreOrder createRetailStoreOrder(RetailScmUserContext userContext, String buyerId, String sellerId, String title, double totalAmount) throws Exception{

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		
		
		RetailStore  buyer = new RetailStore();
		buyer.setId(buyerId);		
		retailStoreOrder.setBuyer(buyer);		
		RetailStoreCountryCenter  seller = new RetailStoreCountryCenter();
		seller.setId(sellerId);		
		retailStoreOrder.setSeller(seller);		
		retailStoreOrder.setTitle(title);		
		retailStoreOrder.setTotalAmount(totalAmount);
	
		
		return retailStoreOrder;
	
		
	}
	
	protected RetailStoreOrder createIndexedRetailStoreOrder(String id, int version){

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(id);
		retailStoreOrder.setVersion(version);
		return retailStoreOrder;			
		
	}
	protected void checkParamsForRemovingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderConfirmationManagerException exception = new RetailStoreOrderConfirmationManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderConfirmation removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderConfirmationId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, allTokens());
		synchronized(retailStoreOrderConfirmation){ 
			//Will be good when the retailStoreOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderConfirmation.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderConfirmation = saveRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmation, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderConfirmationManagerException exception = new RetailStoreOrderConfirmationManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderConfirmation copyRetailStoreOrderFrom(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderConfirmationId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, allTokens());
		synchronized(retailStoreOrderConfirmation){ 
			//Will be good when the retailStoreOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderConfirmation.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderConfirmation = saveRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmation, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderConfirmation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderConfirmationManagerException exception = new RetailStoreOrderConfirmationManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfRetailStoreOrder(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkTotalAmountOfRetailStoreOrder(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreOrderConfirmation updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderConfirmationId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmationId, allTokens());
		
		synchronized(retailStoreOrderConfirmation){ 
			//Will be good when the retailStoreOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderConfirmation.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderConfirmation.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderConfirmationManagerException(retailStoreOrder+"Not found" );
			}
			
			retailStoreOrder.changePropery(property, newValueExpr);

			retailStoreOrderConfirmation = saveRetailStoreOrderConfirmation(userContext, retailStoreOrderConfirmation, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


