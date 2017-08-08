
package com.skynet.retailscm.consumerorder;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.skynet.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.skynet.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;

import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmationDAO;
import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessingDAO;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDeliveryDAO;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApprovalDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipmentDAO;

import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.consumerorder.ConsumerOrder;


import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApprovalTable;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordTable;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDeliveryTable;
import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessingTable;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipmentTable;
import com.skynet.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupTable;
import com.skynet.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentTable;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmationTable;
import com.skynet.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupTable;
import com.skynet.retailscm.consumerorderlineitem.ConsumerOrderLineItemTable;




public class ConsumerOrderManagerImpl extends RetailScmCheckerManager implements ConsumerOrderManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrder";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO  consumerOrderDAO){
 	
 		if(consumerOrderDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
 		}
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
 		if(this.consumerOrderDAO == null){
 			throw new IllegalStateException("The ConsumerOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderDAO;
 	}
 	
 	protected ConsumerOrder saveConsumerOrder(RetailScmUserContext userContext, ConsumerOrder consumerOrder, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderDAO().save(consumerOrder, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrder(userContext, consumerOrder, tokens);
 	}
 	
 	protected ConsumerOrder saveConsumerOrderDetail(RetailScmUserContext userContext, ConsumerOrder consumerOrder) throws Exception{	

 		
 		return saveConsumerOrder(userContext, consumerOrder, allTokens());
 	}
 	
 	public ConsumerOrder loadConsumerOrder(RetailScmUserContext userContext, String consumerOrderId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrder consumerOrder = loadConsumerOrder( userContext, consumerOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrder, tokens);
 	}
 	
 	protected ConsumerOrder present(RetailScmUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrder,tokens);
		
		
		return this.getConsumerOrderDAO().present(consumerOrder, tokens);
	}
 
 	
 	
 	public ConsumerOrder loadConsumerOrderDetail(RetailScmUserContext userContext, String consumerOrderId) throws Exception{	
 		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrder consumerOrder = loadConsumerOrder( userContext, consumerOrderId, allTokens());

 		return present(userContext,consumerOrder, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderId) throws Exception{	
 		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrder consumerOrder = loadConsumerOrder( userContext, consumerOrderId, allTokens());

 		return present(userContext,consumerOrder, allTokens());
		
 	}
 	protected ConsumerOrder saveConsumerOrder(RetailScmUserContext userContext, ConsumerOrder consumerOrder, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderDAO().save(consumerOrder, tokens);
 	}
 	protected ConsumerOrder loadConsumerOrder(RetailScmUserContext userContext, String consumerOrderId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderDAO().load(consumerOrderId, tokens);
 	}

	



 	 
 	
 	private  SupplyOrderApprovalDAO  supplyOrderApprovalDAO;
 	public void setSupplyOrderApprovalDAO(SupplyOrderApprovalDAO supplyOrderApprovalDAO){
	 	this.supplyOrderApprovalDAO = supplyOrderApprovalDAO;
 	}
 	//------------------------------------
 	public SupplyOrderApprovalDAO getSupplyOrderApprovalDAO(){
	 	return this.supplyOrderApprovalDAO;
 	}
 
 	
 	private  SupplyOrderDeliveryDAO  supplyOrderDeliveryDAO;
 	public void setSupplyOrderDeliveryDAO(SupplyOrderDeliveryDAO supplyOrderDeliveryDAO){
	 	this.supplyOrderDeliveryDAO = supplyOrderDeliveryDAO;
 	}
 	//------------------------------------
 	public SupplyOrderDeliveryDAO getSupplyOrderDeliveryDAO(){
	 	return this.supplyOrderDeliveryDAO;
 	}
 
 	
 	private  SupplyOrderShipmentDAO  supplyOrderShipmentDAO;
 	public void setSupplyOrderShipmentDAO(SupplyOrderShipmentDAO supplyOrderShipmentDAO){
	 	this.supplyOrderShipmentDAO = supplyOrderShipmentDAO;
 	}
 	//------------------------------------
 	public SupplyOrderShipmentDAO getSupplyOrderShipmentDAO(){
	 	return this.supplyOrderShipmentDAO;
 	}
 
 	
 	private  SupplyOrderConfirmationDAO  supplyOrderConfirmationDAO;
 	public void setSupplyOrderConfirmationDAO(SupplyOrderConfirmationDAO supplyOrderConfirmationDAO){
	 	this.supplyOrderConfirmationDAO = supplyOrderConfirmationDAO;
 	}
 	//------------------------------------
 	public SupplyOrderConfirmationDAO getSupplyOrderConfirmationDAO(){
	 	return this.supplyOrderConfirmationDAO;
 	}
 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	//------------------------------------
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	//------------------------------------
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}
 
 	
 	private  SupplyOrderProcessingDAO  supplyOrderProcessingDAO;
 	public void setSupplyOrderProcessingDAO(SupplyOrderProcessingDAO supplyOrderProcessingDAO){
	 	this.supplyOrderProcessingDAO = supplyOrderProcessingDAO;
 	}
 	//------------------------------------
 	public SupplyOrderProcessingDAO getSupplyOrderProcessingDAO(){
	 	return this.supplyOrderProcessingDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrder, tokens);
		
		addAction(userContext, consumerOrder, tokens,"@create","createConsumerOrder","createConsumerOrder/","main","primary");
		addAction(userContext, consumerOrder, tokens,"@update","updateConsumerOrder","updateConsumerOrder/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"@copy","cloneConsumerOrder","cloneConsumerOrder/"+consumerOrder.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrder, tokens,"consumer_order.transfer_to_consumer","transferToAnotherConsumer","transferToAnotherConsumer/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.transfer_to_store","transferToAnotherStore","transferToAnotherStore/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.confirm","confirm","confirm/"+consumerOrder.getId()+"/","main","success");
		addAction(userContext, consumerOrder, tokens,"consumer_order.approve","approve","approve/"+consumerOrder.getId()+"/","main","success");
		addAction(userContext, consumerOrder, tokens,"consumer_order.process","process","process/"+consumerOrder.getId()+"/","main","info");
		addAction(userContext, consumerOrder, tokens,"consumer_order.ship","ship","ship/"+consumerOrder.getId()+"/","main","success");
		addAction(userContext, consumerOrder, tokens,"consumer_order.deliver","deliver","deliver/"+consumerOrder.getId()+"/","main","success");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addConsumerOrderLineItem","addConsumerOrderLineItem","addConsumerOrderLineItem/"+consumerOrder.getId()+"/","consumerOrderLineItemList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeConsumerOrderLineItem","removeConsumerOrderLineItem","removeConsumerOrderLineItem/"+consumerOrder.getId()+"/","consumerOrderLineItemList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateConsumerOrderLineItem","updateConsumerOrderLineItem","updateConsumerOrderLineItem/"+consumerOrder.getId()+"/","consumerOrderLineItemList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyConsumerOrderLineItemFrom","copyConsumerOrderLineItemFrom","copyConsumerOrderLineItemFrom/"+consumerOrder.getId()+"/","consumerOrderLineItemList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addConsumerOrderShippingGroup","addConsumerOrderShippingGroup","addConsumerOrderShippingGroup/"+consumerOrder.getId()+"/","consumerOrderShippingGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeConsumerOrderShippingGroup","removeConsumerOrderShippingGroup","removeConsumerOrderShippingGroup/"+consumerOrder.getId()+"/","consumerOrderShippingGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateConsumerOrderShippingGroup","updateConsumerOrderShippingGroup","updateConsumerOrderShippingGroup/"+consumerOrder.getId()+"/","consumerOrderShippingGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyConsumerOrderShippingGroupFrom","copyConsumerOrderShippingGroupFrom","copyConsumerOrderShippingGroupFrom/"+consumerOrder.getId()+"/","consumerOrderShippingGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addConsumerOrderPaymentGroup","addConsumerOrderPaymentGroup","addConsumerOrderPaymentGroup/"+consumerOrder.getId()+"/","consumerOrderPaymentGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeConsumerOrderPaymentGroup","removeConsumerOrderPaymentGroup","removeConsumerOrderPaymentGroup/"+consumerOrder.getId()+"/","consumerOrderPaymentGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateConsumerOrderPaymentGroup","updateConsumerOrderPaymentGroup","updateConsumerOrderPaymentGroup/"+consumerOrder.getId()+"/","consumerOrderPaymentGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyConsumerOrderPaymentGroupFrom","copyConsumerOrderPaymentGroupFrom","copyConsumerOrderPaymentGroupFrom/"+consumerOrder.getId()+"/","consumerOrderPaymentGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addConsumerOrderPriceAdjustment","addConsumerOrderPriceAdjustment","addConsumerOrderPriceAdjustment/"+consumerOrder.getId()+"/","consumerOrderPriceAdjustmentList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeConsumerOrderPriceAdjustment","removeConsumerOrderPriceAdjustment","removeConsumerOrderPriceAdjustment/"+consumerOrder.getId()+"/","consumerOrderPriceAdjustmentList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateConsumerOrderPriceAdjustment","updateConsumerOrderPriceAdjustment","updateConsumerOrderPriceAdjustment/"+consumerOrder.getId()+"/","consumerOrderPriceAdjustmentList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyConsumerOrderPriceAdjustmentFrom","copyConsumerOrderPriceAdjustmentFrom","copyConsumerOrderPriceAdjustmentFrom/"+consumerOrder.getId()+"/","consumerOrderPriceAdjustmentList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addRetailStoreMemberGiftCardConsumeRecord","addRetailStoreMemberGiftCardConsumeRecord","addRetailStoreMemberGiftCardConsumeRecord/"+consumerOrder.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeRetailStoreMemberGiftCardConsumeRecord","removeRetailStoreMemberGiftCardConsumeRecord","removeRetailStoreMemberGiftCardConsumeRecord/"+consumerOrder.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord/"+consumerOrder.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyRetailStoreMemberGiftCardConsumeRecordFrom","copyRetailStoreMemberGiftCardConsumeRecordFrom","copyRetailStoreMemberGiftCardConsumeRecordFrom/"+consumerOrder.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrder createConsumerOrder(RetailScmUserContext userContext,String title, String consumerId, String storeId
) throws Exception
	{
		
		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");

		

		checkTitleOfConsumerOrder(userContext,  title, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrder consumerOrder=createNewConsumerOrder();	

		consumerOrder.setTitle(title);
		RetailStoreMember consumer = loadRetailStoreMember(consumerId,emptyOptions());
		consumerOrder.setConsumer(consumer);
		RetailStore store = loadRetailStore(storeId,emptyOptions());
		consumerOrder.setStore(store);

		return saveConsumerOrder(userContext, consumerOrder, emptyOptions());
		

		
	}
	protected ConsumerOrder createNewConsumerOrder() 
	{
		
		return new ConsumerOrder();		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailScmUserContext userContext,String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfConsumerOrder(userContext, parseString(newValueExpr), exception);
		}		

				

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ConsumerOrder clone(RetailScmUserContext userContext, String fromConsumerOrderId) throws Exception{
		
		return this.getConsumerOrderDAO().clone(fromConsumerOrderId, this.allTokens());
	}
	
	public ConsumerOrder updateConsumerOrder(RetailScmUserContext userContext,String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrder(userContext, consumerOrderId, consumerOrderVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		if(consumerOrder.getVersion() != consumerOrderVersion){
			String message = "The target version("+consumerOrder.getVersion()+") is not equals to version("+consumerOrderVersion+") provided";
			throw new ConsumerOrderManagerException(message);
		}
		synchronized(consumerOrder){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrder.
			
			consumerOrder.changePropery(property, newValueExpr);
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
			//return saveConsumerOrder(userContext, consumerOrder, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderTokens tokens(){
		return ConsumerOrderTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={"CONFIRMED","APPROVED","PROCESSED","SHIPPED","DELIVERED"};
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
	
	protected void checkParamsForTransferingAnotherConsumer(RetailScmUserContext userContext, String consumerOrderId, String anotherConsumerId) throws Exception
 	{
 		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
 		checkIdOfConsumerOrder(userContext, consumerOrderId,exception);
 		checkIdOfRetailStoreMember(userContext, anotherConsumerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ConsumerOrder transferToAnotherConsumer(RetailScmUserContext userContext, String consumerOrderId, String anotherConsumerId) throws Exception
 	{
 		checkParamsForTransferingAnotherConsumer(userContext, consumerOrderId,anotherConsumerId);
 
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember consumer = loadRetailStoreMember(anotherConsumerId, emptyOptions());		
			consumerOrder.setConsumer(consumer);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
			
			return present(userContext,consumerOrder, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForConfirmation(RetailScmUserContext userContext, String consumerOrderId, String who, Date confirmTime
) throws Exception
 	{
 		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkWhoOfSupplyOrderConfirmation(userContext,who,exception);
		checkConfirmTimeOfSupplyOrderConfirmation(userContext,confirmTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public ConsumerOrder confirm(RetailScmUserContext userContext, String consumerOrderId, String who, Date confirmTime
) throws Exception
 	{
		checkParamsForConfirmation(userContext, consumerOrderId, who, confirmTime);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderConfirmation(userContext,consumerOrder);
 		

			consumerOrder.setCurrentStatus("CONFIRMED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderConfirmation confirmation = createSupplyOrderConfirmation(who, confirmTime);		
			consumerOrder.setConfirmation(confirmation);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConfirmation().done());
			
			return present(userContext,consumerOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderConfirmation createSupplyOrderConfirmation(String who, Date confirmTime){
 		SupplyOrderConfirmation confirmation = new SupplyOrderConfirmation(who, confirmTime);
 		return getSupplyOrderConfirmationDAO().save(confirmation,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderConfirmation(RetailScmUserContext userContext, ConsumerOrder consumerOrder) throws Exception{
 		
 		
 		String currentStatus = consumerOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		if(!("CONFIRMED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderConfirmation confirmation = consumerOrder.getConfirmation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = confirmation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( confirmation != null){
				throw new ConsumerOrderManagerException("The ConsumerOrder("+consumerOrder.getId()+") has already been CONFIRMED");
		}
 		
 		
 	}
	
 	protected void checkParamsForApproval(RetailScmUserContext userContext, String consumerOrderId, String who, Date approveTime
) throws Exception
 	{
 		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkWhoOfSupplyOrderApproval(userContext,who,exception);
		checkApproveTimeOfSupplyOrderApproval(userContext,approveTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public ConsumerOrder approve(RetailScmUserContext userContext, String consumerOrderId, String who, Date approveTime
) throws Exception
 	{
		checkParamsForApproval(userContext, consumerOrderId, who, approveTime);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderApproval(userContext,consumerOrder);
 		

			consumerOrder.setCurrentStatus("APPROVED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderApproval approval = createSupplyOrderApproval(who, approveTime);		
			consumerOrder.setApproval(approval);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withApproval().done());
			
			return present(userContext,consumerOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderApproval createSupplyOrderApproval(String who, Date approveTime){
 		SupplyOrderApproval approval = new SupplyOrderApproval(who, approveTime);
 		return getSupplyOrderApprovalDAO().save(approval,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderApproval(RetailScmUserContext userContext, ConsumerOrder consumerOrder) throws Exception{
 		
 		
 		String currentStatus = consumerOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'APPROVED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		if(!("APPROVED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'APPROVED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderApproval approval = consumerOrder.getApproval();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = approval 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( approval != null){
				throw new ConsumerOrderManagerException("The ConsumerOrder("+consumerOrder.getId()+") has already been APPROVED");
		}
 		
 		
 	}
	
 	protected void checkParamsForProcessing(RetailScmUserContext userContext, String consumerOrderId, String who, Date processTime
) throws Exception
 	{
 		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkWhoOfSupplyOrderProcessing(userContext,who,exception);
		checkProcessTimeOfSupplyOrderProcessing(userContext,processTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public ConsumerOrder process(RetailScmUserContext userContext, String consumerOrderId, String who, Date processTime
) throws Exception
 	{
		checkParamsForProcessing(userContext, consumerOrderId, who, processTime);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderProcessing(userContext,consumerOrder);
 		

			consumerOrder.setCurrentStatus("PROCESSED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderProcessing processing = createSupplyOrderProcessing(who, processTime);		
			consumerOrder.setProcessing(processing);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withProcessing().done());
			
			return present(userContext,consumerOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderProcessing createSupplyOrderProcessing(String who, Date processTime){
 		SupplyOrderProcessing processing = new SupplyOrderProcessing(who, processTime);
 		return getSupplyOrderProcessingDAO().save(processing,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderProcessing(RetailScmUserContext userContext, ConsumerOrder consumerOrder) throws Exception{
 		
 		
 		String currentStatus = consumerOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'PROCESSED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		if(!("PROCESSED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'PROCESSED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderProcessing processing = consumerOrder.getProcessing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = processing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( processing != null){
				throw new ConsumerOrderManagerException("The ConsumerOrder("+consumerOrder.getId()+") has already been PROCESSED");
		}
 		
 		
 	}
	
 	protected void checkParamsForShipment(RetailScmUserContext userContext, String consumerOrderId, String who, Date shipTime
) throws Exception
 	{
 		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkWhoOfSupplyOrderShipment(userContext,who,exception);
		checkShipTimeOfSupplyOrderShipment(userContext,shipTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public ConsumerOrder ship(RetailScmUserContext userContext, String consumerOrderId, String who, Date shipTime
) throws Exception
 	{
		checkParamsForShipment(userContext, consumerOrderId, who, shipTime);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderShipment(userContext,consumerOrder);
 		

			consumerOrder.setCurrentStatus("SHIPPED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderShipment shipment = createSupplyOrderShipment(who, shipTime);		
			consumerOrder.setShipment(shipment);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withShipment().done());
			
			return present(userContext,consumerOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderShipment createSupplyOrderShipment(String who, Date shipTime){
 		SupplyOrderShipment shipment = new SupplyOrderShipment(who, shipTime);
 		return getSupplyOrderShipmentDAO().save(shipment,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderShipment(RetailScmUserContext userContext, ConsumerOrder consumerOrder) throws Exception{
 		
 		
 		String currentStatus = consumerOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'SHIPPED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		if(!("SHIPPED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'SHIPPED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderShipment shipment = consumerOrder.getShipment();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = shipment 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( shipment != null){
				throw new ConsumerOrderManagerException("The ConsumerOrder("+consumerOrder.getId()+") has already been SHIPPED");
		}
 		
 		
 	}
	
 	protected void checkParamsForDelivery(RetailScmUserContext userContext, String consumerOrderId, String who, Date deliveryTime
) throws Exception
 	{
 		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkWhoOfSupplyOrderDelivery(userContext,who,exception);
		checkDeliveryTimeOfSupplyOrderDelivery(userContext,deliveryTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public ConsumerOrder deliver(RetailScmUserContext userContext, String consumerOrderId, String who, Date deliveryTime
) throws Exception
 	{
		checkParamsForDelivery(userContext, consumerOrderId, who, deliveryTime);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderDelivery(userContext,consumerOrder);
 		

			consumerOrder.setCurrentStatus("DELIVERED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderDelivery delivery = createSupplyOrderDelivery(who, deliveryTime);		
			consumerOrder.setDelivery(delivery);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withDelivery().done());
			
			return present(userContext,consumerOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderDelivery createSupplyOrderDelivery(String who, Date deliveryTime){
 		SupplyOrderDelivery delivery = new SupplyOrderDelivery(who, deliveryTime);
 		return getSupplyOrderDeliveryDAO().save(delivery,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderDelivery(RetailScmUserContext userContext, ConsumerOrder consumerOrder) throws Exception{
 		
 		
 		String currentStatus = consumerOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'DELIVERED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		if(!("DELIVERED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'DELIVERED'";
 			throw new ConsumerOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderDelivery delivery = consumerOrder.getDelivery();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = delivery 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( delivery != null){
				throw new ConsumerOrderManagerException("The ConsumerOrder("+consumerOrder.getId()+") has already been DELIVERED");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherStore(RetailScmUserContext userContext, String consumerOrderId, String anotherStoreId) throws Exception
 	{
 		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
 		checkIdOfConsumerOrder(userContext, consumerOrderId,exception);
 		checkIdOfRetailStore(userContext, anotherStoreId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ConsumerOrder transferToAnotherStore(RetailScmUserContext userContext, String consumerOrderId, String anotherStoreId) throws Exception
 	{
 		checkParamsForTransferingAnotherStore(userContext, consumerOrderId,anotherStoreId);
 
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore store = loadRetailStore(anotherStoreId, emptyOptions());		
			consumerOrder.setStore(store);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
			
			return present(userContext,consumerOrder, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected SupplyOrderApproval loadSupplyOrderApproval(String newApprovalId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderApprovalDAO().load(newApprovalId, options);
 	}
	
	 	
 	protected SupplyOrderDelivery loadSupplyOrderDelivery(String newDeliveryId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderDeliveryDAO().load(newDeliveryId, options);
 	}
	
	 	
 	protected SupplyOrderShipment loadSupplyOrderShipment(String newShipmentId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderShipmentDAO().load(newShipmentId, options);
 	}
	
	 	
 	protected SupplyOrderConfirmation loadSupplyOrderConfirmation(String newConfirmationId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderConfirmationDAO().load(newConfirmationId, options);
 	}
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(String newConsumerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreMemberDAO().load(newConsumerId, options);
 	}
	
	 	
 	protected RetailStore loadRetailStore(String newStoreId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreDAO().load(newStoreId, options);
 	}
	
	 	
 	protected SupplyOrderProcessing loadSupplyOrderProcessing(String newProcessingId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderProcessingDAO().load(newProcessingId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String consumerOrderId, int consumerOrderVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderId, consumerOrderVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderId, int consumerOrderVersion) throws Exception{
		getConsumerOrderDAO().delete(consumerOrderId, consumerOrderVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderDAO().deleteAll();
	}

	protected void checkParamsForAddingConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, String skuId, String skuName, double price, double quantity, double amount,String [] tokensExpr) throws Exception{
		
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);

		checkSkuIdOfConsumerOrderLineItem(userContext,  skuId, exception);
		checkSkuNameOfConsumerOrderLineItem(userContext,  skuName, exception);
		checkPriceOfConsumerOrderLineItem(userContext,  price, exception);
		checkQuantityOfConsumerOrderLineItem(userContext,  quantity, exception);
		checkAmountOfConsumerOrderLineItem(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  ConsumerOrder addConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, String skuId, String skuName, double price, double quantity, double amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrderLineItem(userContext,consumerOrderId,skuId, skuName, price, quantity, amount,tokensExpr);
		
		ConsumerOrderLineItem consumerOrderLineItem = createConsumerOrderLineItem(userContext,skuId, skuName, price, quantity, amount);
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addConsumerOrderLineItem( consumerOrderLineItem );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected ConsumerOrderLineItem createConsumerOrderLineItem(RetailScmUserContext userContext, String skuId, String skuName, double price, double quantity, double amount) throws Exception{

		ConsumerOrderLineItem consumerOrderLineItem = new ConsumerOrderLineItem();
		
		
		consumerOrderLineItem.setSkuId(skuId);		
		consumerOrderLineItem.setSkuName(skuName);		
		consumerOrderLineItem.setPrice(price);		
		consumerOrderLineItem.setQuantity(quantity);		
		consumerOrderLineItem.setAmount(amount);
	
		
		return consumerOrderLineItem;
	
		
	}
	
	protected ConsumerOrderLineItem createIndexedConsumerOrderLineItem(String id, int version){

		ConsumerOrderLineItem consumerOrderLineItem = new ConsumerOrderLineItem();
		consumerOrderLineItem.setId(id);
		consumerOrderLineItem.setVersion(version);
		return consumerOrderLineItem;			
		
	}
	protected void checkParamsForRemovingConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderLineItem(userContext, consumerOrderLineItemId, exception);
		checkVersionOfConsumerOrderLineItem(userContext, consumerOrderLineItemVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder removeConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrderLineItem(userContext,consumerOrderId, consumerOrderLineItemId, consumerOrderLineItemVersion,tokensExpr);
		
		ConsumerOrderLineItem consumerOrderLineItem = createIndexedConsumerOrderLineItem(consumerOrderLineItemId, consumerOrderLineItemVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeConsumerOrderLineItem( consumerOrderLineItem );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderLineItem(userContext, consumerOrderLineItemId, exception);
		checkVersionOfConsumerOrderLineItem(userContext, consumerOrderLineItemVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder copyConsumerOrderLineItemFrom(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrderLineItem(userContext,consumerOrderId, consumerOrderLineItemId, consumerOrderLineItemVersion,tokensExpr);
		
		ConsumerOrderLineItem consumerOrderLineItem = createIndexedConsumerOrderLineItem(consumerOrderLineItemId, consumerOrderLineItemVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.copyConsumerOrderLineItemFrom( consumerOrderLineItem );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderLineItem(userContext, consumerOrderLineItemId, exception);
		checkVersionOfConsumerOrderLineItem(userContext, consumerOrderLineItemVersion, exception);
		

		if(ConsumerOrderLineItem.SKU_ID_PROPERTY.equals(property)){
			checkSkuIdOfConsumerOrderLineItem(userContext, parseString(newValueExpr), exception);
		}
		
		if(ConsumerOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
			checkSkuNameOfConsumerOrderLineItem(userContext, parseString(newValueExpr), exception);
		}
		
		if(ConsumerOrderLineItem.PRICE_PROPERTY.equals(property)){
			checkPriceOfConsumerOrderLineItem(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(ConsumerOrderLineItem.QUANTITY_PROPERTY.equals(property)){
			checkQuantityOfConsumerOrderLineItem(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(ConsumerOrderLineItem.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfConsumerOrderLineItem(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  ConsumerOrder updateConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrderLineItem(userContext, consumerOrderId, consumerOrderLineItemId, consumerOrderLineItemVersion, property, newValueExpr,  tokensExpr);
		
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeConsumerOrderLineItem( consumerOrderLineItem );	
			//make changes to AcceleraterAccount.
			ConsumerOrderLineItem consumerOrderLineItemIndex = createIndexedConsumerOrderLineItem(consumerOrderLineItemId, consumerOrderLineItemVersion);
		
			ConsumerOrderLineItem consumerOrderLineItem = consumerOrder.findTheConsumerOrderLineItem(consumerOrderLineItemIndex);
			if(consumerOrderLineItem == null){
				throw new ConsumerOrderManagerException(consumerOrderLineItem+"Not found" );
			}
			
			consumerOrderLineItem.changePropery(property, newValueExpr);

			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, String name, double amount,String [] tokensExpr) throws Exception{
		
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);

		checkNameOfConsumerOrderShippingGroup(userContext,  name, exception);
		checkAmountOfConsumerOrderShippingGroup(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  ConsumerOrder addConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, String name, double amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrderShippingGroup(userContext,consumerOrderId,name, amount,tokensExpr);
		
		ConsumerOrderShippingGroup consumerOrderShippingGroup = createConsumerOrderShippingGroup(userContext,name, amount);
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addConsumerOrderShippingGroup( consumerOrderShippingGroup );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected ConsumerOrderShippingGroup createConsumerOrderShippingGroup(RetailScmUserContext userContext, String name, double amount) throws Exception{

		ConsumerOrderShippingGroup consumerOrderShippingGroup = new ConsumerOrderShippingGroup();
		
		
		consumerOrderShippingGroup.setName(name);		
		consumerOrderShippingGroup.setAmount(amount);
	
		
		return consumerOrderShippingGroup;
	
		
	}
	
	protected ConsumerOrderShippingGroup createIndexedConsumerOrderShippingGroup(String id, int version){

		ConsumerOrderShippingGroup consumerOrderShippingGroup = new ConsumerOrderShippingGroup();
		consumerOrderShippingGroup.setId(id);
		consumerOrderShippingGroup.setVersion(version);
		return consumerOrderShippingGroup;			
		
	}
	protected void checkParamsForRemovingConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, exception);
		checkVersionOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder removeConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrderShippingGroup(userContext,consumerOrderId, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion,tokensExpr);
		
		ConsumerOrderShippingGroup consumerOrderShippingGroup = createIndexedConsumerOrderShippingGroup(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeConsumerOrderShippingGroup( consumerOrderShippingGroup );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, exception);
		checkVersionOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder copyConsumerOrderShippingGroupFrom(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrderShippingGroup(userContext,consumerOrderId, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion,tokensExpr);
		
		ConsumerOrderShippingGroup consumerOrderShippingGroup = createIndexedConsumerOrderShippingGroup(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.copyConsumerOrderShippingGroupFrom( consumerOrderShippingGroup );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, exception);
		checkVersionOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupVersion, exception);
		

		if(ConsumerOrderShippingGroup.NAME_PROPERTY.equals(property)){
			checkNameOfConsumerOrderShippingGroup(userContext, parseString(newValueExpr), exception);
		}
		
		if(ConsumerOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfConsumerOrderShippingGroup(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  ConsumerOrder updateConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderId, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr,  tokensExpr);
		
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeConsumerOrderShippingGroup( consumerOrderShippingGroup );	
			//make changes to AcceleraterAccount.
			ConsumerOrderShippingGroup consumerOrderShippingGroupIndex = createIndexedConsumerOrderShippingGroup(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
		
			ConsumerOrderShippingGroup consumerOrderShippingGroup = consumerOrder.findTheConsumerOrderShippingGroup(consumerOrderShippingGroupIndex);
			if(consumerOrderShippingGroup == null){
				throw new ConsumerOrderManagerException(consumerOrderShippingGroup+"Not found" );
			}
			
			consumerOrderShippingGroup.changePropery(property, newValueExpr);

			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, String name, String cardNumber,String [] tokensExpr) throws Exception{
		
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);

		checkNameOfConsumerOrderPaymentGroup(userContext,  name, exception);
		checkCardNumberOfConsumerOrderPaymentGroup(userContext,  cardNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  ConsumerOrder addConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, String name, String cardNumber, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrderPaymentGroup(userContext,consumerOrderId,name, cardNumber,tokensExpr);
		
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = createConsumerOrderPaymentGroup(userContext,name, cardNumber);
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addConsumerOrderPaymentGroup( consumerOrderPaymentGroup );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(RetailScmUserContext userContext, String name, String cardNumber) throws Exception{

		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = new ConsumerOrderPaymentGroup();
		
		
		consumerOrderPaymentGroup.setName(name);		
		consumerOrderPaymentGroup.setCardNumber(cardNumber);
	
		
		return consumerOrderPaymentGroup;
	
		
	}
	
	protected ConsumerOrderPaymentGroup createIndexedConsumerOrderPaymentGroup(String id, int version){

		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = new ConsumerOrderPaymentGroup();
		consumerOrderPaymentGroup.setId(id);
		consumerOrderPaymentGroup.setVersion(version);
		return consumerOrderPaymentGroup;			
		
	}
	protected void checkParamsForRemovingConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, exception);
		checkVersionOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder removeConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrderPaymentGroup(userContext,consumerOrderId, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion,tokensExpr);
		
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = createIndexedConsumerOrderPaymentGroup(consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeConsumerOrderPaymentGroup( consumerOrderPaymentGroup );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, exception);
		checkVersionOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder copyConsumerOrderPaymentGroupFrom(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrderPaymentGroup(userContext,consumerOrderId, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion,tokensExpr);
		
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = createIndexedConsumerOrderPaymentGroup(consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.copyConsumerOrderPaymentGroupFrom( consumerOrderPaymentGroup );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, exception);
		checkVersionOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupVersion, exception);
		

		if(ConsumerOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			checkNameOfConsumerOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}
		
		if(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			checkCardNumberOfConsumerOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  ConsumerOrder updateConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrderPaymentGroup(userContext, consumerOrderId, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion, property, newValueExpr,  tokensExpr);
		
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeConsumerOrderPaymentGroup( consumerOrderPaymentGroup );	
			//make changes to AcceleraterAccount.
			ConsumerOrderPaymentGroup consumerOrderPaymentGroupIndex = createIndexedConsumerOrderPaymentGroup(consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
		
			ConsumerOrderPaymentGroup consumerOrderPaymentGroup = consumerOrder.findTheConsumerOrderPaymentGroup(consumerOrderPaymentGroupIndex);
			if(consumerOrderPaymentGroup == null){
				throw new ConsumerOrderManagerException(consumerOrderPaymentGroup+"Not found" );
			}
			
			consumerOrderPaymentGroup.changePropery(property, newValueExpr);

			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, String name, double amount, String provider,String [] tokensExpr) throws Exception{
		
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);

		checkNameOfConsumerOrderPriceAdjustment(userContext,  name, exception);
		checkAmountOfConsumerOrderPriceAdjustment(userContext,  amount, exception);
		checkProviderOfConsumerOrderPriceAdjustment(userContext,  provider, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  ConsumerOrder addConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, String name, double amount, String provider, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrderPriceAdjustment(userContext,consumerOrderId,name, amount, provider,tokensExpr);
		
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = createConsumerOrderPriceAdjustment(userContext,name, amount, provider);
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addConsumerOrderPriceAdjustment( consumerOrderPriceAdjustment );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String name, double amount, String provider) throws Exception{

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
		
		
		consumerOrderPriceAdjustment.setName(name);		
		consumerOrderPriceAdjustment.setAmount(amount);		
		consumerOrderPriceAdjustment.setProvider(provider);
	
		
		return consumerOrderPriceAdjustment;
	
		
	}
	
	protected ConsumerOrderPriceAdjustment createIndexedConsumerOrderPriceAdjustment(String id, int version){

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
		consumerOrderPriceAdjustment.setId(id);
		consumerOrderPriceAdjustment.setVersion(version);
		return consumerOrderPriceAdjustment;			
		
	}
	protected void checkParamsForRemovingConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, exception);
		checkVersionOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder removeConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrderPriceAdjustment(userContext,consumerOrderId, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion,tokensExpr);
		
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = createIndexedConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeConsumerOrderPriceAdjustment( consumerOrderPriceAdjustment );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, exception);
		checkVersionOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder copyConsumerOrderPriceAdjustmentFrom(RetailScmUserContext userContext, String consumerOrderId, 
		String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrderPriceAdjustment(userContext,consumerOrderId, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion,tokensExpr);
		
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = createIndexedConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.copyConsumerOrderPriceAdjustmentFrom( consumerOrderPriceAdjustment );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, exception);
		checkVersionOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentVersion, exception);
		

		if(ConsumerOrderPriceAdjustment.NAME_PROPERTY.equals(property)){
			checkNameOfConsumerOrderPriceAdjustment(userContext, parseString(newValueExpr), exception);
		}
		
		if(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfConsumerOrderPriceAdjustment(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY.equals(property)){
			checkProviderOfConsumerOrderPriceAdjustment(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  ConsumerOrder updateConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderId, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr,  tokensExpr);
		
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeConsumerOrderPriceAdjustment( consumerOrderPriceAdjustment );	
			//make changes to AcceleraterAccount.
			ConsumerOrderPriceAdjustment consumerOrderPriceAdjustmentIndex = createIndexedConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
		
			ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = consumerOrder.findTheConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentIndex);
			if(consumerOrderPriceAdjustment == null){
				throw new ConsumerOrderManagerException(consumerOrderPriceAdjustment+"Not found" );
			}
			
			consumerOrderPriceAdjustment.changePropery(property, newValueExpr);

			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, Date occureTime, String ownerId, String number, double amount,String [] tokensExpr) throws Exception{
		
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);

		checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(userContext,  occureTime, exception);		
		
		checkIdOfRetailStoreMemberGiftCard(userContext,  ownerId, exception);
		checkNumberOfRetailStoreMemberGiftCardConsumeRecord(userContext,  number, exception);
		checkAmountOfRetailStoreMemberGiftCardConsumeRecord(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  ConsumerOrder addRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, Date occureTime, String ownerId, String number, double amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(userContext,consumerOrderId,occureTime, ownerId, number, amount,tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createRetailStoreMemberGiftCardConsumeRecord(userContext,occureTime, ownerId, number, amount);
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, Date occureTime, String ownerId, String number, double amount) throws Exception{

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		
		
		retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);		
		RetailStoreMemberGiftCard  owner = new RetailStoreMemberGiftCard();
		owner.setId(ownerId);		
		retailStoreMemberGiftCardConsumeRecord.setOwner(owner);		
		retailStoreMemberGiftCardConsumeRecord.setNumber(number);		
		retailStoreMemberGiftCardConsumeRecord.setAmount(amount);
	
		
		return retailStoreMemberGiftCardConsumeRecord;
	
		
	}
	
	protected RetailStoreMemberGiftCardConsumeRecord createIndexedRetailStoreMemberGiftCardConsumeRecord(String id, int version){

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		retailStoreMemberGiftCardConsumeRecord.setId(id);
		retailStoreMemberGiftCardConsumeRecord.setVersion(version);
		return retailStoreMemberGiftCardConsumeRecord;			
		
	}
	protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, exception);
		checkVersionOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(userContext,consumerOrderId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion,tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, exception);
		checkVersionOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ConsumerOrder copyRetailStoreMemberGiftCardConsumeRecordFrom(RetailScmUserContext userContext, String consumerOrderId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(userContext,consumerOrderId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion,tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.copyRetailStoreMemberGiftCardConsumeRecordFrom( retailStoreMemberGiftCardConsumeRecord );		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ConsumerOrderManagerException exception = new ConsumerOrderManagerException("Error Occured");
		
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, exception);
		checkVersionOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordVersion, exception);
		

		if(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY.equals(property)){
			checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(userContext, parseDate(newValueExpr), exception);
		}
		
		if(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY.equals(property)){
			checkNumberOfRetailStoreMemberGiftCardConsumeRecord(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfRetailStoreMemberGiftCardConsumeRecord(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  ConsumerOrder updateRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, consumerOrderId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr,  tokensExpr);
		
		
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		
		synchronized(consumerOrder){ 
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );	
			//make changes to AcceleraterAccount.
			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordIndex = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		
			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = consumerOrder.findTheRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordIndex);
			if(retailStoreMemberGiftCardConsumeRecord == null){
				throw new ConsumerOrderManagerException(retailStoreMemberGiftCardConsumeRecord+"Not found" );
			}
			
			retailStoreMemberGiftCardConsumeRecord.changePropery(property, newValueExpr);

			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


