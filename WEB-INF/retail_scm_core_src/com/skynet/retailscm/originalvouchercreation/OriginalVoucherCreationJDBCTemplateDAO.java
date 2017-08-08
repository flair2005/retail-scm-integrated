
package com.skynet.retailscm.originalvouchercreation;

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

public class OriginalVoucherCreationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements OriginalVoucherCreationDAO{

		
	
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
	protected OriginalVoucherCreation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherCreation(accessKey, options);
	}
	*/
	public OriginalVoucherCreation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherCreation(OriginalVoucherCreationTable.withId(id), options);
	}
	
	
	
	public OriginalVoucherCreation save(OriginalVoucherCreation originalVoucherCreation,Map<String,Object> options){
		
		String methodName="save(OriginalVoucherCreation originalVoucherCreation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(originalVoucherCreation, methodName, "originalVoucherCreation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOriginalVoucherCreation(originalVoucherCreation,options);
	}
	public OriginalVoucherCreation clone(String originalVoucherCreationId, Map<String,Object> options) throws Exception{
	
		return clone(OriginalVoucherCreationTable.withId(originalVoucherCreationId),options);
	}
	
	protected OriginalVoucherCreation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String originalVoucherCreationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OriginalVoucherCreation newOriginalVoucherCreation = loadInternalOriginalVoucherCreation(accessKey, options);
		newOriginalVoucherCreation.setVersion(0);
		
		
 		
 		if(isSaveOriginalVoucherListEnabled(options)){
 			for(OriginalVoucher item: newOriginalVoucherCreation.getOriginalVoucherList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOriginalVoucherCreation(newOriginalVoucherCreation,options);
		
		return newOriginalVoucherCreation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String originalVoucherCreationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{originalVoucherCreationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new OriginalVoucherCreationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OriginalVoucherCreationNotFoundException(
					"The " + this.getTableName() + "(" + originalVoucherCreationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String originalVoucherCreationId, int version) throws Exception{
	
		String methodName="delete(String originalVoucherCreationId, int version)";
		assertMethodArgumentNotNull(originalVoucherCreationId, methodName, "originalVoucherCreationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{originalVoucherCreationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(originalVoucherCreationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","comments","make_date"};
		return OriginalVoucherCreationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "original_voucher_creation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OriginalVoucherCreationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String ORIGINAL_VOUCHER_LIST = "originalVoucherList";
	
	protected boolean isExtractOriginalVoucherListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OriginalVoucherCreationTokens.ORIGINAL_VOUCHER_LIST);
		
 	}

	protected boolean isSaveOriginalVoucherListEnabled(Map<String,Object> options){
		return checkOptions(options, OriginalVoucherCreationTokens.ORIGINAL_VOUCHER_LIST);
		
 	}
 	
 	
			
		

	

	protected OriginalVoucherCreationMapper getOriginalVoucherCreationMapper(){
		return new OriginalVoucherCreationMapper();
	}
	protected OriginalVoucherCreation extractOriginalVoucherCreation(String originalVoucherCreationId) throws Exception{
		String SQL = "select * from original_voucher_creation_data where id = ?";	
		try{
		
			OriginalVoucherCreation originalVoucherCreation = queryForObject(SQL, new Object[]{originalVoucherCreationId}, getOriginalVoucherCreationMapper());
			return originalVoucherCreation;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherCreationNotFoundException("OriginalVoucherCreation("+originalVoucherCreationId+") is not found!");
		}
		
		
	}
	protected OriginalVoucherCreation extractOriginalVoucherCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from original_voucher_creation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			OriginalVoucherCreation originalVoucherCreation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getOriginalVoucherCreationMapper());
			return originalVoucherCreation;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherCreationNotFoundException("OriginalVoucherCreation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected OriginalVoucherCreation loadInternalOriginalVoucherCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OriginalVoucherCreation originalVoucherCreation = extractOriginalVoucherCreation(accessKey, loadOptions);

		
		if(isExtractOriginalVoucherListEnabled(loadOptions)){
	 		extractOriginalVoucherList(originalVoucherCreation, loadOptions);
 		}		
		
		return originalVoucherCreation;
		
	}



	
	
	
		
	protected OriginalVoucherCreation extractOriginalVoucherList(OriginalVoucherCreation originalVoucherCreation, Map<String,Object> options){
		
		SmartList<OriginalVoucher> originalVoucherList = getOriginalVoucherDAO().findOriginalVoucherByCreation(originalVoucherCreation.getId(),options);
		if(originalVoucherList != null){
			originalVoucherCreation.setOriginalVoucherList(originalVoucherList);
		}
		
		return originalVoucherCreation;
	
	}	
		
		
 	
		
		
		

	

	protected OriginalVoucherCreation saveOriginalVoucherCreation(OriginalVoucherCreation  originalVoucherCreation){
	
		String SQL=this.getSaveOriginalVoucherCreationSQL(originalVoucherCreation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOriginalVoucherCreationParameters(originalVoucherCreation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		originalVoucherCreation.incVersion();
		return originalVoucherCreation;
	
	}
	public SmartList<OriginalVoucherCreation> saveOriginalVoucherCreationList(SmartList<OriginalVoucherCreation> originalVoucherCreationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOriginalVoucherCreationList(originalVoucherCreationList);
		
		batchOriginalVoucherCreationCreate((List<OriginalVoucherCreation>)lists[CREATE_LIST_INDEX]);
		
		batchOriginalVoucherCreationUpdate((List<OriginalVoucherCreation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OriginalVoucherCreation originalVoucherCreation:originalVoucherCreationList){
			if(originalVoucherCreation.isChanged()){
				originalVoucherCreation.incVersion();
			}
			
		
		}
		
		
		return originalVoucherCreationList;
	}

	public SmartList<OriginalVoucherCreation> removeOriginalVoucherCreationList(SmartList<OriginalVoucherCreation> originalVoucherCreationList,Map<String,Object> options){
		
		
		super.removeList(originalVoucherCreationList, options);
		
		return originalVoucherCreationList;
		
		
	}
	
	protected List<Object[]> prepareOriginalVoucherCreationBatchCreateArgs(List<OriginalVoucherCreation> originalVoucherCreationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherCreation originalVoucherCreation:originalVoucherCreationList ){
			Object [] parameters = prepareOriginalVoucherCreationCreateParameters(originalVoucherCreation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOriginalVoucherCreationBatchUpdateArgs(List<OriginalVoucherCreation> originalVoucherCreationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherCreation originalVoucherCreation:originalVoucherCreationList ){
			if(!originalVoucherCreation.isChanged()){
				continue;
			}
			Object [] parameters = prepareOriginalVoucherCreationUpdateParameters(originalVoucherCreation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOriginalVoucherCreationCreate(List<OriginalVoucherCreation> originalVoucherCreationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOriginalVoucherCreationBatchCreateArgs(originalVoucherCreationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOriginalVoucherCreationUpdate(List<OriginalVoucherCreation> originalVoucherCreationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOriginalVoucherCreationBatchUpdateArgs(originalVoucherCreationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOriginalVoucherCreationList(List<OriginalVoucherCreation> originalVoucherCreationList){
		
		List<OriginalVoucherCreation> originalVoucherCreationCreateList=new ArrayList<OriginalVoucherCreation>();
		List<OriginalVoucherCreation> originalVoucherCreationUpdateList=new ArrayList<OriginalVoucherCreation>();
		
		for(OriginalVoucherCreation originalVoucherCreation: originalVoucherCreationList){
			if(isUpdateRequest(originalVoucherCreation)){
				originalVoucherCreationUpdateList.add( originalVoucherCreation);
				continue;
			}
			originalVoucherCreationCreateList.add(originalVoucherCreation);
		}
		
		return new Object[]{originalVoucherCreationCreateList,originalVoucherCreationUpdateList};
	}
	
	protected boolean isUpdateRequest(OriginalVoucherCreation originalVoucherCreation){
 		return originalVoucherCreation.getVersion() > 0;
 	}
 	protected String getSaveOriginalVoucherCreationSQL(OriginalVoucherCreation originalVoucherCreation){
 		if(isUpdateRequest(originalVoucherCreation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOriginalVoucherCreationParameters(OriginalVoucherCreation originalVoucherCreation){
 		if(isUpdateRequest(originalVoucherCreation) ){
 			return prepareOriginalVoucherCreationUpdateParameters(originalVoucherCreation);
 		}
 		return prepareOriginalVoucherCreationCreateParameters(originalVoucherCreation);
 	}
 	protected Object[] prepareOriginalVoucherCreationUpdateParameters(OriginalVoucherCreation originalVoucherCreation){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = originalVoucherCreation.getWho();
 		parameters[1] = originalVoucherCreation.getComments();
 		parameters[2] = originalVoucherCreation.getMakeDate();		
 		parameters[3] = originalVoucherCreation.getId();
 		parameters[4] = originalVoucherCreation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOriginalVoucherCreationCreateParameters(OriginalVoucherCreation originalVoucherCreation){
		Object[] parameters = new Object[4];
		String newOriginalVoucherCreationId=getNextId();
		originalVoucherCreation.setId(newOriginalVoucherCreationId);
		parameters[0] =  originalVoucherCreation.getId();
 
 		parameters[1] = originalVoucherCreation.getWho();
 		parameters[2] = originalVoucherCreation.getComments();
 		parameters[3] = originalVoucherCreation.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected OriginalVoucherCreation saveInternalOriginalVoucherCreation(OriginalVoucherCreation originalVoucherCreation, Map<String,Object> options){
		
		saveOriginalVoucherCreation(originalVoucherCreation);

		
		if(isSaveOriginalVoucherListEnabled(options)){
	 		saveOriginalVoucherList(originalVoucherCreation, options);
	 		removeOriginalVoucherList(originalVoucherCreation, options);
	 		
 		}		
		
		return originalVoucherCreation;
		
	}
	
	
	
	//======================================================================================
	
		
	protected OriginalVoucherCreation saveOriginalVoucherList(OriginalVoucherCreation originalVoucherCreation, Map<String,Object> options){
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherCreation.getOriginalVoucherList();
		if(originalVoucherList == null){
			return originalVoucherCreation;
		}
		if(originalVoucherList.isEmpty()){
			return originalVoucherCreation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOriginalVoucherDAO().saveOriginalVoucherList(originalVoucherList,options);
		
		return originalVoucherCreation;
	
	}
	
	protected OriginalVoucherCreation removeOriginalVoucherList(OriginalVoucherCreation originalVoucherCreation, Map<String,Object> options){
	
	
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherCreation.getOriginalVoucherList();
		if(originalVoucherList == null){
			return originalVoucherCreation;
		}	
	
		SmartList<OriginalVoucher> toRemoveOriginalVoucherList = originalVoucherList.getToRemoveList();
		
		if(toRemoveOriginalVoucherList == null){
			return originalVoucherCreation;
		}
		if(toRemoveOriginalVoucherList.isEmpty()){
			return originalVoucherCreation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOriginalVoucherDAO().removeOriginalVoucherList(toRemoveOriginalVoucherList,options);
		
		return originalVoucherCreation;
	
	}
	
	
	
 	
 	
	
	
	
		

	public OriginalVoucherCreation present(OriginalVoucherCreation originalVoucherCreation,Map<String, Object> options){
	
		presentOriginalVoucherList(originalVoucherCreation,options);

		return originalVoucherCreation;
	
	}
		
	
  	
 	protected OriginalVoucherCreation presentOriginalVoucherList(
			OriginalVoucherCreation originalVoucherCreation,
			Map<String, Object> options) {

		SmartList<OriginalVoucher> originalVoucherList = originalVoucherCreation.getOriginalVoucherList();		
		if(originalVoucherList == null){
			return originalVoucherCreation;			
		}
		
		String targetObjectName = "originalVoucher";
		int originalVoucherListSize = originalVoucherList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(originalVoucherListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return originalVoucherCreation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = originalVoucherListSize;
		if(originalVoucherListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getOriginalVoucherDAO().countOriginalVoucherByCreation(originalVoucherCreation.getId(), options);			
		}
		//originalVoucherCreation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//originalVoucherCreation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(originalVoucherListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(originalVoucherListSize,currentPage,rowsPerPage) ;
			originalVoucherList = originalVoucherList.subListOf(fromIndex, toIndex);
			originalVoucherList.setTotalCount(count);
			originalVoucherList.setCurrentPageNumber(currentPage);			
			originalVoucherCreation.setOriginalVoucherList(originalVoucherList);
			return originalVoucherCreation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		originalVoucherList 
			= getOriginalVoucherDAO().findOriginalVoucherByCreation(originalVoucherCreation.getId(),start, rowsPerPage, options );
		originalVoucherList.setTotalCount(count);
		originalVoucherList.setCurrentPageNumber(currentPage);
		originalVoucherCreation.setOriginalVoucherList(originalVoucherList );	

		return originalVoucherCreation;
	}			
		


	protected String getTableName(){
		return OriginalVoucherCreationTable.TABLE_NAME;
	}
}


