
package com.skynet.retailscm.occupationtype;

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




public class OccupationTypeManagerImpl extends RetailScmCheckerManager implements OccupationTypeManager {
	
	private static final String SERVICE_TYPE = "OccupationType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  OccupationTypeDAO  occupationTypeDAO;
 	public void setOccupationTypeDAO(OccupationTypeDAO  occupationTypeDAO){
 	
 		if(occupationTypeDAO == null){
 			throw new IllegalStateException("Do not try to set occupationTypeDAO to null.");
 		}
	 	this.occupationTypeDAO = occupationTypeDAO;
 	}
 	public OccupationTypeDAO getOccupationTypeDAO(){
 		if(this.occupationTypeDAO == null){
 			throw new IllegalStateException("The OccupationTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.occupationTypeDAO;
 	}
 	
 	protected OccupationType saveOccupationType(RetailScmUserContext userContext, OccupationType occupationType, String [] tokensExpr) throws Exception{	
 		//return getOccupationTypeDAO().save(occupationType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOccupationType(userContext, occupationType, tokens);
 	}
 	
 	protected OccupationType saveOccupationTypeDetail(RetailScmUserContext userContext, OccupationType occupationType) throws Exception{	

 		
 		return saveOccupationType(userContext, occupationType, allTokens());
 	}
 	
 	public OccupationType loadOccupationType(RetailScmUserContext userContext, String occupationTypeId, String [] tokensExpr) throws Exception{				
 
 		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");
		
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,occupationType, tokens);
 	}
 	
 	protected OccupationType present(RetailScmUserContext userContext, OccupationType occupationType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,occupationType,tokens);
		
		
		return this.getOccupationTypeDAO().present(occupationType, tokens);
	}
 
 	
 	
 	public OccupationType loadOccupationTypeDetail(RetailScmUserContext userContext, String occupationTypeId) throws Exception{	
 		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");
		
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, allTokens());

 		return present(userContext,occupationType, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String occupationTypeId) throws Exception{	
 		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");
		
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, allTokens());

