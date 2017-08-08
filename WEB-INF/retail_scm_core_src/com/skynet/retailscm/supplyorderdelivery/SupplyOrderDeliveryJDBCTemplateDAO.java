
package com.skynet.retailscm.supplyorderdelivery;

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

public class SupplyOrderDeliveryJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderDeliveryDAO{

		
	
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
	protected SupplyOrderDelivery load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderDelivery(accessKey, options);
	}
	*/
	public SupplyOrderDelivery load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderDelivery(SupplyOrderDeliveryTable.withId(id), options);
	}
	
	
	
	public SupplyOrderDelivery save(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options){
		
		String methodName="save(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderDelivery, methodName, "supplyOrderDelivery");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderDelivery(supplyOrderDelivery,options);
	}
	public SupplyOrderDelivery clone(String supplyOrderDeliveryId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderDeliveryTable.withId(supplyOrderDeliveryId),options);
	}
	
	protected SupplyOrderDelivery clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderDeliveryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderDelivery newSupplyOrderDelivery = loadInternalSupplyOrderDelivery(accessKey, options);
		newSupplyOrderDelivery.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderDelivery.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderDelivery.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderDelivery(newSupplyOrderDelivery,options);
		
		return newSupplyOrderDelivery;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderDeliveryId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderDeliveryId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderDeliveryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderDeliveryNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderDeliveryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderDeliveryId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderDeliveryId, int version)";
		assertMethodArgumentNotNull(supplyOrderDeliveryId, methodName, "supplyOrderDeliveryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderDeliveryId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderDeliveryId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","delivery_time"};
		return SupplyOrderDeliveryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_delivery";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderDeliveryTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderDeliveryTokens.CONSUMER_ORDER_LIST);
		
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderDeliveryTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderDeliveryTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderDeliveryTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderDeliveryMapper getSupplyOrderDeliveryMapper(){
		return new SupplyOrderDeliveryMapper();
	}
	protected SupplyOrderDelivery extractSupplyOrderDelivery(String supplyOrderDeliveryId) throws Exception{
		String SQL = "select * from supply_order_delivery_data where id = ?";	
		try{
		
			SupplyOrderDelivery supplyOrderDelivery = queryForObject(SQL, new Object[]{supplyOrderDeliveryId}, getSupplyOrderDeliveryMapper());
			return supplyOrderDelivery;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderDeliveryNotFoundException("SupplyOrderDelivery("+supplyOrderDeliveryId+") is not found!");
		}
		
		
	}
	protected SupplyOrderDelivery extractSupplyOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_delivery_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrderDelivery supplyOrderDelivery = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderDeliveryMapper());
			return supplyOrderDelivery;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderDeliveryNotFoundException("SupplyOrderDelivery("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrderDelivery loadInternalSupplyOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderDelivery supplyOrderDelivery = extractSupplyOrderDelivery(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderDelivery, loadOptions);
 		}		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderDelivery, loadOptions);
 		}		
		
		return supplyOrderDelivery;
		
	}



	
	
	
		
	protected SupplyOrderDelivery extractConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByDelivery(supplyOrderDelivery.getId(),options);
		if(consumerOrderList != null){
			supplyOrderDelivery.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderDelivery;
	
	}	
		
	protected SupplyOrderDelivery extractSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByDelivery(supplyOrderDelivery.getId(),options);
		if(supplyOrderList != null){
			supplyOrderDelivery.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderDelivery;
	
	}	
		
		
 	
		
		
		

	

	protected SupplyOrderDelivery saveSupplyOrderDelivery(SupplyOrderDelivery  supplyOrderDelivery){
	
		String SQL=this.getSaveSupplyOrderDeliverySQL(supplyOrderDelivery);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderDeliveryParameters(supplyOrderDelivery);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderDelivery.incVersion();
		return supplyOrderDelivery;
	
	}
	public SmartList<SupplyOrderDelivery> saveSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderDeliveryList(supplyOrderDeliveryList);
		
		batchSupplyOrderDeliveryCreate((List<SupplyOrderDelivery>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderDeliveryUpdate((List<SupplyOrderDelivery>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderDelivery supplyOrderDelivery:supplyOrderDeliveryList){
			if(supplyOrderDelivery.isChanged()){
				supplyOrderDelivery.incVersion();
			}
			
		
		}
		
		
		return supplyOrderDeliveryList;
	}

	public SmartList<SupplyOrderDelivery> removeSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderDeliveryList, options);
		
		return supplyOrderDeliveryList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderDeliveryBatchCreateArgs(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderDelivery supplyOrderDelivery:supplyOrderDeliveryList ){
			Object [] parameters = prepareSupplyOrderDeliveryCreateParameters(supplyOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderDeliveryBatchUpdateArgs(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderDelivery supplyOrderDelivery:supplyOrderDeliveryList ){
			if(!supplyOrderDelivery.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderDeliveryUpdateParameters(supplyOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderDeliveryCreate(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderDeliveryBatchCreateArgs(supplyOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderDeliveryUpdate(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderDeliveryBatchUpdateArgs(supplyOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderDeliveryList(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		
		List<SupplyOrderDelivery> supplyOrderDeliveryCreateList=new ArrayList<SupplyOrderDelivery>();
		List<SupplyOrderDelivery> supplyOrderDeliveryUpdateList=new ArrayList<SupplyOrderDelivery>();
		
		for(SupplyOrderDelivery supplyOrderDelivery: supplyOrderDeliveryList){
			if(isUpdateRequest(supplyOrderDelivery)){
				supplyOrderDeliveryUpdateList.add( supplyOrderDelivery);
				continue;
			}
			supplyOrderDeliveryCreateList.add(supplyOrderDelivery);
		}
		
		return new Object[]{supplyOrderDeliveryCreateList,supplyOrderDeliveryUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderDelivery supplyOrderDelivery){
 		return supplyOrderDelivery.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderDeliverySQL(SupplyOrderDelivery supplyOrderDelivery){
 		if(isUpdateRequest(supplyOrderDelivery)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderDeliveryParameters(SupplyOrderDelivery supplyOrderDelivery){
 		if(isUpdateRequest(supplyOrderDelivery) ){
 			return prepareSupplyOrderDeliveryUpdateParameters(supplyOrderDelivery);
 		}
 		return prepareSupplyOrderDeliveryCreateParameters(supplyOrderDelivery);
 	}
 	protected Object[] prepareSupplyOrderDeliveryUpdateParameters(SupplyOrderDelivery supplyOrderDelivery){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = supplyOrderDelivery.getWho();
 		parameters[1] = supplyOrderDelivery.getDeliveryTime();		
 		parameters[2] = supplyOrderDelivery.getId();
 		parameters[3] = supplyOrderDelivery.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderDeliveryCreateParameters(SupplyOrderDelivery supplyOrderDelivery){
		Object[] parameters = new Object[3];
		String newSupplyOrderDeliveryId=getNextId();
		supplyOrderDelivery.setId(newSupplyOrderDeliveryId);
		parameters[0] =  supplyOrderDelivery.getId();
 
 		parameters[1] = supplyOrderDelivery.getWho();
 		parameters[2] = supplyOrderDelivery.getDeliveryTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderDelivery saveInternalSupplyOrderDelivery(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		saveSupplyOrderDelivery(supplyOrderDelivery);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderDelivery, options);
	 		removeConsumerOrderList(supplyOrderDelivery, options);
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderDelivery, options);
	 		removeSupplyOrderList(supplyOrderDelivery, options);
	 		
 		}		
		
		return supplyOrderDelivery;
		
	}
	
	
	
	//======================================================================================
	
		
	protected SupplyOrderDelivery saveConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(consumerOrderList.isEmpty()){
			return supplyOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderDAO().saveConsumerOrderList(consumerOrderList,options);
		
		return supplyOrderDelivery;
	
	}
	
	protected SupplyOrderDelivery removeConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderDelivery;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderDelivery;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected SupplyOrderDelivery saveSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(supplyOrderList.isEmpty()){
			return supplyOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderDAO().saveSupplyOrderList(supplyOrderList,options);
		
		return supplyOrderDelivery;
	
	}
	
	protected SupplyOrderDelivery removeSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderDelivery;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderDelivery;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SupplyOrderDelivery present(SupplyOrderDelivery supplyOrderDelivery,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderDelivery,options);
		presentSupplyOrderList(supplyOrderDelivery,options);

		return supplyOrderDelivery;
	
	}
		
	
  	
 	protected SupplyOrderDelivery presentConsumerOrderList(
			SupplyOrderDelivery supplyOrderDelivery,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		if(consumerOrderList == null){
			return supplyOrderDelivery;			
		}
		
		String targetObjectName = "consumerOrder";
		int consumerOrderListSize = consumerOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderDelivery;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderListSize;
		if(consumerOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderDAO().countConsumerOrderByDelivery(supplyOrderDelivery.getId(), options);			
		}
		//supplyOrderDelivery.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderDelivery.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderListSize,currentPage,rowsPerPage) ;
			consumerOrderList = consumerOrderList.subListOf(fromIndex, toIndex);
			consumerOrderList.setTotalCount(count);
			consumerOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderDelivery.setConsumerOrderList(consumerOrderList);
			return supplyOrderDelivery;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderList 
			= getConsumerOrderDAO().findConsumerOrderByDelivery(supplyOrderDelivery.getId(),start, rowsPerPage, options );
		consumerOrderList.setTotalCount(count);
		consumerOrderList.setCurrentPageNumber(currentPage);
		supplyOrderDelivery.setConsumerOrderList(consumerOrderList );	

		return supplyOrderDelivery;
	}			
		
	
  	
 	protected SupplyOrderDelivery presentSupplyOrderList(
			SupplyOrderDelivery supplyOrderDelivery,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		if(supplyOrderList == null){
			return supplyOrderDelivery;			
		}
		
		String targetObjectName = "supplyOrder";
		int supplyOrderListSize = supplyOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderDelivery;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderListSize;
		if(supplyOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderDAO().countSupplyOrderByDelivery(supplyOrderDelivery.getId(), options);			
		}
		//supplyOrderDelivery.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderDelivery.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderListSize,currentPage,rowsPerPage) ;
			supplyOrderList = supplyOrderList.subListOf(fromIndex, toIndex);
			supplyOrderList.setTotalCount(count);
			supplyOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderDelivery.setSupplyOrderList(supplyOrderList);
			return supplyOrderDelivery;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderList 
			= getSupplyOrderDAO().findSupplyOrderByDelivery(supplyOrderDelivery.getId(),start, rowsPerPage, options );
		supplyOrderList.setTotalCount(count);
		supplyOrderList.setCurrentPageNumber(currentPage);
		supplyOrderDelivery.setSupplyOrderList(supplyOrderList );	

		return supplyOrderDelivery;
	}			
		


	protected String getTableName(){
		return SupplyOrderDeliveryTable.TABLE_NAME;
	}
}


