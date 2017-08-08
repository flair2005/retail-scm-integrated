
package com.skynet.retailscm.jobapplication;

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




public class JobApplicationManagerImpl extends RetailScmCheckerManager implements JobApplicationManager {
	
	private static final String SERVICE_TYPE = "JobApplication";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  JobApplicationDAO  jobApplicationDAO;
 	public void setJobApplicationDAO(JobApplicationDAO  jobApplicationDAO){
 	
 		if(jobApplicationDAO == null){
 			throw new IllegalStateException("Do not try to set jobApplicationDAO to null.");
 		}
	 	this.jobApplicationDAO = jobApplicationDAO;
 	}
 	public JobApplicationDAO getJobApplicationDAO(){
 		if(this.jobApplicationDAO == null){
 			throw new IllegalStateException("The JobApplicationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.jobApplicationDAO;
 	}
 	
 	protected JobApplication saveJobApplication(RetailScmUserContext userContext, JobApplication jobApplication, String [] tokensExpr) throws Exception{	
 		//return getJobApplicationDAO().save(jobApplication, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveJobApplication(userContext, jobApplication, tokens);
 	}
 	
 	protected JobApplication saveJobApplicationDetail(RetailScmUserContext userContext, JobApplication jobApplication) throws Exception{	

 		
 		return saveJobApplication(userContext, jobApplication, allTokens());
 	}
 	
 	public JobApplication loadJobApplication(RetailScmUserContext userContext, String jobApplicationId, String [] tokensExpr) throws Exception{				
 
 		JobApplicationManagerException exception = new JobApplicationManagerException("Error Occured");
		
		checkIdOfJobApplication(userContext, jobApplicationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,jobApplication, tokens);
 	}
 	
 	protected JobApplication present(RetailScmUserContext userContext, JobApplication jobApplication, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,jobApplication,tokens);
		
		
		return this.getJobApplicationDAO().present(jobApplication, tokens);
	}
 
 	
 	
 	public JobApplication loadJobApplicationDetail(RetailScmUserContext userContext, String jobApplicationId) throws Exception{	
 		JobApplicationManagerException exception = new JobApplicationManagerException("Error Occured");
		
		checkIdOfJobApplication(userContext, jobApplicationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, allTokens());

 		return present(userContext,jobApplication, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String jobApplicationId) throws Exception{	
 		JobApplicationManagerException exception = new JobApplicationManagerException("Error Occured");
		
		checkIdOfJobApplication(userContext, jobApplicationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		JobApplication jobApplication = loadJobApplication( userContext, jobApplicationId, allTokens());

 		return present(userContext,jobApplication, allTokens());
		
 	}
 	protected JobApplication saveJobApplication(RetailScmUserContext userContext, JobApplication jobApplication, Map<String,Object>tokens) throws Exception{	
 		return getJobApplicationDAO().save(jobApplication, tokens);
 	}
 	protected JobApplication loadJobApplication(RetailScmUserContext userContext, String jobApplicationId, Map<String,Object>tokens) throws Exception{	
 		return getJobApplicationDAO().load(jobApplicationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, JobApplication jobApplication, Map<String, Object> tokens){
		super.addActions(userContext, jobApplication, tokens);
		
		addAction(userContext, jobApplication, tokens,"@create","createJobApplication","createJobApplication/","main","primary");
		addAction(userContext, jobApplication, tokens,"@update","updateJobApplication","updateJobApplication/"+jobApplication.getId()+"/","main","primary");
		addAction(userContext, jobApplication, tokens,"@copy","cloneJobApplication","cloneJobApplication/"+jobApplication.getId()+"/","main","primary");
		
		addAction(userContext, jobApplication, tokens,"job_application.addEmployee","addEmployee","addEmployee/"+jobApplication.getId()+"/","employeeList","primary");
		addAction(userContext, jobApplication, tokens,"job_application.removeEmployee","removeEmployee","removeEmployee/"+jobApplication.getId()+"/","employeeList","primary");
		addAction(userContext, jobApplication, tokens,"job_application.updateEmployee","updateEmployee","updateEmployee/"+jobApplication.getId()+"/","employeeList","primary");
		addAction(userContext, jobApplication, tokens,"job_application.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+jobApplication.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, JobApplication jobApplication, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public JobApplication createJobApplication(RetailScmUserContext userContext,Date applicationTime, String who, String comments
) throws Exception
	{
		
		JobApplicationManagerException exception = new JobApplicationManagerException("Error Occured");

		

		checkApplicationTimeOfJobApplication(userContext,  applicationTime, exception);
		checkWhoOfJobApplication(userContext,  who, exception);
		checkCommentsOfJobApplication(userContext,  comments, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		JobApplication jobApplication=createNewJobApplication();	

		jobApplication.setApplicationTime(applicationTime);
		jobApplication.setWho(who);
		jobApplication.setComments(comments);

		return saveJobApplication(userContext, jobApplication, emptyOptions());
		

		
	}
	protected JobApplication createNewJobApplication() 
	{
		
		return new JobApplication();		
	}
	
	protected void checkParamsForUpdatingJobApplication(RetailScmUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		JobApplicationManagerException exception = new JobApplicationManagerException("Error Occured");
		
		checkIdOfJobApplication(userContext, jobApplicationId, exception);
		checkVersionOfJobApplication(userContext, jobApplicationVersion, exception);
		

		if(JobApplication.APPLICATION_TIME_PROPERTY.equals(property)){
			checkApplicationTimeOfJobApplication(userContext, parseDate(newValueExpr), exception);
		}
		if(JobApplication.WHO_PROPERTY.equals(property)){
			checkWhoOfJobApplication(userContext, parseString(newValueExpr), exception);
		}
		if(JobApplication.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfJobApplication(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public JobApplication clone(RetailScmUserContext userContext, String fromJobApplicationId) throws Exception{
		
		return this.getJobApplicationDAO().clone(fromJobApplicationId, this.allTokens());
	}
	
	public JobApplication updateJobApplication(RetailScmUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingJobApplication(userContext, jobApplicationId, jobApplicationVersion, property, newValueExpr, tokensExpr);
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		if(jobApplication.getVersion() != jobApplicationVersion){
			String message = "The target version("+jobApplication.getVersion()+") is not equals to version("+jobApplicationVersion+") provided";
			throw new JobApplicationManagerException(message);
		}
		synchronized(jobApplication){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to JobApplication.
			
			jobApplication.changePropery(property, newValueExpr);
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
			//return saveJobApplication(userContext, jobApplication, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected JobApplicationTokens tokens(){
		return JobApplicationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return JobApplicationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return JobApplicationTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String jobApplicationId, int jobApplicationVersion) throws Exception {
		
		deleteInternal(userContext, jobApplicationId, jobApplicationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String jobApplicationId, int jobApplicationVersion) throws Exception{
		getJobApplicationDAO().delete(jobApplicationId, jobApplicationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new JobApplicationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getJobApplicationDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		JobApplicationManagerException exception = new JobApplicationManagerException("Error Occured");
		
		checkIdOfJobApplication(userContext, jobApplicationId, exception);
		
		
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
	public  JobApplication addEmployee(RetailScmUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,jobApplicationId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		synchronized(jobApplication){ 
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			jobApplication.addEmployee( employee );		
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String jobApplicationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		JobApplicationManagerException exception = new JobApplicationManagerException("Error Occured");
		
		checkIdOfJobApplication(userContext, jobApplicationId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  JobApplication removeEmployee(RetailScmUserContext userContext, String jobApplicationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,jobApplicationId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		synchronized(jobApplication){ 
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			jobApplication.removeEmployee( employee );		
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String jobApplicationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		JobApplicationManagerException exception = new JobApplicationManagerException("Error Occured");
		
		checkIdOfJobApplication(userContext, jobApplicationId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  JobApplication copyEmployeeFrom(RetailScmUserContext userContext, String jobApplicationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,jobApplicationId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		synchronized(jobApplication){ 
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			jobApplication.copyEmployeeFrom( employee );		
			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		JobApplicationManagerException exception = new JobApplicationManagerException("Error Occured");
		
		checkIdOfJobApplication(userContext, jobApplicationId, exception);
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
	
	public  JobApplication updateEmployee(RetailScmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, jobApplicationId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		JobApplication jobApplication = loadJobApplication(userContext, jobApplicationId, allTokens());
		
		synchronized(jobApplication){ 
			//Will be good when the jobApplication loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//jobApplication.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = jobApplication.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new JobApplicationManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			jobApplication = saveJobApplication(userContext, jobApplication, tokens().withEmployeeList().done());
			return present(userContext,jobApplication, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


