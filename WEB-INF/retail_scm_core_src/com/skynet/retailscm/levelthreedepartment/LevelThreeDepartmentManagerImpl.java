
package com.skynet.retailscm.levelthreedepartment;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartmentDAO;

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


import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartmentTable;
import com.skynet.retailscm.employee.EmployeeTable;




public class LevelThreeDepartmentManagerImpl extends RetailScmCheckerManager implements LevelThreeDepartmentManager {
	
	private static final String SERVICE_TYPE = "LevelThreeDepartment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  LevelThreeDepartmentDAO  levelThreeDepartmentDAO;
 	public void setLevelThreeDepartmentDAO(LevelThreeDepartmentDAO  levelThreeDepartmentDAO){
 	
 		if(levelThreeDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelThreeDepartmentDAO to null.");
 		}
	 	this.levelThreeDepartmentDAO = levelThreeDepartmentDAO;
 	}
 	public LevelThreeDepartmentDAO getLevelThreeDepartmentDAO(){
 		if(this.levelThreeDepartmentDAO == null){
 			throw new IllegalStateException("The LevelThreeDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelThreeDepartmentDAO;
 	}
 	
 	protected LevelThreeDepartment saveLevelThreeDepartment(RetailScmUserContext userContext, LevelThreeDepartment levelThreeDepartment, String [] tokensExpr) throws Exception{	
 		//return getLevelThreeDepartmentDAO().save(levelThreeDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens);
 	}
 	
 	protected LevelThreeDepartment saveLevelThreeDepartmentDetail(RetailScmUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception{	

 		
 		return saveLevelThreeDepartment(userContext, levelThreeDepartment, allTokens());
 	}
 	
 	public LevelThreeDepartment loadLevelThreeDepartment(RetailScmUserContext userContext, String levelThreeDepartmentId, String [] tokensExpr) throws Exception{				
 
 		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");
		
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeDepartment, tokens);
 	}
 	
 	protected LevelThreeDepartment present(RetailScmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelThreeDepartment,tokens);
		
		
		return this.getLevelThreeDepartmentDAO().present(levelThreeDepartment, tokens);
	}
 
 	
 	
 	public LevelThreeDepartment loadLevelThreeDepartmentDetail(RetailScmUserContext userContext, String levelThreeDepartmentId) throws Exception{	
 		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");
		
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, allTokens());

 		return present(userContext,levelThreeDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String levelThreeDepartmentId) throws Exception{	
 		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");
		
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, allTokens());

 		return present(userContext,levelThreeDepartment, allTokens());
		
 	}
 	protected LevelThreeDepartment saveLevelThreeDepartment(RetailScmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String,Object>tokens) throws Exception{	
 		return getLevelThreeDepartmentDAO().save(levelThreeDepartment, tokens);
 	}
 	protected LevelThreeDepartment loadLevelThreeDepartment(RetailScmUserContext userContext, String levelThreeDepartmentId, Map<String,Object>tokens) throws Exception{	
 		return getLevelThreeDepartmentDAO().load(levelThreeDepartmentId, tokens);
 	}

	



 	 
 	
