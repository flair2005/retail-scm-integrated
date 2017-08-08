
package com.skynet.retailscm.retailstoreprovincecenter;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployeeTable;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartmentTable;




public class RetailStoreProvinceCenterManagerImpl extends RetailScmCheckerManager implements RetailStoreProvinceCenterManager {
	
	private static final String SERVICE_TYPE = "RetailStoreProvinceCenter";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO;
 	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO){
 	
 		if(retailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreProvinceCenterDAO to null.");
 		}
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
 		if(this.retailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("The RetailStoreProvinceCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreProvinceCenterDAO;
 	}
 	
 	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(RetailScmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreProvinceCenterDAO().save(retailStoreProvinceCenter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens);
 	}
 	
 	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenterDetail(RetailScmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter) throws Exception{	

 		
 		return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, allTokens());
 	}
 	
 	public RetailStoreProvinceCenter loadRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreProvinceCenter, tokens);
 	}
 	
 	protected RetailStoreProvinceCenter present(RetailScmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreProvinceCenter,tokens);
		
		
		return this.getRetailStoreProvinceCenterDAO().present(retailStoreProvinceCenter, tokens);
	}
 
 	
 	
 	public RetailStoreProvinceCenter loadRetailStoreProvinceCenterDetail(RetailScmUserContext userContext, String retailStoreProvinceCenterId) throws Exception{	
 		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, allTokens());

 		return present(userContext,retailStoreProvinceCenter, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreProvinceCenterId) throws Exception{	
 		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, allTokens());

 		return present(userContext,retailStoreProvinceCenter, allTokens());
		
 	}
 	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(RetailScmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreProvinceCenterDAO().save(retailStoreProvinceCenter, tokens);
 	}
 	protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreProvinceCenterDAO().load(retailStoreProvinceCenterId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreProvinceCenter, tokens);
		
		addAction(userContext, retailStoreProvinceCenter, tokens,"@create","createRetailStoreProvinceCenter","createRetailStoreProvinceCenter/","main","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"@update","updateRetailStoreProvinceCenter","updateRetailStoreProvinceCenter/"+retailStoreProvinceCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"@copy","cloneRetailStoreProvinceCenter","cloneRetailStoreProvinceCenter/"+retailStoreProvinceCenter.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.transfer_to_country","transferToAnotherCountry","transferToAnotherCountry/"+retailStoreProvinceCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.addProvinceCenterDepartment","addProvinceCenterDepartment","addProvinceCenterDepartment/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.removeProvinceCenterDepartment","removeProvinceCenterDepartment","removeProvinceCenterDepartment/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.updateProvinceCenterDepartment","updateProvinceCenterDepartment","updateProvinceCenterDepartment/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.copyProvinceCenterDepartmentFrom","copyProvinceCenterDepartmentFrom","copyProvinceCenterDepartmentFrom/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.addProvinceCenterEmployee","addProvinceCenterEmployee","addProvinceCenterEmployee/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.removeProvinceCenterEmployee","removeProvinceCenterEmployee","removeProvinceCenterEmployee/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.updateProvinceCenterEmployee","updateProvinceCenterEmployee","updateProvinceCenterEmployee/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.addRetailStoreCityServiceCenter","addRetailStoreCityServiceCenter","addRetailStoreCityServiceCenter/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.removeRetailStoreCityServiceCenter","removeRetailStoreCityServiceCenter","removeRetailStoreCityServiceCenter/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.updateRetailStoreCityServiceCenter","updateRetailStoreCityServiceCenter","updateRetailStoreCityServiceCenter/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.copyRetailStoreCityServiceCenterFrom","copyRetailStoreCityServiceCenterFrom","copyRetailStoreCityServiceCenterFrom/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreProvinceCenter createRetailStoreProvinceCenter(RetailScmUserContext userContext,String name, Date founded, String countryId
) throws Exception
	{
		
		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");

		

		checkNameOfRetailStoreProvinceCenter(userContext,  name, exception);
		checkFoundedOfRetailStoreProvinceCenter(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreProvinceCenter retailStoreProvinceCenter=createNewRetailStoreProvinceCenter();	

		retailStoreProvinceCenter.setName(name);
		retailStoreProvinceCenter.setFounded(founded);
		RetailStoreCountryCenter country = loadRetailStoreCountryCenter(countryId,emptyOptions());
		retailStoreProvinceCenter.setCountry(country);

		return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, emptyOptions());
		

		
	}
	protected RetailStoreProvinceCenter createNewRetailStoreProvinceCenter() 
	{
		
		return new RetailStoreProvinceCenter();		
	}
	
	protected void checkParamsForUpdatingRetailStoreProvinceCenter(RetailScmUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkVersionOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterVersion, exception);
		

		if(RetailStoreProvinceCenter.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreProvinceCenter(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreProvinceCenter.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfRetailStoreProvinceCenter(userContext, parseDate(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreProvinceCenter clone(RetailScmUserContext userContext, String fromRetailStoreProvinceCenterId) throws Exception{
		
		return this.getRetailStoreProvinceCenterDAO().clone(fromRetailStoreProvinceCenterId, this.allTokens());
	}
	
	public RetailStoreProvinceCenter updateRetailStoreProvinceCenter(RetailScmUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		if(retailStoreProvinceCenter.getVersion() != retailStoreProvinceCenterVersion){
			String message = "The target version("+retailStoreProvinceCenter.getVersion()+") is not equals to version("+retailStoreProvinceCenterVersion+") provided";
			throw new RetailStoreProvinceCenterManagerException(message);
		}
		synchronized(retailStoreProvinceCenter){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreProvinceCenter.
			
			retailStoreProvinceCenter.changePropery(property, newValueExpr);
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			//return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreProvinceCenterTokens tokens(){
		return RetailStoreProvinceCenterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreProvinceCenterTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreProvinceCenterTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCountry(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId) throws Exception
 	{
 		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
 		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCountryId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreProvinceCenter transferToAnotherCountry(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId) throws Exception
 	{
 		checkParamsForTransferingAnotherCountry(userContext, retailStoreProvinceCenterId,anotherCountryId);
 
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());	
		synchronized(retailStoreProvinceCenter){
			//will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter country = loadRetailStoreCountryCenter(anotherCountryId, emptyOptions());		
			retailStoreProvinceCenter.setCountry(country);		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, emptyOptions());
			
			return present(userContext,retailStoreProvinceCenter, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCountryId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCountryId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception{
		getRetailStoreProvinceCenterDAO().delete(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreProvinceCenterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreProvinceCenterDAO().deleteAll();
	}

	protected void checkParamsForAddingProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager,String [] tokensExpr) throws Exception{
		
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);

		checkNameOfProvinceCenterDepartment(userContext,  name, exception);
		checkFoundedOfProvinceCenterDepartment(userContext,  founded, exception);
		checkManagerOfProvinceCenterDepartment(userContext,  manager, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreProvinceCenter addProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId,name, founded, manager,tokensExpr);
		
		ProvinceCenterDepartment provinceCenterDepartment = createProvinceCenterDepartment(userContext,name, founded, manager);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.addProvinceCenterDepartment( provinceCenterDepartment );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected ProvinceCenterDepartment createProvinceCenterDepartment(RetailScmUserContext userContext, String name, Date founded, String manager) throws Exception{

		ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
		
		
		provinceCenterDepartment.setName(name);		
		provinceCenterDepartment.setFounded(founded);		
		provinceCenterDepartment.setManager(manager);
	
		
		return provinceCenterDepartment;
	
		
	}
	
	protected ProvinceCenterDepartment createIndexedProvinceCenterDepartment(String id, int version){

		ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
		provinceCenterDepartment.setId(id);
		provinceCenterDepartment.setVersion(version);
		return provinceCenterDepartment;			
		
	}
	protected void checkParamsForRemovingProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);
		checkVersionOfProvinceCenterDepartment(userContext, provinceCenterDepartmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreProvinceCenter removeProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId, provinceCenterDepartmentId, provinceCenterDepartmentVersion,tokensExpr);
		
		ProvinceCenterDepartment provinceCenterDepartment = createIndexedProvinceCenterDepartment(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.removeProvinceCenterDepartment( provinceCenterDepartment );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);
		checkVersionOfProvinceCenterDepartment(userContext, provinceCenterDepartmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreProvinceCenter copyProvinceCenterDepartmentFrom(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId, provinceCenterDepartmentId, provinceCenterDepartmentVersion,tokensExpr);
		
		ProvinceCenterDepartment provinceCenterDepartment = createIndexedProvinceCenterDepartment(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.copyProvinceCenterDepartmentFrom( provinceCenterDepartment );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);
		checkVersionOfProvinceCenterDepartment(userContext, provinceCenterDepartmentVersion, exception);
		

		if(ProvinceCenterDepartment.NAME_PROPERTY.equals(property)){
			checkNameOfProvinceCenterDepartment(userContext, parseString(newValueExpr), exception);
		}
		
		if(ProvinceCenterDepartment.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfProvinceCenterDepartment(userContext, parseDate(newValueExpr), exception);
		}
		
		if(ProvinceCenterDepartment.MANAGER_PROPERTY.equals(property)){
			checkManagerOfProvinceCenterDepartment(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreProvinceCenter updateProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProvinceCenterDepartment(userContext, retailStoreProvinceCenterId, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreProvinceCenter.removeProvinceCenterDepartment( provinceCenterDepartment );	
			//make changes to AcceleraterAccount.
			ProvinceCenterDepartment provinceCenterDepartmentIndex = createIndexedProvinceCenterDepartment(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
		
			ProvinceCenterDepartment provinceCenterDepartment = retailStoreProvinceCenter.findTheProvinceCenterDepartment(provinceCenterDepartmentIndex);
			if(provinceCenterDepartment == null){
				throw new RetailStoreProvinceCenterManagerException(provinceCenterDepartment+"Not found" );
			}
			
			provinceCenterDepartment.changePropery(property, newValueExpr);

			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId,String [] tokensExpr) throws Exception{
		
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);

		checkNameOfProvinceCenterEmployee(userContext,  name, exception);
		checkMobileOfProvinceCenterEmployee(userContext,  mobile, exception);
		checkEmailOfProvinceCenterEmployee(userContext,  email, exception);
		checkFoundedOfProvinceCenterEmployee(userContext,  founded, exception);		
		
		checkIdOfProvinceCenterDepartment(userContext,  departmentId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreProvinceCenter addProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId,name, mobile, email, founded, departmentId,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createProvinceCenterEmployee(userContext,name, mobile, email, founded, departmentId);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.addProvinceCenterEmployee( provinceCenterEmployee );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected ProvinceCenterEmployee createProvinceCenterEmployee(RetailScmUserContext userContext, String name, String mobile, String email, Date founded, String departmentId) throws Exception{

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		
		
		provinceCenterEmployee.setName(name);		
		provinceCenterEmployee.setMobile(mobile);		
		provinceCenterEmployee.setEmail(email);		
		provinceCenterEmployee.setFounded(founded);		
		ProvinceCenterDepartment  department = new ProvinceCenterDepartment();
		department.setId(departmentId);		
		provinceCenterEmployee.setDepartment(department);
	
		
		return provinceCenterEmployee;
	
		
	}
	
	protected ProvinceCenterEmployee createIndexedProvinceCenterEmployee(String id, int version){

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployee.setId(id);
		provinceCenterEmployee.setVersion(version);
		return provinceCenterEmployee;			
		
	}
	protected void checkParamsForRemovingProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId, exception);
		checkVersionOfProvinceCenterEmployee(userContext, provinceCenterEmployeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreProvinceCenter removeProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.removeProvinceCenterEmployee( provinceCenterEmployee );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId, exception);
		checkVersionOfProvinceCenterEmployee(userContext, provinceCenterEmployeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreProvinceCenter copyProvinceCenterEmployeeFrom(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.copyProvinceCenterEmployeeFrom( provinceCenterEmployee );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId, exception);
		checkVersionOfProvinceCenterEmployee(userContext, provinceCenterEmployeeVersion, exception);
		

		if(ProvinceCenterEmployee.NAME_PROPERTY.equals(property)){
			checkNameOfProvinceCenterEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(ProvinceCenterEmployee.MOBILE_PROPERTY.equals(property)){
			checkMobileOfProvinceCenterEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(ProvinceCenterEmployee.EMAIL_PROPERTY.equals(property)){
			checkEmailOfProvinceCenterEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(ProvinceCenterEmployee.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfProvinceCenterEmployee(userContext, parseDate(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreProvinceCenter updateProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProvinceCenterEmployee(userContext, retailStoreProvinceCenterId, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreProvinceCenter.removeProvinceCenterEmployee( provinceCenterEmployee );	
			//make changes to AcceleraterAccount.
			ProvinceCenterEmployee provinceCenterEmployeeIndex = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		
			ProvinceCenterEmployee provinceCenterEmployee = retailStoreProvinceCenter.findTheProvinceCenterEmployee(provinceCenterEmployeeIndex);
			if(provinceCenterEmployee == null){
				throw new RetailStoreProvinceCenterManagerException(provinceCenterEmployee+"Not found" );
			}
			
			provinceCenterEmployee.changePropery(property, newValueExpr);

			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded,String [] tokensExpr) throws Exception{
		
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);

		checkNameOfRetailStoreCityServiceCenter(userContext,  name, exception);
		checkFoundedOfRetailStoreCityServiceCenter(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreProvinceCenter addRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId,name, founded,tokensExpr);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = createRetailStoreCityServiceCenter(userContext,name, founded);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.addRetailStoreCityServiceCenter( retailStoreCityServiceCenter );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(RetailScmUserContext userContext, String name, Date founded) throws Exception{

		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
		
		
		retailStoreCityServiceCenter.setName(name);		
		retailStoreCityServiceCenter.setFounded(founded);
	
		
		return retailStoreCityServiceCenter;
	
		
	}
	
	protected RetailStoreCityServiceCenter createIndexedRetailStoreCityServiceCenter(String id, int version){

		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
		retailStoreCityServiceCenter.setId(id);
		retailStoreCityServiceCenter.setVersion(version);
		return retailStoreCityServiceCenter;			
		
	}
	protected void checkParamsForRemovingRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkVersionOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreProvinceCenter removeRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion,tokensExpr);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = createIndexedRetailStoreCityServiceCenter(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.removeRetailStoreCityServiceCenter( retailStoreCityServiceCenter );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkIdOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, exception);
		checkVersionOfRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreProvinceCenter copyRetailStoreCityServiceCenterFrom(RetailScmUserContext userContext, String retailStoreProvinceCenterId, 
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion,tokensExpr);
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = createIndexedRetailStoreCityServiceCenter(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.copyRetailStoreCityServiceCenterFrom( retailStoreCityServiceCenter );		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreProvinceCenterManagerException exception = new RetailStoreProvinceCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
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
	
	public  RetailStoreProvinceCenter updateRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreCityServiceCenter(userContext, retailStoreProvinceCenterId, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		
		synchronized(retailStoreProvinceCenter){ 
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreProvinceCenter.removeRetailStoreCityServiceCenter( retailStoreCityServiceCenter );	
			//make changes to AcceleraterAccount.
			RetailStoreCityServiceCenter retailStoreCityServiceCenterIndex = createIndexedRetailStoreCityServiceCenter(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
		
			RetailStoreCityServiceCenter retailStoreCityServiceCenter = retailStoreProvinceCenter.findTheRetailStoreCityServiceCenter(retailStoreCityServiceCenterIndex);
			if(retailStoreCityServiceCenter == null){
				throw new RetailStoreProvinceCenterManagerException(retailStoreCityServiceCenter+"Not found" );
			}
			
			retailStoreCityServiceCenter.changePropery(property, newValueExpr);

			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


