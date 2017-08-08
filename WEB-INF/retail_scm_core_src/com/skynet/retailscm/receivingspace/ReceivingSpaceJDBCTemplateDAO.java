
package com.skynet.retailscm.receivingspace;

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

public class ReceivingSpaceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ReceivingSpaceDAO{
 
 	
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
	protected ReceivingSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalReceivingSpace(accessKey, options);
	}
	*/
	public ReceivingSpace load(String id,Map<String,Object> options) throws Exception{
		return loadInternalReceivingSpace(ReceivingSpaceTable.withId(id), options);
	}
	
	
	
	public ReceivingSpace save(ReceivingSpace receivingSpace,Map<String,Object> options){
		
		String methodName="save(ReceivingSpace receivingSpace,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(receivingSpace, methodName, "receivingSpace");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalReceivingSpace(receivingSpace,options);
	}
	public ReceivingSpace clone(String receivingSpaceId, Map<String,Object> options) throws Exception{
	
		return clone(ReceivingSpaceTable.withId(receivingSpaceId),options);
	}
	
	protected ReceivingSpace clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String receivingSpaceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ReceivingSpace newReceivingSpace = loadInternalReceivingSpace(accessKey, options);
		newReceivingSpace.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newReceivingSpace.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalReceivingSpace(newReceivingSpace,options);
		
		return newReceivingSpace;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String receivingSpaceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{receivingSpaceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ReceivingSpaceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ReceivingSpaceNotFoundException(
					"The " + this.getTableName() + "(" + receivingSpaceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String receivingSpaceId, int version) throws Exception{
	
		String methodName="delete(String receivingSpaceId, int version)";
		assertMethodArgumentNotNull(receivingSpaceId, methodName, "receivingSpaceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{receivingSpaceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(receivingSpaceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"location","contact_number","description","total_area","warehouse","latitude","longitude"};
		return ReceivingSpaceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "receiving_space";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ReceivingSpaceTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractWarehouseEnabled = true;
 	//private static final String WAREHOUSE = "warehouse";
 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ReceivingSpaceTokens.WAREHOUSE);
 	}
 	
 	
 	//private boolean saveWarehouseEnabled = true;
 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ReceivingSpaceTokens.WAREHOUSE);
 	}
 	

 	
 
		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ReceivingSpaceTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, ReceivingSpaceTokens.GOODS_LIST);
		
 	}
 	
 	
			
		

	

	protected ReceivingSpaceMapper getReceivingSpaceMapper(){
		return new ReceivingSpaceMapper();
	}
	protected ReceivingSpace extractReceivingSpace(String receivingSpaceId) throws Exception{
		String SQL = "select * from receiving_space_data where id = ?";	
		try{
		
			ReceivingSpace receivingSpace = queryForObject(SQL, new Object[]{receivingSpaceId}, getReceivingSpaceMapper());
			return receivingSpace;
		}catch(EmptyResultDataAccessException e){
			throw new ReceivingSpaceNotFoundException("ReceivingSpace("+receivingSpaceId+") is not found!");
		}
		
		
	}
	protected ReceivingSpace extractReceivingSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from receiving_space_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ReceivingSpace receivingSpace = queryForObject(SQL, new Object[]{accessKey.getValue()}, getReceivingSpaceMapper());
			return receivingSpace;
		}catch(EmptyResultDataAccessException e){
			throw new ReceivingSpaceNotFoundException("ReceivingSpace("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ReceivingSpace loadInternalReceivingSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ReceivingSpace receivingSpace = extractReceivingSpace(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(receivingSpace, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(receivingSpace, loadOptions);
 		}		
		
		return receivingSpace;
		
	}



	
	
	 

 	protected ReceivingSpace extractWarehouse(ReceivingSpace receivingSpace, Map<String,Object> options) throws Exception{

		if(receivingSpace.getWarehouse() == null){
			return receivingSpace;
		}
		String warehouseId = receivingSpace.getWarehouse().getId();
		if( warehouseId == null){
			return receivingSpace;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			receivingSpace.setWarehouse(warehouse);
		}
		
 		
 		return receivingSpace;
 	}
 		
 
		
	protected ReceivingSpace extractGoodsList(ReceivingSpace receivingSpace, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByReceivingSpace(receivingSpace.getId(),options);
		if(goodsList != null){
			receivingSpace.setGoodsList(goodsList);
		}
		
		return receivingSpace;
	
	}	
		
		
  	
 	public SmartList<ReceivingSpace> findReceivingSpaceByWarehouse(String warehouseId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ?";
		SmartList<ReceivingSpace> receivingSpaceList = queryForList(SQL, new Object[]{warehouseId}, getReceivingSpaceMapper());	
 		return receivingSpaceList;
 	}
 	
 	public SmartList<ReceivingSpace> findReceivingSpaceByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ReceivingSpace> receivingSpaceList = queryForList(SQL, new Object[]{warehouseId,start, count}, getReceivingSpaceMapper());
		
 		return receivingSpaceList;
 	}
 	
 	public int countReceivingSpaceByWarehouse(String warehouseId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where warehouse = ?";
		Integer count = queryInt(SQL, new Object[]{warehouseId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ReceivingSpace saveReceivingSpace(ReceivingSpace  receivingSpace){
	
		String SQL=this.getSaveReceivingSpaceSQL(receivingSpace);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveReceivingSpaceParameters(receivingSpace);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		receivingSpace.incVersion();
		return receivingSpace;
	
	}
	public SmartList<ReceivingSpace> saveReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitReceivingSpaceList(receivingSpaceList);
		
		batchReceivingSpaceCreate((List<ReceivingSpace>)lists[CREATE_LIST_INDEX]);
		
		batchReceivingSpaceUpdate((List<ReceivingSpace>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ReceivingSpace receivingSpace:receivingSpaceList){
			if(receivingSpace.isChanged()){
				receivingSpace.incVersion();
			}
			
		
		}
		
		
		return receivingSpaceList;
	}

	public SmartList<ReceivingSpace> removeReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList,Map<String,Object> options){
		
		
		super.removeList(receivingSpaceList, options);
		
		return receivingSpaceList;
		
		
	}
	
	protected List<Object[]> prepareReceivingSpaceBatchCreateArgs(List<ReceivingSpace> receivingSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ReceivingSpace receivingSpace:receivingSpaceList ){
			Object [] parameters = prepareReceivingSpaceCreateParameters(receivingSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareReceivingSpaceBatchUpdateArgs(List<ReceivingSpace> receivingSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ReceivingSpace receivingSpace:receivingSpaceList ){
			if(!receivingSpace.isChanged()){
				continue;
			}
			Object [] parameters = prepareReceivingSpaceUpdateParameters(receivingSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchReceivingSpaceCreate(List<ReceivingSpace> receivingSpaceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareReceivingSpaceBatchCreateArgs(receivingSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchReceivingSpaceUpdate(List<ReceivingSpace> receivingSpaceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareReceivingSpaceBatchUpdateArgs(receivingSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitReceivingSpaceList(List<ReceivingSpace> receivingSpaceList){
		
		List<ReceivingSpace> receivingSpaceCreateList=new ArrayList<ReceivingSpace>();
		List<ReceivingSpace> receivingSpaceUpdateList=new ArrayList<ReceivingSpace>();
		
		for(ReceivingSpace receivingSpace: receivingSpaceList){
			if(isUpdateRequest(receivingSpace)){
				receivingSpaceUpdateList.add( receivingSpace);
				continue;
			}
			receivingSpaceCreateList.add(receivingSpace);
		}
		
		return new Object[]{receivingSpaceCreateList,receivingSpaceUpdateList};
	}
	
	protected boolean isUpdateRequest(ReceivingSpace receivingSpace){
 		return receivingSpace.getVersion() > 0;
 	}
 	protected String getSaveReceivingSpaceSQL(ReceivingSpace receivingSpace){
 		if(isUpdateRequest(receivingSpace)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveReceivingSpaceParameters(ReceivingSpace receivingSpace){
 		if(isUpdateRequest(receivingSpace) ){
 			return prepareReceivingSpaceUpdateParameters(receivingSpace);
 		}
 		return prepareReceivingSpaceCreateParameters(receivingSpace);
 	}
 	protected Object[] prepareReceivingSpaceUpdateParameters(ReceivingSpace receivingSpace){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = receivingSpace.getLocation();
 		parameters[1] = receivingSpace.getContactNumber();
 		parameters[2] = receivingSpace.getDescription();
 		parameters[3] = receivingSpace.getTotalArea(); 	
 		if(receivingSpace.getWarehouse() != null){
 			parameters[4] = receivingSpace.getWarehouse().getId();
 		}
 
 		parameters[5] = receivingSpace.getLatitude();
 		parameters[6] = receivingSpace.getLongitude();		
 		parameters[7] = receivingSpace.getId();
 		parameters[8] = receivingSpace.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareReceivingSpaceCreateParameters(ReceivingSpace receivingSpace){
		Object[] parameters = new Object[8];
		String newReceivingSpaceId=getNextId();
		receivingSpace.setId(newReceivingSpaceId);
		parameters[0] =  receivingSpace.getId();
 
 		parameters[1] = receivingSpace.getLocation();
 		parameters[2] = receivingSpace.getContactNumber();
 		parameters[3] = receivingSpace.getDescription();
 		parameters[4] = receivingSpace.getTotalArea(); 	
 		if(receivingSpace.getWarehouse() != null){
 			parameters[5] = receivingSpace.getWarehouse().getId();
 		
 		}
 		
 		parameters[6] = receivingSpace.getLatitude();
 		parameters[7] = receivingSpace.getLongitude();		
 				
 		return parameters;
 	}
 	
	protected ReceivingSpace saveInternalReceivingSpace(ReceivingSpace receivingSpace, Map<String,Object> options){
		
		saveReceivingSpace(receivingSpace);
 	
 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(receivingSpace, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(receivingSpace, options);
	 		removeGoodsList(receivingSpace, options);
	 		
 		}		
		
		return receivingSpace;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ReceivingSpace saveWarehouse(ReceivingSpace receivingSpace, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(receivingSpace.getWarehouse() == null){
 			return receivingSpace;//do nothing when it is null
 		}
 		
 		getWarehouseDAO().save(receivingSpace.getWarehouse(),options);
 		return receivingSpace;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected ReceivingSpace saveGoodsList(ReceivingSpace receivingSpace, Map<String,Object> options){
		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		if(goodsList == null){
			return receivingSpace;
		}
		if(goodsList.isEmpty()){
			return receivingSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return receivingSpace;
	
	}
	
	protected ReceivingSpace removeGoodsList(ReceivingSpace receivingSpace, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		if(goodsList == null){
			return receivingSpace;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return receivingSpace;
		}
		if(toRemoveGoodsList.isEmpty()){
			return receivingSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return receivingSpace;
	
	}
	
	
	
 	
 	
	
	
	
		

	public ReceivingSpace present(ReceivingSpace receivingSpace,Map<String, Object> options){
	
		presentGoodsList(receivingSpace,options);

		return receivingSpace;
	
	}
		
	
  	
 	protected ReceivingSpace presentGoodsList(
			ReceivingSpace receivingSpace,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = receivingSpace.getGoodsList();		
		if(goodsList == null){
			return receivingSpace;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return receivingSpace;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsByReceivingSpace(receivingSpace.getId(), options);			
		}
		//receivingSpace.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//receivingSpace.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			receivingSpace.setGoodsList(goodsList);
			return receivingSpace;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsByReceivingSpace(receivingSpace.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		receivingSpace.setGoodsList(goodsList );	

		return receivingSpace;
	}			
		


	protected String getTableName(){
		return ReceivingSpaceTable.TABLE_NAME;
	}
}


