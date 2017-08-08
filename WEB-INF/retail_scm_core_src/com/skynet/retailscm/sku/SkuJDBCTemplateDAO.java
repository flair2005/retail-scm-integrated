
package com.skynet.retailscm.sku;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.goods.Goods;

import com.skynet.retailscm.product.ProductDAO;
import com.skynet.retailscm.goods.GoodsDAO;

import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.product.ProductTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SkuJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SkuDAO{
 
 	
 	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO productDAO){
	 	this.productDAO = productDAO;
 	}
 	public ProductDAO getProductDAO(){
	 	return this.productDAO;
 	}

		
	
  	private  GoodsDAO  goodsDAO;
 	public void setGoodsDAO(GoodsDAO pGoodsDAO){
 	
 		if(pGoodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = pGoodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The goodsDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsDAO;
 	}	
 	
			
		

	
	/*
	protected Sku load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSku(accessKey, options);
	}
	*/
	public Sku load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSku(SkuTable.withId(id), options);
	}
	
	
	
	public Sku save(Sku sku,Map<String,Object> options){
		
		String methodName="save(Sku sku,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(sku, methodName, "sku");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSku(sku,options);
	}
	public Sku clone(String skuId, Map<String,Object> options) throws Exception{
	
		return clone(SkuTable.withId(skuId),options);
	}
	
	protected Sku clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String skuId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Sku newSku = loadInternalSku(accessKey, options);
		newSku.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newSku.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSku(newSku,options);
		
		return newSku;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String skuId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{skuId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SkuVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SkuNotFoundException(
					"The " + this.getTableName() + "(" + skuId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String skuId, int version) throws Exception{
	
		String methodName="delete(String skuId, int version)";
		assertMethodArgumentNotNull(skuId, methodName, "skuId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{skuId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(skuId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"display_name","size","product","barcode","package_type","net_content","price","picture"};
		return SkuTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "sku";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SkuTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractProductEnabled = true;
 	//private static final String PRODUCT = "product";
 	protected boolean isExtractProductEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SkuTokens.PRODUCT);
 	}
 	
 	
 	//private boolean saveProductEnabled = true;
 	protected boolean isSaveProductEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SkuTokens.PRODUCT);
 	}
 	

 	
 
		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SkuTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, SkuTokens.GOODS_LIST);
		
 	}
 	
 	
			
		

	

	protected SkuMapper getSkuMapper(){
		return new SkuMapper();
	}
	protected Sku extractSku(String skuId) throws Exception{
		String SQL = "select * from sku_data where id = ?";	
		try{
		
			Sku sku = queryForObject(SQL, new Object[]{skuId}, getSkuMapper());
			return sku;
		}catch(EmptyResultDataAccessException e){
			throw new SkuNotFoundException("Sku("+skuId+") is not found!");
		}
		
		
	}
	protected Sku extractSku(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from sku_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Sku sku = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSkuMapper());
			return sku;
		}catch(EmptyResultDataAccessException e){
			throw new SkuNotFoundException("Sku("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Sku loadInternalSku(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Sku sku = extractSku(accessKey, loadOptions);
 	
 		if(isExtractProductEnabled(loadOptions)){
	 		extractProduct(sku, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(sku, loadOptions);
 		}		
		
		return sku;
		
	}



	
	
	 

 	protected Sku extractProduct(Sku sku, Map<String,Object> options) throws Exception{

		if(sku.getProduct() == null){
			return sku;
		}
		String productId = sku.getProduct().getId();
		if( productId == null){
			return sku;
		}
		Product product = getProductDAO().load(productId,options);
		if(product != null){
			sku.setProduct(product);
		}
		
 		
 		return sku;
 	}
 		
 
		
	protected Sku extractGoodsList(Sku sku, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsBySku(sku.getId(),options);
		if(goodsList != null){
			sku.setGoodsList(goodsList);
		}
		
		return sku;
	
	}	
		
		
  	
 	public SmartList<Sku> findSkuByProduct(String productId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where product = ?";
		SmartList<Sku> skuList = queryForList(SQL, new Object[]{productId}, getSkuMapper());	
 		return skuList;
 	}
 	
 	public SmartList<Sku> findSkuByProduct(String productId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where product = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Sku> skuList = queryForList(SQL, new Object[]{productId,start, count}, getSkuMapper());
		
 		return skuList;
 	}
 	
 	public int countSkuByProduct(String productId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where product = ?";
		Integer count = queryInt(SQL, new Object[]{productId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected Sku saveSku(Sku  sku){
	
		String SQL=this.getSaveSkuSQL(sku);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSkuParameters(sku);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		sku.incVersion();
		return sku;
	
	}
	public SmartList<Sku> saveSkuList(SmartList<Sku> skuList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSkuList(skuList);
		
		batchSkuCreate((List<Sku>)lists[CREATE_LIST_INDEX]);
		
		batchSkuUpdate((List<Sku>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Sku sku:skuList){
			if(sku.isChanged()){
				sku.incVersion();
			}
			
		
		}
		
		
		return skuList;
	}

	public SmartList<Sku> removeSkuList(SmartList<Sku> skuList,Map<String,Object> options){
		
		
		super.removeList(skuList, options);
		
		return skuList;
		
		
	}
	
	protected List<Object[]> prepareSkuBatchCreateArgs(List<Sku> skuList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Sku sku:skuList ){
			Object [] parameters = prepareSkuCreateParameters(sku);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSkuBatchUpdateArgs(List<Sku> skuList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Sku sku:skuList ){
			if(!sku.isChanged()){
				continue;
			}
			Object [] parameters = prepareSkuUpdateParameters(sku);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSkuCreate(List<Sku> skuList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSkuBatchCreateArgs(skuList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSkuUpdate(List<Sku> skuList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSkuBatchUpdateArgs(skuList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSkuList(List<Sku> skuList){
		
		List<Sku> skuCreateList=new ArrayList<Sku>();
		List<Sku> skuUpdateList=new ArrayList<Sku>();
		
		for(Sku sku: skuList){
			if(isUpdateRequest(sku)){
				skuUpdateList.add( sku);
				continue;
			}
			skuCreateList.add(sku);
		}
		
		return new Object[]{skuCreateList,skuUpdateList};
	}
	
	protected boolean isUpdateRequest(Sku sku){
 		return sku.getVersion() > 0;
 	}
 	protected String getSaveSkuSQL(Sku sku){
 		if(isUpdateRequest(sku)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSkuParameters(Sku sku){
 		if(isUpdateRequest(sku) ){
 			return prepareSkuUpdateParameters(sku);
 		}
 		return prepareSkuCreateParameters(sku);
 	}
 	protected Object[] prepareSkuUpdateParameters(Sku sku){
 		Object[] parameters = new Object[10];
 
 		parameters[0] = sku.getDisplayName();
 		parameters[1] = sku.getSize(); 	
 		if(sku.getProduct() != null){
 			parameters[2] = sku.getProduct().getId();
 		}
 
 		parameters[3] = sku.getBarcode();
 		parameters[4] = sku.getPackageType();
 		parameters[5] = sku.getNetContent();
 		parameters[6] = sku.getPrice();
 		parameters[7] = sku.getPicture();		
 		parameters[8] = sku.getId();
 		parameters[9] = sku.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSkuCreateParameters(Sku sku){
		Object[] parameters = new Object[9];
		String newSkuId=getNextId();
		sku.setId(newSkuId);
		parameters[0] =  sku.getId();
 
 		parameters[1] = sku.getDisplayName();
 		parameters[2] = sku.getSize(); 	
 		if(sku.getProduct() != null){
 			parameters[3] = sku.getProduct().getId();
 		
 		}
 		
 		parameters[4] = sku.getBarcode();
 		parameters[5] = sku.getPackageType();
 		parameters[6] = sku.getNetContent();
 		parameters[7] = sku.getPrice();
 		parameters[8] = sku.getPicture();		
 				
 		return parameters;
 	}
 	
	protected Sku saveInternalSku(Sku sku, Map<String,Object> options){
		
		saveSku(sku);
 	
 		if(isSaveProductEnabled(options)){
	 		saveProduct(sku, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(sku, options);
	 		removeGoodsList(sku, options);
	 		
 		}		
		
		return sku;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Sku saveProduct(Sku sku, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(sku.getProduct() == null){
 			return sku;//do nothing when it is null
 		}
 		
 		getProductDAO().save(sku.getProduct(),options);
 		return sku;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected Sku saveGoodsList(Sku sku, Map<String,Object> options){
		SmartList<Goods> goodsList = sku.getGoodsList();
		if(goodsList == null){
			return sku;
		}
		if(goodsList.isEmpty()){
			return sku;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return sku;
	
	}
	
	protected Sku removeGoodsList(Sku sku, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = sku.getGoodsList();
		if(goodsList == null){
			return sku;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return sku;
		}
		if(toRemoveGoodsList.isEmpty()){
			return sku;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return sku;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Sku present(Sku sku,Map<String, Object> options){
	
		presentGoodsList(sku,options);

		return sku;
	
	}
		
	
  	
 	protected Sku presentGoodsList(
			Sku sku,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = sku.getGoodsList();		
		if(goodsList == null){
			return sku;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return sku;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsBySku(sku.getId(), options);			
		}
		//sku.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//sku.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			sku.setGoodsList(goodsList);
			return sku;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsBySku(sku.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		sku.setGoodsList(goodsList );	

		return sku;
	}			
		


	protected String getTableName(){
		return SkuTable.TABLE_NAME;
	}
}


