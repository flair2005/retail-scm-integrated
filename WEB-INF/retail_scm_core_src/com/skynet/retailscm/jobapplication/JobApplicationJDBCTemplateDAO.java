
package com.skynet.retailscm.jobapplication;

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

public class JobApplicationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements JobApplicationDAO{

		
	
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
	protected JobApplication load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalJobApplication(accessKey, options);
	}
	*/
	public JobApplication load(String id,Map<String,Object> options) throws Exception{
		return loadInternalJobApplication(JobApplicationTable.withId(id), options);
	}
	
	
	
	public JobApplication save(JobApplication jobApplication,Map<String,Object> options){
		
		String methodName="save(JobApplication jobApplication,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(jobApplication, methodName, "jobApplication");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalJobApplication(jobApplication,options);
	}
	public JobApplication clone(String jobApplicationId, Map<String,Object> options) throws Exception{
	
		return clone(JobApplicationTable.withId(jobApplicationId),options);
	}
	
	protected JobApplication clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String jobApplicationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		JobApplication newJobApplication = loadInternalJobApplication(accessKey, options);
		newJobApplication.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newJobApplication.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalJobApplication(newJobApplication,options);
		
		return newJobApplication;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String jobApplicationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{jobApplicationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new JobApplicationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new JobApplicationNotFoundException(
					"The " + this.getTableName() + "(" + jobApplicationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String jobApplicationId, int version) throws Exception{
	
		String methodName="delete(String jobApplicationId, int version)";
		assertMethodArgumentNotNull(jobApplicationId, methodName, "jobApplicationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{jobApplicationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(jobApplicationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"application_time","who","comments"};
		return JobApplicationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "job_application";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return JobApplicationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,JobApplicationTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, JobApplicationTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected JobApplicationMapper getJobApplicationMapper(){
		return new JobApplicationMapper();
	}
	protected JobApplication extractJobApplication(String jobApplicationId) throws Exception{
		String SQL = "select * from job_application_data where id = ?";	
		try{
		
			JobApplication jobApplication = queryForObject(SQL, new Object[]{jobApplicationId}, getJobApplicationMapper());
			return jobApplication;
		}catch(EmptyResultDataAccessException e){
			throw new JobApplicationNotFoundException("JobApplication("+jobApplicationId+") is not found!");
		}
		
		
	}
	protected JobApplication extractJobApplication(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from job_application_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			JobApplication jobApplication = queryForObject(SQL, new Object[]{accessKey.getValue()}, getJobApplicationMapper());
			return jobApplication;
		}catch(EmptyResultDataAccessException e){
			throw new JobApplicationNotFoundException("JobApplication("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected JobApplication loadInternalJobApplication(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		JobApplication jobApplication = extractJobApplication(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(jobApplication, loadOptions);
 		}		
		
		return jobApplication;
		
	}



	
	
	
		
	protected JobApplication extractEmployeeList(JobApplication jobApplication, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByJobApplication(jobApplication.getId(),options);
		if(employeeList != null){
			jobApplication.setEmployeeList(employeeList);
		}
		
		return jobApplication;
	
	}	
		
		
 	
		
		
		

	

	protected JobApplication saveJobApplication(JobApplication  jobApplication){
	
		String SQL=this.getSaveJobApplicationSQL(jobApplication);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveJobApplicationParameters(jobApplication);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		jobApplication.incVersion();
		return jobApplication;
	
	}
	public SmartList<JobApplication> saveJobApplicationList(SmartList<JobApplication> jobApplicationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitJobApplicationList(jobApplicationList);
		
		batchJobApplicationCreate((List<JobApplication>)lists[CREATE_LIST_INDEX]);
		
		batchJobApplicationUpdate((List<JobApplication>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(JobApplication jobApplication:jobApplicationList){
			if(jobApplication.isChanged()){
				jobApplication.incVersion();
			}
			
		
		}
		
		
		return jobApplicationList;
	}

	public SmartList<JobApplication> removeJobApplicationList(SmartList<JobApplication> jobApplicationList,Map<String,Object> options){
		
		
		super.removeList(jobApplicationList, options);
		
		return jobApplicationList;
		
		
	}
	
	protected List<Object[]> prepareJobApplicationBatchCreateArgs(List<JobApplication> jobApplicationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(JobApplication jobApplication:jobApplicationList ){
			Object [] parameters = prepareJobApplicationCreateParameters(jobApplication);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareJobApplicationBatchUpdateArgs(List<JobApplication> jobApplicationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(JobApplication jobApplication:jobApplicationList ){
			if(!jobApplication.isChanged()){
				continue;
			}
			Object [] parameters = prepareJobApplicationUpdateParameters(jobApplication);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchJobApplicationCreate(List<JobApplication> jobApplicationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareJobApplicationBatchCreateArgs(jobApplicationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchJobApplicationUpdate(List<JobApplication> jobApplicationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareJobApplicationBatchUpdateArgs(jobApplicationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitJobApplicationList(List<JobApplication> jobApplicationList){
		
		List<JobApplication> jobApplicationCreateList=new ArrayList<JobApplication>();
		List<JobApplication> jobApplicationUpdateList=new ArrayList<JobApplication>();
		
		for(JobApplication jobApplication: jobApplicationList){
			if(isUpdateRequest(jobApplication)){
				jobApplicationUpdateList.add( jobApplication);
				continue;
			}
			jobApplicationCreateList.add(jobApplication);
		}
		
		return new Object[]{jobApplicationCreateList,jobApplicationUpdateList};
	}
	
	protected boolean isUpdateRequest(JobApplication jobApplication){
 		return jobApplication.getVersion() > 0;
 	}
 	protected String getSaveJobApplicationSQL(JobApplication jobApplication){
 		if(isUpdateRequest(jobApplication)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveJobApplicationParameters(JobApplication jobApplication){
 		if(isUpdateRequest(jobApplication) ){
 			return prepareJobApplicationUpdateParameters(jobApplication);
 		}
 		return prepareJobApplicationCreateParameters(jobApplication);
 	}
 	protected Object[] prepareJobApplicationUpdateParameters(JobApplication jobApplication){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = jobApplication.getApplicationTime();
 		parameters[1] = jobApplication.getWho();
 		parameters[2] = jobApplication.getComments();		
 		parameters[3] = jobApplication.getId();
 		parameters[4] = jobApplication.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareJobApplicationCreateParameters(JobApplication jobApplication){
		Object[] parameters = new Object[4];
		String newJobApplicationId=getNextId();
		jobApplication.setId(newJobApplicationId);
		parameters[0] =  jobApplication.getId();
 
 		parameters[1] = jobApplication.getApplicationTime();
 		parameters[2] = jobApplication.getWho();
 		parameters[3] = jobApplication.getComments();		
 				
 		return parameters;
 	}
 	
	protected JobApplication saveInternalJobApplication(JobApplication jobApplication, Map<String,Object> options){
		
		saveJobApplication(jobApplication);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(jobApplication, options);
	 		removeEmployeeList(jobApplication, options);
	 		
 		}		
		
		return jobApplication;
		
	}
	
	
	
	//======================================================================================
	
		
	protected JobApplication saveEmployeeList(JobApplication jobApplication, Map<String,Object> options){
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();
		if(employeeList == null){
			return jobApplication;
		}
		if(employeeList.isEmpty()){
			return jobApplication;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return jobApplication;
	
	}
	
	protected JobApplication removeEmployeeList(JobApplication jobApplication, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();
		if(employeeList == null){
			return jobApplication;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return jobApplication;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return jobApplication;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return jobApplication;
	
	}
	
	
	
 	
 	
	
	
	
		

	public JobApplication present(JobApplication jobApplication,Map<String, Object> options){
	
		presentEmployeeList(jobApplication,options);

		return jobApplication;
	
	}
		
	
  	
 	protected JobApplication presentEmployeeList(
			JobApplication jobApplication,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = jobApplication.getEmployeeList();		
		if(employeeList == null){
			return jobApplication;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return jobApplication;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByJobApplication(jobApplication.getId(), options);			
		}
		//jobApplication.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//jobApplication.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			jobApplication.setEmployeeList(employeeList);
			return jobApplication;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByJobApplication(jobApplication.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		jobApplication.setEmployeeList(employeeList );	

		return jobApplication;
	}			
		


	protected String getTableName(){
		return JobApplicationTable.TABLE_NAME;
	}
}


