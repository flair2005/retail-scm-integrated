
package com.skynet.retailscm.hrinterview;

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




public class HrInterviewManagerImpl extends RetailScmCheckerManager implements HrInterviewManager {
	
	private static final String SERVICE_TYPE = "HrInterview";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  HrInterviewDAO  hrInterviewDAO;
 	public void setHrInterviewDAO(HrInterviewDAO  hrInterviewDAO){
 	
 		if(hrInterviewDAO == null){
 			throw new IllegalStateException("Do not try to set hrInterviewDAO to null.");
 		}
	 	this.hrInterviewDAO = hrInterviewDAO;
 	}
 	public HrInterviewDAO getHrInterviewDAO(){
 		if(this.hrInterviewDAO == null){
 			throw new IllegalStateException("The HrInterviewDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.hrInterviewDAO;
 	}
 	
 	protected HrInterview saveHrInterview(RetailScmUserContext userContext, HrInterview hrInterview, String [] tokensExpr) throws Exception{	
 		//return getHrInterviewDAO().save(hrInterview, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveHrInterview(userContext, hrInterview, tokens);
 	}
 	
 	protected HrInterview saveHrInterviewDetail(RetailScmUserContext userContext, HrInterview hrInterview) throws Exception{	

 		
 		return saveHrInterview(userContext, hrInterview, allTokens());
 	}
 	
 	public HrInterview loadHrInterview(RetailScmUserContext userContext, String hrInterviewId, String [] tokensExpr) throws Exception{				
 
 		HrInterviewManagerException exception = new HrInterviewManagerException("Error Occured");
		
		checkIdOfHrInterview(userContext, hrInterviewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hrInterview, tokens);
 	}
 	
 	protected HrInterview present(RetailScmUserContext userContext, HrInterview hrInterview, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,hrInterview,tokens);
		
		
		return this.getHrInterviewDAO().present(hrInterview, tokens);
	}
 
 	
 	
 	public HrInterview loadHrInterviewDetail(RetailScmUserContext userContext, String hrInterviewId) throws Exception{	
 		HrInterviewManagerException exception = new HrInterviewManagerException("Error Occured");
		
		checkIdOfHrInterview(userContext, hrInterviewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, allTokens());

 		return present(userContext,hrInterview, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String hrInterviewId) throws Exception{	
 		HrInterviewManagerException exception = new HrInterviewManagerException("Error Occured");
		
		checkIdOfHrInterview(userContext, hrInterviewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, allTokens());

 		return present(userContext,hrInterview, allTokens());
		
 	}
 	protected HrInterview saveHrInterview(RetailScmUserContext userContext, HrInterview hrInterview, Map<String,Object>tokens) throws Exception{	
 		return getHrInterviewDAO().save(hrInterview, tokens);
 	}
 	protected HrInterview loadHrInterview(RetailScmUserContext userContext, String hrInterviewId, Map<String,Object>tokens) throws Exception{	
 		return getHrInterviewDAO().load(hrInterviewId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, HrInterview hrInterview, Map<String, Object> tokens){
		super.addActions(userContext, hrInterview, tokens);
		
		addAction(userContext, hrInterview, tokens,"@create","createHrInterview","createHrInterview/","main","primary");
		addAction(userContext, hrInterview, tokens,"@update","updateHrInterview","updateHrInterview/"+hrInterview.getId()+"/","main","primary");
		addAction(userContext, hrInterview, tokens,"@copy","cloneHrInterview","cloneHrInterview/"+hrInterview.getId()+"/","main","primary");
		
		addAction(userContext, hrInterview, tokens,"hr_interview.addEmployee","addEmployee","addEmployee/"+hrInterview.getId()+"/","employeeList","primary");
		addAction(userContext, hrInterview, tokens,"hr_interview.removeEmployee","removeEmployee","removeEmployee/"+hrInterview.getId()+"/","employeeList","primary");
		addAction(userContext, hrInterview, tokens,"hr_interview.updateEmployee","updateEmployee","updateEmployee/"+hrInterview.getId()+"/","employeeList","primary");
		addAction(userContext, hrInterview, tokens,"hr_interview.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+hrInterview.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, HrInterview hrInterview, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public HrInterview createHrInterview(RetailScmUserContext userContext,String who, Date interviewTime, String comments
) throws Exception
	{
		
		HrInterviewManagerException exception = new HrInterviewManagerException("Error Occured");

		

		checkWhoOfHrInterview(userContext,  who, exception);
		checkInterviewTimeOfHrInterview(userContext,  interviewTime, exception);
		checkCommentsOfHrInterview(userContext,  comments, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		HrInterview hrInterview=createNewHrInterview();	

		hrInterview.setWho(who);
		hrInterview.setInterviewTime(interviewTime);
		hrInterview.setComments(comments);

		return saveHrInterview(userContext, hrInterview, emptyOptions());
		

		
	}
	protected HrInterview createNewHrInterview() 
	{
		
		return new HrInterview();		
	}
	
	protected void checkParamsForUpdatingHrInterview(RetailScmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		HrInterviewManagerException exception = new HrInterviewManagerException("Error Occured");
		
		checkIdOfHrInterview(userContext, hrInterviewId, exception);
		checkVersionOfHrInterview(userContext, hrInterviewVersion, exception);
		

		if(HrInterview.WHO_PROPERTY.equals(property)){
			checkWhoOfHrInterview(userContext, parseString(newValueExpr), exception);
		}
		if(HrInterview.INTERVIEW_TIME_PROPERTY.equals(property)){
			checkInterviewTimeOfHrInterview(userContext, parseDate(newValueExpr), exception);
		}
		if(HrInterview.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfHrInterview(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public HrInterview clone(RetailScmUserContext userContext, String fromHrInterviewId) throws Exception{
		
		return this.getHrInterviewDAO().clone(fromHrInterviewId, this.allTokens());
	}
	
	public HrInterview updateHrInterview(RetailScmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingHrInterview(userContext, hrInterviewId, hrInterviewVersion, property, newValueExpr, tokensExpr);
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		if(hrInterview.getVersion() != hrInterviewVersion){
			String message = "The target version("+hrInterview.getVersion()+") is not equals to version("+hrInterviewVersion+") provided";
			throw new HrInterviewManagerException(message);
		}
		synchronized(hrInterview){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HrInterview.
			
			hrInterview.changePropery(property, newValueExpr);
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
			//return saveHrInterview(userContext, hrInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected HrInterviewTokens tokens(){
		return HrInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return HrInterviewTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return HrInterviewTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String hrInterviewId, int hrInterviewVersion) throws Exception {
		
		deleteInternal(userContext, hrInterviewId, hrInterviewVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String hrInterviewId, int hrInterviewVersion) throws Exception{
		getHrInterviewDAO().delete(hrInterviewId, hrInterviewVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new HrInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getHrInterviewDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		HrInterviewManagerException exception = new HrInterviewManagerException("Error Occured");
		
		checkIdOfHrInterview(userContext, hrInterviewId, exception);
		
		
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
	public  HrInterview addEmployee(RetailScmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,hrInterviewId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		synchronized(hrInterview){ 
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hrInterview.addEmployee( employee );		
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String hrInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		HrInterviewManagerException exception = new HrInterviewManagerException("Error Occured");
		
		checkIdOfHrInterview(userContext, hrInterviewId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  HrInterview removeEmployee(RetailScmUserContext userContext, String hrInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,hrInterviewId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		synchronized(hrInterview){ 
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hrInterview.removeEmployee( employee );		
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String hrInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		HrInterviewManagerException exception = new HrInterviewManagerException("Error Occured");
		
		checkIdOfHrInterview(userContext, hrInterviewId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  HrInterview copyEmployeeFrom(RetailScmUserContext userContext, String hrInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,hrInterviewId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		synchronized(hrInterview){ 
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hrInterview.copyEmployeeFrom( employee );		
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		HrInterviewManagerException exception = new HrInterviewManagerException("Error Occured");
		
		checkIdOfHrInterview(userContext, hrInterviewId, exception);
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
	
	public  HrInterview updateEmployee(RetailScmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, hrInterviewId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		
		synchronized(hrInterview){ 
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hrInterview.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = hrInterview.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new HrInterviewManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


