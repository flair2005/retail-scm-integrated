
package com.skynet.retailscm.retailstoreorderprocessing;

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




public class RetailStoreOrderProcessingManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderProcessingManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderProcessing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderProcessingDAO  retailStoreOrderProcessingDAO;
 	public void setRetailStoreOrderProcessingDAO(RetailStoreOrderProcessingDAO  retailStoreOrderProcessingDAO){
 	
 		if(retailStoreOrderProcessingDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderProcessingDAO to null.");
 		}
	 	this.retailStoreOrderProcessingDAO = retailStoreOrderProcessingDAO;
 	}
 	public RetailStoreOrderProcessingDAO getRetailStoreOrderProcessingDAO(){
 		if(this.retailStoreOrderProcessingDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderProcessingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderProcessingDAO;
 	}
 	
 	protected RetailStoreOrderProcessing saveRetailStoreOrderProcessing(RetailScmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderProcessingDAO().save(retailStoreOrderProcessing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens);
 	}
 	
 	protected RetailStoreOrderProcessing saveRetailStoreOrderProcessingDetail(RetailScmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing) throws Exception{	

 		
 		return saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, allTokens());
 	}
 	
 	public RetailStoreOrderProcessing loadRetailStoreOrderProcessing(RetailScmUserContext userContext, String retailStoreOrderProcessingId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderProcessingManagerException exception = new RetailStoreOrderProcessingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing( userContext, retailStoreOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderProcessing, tokens);
 	}
 	
 	protected RetailStoreOrderProcessing present(RetailScmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderProcessing,tokens);
		
		
		return this.getRetailStoreOrderProcessingDAO().present(retailStoreOrderProcessing, tokens);
	}
 
 	
 	
 	public RetailStoreOrderProcessing loadRetailStoreOrderProcessingDetail(RetailScmUserContext userContext, String retailStoreOrderProcessingId) throws Exception{	
 		RetailStoreOrderProcessingManagerException exception = new RetailStoreOrderProcessingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing( userContext, retailStoreOrderProcessingId, allTokens());

 		return present(userContext,retailStoreOrderProcessing, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderProcessingId) throws Exception{	
 		RetailStoreOrderProcessingManagerException exception = new RetailStoreOrderProcessingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing( userContext, retailStoreOrderProcessingId, allTokens());

 		return present(userContext,retailStoreOrderProcessing, allTokens());
		
 	}
 	protected RetailStoreOrderProcessing saveRetailStoreOrderProcessing(RetailScmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderProcessingDAO().save(retailStoreOrderProcessing, tokens);
 	}
 	protected RetailStoreOrderProcessing loadRetailStoreOrderProcessing(RetailScmUserContext userContext, String retailStoreOrderProcessingId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderProcessingDAO().load(retailStoreOrderProcessingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderProcessing, tokens);
		
		addAction(userContext, retailStoreOrderProcessing, tokens,"@create","createRetailStoreOrderProcessing","createRetailStoreOrderProcessing/","main","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"@update","updateRetailStoreOrderProcessing","updateRetailStoreOrderProcessing/"+retailStoreOrderProcessing.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"@copy","cloneRetailStoreOrderProcessing","cloneRetailStoreOrderProcessing/"+retailStoreOrderProcessing.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderProcessing, tokens,"retail_store_order_processing.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderProcessing.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"retail_store_order_processing.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderProcessing.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"retail_store_order_processing.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderProcessing.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"retail_store_order_processing.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderProcessing.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderProcessing createRetailStoreOrderProcessing(RetailScmUserContext userContext,String who, Date processTime
) throws Exception
	{
		
		RetailStoreOrderProcessingManagerException exception = new RetailStoreOrderProcessingManagerException("Error Occured");

		

		checkWhoOfRetailStoreOrderProcessing(userContext,  who, exception);
		checkProcessTimeOfRetailStoreOrderProcessing(userContext,  processTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrderProcessing retailStoreOrderProcessing=createNewRetailStoreOrderProcessing();	

		retailStoreOrderProcessing.setWho(who);
		retailStoreOrderProcessing.setProcessTime(processTime);

		return saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, emptyOptions());
		

		
	}
	protected RetailStoreOrderProcessing createNewRetailStoreOrderProcessing() 
	{
		
		return new RetailStoreOrderProcessing();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderProcessing(RetailScmUserContext userContext,String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderProcessingManagerException exception = new RetailStoreOrderProcessingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, exception);
		checkVersionOfRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingVersion, exception);
		

		if(RetailStoreOrderProcessing.WHO_PROPERTY.equals(property)){
			checkWhoOfRetailStoreOrderProcessing(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreOrderProcessing.PROCESS_TIME_PROPERTY.equals(property)){
			checkProcessTimeOfRetailStoreOrderProcessing(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreOrderProcessing clone(RetailScmUserContext userContext, String fromRetailStoreOrderProcessingId) throws Exception{
		
		return this.getRetailStoreOrderProcessingDAO().clone(fromRetailStoreOrderProcessingId, this.allTokens());
	}
	
	public RetailStoreOrderProcessing updateRetailStoreOrderProcessing(RetailScmUserContext userContext,String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, retailStoreOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		if(retailStoreOrderProcessing.getVersion() != retailStoreOrderProcessingVersion){
			String message = "The target version("+retailStoreOrderProcessing.getVersion()+") is not equals to version("+retailStoreOrderProcessingVersion+") provided";
			throw new RetailStoreOrderProcessingManagerException(message);
		}
		synchronized(retailStoreOrderProcessing){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderProcessing.
			
			retailStoreOrderProcessing.changePropery(property, newValueExpr);
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().done());
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderProcessingTokens tokens(){
		return RetailStoreOrderProcessingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderProcessingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderProcessingTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderProcessingId, retailStoreOrderProcessingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion) throws Exception{
		getRetailStoreOrderProcessingDAO().delete(retailStoreOrderProcessingId, retailStoreOrderProcessingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderProcessingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderProcessingDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderProcessingManagerException exception = new RetailStoreOrderProcessingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, exception);
		
		
		checkIdOfRetailStore(userContext,  buyerId, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  sellerId, exception);
		checkTitleOfRetailStoreOrder(userContext,  title, exception);
		checkTotalAmountOfRetailStoreOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrderProcessing addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderProcessingId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		synchronized(retailStoreOrderProcessing){ 
			//Will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderProcessing.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderProcessingManagerException exception = new RetailStoreOrderProcessingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderProcessing removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderProcessingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		synchronized(retailStoreOrderProcessing){ 
			//Will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderProcessing.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderProcessingManagerException exception = new RetailStoreOrderProcessingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderProcessing copyRetailStoreOrderFrom(RetailScmUserContext userContext, String retailStoreOrderProcessingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderProcessingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		synchronized(retailStoreOrderProcessing){ 
			//Will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderProcessing.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderProcessingManagerException exception = new RetailStoreOrderProcessingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, exception);
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
	
	public  RetailStoreOrderProcessing updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderProcessingId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		
		synchronized(retailStoreOrderProcessing){ 
			//Will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderProcessing.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderProcessing.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderProcessingManagerException(retailStoreOrder+"Not found" );
			}
			
			retailStoreOrder.changePropery(property, newValueExpr);

			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


