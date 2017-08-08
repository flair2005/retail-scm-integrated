
package com.skynet.retailscm.eventattendance;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;

import com.skynet.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.skynet.retailscm.cityevent.CityEventDAO;



import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;
import com.skynet.retailscm.cityevent.CityEventTable;




public class EventAttendanceManagerImpl extends RetailScmCheckerManager implements EventAttendanceManager {
	
	private static final String SERVICE_TYPE = "EventAttendance";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EventAttendanceDAO  eventAttendanceDAO;
 	public void setEventAttendanceDAO(EventAttendanceDAO  eventAttendanceDAO){
 	
 		if(eventAttendanceDAO == null){
 			throw new IllegalStateException("Do not try to set eventAttendanceDAO to null.");
 		}
	 	this.eventAttendanceDAO = eventAttendanceDAO;
 	}
 	public EventAttendanceDAO getEventAttendanceDAO(){
 		if(this.eventAttendanceDAO == null){
 			throw new IllegalStateException("The EventAttendanceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.eventAttendanceDAO;
 	}
 	
 	protected EventAttendance saveEventAttendance(RetailScmUserContext userContext, EventAttendance eventAttendance, String [] tokensExpr) throws Exception{	
 		//return getEventAttendanceDAO().save(eventAttendance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEventAttendance(userContext, eventAttendance, tokens);
 	}
 	
 	protected EventAttendance saveEventAttendanceDetail(RetailScmUserContext userContext, EventAttendance eventAttendance) throws Exception{	

 		
 		return saveEventAttendance(userContext, eventAttendance, allTokens());
 	}
 	
 	public EventAttendance loadEventAttendance(RetailScmUserContext userContext, String eventAttendanceId, String [] tokensExpr) throws Exception{				
 
 		EventAttendanceManagerException exception = new EventAttendanceManagerException("Error Occured");
		
		checkIdOfEventAttendance(userContext, eventAttendanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EventAttendance eventAttendance = loadEventAttendance( userContext, eventAttendanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,eventAttendance, tokens);
 	}
 	
 	protected EventAttendance present(RetailScmUserContext userContext, EventAttendance eventAttendance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,eventAttendance,tokens);
		
		
		return this.getEventAttendanceDAO().present(eventAttendance, tokens);
	}
 
 	
 	
 	public EventAttendance loadEventAttendanceDetail(RetailScmUserContext userContext, String eventAttendanceId) throws Exception{	
 		EventAttendanceManagerException exception = new EventAttendanceManagerException("Error Occured");
		
		checkIdOfEventAttendance(userContext, eventAttendanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EventAttendance eventAttendance = loadEventAttendance( userContext, eventAttendanceId, allTokens());

 		return present(userContext,eventAttendance, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String eventAttendanceId) throws Exception{	
 		EventAttendanceManagerException exception = new EventAttendanceManagerException("Error Occured");
		
		checkIdOfEventAttendance(userContext, eventAttendanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EventAttendance eventAttendance = loadEventAttendance( userContext, eventAttendanceId, allTokens());

 		return present(userContext,eventAttendance, allTokens());
		
 	}
 	protected EventAttendance saveEventAttendance(RetailScmUserContext userContext, EventAttendance eventAttendance, Map<String,Object>tokens) throws Exception{	
 		return getEventAttendanceDAO().save(eventAttendance, tokens);
 	}
 	protected EventAttendance loadEventAttendance(RetailScmUserContext userContext, String eventAttendanceId, Map<String,Object>tokens) throws Exception{	
 		return getEventAttendanceDAO().load(eventAttendanceId, tokens);
 	}

	



 	 
 	
 	private  CityEventDAO  cityEventDAO;
 	public void setCityEventDAO(CityEventDAO cityEventDAO){
	 	this.cityEventDAO = cityEventDAO;
 	}
 	//------------------------------------
 	public CityEventDAO getCityEventDAO(){
	 	return this.cityEventDAO;
 	}
 
 	
 	private  PotentialCustomerDAO  potentialCustomerDAO;
 	public void setPotentialCustomerDAO(PotentialCustomerDAO potentialCustomerDAO){
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	//------------------------------------
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
	 	return this.potentialCustomerDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EventAttendance eventAttendance, Map<String, Object> tokens){
		super.addActions(userContext, eventAttendance, tokens);
		
		addAction(userContext, eventAttendance, tokens,"@create","createEventAttendance","createEventAttendance/","main","primary");
		addAction(userContext, eventAttendance, tokens,"@update","updateEventAttendance","updateEventAttendance/"+eventAttendance.getId()+"/","main","primary");
		addAction(userContext, eventAttendance, tokens,"@copy","cloneEventAttendance","cloneEventAttendance/"+eventAttendance.getId()+"/","main","primary");
		
		addAction(userContext, eventAttendance, tokens,"event_attendance.transfer_to_potential_customer","transferToAnotherPotentialCustomer","transferToAnotherPotentialCustomer/"+eventAttendance.getId()+"/","main","primary");
		addAction(userContext, eventAttendance, tokens,"event_attendance.transfer_to_city_event","transferToAnotherCityEvent","transferToAnotherCityEvent/"+eventAttendance.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EventAttendance eventAttendance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EventAttendance createEventAttendance(RetailScmUserContext userContext,String name, String potentialCustomerId, String cityEventId, String description
) throws Exception
	{
		
		EventAttendanceManagerException exception = new EventAttendanceManagerException("Error Occured");

		

		checkNameOfEventAttendance(userContext,  name, exception);
		checkDescriptionOfEventAttendance(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EventAttendance eventAttendance=createNewEventAttendance();	

		eventAttendance.setName(name);
		PotentialCustomer potentialCustomer = loadPotentialCustomer(potentialCustomerId,emptyOptions());
		eventAttendance.setPotentialCustomer(potentialCustomer);
		CityEvent cityEvent = loadCityEvent(cityEventId,emptyOptions());
		eventAttendance.setCityEvent(cityEvent);
		eventAttendance.setDescription(description);

		return saveEventAttendance(userContext, eventAttendance, emptyOptions());
		

		
	}
	protected EventAttendance createNewEventAttendance() 
	{
		
		return new EventAttendance();		
	}
	
	protected void checkParamsForUpdatingEventAttendance(RetailScmUserContext userContext,String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EventAttendanceManagerException exception = new EventAttendanceManagerException("Error Occured");
		
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
	
	
	
	public EventAttendance clone(RetailScmUserContext userContext, String fromEventAttendanceId) throws Exception{
		
		return this.getEventAttendanceDAO().clone(fromEventAttendanceId, this.allTokens());
	}
	
	public EventAttendance updateEventAttendance(RetailScmUserContext userContext,String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEventAttendance(userContext, eventAttendanceId, eventAttendanceVersion, property, newValueExpr, tokensExpr);
		
		EventAttendance eventAttendance = loadEventAttendance(userContext, eventAttendanceId, allTokens());
		if(eventAttendance.getVersion() != eventAttendanceVersion){
			String message = "The target version("+eventAttendance.getVersion()+") is not equals to version("+eventAttendanceVersion+") provided";
			throw new EventAttendanceManagerException(message);
		}
		synchronized(eventAttendance){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EventAttendance.
			
			eventAttendance.changePropery(property, newValueExpr);
			eventAttendance = saveEventAttendance(userContext, eventAttendance, tokens().done());
			return present(userContext,eventAttendance, mergedAllTokens(tokensExpr));
			//return saveEventAttendance(userContext, eventAttendance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EventAttendanceTokens tokens(){
		return EventAttendanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EventAttendanceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EventAttendanceTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherPotentialCustomer(RetailScmUserContext userContext, String eventAttendanceId, String anotherPotentialCustomerId) throws Exception
 	{
 		EventAttendanceManagerException exception = new EventAttendanceManagerException("Error Occured");
 		checkIdOfEventAttendance(userContext, eventAttendanceId,exception);
 		checkIdOfPotentialCustomer(userContext, anotherPotentialCustomerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EventAttendance transferToAnotherPotentialCustomer(RetailScmUserContext userContext, String eventAttendanceId, String anotherPotentialCustomerId) throws Exception
 	{
 		checkParamsForTransferingAnotherPotentialCustomer(userContext, eventAttendanceId,anotherPotentialCustomerId);
 
		EventAttendance eventAttendance = loadEventAttendance(userContext, eventAttendanceId, allTokens());	
		synchronized(eventAttendance){
			//will be good when the eventAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PotentialCustomer potentialCustomer = loadPotentialCustomer(anotherPotentialCustomerId, emptyOptions());		
			eventAttendance.setPotentialCustomer(potentialCustomer);		
			eventAttendance = saveEventAttendance(userContext, eventAttendance, emptyOptions());
			
			return present(userContext,eventAttendance, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherCityEvent(RetailScmUserContext userContext, String eventAttendanceId, String anotherCityEventId) throws Exception
 	{
 		EventAttendanceManagerException exception = new EventAttendanceManagerException("Error Occured");
 		checkIdOfEventAttendance(userContext, eventAttendanceId,exception);
 		checkIdOfCityEvent(userContext, anotherCityEventId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EventAttendance transferToAnotherCityEvent(RetailScmUserContext userContext, String eventAttendanceId, String anotherCityEventId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityEvent(userContext, eventAttendanceId,anotherCityEventId);
 
		EventAttendance eventAttendance = loadEventAttendance(userContext, eventAttendanceId, allTokens());	
		synchronized(eventAttendance){
			//will be good when the eventAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CityEvent cityEvent = loadCityEvent(anotherCityEventId, emptyOptions());		
			eventAttendance.setCityEvent(cityEvent);		
			eventAttendance = saveEventAttendance(userContext, eventAttendance, emptyOptions());
			
			return present(userContext,eventAttendance, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected CityEvent loadCityEvent(String newCityEventId, Map<String,Object> options) throws Exception
 	{
		
 		return getCityEventDAO().load(newCityEventId, options);
 	}
	
	 	
 	protected PotentialCustomer loadPotentialCustomer(String newPotentialCustomerId, Map<String,Object> options) throws Exception
 	{
		
 		return getPotentialCustomerDAO().load(newPotentialCustomerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String eventAttendanceId, int eventAttendanceVersion) throws Exception {
		
		deleteInternal(userContext, eventAttendanceId, eventAttendanceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String eventAttendanceId, int eventAttendanceVersion) throws Exception{
		getEventAttendanceDAO().delete(eventAttendanceId, eventAttendanceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EventAttendanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEventAttendanceDAO().deleteAll();
	}


}


