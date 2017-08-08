
package com.skynet.retailscm.employeesalarysheet;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.salarygrade.SalaryGrade;

import com.skynet.retailscm.employee.EmployeeDAO;
import com.skynet.retailscm.salarygrade.SalaryGradeDAO;
import com.skynet.retailscm.payingoff.PayingOffDAO;


import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.salarygrade.SalaryGradeTable;
import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.payingoff.PayingOffTable;




public class EmployeeSalarySheetManagerImpl extends RetailScmCheckerManager implements EmployeeSalarySheetManager {
	
	private static final String SERVICE_TYPE = "EmployeeSalarySheet";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeSalarySheetDAO  employeeSalarySheetDAO;
 	public void setEmployeeSalarySheetDAO(EmployeeSalarySheetDAO  employeeSalarySheetDAO){
 	
 		if(employeeSalarySheetDAO == null){
 			throw new IllegalStateException("Do not try to set employeeSalarySheetDAO to null.");
 		}
	 	this.employeeSalarySheetDAO = employeeSalarySheetDAO;
 	}
 	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO(){
 		if(this.employeeSalarySheetDAO == null){
 			throw new IllegalStateException("The EmployeeSalarySheetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeSalarySheetDAO;
 	}
 	
 	protected EmployeeSalarySheet saveEmployeeSalarySheet(RetailScmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, String [] tokensExpr) throws Exception{	
 		//return getEmployeeSalarySheetDAO().save(employeeSalarySheet, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens);
 	}
 	
 	protected EmployeeSalarySheet saveEmployeeSalarySheetDetail(RetailScmUserContext userContext, EmployeeSalarySheet employeeSalarySheet) throws Exception{	

 		
 		return saveEmployeeSalarySheet(userContext, employeeSalarySheet, allTokens());
 	}
 	
 	public EmployeeSalarySheet loadEmployeeSalarySheet(RetailScmUserContext userContext, String employeeSalarySheetId, String [] tokensExpr) throws Exception{				
 
 		EmployeeSalarySheetManagerException exception = new EmployeeSalarySheetManagerException("Error Occured");
		
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSalarySheet, tokens);
 	}
 	
 	protected EmployeeSalarySheet present(RetailScmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeSalarySheet,tokens);
		
		
		return this.getEmployeeSalarySheetDAO().present(employeeSalarySheet, tokens);
	}
 
 	
 	
 	public EmployeeSalarySheet loadEmployeeSalarySheetDetail(RetailScmUserContext userContext, String employeeSalarySheetId) throws Exception{	
 		EmployeeSalarySheetManagerException exception = new EmployeeSalarySheetManagerException("Error Occured");
		
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, allTokens());

 		return present(userContext,employeeSalarySheet, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeSalarySheetId) throws Exception{	
 		EmployeeSalarySheetManagerException exception = new EmployeeSalarySheetManagerException("Error Occured");
		
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet( userContext, employeeSalarySheetId, allTokens());

 		return present(userContext,employeeSalarySheet, allTokens());
		
 	}
 	protected EmployeeSalarySheet saveEmployeeSalarySheet(RetailScmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeSalarySheetDAO().save(employeeSalarySheet, tokens);
 	}
 	protected EmployeeSalarySheet loadEmployeeSalarySheet(RetailScmUserContext userContext, String employeeSalarySheetId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeSalarySheetDAO().load(employeeSalarySheetId, tokens);
 	}

	



 	 
 	
