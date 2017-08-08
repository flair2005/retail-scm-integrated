
package com.skynet.retailscm.retailstoreordershipment;

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

public class RetailStoreOrderShipmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderShipmentDAO{

		
	
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
	protected RetailStoreOrderShipment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderShipment(accessKey, options);
	}
	*/
	public RetailStoreOrderShipment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderShipment(RetailStoreOrderShipmentTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderShipment save(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderShipment, methodName, "retailStoreOrderShipment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderShipment(retailStoreOrderShipment,options);
	}
	public RetailStoreOrderShipment clone(String retailStoreOrderShipmentId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderShipmentTable.withId(retailStoreOrderShipmentId),options);
	}
	
	protected RetailStoreOrderShipment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderShipmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderShipment newRetailStoreOrderShipment = loadInternalRetailStoreOrderShipment(accessKey, options);
		newRetailStoreOrderShipment.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderShipment.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderShipment(newRetailStoreOrderShipment,options);
		
		return newRetailStoreOrderShipment;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderShipmentId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderShipmentId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderShipmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderShipmentNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderShipmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderShipmentId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderShipmentId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderShipmentId, methodName, "retailStoreOrderShipmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderShipmentId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderShipmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","ship_time"};
		return RetailStoreOrderShipmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_shipment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderShipmentTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderShipmentTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderShipmentTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderShipmentMapper getRetailStoreOrderShipmentMapper(){
		return new RetailStoreOrderShipmentMapper();
	}
	protected RetailStoreOrderShipment extractRetailStoreOrderShipment(String retailStoreOrderShipmentId) throws Exception{
		String SQL = "select * from retail_store_order_shipment_data where id = ?";	
		try{
		
			RetailStoreOrderShipment retailStoreOrderShipment = queryForObject(SQL, new Object[]{retailStoreOrderShipmentId}, getRetailStoreOrderShipmentMapper());
			return retailStoreOrderShipment;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderShipmentNotFoundException("RetailStoreOrderShipment("+retailStoreOrderShipmentId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrderShipment extractRetailStoreOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_shipment_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrderShipment retailStoreOrderShipment = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderShipmentMapper());
			return retailStoreOrderShipment;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderShipmentNotFoundException("RetailStoreOrderShipment("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrderShipment loadInternalRetailStoreOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderShipment retailStoreOrderShipment = extractRetailStoreOrderShipment(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderShipment, loadOptions);
 		}		
		
		return retailStoreOrderShipment;
		
	}



	
	
	
		
	protected RetailStoreOrderShipment extractRetailStoreOrderList(RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object> options){
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByShipment(retailStoreOrderShipment.getId(),options);
		if(retailStoreOrderList != null){
			retailStoreOrderShipment.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderShipment;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderShipment saveRetailStoreOrderShipment(RetailStoreOrderShipment  retailStoreOrderShipment){
	
		String SQL=this.getSaveRetailStoreOrderShipmentSQL(retailStoreOrderShipment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderShipmentParameters(retailStoreOrderShipment);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderShipment.incVersion();
		return retailStoreOrderShipment;
	
	}
	public SmartList<RetailStoreOrderShipment> saveRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderShipmentList(retailStoreOrderShipmentList);
		
		batchRetailStoreOrderShipmentCreate((List<RetailStoreOrderShipment>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderShipmentUpdate((List<RetailStoreOrderShipment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderShipment retailStoreOrderShipment:retailStoreOrderShipmentList){
			if(retailStoreOrderShipment.isChanged()){
				retailStoreOrderShipment.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderShipmentList;
	}

	public SmartList<RetailStoreOrderShipment> removeRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderShipmentList, options);
		
		return retailStoreOrderShipmentList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderShipmentBatchCreateArgs(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderShipment retailStoreOrderShipment:retailStoreOrderShipmentList ){
			Object [] parameters = prepareRetailStoreOrderShipmentCreateParameters(retailStoreOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderShipmentBatchUpdateArgs(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderShipment retailStoreOrderShipment:retailStoreOrderShipmentList ){
			if(!retailStoreOrderShipment.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderShipmentUpdateParameters(retailStoreOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderShipmentCreate(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderShipmentBatchCreateArgs(retailStoreOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderShipmentUpdate(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderShipmentBatchUpdateArgs(retailStoreOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderShipmentList(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		
		List<RetailStoreOrderShipment> retailStoreOrderShipmentCreateList=new ArrayList<RetailStoreOrderShipment>();
		List<RetailStoreOrderShipment> retailStoreOrderShipmentUpdateList=new ArrayList<RetailStoreOrderShipment>();
		
		for(RetailStoreOrderShipment retailStoreOrderShipment: retailStoreOrderShipmentList){
			if(isUpdateRequest(retailStoreOrderShipment)){
				retailStoreOrderShipmentUpdateList.add( retailStoreOrderShipment);
				continue;
			}
			retailStoreOrderShipmentCreateList.add(retailStoreOrderShipment);
		}
		
		return new Object[]{retailStoreOrderShipmentCreateList,retailStoreOrderShipmentUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderShipment retailStoreOrderShipment){
 		return retailStoreOrderShipment.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderShipmentSQL(RetailStoreOrderShipment retailStoreOrderShipment){
 		if(isUpdateRequest(retailStoreOrderShipment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderShipmentParameters(RetailStoreOrderShipment retailStoreOrderShipment){
 		if(isUpdateRequest(retailStoreOrderShipment) ){
 			return prepareRetailStoreOrderShipmentUpdateParameters(retailStoreOrderShipment);
 		}
 		return prepareRetailStoreOrderShipmentCreateParameters(retailStoreOrderShipment);
 	}
 	protected Object[] prepareRetailStoreOrderShipmentUpdateParameters(RetailStoreOrderShipment retailStoreOrderShipment){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = retailStoreOrderShipment.getWho();
 		parameters[1] = retailStoreOrderShipment.getShipTime();		
 		parameters[2] = retailStoreOrderShipment.getId();
 		parameters[3] = retailStoreOrderShipment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderShipmentCreateParameters(RetailStoreOrderShipment retailStoreOrderShipment){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderShipmentId=getNextId();
		retailStoreOrderShipment.setId(newRetailStoreOrderShipmentId);
		parameters[0] =  retailStoreOrderShipment.getId();
 
 		parameters[1] = retailStoreOrderShipment.getWho();
 		parameters[2] = retailStoreOrderShipment.getShipTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderShipment saveInternalRetailStoreOrderShipment(RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object> options){
		
		saveRetailStoreOrderShipment(retailStoreOrderShipment);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderShipment, options);
	 		removeRetailStoreOrderList(retailStoreOrderShipment, options);
	 		
 		}		
		
		return retailStoreOrderShipment;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreOrderShipment saveRetailStoreOrderList(RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object> options){
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderShipment;
		}
		if(retailStoreOrderList.isEmpty()){
			return retailStoreOrderShipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderDAO().saveRetailStoreOrderList(retailStoreOrderList,options);
		
		return retailStoreOrderShipment;
	
	}
	
	protected RetailStoreOrderShipment removeRetailStoreOrderList(RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderShipment;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderShipment;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderShipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderShipment;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreOrderShipment present(RetailStoreOrderShipment retailStoreOrderShipment,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderShipment,options);

		return retailStoreOrderShipment;
	
	}
		
	
  	
 	protected RetailStoreOrderShipment presentRetailStoreOrderList(
			RetailStoreOrderShipment retailStoreOrderShipment,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();		
		if(retailStoreOrderList == null){
			return retailStoreOrderShipment;			
		}
		
		String targetObjectName = "retailStoreOrder";
		int retailStoreOrderListSize = retailStoreOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrderShipment;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderListSize;
		if(retailStoreOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderDAO().countRetailStoreOrderByShipment(retailStoreOrderShipment.getId(), options);			
		}
		//retailStoreOrderShipment.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrderShipment.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderListSize,currentPage,rowsPerPage) ;
			retailStoreOrderList = retailStoreOrderList.subListOf(fromIndex, toIndex);
			retailStoreOrderList.setTotalCount(count);
			retailStoreOrderList.setCurrentPageNumber(currentPage);			
			retailStoreOrderShipment.setRetailStoreOrderList(retailStoreOrderList);
			return retailStoreOrderShipment;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderList 
			= getRetailStoreOrderDAO().findRetailStoreOrderByShipment(retailStoreOrderShipment.getId(),start, rowsPerPage, options );
		retailStoreOrderList.setTotalCount(count);
		retailStoreOrderList.setCurrentPageNumber(currentPage);
		retailStoreOrderShipment.setRetailStoreOrderList(retailStoreOrderList );	

		return retailStoreOrderShipment;
	}			
		


	protected String getTableName(){
		return RetailStoreOrderShipmentTable.TABLE_NAME;
	}
}


