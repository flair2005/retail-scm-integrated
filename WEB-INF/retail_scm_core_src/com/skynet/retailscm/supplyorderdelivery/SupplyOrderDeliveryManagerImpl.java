
package com.skynet.retailscm.supplyorderdelivery;

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




public class SupplyOrderDeliveryManagerImpl extends RetailScmCheckerManager implements SupplyOrderDeliveryManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderDelivery";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderDeliveryDAO  supplyOrderDeliveryDAO;
 	public void setSupplyOrderDeliveryDAO(SupplyOrderDeliveryDAO  supplyOrderDeliveryDAO){
 	
 		if(supplyOrderDeliveryDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDeliveryDAO to null.");
 		}
	 	this.supplyOrderDeliveryDAO = supplyOrderDeliveryDAO;
 	}
 	public SupplyOrderDeliveryDAO getSupplyOrderDeliveryDAO(){
 		if(this.supplyOrderDeliveryDAO == null){
 			throw new IllegalStateException("The SupplyOrderDeliveryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDeliveryDAO;
 	}
 	
 	protected SupplyOrderDelivery saveSupplyOrderDelivery(RetailScmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderDeliveryDAO().save(supplyOrderDelivery, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens);
 	}
 	
 	protected SupplyOrderDelivery saveSupplyOrderDeliveryDetail(RetailScmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery) throws Exception{	

 		
 		return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, allTokens());
 	}
 	
 	public SupplyOrderDelivery loadSupplyOrderDelivery(RetailScmUserContext userContext, String supplyOrderDeliveryId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderDelivery, tokens);
 	}
 	
 	protected SupplyOrderDelivery present(RetailScmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderDelivery,tokens);
		
		
		return this.getSupplyOrderDeliveryDAO().present(supplyOrderDelivery, tokens);
	}
 
 	
 	
 	public SupplyOrderDelivery loadSupplyOrderDeliveryDetail(RetailScmUserContext userContext, String supplyOrderDeliveryId) throws Exception{	
 		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, allTokens());

 		return present(userContext,supplyOrderDelivery, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderDeliveryId) throws Exception{	
 		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, allTokens());

 		return present(userContext,supplyOrderDelivery, allTokens());
		
 	}
 	protected SupplyOrderDelivery saveSupplyOrderDelivery(RetailScmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderDeliveryDAO().save(supplyOrderDelivery, tokens);
 	}
 	protected SupplyOrderDelivery loadSupplyOrderDelivery(RetailScmUserContext userContext, String supplyOrderDeliveryId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderDeliveryDAO().load(supplyOrderDeliveryId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderDelivery, tokens);
		
		addAction(userContext, supplyOrderDelivery, tokens,"@create","createSupplyOrderDelivery","createSupplyOrderDelivery/","main","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"@update","updateSupplyOrderDelivery","updateSupplyOrderDelivery/"+supplyOrderDelivery.getId()+"/","main","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"@copy","cloneSupplyOrderDelivery","cloneSupplyOrderDelivery/"+supplyOrderDelivery.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderDelivery createSupplyOrderDelivery(RetailScmUserContext userContext,String who, Date deliveryTime
) throws Exception
	{
		
		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");

		

		checkWhoOfSupplyOrderDelivery(userContext,  who, exception);
		checkDeliveryTimeOfSupplyOrderDelivery(userContext,  deliveryTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrderDelivery supplyOrderDelivery=createNewSupplyOrderDelivery();	

		supplyOrderDelivery.setWho(who);
		supplyOrderDelivery.setDeliveryTime(deliveryTime);

		return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, emptyOptions());
		

		
	}
	protected SupplyOrderDelivery createNewSupplyOrderDelivery() 
	{
		
		return new SupplyOrderDelivery();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderDelivery(RetailScmUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		checkVersionOfSupplyOrderDelivery(userContext, supplyOrderDeliveryVersion, exception);
		

		if(SupplyOrderDelivery.WHO_PROPERTY.equals(property)){
			checkWhoOfSupplyOrderDelivery(userContext, parseString(newValueExpr), exception);
		}
		if(SupplyOrderDelivery.DELIVERY_TIME_PROPERTY.equals(property)){
			checkDeliveryTimeOfSupplyOrderDelivery(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SupplyOrderDelivery clone(RetailScmUserContext userContext, String fromSupplyOrderDeliveryId) throws Exception{
		
		return this.getSupplyOrderDeliveryDAO().clone(fromSupplyOrderDeliveryId, this.allTokens());
	}
	
	public SupplyOrderDelivery updateSupplyOrderDelivery(RetailScmUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderDelivery(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		if(supplyOrderDelivery.getVersion() != supplyOrderDeliveryVersion){
			String message = "The target version("+supplyOrderDelivery.getVersion()+") is not equals to version("+supplyOrderDeliveryVersion+") provided";
			throw new SupplyOrderDeliveryManagerException(message);
		}
		synchronized(supplyOrderDelivery){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderDelivery.
			
			supplyOrderDelivery.changePropery(property, newValueExpr);
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderDeliveryTokens tokens(){
		return SupplyOrderDeliveryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderDeliveryTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderDeliveryTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception{
		getSupplyOrderDeliveryDAO().delete(supplyOrderDeliveryId, supplyOrderDeliveryVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderDeliveryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderDeliveryDAO().deleteAll();
	}

	protected void checkParamsForAddingConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);

		checkTitleOfConsumerOrder(userContext,  title, exception);		
		
		checkIdOfRetailStoreMember(userContext,  consumerId, exception);		
		
		checkIdOfRetailStore(userContext,  storeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderDelivery addConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderDeliveryId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.addConsumerOrder( consumerOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderDelivery removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderDeliveryId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.removeConsumerOrder( consumerOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderDelivery copyConsumerOrderFrom(RetailScmUserContext userContext, String supplyOrderDeliveryId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderDeliveryId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfConsumerOrder(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplyOrderDelivery updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderDeliveryId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderDelivery.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderDelivery.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderDeliveryManagerException(consumerOrder+"Not found" );
			}
			
			consumerOrder.changePropery(property, newValueExpr);

			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  buyerId, exception);		
		
		checkIdOfGoodsSupplier(userContext,  sellerId, exception);
		checkTitleOfSupplyOrder(userContext,  title, exception);
		checkTotalAmountOfSupplyOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderDelivery addSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderDeliveryId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.addSupplyOrder( supplyOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderDelivery removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderDeliveryId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.removeSupplyOrder( supplyOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderDelivery copySupplyOrderFrom(RetailScmUserContext userContext, String supplyOrderDeliveryId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderDeliveryId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.copySupplyOrderFrom( supplyOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderDeliveryManagerException exception = new SupplyOrderDeliveryManagerException("Error Occured");
		
		checkIdOfSupplyOrderDelivery(userContext, supplyOrderDeliveryId, exception);
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
	
	public  SupplyOrderDelivery updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderDeliveryId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderDelivery.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderDelivery.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderDeliveryManagerException(supplyOrder+"Not found" );
			}
			
			supplyOrder.changePropery(property, newValueExpr);

			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


