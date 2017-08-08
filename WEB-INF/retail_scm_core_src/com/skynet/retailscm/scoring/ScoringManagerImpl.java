
package com.skynet.retailscm.scoring;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;


import com.skynet.retailscm.scoring.Scoring;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.employee.Employee;


import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTrainingTable;




public class ScoringManagerImpl extends RetailScmCheckerManager implements ScoringManager {
	
	private static final String SERVICE_TYPE = "Scoring";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ScoringDAO  scoringDAO;
 	public void setScoringDAO(ScoringDAO  scoringDAO){
 	
 		if(scoringDAO == null){
 			throw new IllegalStateException("Do not try to set scoringDAO to null.");
 		}
	 	this.scoringDAO = scoringDAO;
 	}
 	public ScoringDAO getScoringDAO(){
 		if(this.scoringDAO == null){
 			throw new IllegalStateException("The ScoringDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.scoringDAO;
 	}
 	
 	protected Scoring saveScoring(RetailScmUserContext userContext, Scoring scoring, String [] tokensExpr) throws Exception{	
 		//return getScoringDAO().save(scoring, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveScoring(userContext, scoring, tokens);
 	}
 	
 	protected Scoring saveScoringDetail(RetailScmUserContext userContext, Scoring scoring) throws Exception{	

 		
 		return saveScoring(userContext, scoring, allTokens());
 	}
 	
 	public Scoring loadScoring(RetailScmUserContext userContext, String scoringId, String [] tokensExpr) throws Exception{				
 
 		ScoringManagerException exception = new ScoringManagerException("Error Occured");
		
		checkIdOfScoring(userContext, scoringId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Scoring scoring = loadScoring( userContext, scoringId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,scoring, tokens);
 	}
 	
 	protected Scoring present(RetailScmUserContext userContext, Scoring scoring, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,scoring,tokens);
		
		
		return this.getScoringDAO().present(scoring, tokens);
	}
 
 	
 	
 	public Scoring loadScoringDetail(RetailScmUserContext userContext, String scoringId) throws Exception{	
 		ScoringManagerException exception = new ScoringManagerException("Error Occured");
		
		checkIdOfScoring(userContext, scoringId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Scoring scoring = loadScoring( userContext, scoringId, allTokens());

 		return present(userContext,scoring, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String scoringId) throws Exception{	
 		ScoringManagerException exception = new ScoringManagerException("Error Occured");
		
		checkIdOfScoring(userContext, scoringId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Scoring scoring = loadScoring( userContext, scoringId, allTokens());

 		return present(userContext,scoring, allTokens());
		
 	}
 	protected Scoring saveScoring(RetailScmUserContext userContext, Scoring scoring, Map<String,Object>tokens) throws Exception{	
 		return getScoringDAO().save(scoring, tokens);
 	}
 	protected Scoring loadScoring(RetailScmUserContext userContext, String scoringId, Map<String,Object>tokens) throws Exception{	
 		return getScoringDAO().load(scoringId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Scoring scoring, Map<String, Object> tokens){
		super.addActions(userContext, scoring, tokens);
		
		addAction(userContext, scoring, tokens,"@create","createScoring","createScoring/","main","primary");
		addAction(userContext, scoring, tokens,"@update","updateScoring","updateScoring/"+scoring.getId()+"/","main","primary");
		addAction(userContext, scoring, tokens,"@copy","cloneScoring","cloneScoring/"+scoring.getId()+"/","main","primary");
		
		addAction(userContext, scoring, tokens,"scoring.addEmployeeCompanyTraining","addEmployeeCompanyTraining","addEmployeeCompanyTraining/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, scoring, tokens,"scoring.removeEmployeeCompanyTraining","removeEmployeeCompanyTraining","removeEmployeeCompanyTraining/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, scoring, tokens,"scoring.updateEmployeeCompanyTraining","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, scoring, tokens,"scoring.copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Scoring scoring, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Scoring createScoring(RetailScmUserContext userContext,String scoredBy, int score, String comment
) throws Exception
	{
		
		ScoringManagerException exception = new ScoringManagerException("Error Occured");

		

		checkScoredByOfScoring(userContext,  scoredBy, exception);
		checkScoreOfScoring(userContext,  score, exception);
		checkCommentOfScoring(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Scoring scoring=createNewScoring();	

		scoring.setScoredBy(scoredBy);
		scoring.setScore(score);
		scoring.setComment(comment);

		return saveScoring(userContext, scoring, emptyOptions());
		

		
	}
	protected Scoring createNewScoring() 
	{
		
		return new Scoring();		
	}
	
	protected void checkParamsForUpdatingScoring(RetailScmUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ScoringManagerException exception = new ScoringManagerException("Error Occured");
		
		checkIdOfScoring(userContext, scoringId, exception);
		checkVersionOfScoring(userContext, scoringVersion, exception);
		

		if(Scoring.SCORED_BY_PROPERTY.equals(property)){
			checkScoredByOfScoring(userContext, parseString(newValueExpr), exception);
		}
		if(Scoring.SCORE_PROPERTY.equals(property)){
			checkScoreOfScoring(userContext, parseInt(newValueExpr), exception);
		}
		if(Scoring.COMMENT_PROPERTY.equals(property)){
			checkCommentOfScoring(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public Scoring clone(RetailScmUserContext userContext, String fromScoringId) throws Exception{
		
		return this.getScoringDAO().clone(fromScoringId, this.allTokens());
	}
	
	public Scoring updateScoring(RetailScmUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingScoring(userContext, scoringId, scoringVersion, property, newValueExpr, tokensExpr);
		
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		if(scoring.getVersion() != scoringVersion){
			String message = "The target version("+scoring.getVersion()+") is not equals to version("+scoringVersion+") provided";
			throw new ScoringManagerException(message);
		}
		synchronized(scoring){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Scoring.
			
			scoring.changePropery(property, newValueExpr);
			scoring = saveScoring(userContext, scoring, tokens().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
			//return saveScoring(userContext, scoring, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ScoringTokens tokens(){
		return ScoringTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ScoringTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ScoringTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String scoringId, int scoringVersion) throws Exception {
		
		deleteInternal(userContext, scoringId, scoringVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String scoringId, int scoringVersion) throws Exception{
		getScoringDAO().delete(scoringId, scoringVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ScoringManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getScoringDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, String employeeId, String trainingId,String [] tokensExpr) throws Exception{
		
		

		ScoringManagerException exception = new ScoringManagerException("Error Occured");
		
		checkIdOfScoring(userContext, scoringId, exception);
		
		
		checkIdOfEmployee(userContext,  employeeId, exception);		
		
		checkIdOfCompanyTraining(userContext,  trainingId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Scoring addEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, String employeeId, String trainingId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeCompanyTraining(userContext,scoringId,employeeId, trainingId,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,employeeId, trainingId);
		
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		synchronized(scoring){ 
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			scoring.addEmployeeCompanyTraining( employeeCompanyTraining );		
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeCompanyTraining createEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, String trainingId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeCompanyTraining.setEmployee(employee);		
		CompanyTraining  training = new CompanyTraining();
		training.setId(trainingId);		
		employeeCompanyTraining.setTraining(training);
	
		
		return employeeCompanyTraining;
	
		
	}
	
	protected EmployeeCompanyTraining createIndexedEmployeeCompanyTraining(String id, int version){

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTraining.setId(id);
		employeeCompanyTraining.setVersion(version);
		return employeeCompanyTraining;			
		
	}
	protected void checkParamsForRemovingEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		

		ScoringManagerException exception = new ScoringManagerException("Error Occured");
		
		checkIdOfScoring(userContext, scoringId, exception);
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Scoring removeEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeCompanyTraining(userContext,scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		synchronized(scoring){ 
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			scoring.removeEmployeeCompanyTraining( employeeCompanyTraining );		
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		

		ScoringManagerException exception = new ScoringManagerException("Error Occured");
		
		checkIdOfScoring(userContext, scoringId, exception);
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Scoring copyEmployeeCompanyTrainingFrom(RetailScmUserContext userContext, String scoringId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeCompanyTraining(userContext,scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		synchronized(scoring){ 
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			scoring.copyEmployeeCompanyTrainingFrom( employeeCompanyTraining );		
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ScoringManagerException exception = new ScoringManagerException("Error Occured");
		
		checkIdOfScoring(userContext, scoringId, exception);
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);
		

	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Scoring updateEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		
		synchronized(scoring){ 
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//scoring.removeEmployeeCompanyTraining( employeeCompanyTraining );	
			//make changes to AcceleraterAccount.
			EmployeeCompanyTraining employeeCompanyTrainingIndex = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		
			EmployeeCompanyTraining employeeCompanyTraining = scoring.findTheEmployeeCompanyTraining(employeeCompanyTrainingIndex);
			if(employeeCompanyTraining == null){
				throw new ScoringManagerException(employeeCompanyTraining+"Not found" );
			}
			
			employeeCompanyTraining.changePropery(property, newValueExpr);

			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


