
package com.skynet.retailscm.consumerorderpriceadjustment;

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




public class ConsumerOrderPriceAdjustmentManagerImpl extends RetailScmCheckerManager implements ConsumerOrderPriceAdjustmentManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderPriceAdjustment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderPriceAdjustmentDAO  consumerOrderPriceAdjustmentDAO;
 	public void setConsumerOrderPriceAdjustmentDAO(ConsumerOrderPriceAdjustmentDAO  consumerOrderPriceAdjustmentDAO){
 	
 		if(consumerOrderPriceAdjustmentDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderPriceAdjustmentDAO to null.");
 		}
	 	this.consumerOrderPriceAdjustmentDAO = consumerOrderPriceAdjustmentDAO;
 	}
 	public ConsumerOrderPriceAdjustmentDAO getConsumerOrderPriceAdjustmentDAO(){
 		if(this.consumerOrderPriceAdjustmentDAO == null){
 			throw new IllegalStateException("The ConsumerOrderPriceAdjustmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderPriceAdjustmentDAO;
 	}
 	
 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(RetailScmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderPriceAdjustmentDAO().save(consumerOrderPriceAdjustment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens);
 	}
 	
 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustmentDetail(RetailScmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) throws Exception{	

 		
 		return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, allTokens());
 	}
 	
 	public ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderPriceAdjustmentId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderPriceAdjustmentManagerException exception = new ConsumerOrderPriceAdjustmentManagerException("Error Occured");
		
		checkIdOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPriceAdjustment, tokens);
 	}
 	
 	protected ConsumerOrderPriceAdjustment present(RetailScmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderPriceAdjustment,tokens);
		
		
		return this.getConsumerOrderPriceAdjustmentDAO().present(consumerOrderPriceAdjustment, tokens);
	}
 
 	
 	
 	public ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustmentDetail(RetailScmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{	
 		ConsumerOrderPriceAdjustmentManagerException exception = new ConsumerOrderPriceAdjustmentManagerException("Error Occured");
		
		checkIdOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, allTokens());

 		return present(userContext,consumerOrderPriceAdjustment, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{	
 		ConsumerOrderPriceAdjustmentManagerException exception = new ConsumerOrderPriceAdjustmentManagerException("Error Occured");
		
		checkIdOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, allTokens());

 		return present(userContext,consumerOrderPriceAdjustment, allTokens());
		
 	}
 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(RetailScmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderPriceAdjustmentDAO().save(consumerOrderPriceAdjustment, tokens);
 	}
 	protected ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderPriceAdjustmentId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderPriceAdjustmentDAO().load(consumerOrderPriceAdjustmentId, tokens);
 	}

	



 	 
 	
 	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	//------------------------------------
 	public ConsumerOrderDAO getConsumerOrderDAO(){
	 	return this.consumerOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderPriceAdjustment, tokens);
		
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@create","createConsumerOrderPriceAdjustment","createConsumerOrderPriceAdjustment/","main","primary");
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@update","updateConsumerOrderPriceAdjustment","updateConsumerOrderPriceAdjustment/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@copy","cloneConsumerOrderPriceAdjustment","cloneConsumerOrderPriceAdjustment/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"consumer_order_price_adjustment.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(RetailScmUserContext userContext,String name, String bizOrderId, double amount, String provider
) throws Exception
	{
		
		ConsumerOrderPriceAdjustmentManagerException exception = new ConsumerOrderPriceAdjustmentManagerException("Error Occured");

		

		checkNameOfConsumerOrderPriceAdjustment(userContext,  name, exception);
		checkAmountOfConsumerOrderPriceAdjustment(userContext,  amount, exception);
		checkProviderOfConsumerOrderPriceAdjustment(userContext,  provider, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment=createNewConsumerOrderPriceAdjustment();	

		consumerOrderPriceAdjustment.setName(name);
		ConsumerOrder bizOrder = loadConsumerOrder(bizOrderId,emptyOptions());
		consumerOrderPriceAdjustment.setBizOrder(bizOrder);
		consumerOrderPriceAdjustment.setAmount(amount);
		consumerOrderPriceAdjustment.setProvider(provider);

		return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, emptyOptions());
		

		
	}
	protected ConsumerOrderPriceAdjustment createNewConsumerOrderPriceAdjustment() 
	{
		
		return new ConsumerOrderPriceAdjustment();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderPriceAdjustment(RetailScmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderPriceAdjustmentManagerException exception = new ConsumerOrderPriceAdjustmentManagerException("Error Occured");
		
		checkIdOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, exception);
		checkVersionOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentVersion, exception);
		

		if(ConsumerOrderPriceAdjustment.NAME_PROPERTY.equals(property)){
			checkNameOfConsumerOrderPriceAdjustment(userContext, parseString(newValueExpr), exception);
		}		

		
		if(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfConsumerOrderPriceAdjustment(userContext, parseDouble(newValueExpr), exception);
		}
		if(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY.equals(property)){
			checkProviderOfConsumerOrderPriceAdjustment(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ConsumerOrderPriceAdjustment clone(RetailScmUserContext userContext, String fromConsumerOrderPriceAdjustmentId) throws Exception{
		
		return this.getConsumerOrderPriceAdjustmentDAO().clone(fromConsumerOrderPriceAdjustmentId, this.allTokens());
	}
	
	public ConsumerOrderPriceAdjustment updateConsumerOrderPriceAdjustment(RetailScmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());
		if(consumerOrderPriceAdjustment.getVersion() != consumerOrderPriceAdjustmentVersion){
			String message = "The target version("+consumerOrderPriceAdjustment.getVersion()+") is not equals to version("+consumerOrderPriceAdjustmentVersion+") provided";
			throw new ConsumerOrderPriceAdjustmentManagerException(message);
		}
		synchronized(consumerOrderPriceAdjustment){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.
			
			consumerOrderPriceAdjustment.changePropery(property, newValueExpr);
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
			return present(userContext,consumerOrderPriceAdjustment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderPriceAdjustmentTokens tokens(){
		return ConsumerOrderPriceAdjustmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderPriceAdjustmentTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderPriceAdjustmentTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId) throws Exception
 	{
 		ConsumerOrderPriceAdjustmentManagerException exception = new ConsumerOrderPriceAdjustmentManagerException("Error Occured");
 		checkIdOfConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId,exception);
 		checkIdOfConsumerOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ConsumerOrderPriceAdjustment transferToAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderPriceAdjustmentId,anotherBizOrderId);
 
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());	
		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(anotherBizOrderId, emptyOptions());		
			consumerOrderPriceAdjustment.setBizOrder(bizOrder);		
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, emptyOptions());
			
			return present(userContext,consumerOrderPriceAdjustment, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected ConsumerOrder loadConsumerOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getConsumerOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception{
		getConsumerOrderPriceAdjustmentDAO().delete(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderPriceAdjustmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderPriceAdjustmentDAO().deleteAll();
	}


}


