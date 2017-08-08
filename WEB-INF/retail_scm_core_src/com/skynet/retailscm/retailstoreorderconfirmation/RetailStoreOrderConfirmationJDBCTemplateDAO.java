
package com.skynet.retailscm.retailstoreorderconfirmation;

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

public class RetailStoreOrderConfirmationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderConfirmationDAO{

		
	
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
	protected RetailStoreOrderConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderConfirmation(accessKey, options);
	}
	*/
	public RetailStoreOrderConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderConfirmation(RetailStoreOrderConfirmationTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderConfirmation save(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderConfirmation, methodName, "retailStoreOrderConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderConfirmation(retailStoreOrderConfirmation,options);
	}
	public RetailStoreOrderConfirmation clone(String retailStoreOrderConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderConfirmationTable.withId(retailStoreOrderConfirmationId),options);
	}
	
	protected RetailStoreOrderConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderConfirmation newRetailStoreOrderConfirmation = loadInternalRetailStoreOrderConfirmation(accessKey, options);
		newRetailStoreOrderConfirmation.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderConfirmation.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderConfirmation(newRetailStoreOrderConfirmation,options);
		
		return newRetailStoreOrderConfirmation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderConfirmationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderConfirmationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderConfirmationId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderConfirmationId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderConfirmationId, methodName, "retailStoreOrderConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderConfirmationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderConfirmationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","confirm_time"};
		return RetailStoreOrderConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_confirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderConfirmationTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderConfirmationTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderConfirmationMapper getRetailStoreOrderConfirmationMapper(){
		return new RetailStoreOrderConfirmationMapper();
	}
	protected RetailStoreOrderConfirmation extractRetailStoreOrderConfirmation(String retailStoreOrderConfirmationId) throws Exception{
		String SQL = "select * from retail_store_order_confirmation_data where id = ?";	
		try{
		
			RetailStoreOrderConfirmation retailStoreOrderConfirmation = queryForObject(SQL, new Object[]{retailStoreOrderConfirmationId}, getRetailStoreOrderConfirmationMapper());
			return retailStoreOrderConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderConfirmationNotFoundException("RetailStoreOrderConfirmation("+retailStoreOrderConfirmationId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrderConfirmation extractRetailStoreOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_confirmation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrderConfirmation retailStoreOrderConfirmation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderConfirmationMapper());
			return retailStoreOrderConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderConfirmationNotFoundException("RetailStoreOrderConfirmation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrderConfirmation loadInternalRetailStoreOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderConfirmation retailStoreOrderConfirmation = extractRetailStoreOrderConfirmation(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderConfirmation, loadOptions);
 		}		
		
		return retailStoreOrderConfirmation;
		
	}



	
	
	
		
	protected RetailStoreOrderConfirmation extractRetailStoreOrderList(RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String,Object> options){
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByConfirmation(retailStoreOrderConfirmation.getId(),options);
		if(retailStoreOrderList != null){
			retailStoreOrderConfirmation.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderConfirmation;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderConfirmation saveRetailStoreOrderConfirmation(RetailStoreOrderConfirmation  retailStoreOrderConfirmation){
	
		String SQL=this.getSaveRetailStoreOrderConfirmationSQL(retailStoreOrderConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderConfirmationParameters(retailStoreOrderConfirmation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderConfirmation.incVersion();
		return retailStoreOrderConfirmation;
	
	}
	public SmartList<RetailStoreOrderConfirmation> saveRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderConfirmationList(retailStoreOrderConfirmationList);
		
		batchRetailStoreOrderConfirmationCreate((List<RetailStoreOrderConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderConfirmationUpdate((List<RetailStoreOrderConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderConfirmation retailStoreOrderConfirmation:retailStoreOrderConfirmationList){
			if(retailStoreOrderConfirmation.isChanged()){
				retailStoreOrderConfirmation.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderConfirmationList;
	}

	public SmartList<RetailStoreOrderConfirmation> removeRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderConfirmationList, options);
		
		return retailStoreOrderConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderConfirmationBatchCreateArgs(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderConfirmation retailStoreOrderConfirmation:retailStoreOrderConfirmationList ){
			Object [] parameters = prepareRetailStoreOrderConfirmationCreateParameters(retailStoreOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderConfirmationBatchUpdateArgs(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderConfirmation retailStoreOrderConfirmation:retailStoreOrderConfirmationList ){
			if(!retailStoreOrderConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderConfirmationUpdateParameters(retailStoreOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderConfirmationCreate(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderConfirmationBatchCreateArgs(retailStoreOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderConfirmationUpdate(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderConfirmationBatchUpdateArgs(retailStoreOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderConfirmationList(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		
		List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationCreateList=new ArrayList<RetailStoreOrderConfirmation>();
		List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationUpdateList=new ArrayList<RetailStoreOrderConfirmation>();
		
		for(RetailStoreOrderConfirmation retailStoreOrderConfirmation: retailStoreOrderConfirmationList){
			if(isUpdateRequest(retailStoreOrderConfirmation)){
				retailStoreOrderConfirmationUpdateList.add( retailStoreOrderConfirmation);
				continue;
			}
			retailStoreOrderConfirmationCreateList.add(retailStoreOrderConfirmation);
		}
		
		return new Object[]{retailStoreOrderConfirmationCreateList,retailStoreOrderConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
 		return retailStoreOrderConfirmation.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderConfirmationSQL(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
 		if(isUpdateRequest(retailStoreOrderConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderConfirmationParameters(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
 		if(isUpdateRequest(retailStoreOrderConfirmation) ){
 			return prepareRetailStoreOrderConfirmationUpdateParameters(retailStoreOrderConfirmation);
 		}
 		return prepareRetailStoreOrderConfirmationCreateParameters(retailStoreOrderConfirmation);
 	}
 	protected Object[] prepareRetailStoreOrderConfirmationUpdateParameters(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = retailStoreOrderConfirmation.getWho();
 		parameters[1] = retailStoreOrderConfirmation.getConfirmTime();		
 		parameters[2] = retailStoreOrderConfirmation.getId();
 		parameters[3] = retailStoreOrderConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderConfirmationCreateParameters(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderConfirmationId=getNextId();
		retailStoreOrderConfirmation.setId(newRetailStoreOrderConfirmationId);
		parameters[0] =  retailStoreOrderConfirmation.getId();
 
 		parameters[1] = retailStoreOrderConfirmation.getWho();
 		parameters[2] = retailStoreOrderConfirmation.getConfirmTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderConfirmation saveInternalRetailStoreOrderConfirmation(RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String,Object> options){
		
		saveRetailStoreOrderConfirmation(retailStoreOrderConfirmation);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderConfirmation, options);
	 		removeRetailStoreOrderList(retailStoreOrderConfirmation, options);
	 		
 		}		
		
		return retailStoreOrderConfirmation;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreOrderConfirmation saveRetailStoreOrderList(RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String,Object> options){
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderConfirmation;
		}
		if(retailStoreOrderList.isEmpty()){
			return retailStoreOrderConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderDAO().saveRetailStoreOrderList(retailStoreOrderList,options);
		
		return retailStoreOrderConfirmation;
	
	}
	
	protected RetailStoreOrderConfirmation removeRetailStoreOrderList(RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderConfirmation;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderConfirmation;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderConfirmation;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreOrderConfirmation present(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderConfirmation,options);

		return retailStoreOrderConfirmation;
	
	}
		
	
  	
 	protected RetailStoreOrderConfirmation presentRetailStoreOrderList(
			RetailStoreOrderConfirmation retailStoreOrderConfirmation,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();		
		if(retailStoreOrderList == null){
			return retailStoreOrderConfirmation;			
		}
		
		String targetObjectName = "retailStoreOrder";
		int retailStoreOrderListSize = retailStoreOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrderConfirmation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderListSize;
		if(retailStoreOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderDAO().countRetailStoreOrderByConfirmation(retailStoreOrderConfirmation.getId(), options);			
		}
		//retailStoreOrderConfirmation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrderConfirmation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderListSize,currentPage,rowsPerPage) ;
			retailStoreOrderList = retailStoreOrderList.subListOf(fromIndex, toIndex);
			retailStoreOrderList.setTotalCount(count);
			retailStoreOrderList.setCurrentPageNumber(currentPage);			
			retailStoreOrderConfirmation.setRetailStoreOrderList(retailStoreOrderList);
			return retailStoreOrderConfirmation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderList 
			= getRetailStoreOrderDAO().findRetailStoreOrderByConfirmation(retailStoreOrderConfirmation.getId(),start, rowsPerPage, options );
		retailStoreOrderList.setTotalCount(count);
		retailStoreOrderList.setCurrentPageNumber(currentPage);
		retailStoreOrderConfirmation.setRetailStoreOrderList(retailStoreOrderList );	

		return retailStoreOrderConfirmation;
	}			
		


	protected String getTableName(){
		return RetailStoreOrderConfirmationTable.TABLE_NAME;
	}
}


