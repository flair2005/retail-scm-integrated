
package com.skynet.retailscm.leveltwodepartment;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartment;

import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartmentDAO;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartmentDAO;

import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartmentTable;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartmentTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class LevelTwoDepartmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements LevelTwoDepartmentDAO{
 
 	
 	private  LevelOneDepartmentDAO  levelOneDepartmentDAO;
 	public void setLevelOneDepartmentDAO(LevelOneDepartmentDAO levelOneDepartmentDAO){
	 	this.levelOneDepartmentDAO = levelOneDepartmentDAO;
 	}
 	public LevelOneDepartmentDAO getLevelOneDepartmentDAO(){
	 	return this.levelOneDepartmentDAO;
 	}

		
	
  	private  LevelThreeDepartmentDAO  levelThreeDepartmentDAO;
 	public void setLevelThreeDepartmentDAO(LevelThreeDepartmentDAO pLevelThreeDepartmentDAO){
 	
 		if(pLevelThreeDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelThreeDepartmentDAO to null.");
 		}
	 	this.levelThreeDepartmentDAO = pLevelThreeDepartmentDAO;
 	}
 	public LevelThreeDepartmentDAO getLevelThreeDepartmentDAO(){
 		if(this.levelThreeDepartmentDAO == null){
 			throw new IllegalStateException("The levelThreeDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelThreeDepartmentDAO;
 	}	
 	
			
		

	
	/*
	protected LevelTwoDepartment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoDepartment(accessKey, options);
	}
	*/
	public LevelTwoDepartment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoDepartment(LevelTwoDepartmentTable.withId(id), options);
	}
	
	
	
	public LevelTwoDepartment save(LevelTwoDepartment levelTwoDepartment,Map<String,Object> options){
		
		String methodName="save(LevelTwoDepartment levelTwoDepartment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelTwoDepartment, methodName, "levelTwoDepartment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelTwoDepartment(levelTwoDepartment,options);
	}
	public LevelTwoDepartment clone(String levelTwoDepartmentId, Map<String,Object> options) throws Exception{
	
		return clone(LevelTwoDepartmentTable.withId(levelTwoDepartmentId),options);
	}
	
	protected LevelTwoDepartment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelTwoDepartmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelTwoDepartment newLevelTwoDepartment = loadInternalLevelTwoDepartment(accessKey, options);
		newLevelTwoDepartment.setVersion(0);
		
		
 		
 		if(isSaveLevelThreeDepartmentListEnabled(options)){
 			for(LevelThreeDepartment item: newLevelTwoDepartment.getLevelThreeDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelTwoDepartment(newLevelTwoDepartment,options);
		
		return newLevelTwoDepartment;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String levelTwoDepartmentId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{levelTwoDepartmentId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new LevelTwoDepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelTwoDepartmentNotFoundException(
					"The " + this.getTableName() + "(" + levelTwoDepartmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String levelTwoDepartmentId, int version) throws Exception{
	
		String methodName="delete(String levelTwoDepartmentId, int version)";
		assertMethodArgumentNotNull(levelTwoDepartmentId, methodName, "levelTwoDepartmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelTwoDepartmentId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelTwoDepartmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"belongs_to","name","description","founded"};
		return LevelTwoDepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_two_department";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelTwoDepartmentTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelTwoDepartmentTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelTwoDepartmentTokens.BELONGSTO);
 	}
 	

 	
 
		
	//protected static final String LEVEL_THREE_DEPARTMENT_LIST = "levelThreeDepartmentList";
	
	protected boolean isExtractLevelThreeDepartmentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,LevelTwoDepartmentTokens.LEVEL_THREE_DEPARTMENT_LIST);
		
 	}

	protected boolean isSaveLevelThreeDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelTwoDepartmentTokens.LEVEL_THREE_DEPARTMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected LevelTwoDepartmentMapper getLevelTwoDepartmentMapper(){
		return new LevelTwoDepartmentMapper();
	}
	protected LevelTwoDepartment extractLevelTwoDepartment(String levelTwoDepartmentId) throws Exception{
		String SQL = "select * from level_two_department_data where id = ?";	
		try{
		
			LevelTwoDepartment levelTwoDepartment = queryForObject(SQL, new Object[]{levelTwoDepartmentId}, getLevelTwoDepartmentMapper());
			return levelTwoDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new LevelTwoDepartmentNotFoundException("LevelTwoDepartment("+levelTwoDepartmentId+") is not found!");
		}
		
		
	}
	protected LevelTwoDepartment extractLevelTwoDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from level_two_department_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			LevelTwoDepartment levelTwoDepartment = queryForObject(SQL, new Object[]{accessKey.getValue()}, getLevelTwoDepartmentMapper());
			return levelTwoDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new LevelTwoDepartmentNotFoundException("LevelTwoDepartment("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected LevelTwoDepartment loadInternalLevelTwoDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelTwoDepartment levelTwoDepartment = extractLevelTwoDepartment(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(levelTwoDepartment, loadOptions);
 		}
 
		
		if(isExtractLevelThreeDepartmentListEnabled(loadOptions)){
	 		extractLevelThreeDepartmentList(levelTwoDepartment, loadOptions);
 		}		
		
		return levelTwoDepartment;
		
	}



	
	
	 

 	protected LevelTwoDepartment extractBelongsTo(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options) throws Exception{

		if(levelTwoDepartment.getBelongsTo() == null){
			return levelTwoDepartment;
		}
		String belongsToId = levelTwoDepartment.getBelongsTo().getId();
		if( belongsToId == null){
			return levelTwoDepartment;
		}
		LevelOneDepartment belongsTo = getLevelOneDepartmentDAO().load(belongsToId,options);
		if(belongsTo != null){
			levelTwoDepartment.setBelongsTo(belongsTo);
		}
		
 		
 		return levelTwoDepartment;
 	}
 		
 
		
	protected LevelTwoDepartment extractLevelThreeDepartmentList(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){
		
		SmartList<LevelThreeDepartment> levelThreeDepartmentList = getLevelThreeDepartmentDAO().findLevelThreeDepartmentByBelongsTo(levelTwoDepartment.getId(),options);
		if(levelThreeDepartmentList != null){
			levelTwoDepartment.setLevelThreeDepartmentList(levelThreeDepartmentList);
		}
		
		return levelTwoDepartment;
	
	}	
		
		
  	
 	public SmartList<LevelTwoDepartment> findLevelTwoDepartmentByBelongsTo(String levelOneDepartmentId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = queryForList(SQL, new Object[]{levelOneDepartmentId}, getLevelTwoDepartmentMapper());	
 		return levelTwoDepartmentList;
 	}
 	
 	public SmartList<LevelTwoDepartment> findLevelTwoDepartmentByBelongsTo(String levelOneDepartmentId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = queryForList(SQL, new Object[]{levelOneDepartmentId,start, count}, getLevelTwoDepartmentMapper());
		
 		return levelTwoDepartmentList;
 	}
 	
 	public int countLevelTwoDepartmentByBelongsTo(String levelOneDepartmentId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where belongs_to = ?";
		Integer count = queryInt(SQL, new Object[]{levelOneDepartmentId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected LevelTwoDepartment saveLevelTwoDepartment(LevelTwoDepartment  levelTwoDepartment){
	
		String SQL=this.getSaveLevelTwoDepartmentSQL(levelTwoDepartment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelTwoDepartmentParameters(levelTwoDepartment);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelTwoDepartment.incVersion();
		return levelTwoDepartment;
	
	}
	public SmartList<LevelTwoDepartment> saveLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelTwoDepartmentList(levelTwoDepartmentList);
		
		batchLevelTwoDepartmentCreate((List<LevelTwoDepartment>)lists[CREATE_LIST_INDEX]);
		
		batchLevelTwoDepartmentUpdate((List<LevelTwoDepartment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList){
			if(levelTwoDepartment.isChanged()){
				levelTwoDepartment.incVersion();
			}
			
		
		}
		
		
		return levelTwoDepartmentList;
	}

	public SmartList<LevelTwoDepartment> removeLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList,Map<String,Object> options){
		
		
		super.removeList(levelTwoDepartmentList, options);
		
		return levelTwoDepartmentList;
		
		
	}
	
	protected List<Object[]> prepareLevelTwoDepartmentBatchCreateArgs(List<LevelTwoDepartment> levelTwoDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList ){
			Object [] parameters = prepareLevelTwoDepartmentCreateParameters(levelTwoDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelTwoDepartmentBatchUpdateArgs(List<LevelTwoDepartment> levelTwoDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList ){
			if(!levelTwoDepartment.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelTwoDepartmentUpdateParameters(levelTwoDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelTwoDepartmentCreate(List<LevelTwoDepartment> levelTwoDepartmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelTwoDepartmentBatchCreateArgs(levelTwoDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelTwoDepartmentUpdate(List<LevelTwoDepartment> levelTwoDepartmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelTwoDepartmentBatchUpdateArgs(levelTwoDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelTwoDepartmentList(List<LevelTwoDepartment> levelTwoDepartmentList){
		
		List<LevelTwoDepartment> levelTwoDepartmentCreateList=new ArrayList<LevelTwoDepartment>();
		List<LevelTwoDepartment> levelTwoDepartmentUpdateList=new ArrayList<LevelTwoDepartment>();
		
		for(LevelTwoDepartment levelTwoDepartment: levelTwoDepartmentList){
			if(isUpdateRequest(levelTwoDepartment)){
				levelTwoDepartmentUpdateList.add( levelTwoDepartment);
				continue;
			}
			levelTwoDepartmentCreateList.add(levelTwoDepartment);
		}
		
		return new Object[]{levelTwoDepartmentCreateList,levelTwoDepartmentUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelTwoDepartment levelTwoDepartment){
 		return levelTwoDepartment.getVersion() > 0;
 	}
 	protected String getSaveLevelTwoDepartmentSQL(LevelTwoDepartment levelTwoDepartment){
 		if(isUpdateRequest(levelTwoDepartment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelTwoDepartmentParameters(LevelTwoDepartment levelTwoDepartment){
 		if(isUpdateRequest(levelTwoDepartment) ){
 			return prepareLevelTwoDepartmentUpdateParameters(levelTwoDepartment);
 		}
 		return prepareLevelTwoDepartmentCreateParameters(levelTwoDepartment);
 	}
 	protected Object[] prepareLevelTwoDepartmentUpdateParameters(LevelTwoDepartment levelTwoDepartment){
 		Object[] parameters = new Object[6];
  	
 		if(levelTwoDepartment.getBelongsTo() != null){
 			parameters[0] = levelTwoDepartment.getBelongsTo().getId();
 		}
 
 		parameters[1] = levelTwoDepartment.getName();
 		parameters[2] = levelTwoDepartment.getDescription();
 		parameters[3] = levelTwoDepartment.getFounded();		
 		parameters[4] = levelTwoDepartment.getId();
 		parameters[5] = levelTwoDepartment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelTwoDepartmentCreateParameters(LevelTwoDepartment levelTwoDepartment){
		Object[] parameters = new Object[5];
		String newLevelTwoDepartmentId=getNextId();
		levelTwoDepartment.setId(newLevelTwoDepartmentId);
		parameters[0] =  levelTwoDepartment.getId();
  	
 		if(levelTwoDepartment.getBelongsTo() != null){
 			parameters[1] = levelTwoDepartment.getBelongsTo().getId();
 		
 		}
 		
 		parameters[2] = levelTwoDepartment.getName();
 		parameters[3] = levelTwoDepartment.getDescription();
 		parameters[4] = levelTwoDepartment.getFounded();		
 				
 		return parameters;
 	}
 	
	protected LevelTwoDepartment saveInternalLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){
		
		saveLevelTwoDepartment(levelTwoDepartment);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(levelTwoDepartment, options);
 		}
 
		
		if(isSaveLevelThreeDepartmentListEnabled(options)){
	 		saveLevelThreeDepartmentList(levelTwoDepartment, options);
	 		removeLevelThreeDepartmentList(levelTwoDepartment, options);
	 		
 		}		
		
		return levelTwoDepartment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelTwoDepartment saveBelongsTo(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelTwoDepartment.getBelongsTo() == null){
 			return levelTwoDepartment;//do nothing when it is null
 		}
 		
 		getLevelOneDepartmentDAO().save(levelTwoDepartment.getBelongsTo(),options);
 		return levelTwoDepartment;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected LevelTwoDepartment saveLevelThreeDepartmentList(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){
		SmartList<LevelThreeDepartment> levelThreeDepartmentList = levelTwoDepartment.getLevelThreeDepartmentList();
		if(levelThreeDepartmentList == null){
			return levelTwoDepartment;
		}
		if(levelThreeDepartmentList.isEmpty()){
			return levelTwoDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getLevelThreeDepartmentDAO().saveLevelThreeDepartmentList(levelThreeDepartmentList,options);
		
		return levelTwoDepartment;
	
	}
	
	protected LevelTwoDepartment removeLevelThreeDepartmentList(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){
	
	
		SmartList<LevelThreeDepartment> levelThreeDepartmentList = levelTwoDepartment.getLevelThreeDepartmentList();
		if(levelThreeDepartmentList == null){
			return levelTwoDepartment;
		}	
	
		SmartList<LevelThreeDepartment> toRemoveLevelThreeDepartmentList = levelThreeDepartmentList.getToRemoveList();
		
		if(toRemoveLevelThreeDepartmentList == null){
			return levelTwoDepartment;
		}
		if(toRemoveLevelThreeDepartmentList.isEmpty()){
			return levelTwoDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelThreeDepartmentDAO().removeLevelThreeDepartmentList(toRemoveLevelThreeDepartmentList,options);
		
		return levelTwoDepartment;
	
	}
	
	
	
 	
 	
	
	
	
		

	public LevelTwoDepartment present(LevelTwoDepartment levelTwoDepartment,Map<String, Object> options){
	
		presentLevelThreeDepartmentList(levelTwoDepartment,options);

		return levelTwoDepartment;
	
	}
		
	
  	
 	protected LevelTwoDepartment presentLevelThreeDepartmentList(
			LevelTwoDepartment levelTwoDepartment,
			Map<String, Object> options) {

		SmartList<LevelThreeDepartment> levelThreeDepartmentList = levelTwoDepartment.getLevelThreeDepartmentList();		
		if(levelThreeDepartmentList == null){
			return levelTwoDepartment;			
		}
		
		String targetObjectName = "levelThreeDepartment";
		int levelThreeDepartmentListSize = levelThreeDepartmentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(levelThreeDepartmentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return levelTwoDepartment;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = levelThreeDepartmentListSize;
		if(levelThreeDepartmentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getLevelThreeDepartmentDAO().countLevelThreeDepartmentByBelongsTo(levelTwoDepartment.getId(), options);			
		}
		//levelTwoDepartment.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//levelTwoDepartment.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(levelThreeDepartmentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(levelThreeDepartmentListSize,currentPage,rowsPerPage) ;
			levelThreeDepartmentList = levelThreeDepartmentList.subListOf(fromIndex, toIndex);
			levelThreeDepartmentList.setTotalCount(count);
			levelThreeDepartmentList.setCurrentPageNumber(currentPage);			
			levelTwoDepartment.setLevelThreeDepartmentList(levelThreeDepartmentList);
			return levelTwoDepartment;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		levelThreeDepartmentList 
			= getLevelThreeDepartmentDAO().findLevelThreeDepartmentByBelongsTo(levelTwoDepartment.getId(),start, rowsPerPage, options );
		levelThreeDepartmentList.setTotalCount(count);
		levelThreeDepartmentList.setCurrentPageNumber(currentPage);
		levelTwoDepartment.setLevelThreeDepartmentList(levelThreeDepartmentList );	

		return levelTwoDepartment;
	}			
		


	protected String getTableName(){
		return LevelTwoDepartmentTable.TABLE_NAME;
	}
}


