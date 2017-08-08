
package com.skynet.retailscm.product;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;

import com.skynet.retailscm.levelthreecategory.LevelThreeCategoryDAO;
import com.skynet.retailscm.sku.SkuDAO;

import com.skynet.retailscm.levelthreecategory.LevelThreeCategoryTable;
import com.skynet.retailscm.sku.SkuTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ProductJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ProductDAO{
 
 	
 	private  LevelThreeCategoryDAO  levelThreeCategoryDAO;
 	public void setLevelThreeCategoryDAO(LevelThreeCategoryDAO levelThreeCategoryDAO){
	 	this.levelThreeCategoryDAO = levelThreeCategoryDAO;
 	}
 	public LevelThreeCategoryDAO getLevelThreeCategoryDAO(){
	 	return this.levelThreeCategoryDAO;
 	}

		
	
  	private  SkuDAO  skuDAO;
 	public void setSkuDAO(SkuDAO pSkuDAO){
 	
 		if(pSkuDAO == null){
 			throw new IllegalStateException("Do not try to set skuDAO to null.");
 		}
	 	this.skuDAO = pSkuDAO;
 	}
 	public SkuDAO getSkuDAO(){
 		if(this.skuDAO == null){
 			throw new IllegalStateException("The skuDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.skuDAO;
 	}	
 	
			
		

	
	/*
	protected Product load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProduct(accessKey, options);
	}
	*/
	public Product load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProduct(ProductTable.withId(id), options);
	}
	
	
	
	public Product save(Product product,Map<String,Object> options){
		
		String methodName="save(Product product,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(product, methodName, "product");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProduct(product,options);
	}
	public Product clone(String productId, Map<String,Object> options) throws Exception{
	
		return clone(ProductTable.withId(productId),options);
	}
	
	protected Product clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String productId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Product newProduct = loadInternalProduct(accessKey, options);
		newProduct.setVersion(0);
		
		
 		
 		if(isSaveSkuListEnabled(options)){
 			for(Sku item: newProduct.getSkuList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalProduct(newProduct,options);
		
		return newProduct;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String productId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{productId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProductNotFoundException(
					"The " + this.getTableName() + "(" + productId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String productId, int version) throws Exception{
	
		String methodName="delete(String productId, int version)";
		assertMethodArgumentNotNull(productId, methodName, "productId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{productId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(productId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"display_name","parent_category","origin","remark","brand","picture"};
		return ProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "product";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProductTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractParentCategoryEnabled = true;
 	//private static final String PARENTCATEGORY = "parentCategory";
 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProductTokens.PARENTCATEGORY);
 	}
 	
 	
 	//private boolean saveParentCategoryEnabled = true;
 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProductTokens.PARENTCATEGORY);
 	}
 	

 	
 
		
	//protected static final String SKU_LIST = "skuList";
	
	protected boolean isExtractSkuListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ProductTokens.SKU_LIST);
		
 	}

	protected boolean isSaveSkuListEnabled(Map<String,Object> options){
		return checkOptions(options, ProductTokens.SKU_LIST);
		
 	}
 	
 	
			
		

	

	protected ProductMapper getProductMapper(){
		return new ProductMapper();
	}
	protected Product extractProduct(String productId) throws Exception{
		String SQL = "select * from product_data where id = ?";	
		try{
		
			Product product = queryForObject(SQL, new Object[]{productId}, getProductMapper());
			return product;
		}catch(EmptyResultDataAccessException e){
			throw new ProductNotFoundException("Product("+productId+") is not found!");
		}
		
		
	}
	protected Product extractProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from product_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Product product = queryForObject(SQL, new Object[]{accessKey.getValue()}, getProductMapper());
			return product;
		}catch(EmptyResultDataAccessException e){
			throw new ProductNotFoundException("Product("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Product loadInternalProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Product product = extractProduct(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(product, loadOptions);
 		}
 
		
		if(isExtractSkuListEnabled(loadOptions)){
	 		extractSkuList(product, loadOptions);
 		}		
		
		return product;
		
	}



	
	
	 

 	protected Product extractParentCategory(Product product, Map<String,Object> options) throws Exception{

		if(product.getParentCategory() == null){
			return product;
		}
		String parentCategoryId = product.getParentCategory().getId();
		if( parentCategoryId == null){
			return product;
		}
		LevelThreeCategory parentCategory = getLevelThreeCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			product.setParentCategory(parentCategory);
		}
		
 		
 		return product;
 	}
 		
 
		
	protected Product extractSkuList(Product product, Map<String,Object> options){
		
		SmartList<Sku> skuList = getSkuDAO().findSkuByProduct(product.getId(),options);
		if(skuList != null){
			product.setSkuList(skuList);
		}
		
		return product;
	
	}	
		
		
  	
 	public SmartList<Product> findProductByParentCategory(String levelThreeCategoryId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where parent_category = ?";
		SmartList<Product> productList = queryForList(SQL, new Object[]{levelThreeCategoryId}, getProductMapper());	
 		return productList;
 	}
 	
 	public SmartList<Product> findProductByParentCategory(String levelThreeCategoryId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where parent_category = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Product> productList = queryForList(SQL, new Object[]{levelThreeCategoryId,start, count}, getProductMapper());
		
 		return productList;
 	}
 	
 	public int countProductByParentCategory(String levelThreeCategoryId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where parent_category = ?";
		Integer count = queryInt(SQL, new Object[]{levelThreeCategoryId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected Product saveProduct(Product  product){
	
		String SQL=this.getSaveProductSQL(product);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProductParameters(product);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		product.incVersion();
		return product;
	
	}
	public SmartList<Product> saveProductList(SmartList<Product> productList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProductList(productList);
		
		batchProductCreate((List<Product>)lists[CREATE_LIST_INDEX]);
		
		batchProductUpdate((List<Product>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Product product:productList){
			if(product.isChanged()){
				product.incVersion();
			}
			
		
		}
		
		
		return productList;
	}

	public SmartList<Product> removeProductList(SmartList<Product> productList,Map<String,Object> options){
		
		
		super.removeList(productList, options);
		
		return productList;
		
		
	}
	
	protected List<Object[]> prepareProductBatchCreateArgs(List<Product> productList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Product product:productList ){
			Object [] parameters = prepareProductCreateParameters(product);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProductBatchUpdateArgs(List<Product> productList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Product product:productList ){
			if(!product.isChanged()){
				continue;
			}
			Object [] parameters = prepareProductUpdateParameters(product);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProductCreate(List<Product> productList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProductBatchCreateArgs(productList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProductUpdate(List<Product> productList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProductBatchUpdateArgs(productList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProductList(List<Product> productList){
		
		List<Product> productCreateList=new ArrayList<Product>();
		List<Product> productUpdateList=new ArrayList<Product>();
		
		for(Product product: productList){
			if(isUpdateRequest(product)){
				productUpdateList.add( product);
				continue;
			}
			productCreateList.add(product);
		}
		
		return new Object[]{productCreateList,productUpdateList};
	}
	
	protected boolean isUpdateRequest(Product product){
 		return product.getVersion() > 0;
 	}
 	protected String getSaveProductSQL(Product product){
 		if(isUpdateRequest(product)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProductParameters(Product product){
 		if(isUpdateRequest(product) ){
 			return prepareProductUpdateParameters(product);
 		}
 		return prepareProductCreateParameters(product);
 	}
 	protected Object[] prepareProductUpdateParameters(Product product){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = product.getDisplayName(); 	
 		if(product.getParentCategory() != null){
 			parameters[1] = product.getParentCategory().getId();
 		}
 
 		parameters[2] = product.getOrigin();
 		parameters[3] = product.getRemark();
 		parameters[4] = product.getBrand();
 		parameters[5] = product.getPicture();		
 		parameters[6] = product.getId();
 		parameters[7] = product.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProductCreateParameters(Product product){
		Object[] parameters = new Object[7];
		String newProductId=getNextId();
		product.setId(newProductId);
		parameters[0] =  product.getId();
 
 		parameters[1] = product.getDisplayName(); 	
 		if(product.getParentCategory() != null){
 			parameters[2] = product.getParentCategory().getId();
 		
 		}
 		
 		parameters[3] = product.getOrigin();
 		parameters[4] = product.getRemark();
 		parameters[5] = product.getBrand();
 		parameters[6] = product.getPicture();		
 				
 		return parameters;
 	}
 	
	protected Product saveInternalProduct(Product product, Map<String,Object> options){
		
		saveProduct(product);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(product, options);
 		}
 
		
		if(isSaveSkuListEnabled(options)){
	 		saveSkuList(product, options);
	 		removeSkuList(product, options);
	 		
 		}		
		
		return product;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Product saveParentCategory(Product product, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(product.getParentCategory() == null){
 			return product;//do nothing when it is null
 		}
 		
 		getLevelThreeCategoryDAO().save(product.getParentCategory(),options);
 		return product;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected Product saveSkuList(Product product, Map<String,Object> options){
		SmartList<Sku> skuList = product.getSkuList();
		if(skuList == null){
			return product;
		}
		if(skuList.isEmpty()){
			return product;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSkuDAO().saveSkuList(skuList,options);
		
		return product;
	
	}
	
	protected Product removeSkuList(Product product, Map<String,Object> options){
	
	
		SmartList<Sku> skuList = product.getSkuList();
		if(skuList == null){
			return product;
		}	
	
		SmartList<Sku> toRemoveSkuList = skuList.getToRemoveList();
		
		if(toRemoveSkuList == null){
			return product;
		}
		if(toRemoveSkuList.isEmpty()){
			return product;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSkuDAO().removeSkuList(toRemoveSkuList,options);
		
		return product;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Product present(Product product,Map<String, Object> options){
	
		presentSkuList(product,options);

		return product;
	
	}
		
	
  	
 	protected Product presentSkuList(
			Product product,
			Map<String, Object> options) {

		SmartList<Sku> skuList = product.getSkuList();		
		if(skuList == null){
			return product;			
		}
		
		String targetObjectName = "sku";
		int skuListSize = skuList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(skuListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return product;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = skuListSize;
		if(skuListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSkuDAO().countSkuByProduct(product.getId(), options);			
		}
		//product.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//product.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(skuListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(skuListSize,currentPage,rowsPerPage) ;
			skuList = skuList.subListOf(fromIndex, toIndex);
			skuList.setTotalCount(count);
			skuList.setCurrentPageNumber(currentPage);			
			product.setSkuList(skuList);
			return product;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		skuList 
			= getSkuDAO().findSkuByProduct(product.getId(),start, rowsPerPage, options );
		skuList.setTotalCount(count);
		skuList.setCurrentPageNumber(currentPage);
		product.setSkuList(skuList );	

		return product;
	}			
		


	protected String getTableName(){
		return ProductTable.TABLE_NAME;
	}
}


