
package com.skynet.retailscm.hrinterview;

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

public class HrInterviewJDBCTemplateDAO extends CommonJDBCTemplateDAO implements HrInterviewDAO{

		
	
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
	protected HrInterview load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalHrInterview(accessKey, options);
	}
	*/
	public HrInterview load(String id,Map<String,Object> options) throws Exception{
		return loadInternalHrInterview(HrInterviewTable.withId(id), options);
	}
	
	
	
	public HrInterview save(HrInterview hrInterview,Map<String,Object> options){
		
		String methodName="save(HrInterview hrInterview,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(hrInterview, methodName, "hrInterview");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalHrInterview(hrInterview,options);
	}
	public HrInterview clone(String hrInterviewId, Map<String,Object> options) throws Exception{
	
		return clone(HrInterviewTable.withId(hrInterviewId),options);
	}
	
	protected HrInterview clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String hrInterviewId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		HrInterview newHrInterview = loadInternalHrInterview(accessKey, options);
		newHrInterview.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newHrInterview.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalHrInterview(newHrInterview,options);
		
		return newHrInterview;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String hrInterviewId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{hrInterviewId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new HrInterviewVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new HrInterviewNotFoundException(
					"The " + this.getTableName() + "(" + hrInterviewId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String hrInterviewId, int version) throws Exception{
	
		String methodName="delete(String hrInterviewId, int version)";
		assertMethodArgumentNotNull(hrInterviewId, methodName, "hrInterviewId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{hrInterviewId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(hrInterviewId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","interview_time","comments"};
		return HrInterviewTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "hr_interview";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return HrInterviewTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,HrInterviewTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, HrInterviewTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected HrInterviewMapper getHrInterviewMapper(){
		return new HrInterviewMapper();
	}
	protected HrInterview extractHrInterview(String hrInterviewId) throws Exception{
		String SQL = "select * from hr_interview_data where id = ?";	
		try{
		
			HrInterview hrInterview = queryForObject(SQL, new Object[]{hrInterviewId}, getHrInterviewMapper());
			return hrInterview;
		}catch(EmptyResultDataAccessException e){
			throw new HrInterviewNotFoundException("HrInterview("+hrInterviewId+") is not found!");
		}
		
		
	}
	protected HrInterview extractHrInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from hr_interview_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			HrInterview hrInterview = queryForObject(SQL, new Object[]{accessKey.getValue()}, getHrInterviewMapper());
			return hrInterview;
		}catch(EmptyResultDataAccessException e){
			throw new HrInterviewNotFoundException("HrInterview("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected HrInterview loadInternalHrInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		HrInterview hrInterview = extractHrInterview(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(hrInterview, loadOptions);
 		}		
		
		return hrInterview;
		
	}



	
	
	
		
	protected HrInterview extractEmployeeList(HrInterview hrInterview, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByHrInterview(hrInterview.getId(),options);
		if(employeeList != null){
			hrInterview.setEmployeeList(employeeList);
		}
		
		return hrInterview;
	
	}	
		
		
 	
		
		
		

	

	protected HrInterview saveHrInterview(HrInterview  hrInterview){
	
		String SQL=this.getSaveHrInterviewSQL(hrInterview);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveHrInterviewParameters(hrInterview);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		hrInterview.incVersion();
		return hrInterview;
	
	}
	public SmartList<HrInterview> saveHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitHrInterviewList(hrInterviewList);
		
		batchHrInterviewCreate((List<HrInterview>)lists[CREATE_LIST_INDEX]);
		
		batchHrInterviewUpdate((List<HrInterview>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(HrInterview hrInterview:hrInterviewList){
			if(hrInterview.isChanged()){
				hrInterview.incVersion();
			}
			
		
		}
		
		
		return hrInterviewList;
	}

	public SmartList<HrInterview> removeHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options){
		
		
		super.removeList(hrInterviewList, options);
		
		return hrInterviewList;
		
		
	}
	
	protected List<Object[]> prepareHrInterviewBatchCreateArgs(List<HrInterview> hrInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(HrInterview hrInterview:hrInterviewList ){
			Object [] parameters = prepareHrInterviewCreateParameters(hrInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareHrInterviewBatchUpdateArgs(List<HrInterview> hrInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(HrInterview hrInterview:hrInterviewList ){
			if(!hrInterview.isChanged()){
				continue;
			}
			Object [] parameters = prepareHrInterviewUpdateParameters(hrInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchHrInterviewCreate(List<HrInterview> hrInterviewList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareHrInterviewBatchCreateArgs(hrInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchHrInterviewUpdate(List<HrInterview> hrInterviewList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareHrInterviewBatchUpdateArgs(hrInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitHrInterviewList(List<HrInterview> hrInterviewList){
		
		List<HrInterview> hrInterviewCreateList=new ArrayList<HrInterview>();
		List<HrInterview> hrInterviewUpdateList=new ArrayList<HrInterview>();
		
		for(HrInterview hrInterview: hrInterviewList){
			if(isUpdateRequest(hrInterview)){
				hrInterviewUpdateList.add( hrInterview);
				continue;
			}
			hrInterviewCreateList.add(hrInterview);
		}
		
		return new Object[]{hrInterviewCreateList,hrInterviewUpdateList};
	}
	
	protected boolean isUpdateRequest(HrInterview hrInterview){
 		return hrInterview.getVersion() > 0;
 	}
 	protected String getSaveHrInterviewSQL(HrInterview hrInterview){
 		if(isUpdateRequest(hrInterview)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveHrInterviewParameters(HrInterview hrInterview){
 		if(isUpdateRequest(hrInterview) ){
 			return prepareHrInterviewUpdateParameters(hrInterview);
 		}
 		return prepareHrInterviewCreateParameters(hrInterview);
 	}
 	protected Object[] prepareHrInterviewUpdateParameters(HrInterview hrInterview){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = hrInterview.getWho();
 		parameters[1] = hrInterview.getInterviewTime();
 		parameters[2] = hrInterview.getComments();		
 		parameters[3] = hrInterview.getId();
 		parameters[4] = hrInterview.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareHrInterviewCreateParameters(HrInterview hrInterview){
		Object[] parameters = new Object[4];
		String newHrInterviewId=getNextId();
		hrInterview.setId(newHrInterviewId);
		parameters[0] =  hrInterview.getId();
 
 		parameters[1] = hrInterview.getWho();
 		parameters[2] = hrInterview.getInterviewTime();
 		parameters[3] = hrInterview.getComments();		
 				
 		return parameters;
 	}
 	
	protected HrInterview saveInternalHrInterview(HrInterview hrInterview, Map<String,Object> options){
		
		saveHrInterview(hrInterview);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(hrInterview, options);
	 		removeEmployeeList(hrInterview, options);
	 		
 		}		
		
		return hrInterview;
		
	}
	
	
	
	//======================================================================================
	
		
	protected HrInterview saveEmployeeList(HrInterview hrInterview, Map<String,Object> options){
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();
		if(employeeList == null){
			return hrInterview;
		}
		if(employeeList.isEmpty()){
			return hrInterview;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return hrInterview;
	
	}
	
	protected HrInterview removeEmployeeList(HrInterview hrInterview, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();
		if(employeeList == null){
			return hrInterview;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return hrInterview;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return hrInterview;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return hrInterview;
	
	}
	
	
	
 	
 	
	
	
	
		

	public HrInterview present(HrInterview hrInterview,Map<String, Object> options){
	
		presentEmployeeList(hrInterview,options);

		return hrInterview;
	
	}
		
	
  	
 	protected HrInterview presentEmployeeList(
			HrInterview hrInterview,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = hrInterview.getEmployeeList();		
		if(employeeList == null){
			return hrInterview;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return hrInterview;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByHrInterview(hrInterview.getId(), options);			
		}
		//hrInterview.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//hrInterview.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			hrInterview.setEmployeeList(employeeList);
			return hrInterview;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByHrInterview(hrInterview.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		hrInterview.setEmployeeList(employeeList );	

		return hrInterview;
	}			
		


	protected String getTableName(){
		return HrInterviewTable.TABLE_NAME;
	}
}


