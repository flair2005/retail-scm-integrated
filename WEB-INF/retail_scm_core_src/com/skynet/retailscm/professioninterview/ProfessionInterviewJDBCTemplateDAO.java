
package com.skynet.retailscm.professioninterview;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.employee.EmployeeTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ProfessionInterviewJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ProfessionInterviewDAO{

		
	
  	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO pEmployeeDAO){
 	
 		if(pEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = pEmployeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The employeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeDAO;
 	}	
 	
			
		

	
	/*
	protected ProfessionInterview load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProfessionInterview(accessKey, options);
	}
	*/
	public ProfessionInterview load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProfessionInterview(ProfessionInterviewTable.withId(id), options);
	}
	
	
	
	public ProfessionInterview save(ProfessionInterview professionInterview,Map<String,Object> options){
		
		String methodName="save(ProfessionInterview professionInterview,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(professionInterview, methodName, "professionInterview");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProfessionInterview(professionInterview,options);
	}
	public ProfessionInterview clone(String professionInterviewId, Map<String,Object> options) throws Exception{
	
		return clone(ProfessionInterviewTable.withId(professionInterviewId),options);
	}
	
	protected ProfessionInterview clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String professionInterviewId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ProfessionInterview newProfessionInterview = loadInternalProfessionInterview(accessKey, options);
		newProfessionInterview.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newProfessionInterview.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalProfessionInterview(newProfessionInterview,options);
		
		return newProfessionInterview;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String professionInterviewId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{professionInterviewId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ProfessionInterviewVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProfessionInterviewNotFoundException(
					"The " + this.getTableName() + "(" + professionInterviewId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String professionInterviewId, int version) throws Exception{
	
		String methodName="delete(String professionInterviewId, int version)";
		assertMethodArgumentNotNull(professionInterviewId, methodName, "professionInterviewId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{professionInterviewId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(professionInterviewId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","interview_time","comments"};
		return ProfessionInterviewTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "profession_interview";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProfessionInterviewTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ProfessionInterviewTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfessionInterviewTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected ProfessionInterviewMapper getProfessionInterviewMapper(){
		return new ProfessionInterviewMapper();
	}
	protected ProfessionInterview extractProfessionInterview(String professionInterviewId) throws Exception{
		String SQL = "select * from profession_interview_data where id = ?";	
		try{
		
			ProfessionInterview professionInterview = queryForObject(SQL, new Object[]{professionInterviewId}, getProfessionInterviewMapper());
			return professionInterview;
		}catch(EmptyResultDataAccessException e){
			throw new ProfessionInterviewNotFoundException("ProfessionInterview("+professionInterviewId+") is not found!");
		}
		
		
	}
	protected ProfessionInterview extractProfessionInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from profession_interview_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ProfessionInterview professionInterview = queryForObject(SQL, new Object[]{accessKey.getValue()}, getProfessionInterviewMapper());
			return professionInterview;
		}catch(EmptyResultDataAccessException e){
			throw new ProfessionInterviewNotFoundException("ProfessionInterview("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ProfessionInterview loadInternalProfessionInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ProfessionInterview professionInterview = extractProfessionInterview(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(professionInterview, loadOptions);
 		}		
		
		return professionInterview;
		
	}



	
	
	
		
	protected ProfessionInterview extractEmployeeList(ProfessionInterview professionInterview, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByProfessionInterview(professionInterview.getId(),options);
		if(employeeList != null){
			professionInterview.setEmployeeList(employeeList);
		}
		
		return professionInterview;
	
	}	
		
		
 	
		
		
		

	

	protected ProfessionInterview saveProfessionInterview(ProfessionInterview  professionInterview){
	
		String SQL=this.getSaveProfessionInterviewSQL(professionInterview);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProfessionInterviewParameters(professionInterview);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		professionInterview.incVersion();
		return professionInterview;
	
	}
	public SmartList<ProfessionInterview> saveProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProfessionInterviewList(professionInterviewList);
		
		batchProfessionInterviewCreate((List<ProfessionInterview>)lists[CREATE_LIST_INDEX]);
		
		batchProfessionInterviewUpdate((List<ProfessionInterview>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ProfessionInterview professionInterview:professionInterviewList){
			if(professionInterview.isChanged()){
				professionInterview.incVersion();
			}
			
		
		}
		
		
		return professionInterviewList;
	}

	public SmartList<ProfessionInterview> removeProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options){
		
		
		super.removeList(professionInterviewList, options);
		
		return professionInterviewList;
		
		
	}
	
	protected List<Object[]> prepareProfessionInterviewBatchCreateArgs(List<ProfessionInterview> professionInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProfessionInterview professionInterview:professionInterviewList ){
			Object [] parameters = prepareProfessionInterviewCreateParameters(professionInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProfessionInterviewBatchUpdateArgs(List<ProfessionInterview> professionInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProfessionInterview professionInterview:professionInterviewList ){
			if(!professionInterview.isChanged()){
				continue;
			}
			Object [] parameters = prepareProfessionInterviewUpdateParameters(professionInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProfessionInterviewCreate(List<ProfessionInterview> professionInterviewList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProfessionInterviewBatchCreateArgs(professionInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProfessionInterviewUpdate(List<ProfessionInterview> professionInterviewList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProfessionInterviewBatchUpdateArgs(professionInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProfessionInterviewList(List<ProfessionInterview> professionInterviewList){
		
		List<ProfessionInterview> professionInterviewCreateList=new ArrayList<ProfessionInterview>();
		List<ProfessionInterview> professionInterviewUpdateList=new ArrayList<ProfessionInterview>();
		
		for(ProfessionInterview professionInterview: professionInterviewList){
			if(isUpdateRequest(professionInterview)){
				professionInterviewUpdateList.add( professionInterview);
				continue;
			}
			professionInterviewCreateList.add(professionInterview);
		}
		
		return new Object[]{professionInterviewCreateList,professionInterviewUpdateList};
	}
	
	protected boolean isUpdateRequest(ProfessionInterview professionInterview){
 		return professionInterview.getVersion() > 0;
 	}
 	protected String getSaveProfessionInterviewSQL(ProfessionInterview professionInterview){
 		if(isUpdateRequest(professionInterview)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProfessionInterviewParameters(ProfessionInterview professionInterview){
 		if(isUpdateRequest(professionInterview) ){
 			return prepareProfessionInterviewUpdateParameters(professionInterview);
 		}
 		return prepareProfessionInterviewCreateParameters(professionInterview);
 	}
 	protected Object[] prepareProfessionInterviewUpdateParameters(ProfessionInterview professionInterview){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = professionInterview.getWho();
 		parameters[1] = professionInterview.getInterviewTime();
 		parameters[2] = professionInterview.getComments();		
 		parameters[3] = professionInterview.getId();
 		parameters[4] = professionInterview.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProfessionInterviewCreateParameters(ProfessionInterview professionInterview){
		Object[] parameters = new Object[4];
		String newProfessionInterviewId=getNextId();
		professionInterview.setId(newProfessionInterviewId);
		parameters[0] =  professionInterview.getId();
 
 		parameters[1] = professionInterview.getWho();
 		parameters[2] = professionInterview.getInterviewTime();
 		parameters[3] = professionInterview.getComments();		
 				
 		return parameters;
 	}
 	
	protected ProfessionInterview saveInternalProfessionInterview(ProfessionInterview professionInterview, Map<String,Object> options){
		
		saveProfessionInterview(professionInterview);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(professionInterview, options);
	 		removeEmployeeList(professionInterview, options);
	 		
 		}		
		
		return professionInterview;
		
	}
	
	
	
	//======================================================================================
	
		
	protected ProfessionInterview saveEmployeeList(ProfessionInterview professionInterview, Map<String,Object> options){
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();
		if(employeeList == null){
			return professionInterview;
		}
		if(employeeList.isEmpty()){
			return professionInterview;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return professionInterview;
	
	}
	
	protected ProfessionInterview removeEmployeeList(ProfessionInterview professionInterview, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();
		if(employeeList == null){
			return professionInterview;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return professionInterview;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return professionInterview;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return professionInterview;
	
	}
	
	
	
 	
 	
	
	
	
		

	public ProfessionInterview present(ProfessionInterview professionInterview,Map<String, Object> options){
	
		presentEmployeeList(professionInterview,options);

		return professionInterview;
	
	}
		
	
  	
 	protected ProfessionInterview presentEmployeeList(
			ProfessionInterview professionInterview,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = professionInterview.getEmployeeList();		
		if(employeeList == null){
			return professionInterview;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return professionInterview;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByProfessionInterview(professionInterview.getId(), options);			
		}
		//professionInterview.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//professionInterview.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			professionInterview.setEmployeeList(employeeList);
			return professionInterview;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByProfessionInterview(professionInterview.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		professionInterview.setEmployeeList(employeeList );	

		return professionInterview;
	}			
		


	protected String getTableName(){
		return ProfessionInterviewTable.TABLE_NAME;
	}
}


