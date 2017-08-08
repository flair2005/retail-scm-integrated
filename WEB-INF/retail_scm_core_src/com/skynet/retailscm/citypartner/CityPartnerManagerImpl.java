
package com.skynet.retailscm.citypartner;

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
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;

import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;


import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContactTable;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;




public class CityPartnerManagerImpl extends RetailScmCheckerManager implements CityPartnerManager {
	
	private static final String SERVICE_TYPE = "CityPartner";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  CityPartnerDAO  cityPartnerDAO;
 	public void setCityPartnerDAO(CityPartnerDAO  cityPartnerDAO){
 	
 		if(cityPartnerDAO == null){
 			throw new IllegalStateException("Do not try to set cityPartnerDAO to null.");
 		}
	 	this.cityPartnerDAO = cityPartnerDAO;
 	}
 	public CityPartnerDAO getCityPartnerDAO(){
 		if(this.cityPartnerDAO == null){
 			throw new IllegalStateException("The CityPartnerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityPartnerDAO;
 	}
 	
 	protected CityPartner saveCityPartner(RetailScmUserContext userContext, CityPartner cityPartner, String [] tokensExpr) throws Exception{	
 		//return getCityPartnerDAO().save(cityPartner, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCityPartner(userContext, cityPartner, tokens);
 	}
 	
 	protected CityPartner saveCityPartnerDetail(RetailScmUserContext userContext, CityPartner cityPartner) throws Exception{	

 		
 		return saveCityPartner(userContext, cityPartner, allTokens());
 	}
 	
 	public CityPartner loadCityPartner(RetailScmUserContext userContext, String cityPartnerId, String [] tokensExpr) throws Exception{				
 
 		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CityPartner cityPartner = loadCityPartner( userContext, cityPartnerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityPartner, tokens);
 	}
 	
 	protected CityPartner present(RetailScmUserContext userContext, CityPartner cityPartner, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,cityPartner,tokens);
		
		
		return this.getCityPartnerDAO().present(cityPartner, tokens);
	}
 
 	
 	
 	public CityPartner loadCityPartnerDetail(RetailScmUserContext userContext, String cityPartnerId) throws Exception{	
 		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		CityPartner cityPartner = loadCityPartner( userContext, cityPartnerId, allTokens());

 		return present(userContext,cityPartner, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String cityPartnerId) throws Exception{	
 		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		CityPartner cityPartner = loadCityPartner( userContext, cityPartnerId, allTokens());

 		return present(userContext,cityPartner, allTokens());
		
 	}
 	protected CityPartner saveCityPartner(RetailScmUserContext userContext, CityPartner cityPartner, Map<String,Object>tokens) throws Exception{	
 		return getCityPartnerDAO().save(cityPartner, tokens);
 	}
 	protected CityPartner loadCityPartner(RetailScmUserContext userContext, String cityPartnerId, Map<String,Object>tokens) throws Exception{	
 		return getCityPartnerDAO().load(cityPartnerId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
	 	return this.retailStoreCityServiceCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, CityPartner cityPartner, Map<String, Object> tokens){
		super.addActions(userContext, cityPartner, tokens);
		
		addAction(userContext, cityPartner, tokens,"@create","createCityPartner","createCityPartner/","main","primary");
		addAction(userContext, cityPartner, tokens,"@update","updateCityPartner","updateCityPartner/"+cityPartner.getId()+"/","main","primary");
		addAction(userContext, cityPartner, tokens,"@copy","cloneCityPartner","cloneCityPartner/"+cityPartner.getId()+"/","main","primary");
		
		addAction(userContext, cityPartner, tokens,"city_partner.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+cityPartner.getId()+"/","main","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.addPotentialCustomer","addPotentialCustomer","addPotentialCustomer/"+cityPartner.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.removePotentialCustomer","removePotentialCustomer","removePotentialCustomer/"+cityPartner.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.updatePotentialCustomer","updatePotentialCustomer","updatePotentialCustomer/"+cityPartner.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.copyPotentialCustomerFrom","copyPotentialCustomerFrom","copyPotentialCustomerFrom/"+cityPartner.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.addPotentialCustomerContact","addPotentialCustomerContact","addPotentialCustomerContact/"+cityPartner.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.removePotentialCustomerContact","removePotentialCustomerContact","removePotentialCustomerContact/"+cityPartner.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.updatePotentialCustomerContact","updatePotentialCustomerContact","updatePotentialCustomerContact/"+cityPartner.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom/"+cityPartner.getId()+"/","potentialCustomerContactList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, CityPartner cityPartner, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CityPartner createCityPartner(RetailScmUserContext userContext,String name, String mobile, String cityServiceCenterId, String description
) throws Exception
	{
		
		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");

		

		checkNameOfCityPartner(userContext,  name, exception);
		checkMobileOfCityPartner(userContext,  mobile, exception);
		checkDescriptionOfCityPartner(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		CityPartner cityPartner=createNewCityPartner();	

		cityPartner.setName(name);
		cityPartner.setMobile(mobile);
		RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(cityServiceCenterId,emptyOptions());
		cityPartner.setCityServiceCenter(cityServiceCenter);
		cityPartner.setDescription(description);

		return saveCityPartner(userContext, cityPartner, emptyOptions());
		

		
	}
	protected CityPartner createNewCityPartner() 
	{
		
		return new CityPartner();		
	}
	
	protected void checkParamsForUpdatingCityPartner(RetailScmUserContext userContext,String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		checkVersionOfCityPartner(userContext, cityPartnerVersion, exception);
		

		if(CityPartner.NAME_PROPERTY.equals(property)){
			checkNameOfCityPartner(userContext, parseString(newValueExpr), exception);
		}
		if(CityPartner.MOBILE_PROPERTY.equals(property)){
			checkMobileOfCityPartner(userContext, parseString(newValueExpr), exception);
		}		

		
		if(CityPartner.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfCityPartner(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public CityPartner clone(RetailScmUserContext userContext, String fromCityPartnerId) throws Exception{
		
		return this.getCityPartnerDAO().clone(fromCityPartnerId, this.allTokens());
	}
	
	public CityPartner updateCityPartner(RetailScmUserContext userContext,String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCityPartner(userContext, cityPartnerId, cityPartnerVersion, property, newValueExpr, tokensExpr);
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		if(cityPartner.getVersion() != cityPartnerVersion){
			String message = "The target version("+cityPartner.getVersion()+") is not equals to version("+cityPartnerVersion+") provided";
			throw new CityPartnerManagerException(message);
		}
		synchronized(cityPartner){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityPartner.
			
			cityPartner.changePropery(property, newValueExpr);
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
			//return saveCityPartner(userContext, cityPartner, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CityPartnerTokens tokens(){
		return CityPartnerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CityPartnerTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CityPartnerTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCityServiceCenter(RetailScmUserContext userContext, String cityPartnerId, String anotherCityServiceCenterId) throws Exception
 	{
 		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
 		checkIdOfCityPartner(userContext, cityPartnerId,exception);
 		checkIdOfRetailStoreCityServiceCenter(userContext, anotherCityServiceCenterId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public CityPartner transferToAnotherCityServiceCenter(RetailScmUserContext userContext, String cityPartnerId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, cityPartnerId,anotherCityServiceCenterId);
 
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());	
		synchronized(cityPartner){
			//will be good when the cityPartner loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(anotherCityServiceCenterId, emptyOptions());		
			cityPartner.setCityServiceCenter(cityServiceCenter);		
			cityPartner = saveCityPartner(userContext, cityPartner, emptyOptions());
			
			return present(userContext,cityPartner, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCityServiceCenterDAO().load(newCityServiceCenterId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String cityPartnerId, int cityPartnerVersion) throws Exception {
		
		deleteInternal(userContext, cityPartnerId, cityPartnerVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String cityPartnerId, int cityPartnerVersion) throws Exception{
		getCityPartnerDAO().delete(cityPartnerId, cityPartnerVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CityPartnerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getCityPartnerDAO().deleteAll();
	}

	protected void checkParamsForAddingPotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description,String [] tokensExpr) throws Exception{
		
		

		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);

		checkNameOfPotentialCustomer(userContext,  name, exception);
		checkMobileOfPotentialCustomer(userContext,  mobile, exception);		
		
		checkIdOfRetailStoreCityServiceCenter(userContext,  cityServiceCenterId, exception);
		checkDescriptionOfPotentialCustomer(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  CityPartner addPotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPotentialCustomer(userContext,cityPartnerId,name, mobile, cityServiceCenterId, description,tokensExpr);
		
		PotentialCustomer potentialCustomer = createPotentialCustomer(userContext,name, mobile, cityServiceCenterId, description);
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.addPotentialCustomer( potentialCustomer );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
	}
	protected PotentialCustomer createPotentialCustomer(RetailScmUserContext userContext, String name, String mobile, String cityServiceCenterId, String description) throws Exception{

		PotentialCustomer potentialCustomer = new PotentialCustomer();
		
		
		potentialCustomer.setName(name);		
		potentialCustomer.setMobile(mobile);		
		RetailStoreCityServiceCenter  cityServiceCenter = new RetailStoreCityServiceCenter();
		cityServiceCenter.setId(cityServiceCenterId);		
		potentialCustomer.setCityServiceCenter(cityServiceCenter);		
		potentialCustomer.setDescription(description);
	
		
		return potentialCustomer;
	
		
	}
	
	protected PotentialCustomer createIndexedPotentialCustomer(String id, int version){

		PotentialCustomer potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(id);
		potentialCustomer.setVersion(version);
		return potentialCustomer;			
		
	}
	protected void checkParamsForRemovingPotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		

		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkVersionOfPotentialCustomer(userContext, potentialCustomerVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  CityPartner removePotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPotentialCustomer(userContext,cityPartnerId, potentialCustomerId, potentialCustomerVersion,tokensExpr);
		
		PotentialCustomer potentialCustomer = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.removePotentialCustomer( potentialCustomer );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingPotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		

		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkVersionOfPotentialCustomer(userContext, potentialCustomerVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  CityPartner copyPotentialCustomerFrom(RetailScmUserContext userContext, String cityPartnerId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPotentialCustomer(userContext,cityPartnerId, potentialCustomerId, potentialCustomerVersion,tokensExpr);
		
		PotentialCustomer potentialCustomer = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.copyPotentialCustomerFrom( potentialCustomer );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingPotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
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
	
	public  CityPartner updatePotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPotentialCustomer(userContext, cityPartnerId, potentialCustomerId, potentialCustomerVersion, property, newValueExpr,  tokensExpr);
		
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityPartner.removePotentialCustomer( potentialCustomer );	
			//make changes to AcceleraterAccount.
			PotentialCustomer potentialCustomerIndex = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		
			PotentialCustomer potentialCustomer = cityPartner.findThePotentialCustomer(potentialCustomerIndex);
			if(potentialCustomer == null){
				throw new CityPartnerManagerException(potentialCustomer+"Not found" );
			}
			
			potentialCustomer.changePropery(property, newValueExpr);

			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingPotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description,String [] tokensExpr) throws Exception{
		
		

		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);

		checkNameOfPotentialCustomerContact(userContext,  name, exception);
		checkContactDateOfPotentialCustomerContact(userContext,  contactDate, exception);
		checkContactMethodOfPotentialCustomerContact(userContext,  contactMethod, exception);		
		
		checkIdOfPotentialCustomer(userContext,  potentialCustomerId, exception);		
		
		checkIdOfPotentialCustomerContactPerson(userContext,  contactToId, exception);
		checkDescriptionOfPotentialCustomerContact(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  CityPartner addPotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPotentialCustomerContact(userContext,cityPartnerId,name, contactDate, contactMethod, potentialCustomerId, contactToId, description,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createPotentialCustomerContact(userContext,name, contactDate, contactMethod, potentialCustomerId, contactToId, description);
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.addPotentialCustomerContact( potentialCustomerContact );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
	}
	protected PotentialCustomerContact createPotentialCustomerContact(RetailScmUserContext userContext, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description) throws Exception{

		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		
		
		potentialCustomerContact.setName(name);		
		potentialCustomerContact.setContactDate(contactDate);		
		potentialCustomerContact.setContactMethod(contactMethod);		
		PotentialCustomer  potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(potentialCustomerId);		
		potentialCustomerContact.setPotentialCustomer(potentialCustomer);		
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
	protected void checkParamsForRemovingPotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		

		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		checkVersionOfPotentialCustomerContact(userContext, potentialCustomerContactVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  CityPartner removePotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPotentialCustomerContact(userContext,cityPartnerId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.removePotentialCustomerContact( potentialCustomerContact );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingPotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		

		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		checkIdOfPotentialCustomerContact(userContext, potentialCustomerContactId, exception);
		checkVersionOfPotentialCustomerContact(userContext, potentialCustomerContactVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  CityPartner copyPotentialCustomerContactFrom(RetailScmUserContext userContext, String cityPartnerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPotentialCustomerContact(userContext,cityPartnerId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.copyPotentialCustomerContactFrom( potentialCustomerContact );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingPotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		CityPartnerManagerException exception = new CityPartnerManagerException("Error Occured");
		
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
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
	
	public  CityPartner updatePotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPotentialCustomerContact(userContext, cityPartnerId, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr,  tokensExpr);
		
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityPartner.removePotentialCustomerContact( potentialCustomerContact );	
			//make changes to AcceleraterAccount.
			PotentialCustomerContact potentialCustomerContactIndex = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		
			PotentialCustomerContact potentialCustomerContact = cityPartner.findThePotentialCustomerContact(potentialCustomerContactIndex);
			if(potentialCustomerContact == null){
				throw new CityPartnerManagerException(potentialCustomerContact+"Not found" );
			}
			
			potentialCustomerContact.changePropery(property, newValueExpr);

			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


