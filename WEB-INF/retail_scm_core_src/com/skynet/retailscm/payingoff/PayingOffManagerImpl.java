
package com.skynet.retailscm.payingoff;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.salarygrade.SalaryGrade;


import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheetTable;




public class PayingOffManagerImpl extends RetailScmCheckerManager implements PayingOffManager {
	
	private static final String SERVICE_TYPE = "PayingOff";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  PayingOffDAO  payingOffDAO;
 	public void setPayingOffDAO(PayingOffDAO  payingOffDAO){
 	
 		if(payingOffDAO == null){
 			throw new IllegalStateException("Do not try to set payingOffDAO to null.");
 		}
	 	this.payingOffDAO = payingOffDAO;
 	}
 	public PayingOffDAO getPayingOffDAO(){
 		if(this.payingOffDAO == null){
 			throw new IllegalStateException("The PayingOffDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.payingOffDAO;
 	}
 	
 	protected PayingOff savePayingOff(RetailScmUserContext userContext, PayingOff payingOff, String [] tokensExpr) throws Exception{	
 		//return getPayingOffDAO().save(payingOff, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePayingOff(userContext, payingOff, tokens);
 	}
 	
 	protected PayingOff savePayingOffDetail(RetailScmUserContext userContext, PayingOff payingOff) throws Exception{	

 		
 		return savePayingOff(userContext, payingOff, allTokens());
 	}
 	
 	public PayingOff loadPayingOff(RetailScmUserContext userContext, String payingOffId, String [] tokensExpr) throws Exception{				
 
 		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");
		
		checkIdOfPayingOff(userContext, payingOffId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,payingOff, tokens);
 	}
 	
 	protected PayingOff present(RetailScmUserContext userContext, PayingOff payingOff, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,payingOff,tokens);
		
		
		return this.getPayingOffDAO().present(payingOff, tokens);
	}
 
 	
 	
 	public PayingOff loadPayingOffDetail(RetailScmUserContext userContext, String payingOffId) throws Exception{	
 		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");
		
		checkIdOfPayingOff(userContext, payingOffId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, allTokens());

 		return present(userContext,payingOff, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String payingOffId) throws Exception{	
 		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");
		
		checkIdOfPayingOff(userContext, payingOffId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PayingOff payingOff = loadPayingOff( userContext, payingOffId, allTokens());

 		return present(userContext,payingOff, allTokens());
		
 	}
 	protected PayingOff savePayingOff(RetailScmUserContext userContext, PayingOff payingOff, Map<String,Object>tokens) throws Exception{	
 		return getPayingOffDAO().save(payingOff, tokens);
 	}
 	protected PayingOff loadPayingOff(RetailScmUserContext userContext, String payingOffId, Map<String,Object>tokens) throws Exception{	
 		return getPayingOffDAO().load(payingOffId, tokens);
 	}

	



 	 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PayingOff payingOff, Map<String, Object> tokens){
		super.addActions(userContext, payingOff, tokens);
		
		addAction(userContext, payingOff, tokens,"@create","createPayingOff","createPayingOff/","main","primary");
		addAction(userContext, payingOff, tokens,"@update","updatePayingOff","updatePayingOff/"+payingOff.getId()+"/","main","primary");
		addAction(userContext, payingOff, tokens,"@copy","clonePayingOff","clonePayingOff/"+payingOff.getId()+"/","main","primary");
		
		addAction(userContext, payingOff, tokens,"paying_off.transfer_to_paid_for","transferToAnotherPaidFor","transferToAnotherPaidFor/"+payingOff.getId()+"/","main","primary");
		addAction(userContext, payingOff, tokens,"paying_off.addEmployeeSalarySheet","addEmployeeSalarySheet","addEmployeeSalarySheet/"+payingOff.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, payingOff, tokens,"paying_off.removeEmployeeSalarySheet","removeEmployeeSalarySheet","removeEmployeeSalarySheet/"+payingOff.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, payingOff, tokens,"paying_off.updateEmployeeSalarySheet","updateEmployeeSalarySheet","updateEmployeeSalarySheet/"+payingOff.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, payingOff, tokens,"paying_off.copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom/"+payingOff.getId()+"/","employeeSalarySheetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PayingOff payingOff, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PayingOff createPayingOff(RetailScmUserContext userContext,String who, String paidForId, Date paidTime, double amount
) throws Exception
	{
		
		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");

		

		checkWhoOfPayingOff(userContext,  who, exception);
		checkPaidTimeOfPayingOff(userContext,  paidTime, exception);
		checkAmountOfPayingOff(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		PayingOff payingOff=createNewPayingOff();	

		payingOff.setWho(who);
		Employee paidFor = loadEmployee(paidForId,emptyOptions());
		payingOff.setPaidFor(paidFor);
		payingOff.setPaidTime(paidTime);
		payingOff.setAmount(amount);

		return savePayingOff(userContext, payingOff, emptyOptions());
		

		
	}
	protected PayingOff createNewPayingOff() 
	{
		
		return new PayingOff();		
	}
	
	protected void checkParamsForUpdatingPayingOff(RetailScmUserContext userContext,String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");
		
		checkIdOfPayingOff(userContext, payingOffId, exception);
		checkVersionOfPayingOff(userContext, payingOffVersion, exception);
		

		if(PayingOff.WHO_PROPERTY.equals(property)){
			checkWhoOfPayingOff(userContext, parseString(newValueExpr), exception);
		}		

		
		if(PayingOff.PAID_TIME_PROPERTY.equals(property)){
			checkPaidTimeOfPayingOff(userContext, parseDate(newValueExpr), exception);
		}
		if(PayingOff.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfPayingOff(userContext, parseDouble(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public PayingOff clone(RetailScmUserContext userContext, String fromPayingOffId) throws Exception{
		
		return this.getPayingOffDAO().clone(fromPayingOffId, this.allTokens());
	}
	
	public PayingOff updatePayingOff(RetailScmUserContext userContext,String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPayingOff(userContext, payingOffId, payingOffVersion, property, newValueExpr, tokensExpr);
		
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		if(payingOff.getVersion() != payingOffVersion){
			String message = "The target version("+payingOff.getVersion()+") is not equals to version("+payingOffVersion+") provided";
			throw new PayingOffManagerException(message);
		}
		synchronized(payingOff){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PayingOff.
			
			payingOff.changePropery(property, newValueExpr);
			payingOff = savePayingOff(userContext, payingOff, tokens().done());
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
			//return savePayingOff(userContext, payingOff, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PayingOffTokens tokens(){
		return PayingOffTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PayingOffTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PayingOffTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherPaidFor(RetailScmUserContext userContext, String payingOffId, String anotherPaidForId) throws Exception
 	{
 		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");
 		checkIdOfPayingOff(userContext, payingOffId,exception);
 		checkIdOfEmployee(userContext, anotherPaidForId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public PayingOff transferToAnotherPaidFor(RetailScmUserContext userContext, String payingOffId, String anotherPaidForId) throws Exception
 	{
 		checkParamsForTransferingAnotherPaidFor(userContext, payingOffId,anotherPaidForId);
 
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());	
		synchronized(payingOff){
			//will be good when the payingOff loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee paidFor = loadEmployee(anotherPaidForId, emptyOptions());		
			payingOff.setPaidFor(paidFor);		
			payingOff = savePayingOff(userContext, payingOff, emptyOptions());
			
			return present(userContext,payingOff, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Employee loadEmployee(String newPaidForId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newPaidForId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String payingOffId, int payingOffVersion) throws Exception {
		
		deleteInternal(userContext, payingOffId, payingOffVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String payingOffId, int payingOffVersion) throws Exception{
		getPayingOffDAO().delete(payingOffId, payingOffVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PayingOffManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getPayingOffDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance,String [] tokensExpr) throws Exception{
		
		

		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");
		
		checkIdOfPayingOff(userContext, payingOffId, exception);
		
		
		checkIdOfEmployee(userContext,  employeeId, exception);		
		
		checkIdOfSalaryGrade(userContext,  currentSalaryGradeId, exception);
		checkBaseSalaryOfEmployeeSalarySheet(userContext,  baseSalary, exception);
		checkBonusOfEmployeeSalarySheet(userContext,  bonus, exception);
		checkRewardOfEmployeeSalarySheet(userContext,  reward, exception);
		checkPersonalTaxOfEmployeeSalarySheet(userContext,  personalTax, exception);
		checkSocialSecurityOfEmployeeSalarySheet(userContext,  socialSecurity, exception);
		checkHousingFoundOfEmployeeSalarySheet(userContext,  housingFound, exception);
		checkJobInsuranceOfEmployeeSalarySheet(userContext,  jobInsurance, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  PayingOff addEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSalarySheet(userContext,payingOffId,employeeId, currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createEmployeeSalarySheet(userContext,employeeId, currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance);
		
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		synchronized(payingOff){ 
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			payingOff.addEmployeeSalarySheet( employeeSalarySheet );		
			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeSalarySheet createEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance) throws Exception{

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeSalarySheet.setEmployee(employee);		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employeeSalarySheet.setCurrentSalaryGrade(currentSalaryGrade);		
		employeeSalarySheet.setBaseSalary(baseSalary);		
		employeeSalarySheet.setBonus(bonus);		
		employeeSalarySheet.setReward(reward);		
		employeeSalarySheet.setPersonalTax(personalTax);		
		employeeSalarySheet.setSocialSecurity(socialSecurity);		
		employeeSalarySheet.setHousingFound(housingFound);		
		employeeSalarySheet.setJobInsurance(jobInsurance);
	
		
		return employeeSalarySheet;
	
		
	}
	
	protected EmployeeSalarySheet createIndexedEmployeeSalarySheet(String id, int version){

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		employeeSalarySheet.setId(id);
		employeeSalarySheet.setVersion(version);
		return employeeSalarySheet;			
		
	}
	protected void checkParamsForRemovingEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		

		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");
		
		checkIdOfPayingOff(userContext, payingOffId, exception);
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		checkVersionOfEmployeeSalarySheet(userContext, employeeSalarySheetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PayingOff removeEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSalarySheet(userContext,payingOffId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		synchronized(payingOff){ 
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			payingOff.removeEmployeeSalarySheet( employeeSalarySheet );		
			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		

		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");
		
		checkIdOfPayingOff(userContext, payingOffId, exception);
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		checkVersionOfEmployeeSalarySheet(userContext, employeeSalarySheetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  PayingOff copyEmployeeSalarySheetFrom(RetailScmUserContext userContext, String payingOffId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSalarySheet(userContext,payingOffId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		synchronized(payingOff){ 
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			payingOff.copyEmployeeSalarySheetFrom( employeeSalarySheet );		
			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		PayingOffManagerException exception = new PayingOffManagerException("Error Occured");
		
		checkIdOfPayingOff(userContext, payingOffId, exception);
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
	
	public  PayingOff updateEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSalarySheet(userContext, payingOffId, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr,  tokensExpr);
		
		
		PayingOff payingOff = loadPayingOff(userContext, payingOffId, allTokens());
		
		synchronized(payingOff){ 
			//Will be good when the payingOff loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//payingOff.removeEmployeeSalarySheet( employeeSalarySheet );	
			//make changes to AcceleraterAccount.
			EmployeeSalarySheet employeeSalarySheetIndex = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		
			EmployeeSalarySheet employeeSalarySheet = payingOff.findTheEmployeeSalarySheet(employeeSalarySheetIndex);
			if(employeeSalarySheet == null){
				throw new PayingOffManagerException(employeeSalarySheet+"Not found" );
			}
			
			employeeSalarySheet.changePropery(property, newValueExpr);

			payingOff = savePayingOff(userContext, payingOff, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,payingOff, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}








