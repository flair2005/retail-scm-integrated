
package com.skynet.retailscm.supplyorderpicking;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.supplyorder.SupplyOrder;

import com.skynet.retailscm.supplyorder.SupplyOrderDAO;

import com.skynet.retailscm.supplyorder.SupplyOrderTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SupplyOrderPickingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderPickingDAO{

		
	
  	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO pSupplyOrderDAO){
 	
 		if(pSupplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = pSupplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The supplyOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDAO;
 	}	
 	
			
		

	
	/*
	protected SupplyOrderPicking load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderPicking(accessKey, options);
	}
	*/
	public SupplyOrderPicking load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderPicking(SupplyOrderPickingTable.withId(id), options);
	}
	
	
	
	public SupplyOrderPicking save(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options){
		
		String methodName="save(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderPicking, methodName, "supplyOrderPicking");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderPicking(supplyOrderPicking,options);
	}
	public SupplyOrderPicking clone(String supplyOrderPickingId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderPickingTable.withId(supplyOrderPickingId),options);
	}
	
	protected SupplyOrderPicking clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderPickingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderPicking newSupplyOrderPicking = loadInternalSupplyOrderPicking(accessKey, options);
		newSupplyOrderPicking.setVersion(0);
		
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderPicking.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderPicking(newSupplyOrderPicking,options);
		
		return newSupplyOrderPicking;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderPickingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderPickingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderPickingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderPickingNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderPickingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderPickingId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderPickingId, int version)";
		assertMethodArgumentNotNull(supplyOrderPickingId, methodName, "supplyOrderPickingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderPickingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderPickingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","process_time"};
		return SupplyOrderPickingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_picking";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderPickingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderPickingTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderPickingTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderPickingMapper getSupplyOrderPickingMapper(){
		return new SupplyOrderPickingMapper();
	}
	protected SupplyOrderPicking extractSupplyOrderPicking(String supplyOrderPickingId) throws Exception{
		String SQL = "select * from supply_order_picking_data where id = ?";	
		try{
		
			SupplyOrderPicking supplyOrderPicking = queryForObject(SQL, new Object[]{supplyOrderPickingId}, getSupplyOrderPickingMapper());
			return supplyOrderPicking;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderPickingNotFoundException("SupplyOrderPicking("+supplyOrderPickingId+") is not found!");
		}
		
		
	}
	protected SupplyOrderPicking extractSupplyOrderPicking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_picking_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrderPicking supplyOrderPicking = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderPickingMapper());
			return supplyOrderPicking;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderPickingNotFoundException("SupplyOrderPicking("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrderPicking loadInternalSupplyOrderPicking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderPicking supplyOrderPicking = extractSupplyOrderPicking(accessKey, loadOptions);

		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderPicking, loadOptions);
 		}		
		
		return supplyOrderPicking;
		
	}



	
	
	
		
	protected SupplyOrderPicking extractSupplyOrderList(SupplyOrderPicking supplyOrderPicking, Map<String,Object> options){
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByPicking(supplyOrderPicking.getId(),options);
		if(supplyOrderList != null){
			supplyOrderPicking.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderPicking;
	
	}	
		
		
 	
		
		
		

	

	protected SupplyOrderPicking saveSupplyOrderPicking(SupplyOrderPicking  supplyOrderPicking){
	
		String SQL=this.getSaveSupplyOrderPickingSQL(supplyOrderPicking);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderPickingParameters(supplyOrderPicking);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderPicking.incVersion();
		return supplyOrderPicking;
	
	}
	public SmartList<SupplyOrderPicking> saveSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderPickingList(supplyOrderPickingList);
		
		batchSupplyOrderPickingCreate((List<SupplyOrderPicking>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderPickingUpdate((List<SupplyOrderPicking>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderPicking supplyOrderPicking:supplyOrderPickingList){
			if(supplyOrderPicking.isChanged()){
				supplyOrderPicking.incVersion();
			}
			
		
		}
		
		
		return supplyOrderPickingList;
	}

	public SmartList<SupplyOrderPicking> removeSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderPickingList, options);
		
		return supplyOrderPickingList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderPickingBatchCreateArgs(List<SupplyOrderPicking> supplyOrderPickingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderPicking supplyOrderPicking:supplyOrderPickingList ){
			Object [] parameters = prepareSupplyOrderPickingCreateParameters(supplyOrderPicking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderPickingBatchUpdateArgs(List<SupplyOrderPicking> supplyOrderPickingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderPicking supplyOrderPicking:supplyOrderPickingList ){
			if(!supplyOrderPicking.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderPickingUpdateParameters(supplyOrderPicking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderPickingCreate(List<SupplyOrderPicking> supplyOrderPickingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderPickingBatchCreateArgs(supplyOrderPickingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderPickingUpdate(List<SupplyOrderPicking> supplyOrderPickingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderPickingBatchUpdateArgs(supplyOrderPickingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderPickingList(List<SupplyOrderPicking> supplyOrderPickingList){
		
		List<SupplyOrderPicking> supplyOrderPickingCreateList=new ArrayList<SupplyOrderPicking>();
		List<SupplyOrderPicking> supplyOrderPickingUpdateList=new ArrayList<SupplyOrderPicking>();
		
		for(SupplyOrderPicking supplyOrderPicking: supplyOrderPickingList){
			if(isUpdateRequest(supplyOrderPicking)){
				supplyOrderPickingUpdateList.add( supplyOrderPicking);
				continue;
			}
			supplyOrderPickingCreateList.add(supplyOrderPicking);
		}
		
		return new Object[]{supplyOrderPickingCreateList,supplyOrderPickingUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderPicking supplyOrderPicking){
 		return supplyOrderPicking.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderPickingSQL(SupplyOrderPicking supplyOrderPicking){
 		if(isUpdateRequest(supplyOrderPicking)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderPickingParameters(SupplyOrderPicking supplyOrderPicking){
 		if(isUpdateRequest(supplyOrderPicking) ){
 			return prepareSupplyOrderPickingUpdateParameters(supplyOrderPicking);
 		}
 		return prepareSupplyOrderPickingCreateParameters(supplyOrderPicking);
 	}
 	protected Object[] prepareSupplyOrderPickingUpdateParameters(SupplyOrderPicking supplyOrderPicking){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = supplyOrderPicking.getWho();
 		parameters[1] = supplyOrderPicking.getProcessTime();		
 		parameters[2] = supplyOrderPicking.getId();
 		parameters[3] = supplyOrderPicking.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderPickingCreateParameters(SupplyOrderPicking supplyOrderPicking){
		Object[] parameters = new Object[3];
		String newSupplyOrderPickingId=getNextId();
		supplyOrderPicking.setId(newSupplyOrderPickingId);
		parameters[0] =  supplyOrderPicking.getId();
 
 		parameters[1] = supplyOrderPicking.getWho();
 		parameters[2] = supplyOrderPicking.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderPicking saveInternalSupplyOrderPicking(SupplyOrderPicking supplyOrderPicking, Map<String,Object> options){
		
		saveSupplyOrderPicking(supplyOrderPicking);

		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderPicking, options);
	 		removeSupplyOrderList(supplyOrderPicking, options);
	 		
 		}		
		
		return supplyOrderPicking;
		
	}
	
	
	
	//======================================================================================
	
		
	protected SupplyOrderPicking saveSupplyOrderList(SupplyOrderPicking supplyOrderPicking, Map<String,Object> options){
		SmartList<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderPicking;
		}
		if(supplyOrderList.isEmpty()){
			return supplyOrderPicking;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderDAO().saveSupplyOrderList(supplyOrderList,options);
		
		return supplyOrderPicking;
	
	}
	
	protected SupplyOrderPicking removeSupplyOrderList(SupplyOrderPicking supplyOrderPicking, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderPicking;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderPicking;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderPicking;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderPicking;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SupplyOrderPicking present(SupplyOrderPicking supplyOrderPicking,Map<String, Object> options){
	
		presentSupplyOrderList(supplyOrderPicking,options);

		return supplyOrderPicking;
	
	}
		
	
  	
 	protected SupplyOrderPicking presentSupplyOrderList(
			SupplyOrderPicking supplyOrderPicking,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();		
		if(supplyOrderList == null){
			return supplyOrderPicking;			
		}
		
		String targetObjectName = "supplyOrder";
		int supplyOrderListSize = supplyOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderPicking;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderListSize;
		if(supplyOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderDAO().countSupplyOrderByPicking(supplyOrderPicking.getId(), options);			
		}
		//supplyOrderPicking.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderPicking.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderListSize,currentPage,rowsPerPage) ;
			supplyOrderList = supplyOrderList.subListOf(fromIndex, toIndex);
			supplyOrderList.setTotalCount(count);
			supplyOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderPicking.setSupplyOrderList(supplyOrderList);
			return supplyOrderPicking;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderList 
			= getSupplyOrderDAO().findSupplyOrderByPicking(supplyOrderPicking.getId(),start, rowsPerPage, options );
		supplyOrderList.setTotalCount(count);
		supplyOrderList.setCurrentPageNumber(currentPage);
		supplyOrderPicking.setSupplyOrderList(supplyOrderList );	

		return supplyOrderPicking;
	}			
		


	protected String getTableName(){
		return SupplyOrderPickingTable.TABLE_NAME;
	}
}


