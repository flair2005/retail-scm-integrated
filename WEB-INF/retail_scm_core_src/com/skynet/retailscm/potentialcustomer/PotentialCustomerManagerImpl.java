
package com.skynet.retailscm.potentialcustomer;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.citypartner.CityPartner;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.skynet.retailscm.citypartner.CityPartnerDAO;

import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;


import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContactTable;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonTable;
import com.skynet.retailscm.eventattendance.EventAttendanceTable;
import com.skynet.retailscm.citypartner.CityPartnerTable;




public class PotentialCustomerManagerImpl extends RetailScmCheckerManager implements PotentialCustomerManager {
	
	private static final String SERVICE_TYPE = "PotentialCustomer";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  PotentialCustomerDAO  potentialCustomerDAO;
 	public void setPotentialCustomerDAO(PotentialCustomerDAO  potentialCustomerDAO){
 	
 		if(potentialCustomerDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerDAO to null.");
 		}
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
 		if(this.potentialCustomerDAO == null){
 			throw new IllegalStateException("The PotentialCustomerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerDAO;
 	}
 	
 	protected PotentialCustomer savePotentialCustomer(RetailScmUserContext userContext, PotentialCustomer potentialCustomer, String [] tokensExpr) throws Exception{	
 		//return getPotentialCustomerDAO().save(potentialCustomer, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePotentialCustomer(userContext, potentialCustomer, tokens);
 	}
 	
 	protected PotentialCustomer savePotentialCustomerDetail(RetailScmUserContext userContext, PotentialCustomer potentialCustomer) throws Exception{	

 		
 		return savePotentialCustomer(userContext, potentialCustomer, allTokens());
 	}
 	
 	public PotentialCustomer loadPotentialCustomer(RetailScmUserContext userContext, String potentialCustomerId, String [] tokensExpr) throws Exception{				
 
 		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PotentialCustomer potentialCustomer = loadPotentialCustomer( userContext, potentialCustomerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,potentialCustomer, tokens);
 	}
 	
 	protected PotentialCustomer present(RetailScmUserContext userContext, PotentialCustomer potentialCustomer, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,potentialCustomer,tokens);
		
		
		return this.getPotentialCustomerDAO().present(potentialCustomer, tokens);
	}
 
 	
 	
 	public PotentialCustomer loadPotentialCustomerDetail(RetailScmUserContext userContext, String potentialCustomerId) throws Exception{	
 		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PotentialCustomer potentialCustomer = loadPotentialCustomer( userContext, potentialCustomerId, allTokens());

 		return present(userContext,potentialCustomer, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String potentialCustomerId) throws Exception{	
 		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PotentialCustomer potentialCustomer = loadPotentialCustomer( userContext, potentialCustomerId, allTokens());

 		return present(userContext,potentialCustomer, allTokens());
		
 	}
 	protected PotentialCustomer savePotentialCustomer(RetailScmUserContext userContext, PotentialCustomer potentialCustomer, Map<String,Object>tokens) throws Exception{	
 		return getPotentialCustomerDAO().save(potentialCustomer, tokens);
 	}
 	protected PotentialCustomer loadPotentialCustomer(RetailScmUserContext userContext, String potentialCustomerId, Map<String,Object>tokens) throws Exception{	
 		return getPotentialCustomerDAO().load(potentialCustomerId, tokens);
 	}

	



 	 
 	
 	private  CityPartnerDAO  cityPartnerDAO;
 	public void setCityPartnerDAO(CityPartnerDAO cityPartnerDAO){
	 	this.cityPartnerDAO = cityPartnerDAO;
 	}
 	//------------------------------------
 	public CityPartnerDAO getCityPartnerDAO(){
	 	return this.cityPartnerDAO;
 	}
 
 	
 	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
	 	return this.retailStoreCityServiceCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PotentialCustomer potentialCustomer, Map<String, Object> tokens){
		super.addActions(userContext, potentialCustomer, tokens);
		
		addAction(userContext, potentialCustomer, tokens,"@create","createPotentialCustomer","createPotentialCustomer/","main","primary");
		addAction(userContext, potentialCustomer, tokens,"@update","updatePotentialCustomer","updatePotentialCustomer/"+potentialCustomer.getId()+"/","main","primary");
		addAction(userContext, potentialCustomer, tokens,"@copy","clonePotentialCustomer","clonePotentialCustomer/"+potentialCustomer.getId()+"/","main","primary");
		
		addAction(userContext, potentialCustomer, tokens,"potential_customer.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+potentialCustomer.getId()+"/","main","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.transfer_to_city_partner","transferToAnotherCityPartner","transferToAnotherCityPartner/"+potentialCustomer.getId()+"/","main","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.addPotentialCustomerContactPerson","addPotentialCustomerContactPerson","addPotentialCustomerContactPerson/"+potentialCustomer.getId()+"/","potentialCustomerContactPersonList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.removePotentialCustomerContactPerson","removePotentialCustomerContactPerson","removePotentialCustomerContactPerson/"+potentialCustomer.getId()+"/","potentialCustomerContactPersonList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.updatePotentialCustomerContactPerson","updatePotentialCustomerContactPerson","updatePotentialCustomerContactPerson/"+potentialCustomer.getId()+"/","potentialCustomerContactPersonList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.copyPotentialCustomerContactPersonFrom","copyPotentialCustomerContactPersonFrom","copyPotentialCustomerContactPersonFrom/"+potentialCustomer.getId()+"/","potentialCustomerContactPersonList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.addPotentialCustomerContact","addPotentialCustomerContact","addPotentialCustomerContact/"+potentialCustomer.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.removePotentialCustomerContact","removePotentialCustomerContact","removePotentialCustomerContact/"+potentialCustomer.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.updatePotentialCustomerContact","updatePotentialCustomerContact","updatePotentialCustomerContact/"+potentialCustomer.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom/"+potentialCustomer.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.addEventAttendance","addEventAttendance","addEventAttendance/"+potentialCustomer.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.removeEventAttendance","removeEventAttendance","removeEventAttendance/"+potentialCustomer.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.updateEventAttendance","updateEventAttendance","updateEventAttendance/"+potentialCustomer.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, potentialCustomer, tokens,"potential_customer.copyEventAttendanceFrom","copyEventAttendanceFrom","copyEventAttendanceFrom/"+potentialCustomer.getId()+"/","eventAttendanceList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PotentialCustomer potentialCustomer, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PotentialCustomer createPotentialCustomer(RetailScmUserContext userContext,String name, String mobile, String cityServiceCenterId, String cityPartnerId, String description
) throws Exception
	{
		
		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");

		

		checkNameOfPotentialCustomer(userContext,  name, exception);
		checkMobileOfPotentialCustomer(userContext,  mobile, exception);
		checkDescriptionOfPotentialCustomer(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		PotentialCustomer potentialCustomer=createNewPotentialCustomer();	

		potentialCustomer.setName(name);
		potentialCustomer.setMobile(mobile);
		RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(cityServiceCenterId,emptyOptions());
		potentialCustomer.setCityServiceCenter(cityServiceCenter);
		CityPartner cityPartner = loadCityPartner(cityPartnerId,emptyOptions());
		potentialCustomer.setCityPartner(cityPartner);
		potentialCustomer.setDescription(description);

		return savePotentialCustomer(userContext, potentialCustomer, emptyOptions());
		

		
	}
	protected PotentialCustomer createNewPotentialCustomer() 
	{
		
		return new PotentialCustomer();		
	}
	
	protected void checkParamsForUpdatingPotentialCustomer(RetailScmUserContext userContext,String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkVersionOfPotentialCustomer(userContext, potentialCustomerVersion, exception);
		

		if(PotentialCustomer.NAME_PROPERTY.equals(property)){
			checkNameOfPotentialCustomer(userContext, parseString(newValueExpr), exception);
		}
		if(PotentialCustomer.MOBILE_PROPERTY.equals(property)){
			checkMobileOfPotentialCustomer(userContext, parseString(newValueExpr), exception);
		}		

				

		
		if(PotentialCustomer.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfPotentialCustomer(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public PotentialCustomer clone(RetailScmUserContext userContext, String fromPotentialCustomerId) throws Exception{
		
		return this.getPotentialCustomerDAO().clone(fromPotentialCustomerId, this.allTokens());
	}
	
	public PotentialCustomer updatePotentialCustomer(RetailScmUserContext userContext,String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPotentialCustomer(userContext, potentialCustomerId, potentialCustomerVersion, property, newValueExpr, tokensExpr);
		
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		if(potentialCustomer.getVersion() != potentialCustomerVersion){
			String message = "The target version("+potentialCustomer.getVersion()+") is not equals to version("+potentialCustomerVersion+") provided";
			throw new PotentialCustomerManagerException(message);
		}
		synchronized(potentialCustomer){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PotentialCustomer.
			
			potentialCustomer.changePropery(property, newValueExpr);
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
			//return savePotentialCustomer(userContext, potentialCustomer, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PotentialCustomerTokens tokens(){
		return PotentialCustomerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PotentialCustomerTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PotentialCustomerTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCityServiceCenter(RetailScmUserContext userContext, String potentialCustomerId, String anotherCityServiceCenterId) throws Exception
 	{
 		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
 		checkIdOfPotentialCustomer(userContext, potentialCustomerId,exception);
 		checkIdOfRetailStoreCityServiceCenter(userContext, anotherCityServiceCenterId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public PotentialCustomer transferToAnotherCityServiceCenter(RetailScmUserContext userContext, String potentialCustomerId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, potentialCustomerId,anotherCityServiceCenterId);
 
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());	
		synchronized(potentialCustomer){
			//will be good when the potentialCustomer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(anotherCityServiceCenterId, emptyOptions());		
			potentialCustomer.setCityServiceCenter(cityServiceCenter);		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, emptyOptions());
			
			return present(userContext,potentialCustomer, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherCityPartner(RetailScmUserContext userContext, String potentialCustomerId, String anotherCityPartnerId) throws Exception
 	{
 		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
 		checkIdOfPotentialCustomer(userContext, potentialCustomerId,exception);
 		checkIdOfCityPartner(userContext, anotherCityPartnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public PotentialCustomer transferToAnotherCityPartner(RetailScmUserContext userContext, String potentialCustomerId, String anotherCityPartnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityPartner(userContext, potentialCustomerId,anotherCityPartnerId);
 
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());	
		synchronized(potentialCustomer){
			//will be good when the potentialCustomer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CityPartner cityPartner = loadCityPartner(anotherCityPartnerId, emptyOptions());		
			potentialCustomer.setCityPartner(cityPartner);		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, emptyOptions());
			
			return present(userContext,potentialCustomer, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected CityPartner loadCityPartner(String newCityPartnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getCityPartnerDAO().load(newCityPartnerId, options);
 	}
	
	 	
 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCityServiceCenterDAO().load(newCityServiceCenterId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String potentialCustomerId, int potentialCustomerVersion) throws Exception {
		
		deleteInternal(userContext, potentialCustomerId, potentialCustomerVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String potentialCustomerId, int potentialCustomerVersion) throws Exception{
		getPotentialCustomerDAO().delete(potentialCustomerId, potentialCustomerVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PotentialCustomerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getPotentialCustomerDAO().deleteAll();
	}

	protected void checkParamsForAddingPotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, String name, String mobile, String description,String [] tokensExpr) throws Exception{
		
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);

		checkNameOfPotentialCustomerContactPerson(userContext,  name, exception);
		checkMobileOfPotentialCustomerContactPerson(userContext,  mobile, exception);
		checkDescriptionOfPotentialCustomerContactPerson(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  PotentialCustomer addPotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, String name, String mobile, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPotentialCustomerContactPerson(userContext,potentialCustomerId,name, mobile, description,tokensExpr);
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = createPotentialCustomerContactPerson(userContext,name, mobile, description);
		
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomer.addPotentialCustomerContactPerson( potentialCustomerContactPerson );		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withPotentialCustomerContactPersonList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}
	}
	protected PotentialCustomerContactPerson createPotentialCustomerContactPerson(RetailScmUserContext userContext, String name, String mobile, String description) throws Exception{

		PotentialCustomerContactPerson potentialCustomerContactPerson = new PotentialCustomerContactPerson();
		
		
		potentialCustomerContactPerson.setName(name);		
		potentialCustomerContactPerson.setMobile(mobile);		
		potentialCustomerContactPerson.setDescription(description);
	
		
		return potentialCustomerContactPerson;
	
		
	}
	
	protected PotentialCustomerContactPerson createIndexedPotentialCustomerContactPerson(String id, int version){

		PotentialCustomerContactPerson potentialCustomerContactPerson = new PotentialCustomerContactPerson();
		potentialCustomerContactPerson.setId(id);
		potentialCustomerContactPerson.setVersion(version);
		return potentialCustomerContactPerson;			
		
	}
	protected void checkParamsForRemovingPotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, 
		String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion,String [] tokensExpr) throws Exception{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);
		checkVersionOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PotentialCustomer removePotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, 
		String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPotentialCustomerContactPerson(userContext,potentialCustomerId, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion,tokensExpr);
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = createIndexedPotentialCustomerContactPerson(potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomer.removePotentialCustomerContactPerson( potentialCustomerContactPerson );		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withPotentialCustomerContactPersonList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingPotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, 
		String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion,String [] tokensExpr) throws Exception{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);
		checkVersionOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PotentialCustomer copyPotentialCustomerContactPersonFrom(RetailScmUserContext userContext, String potentialCustomerId, 
		String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPotentialCustomerContactPerson(userContext,potentialCustomerId, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion,tokensExpr);
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = createIndexedPotentialCustomerContactPerson(potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomer.copyPotentialCustomerContactPersonFrom( potentialCustomerContactPerson );		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withPotentialCustomerContactPersonList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingPotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);
		checkVersionOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonVersion, exception);
		

		if(PotentialCustomerContactPerson.NAME_PROPERTY.equals(property)){
			checkNameOfPotentialCustomerContactPerson(userContext, parseString(newValueExpr), exception);
		}
		
		if(PotentialCustomerContactPerson.MOBILE_PROPERTY.equals(property)){
			checkMobileOfPotentialCustomerContactPerson(userContext, parseString(newValueExpr), exception);
		}
		
		if(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfPotentialCustomerContactPerson(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  PotentialCustomer updatePotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPotentialCustomerContactPerson(userContext, potentialCustomerId, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion, property, newValueExpr,  tokensExpr);
		
		
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//potentialCustomer.removePotentialCustomerContactPerson( potentialCustomerContactPerson );	
			//make changes to AcceleraterAccount.
			PotentialCustomerContactPerson potentialCustomerContactPersonIndex = createIndexedPotentialCustomerContactPerson(potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
		
			PotentialCustomerContactPerson potentialCustomerContactPerson = potentialCustomer.findThePotentialCustomerContactPerson(potentialCustomerContactPersonIndex);
			if(potentialCustomerContactPerson == null){
				throw new PotentialCustomerManagerException(potentialCustomerContactPerson+"Not found" );
			}
			
			potentialCustomerContactPerson.changePropery(property, newValueExpr);

			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withPotentialCustomerContactPersonList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description,String [] tokensExpr) throws Exception{
		
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);

		checkNameOfPotentialCustomerContact(userContext,  name, exception);
		checkContactDateOfPotentialCustomerContact(userContext,  contactDate, exception);
		checkContactMethodOfPotentialCustomerContact(userContext,  contactMethod, exception);		
		
		checkIdOfCityPartner(userContext,  cityPartnerId, exception);		
		
		checkIdOfPotentialCustomerContactPerson(userContext,  contactToId, exception);
		checkDescriptionOfPotentialCustomerContact(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  PotentialCustomer addPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPotentialCustomerContact(userContext,potentialCustomerId,name, contactDate, contactMethod, cityPartnerId, contactToId, description,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createPotentialCustomerContact(userContext,name, contactDate, contactMethod, cityPartnerId, contactToId, description);
		
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomer.addPotentialCustomerContact( potentialCustomerContact );		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}
	}
	protected PotentialCustomerContact createPotentialCustomerContact(RetailScmUserContext userContext, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description) throws Exception{

		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		
		
		potentialCustomerContact.setName(name);		
		potentialCustomerContact.setContactDate(contactDate);		
		potentialCustomerContact.setContactMethod(contactMethod);		
		CityPartner  cityPartner = new CityPartner();
		cityPartner.setId(cityPartnerId);		
		potentialCustomerContact.setCityPartner(cityPartner);		
		PotentialCustomerContactPerson  contactTo = new PotentialCustomerContactPerson();
		contactTo.setId(contactToId);		
		potentialCustomerContact.setContactTo(contactTo);		
		potentialCustomerContact.setDescription(description);
	
		
		return potentialCustomerContact;
	
		
	}
	
	protected PotentialCustomerContact createIndexedPotentialCustomerContact(String id, int version){

		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		potentialCustomerContact.setId(id);
		potentialCustomerContact.setVersion(version);
		return potentialCustomerContact;			
		
	}
	protected void checkParamsForRemovingPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		checkVersionOfPotentialCustomerContact(userContext, potentialCustomerContactVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PotentialCustomer removePotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPotentialCustomerContact(userContext,potentialCustomerId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomer.removePotentialCustomerContact( potentialCustomerContact );		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		checkVersionOfPotentialCustomerContact(userContext, potentialCustomerContactVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PotentialCustomer copyPotentialCustomerContactFrom(RetailScmUserContext userContext, String potentialCustomerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPotentialCustomerContact(userContext,potentialCustomerId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomer.copyPotentialCustomerContactFrom( potentialCustomerContact );		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		checkVersionOfPotentialCustomerContact(userContext, potentialCustomerContactVersion, exception);
		

		if(PotentialCustomerContact.NAME_PROPERTY.equals(property)){
			checkNameOfPotentialCustomerContact(userContext, parseString(newValueExpr), exception);
		}
		
		if(PotentialCustomerContact.CONTACT_DATE_PROPERTY.equals(property)){
			checkContactDateOfPotentialCustomerContact(userContext, parseDate(newValueExpr), exception);
		}
		
		if(PotentialCustomerContact.CONTACT_METHOD_PROPERTY.equals(property)){
			checkContactMethodOfPotentialCustomerContact(userContext, parseString(newValueExpr), exception);
		}
		
		if(PotentialCustomerContact.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfPotentialCustomerContact(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  PotentialCustomer updatePotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPotentialCustomerContact(userContext, potentialCustomerId, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr,  tokensExpr);
		
		
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//potentialCustomer.removePotentialCustomerContact( potentialCustomerContact );	
			//make changes to AcceleraterAccount.
			PotentialCustomerContact potentialCustomerContactIndex = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		
			PotentialCustomerContact potentialCustomerContact = potentialCustomer.findThePotentialCustomerContact(potentialCustomerContactIndex);
			if(potentialCustomerContact == null){
				throw new PotentialCustomerManagerException(potentialCustomerContact+"Not found" );
			}
			
			potentialCustomerContact.changePropery(property, newValueExpr);

			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, String name, String cityEventId, String description,String [] tokensExpr) throws Exception{
		
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);

		checkNameOfEventAttendance(userContext,  name, exception);		
		
		checkIdOfCityEvent(userContext,  cityEventId, exception);
		checkDescriptionOfEventAttendance(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  PotentialCustomer addEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, String name, String cityEventId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEventAttendance(userContext,potentialCustomerId,name, cityEventId, description,tokensExpr);
		
		EventAttendance eventAttendance = createEventAttendance(userContext,name, cityEventId, description);
		
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomer.addEventAttendance( eventAttendance );		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withEventAttendanceList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}
	}
	protected EventAttendance createEventAttendance(RetailScmUserContext userContext, String name, String cityEventId, String description) throws Exception{

		EventAttendance eventAttendance = new EventAttendance();
		
		
		eventAttendance.setName(name);		
		CityEvent  cityEvent = new CityEvent();
		cityEvent.setId(cityEventId);		
		eventAttendance.setCityEvent(cityEvent);		
		eventAttendance.setDescription(description);
	
		
		return eventAttendance;
	
		
	}
	
	protected EventAttendance createIndexedEventAttendance(String id, int version){

		EventAttendance eventAttendance = new EventAttendance();
		eventAttendance.setId(id);
		eventAttendance.setVersion(version);
		return eventAttendance;			
		
	}
	protected void checkParamsForRemovingEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkIdOfEventAttendance(userContext, eventAttendanceId, exception);
		checkVersionOfEventAttendance(userContext, eventAttendanceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PotentialCustomer removeEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEventAttendance(userContext,potentialCustomerId, eventAttendanceId, eventAttendanceVersion,tokensExpr);
		
		EventAttendance eventAttendance = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomer.removeEventAttendance( eventAttendance );		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withEventAttendanceList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkIdOfEventAttendance(userContext, eventAttendanceId, exception);
		checkVersionOfEventAttendance(userContext, eventAttendanceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PotentialCustomer copyEventAttendanceFrom(RetailScmUserContext userContext, String potentialCustomerId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEventAttendance(userContext,potentialCustomerId, eventAttendanceId, eventAttendanceVersion,tokensExpr);
		
		EventAttendance eventAttendance = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomer.copyEventAttendanceFrom( eventAttendance );		
			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withEventAttendanceList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		PotentialCustomerManagerException exception = new PotentialCustomerManagerException("Error Occured");
		
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
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
	
	public  PotentialCustomer updateEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEventAttendance(userContext, potentialCustomerId, eventAttendanceId, eventAttendanceVersion, property, newValueExpr,  tokensExpr);
		
		
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId, allTokens());
		
		synchronized(potentialCustomer){ 
			//Will be good when the potentialCustomer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//potentialCustomer.removeEventAttendance( eventAttendance );	
			//make changes to AcceleraterAccount.
			EventAttendance eventAttendanceIndex = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		
			EventAttendance eventAttendance = potentialCustomer.findTheEventAttendance(eventAttendanceIndex);
			if(eventAttendance == null){
				throw new PotentialCustomerManagerException(eventAttendance+"Not found" );
			}
			
			eventAttendance.changePropery(property, newValueExpr);

			potentialCustomer = savePotentialCustomer(userContext, potentialCustomer, tokens().withEventAttendanceList().done());
			return present(userContext,potentialCustomer, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


