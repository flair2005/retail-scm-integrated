
package com.skynet.retailscm.retailstoreorderpicking;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrderDAO;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrderTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreOrderPickingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderPickingDAO{

		
	
  	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO pRetailStoreOrderDAO){
 	
 		if(pRetailStoreOrderDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
 		}
	 	this.retailStoreOrderDAO = pRetailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
 		if(this.retailStoreOrderDAO == null){
 			throw new IllegalStateException("The retailStoreOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreOrderPicking load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderPicking(accessKey, options);
	}
	*/
	public RetailStoreOrderPicking load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderPicking(RetailStoreOrderPickingTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderPicking save(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderPicking, methodName, "retailStoreOrderPicking");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderPicking(retailStoreOrderPicking,options);
	}
	public RetailStoreOrderPicking clone(String retailStoreOrderPickingId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderPickingTable.withId(retailStoreOrderPickingId),options);
	}
	
	protected RetailStoreOrderPicking clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderPickingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderPicking newRetailStoreOrderPicking = loadInternalRetailStoreOrderPicking(accessKey, options);
		newRetailStoreOrderPicking.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderPicking.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderPicking(newRetailStoreOrderPicking,options);
		
		return newRetailStoreOrderPicking;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderPickingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderPickingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderPickingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderPickingNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderPickingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderPickingId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderPickingId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderPickingId, methodName, "retailStoreOrderPickingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderPickingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderPickingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","process_time"};
		return RetailStoreOrderPickingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_picking";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderPickingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderPickingTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderPickingTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderPickingMapper getRetailStoreOrderPickingMapper(){
		return new RetailStoreOrderPickingMapper();
	}
	protected RetailStoreOrderPicking extractRetailStoreOrderPicking(String retailStoreOrderPickingId) throws Exception{
		String SQL = "select * from retail_store_order_picking_data where id = ?";	
		try{
		
			RetailStoreOrderPicking retailStoreOrderPicking = queryForObject(SQL, new Object[]{retailStoreOrderPickingId}, getRetailStoreOrderPickingMapper());
			return retailStoreOrderPicking;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderPickingNotFoundException("RetailStoreOrderPicking("+retailStoreOrderPickingId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrderPicking extractRetailStoreOrderPicking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_picking_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrderPicking retailStoreOrderPicking = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderPickingMapper());
			return retailStoreOrderPicking;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderPickingNotFoundException("RetailStoreOrderPicking("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrderPicking loadInternalRetailStoreOrderPicking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderPicking retailStoreOrderPicking = extractRetailStoreOrderPicking(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderPicking, loadOptions);
 		}		
		
		return retailStoreOrderPicking;
		
	}



	
	
	
		
	protected RetailStoreOrderPicking extractRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options){
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByPicking(retailStoreOrderPicking.getId(),options);
		if(retailStoreOrderList != null){
			retailStoreOrderPicking.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderPicking;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderPicking saveRetailStoreOrderPicking(RetailStoreOrderPicking  retailStoreOrderPicking){
	
		String SQL=this.getSaveRetailStoreOrderPickingSQL(retailStoreOrderPicking);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderPickingParameters(retailStoreOrderPicking);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderPicking.incVersion();
		return retailStoreOrderPicking;
	
	}
	public SmartList<RetailStoreOrderPicking> saveRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderPickingList(retailStoreOrderPickingList);
		
		batchRetailStoreOrderPickingCreate((List<RetailStoreOrderPicking>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderPickingUpdate((List<RetailStoreOrderPicking>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderPicking retailStoreOrderPicking:retailStoreOrderPickingList){
			if(retailStoreOrderPicking.isChanged()){
				retailStoreOrderPicking.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderPickingList;
	}

	public SmartList<RetailStoreOrderPicking> removeRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderPickingList, options);
		
		return retailStoreOrderPickingList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderPickingBatchCreateArgs(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderPicking retailStoreOrderPicking:retailStoreOrderPickingList ){
			Object [] parameters = prepareRetailStoreOrderPickingCreateParameters(retailStoreOrderPicking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderPickingBatchUpdateArgs(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderPicking retailStoreOrderPicking:retailStoreOrderPickingList ){
			if(!retailStoreOrderPicking.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderPickingUpdateParameters(retailStoreOrderPicking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderPickingCreate(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderPickingBatchCreateArgs(retailStoreOrderPickingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderPickingUpdate(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderPickingBatchUpdateArgs(retailStoreOrderPickingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderPickingList(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		
		List<RetailStoreOrderPicking> retailStoreOrderPickingCreateList=new ArrayList<RetailStoreOrderPicking>();
		List<RetailStoreOrderPicking> retailStoreOrderPickingUpdateList=new ArrayList<RetailStoreOrderPicking>();
		
		for(RetailStoreOrderPicking retailStoreOrderPicking: retailStoreOrderPickingList){
			if(isUpdateRequest(retailStoreOrderPicking)){
				retailStoreOrderPickingUpdateList.add( retailStoreOrderPicking);
				continue;
			}
			retailStoreOrderPickingCreateList.add(retailStoreOrderPicking);
		}
		
		return new Object[]{retailStoreOrderPickingCreateList,retailStoreOrderPickingUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderPicking retailStoreOrderPicking){
 		return retailStoreOrderPicking.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderPickingSQL(RetailStoreOrderPicking retailStoreOrderPicking){
 		if(isUpdateRequest(retailStoreOrderPicking)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderPickingParameters(RetailStoreOrderPicking retailStoreOrderPicking){
 		if(isUpdateRequest(retailStoreOrderPicking) ){
 			return prepareRetailStoreOrderPickingUpdateParameters(retailStoreOrderPicking);
 		}
 		return prepareRetailStoreOrderPickingCreateParameters(retailStoreOrderPicking);
 	}
 	protected Object[] prepareRetailStoreOrderPickingUpdateParameters(RetailStoreOrderPicking retailStoreOrderPicking){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = retailStoreOrderPicking.getWho();
 		parameters[1] = retailStoreOrderPicking.getProcessTime();		
 		parameters[2] = retailStoreOrderPicking.getId();
 		parameters[3] = retailStoreOrderPicking.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderPickingCreateParameters(RetailStoreOrderPicking retailStoreOrderPicking){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderPickingId=getNextId();
		retailStoreOrderPicking.setId(newRetailStoreOrderPickingId);
		parameters[0] =  retailStoreOrderPicking.getId();
 
 		parameters[1] = retailStoreOrderPicking.getWho();
 		parameters[2] = retailStoreOrderPicking.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderPicking saveInternalRetailStoreOrderPicking(RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options){
		
		saveRetailStoreOrderPicking(retailStoreOrderPicking);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderPicking, options);
	 		removeRetailStoreOrderList(retailStoreOrderPicking, options);
	 		
 		}		
		
		return retailStoreOrderPicking;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreOrderPicking saveRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options){
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderPicking;
		}
		if(retailStoreOrderList.isEmpty()){
			return retailStoreOrderPicking;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderDAO().saveRetailStoreOrderList(retailStoreOrderList,options);
		
		return retailStoreOrderPicking;
	
	}
	
	protected RetailStoreOrderPicking removeRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderPicking;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderPicking;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderPicking;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderPicking;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreOrderPicking present(RetailStoreOrderPicking retailStoreOrderPicking,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderPicking,options);

		return retailStoreOrderPicking;
	
	}
		
	
  	
 	protected RetailStoreOrderPicking presentRetailStoreOrderList(
			RetailStoreOrderPicking retailStoreOrderPicking,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();		
		if(retailStoreOrderList == null){
			return retailStoreOrderPicking;			
		}
		
		String targetObjectName = "retailStoreOrder";
		int retailStoreOrderListSize = retailStoreOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrderPicking;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderListSize;
		if(retailStoreOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderDAO().countRetailStoreOrderByPicking(retailStoreOrderPicking.getId(), options);			
		}
		//retailStoreOrderPicking.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrderPicking.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderListSize,currentPage,rowsPerPage) ;
			retailStoreOrderList = retailStoreOrderList.subListOf(fromIndex, toIndex);
			retailStoreOrderList.setTotalCount(count);
			retailStoreOrderList.setCurrentPageNumber(currentPage);			
			retailStoreOrderPicking.setRetailStoreOrderList(retailStoreOrderList);
			return retailStoreOrderPicking;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderList 
			= getRetailStoreOrderDAO().findRetailStoreOrderByPicking(retailStoreOrderPicking.getId(),start, rowsPerPage, options );
		retailStoreOrderList.setTotalCount(count);
		retailStoreOrderList.setCurrentPageNumber(currentPage);
		retailStoreOrderPicking.setRetailStoreOrderList(retailStoreOrderList );	

		return retailStoreOrderPicking;
	}			
		


	protected String getTableName(){
		return RetailStoreOrderPickingTable.TABLE_NAME;
	}
}


