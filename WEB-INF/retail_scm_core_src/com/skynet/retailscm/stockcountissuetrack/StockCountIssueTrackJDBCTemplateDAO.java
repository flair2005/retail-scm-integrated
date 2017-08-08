
package com.skynet.retailscm.stockcountissuetrack;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCountDAO;

import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCountTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class StockCountIssueTrackJDBCTemplateDAO extends CommonJDBCTemplateDAO implements StockCountIssueTrackDAO{
 
 	
 	private  GoodsShelfStockCountDAO  goodsShelfStockCountDAO;
 	public void setGoodsShelfStockCountDAO(GoodsShelfStockCountDAO goodsShelfStockCountDAO){
	 	this.goodsShelfStockCountDAO = goodsShelfStockCountDAO;
 	}
 	public GoodsShelfStockCountDAO getGoodsShelfStockCountDAO(){
	 	return this.goodsShelfStockCountDAO;
 	}

		

	
	/*
	protected StockCountIssueTrack load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalStockCountIssueTrack(accessKey, options);
	}
	*/
	public StockCountIssueTrack load(String id,Map<String,Object> options) throws Exception{
		return loadInternalStockCountIssueTrack(StockCountIssueTrackTable.withId(id), options);
	}
	
	
	
	public StockCountIssueTrack save(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options){
		
		String methodName="save(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(stockCountIssueTrack, methodName, "stockCountIssueTrack");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalStockCountIssueTrack(stockCountIssueTrack,options);
	}
	public StockCountIssueTrack clone(String stockCountIssueTrackId, Map<String,Object> options) throws Exception{
	
		return clone(StockCountIssueTrackTable.withId(stockCountIssueTrackId),options);
	}
	
	protected StockCountIssueTrack clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String stockCountIssueTrackId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		StockCountIssueTrack newStockCountIssueTrack = loadInternalStockCountIssueTrack(accessKey, options);
		newStockCountIssueTrack.setVersion(0);
		
		

		
		saveInternalStockCountIssueTrack(newStockCountIssueTrack,options);
		
		return newStockCountIssueTrack;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String stockCountIssueTrackId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{stockCountIssueTrackId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new StockCountIssueTrackVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new StockCountIssueTrackNotFoundException(
					"The " + this.getTableName() + "(" + stockCountIssueTrackId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String stockCountIssueTrackId, int version) throws Exception{
	
		String methodName="delete(String stockCountIssueTrackId, int version)";
		assertMethodArgumentNotNull(stockCountIssueTrackId, methodName, "stockCountIssueTrackId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{stockCountIssueTrackId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(stockCountIssueTrackId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"title","count_time","summary","stock_count"};
		return StockCountIssueTrackTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "stock_count_issue_track";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return StockCountIssueTrackTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractStockCountEnabled = true;
 	//private static final String STOCKCOUNT = "stockCount";
 	protected boolean isExtractStockCountEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, StockCountIssueTrackTokens.STOCKCOUNT);
 	}
 	
 	
 	//private boolean saveStockCountEnabled = true;
 	protected boolean isSaveStockCountEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, StockCountIssueTrackTokens.STOCKCOUNT);
 	}
 	

 	
 
		

	

	protected StockCountIssueTrackMapper getStockCountIssueTrackMapper(){
		return new StockCountIssueTrackMapper();
	}
	protected StockCountIssueTrack extractStockCountIssueTrack(String stockCountIssueTrackId) throws Exception{
		String SQL = "select * from stock_count_issue_track_data where id = ?";	
		try{
		
			StockCountIssueTrack stockCountIssueTrack = queryForObject(SQL, new Object[]{stockCountIssueTrackId}, getStockCountIssueTrackMapper());
			return stockCountIssueTrack;
		}catch(EmptyResultDataAccessException e){
			throw new StockCountIssueTrackNotFoundException("StockCountIssueTrack("+stockCountIssueTrackId+") is not found!");
		}
		
		
	}
	protected StockCountIssueTrack extractStockCountIssueTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from stock_count_issue_track_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			StockCountIssueTrack stockCountIssueTrack = queryForObject(SQL, new Object[]{accessKey.getValue()}, getStockCountIssueTrackMapper());
			return stockCountIssueTrack;
		}catch(EmptyResultDataAccessException e){
			throw new StockCountIssueTrackNotFoundException("StockCountIssueTrack("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected StockCountIssueTrack loadInternalStockCountIssueTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		StockCountIssueTrack stockCountIssueTrack = extractStockCountIssueTrack(accessKey, loadOptions);
 	
 		if(isExtractStockCountEnabled(loadOptions)){
	 		extractStockCount(stockCountIssueTrack, loadOptions);
 		}
 
		
		return stockCountIssueTrack;
		
	}



	
	
	 

 	protected StockCountIssueTrack extractStockCount(StockCountIssueTrack stockCountIssueTrack, Map<String,Object> options) throws Exception{

		if(stockCountIssueTrack.getStockCount() == null){
			return stockCountIssueTrack;
		}
		String stockCountId = stockCountIssueTrack.getStockCount().getId();
		if( stockCountId == null){
			return stockCountIssueTrack;
		}
		GoodsShelfStockCount stockCount = getGoodsShelfStockCountDAO().load(stockCountId,options);
		if(stockCount != null){
			stockCountIssueTrack.setStockCount(stockCount);
		}
		
 		
 		return stockCountIssueTrack;
 	}
 		
 
		
		
  	
 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where stock_count = ?";
		SmartList<StockCountIssueTrack> stockCountIssueTrackList = queryForList(SQL, new Object[]{goodsShelfStockCountId}, getStockCountIssueTrackMapper());	
 		return stockCountIssueTrackList;
 	}
 	
 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where stock_count = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<StockCountIssueTrack> stockCountIssueTrackList = queryForList(SQL, new Object[]{goodsShelfStockCountId,start, count}, getStockCountIssueTrackMapper());
		
 		return stockCountIssueTrackList;
 	}
 	
 	public int countStockCountIssueTrackByStockCount(String goodsShelfStockCountId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where stock_count = ?";
		Integer count = queryInt(SQL, new Object[]{goodsShelfStockCountId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected StockCountIssueTrack saveStockCountIssueTrack(StockCountIssueTrack  stockCountIssueTrack){
	
		String SQL=this.getSaveStockCountIssueTrackSQL(stockCountIssueTrack);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveStockCountIssueTrackParameters(stockCountIssueTrack);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		stockCountIssueTrack.incVersion();
		return stockCountIssueTrack;
	
	}
	public SmartList<StockCountIssueTrack> saveStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitStockCountIssueTrackList(stockCountIssueTrackList);
		
		batchStockCountIssueTrackCreate((List<StockCountIssueTrack>)lists[CREATE_LIST_INDEX]);
		
		batchStockCountIssueTrackUpdate((List<StockCountIssueTrack>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList){
			if(stockCountIssueTrack.isChanged()){
				stockCountIssueTrack.incVersion();
			}
			
		
		}
		
		
		return stockCountIssueTrackList;
	}

	public SmartList<StockCountIssueTrack> removeStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options){
		
		
		super.removeList(stockCountIssueTrackList, options);
		
		return stockCountIssueTrackList;
		
		
	}
	
	protected List<Object[]> prepareStockCountIssueTrackBatchCreateArgs(List<StockCountIssueTrack> stockCountIssueTrackList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList ){
			Object [] parameters = prepareStockCountIssueTrackCreateParameters(stockCountIssueTrack);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareStockCountIssueTrackBatchUpdateArgs(List<StockCountIssueTrack> stockCountIssueTrackList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList ){
			if(!stockCountIssueTrack.isChanged()){
				continue;
			}
			Object [] parameters = prepareStockCountIssueTrackUpdateParameters(stockCountIssueTrack);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchStockCountIssueTrackCreate(List<StockCountIssueTrack> stockCountIssueTrackList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareStockCountIssueTrackBatchCreateArgs(stockCountIssueTrackList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchStockCountIssueTrackUpdate(List<StockCountIssueTrack> stockCountIssueTrackList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareStockCountIssueTrackBatchUpdateArgs(stockCountIssueTrackList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitStockCountIssueTrackList(List<StockCountIssueTrack> stockCountIssueTrackList){
		
		List<StockCountIssueTrack> stockCountIssueTrackCreateList=new ArrayList<StockCountIssueTrack>();
		List<StockCountIssueTrack> stockCountIssueTrackUpdateList=new ArrayList<StockCountIssueTrack>();
		
		for(StockCountIssueTrack stockCountIssueTrack: stockCountIssueTrackList){
			if(isUpdateRequest(stockCountIssueTrack)){
				stockCountIssueTrackUpdateList.add( stockCountIssueTrack);
				continue;
			}
			stockCountIssueTrackCreateList.add(stockCountIssueTrack);
		}
		
		return new Object[]{stockCountIssueTrackCreateList,stockCountIssueTrackUpdateList};
	}
	
	protected boolean isUpdateRequest(StockCountIssueTrack stockCountIssueTrack){
 		return stockCountIssueTrack.getVersion() > 0;
 	}
 	protected String getSaveStockCountIssueTrackSQL(StockCountIssueTrack stockCountIssueTrack){
 		if(isUpdateRequest(stockCountIssueTrack)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveStockCountIssueTrackParameters(StockCountIssueTrack stockCountIssueTrack){
 		if(isUpdateRequest(stockCountIssueTrack) ){
 			return prepareStockCountIssueTrackUpdateParameters(stockCountIssueTrack);
 		}
 		return prepareStockCountIssueTrackCreateParameters(stockCountIssueTrack);
 	}
 	protected Object[] prepareStockCountIssueTrackUpdateParameters(StockCountIssueTrack stockCountIssueTrack){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = stockCountIssueTrack.getTitle();
 		parameters[1] = stockCountIssueTrack.getCountTime();
 		parameters[2] = stockCountIssueTrack.getSummary(); 	
 		if(stockCountIssueTrack.getStockCount() != null){
 			parameters[3] = stockCountIssueTrack.getStockCount().getId();
 		}
 		
 		parameters[4] = stockCountIssueTrack.getId();
 		parameters[5] = stockCountIssueTrack.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareStockCountIssueTrackCreateParameters(StockCountIssueTrack stockCountIssueTrack){
		Object[] parameters = new Object[5];
		String newStockCountIssueTrackId=getNextId();
		stockCountIssueTrack.setId(newStockCountIssueTrackId);
		parameters[0] =  stockCountIssueTrack.getId();
 
 		parameters[1] = stockCountIssueTrack.getTitle();
 		parameters[2] = stockCountIssueTrack.getCountTime();
 		parameters[3] = stockCountIssueTrack.getSummary(); 	
 		if(stockCountIssueTrack.getStockCount() != null){
 			parameters[4] = stockCountIssueTrack.getStockCount().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected StockCountIssueTrack saveInternalStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack, Map<String,Object> options){
		
		saveStockCountIssueTrack(stockCountIssueTrack);
 	
 		if(isSaveStockCountEnabled(options)){
	 		saveStockCount(stockCountIssueTrack, options);
 		}
 
		
		return stockCountIssueTrack;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected StockCountIssueTrack saveStockCount(StockCountIssueTrack stockCountIssueTrack, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(stockCountIssueTrack.getStockCount() == null){
 			return stockCountIssueTrack;//do nothing when it is null
 		}
 		
 		getGoodsShelfStockCountDAO().save(stockCountIssueTrack.getStockCount(),options);
 		return stockCountIssueTrack;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public StockCountIssueTrack present(StockCountIssueTrack stockCountIssueTrack,Map<String, Object> options){
	

		return stockCountIssueTrack;
	
	}
		


	protected String getTableName(){
		return StockCountIssueTrackTable.TABLE_NAME;
	}
}


