
package com.skynet.retailscm.consumerorderdelivery;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;









public class ConsumerOrderDeliveryManagerImpl extends RetailScmCheckerManager implements ConsumerOrderDeliveryManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderDelivery";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderDeliveryDAO  consumerOrderDeliveryDAO;
 	public void setConsumerOrderDeliveryDAO(ConsumerOrderDeliveryDAO  consumerOrderDeliveryDAO){
 	
 		if(consumerOrderDeliveryDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderDeliveryDAO to null.");
 		}
	 	this.consumerOrderDeliveryDAO = consumerOrderDeliveryDAO;
 	}
 	public ConsumerOrderDeliveryDAO getConsumerOrderDeliveryDAO(){
 		if(this.consumerOrderDeliveryDAO == null){
 			throw new IllegalStateException("The ConsumerOrderDeliveryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderDeliveryDAO;
 	}
 	
 	protected ConsumerOrderDelivery saveConsumerOrderDelivery(RetailScmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderDeliveryDAO().save(consumerOrderDelivery, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderDelivery(userContext, consumerOrderDelivery, tokens);
 	}
 	
 	protected ConsumerOrderDelivery saveConsumerOrderDeliveryDetail(RetailScmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery) throws Exception{	

 		
 		return saveConsumerOrderDelivery(userContext, consumerOrderDelivery, allTokens());
 	}
 	
 	public ConsumerOrderDelivery loadConsumerOrderDelivery(RetailScmUserContext userContext, String consumerOrderDeliveryId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderDeliveryManagerException exception = new ConsumerOrderDeliveryManagerException("Error Occured");
		
		checkIdOfConsumerOrderDelivery(userContext, consumerOrderDeliveryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery( userContext, consumerOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderDelivery, tokens);
 	}
 	
 	protected ConsumerOrderDelivery present(RetailScmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderDelivery,tokens);
		
		
		return this.getConsumerOrderDeliveryDAO().present(consumerOrderDelivery, tokens);
	}
 
 	
 	
 	public ConsumerOrderDelivery loadConsumerOrderDeliveryDetail(RetailScmUserContext userContext, String consumerOrderDeliveryId) throws Exception{	
 		ConsumerOrderDeliveryManagerException exception = new ConsumerOrderDeliveryManagerException("Error Occured");
		
		checkIdOfConsumerOrderDelivery(userContext, consumerOrderDeliveryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery( userContext, consumerOrderDeliveryId, allTokens());

 		return present(userContext,consumerOrderDelivery, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderDeliveryId) throws Exception{	
 		ConsumerOrderDeliveryManagerException exception = new ConsumerOrderDeliveryManagerException("Error Occured");
		
		checkIdOfConsumerOrderDelivery(userContext, consumerOrderDeliveryId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery( userContext, consumerOrderDeliveryId, allTokens());

 		return present(userContext,consumerOrderDelivery, allTokens());
		
 	}
 	protected ConsumerOrderDelivery saveConsumerOrderDelivery(RetailScmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderDeliveryDAO().save(consumerOrderDelivery, tokens);
 	}
 	protected ConsumerOrderDelivery loadConsumerOrderDelivery(RetailScmUserContext userContext, String consumerOrderDeliveryId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderDeliveryDAO().load(consumerOrderDeliveryId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderDelivery, tokens);
		
		addAction(userContext, consumerOrderDelivery, tokens,"@create","createConsumerOrderDelivery","createConsumerOrderDelivery/","main","primary");
		addAction(userContext, consumerOrderDelivery, tokens,"@update","updateConsumerOrderDelivery","updateConsumerOrderDelivery/"+consumerOrderDelivery.getId()+"/","main","primary");
		addAction(userContext, consumerOrderDelivery, tokens,"@copy","cloneConsumerOrderDelivery","cloneConsumerOrderDelivery/"+consumerOrderDelivery.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderDelivery createConsumerOrderDelivery(RetailScmUserContext userContext,String who, Date deliveryTime
) throws Exception
	{
		
		ConsumerOrderDeliveryManagerException exception = new ConsumerOrderDeliveryManagerException("Error Occured");

		

		checkWhoOfConsumerOrderDelivery(userContext,  who, exception);
		checkDeliveryTimeOfConsumerOrderDelivery(userContext,  deliveryTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrderDelivery consumerOrderDelivery=createNewConsumerOrderDelivery();	

		consumerOrderDelivery.setWho(who);
		consumerOrderDelivery.setDeliveryTime(deliveryTime);

		return saveConsumerOrderDelivery(userContext, consumerOrderDelivery, emptyOptions());
		

		
	}
	protected ConsumerOrderDelivery createNewConsumerOrderDelivery() 
	{
		
		return new ConsumerOrderDelivery();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderDelivery(RetailScmUserContext userContext,String consumerOrderDeliveryId, int consumerOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderDeliveryManagerException exception = new ConsumerOrderDeliveryManagerException("Error Occured");
		
		checkIdOfConsumerOrderDelivery(userContext, consumerOrderDeliveryId, exception);
		checkVersionOfConsumerOrderDelivery(userContext, consumerOrderDeliveryVersion, exception);
		

		if(ConsumerOrderDelivery.WHO_PROPERTY.equals(property)){
			checkWhoOfConsumerOrderDelivery(userContext, parseString(newValueExpr), exception);
		}
		if(ConsumerOrderDelivery.DELIVERY_TIME_PROPERTY.equals(property)){
			checkDeliveryTimeOfConsumerOrderDelivery(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ConsumerOrderDelivery clone(RetailScmUserContext userContext, String fromConsumerOrderDeliveryId) throws Exception{
		
		return this.getConsumerOrderDeliveryDAO().clone(fromConsumerOrderDeliveryId, this.allTokens());
	}
	
	public ConsumerOrderDelivery updateConsumerOrderDelivery(RetailScmUserContext userContext,String consumerOrderDeliveryId, int consumerOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderDelivery(userContext, consumerOrderDeliveryId, consumerOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery(userContext, consumerOrderDeliveryId, allTokens());
		if(consumerOrderDelivery.getVersion() != consumerOrderDeliveryVersion){
			String message = "The target version("+consumerOrderDelivery.getVersion()+") is not equals to version("+consumerOrderDeliveryVersion+") provided";
			throw new ConsumerOrderDeliveryManagerException(message);
		}
		synchronized(consumerOrderDelivery){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderDelivery.
			
			consumerOrderDelivery.changePropery(property, newValueExpr);
			consumerOrderDelivery = saveConsumerOrderDelivery(userContext, consumerOrderDelivery, tokens().done());
			return present(userContext,consumerOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderDelivery(userContext, consumerOrderDelivery, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderDeliveryTokens tokens(){
		return ConsumerOrderDeliveryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderDeliveryTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderDeliveryTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String consumerOrderDeliveryId, int consumerOrderDeliveryVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderDeliveryId, consumerOrderDeliveryVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderDeliveryId, int consumerOrderDeliveryVersion) throws Exception{
		getConsumerOrderDeliveryDAO().delete(consumerOrderDeliveryId, consumerOrderDeliveryVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderDeliveryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderDeliveryDAO().deleteAll();
	}


}


