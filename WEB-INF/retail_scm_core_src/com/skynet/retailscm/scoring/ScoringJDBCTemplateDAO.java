
package com.skynet.retailscm.scoring;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;

import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTrainingTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ScoringJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ScoringDAO{

		
	
  	private  EmployeeCompanyTrainingDAO  employeeCompanyTrainingDAO;
 	public void setEmployeeCompanyTrainingDAO(EmployeeCompanyTrainingDAO pEmployeeCompanyTrainingDAO){
 	
 		if(pEmployeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set employeeCompanyTrainingDAO to null.");
 		}
	 	this.employeeCompanyTrainingDAO = pEmployeeCompanyTrainingDAO;
 	}
 	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO(){
 		if(this.employeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("The employeeCompanyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeCompanyTrainingDAO;
 	}	
 	
			
		

	
	/*
	protected Scoring load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalScoring(accessKey, options);
	}
	*/
	public Scoring load(String id,Map<String,Object> options) throws Exception{
		return loadInternalScoring(ScoringTable.withId(id), options);
	}
	
	
	
	public Scoring save(Scoring scoring,Map<String,Object> options){
		
		String methodName="save(Scoring scoring,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(scoring, methodName, "scoring");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalScoring(scoring,options);
	}
	public Scoring clone(String scoringId, Map<String,Object> options) throws Exception{
	
		return clone(ScoringTable.withId(scoringId),options);
	}
	
	protected Scoring clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String scoringId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Scoring newScoring = loadInternalScoring(accessKey, options);
		newScoring.setVersion(0);
		
		
 		
 		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
 			for(EmployeeCompanyTraining item: newScoring.getEmployeeCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalScoring(newScoring,options);
		
		return newScoring;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String scoringId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{scoringId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ScoringVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ScoringNotFoundException(
					"The " + this.getTableName() + "(" + scoringId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String scoringId, int version) throws Exception{
	
		String methodName="delete(String scoringId, int version)";
		assertMethodArgumentNotNull(scoringId, methodName, "scoringId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{scoringId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(scoringId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"scored_by","score","comment"};
		return ScoringTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "scoring";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ScoringTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";
	
	protected boolean isExtractEmployeeCompanyTrainingListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ScoringTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
		
 	}

	protected boolean isSaveEmployeeCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, ScoringTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
		
 	}
 	
 	
			
		

	

	protected ScoringMapper getScoringMapper(){
		return new ScoringMapper();
	}
	protected Scoring extractScoring(String scoringId) throws Exception{
		String SQL = "select * from scoring_data where id = ?";	
		try{
		
			Scoring scoring = queryForObject(SQL, new Object[]{scoringId}, getScoringMapper());
			return scoring;
		}catch(EmptyResultDataAccessException e){
			throw new ScoringNotFoundException("Scoring("+scoringId+") is not found!");
		}
		
		
	}
	protected Scoring extractScoring(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from scoring_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Scoring scoring = queryForObject(SQL, new Object[]{accessKey.getValue()}, getScoringMapper());
			return scoring;
		}catch(EmptyResultDataAccessException e){
			throw new ScoringNotFoundException("Scoring("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Scoring loadInternalScoring(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Scoring scoring = extractScoring(accessKey, loadOptions);

		
		if(isExtractEmployeeCompanyTrainingListEnabled(loadOptions)){
	 		extractEmployeeCompanyTrainingList(scoring, loadOptions);
 		}		
		
		return scoring;
		
	}



	
	
	
		
	protected Scoring extractEmployeeCompanyTrainingList(Scoring scoring, Map<String,Object> options){
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingByScoring(scoring.getId(),options);
		if(employeeCompanyTrainingList != null){
			scoring.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
		}
		
		return scoring;
	
	}	
		
		
 	
		
		
		

	

	protected Scoring saveScoring(Scoring  scoring){
	
		String SQL=this.getSaveScoringSQL(scoring);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveScoringParameters(scoring);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		scoring.incVersion();
		return scoring;
	
	}
	public SmartList<Scoring> saveScoringList(SmartList<Scoring> scoringList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitScoringList(scoringList);
		
		batchScoringCreate((List<Scoring>)lists[CREATE_LIST_INDEX]);
		
		batchScoringUpdate((List<Scoring>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Scoring scoring:scoringList){
			if(scoring.isChanged()){
				scoring.incVersion();
			}
			
		
		}
		
		
		return scoringList;
	}

	public SmartList<Scoring> removeScoringList(SmartList<Scoring> scoringList,Map<String,Object> options){
		
		
		super.removeList(scoringList, options);
		
		return scoringList;
		
		
	}
	
	protected List<Object[]> prepareScoringBatchCreateArgs(List<Scoring> scoringList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Scoring scoring:scoringList ){
			Object [] parameters = prepareScoringCreateParameters(scoring);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareScoringBatchUpdateArgs(List<Scoring> scoringList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Scoring scoring:scoringList ){
			if(!scoring.isChanged()){
				continue;
			}
			Object [] parameters = prepareScoringUpdateParameters(scoring);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchScoringCreate(List<Scoring> scoringList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareScoringBatchCreateArgs(scoringList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchScoringUpdate(List<Scoring> scoringList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareScoringBatchUpdateArgs(scoringList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitScoringList(List<Scoring> scoringList){
		
		List<Scoring> scoringCreateList=new ArrayList<Scoring>();
		List<Scoring> scoringUpdateList=new ArrayList<Scoring>();
		
		for(Scoring scoring: scoringList){
			if(isUpdateRequest(scoring)){
				scoringUpdateList.add( scoring);
				continue;
			}
			scoringCreateList.add(scoring);
		}
		
		return new Object[]{scoringCreateList,scoringUpdateList};
	}
	
	protected boolean isUpdateRequest(Scoring scoring){
 		return scoring.getVersion() > 0;
 	}
 	protected String getSaveScoringSQL(Scoring scoring){
 		if(isUpdateRequest(scoring)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveScoringParameters(Scoring scoring){
 		if(isUpdateRequest(scoring) ){
 			return prepareScoringUpdateParameters(scoring);
 		}
 		return prepareScoringCreateParameters(scoring);
 	}
 	protected Object[] prepareScoringUpdateParameters(Scoring scoring){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = scoring.getScoredBy();
 		parameters[1] = scoring.getScore();
 		parameters[2] = scoring.getComment();		
 		parameters[3] = scoring.getId();
 		parameters[4] = scoring.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareScoringCreateParameters(Scoring scoring){
		Object[] parameters = new Object[4];
		String newScoringId=getNextId();
		scoring.setId(newScoringId);
		parameters[0] =  scoring.getId();
 
 		parameters[1] = scoring.getScoredBy();
 		parameters[2] = scoring.getScore();
 		parameters[3] = scoring.getComment();		
 				
 		return parameters;
 	}
 	
	protected Scoring saveInternalScoring(Scoring scoring, Map<String,Object> options){
		
		saveScoring(scoring);

		
		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
	 		saveEmployeeCompanyTrainingList(scoring, options);
	 		removeEmployeeCompanyTrainingList(scoring, options);
	 		
 		}		
		
		return scoring;
		
	}
	
	
	
	//======================================================================================
	
		
	protected Scoring saveEmployeeCompanyTrainingList(Scoring scoring, Map<String,Object> options){
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			return scoring;
		}
		if(employeeCompanyTrainingList.isEmpty()){
			return scoring;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeCompanyTrainingDAO().saveEmployeeCompanyTrainingList(employeeCompanyTrainingList,options);
		
		return scoring;
	
	}
	
	protected Scoring removeEmployeeCompanyTrainingList(Scoring scoring, Map<String,Object> options){
	
	
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			return scoring;
		}	
	
		SmartList<EmployeeCompanyTraining> toRemoveEmployeeCompanyTrainingList = employeeCompanyTrainingList.getToRemoveList();
		
		if(toRemoveEmployeeCompanyTrainingList == null){
			return scoring;
		}
		if(toRemoveEmployeeCompanyTrainingList.isEmpty()){
			return scoring;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeCompanyTrainingDAO().removeEmployeeCompanyTrainingList(toRemoveEmployeeCompanyTrainingList,options);
		
		return scoring;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Scoring present(Scoring scoring,Map<String, Object> options){
	
		presentEmployeeCompanyTrainingList(scoring,options);

		return scoring;
	
	}
		
	
  	
 	protected Scoring presentEmployeeCompanyTrainingList(
			Scoring scoring,
			Map<String, Object> options) {

		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();		
		if(employeeCompanyTrainingList == null){
			return scoring;			
		}
		
		String targetObjectName = "employeeCompanyTraining";
		int employeeCompanyTrainingListSize = employeeCompanyTrainingList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeCompanyTrainingListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return scoring;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeCompanyTrainingListSize;
		if(employeeCompanyTrainingListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingByScoring(scoring.getId(), options);			
		}
		//scoring.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//scoring.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeCompanyTrainingListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeCompanyTrainingListSize,currentPage,rowsPerPage) ;
			employeeCompanyTrainingList = employeeCompanyTrainingList.subListOf(fromIndex, toIndex);
			employeeCompanyTrainingList.setTotalCount(count);
			employeeCompanyTrainingList.setCurrentPageNumber(currentPage);			
			scoring.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
			return scoring;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeCompanyTrainingList 
			= getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingByScoring(scoring.getId(),start, rowsPerPage, options );
		employeeCompanyTrainingList.setTotalCount(count);
		employeeCompanyTrainingList.setCurrentPageNumber(currentPage);
		scoring.setEmployeeCompanyTrainingList(employeeCompanyTrainingList );	

		return scoring;
	}			
		


	protected String getTableName(){
		return ScoringTable.TABLE_NAME;
	}
}


