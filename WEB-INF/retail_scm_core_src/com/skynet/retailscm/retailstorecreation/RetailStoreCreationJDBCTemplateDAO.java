
package com.skynet.retailscm.retailstorecreation;

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

public class RetailStoreCreationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreCreationDAO{

		
	
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
	protected RetailStoreCreation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCreation(accessKey, options);
	}
	*/
	public RetailStoreCreation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCreation(RetailStoreCreationTable.withId(id), options);
	}
	
	
	
	public RetailStoreCreation save(RetailStoreCreation retailStoreCreation,Map<String,Object> options){
		
		String methodName="save(RetailStoreCreation retailStoreCreation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreCreation, methodName, "retailStoreCreation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreCreation(retailStoreCreation,options);
	}
	public RetailStoreCreation clone(String retailStoreCreationId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreCreationTable.withId(retailStoreCreationId),options);
	}
	
	protected RetailStoreCreation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreCreationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreCreation newRetailStoreCreation = loadInternalRetailStoreCreation(accessKey, options);
		newRetailStoreCreation.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreCreation.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreCreation(newRetailStoreCreation,options);
		
		return newRetailStoreCreation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreCreationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreCreationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreCreationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreCreationNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreCreationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreCreationId, int version) throws Exception{
	
		String methodName="delete(String retailStoreCreationId, int version)";
		assertMethodArgumentNotNull(retailStoreCreationId, methodName, "retailStoreCreationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreCreationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreCreationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"comment"};
		return RetailStoreCreationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_creation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreCreationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_LIST = "retailStoreList";
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCreationTokens.RETAIL_STORE_LIST);
		
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCreationTokens.RETAIL_STORE_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreCreationMapper getRetailStoreCreationMapper(){
		return new RetailStoreCreationMapper();
	}
	protected RetailStoreCreation extractRetailStoreCreation(String retailStoreCreationId) throws Exception{
		String SQL = "select * from retail_store_creation_data where id = ?";	
		try{
		
			RetailStoreCreation retailStoreCreation = queryForObject(SQL, new Object[]{retailStoreCreationId}, getRetailStoreCreationMapper());
			return retailStoreCreation;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreCreationNotFoundException("RetailStoreCreation("+retailStoreCreationId+") is not found!");
		}
		
		
	}
	protected RetailStoreCreation extractRetailStoreCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_creation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreCreation retailStoreCreation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreCreationMapper());
			return retailStoreCreation;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreCreationNotFoundException("RetailStoreCreation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreCreation loadInternalRetailStoreCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreCreation retailStoreCreation = extractRetailStoreCreation(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreCreation, loadOptions);
 		}		
		
		return retailStoreCreation;
		
	}



	
	
	
		
	protected RetailStoreCreation extractRetailStoreList(RetailStoreCreation retailStoreCreation, Map<String,Object> options){
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByCreation(retailStoreCreation.getId(),options);
		if(retailStoreList != null){
			retailStoreCreation.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreCreation;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreCreation saveRetailStoreCreation(RetailStoreCreation  retailStoreCreation){
	
		String SQL=this.getSaveRetailStoreCreationSQL(retailStoreCreation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreCreationParameters(retailStoreCreation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreCreation.incVersion();
		return retailStoreCreation;
	
	}
	public SmartList<RetailStoreCreation> saveRetailStoreCreationList(SmartList<RetailStoreCreation> retailStoreCreationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreCreationList(retailStoreCreationList);
		
		batchRetailStoreCreationCreate((List<RetailStoreCreation>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreCreationUpdate((List<RetailStoreCreation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreCreation retailStoreCreation:retailStoreCreationList){
			if(retailStoreCreation.isChanged()){
				retailStoreCreation.incVersion();
			}
			
		
		}
		
		
		return retailStoreCreationList;
	}

	public SmartList<RetailStoreCreation> removeRetailStoreCreationList(SmartList<RetailStoreCreation> retailStoreCreationList,Map<String,Object> options){
		
		
		super.removeList(retailStoreCreationList, options);
		
		return retailStoreCreationList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreCreationBatchCreateArgs(List<RetailStoreCreation> retailStoreCreationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCreation retailStoreCreation:retailStoreCreationList ){
			Object [] parameters = prepareRetailStoreCreationCreateParameters(retailStoreCreation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreCreationBatchUpdateArgs(List<RetailStoreCreation> retailStoreCreationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCreation retailStoreCreation:retailStoreCreationList ){
			if(!retailStoreCreation.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreCreationUpdateParameters(retailStoreCreation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreCreationCreate(List<RetailStoreCreation> retailStoreCreationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreCreationBatchCreateArgs(retailStoreCreationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreCreationUpdate(List<RetailStoreCreation> retailStoreCreationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreCreationBatchUpdateArgs(retailStoreCreationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreCreationList(List<RetailStoreCreation> retailStoreCreationList){
		
		List<RetailStoreCreation> retailStoreCreationCreateList=new ArrayList<RetailStoreCreation>();
		List<RetailStoreCreation> retailStoreCreationUpdateList=new ArrayList<RetailStoreCreation>();
		
		for(RetailStoreCreation retailStoreCreation: retailStoreCreationList){
			if(isUpdateRequest(retailStoreCreation)){
				retailStoreCreationUpdateList.add( retailStoreCreation);
				continue;
			}
			retailStoreCreationCreateList.add(retailStoreCreation);
		}
		
		return new Object[]{retailStoreCreationCreateList,retailStoreCreationUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreCreation retailStoreCreation){
 		return retailStoreCreation.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreCreationSQL(RetailStoreCreation retailStoreCreation){
 		if(isUpdateRequest(retailStoreCreation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreCreationParameters(RetailStoreCreation retailStoreCreation){
 		if(isUpdateRequest(retailStoreCreation) ){
 			return prepareRetailStoreCreationUpdateParameters(retailStoreCreation);
 		}
 		return prepareRetailStoreCreationCreateParameters(retailStoreCreation);
 	}
 	protected Object[] prepareRetailStoreCreationUpdateParameters(RetailStoreCreation retailStoreCreation){
 		Object[] parameters = new Object[3];
 
 		parameters[0] = retailStoreCreation.getComment();		
 		parameters[1] = retailStoreCreation.getId();
 		parameters[2] = retailStoreCreation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreCreationCreateParameters(RetailStoreCreation retailStoreCreation){
		Object[] parameters = new Object[2];
		String newRetailStoreCreationId=getNextId();
		retailStoreCreation.setId(newRetailStoreCreationId);
		parameters[0] =  retailStoreCreation.getId();
 
 		parameters[1] = retailStoreCreation.getComment();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreCreation saveInternalRetailStoreCreation(RetailStoreCreation retailStoreCreation, Map<String,Object> options){
		
		saveRetailStoreCreation(retailStoreCreation);

		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreCreation, options);
	 		removeRetailStoreList(retailStoreCreation, options);
	 		
 		}		
		
		return retailStoreCreation;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreCreation saveRetailStoreList(RetailStoreCreation retailStoreCreation, Map<String,Object> options){
		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreCreation;
		}
		if(retailStoreList.isEmpty()){
			return retailStoreCreation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreDAO().saveRetailStoreList(retailStoreList,options);
		
		return retailStoreCreation;
	
	}
	
	protected RetailStoreCreation removeRetailStoreList(RetailStoreCreation retailStoreCreation, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreCreation;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreCreation;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreCreation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreCreation;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreCreation present(RetailStoreCreation retailStoreCreation,Map<String, Object> options){
	
		presentRetailStoreList(retailStoreCreation,options);

		return retailStoreCreation;
	
	}
		
	
  	
 	protected RetailStoreCreation presentRetailStoreList(
			RetailStoreCreation retailStoreCreation,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();		
		if(retailStoreList == null){
			return retailStoreCreation;			
		}
		
		String targetObjectName = "retailStore";
		int retailStoreListSize = retailStoreList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCreation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreListSize;
		if(retailStoreListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreDAO().countRetailStoreByCreation(retailStoreCreation.getId(), options);			
		}
		//retailStoreCreation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCreation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreListSize,currentPage,rowsPerPage) ;
			retailStoreList = retailStoreList.subListOf(fromIndex, toIndex);
			retailStoreList.setTotalCount(count);
			retailStoreList.setCurrentPageNumber(currentPage);			
			retailStoreCreation.setRetailStoreList(retailStoreList);
			return retailStoreCreation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreList 
			= getRetailStoreDAO().findRetailStoreByCreation(retailStoreCreation.getId(),start, rowsPerPage, options );
		retailStoreList.setTotalCount(count);
		retailStoreList.setCurrentPageNumber(currentPage);
		retailStoreCreation.setRetailStoreList(retailStoreList );	

		return retailStoreCreation;
	}			
		


	protected String getTableName(){
		return RetailStoreCreationTable.TABLE_NAME;
	}
}


