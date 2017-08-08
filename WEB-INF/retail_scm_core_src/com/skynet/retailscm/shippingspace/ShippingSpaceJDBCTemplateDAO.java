
package com.skynet.retailscm.shippingspace;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.warehouse.Warehouse;

import com.skynet.retailscm.warehouse.WarehouseDAO;
import com.skynet.retailscm.goods.GoodsDAO;

import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.warehouse.WarehouseTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ShippingSpaceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ShippingSpaceDAO{
 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
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
	protected ShippingSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalShippingSpace(accessKey, options);
	}
	*/
	public ShippingSpace load(String id,Map<String,Object> options) throws Exception{
		return loadInternalShippingSpace(ShippingSpaceTable.withId(id), options);
	}
	
	
	
	public ShippingSpace save(ShippingSpace shippingSpace,Map<String,Object> options){
		
		String methodName="save(ShippingSpace shippingSpace,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(shippingSpace, methodName, "shippingSpace");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalShippingSpace(shippingSpace,options);
	}
	public ShippingSpace clone(String shippingSpaceId, Map<String,Object> options) throws Exception{
	
		return clone(ShippingSpaceTable.withId(shippingSpaceId),options);
	}
	
	protected ShippingSpace clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String shippingSpaceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ShippingSpace newShippingSpace = loadInternalShippingSpace(accessKey, options);
		newShippingSpace.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newShippingSpace.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalShippingSpace(newShippingSpace,options);
		
		return newShippingSpace;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String shippingSpaceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{shippingSpaceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ShippingSpaceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ShippingSpaceNotFoundException(
					"The " + this.getTableName() + "(" + shippingSpaceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String shippingSpaceId, int version) throws Exception{
	
		String methodName="delete(String shippingSpaceId, int version)";
		assertMethodArgumentNotNull(shippingSpaceId, methodName, "shippingSpaceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{shippingSpaceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(shippingSpaceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"location","contact_number","total_area","warehouse","latitude","longitude","description"};
		return ShippingSpaceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "shipping_space";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ShippingSpaceTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractWarehouseEnabled = true;
 	//private static final String WAREHOUSE = "warehouse";
 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ShippingSpaceTokens.WAREHOUSE);
 	}
 	
 	
 	//private boolean saveWarehouseEnabled = true;
 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ShippingSpaceTokens.WAREHOUSE);
 	}
 	

 	
 
		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ShippingSpaceTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, ShippingSpaceTokens.GOODS_LIST);
		
 	}
 	
 	
			
		

	

	protected ShippingSpaceMapper getShippingSpaceMapper(){
		return new ShippingSpaceMapper();
	}
	protected ShippingSpace extractShippingSpace(String shippingSpaceId) throws Exception{
		String SQL = "select * from shipping_space_data where id = ?";	
		try{
		
			ShippingSpace shippingSpace = queryForObject(SQL, new Object[]{shippingSpaceId}, getShippingSpaceMapper());
			return shippingSpace;
		}catch(EmptyResultDataAccessException e){
			throw new ShippingSpaceNotFoundException("ShippingSpace("+shippingSpaceId+") is not found!");
		}
		
		
	}
	protected ShippingSpace extractShippingSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from shipping_space_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ShippingSpace shippingSpace = queryForObject(SQL, new Object[]{accessKey.getValue()}, getShippingSpaceMapper());
			return shippingSpace;
		}catch(EmptyResultDataAccessException e){
			throw new ShippingSpaceNotFoundException("ShippingSpace("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ShippingSpace loadInternalShippingSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ShippingSpace shippingSpace = extractShippingSpace(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(shippingSpace, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(shippingSpace, loadOptions);
 		}		
		
		return shippingSpace;
		
	}



	
	
	 

 	protected ShippingSpace extractWarehouse(ShippingSpace shippingSpace, Map<String,Object> options) throws Exception{

		if(shippingSpace.getWarehouse() == null){
			return shippingSpace;
		}
		String warehouseId = shippingSpace.getWarehouse().getId();
		if( warehouseId == null){
			return shippingSpace;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			shippingSpace.setWarehouse(warehouse);
		}
		
 		
 		return shippingSpace;
 	}
 		
 
		
	protected ShippingSpace extractGoodsList(ShippingSpace shippingSpace, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByShippingSpace(shippingSpace.getId(),options);
		if(goodsList != null){
			shippingSpace.setGoodsList(goodsList);
		}
		
		return shippingSpace;
	
	}	
		
		
  	
 	public SmartList<ShippingSpace> findShippingSpaceByWarehouse(String warehouseId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ?";
		SmartList<ShippingSpace> shippingSpaceList = queryForList(SQL, new Object[]{warehouseId}, getShippingSpaceMapper());	
 		return shippingSpaceList;
 	}
 	
 	public SmartList<ShippingSpace> findShippingSpaceByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ShippingSpace> shippingSpaceList = queryForList(SQL, new Object[]{warehouseId,start, count}, getShippingSpaceMapper());
		
 		return shippingSpaceList;
 	}
 	
 	public int countShippingSpaceByWarehouse(String warehouseId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where warehouse = ?";
		Integer count = queryInt(SQL, new Object[]{warehouseId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ShippingSpace saveShippingSpace(ShippingSpace  shippingSpace){
	
		String SQL=this.getSaveShippingSpaceSQL(shippingSpace);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveShippingSpaceParameters(shippingSpace);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		shippingSpace.incVersion();
		return shippingSpace;
	
	}
	public SmartList<ShippingSpace> saveShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitShippingSpaceList(shippingSpaceList);
		
		batchShippingSpaceCreate((List<ShippingSpace>)lists[CREATE_LIST_INDEX]);
		
		batchShippingSpaceUpdate((List<ShippingSpace>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ShippingSpace shippingSpace:shippingSpaceList){
			if(shippingSpace.isChanged()){
				shippingSpace.incVersion();
			}
			
		
		}
		
		
		return shippingSpaceList;
	}

	public SmartList<ShippingSpace> removeShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList,Map<String,Object> options){
		
		
		super.removeList(shippingSpaceList, options);
		
		return shippingSpaceList;
		
		
	}
	
	protected List<Object[]> prepareShippingSpaceBatchCreateArgs(List<ShippingSpace> shippingSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingSpace shippingSpace:shippingSpaceList ){
			Object [] parameters = prepareShippingSpaceCreateParameters(shippingSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareShippingSpaceBatchUpdateArgs(List<ShippingSpace> shippingSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingSpace shippingSpace:shippingSpaceList ){
			if(!shippingSpace.isChanged()){
				continue;
			}
			Object [] parameters = prepareShippingSpaceUpdateParameters(shippingSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchShippingSpaceCreate(List<ShippingSpace> shippingSpaceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareShippingSpaceBatchCreateArgs(shippingSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchShippingSpaceUpdate(List<ShippingSpace> shippingSpaceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareShippingSpaceBatchUpdateArgs(shippingSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitShippingSpaceList(List<ShippingSpace> shippingSpaceList){
		
		List<ShippingSpace> shippingSpaceCreateList=new ArrayList<ShippingSpace>();
		List<ShippingSpace> shippingSpaceUpdateList=new ArrayList<ShippingSpace>();
		
		for(ShippingSpace shippingSpace: shippingSpaceList){
			if(isUpdateRequest(shippingSpace)){
				shippingSpaceUpdateList.add( shippingSpace);
				continue;
			}
			shippingSpaceCreateList.add(shippingSpace);
		}
		
		return new Object[]{shippingSpaceCreateList,shippingSpaceUpdateList};
	}
	
	protected boolean isUpdateRequest(ShippingSpace shippingSpace){
 		return shippingSpace.getVersion() > 0;
 	}
 	protected String getSaveShippingSpaceSQL(ShippingSpace shippingSpace){
 		if(isUpdateRequest(shippingSpace)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveShippingSpaceParameters(ShippingSpace shippingSpace){
 		if(isUpdateRequest(shippingSpace) ){
 			return prepareShippingSpaceUpdateParameters(shippingSpace);
 		}
 		return prepareShippingSpaceCreateParameters(shippingSpace);
 	}
 	protected Object[] prepareShippingSpaceUpdateParameters(ShippingSpace shippingSpace){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = shippingSpace.getLocation();
 		parameters[1] = shippingSpace.getContactNumber();
 		parameters[2] = shippingSpace.getTotalArea(); 	
 		if(shippingSpace.getWarehouse() != null){
 			parameters[3] = shippingSpace.getWarehouse().getId();
 		}
 
 		parameters[4] = shippingSpace.getLatitude();
 		parameters[5] = shippingSpace.getLongitude();
 		parameters[6] = shippingSpace.getDescription();		
 		parameters[7] = shippingSpace.getId();
 		parameters[8] = shippingSpace.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareShippingSpaceCreateParameters(ShippingSpace shippingSpace){
		Object[] parameters = new Object[8];
		String newShippingSpaceId=getNextId();
		shippingSpace.setId(newShippingSpaceId);
		parameters[0] =  shippingSpace.getId();
 
 		parameters[1] = shippingSpace.getLocation();
 		parameters[2] = shippingSpace.getContactNumber();
 		parameters[3] = shippingSpace.getTotalArea(); 	
 		if(shippingSpace.getWarehouse() != null){
 			parameters[4] = shippingSpace.getWarehouse().getId();
 		
 		}
 		
 		parameters[5] = shippingSpace.getLatitude();
 		parameters[6] = shippingSpace.getLongitude();
 		parameters[7] = shippingSpace.getDescription();		
 				
 		return parameters;
 	}
 	
	protected ShippingSpace saveInternalShippingSpace(ShippingSpace shippingSpace, Map<String,Object> options){
		
		saveShippingSpace(shippingSpace);
 	
 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(shippingSpace, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(shippingSpace, options);
	 		removeGoodsList(shippingSpace, options);
	 		
 		}		
		
		return shippingSpace;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ShippingSpace saveWarehouse(ShippingSpace shippingSpace, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(shippingSpace.getWarehouse() == null){
 			return shippingSpace;//do nothing when it is null
 		}
 		
 		getWarehouseDAO().save(shippingSpace.getWarehouse(),options);
 		return shippingSpace;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected ShippingSpace saveGoodsList(ShippingSpace shippingSpace, Map<String,Object> options){
		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		if(goodsList == null){
			return shippingSpace;
		}
		if(goodsList.isEmpty()){
			return shippingSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return shippingSpace;
	
	}
	
	protected ShippingSpace removeGoodsList(ShippingSpace shippingSpace, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		if(goodsList == null){
			return shippingSpace;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return shippingSpace;
		}
		if(toRemoveGoodsList.isEmpty()){
			return shippingSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return shippingSpace;
	
	}
	
	
	
 	
 	
	
	
	
		

	public ShippingSpace present(ShippingSpace shippingSpace,Map<String, Object> options){
	
		presentGoodsList(shippingSpace,options);

		return shippingSpace;
	
	}
		
	
  	
 	protected ShippingSpace presentGoodsList(
			ShippingSpace shippingSpace,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = shippingSpace.getGoodsList();		
		if(goodsList == null){
			return shippingSpace;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return shippingSpace;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsByShippingSpace(shippingSpace.getId(), options);			
		}
		//shippingSpace.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//shippingSpace.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			shippingSpace.setGoodsList(goodsList);
			return shippingSpace;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsByShippingSpace(shippingSpace.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		shippingSpace.setGoodsList(goodsList );	

		return shippingSpace;
	}			
		


	protected String getTableName(){
		return ShippingSpaceTable.TABLE_NAME;
	}
}


