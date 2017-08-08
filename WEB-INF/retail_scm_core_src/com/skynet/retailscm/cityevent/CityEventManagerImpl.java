
package com.skynet.retailscm.cityevent;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;

import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;


import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.skynet.retailscm.eventattendance.EventAttendanceTable;




public class CityEventManagerImpl extends RetailScmCheckerManager implements CityEventManager {
	
	private static final String SERVICE_TYPE = "CityEvent";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  CityEventDAO  cityEventDAO;
 	public void setCityEventDAO(CityEventDAO  cityEventDAO){
 	
 		if(cityEventDAO == null){
 			throw new IllegalStateException("Do not try to set cityEventDAO to null.");
 		}
	 	this.cityEventDAO = cityEventDAO;
 	}
 	public CityEventDAO getCityEventDAO(){
 		if(this.cityEventDAO == null){
 			throw new IllegalStateException("The CityEventDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityEventDAO;
 	}
 	
 	protected CityEvent saveCityEvent(RetailScmUserContext userContext, CityEvent cityEvent, String [] tokensExpr) throws Exception{	
 		//return getCityEventDAO().save(cityEvent, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCityEvent(userContext, cityEvent, tokens);
 	}
 	
 	protected CityEvent saveCityEventDetail(RetailScmUserContext userContext, CityEvent cityEvent) throws Exception{	

 		
 		return saveCityEvent(userContext, cityEvent, allTokens());
 	}
 	
 	public CityEvent loadCityEvent(RetailScmUserContext userContext, String cityEventId, String [] tokensExpr) throws Exception{				
 
 		CityEventManagerException exception = new CityEventManagerException("Error Occured");
		
		checkIdOfCityEvent(userContext, cityEventId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityEvent, tokens);
 	}
 	
 	protected CityEvent present(RetailScmUserContext userContext, CityEvent cityEvent, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,cityEvent,tokens);
		
		
		return this.getCityEventDAO().present(cityEvent, tokens);
	}
 
 	
 	
 	public CityEvent loadCityEventDetail(RetailScmUserContext userContext, String cityEventId) throws Exception{	
 		CityEventManagerException exception = new CityEventManagerException("Error Occured");
		
		checkIdOfCityEvent(userContext, cityEventId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, allTokens());

 		return present(userContext,cityEvent, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String cityEventId) throws Exception{	
 		CityEventManagerException exception = new CityEventManagerException("Error Occured");
		
		checkIdOfCityEvent(userContext, cityEventId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, allTokens());

 		return present(userContext,cityEvent, allTokens());
		
 	}
 	protected CityEvent saveCityEvent(RetailScmUserContext userContext, CityEvent cityEvent, Map<String,Object>tokens) throws Exception{	
 		return getCityEventDAO().save(cityEvent, tokens);
 	}
 	protected CityEvent loadCityEvent(RetailScmUserContext userContext, String cityEventId, Map<String,Object>tokens) throws Exception{	
 		return getCityEventDAO().load(cityEventId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
	 	return this.retailStoreCityServiceCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, CityEvent cityEvent, Map<String, Object> tokens){
		super.addActions(userContext, cityEvent, tokens);
		
		addAction(userContext, cityEvent, tokens,"@create","createCityEvent","createCityEvent/","main","primary");
		addAction(userContext, cityEvent, tokens,"@update","updateCityEvent","updateCityEvent/"+cityEvent.getId()+"/","main","primary");
		addAction(userContext, cityEvent, tokens,"@copy","cloneCityEvent","cloneCityEvent/"+cityEvent.getId()+"/","main","primary");
		
		addAction(userContext, cityEvent, tokens,"city_event.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+cityEvent.getId()+"/","main","primary");
		addAction(userContext, cityEvent, tokens,"city_event.addEventAttendance","addEventAttendance","addEventAttendance/"+cityEvent.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, cityEvent, tokens,"city_event.removeEventAttendance","removeEventAttendance","removeEventAttendance/"+cityEvent.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, cityEvent, tokens,"city_event.updateEventAttendance","updateEventAttendance","updateEventAttendance/"+cityEvent.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, cityEvent, tokens,"city_event.copyEventAttendanceFrom","copyEventAttendanceFrom","copyEventAttendanceFrom/"+cityEvent.getId()+"/","eventAttendanceList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, CityEvent cityEvent, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CityEvent createCityEvent(RetailScmUserContext userContext,String name, String mobile, String cityServiceCenterId, String description
) throws Exception
	{
		
		CityEventManagerException exception = new CityEventManagerException("Error Occured");

		

		checkNameOfCityEvent(userContext,  name, exception);
		checkMobileOfCityEvent(userContext,  mobile, exception);
		checkDescriptionOfCityEvent(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		CityEvent cityEvent=createNewCityEvent();	

		cityEvent.setName(name);
		cityEvent.setMobile(mobile);
		RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(cityServiceCenterId,emptyOptions());
		cityEvent.setCityServiceCenter(cityServiceCenter);
		cityEvent.setDescription(description);

		return saveCityEvent(userContext, cityEvent, emptyOptions());
		

		
	}
	protected CityEvent createNewCityEvent() 
	{
		
		return new CityEvent();		
	}
	
	protected void checkParamsForUpdatingCityEvent(RetailScmUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		CityEventManagerException exception = new CityEventManagerException("Error Occured");
		
		checkIdOfCityEvent(userContext, cityEventId, exception);
		checkVersionOfCityEvent(userContext, cityEventVersion, exception);
		

		if(CityEvent.NAME_PROPERTY.equals(property)){
			checkNameOfCityEvent(userContext, parseString(newValueExpr), exception);
		}
		if(CityEvent.MOBILE_PROPERTY.equals(property)){
			checkMobileOfCityEvent(userContext, parseString(newValueExpr), exception);
		}		

		
		if(CityEvent.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfCityEvent(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public CityEvent clone(RetailScmUserContext userContext, String fromCityEventId) throws Exception{
		
		return this.getCityEventDAO().clone(fromCityEventId, this.allTokens());
	}
	
	public CityEvent updateCityEvent(RetailScmUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCityEvent(userContext, cityEventId, cityEventVersion, property, newValueExpr, tokensExpr);
		
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		if(cityEvent.getVersion() != cityEventVersion){
			String message = "The target version("+cityEvent.getVersion()+") is not equals to version("+cityEventVersion+") provided";
			throw new CityEventManagerException(message);
		}
		synchronized(cityEvent){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityEvent.
			
			cityEvent.changePropery(property, newValueExpr);
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
			//return saveCityEvent(userContext, cityEvent, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CityEventTokens tokens(){
		return CityEventTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CityEventTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CityEventTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCityServiceCenter(RetailScmUserContext userContext, String cityEventId, String anotherCityServiceCenterId) throws Exception
 	{
 		CityEventManagerException exception = new CityEventManagerException("Error Occured");
 		checkIdOfCityEvent(userContext, cityEventId,exception);
 		checkIdOfRetailStoreCityServiceCenter(userContext, anotherCityServiceCenterId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public CityEvent transferToAnotherCityServiceCenter(RetailScmUserContext userContext, String cityEventId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, cityEventId,anotherCityServiceCenterId);
 
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());	
		synchronized(cityEvent){
			//will be good when the cityEvent loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(anotherCityServiceCenterId, emptyOptions());		
			cityEvent.setCityServiceCenter(cityServiceCenter);		
			cityEvent = saveCityEvent(userContext, cityEvent, emptyOptions());
			
			return present(userContext,cityEvent, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCityServiceCenterDAO().load(newCityServiceCenterId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String cityEventId, int cityEventVersion) throws Exception {
		
		deleteInternal(userContext, cityEventId, cityEventVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String cityEventId, int cityEventVersion) throws Exception{
		getCityEventDAO().delete(cityEventId, cityEventVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CityEventManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getCityEventDAO().deleteAll();
	}

	protected void checkParamsForAddingEventAttendance(RetailScmUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description,String [] tokensExpr) throws Exception{
		
		

		CityEventManagerException exception = new CityEventManagerException("Error Occured");
		
		checkIdOfCityEvent(userContext, cityEventId, exception);

		checkNameOfEventAttendance(userContext,  name, exception);		
		
		checkIdOfPotentialCustomer(userContext,  potentialCustomerId, exception);
		checkDescriptionOfEventAttendance(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  CityEvent addEventAttendance(RetailScmUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEventAttendance(userContext,cityEventId,name, potentialCustomerId, description,tokensExpr);
		
		EventAttendance eventAttendance = createEventAttendance(userContext,name, potentialCustomerId, description);
		
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		synchronized(cityEvent){ 
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityEvent.addEventAttendance( eventAttendance );		
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}
	}
	protected EventAttendance createEventAttendance(RetailScmUserContext userContext, String name, String potentialCustomerId, String description) throws Exception{

		EventAttendance eventAttendance = new EventAttendance();
		
		
		eventAttendance.setName(name);		
		PotentialCustomer  potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(potentialCustomerId);		
		eventAttendance.setPotentialCustomer(potentialCustomer);		
		eventAttendance.setDescription(description);
	
		
		return eventAttendance;
	
		
	}
	
	protected EventAttendance createIndexedEventAttendance(String id, int version){

		EventAttendance eventAttendance = new EventAttendance();
		eventAttendance.setId(id);
		eventAttendance.setVersion(version);
		return eventAttendance;			
		
	}
	protected void checkParamsForRemovingEventAttendance(RetailScmUserContext userContext, String cityEventId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		

		CityEventManagerException exception = new CityEventManagerException("Error Occured");
		
		checkIdOfCityEvent(userContext, cityEventId, exception);
		checkIdOfEventAttendance(userContext, eventAttendanceId, exception);
		checkVersionOfEventAttendance(userContext, eventAttendanceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  CityEvent removeEventAttendance(RetailScmUserContext userContext, String cityEventId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEventAttendance(userContext,cityEventId, eventAttendanceId, eventAttendanceVersion,tokensExpr);
		
		EventAttendance eventAttendance = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		synchronized(cityEvent){ 
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityEvent.removeEventAttendance( eventAttendance );		
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEventAttendance(RetailScmUserContext userContext, String cityEventId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		

		CityEventManagerException exception = new CityEventManagerException("Error Occured");
		
		checkIdOfCityEvent(userContext, cityEventId, exception);
		checkIdOfEventAttendance(userContext, eventAttendanceId, exception);
		checkVersionOfEventAttendance(userContext, eventAttendanceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  CityEvent copyEventAttendanceFrom(RetailScmUserContext userContext, String cityEventId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEventAttendance(userContext,cityEventId, eventAttendanceId, eventAttendanceVersion,tokensExpr);
		
		EventAttendance eventAttendance = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		synchronized(cityEvent){ 
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityEvent.copyEventAttendanceFrom( eventAttendance );		
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEventAttendance(RetailScmUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		CityEventManagerException exception = new CityEventManagerException("Error Occured");
		
		checkIdOfCityEvent(userContext, cityEventId, exception);
		checkIdOfEventAttendance(userContext, eventAttendanceId, exception);
		checkVersionOfEventAttendance(userContext, eventAttendanceVersion, exception);
		

		if(EventAttendance.NAME_PROPERTY.equals(property)){
			checkNameOfEventAttendance(userContext, parseString(newValueExpr), exception);
		}
		
		if(EventAttendance.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfEventAttendance(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  CityEvent updateEventAttendance(RetailScmUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEventAttendance(userContext, cityEventId, eventAttendanceId, eventAttendanceVersion, property, newValueExpr,  tokensExpr);
		
		
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		
		synchronized(cityEvent){ 
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityEvent.removeEventAttendance( eventAttendance );	
			//make changes to AcceleraterAccount.
			EventAttendance eventAttendanceIndex = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		
			EventAttendance eventAttendance = cityEvent.findTheEventAttendance(eventAttendanceIndex);
			if(eventAttendance == null){
				throw new CityEventManagerException(eventAttendance+"Not found" );
			}
			
			eventAttendance.changePropery(property, newValueExpr);

			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


