
package com.skynet.retailscm.trainingcoursetype;

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




public class TrainingCourseTypeManagerImpl extends RetailScmCheckerManager implements TrainingCourseTypeManager {
	
	private static final String SERVICE_TYPE = "TrainingCourseType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  TrainingCourseTypeDAO  trainingCourseTypeDAO;
 	public void setTrainingCourseTypeDAO(TrainingCourseTypeDAO  trainingCourseTypeDAO){
 	
 		if(trainingCourseTypeDAO == null){
 			throw new IllegalStateException("Do not try to set trainingCourseTypeDAO to null.");
 		}
	 	this.trainingCourseTypeDAO = trainingCourseTypeDAO;
 	}
 	public TrainingCourseTypeDAO getTrainingCourseTypeDAO(){
 		if(this.trainingCourseTypeDAO == null){
 			throw new IllegalStateException("The TrainingCourseTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.trainingCourseTypeDAO;
 	}
 	
 	protected TrainingCourseType saveTrainingCourseType(RetailScmUserContext userContext, TrainingCourseType trainingCourseType, String [] tokensExpr) throws Exception{	
 		//return getTrainingCourseTypeDAO().save(trainingCourseType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTrainingCourseType(userContext, trainingCourseType, tokens);
 	}
 	
 	protected TrainingCourseType saveTrainingCourseTypeDetail(RetailScmUserContext userContext, TrainingCourseType trainingCourseType) throws Exception{	

 		
 		return saveTrainingCourseType(userContext, trainingCourseType, allTokens());
 	}
 	
 	public TrainingCourseType loadTrainingCourseType(RetailScmUserContext userContext, String trainingCourseTypeId, String [] tokensExpr) throws Exception{				
 
 		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");
		
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,trainingCourseType, tokens);
 	}
 	
 	protected TrainingCourseType present(RetailScmUserContext userContext, TrainingCourseType trainingCourseType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,trainingCourseType,tokens);
		
		
		return this.getTrainingCourseTypeDAO().present(trainingCourseType, tokens);
	}
 
 	
 	
 	public TrainingCourseType loadTrainingCourseTypeDetail(RetailScmUserContext userContext, String trainingCourseTypeId) throws Exception{	
 		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");
		
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, allTokens());

 		return present(userContext,trainingCourseType, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String trainingCourseTypeId) throws Exception{	
 		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");
		
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, allTokens());

