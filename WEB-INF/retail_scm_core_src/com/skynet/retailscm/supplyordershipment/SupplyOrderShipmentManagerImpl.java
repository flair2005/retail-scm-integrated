
package com.skynet.retailscm.supplyordershipment;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.consumerorder.ConsumerOrder;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;


import com.skynet.retailscm.consumerorder.ConsumerOrderTable;
import com.skynet.retailscm.supplyorder.SupplyOrderTable;




public class SupplyOrderShipmentManagerImpl extends RetailScmCheckerManager implements SupplyOrderShipmentManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderShipment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderShipmentDAO  supplyOrderShipmentDAO;
 	public void setSupplyOrderShipmentDAO(SupplyOrderShipmentDAO  supplyOrderShipmentDAO){
 	
 		if(supplyOrderShipmentDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderShipmentDAO to null.");
 		}
	 	this.supplyOrderShipmentDAO = supplyOrderShipmentDAO;
 	}
 	public SupplyOrderShipmentDAO getSupplyOrderShipmentDAO(){
 		if(this.supplyOrderShipmentDAO == null){
 			throw new IllegalStateException("The SupplyOrderShipmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderShipmentDAO;
 	}
 	
 	protected SupplyOrderShipment saveSupplyOrderShipment(RetailScmUserContext userContext, SupplyOrderShipment supplyOrderShipment, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderShipmentDAO().save(supplyOrderShipment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens);
 	}
 	
 	protected SupplyOrderShipment saveSupplyOrderShipmentDetail(RetailScmUserContext userContext, SupplyOrderShipment supplyOrderShipment) throws Exception{	

 		
 		return saveSupplyOrderShipment(userContext, supplyOrderShipment, allTokens());
 	}
 	
 	public SupplyOrderShipment loadSupplyOrderShipment(RetailScmUserContext userContext, String supplyOrderShipmentId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderShipment, tokens);
 	}
 	
 	protected SupplyOrderShipment present(RetailScmUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderShipment,tokens);
		
		
		return this.getSupplyOrderShipmentDAO().present(supplyOrderShipment, tokens);
	}
 
 	
 	
 	public SupplyOrderShipment loadSupplyOrderShipmentDetail(RetailScmUserContext userContext, String supplyOrderShipmentId) throws Exception{	
 		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, allTokens());

 		return present(userContext,supplyOrderShipment, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderShipmentId) throws Exception{	
 		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, allTokens());

 		return present(userContext,supplyOrderShipment, allTokens());
		
 	}
 	protected SupplyOrderShipment saveSupplyOrderShipment(RetailScmUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderShipmentDAO().save(supplyOrderShipment, tokens);
 	}
 	protected SupplyOrderShipment loadSupplyOrderShipment(RetailScmUserContext userContext, String supplyOrderShipmentId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderShipmentDAO().load(supplyOrderShipmentId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderShipment, tokens);
		
		addAction(userContext, supplyOrderShipment, tokens,"@create","createSupplyOrderShipment","createSupplyOrderShipment/","main","primary");
		addAction(userContext, supplyOrderShipment, tokens,"@update","updateSupplyOrderShipment","updateSupplyOrderShipment/"+supplyOrderShipment.getId()+"/","main","primary");
		addAction(userContext, supplyOrderShipment, tokens,"@copy","cloneSupplyOrderShipment","cloneSupplyOrderShipment/"+supplyOrderShipment.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderShipment createSupplyOrderShipment(RetailScmUserContext userContext,String who, Date shipTime
) throws Exception
	{
		
		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");

		

		checkWhoOfSupplyOrderShipment(userContext,  who, exception);
		checkShipTimeOfSupplyOrderShipment(userContext,  shipTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrderShipment supplyOrderShipment=createNewSupplyOrderShipment();	

		supplyOrderShipment.setWho(who);
		supplyOrderShipment.setShipTime(shipTime);

		return saveSupplyOrderShipment(userContext, supplyOrderShipment, emptyOptions());
		

		
	}
	protected SupplyOrderShipment createNewSupplyOrderShipment() 
	{
		
		return new SupplyOrderShipment();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderShipment(RetailScmUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		checkVersionOfSupplyOrderShipment(userContext, supplyOrderShipmentVersion, exception);
		

		if(SupplyOrderShipment.WHO_PROPERTY.equals(property)){
			checkWhoOfSupplyOrderShipment(userContext, parseString(newValueExpr), exception);
		}
		if(SupplyOrderShipment.SHIP_TIME_PROPERTY.equals(property)){
			checkShipTimeOfSupplyOrderShipment(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SupplyOrderShipment clone(RetailScmUserContext userContext, String fromSupplyOrderShipmentId) throws Exception{
		
		return this.getSupplyOrderShipmentDAO().clone(fromSupplyOrderShipmentId, this.allTokens());
	}
	
	public SupplyOrderShipment updateSupplyOrderShipment(RetailScmUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderShipment(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		if(supplyOrderShipment.getVersion() != supplyOrderShipmentVersion){
			String message = "The target version("+supplyOrderShipment.getVersion()+") is not equals to version("+supplyOrderShipmentVersion+") provided";
			throw new SupplyOrderShipmentManagerException(message);
		}
		synchronized(supplyOrderShipment){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShipment.
			
			supplyOrderShipment.changePropery(property, newValueExpr);
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderShipmentTokens tokens(){
		return SupplyOrderShipmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderShipmentTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderShipmentTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception{
		getSupplyOrderShipmentDAO().delete(supplyOrderShipmentId, supplyOrderShipmentVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderShipmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderShipmentDAO().deleteAll();
	}

	protected void checkParamsForAddingConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);

		checkTitleOfConsumerOrder(userContext,  title, exception);		
		
		checkIdOfRetailStoreMember(userContext,  consumerId, exception);		
		
		checkIdOfRetailStore(userContext,  storeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderShipment addConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderShipmentId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.addConsumerOrder( consumerOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
	}
	protected ConsumerOrder createConsumerOrder(RetailScmUserContext userContext, String title, String consumerId, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
		RetailStore  store = new RetailStore();
		store.setId(storeId);		
		consumerOrder.setStore(store);
	
		
		return consumerOrder;
	
		
	}
	
	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;			
		
	}
	protected void checkParamsForRemovingConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderShipment removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderShipmentId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.removeConsumerOrder( consumerOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderShipment copyConsumerOrderFrom(RetailScmUserContext userContext, String supplyOrderShipmentId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderShipmentId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfConsumerOrder(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplyOrderShipment updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderShipmentId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderShipment.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderShipment.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderShipmentManagerException(consumerOrder+"Not found" );
			}
			
			consumerOrder.changePropery(property, newValueExpr);

			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  buyerId, exception);		
		
		checkIdOfGoodsSupplier(userContext,  sellerId, exception);
		checkTitleOfSupplyOrder(userContext,  title, exception);
		checkTotalAmountOfSupplyOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderShipment addSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderShipmentId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.addSupplyOrder( supplyOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
	}
	protected SupplyOrder createSupplyOrder(RetailScmUserContext userContext, String buyerId, String sellerId, String title, double totalAmount) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		RetailStoreCountryCenter  buyer = new RetailStoreCountryCenter();
		buyer.setId(buyerId);		
		supplyOrder.setBuyer(buyer);		
		GoodsSupplier  seller = new GoodsSupplier();
		seller.setId(sellerId);		
		supplyOrder.setSeller(seller);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);
	
		
		return supplyOrder;
	
		
	}
	
	protected SupplyOrder createIndexedSupplyOrder(String id, int version){

		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(version);
		return supplyOrder;			
		
	}
	protected void checkParamsForRemovingSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderShipment removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderShipmentId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.removeSupplyOrder( supplyOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderShipment copySupplyOrderFrom(RetailScmUserContext userContext, String supplyOrderShipmentId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderShipmentId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.copySupplyOrderFrom( supplyOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderShipmentManagerException exception = new SupplyOrderShipmentManagerException("Error Occured");
		
		checkIdOfSupplyOrderShipment(userContext, supplyOrderShipmentId, exception);
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
	
	public  SupplyOrderShipment updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderShipmentId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderShipment.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderShipment.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderShipmentManagerException(supplyOrder+"Not found" );
			}
			
			supplyOrder.changePropery(property, newValueExpr);

			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


