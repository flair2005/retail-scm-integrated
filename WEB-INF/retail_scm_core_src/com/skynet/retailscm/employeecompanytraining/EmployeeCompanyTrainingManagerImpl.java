
package com.skynet.retailscm.employeecompanytraining;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.scoring.Scoring;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.employee.EmployeeDAO;
import com.skynet.retailscm.companytraining.CompanyTrainingDAO;
import com.skynet.retailscm.scoring.ScoringDAO;



import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.companytraining.CompanyTrainingTable;
import com.skynet.retailscm.scoring.ScoringTable;




public class EmployeeCompanyTrainingManagerImpl extends RetailScmCheckerManager implements EmployeeCompanyTrainingManager {
	
	private static final String SERVICE_TYPE = "EmployeeCompanyTraining";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeCompanyTrainingDAO  employeeCompanyTrainingDAO;
 	public void setEmployeeCompanyTrainingDAO(EmployeeCompanyTrainingDAO  employeeCompanyTrainingDAO){
 	
 		if(employeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set employeeCompanyTrainingDAO to null.");
 		}
	 	this.employeeCompanyTrainingDAO = employeeCompanyTrainingDAO;
 	}
 	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO(){
 		if(this.employeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("The EmployeeCompanyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeCompanyTrainingDAO;
 	}
 	
 	protected EmployeeCompanyTraining saveEmployeeCompanyTraining(RetailScmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, String [] tokensExpr) throws Exception{	
 		//return getEmployeeCompanyTrainingDAO().save(employeeCompanyTraining, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens);
 	}
 	
 	protected EmployeeCompanyTraining saveEmployeeCompanyTrainingDetail(RetailScmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining) throws Exception{	

 		
 		return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, allTokens());
 	}
 	
 	public EmployeeCompanyTraining loadEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeCompanyTrainingId, String [] tokensExpr) throws Exception{				
 
 		EmployeeCompanyTrainingManagerException exception = new EmployeeCompanyTrainingManagerException("Error Occured");
		
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeCompanyTraining, tokens);
 	}
 	
 	protected EmployeeCompanyTraining present(RetailScmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeCompanyTraining,tokens);
		
		
		return this.getEmployeeCompanyTrainingDAO().present(employeeCompanyTraining, tokens);
	}
 
 	
 	
 	public EmployeeCompanyTraining loadEmployeeCompanyTrainingDetail(RetailScmUserContext userContext, String employeeCompanyTrainingId) throws Exception{	
 		EmployeeCompanyTrainingManagerException exception = new EmployeeCompanyTrainingManagerException("Error Occured");
		
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, allTokens());

 		return present(userContext,employeeCompanyTraining, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeCompanyTrainingId) throws Exception{	
 		EmployeeCompanyTrainingManagerException exception = new EmployeeCompanyTrainingManagerException("Error Occured");
		
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, allTokens());

 		return present(userContext,employeeCompanyTraining, allTokens());
		
 	}
 	protected EmployeeCompanyTraining saveEmployeeCompanyTraining(RetailScmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeCompanyTrainingDAO().save(employeeCompanyTraining, tokens);
 	}
 	protected EmployeeCompanyTraining loadEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeCompanyTrainingId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeCompanyTrainingDAO().load(employeeCompanyTrainingId, tokens);
 	}

	



 	 
 	
 	private  CompanyTrainingDAO  companyTrainingDAO;
 	public void setCompanyTrainingDAO(CompanyTrainingDAO companyTrainingDAO){
	 	this.companyTrainingDAO = companyTrainingDAO;
 	}
 	//------------------------------------
 	public CompanyTrainingDAO getCompanyTrainingDAO(){
	 	return this.companyTrainingDAO;
 	}
 
 	
 	private  ScoringDAO  scoringDAO;
 	public void setScoringDAO(ScoringDAO scoringDAO){
	 	this.scoringDAO = scoringDAO;
 	}
 	//------------------------------------
 	public ScoringDAO getScoringDAO(){
	 	return this.scoringDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens){
		super.addActions(userContext, employeeCompanyTraining, tokens);
		
		addAction(userContext, employeeCompanyTraining, tokens,"@create","createEmployeeCompanyTraining","createEmployeeCompanyTraining/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"@update","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+employeeCompanyTraining.getId()+"/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"@copy","cloneEmployeeCompanyTraining","cloneEmployeeCompanyTraining/"+employeeCompanyTraining.getId()+"/","main","primary");
		
		addAction(userContext, employeeCompanyTraining, tokens,"employee_company_training.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeCompanyTraining.getId()+"/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"employee_company_training.transfer_to_training","transferToAnotherTraining","transferToAnotherTraining/"+employeeCompanyTraining.getId()+"/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"employee_company_training.score","score","score/"+employeeCompanyTraining.getId()+"/","main","success");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeCompanyTraining createEmployeeCompanyTraining(RetailScmUserContext userContext,String employeeId, String trainingId
) throws Exception
	{
		
		EmployeeCompanyTrainingManagerException exception = new EmployeeCompanyTrainingManagerException("Error Occured");

		

	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeCompanyTraining employeeCompanyTraining=createNewEmployeeCompanyTraining();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeeCompanyTraining.setEmployee(employee);
		CompanyTraining training = loadCompanyTraining(trainingId,emptyOptions());
		employeeCompanyTraining.setTraining(training);

		return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
		

		
	}
	protected EmployeeCompanyTraining createNewEmployeeCompanyTraining() 
	{
		
		return new EmployeeCompanyTraining();		
	}
	
	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailScmUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeCompanyTrainingManagerException exception = new EmployeeCompanyTrainingManagerException("Error Occured");
		
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);
		
		

				

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeCompanyTraining clone(RetailScmUserContext userContext, String fromEmployeeCompanyTrainingId) throws Exception{
		
		return this.getEmployeeCompanyTrainingDAO().clone(fromEmployeeCompanyTrainingId, this.allTokens());
	}
	
	public EmployeeCompanyTraining updateEmployeeCompanyTraining(RetailScmUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr, tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
		if(employeeCompanyTraining.getVersion() != employeeCompanyTrainingVersion){
			String message = "The target version("+employeeCompanyTraining.getVersion()+") is not equals to version("+employeeCompanyTrainingVersion+") provided";
			throw new EmployeeCompanyTrainingManagerException(message);
		}
		synchronized(employeeCompanyTraining){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeCompanyTraining.
			
			employeeCompanyTraining.changePropery(property, newValueExpr);
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
			return present(userContext,employeeCompanyTraining, mergedAllTokens(tokensExpr));
			//return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeCompanyTrainingTokens tokens(){
		return EmployeeCompanyTrainingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeCompanyTrainingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeCompanyTrainingTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={"SCORED"};
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId) throws Exception
 	{
 		EmployeeCompanyTrainingManagerException exception = new EmployeeCompanyTrainingManagerException("Error Occured");
 		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeCompanyTraining transferToAnotherEmployee(RetailScmUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeCompanyTrainingId,anotherEmployeeId);
 
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeeCompanyTraining.setEmployee(employee);		
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
			
			return present(userContext,employeeCompanyTraining, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherTraining(RetailScmUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId) throws Exception
 	{
 		EmployeeCompanyTrainingManagerException exception = new EmployeeCompanyTrainingManagerException("Error Occured");
 		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId,exception);
 		checkIdOfCompanyTraining(userContext, anotherTrainingId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeCompanyTraining transferToAnotherTraining(RetailScmUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId) throws Exception
 	{
 		checkParamsForTransferingAnotherTraining(userContext, employeeCompanyTrainingId,anotherTrainingId);
 
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CompanyTraining training = loadCompanyTraining(anotherTrainingId, emptyOptions());		
			employeeCompanyTraining.setTraining(training);		
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
			
			return present(userContext,employeeCompanyTraining, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForScoring(RetailScmUserContext userContext, String employeeCompanyTrainingId, String scoredBy, int score, String comment
) throws Exception
 	{
 		

		EmployeeCompanyTrainingManagerException exception = new EmployeeCompanyTrainingManagerException("Error Occured");
		
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkScoredByOfScoring(userContext,scoredBy,exception);
		checkScoreOfScoring(userContext,score,exception);
		checkCommentOfScoring(userContext,comment,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public EmployeeCompanyTraining score(RetailScmUserContext userContext, String employeeCompanyTrainingId, String scoredBy, int score, String comment
) throws Exception
 	{
		checkParamsForScoring(userContext, employeeCompanyTrainingId, scoredBy, score, comment);
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForScoring(userContext,employeeCompanyTraining);
 		

			employeeCompanyTraining.setCurrentStatus("SCORED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			Scoring scoring = createScoring(scoredBy, score, comment);		
			employeeCompanyTraining.setScoring(scoring);		
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().withScoring().done());
			
			return present(userContext,employeeCompanyTraining, allTokens());
			
		}

 	}
 	protected Scoring createScoring(String scoredBy, int score, String comment){
 		Scoring scoring = new Scoring(scoredBy, score, comment);
 		return getScoringDAO().save(scoring,emptyOptions());
 	}
 	protected void checkIfEligibleForScoring(RetailScmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining) throws Exception{
 		
 		
 		String currentStatus = employeeCompanyTraining.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'SCORED'";
 			throw new EmployeeCompanyTrainingManagerException(message);
 		}
 		
 		if(!("SCORED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'SCORED'";
 			throw new EmployeeCompanyTrainingManagerException(message);
 		}
 		
 		
 		Scoring scoring = employeeCompanyTraining.getScoring();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = scoring 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( scoring != null){
				throw new EmployeeCompanyTrainingManagerException("The EmployeeCompanyTraining("+employeeCompanyTraining.getId()+") has already been SCORED");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected CompanyTraining loadCompanyTraining(String newTrainingId, Map<String,Object> options) throws Exception
 	{
		
 		return getCompanyTrainingDAO().load(newTrainingId, options);
 	}
	
	 	
 	protected Scoring loadScoring(String newScoringId, Map<String,Object> options) throws Exception
 	{
		
 		return getScoringDAO().load(newScoringId, options);
 	}
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception {
		
		deleteInternal(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception{
		getEmployeeCompanyTrainingDAO().delete(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeCompanyTrainingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeCompanyTrainingDAO().deleteAll();
	}


}


