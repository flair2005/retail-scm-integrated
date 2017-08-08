
package com.skynet.retailscm.consumerorderapproval;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;









public class ConsumerOrderApprovalManagerImpl extends RetailScmCheckerManager implements ConsumerOrderApprovalManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderApproval";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderApprovalDAO  consumerOrderApprovalDAO;
 	public void setConsumerOrderApprovalDAO(ConsumerOrderApprovalDAO  consumerOrderApprovalDAO){
 	
 		if(consumerOrderApprovalDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderApprovalDAO to null.");
 		}
	 	this.consumerOrderApprovalDAO = consumerOrderApprovalDAO;
 	}
 	public ConsumerOrderApprovalDAO getConsumerOrderApprovalDAO(){
 		if(this.consumerOrderApprovalDAO == null){
 			throw new IllegalStateException("The ConsumerOrderApprovalDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderApprovalDAO;
 	}
 	
 	protected ConsumerOrderApproval saveConsumerOrderApproval(RetailScmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderApprovalDAO().save(consumerOrderApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderApproval(userContext, consumerOrderApproval, tokens);
 	}
 	
 	protected ConsumerOrderApproval saveConsumerOrderApprovalDetail(RetailScmUserContext userContext, ConsumerOrderApproval consumerOrderApproval) throws Exception{	

 		
 		return saveConsumerOrderApproval(userContext, consumerOrderApproval, allTokens());
 	}
 	
 	public ConsumerOrderApproval loadConsumerOrderApproval(RetailScmUserContext userContext, String consumerOrderApprovalId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderApprovalManagerException exception = new ConsumerOrderApprovalManagerException("Error Occured");
		
		checkIdOfConsumerOrderApproval(userContext, consumerOrderApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval( userContext, consumerOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderApproval, tokens);
 	}
 	
 	protected ConsumerOrderApproval present(RetailScmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderApproval,tokens);
		
		
		return this.getConsumerOrderApprovalDAO().present(consumerOrderApproval, tokens);
	}
 
 	
 	
 	public ConsumerOrderApproval loadConsumerOrderApprovalDetail(RetailScmUserContext userContext, String consumerOrderApprovalId) throws Exception{	
 		ConsumerOrderApprovalManagerException exception = new ConsumerOrderApprovalManagerException("Error Occured");
		
		checkIdOfConsumerOrderApproval(userContext, consumerOrderApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval( userContext, consumerOrderApprovalId, allTokens());

 		return present(userContext,consumerOrderApproval, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderApprovalId) throws Exception{	
 		ConsumerOrderApprovalManagerException exception = new ConsumerOrderApprovalManagerException("Error Occured");
		
		checkIdOfConsumerOrderApproval(userContext, consumerOrderApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval( userContext, consumerOrderApprovalId, allTokens());

 		return present(userContext,consumerOrderApproval, allTokens());
		
 	}
 	protected ConsumerOrderApproval saveConsumerOrderApproval(RetailScmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderApprovalDAO().save(consumerOrderApproval, tokens);
 	}
 	protected ConsumerOrderApproval loadConsumerOrderApproval(RetailScmUserContext userContext, String consumerOrderApprovalId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderApprovalDAO().load(consumerOrderApprovalId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderApproval, tokens);
		
		addAction(userContext, consumerOrderApproval, tokens,"@create","createConsumerOrderApproval","createConsumerOrderApproval/","main","primary");
		addAction(userContext, consumerOrderApproval, tokens,"@update","updateConsumerOrderApproval","updateConsumerOrderApproval/"+consumerOrderApproval.getId()+"/","main","primary");
		addAction(userContext, consumerOrderApproval, tokens,"@copy","cloneConsumerOrderApproval","cloneConsumerOrderApproval/"+consumerOrderApproval.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderApproval createConsumerOrderApproval(RetailScmUserContext userContext,String who, Date approveTime
) throws Exception
	{
		
		ConsumerOrderApprovalManagerException exception = new ConsumerOrderApprovalManagerException("Error Occured");

		

		checkWhoOfConsumerOrderApproval(userContext,  who, exception);
		checkApproveTimeOfConsumerOrderApproval(userContext,  approveTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrderApproval consumerOrderApproval=createNewConsumerOrderApproval();	

		consumerOrderApproval.setWho(who);
		consumerOrderApproval.setApproveTime(approveTime);

		return saveConsumerOrderApproval(userContext, consumerOrderApproval, emptyOptions());
		

		
	}
	protected ConsumerOrderApproval createNewConsumerOrderApproval() 
	{
		
		return new ConsumerOrderApproval();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderApproval(RetailScmUserContext userContext,String consumerOrderApprovalId, int consumerOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderApprovalManagerException exception = new ConsumerOrderApprovalManagerException("Error Occured");
		
		checkIdOfConsumerOrderApproval(userContext, consumerOrderApprovalId, exception);
		checkVersionOfConsumerOrderApproval(userContext, consumerOrderApprovalVersion, exception);
		

		if(ConsumerOrderApproval.WHO_PROPERTY.equals(property)){
			checkWhoOfConsumerOrderApproval(userContext, parseString(newValueExpr), exception);
		}
		if(ConsumerOrderApproval.APPROVE_TIME_PROPERTY.equals(property)){
			checkApproveTimeOfConsumerOrderApproval(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ConsumerOrderApproval clone(RetailScmUserContext userContext, String fromConsumerOrderApprovalId) throws Exception{
		
		return this.getConsumerOrderApprovalDAO().clone(fromConsumerOrderApprovalId, this.allTokens());
	}
	
	public ConsumerOrderApproval updateConsumerOrderApproval(RetailScmUserContext userContext,String consumerOrderApprovalId, int consumerOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderApproval(userContext, consumerOrderApprovalId, consumerOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval(userContext, consumerOrderApprovalId, allTokens());
		if(consumerOrderApproval.getVersion() != consumerOrderApprovalVersion){
			String message = "The target version("+consumerOrderApproval.getVersion()+") is not equals to version("+consumerOrderApprovalVersion+") provided";
			throw new ConsumerOrderApprovalManagerException(message);
		}
		synchronized(consumerOrderApproval){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderApproval.
			
			consumerOrderApproval.changePropery(property, newValueExpr);
			consumerOrderApproval = saveConsumerOrderApproval(userContext, consumerOrderApproval, tokens().done());
			return present(userContext,consumerOrderApproval, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderApproval(userContext, consumerOrderApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderApprovalTokens tokens(){
		return ConsumerOrderApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderApprovalTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderApprovalTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String consumerOrderApprovalId, int consumerOrderApprovalVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderApprovalId, consumerOrderApprovalVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderApprovalId, int consumerOrderApprovalVersion) throws Exception{
		getConsumerOrderApprovalDAO().delete(consumerOrderApprovalId, consumerOrderApprovalVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderApprovalDAO().deleteAll();
	}


}


