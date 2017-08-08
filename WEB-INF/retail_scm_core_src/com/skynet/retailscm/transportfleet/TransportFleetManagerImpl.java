
package com.skynet.retailscm.transportfleet;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.truckdriver.TruckDriver;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.truckdriver.TruckDriver;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.truckdriver.TruckDriverTable;
import com.skynet.retailscm.transporttruck.TransportTruckTable;
import com.skynet.retailscm.transporttask.TransportTaskTable;




public class TransportFleetManagerImpl extends RetailScmCheckerManager implements TransportFleetManager {
	
	private static final String SERVICE_TYPE = "TransportFleet";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  TransportFleetDAO  transportFleetDAO;
 	public void setTransportFleetDAO(TransportFleetDAO  transportFleetDAO){
 	
 		if(transportFleetDAO == null){
 			throw new IllegalStateException("Do not try to set transportFleetDAO to null.");
 		}
	 	this.transportFleetDAO = transportFleetDAO;
 	}
 	public TransportFleetDAO getTransportFleetDAO(){
 		if(this.transportFleetDAO == null){
 			throw new IllegalStateException("The TransportFleetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportFleetDAO;
 	}
 	
 	protected TransportFleet saveTransportFleet(RetailScmUserContext userContext, TransportFleet transportFleet, String [] tokensExpr) throws Exception{	
 		//return getTransportFleetDAO().save(transportFleet, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportFleet(userContext, transportFleet, tokens);
 	}
 	
 	protected TransportFleet saveTransportFleetDetail(RetailScmUserContext userContext, TransportFleet transportFleet) throws Exception{	

 		
 		return saveTransportFleet(userContext, transportFleet, allTokens());
 	}
 	
 	public TransportFleet loadTransportFleet(RetailScmUserContext userContext, String transportFleetId, String [] tokensExpr) throws Exception{				
 
 		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportFleet, tokens);
 	}
 	
 	protected TransportFleet present(RetailScmUserContext userContext, TransportFleet transportFleet, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportFleet,tokens);
		
		
		return this.getTransportFleetDAO().present(transportFleet, tokens);
	}
 
 	
 	
 	public TransportFleet loadTransportFleetDetail(RetailScmUserContext userContext, String transportFleetId) throws Exception{	
 		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, allTokens());

 		return present(userContext,transportFleet, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String transportFleetId) throws Exception{	
 		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, allTokens());

