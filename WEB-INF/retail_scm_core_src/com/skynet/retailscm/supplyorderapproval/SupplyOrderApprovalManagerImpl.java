
package com.skynet.retailscm.supplyorderapproval;

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




public class SupplyOrderApprovalManagerImpl extends RetailScmCheckerManager implements SupplyOrderApprovalManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderApproval";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderApprovalDAO  supplyOrderApprovalDAO;
 	public void setSupplyOrderApprovalDAO(SupplyOrderApprovalDAO  supplyOrderApprovalDAO){
 	
 		if(supplyOrderApprovalDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderApprovalDAO to null.");
 		}
	 	this.supplyOrderApprovalDAO = supplyOrderApprovalDAO;
 	}
 	public SupplyOrderApprovalDAO getSupplyOrderApprovalDAO(){
 		if(this.supplyOrderApprovalDAO == null){
 			throw new IllegalStateException("The SupplyOrderApprovalDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderApprovalDAO;
 	}
 	
 	protected SupplyOrderApproval saveSupplyOrderApproval(RetailScmUserContext userContext, SupplyOrderApproval supplyOrderApproval, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderApprovalDAO().save(supplyOrderApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens);
 	}
 	
 	protected SupplyOrderApproval saveSupplyOrderApprovalDetail(RetailScmUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception{	

 		
 		return saveSupplyOrderApproval(userContext, supplyOrderApproval, allTokens());
 	}
 	
 	public SupplyOrderApproval loadSupplyOrderApproval(RetailScmUserContext userContext, String supplyOrderApprovalId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderApproval, tokens);
 	}
 	
 	protected SupplyOrderApproval present(RetailScmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderApproval,tokens);
		
		
		return this.getSupplyOrderApprovalDAO().present(supplyOrderApproval, tokens);
	}
 
 	
 	
 	public SupplyOrderApproval loadSupplyOrderApprovalDetail(RetailScmUserContext userContext, String supplyOrderApprovalId) throws Exception{	
 		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, allTokens());

 		return present(userContext,supplyOrderApproval, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderApprovalId) throws Exception{	
 		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, allTokens());

 		return present(userContext,supplyOrderApproval, allTokens());
		
 	}
 	protected SupplyOrderApproval saveSupplyOrderApproval(RetailScmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderApprovalDAO().save(supplyOrderApproval, tokens);
 	}
 	protected SupplyOrderApproval loadSupplyOrderApproval(RetailScmUserContext userContext, String supplyOrderApprovalId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderApprovalDAO().load(supplyOrderApprovalId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderApproval, tokens);
		
		addAction(userContext, supplyOrderApproval, tokens,"@create","createSupplyOrderApproval","createSupplyOrderApproval/","main","primary");
		addAction(userContext, supplyOrderApproval, tokens,"@update","updateSupplyOrderApproval","updateSupplyOrderApproval/"+supplyOrderApproval.getId()+"/","main","primary");
		addAction(userContext, supplyOrderApproval, tokens,"@copy","cloneSupplyOrderApproval","cloneSupplyOrderApproval/"+supplyOrderApproval.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderApproval createSupplyOrderApproval(RetailScmUserContext userContext,String who, Date approveTime
) throws Exception
	{
		
		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");

		

		checkWhoOfSupplyOrderApproval(userContext,  who, exception);
		checkApproveTimeOfSupplyOrderApproval(userContext,  approveTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrderApproval supplyOrderApproval=createNewSupplyOrderApproval();	

		supplyOrderApproval.setWho(who);
		supplyOrderApproval.setApproveTime(approveTime);

		return saveSupplyOrderApproval(userContext, supplyOrderApproval, emptyOptions());
		

		
	}
	protected SupplyOrderApproval createNewSupplyOrderApproval() 
	{
		
		return new SupplyOrderApproval();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderApproval(RetailScmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		checkVersionOfSupplyOrderApproval(userContext, supplyOrderApprovalVersion, exception);
		

		if(SupplyOrderApproval.WHO_PROPERTY.equals(property)){
			checkWhoOfSupplyOrderApproval(userContext, parseString(newValueExpr), exception);
		}
		if(SupplyOrderApproval.APPROVE_TIME_PROPERTY.equals(property)){
			checkApproveTimeOfSupplyOrderApproval(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SupplyOrderApproval clone(RetailScmUserContext userContext, String fromSupplyOrderApprovalId) throws Exception{
		
		return this.getSupplyOrderApprovalDAO().clone(fromSupplyOrderApprovalId, this.allTokens());
	}
	
	public SupplyOrderApproval updateSupplyOrderApproval(RetailScmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		if(supplyOrderApproval.getVersion() != supplyOrderApprovalVersion){
			String message = "The target version("+supplyOrderApproval.getVersion()+") is not equals to version("+supplyOrderApprovalVersion+") provided";
			throw new SupplyOrderApprovalManagerException(message);
		}
		synchronized(supplyOrderApproval){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.
			
			supplyOrderApproval.changePropery(property, newValueExpr);
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderApprovalTokens tokens(){
		return SupplyOrderApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderApprovalTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderApprovalTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception{
		getSupplyOrderApprovalDAO().delete(supplyOrderApprovalId, supplyOrderApprovalVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderApprovalDAO().deleteAll();
	}

	protected void checkParamsForAddingConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);

		checkTitleOfConsumerOrder(userContext,  title, exception);		
		
		checkIdOfRetailStoreMember(userContext,  consumerId, exception);		
		
		checkIdOfRetailStore(userContext,  storeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderApproval addConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderApprovalId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.addConsumerOrder( consumerOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderApproval removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderApprovalId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.removeConsumerOrder( consumerOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderApproval copyConsumerOrderFrom(RetailScmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderApprovalId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfConsumerOrder(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplyOrderApproval updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderApprovalId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderApproval.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderApproval.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderApprovalManagerException(consumerOrder+"Not found" );
			}
			
			consumerOrder.changePropery(property, newValueExpr);

			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  buyerId, exception);		
		
		checkIdOfGoodsSupplier(userContext,  sellerId, exception);
		checkTitleOfSupplyOrder(userContext,  title, exception);
		checkTotalAmountOfSupplyOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderApproval addSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderApprovalId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.addSupplyOrder( supplyOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderApproval removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderApprovalId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.removeSupplyOrder( supplyOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderApproval copySupplyOrderFrom(RetailScmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderApprovalId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.copySupplyOrderFrom( supplyOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderApprovalManagerException exception = new SupplyOrderApprovalManagerException("Error Occured");
		
		checkIdOfSupplyOrderApproval(userContext, supplyOrderApprovalId, exception);
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
	
	public  SupplyOrderApproval updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderApprovalId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderApproval.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderApproval.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderApprovalManagerException(supplyOrder+"Not found" );
			}
			
			supplyOrder.changePropery(property, newValueExpr);

			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


