
package com.skynet.retailscm.retailstoreordershipment;

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




public class RetailStoreOrderShipmentManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderShipmentManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderShipment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderShipmentDAO  retailStoreOrderShipmentDAO;
 	public void setRetailStoreOrderShipmentDAO(RetailStoreOrderShipmentDAO  retailStoreOrderShipmentDAO){
 	
 		if(retailStoreOrderShipmentDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderShipmentDAO to null.");
 		}
	 	this.retailStoreOrderShipmentDAO = retailStoreOrderShipmentDAO;
 	}
 	public RetailStoreOrderShipmentDAO getRetailStoreOrderShipmentDAO(){
 		if(this.retailStoreOrderShipmentDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderShipmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderShipmentDAO;
 	}
 	
 	protected RetailStoreOrderShipment saveRetailStoreOrderShipment(RetailScmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderShipmentDAO().save(retailStoreOrderShipment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens);
 	}
 	
 	protected RetailStoreOrderShipment saveRetailStoreOrderShipmentDetail(RetailScmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment) throws Exception{	

 		
 		return saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, allTokens());
 	}
 	
 	public RetailStoreOrderShipment loadRetailStoreOrderShipment(RetailScmUserContext userContext, String retailStoreOrderShipmentId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderShipmentManagerException exception = new RetailStoreOrderShipmentManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment( userContext, retailStoreOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderShipment, tokens);
 	}
 	
 	protected RetailStoreOrderShipment present(RetailScmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderShipment,tokens);
		
		
		return this.getRetailStoreOrderShipmentDAO().present(retailStoreOrderShipment, tokens);
	}
 
 	
 	
 	public RetailStoreOrderShipment loadRetailStoreOrderShipmentDetail(RetailScmUserContext userContext, String retailStoreOrderShipmentId) throws Exception{	
 		RetailStoreOrderShipmentManagerException exception = new RetailStoreOrderShipmentManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment( userContext, retailStoreOrderShipmentId, allTokens());

 		return present(userContext,retailStoreOrderShipment, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderShipmentId) throws Exception{	
 		RetailStoreOrderShipmentManagerException exception = new RetailStoreOrderShipmentManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment( userContext, retailStoreOrderShipmentId, allTokens());

 		return present(userContext,retailStoreOrderShipment, allTokens());
		
 	}
 	protected RetailStoreOrderShipment saveRetailStoreOrderShipment(RetailScmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderShipmentDAO().save(retailStoreOrderShipment, tokens);
 	}
 	protected RetailStoreOrderShipment loadRetailStoreOrderShipment(RetailScmUserContext userContext, String retailStoreOrderShipmentId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderShipmentDAO().load(retailStoreOrderShipmentId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderShipment, tokens);
		
		addAction(userContext, retailStoreOrderShipment, tokens,"@create","createRetailStoreOrderShipment","createRetailStoreOrderShipment/","main","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"@update","updateRetailStoreOrderShipment","updateRetailStoreOrderShipment/"+retailStoreOrderShipment.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"@copy","cloneRetailStoreOrderShipment","cloneRetailStoreOrderShipment/"+retailStoreOrderShipment.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderShipment, tokens,"retail_store_order_shipment.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderShipment.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"retail_store_order_shipment.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderShipment.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"retail_store_order_shipment.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderShipment.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"retail_store_order_shipment.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderShipment.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderShipment createRetailStoreOrderShipment(RetailScmUserContext userContext,String who, Date shipTime
) throws Exception
	{
		
		RetailStoreOrderShipmentManagerException exception = new RetailStoreOrderShipmentManagerException("Error Occured");

		

		checkWhoOfRetailStoreOrderShipment(userContext,  who, exception);
		checkShipTimeOfRetailStoreOrderShipment(userContext,  shipTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrderShipment retailStoreOrderShipment=createNewRetailStoreOrderShipment();	

		retailStoreOrderShipment.setWho(who);
		retailStoreOrderShipment.setShipTime(shipTime);

		return saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, emptyOptions());
		

		
	}
	protected RetailStoreOrderShipment createNewRetailStoreOrderShipment() 
	{
		
		return new RetailStoreOrderShipment();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderShipment(RetailScmUserContext userContext,String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderShipmentManagerException exception = new RetailStoreOrderShipmentManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, exception);
		checkVersionOfRetailStoreOrderShipment(userContext, retailStoreOrderShipmentVersion, exception);
		

		if(RetailStoreOrderShipment.WHO_PROPERTY.equals(property)){
			checkWhoOfRetailStoreOrderShipment(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreOrderShipment.SHIP_TIME_PROPERTY.equals(property)){
			checkShipTimeOfRetailStoreOrderShipment(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreOrderShipment clone(RetailScmUserContext userContext, String fromRetailStoreOrderShipmentId) throws Exception{
		
		return this.getRetailStoreOrderShipmentDAO().clone(fromRetailStoreOrderShipmentId, this.allTokens());
	}
	
	public RetailStoreOrderShipment updateRetailStoreOrderShipment(RetailScmUserContext userContext,String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, retailStoreOrderShipmentVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
		if(retailStoreOrderShipment.getVersion() != retailStoreOrderShipmentVersion){
			String message = "The target version("+retailStoreOrderShipment.getVersion()+") is not equals to version("+retailStoreOrderShipmentVersion+") provided";
			throw new RetailStoreOrderShipmentManagerException(message);
		}
		synchronized(retailStoreOrderShipment){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShipment.
			
			retailStoreOrderShipment.changePropery(property, newValueExpr);
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().done());
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderShipmentTokens tokens(){
		return RetailStoreOrderShipmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderShipmentTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderShipmentTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderShipmentId, retailStoreOrderShipmentVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion) throws Exception{
		getRetailStoreOrderShipmentDAO().delete(retailStoreOrderShipmentId, retailStoreOrderShipmentVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderShipmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderShipmentDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderShipmentManagerException exception = new RetailStoreOrderShipmentManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, exception);
		
		
		checkIdOfRetailStore(userContext,  buyerId, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  sellerId, exception);
		checkTitleOfRetailStoreOrder(userContext,  title, exception);
		checkTotalAmountOfRetailStoreOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrderShipment addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderShipmentId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
		synchronized(retailStoreOrderShipment){ 
			//Will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderShipment.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderShipmentManagerException exception = new RetailStoreOrderShipmentManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderShipment removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderShipmentId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
		synchronized(retailStoreOrderShipment){ 
			//Will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderShipment.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderShipmentManagerException exception = new RetailStoreOrderShipmentManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderShipment copyRetailStoreOrderFrom(RetailScmUserContext userContext, String retailStoreOrderShipmentId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderShipmentId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
		synchronized(retailStoreOrderShipment){ 
			//Will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderShipment.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderShipmentManagerException exception = new RetailStoreOrderShipmentManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, exception);
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
	
	public  RetailStoreOrderShipment updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderShipmentId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
		
		synchronized(retailStoreOrderShipment){ 
			//Will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderShipment.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderShipment.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderShipmentManagerException(retailStoreOrder+"Not found" );
			}
			
			retailStoreOrder.changePropery(property, newValueExpr);

			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


