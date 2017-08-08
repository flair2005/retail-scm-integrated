
package com.skynet.retailscm.levelonedepartment;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;

import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartmentDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartmentTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class LevelOneDepartmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements LevelOneDepartmentDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  LevelTwoDepartmentDAO  levelTwoDepartmentDAO;
 	public void setLevelTwoDepartmentDAO(LevelTwoDepartmentDAO pLevelTwoDepartmentDAO){
 	
 		if(pLevelTwoDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelTwoDepartmentDAO to null.");
 		}
	 	this.levelTwoDepartmentDAO = pLevelTwoDepartmentDAO;
 	}
 	public LevelTwoDepartmentDAO getLevelTwoDepartmentDAO(){
 		if(this.levelTwoDepartmentDAO == null){
 			throw new IllegalStateException("The levelTwoDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelTwoDepartmentDAO;
 	}	
 	
			
		

	
	/*
	protected LevelOneDepartment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelOneDepartment(accessKey, options);
	}
	*/
	public LevelOneDepartment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelOneDepartment(LevelOneDepartmentTable.withId(id), options);
	}
	
	
	
	public LevelOneDepartment save(LevelOneDepartment levelOneDepartment,Map<String,Object> options){
		
		String methodName="save(LevelOneDepartment levelOneDepartment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelOneDepartment, methodName, "levelOneDepartment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelOneDepartment(levelOneDepartment,options);
	}
	public LevelOneDepartment clone(String levelOneDepartmentId, Map<String,Object> options) throws Exception{
	
		return clone(LevelOneDepartmentTable.withId(levelOneDepartmentId),options);
	}
	
	protected LevelOneDepartment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelOneDepartmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelOneDepartment newLevelOneDepartment = loadInternalLevelOneDepartment(accessKey, options);
		newLevelOneDepartment.setVersion(0);
		
		
 		
 		if(isSaveLevelTwoDepartmentListEnabled(options)){
 			for(LevelTwoDepartment item: newLevelOneDepartment.getLevelTwoDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelOneDepartment(newLevelOneDepartment,options);
		
		return newLevelOneDepartment;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String levelOneDepartmentId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{levelOneDepartmentId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new LevelOneDepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelOneDepartmentNotFoundException(
					"The " + this.getTableName() + "(" + levelOneDepartmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String levelOneDepartmentId, int version) throws Exception{
	
		String methodName="delete(String levelOneDepartmentId, int version)";
		assertMethodArgumentNotNull(levelOneDepartmentId, methodName, "levelOneDepartmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelOneDepartmentId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelOneDepartmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"belongs_to","name","description","manager","founded"};
		return LevelOneDepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_one_department";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelOneDepartmentTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelOneDepartmentTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelOneDepartmentTokens.BELONGSTO);
 	}
 	

 	
 
		
	//protected static final String LEVEL_TWO_DEPARTMENT_LIST = "levelTwoDepartmentList";
	
	protected boolean isExtractLevelTwoDepartmentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,LevelOneDepartmentTokens.LEVEL_TWO_DEPARTMENT_LIST);
		
 	}

	protected boolean isSaveLevelTwoDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelOneDepartmentTokens.LEVEL_TWO_DEPARTMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected LevelOneDepartmentMapper getLevelOneDepartmentMapper(){
		return new LevelOneDepartmentMapper();
	}
	protected LevelOneDepartment extractLevelOneDepartment(String levelOneDepartmentId) throws Exception{
		String SQL = "select * from level_one_department_data where id = ?";	
		try{
		
			LevelOneDepartment levelOneDepartment = queryForObject(SQL, new Object[]{levelOneDepartmentId}, getLevelOneDepartmentMapper());
			return levelOneDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new LevelOneDepartmentNotFoundException("LevelOneDepartment("+levelOneDepartmentId+") is not found!");
		}
		
		
	}
	protected LevelOneDepartment extractLevelOneDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from level_one_department_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			LevelOneDepartment levelOneDepartment = queryForObject(SQL, new Object[]{accessKey.getValue()}, getLevelOneDepartmentMapper());
			return levelOneDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new LevelOneDepartmentNotFoundException("LevelOneDepartment("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected LevelOneDepartment loadInternalLevelOneDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelOneDepartment levelOneDepartment = extractLevelOneDepartment(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(levelOneDepartment, loadOptions);
 		}
 
		
		if(isExtractLevelTwoDepartmentListEnabled(loadOptions)){
	 		extractLevelTwoDepartmentList(levelOneDepartment, loadOptions);
 		}		
		
		return levelOneDepartment;
		
	}



	
	
	 

 	protected LevelOneDepartment extractBelongsTo(LevelOneDepartment levelOneDepartment, Map<String,Object> options) throws Exception{

		if(levelOneDepartment.getBelongsTo() == null){
			return levelOneDepartment;
		}
		String belongsToId = levelOneDepartment.getBelongsTo().getId();
		if( belongsToId == null){
			return levelOneDepartment;
		}
		RetailStoreCountryCenter belongsTo = getRetailStoreCountryCenterDAO().load(belongsToId,options);
		if(belongsTo != null){
			levelOneDepartment.setBelongsTo(belongsTo);
		}
		
 		
 		return levelOneDepartment;
 	}
 		
 
		
	protected LevelOneDepartment extractLevelTwoDepartmentList(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
		
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = getLevelTwoDepartmentDAO().findLevelTwoDepartmentByBelongsTo(levelOneDepartment.getId(),options);
		if(levelTwoDepartmentList != null){
			levelOneDepartment.setLevelTwoDepartmentList(levelTwoDepartmentList);
		}
		
		return levelOneDepartment;
	
	}	
		
		
  	
 	public SmartList<LevelOneDepartment> findLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		SmartList<LevelOneDepartment> levelOneDepartmentList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getLevelOneDepartmentMapper());	
 		return levelOneDepartmentList;
 	}
 	
 	public SmartList<LevelOneDepartment> findLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<LevelOneDepartment> levelOneDepartmentList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getLevelOneDepartmentMapper());
		
 		return levelOneDepartmentList;
 	}
 	
 	public int countLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where belongs_to = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected LevelOneDepartment saveLevelOneDepartment(LevelOneDepartment  levelOneDepartment){
	
		String SQL=this.getSaveLevelOneDepartmentSQL(levelOneDepartment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelOneDepartmentParameters(levelOneDepartment);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelOneDepartment.incVersion();
		return levelOneDepartment;
	
	}
	public SmartList<LevelOneDepartment> saveLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelOneDepartmentList(levelOneDepartmentList);
		
		batchLevelOneDepartmentCreate((List<LevelOneDepartment>)lists[CREATE_LIST_INDEX]);
		
		batchLevelOneDepartmentUpdate((List<LevelOneDepartment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelOneDepartment levelOneDepartment:levelOneDepartmentList){
			if(levelOneDepartment.isChanged()){
				levelOneDepartment.incVersion();
			}
			
		
		}
		
		
		return levelOneDepartmentList;
	}

	public SmartList<LevelOneDepartment> removeLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList,Map<String,Object> options){
		
		
		super.removeList(levelOneDepartmentList, options);
		
		return levelOneDepartmentList;
		
		
	}
	
	protected List<Object[]> prepareLevelOneDepartmentBatchCreateArgs(List<LevelOneDepartment> levelOneDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelOneDepartment levelOneDepartment:levelOneDepartmentList ){
			Object [] parameters = prepareLevelOneDepartmentCreateParameters(levelOneDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelOneDepartmentBatchUpdateArgs(List<LevelOneDepartment> levelOneDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelOneDepartment levelOneDepartment:levelOneDepartmentList ){
			if(!levelOneDepartment.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelOneDepartmentUpdateParameters(levelOneDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelOneDepartmentCreate(List<LevelOneDepartment> levelOneDepartmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelOneDepartmentBatchCreateArgs(levelOneDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelOneDepartmentUpdate(List<LevelOneDepartment> levelOneDepartmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelOneDepartmentBatchUpdateArgs(levelOneDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelOneDepartmentList(List<LevelOneDepartment> levelOneDepartmentList){
		
		List<LevelOneDepartment> levelOneDepartmentCreateList=new ArrayList<LevelOneDepartment>();
		List<LevelOneDepartment> levelOneDepartmentUpdateList=new ArrayList<LevelOneDepartment>();
		
		for(LevelOneDepartment levelOneDepartment: levelOneDepartmentList){
			if(isUpdateRequest(levelOneDepartment)){
				levelOneDepartmentUpdateList.add( levelOneDepartment);
				continue;
			}
			levelOneDepartmentCreateList.add(levelOneDepartment);
		}
		
		return new Object[]{levelOneDepartmentCreateList,levelOneDepartmentUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelOneDepartment levelOneDepartment){
 		return levelOneDepartment.getVersion() > 0;
 	}
 	protected String getSaveLevelOneDepartmentSQL(LevelOneDepartment levelOneDepartment){
 		if(isUpdateRequest(levelOneDepartment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelOneDepartmentParameters(LevelOneDepartment levelOneDepartment){
 		if(isUpdateRequest(levelOneDepartment) ){
 			return prepareLevelOneDepartmentUpdateParameters(levelOneDepartment);
 		}
 		return prepareLevelOneDepartmentCreateParameters(levelOneDepartment);
 	}
 	protected Object[] prepareLevelOneDepartmentUpdateParameters(LevelOneDepartment levelOneDepartment){
 		Object[] parameters = new Object[7];
  	
 		if(levelOneDepartment.getBelongsTo() != null){
 			parameters[0] = levelOneDepartment.getBelongsTo().getId();
 		}
 
 		parameters[1] = levelOneDepartment.getName();
 		parameters[2] = levelOneDepartment.getDescription();
 		parameters[3] = levelOneDepartment.getManager();
 		parameters[4] = levelOneDepartment.getFounded();		
 		parameters[5] = levelOneDepartment.getId();
 		parameters[6] = levelOneDepartment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelOneDepartmentCreateParameters(LevelOneDepartment levelOneDepartment){
		Object[] parameters = new Object[6];
		String newLevelOneDepartmentId=getNextId();
		levelOneDepartment.setId(newLevelOneDepartmentId);
		parameters[0] =  levelOneDepartment.getId();
  	
 		if(levelOneDepartment.getBelongsTo() != null){
 			parameters[1] = levelOneDepartment.getBelongsTo().getId();
 		
 		}
 		
 		parameters[2] = levelOneDepartment.getName();
 		parameters[3] = levelOneDepartment.getDescription();
 		parameters[4] = levelOneDepartment.getManager();
 		parameters[5] = levelOneDepartment.getFounded();		
 				
 		return parameters;
 	}
 	
	protected LevelOneDepartment saveInternalLevelOneDepartment(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
		
		saveLevelOneDepartment(levelOneDepartment);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(levelOneDepartment, options);
 		}
 
		
		if(isSaveLevelTwoDepartmentListEnabled(options)){
	 		saveLevelTwoDepartmentList(levelOneDepartment, options);
	 		removeLevelTwoDepartmentList(levelOneDepartment, options);
	 		
 		}		
		
		return levelOneDepartment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelOneDepartment saveBelongsTo(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelOneDepartment.getBelongsTo() == null){
 			return levelOneDepartment;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(levelOneDepartment.getBelongsTo(),options);
 		return levelOneDepartment;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected LevelOneDepartment saveLevelTwoDepartmentList(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = levelOneDepartment.getLevelTwoDepartmentList();
		if(levelTwoDepartmentList == null){
			return levelOneDepartment;
		}
		if(levelTwoDepartmentList.isEmpty()){
			return levelOneDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getLevelTwoDepartmentDAO().saveLevelTwoDepartmentList(levelTwoDepartmentList,options);
		
		return levelOneDepartment;
	
	}
	
	protected LevelOneDepartment removeLevelTwoDepartmentList(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
	
	
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = levelOneDepartment.getLevelTwoDepartmentList();
		if(levelTwoDepartmentList == null){
			return levelOneDepartment;
		}	
	
		SmartList<LevelTwoDepartment> toRemoveLevelTwoDepartmentList = levelTwoDepartmentList.getToRemoveList();
		
		if(toRemoveLevelTwoDepartmentList == null){
			return levelOneDepartment;
		}
		if(toRemoveLevelTwoDepartmentList.isEmpty()){
			return levelOneDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelTwoDepartmentDAO().removeLevelTwoDepartmentList(toRemoveLevelTwoDepartmentList,options);
		
		return levelOneDepartment;
	
	}
	
	
	
 	
 	
	
	
	
		

	public LevelOneDepartment present(LevelOneDepartment levelOneDepartment,Map<String, Object> options){
	
		presentLevelTwoDepartmentList(levelOneDepartment,options);

		return levelOneDepartment;
	
	}
		
	
  	
 	protected LevelOneDepartment presentLevelTwoDepartmentList(
			LevelOneDepartment levelOneDepartment,
			Map<String, Object> options) {

		SmartList<LevelTwoDepartment> levelTwoDepartmentList = levelOneDepartment.getLevelTwoDepartmentList();		
		if(levelTwoDepartmentList == null){
			return levelOneDepartment;			
		}
		
		String targetObjectName = "levelTwoDepartment";
		int levelTwoDepartmentListSize = levelTwoDepartmentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(levelTwoDepartmentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return levelOneDepartment;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = levelTwoDepartmentListSize;
		if(levelTwoDepartmentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getLevelTwoDepartmentDAO().countLevelTwoDepartmentByBelongsTo(levelOneDepartment.getId(), options);			
		}
		//levelOneDepartment.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//levelOneDepartment.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(levelTwoDepartmentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(levelTwoDepartmentListSize,currentPage,rowsPerPage) ;
			levelTwoDepartmentList = levelTwoDepartmentList.subListOf(fromIndex, toIndex);
			levelTwoDepartmentList.setTotalCount(count);
			levelTwoDepartmentList.setCurrentPageNumber(currentPage);			
			levelOneDepartment.setLevelTwoDepartmentList(levelTwoDepartmentList);
			return levelOneDepartment;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		levelTwoDepartmentList 
			= getLevelTwoDepartmentDAO().findLevelTwoDepartmentByBelongsTo(levelOneDepartment.getId(),start, rowsPerPage, options );
		levelTwoDepartmentList.setTotalCount(count);
		levelTwoDepartmentList.setCurrentPageNumber(currentPage);
		levelOneDepartment.setLevelTwoDepartmentList(levelTwoDepartmentList );	

		return levelOneDepartment;
	}			
		


	protected String getTableName(){
		return LevelOneDepartmentTable.TABLE_NAME;
	}
}


