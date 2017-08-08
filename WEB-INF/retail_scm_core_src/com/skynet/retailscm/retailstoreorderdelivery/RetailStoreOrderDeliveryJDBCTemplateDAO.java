
package com.skynet.retailscm.retailstoreorderdelivery;

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

public class RetailStoreOrderDeliveryJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderDeliveryDAO{

		
	
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
	protected RetailStoreOrderDelivery load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderDelivery(accessKey, options);
	}
	*/
	public RetailStoreOrderDelivery load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderDelivery(RetailStoreOrderDeliveryTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderDelivery save(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderDelivery, methodName, "retailStoreOrderDelivery");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderDelivery(retailStoreOrderDelivery,options);
	}
	public RetailStoreOrderDelivery clone(String retailStoreOrderDeliveryId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderDeliveryTable.withId(retailStoreOrderDeliveryId),options);
	}
	
	protected RetailStoreOrderDelivery clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderDeliveryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderDelivery newRetailStoreOrderDelivery = loadInternalRetailStoreOrderDelivery(accessKey, options);
		newRetailStoreOrderDelivery.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderDelivery.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderDelivery(newRetailStoreOrderDelivery,options);
		
		return newRetailStoreOrderDelivery;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderDeliveryId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderDeliveryId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderDeliveryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderDeliveryNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderDeliveryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderDeliveryId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderDeliveryId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderDeliveryId, methodName, "retailStoreOrderDeliveryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderDeliveryId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderDeliveryId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","delivery_time"};
		return RetailStoreOrderDeliveryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_delivery";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderDeliveryTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderDeliveryTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderDeliveryTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderDeliveryMapper getRetailStoreOrderDeliveryMapper(){
		return new RetailStoreOrderDeliveryMapper();
	}
	protected RetailStoreOrderDelivery extractRetailStoreOrderDelivery(String retailStoreOrderDeliveryId) throws Exception{
		String SQL = "select * from retail_store_order_delivery_data where id = ?";	
		try{
		
			RetailStoreOrderDelivery retailStoreOrderDelivery = queryForObject(SQL, new Object[]{retailStoreOrderDeliveryId}, getRetailStoreOrderDeliveryMapper());
			return retailStoreOrderDelivery;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderDeliveryNotFoundException("RetailStoreOrderDelivery("+retailStoreOrderDeliveryId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrderDelivery extractRetailStoreOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_delivery_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrderDelivery retailStoreOrderDelivery = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderDeliveryMapper());
			return retailStoreOrderDelivery;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderDeliveryNotFoundException("RetailStoreOrderDelivery("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrderDelivery loadInternalRetailStoreOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = extractRetailStoreOrderDelivery(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderDelivery, loadOptions);
 		}		
		
		return retailStoreOrderDelivery;
		
	}



	
	
	
		
	protected RetailStoreOrderDelivery extractRetailStoreOrderList(RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options){
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByDelivery(retailStoreOrderDelivery.getId(),options);
		if(retailStoreOrderList != null){
			retailStoreOrderDelivery.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderDelivery;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderDelivery saveRetailStoreOrderDelivery(RetailStoreOrderDelivery  retailStoreOrderDelivery){
	
		String SQL=this.getSaveRetailStoreOrderDeliverySQL(retailStoreOrderDelivery);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderDeliveryParameters(retailStoreOrderDelivery);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderDelivery.incVersion();
		return retailStoreOrderDelivery;
	
	}
	public SmartList<RetailStoreOrderDelivery> saveRetailStoreOrderDeliveryList(SmartList<RetailStoreOrderDelivery> retailStoreOrderDeliveryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderDeliveryList(retailStoreOrderDeliveryList);
		
		batchRetailStoreOrderDeliveryCreate((List<RetailStoreOrderDelivery>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderDeliveryUpdate((List<RetailStoreOrderDelivery>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderDelivery retailStoreOrderDelivery:retailStoreOrderDeliveryList){
			if(retailStoreOrderDelivery.isChanged()){
				retailStoreOrderDelivery.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderDeliveryList;
	}

	public SmartList<RetailStoreOrderDelivery> removeRetailStoreOrderDeliveryList(SmartList<RetailStoreOrderDelivery> retailStoreOrderDeliveryList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderDeliveryList, options);
		
		return retailStoreOrderDeliveryList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderDeliveryBatchCreateArgs(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderDelivery retailStoreOrderDelivery:retailStoreOrderDeliveryList ){
			Object [] parameters = prepareRetailStoreOrderDeliveryCreateParameters(retailStoreOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderDeliveryBatchUpdateArgs(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderDelivery retailStoreOrderDelivery:retailStoreOrderDeliveryList ){
			if(!retailStoreOrderDelivery.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderDeliveryUpdateParameters(retailStoreOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderDeliveryCreate(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderDeliveryBatchCreateArgs(retailStoreOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderDeliveryUpdate(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderDeliveryBatchUpdateArgs(retailStoreOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderDeliveryList(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		
		List<RetailStoreOrderDelivery> retailStoreOrderDeliveryCreateList=new ArrayList<RetailStoreOrderDelivery>();
		List<RetailStoreOrderDelivery> retailStoreOrderDeliveryUpdateList=new ArrayList<RetailStoreOrderDelivery>();
		
		for(RetailStoreOrderDelivery retailStoreOrderDelivery: retailStoreOrderDeliveryList){
			if(isUpdateRequest(retailStoreOrderDelivery)){
				retailStoreOrderDeliveryUpdateList.add( retailStoreOrderDelivery);
				continue;
			}
			retailStoreOrderDeliveryCreateList.add(retailStoreOrderDelivery);
		}
		
		return new Object[]{retailStoreOrderDeliveryCreateList,retailStoreOrderDeliveryUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderDelivery retailStoreOrderDelivery){
 		return retailStoreOrderDelivery.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderDeliverySQL(RetailStoreOrderDelivery retailStoreOrderDelivery){
 		if(isUpdateRequest(retailStoreOrderDelivery)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderDeliveryParameters(RetailStoreOrderDelivery retailStoreOrderDelivery){
 		if(isUpdateRequest(retailStoreOrderDelivery) ){
 			return prepareRetailStoreOrderDeliveryUpdateParameters(retailStoreOrderDelivery);
 		}
 		return prepareRetailStoreOrderDeliveryCreateParameters(retailStoreOrderDelivery);
 	}
 	protected Object[] prepareRetailStoreOrderDeliveryUpdateParameters(RetailStoreOrderDelivery retailStoreOrderDelivery){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = retailStoreOrderDelivery.getWho();
 		parameters[1] = retailStoreOrderDelivery.getDeliveryTime();		
 		parameters[2] = retailStoreOrderDelivery.getId();
 		parameters[3] = retailStoreOrderDelivery.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderDeliveryCreateParameters(RetailStoreOrderDelivery retailStoreOrderDelivery){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderDeliveryId=getNextId();
		retailStoreOrderDelivery.setId(newRetailStoreOrderDeliveryId);
		parameters[0] =  retailStoreOrderDelivery.getId();
 
 		parameters[1] = retailStoreOrderDelivery.getWho();
 		parameters[2] = retailStoreOrderDelivery.getDeliveryTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderDelivery saveInternalRetailStoreOrderDelivery(RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options){
		
		saveRetailStoreOrderDelivery(retailStoreOrderDelivery);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderDelivery, options);
	 		removeRetailStoreOrderList(retailStoreOrderDelivery, options);
	 		
 		}		
		
		return retailStoreOrderDelivery;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreOrderDelivery saveRetailStoreOrderList(RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options){
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderDelivery;
		}
		if(retailStoreOrderList.isEmpty()){
			return retailStoreOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderDAO().saveRetailStoreOrderList(retailStoreOrderList,options);
		
		return retailStoreOrderDelivery;
	
	}
	
	protected RetailStoreOrderDelivery removeRetailStoreOrderList(RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderDelivery;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderDelivery;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderDelivery;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreOrderDelivery present(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderDelivery,options);

		return retailStoreOrderDelivery;
	
	}
		
	
  	
 	protected RetailStoreOrderDelivery presentRetailStoreOrderList(
			RetailStoreOrderDelivery retailStoreOrderDelivery,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();		
		if(retailStoreOrderList == null){
			return retailStoreOrderDelivery;			
		}
		
		String targetObjectName = "retailStoreOrder";
		int retailStoreOrderListSize = retailStoreOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrderDelivery;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderListSize;
		if(retailStoreOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderDAO().countRetailStoreOrderByDelivery(retailStoreOrderDelivery.getId(), options);			
		}
		//retailStoreOrderDelivery.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrderDelivery.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderListSize,currentPage,rowsPerPage) ;
			retailStoreOrderList = retailStoreOrderList.subListOf(fromIndex, toIndex);
			retailStoreOrderList.setTotalCount(count);
			retailStoreOrderList.setCurrentPageNumber(currentPage);			
			retailStoreOrderDelivery.setRetailStoreOrderList(retailStoreOrderList);
			return retailStoreOrderDelivery;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderList 
			= getRetailStoreOrderDAO().findRetailStoreOrderByDelivery(retailStoreOrderDelivery.getId(),start, rowsPerPage, options );
		retailStoreOrderList.setTotalCount(count);
		retailStoreOrderList.setCurrentPageNumber(currentPage);
		retailStoreOrderDelivery.setRetailStoreOrderList(retailStoreOrderList );	

		return retailStoreOrderDelivery;
	}			
		


	protected String getTableName(){
		return RetailStoreOrderDeliveryTable.TABLE_NAME;
	}
}


