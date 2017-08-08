
package com.skynet.retailscm.supplyorderprocessing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.consumerorder.ConsumerOrder;

import com.skynet.retailscm.consumerorder.ConsumerOrderDAO;
import com.skynet.retailscm.supplyorder.SupplyOrderDAO;

import com.skynet.retailscm.consumerorder.ConsumerOrderTable;
import com.skynet.retailscm.supplyorder.SupplyOrderTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SupplyOrderProcessingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderProcessingDAO{

		
	
  	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO pConsumerOrderDAO){
 	
 		if(pConsumerOrderDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
 		}
	 	this.consumerOrderDAO = pConsumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
 		if(this.consumerOrderDAO == null){
 			throw new IllegalStateException("The consumerOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderDAO;
 	}	
 	
			
		
	
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
	protected SupplyOrderProcessing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderProcessing(accessKey, options);
	}
	*/
	public SupplyOrderProcessing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderProcessing(SupplyOrderProcessingTable.withId(id), options);
	}
	
	
	
	public SupplyOrderProcessing save(SupplyOrderProcessing supplyOrderProcessing,Map<String,Object> options){
		
		String methodName="save(SupplyOrderProcessing supplyOrderProcessing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderProcessing, methodName, "supplyOrderProcessing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderProcessing(supplyOrderProcessing,options);
	}
	public SupplyOrderProcessing clone(String supplyOrderProcessingId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderProcessingTable.withId(supplyOrderProcessingId),options);
	}
	
	protected SupplyOrderProcessing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderProcessingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderProcessing newSupplyOrderProcessing = loadInternalSupplyOrderProcessing(accessKey, options);
		newSupplyOrderProcessing.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderProcessing.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderProcessing.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderProcessing(newSupplyOrderProcessing,options);
		
		return newSupplyOrderProcessing;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderProcessingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderProcessingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderProcessingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderProcessingNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderProcessingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderProcessingId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderProcessingId, int version)";
		assertMethodArgumentNotNull(supplyOrderProcessingId, methodName, "supplyOrderProcessingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderProcessingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderProcessingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","process_time"};
		return SupplyOrderProcessingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_processing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderProcessingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderProcessingTokens.CONSUMER_ORDER_LIST);
		
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderProcessingTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderProcessingTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderProcessingTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderProcessingMapper getSupplyOrderProcessingMapper(){
		return new SupplyOrderProcessingMapper();
	}
	protected SupplyOrderProcessing extractSupplyOrderProcessing(String supplyOrderProcessingId) throws Exception{
		String SQL = "select * from supply_order_processing_data where id = ?";	
		try{
		
			SupplyOrderProcessing supplyOrderProcessing = queryForObject(SQL, new Object[]{supplyOrderProcessingId}, getSupplyOrderProcessingMapper());
			return supplyOrderProcessing;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderProcessingNotFoundException("SupplyOrderProcessing("+supplyOrderProcessingId+") is not found!");
		}
		
		
	}
	protected SupplyOrderProcessing extractSupplyOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_processing_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrderProcessing supplyOrderProcessing = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderProcessingMapper());
			return supplyOrderProcessing;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderProcessingNotFoundException("SupplyOrderProcessing("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrderProcessing loadInternalSupplyOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderProcessing supplyOrderProcessing = extractSupplyOrderProcessing(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderProcessing, loadOptions);
 		}		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderProcessing, loadOptions);
 		}		
		
		return supplyOrderProcessing;
		
	}



	
	
	
		
	protected SupplyOrderProcessing extractConsumerOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByProcessing(supplyOrderProcessing.getId(),options);
		if(consumerOrderList != null){
			supplyOrderProcessing.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderProcessing;
	
	}	
		
	protected SupplyOrderProcessing extractSupplyOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByProcessing(supplyOrderProcessing.getId(),options);
		if(supplyOrderList != null){
			supplyOrderProcessing.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderProcessing;
	
	}	
		
		
 	
		
		
		

	

	protected SupplyOrderProcessing saveSupplyOrderProcessing(SupplyOrderProcessing  supplyOrderProcessing){
	
		String SQL=this.getSaveSupplyOrderProcessingSQL(supplyOrderProcessing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderProcessingParameters(supplyOrderProcessing);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderProcessing.incVersion();
		return supplyOrderProcessing;
	
	}
	public SmartList<SupplyOrderProcessing> saveSupplyOrderProcessingList(SmartList<SupplyOrderProcessing> supplyOrderProcessingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderProcessingList(supplyOrderProcessingList);
		
		batchSupplyOrderProcessingCreate((List<SupplyOrderProcessing>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderProcessingUpdate((List<SupplyOrderProcessing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderProcessing supplyOrderProcessing:supplyOrderProcessingList){
			if(supplyOrderProcessing.isChanged()){
				supplyOrderProcessing.incVersion();
			}
			
		
		}
		
		
		return supplyOrderProcessingList;
	}

	public SmartList<SupplyOrderProcessing> removeSupplyOrderProcessingList(SmartList<SupplyOrderProcessing> supplyOrderProcessingList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderProcessingList, options);
		
		return supplyOrderProcessingList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderProcessingBatchCreateArgs(List<SupplyOrderProcessing> supplyOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderProcessing supplyOrderProcessing:supplyOrderProcessingList ){
			Object [] parameters = prepareSupplyOrderProcessingCreateParameters(supplyOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderProcessingBatchUpdateArgs(List<SupplyOrderProcessing> supplyOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderProcessing supplyOrderProcessing:supplyOrderProcessingList ){
			if(!supplyOrderProcessing.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderProcessingUpdateParameters(supplyOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderProcessingCreate(List<SupplyOrderProcessing> supplyOrderProcessingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderProcessingBatchCreateArgs(supplyOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderProcessingUpdate(List<SupplyOrderProcessing> supplyOrderProcessingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderProcessingBatchUpdateArgs(supplyOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderProcessingList(List<SupplyOrderProcessing> supplyOrderProcessingList){
		
		List<SupplyOrderProcessing> supplyOrderProcessingCreateList=new ArrayList<SupplyOrderProcessing>();
		List<SupplyOrderProcessing> supplyOrderProcessingUpdateList=new ArrayList<SupplyOrderProcessing>();
		
		for(SupplyOrderProcessing supplyOrderProcessing: supplyOrderProcessingList){
			if(isUpdateRequest(supplyOrderProcessing)){
				supplyOrderProcessingUpdateList.add( supplyOrderProcessing);
				continue;
			}
			supplyOrderProcessingCreateList.add(supplyOrderProcessing);
		}
		
		return new Object[]{supplyOrderProcessingCreateList,supplyOrderProcessingUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderProcessing supplyOrderProcessing){
 		return supplyOrderProcessing.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderProcessingSQL(SupplyOrderProcessing supplyOrderProcessing){
 		if(isUpdateRequest(supplyOrderProcessing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderProcessingParameters(SupplyOrderProcessing supplyOrderProcessing){
 		if(isUpdateRequest(supplyOrderProcessing) ){
 			return prepareSupplyOrderProcessingUpdateParameters(supplyOrderProcessing);
 		}
 		return prepareSupplyOrderProcessingCreateParameters(supplyOrderProcessing);
 	}
 	protected Object[] prepareSupplyOrderProcessingUpdateParameters(SupplyOrderProcessing supplyOrderProcessing){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = supplyOrderProcessing.getWho();
 		parameters[1] = supplyOrderProcessing.getProcessTime();		
 		parameters[2] = supplyOrderProcessing.getId();
 		parameters[3] = supplyOrderProcessing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderProcessingCreateParameters(SupplyOrderProcessing supplyOrderProcessing){
		Object[] parameters = new Object[3];
		String newSupplyOrderProcessingId=getNextId();
		supplyOrderProcessing.setId(newSupplyOrderProcessingId);
		parameters[0] =  supplyOrderProcessing.getId();
 
 		parameters[1] = supplyOrderProcessing.getWho();
 		parameters[2] = supplyOrderProcessing.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderProcessing saveInternalSupplyOrderProcessing(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		saveSupplyOrderProcessing(supplyOrderProcessing);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderProcessing, options);
	 		removeConsumerOrderList(supplyOrderProcessing, options);
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderProcessing, options);
	 		removeSupplyOrderList(supplyOrderProcessing, options);
	 		
 		}		
		
		return supplyOrderProcessing;
		
	}
	
	
	
	//======================================================================================
	
		
	protected SupplyOrderProcessing saveConsumerOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderProcessing;
		}
		if(consumerOrderList.isEmpty()){
			return supplyOrderProcessing;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderDAO().saveConsumerOrderList(consumerOrderList,options);
		
		return supplyOrderProcessing;
	
	}
	
	protected SupplyOrderProcessing removeConsumerOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderProcessing;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderProcessing;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderProcessing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderProcessing;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected SupplyOrderProcessing saveSupplyOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderProcessing;
		}
		if(supplyOrderList.isEmpty()){
			return supplyOrderProcessing;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderDAO().saveSupplyOrderList(supplyOrderList,options);
		
		return supplyOrderProcessing;
	
	}
	
	protected SupplyOrderProcessing removeSupplyOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderProcessing;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderProcessing;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderProcessing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderProcessing;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SupplyOrderProcessing present(SupplyOrderProcessing supplyOrderProcessing,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderProcessing,options);
		presentSupplyOrderList(supplyOrderProcessing,options);

		return supplyOrderProcessing;
	
	}
		
	
  	
 	protected SupplyOrderProcessing presentConsumerOrderList(
			SupplyOrderProcessing supplyOrderProcessing,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();		
		if(consumerOrderList == null){
			return supplyOrderProcessing;			
		}
		
		String targetObjectName = "consumerOrder";
		int consumerOrderListSize = consumerOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderProcessing;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderListSize;
		if(consumerOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderDAO().countConsumerOrderByProcessing(supplyOrderProcessing.getId(), options);			
		}
		//supplyOrderProcessing.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderProcessing.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderListSize,currentPage,rowsPerPage) ;
			consumerOrderList = consumerOrderList.subListOf(fromIndex, toIndex);
			consumerOrderList.setTotalCount(count);
			consumerOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderProcessing.setConsumerOrderList(consumerOrderList);
			return supplyOrderProcessing;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderList 
			= getConsumerOrderDAO().findConsumerOrderByProcessing(supplyOrderProcessing.getId(),start, rowsPerPage, options );
		consumerOrderList.setTotalCount(count);
		consumerOrderList.setCurrentPageNumber(currentPage);
		supplyOrderProcessing.setConsumerOrderList(consumerOrderList );	

		return supplyOrderProcessing;
	}			
		
	
  	
 	protected SupplyOrderProcessing presentSupplyOrderList(
			SupplyOrderProcessing supplyOrderProcessing,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();		
		if(supplyOrderList == null){
			return supplyOrderProcessing;			
		}
		
		String targetObjectName = "supplyOrder";
		int supplyOrderListSize = supplyOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderProcessing;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderListSize;
		if(supplyOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderDAO().countSupplyOrderByProcessing(supplyOrderProcessing.getId(), options);			
		}
		//supplyOrderProcessing.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderProcessing.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderListSize,currentPage,rowsPerPage) ;
			supplyOrderList = supplyOrderList.subListOf(fromIndex, toIndex);
			supplyOrderList.setTotalCount(count);
			supplyOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderProcessing.setSupplyOrderList(supplyOrderList);
			return supplyOrderProcessing;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderList 
			= getSupplyOrderDAO().findSupplyOrderByProcessing(supplyOrderProcessing.getId(),start, rowsPerPage, options );
		supplyOrderList.setTotalCount(count);
		supplyOrderList.setCurrentPageNumber(currentPage);
		supplyOrderProcessing.setSupplyOrderList(supplyOrderList );	

		return supplyOrderProcessing;
	}			
		


	protected String getTableName(){
		return SupplyOrderProcessingTable.TABLE_NAME;
	}
}


