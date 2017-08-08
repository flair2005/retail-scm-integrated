
package com.skynet.retailscm.instructor;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.companytraining.CompanyTraining;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.companytraining.CompanyTrainingTable;




public class InstructorManagerImpl extends RetailScmCheckerManager implements InstructorManager {
	
	private static final String SERVICE_TYPE = "Instructor";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  InstructorDAO  instructorDAO;
 	public void setInstructorDAO(InstructorDAO  instructorDAO){
 	
 		if(instructorDAO == null){
 			throw new IllegalStateException("Do not try to set instructorDAO to null.");
 		}
	 	this.instructorDAO = instructorDAO;
 	}
 	public InstructorDAO getInstructorDAO(){
 		if(this.instructorDAO == null){
 			throw new IllegalStateException("The InstructorDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.instructorDAO;
 	}
 	
 	protected Instructor saveInstructor(RetailScmUserContext userContext, Instructor instructor, String [] tokensExpr) throws Exception{	
 		//return getInstructorDAO().save(instructor, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveInstructor(userContext, instructor, tokens);
 	}
 	
 	protected Instructor saveInstructorDetail(RetailScmUserContext userContext, Instructor instructor) throws Exception{	

 		
 		return saveInstructor(userContext, instructor, allTokens());
 	}
 	
 	public Instructor loadInstructor(RetailScmUserContext userContext, String instructorId, String [] tokensExpr) throws Exception{				
 
 		InstructorManagerException exception = new InstructorManagerException("Error Occured");
		
		checkIdOfInstructor(userContext, instructorId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Instructor instructor = loadInstructor( userContext, instructorId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,instructor, tokens);
 	}
 	
 	protected Instructor present(RetailScmUserContext userContext, Instructor instructor, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,instructor,tokens);
		
		
		return this.getInstructorDAO().present(instructor, tokens);
	}
 
 	
 	
 	public Instructor loadInstructorDetail(RetailScmUserContext userContext, String instructorId) throws Exception{	
 		InstructorManagerException exception = new InstructorManagerException("Error Occured");
		
		checkIdOfInstructor(userContext, instructorId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Instructor instructor = loadInstructor( userContext, instructorId, allTokens());

 		return present(userContext,instructor, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String instructorId) throws Exception{	
 		InstructorManagerException exception = new InstructorManagerException("Error Occured");
		
		checkIdOfInstructor(userContext, instructorId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Instructor instructor = loadInstructor( userContext, instructorId, allTokens());

 		return present(userContext,instructor, allTokens());
		
 	}
 	protected Instructor saveInstructor(RetailScmUserContext userContext, Instructor instructor, Map<String,Object>tokens) throws Exception{	
 		return getInstructorDAO().save(instructor, tokens);
 	}
 	protected Instructor loadInstructor(RetailScmUserContext userContext, String instructorId, Map<String,Object>tokens) throws Exception{	
 		return getInstructorDAO().load(instructorId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Instructor instructor, Map<String, Object> tokens){
		super.addActions(userContext, instructor, tokens);
		
		addAction(userContext, instructor, tokens,"@create","createInstructor","createInstructor/","main","primary");
		addAction(userContext, instructor, tokens,"@update","updateInstructor","updateInstructor/"+instructor.getId()+"/","main","primary");
		addAction(userContext, instructor, tokens,"@copy","cloneInstructor","cloneInstructor/"+instructor.getId()+"/","main","primary");
		
		addAction(userContext, instructor, tokens,"instructor.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+instructor.getId()+"/","main","primary");
		addAction(userContext, instructor, tokens,"instructor.addCompanyTraining","addCompanyTraining","addCompanyTraining/"+instructor.getId()+"/","companyTrainingList","primary");
		addAction(userContext, instructor, tokens,"instructor.removeCompanyTraining","removeCompanyTraining","removeCompanyTraining/"+instructor.getId()+"/","companyTrainingList","primary");
		addAction(userContext, instructor, tokens,"instructor.updateCompanyTraining","updateCompanyTraining","updateCompanyTraining/"+instructor.getId()+"/","companyTrainingList","primary");
		addAction(userContext, instructor, tokens,"instructor.copyCompanyTrainingFrom","copyCompanyTrainingFrom","copyCompanyTrainingFrom/"+instructor.getId()+"/","companyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Instructor instructor, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Instructor createInstructor(RetailScmUserContext userContext,String title, String familyName, String givenName, String cellPhone, String email, String companyId, String introduction
) throws Exception
	{
		
		InstructorManagerException exception = new InstructorManagerException("Error Occured");

		

		checkTitleOfInstructor(userContext,  title, exception);
		checkFamilyNameOfInstructor(userContext,  familyName, exception);
		checkGivenNameOfInstructor(userContext,  givenName, exception);
		checkCellPhoneOfInstructor(userContext,  cellPhone, exception);
		checkEmailOfInstructor(userContext,  email, exception);
		checkIntroductionOfInstructor(userContext,  introduction, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Instructor instructor=createNewInstructor();	

		instructor.setTitle(title);
		instructor.setFamilyName(familyName);
		instructor.setGivenName(givenName);
		instructor.setCellPhone(cellPhone);
		instructor.setEmail(email);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		instructor.setCompany(company);
		instructor.setIntroduction(introduction);

		return saveInstructor(userContext, instructor, emptyOptions());
		

		
	}
	protected Instructor createNewInstructor() 
	{
		
		return new Instructor();		
	}
	
	protected void checkParamsForUpdatingInstructor(RetailScmUserContext userContext,String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		InstructorManagerException exception = new InstructorManagerException("Error Occured");
		
		checkIdOfInstructor(userContext, instructorId, exception);
		checkVersionOfInstructor(userContext, instructorVersion, exception);
		

		if(Instructor.TITLE_PROPERTY.equals(property)){
			checkTitleOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		if(Instructor.FAMILY_NAME_PROPERTY.equals(property)){
			checkFamilyNameOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		if(Instructor.GIVEN_NAME_PROPERTY.equals(property)){
			checkGivenNameOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		if(Instructor.CELL_PHONE_PROPERTY.equals(property)){
			checkCellPhoneOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		if(Instructor.EMAIL_PROPERTY.equals(property)){
			checkEmailOfInstructor(userContext, parseString(newValueExpr), exception);
		}		

		
		if(Instructor.INTRODUCTION_PROPERTY.equals(property)){
			checkIntroductionOfInstructor(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public Instructor clone(RetailScmUserContext userContext, String fromInstructorId) throws Exception{
		
		return this.getInstructorDAO().clone(fromInstructorId, this.allTokens());
	}
	
	public Instructor updateInstructor(RetailScmUserContext userContext,String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingInstructor(userContext, instructorId, instructorVersion, property, newValueExpr, tokensExpr);
		
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		if(instructor.getVersion() != instructorVersion){
			String message = "The target version("+instructor.getVersion()+") is not equals to version("+instructorVersion+") provided";
			throw new InstructorManagerException(message);
		}
		synchronized(instructor){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Instructor.
			
			instructor.changePropery(property, newValueExpr);
			instructor = saveInstructor(userContext, instructor, tokens().done());
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
			//return saveInstructor(userContext, instructor, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected InstructorTokens tokens(){
		return InstructorTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return InstructorTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return InstructorTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String instructorId, String anotherCompanyId) throws Exception
 	{
 		InstructorManagerException exception = new InstructorManagerException("Error Occured");
 		checkIdOfInstructor(userContext, instructorId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Instructor transferToAnotherCompany(RetailScmUserContext userContext, String instructorId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, instructorId,anotherCompanyId);
 
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());	
		synchronized(instructor){
			//will be good when the instructor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			instructor.setCompany(company);		
			instructor = saveInstructor(userContext, instructor, emptyOptions());
			
			return present(userContext,instructor, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String instructorId, int instructorVersion) throws Exception {
		
		deleteInternal(userContext, instructorId, instructorVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String instructorId, int instructorVersion) throws Exception{
		getInstructorDAO().delete(instructorId, instructorVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new InstructorManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getInstructorDAO().deleteAll();
	}

	protected void checkParamsForAddingCompanyTraining(RetailScmUserContext userContext, String instructorId, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours,String [] tokensExpr) throws Exception{
		
		

		InstructorManagerException exception = new InstructorManagerException("Error Occured");
		
		checkIdOfInstructor(userContext, instructorId, exception);

		checkTitleOfCompanyTraining(userContext,  title, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  companyId, exception);		
		
		checkIdOfTrainingCourseType(userContext,  trainingCourseTypeId, exception);
		checkTimeStartOfCompanyTraining(userContext,  timeStart, exception);
		checkDurationHoursOfCompanyTraining(userContext,  durationHours, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Instructor addCompanyTraining(RetailScmUserContext userContext, String instructorId, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCompanyTraining(userContext,instructorId,title, companyId, trainingCourseTypeId, timeStart, durationHours,tokensExpr);
		
		CompanyTraining companyTraining = createCompanyTraining(userContext,title, companyId, trainingCourseTypeId, timeStart, durationHours);
		
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		synchronized(instructor){ 
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			instructor.addCompanyTraining( companyTraining );		
			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}
	}
	protected CompanyTraining createCompanyTraining(RetailScmUserContext userContext, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours) throws Exception{

		CompanyTraining companyTraining = new CompanyTraining();
		
		
		companyTraining.setTitle(title);		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		companyTraining.setCompany(company);		
		TrainingCourseType  trainingCourseType = new TrainingCourseType();
		trainingCourseType.setId(trainingCourseTypeId);		
		companyTraining.setTrainingCourseType(trainingCourseType);		
		companyTraining.setTimeStart(timeStart);		
		companyTraining.setDurationHours(durationHours);
	
		
		return companyTraining;
	
		
	}
	
	protected CompanyTraining createIndexedCompanyTraining(String id, int version){

		CompanyTraining companyTraining = new CompanyTraining();
		companyTraining.setId(id);
		companyTraining.setVersion(version);
		return companyTraining;			
		
	}
	protected void checkParamsForRemovingCompanyTraining(RetailScmUserContext userContext, String instructorId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		

		InstructorManagerException exception = new InstructorManagerException("Error Occured");
		
		checkIdOfInstructor(userContext, instructorId, exception);
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkVersionOfCompanyTraining(userContext, companyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Instructor removeCompanyTraining(RetailScmUserContext userContext, String instructorId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCompanyTraining(userContext,instructorId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		synchronized(instructor){ 
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			instructor.removeCompanyTraining( companyTraining );		
			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingCompanyTraining(RetailScmUserContext userContext, String instructorId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		

		InstructorManagerException exception = new InstructorManagerException("Error Occured");
		
		checkIdOfInstructor(userContext, instructorId, exception);
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkVersionOfCompanyTraining(userContext, companyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Instructor copyCompanyTrainingFrom(RetailScmUserContext userContext, String instructorId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCompanyTraining(userContext,instructorId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		synchronized(instructor){ 
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			instructor.copyCompanyTrainingFrom( companyTraining );		
			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingCompanyTraining(RetailScmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		InstructorManagerException exception = new InstructorManagerException("Error Occured");
		
		checkIdOfInstructor(userContext, instructorId, exception);
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
	
	public  Instructor updateCompanyTraining(RetailScmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCompanyTraining(userContext, instructorId, companyTrainingId, companyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		
		synchronized(instructor){ 
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//instructor.removeCompanyTraining( companyTraining );	
			//make changes to AcceleraterAccount.
			CompanyTraining companyTrainingIndex = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		
			CompanyTraining companyTraining = instructor.findTheCompanyTraining(companyTrainingIndex);
			if(companyTraining == null){
				throw new InstructorManagerException(companyTraining+"Not found" );
			}
			
			companyTraining.changePropery(property, newValueExpr);

			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


