
package com.skynet.retailscm.offerapproval;

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

public class OfferApprovalJDBCTemplateDAO extends CommonJDBCTemplateDAO implements OfferApprovalDAO{

		
	
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
	protected OfferApproval load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOfferApproval(accessKey, options);
	}
	*/
	public OfferApproval load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOfferApproval(OfferApprovalTable.withId(id), options);
	}
	
	
	
	public OfferApproval save(OfferApproval offerApproval,Map<String,Object> options){
		
		String methodName="save(OfferApproval offerApproval,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(offerApproval, methodName, "offerApproval");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOfferApproval(offerApproval,options);
	}
	public OfferApproval clone(String offerApprovalId, Map<String,Object> options) throws Exception{
	
		return clone(OfferApprovalTable.withId(offerApprovalId),options);
	}
	
	protected OfferApproval clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String offerApprovalId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OfferApproval newOfferApproval = loadInternalOfferApproval(accessKey, options);
		newOfferApproval.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newOfferApproval.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOfferApproval(newOfferApproval,options);
		
		return newOfferApproval;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String offerApprovalId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{offerApprovalId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new OfferApprovalVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OfferApprovalNotFoundException(
					"The " + this.getTableName() + "(" + offerApprovalId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String offerApprovalId, int version) throws Exception{
	
		String methodName="delete(String offerApprovalId, int version)";
		assertMethodArgumentNotNull(offerApprovalId, methodName, "offerApprovalId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{offerApprovalId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(offerApprovalId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","approve_time","comments"};
		return OfferApprovalTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "offer_approval";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OfferApprovalTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OfferApprovalTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, OfferApprovalTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected OfferApprovalMapper getOfferApprovalMapper(){
		return new OfferApprovalMapper();
	}
	protected OfferApproval extractOfferApproval(String offerApprovalId) throws Exception{
		String SQL = "select * from offer_approval_data where id = ?";	
		try{
		
			OfferApproval offerApproval = queryForObject(SQL, new Object[]{offerApprovalId}, getOfferApprovalMapper());
			return offerApproval;
		}catch(EmptyResultDataAccessException e){
			throw new OfferApprovalNotFoundException("OfferApproval("+offerApprovalId+") is not found!");
		}
		
		
	}
	protected OfferApproval extractOfferApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from offer_approval_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			OfferApproval offerApproval = queryForObject(SQL, new Object[]{accessKey.getValue()}, getOfferApprovalMapper());
			return offerApproval;
		}catch(EmptyResultDataAccessException e){
			throw new OfferApprovalNotFoundException("OfferApproval("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected OfferApproval loadInternalOfferApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OfferApproval offerApproval = extractOfferApproval(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(offerApproval, loadOptions);
 		}		
		
		return offerApproval;
		
	}



	
	
	
		
	protected OfferApproval extractEmployeeList(OfferApproval offerApproval, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByOfferApproval(offerApproval.getId(),options);
		if(employeeList != null){
			offerApproval.setEmployeeList(employeeList);
		}
		
		return offerApproval;
	
	}	
		
		
 	
		
		
		

	

	protected OfferApproval saveOfferApproval(OfferApproval  offerApproval){
	
		String SQL=this.getSaveOfferApprovalSQL(offerApproval);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOfferApprovalParameters(offerApproval);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		offerApproval.incVersion();
		return offerApproval;
	
	}
	public SmartList<OfferApproval> saveOfferApprovalList(SmartList<OfferApproval> offerApprovalList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOfferApprovalList(offerApprovalList);
		
		batchOfferApprovalCreate((List<OfferApproval>)lists[CREATE_LIST_INDEX]);
		
		batchOfferApprovalUpdate((List<OfferApproval>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OfferApproval offerApproval:offerApprovalList){
			if(offerApproval.isChanged()){
				offerApproval.incVersion();
			}
			
		
		}
		
		
		return offerApprovalList;
	}

	public SmartList<OfferApproval> removeOfferApprovalList(SmartList<OfferApproval> offerApprovalList,Map<String,Object> options){
		
		
		super.removeList(offerApprovalList, options);
		
		return offerApprovalList;
		
		
	}
	
	protected List<Object[]> prepareOfferApprovalBatchCreateArgs(List<OfferApproval> offerApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OfferApproval offerApproval:offerApprovalList ){
			Object [] parameters = prepareOfferApprovalCreateParameters(offerApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOfferApprovalBatchUpdateArgs(List<OfferApproval> offerApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OfferApproval offerApproval:offerApprovalList ){
			if(!offerApproval.isChanged()){
				continue;
			}
			Object [] parameters = prepareOfferApprovalUpdateParameters(offerApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOfferApprovalCreate(List<OfferApproval> offerApprovalList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOfferApprovalBatchCreateArgs(offerApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOfferApprovalUpdate(List<OfferApproval> offerApprovalList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOfferApprovalBatchUpdateArgs(offerApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOfferApprovalList(List<OfferApproval> offerApprovalList){
		
		List<OfferApproval> offerApprovalCreateList=new ArrayList<OfferApproval>();
		List<OfferApproval> offerApprovalUpdateList=new ArrayList<OfferApproval>();
		
		for(OfferApproval offerApproval: offerApprovalList){
			if(isUpdateRequest(offerApproval)){
				offerApprovalUpdateList.add( offerApproval);
				continue;
			}
			offerApprovalCreateList.add(offerApproval);
		}
		
		return new Object[]{offerApprovalCreateList,offerApprovalUpdateList};
	}
	
	protected boolean isUpdateRequest(OfferApproval offerApproval){
 		return offerApproval.getVersion() > 0;
 	}
 	protected String getSaveOfferApprovalSQL(OfferApproval offerApproval){
 		if(isUpdateRequest(offerApproval)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOfferApprovalParameters(OfferApproval offerApproval){
 		if(isUpdateRequest(offerApproval) ){
 			return prepareOfferApprovalUpdateParameters(offerApproval);
 		}
 		return prepareOfferApprovalCreateParameters(offerApproval);
 	}
 	protected Object[] prepareOfferApprovalUpdateParameters(OfferApproval offerApproval){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = offerApproval.getWho();
 		parameters[1] = offerApproval.getApproveTime();
 		parameters[2] = offerApproval.getComments();		
 		parameters[3] = offerApproval.getId();
 		parameters[4] = offerApproval.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOfferApprovalCreateParameters(OfferApproval offerApproval){
		Object[] parameters = new Object[4];
		String newOfferApprovalId=getNextId();
		offerApproval.setId(newOfferApprovalId);
		parameters[0] =  offerApproval.getId();
 
 		parameters[1] = offerApproval.getWho();
 		parameters[2] = offerApproval.getApproveTime();
 		parameters[3] = offerApproval.getComments();		
 				
 		return parameters;
 	}
 	
	protected OfferApproval saveInternalOfferApproval(OfferApproval offerApproval, Map<String,Object> options){
		
		saveOfferApproval(offerApproval);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(offerApproval, options);
	 		removeEmployeeList(offerApproval, options);
	 		
 		}		
		
		return offerApproval;
		
	}
	
	
	
	//======================================================================================
	
		
	protected OfferApproval saveEmployeeList(OfferApproval offerApproval, Map<String,Object> options){
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();
		if(employeeList == null){
			return offerApproval;
		}
		if(employeeList.isEmpty()){
			return offerApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return offerApproval;
	
	}
	
	protected OfferApproval removeEmployeeList(OfferApproval offerApproval, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();
		if(employeeList == null){
			return offerApproval;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return offerApproval;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return offerApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return offerApproval;
	
	}
	
	
	
 	
 	
	
	
	
		

	public OfferApproval present(OfferApproval offerApproval,Map<String, Object> options){
	
		presentEmployeeList(offerApproval,options);

		return offerApproval;
	
	}
		
	
  	
 	protected OfferApproval presentEmployeeList(
			OfferApproval offerApproval,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = offerApproval.getEmployeeList();		
		if(employeeList == null){
			return offerApproval;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return offerApproval;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByOfferApproval(offerApproval.getId(), options);			
		}
		//offerApproval.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//offerApproval.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			offerApproval.setEmployeeList(employeeList);
			return offerApproval;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByOfferApproval(offerApproval.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		offerApproval.setEmployeeList(employeeList );	

		return offerApproval;
	}			
		


	protected String getTableName(){
		return OfferApprovalTable.TABLE_NAME;
	}
}