 		return present(userContext,occupationType, allTokens());
		
 	}
 	protected OccupationType saveOccupationType(RetailScmUserContext userContext, OccupationType occupationType, Map<String,Object>tokens) throws Exception{	
 		return getOccupationTypeDAO().save(occupationType, tokens);
 	}
 	protected OccupationType loadOccupationType(RetailScmUserContext userContext, String occupationTypeId, Map<String,Object>tokens) throws Exception{	
 		return getOccupationTypeDAO().load(occupationTypeId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OccupationType occupationType, Map<String, Object> tokens){
		super.addActions(userContext, occupationType, tokens);
		
		addAction(userContext, occupationType, tokens,"@create","createOccupationType","createOccupationType/","main","primary");
		addAction(userContext, occupationType, tokens,"@update","updateOccupationType","updateOccupationType/"+occupationType.getId()+"/","main","primary");
		addAction(userContext, occupationType, tokens,"@copy","cloneOccupationType","cloneOccupationType/"+occupationType.getId()+"/","main","primary");
		
		addAction(userContext, occupationType, tokens,"occupation_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+occupationType.getId()+"/","main","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.addEmployee","addEmployee","addEmployee/"+occupationType.getId()+"/","employeeList","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.removeEmployee","removeEmployee","removeEmployee/"+occupationType.getId()+"/","employeeList","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.updateEmployee","updateEmployee","updateEmployee/"+occupationType.getId()+"/","employeeList","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+occupationType.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OccupationType occupationType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OccupationType createOccupationType(RetailScmUserContext userContext,String code, String companyId, String description, String detailDescription
) throws Exception
	{
		
		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");

		

		checkCodeOfOccupationType(userContext,  code, exception);
		checkDescriptionOfOccupationType(userContext,  description, exception);
		checkDetailDescriptionOfOccupationType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		OccupationType occupationType=createNewOccupationType();	

		occupationType.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		occupationType.setCompany(company);
		occupationType.setDescription(description);
		occupationType.setDetailDescription(detailDescription);

		return saveOccupationType(userContext, occupationType, emptyOptions());
		

		
	}
	protected OccupationType createNewOccupationType() 
	{
		
		return new OccupationType();		
	}
	
	protected void checkParamsForUpdatingOccupationType(RetailScmUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");
		
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		checkVersionOfOccupationType(userContext, occupationTypeVersion, exception);
		

		if(OccupationType.CODE_PROPERTY.equals(property)){
			checkCodeOfOccupationType(userContext, parseString(newValueExpr), exception);
		}		

		
		if(OccupationType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfOccupationType(userContext, parseString(newValueExpr), exception);
		}
		if(OccupationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfOccupationType(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public OccupationType clone(RetailScmUserContext userContext, String fromOccupationTypeId) throws Exception{
		
		return this.getOccupationTypeDAO().clone(fromOccupationTypeId, this.allTokens());
	}
	
	public OccupationType updateOccupationType(RetailScmUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOccupationType(userContext, occupationTypeId, occupationTypeVersion, property, newValueExpr, tokensExpr);
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		if(occupationType.getVersion() != occupationTypeVersion){
			String message = "The target version("+occupationType.getVersion()+") is not equals to version("+occupationTypeVersion+") provided";
			throw new OccupationTypeManagerException(message);
		}
		synchronized(occupationType){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OccupationType.
			
			occupationType.changePropery(property, newValueExpr);
			occupationType = saveOccupationType(userContext, occupationType, tokens().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
			//return saveOccupationType(userContext, occupationType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OccupationTypeTokens tokens(){
		return OccupationTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OccupationTypeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OccupationTypeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String occupationTypeId, String anotherCompanyId) throws Exception
 	{
 		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");
 		checkIdOfOccupationType(userContext, occupationTypeId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public OccupationType transferToAnotherCompany(RetailScmUserContext userContext, String occupationTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, occupationTypeId,anotherCompanyId);
 
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());	
		synchronized(occupationType){
			//will be good when the occupationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			occupationType.setCompany(company);		
			occupationType = saveOccupationType(userContext, occupationType, emptyOptions());
			
			return present(userContext,occupationType, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String occupationTypeId, int occupationTypeVersion) throws Exception {
		
		deleteInternal(userContext, occupationTypeId, occupationTypeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String occupationTypeId, int occupationTypeVersion) throws Exception{
		getOccupationTypeDAO().delete(occupationTypeId, occupationTypeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OccupationTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getOccupationTypeDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");
		
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  companyId, exception);
		checkTitleOfEmployee(userContext,  title, exception);		
		
		checkIdOfLevelThreeDepartment(userContext,  departmentId, exception);
		checkFamilyNameOfEmployee(userContext,  familyName, exception);
		checkGivenNameOfEmployee(userContext,  givenName, exception);
		checkEmailOfEmployee(userContext,  email, exception);
		checkCityOfEmployee(userContext,  city, exception);
		checkAddressOfEmployee(userContext,  address, exception);
		checkCellPhoneOfEmployee(userContext,  cellPhone, exception);		
		
		checkIdOfResponsibilityType(userContext,  responsibleForId, exception);		
		
		checkIdOfSalaryGrade(userContext,  currentSalaryGradeId, exception);
		checkSalaryAccountOfEmployee(userContext,  salaryAccount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  OccupationType addEmployee(RetailScmUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,occupationTypeId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		synchronized(occupationType){ 
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			occupationType.addEmployee( employee );		
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}
	}
	protected Employee createEmployee(RetailScmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

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
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String occupationTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");
		
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OccupationType removeEmployee(RetailScmUserContext userContext, String occupationTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,occupationTypeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		synchronized(occupationType){ 
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			occupationType.removeEmployee( employee );		
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String occupationTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");
		
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OccupationType copyEmployeeFrom(RetailScmUserContext userContext, String occupationTypeId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,occupationTypeId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		synchronized(occupationType){ 
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			occupationType.copyEmployeeFrom( employee );		
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		OccupationTypeManagerException exception = new OccupationTypeManagerException("Error Occured");
		
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
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
	
	public  OccupationType updateEmployee(RetailScmUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, occupationTypeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		
		synchronized(occupationType){ 
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//occupationType.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = occupationType.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new OccupationTypeManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


