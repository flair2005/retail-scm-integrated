
package com.skynet.retailscm.retailstoreorderapproval;

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

public class RetailStoreOrderApprovalJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderApprovalDAO{

		
	
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
	protected RetailStoreOrderApproval load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderApproval(accessKey, options);
	}
	*/
	public RetailStoreOrderApproval load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderApproval(RetailStoreOrderApprovalTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderApproval save(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderApproval, methodName, "retailStoreOrderApproval");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderApproval(retailStoreOrderApproval,options);
	}
	public RetailStoreOrderApproval clone(String retailStoreOrderApprovalId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderApprovalTable.withId(retailStoreOrderApprovalId),options);
	}
	
	protected RetailStoreOrderApproval clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderApprovalId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderApproval newRetailStoreOrderApproval = loadInternalRetailStoreOrderApproval(accessKey, options);
		newRetailStoreOrderApproval.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderApproval.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderApproval(newRetailStoreOrderApproval,options);
		
		return newRetailStoreOrderApproval;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderApprovalId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderApprovalId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderApprovalVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderApprovalNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderApprovalId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderApprovalId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderApprovalId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderApprovalId, methodName, "retailStoreOrderApprovalId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderApprovalId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderApprovalId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","approve_time"};
		return RetailStoreOrderApprovalTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_approval";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderApprovalTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderApprovalTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderApprovalTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderApprovalMapper getRetailStoreOrderApprovalMapper(){
		return new RetailStoreOrderApprovalMapper();
	}
	protected RetailStoreOrderApproval extractRetailStoreOrderApproval(String retailStoreOrderApprovalId) throws Exception{
		String SQL = "select * from retail_store_order_approval_data where id = ?";	
		try{
		
			RetailStoreOrderApproval retailStoreOrderApproval = queryForObject(SQL, new Object[]{retailStoreOrderApprovalId}, getRetailStoreOrderApprovalMapper());
			return retailStoreOrderApproval;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderApprovalNotFoundException("RetailStoreOrderApproval("+retailStoreOrderApprovalId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrderApproval extractRetailStoreOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_approval_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrderApproval retailStoreOrderApproval = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderApprovalMapper());
			return retailStoreOrderApproval;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderApprovalNotFoundException("RetailStoreOrderApproval("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrderApproval loadInternalRetailStoreOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderApproval retailStoreOrderApproval = extractRetailStoreOrderApproval(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderApproval, loadOptions);
 		}		
		
		return retailStoreOrderApproval;
		
	}



	
	
	
		
	protected RetailStoreOrderApproval extractRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options){
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByApproval(retailStoreOrderApproval.getId(),options);
		if(retailStoreOrderList != null){
			retailStoreOrderApproval.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderApproval;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderApproval saveRetailStoreOrderApproval(RetailStoreOrderApproval  retailStoreOrderApproval){
	
		String SQL=this.getSaveRetailStoreOrderApprovalSQL(retailStoreOrderApproval);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderApprovalParameters(retailStoreOrderApproval);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderApproval.incVersion();
		return retailStoreOrderApproval;
	
	}
	public SmartList<RetailStoreOrderApproval> saveRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderApprovalList(retailStoreOrderApprovalList);
		
		batchRetailStoreOrderApprovalCreate((List<RetailStoreOrderApproval>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderApprovalUpdate((List<RetailStoreOrderApproval>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderApproval retailStoreOrderApproval:retailStoreOrderApprovalList){
			if(retailStoreOrderApproval.isChanged()){
				retailStoreOrderApproval.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderApprovalList;
	}

	public SmartList<RetailStoreOrderApproval> removeRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderApprovalList, options);
		
		return retailStoreOrderApprovalList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderApprovalBatchCreateArgs(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderApproval retailStoreOrderApproval:retailStoreOrderApprovalList ){
			Object [] parameters = prepareRetailStoreOrderApprovalCreateParameters(retailStoreOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderApprovalBatchUpdateArgs(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderApproval retailStoreOrderApproval:retailStoreOrderApprovalList ){
			if(!retailStoreOrderApproval.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderApprovalUpdateParameters(retailStoreOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderApprovalCreate(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderApprovalBatchCreateArgs(retailStoreOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderApprovalUpdate(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderApprovalBatchUpdateArgs(retailStoreOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderApprovalList(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		
		List<RetailStoreOrderApproval> retailStoreOrderApprovalCreateList=new ArrayList<RetailStoreOrderApproval>();
		List<RetailStoreOrderApproval> retailStoreOrderApprovalUpdateList=new ArrayList<RetailStoreOrderApproval>();
		
		for(RetailStoreOrderApproval retailStoreOrderApproval: retailStoreOrderApprovalList){
			if(isUpdateRequest(retailStoreOrderApproval)){
				retailStoreOrderApprovalUpdateList.add( retailStoreOrderApproval);
				continue;
			}
			retailStoreOrderApprovalCreateList.add(retailStoreOrderApproval);
		}
		
		return new Object[]{retailStoreOrderApprovalCreateList,retailStoreOrderApprovalUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderApproval retailStoreOrderApproval){
 		return retailStoreOrderApproval.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderApprovalSQL(RetailStoreOrderApproval retailStoreOrderApproval){
 		if(isUpdateRequest(retailStoreOrderApproval)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderApprovalParameters(RetailStoreOrderApproval retailStoreOrderApproval){
 		if(isUpdateRequest(retailStoreOrderApproval) ){
 			return prepareRetailStoreOrderApprovalUpdateParameters(retailStoreOrderApproval);
 		}
 		return prepareRetailStoreOrderApprovalCreateParameters(retailStoreOrderApproval);
 	}
 	protected Object[] prepareRetailStoreOrderApprovalUpdateParameters(RetailStoreOrderApproval retailStoreOrderApproval){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = retailStoreOrderApproval.getWho();
 		parameters[1] = retailStoreOrderApproval.getApproveTime();		
 		parameters[2] = retailStoreOrderApproval.getId();
 		parameters[3] = retailStoreOrderApproval.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderApprovalCreateParameters(RetailStoreOrderApproval retailStoreOrderApproval){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderApprovalId=getNextId();
		retailStoreOrderApproval.setId(newRetailStoreOrderApprovalId);
		parameters[0] =  retailStoreOrderApproval.getId();
 
 		parameters[1] = retailStoreOrderApproval.getWho();
 		parameters[2] = retailStoreOrderApproval.getApproveTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderApproval saveInternalRetailStoreOrderApproval(RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options){
		
		saveRetailStoreOrderApproval(retailStoreOrderApproval);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderApproval, options);
	 		removeRetailStoreOrderList(retailStoreOrderApproval, options);
	 		
 		}		
		
		return retailStoreOrderApproval;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreOrderApproval saveRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options){
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderApproval;
		}
		if(retailStoreOrderList.isEmpty()){
			return retailStoreOrderApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderDAO().saveRetailStoreOrderList(retailStoreOrderList,options);
		
		return retailStoreOrderApproval;
	
	}
	
	protected RetailStoreOrderApproval removeRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderApproval;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderApproval;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderApproval;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreOrderApproval present(RetailStoreOrderApproval retailStoreOrderApproval,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderApproval,options);

		return retailStoreOrderApproval;
	
	}
		
	
  	
 	protected RetailStoreOrderApproval presentRetailStoreOrderList(
			RetailStoreOrderApproval retailStoreOrderApproval,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();		
		if(retailStoreOrderList == null){
			return retailStoreOrderApproval;			
		}
		
		String targetObjectName = "retailStoreOrder";
		int retailStoreOrderListSize = retailStoreOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrderApproval;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderListSize;
		if(retailStoreOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderDAO().countRetailStoreOrderByApproval(retailStoreOrderApproval.getId(), options);			
		}
		//retailStoreOrderApproval.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrderApproval.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderListSize,currentPage,rowsPerPage) ;
			retailStoreOrderList = retailStoreOrderList.subListOf(fromIndex, toIndex);
			retailStoreOrderList.setTotalCount(count);
			retailStoreOrderList.setCurrentPageNumber(currentPage);			
			retailStoreOrderApproval.setRetailStoreOrderList(retailStoreOrderList);
			return retailStoreOrderApproval;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderList 
			= getRetailStoreOrderDAO().findRetailStoreOrderByApproval(retailStoreOrderApproval.getId(),start, rowsPerPage, options );
		retailStoreOrderList.setTotalCount(count);
		retailStoreOrderList.setCurrentPageNumber(currentPage);
		retailStoreOrderApproval.setRetailStoreOrderList(retailStoreOrderList );	

		return retailStoreOrderApproval;
	}			
		


	protected String getTableName(){
		return RetailStoreOrderApprovalTable.TABLE_NAME;
	}
}


