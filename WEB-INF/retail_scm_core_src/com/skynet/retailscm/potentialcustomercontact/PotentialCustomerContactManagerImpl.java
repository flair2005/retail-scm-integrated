
package com.skynet.retailscm.potentialcustomercontact;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;

import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;
import com.skynet.retailscm.citypartner.CityPartnerDAO;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerDAO;



import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonTable;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;
import com.skynet.retailscm.citypartner.CityPartnerTable;




public class PotentialCustomerContactManagerImpl extends RetailScmCheckerManager implements PotentialCustomerContactManager {
	
	private static final String SERVICE_TYPE = "PotentialCustomerContact";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  PotentialCustomerContactDAO  potentialCustomerContactDAO;
 	public void setPotentialCustomerContactDAO(PotentialCustomerContactDAO  potentialCustomerContactDAO){
 	
 		if(potentialCustomerContactDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerContactDAO to null.");
 		}
	 	this.potentialCustomerContactDAO = potentialCustomerContactDAO;
 	}
 	public PotentialCustomerContactDAO getPotentialCustomerContactDAO(){
 		if(this.potentialCustomerContactDAO == null){
 			throw new IllegalStateException("The PotentialCustomerContactDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerContactDAO;
 	}
 	
 	protected PotentialCustomerContact savePotentialCustomerContact(RetailScmUserContext userContext, PotentialCustomerContact potentialCustomerContact, String [] tokensExpr) throws Exception{	
 		//return getPotentialCustomerContactDAO().save(potentialCustomerContact, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePotentialCustomerContact(userContext, potentialCustomerContact, tokens);
 	}
 	
 	protected PotentialCustomerContact savePotentialCustomerContactDetail(RetailScmUserContext userContext, PotentialCustomerContact potentialCustomerContact) throws Exception{	

 		
 		return savePotentialCustomerContact(userContext, potentialCustomerContact, allTokens());
 	}
 	
 	public PotentialCustomerContact loadPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactId, String [] tokensExpr) throws Exception{				
 
 		PotentialCustomerContactManagerException exception = new PotentialCustomerContactManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact( userContext, potentialCustomerContactId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,potentialCustomerContact, tokens);
 	}
 	
 	protected PotentialCustomerContact present(RetailScmUserContext userContext, PotentialCustomerContact potentialCustomerContact, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,potentialCustomerContact,tokens);
		
		
		return this.getPotentialCustomerContactDAO().present(potentialCustomerContact, tokens);
	}
 
 	
 	
 	public PotentialCustomerContact loadPotentialCustomerContactDetail(RetailScmUserContext userContext, String potentialCustomerContactId) throws Exception{	
 		PotentialCustomerContactManagerException exception = new PotentialCustomerContactManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact( userContext, potentialCustomerContactId, allTokens());

 		return present(userContext,potentialCustomerContact, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String potentialCustomerContactId) throws Exception{	
 		PotentialCustomerContactManagerException exception = new PotentialCustomerContactManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact( userContext, potentialCustomerContactId, allTokens());

 		return present(userContext,potentialCustomerContact, allTokens());
		
 	}
 	protected PotentialCustomerContact savePotentialCustomerContact(RetailScmUserContext userContext, PotentialCustomerContact potentialCustomerContact, Map<String,Object>tokens) throws Exception{	
 		return getPotentialCustomerContactDAO().save(potentialCustomerContact, tokens);
 	}
 	protected PotentialCustomerContact loadPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactId, Map<String,Object>tokens) throws Exception{	
 		return getPotentialCustomerContactDAO().load(potentialCustomerContactId, tokens);
 	}

	



 	 
 	
