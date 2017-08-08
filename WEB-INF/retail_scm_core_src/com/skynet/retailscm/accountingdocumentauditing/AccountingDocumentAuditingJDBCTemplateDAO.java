
package com.skynet.retailscm.accountingdocumentauditing;

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

public class AccountingDocumentAuditingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountingDocumentAuditingDAO{

		
	
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
	protected AccountingDocumentAuditing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentAuditing(accessKey, options);
	}
	*/
	public AccountingDocumentAuditing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentAuditing(AccountingDocumentAuditingTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentAuditing save(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentAuditing, methodName, "accountingDocumentAuditing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentAuditing(accountingDocumentAuditing,options);
	}
	public AccountingDocumentAuditing clone(String accountingDocumentAuditingId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentAuditingTable.withId(accountingDocumentAuditingId),options);
	}
	
	protected AccountingDocumentAuditing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentAuditingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentAuditing newAccountingDocumentAuditing = loadInternalAccountingDocumentAuditing(accessKey, options);
		newAccountingDocumentAuditing.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentAuditing.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentAuditing(newAccountingDocumentAuditing,options);
		
		return newAccountingDocumentAuditing;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountingDocumentAuditingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountingDocumentAuditingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountingDocumentAuditingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentAuditingNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentAuditingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountingDocumentAuditingId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentAuditingId, int version)";
		assertMethodArgumentNotNull(accountingDocumentAuditingId, methodName, "accountingDocumentAuditingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentAuditingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentAuditingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","comments","make_date"};
		return AccountingDocumentAuditingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_auditing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentAuditingTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingDocumentAuditingTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentAuditingTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingDocumentAuditingMapper getAccountingDocumentAuditingMapper(){
		return new AccountingDocumentAuditingMapper();
	}
	protected AccountingDocumentAuditing extractAccountingDocumentAuditing(String accountingDocumentAuditingId) throws Exception{
		String SQL = "select * from accounting_document_auditing_data where id = ?";	
		try{
		
			AccountingDocumentAuditing accountingDocumentAuditing = queryForObject(SQL, new Object[]{accountingDocumentAuditingId}, getAccountingDocumentAuditingMapper());
			return accountingDocumentAuditing;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentAuditingNotFoundException("AccountingDocumentAuditing("+accountingDocumentAuditingId+") is not found!");
		}
		
		
	}
	protected AccountingDocumentAuditing extractAccountingDocumentAuditing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from accounting_document_auditing_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountingDocumentAuditing accountingDocumentAuditing = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountingDocumentAuditingMapper());
			return accountingDocumentAuditing;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentAuditingNotFoundException("AccountingDocumentAuditing("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountingDocumentAuditing loadInternalAccountingDocumentAuditing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentAuditing accountingDocumentAuditing = extractAccountingDocumentAuditing(accessKey, loadOptions);

		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentAuditing, loadOptions);
 		}		
		
		return accountingDocumentAuditing;
		
	}



	
	
	
		
	protected AccountingDocumentAuditing extractAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options){
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByAuditing(accountingDocumentAuditing.getId(),options);
		if(accountingDocumentList != null){
			accountingDocumentAuditing.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentAuditing;
	
	}	
		
		
 	
		
		
		

	

	protected AccountingDocumentAuditing saveAccountingDocumentAuditing(AccountingDocumentAuditing  accountingDocumentAuditing){
	
		String SQL=this.getSaveAccountingDocumentAuditingSQL(accountingDocumentAuditing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentAuditingParameters(accountingDocumentAuditing);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentAuditing.incVersion();
		return accountingDocumentAuditing;
	
	}
	public SmartList<AccountingDocumentAuditing> saveAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentAuditingList(accountingDocumentAuditingList);
		
		batchAccountingDocumentAuditingCreate((List<AccountingDocumentAuditing>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentAuditingUpdate((List<AccountingDocumentAuditing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentAuditing accountingDocumentAuditing:accountingDocumentAuditingList){
			if(accountingDocumentAuditing.isChanged()){
				accountingDocumentAuditing.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentAuditingList;
	}

	public SmartList<AccountingDocumentAuditing> removeAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentAuditingList, options);
		
		return accountingDocumentAuditingList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentAuditingBatchCreateArgs(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentAuditing accountingDocumentAuditing:accountingDocumentAuditingList ){
			Object [] parameters = prepareAccountingDocumentAuditingCreateParameters(accountingDocumentAuditing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentAuditingBatchUpdateArgs(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentAuditing accountingDocumentAuditing:accountingDocumentAuditingList ){
			if(!accountingDocumentAuditing.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentAuditingUpdateParameters(accountingDocumentAuditing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentAuditingCreate(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentAuditingBatchCreateArgs(accountingDocumentAuditingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentAuditingUpdate(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentAuditingBatchUpdateArgs(accountingDocumentAuditingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentAuditingList(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		
		List<AccountingDocumentAuditing> accountingDocumentAuditingCreateList=new ArrayList<AccountingDocumentAuditing>();
		List<AccountingDocumentAuditing> accountingDocumentAuditingUpdateList=new ArrayList<AccountingDocumentAuditing>();
		
		for(AccountingDocumentAuditing accountingDocumentAuditing: accountingDocumentAuditingList){
			if(isUpdateRequest(accountingDocumentAuditing)){
				accountingDocumentAuditingUpdateList.add( accountingDocumentAuditing);
				continue;
			}
			accountingDocumentAuditingCreateList.add(accountingDocumentAuditing);
		}
		
		return new Object[]{accountingDocumentAuditingCreateList,accountingDocumentAuditingUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentAuditing accountingDocumentAuditing){
 		return accountingDocumentAuditing.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentAuditingSQL(AccountingDocumentAuditing accountingDocumentAuditing){
 		if(isUpdateRequest(accountingDocumentAuditing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentAuditingParameters(AccountingDocumentAuditing accountingDocumentAuditing){
 		if(isUpdateRequest(accountingDocumentAuditing) ){
 			return prepareAccountingDocumentAuditingUpdateParameters(accountingDocumentAuditing);
 		}
 		return prepareAccountingDocumentAuditingCreateParameters(accountingDocumentAuditing);
 	}
 	protected Object[] prepareAccountingDocumentAuditingUpdateParameters(AccountingDocumentAuditing accountingDocumentAuditing){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = accountingDocumentAuditing.getWho();
 		parameters[1] = accountingDocumentAuditing.getComments();
 		parameters[2] = accountingDocumentAuditing.getMakeDate();		
 		parameters[3] = accountingDocumentAuditing.getId();
 		parameters[4] = accountingDocumentAuditing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentAuditingCreateParameters(AccountingDocumentAuditing accountingDocumentAuditing){
		Object[] parameters = new Object[4];
		String newAccountingDocumentAuditingId=getNextId();
		accountingDocumentAuditing.setId(newAccountingDocumentAuditingId);
		parameters[0] =  accountingDocumentAuditing.getId();
 
 		parameters[1] = accountingDocumentAuditing.getWho();
 		parameters[2] = accountingDocumentAuditing.getComments();
 		parameters[3] = accountingDocumentAuditing.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentAuditing saveInternalAccountingDocumentAuditing(AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options){
		
		saveAccountingDocumentAuditing(accountingDocumentAuditing);

		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentAuditing, options);
	 		removeAccountingDocumentList(accountingDocumentAuditing, options);
	 		
 		}		
		
		return accountingDocumentAuditing;
		
	}
	
	
	
	//======================================================================================
	
		
	protected AccountingDocumentAuditing saveAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options){
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentAuditing;
		}
		if(accountingDocumentList.isEmpty()){
			return accountingDocumentAuditing;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingDocumentDAO().saveAccountingDocumentList(accountingDocumentList,options);
		
		return accountingDocumentAuditing;
	
	}
	
	protected AccountingDocumentAuditing removeAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentAuditing;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentAuditing;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentAuditing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentAuditing;
	
	}
	
	
	
 	
 	
	
	
	
		

	public AccountingDocumentAuditing present(AccountingDocumentAuditing accountingDocumentAuditing,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentAuditing,options);

		return accountingDocumentAuditing;
	
	}
		
	
  	
 	protected AccountingDocumentAuditing presentAccountingDocumentList(
			AccountingDocumentAuditing accountingDocumentAuditing,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();		
		if(accountingDocumentList == null){
			return accountingDocumentAuditing;			
		}
		
		String targetObjectName = "accountingDocument";
		int accountingDocumentListSize = accountingDocumentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingDocumentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountingDocumentAuditing;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingDocumentListSize;
		if(accountingDocumentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingDocumentDAO().countAccountingDocumentByAuditing(accountingDocumentAuditing.getId(), options);			
		}
		//accountingDocumentAuditing.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountingDocumentAuditing.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingDocumentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingDocumentListSize,currentPage,rowsPerPage) ;
			accountingDocumentList = accountingDocumentList.subListOf(fromIndex, toIndex);
			accountingDocumentList.setTotalCount(count);
			accountingDocumentList.setCurrentPageNumber(currentPage);			
			accountingDocumentAuditing.setAccountingDocumentList(accountingDocumentList);
			return accountingDocumentAuditing;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingDocumentList 
			= getAccountingDocumentDAO().findAccountingDocumentByAuditing(accountingDocumentAuditing.getId(),start, rowsPerPage, options );
		accountingDocumentList.setTotalCount(count);
		accountingDocumentList.setCurrentPageNumber(currentPage);
		accountingDocumentAuditing.setAccountingDocumentList(accountingDocumentList );	

		return accountingDocumentAuditing;
	}			
		


	protected String getTableName(){
		return AccountingDocumentAuditingTable.TABLE_NAME;
	}
}


