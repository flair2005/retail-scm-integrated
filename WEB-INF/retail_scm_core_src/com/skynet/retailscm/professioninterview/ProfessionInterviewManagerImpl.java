
package com.skynet.retailscm.professioninterview;

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




public class ProfessionInterviewManagerImpl extends RetailScmCheckerManager implements ProfessionInterviewManager {
	
	private static final String SERVICE_TYPE = "ProfessionInterview";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ProfessionInterviewDAO  professionInterviewDAO;
 	public void setProfessionInterviewDAO(ProfessionInterviewDAO  professionInterviewDAO){
 	
 		if(professionInterviewDAO == null){
 			throw new IllegalStateException("Do not try to set professionInterviewDAO to null.");
 		}
	 	this.professionInterviewDAO = professionInterviewDAO;
 	}
 	public ProfessionInterviewDAO getProfessionInterviewDAO(){
 		if(this.professionInterviewDAO == null){
 			throw new IllegalStateException("The ProfessionInterviewDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.professionInterviewDAO;
 	}
 	
 	protected ProfessionInterview saveProfessionInterview(RetailScmUserContext userContext, ProfessionInterview professionInterview, String [] tokensExpr) throws Exception{	
 		//return getProfessionInterviewDAO().save(professionInterview, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProfessionInterview(userContext, professionInterview, tokens);
 	}
 	
 	protected ProfessionInterview saveProfessionInterviewDetail(RetailScmUserContext userContext, ProfessionInterview professionInterview) throws Exception{	

 		
 		return saveProfessionInterview(userContext, professionInterview, allTokens());
 	}
 	
 	public ProfessionInterview loadProfessionInterview(RetailScmUserContext userContext, String professionInterviewId, String [] tokensExpr) throws Exception{				
 
 		ProfessionInterviewManagerException exception = new ProfessionInterviewManagerException("Error Occured");
		
		checkIdOfProfessionInterview(userContext, professionInterviewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,professionInterview, tokens);
 	}
 	
 	protected ProfessionInterview present(RetailScmUserContext userContext, ProfessionInterview professionInterview, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,professionInterview,tokens);
		
		
		return this.getProfessionInterviewDAO().present(professionInterview, tokens);
	}
 
 	
 	
 	public ProfessionInterview loadProfessionInterviewDetail(RetailScmUserContext userContext, String professionInterviewId) throws Exception{	
 		ProfessionInterviewManagerException exception = new ProfessionInterviewManagerException("Error Occured");
		
		checkIdOfProfessionInterview(userContext, professionInterviewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, allTokens());

 		return present(userContext,professionInterview, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String professionInterviewId) throws Exception{	
 		ProfessionInterviewManagerException exception = new ProfessionInterviewManagerException("Error Occured");
		
		checkIdOfProfessionInterview(userContext, professionInterviewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, allTokens());

 		return present(userContext,professionInterview, allTokens());
		
 	}
 	protected ProfessionInterview saveProfessionInterview(RetailScmUserContext userContext, ProfessionInterview professionInterview, Map<String,Object>tokens) throws Exception{	
 		return getProfessionInterviewDAO().save(professionInterview, tokens);
 	}
 	protected ProfessionInterview loadProfessionInterview(RetailScmUserContext userContext, String professionInterviewId, Map<String,Object>tokens) throws Exception{	
 		return getProfessionInterviewDAO().load(professionInterviewId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ProfessionInterview professionInterview, Map<String, Object> tokens){
		super.addActions(userContext, professionInterview, tokens);
		
		addAction(userContext, professionInterview, tokens,"@create","createProfessionInterview","createProfessionInterview/","main","primary");
		addAction(userContext, professionInterview, tokens,"@update","updateProfessionInterview","updateProfessionInterview/"+professionInterview.getId()+"/","main","primary");
		addAction(userContext, professionInterview, tokens,"@copy","cloneProfessionInterview","cloneProfessionInterview/"+professionInterview.getId()+"/","main","primary");
		
		addAction(userContext, professionInterview, tokens,"profession_interview.addEmployee","addEmployee","addEmployee/"+professionInterview.getId()+"/","employeeList","primary");
		addAction(userContext, professionInterview, tokens,"profession_interview.removeEmployee","removeEmployee","removeEmployee/"+professionInterview.getId()+"/","employeeList","primary");
		addAction(userContext, professionInterview, tokens,"profession_interview.updateEmployee","updateEmployee","updateEmployee/"+professionInterview.getId()+"/","employeeList","primary");
		addAction(userContext, professionInterview, tokens,"profession_interview.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+professionInterview.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ProfessionInterview professionInterview, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ProfessionInterview createProfessionInterview(RetailScmUserContext userContext,String who, Date interviewTime, String comments
) throws Exception
	{
		
		ProfessionInterviewManagerException exception = new ProfessionInterviewManagerException("Error Occured");

		

		checkWhoOfProfessionInterview(userContext,  who, exception);
		checkInterviewTimeOfProfessionInterview(userContext,  interviewTime, exception);
		checkCommentsOfProfessionInterview(userContext,  comments, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ProfessionInterview professionInterview=createNewProfessionInterview();	

		professionInterview.setWho(who);
		professionInterview.setInterviewTime(interviewTime);
		professionInterview.setComments(comments);

		return saveProfessionInterview(userContext, professionInterview, emptyOptions());
		

		
	}
	protected ProfessionInterview createNewProfessionInterview() 
	{
		
		return new ProfessionInterview();		
	}
	
	protected void checkParamsForUpdatingProfessionInterview(RetailScmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ProfessionInterviewManagerException exception = new ProfessionInterviewManagerException("Error Occured");
		
		checkIdOfProfessionInterview(userContext, professionInterviewId, exception);
		checkVersionOfProfessionInterview(userContext, professionInterviewVersion, exception);
		

		if(ProfessionInterview.WHO_PROPERTY.equals(property)){
			checkWhoOfProfessionInterview(userContext, parseString(newValueExpr), exception);
		}
		if(ProfessionInterview.INTERVIEW_TIME_PROPERTY.equals(property)){
			checkInterviewTimeOfProfessionInterview(userContext, parseDate(newValueExpr), exception);
		}
		if(ProfessionInterview.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfProfessionInterview(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ProfessionInterview clone(RetailScmUserContext userContext, String fromProfessionInterviewId) throws Exception{
		
		return this.getProfessionInterviewDAO().clone(fromProfessionInterviewId, this.allTokens());
	}
	
	public ProfessionInterview updateProfessionInterview(RetailScmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfessionInterview(userContext, professionInterviewId, professionInterviewVersion, property, newValueExpr, tokensExpr);
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		if(professionInterview.getVersion() != professionInterviewVersion){
			String message = "The target version("+professionInterview.getVersion()+") is not equals to version("+professionInterviewVersion+") provided";
			throw new ProfessionInterviewManagerException(message);
		}
		synchronized(professionInterview){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProfessionInterview.
			
			professionInterview.changePropery(property, newValueExpr);
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
			//return saveProfessionInterview(userContext, professionInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProfessionInterviewTokens tokens(){
		return ProfessionInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProfessionInterviewTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProfessionInterviewTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String professionInterviewId, int professionInterviewVersion) throws Exception {
		
		deleteInternal(userContext, professionInterviewId, professionInterviewVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String professionInterviewId, int professionInterviewVersion) throws Exception{
		getProfessionInterviewDAO().delete(professionInterviewId, professionInterviewVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProfessionInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getProfessionInterviewDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		ProfessionInterviewManagerException exception = new ProfessionInterviewManagerException("Error Occured");
		
		checkIdOfProfessionInterview(userContext, professionInterviewId, exception);
		
		
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
	public  ProfessionInterview addEmployee(RetailScmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,professionInterviewId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		synchronized(professionInterview){ 
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			professionInterview.addEmployee( employee );		
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String professionInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		ProfessionInterviewManagerException exception = new ProfessionInterviewManagerException("Error Occured");
		
		checkIdOfProfessionInterview(userContext, professionInterviewId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ProfessionInterview removeEmployee(RetailScmUserContext userContext, String professionInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,professionInterviewId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		synchronized(professionInterview){ 
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			professionInterview.removeEmployee( employee );		
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String professionInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		ProfessionInterviewManagerException exception = new ProfessionInterviewManagerException("Error Occured");
		
		checkIdOfProfessionInterview(userContext, professionInterviewId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  ProfessionInterview copyEmployeeFrom(RetailScmUserContext userContext, String professionInterviewId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,professionInterviewId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		synchronized(professionInterview){ 
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			professionInterview.copyEmployeeFrom( employee );		
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ProfessionInterviewManagerException exception = new ProfessionInterviewManagerException("Error Occured");
		
		checkIdOfProfessionInterview(userContext, professionInterviewId, exception);
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
	
	public  ProfessionInterview updateEmployee(RetailScmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, professionInterviewId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		
		synchronized(professionInterview){ 
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//professionInterview.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = professionInterview.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new ProfessionInterviewManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


