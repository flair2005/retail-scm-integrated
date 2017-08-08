
package com.skynet.retailscm.retailstoreorderlineitem;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrderDAO;



import com.skynet.retailscm.retailstoreorder.RetailStoreOrderTable;




public class RetailStoreOrderLineItemManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderLineItemManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderLineItem";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderLineItemDAO  retailStoreOrderLineItemDAO;
 	public void setRetailStoreOrderLineItemDAO(RetailStoreOrderLineItemDAO  retailStoreOrderLineItemDAO){
 	
 		if(retailStoreOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderLineItemDAO to null.");
 		}
	 	this.retailStoreOrderLineItemDAO = retailStoreOrderLineItemDAO;
 	}
 	public RetailStoreOrderLineItemDAO getRetailStoreOrderLineItemDAO(){
 		if(this.retailStoreOrderLineItemDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderLineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderLineItemDAO;
 	}
 	
 	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItem(RetailScmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderLineItemDAO().save(retailStoreOrderLineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens);
 	}
 	
 	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItemDetail(RetailScmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem) throws Exception{	

 		
 		return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, allTokens());
 	}
 	
 	public RetailStoreOrderLineItem loadRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderLineItemId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderLineItemManagerException exception = new RetailStoreOrderLineItemManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderLineItem, tokens);
 	}
 	
 	protected RetailStoreOrderLineItem present(RetailScmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderLineItem,tokens);
		
		
		return this.getRetailStoreOrderLineItemDAO().present(retailStoreOrderLineItem, tokens);
	}
 
 	
 	
 	public RetailStoreOrderLineItem loadRetailStoreOrderLineItemDetail(RetailScmUserContext userContext, String retailStoreOrderLineItemId) throws Exception{	
 		RetailStoreOrderLineItemManagerException exception = new RetailStoreOrderLineItemManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, allTokens());

 		return present(userContext,retailStoreOrderLineItem, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderLineItemId) throws Exception{	
 		RetailStoreOrderLineItemManagerException exception = new RetailStoreOrderLineItemManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, allTokens());

 		return present(userContext,retailStoreOrderLineItem, allTokens());
		
 	}
 	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItem(RetailScmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderLineItemDAO().save(retailStoreOrderLineItem, tokens);
 	}
 	protected RetailStoreOrderLineItem loadRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderLineItemId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderLineItemDAO().load(retailStoreOrderLineItemId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
	 	return this.retailStoreOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderLineItem, tokens);
		
		addAction(userContext, retailStoreOrderLineItem, tokens,"@create","createRetailStoreOrderLineItem","createRetailStoreOrderLineItem/","main","primary");
		addAction(userContext, retailStoreOrderLineItem, tokens,"@update","updateRetailStoreOrderLineItem","updateRetailStoreOrderLineItem/"+retailStoreOrderLineItem.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderLineItem, tokens,"@copy","cloneRetailStoreOrderLineItem","cloneRetailStoreOrderLineItem/"+retailStoreOrderLineItem.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderLineItem, tokens,"retail_store_order_line_item.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderLineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderLineItem createRetailStoreOrderLineItem(RetailScmUserContext userContext,String bizOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement
) throws Exception
	{
		
		RetailStoreOrderLineItemManagerException exception = new RetailStoreOrderLineItemManagerException("Error Occured");

		

		checkSkuIdOfRetailStoreOrderLineItem(userContext,  skuId, exception);
		checkSkuNameOfRetailStoreOrderLineItem(userContext,  skuName, exception);
		checkAmountOfRetailStoreOrderLineItem(userContext,  amount, exception);
		checkQuantityOfRetailStoreOrderLineItem(userContext,  quantity, exception);
		checkUnitOfMeasurementOfRetailStoreOrderLineItem(userContext,  unitOfMeasurement, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrderLineItem retailStoreOrderLineItem=createNewRetailStoreOrderLineItem();	

		RetailStoreOrder bizOrder = loadRetailStoreOrder(bizOrderId,emptyOptions());
		retailStoreOrderLineItem.setBizOrder(bizOrder);
		retailStoreOrderLineItem.setSkuId(skuId);
		retailStoreOrderLineItem.setSkuName(skuName);
		retailStoreOrderLineItem.setAmount(amount);
		retailStoreOrderLineItem.setQuantity(quantity);
		retailStoreOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);

		return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, emptyOptions());
		

		
	}
	protected RetailStoreOrderLineItem createNewRetailStoreOrderLineItem() 
	{
		
		return new RetailStoreOrderLineItem();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderLineItem(RetailScmUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderLineItemManagerException exception = new RetailStoreOrderLineItemManagerException("Error Occured");
		
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
	
	
	
	public RetailStoreOrderLineItem clone(RetailScmUserContext userContext, String fromRetailStoreOrderLineItemId) throws Exception{
		
		return this.getRetailStoreOrderLineItemDAO().clone(fromRetailStoreOrderLineItemId, this.allTokens());
	}
	
	public RetailStoreOrderLineItem updateRetailStoreOrderLineItem(RetailScmUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, allTokens());
		if(retailStoreOrderLineItem.getVersion() != retailStoreOrderLineItemVersion){
			String message = "The target version("+retailStoreOrderLineItem.getVersion()+") is not equals to version("+retailStoreOrderLineItemVersion+") provided";
			throw new RetailStoreOrderLineItemManagerException(message);
		}
		synchronized(retailStoreOrderLineItem){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderLineItem.
			
			retailStoreOrderLineItem.changePropery(property, newValueExpr);
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
			return present(userContext,retailStoreOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderLineItemTokens tokens(){
		return RetailStoreOrderLineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderLineItemTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderLineItemTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String retailStoreOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		RetailStoreOrderLineItemManagerException exception = new RetailStoreOrderLineItemManagerException("Error Occured");
 		checkIdOfRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId,exception);
 		checkIdOfRetailStoreOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreOrderLineItem transferToAnotherBizOrder(RetailScmUserContext userContext, String retailStoreOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderLineItemId,anotherBizOrderId);
 
		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, allTokens());	
		synchronized(retailStoreOrderLineItem){
			//will be good when the retailStoreOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(anotherBizOrderId, emptyOptions());		
			retailStoreOrderLineItem.setBizOrder(bizOrder);		
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, emptyOptions());
			
			return present(userContext,retailStoreOrderLineItem, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreOrder loadRetailStoreOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception{
		getRetailStoreOrderLineItemDAO().delete(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderLineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderLineItemDAO().deleteAll();
	}


}


