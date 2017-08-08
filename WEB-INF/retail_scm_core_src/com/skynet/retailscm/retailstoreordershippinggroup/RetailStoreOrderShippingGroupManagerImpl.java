
package com.skynet.retailscm.retailstoreordershippinggroup;

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




public class RetailStoreOrderShippingGroupManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderShippingGroupManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderShippingGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderShippingGroupDAO  retailStoreOrderShippingGroupDAO;
 	public void setRetailStoreOrderShippingGroupDAO(RetailStoreOrderShippingGroupDAO  retailStoreOrderShippingGroupDAO){
 	
 		if(retailStoreOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderShippingGroupDAO to null.");
 		}
	 	this.retailStoreOrderShippingGroupDAO = retailStoreOrderShippingGroupDAO;
 	}
 	public RetailStoreOrderShippingGroupDAO getRetailStoreOrderShippingGroupDAO(){
 		if(this.retailStoreOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderShippingGroupDAO;
 	}
 	
 	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroup(RetailScmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderShippingGroupDAO().save(retailStoreOrderShippingGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens);
 	}
 	
 	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroupDetail(RetailScmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) throws Exception{	

 		
 		return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, allTokens());
 	}
 	
 	public RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderShippingGroupId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderShippingGroupManagerException exception = new RetailStoreOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderShippingGroup, tokens);
 	}
 	
 	protected RetailStoreOrderShippingGroup present(RetailScmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderShippingGroup,tokens);
		
		
		return this.getRetailStoreOrderShippingGroupDAO().present(retailStoreOrderShippingGroup, tokens);
	}
 
 	
 	
 	public RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroupDetail(RetailScmUserContext userContext, String retailStoreOrderShippingGroupId) throws Exception{	
 		RetailStoreOrderShippingGroupManagerException exception = new RetailStoreOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, allTokens());

 		return present(userContext,retailStoreOrderShippingGroup, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderShippingGroupId) throws Exception{	
 		RetailStoreOrderShippingGroupManagerException exception = new RetailStoreOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, allTokens());

 		return present(userContext,retailStoreOrderShippingGroup, allTokens());
		
 	}
 	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroup(RetailScmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderShippingGroupDAO().save(retailStoreOrderShippingGroup, tokens);
 	}
 	protected RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderShippingGroupId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderShippingGroupDAO().load(retailStoreOrderShippingGroupId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
	 	return this.retailStoreOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderShippingGroup, tokens);
		
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"@create","createRetailStoreOrderShippingGroup","createRetailStoreOrderShippingGroup/","main","primary");
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"@update","updateRetailStoreOrderShippingGroup","updateRetailStoreOrderShippingGroup/"+retailStoreOrderShippingGroup.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"@copy","cloneRetailStoreOrderShippingGroup","cloneRetailStoreOrderShippingGroup/"+retailStoreOrderShippingGroup.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"retail_store_order_shipping_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderShippingGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(RetailScmUserContext userContext,String name, String bizOrderId, double amount
) throws Exception
	{
		
		RetailStoreOrderShippingGroupManagerException exception = new RetailStoreOrderShippingGroupManagerException("Error Occured");

		

		checkNameOfRetailStoreOrderShippingGroup(userContext,  name, exception);
		checkAmountOfRetailStoreOrderShippingGroup(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup=createNewRetailStoreOrderShippingGroup();	

		retailStoreOrderShippingGroup.setName(name);
		RetailStoreOrder bizOrder = loadRetailStoreOrder(bizOrderId,emptyOptions());
		retailStoreOrderShippingGroup.setBizOrder(bizOrder);
		retailStoreOrderShippingGroup.setAmount(amount);

		return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, emptyOptions());
		

		
	}
	protected RetailStoreOrderShippingGroup createNewRetailStoreOrderShippingGroup() 
	{
		
		return new RetailStoreOrderShippingGroup();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderShippingGroup(RetailScmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderShippingGroupManagerException exception = new RetailStoreOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, exception);
		checkVersionOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupVersion, exception);
		

		if(RetailStoreOrderShippingGroup.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreOrderShippingGroup(userContext, parseString(newValueExpr), exception);
		}		

		
		if(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfRetailStoreOrderShippingGroup(userContext, parseDouble(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreOrderShippingGroup clone(RetailScmUserContext userContext, String fromRetailStoreOrderShippingGroupId) throws Exception{
		
		return this.getRetailStoreOrderShippingGroupDAO().clone(fromRetailStoreOrderShippingGroupId, this.allTokens());
	}
	
	public RetailStoreOrderShippingGroup updateRetailStoreOrderShippingGroup(RetailScmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, allTokens());
		if(retailStoreOrderShippingGroup.getVersion() != retailStoreOrderShippingGroupVersion){
			String message = "The target version("+retailStoreOrderShippingGroup.getVersion()+") is not equals to version("+retailStoreOrderShippingGroupVersion+") provided";
			throw new RetailStoreOrderShippingGroupManagerException(message);
		}
		synchronized(retailStoreOrderShippingGroup){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShippingGroup.
			
			retailStoreOrderShippingGroup.changePropery(property, newValueExpr);
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
			return present(userContext,retailStoreOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderShippingGroupTokens tokens(){
		return RetailStoreOrderShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderShippingGroupTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderShippingGroupTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String retailStoreOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		RetailStoreOrderShippingGroupManagerException exception = new RetailStoreOrderShippingGroupManagerException("Error Occured");
 		checkIdOfRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId,exception);
 		checkIdOfRetailStoreOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreOrderShippingGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String retailStoreOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderShippingGroupId,anotherBizOrderId);
 
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, allTokens());	
		synchronized(retailStoreOrderShippingGroup){
			//will be good when the retailStoreOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(anotherBizOrderId, emptyOptions());		
			retailStoreOrderShippingGroup.setBizOrder(bizOrder);		
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, emptyOptions());
			
			return present(userContext,retailStoreOrderShippingGroup, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreOrder loadRetailStoreOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception{
		getRetailStoreOrderShippingGroupDAO().delete(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderShippingGroupDAO().deleteAll();
	}


}


