
package com.skynet.retailscm.responsibilitytype;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.hrinterview.HrInterview;
import com.skynet.retailscm.termination.Termination;
import com.skynet.retailscm.employeeboarding.EmployeeBoarding;
import com.skynet.retailscm.offeracceptance.OfferAcceptance;
import com.skynet.retailscm.occupationtype.OccupationType;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.professioninterview.ProfessionInterview;
import com.skynet.retailscm.offerapproval.OfferApproval;
import com.skynet.retailscm.responsibilitytype.ResponsibilityType;
import com.skynet.retailscm.salarygrade.SalaryGrade;
import com.skynet.retailscm.jobapplication.JobApplication;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employee.EmployeeTable;




public class ResponsibilityTypeManagerImpl extends RetailScmCheckerManager implements ResponsibilityTypeManager {
	
	private static final String SERVICE_TYPE = "ResponsibilityType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ResponsibilityTypeDAO  responsibilityTypeDAO;
 	public void setResponsibilityTypeDAO(ResponsibilityTypeDAO  responsibilityTypeDAO){
 	
 		if(responsibilityTypeDAO == null){
 			throw new IllegalStateException("Do not try to set responsibilityTypeDAO to null.");
 		}
	 	this.responsibilityTypeDAO = responsibilityTypeDAO;
 	}
 	public ResponsibilityTypeDAO getResponsibilityTypeDAO(){
 		if(this.responsibilityTypeDAO == null){
 			throw new IllegalStateException("The ResponsibilityTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.responsibilityTypeDAO;
 	}
 	
 	protected ResponsibilityType saveResponsibilityType(RetailScmUserContext userContext, ResponsibilityType responsibilityType, String [] tokensExpr) throws Exception{	
 		//return getResponsibilityTypeDAO().save(responsibilityType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveResponsibilityType(userContext, responsibilityType, tokens);
 	}
 	
 	protected ResponsibilityType saveResponsibilityTypeDetail(RetailScmUserContext userContext, ResponsibilityType responsibilityType) throws Exception{	

 		
 		return saveResponsibilityType(userContext, responsibilityType, allTokens());
 	}
 	
 	public ResponsibilityType loadResponsibilityType(RetailScmUserContext userContext, String responsibilityTypeId, String [] tokensExpr) throws Exception{				
 
 		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");
		
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,responsibilityType, tokens);
 	}
 	
 	protected ResponsibilityType present(RetailScmUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,responsibilityType,tokens);
		
		
		return this.getResponsibilityTypeDAO().present(responsibilityType, tokens);
	}
 
 	
 	
 	public ResponsibilityType loadResponsibilityTypeDetail(RetailScmUserContext userContext, String responsibilityTypeId) throws Exception{	
 		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");
		
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, allTokens());

 		return present(userContext,responsibilityType, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String responsibilityTypeId) throws Exception{	
 		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");
		
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, allTokens());

