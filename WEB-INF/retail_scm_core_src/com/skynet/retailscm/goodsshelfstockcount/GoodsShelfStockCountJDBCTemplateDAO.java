
package com.skynet.retailscm.goodsshelfstockcount;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.goodsshelf.GoodsShelf;
import com.skynet.retailscm.stockcountissuetrack.StockCountIssueTrack;

import com.skynet.retailscm.goodsshelf.GoodsShelfDAO;
import com.skynet.retailscm.stockcountissuetrack.StockCountIssueTrackDAO;

import com.skynet.retailscm.goodsshelf.GoodsShelfTable;
import com.skynet.retailscm.stockcountissuetrack.StockCountIssueTrackTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class GoodsShelfStockCountJDBCTemplateDAO extends CommonJDBCTemplateDAO implements GoodsShelfStockCountDAO{
 
 	
 	private  GoodsShelfDAO  goodsShelfDAO;
 	public void setGoodsShelfDAO(GoodsShelfDAO goodsShelfDAO){
	 	this.goodsShelfDAO = goodsShelfDAO;
 	}
 	public GoodsShelfDAO getGoodsShelfDAO(){
	 	return this.goodsShelfDAO;
 	}

		
	
  	private  StockCountIssueTrackDAO  stockCountIssueTrackDAO;
 	public void setStockCountIssueTrackDAO(StockCountIssueTrackDAO pStockCountIssueTrackDAO){
 	
 		if(pStockCountIssueTrackDAO == null){
 			throw new IllegalStateException("Do not try to set stockCountIssueTrackDAO to null.");
 		}
	 	this.stockCountIssueTrackDAO = pStockCountIssueTrackDAO;
 	}
 	public StockCountIssueTrackDAO getStockCountIssueTrackDAO(){
 		if(this.stockCountIssueTrackDAO == null){
 			throw new IllegalStateException("The stockCountIssueTrackDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.stockCountIssueTrackDAO;
 	}	
 	
			
		

	
	/*
	protected GoodsShelfStockCount load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsShelfStockCount(accessKey, options);
	}
	*/
	public GoodsShelfStockCount load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsShelfStockCount(GoodsShelfStockCountTable.withId(id), options);
	}
	
	
	
	public GoodsShelfStockCount save(GoodsShelfStockCount goodsShelfStockCount,Map<String,Object> options){
		
		String methodName="save(GoodsShelfStockCount goodsShelfStockCount,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(goodsShelfStockCount, methodName, "goodsShelfStockCount");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGoodsShelfStockCount(goodsShelfStockCount,options);
	}
	public GoodsShelfStockCount clone(String goodsShelfStockCountId, Map<String,Object> options) throws Exception{
	
		return clone(GoodsShelfStockCountTable.withId(goodsShelfStockCountId),options);
	}
	
	protected GoodsShelfStockCount clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String goodsShelfStockCountId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		GoodsShelfStockCount newGoodsShelfStockCount = loadInternalGoodsShelfStockCount(accessKey, options);
		newGoodsShelfStockCount.setVersion(0);
		
		
 		
 		if(isSaveStockCountIssueTrackListEnabled(options)){
 			for(StockCountIssueTrack item: newGoodsShelfStockCount.getStockCountIssueTrackList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalGoodsShelfStockCount(newGoodsShelfStockCount,options);
		
		return newGoodsShelfStockCount;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String goodsShelfStockCountId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{goodsShelfStockCountId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new GoodsShelfStockCountVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsShelfStockCountNotFoundException(
					"The " + this.getTableName() + "(" + goodsShelfStockCountId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String goodsShelfStockCountId, int version) throws Exception{
	
		String methodName="delete(String goodsShelfStockCountId, int version)";
		assertMethodArgumentNotNull(goodsShelfStockCountId, methodName, "goodsShelfStockCountId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsShelfStockCountId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsShelfStockCountId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"title","count_time","summary","shelf"};
		return GoodsShelfStockCountTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "goods_shelf_stock_count";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsShelfStockCountTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractShelfEnabled = true;
 	//private static final String SHELF = "shelf";
 	protected boolean isExtractShelfEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsShelfStockCountTokens.SHELF);
 	}
 	
 	
 	//private boolean saveShelfEnabled = true;
 	protected boolean isSaveShelfEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsShelfStockCountTokens.SHELF);
 	}
 	

 	
 
		
	//protected static final String STOCK_COUNT_ISSUE_TRACK_LIST = "stockCountIssueTrackList";
	
	protected boolean isExtractStockCountIssueTrackListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsShelfStockCountTokens.STOCK_COUNT_ISSUE_TRACK_LIST);
		
 	}

	protected boolean isSaveStockCountIssueTrackListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsShelfStockCountTokens.STOCK_COUNT_ISSUE_TRACK_LIST);
		
 	}
 	
 	
			
		

	

	protected GoodsShelfStockCountMapper getGoodsShelfStockCountMapper(){
		return new GoodsShelfStockCountMapper();
	}
	protected GoodsShelfStockCount extractGoodsShelfStockCount(String goodsShelfStockCountId) throws Exception{
		String SQL = "select * from goods_shelf_stock_count_data where id = ?";	
		try{
		
			GoodsShelfStockCount goodsShelfStockCount = queryForObject(SQL, new Object[]{goodsShelfStockCountId}, getGoodsShelfStockCountMapper());
			return goodsShelfStockCount;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsShelfStockCountNotFoundException("GoodsShelfStockCount("+goodsShelfStockCountId+") is not found!");
		}
		
		
	}
	protected GoodsShelfStockCount extractGoodsShelfStockCount(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from goods_shelf_stock_count_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			GoodsShelfStockCount goodsShelfStockCount = queryForObject(SQL, new Object[]{accessKey.getValue()}, getGoodsShelfStockCountMapper());
			return goodsShelfStockCount;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsShelfStockCountNotFoundException("GoodsShelfStockCount("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected GoodsShelfStockCount loadInternalGoodsShelfStockCount(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GoodsShelfStockCount goodsShelfStockCount = extractGoodsShelfStockCount(accessKey, loadOptions);
 	
 		if(isExtractShelfEnabled(loadOptions)){
	 		extractShelf(goodsShelfStockCount, loadOptions);
 		}
 
		
		if(isExtractStockCountIssueTrackListEnabled(loadOptions)){
	 		extractStockCountIssueTrackList(goodsShelfStockCount, loadOptions);
 		}		
		
		return goodsShelfStockCount;
		
	}



	
	
	 

 	protected GoodsShelfStockCount extractShelf(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options) throws Exception{

		if(goodsShelfStockCount.getShelf() == null){
			return goodsShelfStockCount;
		}
		String shelfId = goodsShelfStockCount.getShelf().getId();
		if( shelfId == null){
			return goodsShelfStockCount;
		}
		GoodsShelf shelf = getGoodsShelfDAO().load(shelfId,options);
		if(shelf != null){
			goodsShelfStockCount.setShelf(shelf);
		}
		
 		
 		return goodsShelfStockCount;
 	}
 		
 
		
	protected GoodsShelfStockCount extractStockCountIssueTrackList(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){
		
		SmartList<StockCountIssueTrack> stockCountIssueTrackList = getStockCountIssueTrackDAO().findStockCountIssueTrackByStockCount(goodsShelfStockCount.getId(),options);
		if(stockCountIssueTrackList != null){
			goodsShelfStockCount.setStockCountIssueTrackList(stockCountIssueTrackList);
		}
		
		return goodsShelfStockCount;
	
	}	
		
		
  	
 	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountByShelf(String goodsShelfId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shelf = ?";
		SmartList<GoodsShelfStockCount> goodsShelfStockCountList = queryForList(SQL, new Object[]{goodsShelfId}, getGoodsShelfStockCountMapper());	
 		return goodsShelfStockCountList;
 	}
 	
 	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountByShelf(String goodsShelfId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shelf = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<GoodsShelfStockCount> goodsShelfStockCountList = queryForList(SQL, new Object[]{goodsShelfId,start, count}, getGoodsShelfStockCountMapper());
		
 		return goodsShelfStockCountList;
 	}
 	
 	public int countGoodsShelfStockCountByShelf(String goodsShelfId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where shelf = ?";
		Integer count = queryInt(SQL, new Object[]{goodsShelfId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected GoodsShelfStockCount saveGoodsShelfStockCount(GoodsShelfStockCount  goodsShelfStockCount){
	
		String SQL=this.getSaveGoodsShelfStockCountSQL(goodsShelfStockCount);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsShelfStockCountParameters(goodsShelfStockCount);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		goodsShelfStockCount.incVersion();
		return goodsShelfStockCount;
	
	}
	public SmartList<GoodsShelfStockCount> saveGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsShelfStockCountList(goodsShelfStockCountList);
		
		batchGoodsShelfStockCountCreate((List<GoodsShelfStockCount>)lists[CREATE_LIST_INDEX]);
		
		batchGoodsShelfStockCountUpdate((List<GoodsShelfStockCount>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList){
			if(goodsShelfStockCount.isChanged()){
				goodsShelfStockCount.incVersion();
			}
			
		
		}
		
		
		return goodsShelfStockCountList;
	}

	public SmartList<GoodsShelfStockCount> removeGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList,Map<String,Object> options){
		
		
		super.removeList(goodsShelfStockCountList, options);
		
		return goodsShelfStockCountList;
		
		
	}
	
	protected List<Object[]> prepareGoodsShelfStockCountBatchCreateArgs(List<GoodsShelfStockCount> goodsShelfStockCountList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList ){
			Object [] parameters = prepareGoodsShelfStockCountCreateParameters(goodsShelfStockCount);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGoodsShelfStockCountBatchUpdateArgs(List<GoodsShelfStockCount> goodsShelfStockCountList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList ){
			if(!goodsShelfStockCount.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsShelfStockCountUpdateParameters(goodsShelfStockCount);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGoodsShelfStockCountCreate(List<GoodsShelfStockCount> goodsShelfStockCountList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsShelfStockCountBatchCreateArgs(goodsShelfStockCountList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGoodsShelfStockCountUpdate(List<GoodsShelfStockCount> goodsShelfStockCountList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsShelfStockCountBatchUpdateArgs(goodsShelfStockCountList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGoodsShelfStockCountList(List<GoodsShelfStockCount> goodsShelfStockCountList){
		
		List<GoodsShelfStockCount> goodsShelfStockCountCreateList=new ArrayList<GoodsShelfStockCount>();
		List<GoodsShelfStockCount> goodsShelfStockCountUpdateList=new ArrayList<GoodsShelfStockCount>();
		
		for(GoodsShelfStockCount goodsShelfStockCount: goodsShelfStockCountList){
			if(isUpdateRequest(goodsShelfStockCount)){
				goodsShelfStockCountUpdateList.add( goodsShelfStockCount);
				continue;
			}
			goodsShelfStockCountCreateList.add(goodsShelfStockCount);
		}
		
		return new Object[]{goodsShelfStockCountCreateList,goodsShelfStockCountUpdateList};
	}
	
	protected boolean isUpdateRequest(GoodsShelfStockCount goodsShelfStockCount){
 		return goodsShelfStockCount.getVersion() > 0;
 	}
 	protected String getSaveGoodsShelfStockCountSQL(GoodsShelfStockCount goodsShelfStockCount){
 		if(isUpdateRequest(goodsShelfStockCount)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGoodsShelfStockCountParameters(GoodsShelfStockCount goodsShelfStockCount){
 		if(isUpdateRequest(goodsShelfStockCount) ){
 			return prepareGoodsShelfStockCountUpdateParameters(goodsShelfStockCount);
 		}
 		return prepareGoodsShelfStockCountCreateParameters(goodsShelfStockCount);
 	}
 	protected Object[] prepareGoodsShelfStockCountUpdateParameters(GoodsShelfStockCount goodsShelfStockCount){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = goodsShelfStockCount.getTitle();
 		parameters[1] = goodsShelfStockCount.getCountTime();
 		parameters[2] = goodsShelfStockCount.getSummary(); 	
 		if(goodsShelfStockCount.getShelf() != null){
 			parameters[3] = goodsShelfStockCount.getShelf().getId();
 		}
 		
 		parameters[4] = goodsShelfStockCount.getId();
 		parameters[5] = goodsShelfStockCount.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGoodsShelfStockCountCreateParameters(GoodsShelfStockCount goodsShelfStockCount){
		Object[] parameters = new Object[5];
		String newGoodsShelfStockCountId=getNextId();
		goodsShelfStockCount.setId(newGoodsShelfStockCountId);
		parameters[0] =  goodsShelfStockCount.getId();
 
 		parameters[1] = goodsShelfStockCount.getTitle();
 		parameters[2] = goodsShelfStockCount.getCountTime();
 		parameters[3] = goodsShelfStockCount.getSummary(); 	
 		if(goodsShelfStockCount.getShelf() != null){
 			parameters[4] = goodsShelfStockCount.getShelf().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected GoodsShelfStockCount saveInternalGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){
		
		saveGoodsShelfStockCount(goodsShelfStockCount);
 	
 		if(isSaveShelfEnabled(options)){
	 		saveShelf(goodsShelfStockCount, options);
 		}
 
		
		if(isSaveStockCountIssueTrackListEnabled(options)){
	 		saveStockCountIssueTrackList(goodsShelfStockCount, options);
	 		removeStockCountIssueTrackList(goodsShelfStockCount, options);
	 		
 		}		
		
		return goodsShelfStockCount;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected GoodsShelfStockCount saveShelf(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goodsShelfStockCount.getShelf() == null){
 			return goodsShelfStockCount;//do nothing when it is null
 		}
 		
 		getGoodsShelfDAO().save(goodsShelfStockCount.getShelf(),options);
 		return goodsShelfStockCount;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected GoodsShelfStockCount saveStockCountIssueTrackList(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){
		SmartList<StockCountIssueTrack> stockCountIssueTrackList = goodsShelfStockCount.getStockCountIssueTrackList();
		if(stockCountIssueTrackList == null){
			return goodsShelfStockCount;
		}
		if(stockCountIssueTrackList.isEmpty()){
			return goodsShelfStockCount;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getStockCountIssueTrackDAO().saveStockCountIssueTrackList(stockCountIssueTrackList,options);
		
		return goodsShelfStockCount;
	
	}
	
	protected GoodsShelfStockCount removeStockCountIssueTrackList(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){
	
	
		SmartList<StockCountIssueTrack> stockCountIssueTrackList = goodsShelfStockCount.getStockCountIssueTrackList();
		if(stockCountIssueTrackList == null){
			return goodsShelfStockCount;
		}	
	
		SmartList<StockCountIssueTrack> toRemoveStockCountIssueTrackList = stockCountIssueTrackList.getToRemoveList();
		
		if(toRemoveStockCountIssueTrackList == null){
			return goodsShelfStockCount;
		}
		if(toRemoveStockCountIssueTrackList.isEmpty()){
			return goodsShelfStockCount;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getStockCountIssueTrackDAO().removeStockCountIssueTrackList(toRemoveStockCountIssueTrackList,options);
		
		return goodsShelfStockCount;
	
	}
	
	
	
 	
 	
	
	
	
		

	public GoodsShelfStockCount present(GoodsShelfStockCount goodsShelfStockCount,Map<String, Object> options){
	
		presentStockCountIssueTrackList(goodsShelfStockCount,options);

		return goodsShelfStockCount;
	
	}
		
	
  	
 	protected GoodsShelfStockCount presentStockCountIssueTrackList(
			GoodsShelfStockCount goodsShelfStockCount,
			Map<String, Object> options) {

		SmartList<StockCountIssueTrack> stockCountIssueTrackList = goodsShelfStockCount.getStockCountIssueTrackList();		
		if(stockCountIssueTrackList == null){
			return goodsShelfStockCount;			
		}
		
		String targetObjectName = "stockCountIssueTrack";
		int stockCountIssueTrackListSize = stockCountIssueTrackList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(stockCountIssueTrackListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return goodsShelfStockCount;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = stockCountIssueTrackListSize;
		if(stockCountIssueTrackListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getStockCountIssueTrackDAO().countStockCountIssueTrackByStockCount(goodsShelfStockCount.getId(), options);			
		}
		//goodsShelfStockCount.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//goodsShelfStockCount.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(stockCountIssueTrackListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(stockCountIssueTrackListSize,currentPage,rowsPerPage) ;
			stockCountIssueTrackList = stockCountIssueTrackList.subListOf(fromIndex, toIndex);
			stockCountIssueTrackList.setTotalCount(count);
			stockCountIssueTrackList.setCurrentPageNumber(currentPage);			
			goodsShelfStockCount.setStockCountIssueTrackList(stockCountIssueTrackList);
			return goodsShelfStockCount;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		stockCountIssueTrackList 
			= getStockCountIssueTrackDAO().findStockCountIssueTrackByStockCount(goodsShelfStockCount.getId(),start, rowsPerPage, options );
		stockCountIssueTrackList.setTotalCount(count);
		stockCountIssueTrackList.setCurrentPageNumber(currentPage);
		goodsShelfStockCount.setStockCountIssueTrackList(stockCountIssueTrackList );	

		return goodsShelfStockCount;
	}			
		


	protected String getTableName(){
		return GoodsShelfStockCountTable.TABLE_NAME;
	}
}


