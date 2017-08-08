
package com.skynet.retailscm.companytraining;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;

import com.skynet.retailscm.instructor.InstructorDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseTypeDAO;

import com.skynet.retailscm.scoring.Scoring;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.employee.Employee;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.instructor.InstructorTable;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTrainingTable;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseTypeTable;




public class CompanyTrainingManagerImpl extends RetailScmCheckerManager implements CompanyTrainingManager {
	
	private static final String SERVICE_TYPE = "CompanyTraining";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  CompanyTrainingDAO  companyTrainingDAO;
 	public void setCompanyTrainingDAO(CompanyTrainingDAO  companyTrainingDAO){
 	
 		if(companyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set companyTrainingDAO to null.");
 		}
	 	this.companyTrainingDAO = companyTrainingDAO;
 	}
 	public CompanyTrainingDAO getCompanyTrainingDAO(){
 		if(this.companyTrainingDAO == null){
 			throw new IllegalStateException("The CompanyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.companyTrainingDAO;
 	}
 	
 	protected CompanyTraining saveCompanyTraining(RetailScmUserContext userContext, CompanyTraining companyTraining, String [] tokensExpr) throws Exception{	
 		//return getCompanyTrainingDAO().save(companyTraining, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCompanyTraining(userContext, companyTraining, tokens);
 	}
 	
 	protected CompanyTraining saveCompanyTrainingDetail(RetailScmUserContext userContext, CompanyTraining companyTraining) throws Exception{	

 		
 		return saveCompanyTraining(userContext, companyTraining, allTokens());
 	}
 	
 	public CompanyTraining loadCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, String [] tokensExpr) throws Exception{				
 
 		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
		
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,companyTraining, tokens);
 	}
 	
