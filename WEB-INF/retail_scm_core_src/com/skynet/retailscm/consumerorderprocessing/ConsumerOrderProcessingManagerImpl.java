
package com.skynet.retailscm.consumerorderprocessing;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;









public class ConsumerOrderProcessingManagerImpl extends RetailScmCheckerManager implements ConsumerOrderProcessingManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderProcessing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderProcessingDAO  consumerOrderProcessingDAO;
 	public void setConsumerOrderProcessingDAO(ConsumerOrderProcessingDAO  consumerOrderProcessingDAO){
 	
 		if(consumerOrderProcessingDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderProcessingDAO to null.");
 		}
	 	this.consumerOrderProcessingDAO = consumerOrderProcessingDAO;
 	}
 	public ConsumerOrderProcessingDAO getConsumerOrderProcessingDAO(){
 		if(this.consumerOrderProcessingDAO == null){
 			throw new IllegalStateException("The ConsumerOrderProcessingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderProcessingDAO;
 	}
 	
 	protected ConsumerOrderProcessing saveConsumerOrderProcessing(RetailScmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderProcessingDAO().save(consumerOrderProcessing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens);
 	}
 	
 	protected ConsumerOrderProcessing saveConsumerOrderProcessingDetail(RetailScmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing) throws Exception{	

 		
 		return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, allTokens());
 	}
 	
 	public ConsumerOrderProcessing loadConsumerOrderProcessing(RetailScmUserContext userContext, String consumerOrderProcessingId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderProcessingManagerException exception = new ConsumerOrderProcessingManagerException("Error Occured");
		
		checkIdOfConsumerOrderProcessing(userContext, consumerOrderProcessingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderProcessing, tokens);
 	}
 	
 	protected ConsumerOrderProcessing present(RetailScmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderProcessing,tokens);
		
		
		return this.getConsumerOrderProcessingDAO().present(consumerOrderProcessing, tokens);
	}
 
 	
 	
 	public ConsumerOrderProcessing loadConsumerOrderProcessingDetail(RetailScmUserContext userContext, String consumerOrderProcessingId) throws Exception{	
 		ConsumerOrderProcessingManagerException exception = new ConsumerOrderProcessingManagerException("Error Occured");
		
		checkIdOfConsumerOrderProcessing(userContext, consumerOrderProcessingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, allTokens());

 		return present(userContext,consumerOrderProcessing, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderProcessingId) throws Exception{	
 		ConsumerOrderProcessingManagerException exception = new ConsumerOrderProcessingManagerException("Error Occured");
		
		checkIdOfConsumerOrderProcessing(userContext, consumerOrderProcessingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, allTokens());

 		return present(userContext,consumerOrderProcessing, allTokens());
		
 	}
 	protected ConsumerOrderProcessing saveConsumerOrderProcessing(RetailScmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderProcessingDAO().save(consumerOrderProcessing, tokens);
 	}
 	protected ConsumerOrderProcessing loadConsumerOrderProcessing(RetailScmUserContext userContext, String consumerOrderProcessingId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderProcessingDAO().load(consumerOrderProcessingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderProcessing, tokens);
		
		addAction(userContext, consumerOrderProcessing, tokens,"@create","createConsumerOrderProcessing","createConsumerOrderProcessing/","main","primary");
		addAction(userContext, consumerOrderProcessing, tokens,"@update","updateConsumerOrderProcessing","updateConsumerOrderProcessing/"+consumerOrderProcessing.getId()+"/","main","primary");
		addAction(userContext, consumerOrderProcessing, tokens,"@copy","cloneConsumerOrderProcessing","cloneConsumerOrderProcessing/"+consumerOrderProcessing.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderProcessing createConsumerOrderProcessing(RetailScmUserContext userContext,String who, Date processTime
) throws Exception
	{
		
		ConsumerOrderProcessingManagerException exception = new ConsumerOrderProcessingManagerException("Error Occured");

		

		checkWhoOfConsumerOrderProcessing(userContext,  who, exception);
		checkProcessTimeOfConsumerOrderProcessing(userContext,  processTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrderProcessing consumerOrderProcessing=createNewConsumerOrderProcessing();	

		consumerOrderProcessing.setWho(who);
		consumerOrderProcessing.setProcessTime(processTime);

		return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, emptyOptions());
		

		
	}
	protected ConsumerOrderProcessing createNewConsumerOrderProcessing() 
	{
		
		return new ConsumerOrderProcessing();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderProcessing(RetailScmUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderProcessingManagerException exception = new ConsumerOrderProcessingManagerException("Error Occured");
		
		checkIdOfConsumerOrderProcessing(userContext, consumerOrderProcessingId, exception);
		checkVersionOfConsumerOrderProcessing(userContext, consumerOrderProcessingVersion, exception);
		

		if(ConsumerOrderProcessing.WHO_PROPERTY.equals(property)){
			checkWhoOfConsumerOrderProcessing(userContext, parseString(newValueExpr), exception);
		}
		if(ConsumerOrderProcessing.PROCESS_TIME_PROPERTY.equals(property)){
			checkProcessTimeOfConsumerOrderProcessing(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ConsumerOrderProcessing clone(RetailScmUserContext userContext, String fromConsumerOrderProcessingId) throws Exception{
		
		return this.getConsumerOrderProcessingDAO().clone(fromConsumerOrderProcessingId, this.allTokens());
	}
	
	public ConsumerOrderProcessing updateConsumerOrderProcessing(RetailScmUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderProcessing(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing(userContext, consumerOrderProcessingId, allTokens());
		if(consumerOrderProcessing.getVersion() != consumerOrderProcessingVersion){
			String message = "The target version("+consumerOrderProcessing.getVersion()+") is not equals to version("+consumerOrderProcessingVersion+") provided";
			throw new ConsumerOrderProcessingManagerException(message);
		}
		synchronized(consumerOrderProcessing){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderProcessing.
			
			consumerOrderProcessing.changePropery(property, newValueExpr);
			consumerOrderProcessing = saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
			return present(userContext,consumerOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderProcessingTokens tokens(){
		return ConsumerOrderProcessingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderProcessingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderProcessingTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception{
		getConsumerOrderProcessingDAO().delete(consumerOrderProcessingId, consumerOrderProcessingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderProcessingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderProcessingDAO().deleteAll();
	}


}


