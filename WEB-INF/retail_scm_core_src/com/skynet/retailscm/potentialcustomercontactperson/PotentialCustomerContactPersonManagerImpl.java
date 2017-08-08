
package com.skynet.retailscm.potentialcustomercontactperson;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;

import com.skynet.retailscm.potentialcustomer.PotentialCustomerDAO;

import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;


import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContactTable;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;




public class PotentialCustomerContactPersonManagerImpl extends RetailScmCheckerManager implements PotentialCustomerContactPersonManager {
	
	private static final String SERVICE_TYPE = "PotentialCustomerContactPerson";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  PotentialCustomerContactPersonDAO  potentialCustomerContactPersonDAO;
 	public void setPotentialCustomerContactPersonDAO(PotentialCustomerContactPersonDAO  potentialCustomerContactPersonDAO){
 	
 		if(potentialCustomerContactPersonDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerContactPersonDAO to null.");
 		}
	 	this.potentialCustomerContactPersonDAO = potentialCustomerContactPersonDAO;
 	}
 	public PotentialCustomerContactPersonDAO getPotentialCustomerContactPersonDAO(){
 		if(this.potentialCustomerContactPersonDAO == null){
 			throw new IllegalStateException("The PotentialCustomerContactPersonDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerContactPersonDAO;
 	}
 	
 	protected PotentialCustomerContactPerson savePotentialCustomerContactPerson(RetailScmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, String [] tokensExpr) throws Exception{	
 		//return getPotentialCustomerContactPersonDAO().save(potentialCustomerContactPerson, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens);
 	}
 	
 	protected PotentialCustomerContactPerson savePotentialCustomerContactPersonDetail(RetailScmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson) throws Exception{	

 		
 		return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, allTokens());
 	}
 	
 	public PotentialCustomerContactPerson loadPotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String [] tokensExpr) throws Exception{				
 
 		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson( userContext, potentialCustomerContactPersonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,potentialCustomerContactPerson, tokens);
 	}
 	
