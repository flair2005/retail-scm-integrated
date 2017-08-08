
package com.skynet.retailscm.retailstorecityservicecenter;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;

import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpening;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosing;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.skynet.retailscm.citypartner.CityPartner;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreation;


import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTable;
import com.skynet.retailscm.citypartner.CityPartnerTable;
import com.skynet.retailscm.cityevent.CityEventTable;




public class RetailStoreCityServiceCenterManagerImpl extends RetailScmCheckerManager implements RetailStoreCityServiceCenterManager {
	
	private static final String SERVICE_TYPE = "RetailStoreCityServiceCenter";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO){
 	
 		if(retailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCityServiceCenterDAO to null.");
 		}
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
 		if(this.retailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("The RetailStoreCityServiceCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreCityServiceCenterDAO;
 	}
 	
 	protected RetailStoreCityServiceCenter saveRetailStoreCityServiceCenter(RetailScmUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreCityServiceCenterDAO().save(retailStoreCityServiceCenter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens);
 	}
 	
 	protected RetailStoreCityServiceCenter saveRetailStoreCityServiceCenterDetail(RetailScmUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter) throws Exception{	

 		
 		return saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, allTokens());
 	}
 	
 	public RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter( userContext, retailStoreCityServiceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreCityServiceCenter, tokens);
 	}
 	
 	protected RetailStoreCityServiceCenter present(RetailScmUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreCityServiceCenter,tokens);
		
		
		return this.getRetailStoreCityServiceCenterDAO().present(retailStoreCityServiceCenter, tokens);
	}
 
 	
 	
 	public RetailStoreCityServiceCenter loadRetailStoreCityServiceCenterDetail(RetailScmUserContext userContext, String retailStoreCityServiceCenterId) throws Exception{	
 		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter( userContext, retailStoreCityServiceCenterId, allTokens());

 		return present(userContext,retailStoreCityServiceCenter, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreCityServiceCenterId) throws Exception{	
 		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter( userContext, retailStoreCityServiceCenterId, allTokens());

 		return present(userContext,retailStoreCityServiceCenter, allTokens());
		
 	}
 	protected RetailStoreCityServiceCenter saveRetailStoreCityServiceCenter(RetailScmUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreCityServiceCenterDAO().save(retailStoreCityServiceCenter, tokens);
 	}
 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreCityServiceCenterDAO().load(retailStoreCityServiceCenterId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO;
 	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
	 	return this.retailStoreProvinceCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreCityServiceCenter, tokens);
		
		addAction(userContext, retailStoreCityServiceCenter, tokens,"@create","createRetailStoreCityServiceCenter","createRetailStoreCityServiceCenter/","main","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"@update","updateRetailStoreCityServiceCenter","updateRetailStoreCityServiceCenter/"+retailStoreCityServiceCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"@copy","cloneRetailStoreCityServiceCenter","cloneRetailStoreCityServiceCenter/"+retailStoreCityServiceCenter.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+retailStoreCityServiceCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.addCityPartner","addCityPartner","addCityPartner/"+retailStoreCityServiceCenter.getId()+"/","cityPartnerList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.removeCityPartner","removeCityPartner","removeCityPartner/"+retailStoreCityServiceCenter.getId()+"/","cityPartnerList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.updateCityPartner","updateCityPartner","updateCityPartner/"+retailStoreCityServiceCenter.getId()+"/","cityPartnerList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.copyCityPartnerFrom","copyCityPartnerFrom","copyCityPartnerFrom/"+retailStoreCityServiceCenter.getId()+"/","cityPartnerList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.addPotentialCustomer","addPotentialCustomer","addPotentialCustomer/"+retailStoreCityServiceCenter.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.removePotentialCustomer","removePotentialCustomer","removePotentialCustomer/"+retailStoreCityServiceCenter.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.updatePotentialCustomer","updatePotentialCustomer","updatePotentialCustomer/"+retailStoreCityServiceCenter.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.copyPotentialCustomerFrom","copyPotentialCustomerFrom","copyPotentialCustomerFrom/"+retailStoreCityServiceCenter.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.addCityEvent","addCityEvent","addCityEvent/"+retailStoreCityServiceCenter.getId()+"/","cityEventList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.removeCityEvent","removeCityEvent","removeCityEvent/"+retailStoreCityServiceCenter.getId()+"/","cityEventList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.updateCityEvent","updateCityEvent","updateCityEvent/"+retailStoreCityServiceCenter.getId()+"/","cityEventList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.copyCityEventFrom","copyCityEventFrom","copyCityEventFrom/"+retailStoreCityServiceCenter.getId()+"/","cityEventList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.addRetailStore","addRetailStore","addRetailStore/"+retailStoreCityServiceCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreCityServiceCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreCityServiceCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCityServiceCenter, tokens,"retail_store_city_service_center.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreCityServiceCenter.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(RetailScmUserContext userContext,String name, Date founded, String belongsToId
) throws Exception
	{
		
		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");

		

		checkNameOfRetailStoreCityServiceCenter(userContext,  name, exception);
		checkFoundedOfRetailStoreCityServiceCenter(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreCityServiceCenter retailStoreCityServiceCenter=createNewRetailStoreCityServiceCenter();	

		retailStoreCityServiceCenter.setName(name);
		retailStoreCityServiceCenter.setFounded(founded);
		RetailStoreProvinceCenter belongsTo = loadRetailStoreProvinceCenter(belongsToId,emptyOptions());
		retailStoreCityServiceCenter.setBelongsTo(belongsTo);

		return saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, emptyOptions());
		

		
	}
	protected RetailStoreCityServiceCenter createNewRetailStoreCityServiceCenter() 
	{
		
		return new RetailStoreCityServiceCenter();		
	}
	
	protected void checkParamsForUpdatingRetailStoreCityServiceCenter(RetailScmUserContext userContext,String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkVersionOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterVersion, exception);
		

		if(RetailStoreCityServiceCenter.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreCityServiceCenter(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreCityServiceCenter.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfRetailStoreCityServiceCenter(userContext, parseDate(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreCityServiceCenter clone(RetailScmUserContext userContext, String fromRetailStoreCityServiceCenterId) throws Exception{
		
		return this.getRetailStoreCityServiceCenterDAO().clone(fromRetailStoreCityServiceCenterId, this.allTokens());
	}
	
	public RetailStoreCityServiceCenter updateRetailStoreCityServiceCenter(RetailScmUserContext userContext,String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		if(retailStoreCityServiceCenter.getVersion() != retailStoreCityServiceCenterVersion){
			String message = "The target version("+retailStoreCityServiceCenter.getVersion()+") is not equals to version("+retailStoreCityServiceCenterVersion+") provided";
			throw new RetailStoreCityServiceCenterManagerException(message);
		}
		synchronized(retailStoreCityServiceCenter){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreCityServiceCenter.
			
			retailStoreCityServiceCenter.changePropery(property, newValueExpr);
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
			//return saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreCityServiceCenterTokens tokens(){
		return RetailStoreCityServiceCenterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreCityServiceCenterTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreCityServiceCenterTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String anotherBelongsToId) throws Exception
 	{
 		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
 		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId,exception);
 		checkIdOfRetailStoreProvinceCenter(userContext, anotherBelongsToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreCityServiceCenter transferToAnotherBelongsTo(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, retailStoreCityServiceCenterId,anotherBelongsToId);
 
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());	
		synchronized(retailStoreCityServiceCenter){
			//will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreProvinceCenter belongsTo = loadRetailStoreProvinceCenter(anotherBelongsToId, emptyOptions());		
			retailStoreCityServiceCenter.setBelongsTo(belongsTo);		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, emptyOptions());
			
			return present(userContext,retailStoreCityServiceCenter, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreProvinceCenterDAO().load(newBelongsToId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion) throws Exception{
		getRetailStoreCityServiceCenterDAO().delete(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreCityServiceCenterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreCityServiceCenterDAO().deleteAll();
	}

	protected void checkParamsForAddingCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);

		checkNameOfCityPartner(userContext,  name, exception);
		checkMobileOfCityPartner(userContext,  mobile, exception);
		checkDescriptionOfCityPartner(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCityServiceCenter addCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCityPartner(userContext,retailStoreCityServiceCenterId,name, mobile, description,tokensExpr);
		
		CityPartner cityPartner = createCityPartner(userContext,name, mobile, description);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.addCityPartner( cityPartner );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withCityPartnerList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected CityPartner createCityPartner(RetailScmUserContext userContext, String name, String mobile, String description) throws Exception{

		CityPartner cityPartner = new CityPartner();
		
		
		cityPartner.setName(name);		
		cityPartner.setMobile(mobile);		
		cityPartner.setDescription(description);
	
		
		return cityPartner;
	
		
	}
	
	protected CityPartner createIndexedCityPartner(String id, int version){

		CityPartner cityPartner = new CityPartner();
		cityPartner.setId(id);
		cityPartner.setVersion(version);
		return cityPartner;			
		
	}
	protected void checkParamsForRemovingCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String cityPartnerId, int cityPartnerVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		checkVersionOfCityPartner(userContext, cityPartnerVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCityServiceCenter removeCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String cityPartnerId, int cityPartnerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCityPartner(userContext,retailStoreCityServiceCenterId, cityPartnerId, cityPartnerVersion,tokensExpr);
		
		CityPartner cityPartner = createIndexedCityPartner(cityPartnerId, cityPartnerVersion);
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.removeCityPartner( cityPartner );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withCityPartnerList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String cityPartnerId, int cityPartnerVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkIdOfCityPartner(userContext, cityPartnerId, exception);
		checkVersionOfCityPartner(userContext, cityPartnerVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCityServiceCenter copyCityPartnerFrom(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String cityPartnerId, int cityPartnerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCityPartner(userContext,retailStoreCityServiceCenterId, cityPartnerId, cityPartnerVersion,tokensExpr);
		
		CityPartner cityPartner = createIndexedCityPartner(cityPartnerId, cityPartnerVersion);
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.copyCityPartnerFrom( cityPartner );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withCityPartnerList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
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
	
	public  RetailStoreCityServiceCenter updateCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCityPartner(userContext, retailStoreCityServiceCenterId, cityPartnerId, cityPartnerVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCityServiceCenter.removeCityPartner( cityPartner );	
			//make changes to AcceleraterAccount.
			CityPartner cityPartnerIndex = createIndexedCityPartner(cityPartnerId, cityPartnerVersion);
		
			CityPartner cityPartner = retailStoreCityServiceCenter.findTheCityPartner(cityPartnerIndex);
			if(cityPartner == null){
				throw new RetailStoreCityServiceCenterManagerException(cityPartner+"Not found" );
			}
			
			cityPartner.changePropery(property, newValueExpr);

			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withCityPartnerList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingPotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String cityPartnerId, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);

		checkNameOfPotentialCustomer(userContext,  name, exception);
		checkMobileOfPotentialCustomer(userContext,  mobile, exception);		
		
		checkIdOfCityPartner(userContext,  cityPartnerId, exception);
		checkDescriptionOfPotentialCustomer(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCityServiceCenter addPotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String cityPartnerId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPotentialCustomer(userContext,retailStoreCityServiceCenterId,name, mobile, cityPartnerId, description,tokensExpr);
		
		PotentialCustomer potentialCustomer = createPotentialCustomer(userContext,name, mobile, cityPartnerId, description);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.addPotentialCustomer( potentialCustomer );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withPotentialCustomerList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected PotentialCustomer createPotentialCustomer(RetailScmUserContext userContext, String name, String mobile, String cityPartnerId, String description) throws Exception{

		PotentialCustomer potentialCustomer = new PotentialCustomer();
		
		
		potentialCustomer.setName(name);		
		potentialCustomer.setMobile(mobile);		
		CityPartner  cityPartner = new CityPartner();
		cityPartner.setId(cityPartnerId);		
		potentialCustomer.setCityPartner(cityPartner);		
		potentialCustomer.setDescription(description);
	
		
		return potentialCustomer;
	
		
	}
	
	protected PotentialCustomer createIndexedPotentialCustomer(String id, int version){

		PotentialCustomer potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(id);
		potentialCustomer.setVersion(version);
		return potentialCustomer;			
		
	}
	protected void checkParamsForRemovingPotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkVersionOfPotentialCustomer(userContext, potentialCustomerVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCityServiceCenter removePotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPotentialCustomer(userContext,retailStoreCityServiceCenterId, potentialCustomerId, potentialCustomerVersion,tokensExpr);
		
		PotentialCustomer potentialCustomer = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.removePotentialCustomer( potentialCustomer );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withPotentialCustomerList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingPotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkIdOfPotentialCustomer(userContext, potentialCustomerId, exception);
		checkVersionOfPotentialCustomer(userContext, potentialCustomerVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCityServiceCenter copyPotentialCustomerFrom(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPotentialCustomer(userContext,retailStoreCityServiceCenterId, potentialCustomerId, potentialCustomerVersion,tokensExpr);
		
		PotentialCustomer potentialCustomer = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.copyPotentialCustomerFrom( potentialCustomer );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withPotentialCustomerList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingPotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
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
	
	public  RetailStoreCityServiceCenter updatePotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPotentialCustomer(userContext, retailStoreCityServiceCenterId, potentialCustomerId, potentialCustomerVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCityServiceCenter.removePotentialCustomer( potentialCustomer );	
			//make changes to AcceleraterAccount.
			PotentialCustomer potentialCustomerIndex = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		
			PotentialCustomer potentialCustomer = retailStoreCityServiceCenter.findThePotentialCustomer(potentialCustomerIndex);
			if(potentialCustomer == null){
				throw new RetailStoreCityServiceCenterManagerException(potentialCustomer+"Not found" );
			}
			
			potentialCustomer.changePropery(property, newValueExpr);

			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withPotentialCustomerList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);

		checkNameOfCityEvent(userContext,  name, exception);
		checkMobileOfCityEvent(userContext,  mobile, exception);
		checkDescriptionOfCityEvent(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCityServiceCenter addCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCityEvent(userContext,retailStoreCityServiceCenterId,name, mobile, description,tokensExpr);
		
		CityEvent cityEvent = createCityEvent(userContext,name, mobile, description);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.addCityEvent( cityEvent );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withCityEventList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected CityEvent createCityEvent(RetailScmUserContext userContext, String name, String mobile, String description) throws Exception{

		CityEvent cityEvent = new CityEvent();
		
		
		cityEvent.setName(name);		
		cityEvent.setMobile(mobile);		
		cityEvent.setDescription(description);
	
		
		return cityEvent;
	
		
	}
	
	protected CityEvent createIndexedCityEvent(String id, int version){

		CityEvent cityEvent = new CityEvent();
		cityEvent.setId(id);
		cityEvent.setVersion(version);
		return cityEvent;			
		
	}
	protected void checkParamsForRemovingCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String cityEventId, int cityEventVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkIdOfCityEvent(userContext, cityEventId, exception);
		checkVersionOfCityEvent(userContext, cityEventVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCityServiceCenter removeCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String cityEventId, int cityEventVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCityEvent(userContext,retailStoreCityServiceCenterId, cityEventId, cityEventVersion,tokensExpr);
		
		CityEvent cityEvent = createIndexedCityEvent(cityEventId, cityEventVersion);
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.removeCityEvent( cityEvent );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withCityEventList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String cityEventId, int cityEventVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkIdOfCityEvent(userContext, cityEventId, exception);
		checkVersionOfCityEvent(userContext, cityEventVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCityServiceCenter copyCityEventFrom(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String cityEventId, int cityEventVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCityEvent(userContext,retailStoreCityServiceCenterId, cityEventId, cityEventVersion,tokensExpr);
		
		CityEvent cityEvent = createIndexedCityEvent(cityEventId, cityEventVersion);
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.copyCityEventFrom( cityEvent );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withCityEventList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
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
	
	public  RetailStoreCityServiceCenter updateCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCityEvent(userContext, retailStoreCityServiceCenterId, cityEventId, cityEventVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCityServiceCenter.removeCityEvent( cityEvent );	
			//make changes to AcceleraterAccount.
			CityEvent cityEventIndex = createIndexedCityEvent(cityEventId, cityEventVersion);
		
			CityEvent cityEvent = retailStoreCityServiceCenter.findTheCityEvent(cityEventIndex);
			if(cityEvent == null){
				throw new RetailStoreCityServiceCenterManagerException(cityEvent+"Not found" );
			}
			
			cityEvent.changePropery(property, newValueExpr);

			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withCityEventList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String telephone, String owner, String retailStoreCountryCenterId, Date founded, double latitude, double longitude, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);

		checkNameOfRetailStore(userContext,  name, exception);
		checkTelephoneOfRetailStore(userContext,  telephone, exception);
		checkOwnerOfRetailStore(userContext,  owner, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  retailStoreCountryCenterId, exception);
		checkFoundedOfRetailStore(userContext,  founded, exception);
		checkLatitudeOfRetailStore(userContext,  latitude, exception);
		checkLongitudeOfRetailStore(userContext,  longitude, exception);
		checkDescriptionOfRetailStore(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCityServiceCenter addRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String telephone, String owner, String retailStoreCountryCenterId, Date founded, double latitude, double longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreCityServiceCenterId,name, telephone, owner, retailStoreCountryCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, founded, latitude, longitude, description);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.addRetailStore( retailStore );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStore createRetailStore(RetailScmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, Date founded, double latitude, double longitude, String description) throws Exception{

		RetailStore retailStore = new RetailStore();
		
		
		retailStore.setName(name);		
		retailStore.setTelephone(telephone);		
		retailStore.setOwner(owner);		
		RetailStoreCountryCenter  retailStoreCountryCenter = new RetailStoreCountryCenter();
		retailStoreCountryCenter.setId(retailStoreCountryCenterId);		
		retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);		
		retailStore.setFounded(founded);		
		retailStore.setLatitude(latitude);		
		retailStore.setLongitude(longitude);		
		retailStore.setDescription(description);
	
		
		return retailStore;
	
		
	}
	
	protected RetailStore createIndexedRetailStore(String id, int version){

		RetailStore retailStore = new RetailStore();
		retailStore.setId(id);
		retailStore.setVersion(version);
		return retailStore;			
		
	}
	protected void checkParamsForRemovingRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCityServiceCenter removeRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreCityServiceCenterId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.removeRetailStore( retailStore );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCityServiceCenter copyRetailStoreFrom(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreCityServiceCenterId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCityServiceCenter.copyRetailStoreFrom( retailStore );		
			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCityServiceCenterManagerException exception = new RetailStoreCityServiceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);
		

		if(RetailStore.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
			checkTelephoneOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStore.OWNER_PROPERTY.equals(property)){
			checkOwnerOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfRetailStore(userContext, parseDate(newValueExpr), exception);
		}
		
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfRetailStore(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfRetailStore(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCityServiceCenter updateRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreCityServiceCenterId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
		
		synchronized(retailStoreCityServiceCenter){ 
			//Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCityServiceCenter.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreCityServiceCenter.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreCityServiceCenterManagerException(retailStore+"Not found" );
			}
			
			retailStore.changePropery(property, newValueExpr);

			retailStoreCityServiceCenter = saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


