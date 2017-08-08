
package com.skynet.retailscm.retailstoreorderprocessing;

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

public class RetailStoreOrderProcessingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderProcessingDAO{

		
	
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
	protected RetailStoreOrderProcessing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderProcessing(accessKey, options);
	}
	*/
	public RetailStoreOrderProcessing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderProcessing(RetailStoreOrderProcessingTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderProcessing save(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderProcessing, methodName, "retailStoreOrderProcessing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderProcessing(retailStoreOrderProcessing,options);
	}
	public RetailStoreOrderProcessing clone(String retailStoreOrderProcessingId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderProcessingTable.withId(retailStoreOrderProcessingId),options);
	}
	
	protected RetailStoreOrderProcessing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderProcessingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderProcessing newRetailStoreOrderProcessing = loadInternalRetailStoreOrderProcessing(accessKey, options);
		newRetailStoreOrderProcessing.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderProcessing.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderProcessing(newRetailStoreOrderProcessing,options);
		
		return newRetailStoreOrderProcessing;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderProcessingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderProcessingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderProcessingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderProcessingNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderProcessingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderProcessingId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderProcessingId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderProcessingId, methodName, "retailStoreOrderProcessingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderProcessingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderProcessingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","process_time"};
		return RetailStoreOrderProcessingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_processing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderProcessingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderProcessingTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderProcessingTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderProcessingMapper getRetailStoreOrderProcessingMapper(){
		return new RetailStoreOrderProcessingMapper();
	}
	protected RetailStoreOrderProcessing extractRetailStoreOrderProcessing(String retailStoreOrderProcessingId) throws Exception{
		String SQL = "select * from retail_store_order_processing_data where id = ?";	
		try{
		
			RetailStoreOrderProcessing retailStoreOrderProcessing = queryForObject(SQL, new Object[]{retailStoreOrderProcessingId}, getRetailStoreOrderProcessingMapper());
			return retailStoreOrderProcessing;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderProcessingNotFoundException("RetailStoreOrderProcessing("+retailStoreOrderProcessingId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrderProcessing extractRetailStoreOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_processing_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrderProcessing retailStoreOrderProcessing = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderProcessingMapper());
			return retailStoreOrderProcessing;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderProcessingNotFoundException("RetailStoreOrderProcessing("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrderProcessing loadInternalRetailStoreOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = extractRetailStoreOrderProcessing(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderProcessing, loadOptions);
 		}		
		
		return retailStoreOrderProcessing;
		
	}



	
	
	
		
	protected RetailStoreOrderProcessing extractRetailStoreOrderList(RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object> options){
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByProcessing(retailStoreOrderProcessing.getId(),options);
		if(retailStoreOrderList != null){
			retailStoreOrderProcessing.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderProcessing;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderProcessing saveRetailStoreOrderProcessing(RetailStoreOrderProcessing  retailStoreOrderProcessing){
	
		String SQL=this.getSaveRetailStoreOrderProcessingSQL(retailStoreOrderProcessing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderProcessingParameters(retailStoreOrderProcessing);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderProcessing.incVersion();
		return retailStoreOrderProcessing;
	
	}
	public SmartList<RetailStoreOrderProcessing> saveRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderProcessingList(retailStoreOrderProcessingList);
		
		batchRetailStoreOrderProcessingCreate((List<RetailStoreOrderProcessing>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderProcessingUpdate((List<RetailStoreOrderProcessing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderProcessing retailStoreOrderProcessing:retailStoreOrderProcessingList){
			if(retailStoreOrderProcessing.isChanged()){
				retailStoreOrderProcessing.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderProcessingList;
	}

	public SmartList<RetailStoreOrderProcessing> removeRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderProcessingList, options);
		
		return retailStoreOrderProcessingList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderProcessingBatchCreateArgs(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderProcessing retailStoreOrderProcessing:retailStoreOrderProcessingList ){
			Object [] parameters = prepareRetailStoreOrderProcessingCreateParameters(retailStoreOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderProcessingBatchUpdateArgs(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderProcessing retailStoreOrderProcessing:retailStoreOrderProcessingList ){
			if(!retailStoreOrderProcessing.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderProcessingUpdateParameters(retailStoreOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderProcessingCreate(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderProcessingBatchCreateArgs(retailStoreOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderProcessingUpdate(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderProcessingBatchUpdateArgs(retailStoreOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderProcessingList(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		
		List<RetailStoreOrderProcessing> retailStoreOrderProcessingCreateList=new ArrayList<RetailStoreOrderProcessing>();
		List<RetailStoreOrderProcessing> retailStoreOrderProcessingUpdateList=new ArrayList<RetailStoreOrderProcessing>();
		
		for(RetailStoreOrderProcessing retailStoreOrderProcessing: retailStoreOrderProcessingList){
			if(isUpdateRequest(retailStoreOrderProcessing)){
				retailStoreOrderProcessingUpdateList.add( retailStoreOrderProcessing);
				continue;
			}
			retailStoreOrderProcessingCreateList.add(retailStoreOrderProcessing);
		}
		
		return new Object[]{retailStoreOrderProcessingCreateList,retailStoreOrderProcessingUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderProcessing retailStoreOrderProcessing){
 		return retailStoreOrderProcessing.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderProcessingSQL(RetailStoreOrderProcessing retailStoreOrderProcessing){
 		if(isUpdateRequest(retailStoreOrderProcessing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderProcessingParameters(RetailStoreOrderProcessing retailStoreOrderProcessing){
 		if(isUpdateRequest(retailStoreOrderProcessing) ){
 			return prepareRetailStoreOrderProcessingUpdateParameters(retailStoreOrderProcessing);
 		}
 		return prepareRetailStoreOrderProcessingCreateParameters(retailStoreOrderProcessing);
 	}
 	protected Object[] prepareRetailStoreOrderProcessingUpdateParameters(RetailStoreOrderProcessing retailStoreOrderProcessing){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = retailStoreOrderProcessing.getWho();
 		parameters[1] = retailStoreOrderProcessing.getProcessTime();		
 		parameters[2] = retailStoreOrderProcessing.getId();
 		parameters[3] = retailStoreOrderProcessing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderProcessingCreateParameters(RetailStoreOrderProcessing retailStoreOrderProcessing){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderProcessingId=getNextId();
		retailStoreOrderProcessing.setId(newRetailStoreOrderProcessingId);
		parameters[0] =  retailStoreOrderProcessing.getId();
 
 		parameters[1] = retailStoreOrderProcessing.getWho();
 		parameters[2] = retailStoreOrderProcessing.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderProcessing saveInternalRetailStoreOrderProcessing(RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object> options){
		
		saveRetailStoreOrderProcessing(retailStoreOrderProcessing);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderProcessing, options);
	 		removeRetailStoreOrderList(retailStoreOrderProcessing, options);
	 		
 		}		
		
		return retailStoreOrderProcessing;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreOrderProcessing saveRetailStoreOrderList(RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object> options){
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderProcessing;
		}
		if(retailStoreOrderList.isEmpty()){
			return retailStoreOrderProcessing;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderDAO().saveRetailStoreOrderList(retailStoreOrderList,options);
		
		return retailStoreOrderProcessing;
	
	}
	
	protected RetailStoreOrderProcessing removeRetailStoreOrderList(RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderProcessing;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderProcessing;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderProcessing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderProcessing;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreOrderProcessing present(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderProcessing,options);

		return retailStoreOrderProcessing;
	
	}
		
	
  	
 	protected RetailStoreOrderProcessing presentRetailStoreOrderList(
			RetailStoreOrderProcessing retailStoreOrderProcessing,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();		
		if(retailStoreOrderList == null){
			return retailStoreOrderProcessing;			
		}
		
		String targetObjectName = "retailStoreOrder";
		int retailStoreOrderListSize = retailStoreOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrderProcessing;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderListSize;
		if(retailStoreOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderDAO().countRetailStoreOrderByProcessing(retailStoreOrderProcessing.getId(), options);			
		}
		//retailStoreOrderProcessing.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrderProcessing.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderListSize,currentPage,rowsPerPage) ;
			retailStoreOrderList = retailStoreOrderList.subListOf(fromIndex, toIndex);
			retailStoreOrderList.setTotalCount(count);
			retailStoreOrderList.setCurrentPageNumber(currentPage);			
			retailStoreOrderProcessing.setRetailStoreOrderList(retailStoreOrderList);
			return retailStoreOrderProcessing;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderList 
			= getRetailStoreOrderDAO().findRetailStoreOrderByProcessing(retailStoreOrderProcessing.getId(),start, rowsPerPage, options );
		retailStoreOrderList.setTotalCount(count);
		retailStoreOrderList.setCurrentPageNumber(currentPage);
		retailStoreOrderProcessing.setRetailStoreOrderList(retailStoreOrderList );	

		return retailStoreOrderProcessing;
	}			
		


	protected String getTableName(){
		return RetailStoreOrderProcessingTable.TABLE_NAME;
	}
}


