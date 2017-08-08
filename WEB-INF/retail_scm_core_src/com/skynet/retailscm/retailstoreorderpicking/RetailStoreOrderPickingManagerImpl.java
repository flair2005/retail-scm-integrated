
package com.skynet.retailscm.retailstoreorderpicking;

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




public class RetailStoreOrderPickingManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderPickingManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderPicking";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderPickingDAO  retailStoreOrderPickingDAO;
 	public void setRetailStoreOrderPickingDAO(RetailStoreOrderPickingDAO  retailStoreOrderPickingDAO){
 	
 		if(retailStoreOrderPickingDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderPickingDAO to null.");
 		}
	 	this.retailStoreOrderPickingDAO = retailStoreOrderPickingDAO;
 	}
 	public RetailStoreOrderPickingDAO getRetailStoreOrderPickingDAO(){
 		if(this.retailStoreOrderPickingDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderPickingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderPickingDAO;
 	}
 	
 	protected RetailStoreOrderPicking saveRetailStoreOrderPicking(RetailScmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderPickingDAO().save(retailStoreOrderPicking, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens);
 	}
 	
 	protected RetailStoreOrderPicking saveRetailStoreOrderPickingDetail(RetailScmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking) throws Exception{	

 		
 		return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, allTokens());
 	}
 	
 	public RetailStoreOrderPicking loadRetailStoreOrderPicking(RetailScmUserContext userContext, String retailStoreOrderPickingId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderPickingManagerException exception = new RetailStoreOrderPickingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPicking, tokens);
 	}
 	
 	protected RetailStoreOrderPicking present(RetailScmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderPicking,tokens);
		
		
		return this.getRetailStoreOrderPickingDAO().present(retailStoreOrderPicking, tokens);
	}
 
 	
 	
 	public RetailStoreOrderPicking loadRetailStoreOrderPickingDetail(RetailScmUserContext userContext, String retailStoreOrderPickingId) throws Exception{	
 		RetailStoreOrderPickingManagerException exception = new RetailStoreOrderPickingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, allTokens());

 		return present(userContext,retailStoreOrderPicking, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderPickingId) throws Exception{	
 		RetailStoreOrderPickingManagerException exception = new RetailStoreOrderPickingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, allTokens());

 		return present(userContext,retailStoreOrderPicking, allTokens());
		
 	}
 	protected RetailStoreOrderPicking saveRetailStoreOrderPicking(RetailScmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderPickingDAO().save(retailStoreOrderPicking, tokens);
 	}
 	protected RetailStoreOrderPicking loadRetailStoreOrderPicking(RetailScmUserContext userContext, String retailStoreOrderPickingId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderPickingDAO().load(retailStoreOrderPickingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderPicking, tokens);
		
		addAction(userContext, retailStoreOrderPicking, tokens,"@create","createRetailStoreOrderPicking","createRetailStoreOrderPicking/","main","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"@update","updateRetailStoreOrderPicking","updateRetailStoreOrderPicking/"+retailStoreOrderPicking.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"@copy","cloneRetailStoreOrderPicking","cloneRetailStoreOrderPicking/"+retailStoreOrderPicking.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderPicking createRetailStoreOrderPicking(RetailScmUserContext userContext,String who, Date processTime
) throws Exception
	{
		
		RetailStoreOrderPickingManagerException exception = new RetailStoreOrderPickingManagerException("Error Occured");

		

		checkWhoOfRetailStoreOrderPicking(userContext,  who, exception);
		checkProcessTimeOfRetailStoreOrderPicking(userContext,  processTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrderPicking retailStoreOrderPicking=createNewRetailStoreOrderPicking();	

		retailStoreOrderPicking.setWho(who);
		retailStoreOrderPicking.setProcessTime(processTime);

		return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, emptyOptions());
		

		
	}
	protected RetailStoreOrderPicking createNewRetailStoreOrderPicking() 
	{
		
		return new RetailStoreOrderPicking();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderPicking(RetailScmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderPickingManagerException exception = new RetailStoreOrderPickingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, exception);
		checkVersionOfRetailStoreOrderPicking(userContext, retailStoreOrderPickingVersion, exception);
		

		if(RetailStoreOrderPicking.WHO_PROPERTY.equals(property)){
			checkWhoOfRetailStoreOrderPicking(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreOrderPicking.PROCESS_TIME_PROPERTY.equals(property)){
			checkProcessTimeOfRetailStoreOrderPicking(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreOrderPicking clone(RetailScmUserContext userContext, String fromRetailStoreOrderPickingId) throws Exception{
		
		return this.getRetailStoreOrderPickingDAO().clone(fromRetailStoreOrderPickingId, this.allTokens());
	}
	
	public RetailStoreOrderPicking updateRetailStoreOrderPicking(RetailScmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		if(retailStoreOrderPicking.getVersion() != retailStoreOrderPickingVersion){
			String message = "The target version("+retailStoreOrderPicking.getVersion()+") is not equals to version("+retailStoreOrderPickingVersion+") provided";
			throw new RetailStoreOrderPickingManagerException(message);
		}
		synchronized(retailStoreOrderPicking){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPicking.
			
			retailStoreOrderPicking.changePropery(property, newValueExpr);
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderPickingTokens tokens(){
		return RetailStoreOrderPickingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderPickingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderPickingTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception{
		getRetailStoreOrderPickingDAO().delete(retailStoreOrderPickingId, retailStoreOrderPickingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderPickingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderPickingDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderPickingManagerException exception = new RetailStoreOrderPickingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, exception);
		
		
		checkIdOfRetailStore(userContext,  buyerId, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  sellerId, exception);
		checkTitleOfRetailStoreOrder(userContext,  title, exception);
		checkTotalAmountOfRetailStoreOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrderPicking addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderPickingId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		synchronized(retailStoreOrderPicking){ 
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderPicking.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderPickingManagerException exception = new RetailStoreOrderPickingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderPicking removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderPickingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		synchronized(retailStoreOrderPicking){ 
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderPicking.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderPickingManagerException exception = new RetailStoreOrderPickingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderPicking copyRetailStoreOrderFrom(RetailScmUserContext userContext, String retailStoreOrderPickingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderPickingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		synchronized(retailStoreOrderPicking){ 
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderPicking.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderPickingManagerException exception = new RetailStoreOrderPickingManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, exception);
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
	
	public  RetailStoreOrderPicking updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderPickingId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		
		synchronized(retailStoreOrderPicking){ 
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderPicking.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderPicking.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderPickingManagerException(retailStoreOrder+"Not found" );
			}
			
			retailStoreOrder.changePropery(property, newValueExpr);

			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


