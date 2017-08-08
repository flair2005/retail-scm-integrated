
package com.skynet.retailscm.consumerordershipment;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;









public class ConsumerOrderShipmentManagerImpl extends RetailScmCheckerManager implements ConsumerOrderShipmentManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderShipment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ConsumerOrderShipmentDAO  consumerOrderShipmentDAO;
 	public void setConsumerOrderShipmentDAO(ConsumerOrderShipmentDAO  consumerOrderShipmentDAO){
 	
 		if(consumerOrderShipmentDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderShipmentDAO to null.");
 		}
	 	this.consumerOrderShipmentDAO = consumerOrderShipmentDAO;
 	}
 	public ConsumerOrderShipmentDAO getConsumerOrderShipmentDAO(){
 		if(this.consumerOrderShipmentDAO == null){
 			throw new IllegalStateException("The ConsumerOrderShipmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderShipmentDAO;
 	}
 	
 	protected ConsumerOrderShipment saveConsumerOrderShipment(RetailScmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderShipmentDAO().save(consumerOrderShipment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens);
 	}
 	
 	protected ConsumerOrderShipment saveConsumerOrderShipmentDetail(RetailScmUserContext userContext, ConsumerOrderShipment consumerOrderShipment) throws Exception{	

 		
 		return saveConsumerOrderShipment(userContext, consumerOrderShipment, allTokens());
 	}
 	
 	public ConsumerOrderShipment loadConsumerOrderShipment(RetailScmUserContext userContext, String consumerOrderShipmentId, String [] tokensExpr) throws Exception{				
 
 		ConsumerOrderShipmentManagerException exception = new ConsumerOrderShipmentManagerException("Error Occured");
		
		checkIdOfConsumerOrderShipment(userContext, consumerOrderShipmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShipment, tokens);
 	}
 	
 	protected ConsumerOrderShipment present(RetailScmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderShipment,tokens);
		
		
		return this.getConsumerOrderShipmentDAO().present(consumerOrderShipment, tokens);
	}
 
 	
 	
 	public ConsumerOrderShipment loadConsumerOrderShipmentDetail(RetailScmUserContext userContext, String consumerOrderShipmentId) throws Exception{	
 		ConsumerOrderShipmentManagerException exception = new ConsumerOrderShipmentManagerException("Error Occured");
		
		checkIdOfConsumerOrderShipment(userContext, consumerOrderShipmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, allTokens());

 		return present(userContext,consumerOrderShipment, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String consumerOrderShipmentId) throws Exception{	
 		ConsumerOrderShipmentManagerException exception = new ConsumerOrderShipmentManagerException("Error Occured");
		
		checkIdOfConsumerOrderShipment(userContext, consumerOrderShipmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, allTokens());

 		return present(userContext,consumerOrderShipment, allTokens());
		
 	}
 	protected ConsumerOrderShipment saveConsumerOrderShipment(RetailScmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderShipmentDAO().save(consumerOrderShipment, tokens);
 	}
 	protected ConsumerOrderShipment loadConsumerOrderShipment(RetailScmUserContext userContext, String consumerOrderShipmentId, Map<String,Object>tokens) throws Exception{	
 		return getConsumerOrderShipmentDAO().load(consumerOrderShipmentId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderShipment, tokens);
		
		addAction(userContext, consumerOrderShipment, tokens,"@create","createConsumerOrderShipment","createConsumerOrderShipment/","main","primary");
		addAction(userContext, consumerOrderShipment, tokens,"@update","updateConsumerOrderShipment","updateConsumerOrderShipment/"+consumerOrderShipment.getId()+"/","main","primary");
		addAction(userContext, consumerOrderShipment, tokens,"@copy","cloneConsumerOrderShipment","cloneConsumerOrderShipment/"+consumerOrderShipment.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderShipment createConsumerOrderShipment(RetailScmUserContext userContext,String who, Date shipTime
) throws Exception
	{
		
		ConsumerOrderShipmentManagerException exception = new ConsumerOrderShipmentManagerException("Error Occured");

		

		checkWhoOfConsumerOrderShipment(userContext,  who, exception);
		checkShipTimeOfConsumerOrderShipment(userContext,  shipTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ConsumerOrderShipment consumerOrderShipment=createNewConsumerOrderShipment();	

		consumerOrderShipment.setWho(who);
		consumerOrderShipment.setShipTime(shipTime);

		return saveConsumerOrderShipment(userContext, consumerOrderShipment, emptyOptions());
		

		
	}
	protected ConsumerOrderShipment createNewConsumerOrderShipment() 
	{
		
		return new ConsumerOrderShipment();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderShipment(RetailScmUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ConsumerOrderShipmentManagerException exception = new ConsumerOrderShipmentManagerException("Error Occured");
		
		checkIdOfConsumerOrderShipment(userContext, consumerOrderShipmentId, exception);
		checkVersionOfConsumerOrderShipment(userContext, consumerOrderShipmentVersion, exception);
		

		if(ConsumerOrderShipment.WHO_PROPERTY.equals(property)){
			checkWhoOfConsumerOrderShipment(userContext, parseString(newValueExpr), exception);
		}
		if(ConsumerOrderShipment.SHIP_TIME_PROPERTY.equals(property)){
			checkShipTimeOfConsumerOrderShipment(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ConsumerOrderShipment clone(RetailScmUserContext userContext, String fromConsumerOrderShipmentId) throws Exception{
		
		return this.getConsumerOrderShipmentDAO().clone(fromConsumerOrderShipmentId, this.allTokens());
	}
	
	public ConsumerOrderShipment updateConsumerOrderShipment(RetailScmUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderShipment(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment(userContext, consumerOrderShipmentId, allTokens());
		if(consumerOrderShipment.getVersion() != consumerOrderShipmentVersion){
			String message = "The target version("+consumerOrderShipment.getVersion()+") is not equals to version("+consumerOrderShipmentVersion+") provided";
			throw new ConsumerOrderShipmentManagerException(message);
		}
		synchronized(consumerOrderShipment){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShipment.
			
			consumerOrderShipment.changePropery(property, newValueExpr);
			consumerOrderShipment = saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
			return present(userContext,consumerOrderShipment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderShipmentTokens tokens(){
		return ConsumerOrderShipmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderShipmentTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderShipmentTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception {
		
		deleteInternal(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception{
		getConsumerOrderShipmentDAO().delete(consumerOrderShipmentId, consumerOrderShipmentVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderShipmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getConsumerOrderShipmentDAO().deleteAll();
	}


}


