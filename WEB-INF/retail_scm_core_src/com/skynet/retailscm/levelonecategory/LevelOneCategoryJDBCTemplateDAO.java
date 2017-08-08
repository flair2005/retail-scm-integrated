
package com.skynet.retailscm.levelonecategory;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.catalog.Catalog;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;

import com.skynet.retailscm.leveltwocategory.LevelTwoCategoryDAO;
import com.skynet.retailscm.catalog.CatalogDAO;

import com.skynet.retailscm.catalog.CatalogTable;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategoryTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class LevelOneCategoryJDBCTemplateDAO extends CommonJDBCTemplateDAO implements LevelOneCategoryDAO{
 
 	
 	private  CatalogDAO  catalogDAO;
 	public void setCatalogDAO(CatalogDAO catalogDAO){
	 	this.catalogDAO = catalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
	 	return this.catalogDAO;
 	}

		
	
  	private  LevelTwoCategoryDAO  levelTwoCategoryDAO;
 	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO pLevelTwoCategoryDAO){
 	
 		if(pLevelTwoCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelTwoCategoryDAO to null.");
 		}
	 	this.levelTwoCategoryDAO = pLevelTwoCategoryDAO;
 	}
 	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
 		if(this.levelTwoCategoryDAO == null){
 			throw new IllegalStateException("The levelTwoCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelTwoCategoryDAO;
 	}	
 	
			
		

	
	/*
	protected LevelOneCategory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelOneCategory(accessKey, options);
	}
	*/
	public LevelOneCategory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelOneCategory(LevelOneCategoryTable.withId(id), options);
	}
	
	
	
	public LevelOneCategory save(LevelOneCategory levelOneCategory,Map<String,Object> options){
		
		String methodName="save(LevelOneCategory levelOneCategory,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelOneCategory, methodName, "levelOneCategory");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelOneCategory(levelOneCategory,options);
	}
	public LevelOneCategory clone(String levelOneCategoryId, Map<String,Object> options) throws Exception{
	
		return clone(LevelOneCategoryTable.withId(levelOneCategoryId),options);
	}
	
	protected LevelOneCategory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelOneCategoryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelOneCategory newLevelOneCategory = loadInternalLevelOneCategory(accessKey, options);
		newLevelOneCategory.setVersion(0);
		
		
 		
 		if(isSaveLevelTwoCategoryListEnabled(options)){
 			for(LevelTwoCategory item: newLevelOneCategory.getLevelTwoCategoryList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelOneCategory(newLevelOneCategory,options);
		
		return newLevelOneCategory;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String levelOneCategoryId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{levelOneCategoryId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new LevelOneCategoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelOneCategoryNotFoundException(
					"The " + this.getTableName() + "(" + levelOneCategoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String levelOneCategoryId, int version) throws Exception{
	
		String methodName="delete(String levelOneCategoryId, int version)";
		assertMethodArgumentNotNull(levelOneCategoryId, methodName, "levelOneCategoryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelOneCategoryId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelOneCategoryId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"catalog","display_name"};
		return LevelOneCategoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_one_category";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelOneCategoryTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCatalogEnabled = true;
 	//private static final String CATALOG = "catalog";
 	protected boolean isExtractCatalogEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelOneCategoryTokens.CATALOG);
 	}
 	
 	
 	//private boolean saveCatalogEnabled = true;
 	protected boolean isSaveCatalogEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelOneCategoryTokens.CATALOG);
 	}
 	

 	
 
		
	//protected static final String LEVEL_TWO_CATEGORY_LIST = "levelTwoCategoryList";
	
	protected boolean isExtractLevelTwoCategoryListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,LevelOneCategoryTokens.LEVEL_TWO_CATEGORY_LIST);
		
 	}

	protected boolean isSaveLevelTwoCategoryListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelOneCategoryTokens.LEVEL_TWO_CATEGORY_LIST);
		
 	}
 	
 	
			
		

	

	protected LevelOneCategoryMapper getLevelOneCategoryMapper(){
		return new LevelOneCategoryMapper();
	}
	protected LevelOneCategory extractLevelOneCategory(String levelOneCategoryId) throws Exception{
		String SQL = "select * from level_one_category_data where id = ?";	
		try{
		
			LevelOneCategory levelOneCategory = queryForObject(SQL, new Object[]{levelOneCategoryId}, getLevelOneCategoryMapper());
			return levelOneCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelOneCategoryNotFoundException("LevelOneCategory("+levelOneCategoryId+") is not found!");
		}
		
		
	}
	protected LevelOneCategory extractLevelOneCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from level_one_category_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			LevelOneCategory levelOneCategory = queryForObject(SQL, new Object[]{accessKey.getValue()}, getLevelOneCategoryMapper());
			return levelOneCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelOneCategoryNotFoundException("LevelOneCategory("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected LevelOneCategory loadInternalLevelOneCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelOneCategory levelOneCategory = extractLevelOneCategory(accessKey, loadOptions);
 	
 		if(isExtractCatalogEnabled(loadOptions)){
	 		extractCatalog(levelOneCategory, loadOptions);
 		}
 
		
		if(isExtractLevelTwoCategoryListEnabled(loadOptions)){
	 		extractLevelTwoCategoryList(levelOneCategory, loadOptions);
 		}		
		
		return levelOneCategory;
		
	}



	
	
	 

 	protected LevelOneCategory extractCatalog(LevelOneCategory levelOneCategory, Map<String,Object> options) throws Exception{

		if(levelOneCategory.getCatalog() == null){
			return levelOneCategory;
		}
		String catalogId = levelOneCategory.getCatalog().getId();
		if( catalogId == null){
			return levelOneCategory;
		}
		Catalog catalog = getCatalogDAO().load(catalogId,options);
		if(catalog != null){
			levelOneCategory.setCatalog(catalog);
		}
		
 		
 		return levelOneCategory;
 	}
 		
 
		
	protected LevelOneCategory extractLevelTwoCategoryList(LevelOneCategory levelOneCategory, Map<String,Object> options){
		
		SmartList<LevelTwoCategory> levelTwoCategoryList = getLevelTwoCategoryDAO().findLevelTwoCategoryByParentCategory(levelOneCategory.getId(),options);
		if(levelTwoCategoryList != null){
			levelOneCategory.setLevelTwoCategoryList(levelTwoCategoryList);
		}
		
		return levelOneCategory;
	
	}	
		
		
  	
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where catalog = ?";
		SmartList<LevelOneCategory> levelOneCategoryList = queryForList(SQL, new Object[]{catalogId}, getLevelOneCategoryMapper());	
 		return levelOneCategoryList;
 	}
 	
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where catalog = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<LevelOneCategory> levelOneCategoryList = queryForList(SQL, new Object[]{catalogId,start, count}, getLevelOneCategoryMapper());
		
 		return levelOneCategoryList;
 	}
 	
 	public int countLevelOneCategoryByCatalog(String catalogId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where catalog = ?";
		Integer count = queryInt(SQL, new Object[]{catalogId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected LevelOneCategory saveLevelOneCategory(LevelOneCategory  levelOneCategory){
	
		String SQL=this.getSaveLevelOneCategorySQL(levelOneCategory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelOneCategoryParameters(levelOneCategory);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelOneCategory.incVersion();
		return levelOneCategory;
	
	}
	public SmartList<LevelOneCategory> saveLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelOneCategoryList(levelOneCategoryList);
		
		batchLevelOneCategoryCreate((List<LevelOneCategory>)lists[CREATE_LIST_INDEX]);
		
		batchLevelOneCategoryUpdate((List<LevelOneCategory>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelOneCategory levelOneCategory:levelOneCategoryList){
			if(levelOneCategory.isChanged()){
				levelOneCategory.incVersion();
			}
			
		
		}
		
		
		return levelOneCategoryList;
	}

	public SmartList<LevelOneCategory> removeLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options){
		
		
		super.removeList(levelOneCategoryList, options);
		
		return levelOneCategoryList;
		
		
	}
	
	protected List<Object[]> prepareLevelOneCategoryBatchCreateArgs(List<LevelOneCategory> levelOneCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelOneCategory levelOneCategory:levelOneCategoryList ){
			Object [] parameters = prepareLevelOneCategoryCreateParameters(levelOneCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelOneCategoryBatchUpdateArgs(List<LevelOneCategory> levelOneCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelOneCategory levelOneCategory:levelOneCategoryList ){
			if(!levelOneCategory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelOneCategoryUpdateParameters(levelOneCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelOneCategoryCreate(List<LevelOneCategory> levelOneCategoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelOneCategoryBatchCreateArgs(levelOneCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelOneCategoryUpdate(List<LevelOneCategory> levelOneCategoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelOneCategoryBatchUpdateArgs(levelOneCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelOneCategoryList(List<LevelOneCategory> levelOneCategoryList){
		
		List<LevelOneCategory> levelOneCategoryCreateList=new ArrayList<LevelOneCategory>();
		List<LevelOneCategory> levelOneCategoryUpdateList=new ArrayList<LevelOneCategory>();
		
		for(LevelOneCategory levelOneCategory: levelOneCategoryList){
			if(isUpdateRequest(levelOneCategory)){
				levelOneCategoryUpdateList.add( levelOneCategory);
				continue;
			}
			levelOneCategoryCreateList.add(levelOneCategory);
		}
		
		return new Object[]{levelOneCategoryCreateList,levelOneCategoryUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelOneCategory levelOneCategory){
 		return levelOneCategory.getVersion() > 0;
 	}
 	protected String getSaveLevelOneCategorySQL(LevelOneCategory levelOneCategory){
 		if(isUpdateRequest(levelOneCategory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelOneCategoryParameters(LevelOneCategory levelOneCategory){
 		if(isUpdateRequest(levelOneCategory) ){
 			return prepareLevelOneCategoryUpdateParameters(levelOneCategory);
 		}
 		return prepareLevelOneCategoryCreateParameters(levelOneCategory);
 	}
 	protected Object[] prepareLevelOneCategoryUpdateParameters(LevelOneCategory levelOneCategory){
 		Object[] parameters = new Object[4];
  	
 		if(levelOneCategory.getCatalog() != null){
 			parameters[0] = levelOneCategory.getCatalog().getId();
 		}
 
 		parameters[1] = levelOneCategory.getDisplayName();		
 		parameters[2] = levelOneCategory.getId();
 		parameters[3] = levelOneCategory.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelOneCategoryCreateParameters(LevelOneCategory levelOneCategory){
		Object[] parameters = new Object[3];
		String newLevelOneCategoryId=getNextId();
		levelOneCategory.setId(newLevelOneCategoryId);
		parameters[0] =  levelOneCategory.getId();
  	
 		if(levelOneCategory.getCatalog() != null){
 			parameters[1] = levelOneCategory.getCatalog().getId();
 		
 		}
 		
 		parameters[2] = levelOneCategory.getDisplayName();		
 				
 		return parameters;
 	}
 	
	protected LevelOneCategory saveInternalLevelOneCategory(LevelOneCategory levelOneCategory, Map<String,Object> options){
		
		saveLevelOneCategory(levelOneCategory);
 	
 		if(isSaveCatalogEnabled(options)){
	 		saveCatalog(levelOneCategory, options);
 		}
 
		
		if(isSaveLevelTwoCategoryListEnabled(options)){
	 		saveLevelTwoCategoryList(levelOneCategory, options);
	 		removeLevelTwoCategoryList(levelOneCategory, options);
	 		
 		}		
		
		return levelOneCategory;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelOneCategory saveCatalog(LevelOneCategory levelOneCategory, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelOneCategory.getCatalog() == null){
 			return levelOneCategory;//do nothing when it is null
 		}
 		
 		getCatalogDAO().save(levelOneCategory.getCatalog(),options);
 		return levelOneCategory;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected LevelOneCategory saveLevelTwoCategoryList(LevelOneCategory levelOneCategory, Map<String,Object> options){
		SmartList<LevelTwoCategory> levelTwoCategoryList = levelOneCategory.getLevelTwoCategoryList();
		if(levelTwoCategoryList == null){
			return levelOneCategory;
		}
		if(levelTwoCategoryList.isEmpty()){
			return levelOneCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getLevelTwoCategoryDAO().saveLevelTwoCategoryList(levelTwoCategoryList,options);
		
		return levelOneCategory;
	
	}
	
	protected LevelOneCategory removeLevelTwoCategoryList(LevelOneCategory levelOneCategory, Map<String,Object> options){
	
	
		SmartList<LevelTwoCategory> levelTwoCategoryList = levelOneCategory.getLevelTwoCategoryList();
		if(levelTwoCategoryList == null){
			return levelOneCategory;
		}	
	
		SmartList<LevelTwoCategory> toRemoveLevelTwoCategoryList = levelTwoCategoryList.getToRemoveList();
		
		if(toRemoveLevelTwoCategoryList == null){
			return levelOneCategory;
		}
		if(toRemoveLevelTwoCategoryList.isEmpty()){
			return levelOneCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelTwoCategoryDAO().removeLevelTwoCategoryList(toRemoveLevelTwoCategoryList,options);
		
		return levelOneCategory;
	
	}
	
	
	
 	
 	
	
	
	
		

	public LevelOneCategory present(LevelOneCategory levelOneCategory,Map<String, Object> options){
	
		presentLevelTwoCategoryList(levelOneCategory,options);

		return levelOneCategory;
	
	}
		
	
  	
 	protected LevelOneCategory presentLevelTwoCategoryList(
			LevelOneCategory levelOneCategory,
			Map<String, Object> options) {

		SmartList<LevelTwoCategory> levelTwoCategoryList = levelOneCategory.getLevelTwoCategoryList();		
		if(levelTwoCategoryList == null){
			return levelOneCategory;			
		}
		
		String targetObjectName = "levelTwoCategory";
		int levelTwoCategoryListSize = levelTwoCategoryList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(levelTwoCategoryListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return levelOneCategory;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = levelTwoCategoryListSize;
		if(levelTwoCategoryListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getLevelTwoCategoryDAO().countLevelTwoCategoryByParentCategory(levelOneCategory.getId(), options);			
		}
		//levelOneCategory.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//levelOneCategory.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(levelTwoCategoryListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(levelTwoCategoryListSize,currentPage,rowsPerPage) ;
			levelTwoCategoryList = levelTwoCategoryList.subListOf(fromIndex, toIndex);
			levelTwoCategoryList.setTotalCount(count);
			levelTwoCategoryList.setCurrentPageNumber(currentPage);			
			levelOneCategory.setLevelTwoCategoryList(levelTwoCategoryList);
			return levelOneCategory;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		levelTwoCategoryList 
			= getLevelTwoCategoryDAO().findLevelTwoCategoryByParentCategory(levelOneCategory.getId(),start, rowsPerPage, options );
		levelTwoCategoryList.setTotalCount(count);
		levelTwoCategoryList.setCurrentPageNumber(currentPage);
		levelOneCategory.setLevelTwoCategoryList(levelTwoCategoryList );	

		return levelOneCategory;
	}			
		


	protected String getTableName(){
		return LevelOneCategoryTable.TABLE_NAME;
	}
}


