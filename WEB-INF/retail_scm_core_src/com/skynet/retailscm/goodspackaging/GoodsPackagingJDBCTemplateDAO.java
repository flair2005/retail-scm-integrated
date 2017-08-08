
package com.skynet.retailscm.goodspackaging;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.goods.Goods;

import com.skynet.retailscm.goods.GoodsDAO;

import com.skynet.retailscm.goods.GoodsTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class GoodsPackagingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements GoodsPackagingDAO{

		
	
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
	protected GoodsPackaging load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsPackaging(accessKey, options);
	}
	*/
	public GoodsPackaging load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsPackaging(GoodsPackagingTable.withId(id), options);
	}
	
	
	
	public GoodsPackaging save(GoodsPackaging goodsPackaging,Map<String,Object> options){
		
		String methodName="save(GoodsPackaging goodsPackaging,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(goodsPackaging, methodName, "goodsPackaging");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGoodsPackaging(goodsPackaging,options);
	}
	public GoodsPackaging clone(String goodsPackagingId, Map<String,Object> options) throws Exception{
	
		return clone(GoodsPackagingTable.withId(goodsPackagingId),options);
	}
	
	protected GoodsPackaging clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String goodsPackagingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		GoodsPackaging newGoodsPackaging = loadInternalGoodsPackaging(accessKey, options);
		newGoodsPackaging.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newGoodsPackaging.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalGoodsPackaging(newGoodsPackaging,options);
		
		return newGoodsPackaging;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String goodsPackagingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{goodsPackagingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new GoodsPackagingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsPackagingNotFoundException(
					"The " + this.getTableName() + "(" + goodsPackagingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String goodsPackagingId, int version) throws Exception{
	
		String methodName="delete(String goodsPackagingId, int version)";
		assertMethodArgumentNotNull(goodsPackagingId, methodName, "goodsPackagingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsPackagingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsPackagingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"package_name","rfid","package_time","description"};
		return GoodsPackagingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "goods_packaging";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsPackagingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsPackagingTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsPackagingTokens.GOODS_LIST);
		
 	}
 	
 	
			
		

	

	protected GoodsPackagingMapper getGoodsPackagingMapper(){
		return new GoodsPackagingMapper();
	}
	protected GoodsPackaging extractGoodsPackaging(String goodsPackagingId) throws Exception{
		String SQL = "select * from goods_packaging_data where id = ?";	
		try{
		
			GoodsPackaging goodsPackaging = queryForObject(SQL, new Object[]{goodsPackagingId}, getGoodsPackagingMapper());
			return goodsPackaging;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsPackagingNotFoundException("GoodsPackaging("+goodsPackagingId+") is not found!");
		}
		
		
	}
	protected GoodsPackaging extractGoodsPackaging(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from goods_packaging_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			GoodsPackaging goodsPackaging = queryForObject(SQL, new Object[]{accessKey.getValue()}, getGoodsPackagingMapper());
			return goodsPackaging;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsPackagingNotFoundException("GoodsPackaging("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected GoodsPackaging loadInternalGoodsPackaging(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GoodsPackaging goodsPackaging = extractGoodsPackaging(accessKey, loadOptions);

		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(goodsPackaging, loadOptions);
 		}		
		
		return goodsPackaging;
		
	}



	
	
	
		
	protected GoodsPackaging extractGoodsList(GoodsPackaging goodsPackaging, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByPackaging(goodsPackaging.getId(),options);
		if(goodsList != null){
			goodsPackaging.setGoodsList(goodsList);
		}
		
		return goodsPackaging;
	
	}	
		
		
 	
		
		
		

	

	protected GoodsPackaging saveGoodsPackaging(GoodsPackaging  goodsPackaging){
	
		String SQL=this.getSaveGoodsPackagingSQL(goodsPackaging);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsPackagingParameters(goodsPackaging);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		goodsPackaging.incVersion();
		return goodsPackaging;
	
	}
	public SmartList<GoodsPackaging> saveGoodsPackagingList(SmartList<GoodsPackaging> goodsPackagingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsPackagingList(goodsPackagingList);
		
		batchGoodsPackagingCreate((List<GoodsPackaging>)lists[CREATE_LIST_INDEX]);
		
		batchGoodsPackagingUpdate((List<GoodsPackaging>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(GoodsPackaging goodsPackaging:goodsPackagingList){
			if(goodsPackaging.isChanged()){
				goodsPackaging.incVersion();
			}
			
		
		}
		
		
		return goodsPackagingList;
	}

	public SmartList<GoodsPackaging> removeGoodsPackagingList(SmartList<GoodsPackaging> goodsPackagingList,Map<String,Object> options){
		
		
		super.removeList(goodsPackagingList, options);
		
		return goodsPackagingList;
		
		
	}
	
	protected List<Object[]> prepareGoodsPackagingBatchCreateArgs(List<GoodsPackaging> goodsPackagingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsPackaging goodsPackaging:goodsPackagingList ){
			Object [] parameters = prepareGoodsPackagingCreateParameters(goodsPackaging);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGoodsPackagingBatchUpdateArgs(List<GoodsPackaging> goodsPackagingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsPackaging goodsPackaging:goodsPackagingList ){
			if(!goodsPackaging.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsPackagingUpdateParameters(goodsPackaging);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGoodsPackagingCreate(List<GoodsPackaging> goodsPackagingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsPackagingBatchCreateArgs(goodsPackagingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGoodsPackagingUpdate(List<GoodsPackaging> goodsPackagingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsPackagingBatchUpdateArgs(goodsPackagingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGoodsPackagingList(List<GoodsPackaging> goodsPackagingList){
		
		List<GoodsPackaging> goodsPackagingCreateList=new ArrayList<GoodsPackaging>();
		List<GoodsPackaging> goodsPackagingUpdateList=new ArrayList<GoodsPackaging>();
		
		for(GoodsPackaging goodsPackaging: goodsPackagingList){
			if(isUpdateRequest(goodsPackaging)){
				goodsPackagingUpdateList.add( goodsPackaging);
				continue;
			}
			goodsPackagingCreateList.add(goodsPackaging);
		}
		
		return new Object[]{goodsPackagingCreateList,goodsPackagingUpdateList};
	}
	
	protected boolean isUpdateRequest(GoodsPackaging goodsPackaging){
 		return goodsPackaging.getVersion() > 0;
 	}
 	protected String getSaveGoodsPackagingSQL(GoodsPackaging goodsPackaging){
 		if(isUpdateRequest(goodsPackaging)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGoodsPackagingParameters(GoodsPackaging goodsPackaging){
 		if(isUpdateRequest(goodsPackaging) ){
 			return prepareGoodsPackagingUpdateParameters(goodsPackaging);
 		}
 		return prepareGoodsPackagingCreateParameters(goodsPackaging);
 	}
 	protected Object[] prepareGoodsPackagingUpdateParameters(GoodsPackaging goodsPackaging){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = goodsPackaging.getPackageName();
 		parameters[1] = goodsPackaging.getRfid();
 		parameters[2] = goodsPackaging.getPackageTime();
 		parameters[3] = goodsPackaging.getDescription();		
 		parameters[4] = goodsPackaging.getId();
 		parameters[5] = goodsPackaging.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGoodsPackagingCreateParameters(GoodsPackaging goodsPackaging){
		Object[] parameters = new Object[5];
		String newGoodsPackagingId=getNextId();
		goodsPackaging.setId(newGoodsPackagingId);
		parameters[0] =  goodsPackaging.getId();
 
 		parameters[1] = goodsPackaging.getPackageName();
 		parameters[2] = goodsPackaging.getRfid();
 		parameters[3] = goodsPackaging.getPackageTime();
 		parameters[4] = goodsPackaging.getDescription();		
 				
 		return parameters;
 	}
 	
	protected GoodsPackaging saveInternalGoodsPackaging(GoodsPackaging goodsPackaging, Map<String,Object> options){
		
		saveGoodsPackaging(goodsPackaging);

		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(goodsPackaging, options);
	 		removeGoodsList(goodsPackaging, options);
	 		
 		}		
		
		return goodsPackaging;
		
	}
	
	
	
	//======================================================================================
	
		
	protected GoodsPackaging saveGoodsList(GoodsPackaging goodsPackaging, Map<String,Object> options){
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();
		if(goodsList == null){
			return goodsPackaging;
		}
		if(goodsList.isEmpty()){
			return goodsPackaging;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return goodsPackaging;
	
	}
	
	protected GoodsPackaging removeGoodsList(GoodsPackaging goodsPackaging, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();
		if(goodsList == null){
			return goodsPackaging;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return goodsPackaging;
		}
		if(toRemoveGoodsList.isEmpty()){
			return goodsPackaging;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return goodsPackaging;
	
	}
	
	
	
 	
 	
	
	
	
		

	public GoodsPackaging present(GoodsPackaging goodsPackaging,Map<String, Object> options){
	
		presentGoodsList(goodsPackaging,options);

		return goodsPackaging;
	
	}
		
	
  	
 	protected GoodsPackaging presentGoodsList(
			GoodsPackaging goodsPackaging,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		if(goodsList == null){
			return goodsPackaging;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return goodsPackaging;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsByPackaging(goodsPackaging.getId(), options);			
		}
		//goodsPackaging.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//goodsPackaging.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			goodsPackaging.setGoodsList(goodsList);
			return goodsPackaging;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsByPackaging(goodsPackaging.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		goodsPackaging.setGoodsList(goodsList );	

		return goodsPackaging;
	}			
		


	protected String getTableName(){
		return GoodsPackagingTable.TABLE_NAME;
	}
}