 	private  SalaryGradeDAO  salaryGradeDAO;
 	public void setSalaryGradeDAO(SalaryGradeDAO salaryGradeDAO){
	 	this.salaryGradeDAO = salaryGradeDAO;
 	}
 	//------------------------------------
 	public SalaryGradeDAO getSalaryGradeDAO(){
	 	return this.salaryGradeDAO;
 	}
 
 	
 	private  PayingOffDAO  payingOffDAO;
 	public void setPayingOffDAO(PayingOffDAO payingOffDAO){
	 	this.payingOffDAO = payingOffDAO;
 	}
 	//------------------------------------
 	public PayingOffDAO getPayingOffDAO(){
	 	return this.payingOffDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String, Object> tokens){
		super.addActions(userContext, employeeSalarySheet, tokens);
		
		addAction(userContext, employeeSalarySheet, tokens,"@create","createEmployeeSalarySheet","createEmployeeSalarySheet/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"@update","updateEmployeeSalarySheet","updateEmployeeSalarySheet/"+employeeSalarySheet.getId()+"/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"@copy","cloneEmployeeSalarySheet","cloneEmployeeSalarySheet/"+employeeSalarySheet.getId()+"/","main","primary");
		
		addAction(userContext, employeeSalarySheet, tokens,"employee_salary_sheet.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeSalarySheet.getId()+"/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"employee_salary_sheet.transfer_to_current_salary_grade","transferToAnotherCurrentSalaryGrade","transferToAnotherCurrentSalaryGrade/"+employeeSalarySheet.getId()+"/","main","primary");
		addAction(userContext, employeeSalarySheet, tokens,"employee_salary_sheet.payOff","payOff","payOff/"+employeeSalarySheet.getId()+"/","main","success");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeSalarySheet employeeSalarySheet, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeSalarySheet createEmployeeSalarySheet(RetailScmUserContext userContext,String employeeId, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance
) throws Exception
	{
		
		EmployeeSalarySheetManagerException exception = new EmployeeSalarySheetManagerException("Error Occured");

		

		checkBaseSalaryOfEmployeeSalarySheet(userContext,  baseSalary, exception);
		checkBonusOfEmployeeSalarySheet(userContext,  bonus, exception);
		checkRewardOfEmployeeSalarySheet(userContext,  reward, exception);
		checkPersonalTaxOfEmployeeSalarySheet(userContext,  personalTax, exception);
		checkSocialSecurityOfEmployeeSalarySheet(userContext,  socialSecurity, exception);
		checkHousingFoundOfEmployeeSalarySheet(userContext,  housingFound, exception);
		checkJobInsuranceOfEmployeeSalarySheet(userContext,  jobInsurance, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeSalarySheet employeeSalarySheet=createNewEmployeeSalarySheet();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeeSalarySheet.setEmployee(employee);
		SalaryGrade currentSalaryGrade = loadSalaryGrade(currentSalaryGradeId,emptyOptions());
		employeeSalarySheet.setCurrentSalaryGrade(currentSalaryGrade);
		employeeSalarySheet.setBaseSalary(baseSalary);
		employeeSalarySheet.setBonus(bonus);
		employeeSalarySheet.setReward(reward);
		employeeSalarySheet.setPersonalTax(personalTax);
		employeeSalarySheet.setSocialSecurity(socialSecurity);
		employeeSalarySheet.setHousingFound(housingFound);
		employeeSalarySheet.setJobInsurance(jobInsurance);

		return saveEmployeeSalarySheet(userContext, employeeSalarySheet, emptyOptions());
		

		
	}
	protected EmployeeSalarySheet createNewEmployeeSalarySheet() 
	{
		
		return new EmployeeSalarySheet();		
	}
	
	protected void checkParamsForUpdatingEmployeeSalarySheet(RetailScmUserContext userContext,String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeSalarySheetManagerException exception = new EmployeeSalarySheetManagerException("Error Occured");
		
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
	
	
	
	public EmployeeSalarySheet clone(RetailScmUserContext userContext, String fromEmployeeSalarySheetId) throws Exception{
		
		return this.getEmployeeSalarySheetDAO().clone(fromEmployeeSalarySheetId, this.allTokens());
	}
	
	public EmployeeSalarySheet updateEmployeeSalarySheet(RetailScmUserContext userContext,String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeSalarySheet(userContext, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr, tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());
		if(employeeSalarySheet.getVersion() != employeeSalarySheetVersion){
			String message = "The target version("+employeeSalarySheet.getVersion()+") is not equals to version("+employeeSalarySheetVersion+") provided";
			throw new EmployeeSalarySheetManagerException(message);
		}
		synchronized(employeeSalarySheet){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSalarySheet.
			
			employeeSalarySheet.changePropery(property, newValueExpr);
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens().done());
			return present(userContext,employeeSalarySheet, mergedAllTokens(tokensExpr));
			//return saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeSalarySheetTokens tokens(){
		return EmployeeSalarySheetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeSalarySheetTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeSalarySheetTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={"PAID_OFF"};
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeeSalarySheetId, String anotherEmployeeId) throws Exception
 	{
 		EmployeeSalarySheetManagerException exception = new EmployeeSalarySheetManagerException("Error Occured");
 		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeSalarySheet transferToAnotherEmployee(RetailScmUserContext userContext, String employeeSalarySheetId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeSalarySheetId,anotherEmployeeId);
 
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());	
		synchronized(employeeSalarySheet){
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeeSalarySheet.setEmployee(employee);		
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, emptyOptions());
			
			return present(userContext,employeeSalarySheet, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherCurrentSalaryGrade(RetailScmUserContext userContext, String employeeSalarySheetId, String anotherCurrentSalaryGradeId) throws Exception
 	{
 		EmployeeSalarySheetManagerException exception = new EmployeeSalarySheetManagerException("Error Occured");
 		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId,exception);
 		checkIdOfSalaryGrade(userContext, anotherCurrentSalaryGradeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeSalarySheet transferToAnotherCurrentSalaryGrade(RetailScmUserContext userContext, String employeeSalarySheetId, String anotherCurrentSalaryGradeId) throws Exception
 	{
 		checkParamsForTransferingAnotherCurrentSalaryGrade(userContext, employeeSalarySheetId,anotherCurrentSalaryGradeId);
 
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());	
		synchronized(employeeSalarySheet){
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SalaryGrade currentSalaryGrade = loadSalaryGrade(anotherCurrentSalaryGradeId, emptyOptions());		
			employeeSalarySheet.setCurrentSalaryGrade(currentSalaryGrade);		
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, emptyOptions());
			
			return present(userContext,employeeSalarySheet, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForPayingOff(RetailScmUserContext userContext, String employeeSalarySheetId, String who, String paidForId, Date paidTime, double amount
) throws Exception
 	{
 		

		EmployeeSalarySheetManagerException exception = new EmployeeSalarySheetManagerException("Error Occured");
		
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		checkWhoOfPayingOff(userContext,who,exception);
		checkIdOfEmployee(userContext,paidForId,exception);
		checkPaidTimeOfPayingOff(userContext,paidTime,exception);
		checkAmountOfPayingOff(userContext,amount,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public EmployeeSalarySheet payOff(RetailScmUserContext userContext, String employeeSalarySheetId, String who, String paidForId, Date paidTime, double amount
) throws Exception
 	{
		checkParamsForPayingOff(userContext, employeeSalarySheetId, who, paidForId, paidTime, amount);
		EmployeeSalarySheet employeeSalarySheet = loadEmployeeSalarySheet(userContext, employeeSalarySheetId, allTokens());	
		synchronized(employeeSalarySheet){
			//will be good when the employeeSalarySheet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForPayingOff(userContext,employeeSalarySheet);
 		

			employeeSalarySheet.setCurrentStatus("PAID_OFF");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively
			Employee paidFor = loadEmployee(paidForId, emptyOptions());


			PayingOff payingOff = createPayingOff(who, paidFor, paidTime, amount);		
			employeeSalarySheet.setPayingOff(payingOff);		
			employeeSalarySheet = saveEmployeeSalarySheet(userContext, employeeSalarySheet, tokens().withPayingOff().done());
			
			return present(userContext,employeeSalarySheet, allTokens());
			
		}

 	}
 	protected PayingOff createPayingOff(String who, Employee paidFor, Date paidTime, double amount){
 		PayingOff payingOff = new PayingOff(who, paidFor, paidTime, amount);
 		return getPayingOffDAO().save(payingOff,emptyOptions());
 	}
 	protected void checkIfEligibleForPayingOff(RetailScmUserContext userContext, EmployeeSalarySheet employeeSalarySheet) throws Exception{
 		
 		
 		String currentStatus = employeeSalarySheet.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'PAID_OFF'";
 			throw new EmployeeSalarySheetManagerException(message);
 		}
 		
 		if(!("PAID_OFF".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'PAID_OFF'";
 			throw new EmployeeSalarySheetManagerException(message);
 		}
 		
 		
 		PayingOff payingOff = employeeSalarySheet.getPayingOff();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = payingOff 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( payingOff != null){
				throw new EmployeeSalarySheetManagerException("The EmployeeSalarySheet("+employeeSalarySheet.getId()+") has already been PAID_OFF");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected SalaryGrade loadSalaryGrade(String newCurrentSalaryGradeId, Map<String,Object> options) throws Exception
 	{
		
 		return getSalaryGradeDAO().load(newCurrentSalaryGradeId, options);
 	}
	
	 	
 	protected PayingOff loadPayingOff(String newPayingOffId, Map<String,Object> options) throws Exception
 	{
		
 		return getPayingOffDAO().load(newPayingOffId, options);
 	}
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception {
		
		deleteInternal(userContext, employeeSalarySheetId, employeeSalarySheetVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeSalarySheetId, int employeeSalarySheetVersion) throws Exception{
		getEmployeeSalarySheetDAO().delete(employeeSalarySheetId, employeeSalarySheetVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeSalarySheetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeSalarySheetDAO().deleteAll();
	}


}


