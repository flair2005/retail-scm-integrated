
package com.skynet.retailscm.retailstorefranchising;

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

public class RetailStoreFranchisingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreFranchisingDAO{

		
	
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
	protected RetailStoreFranchising load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreFranchising(accessKey, options);
	}
	*/
	public RetailStoreFranchising load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreFranchising(RetailStoreFranchisingTable.withId(id), options);
	}
	
	
	
	public RetailStoreFranchising save(RetailStoreFranchising retailStoreFranchising,Map<String,Object> options){
		
		String methodName="save(RetailStoreFranchising retailStoreFranchising,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreFranchising, methodName, "retailStoreFranchising");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreFranchising(retailStoreFranchising,options);
	}
	public RetailStoreFranchising clone(String retailStoreFranchisingId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreFranchisingTable.withId(retailStoreFranchisingId),options);
	}
	
	protected RetailStoreFranchising clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreFranchisingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreFranchising newRetailStoreFranchising = loadInternalRetailStoreFranchising(accessKey, options);
		newRetailStoreFranchising.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreFranchising.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreFranchising(newRetailStoreFranchising,options);
		
		return newRetailStoreFranchising;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreFranchisingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreFranchisingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreFranchisingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreFranchisingNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreFranchisingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreFranchisingId, int version) throws Exception{
	
		String methodName="delete(String retailStoreFranchisingId, int version)";
		assertMethodArgumentNotNull(retailStoreFranchisingId, methodName, "retailStoreFranchisingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreFranchisingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreFranchisingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"comment"};
		return RetailStoreFranchisingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_franchising";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreFranchisingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_LIST = "retailStoreList";
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreFranchisingTokens.RETAIL_STORE_LIST);
		
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreFranchisingTokens.RETAIL_STORE_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreFranchisingMapper getRetailStoreFranchisingMapper(){
		return new RetailStoreFranchisingMapper();
	}
	protected RetailStoreFranchising extractRetailStoreFranchising(String retailStoreFranchisingId) throws Exception{
		String SQL = "select * from retail_store_franchising_data where id = ?";	
		try{
		
			RetailStoreFranchising retailStoreFranchising = queryForObject(SQL, new Object[]{retailStoreFranchisingId}, getRetailStoreFranchisingMapper());
			return retailStoreFranchising;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreFranchisingNotFoundException("RetailStoreFranchising("+retailStoreFranchisingId+") is not found!");
		}
		
		
	}
	protected RetailStoreFranchising extractRetailStoreFranchising(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_franchising_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreFranchising retailStoreFranchising = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreFranchisingMapper());
			return retailStoreFranchising;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreFranchisingNotFoundException("RetailStoreFranchising("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreFranchising loadInternalRetailStoreFranchising(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreFranchising retailStoreFranchising = extractRetailStoreFranchising(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreFranchising, loadOptions);
 		}		
		
		return retailStoreFranchising;
		
	}



	
	
	
		
	protected RetailStoreFranchising extractRetailStoreList(RetailStoreFranchising retailStoreFranchising, Map<String,Object> options){
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByFranchising(retailStoreFranchising.getId(),options);
		if(retailStoreList != null){
			retailStoreFranchising.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreFranchising;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreFranchising saveRetailStoreFranchising(RetailStoreFranchising  retailStoreFranchising){
	
		String SQL=this.getSaveRetailStoreFranchisingSQL(retailStoreFranchising);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreFranchisingParameters(retailStoreFranchising);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreFranchising.incVersion();
		return retailStoreFranchising;
	
	}
	public SmartList<RetailStoreFranchising> saveRetailStoreFranchisingList(SmartList<RetailStoreFranchising> retailStoreFranchisingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreFranchisingList(retailStoreFranchisingList);
		
		batchRetailStoreFranchisingCreate((List<RetailStoreFranchising>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreFranchisingUpdate((List<RetailStoreFranchising>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreFranchising retailStoreFranchising:retailStoreFranchisingList){
			if(retailStoreFranchising.isChanged()){
				retailStoreFranchising.incVersion();
			}
			
		
		}
		
		
		return retailStoreFranchisingList;
	}

	public SmartList<RetailStoreFranchising> removeRetailStoreFranchisingList(SmartList<RetailStoreFranchising> retailStoreFranchisingList,Map<String,Object> options){
		
		
		super.removeList(retailStoreFranchisingList, options);
		
		return retailStoreFranchisingList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreFranchisingBatchCreateArgs(List<RetailStoreFranchising> retailStoreFranchisingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreFranchising retailStoreFranchising:retailStoreFranchisingList ){
			Object [] parameters = prepareRetailStoreFranchisingCreateParameters(retailStoreFranchising);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreFranchisingBatchUpdateArgs(List<RetailStoreFranchising> retailStoreFranchisingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreFranchising retailStoreFranchising:retailStoreFranchisingList ){
			if(!retailStoreFranchising.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreFranchisingUpdateParameters(retailStoreFranchising);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreFranchisingCreate(List<RetailStoreFranchising> retailStoreFranchisingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreFranchisingBatchCreateArgs(retailStoreFranchisingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreFranchisingUpdate(List<RetailStoreFranchising> retailStoreFranchisingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreFranchisingBatchUpdateArgs(retailStoreFranchisingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreFranchisingList(List<RetailStoreFranchising> retailStoreFranchisingList){
		
		List<RetailStoreFranchising> retailStoreFranchisingCreateList=new ArrayList<RetailStoreFranchising>();
		List<RetailStoreFranchising> retailStoreFranchisingUpdateList=new ArrayList<RetailStoreFranchising>();
		
		for(RetailStoreFranchising retailStoreFranchising: retailStoreFranchisingList){
			if(isUpdateRequest(retailStoreFranchising)){
				retailStoreFranchisingUpdateList.add( retailStoreFranchising);
				continue;
			}
			retailStoreFranchisingCreateList.add(retailStoreFranchising);
		}
		
		return new Object[]{retailStoreFranchisingCreateList,retailStoreFranchisingUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreFranchising retailStoreFranchising){
 		return retailStoreFranchising.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreFranchisingSQL(RetailStoreFranchising retailStoreFranchising){
 		if(isUpdateRequest(retailStoreFranchising)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreFranchisingParameters(RetailStoreFranchising retailStoreFranchising){
 		if(isUpdateRequest(retailStoreFranchising) ){
 			return prepareRetailStoreFranchisingUpdateParameters(retailStoreFranchising);
 		}
 		return prepareRetailStoreFranchisingCreateParameters(retailStoreFranchising);
 	}
 	protected Object[] prepareRetailStoreFranchisingUpdateParameters(RetailStoreFranchising retailStoreFranchising){
 		Object[] parameters = new Object[3];
 
 		parameters[0] = retailStoreFranchising.getComment();		
 		parameters[1] = retailStoreFranchising.getId();
 		parameters[2] = retailStoreFranchising.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreFranchisingCreateParameters(RetailStoreFranchising retailStoreFranchising){
		Object[] parameters = new Object[2];
		String newRetailStoreFranchisingId=getNextId();
		retailStoreFranchising.setId(newRetailStoreFranchisingId);
		parameters[0] =  retailStoreFranchising.getId();
 
 		parameters[1] = retailStoreFranchising.getComment();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreFranchising saveInternalRetailStoreFranchising(RetailStoreFranchising retailStoreFranchising, Map<String,Object> options){
		
		saveRetailStoreFranchising(retailStoreFranchising);

		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreFranchising, options);
	 		removeRetailStoreList(retailStoreFranchising, options);
	 		
 		}		
		
		return retailStoreFranchising;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreFranchising saveRetailStoreList(RetailStoreFranchising retailStoreFranchising, Map<String,Object> options){
		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreFranchising;
		}
		if(retailStoreList.isEmpty()){
			return retailStoreFranchising;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreDAO().saveRetailStoreList(retailStoreList,options);
		
		return retailStoreFranchising;
	
	}
	
	protected RetailStoreFranchising removeRetailStoreList(RetailStoreFranchising retailStoreFranchising, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreFranchising;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreFranchising;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreFranchising;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreFranchising;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreFranchising present(RetailStoreFranchising retailStoreFranchising,Map<String, Object> options){
	
		presentRetailStoreList(retailStoreFranchising,options);

		return retailStoreFranchising;
	
	}
		
	
  	
 	protected RetailStoreFranchising presentRetailStoreList(
			RetailStoreFranchising retailStoreFranchising,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();		
		if(retailStoreList == null){
			return retailStoreFranchising;			
		}
		
		String targetObjectName = "retailStore";
		int retailStoreListSize = retailStoreList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreFranchising;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreListSize;
		if(retailStoreListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreDAO().countRetailStoreByFranchising(retailStoreFranchising.getId(), options);			
		}
		//retailStoreFranchising.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreFranchising.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreListSize,currentPage,rowsPerPage) ;
			retailStoreList = retailStoreList.subListOf(fromIndex, toIndex);
			retailStoreList.setTotalCount(count);
			retailStoreList.setCurrentPageNumber(currentPage);			
			retailStoreFranchising.setRetailStoreList(retailStoreList);
			return retailStoreFranchising;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreList 
			= getRetailStoreDAO().findRetailStoreByFranchising(retailStoreFranchising.getId(),start, rowsPerPage, options );
		retailStoreList.setTotalCount(count);
		retailStoreList.setCurrentPageNumber(currentPage);
		retailStoreFranchising.setRetailStoreList(retailStoreList );	

		return retailStoreFranchising;
	}			
		


	protected String getTableName(){
		return RetailStoreFranchisingTable.TABLE_NAME;
	}
}