 		return present(userContext,responsibilityType, allTokens());
		
 	}
 	protected ResponsibilityType saveResponsibilityType(RetailScmUserContext userContext, ResponsibilityType responsibilityType, Map<String,Object>tokens) throws Exception{	
 		return getResponsibilityTypeDAO().save(responsibilityType, tokens);
 	}
 	protected ResponsibilityType loadResponsibilityType(RetailScmUserContext userContext, String responsibilityTypeId, Map<String,Object>tokens) throws Exception{	
 		return getResponsibilityTypeDAO().load(responsibilityTypeId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens){
		super.addActions(userContext, responsibilityType, tokens);
		
		addAction(userContext, responsibilityType, tokens,"@create","createResponsibilityType","createResponsibilityType/","main","primary");
		addAction(userContext, responsibilityType, tokens,"@update","updateResponsibilityType","updateResponsibilityType/"+responsibilityType.getId()+"/","main","primary");
		addAction(userContext, responsibilityType, tokens,"@copy","cloneResponsibilityType","cloneResponsibilityType/"+responsibilityType.getId()+"/","main","primary");
		
		addAction(userContext, responsibilityType, tokens,"responsibility_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+responsibilityType.getId()+"/","main","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.addEmployee","addEmployee","addEmployee/"+responsibilityType.getId()+"/","employeeList","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.removeEmployee","removeEmployee","removeEmployee/"+responsibilityType.getId()+"/","employeeList","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.updateEmployee","updateEmployee","updateEmployee/"+responsibilityType.getId()+"/","employeeList","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+responsibilityType.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ResponsibilityType createResponsibilityType(RetailScmUserContext userContext,String code, String companyId, String baseDescription, String detailDescription
) throws Exception
	{
		
		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");

		

		checkCodeOfResponsibilityType(userContext,  code, exception);
		checkBaseDescriptionOfResponsibilityType(userContext,  baseDescription, exception);
		checkDetailDescriptionOfResponsibilityType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ResponsibilityType responsibilityType=createNewResponsibilityType();	

		responsibilityType.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		responsibilityType.setCompany(company);
		responsibilityType.setBaseDescription(baseDescription);
		responsibilityType.setDetailDescription(detailDescription);

		return saveResponsibilityType(userContext, responsibilityType, emptyOptions());
		

		
	}
	protected ResponsibilityType createNewResponsibilityType() 
	{
		
		return new ResponsibilityType();		
	}
	
	protected void checkParamsForUpdatingResponsibilityType(RetailScmUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");
		
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		checkVersionOfResponsibilityType(userContext, responsibilityTypeVersion, exception);
		

		if(ResponsibilityType.CODE_PROPERTY.equals(property)){
			checkCodeOfResponsibilityType(userContext, parseString(newValueExpr), exception);
		}		

		
		if(ResponsibilityType.BASE_DESCRIPTION_PROPERTY.equals(property)){
			checkBaseDescriptionOfResponsibilityType(userContext, parseString(newValueExpr), exception);
		}
		if(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfResponsibilityType(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ResponsibilityType clone(RetailScmUserContext userContext, String fromResponsibilityTypeId) throws Exception{
		
		return this.getResponsibilityTypeDAO().clone(fromResponsibilityTypeId, this.allTokens());
	}
	
	public ResponsibilityType updateResponsibilityType(RetailScmUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingResponsibilityType(userContext, responsibilityTypeId, responsibilityTypeVersion, property, newValueExpr, tokensExpr);
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		if(responsibilityType.getVersion() != responsibilityTypeVersion){
			String message = "The target version("+responsibilityType.getVersion()+") is not equals to version("+responsibilityTypeVersion+") provided";
			throw new ResponsibilityTypeManagerException(message);
		}
		synchronized(responsibilityType){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ResponsibilityType.
			
			responsibilityType.changePropery(property, newValueExpr);
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
			//return saveResponsibilityType(userContext, responsibilityType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ResponsibilityTypeTokens tokens(){
		return ResponsibilityTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ResponsibilityTypeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ResponsibilityTypeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String responsibilityTypeId, String anotherCompanyId) throws Exception
 	{
 		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");
 		checkIdOfResponsibilityType(userContext, responsibilityTypeId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ResponsibilityType transferToAnotherCompany(RetailScmUserContext userContext, String responsibilityTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, responsibilityTypeId,anotherCompanyId);
 
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());	
		synchronized(responsibilityType){
			//will be good when the responsibilityType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			responsibilityType.setCompany(company);		
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, emptyOptions());
			
			return present(userContext,responsibilityType, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String responsibilityTypeId, int responsibilityTypeVersion) throws Exception {
		
		deleteInternal(userContext, responsibilityTypeId, responsibilityTypeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String responsibilityTypeId, int responsibilityTypeVersion) throws Exception{
		getResponsibilityTypeDAO().delete(responsibilityTypeId, responsibilityTypeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ResponsibilityTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getResponsibilityTypeDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");
		
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  companyId, exception);
		checkTitleOfEmployee(userContext,  title, exception);		
		
		checkIdOfLevelThreeDepartment(userContext,  departmentId, exception);
		checkFamilyNameOfEmployee(userContext,  familyName, exception);
		checkGivenNameOfEmployee(userContext,  givenName, exception);
		checkEmailOfEmployee(userContext,  email, exception);
		checkCityOfEmployee(userContext,  city, exception);
		checkAddressOfEmployee(userContext,  address, exception);
		checkCellPhoneOfEmployee(userContext,  cellPhone, exception);		
		
		checkIdOfOccupationType(userContext,  occupationId, exception);		
		
		checkIdOfSalaryGrade(userContext,  currentSalaryGradeId, exception);
		checkSalaryAccountOfEmployee(userContext,  salaryAccount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  ResponsibilityType addEmployee(RetailScmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,responsibilityTypeId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, currentSalaryGradeId, salaryAccount);
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		synchronized(responsibilityType){ 
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			responsibilityType.addEmployee( employee );		
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}
	}
	protected Employee createEmployee(RetailScmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount) throws Exception{

		Employee employee = new Employee();
		
		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		employee.setCompany(company);		
		employee.setTitle(title);		
		LevelThreeDepartment  department = new LevelThreeDepartment();
		department.setId(departmentId);		
		employee.setDepartment(department);		
		employee.setFamilyName(familyName);		
		employee.setGivenName(givenName);		
		employee.setEmail(email);		
		employee.setCity(city);		
		employee.setAddress(address);		
		employee.setCellPhone(cellPhone);		
		OccupationType  occupation = new OccupationType();
		occupation.setId(occupationId);		
		employee.setOccupation(occupation);		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employee.setCurrentSalaryGrade(currentSalaryGrade);		
		employee.setSalaryAccount(salaryAccount);
	
		
		return employee;
	
		
	}
	
	protected Employee createIndexedEmployee(String id, int version){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(version);
		return employee;			
		
	}
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String responsibilityTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");
		
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ResponsibilityType removeEmployee(RetailScmUserContext userContext, String responsibilityTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,responsibilityTypeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		synchronized(responsibilityType){ 
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			responsibilityType.removeEmployee( employee );		
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String responsibilityTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");
		
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ResponsibilityType copyEmployeeFrom(RetailScmUserContext userContext, String responsibilityTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,responsibilityTypeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		synchronized(responsibilityType){ 
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			responsibilityType.copyEmployeeFrom( employee );		
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ResponsibilityTypeManagerException exception = new ResponsibilityTypeManagerException("Error Occured");
		
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);
		

		if(Employee.TITLE_PROPERTY.equals(property)){
			checkTitleOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
			checkFamilyNameOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
			checkGivenNameOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.EMAIL_PROPERTY.equals(property)){
			checkEmailOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.CITY_PROPERTY.equals(property)){
			checkCityOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.ADDRESS_PROPERTY.equals(property)){
			checkAddressOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
			checkCellPhoneOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
			checkSalaryAccountOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  ResponsibilityType updateEmployee(RetailScmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, responsibilityTypeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		
		synchronized(responsibilityType){ 
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//responsibilityType.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = responsibilityType.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new ResponsibilityTypeManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


