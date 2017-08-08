
package com.skynet.retailscm.retailstoreorderapproval;

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




public class RetailStoreOrderApprovalManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderApprovalManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderApproval";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderApprovalDAO  retailStoreOrderApprovalDAO;
 	public void setRetailStoreOrderApprovalDAO(RetailStoreOrderApprovalDAO  retailStoreOrderApprovalDAO){
 	
 		if(retailStoreOrderApprovalDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderApprovalDAO to null.");
 		}
	 	this.retailStoreOrderApprovalDAO = retailStoreOrderApprovalDAO;
 	}
 	public RetailStoreOrderApprovalDAO getRetailStoreOrderApprovalDAO(){
 		if(this.retailStoreOrderApprovalDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderApprovalDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderApprovalDAO;
 	}
 	
 	protected RetailStoreOrderApproval saveRetailStoreOrderApproval(RetailScmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderApprovalDAO().save(retailStoreOrderApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens);
 	}
 	
 	protected RetailStoreOrderApproval saveRetailStoreOrderApprovalDetail(RetailScmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval) throws Exception{	

 		
 		return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, allTokens());
 	}
 	
 	public RetailStoreOrderApproval loadRetailStoreOrderApproval(RetailScmUserContext userContext, String retailStoreOrderApprovalId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderApprovalManagerException exception = new RetailStoreOrderApprovalManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderApproval, tokens);
 	}
 	
 	protected RetailStoreOrderApproval present(RetailScmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderApproval,tokens);
		
		
		return this.getRetailStoreOrderApprovalDAO().present(retailStoreOrderApproval, tokens);
	}
 
 	
 	
 	public RetailStoreOrderApproval loadRetailStoreOrderApprovalDetail(RetailScmUserContext userContext, String retailStoreOrderApprovalId) throws Exception{	
 		RetailStoreOrderApprovalManagerException exception = new RetailStoreOrderApprovalManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, allTokens());

 		return present(userContext,retailStoreOrderApproval, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderApprovalId) throws Exception{	
 		RetailStoreOrderApprovalManagerException exception = new RetailStoreOrderApprovalManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, allTokens());

 		return present(userContext,retailStoreOrderApproval, allTokens());
		
 	}
 	protected RetailStoreOrderApproval saveRetailStoreOrderApproval(RetailScmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderApprovalDAO().save(retailStoreOrderApproval, tokens);
 	}
 	protected RetailStoreOrderApproval loadRetailStoreOrderApproval(RetailScmUserContext userContext, String retailStoreOrderApprovalId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderApprovalDAO().load(retailStoreOrderApprovalId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderApproval, tokens);
		
		addAction(userContext, retailStoreOrderApproval, tokens,"@create","createRetailStoreOrderApproval","createRetailStoreOrderApproval/","main","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"@update","updateRetailStoreOrderApproval","updateRetailStoreOrderApproval/"+retailStoreOrderApproval.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"@copy","cloneRetailStoreOrderApproval","cloneRetailStoreOrderApproval/"+retailStoreOrderApproval.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderApproval createRetailStoreOrderApproval(RetailScmUserContext userContext,String who, Date approveTime
) throws Exception
	{
		
		RetailStoreOrderApprovalManagerException exception = new RetailStoreOrderApprovalManagerException("Error Occured");

		

		checkWhoOfRetailStoreOrderApproval(userContext,  who, exception);
		checkApproveTimeOfRetailStoreOrderApproval(userContext,  approveTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrderApproval retailStoreOrderApproval=createNewRetailStoreOrderApproval();	

		retailStoreOrderApproval.setWho(who);
		retailStoreOrderApproval.setApproveTime(approveTime);

		return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, emptyOptions());
		

		
	}
	protected RetailStoreOrderApproval createNewRetailStoreOrderApproval() 
	{
		
		return new RetailStoreOrderApproval();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderApproval(RetailScmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderApprovalManagerException exception = new RetailStoreOrderApprovalManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, exception);
		checkVersionOfRetailStoreOrderApproval(userContext, retailStoreOrderApprovalVersion, exception);
		

		if(RetailStoreOrderApproval.WHO_PROPERTY.equals(property)){
			checkWhoOfRetailStoreOrderApproval(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreOrderApproval.APPROVE_TIME_PROPERTY.equals(property)){
			checkApproveTimeOfRetailStoreOrderApproval(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreOrderApproval clone(RetailScmUserContext userContext, String fromRetailStoreOrderApprovalId) throws Exception{
		
		return this.getRetailStoreOrderApprovalDAO().clone(fromRetailStoreOrderApprovalId, this.allTokens());
	}
	
	public RetailStoreOrderApproval updateRetailStoreOrderApproval(RetailScmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		if(retailStoreOrderApproval.getVersion() != retailStoreOrderApprovalVersion){
			String message = "The target version("+retailStoreOrderApproval.getVersion()+") is not equals to version("+retailStoreOrderApprovalVersion+") provided";
			throw new RetailStoreOrderApprovalManagerException(message);
		}
		synchronized(retailStoreOrderApproval){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderApproval.
			
			retailStoreOrderApproval.changePropery(property, newValueExpr);
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderApprovalTokens tokens(){
		return RetailStoreOrderApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderApprovalTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderApprovalTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception{
		getRetailStoreOrderApprovalDAO().delete(retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderApprovalDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderApprovalManagerException exception = new RetailStoreOrderApprovalManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, exception);
		
		
		checkIdOfRetailStore(userContext,  buyerId, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  sellerId, exception);
		checkTitleOfRetailStoreOrder(userContext,  title, exception);
		checkTotalAmountOfRetailStoreOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrderApproval addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderApprovalId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		synchronized(retailStoreOrderApproval){ 
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderApproval.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderApprovalManagerException exception = new RetailStoreOrderApprovalManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderApproval removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderApprovalId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		synchronized(retailStoreOrderApproval){ 
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderApproval.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderApprovalManagerException exception = new RetailStoreOrderApprovalManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrderApproval copyRetailStoreOrderFrom(RetailScmUserContext userContext, String retailStoreOrderApprovalId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderApprovalId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		synchronized(retailStoreOrderApproval){ 
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderApproval.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderApprovalManagerException exception = new RetailStoreOrderApprovalManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, exception);
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
	
	public  RetailStoreOrderApproval updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderApprovalId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		
		synchronized(retailStoreOrderApproval){ 
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderApproval.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderApproval.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderApprovalManagerException(retailStoreOrder+"Not found" );
			}
			
			retailStoreOrder.changePropery(property, newValueExpr);

			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