 	private  LevelTwoDepartmentDAO  levelTwoDepartmentDAO;
 	public void setLevelTwoDepartmentDAO(LevelTwoDepartmentDAO levelTwoDepartmentDAO){
	 	this.levelTwoDepartmentDAO = levelTwoDepartmentDAO;
 	}
 	//------------------------------------
 	public LevelTwoDepartmentDAO getLevelTwoDepartmentDAO(){
	 	return this.levelTwoDepartmentDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens){
		super.addActions(userContext, levelThreeDepartment, tokens);
		
		addAction(userContext, levelThreeDepartment, tokens,"@create","createLevelThreeDepartment","createLevelThreeDepartment/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"@update","updateLevelThreeDepartment","updateLevelThreeDepartment/"+levelThreeDepartment.getId()+"/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"@copy","cloneLevelThreeDepartment","cloneLevelThreeDepartment/"+levelThreeDepartment.getId()+"/","main","primary");
		
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+levelThreeDepartment.getId()+"/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.addEmployee","addEmployee","addEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.removeEmployee","removeEmployee","removeEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.updateEmployee","updateEmployee","updateEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+levelThreeDepartment.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelThreeDepartment createLevelThreeDepartment(RetailScmUserContext userContext,String belongsToId, String name, String description, Date founded
) throws Exception
	{
		
		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");

		

		checkNameOfLevelThreeDepartment(userContext,  name, exception);
		checkDescriptionOfLevelThreeDepartment(userContext,  description, exception);
		checkFoundedOfLevelThreeDepartment(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		LevelThreeDepartment levelThreeDepartment=createNewLevelThreeDepartment();	

		LevelTwoDepartment belongsTo = loadLevelTwoDepartment(belongsToId,emptyOptions());
		levelThreeDepartment.setBelongsTo(belongsTo);
		levelThreeDepartment.setName(name);
		levelThreeDepartment.setDescription(description);
		levelThreeDepartment.setFounded(founded);

		return saveLevelThreeDepartment(userContext, levelThreeDepartment, emptyOptions());
		

		
	}
	protected LevelThreeDepartment createNewLevelThreeDepartment() 
	{
		
		return new LevelThreeDepartment();		
	}
	
	protected void checkParamsForUpdatingLevelThreeDepartment(RetailScmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");
		
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		checkVersionOfLevelThreeDepartment(userContext, levelThreeDepartmentVersion, exception);
		
		

		
		if(LevelThreeDepartment.NAME_PROPERTY.equals(property)){
			checkNameOfLevelThreeDepartment(userContext, parseString(newValueExpr), exception);
		}
		if(LevelThreeDepartment.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfLevelThreeDepartment(userContext, parseString(newValueExpr), exception);
		}
		if(LevelThreeDepartment.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfLevelThreeDepartment(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public LevelThreeDepartment clone(RetailScmUserContext userContext, String fromLevelThreeDepartmentId) throws Exception{
		
		return this.getLevelThreeDepartmentDAO().clone(fromLevelThreeDepartmentId, this.allTokens());
	}
	
	public LevelThreeDepartment updateLevelThreeDepartment(RetailScmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		if(levelThreeDepartment.getVersion() != levelThreeDepartmentVersion){
			String message = "The target version("+levelThreeDepartment.getVersion()+") is not equals to version("+levelThreeDepartmentVersion+") provided";
			throw new LevelThreeDepartmentManagerException(message);
		}
		synchronized(levelThreeDepartment){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.
			
			levelThreeDepartment.changePropery(property, newValueExpr);
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelThreeDepartmentTokens tokens(){
		return LevelThreeDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelThreeDepartmentTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelThreeDepartmentTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailScmUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");
 		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId,exception);
 		checkIdOfLevelTwoDepartment(userContext, anotherBelongsToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public LevelThreeDepartment transferToAnotherBelongsTo(RetailScmUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, levelThreeDepartmentId,anotherBelongsToId);
 
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());	
		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelTwoDepartment belongsTo = loadLevelTwoDepartment(anotherBelongsToId, emptyOptions());		
			levelThreeDepartment.setBelongsTo(belongsTo);		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, emptyOptions());
			
			return present(userContext,levelThreeDepartment, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelTwoDepartment loadLevelTwoDepartment(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return getLevelTwoDepartmentDAO().load(newBelongsToId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception {
		
		deleteInternal(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception{
		getLevelThreeDepartmentDAO().delete(levelThreeDepartmentId, levelThreeDepartmentVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelThreeDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getLevelThreeDepartmentDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");
		
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  companyId, exception);
		checkTitleOfEmployee(userContext,  title, exception);
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
	public  LevelThreeDepartment addEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,levelThreeDepartmentId,companyId, title, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){ 
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeDepartment.addEmployee( employee );		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected Employee createEmployee(RetailScmUserContext userContext, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

		Employee employee = new Employee();
		
		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		employee.setCompany(company);		
		employee.setTitle(title);		
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
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");
		
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelThreeDepartment removeEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,levelThreeDepartmentId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){ 
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeDepartment.removeEmployee( employee );		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");
		
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LevelThreeDepartment copyEmployeeFrom(RetailScmUserContext userContext, String levelThreeDepartmentId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,levelThreeDepartmentId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){ 
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeDepartment.copyEmployeeFrom( employee );		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		LevelThreeDepartmentManagerException exception = new LevelThreeDepartmentManagerException("Error Occured");
		
		checkIdOfLevelThreeDepartment(userContext, levelThreeDepartmentId, exception);
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
	
	public  LevelThreeDepartment updateEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, levelThreeDepartmentId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		
		synchronized(levelThreeDepartment){ 
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelThreeDepartment.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = levelThreeDepartment.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new LevelThreeDepartmentManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


