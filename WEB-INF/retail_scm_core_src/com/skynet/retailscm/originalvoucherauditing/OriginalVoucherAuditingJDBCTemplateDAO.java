
package com.skynet.retailscm.originalvoucherauditing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.originalvoucher.OriginalVoucher;

import com.skynet.retailscm.originalvoucher.OriginalVoucherDAO;

import com.skynet.retailscm.originalvoucher.OriginalVoucherTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class OriginalVoucherAuditingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements OriginalVoucherAuditingDAO{

		
	
  	private  OriginalVoucherDAO  originalVoucherDAO;
 	public void setOriginalVoucherDAO(OriginalVoucherDAO pOriginalVoucherDAO){
 	
 		if(pOriginalVoucherDAO == null){
 			throw new IllegalStateException("Do not try to set originalVoucherDAO to null.");
 		}
	 	this.originalVoucherDAO = pOriginalVoucherDAO;
 	}
 	public OriginalVoucherDAO getOriginalVoucherDAO(){
 		if(this.originalVoucherDAO == null){
 			throw new IllegalStateException("The originalVoucherDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.originalVoucherDAO;
 	}	
 	
			
		

	
	/*
	protected OriginalVoucherAuditing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherAuditing(accessKey, options);
	}
	*/
	public OriginalVoucherAuditing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherAuditing(OriginalVoucherAuditingTable.withId(id), options);
	}
	
	
	
	public OriginalVoucherAuditing save(OriginalVoucherAuditing originalVoucherAuditing,Map<String,Object> options){
		
		String methodName="save(OriginalVoucherAuditing originalVoucherAuditing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(originalVoucherAuditing, methodName, "originalVoucherAuditing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOriginalVoucherAuditing(originalVoucherAuditing,options);
	}
	public OriginalVoucherAuditing clone(String originalVoucherAuditingId, Map<String,Object> options) throws Exception{
	
		return clone(OriginalVoucherAuditingTable.withId(originalVoucherAuditingId),options);
	}
	
	protected OriginalVoucherAuditing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String originalVoucherAuditingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OriginalVoucherAuditing newOriginalVoucherAuditing = loadInternalOriginalVoucherAuditing(accessKey, options);
		newOriginalVoucherAuditing.setVersion(0);
		
		
 		
 		if(isSaveOriginalVoucherListEnabled(options)){
 			for(OriginalVoucher item: newOriginalVoucherAuditing.getOriginalVoucherList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOriginalVoucherAuditing(newOriginalVoucherAuditing,options);
		
		return newOriginalVoucherAuditing;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String originalVoucherAuditingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{originalVoucherAuditingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new OriginalVoucherAuditingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OriginalVoucherAuditingNotFoundException(
					"The " + this.getTableName() + "(" + originalVoucherAuditingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String originalVoucherAuditingId, int version) throws Exception{
	
		String methodName="delete(String originalVoucherAuditingId, int version)";
		assertMethodArgumentNotNull(originalVoucherAuditingId, methodName, "originalVoucherAuditingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{originalVoucherAuditingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(originalVoucherAuditingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","comments","make_date"};
		return OriginalVoucherAuditingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "original_voucher_auditing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OriginalVoucherAuditingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String ORIGINAL_VOUCHER_LIST = "originalVoucherList";
	
	protected boolean isExtractOriginalVoucherListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OriginalVoucherAuditingTokens.ORIGINAL_VOUCHER_LIST);
		
 	}

	protected boolean isSaveOriginalVoucherListEnabled(Map<String,Object> options){
		return checkOptions(options, OriginalVoucherAuditingTokens.ORIGINAL_VOUCHER_LIST);
		
 	}
 	
 	
			
		

	

	protected OriginalVoucherAuditingMapper getOriginalVoucherAuditingMapper(){
		return new OriginalVoucherAuditingMapper();
	}
	protected OriginalVoucherAuditing extractOriginalVoucherAuditing(String originalVoucherAuditingId) throws Exception{
		String SQL = "select * from original_voucher_auditing_data where id = ?";	
		try{
		
			OriginalVoucherAuditing originalVoucherAuditing = queryForObject(SQL, new Object[]{originalVoucherAuditingId}, getOriginalVoucherAuditingMapper());
			return originalVoucherAuditing;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherAuditingNotFoundException("OriginalVoucherAuditing("+originalVoucherAuditingId+") is not found!");
		}
		
		
	}
	protected OriginalVoucherAuditing extractOriginalVoucherAuditing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from original_voucher_auditing_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			OriginalVoucherAuditing originalVoucherAuditing = queryForObject(SQL, new Object[]{accessKey.getValue()}, getOriginalVoucherAuditingMapper());
			return originalVoucherAuditing;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherAuditingNotFoundException("OriginalVoucherAuditing("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected OriginalVoucherAuditing loadInternalOriginalVoucherAuditing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OriginalVoucherAuditing originalVoucherAuditing = extractOriginalVoucherAuditing(accessKey, loadOptions);

		
		if(isExtractOriginalVoucherListEnabled(loadOptions)){
	 		extractOriginalVoucherList(originalVoucherAuditing, loadOptions);
 		}		
		
		return originalVoucherAuditing;
		
	}



	
	
	
		
	protected OriginalVoucherAuditing extractOriginalVoucherList(OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options){
		
		SmartList<OriginalVoucher> originalVoucherList = getOriginalVoucherDAO().findOriginalVoucherByAuditing(originalVoucherAuditing.getId(),options);
		if(originalVoucherList != null){
			originalVoucherAuditing.setOriginalVoucherList(originalVoucherList);
		}
		
		return originalVoucherAuditing;
	
	}	
		
		
 	
		
		
		

	

	protected OriginalVoucherAuditing saveOriginalVoucherAuditing(OriginalVoucherAuditing  originalVoucherAuditing){
	
		String SQL=this.getSaveOriginalVoucherAuditingSQL(originalVoucherAuditing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOriginalVoucherAuditingParameters(originalVoucherAuditing);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		originalVoucherAuditing.incVersion();
		return originalVoucherAuditing;
	
	}
	public SmartList<OriginalVoucherAuditing> saveOriginalVoucherAuditingList(SmartList<OriginalVoucherAuditing> originalVoucherAuditingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOriginalVoucherAuditingList(originalVoucherAuditingList);
		
		batchOriginalVoucherAuditingCreate((List<OriginalVoucherAuditing>)lists[CREATE_LIST_INDEX]);
		
		batchOriginalVoucherAuditingUpdate((List<OriginalVoucherAuditing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OriginalVoucherAuditing originalVoucherAuditing:originalVoucherAuditingList){
			if(originalVoucherAuditing.isChanged()){
				originalVoucherAuditing.incVersion();
			}
			
		
		}
		
		
		return originalVoucherAuditingList;
	}

	public SmartList<OriginalVoucherAuditing> removeOriginalVoucherAuditingList(SmartList<OriginalVoucherAuditing> originalVoucherAuditingList,Map<String,Object> options){
		
		
		super.removeList(originalVoucherAuditingList, options);
		
		return originalVoucherAuditingList;
		
		
	}
	
	protected List<Object[]> prepareOriginalVoucherAuditingBatchCreateArgs(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherAuditing originalVoucherAuditing:originalVoucherAuditingList ){
			Object [] parameters = prepareOriginalVoucherAuditingCreateParameters(originalVoucherAuditing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOriginalVoucherAuditingBatchUpdateArgs(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherAuditing originalVoucherAuditing:originalVoucherAuditingList ){
			if(!originalVoucherAuditing.isChanged()){
				continue;
			}
			Object [] parameters = prepareOriginalVoucherAuditingUpdateParameters(originalVoucherAuditing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOriginalVoucherAuditingCreate(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOriginalVoucherAuditingBatchCreateArgs(originalVoucherAuditingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOriginalVoucherAuditingUpdate(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOriginalVoucherAuditingBatchUpdateArgs(originalVoucherAuditingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOriginalVoucherAuditingList(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		
		List<OriginalVoucherAuditing> originalVoucherAuditingCreateList=new ArrayList<OriginalVoucherAuditing>();
		List<OriginalVoucherAuditing> originalVoucherAuditingUpdateList=new ArrayList<OriginalVoucherAuditing>();
		
		for(OriginalVoucherAuditing originalVoucherAuditing: originalVoucherAuditingList){
			if(isUpdateRequest(originalVoucherAuditing)){
				originalVoucherAuditingUpdateList.add( originalVoucherAuditing);
				continue;
			}
			originalVoucherAuditingCreateList.add(originalVoucherAuditing);
		}
		
		return new Object[]{originalVoucherAuditingCreateList,originalVoucherAuditingUpdateList};
	}
	
	protected boolean isUpdateRequest(OriginalVoucherAuditing originalVoucherAuditing){
 		return originalVoucherAuditing.getVersion() > 0;
 	}
 	protected String getSaveOriginalVoucherAuditingSQL(OriginalVoucherAuditing originalVoucherAuditing){
 		if(isUpdateRequest(originalVoucherAuditing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOriginalVoucherAuditingParameters(OriginalVoucherAuditing originalVoucherAuditing){
 		if(isUpdateRequest(originalVoucherAuditing) ){
 			return prepareOriginalVoucherAuditingUpdateParameters(originalVoucherAuditing);
 		}
 		return prepareOriginalVoucherAuditingCreateParameters(originalVoucherAuditing);
 	}
 	protected Object[] prepareOriginalVoucherAuditingUpdateParameters(OriginalVoucherAuditing originalVoucherAuditing){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = originalVoucherAuditing.getWho();
 		parameters[1] = originalVoucherAuditing.getComments();
 		parameters[2] = originalVoucherAuditing.getMakeDate();		
 		parameters[3] = originalVoucherAuditing.getId();
 		parameters[4] = originalVoucherAuditing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOriginalVoucherAuditingCreateParameters(OriginalVoucherAuditing originalVoucherAuditing){
		Object[] parameters = new Object[4];
		String newOriginalVoucherAuditingId=getNextId();
		originalVoucherAuditing.setId(newOriginalVoucherAuditingId);
		parameters[0] =  originalVoucherAuditing.getId();
 
 		parameters[1] = originalVoucherAuditing.getWho();
 		parameters[2] = originalVoucherAuditing.getComments();
 		parameters[3] = originalVoucherAuditing.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected OriginalVoucherAuditing saveInternalOriginalVoucherAuditing(OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options){
		
		saveOriginalVoucherAuditing(originalVoucherAuditing);

		
		if(isSaveOriginalVoucherListEnabled(options)){
	 		saveOriginalVoucherList(originalVoucherAuditing, options);
	 		removeOriginalVoucherList(originalVoucherAuditing, options);
	 		
 		}		
		
		return originalVoucherAuditing;
		
	}
	
	
	
	//======================================================================================
	
		
	protected OriginalVoucherAuditing saveOriginalVoucherList(OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options){
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();
		if(originalVoucherList == null){
			return originalVoucherAuditing;
		}
		if(originalVoucherList.isEmpty()){
			return originalVoucherAuditing;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOriginalVoucherDAO().saveOriginalVoucherList(originalVoucherList,options);
		
		return originalVoucherAuditing;
	
	}
	
	protected OriginalVoucherAuditing removeOriginalVoucherList(OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options){
	
	
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();
		if(originalVoucherList == null){
			return originalVoucherAuditing;
		}	
	
		SmartList<OriginalVoucher> toRemoveOriginalVoucherList = originalVoucherList.getToRemoveList();
		
		if(toRemoveOriginalVoucherList == null){
			return originalVoucherAuditing;
		}
		if(toRemoveOriginalVoucherList.isEmpty()){
			return originalVoucherAuditing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOriginalVoucherDAO().removeOriginalVoucherList(toRemoveOriginalVoucherList,options);
		
		return originalVoucherAuditing;
	
	}
	
	
	
 	
 	
	
	
	
		

	public OriginalVoucherAuditing present(OriginalVoucherAuditing originalVoucherAuditing,Map<String, Object> options){
	
		presentOriginalVoucherList(originalVoucherAuditing,options);

		return originalVoucherAuditing;
	
	}
		
	
  	
 	protected OriginalVoucherAuditing presentOriginalVoucherList(
			OriginalVoucherAuditing originalVoucherAuditing,
			Map<String, Object> options) {

		SmartList<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();		
		if(originalVoucherList == null){
			return originalVoucherAuditing;			
		}
		
		String targetObjectName = "originalVoucher";
		int originalVoucherListSize = originalVoucherList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(originalVoucherListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return originalVoucherAuditing;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = originalVoucherListSize;
		if(originalVoucherListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getOriginalVoucherDAO().countOriginalVoucherByAuditing(originalVoucherAuditing.getId(), options);			
		}
		//originalVoucherAuditing.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//originalVoucherAuditing.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(originalVoucherListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(originalVoucherListSize,currentPage,rowsPerPage) ;
			originalVoucherList = originalVoucherList.subListOf(fromIndex, toIndex);
			originalVoucherList.setTotalCount(count);
			originalVoucherList.setCurrentPageNumber(currentPage);			
			originalVoucherAuditing.setOriginalVoucherList(originalVoucherList);
			return originalVoucherAuditing;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		originalVoucherList 
			= getOriginalVoucherDAO().findOriginalVoucherByAuditing(originalVoucherAuditing.getId(),start, rowsPerPage, options );
		originalVoucherList.setTotalCount(count);
		originalVoucherList.setCurrentPageNumber(currentPage);
		originalVoucherAuditing.setOriginalVoucherList(originalVoucherList );	

		return originalVoucherAuditing;
	}			
		


	protected String getTableName(){
		return OriginalVoucherAuditingTable.TABLE_NAME;
	}
}