 	protected PotentialCustomerContactPerson present(RetailScmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,potentialCustomerContactPerson,tokens);
		
		
		return this.getPotentialCustomerContactPersonDAO().present(potentialCustomerContactPerson, tokens);
	}
 
 	
 	
 	public PotentialCustomerContactPerson loadPotentialCustomerContactPersonDetail(RetailScmUserContext userContext, String potentialCustomerContactPersonId) throws Exception{	
 		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson( userContext, potentialCustomerContactPersonId, allTokens());

 		return present(userContext,potentialCustomerContactPerson, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String potentialCustomerContactPersonId) throws Exception{	
 		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson( userContext, potentialCustomerContactPersonId, allTokens());

 		return present(userContext,potentialCustomerContactPerson, allTokens());
		
 	}
 	protected PotentialCustomerContactPerson savePotentialCustomerContactPerson(RetailScmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object>tokens) throws Exception{	
 		return getPotentialCustomerContactPersonDAO().save(potentialCustomerContactPerson, tokens);
 	}
 	protected PotentialCustomerContactPerson loadPotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerContactPersonId, Map<String,Object>tokens) throws Exception{	
 		return getPotentialCustomerContactPersonDAO().load(potentialCustomerContactPersonId, tokens);
 	}

	



 	 
 	
 	private  PotentialCustomerDAO  potentialCustomerDAO;
 	public void setPotentialCustomerDAO(PotentialCustomerDAO potentialCustomerDAO){
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	//------------------------------------
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
	 	return this.potentialCustomerDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String, Object> tokens){
		super.addActions(userContext, potentialCustomerContactPerson, tokens);
		
		addAction(userContext, potentialCustomerContactPerson, tokens,"@create","createPotentialCustomerContactPerson","createPotentialCustomerContactPerson/","main","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"@update","updatePotentialCustomerContactPerson","updatePotentialCustomerContactPerson/"+potentialCustomerContactPerson.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"@copy","clonePotentialCustomerContactPerson","clonePotentialCustomerContactPerson/"+potentialCustomerContactPerson.getId()+"/","main","primary");
		
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.transfer_to_potential_customer","transferToAnotherPotentialCustomer","transferToAnotherPotentialCustomer/"+potentialCustomerContactPerson.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.addPotentialCustomerContact","addPotentialCustomerContact","addPotentialCustomerContact/"+potentialCustomerContactPerson.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.removePotentialCustomerContact","removePotentialCustomerContact","removePotentialCustomerContact/"+potentialCustomerContactPerson.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.updatePotentialCustomerContact","updatePotentialCustomerContact","updatePotentialCustomerContact/"+potentialCustomerContactPerson.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom/"+potentialCustomerContactPerson.getId()+"/","potentialCustomerContactList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(RetailScmUserContext userContext,String name, String mobile, String potentialCustomerId, String description
) throws Exception
	{
		
		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");

		

		checkNameOfPotentialCustomerContactPerson(userContext,  name, exception);
		checkMobileOfPotentialCustomerContactPerson(userContext,  mobile, exception);
		checkDescriptionOfPotentialCustomerContactPerson(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		PotentialCustomerContactPerson potentialCustomerContactPerson=createNewPotentialCustomerContactPerson();	

		potentialCustomerContactPerson.setName(name);
		potentialCustomerContactPerson.setMobile(mobile);
		PotentialCustomer potentialCustomer = loadPotentialCustomer(potentialCustomerId,emptyOptions());
		potentialCustomerContactPerson.setPotentialCustomer(potentialCustomer);
		potentialCustomerContactPerson.setDescription(description);

		return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, emptyOptions());
		

		
	}
	protected PotentialCustomerContactPerson createNewPotentialCustomerContactPerson() 
	{
		
		return new PotentialCustomerContactPerson();		
	}
	
	protected void checkParamsForUpdatingPotentialCustomerContactPerson(RetailScmUserContext userContext,String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");
		
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
	
	
	
	public PotentialCustomerContactPerson clone(RetailScmUserContext userContext, String fromPotentialCustomerContactPersonId) throws Exception{
		
		return this.getPotentialCustomerContactPersonDAO().clone(fromPotentialCustomerContactPersonId, this.allTokens());
	}
	
	public PotentialCustomerContactPerson updatePotentialCustomerContactPerson(RetailScmUserContext userContext,String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion, property, newValueExpr, tokensExpr);
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		if(potentialCustomerContactPerson.getVersion() != potentialCustomerContactPersonVersion){
			String message = "The target version("+potentialCustomerContactPerson.getVersion()+") is not equals to version("+potentialCustomerContactPersonVersion+") provided";
			throw new PotentialCustomerContactPersonManagerException(message);
		}
		synchronized(potentialCustomerContactPerson){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PotentialCustomerContactPerson.
			
			potentialCustomerContactPerson.changePropery(property, newValueExpr);
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().done());
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
			//return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PotentialCustomerContactPersonTokens tokens(){
		return PotentialCustomerContactPersonTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PotentialCustomerContactPersonTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PotentialCustomerContactPersonTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherPotentialCustomer(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String anotherPotentialCustomerId) throws Exception
 	{
 		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");
 		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId,exception);
 		checkIdOfPotentialCustomer(userContext, anotherPotentialCustomerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public PotentialCustomerContactPerson transferToAnotherPotentialCustomer(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String anotherPotentialCustomerId) throws Exception
 	{
 		checkParamsForTransferingAnotherPotentialCustomer(userContext, potentialCustomerContactPersonId,anotherPotentialCustomerId);
 
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());	
		synchronized(potentialCustomerContactPerson){
			//will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PotentialCustomer potentialCustomer = loadPotentialCustomer(anotherPotentialCustomerId, emptyOptions());		
			potentialCustomerContactPerson.setPotentialCustomer(potentialCustomer);		
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, emptyOptions());
			
			return present(userContext,potentialCustomerContactPerson, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected PotentialCustomer loadPotentialCustomer(String newPotentialCustomerId, Map<String,Object> options) throws Exception
 	{
		
 		return getPotentialCustomerDAO().load(newPotentialCustomerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception {
		
		deleteInternal(userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception{
		getPotentialCustomerContactPersonDAO().delete(potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PotentialCustomerContactPersonManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getPotentialCustomerContactPersonDAO().deleteAll();
	}

	protected void checkParamsForAddingPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description,String [] tokensExpr) throws Exception{
		
		

		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);

		checkNameOfPotentialCustomerContact(userContext,  name, exception);
		checkContactDateOfPotentialCustomerContact(userContext,  contactDate, exception);
		checkContactMethodOfPotentialCustomerContact(userContext,  contactMethod, exception);		
		
		checkIdOfPotentialCustomer(userContext,  potentialCustomerId, exception);		
		
		checkIdOfCityPartner(userContext,  cityPartnerId, exception);
		checkDescriptionOfPotentialCustomerContact(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  PotentialCustomerContactPerson addPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPotentialCustomerContact(userContext,potentialCustomerContactPersonId,name, contactDate, contactMethod, potentialCustomerId, cityPartnerId, description,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createPotentialCustomerContact(userContext,name, contactDate, contactMethod, potentialCustomerId, cityPartnerId, description);
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		synchronized(potentialCustomerContactPerson){ 
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomerContactPerson.addPotentialCustomerContact( potentialCustomerContact );		
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}
	}
	protected PotentialCustomerContact createPotentialCustomerContact(RetailScmUserContext userContext, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description) throws Exception{

		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		
		
		potentialCustomerContact.setName(name);		
		potentialCustomerContact.setContactDate(contactDate);		
		potentialCustomerContact.setContactMethod(contactMethod);		
		PotentialCustomer  potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(potentialCustomerId);		
		potentialCustomerContact.setPotentialCustomer(potentialCustomer);		
		CityPartner  cityPartner = new CityPartner();
		cityPartner.setId(cityPartnerId);		
		potentialCustomerContact.setCityPartner(cityPartner);		
		potentialCustomerContact.setDescription(description);
	
		
		return potentialCustomerContact;
	
		
	}
	
	protected PotentialCustomerContact createIndexedPotentialCustomerContact(String id, int version){

		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		potentialCustomerContact.setId(id);
		potentialCustomerContact.setVersion(version);
		return potentialCustomerContact;			
		
	}
	protected void checkParamsForRemovingPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		

		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		checkVersionOfPotentialCustomerContact(userContext, potentialCustomerContactVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PotentialCustomerContactPerson removePotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPotentialCustomerContact(userContext,potentialCustomerContactPersonId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		synchronized(potentialCustomerContactPerson){ 
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomerContactPerson.removePotentialCustomerContact( potentialCustomerContact );		
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		

		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		checkVersionOfPotentialCustomerContact(userContext, potentialCustomerContactVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PotentialCustomerContactPerson copyPotentialCustomerContactFrom(RetailScmUserContext userContext, String potentialCustomerContactPersonId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPotentialCustomerContact(userContext,potentialCustomerContactPersonId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		synchronized(potentialCustomerContactPerson){ 
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomerContactPerson.copyPotentialCustomerContactFrom( potentialCustomerContact );		
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		PotentialCustomerContactPersonManagerException exception = new PotentialCustomerContactPersonManagerException("Error Occured");
		
		checkIdOfPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, exception);
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
	
	public  PotentialCustomerContactPerson updatePotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPotentialCustomerContact(userContext, potentialCustomerContactPersonId, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr,  tokensExpr);
		
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		
		synchronized(potentialCustomerContactPerson){ 
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//potentialCustomerContactPerson.removePotentialCustomerContact( potentialCustomerContact );	
			//make changes to AcceleraterAccount.
			PotentialCustomerContact potentialCustomerContactIndex = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		
			PotentialCustomerContact potentialCustomerContact = potentialCustomerContactPerson.findThePotentialCustomerContact(potentialCustomerContactIndex);
			if(potentialCustomerContact == null){
				throw new PotentialCustomerContactPersonManagerException(potentialCustomerContact+"Not found" );
			}
			
			potentialCustomerContact.changePropery(property, newValueExpr);

			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


