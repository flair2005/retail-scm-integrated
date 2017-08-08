
package com.skynet.retailscm.supplyorder;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.skynet.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;

import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmationDAO;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessingDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.goodssupplier.GoodsSupplierDAO;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDeliveryDAO;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPickingDAO;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApprovalDAO;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipmentDAO;

import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.supplyorderlineitem.SupplyOrderLineItemTable;
import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApprovalTable;
import com.skynet.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupTable;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDeliveryTable;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessingTable;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPickingTable;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipmentTable;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmationTable;
import com.skynet.retailscm.goodssupplier.GoodsSupplierTable;
import com.skynet.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupTable;




public class SupplyOrderManagerImpl extends RetailScmCheckerManager implements SupplyOrderManager {
	
	private static final String SERVICE_TYPE = "SupplyOrder";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO  supplyOrderDAO){
 	
 		if(supplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The SupplyOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDAO;
 	}
 	
 	protected SupplyOrder saveSupplyOrder(RetailScmUserContext userContext, SupplyOrder supplyOrder, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderDAO().save(supplyOrder, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrder(userContext, supplyOrder, tokens);
 	}
 	
 	protected SupplyOrder saveSupplyOrderDetail(RetailScmUserContext userContext, SupplyOrder supplyOrder) throws Exception{	

 		
 		return saveSupplyOrder(userContext, supplyOrder, allTokens());
 	}
 	
 	public SupplyOrder loadSupplyOrder(RetailScmUserContext userContext, String supplyOrderId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrder, tokens);
 	}
 	
 	protected SupplyOrder present(RetailScmUserContext userContext, SupplyOrder supplyOrder, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrder,tokens);
		
		
		return this.getSupplyOrderDAO().present(supplyOrder, tokens);
	}
 
 	
 	
 	public SupplyOrder loadSupplyOrderDetail(RetailScmUserContext userContext, String supplyOrderId) throws Exception{	
 		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, allTokens());

 		return present(userContext,supplyOrder, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderId) throws Exception{	
 		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, allTokens());

 		return present(userContext,supplyOrder, allTokens());
		
 	}
 	protected SupplyOrder saveSupplyOrder(RetailScmUserContext userContext, SupplyOrder supplyOrder, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderDAO().save(supplyOrder, tokens);
 	}
 	protected SupplyOrder loadSupplyOrder(RetailScmUserContext userContext, String supplyOrderId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderDAO().load(supplyOrderId, tokens);
 	}

	



 	 
 	
 	private  SupplyOrderApprovalDAO  supplyOrderApprovalDAO;
 	public void setSupplyOrderApprovalDAO(SupplyOrderApprovalDAO supplyOrderApprovalDAO){
	 	this.supplyOrderApprovalDAO = supplyOrderApprovalDAO;
 	}
 	//------------------------------------
 	public SupplyOrderApprovalDAO getSupplyOrderApprovalDAO(){
	 	return this.supplyOrderApprovalDAO;
 	}
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  SupplyOrderDeliveryDAO  supplyOrderDeliveryDAO;
 	public void setSupplyOrderDeliveryDAO(SupplyOrderDeliveryDAO supplyOrderDeliveryDAO){
	 	this.supplyOrderDeliveryDAO = supplyOrderDeliveryDAO;
 	}
 	//------------------------------------
 	public SupplyOrderDeliveryDAO getSupplyOrderDeliveryDAO(){
	 	return this.supplyOrderDeliveryDAO;
 	}
 
 	
 	private  GoodsSupplierDAO  goodsSupplierDAO;
 	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	//------------------------------------
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
	 	return this.goodsSupplierDAO;
 	}
 
 	
 	private  SupplyOrderPickingDAO  supplyOrderPickingDAO;
 	public void setSupplyOrderPickingDAO(SupplyOrderPickingDAO supplyOrderPickingDAO){
	 	this.supplyOrderPickingDAO = supplyOrderPickingDAO;
 	}
 	//------------------------------------
 	public SupplyOrderPickingDAO getSupplyOrderPickingDAO(){
	 	return this.supplyOrderPickingDAO;
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
 
 	
 	private  SupplyOrderProcessingDAO  supplyOrderProcessingDAO;
 	public void setSupplyOrderProcessingDAO(SupplyOrderProcessingDAO supplyOrderProcessingDAO){
	 	this.supplyOrderProcessingDAO = supplyOrderProcessingDAO;
 	}
 	//------------------------------------
 	public SupplyOrderProcessingDAO getSupplyOrderProcessingDAO(){
	 	return this.supplyOrderProcessingDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrder supplyOrder, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrder, tokens);
		
		addAction(userContext, supplyOrder, tokens,"@create","createSupplyOrder","createSupplyOrder/","main","primary");
		addAction(userContext, supplyOrder, tokens,"@update","updateSupplyOrder","updateSupplyOrder/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"@copy","cloneSupplyOrder","cloneSupplyOrder/"+supplyOrder.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_buyer","transferToAnotherBuyer","transferToAnotherBuyer/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_seller","transferToAnotherSeller","transferToAnotherSeller/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.confirm","confirm","confirm/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.approve","approve","approve/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.process","process","process/"+supplyOrder.getId()+"/","main","info");
		addAction(userContext, supplyOrder, tokens,"supply_order.pick","pick","pick/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.ship","ship","ship/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.deliver","deliver","deliver/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.addSupplyOrderLineItem","addSupplyOrderLineItem","addSupplyOrderLineItem/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeSupplyOrderLineItem","removeSupplyOrderLineItem","removeSupplyOrderLineItem/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateSupplyOrderLineItem","updateSupplyOrderLineItem","updateSupplyOrderLineItem/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copySupplyOrderLineItemFrom","copySupplyOrderLineItemFrom","copySupplyOrderLineItemFrom/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addSupplyOrderShippingGroup","addSupplyOrderShippingGroup","addSupplyOrderShippingGroup/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeSupplyOrderShippingGroup","removeSupplyOrderShippingGroup","removeSupplyOrderShippingGroup/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateSupplyOrderShippingGroup","updateSupplyOrderShippingGroup","updateSupplyOrderShippingGroup/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copySupplyOrderShippingGroupFrom","copySupplyOrderShippingGroupFrom","copySupplyOrderShippingGroupFrom/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addSupplyOrderPaymentGroup","addSupplyOrderPaymentGroup","addSupplyOrderPaymentGroup/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeSupplyOrderPaymentGroup","removeSupplyOrderPaymentGroup","removeSupplyOrderPaymentGroup/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateSupplyOrderPaymentGroup","updateSupplyOrderPaymentGroup","updateSupplyOrderPaymentGroup/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copySupplyOrderPaymentGroupFrom","copySupplyOrderPaymentGroupFrom","copySupplyOrderPaymentGroupFrom/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addGoods","addGoods","addGoods/"+supplyOrder.getId()+"/","goodsList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeGoods","removeGoods","removeGoods/"+supplyOrder.getId()+"/","goodsList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateGoods","updateGoods","updateGoods/"+supplyOrder.getId()+"/","goodsList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+supplyOrder.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrder supplyOrder, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrder createSupplyOrder(RetailScmUserContext userContext,String buyerId, String sellerId, String title, double totalAmount
) throws Exception
	{
		
		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");

		

		checkTitleOfSupplyOrder(userContext,  title, exception);
		checkTotalAmountOfSupplyOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrder supplyOrder=createNewSupplyOrder();	

		RetailStoreCountryCenter buyer = loadRetailStoreCountryCenter(buyerId,emptyOptions());
		supplyOrder.setBuyer(buyer);
		GoodsSupplier seller = loadGoodsSupplier(sellerId,emptyOptions());
		supplyOrder.setSeller(seller);
		supplyOrder.setTitle(title);
		supplyOrder.setTotalAmount(totalAmount);

		return saveSupplyOrder(userContext, supplyOrder, emptyOptions());
		

		
	}
	protected SupplyOrder createNewSupplyOrder() 
	{
		
		return new SupplyOrder();		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailScmUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);
		
		

				

		
		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfSupplyOrder(userContext, parseString(newValueExpr), exception);
		}
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkTotalAmountOfSupplyOrder(userContext, parseDouble(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SupplyOrder clone(RetailScmUserContext userContext, String fromSupplyOrderId) throws Exception{
		
		return this.getSupplyOrderDAO().clone(fromSupplyOrderId, this.allTokens());
	}
	
	public SupplyOrder updateSupplyOrder(RetailScmUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderId, supplyOrderVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		if(supplyOrder.getVersion() != supplyOrderVersion){
			String message = "The target version("+supplyOrder.getVersion()+") is not equals to version("+supplyOrderVersion+") provided";
			throw new SupplyOrderManagerException(message);
		}
		synchronized(supplyOrder){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrder.
			
			supplyOrder.changePropery(property, newValueExpr);
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			//return saveSupplyOrder(userContext, supplyOrder, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderTokens tokens(){
		return SupplyOrderTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBuyer(RetailScmUserContext userContext, String supplyOrderId, String anotherBuyerId) throws Exception
 	{
 		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
 		checkIdOfSupplyOrder(userContext, supplyOrderId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherBuyerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SupplyOrder transferToAnotherBuyer(RetailScmUserContext userContext, String supplyOrderId, String anotherBuyerId) throws Exception
 	{
 		checkParamsForTransferingAnotherBuyer(userContext, supplyOrderId,anotherBuyerId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter buyer = loadRetailStoreCountryCenter(anotherBuyerId, emptyOptions());		
			supplyOrder.setBuyer(buyer);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherSeller(RetailScmUserContext userContext, String supplyOrderId, String anotherSellerId) throws Exception
 	{
 		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
 		checkIdOfSupplyOrder(userContext, supplyOrderId,exception);
 		checkIdOfGoodsSupplier(userContext, anotherSellerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SupplyOrder transferToAnotherSeller(RetailScmUserContext userContext, String supplyOrderId, String anotherSellerId) throws Exception
 	{
 		checkParamsForTransferingAnotherSeller(userContext, supplyOrderId,anotherSellerId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsSupplier seller = loadGoodsSupplier(anotherSellerId, emptyOptions());		
			supplyOrder.setSeller(seller);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForConfirmation(RetailScmUserContext userContext, String supplyOrderId, String who, Date confirmTime
) throws Exception
 	{
 		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkWhoOfSupplyOrderConfirmation(userContext,who,exception);
		checkConfirmTimeOfSupplyOrderConfirmation(userContext,confirmTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public SupplyOrder confirm(RetailScmUserContext userContext, String supplyOrderId, String who, Date confirmTime
) throws Exception
 	{
		checkParamsForConfirmation(userContext, supplyOrderId, who, confirmTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderConfirmation(userContext,supplyOrder);
 		

			supplyOrder.setCurrentStatus("CONFIRMED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderConfirmation confirmation = createSupplyOrderConfirmation(who, confirmTime);		
			supplyOrder.setConfirmation(confirmation);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withConfirmation().done());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderConfirmation createSupplyOrderConfirmation(String who, Date confirmTime){
 		SupplyOrderConfirmation confirmation = new SupplyOrderConfirmation(who, confirmTime);
 		return getSupplyOrderConfirmationDAO().save(confirmation,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderConfirmation(RetailScmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 		
 		
 		String currentStatus = supplyOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		if(!("CONFIRMED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderConfirmation confirmation = supplyOrder.getConfirmation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = confirmation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( confirmation != null){
				throw new SupplyOrderManagerException("The SupplyOrder("+supplyOrder.getId()+") has already been CONFIRMED");
		}
 		
 		
 	}
	
 	protected void checkParamsForApproval(RetailScmUserContext userContext, String supplyOrderId, String who, Date approveTime
) throws Exception
 	{
 		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkWhoOfSupplyOrderApproval(userContext,who,exception);
		checkApproveTimeOfSupplyOrderApproval(userContext,approveTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public SupplyOrder approve(RetailScmUserContext userContext, String supplyOrderId, String who, Date approveTime
) throws Exception
 	{
		checkParamsForApproval(userContext, supplyOrderId, who, approveTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderApproval(userContext,supplyOrder);
 		

			supplyOrder.setCurrentStatus("APPROVED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderApproval approval = createSupplyOrderApproval(who, approveTime);		
			supplyOrder.setApproval(approval);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withApproval().done());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderApproval createSupplyOrderApproval(String who, Date approveTime){
 		SupplyOrderApproval approval = new SupplyOrderApproval(who, approveTime);
 		return getSupplyOrderApprovalDAO().save(approval,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderApproval(RetailScmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 		
 		
 		String currentStatus = supplyOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'APPROVED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		if(!("APPROVED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'APPROVED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderApproval approval = supplyOrder.getApproval();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = approval 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( approval != null){
				throw new SupplyOrderManagerException("The SupplyOrder("+supplyOrder.getId()+") has already been APPROVED");
		}
 		
 		
 	}
	
 	protected void checkParamsForProcessing(RetailScmUserContext userContext, String supplyOrderId, String who, Date processTime
) throws Exception
 	{
 		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkWhoOfSupplyOrderProcessing(userContext,who,exception);
		checkProcessTimeOfSupplyOrderProcessing(userContext,processTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public SupplyOrder process(RetailScmUserContext userContext, String supplyOrderId, String who, Date processTime
) throws Exception
 	{
		checkParamsForProcessing(userContext, supplyOrderId, who, processTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderProcessing(userContext,supplyOrder);
 		

			supplyOrder.setCurrentStatus("PROCESSED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderProcessing processing = createSupplyOrderProcessing(who, processTime);		
			supplyOrder.setProcessing(processing);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withProcessing().done());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderProcessing createSupplyOrderProcessing(String who, Date processTime){
 		SupplyOrderProcessing processing = new SupplyOrderProcessing(who, processTime);
 		return getSupplyOrderProcessingDAO().save(processing,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderProcessing(RetailScmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 		
 		
 		String currentStatus = supplyOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'PROCESSED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		if(!("PROCESSED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'PROCESSED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderProcessing processing = supplyOrder.getProcessing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = processing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( processing != null){
				throw new SupplyOrderManagerException("The SupplyOrder("+supplyOrder.getId()+") has already been PROCESSED");
		}
 		
 		
 	}
	
 	protected void checkParamsForPicking(RetailScmUserContext userContext, String supplyOrderId, String who, Date processTime
) throws Exception
 	{
 		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkWhoOfSupplyOrderPicking(userContext,who,exception);
		checkProcessTimeOfSupplyOrderPicking(userContext,processTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public SupplyOrder pick(RetailScmUserContext userContext, String supplyOrderId, String who, Date processTime
) throws Exception
 	{
		checkParamsForPicking(userContext, supplyOrderId, who, processTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderPicking(userContext,supplyOrder);
 		

			supplyOrder.setCurrentStatus("PICKED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderPicking picking = createSupplyOrderPicking(who, processTime);		
			supplyOrder.setPicking(picking);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withPicking().done());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderPicking createSupplyOrderPicking(String who, Date processTime){
 		SupplyOrderPicking picking = new SupplyOrderPicking(who, processTime);
 		return getSupplyOrderPickingDAO().save(picking,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderPicking(RetailScmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 		
 		
 		String currentStatus = supplyOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'PICKED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		if(!("PICKED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'PICKED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderPicking picking = supplyOrder.getPicking();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = picking 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( picking != null){
				throw new SupplyOrderManagerException("The SupplyOrder("+supplyOrder.getId()+") has already been PICKED");
		}
 		
 		
 	}
	
 	protected void checkParamsForShipment(RetailScmUserContext userContext, String supplyOrderId, String who, Date shipTime
) throws Exception
 	{
 		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkWhoOfSupplyOrderShipment(userContext,who,exception);
		checkShipTimeOfSupplyOrderShipment(userContext,shipTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public SupplyOrder ship(RetailScmUserContext userContext, String supplyOrderId, String who, Date shipTime
) throws Exception
 	{
		checkParamsForShipment(userContext, supplyOrderId, who, shipTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderShipment(userContext,supplyOrder);
 		

			supplyOrder.setCurrentStatus("SHIPPED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderShipment shipment = createSupplyOrderShipment(who, shipTime);		
			supplyOrder.setShipment(shipment);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withShipment().done());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderShipment createSupplyOrderShipment(String who, Date shipTime){
 		SupplyOrderShipment shipment = new SupplyOrderShipment(who, shipTime);
 		return getSupplyOrderShipmentDAO().save(shipment,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderShipment(RetailScmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 		
 		
 		String currentStatus = supplyOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'SHIPPED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		if(!("SHIPPED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'SHIPPED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderShipment shipment = supplyOrder.getShipment();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = shipment 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( shipment != null){
				throw new SupplyOrderManagerException("The SupplyOrder("+supplyOrder.getId()+") has already been SHIPPED");
		}
 		
 		
 	}
	
 	protected void checkParamsForDelivery(RetailScmUserContext userContext, String supplyOrderId, String who, Date deliveryTime
) throws Exception
 	{
 		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkWhoOfSupplyOrderDelivery(userContext,who,exception);
		checkDeliveryTimeOfSupplyOrderDelivery(userContext,deliveryTime,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public SupplyOrder deliver(RetailScmUserContext userContext, String supplyOrderId, String who, Date deliveryTime
) throws Exception
 	{
		checkParamsForDelivery(userContext, supplyOrderId, who, deliveryTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForSupplyOrderDelivery(userContext,supplyOrder);
 		

			supplyOrder.setCurrentStatus("DELIVERED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderDelivery delivery = createSupplyOrderDelivery(who, deliveryTime);		
			supplyOrder.setDelivery(delivery);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withDelivery().done());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	protected SupplyOrderDelivery createSupplyOrderDelivery(String who, Date deliveryTime){
 		SupplyOrderDelivery delivery = new SupplyOrderDelivery(who, deliveryTime);
 		return getSupplyOrderDeliveryDAO().save(delivery,emptyOptions());
 	}
 	protected void checkIfEligibleForSupplyOrderDelivery(RetailScmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 		
 		
 		String currentStatus = supplyOrder.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'DELIVERED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		if(!("DELIVERED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'DELIVERED'";
 			throw new SupplyOrderManagerException(message);
 		}
 		
 		
 		SupplyOrderDelivery delivery = supplyOrder.getDelivery();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = delivery 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( delivery != null){
				throw new SupplyOrderManagerException("The SupplyOrder("+supplyOrder.getId()+") has already been DELIVERED");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected SupplyOrderApproval loadSupplyOrderApproval(String newApprovalId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderApprovalDAO().load(newApprovalId, options);
 	}
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newBuyerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newBuyerId, options);
 	}
	
	 	
 	protected SupplyOrderDelivery loadSupplyOrderDelivery(String newDeliveryId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderDeliveryDAO().load(newDeliveryId, options);
 	}
	
	 	
 	protected GoodsSupplier loadGoodsSupplier(String newSellerId, Map<String,Object> options) throws Exception
 	{
		
 		return getGoodsSupplierDAO().load(newSellerId, options);
 	}
	
	 	
 	protected SupplyOrderPicking loadSupplyOrderPicking(String newPickingId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderPickingDAO().load(newPickingId, options);
 	}
	
	 	
 	protected SupplyOrderShipment loadSupplyOrderShipment(String newShipmentId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderShipmentDAO().load(newShipmentId, options);
 	}
	
	 	
 	protected SupplyOrderConfirmation loadSupplyOrderConfirmation(String newConfirmationId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderConfirmationDAO().load(newConfirmationId, options);
 	}
	
	 	
 	protected SupplyOrderProcessing loadSupplyOrderProcessing(String newProcessingId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderProcessingDAO().load(newProcessingId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String supplyOrderId, int supplyOrderVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderId, supplyOrderVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderId, int supplyOrderVersion) throws Exception{
		getSupplyOrderDAO().delete(supplyOrderId, supplyOrderVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderDAO().deleteAll();
	}

	protected void checkParamsForAddingSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);

		checkSkuIdOfSupplyOrderLineItem(userContext,  skuId, exception);
		checkSkuNameOfSupplyOrderLineItem(userContext,  skuName, exception);
		checkAmountOfSupplyOrderLineItem(userContext,  amount, exception);
		checkQuantityOfSupplyOrderLineItem(userContext,  quantity, exception);
		checkUnitOfMeasurementOfSupplyOrderLineItem(userContext,  unitOfMeasurement, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrder addSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrderLineItem(userContext,supplyOrderId,skuId, skuName, amount, quantity, unitOfMeasurement,tokensExpr);
		
		SupplyOrderLineItem supplyOrderLineItem = createSupplyOrderLineItem(userContext,skuId, skuName, amount, quantity, unitOfMeasurement);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addSupplyOrderLineItem( supplyOrderLineItem );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected SupplyOrderLineItem createSupplyOrderLineItem(RetailScmUserContext userContext, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement) throws Exception{

		SupplyOrderLineItem supplyOrderLineItem = new SupplyOrderLineItem();
		
		
		supplyOrderLineItem.setSkuId(skuId);		
		supplyOrderLineItem.setSkuName(skuName);		
		supplyOrderLineItem.setAmount(amount);		
		supplyOrderLineItem.setQuantity(quantity);		
		supplyOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);
	
		
		return supplyOrderLineItem;
	
		
	}
	
	protected SupplyOrderLineItem createIndexedSupplyOrderLineItem(String id, int version){

		SupplyOrderLineItem supplyOrderLineItem = new SupplyOrderLineItem();
		supplyOrderLineItem.setId(id);
		supplyOrderLineItem.setVersion(version);
		return supplyOrderLineItem;			
		
	}
	protected void checkParamsForRemovingSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfSupplyOrderLineItem(userContext, supplyOrderLineItemId, exception);
		checkVersionOfSupplyOrderLineItem(userContext, supplyOrderLineItemVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrder removeSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrderLineItem(userContext,supplyOrderId, supplyOrderLineItemId, supplyOrderLineItemVersion,tokensExpr);
		
		SupplyOrderLineItem supplyOrderLineItem = createIndexedSupplyOrderLineItem(supplyOrderLineItemId, supplyOrderLineItemVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeSupplyOrderLineItem( supplyOrderLineItem );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfSupplyOrderLineItem(userContext, supplyOrderLineItemId, exception);
		checkVersionOfSupplyOrderLineItem(userContext, supplyOrderLineItemVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrder copySupplyOrderLineItemFrom(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrderLineItem(userContext,supplyOrderId, supplyOrderLineItemId, supplyOrderLineItemVersion,tokensExpr);
		
		SupplyOrderLineItem supplyOrderLineItem = createIndexedSupplyOrderLineItem(supplyOrderLineItemId, supplyOrderLineItemVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.copySupplyOrderLineItemFrom( supplyOrderLineItem );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfSupplyOrderLineItem(userContext, supplyOrderLineItemId, exception);
		checkVersionOfSupplyOrderLineItem(userContext, supplyOrderLineItemVersion, exception);
		

		if(SupplyOrderLineItem.SKU_ID_PROPERTY.equals(property)){
			checkSkuIdOfSupplyOrderLineItem(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplyOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
			checkSkuNameOfSupplyOrderLineItem(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplyOrderLineItem.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfSupplyOrderLineItem(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(SupplyOrderLineItem.QUANTITY_PROPERTY.equals(property)){
			checkQuantityOfSupplyOrderLineItem(userContext, parseInt(newValueExpr), exception);
		}
		
		if(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
			checkUnitOfMeasurementOfSupplyOrderLineItem(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplyOrder updateSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderId, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeSupplyOrderLineItem( supplyOrderLineItem );	
			//make changes to AcceleraterAccount.
			SupplyOrderLineItem supplyOrderLineItemIndex = createIndexedSupplyOrderLineItem(supplyOrderLineItemId, supplyOrderLineItemVersion);
		
			SupplyOrderLineItem supplyOrderLineItem = supplyOrder.findTheSupplyOrderLineItem(supplyOrderLineItemIndex);
			if(supplyOrderLineItem == null){
				throw new SupplyOrderManagerException(supplyOrderLineItem+"Not found" );
			}
			
			supplyOrderLineItem.changePropery(property, newValueExpr);

			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, String name, double amount,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);

		checkNameOfSupplyOrderShippingGroup(userContext,  name, exception);
		checkAmountOfSupplyOrderShippingGroup(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrder addSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, String name, double amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrderShippingGroup(userContext,supplyOrderId,name, amount,tokensExpr);
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = createSupplyOrderShippingGroup(userContext,name, amount);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addSupplyOrderShippingGroup( supplyOrderShippingGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected SupplyOrderShippingGroup createSupplyOrderShippingGroup(RetailScmUserContext userContext, String name, double amount) throws Exception{

		SupplyOrderShippingGroup supplyOrderShippingGroup = new SupplyOrderShippingGroup();
		
		
		supplyOrderShippingGroup.setName(name);		
		supplyOrderShippingGroup.setAmount(amount);
	
		
		return supplyOrderShippingGroup;
	
		
	}
	
	protected SupplyOrderShippingGroup createIndexedSupplyOrderShippingGroup(String id, int version){

		SupplyOrderShippingGroup supplyOrderShippingGroup = new SupplyOrderShippingGroup();
		supplyOrderShippingGroup.setId(id);
		supplyOrderShippingGroup.setVersion(version);
		return supplyOrderShippingGroup;			
		
	}
	protected void checkParamsForRemovingSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, exception);
		checkVersionOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrder removeSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrderShippingGroup(userContext,supplyOrderId, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion,tokensExpr);
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = createIndexedSupplyOrderShippingGroup(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeSupplyOrderShippingGroup( supplyOrderShippingGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, exception);
		checkVersionOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrder copySupplyOrderShippingGroupFrom(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrderShippingGroup(userContext,supplyOrderId, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion,tokensExpr);
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = createIndexedSupplyOrderShippingGroup(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.copySupplyOrderShippingGroupFrom( supplyOrderShippingGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, exception);
		checkVersionOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupVersion, exception);
		

		if(SupplyOrderShippingGroup.NAME_PROPERTY.equals(property)){
			checkNameOfSupplyOrderShippingGroup(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplyOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfSupplyOrderShippingGroup(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplyOrder updateSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrderShippingGroup(userContext, supplyOrderId, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeSupplyOrderShippingGroup( supplyOrderShippingGroup );	
			//make changes to AcceleraterAccount.
			SupplyOrderShippingGroup supplyOrderShippingGroupIndex = createIndexedSupplyOrderShippingGroup(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
		
			SupplyOrderShippingGroup supplyOrderShippingGroup = supplyOrder.findTheSupplyOrderShippingGroup(supplyOrderShippingGroupIndex);
			if(supplyOrderShippingGroup == null){
				throw new SupplyOrderManagerException(supplyOrderShippingGroup+"Not found" );
			}
			
			supplyOrderShippingGroup.changePropery(property, newValueExpr);

			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, String name, String cardNumber,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);

		checkNameOfSupplyOrderPaymentGroup(userContext,  name, exception);
		checkCardNumberOfSupplyOrderPaymentGroup(userContext,  cardNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrder addSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, String name, String cardNumber, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrderPaymentGroup(userContext,supplyOrderId,name, cardNumber,tokensExpr);
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = createSupplyOrderPaymentGroup(userContext,name, cardNumber);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addSupplyOrderPaymentGroup( supplyOrderPaymentGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(RetailScmUserContext userContext, String name, String cardNumber) throws Exception{

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = new SupplyOrderPaymentGroup();
		
		
		supplyOrderPaymentGroup.setName(name);		
		supplyOrderPaymentGroup.setCardNumber(cardNumber);
	
		
		return supplyOrderPaymentGroup;
	
		
	}
	
	protected SupplyOrderPaymentGroup createIndexedSupplyOrderPaymentGroup(String id, int version){

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = new SupplyOrderPaymentGroup();
		supplyOrderPaymentGroup.setId(id);
		supplyOrderPaymentGroup.setVersion(version);
		return supplyOrderPaymentGroup;			
		
	}
	protected void checkParamsForRemovingSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, exception);
		checkVersionOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrder removeSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrderPaymentGroup(userContext,supplyOrderId, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion,tokensExpr);
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = createIndexedSupplyOrderPaymentGroup(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeSupplyOrderPaymentGroup( supplyOrderPaymentGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, exception);
		checkVersionOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrder copySupplyOrderPaymentGroupFrom(RetailScmUserContext userContext, String supplyOrderId, 
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrderPaymentGroup(userContext,supplyOrderId, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion,tokensExpr);
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = createIndexedSupplyOrderPaymentGroup(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.copySupplyOrderPaymentGroupFrom( supplyOrderPaymentGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, exception);
		checkVersionOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupVersion, exception);
		

		if(SupplyOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			checkNameOfSupplyOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			checkCardNumberOfSupplyOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplyOrder updateSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderId, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeSupplyOrderPaymentGroup( supplyOrderPaymentGroup );	
			//make changes to AcceleraterAccount.
			SupplyOrderPaymentGroup supplyOrderPaymentGroupIndex = createIndexedSupplyOrderPaymentGroup(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
		
			SupplyOrderPaymentGroup supplyOrderPaymentGroup = supplyOrder.findTheSupplyOrderPaymentGroup(supplyOrderPaymentGroupIndex);
			if(supplyOrderPaymentGroup == null){
				throw new SupplyOrderManagerException(supplyOrderPaymentGroup+"Not found" );
			}
			
			supplyOrderPaymentGroup.changePropery(property, newValueExpr);

			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);

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
		
		checkIdOfRetailStoreOrder(userContext,  retailStoreOrderId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrder addGoods(RetailScmUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,supplyOrderId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, retailStoreOrderId);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addGoods( goods );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId) throws Exception{

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
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);
	
		
		return goods;
	
		
	}
	
	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;			
		
	}
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String supplyOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrder removeGoods(RetailScmUserContext userContext, String supplyOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,supplyOrderId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeGoods( goods );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String supplyOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrder copyGoodsFrom(RetailScmUserContext userContext, String supplyOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,supplyOrderId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.copyGoodsFrom( goods );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderManagerException exception = new SupplyOrderManagerException("Error Occured");
		
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
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
	
	public  SupplyOrder updateGoods(RetailScmUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, supplyOrderId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = supplyOrder.findTheGoods(goodsIndex);
			if(goods == null){
				throw new SupplyOrderManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


