
package com.skynet.retailscm.goodsallocation;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.goodsshelf.GoodsShelf;

import com.skynet.retailscm.goodsshelf.GoodsShelfDAO;
import com.skynet.retailscm.goods.GoodsDAO;

import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.goodsshelf.GoodsShelfTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class GoodsAllocationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements GoodsAllocationDAO{
 
 	
 	private  GoodsShelfDAO  goodsShelfDAO;
 	public void setGoodsShelfDAO(GoodsShelfDAO goodsShelfDAO){
	 	this.goodsShelfDAO = goodsShelfDAO;
 	}
 	public GoodsShelfDAO getGoodsShelfDAO(){
	 	return this.goodsShelfDAO;
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
	protected GoodsAllocation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsAllocation(accessKey, options);
	}
	*/
	public GoodsAllocation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsAllocation(GoodsAllocationTable.withId(id), options);
	}
	
	
	
	public GoodsAllocation save(GoodsAllocation goodsAllocation,Map<String,Object> options){
		
		String methodName="save(GoodsAllocation goodsAllocation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(goodsAllocation, methodName, "goodsAllocation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGoodsAllocation(goodsAllocation,options);
	}
	public GoodsAllocation clone(String goodsAllocationId, Map<String,Object> options) throws Exception{
	
		return clone(GoodsAllocationTable.withId(goodsAllocationId),options);
	}
	
	protected GoodsAllocation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String goodsAllocationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		GoodsAllocation newGoodsAllocation = loadInternalGoodsAllocation(accessKey, options);
		newGoodsAllocation.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newGoodsAllocation.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalGoodsAllocation(newGoodsAllocation,options);
		
		return newGoodsAllocation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String goodsAllocationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{goodsAllocationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new GoodsAllocationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsAllocationNotFoundException(
					"The " + this.getTableName() + "(" + goodsAllocationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String goodsAllocationId, int version) throws Exception{
	
		String methodName="delete(String goodsAllocationId, int version)";
		assertMethodArgumentNotNull(goodsAllocationId, methodName, "goodsAllocationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsAllocationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsAllocationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"location","latitude","longitude","goods_shelf"};
		return GoodsAllocationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "goods_allocation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsAllocationTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractGoodsShelfEnabled = true;
 	//private static final String GOODSSHELF = "goodsShelf";
 	protected boolean isExtractGoodsShelfEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsAllocationTokens.GOODSSHELF);
 	}
 	
 	
 	//private boolean saveGoodsShelfEnabled = true;
 	protected boolean isSaveGoodsShelfEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsAllocationTokens.GOODSSHELF);
 	}
 	

 	
 
		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsAllocationTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsAllocationTokens.GOODS_LIST);
		
 	}
 	
 	
			
		

	

	protected GoodsAllocationMapper getGoodsAllocationMapper(){
		return new GoodsAllocationMapper();
	}
	protected GoodsAllocation extractGoodsAllocation(String goodsAllocationId) throws Exception{
		String SQL = "select * from goods_allocation_data where id = ?";	
		try{
		
			GoodsAllocation goodsAllocation = queryForObject(SQL, new Object[]{goodsAllocationId}, getGoodsAllocationMapper());
			return goodsAllocation;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsAllocationNotFoundException("GoodsAllocation("+goodsAllocationId+") is not found!");
		}
		
		
	}
	protected GoodsAllocation extractGoodsAllocation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from goods_allocation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			GoodsAllocation goodsAllocation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getGoodsAllocationMapper());
			return goodsAllocation;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsAllocationNotFoundException("GoodsAllocation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected GoodsAllocation loadInternalGoodsAllocation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GoodsAllocation goodsAllocation = extractGoodsAllocation(accessKey, loadOptions);
 	
 		if(isExtractGoodsShelfEnabled(loadOptions)){
	 		extractGoodsShelf(goodsAllocation, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(goodsAllocation, loadOptions);
 		}		
		
		return goodsAllocation;
		
	}



	
	
	 

 	protected GoodsAllocation extractGoodsShelf(GoodsAllocation goodsAllocation, Map<String,Object> options) throws Exception{

		if(goodsAllocation.getGoodsShelf() == null){
			return goodsAllocation;
		}
		String goodsShelfId = goodsAllocation.getGoodsShelf().getId();
		if( goodsShelfId == null){
			return goodsAllocation;
		}
		GoodsShelf goodsShelf = getGoodsShelfDAO().load(goodsShelfId,options);
		if(goodsShelf != null){
			goodsAllocation.setGoodsShelf(goodsShelf);
		}
		
 		
 		return goodsAllocation;
 	}
 		
 
		
	protected GoodsAllocation extractGoodsList(GoodsAllocation goodsAllocation, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByGoodsAllocation(goodsAllocation.getId(),options);
		if(goodsList != null){
			goodsAllocation.setGoodsList(goodsList);
		}
		
		return goodsAllocation;
	
	}	
		
		
  	
 	public SmartList<GoodsAllocation> findGoodsAllocationByGoodsShelf(String goodsShelfId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where goods_shelf = ?";
		SmartList<GoodsAllocation> goodsAllocationList = queryForList(SQL, new Object[]{goodsShelfId}, getGoodsAllocationMapper());	
 		return goodsAllocationList;
 	}
 	
 	public SmartList<GoodsAllocation> findGoodsAllocationByGoodsShelf(String goodsShelfId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where goods_shelf = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<GoodsAllocation> goodsAllocationList = queryForList(SQL, new Object[]{goodsShelfId,start, count}, getGoodsAllocationMapper());
		
 		return goodsAllocationList;
 	}
 	
 	public int countGoodsAllocationByGoodsShelf(String goodsShelfId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where goods_shelf = ?";
		Integer count = queryInt(SQL, new Object[]{goodsShelfId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected GoodsAllocation saveGoodsAllocation(GoodsAllocation  goodsAllocation){
	
		String SQL=this.getSaveGoodsAllocationSQL(goodsAllocation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsAllocationParameters(goodsAllocation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		goodsAllocation.incVersion();
		return goodsAllocation;
	
	}
	public SmartList<GoodsAllocation> saveGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsAllocationList(goodsAllocationList);
		
		batchGoodsAllocationCreate((List<GoodsAllocation>)lists[CREATE_LIST_INDEX]);
		
		batchGoodsAllocationUpdate((List<GoodsAllocation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(GoodsAllocation goodsAllocation:goodsAllocationList){
			if(goodsAllocation.isChanged()){
				goodsAllocation.incVersion();
			}
			
		
		}
		
		
		return goodsAllocationList;
	}

	public SmartList<GoodsAllocation> removeGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList,Map<String,Object> options){
		
		
		super.removeList(goodsAllocationList, options);
		
		return goodsAllocationList;
		
		
	}
	
	protected List<Object[]> prepareGoodsAllocationBatchCreateArgs(List<GoodsAllocation> goodsAllocationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsAllocation goodsAllocation:goodsAllocationList ){
			Object [] parameters = prepareGoodsAllocationCreateParameters(goodsAllocation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGoodsAllocationBatchUpdateArgs(List<GoodsAllocation> goodsAllocationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsAllocation goodsAllocation:goodsAllocationList ){
			if(!goodsAllocation.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsAllocationUpdateParameters(goodsAllocation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGoodsAllocationCreate(List<GoodsAllocation> goodsAllocationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsAllocationBatchCreateArgs(goodsAllocationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGoodsAllocationUpdate(List<GoodsAllocation> goodsAllocationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsAllocationBatchUpdateArgs(goodsAllocationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGoodsAllocationList(List<GoodsAllocation> goodsAllocationList){
		
		List<GoodsAllocation> goodsAllocationCreateList=new ArrayList<GoodsAllocation>();
		List<GoodsAllocation> goodsAllocationUpdateList=new ArrayList<GoodsAllocation>();
		
		for(GoodsAllocation goodsAllocation: goodsAllocationList){
			if(isUpdateRequest(goodsAllocation)){
				goodsAllocationUpdateList.add( goodsAllocation);
				continue;
			}
			goodsAllocationCreateList.add(goodsAllocation);
		}
		
		return new Object[]{goodsAllocationCreateList,goodsAllocationUpdateList};
	}
	
	protected boolean isUpdateRequest(GoodsAllocation goodsAllocation){
 		return goodsAllocation.getVersion() > 0;
 	}
 	protected String getSaveGoodsAllocationSQL(GoodsAllocation goodsAllocation){
 		if(isUpdateRequest(goodsAllocation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGoodsAllocationParameters(GoodsAllocation goodsAllocation){
 		if(isUpdateRequest(goodsAllocation) ){
 			return prepareGoodsAllocationUpdateParameters(goodsAllocation);
 		}
 		return prepareGoodsAllocationCreateParameters(goodsAllocation);
 	}
 	protected Object[] prepareGoodsAllocationUpdateParameters(GoodsAllocation goodsAllocation){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = goodsAllocation.getLocation();
 		parameters[1] = goodsAllocation.getLatitude();
 		parameters[2] = goodsAllocation.getLongitude(); 	
 		if(goodsAllocation.getGoodsShelf() != null){
 			parameters[3] = goodsAllocation.getGoodsShelf().getId();
 		}
 		
 		parameters[4] = goodsAllocation.getId();
 		parameters[5] = goodsAllocation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGoodsAllocationCreateParameters(GoodsAllocation goodsAllocation){
		Object[] parameters = new Object[5];
		String newGoodsAllocationId=getNextId();
		goodsAllocation.setId(newGoodsAllocationId);
		parameters[0] =  goodsAllocation.getId();
 
 		parameters[1] = goodsAllocation.getLocation();
 		parameters[2] = goodsAllocation.getLatitude();
 		parameters[3] = goodsAllocation.getLongitude(); 	
 		if(goodsAllocation.getGoodsShelf() != null){
 			parameters[4] = goodsAllocation.getGoodsShelf().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected GoodsAllocation saveInternalGoodsAllocation(GoodsAllocation goodsAllocation, Map<String,Object> options){
		
		saveGoodsAllocation(goodsAllocation);
 	
 		if(isSaveGoodsShelfEnabled(options)){
	 		saveGoodsShelf(goodsAllocation, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(goodsAllocation, options);
	 		removeGoodsList(goodsAllocation, options);
	 		
 		}		
		
		return goodsAllocation;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected GoodsAllocation saveGoodsShelf(GoodsAllocation goodsAllocation, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goodsAllocation.getGoodsShelf() == null){
 			return goodsAllocation;//do nothing when it is null
 		}
 		
 		getGoodsShelfDAO().save(goodsAllocation.getGoodsShelf(),options);
 		return goodsAllocation;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected GoodsAllocation saveGoodsList(GoodsAllocation goodsAllocation, Map<String,Object> options){
		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		if(goodsList == null){
			return goodsAllocation;
		}
		if(goodsList.isEmpty()){
			return goodsAllocation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return goodsAllocation;
	
	}
	
	protected GoodsAllocation removeGoodsList(GoodsAllocation goodsAllocation, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		if(goodsList == null){
			return goodsAllocation;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return goodsAllocation;
		}
		if(toRemoveGoodsList.isEmpty()){
			return goodsAllocation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return goodsAllocation;
	
	}
	
	
	
 	
 	
	
	
	
		

	public GoodsAllocation present(GoodsAllocation goodsAllocation,Map<String, Object> options){
	
		presentGoodsList(goodsAllocation,options);

		return goodsAllocation;
	
	}
		
	
  	
 	protected GoodsAllocation presentGoodsList(
			GoodsAllocation goodsAllocation,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();		
		if(goodsList == null){
			return goodsAllocation;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return goodsAllocation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsByGoodsAllocation(goodsAllocation.getId(), options);			
		}
		//goodsAllocation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//goodsAllocation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			goodsAllocation.setGoodsList(goodsList);
			return goodsAllocation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsByGoodsAllocation(goodsAllocation.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		goodsAllocation.setGoodsList(goodsList );	

		return goodsAllocation;
	}			
		


	protected String getTableName(){
		return GoodsAllocationTable.TABLE_NAME;
	}
}