 		return present(userContext,transportFleet, allTokens());
		
 	}
 	protected TransportFleet saveTransportFleet(RetailScmUserContext userContext, TransportFleet transportFleet, Map<String,Object>tokens) throws Exception{	
 		return getTransportFleetDAO().save(transportFleet, tokens);
 	}
 	protected TransportFleet loadTransportFleet(RetailScmUserContext userContext, String transportFleetId, Map<String,Object>tokens) throws Exception{	
 		return getTransportFleetDAO().load(transportFleetId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TransportFleet transportFleet, Map<String, Object> tokens){
		super.addActions(userContext, transportFleet, tokens);
		
		addAction(userContext, transportFleet, tokens,"@create","createTransportFleet","createTransportFleet/","main","primary");
		addAction(userContext, transportFleet, tokens,"@update","updateTransportFleet","updateTransportFleet/"+transportFleet.getId()+"/","main","primary");
		addAction(userContext, transportFleet, tokens,"@copy","cloneTransportFleet","cloneTransportFleet/"+transportFleet.getId()+"/","main","primary");
		
		addAction(userContext, transportFleet, tokens,"transport_fleet.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+transportFleet.getId()+"/","main","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.addTransportTruck","addTransportTruck","addTransportTruck/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.removeTransportTruck","removeTransportTruck","removeTransportTruck/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.updateTransportTruck","updateTransportTruck","updateTransportTruck/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.copyTransportTruckFrom","copyTransportTruckFrom","copyTransportTruckFrom/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.addTruckDriver","addTruckDriver","addTruckDriver/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.removeTruckDriver","removeTruckDriver","removeTruckDriver/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.updateTruckDriver","updateTruckDriver","updateTruckDriver/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.copyTruckDriverFrom","copyTruckDriverFrom","copyTruckDriverFrom/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.addTransportTask","addTransportTask","addTransportTask/"+transportFleet.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.removeTransportTask","removeTransportTask","removeTransportTask/"+transportFleet.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.updateTransportTask","updateTransportTask","updateTransportTask/"+transportFleet.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+transportFleet.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TransportFleet transportFleet, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportFleet createTransportFleet(RetailScmUserContext userContext,String name, String contactNumber, String ownerId
) throws Exception
	{
		
		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");

		

		checkNameOfTransportFleet(userContext,  name, exception);
		checkContactNumberOfTransportFleet(userContext,  contactNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		TransportFleet transportFleet=createNewTransportFleet();	

		transportFleet.setName(name);
		transportFleet.setContactNumber(contactNumber);
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(ownerId,emptyOptions());
		transportFleet.setOwner(owner);

		return saveTransportFleet(userContext, transportFleet, emptyOptions());
		

		
	}
	protected TransportFleet createNewTransportFleet() 
	{
		
		return new TransportFleet();		
	}
	
	protected void checkParamsForUpdatingTransportFleet(RetailScmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkVersionOfTransportFleet(userContext, transportFleetVersion, exception);
		

		if(TransportFleet.NAME_PROPERTY.equals(property)){
			checkNameOfTransportFleet(userContext, parseString(newValueExpr), exception);
		}
		if(TransportFleet.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfTransportFleet(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public TransportFleet clone(RetailScmUserContext userContext, String fromTransportFleetId) throws Exception{
		
		return this.getTransportFleetDAO().clone(fromTransportFleetId, this.allTokens());
	}
	
	public TransportFleet updateTransportFleet(RetailScmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportFleet(userContext, transportFleetId, transportFleetVersion, property, newValueExpr, tokensExpr);
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		if(transportFleet.getVersion() != transportFleetVersion){
			String message = "The target version("+transportFleet.getVersion()+") is not equals to version("+transportFleetVersion+") provided";
			throw new TransportFleetManagerException(message);
		}
		synchronized(transportFleet){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportFleet.
			
			transportFleet.changePropery(property, newValueExpr);
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			//return saveTransportFleet(userContext, transportFleet, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportFleetTokens tokens(){
		return TransportFleetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportFleetTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportFleetTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String transportFleetId, String anotherOwnerId) throws Exception
 	{
 		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
 		checkIdOfTransportFleet(userContext, transportFleetId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TransportFleet transferToAnotherOwner(RetailScmUserContext userContext, String transportFleetId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, transportFleetId,anotherOwnerId);
 
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());	
		synchronized(transportFleet){
			//will be good when the transportFleet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(anotherOwnerId, emptyOptions());		
			transportFleet.setOwner(owner);		
			transportFleet = saveTransportFleet(userContext, transportFleet, emptyOptions());
			
			return present(userContext,transportFleet, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String transportFleetId, int transportFleetVersion) throws Exception {
		
		deleteInternal(userContext, transportFleetId, transportFleetVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String transportFleetId, int transportFleetVersion) throws Exception{
		getTransportFleetDAO().delete(transportFleetId, transportFleetVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportFleetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getTransportFleetDAO().deleteAll();
	}

	protected void checkParamsForAddingTransportTruck(RetailScmUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor,String [] tokensExpr) throws Exception{
		
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);

		checkNameOfTransportTruck(userContext,  name, exception);
		checkPlateNumberOfTransportTruck(userContext,  plateNumber, exception);
		checkContactNumberOfTransportTruck(userContext,  contactNumber, exception);
		checkVehicleLicenseNumberOfTransportTruck(userContext,  vehicleLicenseNumber, exception);
		checkEngineNumberOfTransportTruck(userContext,  engineNumber, exception);
		checkMakeDateOfTransportTruck(userContext,  makeDate, exception);
		checkMileageOfTransportTruck(userContext,  mileage, exception);
		checkBodyColorOfTransportTruck(userContext,  bodyColor, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TransportFleet addTransportTruck(RetailScmUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTruck(userContext,transportFleetId,name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor,tokensExpr);
		
		TransportTruck transportTruck = createTransportTruck(userContext,name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor);
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.addTransportTruck( transportTruck );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	protected TransportTruck createTransportTruck(RetailScmUserContext userContext, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor) throws Exception{

		TransportTruck transportTruck = new TransportTruck();
		
		
		transportTruck.setName(name);		
		transportTruck.setPlateNumber(plateNumber);		
		transportTruck.setContactNumber(contactNumber);		
		transportTruck.setVehicleLicenseNumber(vehicleLicenseNumber);		
		transportTruck.setEngineNumber(engineNumber);		
		transportTruck.setMakeDate(makeDate);		
		transportTruck.setMileage(mileage);		
		transportTruck.setBodyColor(bodyColor);
	
		
		return transportTruck;
	
		
	}
	
	protected TransportTruck createIndexedTransportTruck(String id, int version){

		TransportTruck transportTruck = new TransportTruck();
		transportTruck.setId(id);
		transportTruck.setVersion(version);
		return transportTruck;			
		
	}
	protected void checkParamsForRemovingTransportTruck(RetailScmUserContext userContext, String transportFleetId, 
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkIdOfTransportTruck(userContext, transportTruckId, exception);
		checkVersionOfTransportTruck(userContext, transportTruckVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportFleet removeTransportTruck(RetailScmUserContext userContext, String transportFleetId, 
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTruck(userContext,transportFleetId, transportTruckId, transportTruckVersion,tokensExpr);
		
		TransportTruck transportTruck = createIndexedTransportTruck(transportTruckId, transportTruckVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.removeTransportTruck( transportTruck );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTransportTruck(RetailScmUserContext userContext, String transportFleetId, 
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkIdOfTransportTruck(userContext, transportTruckId, exception);
		checkVersionOfTransportTruck(userContext, transportTruckVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportFleet copyTransportTruckFrom(RetailScmUserContext userContext, String transportFleetId, 
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTruck(userContext,transportFleetId, transportTruckId, transportTruckVersion,tokensExpr);
		
		TransportTruck transportTruck = createIndexedTransportTruck(transportTruckId, transportTruckVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.copyTransportTruckFrom( transportTruck );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTransportTruck(RetailScmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
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
	
	public  TransportFleet updateTransportTruck(RetailScmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTruck(userContext, transportFleetId, transportTruckId, transportTruckVersion, property, newValueExpr,  tokensExpr);
		
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportFleet.removeTransportTruck( transportTruck );	
			//make changes to AcceleraterAccount.
			TransportTruck transportTruckIndex = createIndexedTransportTruck(transportTruckId, transportTruckVersion);
		
			TransportTruck transportTruck = transportFleet.findTheTransportTruck(transportTruckIndex);
			if(transportTruck == null){
				throw new TransportFleetManagerException(transportTruck+"Not found" );
			}
			
			transportTruck.changePropery(property, newValueExpr);

			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingTruckDriver(RetailScmUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber,String [] tokensExpr) throws Exception{
		
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);

		checkNameOfTruckDriver(userContext,  name, exception);
		checkDriverLicenseNumberOfTruckDriver(userContext,  driverLicenseNumber, exception);
		checkContactNumberOfTruckDriver(userContext,  contactNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TransportFleet addTruckDriver(RetailScmUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTruckDriver(userContext,transportFleetId,name, driverLicenseNumber, contactNumber,tokensExpr);
		
		TruckDriver truckDriver = createTruckDriver(userContext,name, driverLicenseNumber, contactNumber);
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.addTruckDriver( truckDriver );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	protected TruckDriver createTruckDriver(RetailScmUserContext userContext, String name, String driverLicenseNumber, String contactNumber) throws Exception{

		TruckDriver truckDriver = new TruckDriver();
		
		
		truckDriver.setName(name);		
		truckDriver.setDriverLicenseNumber(driverLicenseNumber);		
		truckDriver.setContactNumber(contactNumber);
	
		
		return truckDriver;
	
		
	}
	
	protected TruckDriver createIndexedTruckDriver(String id, int version){

		TruckDriver truckDriver = new TruckDriver();
		truckDriver.setId(id);
		truckDriver.setVersion(version);
		return truckDriver;			
		
	}
	protected void checkParamsForRemovingTruckDriver(RetailScmUserContext userContext, String transportFleetId, 
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkIdOfTruckDriver(userContext, truckDriverId, exception);
		checkVersionOfTruckDriver(userContext, truckDriverVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportFleet removeTruckDriver(RetailScmUserContext userContext, String transportFleetId, 
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTruckDriver(userContext,transportFleetId, truckDriverId, truckDriverVersion,tokensExpr);
		
		TruckDriver truckDriver = createIndexedTruckDriver(truckDriverId, truckDriverVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.removeTruckDriver( truckDriver );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTruckDriver(RetailScmUserContext userContext, String transportFleetId, 
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkIdOfTruckDriver(userContext, truckDriverId, exception);
		checkVersionOfTruckDriver(userContext, truckDriverVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportFleet copyTruckDriverFrom(RetailScmUserContext userContext, String transportFleetId, 
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTruckDriver(userContext,transportFleetId, truckDriverId, truckDriverVersion,tokensExpr);
		
		TruckDriver truckDriver = createIndexedTruckDriver(truckDriverId, truckDriverVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.copyTruckDriverFrom( truckDriver );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTruckDriver(RetailScmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
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
	
	public  TransportFleet updateTruckDriver(RetailScmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTruckDriver(userContext, transportFleetId, truckDriverId, truckDriverVersion, property, newValueExpr,  tokensExpr);
		
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportFleet.removeTruckDriver( truckDriver );	
			//make changes to AcceleraterAccount.
			TruckDriver truckDriverIndex = createIndexedTruckDriver(truckDriverId, truckDriverVersion);
		
			TruckDriver truckDriver = transportFleet.findTheTruckDriver(truckDriverIndex);
			if(truckDriver == null){
				throw new TransportFleetManagerException(truckDriver+"Not found" );
			}
			
			truckDriver.changePropery(property, newValueExpr);

			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingTransportTask(RetailScmUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);

		checkNameOfTransportTask(userContext,  name, exception);
		checkStartOfTransportTask(userContext,  start, exception);
		checkBeginTimeOfTransportTask(userContext,  beginTime, exception);		
		
		checkIdOfRetailStore(userContext,  endId, exception);		
		
		checkIdOfTruckDriver(userContext,  driverId, exception);		
		
		checkIdOfTransportTruck(userContext,  truckId, exception);
		checkLatitudeOfTransportTask(userContext,  latitude, exception);
		checkLongitudeOfTransportTask(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TransportFleet addTransportTask(RetailScmUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,transportFleetId,name, start, beginTime, endId, driverId, truckId, latitude, longitude,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, endId, driverId, truckId, latitude, longitude);
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.addTransportTask( transportTask );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	protected TransportTask createTransportTask(RetailScmUserContext userContext, String name, String start, Date beginTime, String endId, String driverId, String truckId, double latitude, double longitude) throws Exception{

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
		TransportTruck  truck = new TransportTruck();
		truck.setId(truckId);		
		transportTask.setTruck(truck);		
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
	protected void checkParamsForRemovingTransportTask(RetailScmUserContext userContext, String transportFleetId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportFleet removeTransportTask(RetailScmUserContext userContext, String transportFleetId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,transportFleetId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.removeTransportTask( transportTask );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTransportTask(RetailScmUserContext userContext, String transportFleetId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportFleet copyTransportTaskFrom(RetailScmUserContext userContext, String transportFleetId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,transportFleetId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.copyTransportTaskFrom( transportTask );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTransportTask(RetailScmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TransportFleetManagerException exception = new TransportFleetManagerException("Error Occured");
		
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
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
	
	public  TransportFleet updateTransportTask(RetailScmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, transportFleetId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportFleet.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = transportFleet.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new TransportFleetManagerException(transportTask+"Not found" );
			}
			
			transportTask.changePropery(property, newValueExpr);

			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


