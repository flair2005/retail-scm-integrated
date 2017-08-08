
package com.skynet.retailscm.consumerorderlineitem;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.consumerorder.ConsumerOrder;

import com.skynet.retailscm.consumerorder.ConsumerOrderDAO;



import com.skynet.retailscm.consumerorder.ConsumerOrderTable;




public class ConsumerOrderLineItemManagerImpl extends RetailScmCheckerManager implements ConsumerOrderLineItemManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderLineItem";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderLineItemDAO  consumerOrderLineItemDAO;
 	public void setConsumerOrderLineItemDAO(ConsumerOrderLineItemDAO  consumerOrderLineItemDAO){
 	
 		if(consumerOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderLineItemDAO to null.");
 		}
	 	this.consumerOrderLineItemDAO = consumerOrderLineItemDAO;
 	}
 	public ConsumerOrderLineItemDAO getConsumerOrderLineItemDAO(){
 		if(this.consumerOrderLineItemDAO == null){
 			throw new IllegalStateException("The ConsumerOrderLineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderLineItemDAO;
 	}
 	
 	protected ConsumerOrderLineItem saveConsumerOrderLineItem(RetailScmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderLineItemDAO().save(consumerOrderLineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens);
 	}
 	
 	protected ConsumerOrderLineItem saveConsumerOrderLineItemDetail(RetailScmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem) throws Exception{	

 		
 		return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, allTokens());
 	}
 	
 	public ConsumerOrderLineItem loadConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderLineItemId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderLineItemManagerException exception = new ConsumerOrderLineItemManagerException("Error Occured");
		
		checkIdOfConsumerOrderLineItem(userContext, consumerOrderLineItemId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderLineItem, tokens);
 	}
 	
 	protected ConsumerOrderLineItem present(RetailScmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderLineItem,tokens);
		
		
		return this.getConsumerOrderLineItemDAO().present(consumerOrderLineItem, tokens);
	}
 
 	
 	
 	public ConsumerOrderLineItem loadConsumerOrderLineItemDetail(RetailScmUserContext userContext, String consumerOrderLineItemId) throws Exception{	
 		ConsumerOrderLineItemManagerException exception = new ConsumerOrderLineItemManagerException("Error Occured");
		
		checkIdOfConsumerOrderLineItem(userContext, consumerOrderLineItemId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, allTokens());

 		return present(userContext,consumerOrderLineItem, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderLineItemId) throws Exception{	
 		ConsumerOrderLineItemManagerException exception = new ConsumerOrderLineItemManagerException("Error Occured");
		
		checkIdOfConsumerOrderLineItem(userContext, consumerOrderLineItemId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, allTokens());

 		return present(userContext,consumerOrderLineItem, allTokens());
		
 	}
 	protected ConsumerOrderLineItem saveConsumerOrderLineItem(RetailScmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderLineItemDAO().save(consumerOrderLineItem, tokens);
 	}
 	protected ConsumerOrderLineItem loadConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderLineItemId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderLineItemDAO().load(consumerOrderLineItemId, tokens);
 	}

	



 	 
 	
 	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	//------------------------------------
 	public ConsumerOrderDAO getConsumerOrderDAO(){
	 	return this.consumerOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderLineItem, tokens);
		
		addAction(userContext, consumerOrderLineItem, tokens,"@create","createConsumerOrderLineItem","createConsumerOrderLineItem/","main","primary");
		addAction(userContext, consumerOrderLineItem, tokens,"@update","updateConsumerOrderLineItem","updateConsumerOrderLineItem/"+consumerOrderLineItem.getId()+"/","main","primary");
		addAction(userContext, consumerOrderLineItem, tokens,"@copy","cloneConsumerOrderLineItem","cloneConsumerOrderLineItem/"+consumerOrderLineItem.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderLineItem, tokens,"consumer_order_line_item.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderLineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderLineItem createConsumerOrderLineItem(RetailScmUserContext userContext,String bizOrderId, String skuId, String skuName, double price, double quantity, double amount
) throws Exception
	{
		
		ConsumerOrderLineItemManagerException exception = new ConsumerOrderLineItemManagerException("Error Occured");

		

		checkSkuIdOfConsumerOrderLineItem(userContext,  skuId, exception);
		checkSkuNameOfConsumerOrderLineItem(userContext,  skuName, exception);
		checkPriceOfConsumerOrderLineItem(userContext,  price, exception);
		checkQuantityOfConsumerOrderLineItem(userContext,  quantity, exception);
		checkAmountOfConsumerOrderLineItem(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrderLineItem consumerOrderLineItem=createNewConsumerOrderLineItem();	

		ConsumerOrder bizOrder = loadConsumerOrder(bizOrderId,emptyOptions());
		consumerOrderLineItem.setBizOrder(bizOrder);
		consumerOrderLineItem.setSkuId(skuId);
		consumerOrderLineItem.setSkuName(skuName);
		consumerOrderLineItem.setPrice(price);
		consumerOrderLineItem.setQuantity(quantity);
		consumerOrderLineItem.setAmount(amount);

		return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, emptyOptions());
		

		
	}
	protected ConsumerOrderLineItem createNewConsumerOrderLineItem() 
	{
		
		return new ConsumerOrderLineItem();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderLineItem(RetailScmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderLineItemManagerException exception = new ConsumerOrderLineItemManagerException("Error Occured");
		
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
	
	
	
	public ConsumerOrderLineItem clone(RetailScmUserContext userContext, String fromConsumerOrderLineItemId) throws Exception{
		
		return this.getConsumerOrderLineItemDAO().clone(fromConsumerOrderLineItemId, this.allTokens());
	}
	
	public ConsumerOrderLineItem updateConsumerOrderLineItem(RetailScmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderLineItem(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem(userContext, consumerOrderLineItemId, allTokens());
		if(consumerOrderLineItem.getVersion() != consumerOrderLineItemVersion){
			String message = "The target version("+consumerOrderLineItem.getVersion()+") is not equals to version("+consumerOrderLineItemVersion+") provided";
			throw new ConsumerOrderLineItemManagerException(message);
		}
		synchronized(consumerOrderLineItem){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderLineItem.
			
			consumerOrderLineItem.changePropery(property, newValueExpr);
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
			return present(userContext,consumerOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderLineItemTokens tokens(){
		return ConsumerOrderLineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderLineItemTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderLineItemTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		ConsumerOrderLineItemManagerException exception = new ConsumerOrderLineItemManagerException("Error Occured");
 		checkIdOfConsumerOrderLineItem(userContext, consumerOrderLineItemId,exception);
 		checkIdOfConsumerOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ConsumerOrderLineItem transferToAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderLineItemId,anotherBizOrderId);
 
		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem(userContext, consumerOrderLineItemId, allTokens());	
		synchronized(consumerOrderLineItem){
			//will be good when the consumerOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(anotherBizOrderId, emptyOptions());		
			consumerOrderLineItem.setBizOrder(bizOrder);		
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, emptyOptions());
			
			return present(userContext,consumerOrderLineItem, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected ConsumerOrder loadConsumerOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getConsumerOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception{
		getConsumerOrderLineItemDAO().delete(consumerOrderLineItemId, consumerOrderLineItemVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderLineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderLineItemDAO().deleteAll();
	}


}


