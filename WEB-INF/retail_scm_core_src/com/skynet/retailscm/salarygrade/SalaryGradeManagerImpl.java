
package com.skynet.retailscm.salarygrade;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.termination.Termination;
import com.skynet.retailscm.offeracceptance.OfferAcceptance;
import com.skynet.retailscm.professioninterview.ProfessionInterview;
import com.skynet.retailscm.offerapproval.OfferApproval;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.hrinterview.HrInterview;
import com.skynet.retailscm.employeeboarding.EmployeeBoarding;
import com.skynet.retailscm.occupationtype.OccupationType;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.responsibilitytype.ResponsibilityType;
import com.skynet.retailscm.salarygrade.SalaryGrade;
import com.skynet.retailscm.jobapplication.JobApplication;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheetTable;




public class SalaryGradeManagerImpl extends RetailScmCheckerManager implements SalaryGradeManager {
	
	private static final String SERVICE_TYPE = "SalaryGrade";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SalaryGradeDAO  salaryGradeDAO;
 	public void setSalaryGradeDAO(SalaryGradeDAO  salaryGradeDAO){
 	
 		if(salaryGradeDAO == null){
 			throw new IllegalStateException("Do not try to set salaryGradeDAO to null.");
 		}
	 	this.salaryGradeDAO = salaryGradeDAO;
 	}
 	public SalaryGradeDAO getSalaryGradeDAO(){
 		if(this.salaryGradeDAO == null){
 			throw new IllegalStateException("The SalaryGradeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.salaryGradeDAO;
 	}
 	
 	protected SalaryGrade saveSalaryGrade(RetailScmUserContext userContext, SalaryGrade salaryGrade, String [] tokensExpr) throws Exception{	
 		//return getSalaryGradeDAO().save(salaryGrade, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSalaryGrade(userContext, salaryGrade, tokens);
 	}
 	
 	protected SalaryGrade saveSalaryGradeDetail(RetailScmUserContext userContext, SalaryGrade salaryGrade) throws Exception{	

 		
 		return saveSalaryGrade(userContext, salaryGrade, allTokens());
 	}
 	
 	public SalaryGrade loadSalaryGrade(RetailScmUserContext userContext, String salaryGradeId, String [] tokensExpr) throws Exception{				
 
 		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SalaryGrade salaryGrade = loadSalaryGrade( userContext, salaryGradeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,salaryGrade, tokens);
 	}
 	
 	protected SalaryGrade present(RetailScmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,salaryGrade,tokens);
		
		
		return this.getSalaryGradeDAO().present(salaryGrade, tokens);
	}
 
 	
 	
 	public SalaryGrade loadSalaryGradeDetail(RetailScmUserContext userContext, String salaryGradeId) throws Exception{	
 		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SalaryGrade salaryGrade = loadSalaryGrade( userContext, salaryGradeId, allTokens());

 		return present(userContext,salaryGrade, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String salaryGradeId) throws Exception{	
 		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SalaryGrade salaryGrade = loadSalaryGrade( userContext, salaryGradeId, allTokens());

 		return present(userContext,salaryGrade, allTokens());
		
 	}
 	protected SalaryGrade saveSalaryGrade(RetailScmUserContext userContext, SalaryGrade salaryGrade, Map<String,Object>tokens) throws Exception{	
 		return getSalaryGradeDAO().save(salaryGrade, tokens);
 	}
 	protected SalaryGrade loadSalaryGrade(RetailScmUserContext userContext, String salaryGradeId, Map<String,Object>tokens) throws Exception{	
 		return getSalaryGradeDAO().load(salaryGradeId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> tokens){
		super.addActions(userContext, salaryGrade, tokens);
		
		addAction(userContext, salaryGrade, tokens,"@create","createSalaryGrade","createSalaryGrade/","main","primary");
		addAction(userContext, salaryGrade, tokens,"@update","updateSalaryGrade","updateSalaryGrade/"+salaryGrade.getId()+"/","main","primary");
		addAction(userContext, salaryGrade, tokens,"@copy","cloneSalaryGrade","cloneSalaryGrade/"+salaryGrade.getId()+"/","main","primary");
		
		addAction(userContext, salaryGrade, tokens,"salary_grade.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+salaryGrade.getId()+"/","main","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.addEmployee","addEmployee","addEmployee/"+salaryGrade.getId()+"/","employeeList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.removeEmployee","removeEmployee","removeEmployee/"+salaryGrade.getId()+"/","employeeList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.updateEmployee","updateEmployee","updateEmployee/"+salaryGrade.getId()+"/","employeeList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+salaryGrade.getId()+"/","employeeList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.addEmployeeSalarySheet","addEmployeeSalarySheet","addEmployeeSalarySheet/"+salaryGrade.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.removeEmployeeSalarySheet","removeEmployeeSalarySheet","removeEmployeeSalarySheet/"+salaryGrade.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.updateEmployeeSalarySheet","updateEmployeeSalarySheet","updateEmployeeSalarySheet/"+salaryGrade.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, salaryGrade, tokens,"salary_grade.copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom/"+salaryGrade.getId()+"/","employeeSalarySheetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SalaryGrade createSalaryGrade(RetailScmUserContext userContext,String code, String companyId, String name, String detailDescription
) throws Exception
	{
		
		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");

		

		checkCodeOfSalaryGrade(userContext,  code, exception);
		checkNameOfSalaryGrade(userContext,  name, exception);
		checkDetailDescriptionOfSalaryGrade(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SalaryGrade salaryGrade=createNewSalaryGrade();	

		salaryGrade.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		salaryGrade.setCompany(company);
		salaryGrade.setName(name);
		salaryGrade.setDetailDescription(detailDescription);

		return saveSalaryGrade(userContext, salaryGrade, emptyOptions());
		

		
	}
	protected SalaryGrade createNewSalaryGrade() 
	{
		
		return new SalaryGrade();		
	}
	
	protected void checkParamsForUpdatingSalaryGrade(RetailScmUserContext userContext,String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		checkVersionOfSalaryGrade(userContext, salaryGradeVersion, exception);
		

		if(SalaryGrade.CODE_PROPERTY.equals(property)){
			checkCodeOfSalaryGrade(userContext, parseString(newValueExpr), exception);
		}		

		
		if(SalaryGrade.NAME_PROPERTY.equals(property)){
			checkNameOfSalaryGrade(userContext, parseString(newValueExpr), exception);
		}
		if(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfSalaryGrade(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SalaryGrade clone(RetailScmUserContext userContext, String fromSalaryGradeId) throws Exception{
		
		return this.getSalaryGradeDAO().clone(fromSalaryGradeId, this.allTokens());
	}
	
	public SalaryGrade updateSalaryGrade(RetailScmUserContext userContext,String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSalaryGrade(userContext, salaryGradeId, salaryGradeVersion, property, newValueExpr, tokensExpr);
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		if(salaryGrade.getVersion() != salaryGradeVersion){
			String message = "The target version("+salaryGrade.getVersion()+") is not equals to version("+salaryGradeVersion+") provided";
			throw new SalaryGradeManagerException(message);
		}
		synchronized(salaryGrade){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SalaryGrade.
			
			salaryGrade.changePropery(property, newValueExpr);
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
			//return saveSalaryGrade(userContext, salaryGrade, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SalaryGradeTokens tokens(){
		return SalaryGradeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SalaryGradeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SalaryGradeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String salaryGradeId, String anotherCompanyId) throws Exception
 	{
 		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
 		checkIdOfSalaryGrade(userContext, salaryGradeId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SalaryGrade transferToAnotherCompany(RetailScmUserContext userContext, String salaryGradeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, salaryGradeId,anotherCompanyId);
 
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());	
		synchronized(salaryGrade){
			//will be good when the salaryGrade loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			salaryGrade.setCompany(company);		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, emptyOptions());
			
			return present(userContext,salaryGrade, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String salaryGradeId, int salaryGradeVersion) throws Exception {
		
		deleteInternal(userContext, salaryGradeId, salaryGradeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String salaryGradeId, int salaryGradeVersion) throws Exception{
		getSalaryGradeDAO().delete(salaryGradeId, salaryGradeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SalaryGradeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSalaryGradeDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String salaryGradeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		
		
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
		
		checkIdOfResponsibilityType(userContext,  responsibleForId, exception);
		checkSalaryAccountOfEmployee(userContext,  salaryAccount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SalaryGrade addEmployee(RetailScmUserContext userContext, String salaryGradeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,salaryGradeId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, salaryAccount);
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.addEmployee( employee );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
	}
	protected Employee createEmployee(RetailScmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount) throws Exception{

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
		ResponsibilityType  responsibleFor = new ResponsibilityType();
		responsibleFor.setId(responsibleForId);		
		employee.setResponsibleFor(responsibleFor);		
		employee.setSalaryAccount(salaryAccount);
	
		
		return employee;
	
		
	}
	
	protected Employee createIndexedEmployee(String id, int version){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(version);
		return employee;			
		
	}
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String salaryGradeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SalaryGrade removeEmployee(RetailScmUserContext userContext, String salaryGradeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,salaryGradeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.removeEmployee( employee );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String salaryGradeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SalaryGrade copyEmployeeFrom(RetailScmUserContext userContext, String salaryGradeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,salaryGradeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.copyEmployeeFrom( employee );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
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
	
	public  SalaryGrade updateEmployee(RetailScmUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, salaryGradeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//salaryGrade.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = salaryGrade.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new SalaryGradeManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, String employeeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance,String [] tokensExpr) throws Exception{
		
		

		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		
		
		checkIdOfEmployee(userContext,  employeeId, exception);
		checkBaseSalaryOfEmployeeSalarySheet(userContext,  baseSalary, exception);
		checkBonusOfEmployeeSalarySheet(userContext,  bonus, exception);
		checkRewardOfEmployeeSalarySheet(userContext,  reward, exception);
		checkPersonalTaxOfEmployeeSalarySheet(userContext,  personalTax, exception);
		checkSocialSecurityOfEmployeeSalarySheet(userContext,  socialSecurity, exception);
		checkHousingFoundOfEmployeeSalarySheet(userContext,  housingFound, exception);
		checkJobInsuranceOfEmployeeSalarySheet(userContext,  jobInsurance, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SalaryGrade addEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, String employeeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSalarySheet(userContext,salaryGradeId,employeeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createEmployeeSalarySheet(userContext,employeeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance);
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.addEmployeeSalarySheet( employeeSalarySheet );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeSalarySheet createEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance) throws Exception{

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeSalarySheet.setEmployee(employee);		
		employeeSalarySheet.setBaseSalary(baseSalary);		
		employeeSalarySheet.setBonus(bonus);		
		employeeSalarySheet.setReward(reward);		
		employeeSalarySheet.setPersonalTax(personalTax);		
		employeeSalarySheet.setSocialSecurity(socialSecurity);		
		employeeSalarySheet.setHousingFound(housingFound);		
		employeeSalarySheet.setJobInsurance(jobInsurance);
	
		
		return employeeSalarySheet;
	
		
	}
	
	protected EmployeeSalarySheet createIndexedEmployeeSalarySheet(String id, int version){

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		employeeSalarySheet.setId(id);
		employeeSalarySheet.setVersion(version);
		return employeeSalarySheet;			
		
	}
	protected void checkParamsForRemovingEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		

		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		checkVersionOfEmployeeSalarySheet(userContext, employeeSalarySheetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SalaryGrade removeEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSalarySheet(userContext,salaryGradeId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.removeEmployeeSalarySheet( employeeSalarySheet );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		

		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		checkVersionOfEmployeeSalarySheet(userContext, employeeSalarySheetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SalaryGrade copyEmployeeSalarySheetFrom(RetailScmUserContext userContext, String salaryGradeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSalarySheet(userContext,salaryGradeId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			salaryGrade.copyEmployeeSalarySheetFrom( employeeSalarySheet );		
			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SalaryGradeManagerException exception = new SalaryGradeManagerException("Error Occured");
		
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		checkVersionOfEmployeeSalarySheet(userContext, employeeSalarySheetVersion, exception);
		

		if(EmployeeSalarySheet.BASE_SALARY_PROPERTY.equals(property)){
			checkBaseSalaryOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.BONUS_PROPERTY.equals(property)){
			checkBonusOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.REWARD_PROPERTY.equals(property)){
			checkRewardOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY.equals(property)){
			checkPersonalTaxOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY.equals(property)){
			checkSocialSecurityOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY.equals(property)){
			checkHousingFoundOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY.equals(property)){
			checkJobInsuranceOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SalaryGrade updateEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSalarySheet(userContext, salaryGradeId, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr,  tokensExpr);
		
		
		SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
		
		synchronized(salaryGrade){ 
			//Will be good when the salaryGrade loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//salaryGrade.removeEmployeeSalarySheet( employeeSalarySheet );	
			//make changes to AcceleraterAccount.
			EmployeeSalarySheet employeeSalarySheetIndex = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		
			EmployeeSalarySheet employeeSalarySheet = salaryGrade.findTheEmployeeSalarySheet(employeeSalarySheetIndex);
			if(employeeSalarySheet == null){
				throw new SalaryGradeManagerException(employeeSalarySheet+"Not found" );
			}
			
			employeeSalarySheet.changePropery(property, newValueExpr);

			salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,salaryGrade, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


