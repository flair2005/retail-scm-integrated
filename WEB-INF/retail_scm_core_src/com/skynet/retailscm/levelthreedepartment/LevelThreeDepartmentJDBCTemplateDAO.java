
package com.skynet.retailscm.levelthreedepartment;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartmentDAO;
import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartmentTable;
import com.skynet.retailscm.employee.EmployeeTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class LevelThreeDepartmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements LevelThreeDepartmentDAO{
 
 	
 	private  LevelTwoDepartmentDAO  levelTwoDepartmentDAO;
 	public void setLevelTwoDepartmentDAO(LevelTwoDepartmentDAO levelTwoDepartmentDAO){
	 	this.levelTwoDepartmentDAO = levelTwoDepartmentDAO;
 	}
 	public LevelTwoDepartmentDAO getLevelTwoDepartmentDAO(){
	 	return this.levelTwoDepartmentDAO;
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
	protected LevelThreeDepartment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelThreeDepartment(accessKey, options);
	}
	*/
	public LevelThreeDepartment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelThreeDepartment(LevelThreeDepartmentTable.withId(id), options);
	}
	
	
	
	public LevelThreeDepartment save(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options){
		
		String methodName="save(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelThreeDepartment, methodName, "levelThreeDepartment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelThreeDepartment(levelThreeDepartment,options);
	}
	public LevelThreeDepartment clone(String levelThreeDepartmentId, Map<String,Object> options) throws Exception{
	
		return clone(LevelThreeDepartmentTable.withId(levelThreeDepartmentId),options);
	}
	
	protected LevelThreeDepartment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelThreeDepartmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelThreeDepartment newLevelThreeDepartment = loadInternalLevelThreeDepartment(accessKey, options);
		newLevelThreeDepartment.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newLevelThreeDepartment.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelThreeDepartment(newLevelThreeDepartment,options);
		
		return newLevelThreeDepartment;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String levelThreeDepartmentId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{levelThreeDepartmentId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new LevelThreeDepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelThreeDepartmentNotFoundException(
					"The " + this.getTableName() + "(" + levelThreeDepartmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String levelThreeDepartmentId, int version) throws Exception{
	
		String methodName="delete(String levelThreeDepartmentId, int version)";
		assertMethodArgumentNotNull(levelThreeDepartmentId, methodName, "levelThreeDepartmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelThreeDepartmentId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelThreeDepartmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"belongs_to","name","description","founded"};
		return LevelThreeDepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_three_department";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelThreeDepartmentTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelThreeDepartmentTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelThreeDepartmentTokens.BELONGSTO);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,LevelThreeDepartmentTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelThreeDepartmentTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected LevelThreeDepartmentMapper getLevelThreeDepartmentMapper(){
		return new LevelThreeDepartmentMapper();
	}
	protected LevelThreeDepartment extractLevelThreeDepartment(String levelThreeDepartmentId) throws Exception{
		String SQL = "select * from level_three_department_data where id = ?";	
		try{
		
			LevelThreeDepartment levelThreeDepartment = queryForObject(SQL, new Object[]{levelThreeDepartmentId}, getLevelThreeDepartmentMapper());
			return levelThreeDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new LevelThreeDepartmentNotFoundException("LevelThreeDepartment("+levelThreeDepartmentId+") is not found!");
		}
		
		
	}
	protected LevelThreeDepartment extractLevelThreeDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from level_three_department_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			LevelThreeDepartment levelThreeDepartment = queryForObject(SQL, new Object[]{accessKey.getValue()}, getLevelThreeDepartmentMapper());
			return levelThreeDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new LevelThreeDepartmentNotFoundException("LevelThreeDepartment("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected LevelThreeDepartment loadInternalLevelThreeDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelThreeDepartment levelThreeDepartment = extractLevelThreeDepartment(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(levelThreeDepartment, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(levelThreeDepartment, loadOptions);
 		}		
		
		return levelThreeDepartment;
		
	}



	
	
	 

 	protected LevelThreeDepartment extractBelongsTo(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options) throws Exception{

		if(levelThreeDepartment.getBelongsTo() == null){
			return levelThreeDepartment;
		}
		String belongsToId = levelThreeDepartment.getBelongsTo().getId();
		if( belongsToId == null){
			return levelThreeDepartment;
		}
		LevelTwoDepartment belongsTo = getLevelTwoDepartmentDAO().load(belongsToId,options);
		if(belongsTo != null){
			levelThreeDepartment.setBelongsTo(belongsTo);
		}
		
 		
 		return levelThreeDepartment;
 	}
 		
 
		
	protected LevelThreeDepartment extractEmployeeList(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByDepartment(levelThreeDepartment.getId(),options);
		if(employeeList != null){
			levelThreeDepartment.setEmployeeList(employeeList);
		}
		
		return levelThreeDepartment;
	
	}	
		
		
  	
 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		SmartList<LevelThreeDepartment> levelThreeDepartmentList = queryForList(SQL, new Object[]{levelTwoDepartmentId}, getLevelThreeDepartmentMapper());	
 		return levelThreeDepartmentList;
 	}
 	
 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<LevelThreeDepartment> levelThreeDepartmentList = queryForList(SQL, new Object[]{levelTwoDepartmentId,start, count}, getLevelThreeDepartmentMapper());
		
 		return levelThreeDepartmentList;
 	}
 	
 	public int countLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where belongs_to = ?";
		Integer count = queryInt(SQL, new Object[]{levelTwoDepartmentId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected LevelThreeDepartment saveLevelThreeDepartment(LevelThreeDepartment  levelThreeDepartment){
	
		String SQL=this.getSaveLevelThreeDepartmentSQL(levelThreeDepartment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelThreeDepartmentParameters(levelThreeDepartment);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelThreeDepartment.incVersion();
		return levelThreeDepartment;
	
	}
	public SmartList<LevelThreeDepartment> saveLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelThreeDepartmentList(levelThreeDepartmentList);
		
		batchLevelThreeDepartmentCreate((List<LevelThreeDepartment>)lists[CREATE_LIST_INDEX]);
		
		batchLevelThreeDepartmentUpdate((List<LevelThreeDepartment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList){
			if(levelThreeDepartment.isChanged()){
				levelThreeDepartment.incVersion();
			}
			
		
		}
		
		
		return levelThreeDepartmentList;
	}

	public SmartList<LevelThreeDepartment> removeLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options){
		
		
		super.removeList(levelThreeDepartmentList, options);
		
		return levelThreeDepartmentList;
		
		
	}
	
	protected List<Object[]> prepareLevelThreeDepartmentBatchCreateArgs(List<LevelThreeDepartment> levelThreeDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList ){
			Object [] parameters = prepareLevelThreeDepartmentCreateParameters(levelThreeDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelThreeDepartmentBatchUpdateArgs(List<LevelThreeDepartment> levelThreeDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList ){
			if(!levelThreeDepartment.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelThreeDepartmentUpdateParameters(levelThreeDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelThreeDepartmentCreate(List<LevelThreeDepartment> levelThreeDepartmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelThreeDepartmentBatchCreateArgs(levelThreeDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelThreeDepartmentUpdate(List<LevelThreeDepartment> levelThreeDepartmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelThreeDepartmentBatchUpdateArgs(levelThreeDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelThreeDepartmentList(List<LevelThreeDepartment> levelThreeDepartmentList){
		
		List<LevelThreeDepartment> levelThreeDepartmentCreateList=new ArrayList<LevelThreeDepartment>();
		List<LevelThreeDepartment> levelThreeDepartmentUpdateList=new ArrayList<LevelThreeDepartment>();
		
		for(LevelThreeDepartment levelThreeDepartment: levelThreeDepartmentList){
			if(isUpdateRequest(levelThreeDepartment)){
				levelThreeDepartmentUpdateList.add( levelThreeDepartment);
				continue;
			}
			levelThreeDepartmentCreateList.add(levelThreeDepartment);
		}
		
		return new Object[]{levelThreeDepartmentCreateList,levelThreeDepartmentUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelThreeDepartment levelThreeDepartment){
 		return levelThreeDepartment.getVersion() > 0;
 	}
 	protected String getSaveLevelThreeDepartmentSQL(LevelThreeDepartment levelThreeDepartment){
 		if(isUpdateRequest(levelThreeDepartment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelThreeDepartmentParameters(LevelThreeDepartment levelThreeDepartment){
 		if(isUpdateRequest(levelThreeDepartment) ){
 			return prepareLevelThreeDepartmentUpdateParameters(levelThreeDepartment);
 		}
 		return prepareLevelThreeDepartmentCreateParameters(levelThreeDepartment);
 	}
 	protected Object[] prepareLevelThreeDepartmentUpdateParameters(LevelThreeDepartment levelThreeDepartment){
 		Object[] parameters = new Object[6];
  	
 		if(levelThreeDepartment.getBelongsTo() != null){
 			parameters[0] = levelThreeDepartment.getBelongsTo().getId();
 		}
 
 		parameters[1] = levelThreeDepartment.getName();
 		parameters[2] = levelThreeDepartment.getDescription();
 		parameters[3] = levelThreeDepartment.getFounded();		
 		parameters[4] = levelThreeDepartment.getId();
 		parameters[5] = levelThreeDepartment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelThreeDepartmentCreateParameters(LevelThreeDepartment levelThreeDepartment){
		Object[] parameters = new Object[5];
		String newLevelThreeDepartmentId=getNextId();
		levelThreeDepartment.setId(newLevelThreeDepartmentId);
		parameters[0] =  levelThreeDepartment.getId();
  	
 		if(levelThreeDepartment.getBelongsTo() != null){
 			parameters[1] = levelThreeDepartment.getBelongsTo().getId();
 		
 		}
 		
 		parameters[2] = levelThreeDepartment.getName();
 		parameters[3] = levelThreeDepartment.getDescription();
 		parameters[4] = levelThreeDepartment.getFounded();		
 				
 		return parameters;
 	}
 	
	protected LevelThreeDepartment saveInternalLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){
		
		saveLevelThreeDepartment(levelThreeDepartment);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(levelThreeDepartment, options);
 		}
 
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(levelThreeDepartment, options);
	 		removeEmployeeList(levelThreeDepartment, options);
	 		
 		}		
		
		return levelThreeDepartment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelThreeDepartment saveBelongsTo(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelThreeDepartment.getBelongsTo() == null){
 			return levelThreeDepartment;//do nothing when it is null
 		}
 		
 		getLevelTwoDepartmentDAO().save(levelThreeDepartment.getBelongsTo(),options);
 		return levelThreeDepartment;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected LevelThreeDepartment saveEmployeeList(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){
		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		if(employeeList == null){
			return levelThreeDepartment;
		}
		if(employeeList.isEmpty()){
			return levelThreeDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return levelThreeDepartment;
	
	}
	
	protected LevelThreeDepartment removeEmployeeList(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		if(employeeList == null){
			return levelThreeDepartment;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return levelThreeDepartment;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return levelThreeDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return levelThreeDepartment;
	
	}
	
	
	
 	
 	
	
	
	
		

	public LevelThreeDepartment present(LevelThreeDepartment levelThreeDepartment,Map<String, Object> options){
	
		presentEmployeeList(levelThreeDepartment,options);

		return levelThreeDepartment;
	
	}
		
	
  	
 	protected LevelThreeDepartment presentEmployeeList(
			LevelThreeDepartment levelThreeDepartment,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();		
		if(employeeList == null){
			return levelThreeDepartment;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return levelThreeDepartment;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByDepartment(levelThreeDepartment.getId(), options);			
		}
		//levelThreeDepartment.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//levelThreeDepartment.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			levelThreeDepartment.setEmployeeList(employeeList);
			return levelThreeDepartment;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByDepartment(levelThreeDepartment.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		levelThreeDepartment.setEmployeeList(employeeList );	

		return levelThreeDepartment;
	}			
		


	protected String getTableName(){
		return LevelThreeDepartmentTable.TABLE_NAME;
	}
}


