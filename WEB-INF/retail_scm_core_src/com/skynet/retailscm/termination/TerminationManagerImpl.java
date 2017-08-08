
package com.skynet.retailscm.termination;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.terminationreason.TerminationReason;
import com.skynet.retailscm.terminationtype.TerminationType;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.terminationreason.TerminationReasonDAO;
import com.skynet.retailscm.terminationtype.TerminationTypeDAO;

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
import com.skynet.retailscm.terminationtype.TerminationTypeTable;
import com.skynet.retailscm.terminationreason.TerminationReasonTable;




public class TerminationManagerImpl extends RetailScmCheckerManager implements TerminationManager {
	
	private static final String SERVICE_TYPE = "Termination";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  TerminationDAO  terminationDAO;
 	public void setTerminationDAO(TerminationDAO  terminationDAO){
 	
 		if(terminationDAO == null){
 			throw new IllegalStateException("Do not try to set terminationDAO to null.");
 		}
	 	this.terminationDAO = terminationDAO;
 	}
 	public TerminationDAO getTerminationDAO(){
 		if(this.terminationDAO == null){
 			throw new IllegalStateException("The TerminationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.terminationDAO;
 	}
 	
 	protected Termination saveTermination(RetailScmUserContext userContext, Termination termination, String [] tokensExpr) throws Exception{	
 		//return getTerminationDAO().save(termination, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTermination(userContext, termination, tokens);
 	}
 	
 	protected Termination saveTerminationDetail(RetailScmUserContext userContext, Termination termination) throws Exception{	

 		
 		return saveTermination(userContext, termination, allTokens());
 	}
 	
 	public Termination loadTermination(RetailScmUserContext userContext, String terminationId, String [] tokensExpr) throws Exception{				
 
 		TerminationManagerException exception = new TerminationManagerException("Error Occured");
		
		checkIdOfTermination(userContext, terminationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Termination termination = loadTermination( userContext, terminationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,termination, tokens);
 	}
 	
 	protected Termination present(RetailScmUserContext userContext, Termination termination, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,termination,tokens);
		
		
		return this.getTerminationDAO().present(termination, tokens);
	}
 
 	
 	
 	public Termination loadTerminationDetail(RetailScmUserContext userContext, String terminationId) throws Exception{	
 		TerminationManagerException exception = new TerminationManagerException("Error Occured");
		
		checkIdOfTermination(userContext, terminationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Termination termination = loadTermination( userContext, terminationId, allTokens());

 		return present(userContext,termination, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String terminationId) throws Exception{	
 		TerminationManagerException exception = new TerminationManagerException("Error Occured");
		
		checkIdOfTermination(userContext, terminationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Termination termination = loadTermination( userContext, terminationId, allTokens());

 		return present(userContext,termination, allTokens());
		
 	}
 	protected Termination saveTermination(RetailScmUserContext userContext, Termination termination, Map<String,Object>tokens) throws Exception{	
 		return getTerminationDAO().save(termination, tokens);
 	}
 	protected Termination loadTermination(RetailScmUserContext userContext, String terminationId, Map<String,Object>tokens) throws Exception{	
 		return getTerminationDAO().load(terminationId, tokens);
 	}

	



 	 
 	
 	private  TerminationTypeDAO  terminationTypeDAO;
 	public void setTerminationTypeDAO(TerminationTypeDAO terminationTypeDAO){
	 	this.terminationTypeDAO = terminationTypeDAO;
 	}
 	//------------------------------------
 	public TerminationTypeDAO getTerminationTypeDAO(){
	 	return this.terminationTypeDAO;
 	}
 
 	
 	private  TerminationReasonDAO  terminationReasonDAO;
 	public void setTerminationReasonDAO(TerminationReasonDAO terminationReasonDAO){
	 	this.terminationReasonDAO = terminationReasonDAO;
 	}
 	//------------------------------------
 	public TerminationReasonDAO getTerminationReasonDAO(){
	 	return this.terminationReasonDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Termination termination, Map<String, Object> tokens){
		super.addActions(userContext, termination, tokens);
		
		addAction(userContext, termination, tokens,"@create","createTermination","createTermination/","main","primary");
		addAction(userContext, termination, tokens,"@update","updateTermination","updateTermination/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"@copy","cloneTermination","cloneTermination/"+termination.getId()+"/","main","primary");
		
		addAction(userContext, termination, tokens,"termination.transfer_to_reason","transferToAnotherReason","transferToAnotherReason/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"termination.transfer_to_type","transferToAnotherType","transferToAnotherType/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"termination.addEmployee","addEmployee","addEmployee/"+termination.getId()+"/","employeeList","primary");
		addAction(userContext, termination, tokens,"termination.removeEmployee","removeEmployee","removeEmployee/"+termination.getId()+"/","employeeList","primary");
		addAction(userContext, termination, tokens,"termination.updateEmployee","updateEmployee","updateEmployee/"+termination.getId()+"/","employeeList","primary");
		addAction(userContext, termination, tokens,"termination.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+termination.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Termination termination, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Termination createTermination(RetailScmUserContext userContext,String reasonId, String typeId, String comment
) throws Exception
	{
		
		TerminationManagerException exception = new TerminationManagerException("Error Occured");

		

		checkCommentOfTermination(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Termination termination=createNewTermination();	

		TerminationReason reason = loadTerminationReason(reasonId,emptyOptions());
		termination.setReason(reason);
		TerminationType type = loadTerminationType(typeId,emptyOptions());
		termination.setType(type);
		termination.setComment(comment);

		return saveTermination(userContext, termination, emptyOptions());
		

		
	}
	protected Termination createNewTermination() 
	{
		
		return new Termination();		
	}
	
	protected void checkParamsForUpdatingTermination(RetailScmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		TerminationManagerException exception = new TerminationManagerException("Error Occured");
		
		checkIdOfTermination(userContext, terminationId, exception);
		checkVersionOfTermination(userContext, terminationVersion, exception);
		
		

				

		
		if(Termination.COMMENT_PROPERTY.equals(property)){
			checkCommentOfTermination(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public Termination clone(RetailScmUserContext userContext, String fromTerminationId) throws Exception{
		
		return this.getTerminationDAO().clone(fromTerminationId, this.allTokens());
	}
	
	public Termination updateTermination(RetailScmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);
		
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		if(termination.getVersion() != terminationVersion){
			String message = "The target version("+termination.getVersion()+") is not equals to version("+terminationVersion+") provided";
			throw new TerminationManagerException(message);
		}
		synchronized(termination){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.
			
			termination.changePropery(property, newValueExpr);
			termination = saveTermination(userContext, termination, tokens().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
			//return saveTermination(userContext, termination, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TerminationTokens tokens(){
		return TerminationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TerminationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TerminationTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherReason(RetailScmUserContext userContext, String terminationId, String anotherReasonId) throws Exception
 	{
 		TerminationManagerException exception = new TerminationManagerException("Error Occured");
 		checkIdOfTermination(userContext, terminationId,exception);
 		checkIdOfTerminationReason(userContext, anotherReasonId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Termination transferToAnotherReason(RetailScmUserContext userContext, String terminationId, String anotherReasonId) throws Exception
 	{
 		checkParamsForTransferingAnotherReason(userContext, terminationId,anotherReasonId);
 
		Termination termination = loadTermination(userContext, terminationId, allTokens());	
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TerminationReason reason = loadTerminationReason(anotherReasonId, emptyOptions());		
			termination.setReason(reason);		
			termination = saveTermination(userContext, termination, emptyOptions());
			
			return present(userContext,termination, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherType(RetailScmUserContext userContext, String terminationId, String anotherTypeId) throws Exception
 	{
 		TerminationManagerException exception = new TerminationManagerException("Error Occured");
 		checkIdOfTermination(userContext, terminationId,exception);
 		checkIdOfTerminationType(userContext, anotherTypeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Termination transferToAnotherType(RetailScmUserContext userContext, String terminationId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, terminationId,anotherTypeId);
 
		Termination termination = loadTermination(userContext, terminationId, allTokens());	
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TerminationType type = loadTerminationType(anotherTypeId, emptyOptions());		
			termination.setType(type);		
			termination = saveTermination(userContext, termination, emptyOptions());
			
			return present(userContext,termination, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected TerminationType loadTerminationType(String newTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return getTerminationTypeDAO().load(newTypeId, options);
 	}
	
	 	
 	protected TerminationReason loadTerminationReason(String newReasonId, Map<String,Object> options) throws Exception
 	{
		
 		return getTerminationReasonDAO().load(newReasonId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String terminationId, int terminationVersion) throws Exception {
		
		deleteInternal(userContext, terminationId, terminationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String terminationId, int terminationVersion) throws Exception{
		getTerminationDAO().delete(terminationId, terminationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TerminationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getTerminationDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		TerminationManagerException exception = new TerminationManagerException("Error Occured");
		
		checkIdOfTermination(userContext, terminationId, exception);
		
		
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
	public  Termination addEmployee(RetailScmUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,terminationId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){ 
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			termination.addEmployee( employee );		
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String terminationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		TerminationManagerException exception = new TerminationManagerException("Error Occured");
		
		checkIdOfTermination(userContext, terminationId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Termination removeEmployee(RetailScmUserContext userContext, String terminationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,terminationId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){ 
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			termination.removeEmployee( employee );		
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String terminationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		TerminationManagerException exception = new TerminationManagerException("Error Occured");
		
		checkIdOfTermination(userContext, terminationId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Termination copyEmployeeFrom(RetailScmUserContext userContext, String terminationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,terminationId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){ 
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			termination.copyEmployeeFrom( employee );		
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String terminationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TerminationManagerException exception = new TerminationManagerException("Error Occured");
		
		checkIdOfTermination(userContext, terminationId, exception);
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
	
	public  Termination updateEmployee(RetailScmUserContext userContext, String terminationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, terminationId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		
		synchronized(termination){ 
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//termination.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = termination.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new TerminationManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


