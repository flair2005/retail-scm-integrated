
package com.skynet.retailscm.provincecenterdepartment;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;

import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;

import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;


import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployeeTable;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTable;




public class ProvinceCenterDepartmentManagerImpl extends RetailScmCheckerManager implements ProvinceCenterDepartmentManager {
	
	private static final String SERVICE_TYPE = "ProvinceCenterDepartment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ProvinceCenterDepartmentDAO  provinceCenterDepartmentDAO;
 	public void setProvinceCenterDepartmentDAO(ProvinceCenterDepartmentDAO  provinceCenterDepartmentDAO){
 	
 		if(provinceCenterDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set provinceCenterDepartmentDAO to null.");
 		}
	 	this.provinceCenterDepartmentDAO = provinceCenterDepartmentDAO;
 	}
 	public ProvinceCenterDepartmentDAO getProvinceCenterDepartmentDAO(){
 		if(this.provinceCenterDepartmentDAO == null){
 			throw new IllegalStateException("The ProvinceCenterDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.provinceCenterDepartmentDAO;
 	}
 	
 	protected ProvinceCenterDepartment saveProvinceCenterDepartment(RetailScmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, String [] tokensExpr) throws Exception{	
 		//return getProvinceCenterDepartmentDAO().save(provinceCenterDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens);
 	}
 	
 	protected ProvinceCenterDepartment saveProvinceCenterDepartmentDetail(RetailScmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment) throws Exception{	

 		
 		return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, allTokens());
 	}
 	
 	public ProvinceCenterDepartment loadProvinceCenterDepartment(RetailScmUserContext userContext, String provinceCenterDepartmentId, String [] tokensExpr) throws Exception{				
 
 		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");
		
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterDepartment, tokens);
 	}
 	
