
package com.skynet.retailscm.offeracceptance;

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

public class OfferAcceptanceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements OfferAcceptanceDAO{

		
	
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
	protected OfferAcceptance load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOfferAcceptance(accessKey, options);
	}
	*/
	public OfferAcceptance load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOfferAcceptance(OfferAcceptanceTable.withId(id), options);
	}
	
	
	
	public OfferAcceptance save(OfferAcceptance offerAcceptance,Map<String,Object> options){
		
		String methodName="save(OfferAcceptance offerAcceptance,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(offerAcceptance, methodName, "offerAcceptance");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOfferAcceptance(offerAcceptance,options);
	}
	public OfferAcceptance clone(String offerAcceptanceId, Map<String,Object> options) throws Exception{
	
		return clone(OfferAcceptanceTable.withId(offerAcceptanceId),options);
	}
	
	protected OfferAcceptance clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String offerAcceptanceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OfferAcceptance newOfferAcceptance = loadInternalOfferAcceptance(accessKey, options);
		newOfferAcceptance.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newOfferAcceptance.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOfferAcceptance(newOfferAcceptance,options);
		
		return newOfferAcceptance;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String offerAcceptanceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{offerAcceptanceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new OfferAcceptanceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OfferAcceptanceNotFoundException(
					"The " + this.getTableName() + "(" + offerAcceptanceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String offerAcceptanceId, int version) throws Exception{
	
		String methodName="delete(String offerAcceptanceId, int version)";
		assertMethodArgumentNotNull(offerAcceptanceId, methodName, "offerAcceptanceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{offerAcceptanceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(offerAcceptanceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","accept_time","comments"};
		return OfferAcceptanceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "offer_acceptance";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OfferAcceptanceTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OfferAcceptanceTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, OfferAcceptanceTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected OfferAcceptanceMapper getOfferAcceptanceMapper(){
		return new OfferAcceptanceMapper();
	}
	protected OfferAcceptance extractOfferAcceptance(String offerAcceptanceId) throws Exception{
		String SQL = "select * from offer_acceptance_data where id = ?";	
		try{
		
			OfferAcceptance offerAcceptance = queryForObject(SQL, new Object[]{offerAcceptanceId}, getOfferAcceptanceMapper());
			return offerAcceptance;
		}catch(EmptyResultDataAccessException e){
			throw new OfferAcceptanceNotFoundException("OfferAcceptance("+offerAcceptanceId+") is not found!");
		}
		
		
	}
	protected OfferAcceptance extractOfferAcceptance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from offer_acceptance_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			OfferAcceptance offerAcceptance = queryForObject(SQL, new Object[]{accessKey.getValue()}, getOfferAcceptanceMapper());
			return offerAcceptance;
		}catch(EmptyResultDataAccessException e){
			throw new OfferAcceptanceNotFoundException("OfferAcceptance("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected OfferAcceptance loadInternalOfferAcceptance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OfferAcceptance offerAcceptance = extractOfferAcceptance(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(offerAcceptance, loadOptions);
 		}		
		
		return offerAcceptance;
		
	}



	
	
	
		
	protected OfferAcceptance extractEmployeeList(OfferAcceptance offerAcceptance, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByOfferAcceptance(offerAcceptance.getId(),options);
		if(employeeList != null){
			offerAcceptance.setEmployeeList(employeeList);
		}
		
		return offerAcceptance;
	
	}	
		
		
 	
		
		
		

	

	protected OfferAcceptance saveOfferAcceptance(OfferAcceptance  offerAcceptance){
	
		String SQL=this.getSaveOfferAcceptanceSQL(offerAcceptance);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOfferAcceptanceParameters(offerAcceptance);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		offerAcceptance.incVersion();
		return offerAcceptance;
	
	}
	public SmartList<OfferAcceptance> saveOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOfferAcceptanceList(offerAcceptanceList);
		
		batchOfferAcceptanceCreate((List<OfferAcceptance>)lists[CREATE_LIST_INDEX]);
		
		batchOfferAcceptanceUpdate((List<OfferAcceptance>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OfferAcceptance offerAcceptance:offerAcceptanceList){
			if(offerAcceptance.isChanged()){
				offerAcceptance.incVersion();
			}
			
		
		}
		
		
		return offerAcceptanceList;
	}

	public SmartList<OfferAcceptance> removeOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options){
		
		
		super.removeList(offerAcceptanceList, options);
		
		return offerAcceptanceList;
		
		
	}
	
	protected List<Object[]> prepareOfferAcceptanceBatchCreateArgs(List<OfferAcceptance> offerAcceptanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OfferAcceptance offerAcceptance:offerAcceptanceList ){
			Object [] parameters = prepareOfferAcceptanceCreateParameters(offerAcceptance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOfferAcceptanceBatchUpdateArgs(List<OfferAcceptance> offerAcceptanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OfferAcceptance offerAcceptance:offerAcceptanceList ){
			if(!offerAcceptance.isChanged()){
				continue;
			}
			Object [] parameters = prepareOfferAcceptanceUpdateParameters(offerAcceptance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOfferAcceptanceCreate(List<OfferAcceptance> offerAcceptanceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOfferAcceptanceBatchCreateArgs(offerAcceptanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOfferAcceptanceUpdate(List<OfferAcceptance> offerAcceptanceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOfferAcceptanceBatchUpdateArgs(offerAcceptanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOfferAcceptanceList(List<OfferAcceptance> offerAcceptanceList){
		
		List<OfferAcceptance> offerAcceptanceCreateList=new ArrayList<OfferAcceptance>();
		List<OfferAcceptance> offerAcceptanceUpdateList=new ArrayList<OfferAcceptance>();
		
		for(OfferAcceptance offerAcceptance: offerAcceptanceList){
			if(isUpdateRequest(offerAcceptance)){
				offerAcceptanceUpdateList.add( offerAcceptance);
				continue;
			}
			offerAcceptanceCreateList.add(offerAcceptance);
		}
		
		return new Object[]{offerAcceptanceCreateList,offerAcceptanceUpdateList};
	}
	
	protected boolean isUpdateRequest(OfferAcceptance offerAcceptance){
 		return offerAcceptance.getVersion() > 0;
 	}
 	protected String getSaveOfferAcceptanceSQL(OfferAcceptance offerAcceptance){
 		if(isUpdateRequest(offerAcceptance)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOfferAcceptanceParameters(OfferAcceptance offerAcceptance){
 		if(isUpdateRequest(offerAcceptance) ){
 			return prepareOfferAcceptanceUpdateParameters(offerAcceptance);
 		}
 		return prepareOfferAcceptanceCreateParameters(offerAcceptance);
 	}
 	protected Object[] prepareOfferAcceptanceUpdateParameters(OfferAcceptance offerAcceptance){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = offerAcceptance.getWho();
 		parameters[1] = offerAcceptance.getAcceptTime();
 		parameters[2] = offerAcceptance.getComments();		
 		parameters[3] = offerAcceptance.getId();
 		parameters[4] = offerAcceptance.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOfferAcceptanceCreateParameters(OfferAcceptance offerAcceptance){
		Object[] parameters = new Object[4];
		String newOfferAcceptanceId=getNextId();
		offerAcceptance.setId(newOfferAcceptanceId);
		parameters[0] =  offerAcceptance.getId();
 
 		parameters[1] = offerAcceptance.getWho();
 		parameters[2] = offerAcceptance.getAcceptTime();
 		parameters[3] = offerAcceptance.getComments();		
 				
 		return parameters;
 	}
 	
	protected OfferAcceptance saveInternalOfferAcceptance(OfferAcceptance offerAcceptance, Map<String,Object> options){
		
		saveOfferAcceptance(offerAcceptance);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(offerAcceptance, options);
	 		removeEmployeeList(offerAcceptance, options);
	 		
 		}		
		
		return offerAcceptance;
		
	}
	
	
	
	//======================================================================================
	
		
	protected OfferAcceptance saveEmployeeList(OfferAcceptance offerAcceptance, Map<String,Object> options){
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();
		if(employeeList == null){
			return offerAcceptance;
		}
		if(employeeList.isEmpty()){
			return offerAcceptance;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return offerAcceptance;
	
	}
	
	protected OfferAcceptance removeEmployeeList(OfferAcceptance offerAcceptance, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();
		if(employeeList == null){
			return offerAcceptance;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return offerAcceptance;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return offerAcceptance;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return offerAcceptance;
	
	}
	
	
	
 	
 	
	
	
	
		

	public OfferAcceptance present(OfferAcceptance offerAcceptance,Map<String, Object> options){
	
		presentEmployeeList(offerAcceptance,options);

		return offerAcceptance;
	
	}
		
	
  	
 	protected OfferAcceptance presentEmployeeList(
			OfferAcceptance offerAcceptance,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();		
		if(employeeList == null){
			return offerAcceptance;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return offerAcceptance;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByOfferAcceptance(offerAcceptance.getId(), options);			
		}
		//offerAcceptance.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//offerAcceptance.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			offerAcceptance.setEmployeeList(employeeList);
			return offerAcceptance;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByOfferAcceptance(offerAcceptance.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		offerAcceptance.setEmployeeList(employeeList );	

		return offerAcceptance;
	}			
		


	protected String getTableName(){
		return OfferAcceptanceTable.TABLE_NAME;
	}
}