 	protected CompanyTraining present(RetailScmUserContext userContext, CompanyTraining companyTraining, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,companyTraining,tokens);
		
		
		return this.getCompanyTrainingDAO().present(companyTraining, tokens);
	}
 
 	
 	
 	public CompanyTraining loadCompanyTrainingDetail(RetailScmUserContext userContext, String companyTrainingId) throws Exception{	
 		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
		
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, allTokens());

 		return present(userContext,companyTraining, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String companyTrainingId) throws Exception{	
 		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
		
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, allTokens());

 		return present(userContext,companyTraining, allTokens());
		
 	}
 	protected CompanyTraining saveCompanyTraining(RetailScmUserContext userContext, CompanyTraining companyTraining, Map<String,Object>tokens) throws Exception{	
 		return getCompanyTrainingDAO().save(companyTraining, tokens);
 	}
 	protected CompanyTraining loadCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, Map<String,Object>tokens) throws Exception{	
 		return getCompanyTrainingDAO().load(companyTrainingId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  InstructorDAO  instructorDAO;
 	public void setInstructorDAO(InstructorDAO instructorDAO){
	 	this.instructorDAO = instructorDAO;
 	}
 	//------------------------------------
 	public InstructorDAO getInstructorDAO(){
	 	return this.instructorDAO;
 	}
 
 	
 	private  TrainingCourseTypeDAO  trainingCourseTypeDAO;
 	public void setTrainingCourseTypeDAO(TrainingCourseTypeDAO trainingCourseTypeDAO){
	 	this.trainingCourseTypeDAO = trainingCourseTypeDAO;
 	}
 	//------------------------------------
 	public TrainingCourseTypeDAO getTrainingCourseTypeDAO(){
	 	return this.trainingCourseTypeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, CompanyTraining companyTraining, Map<String, Object> tokens){
		super.addActions(userContext, companyTraining, tokens);
		
		addAction(userContext, companyTraining, tokens,"@create","createCompanyTraining","createCompanyTraining/","main","primary");
		addAction(userContext, companyTraining, tokens,"@update","updateCompanyTraining","updateCompanyTraining/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"@copy","cloneCompanyTraining","cloneCompanyTraining/"+companyTraining.getId()+"/","main","primary");
		
		addAction(userContext, companyTraining, tokens,"company_training.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"company_training.transfer_to_instructor","transferToAnotherInstructor","transferToAnotherInstructor/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"company_training.transfer_to_training_course_type","transferToAnotherTrainingCourseType","transferToAnotherTrainingCourseType/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"company_training.addEmployeeCompanyTraining","addEmployeeCompanyTraining","addEmployeeCompanyTraining/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, companyTraining, tokens,"company_training.removeEmployeeCompanyTraining","removeEmployeeCompanyTraining","removeEmployeeCompanyTraining/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, companyTraining, tokens,"company_training.updateEmployeeCompanyTraining","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, companyTraining, tokens,"company_training.copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, CompanyTraining companyTraining, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CompanyTraining createCompanyTraining(RetailScmUserContext userContext,String title, String companyId, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours
) throws Exception
	{
		
		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");

		

		checkTitleOfCompanyTraining(userContext,  title, exception);
		checkTimeStartOfCompanyTraining(userContext,  timeStart, exception);
		checkDurationHoursOfCompanyTraining(userContext,  durationHours, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		CompanyTraining companyTraining=createNewCompanyTraining();	

		companyTraining.setTitle(title);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		companyTraining.setCompany(company);
		Instructor instructor = loadInstructor(instructorId,emptyOptions());
		companyTraining.setInstructor(instructor);
		TrainingCourseType trainingCourseType = loadTrainingCourseType(trainingCourseTypeId,emptyOptions());
		companyTraining.setTrainingCourseType(trainingCourseType);
		companyTraining.setTimeStart(timeStart);
		companyTraining.setDurationHours(durationHours);

		return saveCompanyTraining(userContext, companyTraining, emptyOptions());
		

		
	}
	protected CompanyTraining createNewCompanyTraining() 
	{
		
		return new CompanyTraining();		
	}
	
	protected void checkParamsForUpdatingCompanyTraining(RetailScmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
		
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkVersionOfCompanyTraining(userContext, companyTrainingVersion, exception);
		

		if(CompanyTraining.TITLE_PROPERTY.equals(property)){
			checkTitleOfCompanyTraining(userContext, parseString(newValueExpr), exception);
		}		

				

				

		
		if(CompanyTraining.TIME_START_PROPERTY.equals(property)){
			checkTimeStartOfCompanyTraining(userContext, parseDate(newValueExpr), exception);
		}
		if(CompanyTraining.DURATION_HOURS_PROPERTY.equals(property)){
			checkDurationHoursOfCompanyTraining(userContext, parseInt(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public CompanyTraining clone(RetailScmUserContext userContext, String fromCompanyTrainingId) throws Exception{
		
		return this.getCompanyTrainingDAO().clone(fromCompanyTrainingId, this.allTokens());
	}
	
	public CompanyTraining updateCompanyTraining(RetailScmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCompanyTraining(userContext, companyTrainingId, companyTrainingVersion, property, newValueExpr, tokensExpr);
		
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		if(companyTraining.getVersion() != companyTrainingVersion){
			String message = "The target version("+companyTraining.getVersion()+") is not equals to version("+companyTrainingVersion+") provided";
			throw new CompanyTrainingManagerException(message);
		}
		synchronized(companyTraining){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CompanyTraining.
			
			companyTraining.changePropery(property, newValueExpr);
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
			//return saveCompanyTraining(userContext, companyTraining, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CompanyTrainingTokens tokens(){
		return CompanyTrainingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CompanyTrainingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CompanyTrainingTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String companyTrainingId, String anotherCompanyId) throws Exception
 	{
 		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
 		checkIdOfCompanyTraining(userContext, companyTrainingId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public CompanyTraining transferToAnotherCompany(RetailScmUserContext userContext, String companyTrainingId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, companyTrainingId,anotherCompanyId);
 
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());	
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			companyTraining.setCompany(company);		
			companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
			
			return present(userContext,companyTraining, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherInstructor(RetailScmUserContext userContext, String companyTrainingId, String anotherInstructorId) throws Exception
 	{
 		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
 		checkIdOfCompanyTraining(userContext, companyTrainingId,exception);
 		checkIdOfInstructor(userContext, anotherInstructorId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public CompanyTraining transferToAnotherInstructor(RetailScmUserContext userContext, String companyTrainingId, String anotherInstructorId) throws Exception
 	{
 		checkParamsForTransferingAnotherInstructor(userContext, companyTrainingId,anotherInstructorId);
 
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());	
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Instructor instructor = loadInstructor(anotherInstructorId, emptyOptions());		
			companyTraining.setInstructor(instructor);		
			companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
			
			return present(userContext,companyTraining, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherTrainingCourseType(RetailScmUserContext userContext, String companyTrainingId, String anotherTrainingCourseTypeId) throws Exception
 	{
 		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
 		checkIdOfCompanyTraining(userContext, companyTrainingId,exception);
 		checkIdOfTrainingCourseType(userContext, anotherTrainingCourseTypeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public CompanyTraining transferToAnotherTrainingCourseType(RetailScmUserContext userContext, String companyTrainingId, String anotherTrainingCourseTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherTrainingCourseType(userContext, companyTrainingId,anotherTrainingCourseTypeId);
 
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());	
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TrainingCourseType trainingCourseType = loadTrainingCourseType(anotherTrainingCourseTypeId, emptyOptions());		
			companyTraining.setTrainingCourseType(trainingCourseType);		
			companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
			
			return present(userContext,companyTraining, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	 	
 	protected Instructor loadInstructor(String newInstructorId, Map<String,Object> options) throws Exception
 	{
		
 		return getInstructorDAO().load(newInstructorId, options);
 	}
	
	 	
 	protected TrainingCourseType loadTrainingCourseType(String newTrainingCourseTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return getTrainingCourseTypeDAO().load(newTrainingCourseTypeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String companyTrainingId, int companyTrainingVersion) throws Exception {
		
		deleteInternal(userContext, companyTrainingId, companyTrainingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String companyTrainingId, int companyTrainingVersion) throws Exception{
		getCompanyTrainingDAO().delete(companyTrainingId, companyTrainingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CompanyTrainingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getCompanyTrainingDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, String employeeId,String [] tokensExpr) throws Exception{
		
		

		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
		
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		
		
		checkIdOfEmployee(userContext,  employeeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  CompanyTraining addEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, String employeeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeCompanyTraining(userContext,companyTrainingId,employeeId,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,employeeId);
		
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		synchronized(companyTraining){ 
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			companyTraining.addEmployeeCompanyTraining( employeeCompanyTraining );		
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeCompanyTraining createEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeCompanyTraining.setEmployee(employee);
	
		
		return employeeCompanyTraining;
	
		
	}
	
	protected EmployeeCompanyTraining createIndexedEmployeeCompanyTraining(String id, int version){

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTraining.setId(id);
		employeeCompanyTraining.setVersion(version);
		return employeeCompanyTraining;			
		
	}
	protected void checkParamsForRemovingEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		

		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
		
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  CompanyTraining removeEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeCompanyTraining(userContext,companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		synchronized(companyTraining){ 
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			companyTraining.removeEmployeeCompanyTraining( employeeCompanyTraining );		
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		

		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
		
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  CompanyTraining copyEmployeeCompanyTrainingFrom(RetailScmUserContext userContext, String companyTrainingId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeCompanyTraining(userContext,companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		synchronized(companyTraining){ 
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			companyTraining.copyEmployeeCompanyTrainingFrom( employeeCompanyTraining );		
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		CompanyTrainingManagerException exception = new CompanyTrainingManagerException("Error Occured");
		
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);
		

	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  CompanyTraining updateEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		
		synchronized(companyTraining){ 
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//companyTraining.removeEmployeeCompanyTraining( employeeCompanyTraining );	
			//make changes to AcceleraterAccount.
			EmployeeCompanyTraining employeeCompanyTrainingIndex = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		
			EmployeeCompanyTraining employeeCompanyTraining = companyTraining.findTheEmployeeCompanyTraining(employeeCompanyTrainingIndex);
			if(employeeCompanyTraining == null){
				throw new CompanyTrainingManagerException(employeeCompanyTraining+"Not found" );
			}
			
			employeeCompanyTraining.changePropery(property, newValueExpr);

			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


