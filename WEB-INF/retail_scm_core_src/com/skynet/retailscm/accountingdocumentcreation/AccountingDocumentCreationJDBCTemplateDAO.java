
package com.skynet.retailscm.accountingdocumentcreation;

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

public class AccountingDocumentCreationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountingDocumentCreationDAO{

		
	
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
	protected AccountingDocumentCreation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentCreation(accessKey, options);
	}
	*/
	public AccountingDocumentCreation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentCreation(AccountingDocumentCreationTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentCreation save(AccountingDocumentCreation accountingDocumentCreation,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentCreation accountingDocumentCreation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentCreation, methodName, "accountingDocumentCreation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentCreation(accountingDocumentCreation,options);
	}
	public AccountingDocumentCreation clone(String accountingDocumentCreationId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentCreationTable.withId(accountingDocumentCreationId),options);
	}
	
	protected AccountingDocumentCreation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentCreationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentCreation newAccountingDocumentCreation = loadInternalAccountingDocumentCreation(accessKey, options);
		newAccountingDocumentCreation.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentCreation.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentCreation(newAccountingDocumentCreation,options);
		
		return newAccountingDocumentCreation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountingDocumentCreationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountingDocumentCreationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountingDocumentCreationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentCreationNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentCreationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountingDocumentCreationId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentCreationId, int version)";
		assertMethodArgumentNotNull(accountingDocumentCreationId, methodName, "accountingDocumentCreationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentCreationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentCreationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","comments","make_date"};
		return AccountingDocumentCreationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_creation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentCreationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingDocumentCreationTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentCreationTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingDocumentCreationMapper getAccountingDocumentCreationMapper(){
		return new AccountingDocumentCreationMapper();
	}
	protected AccountingDocumentCreation extractAccountingDocumentCreation(String accountingDocumentCreationId) throws Exception{
		String SQL = "select * from accounting_document_creation_data where id = ?";	
		try{
		
			AccountingDocumentCreation accountingDocumentCreation = queryForObject(SQL, new Object[]{accountingDocumentCreationId}, getAccountingDocumentCreationMapper());
			return accountingDocumentCreation;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentCreationNotFoundException("AccountingDocumentCreation("+accountingDocumentCreationId+") is not found!");
		}
		
		
	}
	protected AccountingDocumentCreation extractAccountingDocumentCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from accounting_document_creation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountingDocumentCreation accountingDocumentCreation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountingDocumentCreationMapper());
			return accountingDocumentCreation;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentCreationNotFoundException("AccountingDocumentCreation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountingDocumentCreation loadInternalAccountingDocumentCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentCreation accountingDocumentCreation = extractAccountingDocumentCreation(accessKey, loadOptions);

		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentCreation, loadOptions);
 		}		
		
		return accountingDocumentCreation;
		
	}



	
	
	
		
	protected AccountingDocumentCreation extractAccountingDocumentList(AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options){
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByCreation(accountingDocumentCreation.getId(),options);
		if(accountingDocumentList != null){
			accountingDocumentCreation.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentCreation;
	
	}	
		
		
 	
		
		
		

	

	protected AccountingDocumentCreation saveAccountingDocumentCreation(AccountingDocumentCreation  accountingDocumentCreation){
	
		String SQL=this.getSaveAccountingDocumentCreationSQL(accountingDocumentCreation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentCreationParameters(accountingDocumentCreation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentCreation.incVersion();
		return accountingDocumentCreation;
	
	}
	public SmartList<AccountingDocumentCreation> saveAccountingDocumentCreationList(SmartList<AccountingDocumentCreation> accountingDocumentCreationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentCreationList(accountingDocumentCreationList);
		
		batchAccountingDocumentCreationCreate((List<AccountingDocumentCreation>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentCreationUpdate((List<AccountingDocumentCreation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentCreation accountingDocumentCreation:accountingDocumentCreationList){
			if(accountingDocumentCreation.isChanged()){
				accountingDocumentCreation.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentCreationList;
	}

	public SmartList<AccountingDocumentCreation> removeAccountingDocumentCreationList(SmartList<AccountingDocumentCreation> accountingDocumentCreationList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentCreationList, options);
		
		return accountingDocumentCreationList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentCreationBatchCreateArgs(List<AccountingDocumentCreation> accountingDocumentCreationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentCreation accountingDocumentCreation:accountingDocumentCreationList ){
			Object [] parameters = prepareAccountingDocumentCreationCreateParameters(accountingDocumentCreation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentCreationBatchUpdateArgs(List<AccountingDocumentCreation> accountingDocumentCreationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentCreation accountingDocumentCreation:accountingDocumentCreationList ){
			if(!accountingDocumentCreation.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentCreationUpdateParameters(accountingDocumentCreation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentCreationCreate(List<AccountingDocumentCreation> accountingDocumentCreationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentCreationBatchCreateArgs(accountingDocumentCreationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentCreationUpdate(List<AccountingDocumentCreation> accountingDocumentCreationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentCreationBatchUpdateArgs(accountingDocumentCreationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentCreationList(List<AccountingDocumentCreation> accountingDocumentCreationList){
		
		List<AccountingDocumentCreation> accountingDocumentCreationCreateList=new ArrayList<AccountingDocumentCreation>();
		List<AccountingDocumentCreation> accountingDocumentCreationUpdateList=new ArrayList<AccountingDocumentCreation>();
		
		for(AccountingDocumentCreation accountingDocumentCreation: accountingDocumentCreationList){
			if(isUpdateRequest(accountingDocumentCreation)){
				accountingDocumentCreationUpdateList.add( accountingDocumentCreation);
				continue;
			}
			accountingDocumentCreationCreateList.add(accountingDocumentCreation);
		}
		
		return new Object[]{accountingDocumentCreationCreateList,accountingDocumentCreationUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentCreation accountingDocumentCreation){
 		return accountingDocumentCreation.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentCreationSQL(AccountingDocumentCreation accountingDocumentCreation){
 		if(isUpdateRequest(accountingDocumentCreation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentCreationParameters(AccountingDocumentCreation accountingDocumentCreation){
 		if(isUpdateRequest(accountingDocumentCreation) ){
 			return prepareAccountingDocumentCreationUpdateParameters(accountingDocumentCreation);
 		}
 		return prepareAccountingDocumentCreationCreateParameters(accountingDocumentCreation);
 	}
 	protected Object[] prepareAccountingDocumentCreationUpdateParameters(AccountingDocumentCreation accountingDocumentCreation){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = accountingDocumentCreation.getWho();
 		parameters[1] = accountingDocumentCreation.getComments();
 		parameters[2] = accountingDocumentCreation.getMakeDate();		
 		parameters[3] = accountingDocumentCreation.getId();
 		parameters[4] = accountingDocumentCreation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentCreationCreateParameters(AccountingDocumentCreation accountingDocumentCreation){
		Object[] parameters = new Object[4];
		String newAccountingDocumentCreationId=getNextId();
		accountingDocumentCreation.setId(newAccountingDocumentCreationId);
		parameters[0] =  accountingDocumentCreation.getId();
 
 		parameters[1] = accountingDocumentCreation.getWho();
 		parameters[2] = accountingDocumentCreation.getComments();
 		parameters[3] = accountingDocumentCreation.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentCreation saveInternalAccountingDocumentCreation(AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options){
		
		saveAccountingDocumentCreation(accountingDocumentCreation);

		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentCreation, options);
	 		removeAccountingDocumentList(accountingDocumentCreation, options);
	 		
 		}		
		
		return accountingDocumentCreation;
		
	}
	
	
	
	//======================================================================================
	
		
	protected AccountingDocumentCreation saveAccountingDocumentList(AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options){
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentCreation;
		}
		if(accountingDocumentList.isEmpty()){
			return accountingDocumentCreation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingDocumentDAO().saveAccountingDocumentList(accountingDocumentList,options);
		
		return accountingDocumentCreation;
	
	}
	
	protected AccountingDocumentCreation removeAccountingDocumentList(AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentCreation;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentCreation;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentCreation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentCreation;
	
	}
	
	
	
 	
 	
	
	
	
		

	public AccountingDocumentCreation present(AccountingDocumentCreation accountingDocumentCreation,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentCreation,options);

		return accountingDocumentCreation;
	
	}
		
	
  	
 	protected AccountingDocumentCreation presentAccountingDocumentList(
			AccountingDocumentCreation accountingDocumentCreation,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();		
		if(accountingDocumentList == null){
			return accountingDocumentCreation;			
		}
		
		String targetObjectName = "accountingDocument";
		int accountingDocumentListSize = accountingDocumentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingDocumentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountingDocumentCreation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingDocumentListSize;
		if(accountingDocumentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingDocumentDAO().countAccountingDocumentByCreation(accountingDocumentCreation.getId(), options);			
		}
		//accountingDocumentCreation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountingDocumentCreation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingDocumentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingDocumentListSize,currentPage,rowsPerPage) ;
			accountingDocumentList = accountingDocumentList.subListOf(fromIndex, toIndex);
			accountingDocumentList.setTotalCount(count);
			accountingDocumentList.setCurrentPageNumber(currentPage);			
			accountingDocumentCreation.setAccountingDocumentList(accountingDocumentList);
			return accountingDocumentCreation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingDocumentList 
			= getAccountingDocumentDAO().findAccountingDocumentByCreation(accountingDocumentCreation.getId(),start, rowsPerPage, options );
		accountingDocumentList.setTotalCount(count);
		accountingDocumentList.setCurrentPageNumber(currentPage);
		accountingDocumentCreation.setAccountingDocumentList(accountingDocumentList );	

		return accountingDocumentCreation;
	}			
		


	protected String getTableName(){
		return AccountingDocumentCreationTable.TABLE_NAME;
	}
}


