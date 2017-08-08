
package com.skynet.retailscm.offeracceptance;

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




public class OfferAcceptanceManagerImpl extends RetailScmCheckerManager implements OfferAcceptanceManager {
	
	private static final String SERVICE_TYPE = "OfferAcceptance";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  OfferAcceptanceDAO  offerAcceptanceDAO;
 	public void setOfferAcceptanceDAO(OfferAcceptanceDAO  offerAcceptanceDAO){
 	
 		if(offerAcceptanceDAO == null){
 			throw new IllegalStateException("Do not try to set offerAcceptanceDAO to null.");
 		}
	 	this.offerAcceptanceDAO = offerAcceptanceDAO;
 	}
 	public OfferAcceptanceDAO getOfferAcceptanceDAO(){
 		if(this.offerAcceptanceDAO == null){
 			throw new IllegalStateException("The OfferAcceptanceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.offerAcceptanceDAO;
 	}
 	
 	protected OfferAcceptance saveOfferAcceptance(RetailScmUserContext userContext, OfferAcceptance offerAcceptance, String [] tokensExpr) throws Exception{	
 		//return getOfferAcceptanceDAO().save(offerAcceptance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOfferAcceptance(userContext, offerAcceptance, tokens);
 	}
 	
 	protected OfferAcceptance saveOfferAcceptanceDetail(RetailScmUserContext userContext, OfferAcceptance offerAcceptance) throws Exception{	

 		
 		return saveOfferAcceptance(userContext, offerAcceptance, allTokens());
 	}
 	
 	public OfferAcceptance loadOfferAcceptance(RetailScmUserContext userContext, String offerAcceptanceId, String [] tokensExpr) throws Exception{				
 
 		OfferAcceptanceManagerException exception = new OfferAcceptanceManagerException("Error Occured");
		
		checkIdOfOfferAcceptance(userContext, offerAcceptanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerAcceptance, tokens);
 	}
 	
 	protected OfferAcceptance present(RetailScmUserContext userContext, OfferAcceptance offerAcceptance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,offerAcceptance,tokens);
		
		
		return this.getOfferAcceptanceDAO().present(offerAcceptance, tokens);
	}
 
 	
 	
 	public OfferAcceptance loadOfferAcceptanceDetail(RetailScmUserContext userContext, String offerAcceptanceId) throws Exception{	
 		OfferAcceptanceManagerException exception = new OfferAcceptanceManagerException("Error Occured");
		
		checkIdOfOfferAcceptance(userContext, offerAcceptanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, allTokens());

 		return present(userContext,offerAcceptance, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String offerAcceptanceId) throws Exception{	
 		OfferAcceptanceManagerException exception = new OfferAcceptanceManagerException("Error Occured");
		
		checkIdOfOfferAcceptance(userContext, offerAcceptanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, allTokens());

 		return present(userContext,offerAcceptance, allTokens());
		
 	}
 	protected OfferAcceptance saveOfferAcceptance(RetailScmUserContext userContext, OfferAcceptance offerAcceptance, Map<String,Object>tokens) throws Exception{	
 		return getOfferAcceptanceDAO().save(offerAcceptance, tokens);
 	}
 	protected OfferAcceptance loadOfferAcceptance(RetailScmUserContext userContext, String offerAcceptanceId, Map<String,Object>tokens) throws Exception{	
 		return getOfferAcceptanceDAO().load(offerAcceptanceId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OfferAcceptance offerAcceptance, Map<String, Object> tokens){
		super.addActions(userContext, offerAcceptance, tokens);
		
		addAction(userContext, offerAcceptance, tokens,"@create","createOfferAcceptance","createOfferAcceptance/","main","primary");
		addAction(userContext, offerAcceptance, tokens,"@update","updateOfferAcceptance","updateOfferAcceptance/"+offerAcceptance.getId()+"/","main","primary");
		addAction(userContext, offerAcceptance, tokens,"@copy","cloneOfferAcceptance","cloneOfferAcceptance/"+offerAcceptance.getId()+"/","main","primary");
		
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.addEmployee","addEmployee","addEmployee/"+offerAcceptance.getId()+"/","employeeList","primary");
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.removeEmployee","removeEmployee","removeEmployee/"+offerAcceptance.getId()+"/","employeeList","primary");
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.updateEmployee","updateEmployee","updateEmployee/"+offerAcceptance.getId()+"/","employeeList","primary");
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+offerAcceptance.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OfferAcceptance offerAcceptance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OfferAcceptance createOfferAcceptance(RetailScmUserContext userContext,String who, Date acceptTime, String comments
) throws Exception
	{
		
		OfferAcceptanceManagerException exception = new OfferAcceptanceManagerException("Error Occured");

		

		checkWhoOfOfferAcceptance(userContext,  who, exception);
		checkAcceptTimeOfOfferAcceptance(userContext,  acceptTime, exception);
		checkCommentsOfOfferAcceptance(userContext,  comments, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		OfferAcceptance offerAcceptance=createNewOfferAcceptance();	

		offerAcceptance.setWho(who);
		offerAcceptance.setAcceptTime(acceptTime);
		offerAcceptance.setComments(comments);

		return saveOfferAcceptance(userContext, offerAcceptance, emptyOptions());
		

		
	}
	protected OfferAcceptance createNewOfferAcceptance() 
	{
		
		return new OfferAcceptance();		
	}
	
	protected void checkParamsForUpdatingOfferAcceptance(RetailScmUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		OfferAcceptanceManagerException exception = new OfferAcceptanceManagerException("Error Occured");
		
		checkIdOfOfferAcceptance(userContext, offerAcceptanceId, exception);
		checkVersionOfOfferAcceptance(userContext, offerAcceptanceVersion, exception);
		

		if(OfferAcceptance.WHO_PROPERTY.equals(property)){
			checkWhoOfOfferAcceptance(userContext, parseString(newValueExpr), exception);
		}
		if(OfferAcceptance.ACCEPT_TIME_PROPERTY.equals(property)){
			checkAcceptTimeOfOfferAcceptance(userContext, parseDate(newValueExpr), exception);
		}
		if(OfferAcceptance.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfOfferAcceptance(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public OfferAcceptance clone(RetailScmUserContext userContext, String fromOfferAcceptanceId) throws Exception{
		
		return this.getOfferAcceptanceDAO().clone(fromOfferAcceptanceId, this.allTokens());
	}
	
	public OfferAcceptance updateOfferAcceptance(RetailScmUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOfferAcceptance(userContext, offerAcceptanceId, offerAcceptanceVersion, property, newValueExpr, tokensExpr);
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		if(offerAcceptance.getVersion() != offerAcceptanceVersion){
			String message = "The target version("+offerAcceptance.getVersion()+") is not equals to version("+offerAcceptanceVersion+") provided";
			throw new OfferAcceptanceManagerException(message);
		}
		synchronized(offerAcceptance){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferAcceptance.
			
			offerAcceptance.changePropery(property, newValueExpr);
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
			//return saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OfferAcceptanceTokens tokens(){
		return OfferAcceptanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OfferAcceptanceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OfferAcceptanceTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String offerAcceptanceId, int offerAcceptanceVersion) throws Exception {
		
		deleteInternal(userContext, offerAcceptanceId, offerAcceptanceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String offerAcceptanceId, int offerAcceptanceVersion) throws Exception{
		getOfferAcceptanceDAO().delete(offerAcceptanceId, offerAcceptanceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OfferAcceptanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getOfferAcceptanceDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		OfferAcceptanceManagerException exception = new OfferAcceptanceManagerException("Error Occured");
		
		checkIdOfOfferAcceptance(userContext, offerAcceptanceId, exception);
		
		
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
	public  OfferAcceptance addEmployee(RetailScmUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,offerAcceptanceId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		synchronized(offerAcceptance){ 
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerAcceptance.addEmployee( employee );		
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String offerAcceptanceId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		OfferAcceptanceManagerException exception = new OfferAcceptanceManagerException("Error Occured");
		
		checkIdOfOfferAcceptance(userContext, offerAcceptanceId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OfferAcceptance removeEmployee(RetailScmUserContext userContext, String offerAcceptanceId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,offerAcceptanceId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		synchronized(offerAcceptance){ 
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerAcceptance.removeEmployee( employee );		
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String offerAcceptanceId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		OfferAcceptanceManagerException exception = new OfferAcceptanceManagerException("Error Occured");
		
		checkIdOfOfferAcceptance(userContext, offerAcceptanceId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OfferAcceptance copyEmployeeFrom(RetailScmUserContext userContext, String offerAcceptanceId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,offerAcceptanceId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		synchronized(offerAcceptance){ 
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerAcceptance.copyEmployeeFrom( employee );		
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		OfferAcceptanceManagerException exception = new OfferAcceptanceManagerException("Error Occured");
		
		checkIdOfOfferAcceptance(userContext, offerAcceptanceId, exception);
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
	
	public  OfferAcceptance updateEmployee(RetailScmUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, offerAcceptanceId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		
		synchronized(offerAcceptance){ 
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//offerAcceptance.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = offerAcceptance.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new OfferAcceptanceManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


