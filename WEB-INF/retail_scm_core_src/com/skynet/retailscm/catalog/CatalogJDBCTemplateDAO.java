
package com.skynet.retailscm.catalog;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.levelonecategory.LevelOneCategory;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.levelonecategory.LevelOneCategoryDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.levelonecategory.LevelOneCategoryTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class CatalogJDBCTemplateDAO extends CommonJDBCTemplateDAO implements CatalogDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  LevelOneCategoryDAO  levelOneCategoryDAO;
 	public void setLevelOneCategoryDAO(LevelOneCategoryDAO pLevelOneCategoryDAO){
 	
 		if(pLevelOneCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelOneCategoryDAO to null.");
 		}
	 	this.levelOneCategoryDAO = pLevelOneCategoryDAO;
 	}
 	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
 		if(this.levelOneCategoryDAO == null){
 			throw new IllegalStateException("The levelOneCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelOneCategoryDAO;
 	}	
 	
			
		

	
	/*
	protected Catalog load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCatalog(accessKey, options);
	}
	*/
	public Catalog load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCatalog(CatalogTable.withId(id), options);
	}
	
	
	
	public Catalog save(Catalog catalog,Map<String,Object> options){
		
		String methodName="save(Catalog catalog,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(catalog, methodName, "catalog");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCatalog(catalog,options);
	}
	public Catalog clone(String catalogId, Map<String,Object> options) throws Exception{
	
		return clone(CatalogTable.withId(catalogId),options);
	}
	
	protected Catalog clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String catalogId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Catalog newCatalog = loadInternalCatalog(accessKey, options);
		newCatalog.setVersion(0);
		
		
 		
 		if(isSaveLevelOneCategoryListEnabled(options)){
 			for(LevelOneCategory item: newCatalog.getLevelOneCategoryList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCatalog(newCatalog,options);
		
		return newCatalog;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String catalogId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{catalogId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new CatalogVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CatalogNotFoundException(
					"The " + this.getTableName() + "(" + catalogId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String catalogId, int version) throws Exception{
	
		String methodName="delete(String catalogId, int version)";
		assertMethodArgumentNotNull(catalogId, methodName, "catalogId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{catalogId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(catalogId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"display_name","owner"};
		return CatalogTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "catalog";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CatalogTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CatalogTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CatalogTokens.OWNER);
 	}
 	

 	
 
		
	//protected static final String LEVEL_ONE_CATEGORY_LIST = "levelOneCategoryList";
	
	protected boolean isExtractLevelOneCategoryListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,CatalogTokens.LEVEL_ONE_CATEGORY_LIST);
		
 	}

	protected boolean isSaveLevelOneCategoryListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.LEVEL_ONE_CATEGORY_LIST);
		
 	}
 	
 	
			
		

	

	protected CatalogMapper getCatalogMapper(){
		return new CatalogMapper();
	}
	protected Catalog extractCatalog(String catalogId) throws Exception{
		String SQL = "select * from catalog_data where id = ?";	
		try{
		
			Catalog catalog = queryForObject(SQL, new Object[]{catalogId}, getCatalogMapper());
			return catalog;
		}catch(EmptyResultDataAccessException e){
			throw new CatalogNotFoundException("Catalog("+catalogId+") is not found!");
		}
		
		
	}
	protected Catalog extractCatalog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from catalog_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Catalog catalog = queryForObject(SQL, new Object[]{accessKey.getValue()}, getCatalogMapper());
			return catalog;
		}catch(EmptyResultDataAccessException e){
			throw new CatalogNotFoundException("Catalog("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Catalog loadInternalCatalog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Catalog catalog = extractCatalog(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(catalog, loadOptions);
 		}
 
		
		if(isExtractLevelOneCategoryListEnabled(loadOptions)){
	 		extractLevelOneCategoryList(catalog, loadOptions);
 		}		
		
		return catalog;
		
	}



	
	
	 

 	protected Catalog extractOwner(Catalog catalog, Map<String,Object> options) throws Exception{

		if(catalog.getOwner() == null){
			return catalog;
		}
		String ownerId = catalog.getOwner().getId();
		if( ownerId == null){
			return catalog;
		}
		RetailStoreCountryCenter owner = getRetailStoreCountryCenterDAO().load(ownerId,options);
		if(owner != null){
			catalog.setOwner(owner);
		}
		
 		
 		return catalog;
 	}
 		
 
		
	protected Catalog extractLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		SmartList<LevelOneCategory> levelOneCategoryList = getLevelOneCategoryDAO().findLevelOneCategoryByCatalog(catalog.getId(),options);
		if(levelOneCategoryList != null){
			catalog.setLevelOneCategoryList(levelOneCategoryList);
		}
		
		return catalog;
	
	}	
		
		
  	
 	public SmartList<Catalog> findCatalogByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<Catalog> catalogList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getCatalogMapper());	
 		return catalogList;
 	}
 	
 	public SmartList<Catalog> findCatalogByOwner(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Catalog> catalogList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getCatalogMapper());
		
 		return catalogList;
 	}
 	
 	public int countCatalogByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected Catalog saveCatalog(Catalog  catalog){
	
		String SQL=this.getSaveCatalogSQL(catalog);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCatalogParameters(catalog);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		catalog.incVersion();
		return catalog;
	
	}
	public SmartList<Catalog> saveCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCatalogList(catalogList);
		
		batchCatalogCreate((List<Catalog>)lists[CREATE_LIST_INDEX]);
		
		batchCatalogUpdate((List<Catalog>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Catalog catalog:catalogList){
			if(catalog.isChanged()){
				catalog.incVersion();
			}
			
		
		}
		
		
		return catalogList;
	}

	public SmartList<Catalog> removeCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		
		
		super.removeList(catalogList, options);
		
		return catalogList;
		
		
	}
	
	protected List<Object[]> prepareCatalogBatchCreateArgs(List<Catalog> catalogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Catalog catalog:catalogList ){
			Object [] parameters = prepareCatalogCreateParameters(catalog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCatalogBatchUpdateArgs(List<Catalog> catalogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Catalog catalog:catalogList ){
			if(!catalog.isChanged()){
				continue;
			}
			Object [] parameters = prepareCatalogUpdateParameters(catalog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCatalogCreate(List<Catalog> catalogList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCatalogBatchCreateArgs(catalogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCatalogUpdate(List<Catalog> catalogList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCatalogBatchUpdateArgs(catalogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCatalogList(List<Catalog> catalogList){
		
		List<Catalog> catalogCreateList=new ArrayList<Catalog>();
		List<Catalog> catalogUpdateList=new ArrayList<Catalog>();
		
		for(Catalog catalog: catalogList){
			if(isUpdateRequest(catalog)){
				catalogUpdateList.add( catalog);
				continue;
			}
			catalogCreateList.add(catalog);
		}
		
		return new Object[]{catalogCreateList,catalogUpdateList};
	}
	
	protected boolean isUpdateRequest(Catalog catalog){
 		return catalog.getVersion() > 0;
 	}
 	protected String getSaveCatalogSQL(Catalog catalog){
 		if(isUpdateRequest(catalog)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCatalogParameters(Catalog catalog){
 		if(isUpdateRequest(catalog) ){
 			return prepareCatalogUpdateParameters(catalog);
 		}
 		return prepareCatalogCreateParameters(catalog);
 	}
 	protected Object[] prepareCatalogUpdateParameters(Catalog catalog){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = catalog.getDisplayName(); 	
 		if(catalog.getOwner() != null){
 			parameters[1] = catalog.getOwner().getId();
 		}
 		
 		parameters[2] = catalog.getId();
 		parameters[3] = catalog.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCatalogCreateParameters(Catalog catalog){
		Object[] parameters = new Object[3];
		String newCatalogId=getNextId();
		catalog.setId(newCatalogId);
		parameters[0] =  catalog.getId();
 
 		parameters[1] = catalog.getDisplayName(); 	
 		if(catalog.getOwner() != null){
 			parameters[2] = catalog.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Catalog saveInternalCatalog(Catalog catalog, Map<String,Object> options){
		
		saveCatalog(catalog);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(catalog, options);
 		}
 
		
		if(isSaveLevelOneCategoryListEnabled(options)){
	 		saveLevelOneCategoryList(catalog, options);
	 		removeLevelOneCategoryList(catalog, options);
	 		
 		}		
		
		return catalog;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Catalog saveOwner(Catalog catalog, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(catalog.getOwner() == null){
 			return catalog;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(catalog.getOwner(),options);
 		return catalog;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected Catalog saveLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList == null){
			return catalog;
		}
		if(levelOneCategoryList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getLevelOneCategoryDAO().saveLevelOneCategoryList(levelOneCategoryList,options);
		
		return catalog;
	
	}
	
	protected Catalog removeLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList == null){
			return catalog;
		}	
	
		SmartList<LevelOneCategory> toRemoveLevelOneCategoryList = levelOneCategoryList.getToRemoveList();
		
		if(toRemoveLevelOneCategoryList == null){
			return catalog;
		}
		if(toRemoveLevelOneCategoryList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelOneCategoryDAO().removeLevelOneCategoryList(toRemoveLevelOneCategoryList,options);
		
		return catalog;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Catalog present(Catalog catalog,Map<String, Object> options){
	
		presentLevelOneCategoryList(catalog,options);

		return catalog;
	
	}
		
	
  	
 	protected Catalog presentLevelOneCategoryList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();		
		if(levelOneCategoryList == null){
			return catalog;			
		}
		
		String targetObjectName = "levelOneCategory";
		int levelOneCategoryListSize = levelOneCategoryList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(levelOneCategoryListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return catalog;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = levelOneCategoryListSize;
		if(levelOneCategoryListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getLevelOneCategoryDAO().countLevelOneCategoryByCatalog(catalog.getId(), options);			
		}
		//catalog.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//catalog.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(levelOneCategoryListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(levelOneCategoryListSize,currentPage,rowsPerPage) ;
			levelOneCategoryList = levelOneCategoryList.subListOf(fromIndex, toIndex);
			levelOneCategoryList.setTotalCount(count);
			levelOneCategoryList.setCurrentPageNumber(currentPage);			
			catalog.setLevelOneCategoryList(levelOneCategoryList);
			return catalog;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		levelOneCategoryList 
			= getLevelOneCategoryDAO().findLevelOneCategoryByCatalog(catalog.getId(),start, rowsPerPage, options );
		levelOneCategoryList.setTotalCount(count);
		levelOneCategoryList.setCurrentPageNumber(currentPage);
		catalog.setLevelOneCategoryList(levelOneCategoryList );	

		return catalog;
	}			
		


	protected String getTableName(){
		return CatalogTable.TABLE_NAME;
	}
}