 		return present(userContext,trainingCourseType, allTokens());
		
 	}
 	protected TrainingCourseType saveTrainingCourseType(RetailScmUserContext userContext, TrainingCourseType trainingCourseType, Map<String,Object>tokens) throws Exception{	
 		return getTrainingCourseTypeDAO().save(trainingCourseType, tokens);
 	}
 	protected TrainingCourseType loadTrainingCourseType(RetailScmUserContext userContext, String trainingCourseTypeId, Map<String,Object>tokens) throws Exception{	
 		return getTrainingCourseTypeDAO().load(trainingCourseTypeId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TrainingCourseType trainingCourseType, Map<String, Object> tokens){
		super.addActions(userContext, trainingCourseType, tokens);
		
		addAction(userContext, trainingCourseType, tokens,"@create","createTrainingCourseType","createTrainingCourseType/","main","primary");
		addAction(userContext, trainingCourseType, tokens,"@update","updateTrainingCourseType","updateTrainingCourseType/"+trainingCourseType.getId()+"/","main","primary");
		addAction(userContext, trainingCourseType, tokens,"@copy","cloneTrainingCourseType","cloneTrainingCourseType/"+trainingCourseType.getId()+"/","main","primary");
		
		addAction(userContext, trainingCourseType, tokens,"training_course_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+trainingCourseType.getId()+"/","main","primary");
		addAction(userContext, trainingCourseType, tokens,"training_course_type.addCompanyTraining","addCompanyTraining","addCompanyTraining/"+trainingCourseType.getId()+"/","companyTrainingList","primary");
		addAction(userContext, trainingCourseType, tokens,"training_course_type.removeCompanyTraining","removeCompanyTraining","removeCompanyTraining/"+trainingCourseType.getId()+"/","companyTrainingList","primary");
		addAction(userContext, trainingCourseType, tokens,"training_course_type.updateCompanyTraining","updateCompanyTraining","updateCompanyTraining/"+trainingCourseType.getId()+"/","companyTrainingList","primary");
		addAction(userContext, trainingCourseType, tokens,"training_course_type.copyCompanyTrainingFrom","copyCompanyTrainingFrom","copyCompanyTrainingFrom/"+trainingCourseType.getId()+"/","companyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TrainingCourseType trainingCourseType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TrainingCourseType createTrainingCourseType(RetailScmUserContext userContext,String code, String companyId, String name, String description
) throws Exception
	{
		
		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");

		

		checkCodeOfTrainingCourseType(userContext,  code, exception);
		checkNameOfTrainingCourseType(userContext,  name, exception);
		checkDescriptionOfTrainingCourseType(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		TrainingCourseType trainingCourseType=createNewTrainingCourseType();	

		trainingCourseType.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		trainingCourseType.setCompany(company);
		trainingCourseType.setName(name);
		trainingCourseType.setDescription(description);

		return saveTrainingCourseType(userContext, trainingCourseType, emptyOptions());
		

		
	}
	protected TrainingCourseType createNewTrainingCourseType() 
	{
		
		return new TrainingCourseType();		
	}
	
	protected void checkParamsForUpdatingTrainingCourseType(RetailScmUserContext userContext,String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");
		
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
		checkVersionOfTrainingCourseType(userContext, trainingCourseTypeVersion, exception);
		

		if(TrainingCourseType.CODE_PROPERTY.equals(property)){
			checkCodeOfTrainingCourseType(userContext, parseString(newValueExpr), exception);
		}		

		
		if(TrainingCourseType.NAME_PROPERTY.equals(property)){
			checkNameOfTrainingCourseType(userContext, parseString(newValueExpr), exception);
		}
		if(TrainingCourseType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfTrainingCourseType(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public TrainingCourseType clone(RetailScmUserContext userContext, String fromTrainingCourseTypeId) throws Exception{
		
		return this.getTrainingCourseTypeDAO().clone(fromTrainingCourseTypeId, this.allTokens());
	}
	
	public TrainingCourseType updateTrainingCourseType(RetailScmUserContext userContext,String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTrainingCourseType(userContext, trainingCourseTypeId, trainingCourseTypeVersion, property, newValueExpr, tokensExpr);
		
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		if(trainingCourseType.getVersion() != trainingCourseTypeVersion){
			String message = "The target version("+trainingCourseType.getVersion()+") is not equals to version("+trainingCourseTypeVersion+") provided";
			throw new TrainingCourseTypeManagerException(message);
		}
		synchronized(trainingCourseType){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TrainingCourseType.
			
			trainingCourseType.changePropery(property, newValueExpr);
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().done());
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
			//return saveTrainingCourseType(userContext, trainingCourseType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TrainingCourseTypeTokens tokens(){
		return TrainingCourseTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TrainingCourseTypeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TrainingCourseTypeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String trainingCourseTypeId, String anotherCompanyId) throws Exception
 	{
 		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");
 		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TrainingCourseType transferToAnotherCompany(RetailScmUserContext userContext, String trainingCourseTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, trainingCourseTypeId,anotherCompanyId);
 
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());	
		synchronized(trainingCourseType){
			//will be good when the trainingCourseType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			trainingCourseType.setCompany(company);		
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, emptyOptions());
			
			return present(userContext,trainingCourseType, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception {
		
		deleteInternal(userContext, trainingCourseTypeId, trainingCourseTypeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception{
		getTrainingCourseTypeDAO().delete(trainingCourseTypeId, trainingCourseTypeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TrainingCourseTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getTrainingCourseTypeDAO().deleteAll();
	}

	protected void checkParamsForAddingCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours,String [] tokensExpr) throws Exception{
		
		

		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");
		
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);

		checkTitleOfCompanyTraining(userContext,  title, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  companyId, exception);		
		
		checkIdOfInstructor(userContext,  instructorId, exception);
		checkTimeStartOfCompanyTraining(userContext,  timeStart, exception);
		checkDurationHoursOfCompanyTraining(userContext,  durationHours, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TrainingCourseType addCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCompanyTraining(userContext,trainingCourseTypeId,title, companyId, instructorId, timeStart, durationHours,tokensExpr);
		
		CompanyTraining companyTraining = createCompanyTraining(userContext,title, companyId, instructorId, timeStart, durationHours);
		
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		synchronized(trainingCourseType){ 
			//Will be good when the trainingCourseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			trainingCourseType.addCompanyTraining( companyTraining );		
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}
	}
	protected CompanyTraining createCompanyTraining(RetailScmUserContext userContext, String title, String companyId, String instructorId, Date timeStart, int durationHours) throws Exception{

		CompanyTraining companyTraining = new CompanyTraining();
		
		
		companyTraining.setTitle(title);		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		companyTraining.setCompany(company);		
		Instructor  instructor = new Instructor();
		instructor.setId(instructorId);		
		companyTraining.setInstructor(instructor);		
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
	protected void checkParamsForRemovingCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		

		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");
		
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkVersionOfCompanyTraining(userContext, companyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TrainingCourseType removeCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCompanyTraining(userContext,trainingCourseTypeId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		synchronized(trainingCourseType){ 
			//Will be good when the trainingCourseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			trainingCourseType.removeCompanyTraining( companyTraining );		
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		

		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");
		
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkVersionOfCompanyTraining(userContext, companyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TrainingCourseType copyCompanyTrainingFrom(RetailScmUserContext userContext, String trainingCourseTypeId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCompanyTraining(userContext,trainingCourseTypeId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		synchronized(trainingCourseType){ 
			//Will be good when the trainingCourseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			trainingCourseType.copyCompanyTrainingFrom( companyTraining );		
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TrainingCourseTypeManagerException exception = new TrainingCourseTypeManagerException("Error Occured");
		
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
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
	
	public  TrainingCourseType updateCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCompanyTraining(userContext, trainingCourseTypeId, companyTrainingId, companyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		
		synchronized(trainingCourseType){ 
			//Will be good when the trainingCourseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//trainingCourseType.removeCompanyTraining( companyTraining );	
			//make changes to AcceleraterAccount.
			CompanyTraining companyTrainingIndex = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		
			CompanyTraining companyTraining = trainingCourseType.findTheCompanyTraining(companyTrainingIndex);
			if(companyTraining == null){
				throw new TrainingCourseTypeManagerException(companyTraining+"Not found" );
			}
			
			companyTraining.changePropery(property, newValueExpr);

			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


