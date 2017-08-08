
package com.skynet.retailscm.supplyordershipment;

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

public class SupplyOrderShipmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderShipmentDAO{

		
	
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
	protected SupplyOrderShipment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderShipment(accessKey, options);
	}
	*/
	public SupplyOrderShipment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderShipment(SupplyOrderShipmentTable.withId(id), options);
	}
	
	
	
	public SupplyOrderShipment save(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options){
		
		String methodName="save(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderShipment, methodName, "supplyOrderShipment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderShipment(supplyOrderShipment,options);
	}
	public SupplyOrderShipment clone(String supplyOrderShipmentId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderShipmentTable.withId(supplyOrderShipmentId),options);
	}
	
	protected SupplyOrderShipment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderShipmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderShipment newSupplyOrderShipment = loadInternalSupplyOrderShipment(accessKey, options);
		newSupplyOrderShipment.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderShipment.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderShipment.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderShipment(newSupplyOrderShipment,options);
		
		return newSupplyOrderShipment;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderShipmentId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderShipmentId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderShipmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderShipmentNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderShipmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderShipmentId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderShipmentId, int version)";
		assertMethodArgumentNotNull(supplyOrderShipmentId, methodName, "supplyOrderShipmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderShipmentId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderShipmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","ship_time"};
		return SupplyOrderShipmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_shipment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderShipmentTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderShipmentTokens.CONSUMER_ORDER_LIST);
		
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderShipmentTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderShipmentTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderShipmentTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderShipmentMapper getSupplyOrderShipmentMapper(){
		return new SupplyOrderShipmentMapper();
	}
	protected SupplyOrderShipment extractSupplyOrderShipment(String supplyOrderShipmentId) throws Exception{
		String SQL = "select * from supply_order_shipment_data where id = ?";	
		try{
		
			SupplyOrderShipment supplyOrderShipment = queryForObject(SQL, new Object[]{supplyOrderShipmentId}, getSupplyOrderShipmentMapper());
			return supplyOrderShipment;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderShipmentNotFoundException("SupplyOrderShipment("+supplyOrderShipmentId+") is not found!");
		}
		
		
	}
	protected SupplyOrderShipment extractSupplyOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_shipment_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrderShipment supplyOrderShipment = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderShipmentMapper());
			return supplyOrderShipment;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderShipmentNotFoundException("SupplyOrderShipment("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrderShipment loadInternalSupplyOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderShipment supplyOrderShipment = extractSupplyOrderShipment(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderShipment, loadOptions);
 		}		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderShipment, loadOptions);
 		}		
		
		return supplyOrderShipment;
		
	}



	
	
	
		
	protected SupplyOrderShipment extractConsumerOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByShipment(supplyOrderShipment.getId(),options);
		if(consumerOrderList != null){
			supplyOrderShipment.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderShipment;
	
	}	
		
	protected SupplyOrderShipment extractSupplyOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByShipment(supplyOrderShipment.getId(),options);
		if(supplyOrderList != null){
			supplyOrderShipment.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderShipment;
	
	}	
		
		
 	
		
		
		

	

	protected SupplyOrderShipment saveSupplyOrderShipment(SupplyOrderShipment  supplyOrderShipment){
	
		String SQL=this.getSaveSupplyOrderShipmentSQL(supplyOrderShipment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderShipmentParameters(supplyOrderShipment);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderShipment.incVersion();
		return supplyOrderShipment;
	
	}
	public SmartList<SupplyOrderShipment> saveSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderShipmentList(supplyOrderShipmentList);
		
		batchSupplyOrderShipmentCreate((List<SupplyOrderShipment>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderShipmentUpdate((List<SupplyOrderShipment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderShipment supplyOrderShipment:supplyOrderShipmentList){
			if(supplyOrderShipment.isChanged()){
				supplyOrderShipment.incVersion();
			}
			
		
		}
		
		
		return supplyOrderShipmentList;
	}

	public SmartList<SupplyOrderShipment> removeSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderShipmentList, options);
		
		return supplyOrderShipmentList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderShipmentBatchCreateArgs(List<SupplyOrderShipment> supplyOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderShipment supplyOrderShipment:supplyOrderShipmentList ){
			Object [] parameters = prepareSupplyOrderShipmentCreateParameters(supplyOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderShipmentBatchUpdateArgs(List<SupplyOrderShipment> supplyOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderShipment supplyOrderShipment:supplyOrderShipmentList ){
			if(!supplyOrderShipment.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderShipmentUpdateParameters(supplyOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderShipmentCreate(List<SupplyOrderShipment> supplyOrderShipmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderShipmentBatchCreateArgs(supplyOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderShipmentUpdate(List<SupplyOrderShipment> supplyOrderShipmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderShipmentBatchUpdateArgs(supplyOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderShipmentList(List<SupplyOrderShipment> supplyOrderShipmentList){
		
		List<SupplyOrderShipment> supplyOrderShipmentCreateList=new ArrayList<SupplyOrderShipment>();
		List<SupplyOrderShipment> supplyOrderShipmentUpdateList=new ArrayList<SupplyOrderShipment>();
		
		for(SupplyOrderShipment supplyOrderShipment: supplyOrderShipmentList){
			if(isUpdateRequest(supplyOrderShipment)){
				supplyOrderShipmentUpdateList.add( supplyOrderShipment);
				continue;
			}
			supplyOrderShipmentCreateList.add(supplyOrderShipment);
		}
		
		return new Object[]{supplyOrderShipmentCreateList,supplyOrderShipmentUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderShipment supplyOrderShipment){
 		return supplyOrderShipment.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderShipmentSQL(SupplyOrderShipment supplyOrderShipment){
 		if(isUpdateRequest(supplyOrderShipment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderShipmentParameters(SupplyOrderShipment supplyOrderShipment){
 		if(isUpdateRequest(supplyOrderShipment) ){
 			return prepareSupplyOrderShipmentUpdateParameters(supplyOrderShipment);
 		}
 		return prepareSupplyOrderShipmentCreateParameters(supplyOrderShipment);
 	}
 	protected Object[] prepareSupplyOrderShipmentUpdateParameters(SupplyOrderShipment supplyOrderShipment){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = supplyOrderShipment.getWho();
 		parameters[1] = supplyOrderShipment.getShipTime();		
 		parameters[2] = supplyOrderShipment.getId();
 		parameters[3] = supplyOrderShipment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderShipmentCreateParameters(SupplyOrderShipment supplyOrderShipment){
		Object[] parameters = new Object[3];
		String newSupplyOrderShipmentId=getNextId();
		supplyOrderShipment.setId(newSupplyOrderShipmentId);
		parameters[0] =  supplyOrderShipment.getId();
 
 		parameters[1] = supplyOrderShipment.getWho();
 		parameters[2] = supplyOrderShipment.getShipTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderShipment saveInternalSupplyOrderShipment(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		saveSupplyOrderShipment(supplyOrderShipment);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderShipment, options);
	 		removeConsumerOrderList(supplyOrderShipment, options);
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderShipment, options);
	 		removeSupplyOrderList(supplyOrderShipment, options);
	 		
 		}		
		
		return supplyOrderShipment;
		
	}
	
	
	
	//======================================================================================
	
		
	protected SupplyOrderShipment saveConsumerOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderShipment;
		}
		if(consumerOrderList.isEmpty()){
			return supplyOrderShipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderDAO().saveConsumerOrderList(consumerOrderList,options);
		
		return supplyOrderShipment;
	
	}
	
	protected SupplyOrderShipment removeConsumerOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderShipment;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderShipment;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderShipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderShipment;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected SupplyOrderShipment saveSupplyOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderShipment;
		}
		if(supplyOrderList.isEmpty()){
			return supplyOrderShipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderDAO().saveSupplyOrderList(supplyOrderList,options);
		
		return supplyOrderShipment;
	
	}
	
	protected SupplyOrderShipment removeSupplyOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderShipment;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderShipment;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderShipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderShipment;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SupplyOrderShipment present(SupplyOrderShipment supplyOrderShipment,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderShipment,options);
		presentSupplyOrderList(supplyOrderShipment,options);

		return supplyOrderShipment;
	
	}
		
	
  	
 	protected SupplyOrderShipment presentConsumerOrderList(
			SupplyOrderShipment supplyOrderShipment,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();		
		if(consumerOrderList == null){
			return supplyOrderShipment;			
		}
		
		String targetObjectName = "consumerOrder";
		int consumerOrderListSize = consumerOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderShipment;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderListSize;
		if(consumerOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderDAO().countConsumerOrderByShipment(supplyOrderShipment.getId(), options);			
		}
		//supplyOrderShipment.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderShipment.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderListSize,currentPage,rowsPerPage) ;
			consumerOrderList = consumerOrderList.subListOf(fromIndex, toIndex);
			consumerOrderList.setTotalCount(count);
			consumerOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderShipment.setConsumerOrderList(consumerOrderList);
			return supplyOrderShipment;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderList 
			= getConsumerOrderDAO().findConsumerOrderByShipment(supplyOrderShipment.getId(),start, rowsPerPage, options );
		consumerOrderList.setTotalCount(count);
		consumerOrderList.setCurrentPageNumber(currentPage);
		supplyOrderShipment.setConsumerOrderList(consumerOrderList );	

		return supplyOrderShipment;
	}			
		
	
  	
 	protected SupplyOrderShipment presentSupplyOrderList(
			SupplyOrderShipment supplyOrderShipment,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();		
		if(supplyOrderList == null){
			return supplyOrderShipment;			
		}
		
		String targetObjectName = "supplyOrder";
		int supplyOrderListSize = supplyOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderShipment;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderListSize;
		if(supplyOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderDAO().countSupplyOrderByShipment(supplyOrderShipment.getId(), options);			
		}
		//supplyOrderShipment.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderShipment.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderListSize,currentPage,rowsPerPage) ;
			supplyOrderList = supplyOrderList.subListOf(fromIndex, toIndex);
			supplyOrderList.setTotalCount(count);
			supplyOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderShipment.setSupplyOrderList(supplyOrderList);
			return supplyOrderShipment;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderList 
			= getSupplyOrderDAO().findSupplyOrderByShipment(supplyOrderShipment.getId(),start, rowsPerPage, options );
		supplyOrderList.setTotalCount(count);
		supplyOrderList.setCurrentPageNumber(currentPage);
		supplyOrderShipment.setSupplyOrderList(supplyOrderList );	

		return supplyOrderShipment;
	}			
		


	protected String getTableName(){
		return SupplyOrderShipmentTable.TABLE_NAME;
	}
}


