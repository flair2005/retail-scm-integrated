
package com.skynet.retailscm.supplyorderconfirmation;

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

public class SupplyOrderConfirmationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderConfirmationDAO{

		
	
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
	protected SupplyOrderConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderConfirmation(accessKey, options);
	}
	*/
	public SupplyOrderConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderConfirmation(SupplyOrderConfirmationTable.withId(id), options);
	}
	
	
	
	public SupplyOrderConfirmation save(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options){
		
		String methodName="save(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderConfirmation, methodName, "supplyOrderConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderConfirmation(supplyOrderConfirmation,options);
	}
	public SupplyOrderConfirmation clone(String supplyOrderConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderConfirmationTable.withId(supplyOrderConfirmationId),options);
	}
	
	protected SupplyOrderConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderConfirmation newSupplyOrderConfirmation = loadInternalSupplyOrderConfirmation(accessKey, options);
		newSupplyOrderConfirmation.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderConfirmation.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderConfirmation.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderConfirmation(newSupplyOrderConfirmation,options);
		
		return newSupplyOrderConfirmation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderConfirmationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderConfirmationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderConfirmationId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderConfirmationId, int version)";
		assertMethodArgumentNotNull(supplyOrderConfirmationId, methodName, "supplyOrderConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderConfirmationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderConfirmationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","confirm_time"};
		return SupplyOrderConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_confirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderConfirmationTokens.CONSUMER_ORDER_LIST);
		
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderConfirmationTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderConfirmationTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderConfirmationTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderConfirmationMapper getSupplyOrderConfirmationMapper(){
		return new SupplyOrderConfirmationMapper();
	}
	protected SupplyOrderConfirmation extractSupplyOrderConfirmation(String supplyOrderConfirmationId) throws Exception{
		String SQL = "select * from supply_order_confirmation_data where id = ?";	
		try{
		
			SupplyOrderConfirmation supplyOrderConfirmation = queryForObject(SQL, new Object[]{supplyOrderConfirmationId}, getSupplyOrderConfirmationMapper());
			return supplyOrderConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderConfirmationNotFoundException("SupplyOrderConfirmation("+supplyOrderConfirmationId+") is not found!");
		}
		
		
	}
	protected SupplyOrderConfirmation extractSupplyOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_confirmation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrderConfirmation supplyOrderConfirmation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderConfirmationMapper());
			return supplyOrderConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderConfirmationNotFoundException("SupplyOrderConfirmation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrderConfirmation loadInternalSupplyOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderConfirmation supplyOrderConfirmation = extractSupplyOrderConfirmation(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderConfirmation, loadOptions);
 		}		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderConfirmation, loadOptions);
 		}		
		
		return supplyOrderConfirmation;
		
	}



	
	
	
		
	protected SupplyOrderConfirmation extractConsumerOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByConfirmation(supplyOrderConfirmation.getId(),options);
		if(consumerOrderList != null){
			supplyOrderConfirmation.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderConfirmation;
	
	}	
		
	protected SupplyOrderConfirmation extractSupplyOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByConfirmation(supplyOrderConfirmation.getId(),options);
		if(supplyOrderList != null){
			supplyOrderConfirmation.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderConfirmation;
	
	}	
		
		
 	
		
		
		

	

	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(SupplyOrderConfirmation  supplyOrderConfirmation){
	
		String SQL=this.getSaveSupplyOrderConfirmationSQL(supplyOrderConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderConfirmationParameters(supplyOrderConfirmation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderConfirmation.incVersion();
		return supplyOrderConfirmation;
	
	}
	public SmartList<SupplyOrderConfirmation> saveSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderConfirmationList(supplyOrderConfirmationList);
		
		batchSupplyOrderConfirmationCreate((List<SupplyOrderConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderConfirmationUpdate((List<SupplyOrderConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderConfirmation supplyOrderConfirmation:supplyOrderConfirmationList){
			if(supplyOrderConfirmation.isChanged()){
				supplyOrderConfirmation.incVersion();
			}
			
		
		}
		
		
		return supplyOrderConfirmationList;
	}

	public SmartList<SupplyOrderConfirmation> removeSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderConfirmationList, options);
		
		return supplyOrderConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderConfirmationBatchCreateArgs(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderConfirmation supplyOrderConfirmation:supplyOrderConfirmationList ){
			Object [] parameters = prepareSupplyOrderConfirmationCreateParameters(supplyOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderConfirmationBatchUpdateArgs(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderConfirmation supplyOrderConfirmation:supplyOrderConfirmationList ){
			if(!supplyOrderConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderConfirmationUpdateParameters(supplyOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderConfirmationCreate(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderConfirmationBatchCreateArgs(supplyOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderConfirmationUpdate(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderConfirmationBatchUpdateArgs(supplyOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderConfirmationList(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		
		List<SupplyOrderConfirmation> supplyOrderConfirmationCreateList=new ArrayList<SupplyOrderConfirmation>();
		List<SupplyOrderConfirmation> supplyOrderConfirmationUpdateList=new ArrayList<SupplyOrderConfirmation>();
		
		for(SupplyOrderConfirmation supplyOrderConfirmation: supplyOrderConfirmationList){
			if(isUpdateRequest(supplyOrderConfirmation)){
				supplyOrderConfirmationUpdateList.add( supplyOrderConfirmation);
				continue;
			}
			supplyOrderConfirmationCreateList.add(supplyOrderConfirmation);
		}
		
		return new Object[]{supplyOrderConfirmationCreateList,supplyOrderConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderConfirmation supplyOrderConfirmation){
 		return supplyOrderConfirmation.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderConfirmationSQL(SupplyOrderConfirmation supplyOrderConfirmation){
 		if(isUpdateRequest(supplyOrderConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderConfirmationParameters(SupplyOrderConfirmation supplyOrderConfirmation){
 		if(isUpdateRequest(supplyOrderConfirmation) ){
 			return prepareSupplyOrderConfirmationUpdateParameters(supplyOrderConfirmation);
 		}
 		return prepareSupplyOrderConfirmationCreateParameters(supplyOrderConfirmation);
 	}
 	protected Object[] prepareSupplyOrderConfirmationUpdateParameters(SupplyOrderConfirmation supplyOrderConfirmation){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = supplyOrderConfirmation.getWho();
 		parameters[1] = supplyOrderConfirmation.getConfirmTime();		
 		parameters[2] = supplyOrderConfirmation.getId();
 		parameters[3] = supplyOrderConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderConfirmationCreateParameters(SupplyOrderConfirmation supplyOrderConfirmation){
		Object[] parameters = new Object[3];
		String newSupplyOrderConfirmationId=getNextId();
		supplyOrderConfirmation.setId(newSupplyOrderConfirmationId);
		parameters[0] =  supplyOrderConfirmation.getId();
 
 		parameters[1] = supplyOrderConfirmation.getWho();
 		parameters[2] = supplyOrderConfirmation.getConfirmTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderConfirmation saveInternalSupplyOrderConfirmation(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		
		saveSupplyOrderConfirmation(supplyOrderConfirmation);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderConfirmation, options);
	 		removeConsumerOrderList(supplyOrderConfirmation, options);
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderConfirmation, options);
	 		removeSupplyOrderList(supplyOrderConfirmation, options);
	 		
 		}		
		
		return supplyOrderConfirmation;
		
	}
	
	
	
	//======================================================================================
	
		
	protected SupplyOrderConfirmation saveConsumerOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderConfirmation.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderConfirmation;
		}
		if(consumerOrderList.isEmpty()){
			return supplyOrderConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderDAO().saveConsumerOrderList(consumerOrderList,options);
		
		return supplyOrderConfirmation;
	
	}
	
	protected SupplyOrderConfirmation removeConsumerOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderConfirmation.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderConfirmation;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderConfirmation;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderConfirmation;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected SupplyOrderConfirmation saveSupplyOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		SmartList<SupplyOrder> supplyOrderList = supplyOrderConfirmation.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderConfirmation;
		}
		if(supplyOrderList.isEmpty()){
			return supplyOrderConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderDAO().saveSupplyOrderList(supplyOrderList,options);
		
		return supplyOrderConfirmation;
	
	}
	
	protected SupplyOrderConfirmation removeSupplyOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderConfirmation.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderConfirmation;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderConfirmation;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderConfirmation;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SupplyOrderConfirmation present(SupplyOrderConfirmation supplyOrderConfirmation,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderConfirmation,options);
		presentSupplyOrderList(supplyOrderConfirmation,options);

		return supplyOrderConfirmation;
	
	}
		
	
  	
 	protected SupplyOrderConfirmation presentConsumerOrderList(
			SupplyOrderConfirmation supplyOrderConfirmation,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderConfirmation.getConsumerOrderList();		
		if(consumerOrderList == null){
			return supplyOrderConfirmation;			
		}
		
		String targetObjectName = "consumerOrder";
		int consumerOrderListSize = consumerOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderConfirmation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderListSize;
		if(consumerOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderDAO().countConsumerOrderByConfirmation(supplyOrderConfirmation.getId(), options);			
		}
		//supplyOrderConfirmation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderConfirmation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderListSize,currentPage,rowsPerPage) ;
			consumerOrderList = consumerOrderList.subListOf(fromIndex, toIndex);
			consumerOrderList.setTotalCount(count);
			consumerOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderConfirmation.setConsumerOrderList(consumerOrderList);
			return supplyOrderConfirmation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderList 
			= getConsumerOrderDAO().findConsumerOrderByConfirmation(supplyOrderConfirmation.getId(),start, rowsPerPage, options );
		consumerOrderList.setTotalCount(count);
		consumerOrderList.setCurrentPageNumber(currentPage);
		supplyOrderConfirmation.setConsumerOrderList(consumerOrderList );	

		return supplyOrderConfirmation;
	}			
		
	
  	
 	protected SupplyOrderConfirmation presentSupplyOrderList(
			SupplyOrderConfirmation supplyOrderConfirmation,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderConfirmation.getSupplyOrderList();		
		if(supplyOrderList == null){
			return supplyOrderConfirmation;			
		}
		
		String targetObjectName = "supplyOrder";
		int supplyOrderListSize = supplyOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrderConfirmation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderListSize;
		if(supplyOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderDAO().countSupplyOrderByConfirmation(supplyOrderConfirmation.getId(), options);			
		}
		//supplyOrderConfirmation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrderConfirmation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderListSize,currentPage,rowsPerPage) ;
			supplyOrderList = supplyOrderList.subListOf(fromIndex, toIndex);
			supplyOrderList.setTotalCount(count);
			supplyOrderList.setCurrentPageNumber(currentPage);			
			supplyOrderConfirmation.setSupplyOrderList(supplyOrderList);
			return supplyOrderConfirmation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderList 
			= getSupplyOrderDAO().findSupplyOrderByConfirmation(supplyOrderConfirmation.getId(),start, rowsPerPage, options );
		supplyOrderList.setTotalCount(count);
		supplyOrderList.setCurrentPageNumber(currentPage);
		supplyOrderConfirmation.setSupplyOrderList(supplyOrderList );	

		return supplyOrderConfirmation;
	}			
		


	protected String getTableName(){
		return SupplyOrderConfirmationTable.TABLE_NAME;
	}
}


