
package com.skynet.retailscm.employeeboarding;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.employee.Employee;


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


import com.skynet.retailscm.employee.EmployeeTable;




public class EmployeeBoardingManagerImpl extends RetailScmCheckerManager implements EmployeeBoardingManager {
	
	private static final String SERVICE_TYPE = "EmployeeBoarding";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeBoardingDAO  employeeBoardingDAO;
 	public void setEmployeeBoardingDAO(EmployeeBoardingDAO  employeeBoardingDAO){
 	
 		if(employeeBoardingDAO == null){
 			throw new IllegalStateException("Do not try to set employeeBoardingDAO to null.");
 		}
	 	this.employeeBoardingDAO = employeeBoardingDAO;
 	}
 	public EmployeeBoardingDAO getEmployeeBoardingDAO(){
 		if(this.employeeBoardingDAO == null){
 			throw new IllegalStateException("The EmployeeBoardingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeBoardingDAO;
 	}
 	
 	protected EmployeeBoarding saveEmployeeBoarding(RetailScmUserContext userContext, EmployeeBoarding employeeBoarding, String [] tokensExpr) throws Exception{	
 		//return getEmployeeBoardingDAO().save(employeeBoarding, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeBoarding(userContext, employeeBoarding, tokens);
 	}
 	
 	protected EmployeeBoarding saveEmployeeBoardingDetail(RetailScmUserContext userContext, EmployeeBoarding employeeBoarding) throws Exception{	

 		
 		return saveEmployeeBoarding(userContext, employeeBoarding, allTokens());
 	}
 	
 	public EmployeeBoarding loadEmployeeBoarding(RetailScmUserContext userContext, String employeeBoardingId, String [] tokensExpr) throws Exception{				
 
 		EmployeeBoardingManagerException exception = new EmployeeBoardingManagerException("Error Occured");
		
		checkIdOfEmployeeBoarding(userContext, employeeBoardingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeBoarding, tokens);
 	}
 	
 	protected EmployeeBoarding present(RetailScmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeBoarding,tokens);
		
		
		return this.getEmployeeBoardingDAO().present(employeeBoarding, tokens);
	}
 
 	
 	
 	public EmployeeBoarding loadEmployeeBoardingDetail(RetailScmUserContext userContext, String employeeBoardingId) throws Exception{	
 		EmployeeBoardingManagerException exception = new EmployeeBoardingManagerException("Error Occured");
		
		checkIdOfEmployeeBoarding(userContext, employeeBoardingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, allTokens());

 		return present(userContext,employeeBoarding, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeBoardingId) throws Exception{	
 		EmployeeBoardingManagerException exception = new EmployeeBoardingManagerException("Error Occured");
		
		checkIdOfEmployeeBoarding(userContext, employeeBoardingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, allTokens());

 		return present(userContext,employeeBoarding, allTokens());
		
 	}
 	protected EmployeeBoarding saveEmployeeBoarding(RetailScmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeBoardingDAO().save(employeeBoarding, tokens);
 	}
 	protected EmployeeBoarding loadEmployeeBoarding(RetailScmUserContext userContext, String employeeBoardingId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeBoardingDAO().load(employeeBoardingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String, Object> tokens){
		super.addActions(userContext, employeeBoarding, tokens);
		
		addAction(userContext, employeeBoarding, tokens,"@create","createEmployeeBoarding","createEmployeeBoarding/","main","primary");
		addAction(userContext, employeeBoarding, tokens,"@update","updateEmployeeBoarding","updateEmployeeBoarding/"+employeeBoarding.getId()+"/","main","primary");
		addAction(userContext, employeeBoarding, tokens,"@copy","cloneEmployeeBoarding","cloneEmployeeBoarding/"+employeeBoarding.getId()+"/","main","primary");
		
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.addEmployee","addEmployee","addEmployee/"+employeeBoarding.getId()+"/","employeeList","primary");
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.removeEmployee","removeEmployee","removeEmployee/"+employeeBoarding.getId()+"/","employeeList","primary");
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.updateEmployee","updateEmployee","updateEmployee/"+employeeBoarding.getId()+"/","employeeList","primary");
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+employeeBoarding.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeBoarding createEmployeeBoarding(RetailScmUserContext userContext,String who, Date employTime, String comments
) throws Exception
	{
		
		EmployeeBoardingManagerException exception = new EmployeeBoardingManagerException("Error Occured");

		

		checkWhoOfEmployeeBoarding(userContext,  who, exception);
		checkEmployTimeOfEmployeeBoarding(userContext,  employTime, exception);
		checkCommentsOfEmployeeBoarding(userContext,  comments, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeBoarding employeeBoarding=createNewEmployeeBoarding();	

		employeeBoarding.setWho(who);
		employeeBoarding.setEmployTime(employTime);
		employeeBoarding.setComments(comments);

		return saveEmployeeBoarding(userContext, employeeBoarding, emptyOptions());
		

		
	}
	protected EmployeeBoarding createNewEmployeeBoarding() 
	{
		
		return new EmployeeBoarding();		
	}
	
	protected void checkParamsForUpdatingEmployeeBoarding(RetailScmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeBoardingManagerException exception = new EmployeeBoardingManagerException("Error Occured");
		
		checkIdOfEmployeeBoarding(userContext, employeeBoardingId, exception);
		checkVersionOfEmployeeBoarding(userContext, employeeBoardingVersion, exception);
		

		if(EmployeeBoarding.WHO_PROPERTY.equals(property)){
			checkWhoOfEmployeeBoarding(userContext, parseString(newValueExpr), exception);
		}
		if(EmployeeBoarding.EMPLOY_TIME_PROPERTY.equals(property)){
			checkEmployTimeOfEmployeeBoarding(userContext, parseDate(newValueExpr), exception);
		}
		if(EmployeeBoarding.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfEmployeeBoarding(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeBoarding clone(RetailScmUserContext userContext, String fromEmployeeBoardingId) throws Exception{
		
		return this.getEmployeeBoardingDAO().clone(fromEmployeeBoardingId, this.allTokens());
	}
	
	public EmployeeBoarding updateEmployeeBoarding(RetailScmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeBoarding(userContext, employeeBoardingId, employeeBoardingVersion, property, newValueExpr, tokensExpr);
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		if(employeeBoarding.getVersion() != employeeBoardingVersion){
			String message = "The target version("+employeeBoarding.getVersion()+") is not equals to version("+employeeBoardingVersion+") provided";
			throw new EmployeeBoardingManagerException(message);
		}
		synchronized(employeeBoarding){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeBoarding.
			
			employeeBoarding.changePropery(property, newValueExpr);
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
			//return saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeBoardingTokens tokens(){
		return EmployeeBoardingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeBoardingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeBoardingTokens.mergeAll(tokens).done();
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
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeBoardingId, int employeeBoardingVersion) throws Exception {
		
		deleteInternal(userContext, employeeBoardingId, employeeBoardingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeBoardingId, int employeeBoardingVersion) throws Exception{
		getEmployeeBoardingDAO().delete(employeeBoardingId, employeeBoardingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeBoardingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeBoardingDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		EmployeeBoardingManagerException exception = new EmployeeBoardingManagerException("Error Occured");
		
		checkIdOfEmployeeBoarding(userContext, employeeBoardingId, exception);
		
		
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
		
		checkIdOfSalaryGrade(userContext,  currentSalaryGradeId, exception);
		checkSalaryAccountOfEmployee(userContext,  salaryAccount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  EmployeeBoarding addEmployee(RetailScmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,employeeBoardingId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		synchronized(employeeBoarding){ 
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employeeBoarding.addEmployee( employee );		
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}
	}
	protected Employee createEmployee(RetailScmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

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
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String employeeBoardingId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		EmployeeBoardingManagerException exception = new EmployeeBoardingManagerException("Error Occured");
		
		checkIdOfEmployeeBoarding(userContext, employeeBoardingId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  EmployeeBoarding removeEmployee(RetailScmUserContext userContext, String employeeBoardingId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,employeeBoardingId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		synchronized(employeeBoarding){ 
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employeeBoarding.removeEmployee( employee );		
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String employeeBoardingId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		EmployeeBoardingManagerException exception = new EmployeeBoardingManagerException("Error Occured");
		
		checkIdOfEmployeeBoarding(userContext, employeeBoardingId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  EmployeeBoarding copyEmployeeFrom(RetailScmUserContext userContext, String employeeBoardingId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,employeeBoardingId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		synchronized(employeeBoarding){ 
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employeeBoarding.copyEmployeeFrom( employee );		
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeBoardingManagerException exception = new EmployeeBoardingManagerException("Error Occured");
		
		checkIdOfEmployeeBoarding(userContext, employeeBoardingId, exception);
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
	
	public  EmployeeBoarding updateEmployee(RetailScmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, employeeBoardingId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		
		synchronized(employeeBoarding){ 
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employeeBoarding.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = employeeBoarding.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new EmployeeBoardingManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


