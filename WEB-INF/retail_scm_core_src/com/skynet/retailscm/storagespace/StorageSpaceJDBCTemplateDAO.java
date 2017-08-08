
package com.skynet.retailscm.storagespace;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.goodsshelf.GoodsShelf;

import com.skynet.retailscm.warehouse.WarehouseDAO;
import com.skynet.retailscm.goodsshelf.GoodsShelfDAO;

import com.skynet.retailscm.goodsshelf.GoodsShelfTable;
import com.skynet.retailscm.warehouse.WarehouseTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class StorageSpaceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements StorageSpaceDAO{
 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

		
	
  	private  GoodsShelfDAO  goodsShelfDAO;
 	public void setGoodsShelfDAO(GoodsShelfDAO pGoodsShelfDAO){
 	
 		if(pGoodsShelfDAO == null){
 			throw new IllegalStateException("Do not try to set goodsShelfDAO to null.");
 		}
	 	this.goodsShelfDAO = pGoodsShelfDAO;
 	}
 	public GoodsShelfDAO getGoodsShelfDAO(){
 		if(this.goodsShelfDAO == null){
 			throw new IllegalStateException("The goodsShelfDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsShelfDAO;
 	}	
 	
			
		

	
	/*
	protected StorageSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalStorageSpace(accessKey, options);
	}
	*/
	public StorageSpace load(String id,Map<String,Object> options) throws Exception{
		return loadInternalStorageSpace(StorageSpaceTable.withId(id), options);
	}
	
	
	
	public StorageSpace save(StorageSpace storageSpace,Map<String,Object> options){
		
		String methodName="save(StorageSpace storageSpace,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(storageSpace, methodName, "storageSpace");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalStorageSpace(storageSpace,options);
	}
	public StorageSpace clone(String storageSpaceId, Map<String,Object> options) throws Exception{
	
		return clone(StorageSpaceTable.withId(storageSpaceId),options);
	}
	
	protected StorageSpace clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String storageSpaceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		StorageSpace newStorageSpace = loadInternalStorageSpace(accessKey, options);
		newStorageSpace.setVersion(0);
		
		
 		
 		if(isSaveGoodsShelfListEnabled(options)){
 			for(GoodsShelf item: newStorageSpace.getGoodsShelfList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalStorageSpace(newStorageSpace,options);
		
		return newStorageSpace;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String storageSpaceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{storageSpaceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new StorageSpaceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new StorageSpaceNotFoundException(
					"The " + this.getTableName() + "(" + storageSpaceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String storageSpaceId, int version) throws Exception{
	
		String methodName="delete(String storageSpaceId, int version)";
		assertMethodArgumentNotNull(storageSpaceId, methodName, "storageSpaceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{storageSpaceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(storageSpaceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"location","contact_number","total_area","warehouse","latitude","longitude"};
		return StorageSpaceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "storage_space";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return StorageSpaceTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractWarehouseEnabled = true;
 	//private static final String WAREHOUSE = "warehouse";
 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, StorageSpaceTokens.WAREHOUSE);
 	}
 	
 	
 	//private boolean saveWarehouseEnabled = true;
 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, StorageSpaceTokens.WAREHOUSE);
 	}
 	

 	
 
		
	//protected static final String GOODS_SHELF_LIST = "goodsShelfList";
	
	protected boolean isExtractGoodsShelfListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,StorageSpaceTokens.GOODS_SHELF_LIST);
		
 	}

	protected boolean isSaveGoodsShelfListEnabled(Map<String,Object> options){
		return checkOptions(options, StorageSpaceTokens.GOODS_SHELF_LIST);
		
 	}
 	
 	
			
		

	

	protected StorageSpaceMapper getStorageSpaceMapper(){
		return new StorageSpaceMapper();
	}
	protected StorageSpace extractStorageSpace(String storageSpaceId) throws Exception{
		String SQL = "select * from storage_space_data where id = ?";	
		try{
		
			StorageSpace storageSpace = queryForObject(SQL, new Object[]{storageSpaceId}, getStorageSpaceMapper());
			return storageSpace;
		}catch(EmptyResultDataAccessException e){
			throw new StorageSpaceNotFoundException("StorageSpace("+storageSpaceId+") is not found!");
		}
		
		
	}
	protected StorageSpace extractStorageSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from storage_space_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			StorageSpace storageSpace = queryForObject(SQL, new Object[]{accessKey.getValue()}, getStorageSpaceMapper());
			return storageSpace;
		}catch(EmptyResultDataAccessException e){
			throw new StorageSpaceNotFoundException("StorageSpace("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected StorageSpace loadInternalStorageSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		StorageSpace storageSpace = extractStorageSpace(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(storageSpace, loadOptions);
 		}
 
		
		if(isExtractGoodsShelfListEnabled(loadOptions)){
	 		extractGoodsShelfList(storageSpace, loadOptions);
 		}		
		
		return storageSpace;
		
	}



	
	
	 

 	protected StorageSpace extractWarehouse(StorageSpace storageSpace, Map<String,Object> options) throws Exception{

		if(storageSpace.getWarehouse() == null){
			return storageSpace;
		}
		String warehouseId = storageSpace.getWarehouse().getId();
		if( warehouseId == null){
			return storageSpace;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			storageSpace.setWarehouse(warehouse);
		}
		
 		
 		return storageSpace;
 	}
 		
 
		
	protected StorageSpace extractGoodsShelfList(StorageSpace storageSpace, Map<String,Object> options){
		
		SmartList<GoodsShelf> goodsShelfList = getGoodsShelfDAO().findGoodsShelfByStorageSpace(storageSpace.getId(),options);
		if(goodsShelfList != null){
			storageSpace.setGoodsShelfList(goodsShelfList);
		}
		
		return storageSpace;
	
	}	
		
		
  	
 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ?";
		SmartList<StorageSpace> storageSpaceList = queryForList(SQL, new Object[]{warehouseId}, getStorageSpaceMapper());	
 		return storageSpaceList;
 	}
 	
 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<StorageSpace> storageSpaceList = queryForList(SQL, new Object[]{warehouseId,start, count}, getStorageSpaceMapper());
		
 		return storageSpaceList;
 	}
 	
 	public int countStorageSpaceByWarehouse(String warehouseId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where warehouse = ?";
		Integer count = queryInt(SQL, new Object[]{warehouseId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected StorageSpace saveStorageSpace(StorageSpace  storageSpace){
	
		String SQL=this.getSaveStorageSpaceSQL(storageSpace);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveStorageSpaceParameters(storageSpace);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		storageSpace.incVersion();
		return storageSpace;
	
	}
	public SmartList<StorageSpace> saveStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitStorageSpaceList(storageSpaceList);
		
		batchStorageSpaceCreate((List<StorageSpace>)lists[CREATE_LIST_INDEX]);
		
		batchStorageSpaceUpdate((List<StorageSpace>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(StorageSpace storageSpace:storageSpaceList){
			if(storageSpace.isChanged()){
				storageSpace.incVersion();
			}
			
		
		}
		
		
		return storageSpaceList;
	}

	public SmartList<StorageSpace> removeStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options){
		
		
		super.removeList(storageSpaceList, options);
		
		return storageSpaceList;
		
		
	}
	
	protected List<Object[]> prepareStorageSpaceBatchCreateArgs(List<StorageSpace> storageSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StorageSpace storageSpace:storageSpaceList ){
			Object [] parameters = prepareStorageSpaceCreateParameters(storageSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareStorageSpaceBatchUpdateArgs(List<StorageSpace> storageSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StorageSpace storageSpace:storageSpaceList ){
			if(!storageSpace.isChanged()){
				continue;
			}
			Object [] parameters = prepareStorageSpaceUpdateParameters(storageSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchStorageSpaceCreate(List<StorageSpace> storageSpaceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareStorageSpaceBatchCreateArgs(storageSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchStorageSpaceUpdate(List<StorageSpace> storageSpaceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareStorageSpaceBatchUpdateArgs(storageSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitStorageSpaceList(List<StorageSpace> storageSpaceList){
		
		List<StorageSpace> storageSpaceCreateList=new ArrayList<StorageSpace>();
		List<StorageSpace> storageSpaceUpdateList=new ArrayList<StorageSpace>();
		
		for(StorageSpace storageSpace: storageSpaceList){
			if(isUpdateRequest(storageSpace)){
				storageSpaceUpdateList.add( storageSpace);
				continue;
			}
			storageSpaceCreateList.add(storageSpace);
		}
		
		return new Object[]{storageSpaceCreateList,storageSpaceUpdateList};
	}
	
	protected boolean isUpdateRequest(StorageSpace storageSpace){
 		return storageSpace.getVersion() > 0;
 	}
 	protected String getSaveStorageSpaceSQL(StorageSpace storageSpace){
 		if(isUpdateRequest(storageSpace)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveStorageSpaceParameters(StorageSpace storageSpace){
 		if(isUpdateRequest(storageSpace) ){
 			return prepareStorageSpaceUpdateParameters(storageSpace);
 		}
 		return prepareStorageSpaceCreateParameters(storageSpace);
 	}
 	protected Object[] prepareStorageSpaceUpdateParameters(StorageSpace storageSpace){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = storageSpace.getLocation();
 		parameters[1] = storageSpace.getContactNumber();
 		parameters[2] = storageSpace.getTotalArea(); 	
 		if(storageSpace.getWarehouse() != null){
 			parameters[3] = storageSpace.getWarehouse().getId();
 		}
 
 		parameters[4] = storageSpace.getLatitude();
 		parameters[5] = storageSpace.getLongitude();		
 		parameters[6] = storageSpace.getId();
 		parameters[7] = storageSpace.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareStorageSpaceCreateParameters(StorageSpace storageSpace){
		Object[] parameters = new Object[7];
		String newStorageSpaceId=getNextId();
		storageSpace.setId(newStorageSpaceId);
		parameters[0] =  storageSpace.getId();
 
 		parameters[1] = storageSpace.getLocation();
 		parameters[2] = storageSpace.getContactNumber();
 		parameters[3] = storageSpace.getTotalArea(); 	
 		if(storageSpace.getWarehouse() != null){
 			parameters[4] = storageSpace.getWarehouse().getId();
 		
 		}
 		
 		parameters[5] = storageSpace.getLatitude();
 		parameters[6] = storageSpace.getLongitude();		
 				
 		return parameters;
 	}
 	
	protected StorageSpace saveInternalStorageSpace(StorageSpace storageSpace, Map<String,Object> options){
		
		saveStorageSpace(storageSpace);
 	
 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(storageSpace, options);
 		}
 
		
		if(isSaveGoodsShelfListEnabled(options)){
	 		saveGoodsShelfList(storageSpace, options);
	 		removeGoodsShelfList(storageSpace, options);
	 		
 		}		
		
		return storageSpace;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected StorageSpace saveWarehouse(StorageSpace storageSpace, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(storageSpace.getWarehouse() == null){
 			return storageSpace;//do nothing when it is null
 		}
 		
 		getWarehouseDAO().save(storageSpace.getWarehouse(),options);
 		return storageSpace;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected StorageSpace saveGoodsShelfList(StorageSpace storageSpace, Map<String,Object> options){
		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			return storageSpace;
		}
		if(goodsShelfList.isEmpty()){
			return storageSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsShelfDAO().saveGoodsShelfList(goodsShelfList,options);
		
		return storageSpace;
	
	}
	
	protected StorageSpace removeGoodsShelfList(StorageSpace storageSpace, Map<String,Object> options){
	
	
		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			return storageSpace;
		}	
	
		SmartList<GoodsShelf> toRemoveGoodsShelfList = goodsShelfList.getToRemoveList();
		
		if(toRemoveGoodsShelfList == null){
			return storageSpace;
		}
		if(toRemoveGoodsShelfList.isEmpty()){
			return storageSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsShelfDAO().removeGoodsShelfList(toRemoveGoodsShelfList,options);
		
		return storageSpace;
	
	}
	
	
	
 	
 	
	
	
	
		

	public StorageSpace present(StorageSpace storageSpace,Map<String, Object> options){
	
		presentGoodsShelfList(storageSpace,options);

		return storageSpace;
	
	}
		
	
  	
 	protected StorageSpace presentGoodsShelfList(
			StorageSpace storageSpace,
			Map<String, Object> options) {

		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();		
		if(goodsShelfList == null){
			return storageSpace;			
		}
		
		String targetObjectName = "goodsShelf";
		int goodsShelfListSize = goodsShelfList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsShelfListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return storageSpace;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsShelfListSize;
		if(goodsShelfListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsShelfDAO().countGoodsShelfByStorageSpace(storageSpace.getId(), options);			
		}
		//storageSpace.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//storageSpace.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsShelfListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsShelfListSize,currentPage,rowsPerPage) ;
			goodsShelfList = goodsShelfList.subListOf(fromIndex, toIndex);
			goodsShelfList.setTotalCount(count);
			goodsShelfList.setCurrentPageNumber(currentPage);			
			storageSpace.setGoodsShelfList(goodsShelfList);
			return storageSpace;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsShelfList 
			= getGoodsShelfDAO().findGoodsShelfByStorageSpace(storageSpace.getId(),start, rowsPerPage, options );
		goodsShelfList.setTotalCount(count);
		goodsShelfList.setCurrentPageNumber(currentPage);
		storageSpace.setGoodsShelfList(goodsShelfList );	

		return storageSpace;
	}			
		


	protected String getTableName(){
		return StorageSpaceTable.TABLE_NAME;
	}
}


