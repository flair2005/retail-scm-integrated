
package com.skynet.retailscm.supplyorderlineitem;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.supplyorder.SupplyOrder;

import com.skynet.retailscm.supplyorder.SupplyOrderDAO;



import com.skynet.retailscm.supplyorder.SupplyOrderTable;




public class SupplyOrderLineItemManagerImpl extends RetailScmCheckerManager implements SupplyOrderLineItemManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderLineItem";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderLineItemDAO  supplyOrderLineItemDAO;
 	public void setSupplyOrderLineItemDAO(SupplyOrderLineItemDAO  supplyOrderLineItemDAO){
 	
 		if(supplyOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderLineItemDAO to null.");
 		}
	 	this.supplyOrderLineItemDAO = supplyOrderLineItemDAO;
 	}
 	public SupplyOrderLineItemDAO getSupplyOrderLineItemDAO(){
 		if(this.supplyOrderLineItemDAO == null){
 			throw new IllegalStateException("The SupplyOrderLineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderLineItemDAO;
 	}
 	
 	protected SupplyOrderLineItem saveSupplyOrderLineItem(RetailScmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderLineItemDAO().save(supplyOrderLineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens);
 	}
 	
 	protected SupplyOrderLineItem saveSupplyOrderLineItemDetail(RetailScmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem) throws Exception{	

 		
 		return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, allTokens());
 	}
 	
 	public SupplyOrderLineItem loadSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderLineItemId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderLineItemManagerException exception = new SupplyOrderLineItemManagerException("Error Occured");
		
		checkIdOfSupplyOrderLineItem(userContext, supplyOrderLineItemId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderLineItem, tokens);
 	}
 	
 	protected SupplyOrderLineItem present(RetailScmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderLineItem,tokens);
		
		
		return this.getSupplyOrderLineItemDAO().present(supplyOrderLineItem, tokens);
	}
 
 	
 	
 	public SupplyOrderLineItem loadSupplyOrderLineItemDetail(RetailScmUserContext userContext, String supplyOrderLineItemId) throws Exception{	
 		SupplyOrderLineItemManagerException exception = new SupplyOrderLineItemManagerException("Error Occured");
		
		checkIdOfSupplyOrderLineItem(userContext, supplyOrderLineItemId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, allTokens());

 		return present(userContext,supplyOrderLineItem, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderLineItemId) throws Exception{	
 		SupplyOrderLineItemManagerException exception = new SupplyOrderLineItemManagerException("Error Occured");
		
		checkIdOfSupplyOrderLineItem(userContext, supplyOrderLineItemId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, allTokens());

 		return present(userContext,supplyOrderLineItem, allTokens());
		
 	}
 	protected SupplyOrderLineItem saveSupplyOrderLineItem(RetailScmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderLineItemDAO().save(supplyOrderLineItem, tokens);
 	}
 	protected SupplyOrderLineItem loadSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderLineItemId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderLineItemDAO().load(supplyOrderLineItemId, tokens);
 	}

	



 	 
 	
 	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	//------------------------------------
 	public SupplyOrderDAO getSupplyOrderDAO(){
	 	return this.supplyOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderLineItem, tokens);
		
		addAction(userContext, supplyOrderLineItem, tokens,"@create","createSupplyOrderLineItem","createSupplyOrderLineItem/","main","primary");
		addAction(userContext, supplyOrderLineItem, tokens,"@update","updateSupplyOrderLineItem","updateSupplyOrderLineItem/"+supplyOrderLineItem.getId()+"/","main","primary");
		addAction(userContext, supplyOrderLineItem, tokens,"@copy","cloneSupplyOrderLineItem","cloneSupplyOrderLineItem/"+supplyOrderLineItem.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderLineItem, tokens,"supply_order_line_item.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+supplyOrderLineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderLineItem createSupplyOrderLineItem(RetailScmUserContext userContext,String bizOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement
) throws Exception
	{
		
		SupplyOrderLineItemManagerException exception = new SupplyOrderLineItemManagerException("Error Occured");

		

		checkSkuIdOfSupplyOrderLineItem(userContext,  skuId, exception);
		checkSkuNameOfSupplyOrderLineItem(userContext,  skuName, exception);
		checkAmountOfSupplyOrderLineItem(userContext,  amount, exception);
		checkQuantityOfSupplyOrderLineItem(userContext,  quantity, exception);
		checkUnitOfMeasurementOfSupplyOrderLineItem(userContext,  unitOfMeasurement, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrderLineItem supplyOrderLineItem=createNewSupplyOrderLineItem();	

		SupplyOrder bizOrder = loadSupplyOrder(bizOrderId,emptyOptions());
		supplyOrderLineItem.setBizOrder(bizOrder);
		supplyOrderLineItem.setSkuId(skuId);
		supplyOrderLineItem.setSkuName(skuName);
		supplyOrderLineItem.setAmount(amount);
		supplyOrderLineItem.setQuantity(quantity);
		supplyOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);

		return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, emptyOptions());
		

		
	}
	protected SupplyOrderLineItem createNewSupplyOrderLineItem() 
	{
		
		return new SupplyOrderLineItem();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderLineItem(RetailScmUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderLineItemManagerException exception = new SupplyOrderLineItemManagerException("Error Occured");
		
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
	
	
	
	public SupplyOrderLineItem clone(RetailScmUserContext userContext, String fromSupplyOrderLineItemId) throws Exception{
		
		return this.getSupplyOrderLineItemDAO().clone(fromSupplyOrderLineItemId, this.allTokens());
	}
	
	public SupplyOrderLineItem updateSupplyOrderLineItem(RetailScmUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());
		if(supplyOrderLineItem.getVersion() != supplyOrderLineItemVersion){
			String message = "The target version("+supplyOrderLineItem.getVersion()+") is not equals to version("+supplyOrderLineItemVersion+") provided";
			throw new SupplyOrderLineItemManagerException(message);
		}
		synchronized(supplyOrderLineItem){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderLineItem.
			
			supplyOrderLineItem.changePropery(property, newValueExpr);
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
			return present(userContext,supplyOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderLineItemTokens tokens(){
		return SupplyOrderLineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderLineItemTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderLineItemTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		SupplyOrderLineItemManagerException exception = new SupplyOrderLineItemManagerException("Error Occured");
 		checkIdOfSupplyOrderLineItem(userContext, supplyOrderLineItemId,exception);
 		checkIdOfSupplyOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SupplyOrderLineItem transferToAnotherBizOrder(RetailScmUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, supplyOrderLineItemId,anotherBizOrderId);
 
		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());	
		synchronized(supplyOrderLineItem){
			//will be good when the supplyOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(anotherBizOrderId, emptyOptions());		
			supplyOrderLineItem.setBizOrder(bizOrder);		
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, emptyOptions());
			
			return present(userContext,supplyOrderLineItem, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected SupplyOrder loadSupplyOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception{
		getSupplyOrderLineItemDAO().delete(supplyOrderLineItemId, supplyOrderLineItemVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderLineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderLineItemDAO().deleteAll();
	}


}


