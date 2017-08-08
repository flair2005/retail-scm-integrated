
package com.skynet.retailscm.termination;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.terminationreason.TerminationReason;
import com.skynet.retailscm.terminationtype.TerminationType;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.terminationreason.TerminationReasonDAO;
import com.skynet.retailscm.terminationtype.TerminationTypeDAO;
import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.terminationtype.TerminationTypeTable;
import com.skynet.retailscm.terminationreason.TerminationReasonTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class TerminationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements TerminationDAO{
 
 	
 	private  TerminationTypeDAO  terminationTypeDAO;
 	public void setTerminationTypeDAO(TerminationTypeDAO terminationTypeDAO){
	 	this.terminationTypeDAO = terminationTypeDAO;
 	}
 	public TerminationTypeDAO getTerminationTypeDAO(){
	 	return this.terminationTypeDAO;
 	}
 
 	
 	private  TerminationReasonDAO  terminationReasonDAO;
 	public void setTerminationReasonDAO(TerminationReasonDAO terminationReasonDAO){
	 	this.terminationReasonDAO = terminationReasonDAO;
 	}
 	public TerminationReasonDAO getTerminationReasonDAO(){
	 	return this.terminationReasonDAO;
 	}

		
	
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
	protected Termination load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTermination(accessKey, options);
	}
	*/
	public Termination load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTermination(TerminationTable.withId(id), options);
	}
	
	
	
	public Termination save(Termination termination,Map<String,Object> options){
		
		String methodName="save(Termination termination,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(termination, methodName, "termination");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTermination(termination,options);
	}
	public Termination clone(String terminationId, Map<String,Object> options) throws Exception{
	
		return clone(TerminationTable.withId(terminationId),options);
	}
	
	protected Termination clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String terminationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Termination newTermination = loadInternalTermination(accessKey, options);
		newTermination.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newTermination.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTermination(newTermination,options);
		
		return newTermination;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String terminationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{terminationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new TerminationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TerminationNotFoundException(
					"The " + this.getTableName() + "(" + terminationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String terminationId, int version) throws Exception{
	
		String methodName="delete(String terminationId, int version)";
		assertMethodArgumentNotNull(terminationId, methodName, "terminationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{terminationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(terminationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"reason","type","comment"};
		return TerminationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "termination";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TerminationTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractReasonEnabled = true;
 	//private static final String REASON = "reason";
 	protected boolean isExtractReasonEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TerminationTokens.REASON);
 	}
 	
 	
 	//private boolean saveReasonEnabled = true;
 	protected boolean isSaveReasonEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TerminationTokens.REASON);
 	}
 	

 	
  
 	//private boolean extractTypeEnabled = true;
 	//private static final String TYPE = "type";
 	protected boolean isExtractTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TerminationTokens.TYPE);
 	}
 	
 	
 	//private boolean saveTypeEnabled = true;
 	protected boolean isSaveTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TerminationTokens.TYPE);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TerminationTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, TerminationTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected TerminationMapper getTerminationMapper(){
		return new TerminationMapper();
	}
	protected Termination extractTermination(String terminationId) throws Exception{
		String SQL = "select * from termination_data where id = ?";	
		try{
		
			Termination termination = queryForObject(SQL, new Object[]{terminationId}, getTerminationMapper());
			return termination;
		}catch(EmptyResultDataAccessException e){
			throw new TerminationNotFoundException("Termination("+terminationId+") is not found!");
		}
		
		
	}
	protected Termination extractTermination(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from termination_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Termination termination = queryForObject(SQL, new Object[]{accessKey.getValue()}, getTerminationMapper());
			return termination;
		}catch(EmptyResultDataAccessException e){
			throw new TerminationNotFoundException("Termination("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Termination loadInternalTermination(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Termination termination = extractTermination(accessKey, loadOptions);
 	
 		if(isExtractReasonEnabled(loadOptions)){
	 		extractReason(termination, loadOptions);
 		}
  	
 		if(isExtractTypeEnabled(loadOptions)){
	 		extractType(termination, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(termination, loadOptions);
 		}		
		
		return termination;
		
	}



	
	
	 

 	protected Termination extractReason(Termination termination, Map<String,Object> options) throws Exception{

		if(termination.getReason() == null){
			return termination;
		}
		String reasonId = termination.getReason().getId();
		if( reasonId == null){
			return termination;
		}
		TerminationReason reason = getTerminationReasonDAO().load(reasonId,options);
		if(reason != null){
			termination.setReason(reason);
		}
		
 		
 		return termination;
 	}
 		
  

 	protected Termination extractType(Termination termination, Map<String,Object> options) throws Exception{

		if(termination.getType() == null){
			return termination;
		}
		String typeId = termination.getType().getId();
		if( typeId == null){
			return termination;
		}
		TerminationType type = getTerminationTypeDAO().load(typeId,options);
		if(type != null){
			termination.setType(type);
		}
		
 		
 		return termination;
 	}
 		
 
		
	protected Termination extractEmployeeList(Termination termination, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByTermination(termination.getId(),options);
		if(employeeList != null){
			termination.setEmployeeList(employeeList);
		}
		
		return termination;
	
	}	
		
		
  	
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where reason = ?";
		SmartList<Termination> terminationList = queryForList(SQL, new Object[]{terminationReasonId}, getTerminationMapper());	
 		return terminationList;
 	}
 	
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where reason = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Termination> terminationList = queryForList(SQL, new Object[]{terminationReasonId,start, count}, getTerminationMapper());
		
 		return terminationList;
 	}
 	
 	public int countTerminationByReason(String terminationReasonId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where reason = ?";
		Integer count = queryInt(SQL, new Object[]{terminationReasonId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Termination> findTerminationByType(String terminationTypeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where type = ?";
		SmartList<Termination> terminationList = queryForList(SQL, new Object[]{terminationTypeId}, getTerminationMapper());	
 		return terminationList;
 	}
 	
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where type = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Termination> terminationList = queryForList(SQL, new Object[]{terminationTypeId,start, count}, getTerminationMapper());
		
 		return terminationList;
 	}
 	
 	public int countTerminationByType(String terminationTypeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where type = ?";
		Integer count = queryInt(SQL, new Object[]{terminationTypeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected Termination saveTermination(Termination  termination){
	
		String SQL=this.getSaveTerminationSQL(termination);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTerminationParameters(termination);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		termination.incVersion();
		return termination;
	
	}
	public SmartList<Termination> saveTerminationList(SmartList<Termination> terminationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTerminationList(terminationList);
		
		batchTerminationCreate((List<Termination>)lists[CREATE_LIST_INDEX]);
		
		batchTerminationUpdate((List<Termination>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Termination termination:terminationList){
			if(termination.isChanged()){
				termination.incVersion();
			}
			
		
		}
		
		
		return terminationList;
	}

	public SmartList<Termination> removeTerminationList(SmartList<Termination> terminationList,Map<String,Object> options){
		
		
		super.removeList(terminationList, options);
		
		return terminationList;
		
		
	}
	
	protected List<Object[]> prepareTerminationBatchCreateArgs(List<Termination> terminationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Termination termination:terminationList ){
			Object [] parameters = prepareTerminationCreateParameters(termination);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTerminationBatchUpdateArgs(List<Termination> terminationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Termination termination:terminationList ){
			if(!termination.isChanged()){
				continue;
			}
			Object [] parameters = prepareTerminationUpdateParameters(termination);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTerminationCreate(List<Termination> terminationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTerminationBatchCreateArgs(terminationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTerminationUpdate(List<Termination> terminationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTerminationBatchUpdateArgs(terminationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTerminationList(List<Termination> terminationList){
		
		List<Termination> terminationCreateList=new ArrayList<Termination>();
		List<Termination> terminationUpdateList=new ArrayList<Termination>();
		
		for(Termination termination: terminationList){
			if(isUpdateRequest(termination)){
				terminationUpdateList.add( termination);
				continue;
			}
			terminationCreateList.add(termination);
		}
		
		return new Object[]{terminationCreateList,terminationUpdateList};
	}
	
	protected boolean isUpdateRequest(Termination termination){
 		return termination.getVersion() > 0;
 	}
 	protected String getSaveTerminationSQL(Termination termination){
 		if(isUpdateRequest(termination)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTerminationParameters(Termination termination){
 		if(isUpdateRequest(termination) ){
 			return prepareTerminationUpdateParameters(termination);
 		}
 		return prepareTerminationCreateParameters(termination);
 	}
 	protected Object[] prepareTerminationUpdateParameters(Termination termination){
 		Object[] parameters = new Object[5];
  	
 		if(termination.getReason() != null){
 			parameters[0] = termination.getReason().getId();
 		}
  	
 		if(termination.getType() != null){
 			parameters[1] = termination.getType().getId();
 		}
 
 		parameters[2] = termination.getComment();		
 		parameters[3] = termination.getId();
 		parameters[4] = termination.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTerminationCreateParameters(Termination termination){
		Object[] parameters = new Object[4];
		String newTerminationId=getNextId();
		termination.setId(newTerminationId);
		parameters[0] =  termination.getId();
  	
 		if(termination.getReason() != null){
 			parameters[1] = termination.getReason().getId();
 		
 		}
 		 	
 		if(termination.getType() != null){
 			parameters[2] = termination.getType().getId();
 		
 		}
 		
 		parameters[3] = termination.getComment();		
 				
 		return parameters;
 	}
 	
	protected Termination saveInternalTermination(Termination termination, Map<String,Object> options){
		
		saveTermination(termination);
 	
 		if(isSaveReasonEnabled(options)){
	 		saveReason(termination, options);
 		}
  	
 		if(isSaveTypeEnabled(options)){
	 		saveType(termination, options);
 		}
 
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(termination, options);
	 		removeEmployeeList(termination, options);
	 		
 		}		
		
		return termination;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Termination saveReason(Termination termination, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(termination.getReason() == null){
 			return termination;//do nothing when it is null
 		}
 		
 		getTerminationReasonDAO().save(termination.getReason(),options);
 		return termination;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Termination saveType(Termination termination, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(termination.getType() == null){
 			return termination;//do nothing when it is null
 		}
 		
 		getTerminationTypeDAO().save(termination.getType(),options);
 		return termination;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected Termination saveEmployeeList(Termination termination, Map<String,Object> options){
		SmartList<Employee> employeeList = termination.getEmployeeList();
		if(employeeList == null){
			return termination;
		}
		if(employeeList.isEmpty()){
			return termination;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return termination;
	
	}
	
	protected Termination removeEmployeeList(Termination termination, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = termination.getEmployeeList();
		if(employeeList == null){
			return termination;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return termination;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return termination;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return termination;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Termination present(Termination termination,Map<String, Object> options){
	
		presentEmployeeList(termination,options);

		return termination;
	
	}
		
	
  	
 	protected Termination presentEmployeeList(
			Termination termination,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = termination.getEmployeeList();		
		if(employeeList == null){
			return termination;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return termination;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByTermination(termination.getId(), options);			
		}
		//termination.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//termination.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			termination.setEmployeeList(employeeList);
			return termination;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByTermination(termination.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		termination.setEmployeeList(employeeList );	

		return termination;
	}			
		


	protected String getTableName(){
		return TerminationTable.TABLE_NAME;
	}
}


