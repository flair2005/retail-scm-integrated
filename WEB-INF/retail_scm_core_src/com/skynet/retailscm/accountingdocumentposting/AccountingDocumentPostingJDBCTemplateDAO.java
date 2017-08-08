
package com.skynet.retailscm.accountingdocumentposting;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.accountingdocument.AccountingDocument;

import com.skynet.retailscm.accountingdocument.AccountingDocumentDAO;

import com.skynet.retailscm.accountingdocument.AccountingDocumentTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class AccountingDocumentPostingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountingDocumentPostingDAO{

		
	
  	private  AccountingDocumentDAO  accountingDocumentDAO;
 	public void setAccountingDocumentDAO(AccountingDocumentDAO pAccountingDocumentDAO){
 	
 		if(pAccountingDocumentDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentDAO to null.");
 		}
	 	this.accountingDocumentDAO = pAccountingDocumentDAO;
 	}
 	public AccountingDocumentDAO getAccountingDocumentDAO(){
 		if(this.accountingDocumentDAO == null){
 			throw new IllegalStateException("The accountingDocumentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentDAO;
 	}	
 	
			
		

	
	/*
	protected AccountingDocumentPosting load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentPosting(accessKey, options);
	}
	*/
	public AccountingDocumentPosting load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentPosting(AccountingDocumentPostingTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentPosting save(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentPosting, methodName, "accountingDocumentPosting");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentPosting(accountingDocumentPosting,options);
	}
	public AccountingDocumentPosting clone(String accountingDocumentPostingId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentPostingTable.withId(accountingDocumentPostingId),options);
	}
	
	protected AccountingDocumentPosting clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentPostingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentPosting newAccountingDocumentPosting = loadInternalAccountingDocumentPosting(accessKey, options);
		newAccountingDocumentPosting.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentPosting.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentPosting(newAccountingDocumentPosting,options);
		
		return newAccountingDocumentPosting;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountingDocumentPostingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountingDocumentPostingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountingDocumentPostingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentPostingNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentPostingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountingDocumentPostingId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentPostingId, int version)";
		assertMethodArgumentNotNull(accountingDocumentPostingId, methodName, "accountingDocumentPostingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentPostingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentPostingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","comments","make_date"};
		return AccountingDocumentPostingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_posting";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentPostingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingDocumentPostingTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentPostingTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingDocumentPostingMapper getAccountingDocumentPostingMapper(){
		return new AccountingDocumentPostingMapper();
	}
	protected AccountingDocumentPosting extractAccountingDocumentPosting(String accountingDocumentPostingId) throws Exception{
		String SQL = "select * from accounting_document_posting_data where id = ?";	
		try{
		
			AccountingDocumentPosting accountingDocumentPosting = queryForObject(SQL, new Object[]{accountingDocumentPostingId}, getAccountingDocumentPostingMapper());
			return accountingDocumentPosting;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentPostingNotFoundException("AccountingDocumentPosting("+accountingDocumentPostingId+") is not found!");
		}
		
		
	}
	protected AccountingDocumentPosting extractAccountingDocumentPosting(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from accounting_document_posting_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountingDocumentPosting accountingDocumentPosting = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountingDocumentPostingMapper());
			return accountingDocumentPosting;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentPostingNotFoundException("AccountingDocumentPosting("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountingDocumentPosting loadInternalAccountingDocumentPosting(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentPosting accountingDocumentPosting = extractAccountingDocumentPosting(accessKey, loadOptions);

		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentPosting, loadOptions);
 		}		
		
		return accountingDocumentPosting;
		
	}



	
	
	
		
	protected AccountingDocumentPosting extractAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options){
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByPosting(accountingDocumentPosting.getId(),options);
		if(accountingDocumentList != null){
			accountingDocumentPosting.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentPosting;
	
	}	
		
		
 	
		
		
		

	

	protected AccountingDocumentPosting saveAccountingDocumentPosting(AccountingDocumentPosting  accountingDocumentPosting){
	
		String SQL=this.getSaveAccountingDocumentPostingSQL(accountingDocumentPosting);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentPostingParameters(accountingDocumentPosting);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentPosting.incVersion();
		return accountingDocumentPosting;
	
	}
	public SmartList<AccountingDocumentPosting> saveAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentPostingList(accountingDocumentPostingList);
		
		batchAccountingDocumentPostingCreate((List<AccountingDocumentPosting>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentPostingUpdate((List<AccountingDocumentPosting>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentPosting accountingDocumentPosting:accountingDocumentPostingList){
			if(accountingDocumentPosting.isChanged()){
				accountingDocumentPosting.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentPostingList;
	}

	public SmartList<AccountingDocumentPosting> removeAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentPostingList, options);
		
		return accountingDocumentPostingList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentPostingBatchCreateArgs(List<AccountingDocumentPosting> accountingDocumentPostingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentPosting accountingDocumentPosting:accountingDocumentPostingList ){
			Object [] parameters = prepareAccountingDocumentPostingCreateParameters(accountingDocumentPosting);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentPostingBatchUpdateArgs(List<AccountingDocumentPosting> accountingDocumentPostingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentPosting accountingDocumentPosting:accountingDocumentPostingList ){
			if(!accountingDocumentPosting.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentPostingUpdateParameters(accountingDocumentPosting);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentPostingCreate(List<AccountingDocumentPosting> accountingDocumentPostingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentPostingBatchCreateArgs(accountingDocumentPostingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentPostingUpdate(List<AccountingDocumentPosting> accountingDocumentPostingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentPostingBatchUpdateArgs(accountingDocumentPostingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentPostingList(List<AccountingDocumentPosting> accountingDocumentPostingList){
		
		List<AccountingDocumentPosting> accountingDocumentPostingCreateList=new ArrayList<AccountingDocumentPosting>();
		List<AccountingDocumentPosting> accountingDocumentPostingUpdateList=new ArrayList<AccountingDocumentPosting>();
		
		for(AccountingDocumentPosting accountingDocumentPosting: accountingDocumentPostingList){
			if(isUpdateRequest(accountingDocumentPosting)){
				accountingDocumentPostingUpdateList.add( accountingDocumentPosting);
				continue;
			}
			accountingDocumentPostingCreateList.add(accountingDocumentPosting);
		}
		
		return new Object[]{accountingDocumentPostingCreateList,accountingDocumentPostingUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentPosting accountingDocumentPosting){
 		return accountingDocumentPosting.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentPostingSQL(AccountingDocumentPosting accountingDocumentPosting){
 		if(isUpdateRequest(accountingDocumentPosting)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentPostingParameters(AccountingDocumentPosting accountingDocumentPosting){
 		if(isUpdateRequest(accountingDocumentPosting) ){
 			return prepareAccountingDocumentPostingUpdateParameters(accountingDocumentPosting);
 		}
 		return prepareAccountingDocumentPostingCreateParameters(accountingDocumentPosting);
 	}
 	protected Object[] prepareAccountingDocumentPostingUpdateParameters(AccountingDocumentPosting accountingDocumentPosting){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = accountingDocumentPosting.getWho();
 		parameters[1] = accountingDocumentPosting.getComments();
 		parameters[2] = accountingDocumentPosting.getMakeDate();		
 		parameters[3] = accountingDocumentPosting.getId();
 		parameters[4] = accountingDocumentPosting.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentPostingCreateParameters(AccountingDocumentPosting accountingDocumentPosting){
		Object[] parameters = new Object[4];
		String newAccountingDocumentPostingId=getNextId();
		accountingDocumentPosting.setId(newAccountingDocumentPostingId);
		parameters[0] =  accountingDocumentPosting.getId();
 
 		parameters[1] = accountingDocumentPosting.getWho();
 		parameters[2] = accountingDocumentPosting.getComments();
 		parameters[3] = accountingDocumentPosting.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentPosting saveInternalAccountingDocumentPosting(AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options){
		
		saveAccountingDocumentPosting(accountingDocumentPosting);

		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentPosting, options);
	 		removeAccountingDocumentList(accountingDocumentPosting, options);
	 		
 		}		
		
		return accountingDocumentPosting;
		
	}
	
	
	
	//======================================================================================
	
		
	protected AccountingDocumentPosting saveAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options){
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentPosting;
		}
		if(accountingDocumentList.isEmpty()){
			return accountingDocumentPosting;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingDocumentDAO().saveAccountingDocumentList(accountingDocumentList,options);
		
		return accountingDocumentPosting;
	
	}
	
	protected AccountingDocumentPosting removeAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentPosting;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentPosting;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentPosting;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentPosting;
	
	}
	
	
	
 	
 	
	
	
	
		

	public AccountingDocumentPosting present(AccountingDocumentPosting accountingDocumentPosting,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentPosting,options);

		return accountingDocumentPosting;
	
	}
		
	
  	
 	protected AccountingDocumentPosting presentAccountingDocumentList(
			AccountingDocumentPosting accountingDocumentPosting,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();		
		if(accountingDocumentList == null){
			return accountingDocumentPosting;			
		}
		
		String targetObjectName = "accountingDocument";
		int accountingDocumentListSize = accountingDocumentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingDocumentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountingDocumentPosting;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingDocumentListSize;
		if(accountingDocumentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingDocumentDAO().countAccountingDocumentByPosting(accountingDocumentPosting.getId(), options);			
		}
		//accountingDocumentPosting.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountingDocumentPosting.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingDocumentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingDocumentListSize,currentPage,rowsPerPage) ;
			accountingDocumentList = accountingDocumentList.subListOf(fromIndex, toIndex);
			accountingDocumentList.setTotalCount(count);
			accountingDocumentList.setCurrentPageNumber(currentPage);			
			accountingDocumentPosting.setAccountingDocumentList(accountingDocumentList);
			return accountingDocumentPosting;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingDocumentList 
			= getAccountingDocumentDAO().findAccountingDocumentByPosting(accountingDocumentPosting.getId(),start, rowsPerPage, options );
		accountingDocumentList.setTotalCount(count);
		accountingDocumentList.setCurrentPageNumber(currentPage);
		accountingDocumentPosting.setAccountingDocumentList(accountingDocumentList );	

		return accountingDocumentPosting;
	}			
		


	protected String getTableName(){
		return AccountingDocumentPostingTable.TABLE_NAME;
	}
}


