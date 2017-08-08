
package com.skynet.retailscm.productsupplyduration;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.supplierproduct.SupplierProduct;

import com.skynet.retailscm.supplierproduct.SupplierProductDAO;

import com.skynet.retailscm.supplierproduct.SupplierProductTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ProductSupplyDurationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ProductSupplyDurationDAO{
 
 	
 	private  SupplierProductDAO  supplierProductDAO;
 	public void setSupplierProductDAO(SupplierProductDAO supplierProductDAO){
	 	this.supplierProductDAO = supplierProductDAO;
 	}
 	public SupplierProductDAO getSupplierProductDAO(){
	 	return this.supplierProductDAO;
 	}

		

	
	/*
	protected ProductSupplyDuration load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProductSupplyDuration(accessKey, options);
	}
	*/
	public ProductSupplyDuration load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProductSupplyDuration(ProductSupplyDurationTable.withId(id), options);
	}
	
	
	
	public ProductSupplyDuration save(ProductSupplyDuration productSupplyDuration,Map<String,Object> options){
		
		String methodName="save(ProductSupplyDuration productSupplyDuration,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(productSupplyDuration, methodName, "productSupplyDuration");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProductSupplyDuration(productSupplyDuration,options);
	}
	public ProductSupplyDuration clone(String productSupplyDurationId, Map<String,Object> options) throws Exception{
	
		return clone(ProductSupplyDurationTable.withId(productSupplyDurationId),options);
	}
	
	protected ProductSupplyDuration clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String productSupplyDurationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ProductSupplyDuration newProductSupplyDuration = loadInternalProductSupplyDuration(accessKey, options);
		newProductSupplyDuration.setVersion(0);
		
		

		
		saveInternalProductSupplyDuration(newProductSupplyDuration,options);
		
		return newProductSupplyDuration;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String productSupplyDurationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{productSupplyDurationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ProductSupplyDurationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProductSupplyDurationNotFoundException(
					"The " + this.getTableName() + "(" + productSupplyDurationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String productSupplyDurationId, int version) throws Exception{
	
		String methodName="delete(String productSupplyDurationId, int version)";
		assertMethodArgumentNotNull(productSupplyDurationId, methodName, "productSupplyDurationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{productSupplyDurationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(productSupplyDurationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"quantity","duration","price","product"};
		return ProductSupplyDurationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "product_supply_duration";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProductSupplyDurationTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractProductEnabled = true;
 	//private static final String PRODUCT = "product";
 	protected boolean isExtractProductEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProductSupplyDurationTokens.PRODUCT);
 	}
 	
 	
 	//private boolean saveProductEnabled = true;
 	protected boolean isSaveProductEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProductSupplyDurationTokens.PRODUCT);
 	}
 	

 	
 
		

	

	protected ProductSupplyDurationMapper getProductSupplyDurationMapper(){
		return new ProductSupplyDurationMapper();
	}
	protected ProductSupplyDuration extractProductSupplyDuration(String productSupplyDurationId) throws Exception{
		String SQL = "select * from product_supply_duration_data where id = ?";	
		try{
		
			ProductSupplyDuration productSupplyDuration = queryForObject(SQL, new Object[]{productSupplyDurationId}, getProductSupplyDurationMapper());
			return productSupplyDuration;
		}catch(EmptyResultDataAccessException e){
			throw new ProductSupplyDurationNotFoundException("ProductSupplyDuration("+productSupplyDurationId+") is not found!");
		}
		
		
	}
	protected ProductSupplyDuration extractProductSupplyDuration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from product_supply_duration_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ProductSupplyDuration productSupplyDuration = queryForObject(SQL, new Object[]{accessKey.getValue()}, getProductSupplyDurationMapper());
			return productSupplyDuration;
		}catch(EmptyResultDataAccessException e){
			throw new ProductSupplyDurationNotFoundException("ProductSupplyDuration("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ProductSupplyDuration loadInternalProductSupplyDuration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ProductSupplyDuration productSupplyDuration = extractProductSupplyDuration(accessKey, loadOptions);
 	
 		if(isExtractProductEnabled(loadOptions)){
	 		extractProduct(productSupplyDuration, loadOptions);
 		}
 
		
		return productSupplyDuration;
		
	}



	
	
	 

 	protected ProductSupplyDuration extractProduct(ProductSupplyDuration productSupplyDuration, Map<String,Object> options) throws Exception{

		if(productSupplyDuration.getProduct() == null){
			return productSupplyDuration;
		}
		String productId = productSupplyDuration.getProduct().getId();
		if( productId == null){
			return productSupplyDuration;
		}
		SupplierProduct product = getSupplierProductDAO().load(productId,options);
		if(product != null){
			productSupplyDuration.setProduct(product);
		}
		
 		
 		return productSupplyDuration;
 	}
 		
 
		
		
  	
 	public SmartList<ProductSupplyDuration> findProductSupplyDurationByProduct(String supplierProductId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where product = ?";
		SmartList<ProductSupplyDuration> productSupplyDurationList = queryForList(SQL, new Object[]{supplierProductId}, getProductSupplyDurationMapper());	
 		return productSupplyDurationList;
 	}
 	
 	public SmartList<ProductSupplyDuration> findProductSupplyDurationByProduct(String supplierProductId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where product = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ProductSupplyDuration> productSupplyDurationList = queryForList(SQL, new Object[]{supplierProductId,start, count}, getProductSupplyDurationMapper());
		
 		return productSupplyDurationList;
 	}
 	
 	public int countProductSupplyDurationByProduct(String supplierProductId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where product = ?";
		Integer count = queryInt(SQL, new Object[]{supplierProductId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ProductSupplyDuration saveProductSupplyDuration(ProductSupplyDuration  productSupplyDuration){
	
		String SQL=this.getSaveProductSupplyDurationSQL(productSupplyDuration);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProductSupplyDurationParameters(productSupplyDuration);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		productSupplyDuration.incVersion();
		return productSupplyDuration;
	
	}
	public SmartList<ProductSupplyDuration> saveProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProductSupplyDurationList(productSupplyDurationList);
		
		batchProductSupplyDurationCreate((List<ProductSupplyDuration>)lists[CREATE_LIST_INDEX]);
		
		batchProductSupplyDurationUpdate((List<ProductSupplyDuration>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ProductSupplyDuration productSupplyDuration:productSupplyDurationList){
			if(productSupplyDuration.isChanged()){
				productSupplyDuration.incVersion();
			}
			
		
		}
		
		
		return productSupplyDurationList;
	}

	public SmartList<ProductSupplyDuration> removeProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList,Map<String,Object> options){
		
		
		super.removeList(productSupplyDurationList, options);
		
		return productSupplyDurationList;
		
		
	}
	
	protected List<Object[]> prepareProductSupplyDurationBatchCreateArgs(List<ProductSupplyDuration> productSupplyDurationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProductSupplyDuration productSupplyDuration:productSupplyDurationList ){
			Object [] parameters = prepareProductSupplyDurationCreateParameters(productSupplyDuration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProductSupplyDurationBatchUpdateArgs(List<ProductSupplyDuration> productSupplyDurationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProductSupplyDuration productSupplyDuration:productSupplyDurationList ){
			if(!productSupplyDuration.isChanged()){
				continue;
			}
			Object [] parameters = prepareProductSupplyDurationUpdateParameters(productSupplyDuration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProductSupplyDurationCreate(List<ProductSupplyDuration> productSupplyDurationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProductSupplyDurationBatchCreateArgs(productSupplyDurationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProductSupplyDurationUpdate(List<ProductSupplyDuration> productSupplyDurationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProductSupplyDurationBatchUpdateArgs(productSupplyDurationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProductSupplyDurationList(List<ProductSupplyDuration> productSupplyDurationList){
		
		List<ProductSupplyDuration> productSupplyDurationCreateList=new ArrayList<ProductSupplyDuration>();
		List<ProductSupplyDuration> productSupplyDurationUpdateList=new ArrayList<ProductSupplyDuration>();
		
		for(ProductSupplyDuration productSupplyDuration: productSupplyDurationList){
			if(isUpdateRequest(productSupplyDuration)){
				productSupplyDurationUpdateList.add( productSupplyDuration);
				continue;
			}
			productSupplyDurationCreateList.add(productSupplyDuration);
		}
		
		return new Object[]{productSupplyDurationCreateList,productSupplyDurationUpdateList};
	}
	
	protected boolean isUpdateRequest(ProductSupplyDuration productSupplyDuration){
 		return productSupplyDuration.getVersion() > 0;
 	}
 	protected String getSaveProductSupplyDurationSQL(ProductSupplyDuration productSupplyDuration){
 		if(isUpdateRequest(productSupplyDuration)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProductSupplyDurationParameters(ProductSupplyDuration productSupplyDuration){
 		if(isUpdateRequest(productSupplyDuration) ){
 			return prepareProductSupplyDurationUpdateParameters(productSupplyDuration);
 		}
 		return prepareProductSupplyDurationCreateParameters(productSupplyDuration);
 	}
 	protected Object[] prepareProductSupplyDurationUpdateParameters(ProductSupplyDuration productSupplyDuration){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = productSupplyDuration.getQuantity();
 		parameters[1] = productSupplyDuration.getDuration();
 		parameters[2] = productSupplyDuration.getPrice(); 	
 		if(productSupplyDuration.getProduct() != null){
 			parameters[3] = productSupplyDuration.getProduct().getId();
 		}
 		
 		parameters[4] = productSupplyDuration.getId();
 		parameters[5] = productSupplyDuration.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProductSupplyDurationCreateParameters(ProductSupplyDuration productSupplyDuration){
		Object[] parameters = new Object[5];
		String newProductSupplyDurationId=getNextId();
		productSupplyDuration.setId(newProductSupplyDurationId);
		parameters[0] =  productSupplyDuration.getId();
 
 		parameters[1] = productSupplyDuration.getQuantity();
 		parameters[2] = productSupplyDuration.getDuration();
 		parameters[3] = productSupplyDuration.getPrice(); 	
 		if(productSupplyDuration.getProduct() != null){
 			parameters[4] = productSupplyDuration.getProduct().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ProductSupplyDuration saveInternalProductSupplyDuration(ProductSupplyDuration productSupplyDuration, Map<String,Object> options){
		
		saveProductSupplyDuration(productSupplyDuration);
 	
 		if(isSaveProductEnabled(options)){
	 		saveProduct(productSupplyDuration, options);
 		}
 
		
		return productSupplyDuration;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ProductSupplyDuration saveProduct(ProductSupplyDuration productSupplyDuration, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(productSupplyDuration.getProduct() == null){
 			return productSupplyDuration;//do nothing when it is null
 		}
 		
 		getSupplierProductDAO().save(productSupplyDuration.getProduct(),options);
 		return productSupplyDuration;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public ProductSupplyDuration present(ProductSupplyDuration productSupplyDuration,Map<String, Object> options){
	

		return productSupplyDuration;
	
	}
		


	protected String getTableName(){
		return ProductSupplyDurationTable.TABLE_NAME;
	}
}


