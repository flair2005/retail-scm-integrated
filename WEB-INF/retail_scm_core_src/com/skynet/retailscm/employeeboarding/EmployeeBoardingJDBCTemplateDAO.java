
package com.skynet.retailscm.employeeboarding;

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

public class EmployeeBoardingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeBoardingDAO{

		
	
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
	protected EmployeeBoarding load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeBoarding(accessKey, options);
	}
	*/
	public EmployeeBoarding load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeBoarding(EmployeeBoardingTable.withId(id), options);
	}
	
	
	
	public EmployeeBoarding save(EmployeeBoarding employeeBoarding,Map<String,Object> options){
		
		String methodName="save(EmployeeBoarding employeeBoarding,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeBoarding, methodName, "employeeBoarding");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeBoarding(employeeBoarding,options);
	}
	public EmployeeBoarding clone(String employeeBoardingId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeBoardingTable.withId(employeeBoardingId),options);
	}
	
	protected EmployeeBoarding clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeBoardingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeBoarding newEmployeeBoarding = loadInternalEmployeeBoarding(accessKey, options);
		newEmployeeBoarding.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newEmployeeBoarding.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalEmployeeBoarding(newEmployeeBoarding,options);
		
		return newEmployeeBoarding;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeBoardingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeBoardingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeBoardingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeBoardingNotFoundException(
					"The " + this.getTableName() + "(" + employeeBoardingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeBoardingId, int version) throws Exception{
	
		String methodName="delete(String employeeBoardingId, int version)";
		assertMethodArgumentNotNull(employeeBoardingId, methodName, "employeeBoardingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeBoardingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeBoardingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","employ_time","comments"};
		return EmployeeBoardingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_boarding";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeBoardingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeBoardingTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeBoardingTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected EmployeeBoardingMapper getEmployeeBoardingMapper(){
		return new EmployeeBoardingMapper();
	}
	protected EmployeeBoarding extractEmployeeBoarding(String employeeBoardingId) throws Exception{
		String SQL = "select * from employee_boarding_data where id = ?";	
		try{
		
			EmployeeBoarding employeeBoarding = queryForObject(SQL, new Object[]{employeeBoardingId}, getEmployeeBoardingMapper());
			return employeeBoarding;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeBoardingNotFoundException("EmployeeBoarding("+employeeBoardingId+") is not found!");
		}
		
		
	}
	protected EmployeeBoarding extractEmployeeBoarding(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_boarding_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeBoarding employeeBoarding = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeBoardingMapper());
			return employeeBoarding;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeBoardingNotFoundException("EmployeeBoarding("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeBoarding loadInternalEmployeeBoarding(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeBoarding employeeBoarding = extractEmployeeBoarding(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(employeeBoarding, loadOptions);
 		}		
		
		return employeeBoarding;
		
	}



	
	
	
		
	protected EmployeeBoarding extractEmployeeList(EmployeeBoarding employeeBoarding, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByEmployeeBoarding(employeeBoarding.getId(),options);
		if(employeeList != null){
			employeeBoarding.setEmployeeList(employeeList);
		}
		
		return employeeBoarding;
	
	}	
		
		
 	
		
		
		

	

	protected EmployeeBoarding saveEmployeeBoarding(EmployeeBoarding  employeeBoarding){
	
		String SQL=this.getSaveEmployeeBoardingSQL(employeeBoarding);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeBoardingParameters(employeeBoarding);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeBoarding.incVersion();
		return employeeBoarding;
	
	}
	public SmartList<EmployeeBoarding> saveEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeBoardingList(employeeBoardingList);
		
		batchEmployeeBoardingCreate((List<EmployeeBoarding>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeBoardingUpdate((List<EmployeeBoarding>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeBoarding employeeBoarding:employeeBoardingList){
			if(employeeBoarding.isChanged()){
				employeeBoarding.incVersion();
			}
			
		
		}
		
		
		return employeeBoardingList;
	}

	public SmartList<EmployeeBoarding> removeEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options){
		
		
		super.removeList(employeeBoardingList, options);
		
		return employeeBoardingList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeBoardingBatchCreateArgs(List<EmployeeBoarding> employeeBoardingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeBoarding employeeBoarding:employeeBoardingList ){
			Object [] parameters = prepareEmployeeBoardingCreateParameters(employeeBoarding);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeBoardingBatchUpdateArgs(List<EmployeeBoarding> employeeBoardingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeBoarding employeeBoarding:employeeBoardingList ){
			if(!employeeBoarding.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeBoardingUpdateParameters(employeeBoarding);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeBoardingCreate(List<EmployeeBoarding> employeeBoardingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeBoardingBatchCreateArgs(employeeBoardingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeBoardingUpdate(List<EmployeeBoarding> employeeBoardingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeBoardingBatchUpdateArgs(employeeBoardingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeBoardingList(List<EmployeeBoarding> employeeBoardingList){
		
		List<EmployeeBoarding> employeeBoardingCreateList=new ArrayList<EmployeeBoarding>();
		List<EmployeeBoarding> employeeBoardingUpdateList=new ArrayList<EmployeeBoarding>();
		
		for(EmployeeBoarding employeeBoarding: employeeBoardingList){
			if(isUpdateRequest(employeeBoarding)){
				employeeBoardingUpdateList.add( employeeBoarding);
				continue;
			}
			employeeBoardingCreateList.add(employeeBoarding);
		}
		
		return new Object[]{employeeBoardingCreateList,employeeBoardingUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeBoarding employeeBoarding){
 		return employeeBoarding.getVersion() > 0;
 	}
 	protected String getSaveEmployeeBoardingSQL(EmployeeBoarding employeeBoarding){
 		if(isUpdateRequest(employeeBoarding)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeBoardingParameters(EmployeeBoarding employeeBoarding){
 		if(isUpdateRequest(employeeBoarding) ){
 			return prepareEmployeeBoardingUpdateParameters(employeeBoarding);
 		}
 		return prepareEmployeeBoardingCreateParameters(employeeBoarding);
 	}
 	protected Object[] prepareEmployeeBoardingUpdateParameters(EmployeeBoarding employeeBoarding){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = employeeBoarding.getWho();
 		parameters[1] = employeeBoarding.getEmployTime();
 		parameters[2] = employeeBoarding.getComments();		
 		parameters[3] = employeeBoarding.getId();
 		parameters[4] = employeeBoarding.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeBoardingCreateParameters(EmployeeBoarding employeeBoarding){
		Object[] parameters = new Object[4];
		String newEmployeeBoardingId=getNextId();
		employeeBoarding.setId(newEmployeeBoardingId);
		parameters[0] =  employeeBoarding.getId();
 
 		parameters[1] = employeeBoarding.getWho();
 		parameters[2] = employeeBoarding.getEmployTime();
 		parameters[3] = employeeBoarding.getComments();		
 				
 		return parameters;
 	}
 	
	protected EmployeeBoarding saveInternalEmployeeBoarding(EmployeeBoarding employeeBoarding, Map<String,Object> options){
		
		saveEmployeeBoarding(employeeBoarding);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(employeeBoarding, options);
	 		removeEmployeeList(employeeBoarding, options);
	 		
 		}		
		
		return employeeBoarding;
		
	}
	
	
	
	//======================================================================================
	
		
	protected EmployeeBoarding saveEmployeeList(EmployeeBoarding employeeBoarding, Map<String,Object> options){
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();
		if(employeeList == null){
			return employeeBoarding;
		}
		if(employeeList.isEmpty()){
			return employeeBoarding;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return employeeBoarding;
	
	}
	
	protected EmployeeBoarding removeEmployeeList(EmployeeBoarding employeeBoarding, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();
		if(employeeList == null){
			return employeeBoarding;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return employeeBoarding;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return employeeBoarding;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return employeeBoarding;
	
	}
	
	
	
 	
 	
	
	
	
		

	public EmployeeBoarding present(EmployeeBoarding employeeBoarding,Map<String, Object> options){
	
		presentEmployeeList(employeeBoarding,options);

		return employeeBoarding;
	
	}
		
	
  	
 	protected EmployeeBoarding presentEmployeeList(
			EmployeeBoarding employeeBoarding,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();		
		if(employeeList == null){
			return employeeBoarding;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employeeBoarding;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByEmployeeBoarding(employeeBoarding.getId(), options);			
		}
		//employeeBoarding.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employeeBoarding.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			employeeBoarding.setEmployeeList(employeeList);
			return employeeBoarding;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByEmployeeBoarding(employeeBoarding.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		employeeBoarding.setEmployeeList(employeeList );	

		return employeeBoarding;
	}			
		


	protected String getTableName(){
		return EmployeeBoardingTable.TABLE_NAME;
	}
}


