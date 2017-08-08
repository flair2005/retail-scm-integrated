
package com.skynet.retailscm.retailstoreclosing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstore.RetailStore;

import com.skynet.retailscm.retailstore.RetailStoreDAO;

import com.skynet.retailscm.retailstore.RetailStoreTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreClosingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreClosingDAO{

		
	
  	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO pRetailStoreDAO){
 	
 		if(pRetailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = pRetailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The retailStoreDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreClosing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreClosing(accessKey, options);
	}
	*/
	public RetailStoreClosing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreClosing(RetailStoreClosingTable.withId(id), options);
	}
	
	
	
	public RetailStoreClosing save(RetailStoreClosing retailStoreClosing,Map<String,Object> options){
		
		String methodName="save(RetailStoreClosing retailStoreClosing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreClosing, methodName, "retailStoreClosing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreClosing(retailStoreClosing,options);
	}
	public RetailStoreClosing clone(String retailStoreClosingId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreClosingTable.withId(retailStoreClosingId),options);
	}
	
	protected RetailStoreClosing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreClosingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreClosing newRetailStoreClosing = loadInternalRetailStoreClosing(accessKey, options);
		newRetailStoreClosing.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreClosing.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreClosing(newRetailStoreClosing,options);
		
		return newRetailStoreClosing;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreClosingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreClosingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreClosingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreClosingNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreClosingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreClosingId, int version) throws Exception{
	
		String methodName="delete(String retailStoreClosingId, int version)";
		assertMethodArgumentNotNull(retailStoreClosingId, methodName, "retailStoreClosingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreClosingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreClosingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"comment"};
		return RetailStoreClosingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_closing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreClosingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_LIST = "retailStoreList";
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreClosingTokens.RETAIL_STORE_LIST);
		
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreClosingTokens.RETAIL_STORE_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreClosingMapper getRetailStoreClosingMapper(){
		return new RetailStoreClosingMapper();
	}
	protected RetailStoreClosing extractRetailStoreClosing(String retailStoreClosingId) throws Exception{
		String SQL = "select * from retail_store_closing_data where id = ?";	
		try{
		
			RetailStoreClosing retailStoreClosing = queryForObject(SQL, new Object[]{retailStoreClosingId}, getRetailStoreClosingMapper());
			return retailStoreClosing;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreClosingNotFoundException("RetailStoreClosing("+retailStoreClosingId+") is not found!");
		}
		
		
	}
	protected RetailStoreClosing extractRetailStoreClosing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_closing_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreClosing retailStoreClosing = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreClosingMapper());
			return retailStoreClosing;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreClosingNotFoundException("RetailStoreClosing("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreClosing loadInternalRetailStoreClosing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreClosing retailStoreClosing = extractRetailStoreClosing(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreClosing, loadOptions);
 		}		
		
		return retailStoreClosing;
		
	}



	
	
	
		
	protected RetailStoreClosing extractRetailStoreList(RetailStoreClosing retailStoreClosing, Map<String,Object> options){
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByClosing(retailStoreClosing.getId(),options);
		if(retailStoreList != null){
			retailStoreClosing.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreClosing;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreClosing saveRetailStoreClosing(RetailStoreClosing  retailStoreClosing){
	
		String SQL=this.getSaveRetailStoreClosingSQL(retailStoreClosing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreClosingParameters(retailStoreClosing);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreClosing.incVersion();
		return retailStoreClosing;
	
	}
	public SmartList<RetailStoreClosing> saveRetailStoreClosingList(SmartList<RetailStoreClosing> retailStoreClosingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreClosingList(retailStoreClosingList);
		
		batchRetailStoreClosingCreate((List<RetailStoreClosing>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreClosingUpdate((List<RetailStoreClosing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreClosing retailStoreClosing:retailStoreClosingList){
			if(retailStoreClosing.isChanged()){
				retailStoreClosing.incVersion();
			}
			
		
		}
		
		
		return retailStoreClosingList;
	}

	public SmartList<RetailStoreClosing> removeRetailStoreClosingList(SmartList<RetailStoreClosing> retailStoreClosingList,Map<String,Object> options){
		
		
		super.removeList(retailStoreClosingList, options);
		
		return retailStoreClosingList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreClosingBatchCreateArgs(List<RetailStoreClosing> retailStoreClosingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreClosing retailStoreClosing:retailStoreClosingList ){
			Object [] parameters = prepareRetailStoreClosingCreateParameters(retailStoreClosing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreClosingBatchUpdateArgs(List<RetailStoreClosing> retailStoreClosingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreClosing retailStoreClosing:retailStoreClosingList ){
			if(!retailStoreClosing.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreClosingUpdateParameters(retailStoreClosing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreClosingCreate(List<RetailStoreClosing> retailStoreClosingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreClosingBatchCreateArgs(retailStoreClosingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreClosingUpdate(List<RetailStoreClosing> retailStoreClosingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreClosingBatchUpdateArgs(retailStoreClosingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreClosingList(List<RetailStoreClosing> retailStoreClosingList){
		
		List<RetailStoreClosing> retailStoreClosingCreateList=new ArrayList<RetailStoreClosing>();
		List<RetailStoreClosing> retailStoreClosingUpdateList=new ArrayList<RetailStoreClosing>();
		
		for(RetailStoreClosing retailStoreClosing: retailStoreClosingList){
			if(isUpdateRequest(retailStoreClosing)){
				retailStoreClosingUpdateList.add( retailStoreClosing);
				continue;
			}
			retailStoreClosingCreateList.add(retailStoreClosing);
		}
		
		return new Object[]{retailStoreClosingCreateList,retailStoreClosingUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreClosing retailStoreClosing){
 		return retailStoreClosing.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreClosingSQL(RetailStoreClosing retailStoreClosing){
 		if(isUpdateRequest(retailStoreClosing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreClosingParameters(RetailStoreClosing retailStoreClosing){
 		if(isUpdateRequest(retailStoreClosing) ){
 			return prepareRetailStoreClosingUpdateParameters(retailStoreClosing);
 		}
 		return prepareRetailStoreClosingCreateParameters(retailStoreClosing);
 	}
 	protected Object[] prepareRetailStoreClosingUpdateParameters(RetailStoreClosing retailStoreClosing){
 		Object[] parameters = new Object[3];
 
 		parameters[0] = retailStoreClosing.getComment();		
 		parameters[1] = retailStoreClosing.getId();
 		parameters[2] = retailStoreClosing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreClosingCreateParameters(RetailStoreClosing retailStoreClosing){
		Object[] parameters = new Object[2];
		String newRetailStoreClosingId=getNextId();
		retailStoreClosing.setId(newRetailStoreClosingId);
		parameters[0] =  retailStoreClosing.getId();
 
 		parameters[1] = retailStoreClosing.getComment();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreClosing saveInternalRetailStoreClosing(RetailStoreClosing retailStoreClosing, Map<String,Object> options){
		
		saveRetailStoreClosing(retailStoreClosing);

		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreClosing, options);
	 		removeRetailStoreList(retailStoreClosing, options);
	 		
 		}		
		
		return retailStoreClosing;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreClosing saveRetailStoreList(RetailStoreClosing retailStoreClosing, Map<String,Object> options){
		SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreClosing;
		}
		if(retailStoreList.isEmpty()){
			return retailStoreClosing;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreDAO().saveRetailStoreList(retailStoreList,options);
		
		return retailStoreClosing;
	
	}
	
	protected RetailStoreClosing removeRetailStoreList(RetailStoreClosing retailStoreClosing, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreClosing;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreClosing;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreClosing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreClosing;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreClosing present(RetailStoreClosing retailStoreClosing,Map<String, Object> options){
	
		presentRetailStoreList(retailStoreClosing,options);

		return retailStoreClosing;
	
	}
		
	
  	
 	protected RetailStoreClosing presentRetailStoreList(
			RetailStoreClosing retailStoreClosing,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreClosing.getRetailStoreList();		
		if(retailStoreList == null){
			return retailStoreClosing;			
		}
		
		String targetObjectName = "retailStore";
		int retailStoreListSize = retailStoreList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreClosing;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreListSize;
		if(retailStoreListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreDAO().countRetailStoreByClosing(retailStoreClosing.getId(), options);			
		}
		//retailStoreClosing.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreClosing.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreListSize,currentPage,rowsPerPage) ;
			retailStoreList = retailStoreList.subListOf(fromIndex, toIndex);
			retailStoreList.setTotalCount(count);
			retailStoreList.setCurrentPageNumber(currentPage);			
			retailStoreClosing.setRetailStoreList(retailStoreList);
			return retailStoreClosing;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreList 
			= getRetailStoreDAO().findRetailStoreByClosing(retailStoreClosing.getId(),start, rowsPerPage, options );
		retailStoreList.setTotalCount(count);
		retailStoreList.setCurrentPageNumber(currentPage);
		retailStoreClosing.setRetailStoreList(retailStoreList );	

		return retailStoreClosing;
	}			
		


	protected String getTableName(){
		return RetailStoreClosingTable.TABLE_NAME;
	}
}


