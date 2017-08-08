
package com.skynet.retailscm.provincecenteremployee;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartmentDAO;



import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartmentTable;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTable;




public class ProvinceCenterEmployeeManagerImpl extends RetailScmCheckerManager implements ProvinceCenterEmployeeManager {
	
	private static final String SERVICE_TYPE = "ProvinceCenterEmployee";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ProvinceCenterEmployeeDAO  provinceCenterEmployeeDAO;
 	public void setProvinceCenterEmployeeDAO(ProvinceCenterEmployeeDAO  provinceCenterEmployeeDAO){
 	
 		if(provinceCenterEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set provinceCenterEmployeeDAO to null.");
 		}
	 	this.provinceCenterEmployeeDAO = provinceCenterEmployeeDAO;
 	}
 	public ProvinceCenterEmployeeDAO getProvinceCenterEmployeeDAO(){
 		if(this.provinceCenterEmployeeDAO == null){
 			throw new IllegalStateException("The ProvinceCenterEmployeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.provinceCenterEmployeeDAO;
 	}
 	
 	protected ProvinceCenterEmployee saveProvinceCenterEmployee(RetailScmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, String [] tokensExpr) throws Exception{	
 		//return getProvinceCenterEmployeeDAO().save(provinceCenterEmployee, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens);
 	}
 	
 	protected ProvinceCenterEmployee saveProvinceCenterEmployeeDetail(RetailScmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee) throws Exception{	

 		
 		return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, allTokens());
 	}
 	
 	public ProvinceCenterEmployee loadProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterEmployeeId, String [] tokensExpr) throws Exception{				
 
 		ProvinceCenterEmployeeManagerException exception = new ProvinceCenterEmployeeManagerException("Error Occured");
		
		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterEmployee, tokens);
 	}
 	
 	protected ProvinceCenterEmployee present(RetailScmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,provinceCenterEmployee,tokens);
		
		
		return this.getProvinceCenterEmployeeDAO().present(provinceCenterEmployee, tokens);
	}
 
 	
 	
 	public ProvinceCenterEmployee loadProvinceCenterEmployeeDetail(RetailScmUserContext userContext, String provinceCenterEmployeeId) throws Exception{	
 		ProvinceCenterEmployeeManagerException exception = new ProvinceCenterEmployeeManagerException("Error Occured");
		
		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, allTokens());

 		return present(userContext,provinceCenterEmployee, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String provinceCenterEmployeeId) throws Exception{	
 		ProvinceCenterEmployeeManagerException exception = new ProvinceCenterEmployeeManagerException("Error Occured");
		
		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, allTokens());

 		return present(userContext,provinceCenterEmployee, allTokens());
		
 	}
 	protected ProvinceCenterEmployee saveProvinceCenterEmployee(RetailScmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object>tokens) throws Exception{	
 		return getProvinceCenterEmployeeDAO().save(provinceCenterEmployee, tokens);
 	}
 	protected ProvinceCenterEmployee loadProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterEmployeeId, Map<String,Object>tokens) throws Exception{	
 		return getProvinceCenterEmployeeDAO().load(provinceCenterEmployeeId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO;
 	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
	 	return this.retailStoreProvinceCenterDAO;
 	}
 
 	
 	private  ProvinceCenterDepartmentDAO  provinceCenterDepartmentDAO;
 	public void setProvinceCenterDepartmentDAO(ProvinceCenterDepartmentDAO provinceCenterDepartmentDAO){
	 	this.provinceCenterDepartmentDAO = provinceCenterDepartmentDAO;
 	}
 	//------------------------------------
 	public ProvinceCenterDepartmentDAO getProvinceCenterDepartmentDAO(){
	 	return this.provinceCenterDepartmentDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens){
		super.addActions(userContext, provinceCenterEmployee, tokens);
		
		addAction(userContext, provinceCenterEmployee, tokens,"@create","createProvinceCenterEmployee","createProvinceCenterEmployee/","main","primary");
		addAction(userContext, provinceCenterEmployee, tokens,"@update","updateProvinceCenterEmployee","updateProvinceCenterEmployee/"+provinceCenterEmployee.getId()+"/","main","primary");
		addAction(userContext, provinceCenterEmployee, tokens,"@copy","cloneProvinceCenterEmployee","cloneProvinceCenterEmployee/"+provinceCenterEmployee.getId()+"/","main","primary");
		
		addAction(userContext, provinceCenterEmployee, tokens,"province_center_employee.transfer_to_department","transferToAnotherDepartment","transferToAnotherDepartment/"+provinceCenterEmployee.getId()+"/","main","primary");
		addAction(userContext, provinceCenterEmployee, tokens,"province_center_employee.transfer_to_province_center","transferToAnotherProvinceCenter","transferToAnotherProvinceCenter/"+provinceCenterEmployee.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ProvinceCenterEmployee createProvinceCenterEmployee(RetailScmUserContext userContext,String name, String mobile, String email, Date founded, String departmentId, String provinceCenterId
) throws Exception
	{
		
		ProvinceCenterEmployeeManagerException exception = new ProvinceCenterEmployeeManagerException("Error Occured");

		

		checkNameOfProvinceCenterEmployee(userContext,  name, exception);
		checkMobileOfProvinceCenterEmployee(userContext,  mobile, exception);
		checkEmailOfProvinceCenterEmployee(userContext,  email, exception);
		checkFoundedOfProvinceCenterEmployee(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ProvinceCenterEmployee provinceCenterEmployee=createNewProvinceCenterEmployee();	

		provinceCenterEmployee.setName(name);
		provinceCenterEmployee.setMobile(mobile);
		provinceCenterEmployee.setEmail(email);
		provinceCenterEmployee.setFounded(founded);
		ProvinceCenterDepartment department = loadProvinceCenterDepartment(departmentId,emptyOptions());
		provinceCenterEmployee.setDepartment(department);
		RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(provinceCenterId,emptyOptions());
		provinceCenterEmployee.setProvinceCenter(provinceCenter);

		return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());
		

		
	}
	protected ProvinceCenterEmployee createNewProvinceCenterEmployee() 
	{
		
		return new ProvinceCenterEmployee();		
	}
	
	protected void checkParamsForUpdatingProvinceCenterEmployee(RetailScmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ProvinceCenterEmployeeManagerException exception = new ProvinceCenterEmployeeManagerException("Error Occured");
		
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
	
	
	
	public ProvinceCenterEmployee clone(RetailScmUserContext userContext, String fromProvinceCenterEmployeeId) throws Exception{
		
		return this.getProvinceCenterEmployeeDAO().clone(fromProvinceCenterEmployeeId, this.allTokens());
	}
	
	public ProvinceCenterEmployee updateProvinceCenterEmployee(RetailScmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr, tokensExpr);
		
		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
		if(provinceCenterEmployee.getVersion() != provinceCenterEmployeeVersion){
			String message = "The target version("+provinceCenterEmployee.getVersion()+") is not equals to version("+provinceCenterEmployeeVersion+") provided";
			throw new ProvinceCenterEmployeeManagerException(message);
		}
		synchronized(provinceCenterEmployee){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterEmployee.
			
			provinceCenterEmployee.changePropery(property, newValueExpr);
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
			return present(userContext,provinceCenterEmployee, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProvinceCenterEmployeeTokens tokens(){
		return ProvinceCenterEmployeeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProvinceCenterEmployeeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProvinceCenterEmployeeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherDepartment(RetailScmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId) throws Exception
 	{
 		ProvinceCenterEmployeeManagerException exception = new ProvinceCenterEmployeeManagerException("Error Occured");
 		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId,exception);
 		checkIdOfProvinceCenterDepartment(userContext, anotherDepartmentId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ProvinceCenterEmployee transferToAnotherDepartment(RetailScmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherDepartment(userContext, provinceCenterEmployeeId,anotherDepartmentId);
 
		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());	
		synchronized(provinceCenterEmployee){
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ProvinceCenterDepartment department = loadProvinceCenterDepartment(anotherDepartmentId, emptyOptions());		
			provinceCenterEmployee.setDepartment(department);		
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());
			
			return present(userContext,provinceCenterEmployee, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherProvinceCenter(RetailScmUserContext userContext, String provinceCenterEmployeeId, String anotherProvinceCenterId) throws Exception
 	{
 		ProvinceCenterEmployeeManagerException exception = new ProvinceCenterEmployeeManagerException("Error Occured");
 		checkIdOfProvinceCenterEmployee(userContext, provinceCenterEmployeeId,exception);
 		checkIdOfRetailStoreProvinceCenter(userContext, anotherProvinceCenterId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ProvinceCenterEmployee transferToAnotherProvinceCenter(RetailScmUserContext userContext, String provinceCenterEmployeeId, String anotherProvinceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherProvinceCenter(userContext, provinceCenterEmployeeId,anotherProvinceCenterId);
 
		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());	
		synchronized(provinceCenterEmployee){
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(anotherProvinceCenterId, emptyOptions());		
			provinceCenterEmployee.setProvinceCenter(provinceCenter);		
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());
			
			return present(userContext,provinceCenterEmployee, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(String newProvinceCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreProvinceCenterDAO().load(newProvinceCenterId, options);
 	}
	
	 	
 	protected ProvinceCenterDepartment loadProvinceCenterDepartment(String newDepartmentId, Map<String,Object> options) throws Exception
 	{
		
 		return getProvinceCenterDepartmentDAO().load(newDepartmentId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception {
		
		deleteInternal(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception{
		getProvinceCenterEmployeeDAO().delete(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProvinceCenterEmployeeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getProvinceCenterEmployeeDAO().deleteAll();
	}


}


