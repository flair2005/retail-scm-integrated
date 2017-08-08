
package com.skynet.retailscm.offerapproval;

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




public class OfferApprovalManagerImpl extends RetailScmCheckerManager implements OfferApprovalManager {
	
	private static final String SERVICE_TYPE = "OfferApproval";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  OfferApprovalDAO  offerApprovalDAO;
 	public void setOfferApprovalDAO(OfferApprovalDAO  offerApprovalDAO){
 	
 		if(offerApprovalDAO == null){
 			throw new IllegalStateException("Do not try to set offerApprovalDAO to null.");
 		}
	 	this.offerApprovalDAO = offerApprovalDAO;
 	}
 	public OfferApprovalDAO getOfferApprovalDAO(){
 		if(this.offerApprovalDAO == null){
 			throw new IllegalStateException("The OfferApprovalDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.offerApprovalDAO;
 	}
 	
 	protected OfferApproval saveOfferApproval(RetailScmUserContext userContext, OfferApproval offerApproval, String [] tokensExpr) throws Exception{	
 		//return getOfferApprovalDAO().save(offerApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOfferApproval(userContext, offerApproval, tokens);
 	}
 	
 	protected OfferApproval saveOfferApprovalDetail(RetailScmUserContext userContext, OfferApproval offerApproval) throws Exception{	

 		
 		return saveOfferApproval(userContext, offerApproval, allTokens());
 	}
 	
 	public OfferApproval loadOfferApproval(RetailScmUserContext userContext, String offerApprovalId, String [] tokensExpr) throws Exception{				
 
 		OfferApprovalManagerException exception = new OfferApprovalManagerException("Error Occured");
		
		checkIdOfOfferApproval(userContext, offerApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerApproval, tokens);
 	}
 	
 	protected OfferApproval present(RetailScmUserContext userContext, OfferApproval offerApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,offerApproval,tokens);
		
		
		return this.getOfferApprovalDAO().present(offerApproval, tokens);
	}
 
 	
 	
 	public OfferApproval loadOfferApprovalDetail(RetailScmUserContext userContext, String offerApprovalId) throws Exception{	
 		OfferApprovalManagerException exception = new OfferApprovalManagerException("Error Occured");
		
		checkIdOfOfferApproval(userContext, offerApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, allTokens());

 		return present(userContext,offerApproval, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String offerApprovalId) throws Exception{	
 		OfferApprovalManagerException exception = new OfferApprovalManagerException("Error Occured");
		
		checkIdOfOfferApproval(userContext, offerApprovalId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, allTokens());

 		return present(userContext,offerApproval, allTokens());
		
 	}
 	protected OfferApproval saveOfferApproval(RetailScmUserContext userContext, OfferApproval offerApproval, Map<String,Object>tokens) throws Exception{	
 		return getOfferApprovalDAO().save(offerApproval, tokens);
 	}
 	protected OfferApproval loadOfferApproval(RetailScmUserContext userContext, String offerApprovalId, Map<String,Object>tokens) throws Exception{	
 		return getOfferApprovalDAO().load(offerApprovalId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OfferApproval offerApproval, Map<String, Object> tokens){
		super.addActions(userContext, offerApproval, tokens);
		
		addAction(userContext, offerApproval, tokens,"@create","createOfferApproval","createOfferApproval/","main","primary");
		addAction(userContext, offerApproval, tokens,"@update","updateOfferApproval","updateOfferApproval/"+offerApproval.getId()+"/","main","primary");
		addAction(userContext, offerApproval, tokens,"@copy","cloneOfferApproval","cloneOfferApproval/"+offerApproval.getId()+"/","main","primary");
		
		addAction(userContext, offerApproval, tokens,"offer_approval.addEmployee","addEmployee","addEmployee/"+offerApproval.getId()+"/","employeeList","primary");
		addAction(userContext, offerApproval, tokens,"offer_approval.removeEmployee","removeEmployee","removeEmployee/"+offerApproval.getId()+"/","employeeList","primary");
		addAction(userContext, offerApproval, tokens,"offer_approval.updateEmployee","updateEmployee","updateEmployee/"+offerApproval.getId()+"/","employeeList","primary");
		addAction(userContext, offerApproval, tokens,"offer_approval.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+offerApproval.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OfferApproval offerApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OfferApproval createOfferApproval(RetailScmUserContext userContext,String who, Date approveTime, String comments
) throws Exception
	{
		
		OfferApprovalManagerException exception = new OfferApprovalManagerException("Error Occured");

		

		checkWhoOfOfferApproval(userContext,  who, exception);
		checkApproveTimeOfOfferApproval(userContext,  approveTime, exception);
		checkCommentsOfOfferApproval(userContext,  comments, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		OfferApproval offerApproval=createNewOfferApproval();	

		offerApproval.setWho(who);
		offerApproval.setApproveTime(approveTime);
		offerApproval.setComments(comments);

		return saveOfferApproval(userContext, offerApproval, emptyOptions());
		

		
	}
	protected OfferApproval createNewOfferApproval() 
	{
		
		return new OfferApproval();		
	}
	
	protected void checkParamsForUpdatingOfferApproval(RetailScmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		OfferApprovalManagerException exception = new OfferApprovalManagerException("Error Occured");
		
		checkIdOfOfferApproval(userContext, offerApprovalId, exception);
		checkVersionOfOfferApproval(userContext, offerApprovalVersion, exception);
		

		if(OfferApproval.WHO_PROPERTY.equals(property)){
			checkWhoOfOfferApproval(userContext, parseString(newValueExpr), exception);
		}
		if(OfferApproval.APPROVE_TIME_PROPERTY.equals(property)){
			checkApproveTimeOfOfferApproval(userContext, parseDate(newValueExpr), exception);
		}
		if(OfferApproval.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfOfferApproval(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public OfferApproval clone(RetailScmUserContext userContext, String fromOfferApprovalId) throws Exception{
		
		return this.getOfferApprovalDAO().clone(fromOfferApprovalId, this.allTokens());
	}
	
	public OfferApproval updateOfferApproval(RetailScmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOfferApproval(userContext, offerApprovalId, offerApprovalVersion, property, newValueExpr, tokensExpr);
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		if(offerApproval.getVersion() != offerApprovalVersion){
			String message = "The target version("+offerApproval.getVersion()+") is not equals to version("+offerApprovalVersion+") provided";
			throw new OfferApprovalManagerException(message);
		}
		synchronized(offerApproval){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferApproval.
			
			offerApproval.changePropery(property, newValueExpr);
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
			//return saveOfferApproval(userContext, offerApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OfferApprovalTokens tokens(){
		return OfferApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OfferApprovalTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OfferApprovalTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String offerApprovalId, int offerApprovalVersion) throws Exception {
		
		deleteInternal(userContext, offerApprovalId, offerApprovalVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String offerApprovalId, int offerApprovalVersion) throws Exception{
		getOfferApprovalDAO().delete(offerApprovalId, offerApprovalVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OfferApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getOfferApprovalDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		OfferApprovalManagerException exception = new OfferApprovalManagerException("Error Occured");
		
		checkIdOfOfferApproval(userContext, offerApprovalId, exception);
		
		
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
	public  OfferApproval addEmployee(RetailScmUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,offerApprovalId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		synchronized(offerApproval){ 
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerApproval.addEmployee( employee );		
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String offerApprovalId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		OfferApprovalManagerException exception = new OfferApprovalManagerException("Error Occured");
		
		checkIdOfOfferApproval(userContext, offerApprovalId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OfferApproval removeEmployee(RetailScmUserContext userContext, String offerApprovalId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,offerApprovalId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		synchronized(offerApproval){ 
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerApproval.removeEmployee( employee );		
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String offerApprovalId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		OfferApprovalManagerException exception = new OfferApprovalManagerException("Error Occured");
		
		checkIdOfOfferApproval(userContext, offerApprovalId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OfferApproval copyEmployeeFrom(RetailScmUserContext userContext, String offerApprovalId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,offerApprovalId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		synchronized(offerApproval){ 
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerApproval.copyEmployeeFrom( employee );		
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		OfferApprovalManagerException exception = new OfferApprovalManagerException("Error Occured");
		
		checkIdOfOfferApproval(userContext, offerApprovalId, exception);
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
	
	public  OfferApproval updateEmployee(RetailScmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, offerApprovalId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		
		synchronized(offerApproval){ 
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//offerApproval.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = offerApproval.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new OfferApprovalManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


