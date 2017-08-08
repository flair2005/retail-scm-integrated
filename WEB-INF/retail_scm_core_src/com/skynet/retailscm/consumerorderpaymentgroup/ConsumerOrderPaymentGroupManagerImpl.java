
package com.skynet.retailscm.consumerorderpaymentgroup;

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




public class ConsumerOrderPaymentGroupManagerImpl extends RetailScmCheckerManager implements ConsumerOrderPaymentGroupManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderPaymentGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderPaymentGroupDAO  consumerOrderPaymentGroupDAO;
 	public void setConsumerOrderPaymentGroupDAO(ConsumerOrderPaymentGroupDAO  consumerOrderPaymentGroupDAO){
 	
 		if(consumerOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderPaymentGroupDAO to null.");
 		}
	 	this.consumerOrderPaymentGroupDAO = consumerOrderPaymentGroupDAO;
 	}
 	public ConsumerOrderPaymentGroupDAO getConsumerOrderPaymentGroupDAO(){
 		if(this.consumerOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The ConsumerOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderPaymentGroupDAO;
 	}
 	
 	protected ConsumerOrderPaymentGroup saveConsumerOrderPaymentGroup(RetailScmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderPaymentGroupDAO().save(consumerOrderPaymentGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, tokens);
 	}
 	
 	protected ConsumerOrderPaymentGroup saveConsumerOrderPaymentGroupDetail(RetailScmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup) throws Exception{	

 		
 		return saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, allTokens());
 	}
 	
 	public ConsumerOrderPaymentGroup loadConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderPaymentGroupId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderPaymentGroupManagerException exception = new ConsumerOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup( userContext, consumerOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPaymentGroup, tokens);
 	}
 	
 	protected ConsumerOrderPaymentGroup present(RetailScmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderPaymentGroup,tokens);
		
		
		return this.getConsumerOrderPaymentGroupDAO().present(consumerOrderPaymentGroup, tokens);
	}
 
 	
 	
 	public ConsumerOrderPaymentGroup loadConsumerOrderPaymentGroupDetail(RetailScmUserContext userContext, String consumerOrderPaymentGroupId) throws Exception{	
 		ConsumerOrderPaymentGroupManagerException exception = new ConsumerOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup( userContext, consumerOrderPaymentGroupId, allTokens());

 		return present(userContext,consumerOrderPaymentGroup, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderPaymentGroupId) throws Exception{	
 		ConsumerOrderPaymentGroupManagerException exception = new ConsumerOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup( userContext, consumerOrderPaymentGroupId, allTokens());

 		return present(userContext,consumerOrderPaymentGroup, allTokens());
		
 	}
 	protected ConsumerOrderPaymentGroup saveConsumerOrderPaymentGroup(RetailScmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderPaymentGroupDAO().save(consumerOrderPaymentGroup, tokens);
 	}
 	protected ConsumerOrderPaymentGroup loadConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderPaymentGroupId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderPaymentGroupDAO().load(consumerOrderPaymentGroupId, tokens);
 	}

	



 	 
 	
 	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	//------------------------------------
 	public ConsumerOrderDAO getConsumerOrderDAO(){
	 	return this.consumerOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderPaymentGroup, tokens);
		
		addAction(userContext, consumerOrderPaymentGroup, tokens,"@create","createConsumerOrderPaymentGroup","createConsumerOrderPaymentGroup/","main","primary");
		addAction(userContext, consumerOrderPaymentGroup, tokens,"@update","updateConsumerOrderPaymentGroup","updateConsumerOrderPaymentGroup/"+consumerOrderPaymentGroup.getId()+"/","main","primary");
		addAction(userContext, consumerOrderPaymentGroup, tokens,"@copy","cloneConsumerOrderPaymentGroup","cloneConsumerOrderPaymentGroup/"+consumerOrderPaymentGroup.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderPaymentGroup, tokens,"consumer_order_payment_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderPaymentGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(RetailScmUserContext userContext,String name, String bizOrderId, String cardNumber
) throws Exception
	{
		
		ConsumerOrderPaymentGroupManagerException exception = new ConsumerOrderPaymentGroupManagerException("Error Occured");

		

		checkNameOfConsumerOrderPaymentGroup(userContext,  name, exception);
		checkCardNumberOfConsumerOrderPaymentGroup(userContext,  cardNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrderPaymentGroup consumerOrderPaymentGroup=createNewConsumerOrderPaymentGroup();	

		consumerOrderPaymentGroup.setName(name);
		ConsumerOrder bizOrder = loadConsumerOrder(bizOrderId,emptyOptions());
		consumerOrderPaymentGroup.setBizOrder(bizOrder);
		consumerOrderPaymentGroup.setCardNumber(cardNumber);

		return saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, emptyOptions());
		

		
	}
	protected ConsumerOrderPaymentGroup createNewConsumerOrderPaymentGroup() 
	{
		
		return new ConsumerOrderPaymentGroup();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderPaymentGroup(RetailScmUserContext userContext,String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderPaymentGroupManagerException exception = new ConsumerOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, exception);
		checkVersionOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupVersion, exception);
		

		if(ConsumerOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			checkNameOfConsumerOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}		

		
		if(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			checkCardNumberOfConsumerOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ConsumerOrderPaymentGroup clone(RetailScmUserContext userContext, String fromConsumerOrderPaymentGroupId) throws Exception{
		
		return this.getConsumerOrderPaymentGroupDAO().clone(fromConsumerOrderPaymentGroupId, this.allTokens());
	}
	
	public ConsumerOrderPaymentGroup updateConsumerOrderPaymentGroup(RetailScmUserContext userContext,String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, allTokens());
		if(consumerOrderPaymentGroup.getVersion() != consumerOrderPaymentGroupVersion){
			String message = "The target version("+consumerOrderPaymentGroup.getVersion()+") is not equals to version("+consumerOrderPaymentGroupVersion+") provided";
			throw new ConsumerOrderPaymentGroupManagerException(message);
		}
		synchronized(consumerOrderPaymentGroup){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPaymentGroup.
			
			consumerOrderPaymentGroup.changePropery(property, newValueExpr);
			consumerOrderPaymentGroup = saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, tokens().done());
			return present(userContext,consumerOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderPaymentGroupTokens tokens(){
		return ConsumerOrderPaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderPaymentGroupTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderPaymentGroupTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		ConsumerOrderPaymentGroupManagerException exception = new ConsumerOrderPaymentGroupManagerException("Error Occured");
 		checkIdOfConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId,exception);
 		checkIdOfConsumerOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ConsumerOrderPaymentGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderPaymentGroupId,anotherBizOrderId);
 
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, allTokens());	
		synchronized(consumerOrderPaymentGroup){
			//will be good when the consumerOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(anotherBizOrderId, emptyOptions());		
			consumerOrderPaymentGroup.setBizOrder(bizOrder);		
			consumerOrderPaymentGroup = saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, emptyOptions());
			
			return present(userContext,consumerOrderPaymentGroup, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected ConsumerOrder loadConsumerOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getConsumerOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion) throws Exception{
		getConsumerOrderPaymentGroupDAO().delete(consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderPaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderPaymentGroupDAO().deleteAll();
	}


}


