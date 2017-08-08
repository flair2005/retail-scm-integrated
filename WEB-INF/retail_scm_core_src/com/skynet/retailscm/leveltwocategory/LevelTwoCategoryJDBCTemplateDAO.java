
package com.skynet.retailscm.leveltwocategory;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.levelonecategory.LevelOneCategory;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;

import com.skynet.retailscm.levelonecategory.LevelOneCategoryDAO;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategoryDAO;

import com.skynet.retailscm.levelthreecategory.LevelThreeCategoryTable;
import com.skynet.retailscm.levelonecategory.LevelOneCategoryTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class LevelTwoCategoryJDBCTemplateDAO extends CommonJDBCTemplateDAO implements LevelTwoCategoryDAO{
 
 	
 	private  LevelOneCategoryDAO  levelOneCategoryDAO;
 	public void setLevelOneCategoryDAO(LevelOneCategoryDAO levelOneCategoryDAO){
	 	this.levelOneCategoryDAO = levelOneCategoryDAO;
 	}
 	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
	 	return this.levelOneCategoryDAO;
 	}

		
	
  	private  LevelThreeCategoryDAO  levelThreeCategoryDAO;
 	public void setLevelThreeCategoryDAO(LevelThreeCategoryDAO pLevelThreeCategoryDAO){
 	
 		if(pLevelThreeCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelThreeCategoryDAO to null.");
 		}
	 	this.levelThreeCategoryDAO = pLevelThreeCategoryDAO;
 	}
 	public LevelThreeCategoryDAO getLevelThreeCategoryDAO(){
 		if(this.levelThreeCategoryDAO == null){
 			throw new IllegalStateException("The levelThreeCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelThreeCategoryDAO;
 	}	
 	
			
		

	
	/*
	protected LevelTwoCategory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoCategory(accessKey, options);
	}
	*/
	public LevelTwoCategory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoCategory(LevelTwoCategoryTable.withId(id), options);
	}
	
	
	
	public LevelTwoCategory save(LevelTwoCategory levelTwoCategory,Map<String,Object> options){
		
		String methodName="save(LevelTwoCategory levelTwoCategory,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelTwoCategory, methodName, "levelTwoCategory");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelTwoCategory(levelTwoCategory,options);
	}
	public LevelTwoCategory clone(String levelTwoCategoryId, Map<String,Object> options) throws Exception{
	
		return clone(LevelTwoCategoryTable.withId(levelTwoCategoryId),options);
	}
	
	protected LevelTwoCategory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelTwoCategoryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelTwoCategory newLevelTwoCategory = loadInternalLevelTwoCategory(accessKey, options);
		newLevelTwoCategory.setVersion(0);
		
		
 		
 		if(isSaveLevelThreeCategoryListEnabled(options)){
 			for(LevelThreeCategory item: newLevelTwoCategory.getLevelThreeCategoryList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelTwoCategory(newLevelTwoCategory,options);
		
		return newLevelTwoCategory;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String levelTwoCategoryId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{levelTwoCategoryId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new LevelTwoCategoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelTwoCategoryNotFoundException(
					"The " + this.getTableName() + "(" + levelTwoCategoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String levelTwoCategoryId, int version) throws Exception{
	
		String methodName="delete(String levelTwoCategoryId, int version)";
		assertMethodArgumentNotNull(levelTwoCategoryId, methodName, "levelTwoCategoryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelTwoCategoryId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelTwoCategoryId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"parent_category","display_name"};
		return LevelTwoCategoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_two_category";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelTwoCategoryTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractParentCategoryEnabled = true;
 	//private static final String PARENTCATEGORY = "parentCategory";
 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelTwoCategoryTokens.PARENTCATEGORY);
 	}
 	
 	
 	//private boolean saveParentCategoryEnabled = true;
 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelTwoCategoryTokens.PARENTCATEGORY);
 	}
 	

 	
 
		
	//protected static final String LEVEL_THREE_CATEGORY_LIST = "levelThreeCategoryList";
	
	protected boolean isExtractLevelThreeCategoryListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,LevelTwoCategoryTokens.LEVEL_THREE_CATEGORY_LIST);
		
 	}

	protected boolean isSaveLevelThreeCategoryListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelTwoCategoryTokens.LEVEL_THREE_CATEGORY_LIST);
		
 	}
 	
 	
			
		

	

	protected LevelTwoCategoryMapper getLevelTwoCategoryMapper(){
		return new LevelTwoCategoryMapper();
	}
	protected LevelTwoCategory extractLevelTwoCategory(String levelTwoCategoryId) throws Exception{
		String SQL = "select * from level_two_category_data where id = ?";	
		try{
		
			LevelTwoCategory levelTwoCategory = queryForObject(SQL, new Object[]{levelTwoCategoryId}, getLevelTwoCategoryMapper());
			return levelTwoCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelTwoCategoryNotFoundException("LevelTwoCategory("+levelTwoCategoryId+") is not found!");
		}
		
		
	}
	protected LevelTwoCategory extractLevelTwoCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from level_two_category_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			LevelTwoCategory levelTwoCategory = queryForObject(SQL, new Object[]{accessKey.getValue()}, getLevelTwoCategoryMapper());
			return levelTwoCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelTwoCategoryNotFoundException("LevelTwoCategory("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected LevelTwoCategory loadInternalLevelTwoCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelTwoCategory levelTwoCategory = extractLevelTwoCategory(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(levelTwoCategory, loadOptions);
 		}
 
		
		if(isExtractLevelThreeCategoryListEnabled(loadOptions)){
	 		extractLevelThreeCategoryList(levelTwoCategory, loadOptions);
 		}		
		
		return levelTwoCategory;
		
	}



	
	
	 

 	protected LevelTwoCategory extractParentCategory(LevelTwoCategory levelTwoCategory, Map<String,Object> options) throws Exception{

		if(levelTwoCategory.getParentCategory() == null){
			return levelTwoCategory;
		}
		String parentCategoryId = levelTwoCategory.getParentCategory().getId();
		if( parentCategoryId == null){
			return levelTwoCategory;
		}
		LevelOneCategory parentCategory = getLevelOneCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			levelTwoCategory.setParentCategory(parentCategory);
		}
		
 		
 		return levelTwoCategory;
 	}
 		
 
		
	protected LevelTwoCategory extractLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		SmartList<LevelThreeCategory> levelThreeCategoryList = getLevelThreeCategoryDAO().findLevelThreeCategoryByParentCategory(levelTwoCategory.getId(),options);
		if(levelThreeCategoryList != null){
			levelTwoCategory.setLevelThreeCategoryList(levelThreeCategoryList);
		}
		
		return levelTwoCategory;
	
	}	
		
		
  	
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where parent_category = ?";
		SmartList<LevelTwoCategory> levelTwoCategoryList = queryForList(SQL, new Object[]{levelOneCategoryId}, getLevelTwoCategoryMapper());	
 		return levelTwoCategoryList;
 	}
 	
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where parent_category = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<LevelTwoCategory> levelTwoCategoryList = queryForList(SQL, new Object[]{levelOneCategoryId,start, count}, getLevelTwoCategoryMapper());
		
 		return levelTwoCategoryList;
 	}
 	
 	public int countLevelTwoCategoryByParentCategory(String levelOneCategoryId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where parent_category = ?";
		Integer count = queryInt(SQL, new Object[]{levelOneCategoryId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected LevelTwoCategory saveLevelTwoCategory(LevelTwoCategory  levelTwoCategory){
	
		String SQL=this.getSaveLevelTwoCategorySQL(levelTwoCategory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelTwoCategoryParameters(levelTwoCategory);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelTwoCategory.incVersion();
		return levelTwoCategory;
	
	}
	public SmartList<LevelTwoCategory> saveLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelTwoCategoryList(levelTwoCategoryList);
		
		batchLevelTwoCategoryCreate((List<LevelTwoCategory>)lists[CREATE_LIST_INDEX]);
		
		batchLevelTwoCategoryUpdate((List<LevelTwoCategory>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelTwoCategory levelTwoCategory:levelTwoCategoryList){
			if(levelTwoCategory.isChanged()){
				levelTwoCategory.incVersion();
			}
			
		
		}
		
		
		return levelTwoCategoryList;
	}

	public SmartList<LevelTwoCategory> removeLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options){
		
		
		super.removeList(levelTwoCategoryList, options);
		
		return levelTwoCategoryList;
		
		
	}
	
	protected List<Object[]> prepareLevelTwoCategoryBatchCreateArgs(List<LevelTwoCategory> levelTwoCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoCategory levelTwoCategory:levelTwoCategoryList ){
			Object [] parameters = prepareLevelTwoCategoryCreateParameters(levelTwoCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelTwoCategoryBatchUpdateArgs(List<LevelTwoCategory> levelTwoCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoCategory levelTwoCategory:levelTwoCategoryList ){
			if(!levelTwoCategory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelTwoCategoryUpdateParameters(levelTwoCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelTwoCategoryCreate(List<LevelTwoCategory> levelTwoCategoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelTwoCategoryBatchCreateArgs(levelTwoCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelTwoCategoryUpdate(List<LevelTwoCategory> levelTwoCategoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelTwoCategoryBatchUpdateArgs(levelTwoCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelTwoCategoryList(List<LevelTwoCategory> levelTwoCategoryList){
		
		List<LevelTwoCategory> levelTwoCategoryCreateList=new ArrayList<LevelTwoCategory>();
		List<LevelTwoCategory> levelTwoCategoryUpdateList=new ArrayList<LevelTwoCategory>();
		
		for(LevelTwoCategory levelTwoCategory: levelTwoCategoryList){
			if(isUpdateRequest(levelTwoCategory)){
				levelTwoCategoryUpdateList.add( levelTwoCategory);
				continue;
			}
			levelTwoCategoryCreateList.add(levelTwoCategory);
		}
		
		return new Object[]{levelTwoCategoryCreateList,levelTwoCategoryUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelTwoCategory levelTwoCategory){
 		return levelTwoCategory.getVersion() > 0;
 	}
 	protected String getSaveLevelTwoCategorySQL(LevelTwoCategory levelTwoCategory){
 		if(isUpdateRequest(levelTwoCategory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelTwoCategoryParameters(LevelTwoCategory levelTwoCategory){
 		if(isUpdateRequest(levelTwoCategory) ){
 			return prepareLevelTwoCategoryUpdateParameters(levelTwoCategory);
 		}
 		return prepareLevelTwoCategoryCreateParameters(levelTwoCategory);
 	}
 	protected Object[] prepareLevelTwoCategoryUpdateParameters(LevelTwoCategory levelTwoCategory){
 		Object[] parameters = new Object[4];
  	
 		if(levelTwoCategory.getParentCategory() != null){
 			parameters[0] = levelTwoCategory.getParentCategory().getId();
 		}
 
 		parameters[1] = levelTwoCategory.getDisplayName();		
 		parameters[2] = levelTwoCategory.getId();
 		parameters[3] = levelTwoCategory.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelTwoCategoryCreateParameters(LevelTwoCategory levelTwoCategory){
		Object[] parameters = new Object[3];
		String newLevelTwoCategoryId=getNextId();
		levelTwoCategory.setId(newLevelTwoCategoryId);
		parameters[0] =  levelTwoCategory.getId();
  	
 		if(levelTwoCategory.getParentCategory() != null){
 			parameters[1] = levelTwoCategory.getParentCategory().getId();
 		
 		}
 		
 		parameters[2] = levelTwoCategory.getDisplayName();		
 				
 		return parameters;
 	}
 	
	protected LevelTwoCategory saveInternalLevelTwoCategory(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		saveLevelTwoCategory(levelTwoCategory);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(levelTwoCategory, options);
 		}
 
		
		if(isSaveLevelThreeCategoryListEnabled(options)){
	 		saveLevelThreeCategoryList(levelTwoCategory, options);
	 		removeLevelThreeCategoryList(levelTwoCategory, options);
	 		
 		}		
		
		return levelTwoCategory;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelTwoCategory saveParentCategory(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelTwoCategory.getParentCategory() == null){
 			return levelTwoCategory;//do nothing when it is null
 		}
 		
 		getLevelOneCategoryDAO().save(levelTwoCategory.getParentCategory(),options);
 		return levelTwoCategory;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected LevelTwoCategory saveLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		SmartList<LevelThreeCategory> levelThreeCategoryList = levelTwoCategory.getLevelThreeCategoryList();
		if(levelThreeCategoryList == null){
			return levelTwoCategory;
		}
		if(levelThreeCategoryList.isEmpty()){
			return levelTwoCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getLevelThreeCategoryDAO().saveLevelThreeCategoryList(levelThreeCategoryList,options);
		
		return levelTwoCategory;
	
	}
	
	protected LevelTwoCategory removeLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
	
	
		SmartList<LevelThreeCategory> levelThreeCategoryList = levelTwoCategory.getLevelThreeCategoryList();
		if(levelThreeCategoryList == null){
			return levelTwoCategory;
		}	
	
		SmartList<LevelThreeCategory> toRemoveLevelThreeCategoryList = levelThreeCategoryList.getToRemoveList();
		
		if(toRemoveLevelThreeCategoryList == null){
			return levelTwoCategory;
		}
		if(toRemoveLevelThreeCategoryList.isEmpty()){
			return levelTwoCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelThreeCategoryDAO().removeLevelThreeCategoryList(toRemoveLevelThreeCategoryList,options);
		
		return levelTwoCategory;
	
	}
	
	
	
 	
 	
	
	
	
		

	public LevelTwoCategory present(LevelTwoCategory levelTwoCategory,Map<String, Object> options){
	
		presentLevelThreeCategoryList(levelTwoCategory,options);

		return levelTwoCategory;
	
	}
		
	
  	
 	protected LevelTwoCategory presentLevelThreeCategoryList(
			LevelTwoCategory levelTwoCategory,
			Map<String, Object> options) {

		SmartList<LevelThreeCategory> levelThreeCategoryList = levelTwoCategory.getLevelThreeCategoryList();		
		if(levelThreeCategoryList == null){
			return levelTwoCategory;			
		}
		
		String targetObjectName = "levelThreeCategory";
		int levelThreeCategoryListSize = levelThreeCategoryList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(levelThreeCategoryListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return levelTwoCategory;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = levelThreeCategoryListSize;
		if(levelThreeCategoryListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getLevelThreeCategoryDAO().countLevelThreeCategoryByParentCategory(levelTwoCategory.getId(), options);			
		}
		//levelTwoCategory.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//levelTwoCategory.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(levelThreeCategoryListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(levelThreeCategoryListSize,currentPage,rowsPerPage) ;
			levelThreeCategoryList = levelThreeCategoryList.subListOf(fromIndex, toIndex);
			levelThreeCategoryList.setTotalCount(count);
			levelThreeCategoryList.setCurrentPageNumber(currentPage);			
			levelTwoCategory.setLevelThreeCategoryList(levelThreeCategoryList);
			return levelTwoCategory;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		levelThreeCategoryList 
			= getLevelThreeCategoryDAO().findLevelThreeCategoryByParentCategory(levelTwoCategory.getId(),start, rowsPerPage, options );
		levelThreeCategoryList.setTotalCount(count);
		levelThreeCategoryList.setCurrentPageNumber(currentPage);
		levelTwoCategory.setLevelThreeCategoryList(levelThreeCategoryList );	

		return levelTwoCategory;
	}			
		


	protected String getTableName(){
		return LevelTwoCategoryTable.TABLE_NAME;
	}
}


