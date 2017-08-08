
package com.skynet.retailscm.smartpallet;

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

public class SmartPalletJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SmartPalletDAO{
 
 	
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
	protected SmartPallet load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSmartPallet(accessKey, options);
	}
	*/
	public SmartPallet load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSmartPallet(SmartPalletTable.withId(id), options);
	}
	
	
	
	public SmartPallet save(SmartPallet smartPallet,Map<String,Object> options){
		
		String methodName="save(SmartPallet smartPallet,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(smartPallet, methodName, "smartPallet");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSmartPallet(smartPallet,options);
	}
	public SmartPallet clone(String smartPalletId, Map<String,Object> options) throws Exception{
	
		return clone(SmartPalletTable.withId(smartPalletId),options);
	}
	
	protected SmartPallet clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String smartPalletId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SmartPallet newSmartPallet = loadInternalSmartPallet(accessKey, options);
		newSmartPallet.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newSmartPallet.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSmartPallet(newSmartPallet,options);
		
		return newSmartPallet;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String smartPalletId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{smartPalletId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SmartPalletVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SmartPalletNotFoundException(
					"The " + this.getTableName() + "(" + smartPalletId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String smartPalletId, int version) throws Exception{
	
		String methodName="delete(String smartPalletId, int version)";
		assertMethodArgumentNotNull(smartPalletId, methodName, "smartPalletId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{smartPalletId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(smartPalletId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"location","contact_number","total_area","latitude","longitude","warehouse"};
		return SmartPalletTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "smart_pallet";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SmartPalletTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractWarehouseEnabled = true;
 	//private static final String WAREHOUSE = "warehouse";
 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SmartPalletTokens.WAREHOUSE);
 	}
 	
 	
 	//private boolean saveWarehouseEnabled = true;
 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SmartPalletTokens.WAREHOUSE);
 	}
 	

 	
 
		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SmartPalletTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, SmartPalletTokens.GOODS_LIST);
		
 	}
 	
 	
			
		

	

	protected SmartPalletMapper getSmartPalletMapper(){
		return new SmartPalletMapper();
	}
	protected SmartPallet extractSmartPallet(String smartPalletId) throws Exception{
		String SQL = "select * from smart_pallet_data where id = ?";	
		try{
		
			SmartPallet smartPallet = queryForObject(SQL, new Object[]{smartPalletId}, getSmartPalletMapper());
			return smartPallet;
		}catch(EmptyResultDataAccessException e){
			throw new SmartPalletNotFoundException("SmartPallet("+smartPalletId+") is not found!");
		}
		
		
	}
	protected SmartPallet extractSmartPallet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from smart_pallet_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SmartPallet smartPallet = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSmartPalletMapper());
			return smartPallet;
		}catch(EmptyResultDataAccessException e){
			throw new SmartPalletNotFoundException("SmartPallet("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SmartPallet loadInternalSmartPallet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SmartPallet smartPallet = extractSmartPallet(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(smartPallet, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(smartPallet, loadOptions);
 		}		
		
		return smartPallet;
		
	}



	
	
	 

 	protected SmartPallet extractWarehouse(SmartPallet smartPallet, Map<String,Object> options) throws Exception{

		if(smartPallet.getWarehouse() == null){
			return smartPallet;
		}
		String warehouseId = smartPallet.getWarehouse().getId();
		if( warehouseId == null){
			return smartPallet;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			smartPallet.setWarehouse(warehouse);
		}
		
 		
 		return smartPallet;
 	}
 		
 
		
	protected SmartPallet extractGoodsList(SmartPallet smartPallet, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsBySmartPallet(smartPallet.getId(),options);
		if(goodsList != null){
			smartPallet.setGoodsList(goodsList);
		}
		
		return smartPallet;
	
	}	
		
		
  	
 	public SmartList<SmartPallet> findSmartPalletByWarehouse(String warehouseId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ?";
		SmartList<SmartPallet> smartPalletList = queryForList(SQL, new Object[]{warehouseId}, getSmartPalletMapper());	
 		return smartPalletList;
 	}
 	
 	public SmartList<SmartPallet> findSmartPalletByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SmartPallet> smartPalletList = queryForList(SQL, new Object[]{warehouseId,start, count}, getSmartPalletMapper());
		
 		return smartPalletList;
 	}
 	
 	public int countSmartPalletByWarehouse(String warehouseId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where warehouse = ?";
		Integer count = queryInt(SQL, new Object[]{warehouseId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SmartPallet saveSmartPallet(SmartPallet  smartPallet){
	
		String SQL=this.getSaveSmartPalletSQL(smartPallet);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSmartPalletParameters(smartPallet);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		smartPallet.incVersion();
		return smartPallet;
	
	}
	public SmartList<SmartPallet> saveSmartPalletList(SmartList<SmartPallet> smartPalletList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSmartPalletList(smartPalletList);
		
		batchSmartPalletCreate((List<SmartPallet>)lists[CREATE_LIST_INDEX]);
		
		batchSmartPalletUpdate((List<SmartPallet>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SmartPallet smartPallet:smartPalletList){
			if(smartPallet.isChanged()){
				smartPallet.incVersion();
			}
			
		
		}
		
		
		return smartPalletList;
	}

	public SmartList<SmartPallet> removeSmartPalletList(SmartList<SmartPallet> smartPalletList,Map<String,Object> options){
		
		
		super.removeList(smartPalletList, options);
		
		return smartPalletList;
		
		
	}
	
	protected List<Object[]> prepareSmartPalletBatchCreateArgs(List<SmartPallet> smartPalletList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SmartPallet smartPallet:smartPalletList ){
			Object [] parameters = prepareSmartPalletCreateParameters(smartPallet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSmartPalletBatchUpdateArgs(List<SmartPallet> smartPalletList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SmartPallet smartPallet:smartPalletList ){
			if(!smartPallet.isChanged()){
				continue;
			}
			Object [] parameters = prepareSmartPalletUpdateParameters(smartPallet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSmartPalletCreate(List<SmartPallet> smartPalletList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSmartPalletBatchCreateArgs(smartPalletList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSmartPalletUpdate(List<SmartPallet> smartPalletList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSmartPalletBatchUpdateArgs(smartPalletList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSmartPalletList(List<SmartPallet> smartPalletList){
		
		List<SmartPallet> smartPalletCreateList=new ArrayList<SmartPallet>();
		List<SmartPallet> smartPalletUpdateList=new ArrayList<SmartPallet>();
		
		for(SmartPallet smartPallet: smartPalletList){
			if(isUpdateRequest(smartPallet)){
				smartPalletUpdateList.add( smartPallet);
				continue;
			}
			smartPalletCreateList.add(smartPallet);
		}
		
		return new Object[]{smartPalletCreateList,smartPalletUpdateList};
	}
	
	protected boolean isUpdateRequest(SmartPallet smartPallet){
 		return smartPallet.getVersion() > 0;
 	}
 	protected String getSaveSmartPalletSQL(SmartPallet smartPallet){
 		if(isUpdateRequest(smartPallet)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSmartPalletParameters(SmartPallet smartPallet){
 		if(isUpdateRequest(smartPallet) ){
 			return prepareSmartPalletUpdateParameters(smartPallet);
 		}
 		return prepareSmartPalletCreateParameters(smartPallet);
 	}
 	protected Object[] prepareSmartPalletUpdateParameters(SmartPallet smartPallet){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = smartPallet.getLocation();
 		parameters[1] = smartPallet.getContactNumber();
 		parameters[2] = smartPallet.getTotalArea();
 		parameters[3] = smartPallet.getLatitude();
 		parameters[4] = smartPallet.getLongitude(); 	
 		if(smartPallet.getWarehouse() != null){
 			parameters[5] = smartPallet.getWarehouse().getId();
 		}
 		
 		parameters[6] = smartPallet.getId();
 		parameters[7] = smartPallet.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSmartPalletCreateParameters(SmartPallet smartPallet){
		Object[] parameters = new Object[7];
		String newSmartPalletId=getNextId();
		smartPallet.setId(newSmartPalletId);
		parameters[0] =  smartPallet.getId();
 
 		parameters[1] = smartPallet.getLocation();
 		parameters[2] = smartPallet.getContactNumber();
 		parameters[3] = smartPallet.getTotalArea();
 		parameters[4] = smartPallet.getLatitude();
 		parameters[5] = smartPallet.getLongitude(); 	
 		if(smartPallet.getWarehouse() != null){
 			parameters[6] = smartPallet.getWarehouse().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected SmartPallet saveInternalSmartPallet(SmartPallet smartPallet, Map<String,Object> options){
		
		saveSmartPallet(smartPallet);
 	
 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(smartPallet, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(smartPallet, options);
	 		removeGoodsList(smartPallet, options);
	 		
 		}		
		
		return smartPallet;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SmartPallet saveWarehouse(SmartPallet smartPallet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(smartPallet.getWarehouse() == null){
 			return smartPallet;//do nothing when it is null
 		}
 		
 		getWarehouseDAO().save(smartPallet.getWarehouse(),options);
 		return smartPallet;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected SmartPallet saveGoodsList(SmartPallet smartPallet, Map<String,Object> options){
		SmartList<Goods> goodsList = smartPallet.getGoodsList();
		if(goodsList == null){
			return smartPallet;
		}
		if(goodsList.isEmpty()){
			return smartPallet;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return smartPallet;
	
	}
	
	protected SmartPallet removeGoodsList(SmartPallet smartPallet, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = smartPallet.getGoodsList();
		if(goodsList == null){
			return smartPallet;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return smartPallet;
		}
		if(toRemoveGoodsList.isEmpty()){
			return smartPallet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return smartPallet;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SmartPallet present(SmartPallet smartPallet,Map<String, Object> options){
	
		presentGoodsList(smartPallet,options);

		return smartPallet;
	
	}
		
	
  	
 	protected SmartPallet presentGoodsList(
			SmartPallet smartPallet,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = smartPallet.getGoodsList();		
		if(goodsList == null){
			return smartPallet;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return smartPallet;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsBySmartPallet(smartPallet.getId(), options);			
		}
		//smartPallet.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//smartPallet.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			smartPallet.setGoodsList(goodsList);
			return smartPallet;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsBySmartPallet(smartPallet.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		smartPallet.setGoodsList(goodsList );	

		return smartPallet;
	}			
		


	protected String getTableName(){
		return SmartPalletTable.TABLE_NAME;
	}
}


