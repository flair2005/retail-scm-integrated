
package com.skynet.retailscm.supplyorderapproval;

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

public class SupplyOrderApprovalJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderApprovalDAO{

		
	
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
	protected SupplyOrderApproval load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderApproval(accessKey, options);
	}
	*/
	public SupplyOrderApproval load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderApproval(SupplyOrderApprovalTable.withId(id), options);
	}
	
	
	
	public SupplyOrderApproval save(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options){
		
		String methodName="save(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderApproval, methodName, "supplyOrderApproval");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderApproval(supplyOrderApproval,options);
	}
	public SupplyOrderApproval clone(String supplyOrderApprovalId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderApprovalTable.withId(supplyOrderApprovalId),options);
	}
	
	protected SupplyOrderApproval clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderApprovalId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderApproval newSupplyOrderApproval = loadInternalSupplyOrderApproval(accessKey, options);
		newSupplyOrderApproval.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderApproval.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderApproval.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderApproval(newSupplyOrderApproval,options);
		
		return newSupplyOrderApproval;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderApprovalId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderApprovalId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderApprovalVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderApprovalNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderApprovalId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderApprovalId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderApprovalId, int version)";
		assertMethodArgumentNotNull(supplyOrderApprovalId, methodName, "supplyOrderApprovalId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderApprovalId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderApprovalId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","approve_time"};
		return SupplyOrderApprovalTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_approval";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderApprovalTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderApprovalTokens.CONSUMER_ORDER_LIST);
		
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderApprovalTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderApprovalTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderApprovalTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderApprovalMapper getSupplyOrderApprovalMapper(){
		return new SupplyOrderApprovalMapper();
	}
	protected SupplyOrderApproval extractSupplyOrderApproval(String supplyOrderApprovalId) throws Exception{
		String SQL = "select * from supply_order_approval_data where id = ?";	
		try{
		
			SupplyOrderApproval supplyOrderApproval = queryForObject(SQL, new Object[]{supplyOrderApprovalId}, getSupplyOrderApprovalMapper());
			return supplyOrderApproval;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderApprovalNotFoundException("SupplyOrderApproval("+supplyOrderApprovalId+") is not found!");
		}
		
		
	}
	protected SupplyOrderApproval extractSupplyOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_approval_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrderApproval supplyOrderApproval = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderApprovalMapper());
			return supplyOrderApproval;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderApprovalNotFoundException("SupplyOrderApproval("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrderApproval loadInternalSupplyOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderApproval supplyOrderApproval = extractSupplyOrderApproval(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderApproval, loadOptions);
 		}		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderApproval, loadOptions);
 		}		
		
		return supplyOrderApproval;
		
	}



	
	
	
		
	protected SupplyOrderApproval extractConsumerOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByApproval(supplyOrderApproval.getId(),options);
		if(consumerOrderList != null){
			supplyOrderApproval.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderApproval;
	
	}	
		
	protected SupplyOrderApproval extractSupplyOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByApproval(supplyOrderApproval.getId(),options);
		if(supplyOrderList != null){
			supplyOrderApproval.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderApproval;
	
	}	
		
		
 	
		
		
		

	

	protected SupplyOrderApproval saveSupplyOrderApproval(SupplyOrderApproval  supplyOrderApproval){
	
		String SQL=this.getSaveSupplyOrderApprovalSQL(supplyOrderApproval);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderApprovalParameters(supplyOrderApproval);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderApproval.incVersion();
		return supplyOrderApproval;
	
	}
	public SmartList<SupplyOrderApproval> saveSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderApprovalList(supplyOrderApprovalList);
		
		batchSupplyOrderApprovalCreate((List<SupplyOrderApproval>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderApprovalUpdate((List<SupplyOrderApproval>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderApproval supplyOrderApproval:supplyOrderApprovalList){
			if(supplyOrderApproval.isChanged()){
				supplyOrderApproval.incVersion();
			}
			
		
		}
		
		
		return supplyOrderApprovalList;
	}

	public SmartList<SupplyOrderApproval> removeSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderApprovalList, options);
		
		return supplyOrderApprovalList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderApprovalBatchCreateArgs(List<SupplyOrderApproval> supplyOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderApproval supplyOrderApproval:supplyOrderApprovalList ){
			Object [] parameters = prepareSupplyOrderApprovalCreateParameters(supplyOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderApprovalBatchUpdateArgs(List<SupplyOrderApproval> supplyOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderApproval supplyOrderApproval:supplyOrderApprovalList ){
			if(!supplyOrderApproval.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderApprovalUpdateParameters(supplyOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderApprovalCreate(List<SupplyOrderApproval> supplyOrderApprovalList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderApprovalBatchCreateArgs(supplyOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderApprovalUpdate(List<SupplyOrderApproval> supplyOrderApprovalList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderApprovalBatchUpdateArgs(supplyOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderApprovalList(List<SupplyOrderApproval> supplyOrderApprovalList){
		
		List<SupplyOrderApproval> supplyOrderApprovalCreateList=new ArrayList<SupplyOrderApproval>();
		List<SupplyOrderApproval> supplyOrderApprovalUpdateList=new ArrayList<SupplyOrderApproval>();
		
		for(SupplyOrderApproval supplyOrderApproval: supplyOrderApprovalList){
			if(isUpdateRequest(supplyOrderApproval)){
				supplyOrderApprovalUpdateList.add( supplyOrderApproval);
				continue;
			}
			supplyOrderApprovalCreateList.add(supplyOrderApproval);
		}
		
		return new Object[]{supplyOrderApprovalCreateList,supplyOrderApprovalUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderApproval supplyOrderApproval){
 		return supplyOrderApproval.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderApprovalSQL(SupplyOrderApproval supplyOrderApproval){
 		if(isUpdateRequest(supplyOrderApproval)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderApprovalParameters(SupplyOrderApproval supplyOrderApproval){
 		if(isUpdateRequest(supplyOrderApproval) ){
 			return prepareSupplyOrderApprovalUpdateParameters(supplyOrderApproval);
 		}
 		return prepareSupplyOrderApprovalCreateParameters(supplyOrderApproval);
 	}
 	protected Object[] prepareSupplyOrderApprovalUpdateParameters(SupplyOrderApproval supplyOrderApproval){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = supplyOrderApproval.getWho();
 		parameters[1] = supplyOrderApproval.getApproveTime();		
 		parameters[2] = supplyOrderApproval.getId();
 		parameters[3] = supplyOrderApproval.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderApprovalCreateParameters(SupplyOrderApproval supplyOrderApproval){
		Object[] parameters = new Object[3];
		String newSupplyOrderApprovalId=getNextId();
		supplyOrderApproval.setId(newSupplyOrderApprovalId);
		parameters[0] =  supplyOrderApproval.getId();
 
 		parameters[1] = supplyOrderApproval.getWho();
 		parameters[2] = supplyOrderApproval.getApproveTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderApproval saveInternalSupplyOrderApproval(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		
		saveSupplyOrderApproval(supplyOrderApproval);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderApproval, options);
	 		removeConsumerOrderList(supplyOrderApproval, options);
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderApproval, options);
	 		removeSupplyOrderList(supplyOrderApproval, options);
	 		
 		}		
		
		return supplyOrderApproval;
		
	}
	
	
	
	//======================================================================================
	
		
	protected SupplyOrderApproval saveConsumerOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderApproval.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderApproval;
		}
		if(consumerOrderList.isEmpty()){
			return supplyOrderApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderDAO().saveConsumerOrderList(consumerOrderList,options);
		
		return supplyOrderApproval;
	
	}
	
	protected SupplyOrderApproval removeConsumerOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderApproval.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderApproval;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderApproval;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderApproval;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected SupplyOrderApproval saveSupplyOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		SmartList<SupplyOrder> supplyOrderList = supplyOrderApproval.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderApproval;
		}
		if(supplyOrderList.isEmpty()){
			return supplyOrderApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderDAO().saveSupplyOrderList(supplyOrderList,options);
		
		return supplyOrderApproval;
	
	}
	
	protected SupplyOrderApproval removeSupplyOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderApproval.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderApproval;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderApproval;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderApproval;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SupplyOrderApproval present(SupplyOrderApproval supplyOrderApproval,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderApproval,options);
		presentSupplyOrderList(supplyOrderApproval,options);

		return supplyOrderApproval;
	
	}
		
	
  	
 	protected SupplyOrderApproval presentConsumerOrderList(
			SupplyOrderApproval supplyOrderApproval,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderApproval.getConsumerOrderList();		
		if(consumerOrderList == null){
			return supplyOrderApproval;			
		}
		
		String targetObjectName = "consumerOrder";
		int consumerOrderListSize = consumerOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderApproval;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderListSize;
		if(consumerOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderDAO().countConsumerOrderByApproval(supplyOrderApproval.getId(), options);			
		}
		//supplyOrderApproval.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderApproval.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderListSize,currentPage,rowsPerPage) ;
			consumerOrderList = consumerOrderList.subListOf(fromIndex, toIndex);
			consumerOrderList.setTotalCount(count);
			consumerOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderApproval.setConsumerOrderList(consumerOrderList);
			return supplyOrderApproval;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderList 
			= getConsumerOrderDAO().findConsumerOrderByApproval(supplyOrderApproval.getId(),start, rowsPerPage, options );
		consumerOrderList.setTotalCount(count);
		consumerOrderList.setCurrentPageNumber(currentPage);
		supplyOrderApproval.setConsumerOrderList(consumerOrderList );	

		return supplyOrderApproval;
	}			
		
	
  	
 	protected SupplyOrderApproval presentSupplyOrderList(
			SupplyOrderApproval supplyOrderApproval,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderApproval.getSupplyOrderList();		
		if(supplyOrderList == null){
			return supplyOrderApproval;			
		}
		
		String targetObjectName = "supplyOrder";
		int supplyOrderListSize = supplyOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderApproval;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderListSize;
		if(supplyOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderDAO().countSupplyOrderByApproval(supplyOrderApproval.getId(), options);			
		}
		//supplyOrderApproval.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderApproval.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderListSize,currentPage,rowsPerPage) ;
			supplyOrderList = supplyOrderList.subListOf(fromIndex, toIndex);
			supplyOrderList.setTotalCount(count);
			supplyOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderApproval.setSupplyOrderList(supplyOrderList);
			return supplyOrderApproval;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderList 
			= getSupplyOrderDAO().findSupplyOrderByApproval(supplyOrderApproval.getId(),start, rowsPerPage, options );
		supplyOrderList.setTotalCount(count);
		supplyOrderList.setCurrentPageNumber(currentPage);
		supplyOrderApproval.setSupplyOrderList(supplyOrderList );	

		return supplyOrderApproval;
	}			
		


	protected String getTableName(){
		return SupplyOrderApprovalTable.TABLE_NAME;
	}
}


