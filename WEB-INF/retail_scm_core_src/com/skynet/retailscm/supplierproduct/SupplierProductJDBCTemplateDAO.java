
package com.skynet.retailscm.supplierproduct;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.productsupplyduration.ProductSupplyDuration;

import com.skynet.retailscm.goodssupplier.GoodsSupplierDAO;
import com.skynet.retailscm.productsupplyduration.ProductSupplyDurationDAO;

import com.skynet.retailscm.productsupplyduration.ProductSupplyDurationTable;
import com.skynet.retailscm.goodssupplier.GoodsSupplierTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SupplierProductJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplierProductDAO{
 
 	
 	private  GoodsSupplierDAO  goodsSupplierDAO;
 	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
	 	return this.goodsSupplierDAO;
 	}

		
	
  	private  ProductSupplyDurationDAO  productSupplyDurationDAO;
 	public void setProductSupplyDurationDAO(ProductSupplyDurationDAO pProductSupplyDurationDAO){
 	
 		if(pProductSupplyDurationDAO == null){
 			throw new IllegalStateException("Do not try to set productSupplyDurationDAO to null.");
 		}
	 	this.productSupplyDurationDAO = pProductSupplyDurationDAO;
 	}
 	public ProductSupplyDurationDAO getProductSupplyDurationDAO(){
 		if(this.productSupplyDurationDAO == null){
 			throw new IllegalStateException("The productSupplyDurationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productSupplyDurationDAO;
 	}	
 	
			
		

	
	/*
	protected SupplierProduct load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplierProduct(accessKey, options);
	}
	*/
	public SupplierProduct load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplierProduct(SupplierProductTable.withId(id), options);
	}
	
	
	
	public SupplierProduct save(SupplierProduct supplierProduct,Map<String,Object> options){
		
		String methodName="save(SupplierProduct supplierProduct,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplierProduct, methodName, "supplierProduct");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplierProduct(supplierProduct,options);
	}
	public SupplierProduct clone(String supplierProductId, Map<String,Object> options) throws Exception{
	
		return clone(SupplierProductTable.withId(supplierProductId),options);
	}
	
	protected SupplierProduct clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplierProductId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplierProduct newSupplierProduct = loadInternalSupplierProduct(accessKey, options);
		newSupplierProduct.setVersion(0);
		
		
 		
 		if(isSaveProductSupplyDurationListEnabled(options)){
 			for(ProductSupplyDuration item: newSupplierProduct.getProductSupplyDurationList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplierProduct(newSupplierProduct,options);
		
		return newSupplierProduct;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplierProductId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplierProductId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplierProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplierProductNotFoundException(
					"The " + this.getTableName() + "(" + supplierProductId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplierProductId, int version) throws Exception{
	
		String methodName="delete(String supplierProductId, int version)";
		assertMethodArgumentNotNull(supplierProductId, methodName, "supplierProductId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplierProductId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplierProductId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"product_name","product_description","product_unit","supplier"};
		return SupplierProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supplier_product";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplierProductTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractSupplierEnabled = true;
 	//private static final String SUPPLIER = "supplier";
 	protected boolean isExtractSupplierEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplierProductTokens.SUPPLIER);
 	}
 	
 	
 	//private boolean saveSupplierEnabled = true;
 	protected boolean isSaveSupplierEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplierProductTokens.SUPPLIER);
 	}
 	

 	
 
		
	//protected static final String PRODUCT_SUPPLY_DURATION_LIST = "productSupplyDurationList";
	
	protected boolean isExtractProductSupplyDurationListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplierProductTokens.PRODUCT_SUPPLY_DURATION_LIST);
		
 	}

	protected boolean isSaveProductSupplyDurationListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplierProductTokens.PRODUCT_SUPPLY_DURATION_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplierProductMapper getSupplierProductMapper(){
		return new SupplierProductMapper();
	}
	protected SupplierProduct extractSupplierProduct(String supplierProductId) throws Exception{
		String SQL = "select * from supplier_product_data where id = ?";	
		try{
		
			SupplierProduct supplierProduct = queryForObject(SQL, new Object[]{supplierProductId}, getSupplierProductMapper());
			return supplierProduct;
		}catch(EmptyResultDataAccessException e){
			throw new SupplierProductNotFoundException("SupplierProduct("+supplierProductId+") is not found!");
		}
		
		
	}
	protected SupplierProduct extractSupplierProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supplier_product_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplierProduct supplierProduct = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplierProductMapper());
			return supplierProduct;
		}catch(EmptyResultDataAccessException e){
			throw new SupplierProductNotFoundException("SupplierProduct("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplierProduct loadInternalSupplierProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplierProduct supplierProduct = extractSupplierProduct(accessKey, loadOptions);
 	
 		if(isExtractSupplierEnabled(loadOptions)){
	 		extractSupplier(supplierProduct, loadOptions);
 		}
 
		
		if(isExtractProductSupplyDurationListEnabled(loadOptions)){
	 		extractProductSupplyDurationList(supplierProduct, loadOptions);
 		}		
		
		return supplierProduct;
		
	}



	
	
	 

 	protected SupplierProduct extractSupplier(SupplierProduct supplierProduct, Map<String,Object> options) throws Exception{

		if(supplierProduct.getSupplier() == null){
			return supplierProduct;
		}
		String supplierId = supplierProduct.getSupplier().getId();
		if( supplierId == null){
			return supplierProduct;
		}
		GoodsSupplier supplier = getGoodsSupplierDAO().load(supplierId,options);
		if(supplier != null){
			supplierProduct.setSupplier(supplier);
		}
		
 		
 		return supplierProduct;
 	}
 		
 
		
	protected SupplierProduct extractProductSupplyDurationList(SupplierProduct supplierProduct, Map<String,Object> options){
		
		SmartList<ProductSupplyDuration> productSupplyDurationList = getProductSupplyDurationDAO().findProductSupplyDurationByProduct(supplierProduct.getId(),options);
		if(productSupplyDurationList != null){
			supplierProduct.setProductSupplyDurationList(productSupplyDurationList);
		}
		
		return supplierProduct;
	
	}	
		
		
  	
 	public SmartList<SupplierProduct> findSupplierProductBySupplier(String goodsSupplierId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where supplier = ?";
		SmartList<SupplierProduct> supplierProductList = queryForList(SQL, new Object[]{goodsSupplierId}, getSupplierProductMapper());	
 		return supplierProductList;
 	}
 	
 	public SmartList<SupplierProduct> findSupplierProductBySupplier(String goodsSupplierId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where supplier = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplierProduct> supplierProductList = queryForList(SQL, new Object[]{goodsSupplierId,start, count}, getSupplierProductMapper());
		
 		return supplierProductList;
 	}
 	
 	public int countSupplierProductBySupplier(String goodsSupplierId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where supplier = ?";
		Integer count = queryInt(SQL, new Object[]{goodsSupplierId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SupplierProduct saveSupplierProduct(SupplierProduct  supplierProduct){
	
		String SQL=this.getSaveSupplierProductSQL(supplierProduct);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplierProductParameters(supplierProduct);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplierProduct.incVersion();
		return supplierProduct;
	
	}
	public SmartList<SupplierProduct> saveSupplierProductList(SmartList<SupplierProduct> supplierProductList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplierProductList(supplierProductList);
		
		batchSupplierProductCreate((List<SupplierProduct>)lists[CREATE_LIST_INDEX]);
		
		batchSupplierProductUpdate((List<SupplierProduct>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplierProduct supplierProduct:supplierProductList){
			if(supplierProduct.isChanged()){
				supplierProduct.incVersion();
			}
			
		
		}
		
		
		return supplierProductList;
	}

	public SmartList<SupplierProduct> removeSupplierProductList(SmartList<SupplierProduct> supplierProductList,Map<String,Object> options){
		
		
		super.removeList(supplierProductList, options);
		
		return supplierProductList;
		
		
	}
	
	protected List<Object[]> prepareSupplierProductBatchCreateArgs(List<SupplierProduct> supplierProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplierProduct supplierProduct:supplierProductList ){
			Object [] parameters = prepareSupplierProductCreateParameters(supplierProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplierProductBatchUpdateArgs(List<SupplierProduct> supplierProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplierProduct supplierProduct:supplierProductList ){
			if(!supplierProduct.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplierProductUpdateParameters(supplierProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplierProductCreate(List<SupplierProduct> supplierProductList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplierProductBatchCreateArgs(supplierProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplierProductUpdate(List<SupplierProduct> supplierProductList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplierProductBatchUpdateArgs(supplierProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplierProductList(List<SupplierProduct> supplierProductList){
		
		List<SupplierProduct> supplierProductCreateList=new ArrayList<SupplierProduct>();
		List<SupplierProduct> supplierProductUpdateList=new ArrayList<SupplierProduct>();
		
		for(SupplierProduct supplierProduct: supplierProductList){
			if(isUpdateRequest(supplierProduct)){
				supplierProductUpdateList.add( supplierProduct);
				continue;
			}
			supplierProductCreateList.add(supplierProduct);
		}
		
		return new Object[]{supplierProductCreateList,supplierProductUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplierProduct supplierProduct){
 		return supplierProduct.getVersion() > 0;
 	}
 	protected String getSaveSupplierProductSQL(SupplierProduct supplierProduct){
 		if(isUpdateRequest(supplierProduct)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplierProductParameters(SupplierProduct supplierProduct){
 		if(isUpdateRequest(supplierProduct) ){
 			return prepareSupplierProductUpdateParameters(supplierProduct);
 		}
 		return prepareSupplierProductCreateParameters(supplierProduct);
 	}
 	protected Object[] prepareSupplierProductUpdateParameters(SupplierProduct supplierProduct){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = supplierProduct.getProductName();
 		parameters[1] = supplierProduct.getProductDescription();
 		parameters[2] = supplierProduct.getProductUnit(); 	
 		if(supplierProduct.getSupplier() != null){
 			parameters[3] = supplierProduct.getSupplier().getId();
 		}
 		
 		parameters[4] = supplierProduct.getId();
 		parameters[5] = supplierProduct.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplierProductCreateParameters(SupplierProduct supplierProduct){
		Object[] parameters = new Object[5];
		String newSupplierProductId=getNextId();
		supplierProduct.setId(newSupplierProductId);
		parameters[0] =  supplierProduct.getId();
 
 		parameters[1] = supplierProduct.getProductName();
 		parameters[2] = supplierProduct.getProductDescription();
 		parameters[3] = supplierProduct.getProductUnit(); 	
 		if(supplierProduct.getSupplier() != null){
 			parameters[4] = supplierProduct.getSupplier().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected SupplierProduct saveInternalSupplierProduct(SupplierProduct supplierProduct, Map<String,Object> options){
		
		saveSupplierProduct(supplierProduct);
 	
 		if(isSaveSupplierEnabled(options)){
	 		saveSupplier(supplierProduct, options);
 		}
 
		
		if(isSaveProductSupplyDurationListEnabled(options)){
	 		saveProductSupplyDurationList(supplierProduct, options);
	 		removeProductSupplyDurationList(supplierProduct, options);
	 		
 		}		
		
		return supplierProduct;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SupplierProduct saveSupplier(SupplierProduct supplierProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplierProduct.getSupplier() == null){
 			return supplierProduct;//do nothing when it is null
 		}
 		
 		getGoodsSupplierDAO().save(supplierProduct.getSupplier(),options);
 		return supplierProduct;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected SupplierProduct saveProductSupplyDurationList(SupplierProduct supplierProduct, Map<String,Object> options){
		SmartList<ProductSupplyDuration> productSupplyDurationList = supplierProduct.getProductSupplyDurationList();
		if(productSupplyDurationList == null){
			return supplierProduct;
		}
		if(productSupplyDurationList.isEmpty()){
			return supplierProduct;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getProductSupplyDurationDAO().saveProductSupplyDurationList(productSupplyDurationList,options);
		
		return supplierProduct;
	
	}
	
	protected SupplierProduct removeProductSupplyDurationList(SupplierProduct supplierProduct, Map<String,Object> options){
	
	
		SmartList<ProductSupplyDuration> productSupplyDurationList = supplierProduct.getProductSupplyDurationList();
		if(productSupplyDurationList == null){
			return supplierProduct;
		}	
	
		SmartList<ProductSupplyDuration> toRemoveProductSupplyDurationList = productSupplyDurationList.getToRemoveList();
		
		if(toRemoveProductSupplyDurationList == null){
			return supplierProduct;
		}
		if(toRemoveProductSupplyDurationList.isEmpty()){
			return supplierProduct;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductSupplyDurationDAO().removeProductSupplyDurationList(toRemoveProductSupplyDurationList,options);
		
		return supplierProduct;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SupplierProduct present(SupplierProduct supplierProduct,Map<String, Object> options){
	
		presentProductSupplyDurationList(supplierProduct,options);

		return supplierProduct;
	
	}
		
	
  	
 	protected SupplierProduct presentProductSupplyDurationList(
			SupplierProduct supplierProduct,
			Map<String, Object> options) {

		SmartList<ProductSupplyDuration> productSupplyDurationList = supplierProduct.getProductSupplyDurationList();		
		if(productSupplyDurationList == null){
			return supplierProduct;			
		}
		
		String targetObjectName = "productSupplyDuration";
		int productSupplyDurationListSize = productSupplyDurationList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(productSupplyDurationListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplierProduct;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = productSupplyDurationListSize;
		if(productSupplyDurationListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getProductSupplyDurationDAO().countProductSupplyDurationByProduct(supplierProduct.getId(), options);			
		}
		//supplierProduct.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplierProduct.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(productSupplyDurationListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(productSupplyDurationListSize,currentPage,rowsPerPage) ;
			productSupplyDurationList = productSupplyDurationList.subListOf(fromIndex, toIndex);
			productSupplyDurationList.setTotalCount(count);
			productSupplyDurationList.setCurrentPageNumber(currentPage);			
			supplierProduct.setProductSupplyDurationList(productSupplyDurationList);
			return supplierProduct;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		productSupplyDurationList 
			= getProductSupplyDurationDAO().findProductSupplyDurationByProduct(supplierProduct.getId(),start, rowsPerPage, options );
		productSupplyDurationList.setTotalCount(count);
		productSupplyDurationList.setCurrentPageNumber(currentPage);
		supplierProduct.setProductSupplyDurationList(productSupplyDurationList );	

		return supplierProduct;
	}			
		


	protected String getTableName(){
		return SupplierProductTable.TABLE_NAME;
	}
}


