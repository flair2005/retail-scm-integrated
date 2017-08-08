
package com.skynet.retailscm.retailstoreorder;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.skynet.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.skynet.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipmentDAO;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessingDAO;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPickingDAO;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDeliveryDAO;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmationDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApprovalDAO;

import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipmentTable;
import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemTable;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmationTable;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPickingTable;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApprovalTable;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessingTable;
import com.skynet.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupTable;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDeliveryTable;
import com.skynet.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupTable;




public class RetailStoreOrderManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrder";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO  retailStoreOrderDAO){
 	
 		if(retailStoreOrderDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
 		}
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
 		if(this.retailStoreOrderDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderDAO;
 	}
 	
 	protected RetailStoreOrder saveRetailStoreOrder(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderDAO().save(retailStoreOrder, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrder(userContext, retailStoreOrder, tokens);
 	}
 	
 	protected RetailStoreOrder saveRetailStoreOrderDetail(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{	

 		
 		return saveRetailStoreOrder(userContext, retailStoreOrder, allTokens());
 	}
 	
 	public RetailStoreOrder loadRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder( userContext, retailStoreOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrder, tokens);
 	}
 	
 	protected RetailStoreOrder present(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrder,tokens);
		
		
		return this.getRetailStoreOrderDAO().present(retailStoreOrder, tokens);
	}
 
 	
 	
 	public RetailStoreOrder loadRetailStoreOrderDetail(RetailScmUserContext userContext, String retailStoreOrderId) throws Exception{	
 		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder( userContext, retailStoreOrderId, allTokens());

 		return present(userContext,retailStoreOrder, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderId) throws Exception{	
 		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder( userContext, retailStoreOrderId, allTokens());

 		return present(userContext,retailStoreOrder, allTokens());
		
 	}
 	protected RetailStoreOrder saveRetailStoreOrder(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderDAO().save(retailStoreOrder, tokens);
 	}
 	protected RetailStoreOrder loadRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderDAO().load(retailStoreOrderId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreOrderApprovalDAO  retailStoreOrderApprovalDAO;
 	public void setRetailStoreOrderApprovalDAO(RetailStoreOrderApprovalDAO retailStoreOrderApprovalDAO){
	 	this.retailStoreOrderApprovalDAO = retailStoreOrderApprovalDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderApprovalDAO getRetailStoreOrderApprovalDAO(){
	 	return this.retailStoreOrderApprovalDAO;
 	}
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  RetailStoreOrderDeliveryDAO  retailStoreOrderDeliveryDAO;
 	public void setRetailStoreOrderDeliveryDAO(RetailStoreOrderDeliveryDAO retailStoreOrderDeliveryDAO){
	 	this.retailStoreOrderDeliveryDAO = retailStoreOrderDeliveryDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderDeliveryDAO getRetailStoreOrderDeliveryDAO(){
	 	return this.retailStoreOrderDeliveryDAO;
 	}
 
 	
 	private  RetailStoreOrderPickingDAO  retailStoreOrderPickingDAO;
 	public void setRetailStoreOrderPickingDAO(RetailStoreOrderPickingDAO retailStoreOrderPickingDAO){
	 	this.retailStoreOrderPickingDAO = retailStoreOrderPickingDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderPickingDAO getRetailStoreOrderPickingDAO(){
	 	return this.retailStoreOrderPickingDAO;
 	}
 
 	
 	private  RetailStoreOrderShipmentDAO  retailStoreOrderShipmentDAO;
 	public void setRetailStoreOrderShipmentDAO(RetailStoreOrderShipmentDAO retailStoreOrderShipmentDAO){
	 	this.retailStoreOrderShipmentDAO = retailStoreOrderShipmentDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderShipmentDAO getRetailStoreOrderShipmentDAO(){
	 	return this.retailStoreOrderShipmentDAO;
 	}
 
 	
 	private  RetailStoreOrderConfirmationDAO  retailStoreOrderConfirmationDAO;
 	public void setRetailStoreOrderConfirmationDAO(RetailStoreOrderConfirmationDAO retailStoreOrderConfirmationDAO){
	 	this.retailStoreOrderConfirmationDAO = retailStoreOrderConfirmationDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderConfirmationDAO getRetailStoreOrderConfirmationDAO(){
	 	return this.retailStoreOrderConfirmationDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	//------------------------------------
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}
 
 	
 	private  RetailStoreOrderProcessingDAO  retailStoreOrderProcessingDAO;
 	public void setRetailStoreOrderProcessingDAO(RetailStoreOrderProcessingDAO retailStoreOrderProcessingDAO){
	 	this.retailStoreOrderProcessingDAO = retailStoreOrderProcessingDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderProcessingDAO getRetailStoreOrderProcessingDAO(){
	 	return this.retailStoreOrderProcessingDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrder, tokens);
		
		addAction(userContext, retailStoreOrder, tokens,"@create","createRetailStoreOrder","createRetailStoreOrder/","main","primary");
		addAction(userContext, retailStoreOrder, tokens,"@update","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrder.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrder, tokens,"@copy","cloneRetailStoreOrder","cloneRetailStoreOrder/"+retailStoreOrder.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.transfer_to_buyer","transferToAnotherBuyer","transferToAnotherBuyer/"+retailStoreOrder.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.transfer_to_seller","transferToAnotherSeller","transferToAnotherSeller/"+retailStoreOrder.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.confirm","confirm","confirm/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.approve","approve","approve/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.process","process","process/"+retailStoreOrder.getId()+"/","main","info");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.pick","pick","pick/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.ship","ship","ship/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.deliver","deliver","deliver/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.addRetailStoreOrderLineItem","addRetailStoreOrderLineItem","addRetailStoreOrderLineItem/"+retailStoreOrder.getId()+"/","retailStoreOrderLineItemList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.removeRetailStoreOrderLineItem","removeRetailStoreOrderLineItem","removeRetailStoreOrderLineItem/"+retailStoreOrder.getId()+"/","retailStoreOrderLineItemList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.updateRetailStoreOrderLineItem","updateRetailStoreOrderLineItem","updateRetailStoreOrderLineItem/"+retailStoreOrder.getId()+"/","retailStoreOrderLineItemList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.copyRetailStoreOrderLineItemFrom","copyRetailStoreOrderLineItemFrom","copyRetailStoreOrderLineItemFrom/"+retailStoreOrder.getId()+"/","retailStoreOrderLineItemList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.addRetailStoreOrderShippingGroup","addRetailStoreOrderShippingGroup","addRetailStoreOrderShippingGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderShippingGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.removeRetailStoreOrderShippingGroup","removeRetailStoreOrderShippingGroup","removeRetailStoreOrderShippingGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderShippingGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.updateRetailStoreOrderShippingGroup","updateRetailStoreOrderShippingGroup","updateRetailStoreOrderShippingGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderShippingGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.copyRetailStoreOrderShippingGroupFrom","copyRetailStoreOrderShippingGroupFrom","copyRetailStoreOrderShippingGroupFrom/"+retailStoreOrder.getId()+"/","retailStoreOrderShippingGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.addRetailStoreOrderPaymentGroup","addRetailStoreOrderPaymentGroup","addRetailStoreOrderPaymentGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderPaymentGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.removeRetailStoreOrderPaymentGroup","removeRetailStoreOrderPaymentGroup","removeRetailStoreOrderPaymentGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderPaymentGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.updateRetailStoreOrderPaymentGroup","updateRetailStoreOrderPaymentGroup","updateRetailStoreOrderPaymentGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderPaymentGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.copyRetailStoreOrderPaymentGroupFrom","copyRetailStoreOrderPaymentGroupFrom","copyRetailStoreOrderPaymentGroupFrom/"+retailStoreOrder.getId()+"/","retailStoreOrderPaymentGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.addGoods","addGoods","addGoods/"+retailStoreOrder.getId()+"/","goodsList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.removeGoods","removeGoods","removeGoods/"+retailStoreOrder.getId()+"/","goodsList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.updateGoods","updateGoods","updateGoods/"+retailStoreOrder.getId()+"/","goodsList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+retailStoreOrder.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrder createRetailStoreOrder(RetailScmUserContext userContext,String buyerId, String sellerId, String title, double totalAmount
) throws Exception
	{
		
		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");

		

		checkTitleOfRetailStoreOrder(userContext,  title, exception);
		checkTotalAmountOfRetailStoreOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrder retailStoreOrder=createNewRetailStoreOrder();	

		RetailStore buyer = loadRetailStore(buyerId,emptyOptions());
		retailStoreOrder.setBuyer(buyer);
		RetailStoreCountryCenter seller = loadRetailStoreCountryCenter(sellerId,emptyOptions());
		retailStoreOrder.setSeller(seller);
		retailStoreOrder.setTitle(title);
		retailStoreOrder.setTotalAmount(totalAmount);

		return saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
		

		
	}
	protected RetailStoreOrder createNewRetailStoreOrder() 
	{
		
		return new RetailStoreOrder();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailScmUserContext userContext,String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
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
	
	
	
	public RetailStoreOrder clone(RetailScmUserContext userContext, String fromRetailStoreOrderId) throws Exception{
		
		return this.getRetailStoreOrderDAO().clone(fromRetailStoreOrderId, this.allTokens());
	}
	
	public RetailStoreOrder updateRetailStoreOrder(RetailScmUserContext userContext,String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		if(retailStoreOrder.getVersion() != retailStoreOrderVersion){
			String message = "The target version("+retailStoreOrder.getVersion()+") is not equals to version("+retailStoreOrderVersion+") provided";
			throw new RetailStoreOrderManagerException(message);
		}
		synchronized(retailStoreOrder){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrder.
			
			retailStoreOrder.changePropery(property, newValueExpr);
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrder(userContext, retailStoreOrder, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderTokens tokens(){
		return RetailStoreOrderTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={"CONFIRMED","APPROVED","PROCESSED","PICKED","SHIPPED","DELIVERED"};
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
	
	protected void checkParamsForTransferingAnotherBuyer(RetailScmUserContext userContext, String retailStoreOrderId, String anotherBuyerId) throws Exception
 	{
 		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
 		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId,exception);
 		checkIdOfRetailStore(userContext, anotherBuyerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreOrder transferToAnotherBuyer(RetailScmUserContext userContext, String retailStoreOrderId, String anotherBuyerId) throws Exception
 	{
 		checkParamsForTransferingAnotherBuyer(userContext, retailStoreOrderId,anotherBuyerId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore buyer = loadRetailStore(anotherBuyerId, emptyOptions());		
			retailStoreOrder.setBuyer(buyer);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherSeller(RetailScmUserContext userContext, String retailStoreOrderId, String anotherSellerId) throws Exception
 	{
 		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
 		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherSellerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreOrder transferToAnotherSeller(RetailScmUserContext userContext, String retailStoreOrderId, String anotherSellerId) throws Exception
 	{
 		checkParamsForTransferingAnotherSeller(userContext, retailStoreOrderId,anotherSellerId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter seller = loadRetailStoreCountryCenter(anotherSellerId, emptyOptions());		
			retailStoreOrder.setSeller(seller);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForConfirmation(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date confirmTime
) throws Exception
 	{
 		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkWhoOfRetailStoreOrderConfirmation(userContext,who,exception);
		checkConfirmTimeOfRetailStoreOrderConfirmation(userContext,confirmTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStoreOrder confirm(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date confirmTime
) throws Exception
 	{
		checkParamsForConfirmation(userContext, retailStoreOrderId, who, confirmTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreOrderConfirmation(userContext,retailStoreOrder);
 		

			retailStoreOrder.setCurrentStatus("CONFIRMED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderConfirmation confirmation = createRetailStoreOrderConfirmation(who, confirmTime);		
			retailStoreOrder.setConfirmation(confirmation);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withConfirmation().done());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	protected RetailStoreOrderConfirmation createRetailStoreOrderConfirmation(String who, Date confirmTime){
 		RetailStoreOrderConfirmation confirmation = new RetailStoreOrderConfirmation(who, confirmTime);
 		return getRetailStoreOrderConfirmationDAO().save(confirmation,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreOrderConfirmation(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 		
 		
 		String currentStatus = retailStoreOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		if(!("CONFIRMED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		
 		RetailStoreOrderConfirmation confirmation = retailStoreOrder.getConfirmation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = confirmation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( confirmation != null){
				throw new RetailStoreOrderManagerException("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been CONFIRMED");
		}
 		
 		
 	}
	
 	protected void checkParamsForApproval(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date approveTime
) throws Exception
 	{
 		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkWhoOfRetailStoreOrderApproval(userContext,who,exception);
		checkApproveTimeOfRetailStoreOrderApproval(userContext,approveTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStoreOrder approve(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date approveTime
) throws Exception
 	{
		checkParamsForApproval(userContext, retailStoreOrderId, who, approveTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreOrderApproval(userContext,retailStoreOrder);
 		

			retailStoreOrder.setCurrentStatus("APPROVED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderApproval approval = createRetailStoreOrderApproval(who, approveTime);		
			retailStoreOrder.setApproval(approval);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withApproval().done());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	protected RetailStoreOrderApproval createRetailStoreOrderApproval(String who, Date approveTime){
 		RetailStoreOrderApproval approval = new RetailStoreOrderApproval(who, approveTime);
 		return getRetailStoreOrderApprovalDAO().save(approval,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreOrderApproval(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 		
 		
 		String currentStatus = retailStoreOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'APPROVED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		if(!("APPROVED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'APPROVED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		
 		RetailStoreOrderApproval approval = retailStoreOrder.getApproval();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = approval 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( approval != null){
				throw new RetailStoreOrderManagerException("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been APPROVED");
		}
 		
 		
 	}
	
 	protected void checkParamsForProcessing(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date processTime
) throws Exception
 	{
 		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkWhoOfRetailStoreOrderProcessing(userContext,who,exception);
		checkProcessTimeOfRetailStoreOrderProcessing(userContext,processTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStoreOrder process(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date processTime
) throws Exception
 	{
		checkParamsForProcessing(userContext, retailStoreOrderId, who, processTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreOrderProcessing(userContext,retailStoreOrder);
 		

			retailStoreOrder.setCurrentStatus("PROCESSED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderProcessing processing = createRetailStoreOrderProcessing(who, processTime);		
			retailStoreOrder.setProcessing(processing);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withProcessing().done());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	protected RetailStoreOrderProcessing createRetailStoreOrderProcessing(String who, Date processTime){
 		RetailStoreOrderProcessing processing = new RetailStoreOrderProcessing(who, processTime);
 		return getRetailStoreOrderProcessingDAO().save(processing,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreOrderProcessing(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 		
 		
 		String currentStatus = retailStoreOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'PROCESSED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		if(!("PROCESSED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'PROCESSED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		
 		RetailStoreOrderProcessing processing = retailStoreOrder.getProcessing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = processing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( processing != null){
				throw new RetailStoreOrderManagerException("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been PROCESSED");
		}
 		
 		
 	}
	
 	protected void checkParamsForPicking(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date processTime
) throws Exception
 	{
 		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkWhoOfRetailStoreOrderPicking(userContext,who,exception);
		checkProcessTimeOfRetailStoreOrderPicking(userContext,processTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStoreOrder pick(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date processTime
) throws Exception
 	{
		checkParamsForPicking(userContext, retailStoreOrderId, who, processTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreOrderPicking(userContext,retailStoreOrder);
 		

			retailStoreOrder.setCurrentStatus("PICKED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderPicking picking = createRetailStoreOrderPicking(who, processTime);		
			retailStoreOrder.setPicking(picking);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withPicking().done());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	protected RetailStoreOrderPicking createRetailStoreOrderPicking(String who, Date processTime){
 		RetailStoreOrderPicking picking = new RetailStoreOrderPicking(who, processTime);
 		return getRetailStoreOrderPickingDAO().save(picking,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreOrderPicking(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 		
 		
 		String currentStatus = retailStoreOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'PICKED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		if(!("PICKED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'PICKED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		
 		RetailStoreOrderPicking picking = retailStoreOrder.getPicking();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = picking 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( picking != null){
				throw new RetailStoreOrderManagerException("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been PICKED");
		}
 		
 		
 	}
	
 	protected void checkParamsForShipment(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date shipTime
) throws Exception
 	{
 		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkWhoOfRetailStoreOrderShipment(userContext,who,exception);
		checkShipTimeOfRetailStoreOrderShipment(userContext,shipTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStoreOrder ship(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date shipTime
) throws Exception
 	{
		checkParamsForShipment(userContext, retailStoreOrderId, who, shipTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreOrderShipment(userContext,retailStoreOrder);
 		

			retailStoreOrder.setCurrentStatus("SHIPPED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderShipment shipment = createRetailStoreOrderShipment(who, shipTime);		
			retailStoreOrder.setShipment(shipment);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withShipment().done());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	protected RetailStoreOrderShipment createRetailStoreOrderShipment(String who, Date shipTime){
 		RetailStoreOrderShipment shipment = new RetailStoreOrderShipment(who, shipTime);
 		return getRetailStoreOrderShipmentDAO().save(shipment,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreOrderShipment(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 		
 		
 		String currentStatus = retailStoreOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'SHIPPED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		if(!("SHIPPED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'SHIPPED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		
 		RetailStoreOrderShipment shipment = retailStoreOrder.getShipment();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = shipment 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( shipment != null){
				throw new RetailStoreOrderManagerException("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been SHIPPED");
		}
 		
 		
 	}
	
 	protected void checkParamsForDelivery(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date deliveryTime
) throws Exception
 	{
 		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkWhoOfRetailStoreOrderDelivery(userContext,who,exception);
		checkDeliveryTimeOfRetailStoreOrderDelivery(userContext,deliveryTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStoreOrder deliver(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date deliveryTime
) throws Exception
 	{
		checkParamsForDelivery(userContext, retailStoreOrderId, who, deliveryTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreOrderDelivery(userContext,retailStoreOrder);
 		

			retailStoreOrder.setCurrentStatus("DELIVERED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderDelivery delivery = createRetailStoreOrderDelivery(who, deliveryTime);		
			retailStoreOrder.setDelivery(delivery);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withDelivery().done());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	protected RetailStoreOrderDelivery createRetailStoreOrderDelivery(String who, Date deliveryTime){
 		RetailStoreOrderDelivery delivery = new RetailStoreOrderDelivery(who, deliveryTime);
 		return getRetailStoreOrderDeliveryDAO().save(delivery,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreOrderDelivery(RetailScmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 		
 		
 		String currentStatus = retailStoreOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'DELIVERED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		if(!("DELIVERED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'DELIVERED'";
 			throw new RetailStoreOrderManagerException(message);
 		}
 		
 		
 		RetailStoreOrderDelivery delivery = retailStoreOrder.getDelivery();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = delivery 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( delivery != null){
				throw new RetailStoreOrderManagerException("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been DELIVERED");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected RetailStoreOrderApproval loadRetailStoreOrderApproval(String newApprovalId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderApprovalDAO().load(newApprovalId, options);
 	}
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newSellerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newSellerId, options);
 	}
	
	 	
 	protected RetailStoreOrderDelivery loadRetailStoreOrderDelivery(String newDeliveryId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderDeliveryDAO().load(newDeliveryId, options);
 	}
	
	 	
 	protected RetailStoreOrderPicking loadRetailStoreOrderPicking(String newPickingId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderPickingDAO().load(newPickingId, options);
 	}
	
	 	
 	protected RetailStoreOrderShipment loadRetailStoreOrderShipment(String newShipmentId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderShipmentDAO().load(newShipmentId, options);
 	}
	
	 	
 	protected RetailStoreOrderConfirmation loadRetailStoreOrderConfirmation(String newConfirmationId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderConfirmationDAO().load(newConfirmationId, options);
 	}
	
	 	
 	protected RetailStore loadRetailStore(String newBuyerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreDAO().load(newBuyerId, options);
 	}
	
	 	
 	protected RetailStoreOrderProcessing loadRetailStoreOrderProcessing(String newProcessingId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderProcessingDAO().load(newProcessingId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreOrderId, int retailStoreOrderVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderId, retailStoreOrderVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderId, int retailStoreOrderVersion) throws Exception{
		getRetailStoreOrderDAO().delete(retailStoreOrderId, retailStoreOrderVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);

		checkSkuIdOfRetailStoreOrderLineItem(userContext,  skuId, exception);
		checkSkuNameOfRetailStoreOrderLineItem(userContext,  skuName, exception);
		checkAmountOfRetailStoreOrderLineItem(userContext,  amount, exception);
		checkQuantityOfRetailStoreOrderLineItem(userContext,  quantity, exception);
		checkUnitOfMeasurementOfRetailStoreOrderLineItem(userContext,  unitOfMeasurement, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrder addRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrderLineItem(userContext,retailStoreOrderId,skuId, skuName, amount, quantity, unitOfMeasurement,tokensExpr);
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = createRetailStoreOrderLineItem(userContext,skuId, skuName, amount, quantity, unitOfMeasurement);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.addRetailStoreOrderLineItem( retailStoreOrderLineItem );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreOrderLineItem createRetailStoreOrderLineItem(RetailScmUserContext userContext, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement) throws Exception{

		RetailStoreOrderLineItem retailStoreOrderLineItem = new RetailStoreOrderLineItem();
		
		
		retailStoreOrderLineItem.setSkuId(skuId);		
		retailStoreOrderLineItem.setSkuName(skuName);		
		retailStoreOrderLineItem.setAmount(amount);		
		retailStoreOrderLineItem.setQuantity(quantity);		
		retailStoreOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);
	
		
		return retailStoreOrderLineItem;
	
		
	}
	
	protected RetailStoreOrderLineItem createIndexedRetailStoreOrderLineItem(String id, int version){

		RetailStoreOrderLineItem retailStoreOrderLineItem = new RetailStoreOrderLineItem();
		retailStoreOrderLineItem.setId(id);
		retailStoreOrderLineItem.setVersion(version);
		return retailStoreOrderLineItem;			
		
	}
	protected void checkParamsForRemovingRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, exception);
		checkVersionOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrder removeRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrderLineItem(userContext,retailStoreOrderId, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion,tokensExpr);
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = createIndexedRetailStoreOrderLineItem(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.removeRetailStoreOrderLineItem( retailStoreOrderLineItem );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, exception);
		checkVersionOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrder copyRetailStoreOrderLineItemFrom(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrderLineItem(userContext,retailStoreOrderId, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion,tokensExpr);
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = createIndexedRetailStoreOrderLineItem(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.copyRetailStoreOrderLineItemFrom( retailStoreOrderLineItem );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, exception);
		checkVersionOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemVersion, exception);
		

		if(RetailStoreOrderLineItem.SKU_ID_PROPERTY.equals(property)){
			checkSkuIdOfRetailStoreOrderLineItem(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
			checkSkuNameOfRetailStoreOrderLineItem(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreOrderLineItem.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfRetailStoreOrderLineItem(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(RetailStoreOrderLineItem.QUANTITY_PROPERTY.equals(property)){
			checkQuantityOfRetailStoreOrderLineItem(userContext, parseInt(newValueExpr), exception);
		}
		
		if(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
			checkUnitOfMeasurementOfRetailStoreOrderLineItem(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreOrder updateRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrderLineItem(userContext, retailStoreOrderId, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrder.removeRetailStoreOrderLineItem( retailStoreOrderLineItem );	
			//make changes to AcceleraterAccount.
			RetailStoreOrderLineItem retailStoreOrderLineItemIndex = createIndexedRetailStoreOrderLineItem(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
		
			RetailStoreOrderLineItem retailStoreOrderLineItem = retailStoreOrder.findTheRetailStoreOrderLineItem(retailStoreOrderLineItemIndex);
			if(retailStoreOrderLineItem == null){
				throw new RetailStoreOrderManagerException(retailStoreOrderLineItem+"Not found" );
			}
			
			retailStoreOrderLineItem.changePropery(property, newValueExpr);

			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, String name, double amount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);

		checkNameOfRetailStoreOrderShippingGroup(userContext,  name, exception);
		checkAmountOfRetailStoreOrderShippingGroup(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrder addRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, String name, double amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrderShippingGroup(userContext,retailStoreOrderId,name, amount,tokensExpr);
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = createRetailStoreOrderShippingGroup(userContext,name, amount);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.addRetailStoreOrderShippingGroup( retailStoreOrderShippingGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderShippingGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String name, double amount) throws Exception{

		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = new RetailStoreOrderShippingGroup();
		
		
		retailStoreOrderShippingGroup.setName(name);		
		retailStoreOrderShippingGroup.setAmount(amount);
	
		
		return retailStoreOrderShippingGroup;
	
		
	}
	
	protected RetailStoreOrderShippingGroup createIndexedRetailStoreOrderShippingGroup(String id, int version){

		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = new RetailStoreOrderShippingGroup();
		retailStoreOrderShippingGroup.setId(id);
		retailStoreOrderShippingGroup.setVersion(version);
		return retailStoreOrderShippingGroup;			
		
	}
	protected void checkParamsForRemovingRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, exception);
		checkVersionOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrder removeRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrderShippingGroup(userContext,retailStoreOrderId, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion,tokensExpr);
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = createIndexedRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.removeRetailStoreOrderShippingGroup( retailStoreOrderShippingGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderShippingGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, exception);
		checkVersionOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrder copyRetailStoreOrderShippingGroupFrom(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrderShippingGroup(userContext,retailStoreOrderId, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion,tokensExpr);
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = createIndexedRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.copyRetailStoreOrderShippingGroupFrom( retailStoreOrderShippingGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderShippingGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, exception);
		checkVersionOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupVersion, exception);
		

		if(RetailStoreOrderShippingGroup.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreOrderShippingGroup(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfRetailStoreOrderShippingGroup(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreOrder updateRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrderShippingGroup(userContext, retailStoreOrderId, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrder.removeRetailStoreOrderShippingGroup( retailStoreOrderShippingGroup );	
			//make changes to AcceleraterAccount.
			RetailStoreOrderShippingGroup retailStoreOrderShippingGroupIndex = createIndexedRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
		
			RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = retailStoreOrder.findTheRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupIndex);
			if(retailStoreOrderShippingGroup == null){
				throw new RetailStoreOrderManagerException(retailStoreOrderShippingGroup+"Not found" );
			}
			
			retailStoreOrderShippingGroup.changePropery(property, newValueExpr);

			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderShippingGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, String name, String cardNumber,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);

		checkNameOfRetailStoreOrderPaymentGroup(userContext,  name, exception);
		checkCardNumberOfRetailStoreOrderPaymentGroup(userContext,  cardNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrder addRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, String name, String cardNumber, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrderPaymentGroup(userContext,retailStoreOrderId,name, cardNumber,tokensExpr);
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = createRetailStoreOrderPaymentGroup(userContext,name, cardNumber);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.addRetailStoreOrderPaymentGroup( retailStoreOrderPaymentGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderPaymentGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String name, String cardNumber) throws Exception{

		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = new RetailStoreOrderPaymentGroup();
		
		
		retailStoreOrderPaymentGroup.setName(name);		
		retailStoreOrderPaymentGroup.setCardNumber(cardNumber);
	
		
		return retailStoreOrderPaymentGroup;
	
		
	}
	
	protected RetailStoreOrderPaymentGroup createIndexedRetailStoreOrderPaymentGroup(String id, int version){

		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = new RetailStoreOrderPaymentGroup();
		retailStoreOrderPaymentGroup.setId(id);
		retailStoreOrderPaymentGroup.setVersion(version);
		return retailStoreOrderPaymentGroup;			
		
	}
	protected void checkParamsForRemovingRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, exception);
		checkVersionOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrder removeRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrderPaymentGroup(userContext,retailStoreOrderId, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion,tokensExpr);
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = createIndexedRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.removeRetailStoreOrderPaymentGroup( retailStoreOrderPaymentGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderPaymentGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, exception);
		checkVersionOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrder copyRetailStoreOrderPaymentGroupFrom(RetailScmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrderPaymentGroup(userContext,retailStoreOrderId, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion,tokensExpr);
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = createIndexedRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.copyRetailStoreOrderPaymentGroupFrom( retailStoreOrderPaymentGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderPaymentGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, exception);
		checkVersionOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupVersion, exception);
		

		if(RetailStoreOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			checkCardNumberOfRetailStoreOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreOrder updateRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderId, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrder.removeRetailStoreOrderPaymentGroup( retailStoreOrderPaymentGroup );	
			//make changes to AcceleraterAccount.
			RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroupIndex = createIndexedRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
		
			RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = retailStoreOrder.findTheRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupIndex);
			if(retailStoreOrderPaymentGroup == null){
				throw new RetailStoreOrderManagerException(retailStoreOrderPaymentGroup+"Not found" );
			}
			
			retailStoreOrderPaymentGroup.changePropery(property, newValueExpr);

			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderPaymentGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String retailStoreOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId,String [] tokensExpr) throws Exception{
		
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);

		checkNameOfGoods(userContext,  name, exception);
		checkRfidOfGoods(userContext,  rfid, exception);
		checkUomOfGoods(userContext,  uom, exception);
		checkMaxPackageOfGoods(userContext,  maxPackage, exception);
		checkExpireTimeOfGoods(userContext,  expireTime, exception);		
		
		checkIdOfSku(userContext,  skuId, exception);		
		
		checkIdOfReceivingSpace(userContext,  receivingSpaceId, exception);		
		
		checkIdOfGoodsAllocation(userContext,  goodsAllocationId, exception);		
		
		checkIdOfSmartPallet(userContext,  smartPalletId, exception);		
		
		checkIdOfShippingSpace(userContext,  shippingSpaceId, exception);		
		
		checkIdOfTransportTask(userContext,  transportTaskId, exception);		
		
		checkIdOfRetailStore(userContext,  retailStoreId, exception);		
		
		checkIdOfSupplyOrder(userContext,  bizOrderId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreOrder addGoods(RetailScmUserContext userContext, String retailStoreOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,retailStoreOrderId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.addGoods( goods );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
		ReceivingSpace  receivingSpace = new ReceivingSpace();
		receivingSpace.setId(receivingSpaceId);		
		goods.setReceivingSpace(receivingSpace);		
		GoodsAllocation  goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(goodsAllocationId);		
		goods.setGoodsAllocation(goodsAllocation);		
		SmartPallet  smartPallet = new SmartPallet();
		smartPallet.setId(smartPalletId);		
		goods.setSmartPallet(smartPallet);		
		ShippingSpace  shippingSpace = new ShippingSpace();
		shippingSpace.setId(shippingSpaceId);		
		goods.setShippingSpace(shippingSpace);		
		TransportTask  transportTask = new TransportTask();
		transportTask.setId(transportTaskId);		
		goods.setTransportTask(transportTask);		
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		goods.setRetailStore(retailStore);		
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);
	
		
		return goods;
	
		
	}
	
	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;			
		
	}
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String retailStoreOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrder removeGoods(RetailScmUserContext userContext, String retailStoreOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,retailStoreOrderId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.removeGoods( goods );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String retailStoreOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreOrder copyGoodsFrom(RetailScmUserContext userContext, String retailStoreOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,retailStoreOrderId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.copyGoodsFrom( goods );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreOrderManagerException exception = new RetailStoreOrderManagerException("Error Occured");
		
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);
		

		if(Goods.NAME_PROPERTY.equals(property)){
			checkNameOfGoods(userContext, parseString(newValueExpr), exception);
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
			checkRfidOfGoods(userContext, parseString(newValueExpr), exception);
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
			checkUomOfGoods(userContext, parseString(newValueExpr), exception);
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
			checkMaxPackageOfGoods(userContext, parseInt(newValueExpr), exception);
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
			checkExpireTimeOfGoods(userContext, parseDate(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreOrder updateGoods(RetailScmUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, retailStoreOrderId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrder.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = retailStoreOrder.findTheGoods(goodsIndex);
			if(goods == null){
				throw new RetailStoreOrderManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


