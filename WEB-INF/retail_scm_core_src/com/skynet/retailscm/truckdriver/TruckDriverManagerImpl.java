
package com.skynet.retailscm.truckdriver;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttask.TransportTask;

import com.skynet.retailscm.transportfleet.TransportFleetDAO;

import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.truckdriver.TruckDriver;


import com.skynet.retailscm.transportfleet.TransportFleetTable;
import com.skynet.retailscm.transporttask.TransportTaskTable;




public class TruckDriverManagerImpl extends RetailScmCheckerManager implements TruckDriverManager {
	
	private static final String SERVICE_TYPE = "TruckDriver";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  TruckDriverDAO  truckDriverDAO;
 	public void setTruckDriverDAO(TruckDriverDAO  truckDriverDAO){
 	
 		if(truckDriverDAO == null){
 			throw new IllegalStateException("Do not try to set truckDriverDAO to null.");
 		}
	 	this.truckDriverDAO = truckDriverDAO;
 	}
 	public TruckDriverDAO getTruckDriverDAO(){
 		if(this.truckDriverDAO == null){
 			throw new IllegalStateException("The TruckDriverDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.truckDriverDAO;
 	}
 	
 	protected TruckDriver saveTruckDriver(RetailScmUserContext userContext, TruckDriver truckDriver, String [] tokensExpr) throws Exception{	
 		//return getTruckDriverDAO().save(truckDriver, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTruckDriver(userContext, truckDriver, tokens);
 	}
 	
 	protected TruckDriver saveTruckDriverDetail(RetailScmUserContext userContext, TruckDriver truckDriver) throws Exception{	

 		
 		return saveTruckDriver(userContext, truckDriver, allTokens());
 	}
 	
 	public TruckDriver loadTruckDriver(RetailScmUserContext userContext, String truckDriverId, String [] tokensExpr) throws Exception{				
 
 		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");
		
		checkIdOfTruckDriver(userContext, truckDriverId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,truckDriver, tokens);
 	}
 	
 	protected TruckDriver present(RetailScmUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,truckDriver,tokens);
		
		
		return this.getTruckDriverDAO().present(truckDriver, tokens);
	}
 
 	
 	
 	public TruckDriver loadTruckDriverDetail(RetailScmUserContext userContext, String truckDriverId) throws Exception{	
 		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");
		
		checkIdOfTruckDriver(userContext, truckDriverId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, allTokens());

 		return present(userContext,truckDriver, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String truckDriverId) throws Exception{	
 		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");
		
		checkIdOfTruckDriver(userContext, truckDriverId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, allTokens());

 		return present(userContext,truckDriver, allTokens());
		
 	}
 	protected TruckDriver saveTruckDriver(RetailScmUserContext userContext, TruckDriver truckDriver, Map<String,Object>tokens) throws Exception{	
 		return getTruckDriverDAO().save(truckDriver, tokens);
 	}
 	protected TruckDriver loadTruckDriver(RetailScmUserContext userContext, String truckDriverId, Map<String,Object>tokens) throws Exception{	
 		return getTruckDriverDAO().load(truckDriverId, tokens);
 	}

	



 	 
 	
 	private  TransportFleetDAO  transportFleetDAO;
 	public void setTransportFleetDAO(TransportFleetDAO transportFleetDAO){
	 	this.transportFleetDAO = transportFleetDAO;
 	}
 	//------------------------------------
 	public TransportFleetDAO getTransportFleetDAO(){
	 	return this.transportFleetDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens){
		super.addActions(userContext, truckDriver, tokens);
		
		addAction(userContext, truckDriver, tokens,"@create","createTruckDriver","createTruckDriver/","main","primary");
		addAction(userContext, truckDriver, tokens,"@update","updateTruckDriver","updateTruckDriver/"+truckDriver.getId()+"/","main","primary");
		addAction(userContext, truckDriver, tokens,"@copy","cloneTruckDriver","cloneTruckDriver/"+truckDriver.getId()+"/","main","primary");
		
		addAction(userContext, truckDriver, tokens,"truck_driver.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+truckDriver.getId()+"/","main","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.addTransportTask","addTransportTask","addTransportTask/"+truckDriver.getId()+"/","transportTaskList","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.removeTransportTask","removeTransportTask","removeTransportTask/"+truckDriver.getId()+"/","transportTaskList","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.updateTransportTask","updateTransportTask","updateTransportTask/"+truckDriver.getId()+"/","transportTaskList","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+truckDriver.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TruckDriver createTruckDriver(RetailScmUserContext userContext,String name, String driverLicenseNumber, String contactNumber, String belongsToId
) throws Exception
	{
		
		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");

		

		checkNameOfTruckDriver(userContext,  name, exception);
		checkDriverLicenseNumberOfTruckDriver(userContext,  driverLicenseNumber, exception);
		checkContactNumberOfTruckDriver(userContext,  contactNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		TruckDriver truckDriver=createNewTruckDriver();	

		truckDriver.setName(name);
		truckDriver.setDriverLicenseNumber(driverLicenseNumber);
		truckDriver.setContactNumber(contactNumber);
		TransportFleet belongsTo = loadTransportFleet(belongsToId,emptyOptions());
		truckDriver.setBelongsTo(belongsTo);

		return saveTruckDriver(userContext, truckDriver, emptyOptions());
		

		
	}
	protected TruckDriver createNewTruckDriver() 
	{
		
		return new TruckDriver();		
	}
	
	protected void checkParamsForUpdatingTruckDriver(RetailScmUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");
		
		checkIdOfTruckDriver(userContext, truckDriverId, exception);
		checkVersionOfTruckDriver(userContext, truckDriverVersion, exception);
		

		if(TruckDriver.NAME_PROPERTY.equals(property)){
			checkNameOfTruckDriver(userContext, parseString(newValueExpr), exception);
		}
		if(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)){
			checkDriverLicenseNumberOfTruckDriver(userContext, parseString(newValueExpr), exception);
		}
		if(TruckDriver.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfTruckDriver(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public TruckDriver clone(RetailScmUserContext userContext, String fromTruckDriverId) throws Exception{
		
		return this.getTruckDriverDAO().clone(fromTruckDriverId, this.allTokens());
	}
	
	public TruckDriver updateTruckDriver(RetailScmUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTruckDriver(userContext, truckDriverId, truckDriverVersion, property, newValueExpr, tokensExpr);
		
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		if(truckDriver.getVersion() != truckDriverVersion){
			String message = "The target version("+truckDriver.getVersion()+") is not equals to version("+truckDriverVersion+") provided";
			throw new TruckDriverManagerException(message);
		}
		synchronized(truckDriver){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TruckDriver.
			
			truckDriver.changePropery(property, newValueExpr);
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
			//return saveTruckDriver(userContext, truckDriver, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TruckDriverTokens tokens(){
		return TruckDriverTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TruckDriverTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TruckDriverTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailScmUserContext userContext, String truckDriverId, String anotherBelongsToId) throws Exception
 	{
 		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");
 		checkIdOfTruckDriver(userContext, truckDriverId,exception);
 		checkIdOfTransportFleet(userContext, anotherBelongsToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TruckDriver transferToAnotherBelongsTo(RetailScmUserContext userContext, String truckDriverId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, truckDriverId,anotherBelongsToId);
 
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());	
		synchronized(truckDriver){
			//will be good when the truckDriver loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportFleet belongsTo = loadTransportFleet(anotherBelongsToId, emptyOptions());		
			truckDriver.setBelongsTo(belongsTo);		
			truckDriver = saveTruckDriver(userContext, truckDriver, emptyOptions());
			
			return present(userContext,truckDriver, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected TransportFleet loadTransportFleet(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return getTransportFleetDAO().load(newBelongsToId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String truckDriverId, int truckDriverVersion) throws Exception {
		
		deleteInternal(userContext, truckDriverId, truckDriverVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String truckDriverId, int truckDriverVersion) throws Exception{
		getTruckDriverDAO().delete(truckDriverId, truckDriverVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TruckDriverManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getTruckDriverDAO().deleteAll();
	}

	protected void checkParamsForAddingTransportTask(RetailScmUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");
		
		checkIdOfTruckDriver(userContext, truckDriverId, exception);

		checkNameOfTransportTask(userContext,  name, exception);
		checkStartOfTransportTask(userContext,  start, exception);
		checkBeginTimeOfTransportTask(userContext,  beginTime, exception);		
		
		checkIdOfRetailStore(userContext,  endId, exception);		
		
		checkIdOfTransportTruck(userContext,  truckId, exception);		
		
		checkIdOfTransportFleet(userContext,  belongsToId, exception);
		checkLatitudeOfTransportTask(userContext,  latitude, exception);
		checkLongitudeOfTransportTask(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TruckDriver addTransportTask(RetailScmUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,truckDriverId,name, start, beginTime, endId, truckId, belongsToId, latitude, longitude,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, endId, truckId, belongsToId, latitude, longitude);
		
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		synchronized(truckDriver){ 
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			truckDriver.addTransportTask( transportTask );		
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}
	}
	protected TransportTask createTransportTask(RetailScmUserContext userContext, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, double latitude, double longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		RetailStore  end = new RetailStore();
		end.setId(endId);		
		transportTask.setEnd(end);		
		TransportTruck  truck = new TransportTruck();
		truck.setId(truckId);		
		transportTask.setTruck(truck);		
		TransportFleet  belongsTo = new TransportFleet();
		belongsTo.setId(belongsToId);		
		transportTask.setBelongsTo(belongsTo);		
		transportTask.setLatitude(latitude);		
		transportTask.setLongitude(longitude);
	
		
		return transportTask;
	
		
	}
	
	protected TransportTask createIndexedTransportTask(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;			
		
	}
	protected void checkParamsForRemovingTransportTask(RetailScmUserContext userContext, String truckDriverId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		

		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");
		
		checkIdOfTruckDriver(userContext, truckDriverId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TruckDriver removeTransportTask(RetailScmUserContext userContext, String truckDriverId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,truckDriverId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		synchronized(truckDriver){ 
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			truckDriver.removeTransportTask( transportTask );		
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTransportTask(RetailScmUserContext userContext, String truckDriverId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		

		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");
		
		checkIdOfTruckDriver(userContext, truckDriverId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TruckDriver copyTransportTaskFrom(RetailScmUserContext userContext, String truckDriverId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,truckDriverId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		synchronized(truckDriver){ 
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			truckDriver.copyTransportTaskFrom( transportTask );		
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTransportTask(RetailScmUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TruckDriverManagerException exception = new TruckDriverManagerException("Error Occured");
		
		checkIdOfTruckDriver(userContext, truckDriverId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			checkNameOfTransportTask(userContext, parseString(newValueExpr), exception);
		}
		
		if(TransportTask.START_PROPERTY.equals(property)){
			checkStartOfTransportTask(userContext, parseString(newValueExpr), exception);
		}
		
		if(TransportTask.BEGIN_TIME_PROPERTY.equals(property)){
			checkBeginTimeOfTransportTask(userContext, parseDate(newValueExpr), exception);
		}
		
		if(TransportTask.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfTransportTask(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(TransportTask.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfTransportTask(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  TruckDriver updateTransportTask(RetailScmUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, truckDriverId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		
		synchronized(truckDriver){ 
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//truckDriver.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = truckDriver.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new TruckDriverManagerException(transportTask+"Not found" );
			}
			
			transportTask.changePropery(property, newValueExpr);

			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


