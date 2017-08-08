
package com.skynet.retailscm.retailstoreorderpaymentgroup;

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




public class RetailStoreOrderPaymentGroupManagerImpl extends RetailScmCheckerManager implements RetailStoreOrderPaymentGroupManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderPaymentGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreOrderPaymentGroupDAO  retailStoreOrderPaymentGroupDAO;
 	public void setRetailStoreOrderPaymentGroupDAO(RetailStoreOrderPaymentGroupDAO  retailStoreOrderPaymentGroupDAO){
 	
 		if(retailStoreOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderPaymentGroupDAO to null.");
 		}
	 	this.retailStoreOrderPaymentGroupDAO = retailStoreOrderPaymentGroupDAO;
 	}
 	public RetailStoreOrderPaymentGroupDAO getRetailStoreOrderPaymentGroupDAO(){
 		if(this.retailStoreOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The RetailStoreOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderPaymentGroupDAO;
 	}
 	
 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderPaymentGroupDAO().save(retailStoreOrderPaymentGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens);
 	}
 	
 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroupDetail(RetailScmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) throws Exception{	

 		
 		return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, allTokens());
 	}
 	
 	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderPaymentGroupId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreOrderPaymentGroupManagerException exception = new RetailStoreOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPaymentGroup, tokens);
 	}
 	
 	protected RetailStoreOrderPaymentGroup present(RetailScmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderPaymentGroup,tokens);
		
		
		return this.getRetailStoreOrderPaymentGroupDAO().present(retailStoreOrderPaymentGroup, tokens);
	}
 
 	
 	
 	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroupDetail(RetailScmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{	
 		RetailStoreOrderPaymentGroupManagerException exception = new RetailStoreOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, allTokens());

 		return present(userContext,retailStoreOrderPaymentGroup, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{	
 		RetailStoreOrderPaymentGroupManagerException exception = new RetailStoreOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, allTokens());

 		return present(userContext,retailStoreOrderPaymentGroup, allTokens());
		
 	}
 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderPaymentGroupDAO().save(retailStoreOrderPaymentGroup, tokens);
 	}
 	protected RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderPaymentGroupId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreOrderPaymentGroupDAO().load(retailStoreOrderPaymentGroupId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	//------------------------------------
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
	 	return this.retailStoreOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderPaymentGroup, tokens);
		
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@create","createRetailStoreOrderPaymentGroup","createRetailStoreOrderPaymentGroup/","main","primary");
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@update","updateRetailStoreOrderPaymentGroup","updateRetailStoreOrderPaymentGroup/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@copy","cloneRetailStoreOrderPaymentGroup","cloneRetailStoreOrderPaymentGroup/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"retail_store_order_payment_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(RetailScmUserContext userContext,String name, String bizOrderId, String cardNumber
) throws Exception
	{
		
		RetailStoreOrderPaymentGroupManagerException exception = new RetailStoreOrderPaymentGroupManagerException("Error Occured");

		

		checkNameOfRetailStoreOrderPaymentGroup(userContext,  name, exception);
		checkCardNumberOfRetailStoreOrderPaymentGroup(userContext,  cardNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup=createNewRetailStoreOrderPaymentGroup();	

		retailStoreOrderPaymentGroup.setName(name);
		RetailStoreOrder bizOrder = loadRetailStoreOrder(bizOrderId,emptyOptions());
		retailStoreOrderPaymentGroup.setBizOrder(bizOrder);
		retailStoreOrderPaymentGroup.setCardNumber(cardNumber);

		return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, emptyOptions());
		

		
	}
	protected RetailStoreOrderPaymentGroup createNewRetailStoreOrderPaymentGroup() 
	{
		
		return new RetailStoreOrderPaymentGroup();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderPaymentGroup(RetailScmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreOrderPaymentGroupManagerException exception = new RetailStoreOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, exception);
		checkVersionOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupVersion, exception);
		

		if(RetailStoreOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}		

		
		if(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			checkCardNumberOfRetailStoreOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreOrderPaymentGroup clone(RetailScmUserContext userContext, String fromRetailStoreOrderPaymentGroupId) throws Exception{
		
		return this.getRetailStoreOrderPaymentGroupDAO().clone(fromRetailStoreOrderPaymentGroupId, this.allTokens());
	}
	
	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroup(RetailScmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());
		if(retailStoreOrderPaymentGroup.getVersion() != retailStoreOrderPaymentGroupVersion){
			String message = "The target version("+retailStoreOrderPaymentGroup.getVersion()+") is not equals to version("+retailStoreOrderPaymentGroupVersion+") provided";
			throw new RetailStoreOrderPaymentGroupManagerException(message);
		}
		synchronized(retailStoreOrderPaymentGroup){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.
			
			retailStoreOrderPaymentGroup.changePropery(property, newValueExpr);
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
			return present(userContext,retailStoreOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderPaymentGroupTokens tokens(){
		return RetailStoreOrderPaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderPaymentGroupTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderPaymentGroupTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		RetailStoreOrderPaymentGroupManagerException exception = new RetailStoreOrderPaymentGroupManagerException("Error Occured");
 		checkIdOfRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId,exception);
 		checkIdOfRetailStoreOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreOrderPaymentGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderPaymentGroupId,anotherBizOrderId);
 
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());	
		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(anotherBizOrderId, emptyOptions());		
			retailStoreOrderPaymentGroup.setBizOrder(bizOrder);		
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, emptyOptions());
			
			return present(userContext,retailStoreOrderPaymentGroup, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreOrder loadRetailStoreOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception{
		getRetailStoreOrderPaymentGroupDAO().delete(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderPaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreOrderPaymentGroupDAO().deleteAll();
	}


}


