
package com.skynet.retailscm.transporttasktrack;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.transporttask.TransportTask;

import com.skynet.retailscm.transporttask.TransportTaskDAO;



import com.skynet.retailscm.transporttask.TransportTaskTable;




public class TransportTaskTrackManagerImpl extends RetailScmCheckerManager implements TransportTaskTrackManager {
	
	private static final String SERVICE_TYPE = "TransportTaskTrack";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  TransportTaskTrackDAO  transportTaskTrackDAO;
 	public void setTransportTaskTrackDAO(TransportTaskTrackDAO  transportTaskTrackDAO){
 	
 		if(transportTaskTrackDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskTrackDAO to null.");
 		}
	 	this.transportTaskTrackDAO = transportTaskTrackDAO;
 	}
 	public TransportTaskTrackDAO getTransportTaskTrackDAO(){
 		if(this.transportTaskTrackDAO == null){
 			throw new IllegalStateException("The TransportTaskTrackDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskTrackDAO;
 	}
 	
 	protected TransportTaskTrack saveTransportTaskTrack(RetailScmUserContext userContext, TransportTaskTrack transportTaskTrack, String [] tokensExpr) throws Exception{	
 		//return getTransportTaskTrackDAO().save(transportTaskTrack, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTaskTrack(userContext, transportTaskTrack, tokens);
 	}
 	
 	protected TransportTaskTrack saveTransportTaskTrackDetail(RetailScmUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception{	

 		
 		return saveTransportTaskTrack(userContext, transportTaskTrack, allTokens());
 	}
 	
 	public TransportTaskTrack loadTransportTaskTrack(RetailScmUserContext userContext, String transportTaskTrackId, String [] tokensExpr) throws Exception{				
 
 		TransportTaskTrackManagerException exception = new TransportTaskTrackManagerException("Error Occured");
		
		checkIdOfTransportTaskTrack(userContext, transportTaskTrackId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTaskTrack, tokens);
 	}
 	
 	protected TransportTaskTrack present(RetailScmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTaskTrack,tokens);
		
		
		return this.getTransportTaskTrackDAO().present(transportTaskTrack, tokens);
	}
 
 	
 	
 	public TransportTaskTrack loadTransportTaskTrackDetail(RetailScmUserContext userContext, String transportTaskTrackId) throws Exception{	
 		TransportTaskTrackManagerException exception = new TransportTaskTrackManagerException("Error Occured");
		
		checkIdOfTransportTaskTrack(userContext, transportTaskTrackId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, allTokens());

 		return present(userContext,transportTaskTrack, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String transportTaskTrackId) throws Exception{	
 		TransportTaskTrackManagerException exception = new TransportTaskTrackManagerException("Error Occured");
		
		checkIdOfTransportTaskTrack(userContext, transportTaskTrackId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, allTokens());

 		return present(userContext,transportTaskTrack, allTokens());
		
 	}
 	protected TransportTaskTrack saveTransportTaskTrack(RetailScmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String,Object>tokens) throws Exception{	
 		return getTransportTaskTrackDAO().save(transportTaskTrack, tokens);
 	}
 	protected TransportTaskTrack loadTransportTaskTrack(RetailScmUserContext userContext, String transportTaskTrackId, Map<String,Object>tokens) throws Exception{	
 		return getTransportTaskTrackDAO().load(transportTaskTrackId, tokens);
 	}

	



 	 
 	
 	private  TransportTaskDAO  transportTaskDAO;
 	public void setTransportTaskDAO(TransportTaskDAO transportTaskDAO){
	 	this.transportTaskDAO = transportTaskDAO;
 	}
 	//------------------------------------
 	public TransportTaskDAO getTransportTaskDAO(){
	 	return this.transportTaskDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens){
		super.addActions(userContext, transportTaskTrack, tokens);
		
		addAction(userContext, transportTaskTrack, tokens,"@create","createTransportTaskTrack","createTransportTaskTrack/","main","primary");
		addAction(userContext, transportTaskTrack, tokens,"@update","updateTransportTaskTrack","updateTransportTaskTrack/"+transportTaskTrack.getId()+"/","main","primary");
		addAction(userContext, transportTaskTrack, tokens,"@copy","cloneTransportTaskTrack","cloneTransportTaskTrack/"+transportTaskTrack.getId()+"/","main","primary");
		
		addAction(userContext, transportTaskTrack, tokens,"transport_task_track.transfer_to_movement","transferToAnotherMovement","transferToAnotherMovement/"+transportTaskTrack.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportTaskTrack createTransportTaskTrack(RetailScmUserContext userContext,Date trackTime, double latitude, double longitude, String movementId
) throws Exception
	{
		
		TransportTaskTrackManagerException exception = new TransportTaskTrackManagerException("Error Occured");

		

		checkTrackTimeOfTransportTaskTrack(userContext,  trackTime, exception);
		checkLatitudeOfTransportTaskTrack(userContext,  latitude, exception);
		checkLongitudeOfTransportTaskTrack(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		TransportTaskTrack transportTaskTrack=createNewTransportTaskTrack();	

		transportTaskTrack.setTrackTime(trackTime);
		transportTaskTrack.setLatitude(latitude);
		transportTaskTrack.setLongitude(longitude);
		TransportTask movement = loadTransportTask(movementId,emptyOptions());
		transportTaskTrack.setMovement(movement);

		return saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());
		

		
	}
	protected TransportTaskTrack createNewTransportTaskTrack() 
	{
		
		return new TransportTaskTrack();		
	}
	
	protected void checkParamsForUpdatingTransportTaskTrack(RetailScmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		TransportTaskTrackManagerException exception = new TransportTaskTrackManagerException("Error Occured");
		
		checkIdOfTransportTaskTrack(userContext, transportTaskTrackId, exception);
		checkVersionOfTransportTaskTrack(userContext, transportTaskTrackVersion, exception);
		

		if(TransportTaskTrack.TRACK_TIME_PROPERTY.equals(property)){
			checkTrackTimeOfTransportTaskTrack(userContext, parseDate(newValueExpr), exception);
		}
		if(TransportTaskTrack.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfTransportTaskTrack(userContext, parseDouble(newValueExpr), exception);
		}
		if(TransportTaskTrack.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfTransportTaskTrack(userContext, parseDouble(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public TransportTaskTrack clone(RetailScmUserContext userContext, String fromTransportTaskTrackId) throws Exception{
		
		return this.getTransportTaskTrackDAO().clone(fromTransportTaskTrackId, this.allTokens());
	}
	
	public TransportTaskTrack updateTransportTaskTrack(RetailScmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);
		
		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
		if(transportTaskTrack.getVersion() != transportTaskTrackVersion){
			String message = "The target version("+transportTaskTrack.getVersion()+") is not equals to version("+transportTaskTrackVersion+") provided";
			throw new TransportTaskTrackManagerException(message);
		}
		synchronized(transportTaskTrack){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.
			
			transportTaskTrack.changePropery(property, newValueExpr);
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
			return present(userContext,transportTaskTrack, mergedAllTokens(tokensExpr));
			//return saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportTaskTrackTokens tokens(){
		return TransportTaskTrackTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTaskTrackTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTaskTrackTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherMovement(RetailScmUserContext userContext, String transportTaskTrackId, String anotherMovementId) throws Exception
 	{
 		TransportTaskTrackManagerException exception = new TransportTaskTrackManagerException("Error Occured");
 		checkIdOfTransportTaskTrack(userContext, transportTaskTrackId,exception);
 		checkIdOfTransportTask(userContext, anotherMovementId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TransportTaskTrack transferToAnotherMovement(RetailScmUserContext userContext, String transportTaskTrackId, String anotherMovementId) throws Exception
 	{
 		checkParamsForTransferingAnotherMovement(userContext, transportTaskTrackId,anotherMovementId);
 
		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());	
		synchronized(transportTaskTrack){
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportTask movement = loadTransportTask(anotherMovementId, emptyOptions());		
			transportTaskTrack.setMovement(movement);		
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());
			
			return present(userContext,transportTaskTrack, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected TransportTask loadTransportTask(String newMovementId, Map<String,Object> options) throws Exception
 	{
		
 		return getTransportTaskDAO().load(newMovementId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String transportTaskTrackId, int transportTaskTrackVersion) throws Exception {
		
		deleteInternal(userContext, transportTaskTrackId, transportTaskTrackVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String transportTaskTrackId, int transportTaskTrackVersion) throws Exception{
		getTransportTaskTrackDAO().delete(transportTaskTrackId, transportTaskTrackVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTaskTrackManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getTransportTaskTrackDAO().deleteAll();
	}


}


