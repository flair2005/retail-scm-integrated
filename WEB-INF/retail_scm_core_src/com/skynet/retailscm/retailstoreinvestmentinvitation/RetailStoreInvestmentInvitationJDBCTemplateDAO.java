
package com.skynet.retailscm.retailstoreinvestmentinvitation;

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

public class RetailStoreInvestmentInvitationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreInvestmentInvitationDAO{

		
	
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
	protected RetailStoreInvestmentInvitation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreInvestmentInvitation(accessKey, options);
	}
	*/
	public RetailStoreInvestmentInvitation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreInvestmentInvitation(RetailStoreInvestmentInvitationTable.withId(id), options);
	}
	
	
	
	public RetailStoreInvestmentInvitation save(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object> options){
		
		String methodName="save(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreInvestmentInvitation, methodName, "retailStoreInvestmentInvitation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreInvestmentInvitation(retailStoreInvestmentInvitation,options);
	}
	public RetailStoreInvestmentInvitation clone(String retailStoreInvestmentInvitationId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreInvestmentInvitationTable.withId(retailStoreInvestmentInvitationId),options);
	}
	
	protected RetailStoreInvestmentInvitation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreInvestmentInvitationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreInvestmentInvitation newRetailStoreInvestmentInvitation = loadInternalRetailStoreInvestmentInvitation(accessKey, options);
		newRetailStoreInvestmentInvitation.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreInvestmentInvitation.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreInvestmentInvitation(newRetailStoreInvestmentInvitation,options);
		
		return newRetailStoreInvestmentInvitation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreInvestmentInvitationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreInvestmentInvitationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreInvestmentInvitationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreInvestmentInvitationNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreInvestmentInvitationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreInvestmentInvitationId, int version) throws Exception{
	
		String methodName="delete(String retailStoreInvestmentInvitationId, int version)";
		assertMethodArgumentNotNull(retailStoreInvestmentInvitationId, methodName, "retailStoreInvestmentInvitationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreInvestmentInvitationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreInvestmentInvitationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"comment"};
		return RetailStoreInvestmentInvitationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_investment_invitation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreInvestmentInvitationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String RETAIL_STORE_LIST = "retailStoreList";
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreInvestmentInvitationTokens.RETAIL_STORE_LIST);
		
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreInvestmentInvitationTokens.RETAIL_STORE_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreInvestmentInvitationMapper getRetailStoreInvestmentInvitationMapper(){
		return new RetailStoreInvestmentInvitationMapper();
	}
	protected RetailStoreInvestmentInvitation extractRetailStoreInvestmentInvitation(String retailStoreInvestmentInvitationId) throws Exception{
		String SQL = "select * from retail_store_investment_invitation_data where id = ?";	
		try{
		
			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = queryForObject(SQL, new Object[]{retailStoreInvestmentInvitationId}, getRetailStoreInvestmentInvitationMapper());
			return retailStoreInvestmentInvitation;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreInvestmentInvitationNotFoundException("RetailStoreInvestmentInvitation("+retailStoreInvestmentInvitationId+") is not found!");
		}
		
		
	}
	protected RetailStoreInvestmentInvitation extractRetailStoreInvestmentInvitation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_investment_invitation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreInvestmentInvitationMapper());
			return retailStoreInvestmentInvitation;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreInvestmentInvitationNotFoundException("RetailStoreInvestmentInvitation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreInvestmentInvitation loadInternalRetailStoreInvestmentInvitation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = extractRetailStoreInvestmentInvitation(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreInvestmentInvitation, loadOptions);
 		}		
		
		return retailStoreInvestmentInvitation;
		
	}



	
	
	
		
	protected RetailStoreInvestmentInvitation extractRetailStoreList(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options){
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByInvestmentInvitation(retailStoreInvestmentInvitation.getId(),options);
		if(retailStoreList != null){
			retailStoreInvestmentInvitation.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreInvestmentInvitation;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitation(RetailStoreInvestmentInvitation  retailStoreInvestmentInvitation){
	
		String SQL=this.getSaveRetailStoreInvestmentInvitationSQL(retailStoreInvestmentInvitation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreInvestmentInvitationParameters(retailStoreInvestmentInvitation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreInvestmentInvitation.incVersion();
		return retailStoreInvestmentInvitation;
	
	}
	public SmartList<RetailStoreInvestmentInvitation> saveRetailStoreInvestmentInvitationList(SmartList<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreInvestmentInvitationList(retailStoreInvestmentInvitationList);
		
		batchRetailStoreInvestmentInvitationCreate((List<RetailStoreInvestmentInvitation>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreInvestmentInvitationUpdate((List<RetailStoreInvestmentInvitation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation:retailStoreInvestmentInvitationList){
			if(retailStoreInvestmentInvitation.isChanged()){
				retailStoreInvestmentInvitation.incVersion();
			}
			
		
		}
		
		
		return retailStoreInvestmentInvitationList;
	}

	public SmartList<RetailStoreInvestmentInvitation> removeRetailStoreInvestmentInvitationList(SmartList<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList,Map<String,Object> options){
		
		
		super.removeList(retailStoreInvestmentInvitationList, options);
		
		return retailStoreInvestmentInvitationList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreInvestmentInvitationBatchCreateArgs(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation:retailStoreInvestmentInvitationList ){
			Object [] parameters = prepareRetailStoreInvestmentInvitationCreateParameters(retailStoreInvestmentInvitation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreInvestmentInvitationBatchUpdateArgs(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation:retailStoreInvestmentInvitationList ){
			if(!retailStoreInvestmentInvitation.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreInvestmentInvitationUpdateParameters(retailStoreInvestmentInvitation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreInvestmentInvitationCreate(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreInvestmentInvitationBatchCreateArgs(retailStoreInvestmentInvitationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreInvestmentInvitationUpdate(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreInvestmentInvitationBatchUpdateArgs(retailStoreInvestmentInvitationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreInvestmentInvitationList(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		
		List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationCreateList=new ArrayList<RetailStoreInvestmentInvitation>();
		List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationUpdateList=new ArrayList<RetailStoreInvestmentInvitation>();
		
		for(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation: retailStoreInvestmentInvitationList){
			if(isUpdateRequest(retailStoreInvestmentInvitation)){
				retailStoreInvestmentInvitationUpdateList.add( retailStoreInvestmentInvitation);
				continue;
			}
			retailStoreInvestmentInvitationCreateList.add(retailStoreInvestmentInvitation);
		}
		
		return new Object[]{retailStoreInvestmentInvitationCreateList,retailStoreInvestmentInvitationUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
 		return retailStoreInvestmentInvitation.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreInvestmentInvitationSQL(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
 		if(isUpdateRequest(retailStoreInvestmentInvitation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreInvestmentInvitationParameters(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
 		if(isUpdateRequest(retailStoreInvestmentInvitation) ){
 			return prepareRetailStoreInvestmentInvitationUpdateParameters(retailStoreInvestmentInvitation);
 		}
 		return prepareRetailStoreInvestmentInvitationCreateParameters(retailStoreInvestmentInvitation);
 	}
 	protected Object[] prepareRetailStoreInvestmentInvitationUpdateParameters(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
 		Object[] parameters = new Object[3];
 
 		parameters[0] = retailStoreInvestmentInvitation.getComment();		
 		parameters[1] = retailStoreInvestmentInvitation.getId();
 		parameters[2] = retailStoreInvestmentInvitation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreInvestmentInvitationCreateParameters(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
		Object[] parameters = new Object[2];
		String newRetailStoreInvestmentInvitationId=getNextId();
		retailStoreInvestmentInvitation.setId(newRetailStoreInvestmentInvitationId);
		parameters[0] =  retailStoreInvestmentInvitation.getId();
 
 		parameters[1] = retailStoreInvestmentInvitation.getComment();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreInvestmentInvitation saveInternalRetailStoreInvestmentInvitation(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options){
		
		saveRetailStoreInvestmentInvitation(retailStoreInvestmentInvitation);

		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreInvestmentInvitation, options);
	 		removeRetailStoreList(retailStoreInvestmentInvitation, options);
	 		
 		}		
		
		return retailStoreInvestmentInvitation;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreInvestmentInvitation saveRetailStoreList(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options){
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(retailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreDAO().saveRetailStoreList(retailStoreList,options);
		
		return retailStoreInvestmentInvitation;
	
	}
	
	protected RetailStoreInvestmentInvitation removeRetailStoreList(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreInvestmentInvitation;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreInvestmentInvitation;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreInvestmentInvitation present(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String, Object> options){
	
		presentRetailStoreList(retailStoreInvestmentInvitation,options);

		return retailStoreInvestmentInvitation;
	
	}
		
	
  	
 	protected RetailStoreInvestmentInvitation presentRetailStoreList(
			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
		if(retailStoreList == null){
			return retailStoreInvestmentInvitation;			
		}
		
		String targetObjectName = "retailStore";
		int retailStoreListSize = retailStoreList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreInvestmentInvitation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreListSize;
		if(retailStoreListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreDAO().countRetailStoreByInvestmentInvitation(retailStoreInvestmentInvitation.getId(), options);			
		}
		//retailStoreInvestmentInvitation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreInvestmentInvitation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreListSize,currentPage,rowsPerPage) ;
			retailStoreList = retailStoreList.subListOf(fromIndex, toIndex);
			retailStoreList.setTotalCount(count);
			retailStoreList.setCurrentPageNumber(currentPage);			
			retailStoreInvestmentInvitation.setRetailStoreList(retailStoreList);
			return retailStoreInvestmentInvitation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreList 
			= getRetailStoreDAO().findRetailStoreByInvestmentInvitation(retailStoreInvestmentInvitation.getId(),start, rowsPerPage, options );
		retailStoreList.setTotalCount(count);
		retailStoreList.setCurrentPageNumber(currentPage);
		retailStoreInvestmentInvitation.setRetailStoreList(retailStoreList );	

		return retailStoreInvestmentInvitation;
	}			
		


	protected String getTableName(){
		return RetailStoreInvestmentInvitationTable.TABLE_NAME;
	}
}


