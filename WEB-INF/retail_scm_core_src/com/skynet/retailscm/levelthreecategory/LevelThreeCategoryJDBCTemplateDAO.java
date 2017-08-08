
package com.skynet.retailscm.levelthreecategory;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;

import com.skynet.retailscm.leveltwocategory.LevelTwoCategoryDAO;
import com.skynet.retailscm.product.ProductDAO;

import com.skynet.retailscm.leveltwocategory.LevelTwoCategoryTable;
import com.skynet.retailscm.product.ProductTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class LevelThreeCategoryJDBCTemplateDAO extends CommonJDBCTemplateDAO implements LevelThreeCategoryDAO{
 
 	
 	private  LevelTwoCategoryDAO  levelTwoCategoryDAO;
 	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO levelTwoCategoryDAO){
	 	this.levelTwoCategoryDAO = levelTwoCategoryDAO;
 	}
 	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
	 	return this.levelTwoCategoryDAO;
 	}

		
	
  	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO pProductDAO){
 	
 		if(pProductDAO == null){
 			throw new IllegalStateException("Do not try to set productDAO to null.");
 		}
	 	this.productDAO = pProductDAO;
 	}
 	public ProductDAO getProductDAO(){
 		if(this.productDAO == null){
 			throw new IllegalStateException("The productDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productDAO;
 	}	
 	
			
		

	
	/*
	protected LevelThreeCategory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelThreeCategory(accessKey, options);
	}
	*/
	public LevelThreeCategory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelThreeCategory(LevelThreeCategoryTable.withId(id), options);
	}
	
	
	
	public LevelThreeCategory save(LevelThreeCategory levelThreeCategory,Map<String,Object> options){
		
		String methodName="save(LevelThreeCategory levelThreeCategory,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelThreeCategory, methodName, "levelThreeCategory");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelThreeCategory(levelThreeCategory,options);
	}
	public LevelThreeCategory clone(String levelThreeCategoryId, Map<String,Object> options) throws Exception{
	
		return clone(LevelThreeCategoryTable.withId(levelThreeCategoryId),options);
	}
	
	protected LevelThreeCategory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelThreeCategoryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelThreeCategory newLevelThreeCategory = loadInternalLevelThreeCategory(accessKey, options);
		newLevelThreeCategory.setVersion(0);
		
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newLevelThreeCategory.getProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelThreeCategory(newLevelThreeCategory,options);
		
		return newLevelThreeCategory;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String levelThreeCategoryId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{levelThreeCategoryId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new LevelThreeCategoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelThreeCategoryNotFoundException(
					"The " + this.getTableName() + "(" + levelThreeCategoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String levelThreeCategoryId, int version) throws Exception{
	
		String methodName="delete(String levelThreeCategoryId, int version)";
		assertMethodArgumentNotNull(levelThreeCategoryId, methodName, "levelThreeCategoryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelThreeCategoryId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelThreeCategoryId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"parent_category","display_name"};
		return LevelThreeCategoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_three_category";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelThreeCategoryTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractParentCategoryEnabled = true;
 	//private static final String PARENTCATEGORY = "parentCategory";
 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelThreeCategoryTokens.PARENTCATEGORY);
 	}
 	
 	
 	//private boolean saveParentCategoryEnabled = true;
 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelThreeCategoryTokens.PARENTCATEGORY);
 	}
 	

 	
 
		
	//protected static final String PRODUCT_LIST = "productList";
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,LevelThreeCategoryTokens.PRODUCT_LIST);
		
 	}

	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelThreeCategoryTokens.PRODUCT_LIST);
		
 	}
 	
 	
			
		

	

	protected LevelThreeCategoryMapper getLevelThreeCategoryMapper(){
		return new LevelThreeCategoryMapper();
	}
	protected LevelThreeCategory extractLevelThreeCategory(String levelThreeCategoryId) throws Exception{
		String SQL = "select * from level_three_category_data where id = ?";	
		try{
		
			LevelThreeCategory levelThreeCategory = queryForObject(SQL, new Object[]{levelThreeCategoryId}, getLevelThreeCategoryMapper());
			return levelThreeCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelThreeCategoryNotFoundException("LevelThreeCategory("+levelThreeCategoryId+") is not found!");
		}
		
		
	}
	protected LevelThreeCategory extractLevelThreeCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from level_three_category_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			LevelThreeCategory levelThreeCategory = queryForObject(SQL, new Object[]{accessKey.getValue()}, getLevelThreeCategoryMapper());
			return levelThreeCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelThreeCategoryNotFoundException("LevelThreeCategory("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected LevelThreeCategory loadInternalLevelThreeCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelThreeCategory levelThreeCategory = extractLevelThreeCategory(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(levelThreeCategory, loadOptions);
 		}
 
		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(levelThreeCategory, loadOptions);
 		}		
		
		return levelThreeCategory;
		
	}



	
	
	 

 	protected LevelThreeCategory extractParentCategory(LevelThreeCategory levelThreeCategory, Map<String,Object> options) throws Exception{

		if(levelThreeCategory.getParentCategory() == null){
			return levelThreeCategory;
		}
		String parentCategoryId = levelThreeCategory.getParentCategory().getId();
		if( parentCategoryId == null){
			return levelThreeCategory;
		}
		LevelTwoCategory parentCategory = getLevelTwoCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			levelThreeCategory.setParentCategory(parentCategory);
		}
		
 		
 		return levelThreeCategory;
 	}
 		
 
		
	protected LevelThreeCategory extractProductList(LevelThreeCategory levelThreeCategory, Map<String,Object> options){
		
		SmartList<Product> productList = getProductDAO().findProductByParentCategory(levelThreeCategory.getId(),options);
		if(productList != null){
			levelThreeCategory.setProductList(productList);
		}
		
		return levelThreeCategory;
	
	}	
		
		
  	
 	public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(String levelTwoCategoryId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where parent_category = ?";
		SmartList<LevelThreeCategory> levelThreeCategoryList = queryForList(SQL, new Object[]{levelTwoCategoryId}, getLevelThreeCategoryMapper());	
 		return levelThreeCategoryList;
 	}
 	
 	public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(String levelTwoCategoryId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where parent_category = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<LevelThreeCategory> levelThreeCategoryList = queryForList(SQL, new Object[]{levelTwoCategoryId,start, count}, getLevelThreeCategoryMapper());
		
 		return levelThreeCategoryList;
 	}
 	
 	public int countLevelThreeCategoryByParentCategory(String levelTwoCategoryId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where parent_category = ?";
		Integer count = queryInt(SQL, new Object[]{levelTwoCategoryId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected LevelThreeCategory saveLevelThreeCategory(LevelThreeCategory  levelThreeCategory){
	
		String SQL=this.getSaveLevelThreeCategorySQL(levelThreeCategory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelThreeCategoryParameters(levelThreeCategory);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelThreeCategory.incVersion();
		return levelThreeCategory;
	
	}
	public SmartList<LevelThreeCategory> saveLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelThreeCategoryList(levelThreeCategoryList);
		
		batchLevelThreeCategoryCreate((List<LevelThreeCategory>)lists[CREATE_LIST_INDEX]);
		
		batchLevelThreeCategoryUpdate((List<LevelThreeCategory>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelThreeCategory levelThreeCategory:levelThreeCategoryList){
			if(levelThreeCategory.isChanged()){
				levelThreeCategory.incVersion();
			}
			
		
		}
		
		
		return levelThreeCategoryList;
	}

	public SmartList<LevelThreeCategory> removeLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList,Map<String,Object> options){
		
		
		super.removeList(levelThreeCategoryList, options);
		
		return levelThreeCategoryList;
		
		
	}
	
	protected List<Object[]> prepareLevelThreeCategoryBatchCreateArgs(List<LevelThreeCategory> levelThreeCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelThreeCategory levelThreeCategory:levelThreeCategoryList ){
			Object [] parameters = prepareLevelThreeCategoryCreateParameters(levelThreeCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelThreeCategoryBatchUpdateArgs(List<LevelThreeCategory> levelThreeCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelThreeCategory levelThreeCategory:levelThreeCategoryList ){
			if(!levelThreeCategory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelThreeCategoryUpdateParameters(levelThreeCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelThreeCategoryCreate(List<LevelThreeCategory> levelThreeCategoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelThreeCategoryBatchCreateArgs(levelThreeCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelThreeCategoryUpdate(List<LevelThreeCategory> levelThreeCategoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelThreeCategoryBatchUpdateArgs(levelThreeCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelThreeCategoryList(List<LevelThreeCategory> levelThreeCategoryList){
		
		List<LevelThreeCategory> levelThreeCategoryCreateList=new ArrayList<LevelThreeCategory>();
		List<LevelThreeCategory> levelThreeCategoryUpdateList=new ArrayList<LevelThreeCategory>();
		
		for(LevelThreeCategory levelThreeCategory: levelThreeCategoryList){
			if(isUpdateRequest(levelThreeCategory)){
				levelThreeCategoryUpdateList.add( levelThreeCategory);
				continue;
			}
			levelThreeCategoryCreateList.add(levelThreeCategory);
		}
		
		return new Object[]{levelThreeCategoryCreateList,levelThreeCategoryUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelThreeCategory levelThreeCategory){
 		return levelThreeCategory.getVersion() > 0;
 	}
 	protected String getSaveLevelThreeCategorySQL(LevelThreeCategory levelThreeCategory){
 		if(isUpdateRequest(levelThreeCategory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelThreeCategoryParameters(LevelThreeCategory levelThreeCategory){
 		if(isUpdateRequest(levelThreeCategory) ){
 			return prepareLevelThreeCategoryUpdateParameters(levelThreeCategory);
 		}
 		return prepareLevelThreeCategoryCreateParameters(levelThreeCategory);
 	}
 	protected Object[] prepareLevelThreeCategoryUpdateParameters(LevelThreeCategory levelThreeCategory){
 		Object[] parameters = new Object[4];
  	
 		if(levelThreeCategory.getParentCategory() != null){
 			parameters[0] = levelThreeCategory.getParentCategory().getId();
 		}
 
 		parameters[1] = levelThreeCategory.getDisplayName();		
 		parameters[2] = levelThreeCategory.getId();
 		parameters[3] = levelThreeCategory.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelThreeCategoryCreateParameters(LevelThreeCategory levelThreeCategory){
		Object[] parameters = new Object[3];
		String newLevelThreeCategoryId=getNextId();
		levelThreeCategory.setId(newLevelThreeCategoryId);
		parameters[0] =  levelThreeCategory.getId();
  	
 		if(levelThreeCategory.getParentCategory() != null){
 			parameters[1] = levelThreeCategory.getParentCategory().getId();
 		
 		}
 		
 		parameters[2] = levelThreeCategory.getDisplayName();		
 				
 		return parameters;
 	}
 	
	protected LevelThreeCategory saveInternalLevelThreeCategory(LevelThreeCategory levelThreeCategory, Map<String,Object> options){
		
		saveLevelThreeCategory(levelThreeCategory);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(levelThreeCategory, options);
 		}
 
		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(levelThreeCategory, options);
	 		removeProductList(levelThreeCategory, options);
	 		
 		}		
		
		return levelThreeCategory;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelThreeCategory saveParentCategory(LevelThreeCategory levelThreeCategory, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelThreeCategory.getParentCategory() == null){
 			return levelThreeCategory;//do nothing when it is null
 		}
 		
 		getLevelTwoCategoryDAO().save(levelThreeCategory.getParentCategory(),options);
 		return levelThreeCategory;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected LevelThreeCategory saveProductList(LevelThreeCategory levelThreeCategory, Map<String,Object> options){
		SmartList<Product> productList = levelThreeCategory.getProductList();
		if(productList == null){
			return levelThreeCategory;
		}
		if(productList.isEmpty()){
			return levelThreeCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getProductDAO().saveProductList(productList,options);
		
		return levelThreeCategory;
	
	}
	
	protected LevelThreeCategory removeProductList(LevelThreeCategory levelThreeCategory, Map<String,Object> options){
	
	
		SmartList<Product> productList = levelThreeCategory.getProductList();
		if(productList == null){
			return levelThreeCategory;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return levelThreeCategory;
		}
		if(toRemoveProductList.isEmpty()){
			return levelThreeCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return levelThreeCategory;
	
	}
	
	
	
 	
 	
	
	
	
		

	public LevelThreeCategory present(LevelThreeCategory levelThreeCategory,Map<String, Object> options){
	
		presentProductList(levelThreeCategory,options);

		return levelThreeCategory;
	
	}
		
	
  	
 	protected LevelThreeCategory presentProductList(
			LevelThreeCategory levelThreeCategory,
			Map<String, Object> options) {

		SmartList<Product> productList = levelThreeCategory.getProductList();		
		if(productList == null){
			return levelThreeCategory;			
		}
		
		String targetObjectName = "product";
		int productListSize = productList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(productListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return levelThreeCategory;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = productListSize;
		if(productListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getProductDAO().countProductByParentCategory(levelThreeCategory.getId(), options);			
		}
		//levelThreeCategory.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//levelThreeCategory.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(productListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(productListSize,currentPage,rowsPerPage) ;
			productList = productList.subListOf(fromIndex, toIndex);
			productList.setTotalCount(count);
			productList.setCurrentPageNumber(currentPage);			
			levelThreeCategory.setProductList(productList);
			return levelThreeCategory;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		productList 
			= getProductDAO().findProductByParentCategory(levelThreeCategory.getId(),start, rowsPerPage, options );
		productList.setTotalCount(count);
		productList.setCurrentPageNumber(currentPage);
		levelThreeCategory.setProductList(productList );	

		return levelThreeCategory;
	}			
		


	protected String getTableName(){
		return LevelThreeCategoryTable.TABLE_NAME;
	}
}


