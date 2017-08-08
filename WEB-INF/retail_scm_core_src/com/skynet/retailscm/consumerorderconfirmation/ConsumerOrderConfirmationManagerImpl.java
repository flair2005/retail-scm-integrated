
package com.skynet.retailscm.consumerorderconfirmation;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;









public class ConsumerOrderConfirmationManagerImpl extends RetailScmCheckerManager implements ConsumerOrderConfirmationManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderConfirmation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderConfirmationDAO  consumerOrderConfirmationDAO;
 	public void setConsumerOrderConfirmationDAO(ConsumerOrderConfirmationDAO  consumerOrderConfirmationDAO){
 	
 		if(consumerOrderConfirmationDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderConfirmationDAO to null.");
 		}
	 	this.consumerOrderConfirmationDAO = consumerOrderConfirmationDAO;
 	}
 	public ConsumerOrderConfirmationDAO getConsumerOrderConfirmationDAO(){
 		if(this.consumerOrderConfirmationDAO == null){
 			throw new IllegalStateException("The ConsumerOrderConfirmationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderConfirmationDAO;
 	}
 	
 	protected ConsumerOrderConfirmation saveConsumerOrderConfirmation(RetailScmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderConfirmationDAO().save(consumerOrderConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens);
 	}
 	
 	protected ConsumerOrderConfirmation saveConsumerOrderConfirmationDetail(RetailScmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation) throws Exception{	

 		
 		return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, allTokens());
 	}
 	
 	public ConsumerOrderConfirmation loadConsumerOrderConfirmation(RetailScmUserContext userContext, String consumerOrderConfirmationId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderConfirmationManagerException exception = new ConsumerOrderConfirmationManagerException("Error Occured");
		
		checkIdOfConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderConfirmation, tokens);
 	}
 	
 	protected ConsumerOrderConfirmation present(RetailScmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderConfirmation,tokens);
		
		
		return this.getConsumerOrderConfirmationDAO().present(consumerOrderConfirmation, tokens);
	}
 
 	
 	
 	public ConsumerOrderConfirmation loadConsumerOrderConfirmationDetail(RetailScmUserContext userContext, String consumerOrderConfirmationId) throws Exception{	
 		ConsumerOrderConfirmationManagerException exception = new ConsumerOrderConfirmationManagerException("Error Occured");
		
		checkIdOfConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, allTokens());

 		return present(userContext,consumerOrderConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderConfirmationId) throws Exception{	
 		ConsumerOrderConfirmationManagerException exception = new ConsumerOrderConfirmationManagerException("Error Occured");
		
		checkIdOfConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, allTokens());

 		return present(userContext,consumerOrderConfirmation, allTokens());
		
 	}
 	protected ConsumerOrderConfirmation saveConsumerOrderConfirmation(RetailScmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderConfirmationDAO().save(consumerOrderConfirmation, tokens);
 	}
 	protected ConsumerOrderConfirmation loadConsumerOrderConfirmation(RetailScmUserContext userContext, String consumerOrderConfirmationId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderConfirmationDAO().load(consumerOrderConfirmationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderConfirmation, tokens);
		
		addAction(userContext, consumerOrderConfirmation, tokens,"@create","createConsumerOrderConfirmation","createConsumerOrderConfirmation/","main","primary");
		addAction(userContext, consumerOrderConfirmation, tokens,"@update","updateConsumerOrderConfirmation","updateConsumerOrderConfirmation/"+consumerOrderConfirmation.getId()+"/","main","primary");
		addAction(userContext, consumerOrderConfirmation, tokens,"@copy","cloneConsumerOrderConfirmation","cloneConsumerOrderConfirmation/"+consumerOrderConfirmation.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderConfirmation createConsumerOrderConfirmation(RetailScmUserContext userContext,String who, Date confirmTime
) throws Exception
	{
		
		ConsumerOrderConfirmationManagerException exception = new ConsumerOrderConfirmationManagerException("Error Occured");

		

		checkWhoOfConsumerOrderConfirmation(userContext,  who, exception);
		checkConfirmTimeOfConsumerOrderConfirmation(userContext,  confirmTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrderConfirmation consumerOrderConfirmation=createNewConsumerOrderConfirmation();	

		consumerOrderConfirmation.setWho(who);
		consumerOrderConfirmation.setConfirmTime(confirmTime);

		return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, emptyOptions());
		

		
	}
	protected ConsumerOrderConfirmation createNewConsumerOrderConfirmation() 
	{
		
		return new ConsumerOrderConfirmation();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderConfirmation(RetailScmUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderConfirmationManagerException exception = new ConsumerOrderConfirmationManagerException("Error Occured");
		
		checkIdOfConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, exception);
		checkVersionOfConsumerOrderConfirmation(userContext, consumerOrderConfirmationVersion, exception);
		

		if(ConsumerOrderConfirmation.WHO_PROPERTY.equals(property)){
			checkWhoOfConsumerOrderConfirmation(userContext, parseString(newValueExpr), exception);
		}
		if(ConsumerOrderConfirmation.CONFIRM_TIME_PROPERTY.equals(property)){
			checkConfirmTimeOfConsumerOrderConfirmation(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ConsumerOrderConfirmation clone(RetailScmUserContext userContext, String fromConsumerOrderConfirmationId) throws Exception{
		
		return this.getConsumerOrderConfirmationDAO().clone(fromConsumerOrderConfirmationId, this.allTokens());
	}
	
	public ConsumerOrderConfirmation updateConsumerOrderConfirmation(RetailScmUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, allTokens());
		if(consumerOrderConfirmation.getVersion() != consumerOrderConfirmationVersion){
			String message = "The target version("+consumerOrderConfirmation.getVersion()+") is not equals to version("+consumerOrderConfirmationVersion+") provided";
			throw new ConsumerOrderConfirmationManagerException(message);
		}
		synchronized(consumerOrderConfirmation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderConfirmation.
			
			consumerOrderConfirmation.changePropery(property, newValueExpr);
			consumerOrderConfirmation = saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
			return present(userContext,consumerOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderConfirmationTokens tokens(){
		return ConsumerOrderConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderConfirmationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderConfirmationTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception{
		getConsumerOrderConfirmationDAO().delete(consumerOrderConfirmationId, consumerOrderConfirmationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderConfirmationDAO().deleteAll();
	}


}