 	private  CityPartnerDAO  cityPartnerDAO;
 	public void setCityPartnerDAO(CityPartnerDAO cityPartnerDAO){
	 	this.cityPartnerDAO = cityPartnerDAO;
 	}
 	//------------------------------------
 	public CityPartnerDAO getCityPartnerDAO(){
	 	return this.cityPartnerDAO;
 	}
 
 	
 	private  PotentialCustomerDAO  potentialCustomerDAO;
 	public void setPotentialCustomerDAO(PotentialCustomerDAO potentialCustomerDAO){
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	//------------------------------------
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
	 	return this.potentialCustomerDAO;
 	}
 
 	
 	private  PotentialCustomerContactPersonDAO  potentialCustomerContactPersonDAO;
 	public void setPotentialCustomerContactPersonDAO(PotentialCustomerContactPersonDAO potentialCustomerContactPersonDAO){
	 	this.potentialCustomerContactPersonDAO = potentialCustomerContactPersonDAO;
 	}
 	//------------------------------------
 	public PotentialCustomerContactPersonDAO getPotentialCustomerContactPersonDAO(){
	 	return this.potentialCustomerContactPersonDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PotentialCustomerContact potentialCustomerContact, Map<String, Object> tokens){
		super.addActions(userContext, potentialCustomerContact, tokens);
		
		addAction(userContext, potentialCustomerContact, tokens,"@create","createPotentialCustomerContact","createPotentialCustomerContact/","main","primary");
		addAction(userContext, potentialCustomerContact, tokens,"@update","updatePotentialCustomerContact","updatePotentialCustomerContact/"+potentialCustomerContact.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContact, tokens,"@copy","clonePotentialCustomerContact","clonePotentialCustomerContact/"+potentialCustomerContact.getId()+"/","main","primary");
		
		addAction(userContext, potentialCustomerContact, tokens,"potential_customer_contact.transfer_to_potential_customer","transferToAnotherPotentialCustomer","transferToAnotherPotentialCustomer/"+potentialCustomerContact.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContact, tokens,"potential_customer_contact.transfer_to_city_partner","transferToAnotherCityPartner","transferToAnotherCityPartner/"+potentialCustomerContact.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContact, tokens,"potential_customer_contact.transfer_to_contact_to","transferToAnotherContactTo","transferToAnotherContactTo/"+potentialCustomerContact.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PotentialCustomerContact potentialCustomerContact, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PotentialCustomerContact createPotentialCustomerContact(RetailScmUserContext userContext,String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String contactToId, String description
) throws Exception
	{
		
		PotentialCustomerContactManagerException exception = new PotentialCustomerContactManagerException("Error Occured");

		

		checkNameOfPotentialCustomerContact(userContext,  name, exception);
		checkContactDateOfPotentialCustomerContact(userContext,  contactDate, exception);
		checkContactMethodOfPotentialCustomerContact(userContext,  contactMethod, exception);
		checkDescriptionOfPotentialCustomerContact(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		PotentialCustomerContact potentialCustomerContact=createNewPotentialCustomerContact();	

		potentialCustomerContact.setName(name);
		potentialCustomerContact.setContactDate(contactDate);
		potentialCustomerContact.setContactMethod(contactMethod);
		PotentialCustomer potentialCustomer = loadPotentialCustomer(potentialCustomerId,emptyOptions());
		potentialCustomerContact.setPotentialCustomer(potentialCustomer);
		CityPartner cityPartner = loadCityPartner(cityPartnerId,emptyOptions());
		potentialCustomerContact.setCityPartner(cityPartner);
		PotentialCustomerContactPerson contactTo = loadPotentialCustomerContactPerson(contactToId,emptyOptions());
		potentialCustomerContact.setContactTo(contactTo);
		potentialCustomerContact.setDescription(description);

		return savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());
		

		
	}
	protected PotentialCustomerContact createNewPotentialCustomerContact() 
	{
		
		return new PotentialCustomerContact();		
	}
	
	protected void checkParamsForUpdatingPotentialCustomerContact(RetailScmUserContext userContext,String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		PotentialCustomerContactManagerException exception = new PotentialCustomerContactManagerException("Error Occured");
		
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
	
	
	
	public PotentialCustomerContact clone(RetailScmUserContext userContext, String fromPotentialCustomerContactId) throws Exception{
		
		return this.getPotentialCustomerContactDAO().clone(fromPotentialCustomerContactId, this.allTokens());
	}
	
	public PotentialCustomerContact updatePotentialCustomerContact(RetailScmUserContext userContext,String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPotentialCustomerContact(userContext, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr, tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());
		if(potentialCustomerContact.getVersion() != potentialCustomerContactVersion){
			String message = "The target version("+potentialCustomerContact.getVersion()+") is not equals to version("+potentialCustomerContactVersion+") provided";
			throw new PotentialCustomerContactManagerException(message);
		}
		synchronized(potentialCustomerContact){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PotentialCustomerContact.
			
			potentialCustomerContact.changePropery(property, newValueExpr);
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, tokens().done());
			return present(userContext,potentialCustomerContact, mergedAllTokens(tokensExpr));
			//return savePotentialCustomerContact(userContext, potentialCustomerContact, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PotentialCustomerContactTokens tokens(){
		return PotentialCustomerContactTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PotentialCustomerContactTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PotentialCustomerContactTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherPotentialCustomer(RetailScmUserContext userContext, String potentialCustomerContactId, String anotherPotentialCustomerId) throws Exception
 	{
 		PotentialCustomerContactManagerException exception = new PotentialCustomerContactManagerException("Error Occured");
 		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId,exception);
 		checkIdOfPotentialCustomer(userContext, anotherPotentialCustomerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public PotentialCustomerContact transferToAnotherPotentialCustomer(RetailScmUserContext userContext, String potentialCustomerContactId, String anotherPotentialCustomerId) throws Exception
 	{
 		checkParamsForTransferingAnotherPotentialCustomer(userContext, potentialCustomerContactId,anotherPotentialCustomerId);
 
		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());	
		synchronized(potentialCustomerContact){
			//will be good when the potentialCustomerContact loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PotentialCustomer potentialCustomer = loadPotentialCustomer(anotherPotentialCustomerId, emptyOptions());		
			potentialCustomerContact.setPotentialCustomer(potentialCustomer);		
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());
			
			return present(userContext,potentialCustomerContact, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherCityPartner(RetailScmUserContext userContext, String potentialCustomerContactId, String anotherCityPartnerId) throws Exception
 	{
 		PotentialCustomerContactManagerException exception = new PotentialCustomerContactManagerException("Error Occured");
 		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId,exception);
 		checkIdOfCityPartner(userContext, anotherCityPartnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public PotentialCustomerContact transferToAnotherCityPartner(RetailScmUserContext userContext, String potentialCustomerContactId, String anotherCityPartnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityPartner(userContext, potentialCustomerContactId,anotherCityPartnerId);
 
		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());	
		synchronized(potentialCustomerContact){
			//will be good when the potentialCustomerContact loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CityPartner cityPartner = loadCityPartner(anotherCityPartnerId, emptyOptions());		
			potentialCustomerContact.setCityPartner(cityPartner);		
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());
			
			return present(userContext,potentialCustomerContact, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherContactTo(RetailScmUserContext userContext, String potentialCustomerContactId, String anotherContactToId) throws Exception
 	{
 		PotentialCustomerContactManagerException exception = new PotentialCustomerContactManagerException("Error Occured");
 		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId,exception);
 		checkIdOfPotentialCustomerContactPerson(userContext, anotherContactToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public PotentialCustomerContact transferToAnotherContactTo(RetailScmUserContext userContext, String potentialCustomerContactId, String anotherContactToId) throws Exception
 	{
 		checkParamsForTransferingAnotherContactTo(userContext, potentialCustomerContactId,anotherContactToId);
 
		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());	
		synchronized(potentialCustomerContact){
			//will be good when the potentialCustomerContact loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PotentialCustomerContactPerson contactTo = loadPotentialCustomerContactPerson(anotherContactToId, emptyOptions());		
			potentialCustomerContact.setContactTo(contactTo);		
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());
			
			return present(userContext,potentialCustomerContact, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected CityPartner loadCityPartner(String newCityPartnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getCityPartnerDAO().load(newCityPartnerId, options);
 	}
	
	 	
 	protected PotentialCustomer loadPotentialCustomer(String newPotentialCustomerId, Map<String,Object> options) throws Exception
 	{
		
 		return getPotentialCustomerDAO().load(newPotentialCustomerId, options);
 	}
	
	 	
 	protected PotentialCustomerContactPerson loadPotentialCustomerContactPerson(String newContactToId, Map<String,Object> options) throws Exception
 	{
		
 		return getPotentialCustomerContactPersonDAO().load(newContactToId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String potentialCustomerContactId, int potentialCustomerContactVersion) throws Exception {
		
		deleteInternal(userContext, potentialCustomerContactId, potentialCustomerContactVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String potentialCustomerContactId, int potentialCustomerContactVersion) throws Exception{
		getPotentialCustomerContactDAO().delete(potentialCustomerContactId, potentialCustomerContactVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PotentialCustomerContactManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getPotentialCustomerContactDAO().deleteAll();
	}


}