 	protected ProvinceCenterDepartment present(RetailScmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,provinceCenterDepartment,tokens);
		
		
		return this.getProvinceCenterDepartmentDAO().present(provinceCenterDepartment, tokens);
	}
 
 	
 	
 	public ProvinceCenterDepartment loadProvinceCenterDepartmentDetail(RetailScmUserContext userContext, String provinceCenterDepartmentId) throws Exception{	
 		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");
		
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, allTokens());

 		return present(userContext,provinceCenterDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String provinceCenterDepartmentId) throws Exception{	
 		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");
		
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, allTokens());

 		return present(userContext,provinceCenterDepartment, allTokens());
		
 	}
 	protected ProvinceCenterDepartment saveProvinceCenterDepartment(RetailScmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object>tokens) throws Exception{	
 		return getProvinceCenterDepartmentDAO().save(provinceCenterDepartment, tokens);
 	}
 	protected ProvinceCenterDepartment loadProvinceCenterDepartment(RetailScmUserContext userContext, String provinceCenterDepartmentId, Map<String,Object>tokens) throws Exception{	
 		return getProvinceCenterDepartmentDAO().load(provinceCenterDepartmentId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO;
 	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
	 	return this.retailStoreProvinceCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens){
		super.addActions(userContext, provinceCenterDepartment, tokens);
		
		addAction(userContext, provinceCenterDepartment, tokens,"@create","createProvinceCenterDepartment","createProvinceCenterDepartment/","main","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"@update","updateProvinceCenterDepartment","updateProvinceCenterDepartment/"+provinceCenterDepartment.getId()+"/","main","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"@copy","cloneProvinceCenterDepartment","cloneProvinceCenterDepartment/"+provinceCenterDepartment.getId()+"/","main","primary");
		
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.transfer_to_province_center","transferToAnotherProvinceCenter","transferToAnotherProvinceCenter/"+provinceCenterDepartment.getId()+"/","main","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.addProvinceCenterEmployee","addProvinceCenterEmployee","addProvinceCenterEmployee/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.removeProvinceCenterEmployee","removeProvinceCenterEmployee","removeProvinceCenterEmployee/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.updateProvinceCenterEmployee","updateProvinceCenterEmployee","updateProvinceCenterEmployee/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ProvinceCenterDepartment createProvinceCenterDepartment(RetailScmUserContext userContext,String name, Date founded, String provinceCenterId, String manager
) throws Exception
	{
		
		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");

		

		checkNameOfProvinceCenterDepartment(userContext,  name, exception);
		checkFoundedOfProvinceCenterDepartment(userContext,  founded, exception);
		checkManagerOfProvinceCenterDepartment(userContext,  manager, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ProvinceCenterDepartment provinceCenterDepartment=createNewProvinceCenterDepartment();	

		provinceCenterDepartment.setName(name);
		provinceCenterDepartment.setFounded(founded);
		RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(provinceCenterId,emptyOptions());
		provinceCenterDepartment.setProvinceCenter(provinceCenter);
		provinceCenterDepartment.setManager(manager);

		return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, emptyOptions());
		

		
	}
	protected ProvinceCenterDepartment createNewProvinceCenterDepartment() 
	{
		
		return new ProvinceCenterDepartment();		
	}
	
	protected void checkParamsForUpdatingProvinceCenterDepartment(RetailScmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");
		
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
	
	
	
	public ProvinceCenterDepartment clone(RetailScmUserContext userContext, String fromProvinceCenterDepartmentId) throws Exception{
		
		return this.getProvinceCenterDepartmentDAO().clone(fromProvinceCenterDepartmentId, this.allTokens());
	}
	
	public ProvinceCenterDepartment updateProvinceCenterDepartment(RetailScmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProvinceCenterDepartment(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr, tokensExpr);
		
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		if(provinceCenterDepartment.getVersion() != provinceCenterDepartmentVersion){
			String message = "The target version("+provinceCenterDepartment.getVersion()+") is not equals to version("+provinceCenterDepartmentVersion+") provided";
			throw new ProvinceCenterDepartmentManagerException(message);
		}
		synchronized(provinceCenterDepartment){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterDepartment.
			
			provinceCenterDepartment.changePropery(property, newValueExpr);
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProvinceCenterDepartmentTokens tokens(){
		return ProvinceCenterDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProvinceCenterDepartmentTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProvinceCenterDepartmentTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherProvinceCenter(RetailScmUserContext userContext, String provinceCenterDepartmentId, String anotherProvinceCenterId) throws Exception
 	{
 		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");
 		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId,exception);
 		checkIdOfRetailStoreProvinceCenter(userContext, anotherProvinceCenterId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ProvinceCenterDepartment transferToAnotherProvinceCenter(RetailScmUserContext userContext, String provinceCenterDepartmentId, String anotherProvinceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherProvinceCenter(userContext, provinceCenterDepartmentId,anotherProvinceCenterId);
 
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());	
		synchronized(provinceCenterDepartment){
			//will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(anotherProvinceCenterId, emptyOptions());		
			provinceCenterDepartment.setProvinceCenter(provinceCenter);		
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, emptyOptions());
			
			return present(userContext,provinceCenterDepartment, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(String newProvinceCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreProvinceCenterDAO().load(newProvinceCenterId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception {
		
		deleteInternal(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception{
		getProvinceCenterDepartmentDAO().delete(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProvinceCenterDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getProvinceCenterDepartmentDAO().deleteAll();
	}

	protected void checkParamsForAddingProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId,String [] tokensExpr) throws Exception{
		
		

		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");
		
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);

		checkNameOfProvinceCenterEmployee(userContext,  name, exception);
		checkMobileOfProvinceCenterEmployee(userContext,  mobile, exception);
		checkEmailOfProvinceCenterEmployee(userContext,  email, exception);
		checkFoundedOfProvinceCenterEmployee(userContext,  founded, exception);		
		
		checkIdOfRetailStoreProvinceCenter(userContext,  provinceCenterId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  ProvinceCenterDepartment addProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProvinceCenterEmployee(userContext,provinceCenterDepartmentId,name, mobile, email, founded, provinceCenterId,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createProvinceCenterEmployee(userContext,name, mobile, email, founded, provinceCenterId);
		
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		synchronized(provinceCenterDepartment){ 
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			provinceCenterDepartment.addProvinceCenterEmployee( provinceCenterEmployee );		
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected ProvinceCenterEmployee createProvinceCenterEmployee(RetailScmUserContext userContext, String name, String mobile, String email, Date founded, String provinceCenterId) throws Exception{

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		
		
		provinceCenterEmployee.setName(name);		
		provinceCenterEmployee.setMobile(mobile);		
		provinceCenterEmployee.setEmail(email);		
		provinceCenterEmployee.setFounded(founded);		
		RetailStoreProvinceCenter  provinceCenter = new RetailStoreProvinceCenter();
		provinceCenter.setId(provinceCenterId);		
		provinceCenterEmployee.setProvinceCenter(provinceCenter);
	
		
		return provinceCenterEmployee;
	
		
	}
	
	protected ProvinceCenterEmployee createIndexedProvinceCenterEmployee(String id, int version){

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployee.setId(id);
		provinceCenterEmployee.setVersion(version);
		return provinceCenterEmployee;			
		
	}
	protected void checkParamsForRemovingProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		

		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");
		
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);
		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId, exception);
		checkVersionOfProvinceCenterEmployee(userContext, provinceCenterEmployeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ProvinceCenterDepartment removeProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProvinceCenterEmployee(userContext,provinceCenterDepartmentId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		synchronized(provinceCenterDepartment){ 
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			provinceCenterDepartment.removeProvinceCenterEmployee( provinceCenterEmployee );		
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		

		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");
		
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);
		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId, exception);
		checkVersionOfProvinceCenterEmployee(userContext, provinceCenterEmployeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ProvinceCenterDepartment copyProvinceCenterEmployeeFrom(RetailScmUserContext userContext, String provinceCenterDepartmentId, 
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProvinceCenterEmployee(userContext,provinceCenterDepartmentId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		synchronized(provinceCenterDepartment){ 
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			provinceCenterDepartment.copyProvinceCenterEmployeeFrom( provinceCenterEmployee );		
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ProvinceCenterDepartmentManagerException exception = new ProvinceCenterDepartmentManagerException("Error Occured");
		
		checkIdOfProvinceCenterDepartment(userContext, provinceCenterDepartmentId, exception);
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
	
	public  ProvinceCenterDepartment updateProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterDepartmentId, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr,  tokensExpr);
		
		
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		
		synchronized(provinceCenterDepartment){ 
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//provinceCenterDepartment.removeProvinceCenterEmployee( provinceCenterEmployee );	
			//make changes to AcceleraterAccount.
			ProvinceCenterEmployee provinceCenterEmployeeIndex = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		
			ProvinceCenterEmployee provinceCenterEmployee = provinceCenterDepartment.findTheProvinceCenterEmployee(provinceCenterEmployeeIndex);
			if(provinceCenterEmployee == null){
				throw new ProvinceCenterDepartmentManagerException(provinceCenterEmployee+"Not found" );
			}
			
			provinceCenterEmployee.changePropery(property, newValueExpr);

			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


