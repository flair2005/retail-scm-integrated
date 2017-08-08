
package com.skynet.retailscm.transporttruck;

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




public class TransportTruckManagerImpl extends RetailScmCheckerManager implements TransportTruckManager {
	
	private static final String SERVICE_TYPE = "TransportTruck";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  TransportTruckDAO  transportTruckDAO;
 	public void setTransportTruckDAO(TransportTruckDAO  transportTruckDAO){
 	
 		if(transportTruckDAO == null){
 			throw new IllegalStateException("Do not try to set transportTruckDAO to null.");
 		}
	 	this.transportTruckDAO = transportTruckDAO;
 	}
 	public TransportTruckDAO getTransportTruckDAO(){
 		if(this.transportTruckDAO == null){
 			throw new IllegalStateException("The TransportTruckDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTruckDAO;
 	}
 	
 	protected TransportTruck saveTransportTruck(RetailScmUserContext userContext, TransportTruck transportTruck, String [] tokensExpr) throws Exception{	
 		//return getTransportTruckDAO().save(transportTruck, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTruck(userContext, transportTruck, tokens);
 	}
 	
 	protected TransportTruck saveTransportTruckDetail(RetailScmUserContext userContext, TransportTruck transportTruck) throws Exception{	

 		
 		return saveTransportTruck(userContext, transportTruck, allTokens());
 	}
 	
 	public TransportTruck loadTransportTruck(RetailScmUserContext userContext, String transportTruckId, String [] tokensExpr) throws Exception{				
 
 		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");
		
		checkIdOfTransportTruck(userContext, transportTruckId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTruck transportTruck = loadTransportTruck( userContext, transportTruckId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTruck, tokens);
 	}
 	
 	protected TransportTruck present(RetailScmUserContext userContext, TransportTruck transportTruck, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTruck,tokens);
		
		
		return this.getTransportTruckDAO().present(transportTruck, tokens);
	}
 
 	
 	
 	public TransportTruck loadTransportTruckDetail(RetailScmUserContext userContext, String transportTruckId) throws Exception{	
 		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");
		
		checkIdOfTransportTruck(userContext, transportTruckId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TransportTruck transportTruck = loadTransportTruck( userContext, transportTruckId, allTokens());

 		return present(userContext,transportTruck, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String transportTruckId) throws Exception{	
 		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");
		
		checkIdOfTransportTruck(userContext, transportTruckId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TransportTruck transportTruck = loadTransportTruck( userContext, transportTruckId, allTokens());

 		return present(userContext,transportTruck, allTokens());
		
 	}
 	protected TransportTruck saveTransportTruck(RetailScmUserContext userContext, TransportTruck transportTruck, Map<String,Object>tokens) throws Exception{	
 		return getTransportTruckDAO().save(transportTruck, tokens);
 	}
 	protected TransportTruck loadTransportTruck(RetailScmUserContext userContext, String transportTruckId, Map<String,Object>tokens) throws Exception{	
 		return getTransportTruckDAO().load(transportTruckId, tokens);
 	}

	



 	 
 	
 	private  TransportFleetDAO  transportFleetDAO;
 	public void setTransportFleetDAO(TransportFleetDAO transportFleetDAO){
	 	this.transportFleetDAO = transportFleetDAO;
 	}
 	//------------------------------------
 	public TransportFleetDAO getTransportFleetDAO(){
	 	return this.transportFleetDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TransportTruck transportTruck, Map<String, Object> tokens){
		super.addActions(userContext, transportTruck, tokens);
		
		addAction(userContext, transportTruck, tokens,"@create","createTransportTruck","createTransportTruck/","main","primary");
		addAction(userContext, transportTruck, tokens,"@update","updateTransportTruck","updateTransportTruck/"+transportTruck.getId()+"/","main","primary");
		addAction(userContext, transportTruck, tokens,"@copy","cloneTransportTruck","cloneTransportTruck/"+transportTruck.getId()+"/","main","primary");
		
		addAction(userContext, transportTruck, tokens,"transport_truck.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+transportTruck.getId()+"/","main","primary");
		addAction(userContext, transportTruck, tokens,"transport_truck.addTransportTask","addTransportTask","addTransportTask/"+transportTruck.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportTruck, tokens,"transport_truck.removeTransportTask","removeTransportTask","removeTransportTask/"+transportTruck.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportTruck, tokens,"transport_truck.updateTransportTask","updateTransportTask","updateTransportTask/"+transportTruck.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportTruck, tokens,"transport_truck.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+transportTruck.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TransportTruck transportTruck, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportTruck createTransportTruck(RetailScmUserContext userContext,String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor, String ownerId
) throws Exception
	{
		
		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");

		

		checkNameOfTransportTruck(userContext,  name, exception);
		checkPlateNumberOfTransportTruck(userContext,  plateNumber, exception);
		checkContactNumberOfTransportTruck(userContext,  contactNumber, exception);
		checkVehicleLicenseNumberOfTransportTruck(userContext,  vehicleLicenseNumber, exception);
		checkEngineNumberOfTransportTruck(userContext,  engineNumber, exception);
		checkMakeDateOfTransportTruck(userContext,  makeDate, exception);
		checkMileageOfTransportTruck(userContext,  mileage, exception);
		checkBodyColorOfTransportTruck(userContext,  bodyColor, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		TransportTruck transportTruck=createNewTransportTruck();	

		transportTruck.setName(name);
		transportTruck.setPlateNumber(plateNumber);
		transportTruck.setContactNumber(contactNumber);
		transportTruck.setVehicleLicenseNumber(vehicleLicenseNumber);
		transportTruck.setEngineNumber(engineNumber);
		transportTruck.setMakeDate(makeDate);
		transportTruck.setMileage(mileage);
		transportTruck.setBodyColor(bodyColor);
		TransportFleet owner = loadTransportFleet(ownerId,emptyOptions());
		transportTruck.setOwner(owner);

		return saveTransportTruck(userContext, transportTruck, emptyOptions());
		

		
	}
	protected TransportTruck createNewTransportTruck() 
	{
		
		return new TransportTruck();		
	}
	
	protected void checkParamsForUpdatingTransportTruck(RetailScmUserContext userContext,String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");
		
		checkIdOfTransportTruck(userContext, transportTruckId, exception);
		checkVersionOfTransportTruck(userContext, transportTruckVersion, exception);
		

		if(TransportTruck.NAME_PROPERTY.equals(property)){
			checkNameOfTransportTruck(userContext, parseString(newValueExpr), exception);
		}
		if(TransportTruck.PLATE_NUMBER_PROPERTY.equals(property)){
			checkPlateNumberOfTransportTruck(userContext, parseString(newValueExpr), exception);
		}
		if(TransportTruck.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfTransportTruck(userContext, parseString(newValueExpr), exception);
		}
		if(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY.equals(property)){
			checkVehicleLicenseNumberOfTransportTruck(userContext, parseString(newValueExpr), exception);
		}
		if(TransportTruck.ENGINE_NUMBER_PROPERTY.equals(property)){
			checkEngineNumberOfTransportTruck(userContext, parseString(newValueExpr), exception);
		}
		if(TransportTruck.MAKE_DATE_PROPERTY.equals(property)){
			checkMakeDateOfTransportTruck(userContext, parseDate(newValueExpr), exception);
		}
		if(TransportTruck.MILEAGE_PROPERTY.equals(property)){
			checkMileageOfTransportTruck(userContext, parseString(newValueExpr), exception);
		}
		if(TransportTruck.BODY_COLOR_PROPERTY.equals(property)){
			checkBodyColorOfTransportTruck(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public TransportTruck clone(RetailScmUserContext userContext, String fromTransportTruckId) throws Exception{
		
		return this.getTransportTruckDAO().clone(fromTransportTruckId, this.allTokens());
	}
	
	public TransportTruck updateTransportTruck(RetailScmUserContext userContext,String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTruck(userContext, transportTruckId, transportTruckVersion, property, newValueExpr, tokensExpr);
		
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		if(transportTruck.getVersion() != transportTruckVersion){
			String message = "The target version("+transportTruck.getVersion()+") is not equals to version("+transportTruckVersion+") provided";
			throw new TransportTruckManagerException(message);
		}
		synchronized(transportTruck){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTruck.
			
			transportTruck.changePropery(property, newValueExpr);
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().done());
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
			//return saveTransportTruck(userContext, transportTruck, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportTruckTokens tokens(){
		return TransportTruckTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTruckTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTruckTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String transportTruckId, String anotherOwnerId) throws Exception
 	{
 		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");
 		checkIdOfTransportTruck(userContext, transportTruckId,exception);
 		checkIdOfTransportFleet(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TransportTruck transferToAnotherOwner(RetailScmUserContext userContext, String transportTruckId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, transportTruckId,anotherOwnerId);
 
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());	
		synchronized(transportTruck){
			//will be good when the transportTruck loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportFleet owner = loadTransportFleet(anotherOwnerId, emptyOptions());		
			transportTruck.setOwner(owner);		
			transportTruck = saveTransportTruck(userContext, transportTruck, emptyOptions());
			
			return present(userContext,transportTruck, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected TransportFleet loadTransportFleet(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getTransportFleetDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String transportTruckId, int transportTruckVersion) throws Exception {
		
		deleteInternal(userContext, transportTruckId, transportTruckVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String transportTruckId, int transportTruckVersion) throws Exception{
		getTransportTruckDAO().delete(transportTruckId, transportTruckVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTruckManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getTransportTruckDAO().deleteAll();
	}

	protected void checkParamsForAddingTransportTask(RetailScmUserContext userContext, String transportTruckId, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");
		
		checkIdOfTransportTruck(userContext, transportTruckId, exception);

		checkNameOfTransportTask(userContext,  name, exception);
		checkStartOfTransportTask(userContext,  start, exception);
		checkBeginTimeOfTransportTask(userContext,  beginTime, exception);		
		
		checkIdOfRetailStore(userContext,  endId, exception);		
		
		checkIdOfTruckDriver(userContext,  driverId, exception);		
		
		checkIdOfTransportFleet(userContext,  belongsToId, exception);
		checkLatitudeOfTransportTask(userContext,  latitude, exception);
		checkLongitudeOfTransportTask(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TransportTruck addTransportTask(RetailScmUserContext userContext, String transportTruckId, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,transportTruckId,name, start, beginTime, endId, driverId, belongsToId, latitude, longitude,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, endId, driverId, belongsToId, latitude, longitude);
		
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		synchronized(transportTruck){ 
			//Will be good when the transportTruck loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTruck.addTransportTask( transportTask );		
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
		}
	}
	protected TransportTask createTransportTask(RetailScmUserContext userContext, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, double latitude, double longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		RetailStore  end = new RetailStore();
		end.setId(endId);		
		transportTask.setEnd(end);		
		TruckDriver  driver = new TruckDriver();
		driver.setId(driverId);		
		transportTask.setDriver(driver);		
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
	protected void checkParamsForRemovingTransportTask(RetailScmUserContext userContext, String transportTruckId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		

		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");
		
		checkIdOfTransportTruck(userContext, transportTruckId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportTruck removeTransportTask(RetailScmUserContext userContext, String transportTruckId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,transportTruckId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		synchronized(transportTruck){ 
			//Will be good when the transportTruck loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTruck.removeTransportTask( transportTask );		
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTransportTask(RetailScmUserContext userContext, String transportTruckId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		

		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");
		
		checkIdOfTransportTruck(userContext, transportTruckId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportTruck copyTransportTaskFrom(RetailScmUserContext userContext, String transportTruckId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,transportTruckId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		synchronized(transportTruck){ 
			//Will be good when the transportTruck loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTruck.copyTransportTaskFrom( transportTask );		
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTransportTask(RetailScmUserContext userContext, String transportTruckId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TransportTruckManagerException exception = new TransportTruckManagerException("Error Occured");
		
		checkIdOfTransportTruck(userContext, transportTruckId, exception);
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
	
	public  TransportTruck updateTransportTask(RetailScmUserContext userContext, String transportTruckId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, transportTruckId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		
		synchronized(transportTruck){ 
			//Will be good when the transportTruck loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportTruck.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = transportTruck.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new TransportTruckManagerException(transportTask+"Not found" );
			}
			
			transportTask.changePropery(property, newValueExpr);

			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


