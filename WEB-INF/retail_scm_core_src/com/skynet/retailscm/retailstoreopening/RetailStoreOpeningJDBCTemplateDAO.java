
package com.skynet.retailscm.retailstoreopening;

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

public class RetailStoreOpeningJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOpeningDAO{

		
	
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
	protected RetailStoreOpening load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOpening(accessKey, options);
	}
	*/
	public RetailStoreOpening load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOpening(RetailStoreOpeningTable.withId(id), options);
	}
	
	
	
	public RetailStoreOpening save(RetailStoreOpening retailStoreOpening,Map<String,Object> options){
		
		String methodName="save(RetailStoreOpening retailStoreOpening,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOpening, methodName, "retailStoreOpening");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOpening(retailStoreOpening,options);
	}
	public RetailStoreOpening clone(String retailStoreOpeningId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOpeningTable.withId(retailStoreOpeningId),options);
	}
	
	protected RetailStoreOpening clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOpeningId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOpening newRetailStoreOpening = loadInternalRetailStoreOpening(accessKey, options);
		newRetailStoreOpening.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreOpening.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOpening(newRetailStoreOpening,options);
		
		return newRetailStoreOpening;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOpeningId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOpeningId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOpeningVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOpeningNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOpeningId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOpeningId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOpeningId, int version)";
		assertMethodArgumentNotNull(retailStoreOpeningId, methodName, "retailStoreOpeningId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOpeningId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOpeningId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"comment"};
		return RetailStoreOpeningTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_opening";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOpeningTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_LIST = "retailStoreList";
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOpeningTokens.RETAIL_STORE_LIST);
		
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOpeningTokens.RETAIL_STORE_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOpeningMapper getRetailStoreOpeningMapper(){
		return new RetailStoreOpeningMapper();
	}
	protected RetailStoreOpening extractRetailStoreOpening(String retailStoreOpeningId) throws Exception{
		String SQL = "select * from retail_store_opening_data where id = ?";	
		try{
		
			RetailStoreOpening retailStoreOpening = queryForObject(SQL, new Object[]{retailStoreOpeningId}, getRetailStoreOpeningMapper());
			return retailStoreOpening;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOpeningNotFoundException("RetailStoreOpening("+retailStoreOpeningId+") is not found!");
		}
		
		
	}
	protected RetailStoreOpening extractRetailStoreOpening(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_opening_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOpening retailStoreOpening = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOpeningMapper());
			return retailStoreOpening;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOpeningNotFoundException("RetailStoreOpening("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOpening loadInternalRetailStoreOpening(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOpening retailStoreOpening = extractRetailStoreOpening(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreOpening, loadOptions);
 		}		
		
		return retailStoreOpening;
		
	}



	
	
	
		
	protected RetailStoreOpening extractRetailStoreList(RetailStoreOpening retailStoreOpening, Map<String,Object> options){
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByOpening(retailStoreOpening.getId(),options);
		if(retailStoreList != null){
			retailStoreOpening.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreOpening;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOpening saveRetailStoreOpening(RetailStoreOpening  retailStoreOpening){
	
		String SQL=this.getSaveRetailStoreOpeningSQL(retailStoreOpening);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOpeningParameters(retailStoreOpening);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOpening.incVersion();
		return retailStoreOpening;
	
	}
	public SmartList<RetailStoreOpening> saveRetailStoreOpeningList(SmartList<RetailStoreOpening> retailStoreOpeningList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOpeningList(retailStoreOpeningList);
		
		batchRetailStoreOpeningCreate((List<RetailStoreOpening>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOpeningUpdate((List<RetailStoreOpening>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOpening retailStoreOpening:retailStoreOpeningList){
			if(retailStoreOpening.isChanged()){
				retailStoreOpening.incVersion();
			}
			
		
		}
		
		
		return retailStoreOpeningList;
	}

	public SmartList<RetailStoreOpening> removeRetailStoreOpeningList(SmartList<RetailStoreOpening> retailStoreOpeningList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOpeningList, options);
		
		return retailStoreOpeningList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOpeningBatchCreateArgs(List<RetailStoreOpening> retailStoreOpeningList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOpening retailStoreOpening:retailStoreOpeningList ){
			Object [] parameters = prepareRetailStoreOpeningCreateParameters(retailStoreOpening);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOpeningBatchUpdateArgs(List<RetailStoreOpening> retailStoreOpeningList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOpening retailStoreOpening:retailStoreOpeningList ){
			if(!retailStoreOpening.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOpeningUpdateParameters(retailStoreOpening);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOpeningCreate(List<RetailStoreOpening> retailStoreOpeningList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOpeningBatchCreateArgs(retailStoreOpeningList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOpeningUpdate(List<RetailStoreOpening> retailStoreOpeningList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOpeningBatchUpdateArgs(retailStoreOpeningList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOpeningList(List<RetailStoreOpening> retailStoreOpeningList){
		
		List<RetailStoreOpening> retailStoreOpeningCreateList=new ArrayList<RetailStoreOpening>();
		List<RetailStoreOpening> retailStoreOpeningUpdateList=new ArrayList<RetailStoreOpening>();
		
		for(RetailStoreOpening retailStoreOpening: retailStoreOpeningList){
			if(isUpdateRequest(retailStoreOpening)){
				retailStoreOpeningUpdateList.add( retailStoreOpening);
				continue;
			}
			retailStoreOpeningCreateList.add(retailStoreOpening);
		}
		
		return new Object[]{retailStoreOpeningCreateList,retailStoreOpeningUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOpening retailStoreOpening){
 		return retailStoreOpening.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOpeningSQL(RetailStoreOpening retailStoreOpening){
 		if(isUpdateRequest(retailStoreOpening)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOpeningParameters(RetailStoreOpening retailStoreOpening){
 		if(isUpdateRequest(retailStoreOpening) ){
 			return prepareRetailStoreOpeningUpdateParameters(retailStoreOpening);
 		}
 		return prepareRetailStoreOpeningCreateParameters(retailStoreOpening);
 	}
 	protected Object[] prepareRetailStoreOpeningUpdateParameters(RetailStoreOpening retailStoreOpening){
 		Object[] parameters = new Object[3];
 
 		parameters[0] = retailStoreOpening.getComment();		
 		parameters[1] = retailStoreOpening.getId();
 		parameters[2] = retailStoreOpening.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOpeningCreateParameters(RetailStoreOpening retailStoreOpening){
		Object[] parameters = new Object[2];
		String newRetailStoreOpeningId=getNextId();
		retailStoreOpening.setId(newRetailStoreOpeningId);
		parameters[0] =  retailStoreOpening.getId();
 
 		parameters[1] = retailStoreOpening.getComment();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOpening saveInternalRetailStoreOpening(RetailStoreOpening retailStoreOpening, Map<String,Object> options){
		
		saveRetailStoreOpening(retailStoreOpening);

		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreOpening, options);
	 		removeRetailStoreList(retailStoreOpening, options);
	 		
 		}		
		
		return retailStoreOpening;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreOpening saveRetailStoreList(RetailStoreOpening retailStoreOpening, Map<String,Object> options){
		SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreOpening;
		}
		if(retailStoreList.isEmpty()){
			return retailStoreOpening;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreDAO().saveRetailStoreList(retailStoreList,options);
		
		return retailStoreOpening;
	
	}
	
	protected RetailStoreOpening removeRetailStoreList(RetailStoreOpening retailStoreOpening, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreOpening;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreOpening;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreOpening;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreOpening;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreOpening present(RetailStoreOpening retailStoreOpening,Map<String, Object> options){
	
		presentRetailStoreList(retailStoreOpening,options);

		return retailStoreOpening;
	
	}
		
	
  	
 	protected RetailStoreOpening presentRetailStoreList(
			RetailStoreOpening retailStoreOpening,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreOpening.getRetailStoreList();		
		if(retailStoreList == null){
			return retailStoreOpening;			
		}
		
		String targetObjectName = "retailStore";
		int retailStoreListSize = retailStoreList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOpening;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreListSize;
		if(retailStoreListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreDAO().countRetailStoreByOpening(retailStoreOpening.getId(), options);			
		}
		//retailStoreOpening.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOpening.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreListSize,currentPage,rowsPerPage) ;
			retailStoreList = retailStoreList.subListOf(fromIndex, toIndex);
			retailStoreList.setTotalCount(count);
			retailStoreList.setCurrentPageNumber(currentPage);			
			retailStoreOpening.setRetailStoreList(retailStoreList);
			return retailStoreOpening;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreList 
			= getRetailStoreDAO().findRetailStoreByOpening(retailStoreOpening.getId(),start, rowsPerPage, options );
		retailStoreList.setTotalCount(count);
		retailStoreList.setCurrentPageNumber(currentPage);
		retailStoreOpening.setRetailStoreList(retailStoreList );	

		return retailStoreOpening;
	}			
		


	protected String getTableName(){
		return RetailStoreOpeningTable.TABLE_NAME;
	}
}


