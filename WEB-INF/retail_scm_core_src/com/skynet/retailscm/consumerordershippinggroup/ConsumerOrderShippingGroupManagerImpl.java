
package com.skynet.retailscm.consumerordershippinggroup;

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




public class ConsumerOrderShippingGroupManagerImpl extends RetailScmCheckerManager implements ConsumerOrderShippingGroupManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderShippingGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderShippingGroupDAO  consumerOrderShippingGroupDAO;
 	public void setConsumerOrderShippingGroupDAO(ConsumerOrderShippingGroupDAO  consumerOrderShippingGroupDAO){
 	
 		if(consumerOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderShippingGroupDAO to null.");
 		}
	 	this.consumerOrderShippingGroupDAO = consumerOrderShippingGroupDAO;
 	}
 	public ConsumerOrderShippingGroupDAO getConsumerOrderShippingGroupDAO(){
 		if(this.consumerOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The ConsumerOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderShippingGroupDAO;
 	}
 	
 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(RetailScmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderShippingGroupDAO().save(consumerOrderShippingGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens);
 	}
 	
 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroupDetail(RetailScmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup) throws Exception{	

 		
 		return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, allTokens());
 	}
 	
 	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderShippingGroupId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderShippingGroupManagerException exception = new ConsumerOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShippingGroup, tokens);
 	}
 	
 	protected ConsumerOrderShippingGroup present(RetailScmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderShippingGroup,tokens);
		
		
		return this.getConsumerOrderShippingGroupDAO().present(consumerOrderShippingGroup, tokens);
	}
 
 	
 	
 	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroupDetail(RetailScmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{	
 		ConsumerOrderShippingGroupManagerException exception = new ConsumerOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, allTokens());

 		return present(userContext,consumerOrderShippingGroup, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{	
 		ConsumerOrderShippingGroupManagerException exception = new ConsumerOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, allTokens());

 		return present(userContext,consumerOrderShippingGroup, allTokens());
		
 	}
 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(RetailScmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderShippingGroupDAO().save(consumerOrderShippingGroup, tokens);
 	}
 	protected ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderShippingGroupId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderShippingGroupDAO().load(consumerOrderShippingGroupId, tokens);
 	}

	



 	 
 	
 	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	//------------------------------------
 	public ConsumerOrderDAO getConsumerOrderDAO(){
	 	return this.consumerOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderShippingGroup, tokens);
		
		addAction(userContext, consumerOrderShippingGroup, tokens,"@create","createConsumerOrderShippingGroup","createConsumerOrderShippingGroup/","main","primary");
		addAction(userContext, consumerOrderShippingGroup, tokens,"@update","updateConsumerOrderShippingGroup","updateConsumerOrderShippingGroup/"+consumerOrderShippingGroup.getId()+"/","main","primary");
		addAction(userContext, consumerOrderShippingGroup, tokens,"@copy","cloneConsumerOrderShippingGroup","cloneConsumerOrderShippingGroup/"+consumerOrderShippingGroup.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderShippingGroup, tokens,"consumer_order_shipping_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderShippingGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(RetailScmUserContext userContext,String name, String bizOrderId, double amount
) throws Exception
	{
		
		ConsumerOrderShippingGroupManagerException exception = new ConsumerOrderShippingGroupManagerException("Error Occured");

		

		checkNameOfConsumerOrderShippingGroup(userContext,  name, exception);
		checkAmountOfConsumerOrderShippingGroup(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrderShippingGroup consumerOrderShippingGroup=createNewConsumerOrderShippingGroup();	

		consumerOrderShippingGroup.setName(name);
		ConsumerOrder bizOrder = loadConsumerOrder(bizOrderId,emptyOptions());
		consumerOrderShippingGroup.setBizOrder(bizOrder);
		consumerOrderShippingGroup.setAmount(amount);

		return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, emptyOptions());
		

		
	}
	protected ConsumerOrderShippingGroup createNewConsumerOrderShippingGroup() 
	{
		
		return new ConsumerOrderShippingGroup();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderShippingGroup(RetailScmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderShippingGroupManagerException exception = new ConsumerOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, exception);
		checkVersionOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupVersion, exception);
		

		if(ConsumerOrderShippingGroup.NAME_PROPERTY.equals(property)){
			checkNameOfConsumerOrderShippingGroup(userContext, parseString(newValueExpr), exception);
		}		

		
		if(ConsumerOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfConsumerOrderShippingGroup(userContext, parseDouble(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ConsumerOrderShippingGroup clone(RetailScmUserContext userContext, String fromConsumerOrderShippingGroupId) throws Exception{
		
		return this.getConsumerOrderShippingGroupDAO().clone(fromConsumerOrderShippingGroupId, this.allTokens());
	}
	
	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroup(RetailScmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());
		if(consumerOrderShippingGroup.getVersion() != consumerOrderShippingGroupVersion){
			String message = "The target version("+consumerOrderShippingGroup.getVersion()+") is not equals to version("+consumerOrderShippingGroupVersion+") provided";
			throw new ConsumerOrderShippingGroupManagerException(message);
		}
		synchronized(consumerOrderShippingGroup){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.
			
			consumerOrderShippingGroup.changePropery(property, newValueExpr);
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
			return present(userContext,consumerOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderShippingGroupTokens tokens(){
		return ConsumerOrderShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderShippingGroupTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderShippingGroupTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		ConsumerOrderShippingGroupManagerException exception = new ConsumerOrderShippingGroupManagerException("Error Occured");
 		checkIdOfConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId,exception);
 		checkIdOfConsumerOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ConsumerOrderShippingGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderShippingGroupId,anotherBizOrderId);
 
		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());	
		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(anotherBizOrderId, emptyOptions());		
			consumerOrderShippingGroup.setBizOrder(bizOrder);		
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, emptyOptions());
			
			return present(userContext,consumerOrderShippingGroup, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected ConsumerOrder loadConsumerOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getConsumerOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception{
		getConsumerOrderShippingGroupDAO().delete(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderShippingGroupDAO().deleteAll();
	}


}


