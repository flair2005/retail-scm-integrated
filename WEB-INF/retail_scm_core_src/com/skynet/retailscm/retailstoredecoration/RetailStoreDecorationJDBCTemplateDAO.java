
package com.skynet.retailscm.retailstoredecoration;

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

public class RetailStoreDecorationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreDecorationDAO{

		
	
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
	protected RetailStoreDecoration load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreDecoration(accessKey, options);
	}
	*/
	public RetailStoreDecoration load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreDecoration(RetailStoreDecorationTable.withId(id), options);
	}
	
	
	
	public RetailStoreDecoration save(RetailStoreDecoration retailStoreDecoration,Map<String,Object> options){
		
		String methodName="save(RetailStoreDecoration retailStoreDecoration,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreDecoration, methodName, "retailStoreDecoration");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreDecoration(retailStoreDecoration,options);
	}
	public RetailStoreDecoration clone(String retailStoreDecorationId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreDecorationTable.withId(retailStoreDecorationId),options);
	}
	
	protected RetailStoreDecoration clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreDecorationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreDecoration newRetailStoreDecoration = loadInternalRetailStoreDecoration(accessKey, options);
		newRetailStoreDecoration.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreDecoration.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreDecoration(newRetailStoreDecoration,options);
		
		return newRetailStoreDecoration;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreDecorationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreDecorationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreDecorationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreDecorationNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreDecorationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreDecorationId, int version) throws Exception{
	
		String methodName="delete(String retailStoreDecorationId, int version)";
		assertMethodArgumentNotNull(retailStoreDecorationId, methodName, "retailStoreDecorationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreDecorationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreDecorationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"comment"};
		return RetailStoreDecorationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_decoration";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreDecorationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_LIST = "retailStoreList";
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreDecorationTokens.RETAIL_STORE_LIST);
		
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreDecorationTokens.RETAIL_STORE_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreDecorationMapper getRetailStoreDecorationMapper(){
		return new RetailStoreDecorationMapper();
	}
	protected RetailStoreDecoration extractRetailStoreDecoration(String retailStoreDecorationId) throws Exception{
		String SQL = "select * from retail_store_decoration_data where id = ?";	
		try{
		
			RetailStoreDecoration retailStoreDecoration = queryForObject(SQL, new Object[]{retailStoreDecorationId}, getRetailStoreDecorationMapper());
			return retailStoreDecoration;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreDecorationNotFoundException("RetailStoreDecoration("+retailStoreDecorationId+") is not found!");
		}
		
		
	}
	protected RetailStoreDecoration extractRetailStoreDecoration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_decoration_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreDecoration retailStoreDecoration = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreDecorationMapper());
			return retailStoreDecoration;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreDecorationNotFoundException("RetailStoreDecoration("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreDecoration loadInternalRetailStoreDecoration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreDecoration retailStoreDecoration = extractRetailStoreDecoration(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreDecoration, loadOptions);
 		}		
		
		return retailStoreDecoration;
		
	}



	
	
	
		
	protected RetailStoreDecoration extractRetailStoreList(RetailStoreDecoration retailStoreDecoration, Map<String,Object> options){
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByDecoration(retailStoreDecoration.getId(),options);
		if(retailStoreList != null){
			retailStoreDecoration.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreDecoration;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreDecoration saveRetailStoreDecoration(RetailStoreDecoration  retailStoreDecoration){
	
		String SQL=this.getSaveRetailStoreDecorationSQL(retailStoreDecoration);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreDecorationParameters(retailStoreDecoration);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreDecoration.incVersion();
		return retailStoreDecoration;
	
	}
	public SmartList<RetailStoreDecoration> saveRetailStoreDecorationList(SmartList<RetailStoreDecoration> retailStoreDecorationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreDecorationList(retailStoreDecorationList);
		
		batchRetailStoreDecorationCreate((List<RetailStoreDecoration>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreDecorationUpdate((List<RetailStoreDecoration>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreDecoration retailStoreDecoration:retailStoreDecorationList){
			if(retailStoreDecoration.isChanged()){
				retailStoreDecoration.incVersion();
			}
			
		
		}
		
		
		return retailStoreDecorationList;
	}

	public SmartList<RetailStoreDecoration> removeRetailStoreDecorationList(SmartList<RetailStoreDecoration> retailStoreDecorationList,Map<String,Object> options){
		
		
		super.removeList(retailStoreDecorationList, options);
		
		return retailStoreDecorationList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreDecorationBatchCreateArgs(List<RetailStoreDecoration> retailStoreDecorationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreDecoration retailStoreDecoration:retailStoreDecorationList ){
			Object [] parameters = prepareRetailStoreDecorationCreateParameters(retailStoreDecoration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreDecorationBatchUpdateArgs(List<RetailStoreDecoration> retailStoreDecorationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreDecoration retailStoreDecoration:retailStoreDecorationList ){
			if(!retailStoreDecoration.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreDecorationUpdateParameters(retailStoreDecoration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreDecorationCreate(List<RetailStoreDecoration> retailStoreDecorationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreDecorationBatchCreateArgs(retailStoreDecorationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreDecorationUpdate(List<RetailStoreDecoration> retailStoreDecorationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreDecorationBatchUpdateArgs(retailStoreDecorationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreDecorationList(List<RetailStoreDecoration> retailStoreDecorationList){
		
		List<RetailStoreDecoration> retailStoreDecorationCreateList=new ArrayList<RetailStoreDecoration>();
		List<RetailStoreDecoration> retailStoreDecorationUpdateList=new ArrayList<RetailStoreDecoration>();
		
		for(RetailStoreDecoration retailStoreDecoration: retailStoreDecorationList){
			if(isUpdateRequest(retailStoreDecoration)){
				retailStoreDecorationUpdateList.add( retailStoreDecoration);
				continue;
			}
			retailStoreDecorationCreateList.add(retailStoreDecoration);
		}
		
		return new Object[]{retailStoreDecorationCreateList,retailStoreDecorationUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreDecoration retailStoreDecoration){
 		return retailStoreDecoration.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreDecorationSQL(RetailStoreDecoration retailStoreDecoration){
 		if(isUpdateRequest(retailStoreDecoration)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreDecorationParameters(RetailStoreDecoration retailStoreDecoration){
 		if(isUpdateRequest(retailStoreDecoration) ){
 			return prepareRetailStoreDecorationUpdateParameters(retailStoreDecoration);
 		}
 		return prepareRetailStoreDecorationCreateParameters(retailStoreDecoration);
 	}
 	protected Object[] prepareRetailStoreDecorationUpdateParameters(RetailStoreDecoration retailStoreDecoration){
 		Object[] parameters = new Object[3];
 
 		parameters[0] = retailStoreDecoration.getComment();		
 		parameters[1] = retailStoreDecoration.getId();
 		parameters[2] = retailStoreDecoration.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreDecorationCreateParameters(RetailStoreDecoration retailStoreDecoration){
		Object[] parameters = new Object[2];
		String newRetailStoreDecorationId=getNextId();
		retailStoreDecoration.setId(newRetailStoreDecorationId);
		parameters[0] =  retailStoreDecoration.getId();
 
 		parameters[1] = retailStoreDecoration.getComment();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreDecoration saveInternalRetailStoreDecoration(RetailStoreDecoration retailStoreDecoration, Map<String,Object> options){
		
		saveRetailStoreDecoration(retailStoreDecoration);

		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreDecoration, options);
	 		removeRetailStoreList(retailStoreDecoration, options);
	 		
 		}		
		
		return retailStoreDecoration;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreDecoration saveRetailStoreList(RetailStoreDecoration retailStoreDecoration, Map<String,Object> options){
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreDecoration;
		}
		if(retailStoreList.isEmpty()){
			return retailStoreDecoration;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreDAO().saveRetailStoreList(retailStoreList,options);
		
		return retailStoreDecoration;
	
	}
	
	protected RetailStoreDecoration removeRetailStoreList(RetailStoreDecoration retailStoreDecoration, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreDecoration;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreDecoration;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreDecoration;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreDecoration present(RetailStoreDecoration retailStoreDecoration,Map<String, Object> options){
	
		presentRetailStoreList(retailStoreDecoration,options);

		return retailStoreDecoration;
	
	}
		
	
  	
 	protected RetailStoreDecoration presentRetailStoreList(
			RetailStoreDecoration retailStoreDecoration,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
		if(retailStoreList == null){
			return retailStoreDecoration;			
		}
		
		String targetObjectName = "retailStore";
		int retailStoreListSize = retailStoreList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreDecoration;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreListSize;
		if(retailStoreListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreDAO().countRetailStoreByDecoration(retailStoreDecoration.getId(), options);			
		}
		//retailStoreDecoration.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreDecoration.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreListSize,currentPage,rowsPerPage) ;
			retailStoreList = retailStoreList.subListOf(fromIndex, toIndex);
			retailStoreList.setTotalCount(count);
			retailStoreList.setCurrentPageNumber(currentPage);			
			retailStoreDecoration.setRetailStoreList(retailStoreList);
			return retailStoreDecoration;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreList 
			= getRetailStoreDAO().findRetailStoreByDecoration(retailStoreDecoration.getId(),start, rowsPerPage, options );
		retailStoreList.setTotalCount(count);
		retailStoreList.setCurrentPageNumber(currentPage);
		retailStoreDecoration.setRetailStoreList(retailStoreList );	

		return retailStoreDecoration;
	}			
		


	protected String getTableName(){
		return RetailStoreDecorationTable.TABLE_NAME;
	}
}


