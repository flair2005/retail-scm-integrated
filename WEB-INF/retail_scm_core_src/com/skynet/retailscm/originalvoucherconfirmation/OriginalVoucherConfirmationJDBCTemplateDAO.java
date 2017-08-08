
package com.skynet.retailscm.originalvoucherconfirmation;

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

public class OriginalVoucherConfirmationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements OriginalVoucherConfirmationDAO{

		
	
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
	protected OriginalVoucherConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherConfirmation(accessKey, options);
	}
	*/
	public OriginalVoucherConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherConfirmation(OriginalVoucherConfirmationTable.withId(id), options);
	}
	
	
	
	public OriginalVoucherConfirmation save(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object> options){
		
		String methodName="save(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(originalVoucherConfirmation, methodName, "originalVoucherConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOriginalVoucherConfirmation(originalVoucherConfirmation,options);
	}
	public OriginalVoucherConfirmation clone(String originalVoucherConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(OriginalVoucherConfirmationTable.withId(originalVoucherConfirmationId),options);
	}
	
	protected OriginalVoucherConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String originalVoucherConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OriginalVoucherConfirmation newOriginalVoucherConfirmation = loadInternalOriginalVoucherConfirmation(accessKey, options);
		newOriginalVoucherConfirmation.setVersion(0);
		
		
 		
 		if(isSaveOriginalVoucherListEnabled(options)){
 			for(OriginalVoucher item: newOriginalVoucherConfirmation.getOriginalVoucherList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOriginalVoucherConfirmation(newOriginalVoucherConfirmation,options);
		
		return newOriginalVoucherConfirmation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String originalVoucherConfirmationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{originalVoucherConfirmationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new OriginalVoucherConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OriginalVoucherConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + originalVoucherConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String originalVoucherConfirmationId, int version) throws Exception{
	
		String methodName="delete(String originalVoucherConfirmationId, int version)";
		assertMethodArgumentNotNull(originalVoucherConfirmationId, methodName, "originalVoucherConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{originalVoucherConfirmationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(originalVoucherConfirmationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","comments","make_date"};
		return OriginalVoucherConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "original_voucher_confirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OriginalVoucherConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String ORIGINAL_VOUCHER_LIST = "originalVoucherList";
	
	protected boolean isExtractOriginalVoucherListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OriginalVoucherConfirmationTokens.ORIGINAL_VOUCHER_LIST);
		
 	}

	protected boolean isSaveOriginalVoucherListEnabled(Map<String,Object> options){
		return checkOptions(options, OriginalVoucherConfirmationTokens.ORIGINAL_VOUCHER_LIST);
		
 	}
 	
 	
			
		

	

	protected OriginalVoucherConfirmationMapper getOriginalVoucherConfirmationMapper(){
		return new OriginalVoucherConfirmationMapper();
	}
	protected OriginalVoucherConfirmation extractOriginalVoucherConfirmation(String originalVoucherConfirmationId) throws Exception{
		String SQL = "select * from original_voucher_confirmation_data where id = ?";	
		try{
		
			OriginalVoucherConfirmation originalVoucherConfirmation = queryForObject(SQL, new Object[]{originalVoucherConfirmationId}, getOriginalVoucherConfirmationMapper());
			return originalVoucherConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherConfirmationNotFoundException("OriginalVoucherConfirmation("+originalVoucherConfirmationId+") is not found!");
		}
		
		
	}
	protected OriginalVoucherConfirmation extractOriginalVoucherConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from original_voucher_confirmation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			OriginalVoucherConfirmation originalVoucherConfirmation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getOriginalVoucherConfirmationMapper());
			return originalVoucherConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherConfirmationNotFoundException("OriginalVoucherConfirmation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected OriginalVoucherConfirmation loadInternalOriginalVoucherConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OriginalVoucherConfirmation originalVoucherConfirmation = extractOriginalVoucherConfirmation(accessKey, loadOptions);

		
		if(isExtractOriginalVoucherListEnabled(loadOptions)){
	 		extractOriginalVoucherList(originalVoucherConfirmation, loadOptions);
 		}		
		
		return originalVoucherConfirmation;
		
	}



	
	
	
		
	protected OriginalVoucherConfirmation extractOriginalVoucherList(OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options){
		
		SmartList<OriginalVoucher> originalVoucherList = getOriginalVoucherDAO().findOriginalVoucherByConfirmation(originalVoucherConfirmation.getId(),options);
		if(originalVoucherList != null){
			originalVoucherConfirmation.setOriginalVoucherList(originalVoucherList);
		}
		
		return originalVoucherConfirmation;
	
	}	
		
		
 	
		
		
		

	

	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmation(OriginalVoucherConfirmation  originalVoucherConfirmation){
	
		String SQL=this.getSaveOriginalVoucherConfirmationSQL(originalVoucherConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOriginalVoucherConfirmationParameters(originalVoucherConfirmation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		originalVoucherConfirmation.incVersion();
		return originalVoucherConfirmation;
	
	}
	public SmartList<OriginalVoucherConfirmation> saveOriginalVoucherConfirmationList(SmartList<OriginalVoucherConfirmation> originalVoucherConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOriginalVoucherConfirmationList(originalVoucherConfirmationList);
		
		batchOriginalVoucherConfirmationCreate((List<OriginalVoucherConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchOriginalVoucherConfirmationUpdate((List<OriginalVoucherConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OriginalVoucherConfirmation originalVoucherConfirmation:originalVoucherConfirmationList){
			if(originalVoucherConfirmation.isChanged()){
				originalVoucherConfirmation.incVersion();
			}
			
		
		}
		
		
		return originalVoucherConfirmationList;
	}

	public SmartList<OriginalVoucherConfirmation> removeOriginalVoucherConfirmationList(SmartList<OriginalVoucherConfirmation> originalVoucherConfirmationList,Map<String,Object> options){
		
		
		super.removeList(originalVoucherConfirmationList, options);
		
		return originalVoucherConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareOriginalVoucherConfirmationBatchCreateArgs(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherConfirmation originalVoucherConfirmation:originalVoucherConfirmationList ){
			Object [] parameters = prepareOriginalVoucherConfirmationCreateParameters(originalVoucherConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOriginalVoucherConfirmationBatchUpdateArgs(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherConfirmation originalVoucherConfirmation:originalVoucherConfirmationList ){
			if(!originalVoucherConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareOriginalVoucherConfirmationUpdateParameters(originalVoucherConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOriginalVoucherConfirmationCreate(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOriginalVoucherConfirmationBatchCreateArgs(originalVoucherConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOriginalVoucherConfirmationUpdate(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOriginalVoucherConfirmationBatchUpdateArgs(originalVoucherConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOriginalVoucherConfirmationList(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		
		List<OriginalVoucherConfirmation> originalVoucherConfirmationCreateList=new ArrayList<OriginalVoucherConfirmation>();
		List<OriginalVoucherConfirmation> originalVoucherConfirmationUpdateList=new ArrayList<OriginalVoucherConfirmation>();
		
		for(OriginalVoucherConfirmation originalVoucherConfirmation: originalVoucherConfirmationList){
			if(isUpdateRequest(originalVoucherConfirmation)){
				originalVoucherConfirmationUpdateList.add( originalVoucherConfirmation);
				continue;
			}
			originalVoucherConfirmationCreateList.add(originalVoucherConfirmation);
		}
		
		return new Object[]{originalVoucherConfirmationCreateList,originalVoucherConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(OriginalVoucherConfirmation originalVoucherConfirmation){
 		return originalVoucherConfirmation.getVersion() > 0;
 	}
 	protected String getSaveOriginalVoucherConfirmationSQL(OriginalVoucherConfirmation originalVoucherConfirmation){
 		if(isUpdateRequest(originalVoucherConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOriginalVoucherConfirmationParameters(OriginalVoucherConfirmation originalVoucherConfirmation){
 		if(isUpdateRequest(originalVoucherConfirmation) ){
 			return prepareOriginalVoucherConfirmationUpdateParameters(originalVoucherConfirmation);
 		}
 		return prepareOriginalVoucherConfirmationCreateParameters(originalVoucherConfirmation);
 	}
 	protected Object[] prepareOriginalVoucherConfirmationUpdateParameters(OriginalVoucherConfirmation originalVoucherConfirmation){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = originalVoucherConfirmation.getWho();
 		parameters[1] = originalVoucherConfirmation.getComments();
 		parameters[2] = originalVoucherConfirmation.getMakeDate();		
 		parameters[3] = originalVoucherConfirmation.getId();
 		parameters[4] = originalVoucherConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOriginalVoucherConfirmationCreateParameters(OriginalVoucherConfirmation originalVoucherConfirmation){
		Object[] parameters = new Object[4];
		String newOriginalVoucherConfirmationId=getNextId();
		originalVoucherConfirmation.setId(newOriginalVoucherConfirmationId);
		parameters[0] =  originalVoucherConfirmation.getId();
 
 		parameters[1] = originalVoucherConfirmation.getWho();
 		parameters[2] = originalVoucherConfirmation.getComments();
 		parameters[3] = originalVoucherConfirmation.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected OriginalVoucherConfirmation saveInternalOriginalVoucherConfirmation(OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options){
		
		saveOriginalVoucherConfirmation(originalVoucherConfirmation);

		
		if(isSaveOriginalVoucherListEnabled(options)){
	 		saveOriginalVoucherList(originalVoucherConfirmation, options);
	 		removeOriginalVoucherList(originalVoucherConfirmation, options);
	 		
 		}		
		
		return originalVoucherConfirmation;
		
	}
	
	
	
	//======================================================================================
	
		
	protected OriginalVoucherConfirmation saveOriginalVoucherList(OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options){
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();
		if(originalVoucherList == null){
			return originalVoucherConfirmation;
		}
		if(originalVoucherList.isEmpty()){
			return originalVoucherConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOriginalVoucherDAO().saveOriginalVoucherList(originalVoucherList,options);
		
		return originalVoucherConfirmation;
	
	}
	
	protected OriginalVoucherConfirmation removeOriginalVoucherList(OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options){
	
	
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();
		if(originalVoucherList == null){
			return originalVoucherConfirmation;
		}	
	
		SmartList<OriginalVoucher> toRemoveOriginalVoucherList = originalVoucherList.getToRemoveList();
		
		if(toRemoveOriginalVoucherList == null){
			return originalVoucherConfirmation;
		}
		if(toRemoveOriginalVoucherList.isEmpty()){
			return originalVoucherConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOriginalVoucherDAO().removeOriginalVoucherList(toRemoveOriginalVoucherList,options);
		
		return originalVoucherConfirmation;
	
	}
	
	
	
 	
 	
	
	
	
		

	public OriginalVoucherConfirmation present(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String, Object> options){
	
		presentOriginalVoucherList(originalVoucherConfirmation,options);

		return originalVoucherConfirmation;
	
	}
		
	
  	
 	protected OriginalVoucherConfirmation presentOriginalVoucherList(
			OriginalVoucherConfirmation originalVoucherConfirmation,
			Map<String, Object> options) {

		SmartList<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();		
		if(originalVoucherList == null){
			return originalVoucherConfirmation;			
		}
		
		String targetObjectName = "originalVoucher";
		int originalVoucherListSize = originalVoucherList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(originalVoucherListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return originalVoucherConfirmation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = originalVoucherListSize;
		if(originalVoucherListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getOriginalVoucherDAO().countOriginalVoucherByConfirmation(originalVoucherConfirmation.getId(), options);			
		}
		//originalVoucherConfirmation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//originalVoucherConfirmation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(originalVoucherListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(originalVoucherListSize,currentPage,rowsPerPage) ;
			originalVoucherList = originalVoucherList.subListOf(fromIndex, toIndex);
			originalVoucherList.setTotalCount(count);
			originalVoucherList.setCurrentPageNumber(currentPage);			
			originalVoucherConfirmation.setOriginalVoucherList(originalVoucherList);
			return originalVoucherConfirmation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		originalVoucherList 
			= getOriginalVoucherDAO().findOriginalVoucherByConfirmation(originalVoucherConfirmation.getId(),start, rowsPerPage, options );
		originalVoucherList.setTotalCount(count);
		originalVoucherList.setCurrentPageNumber(currentPage);
		originalVoucherConfirmation.setOriginalVoucherList(originalVoucherList );	

		return originalVoucherConfirmation;
	}			
		


	protected String getTableName(){
		return OriginalVoucherConfirmationTable.TABLE_NAME;
	}
}


