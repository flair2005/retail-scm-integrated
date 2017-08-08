
package com.skynet.retailscm.supplyorderconfirmation;

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




public class SupplyOrderConfirmationManagerImpl extends RetailScmCheckerManager implements SupplyOrderConfirmationManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderConfirmation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderConfirmationDAO  supplyOrderConfirmationDAO;
 	public void setSupplyOrderConfirmationDAO(SupplyOrderConfirmationDAO  supplyOrderConfirmationDAO){
 	
 		if(supplyOrderConfirmationDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderConfirmationDAO to null.");
 		}
	 	this.supplyOrderConfirmationDAO = supplyOrderConfirmationDAO;
 	}
 	public SupplyOrderConfirmationDAO getSupplyOrderConfirmationDAO(){
 		if(this.supplyOrderConfirmationDAO == null){
 			throw new IllegalStateException("The SupplyOrderConfirmationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderConfirmationDAO;
 	}
 	
 	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(RetailScmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderConfirmationDAO().save(supplyOrderConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens);
 	}
 	
 	protected SupplyOrderConfirmation saveSupplyOrderConfirmationDetail(RetailScmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception{	

 		
 		return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, allTokens());
 	}
 	
 	public SupplyOrderConfirmation loadSupplyOrderConfirmation(RetailScmUserContext userContext, String supplyOrderConfirmationId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderConfirmation, tokens);
 	}
 	
 	protected SupplyOrderConfirmation present(RetailScmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderConfirmation,tokens);
		
		
		return this.getSupplyOrderConfirmationDAO().present(supplyOrderConfirmation, tokens);
	}
 
 	
 	
 	public SupplyOrderConfirmation loadSupplyOrderConfirmationDetail(RetailScmUserContext userContext, String supplyOrderConfirmationId) throws Exception{	
 		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, allTokens());

 		return present(userContext,supplyOrderConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderConfirmationId) throws Exception{	
 		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, allTokens());

 		return present(userContext,supplyOrderConfirmation, allTokens());
		
 	}
 	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(RetailScmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderConfirmationDAO().save(supplyOrderConfirmation, tokens);
 	}
 	protected SupplyOrderConfirmation loadSupplyOrderConfirmation(RetailScmUserContext userContext, String supplyOrderConfirmationId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderConfirmationDAO().load(supplyOrderConfirmationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderConfirmation, tokens);
		
		addAction(userContext, supplyOrderConfirmation, tokens,"@create","createSupplyOrderConfirmation","createSupplyOrderConfirmation/","main","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"@update","updateSupplyOrderConfirmation","updateSupplyOrderConfirmation/"+supplyOrderConfirmation.getId()+"/","main","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"@copy","cloneSupplyOrderConfirmation","cloneSupplyOrderConfirmation/"+supplyOrderConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderConfirmation createSupplyOrderConfirmation(RetailScmUserContext userContext,String who, Date confirmTime
) throws Exception
	{
		
		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");

		

		checkWhoOfSupplyOrderConfirmation(userContext,  who, exception);
		checkConfirmTimeOfSupplyOrderConfirmation(userContext,  confirmTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrderConfirmation supplyOrderConfirmation=createNewSupplyOrderConfirmation();	

		supplyOrderConfirmation.setWho(who);
		supplyOrderConfirmation.setConfirmTime(confirmTime);

		return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, emptyOptions());
		

		
	}
	protected SupplyOrderConfirmation createNewSupplyOrderConfirmation() 
	{
		
		return new SupplyOrderConfirmation();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderConfirmation(RetailScmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		checkVersionOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationVersion, exception);
		

		if(SupplyOrderConfirmation.WHO_PROPERTY.equals(property)){
			checkWhoOfSupplyOrderConfirmation(userContext, parseString(newValueExpr), exception);
		}
		if(SupplyOrderConfirmation.CONFIRM_TIME_PROPERTY.equals(property)){
			checkConfirmTimeOfSupplyOrderConfirmation(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SupplyOrderConfirmation clone(RetailScmUserContext userContext, String fromSupplyOrderConfirmationId) throws Exception{
		
		return this.getSupplyOrderConfirmationDAO().clone(fromSupplyOrderConfirmationId, this.allTokens());
	}
	
	public SupplyOrderConfirmation updateSupplyOrderConfirmation(RetailScmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		if(supplyOrderConfirmation.getVersion() != supplyOrderConfirmationVersion){
			String message = "The target version("+supplyOrderConfirmation.getVersion()+") is not equals to version("+supplyOrderConfirmationVersion+") provided";
			throw new SupplyOrderConfirmationManagerException(message);
		}
		synchronized(supplyOrderConfirmation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.
			
			supplyOrderConfirmation.changePropery(property, newValueExpr);
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderConfirmationTokens tokens(){
		return SupplyOrderConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderConfirmationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderConfirmationTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception{
		getSupplyOrderConfirmationDAO().delete(supplyOrderConfirmationId, supplyOrderConfirmationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderConfirmationDAO().deleteAll();
	}

	protected void checkParamsForAddingConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);

		checkTitleOfConsumerOrder(userContext,  title, exception);		
		
		checkIdOfRetailStoreMember(userContext,  consumerId, exception);		
		
		checkIdOfRetailStore(userContext,  storeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderConfirmation addConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderConfirmationId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.addConsumerOrder( consumerOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderConfirmation removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.removeConsumerOrder( consumerOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderConfirmation copyConsumerOrderFrom(RetailScmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfConsumerOrder(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplyOrderConfirmation updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderConfirmation.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderConfirmation.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderConfirmationManagerException(consumerOrder+"Not found" );
			}
			
			consumerOrder.changePropery(property, newValueExpr);

			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  buyerId, exception);		
		
		checkIdOfGoodsSupplier(userContext,  sellerId, exception);
		checkTitleOfSupplyOrder(userContext,  title, exception);
		checkTotalAmountOfSupplyOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderConfirmation addSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderConfirmationId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.addSupplyOrder( supplyOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderConfirmation removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.removeSupplyOrder( supplyOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderConfirmation copySupplyOrderFrom(RetailScmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.copySupplyOrderFrom( supplyOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderConfirmationManagerException exception = new SupplyOrderConfirmationManagerException("Error Occured");
		
		checkIdOfSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, exception);
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
	
	public  SupplyOrderConfirmation updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderConfirmation.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderConfirmation.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderConfirmationManagerException(supplyOrder+"Not found" );
			}
			
			supplyOrder.changePropery(property, newValueExpr);

			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


