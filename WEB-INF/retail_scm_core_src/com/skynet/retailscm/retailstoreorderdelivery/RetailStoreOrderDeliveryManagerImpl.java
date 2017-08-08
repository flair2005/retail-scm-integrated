
package com.skynet.retailscm.retailstoreorderdelivery;

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




public class RetailStoreOrderDeliveryManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderDeliveryManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderDelivery";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderDeliveryDAO  retailStoreOrderDeliveryDAO;
 	public void setRetailStoreOrderDeliveryDAO(RetailStoreOrderDeliveryDAO  retailStoreOrderDeliveryDAO){
 	
 		if(retailStoreOrderDeliveryDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDeliveryDAO to null.");
 		}
	 	this.retailStoreOrderDeliveryDAO = retailStoreOrderDeliveryDAO;
 	}
 	public RetailStoreOrderDeliveryDAO getRetailStoreOrderDeliveryDAO(){
 		if(this.retailStoreOrderDeliveryDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderDeliveryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderDeliveryDAO;
 	}
 	
 	protected RetailStoreOrderDelivery saveRetailStoreOrderDelivery(RetailScmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderDeliveryDAO().save(retailStoreOrderDelivery, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens);
 	}
 	
 	protected RetailStoreOrderDelivery saveRetailStoreOrderDeliveryDetail(RetailScmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery) throws Exception{	

 		
 		return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, allTokens());
 	}
 	
 	public RetailStoreOrderDelivery loadRetailStoreOrderDelivery(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderDeliveryManagerException exception = new RetailStoreOrderDeliveryManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderDelivery, tokens);
 	}
 	
 	protected RetailStoreOrderDelivery present(RetailScmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderDelivery,tokens);
		
		
		return this.getRetailStoreOrderDeliveryDAO().present(retailStoreOrderDelivery, tokens);
	}
 
 	
 	
 	public RetailStoreOrderDelivery loadRetailStoreOrderDeliveryDetail(RetailScmUserContext userContext, String retailStoreOrderDeliveryId) throws Exception{	
 		RetailStoreOrderDeliveryManagerException exception = new RetailStoreOrderDeliveryManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, allTokens());

 		return present(userContext,retailStoreOrderDelivery, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderDeliveryId) throws Exception{	
 		RetailStoreOrderDeliveryManagerException exception = new RetailStoreOrderDeliveryManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, allTokens());

 		return present(userContext,retailStoreOrderDelivery, allTokens());
		
 	}
 	protected RetailStoreOrderDelivery saveRetailStoreOrderDelivery(RetailScmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderDeliveryDAO().save(retailStoreOrderDelivery, tokens);
 	}
 	protected RetailStoreOrderDelivery loadRetailStoreOrderDelivery(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderDeliveryDAO().load(retailStoreOrderDeliveryId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderDelivery, tokens);
		
		addAction(userContext, retailStoreOrderDelivery, tokens,"@create","createRetailStoreOrderDelivery","createRetailStoreOrderDelivery/","main","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"@update","updateRetailStoreOrderDelivery","updateRetailStoreOrderDelivery/"+retailStoreOrderDelivery.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"@copy","cloneRetailStoreOrderDelivery","cloneRetailStoreOrderDelivery/"+retailStoreOrderDelivery.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderDelivery createRetailStoreOrderDelivery(RetailScmUserContext userContext,String who, Date deliveryTime
) throws Exception
	{
		
		RetailStoreOrderDeliveryManagerException exception = new RetailStoreOrderDeliveryManagerException("Error Occured");

		

		checkWhoOfRetailStoreOrderDelivery(userContext,  who, exception);
		checkDeliveryTimeOfRetailStoreOrderDelivery(userContext,  deliveryTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrderDelivery retailStoreOrderDelivery=createNewRetailStoreOrderDelivery();	

		retailStoreOrderDelivery.setWho(who);
		retailStoreOrderDelivery.setDeliveryTime(deliveryTime);

		return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, emptyOptions());
		

		
	}
	protected RetailStoreOrderDelivery createNewRetailStoreOrderDelivery() 
	{
		
		return new RetailStoreOrderDelivery();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderDelivery(RetailScmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderDeliveryManagerException exception = new RetailStoreOrderDeliveryManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, exception);
		checkVersionOfRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryVersion, exception);
		

		if(RetailStoreOrderDelivery.WHO_PROPERTY.equals(property)){
			checkWhoOfRetailStoreOrderDelivery(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreOrderDelivery.DELIVERY_TIME_PROPERTY.equals(property)){
			checkDeliveryTimeOfRetailStoreOrderDelivery(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreOrderDelivery clone(RetailScmUserContext userContext, String fromRetailStoreOrderDeliveryId) throws Exception{
		
		return this.getRetailStoreOrderDeliveryDAO().clone(fromRetailStoreOrderDeliveryId, this.allTokens());
	}
	
	public RetailStoreOrderDelivery updateRetailStoreOrderDelivery(RetailScmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		if(retailStoreOrderDelivery.getVersion() != retailStoreOrderDeliveryVersion){
			String message = "The target version("+retailStoreOrderDelivery.getVersion()+") is not equals to version("+retailStoreOrderDeliveryVersion+") provided";
			throw new RetailStoreOrderDeliveryManagerException(message);
		}
		synchronized(retailStoreOrderDelivery){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderDelivery.
			
			retailStoreOrderDelivery.changePropery(property, newValueExpr);
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderDeliveryTokens tokens(){
		return RetailStoreOrderDeliveryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderDeliveryTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderDeliveryTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception{
		getRetailStoreOrderDeliveryDAO().delete(retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderDeliveryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderDeliveryDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderDeliveryManagerException exception = new RetailStoreOrderDeliveryManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, exception);
		
		
		checkIdOfRetailStore(userContext,  buyerId, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  sellerId, exception);
		checkTitleOfRetailStoreOrder(userContext,  title, exception);
		checkTotalAmountOfRetailStoreOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrderDelivery addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderDeliveryId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		synchronized(retailStoreOrderDelivery){ 
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderDelivery.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderDeliveryManagerException exception = new RetailStoreOrderDeliveryManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderDelivery removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderDeliveryId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		synchronized(retailStoreOrderDelivery){ 
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderDelivery.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderDeliveryManagerException exception = new RetailStoreOrderDeliveryManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderDelivery copyRetailStoreOrderFrom(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderDeliveryId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		synchronized(retailStoreOrderDelivery){ 
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderDelivery.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderDeliveryManagerException exception = new RetailStoreOrderDeliveryManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, exception);
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
	
	public  RetailStoreOrderDelivery updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderDeliveryId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		
		synchronized(retailStoreOrderDelivery){ 
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderDelivery.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderDelivery.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderDeliveryManagerException(retailStoreOrder+"Not found" );
			}
			
			retailStoreOrder.changePropery(property, newValueExpr);

			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


