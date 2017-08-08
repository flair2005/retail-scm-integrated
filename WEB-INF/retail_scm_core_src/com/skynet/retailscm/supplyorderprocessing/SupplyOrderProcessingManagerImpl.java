
package com.skynet.retailscm.supplyorderprocessing;

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




public class SupplyOrderProcessingManagerImpl extends RetailScmCheckerManager implements SupplyOrderProcessingManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderProcessing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderProcessingDAO  supplyOrderProcessingDAO;
 	public void setSupplyOrderProcessingDAO(SupplyOrderProcessingDAO  supplyOrderProcessingDAO){
 	
 		if(supplyOrderProcessingDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderProcessingDAO to null.");
 		}
	 	this.supplyOrderProcessingDAO = supplyOrderProcessingDAO;
 	}
 	public SupplyOrderProcessingDAO getSupplyOrderProcessingDAO(){
 		if(this.supplyOrderProcessingDAO == null){
 			throw new IllegalStateException("The SupplyOrderProcessingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderProcessingDAO;
 	}
 	
 	protected SupplyOrderProcessing saveSupplyOrderProcessing(RetailScmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderProcessingDAO().save(supplyOrderProcessing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens);
 	}
 	
 	protected SupplyOrderProcessing saveSupplyOrderProcessingDetail(RetailScmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing) throws Exception{	

 		
 		return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, allTokens());
 	}
 	
 	public SupplyOrderProcessing loadSupplyOrderProcessing(RetailScmUserContext userContext, String supplyOrderProcessingId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderProcessing, tokens);
 	}
 	
 	protected SupplyOrderProcessing present(RetailScmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderProcessing,tokens);
		
		
		return this.getSupplyOrderProcessingDAO().present(supplyOrderProcessing, tokens);
	}
 
 	
 	
 	public SupplyOrderProcessing loadSupplyOrderProcessingDetail(RetailScmUserContext userContext, String supplyOrderProcessingId) throws Exception{	
 		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, allTokens());

 		return present(userContext,supplyOrderProcessing, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderProcessingId) throws Exception{	
 		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, allTokens());

 		return present(userContext,supplyOrderProcessing, allTokens());
		
 	}
 	protected SupplyOrderProcessing saveSupplyOrderProcessing(RetailScmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderProcessingDAO().save(supplyOrderProcessing, tokens);
 	}
 	protected SupplyOrderProcessing loadSupplyOrderProcessing(RetailScmUserContext userContext, String supplyOrderProcessingId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderProcessingDAO().load(supplyOrderProcessingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderProcessing, tokens);
		
		addAction(userContext, supplyOrderProcessing, tokens,"@create","createSupplyOrderProcessing","createSupplyOrderProcessing/","main","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"@update","updateSupplyOrderProcessing","updateSupplyOrderProcessing/"+supplyOrderProcessing.getId()+"/","main","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"@copy","cloneSupplyOrderProcessing","cloneSupplyOrderProcessing/"+supplyOrderProcessing.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderProcessing createSupplyOrderProcessing(RetailScmUserContext userContext,String who, Date processTime
) throws Exception
	{
		
		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");

		

		checkWhoOfSupplyOrderProcessing(userContext,  who, exception);
		checkProcessTimeOfSupplyOrderProcessing(userContext,  processTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrderProcessing supplyOrderProcessing=createNewSupplyOrderProcessing();	

		supplyOrderProcessing.setWho(who);
		supplyOrderProcessing.setProcessTime(processTime);

		return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, emptyOptions());
		

		
	}
	protected SupplyOrderProcessing createNewSupplyOrderProcessing() 
	{
		
		return new SupplyOrderProcessing();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderProcessing(RetailScmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		checkVersionOfSupplyOrderProcessing(userContext, supplyOrderProcessingVersion, exception);
		

		if(SupplyOrderProcessing.WHO_PROPERTY.equals(property)){
			checkWhoOfSupplyOrderProcessing(userContext, parseString(newValueExpr), exception);
		}
		if(SupplyOrderProcessing.PROCESS_TIME_PROPERTY.equals(property)){
			checkProcessTimeOfSupplyOrderProcessing(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SupplyOrderProcessing clone(RetailScmUserContext userContext, String fromSupplyOrderProcessingId) throws Exception{
		
		return this.getSupplyOrderProcessingDAO().clone(fromSupplyOrderProcessingId, this.allTokens());
	}
	
	public SupplyOrderProcessing updateSupplyOrderProcessing(RetailScmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderProcessing(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		if(supplyOrderProcessing.getVersion() != supplyOrderProcessingVersion){
			String message = "The target version("+supplyOrderProcessing.getVersion()+") is not equals to version("+supplyOrderProcessingVersion+") provided";
			throw new SupplyOrderProcessingManagerException(message);
		}
		synchronized(supplyOrderProcessing){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderProcessing.
			
			supplyOrderProcessing.changePropery(property, newValueExpr);
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderProcessingTokens tokens(){
		return SupplyOrderProcessingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderProcessingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderProcessingTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception{
		getSupplyOrderProcessingDAO().delete(supplyOrderProcessingId, supplyOrderProcessingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderProcessingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderProcessingDAO().deleteAll();
	}

	protected void checkParamsForAddingConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);

		checkTitleOfConsumerOrder(userContext,  title, exception);		
		
		checkIdOfRetailStoreMember(userContext,  consumerId, exception);		
		
		checkIdOfRetailStore(userContext,  storeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderProcessing addConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderProcessingId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.addConsumerOrder( consumerOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderProcessing removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderProcessingId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.removeConsumerOrder( consumerOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderProcessing copyConsumerOrderFrom(RetailScmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderProcessingId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfConsumerOrder(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplyOrderProcessing updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderProcessingId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderProcessing.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderProcessing.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderProcessingManagerException(consumerOrder+"Not found" );
			}
			
			consumerOrder.changePropery(property, newValueExpr);

			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  buyerId, exception);		
		
		checkIdOfGoodsSupplier(userContext,  sellerId, exception);
		checkTitleOfSupplyOrder(userContext,  title, exception);
		checkTotalAmountOfSupplyOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderProcessing addSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderProcessingId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.addSupplyOrder( supplyOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderProcessing removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderProcessingId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.removeSupplyOrder( supplyOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderProcessing copySupplyOrderFrom(RetailScmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderProcessingId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.copySupplyOrderFrom( supplyOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderProcessingManagerException exception = new SupplyOrderProcessingManagerException("Error Occured");
		
		checkIdOfSupplyOrderProcessing(userContext, supplyOrderProcessingId, exception);
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
	
	public  SupplyOrderProcessing updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderProcessingId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderProcessing.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderProcessing.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderProcessingManagerException(supplyOrder+"Not found" );
			}
			
			supplyOrder.changePropery(property, newValueExpr);

			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


