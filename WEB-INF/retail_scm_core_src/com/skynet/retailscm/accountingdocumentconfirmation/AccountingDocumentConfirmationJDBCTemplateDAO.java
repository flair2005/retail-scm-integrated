
package com.skynet.retailscm.accountingdocumentconfirmation;

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

public class AccountingDocumentConfirmationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountingDocumentConfirmationDAO{

		
	
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
	protected AccountingDocumentConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentConfirmation(accessKey, options);
	}
	*/
	public AccountingDocumentConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentConfirmation(AccountingDocumentConfirmationTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentConfirmation save(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentConfirmation, methodName, "accountingDocumentConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentConfirmation(accountingDocumentConfirmation,options);
	}
	public AccountingDocumentConfirmation clone(String accountingDocumentConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentConfirmationTable.withId(accountingDocumentConfirmationId),options);
	}
	
	protected AccountingDocumentConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentConfirmation newAccountingDocumentConfirmation = loadInternalAccountingDocumentConfirmation(accessKey, options);
		newAccountingDocumentConfirmation.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentConfirmation.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentConfirmation(newAccountingDocumentConfirmation,options);
		
		return newAccountingDocumentConfirmation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountingDocumentConfirmationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountingDocumentConfirmationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountingDocumentConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountingDocumentConfirmationId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentConfirmationId, int version)";
		assertMethodArgumentNotNull(accountingDocumentConfirmationId, methodName, "accountingDocumentConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentConfirmationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentConfirmationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","comments","make_date"};
		return AccountingDocumentConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_confirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingDocumentConfirmationTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentConfirmationTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingDocumentConfirmationMapper getAccountingDocumentConfirmationMapper(){
		return new AccountingDocumentConfirmationMapper();
	}
	protected AccountingDocumentConfirmation extractAccountingDocumentConfirmation(String accountingDocumentConfirmationId) throws Exception{
		String SQL = "select * from accounting_document_confirmation_data where id = ?";	
		try{
		
			AccountingDocumentConfirmation accountingDocumentConfirmation = queryForObject(SQL, new Object[]{accountingDocumentConfirmationId}, getAccountingDocumentConfirmationMapper());
			return accountingDocumentConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentConfirmationNotFoundException("AccountingDocumentConfirmation("+accountingDocumentConfirmationId+") is not found!");
		}
		
		
	}
	protected AccountingDocumentConfirmation extractAccountingDocumentConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from accounting_document_confirmation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountingDocumentConfirmation accountingDocumentConfirmation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountingDocumentConfirmationMapper());
			return accountingDocumentConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentConfirmationNotFoundException("AccountingDocumentConfirmation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountingDocumentConfirmation loadInternalAccountingDocumentConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = extractAccountingDocumentConfirmation(accessKey, loadOptions);

		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentConfirmation, loadOptions);
 		}		
		
		return accountingDocumentConfirmation;
		
	}



	
	
	
		
	protected AccountingDocumentConfirmation extractAccountingDocumentList(AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options){
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByConfirmation(accountingDocumentConfirmation.getId(),options);
		if(accountingDocumentList != null){
			accountingDocumentConfirmation.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentConfirmation;
	
	}	
		
		
 	
		
		
		

	

	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmation(AccountingDocumentConfirmation  accountingDocumentConfirmation){
	
		String SQL=this.getSaveAccountingDocumentConfirmationSQL(accountingDocumentConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentConfirmationParameters(accountingDocumentConfirmation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentConfirmation.incVersion();
		return accountingDocumentConfirmation;
	
	}
	public SmartList<AccountingDocumentConfirmation> saveAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentConfirmationList(accountingDocumentConfirmationList);
		
		batchAccountingDocumentConfirmationCreate((List<AccountingDocumentConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentConfirmationUpdate((List<AccountingDocumentConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentConfirmation accountingDocumentConfirmation:accountingDocumentConfirmationList){
			if(accountingDocumentConfirmation.isChanged()){
				accountingDocumentConfirmation.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentConfirmationList;
	}

	public SmartList<AccountingDocumentConfirmation> removeAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentConfirmationList, options);
		
		return accountingDocumentConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentConfirmationBatchCreateArgs(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentConfirmation accountingDocumentConfirmation:accountingDocumentConfirmationList ){
			Object [] parameters = prepareAccountingDocumentConfirmationCreateParameters(accountingDocumentConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentConfirmationBatchUpdateArgs(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentConfirmation accountingDocumentConfirmation:accountingDocumentConfirmationList ){
			if(!accountingDocumentConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentConfirmationUpdateParameters(accountingDocumentConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentConfirmationCreate(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentConfirmationBatchCreateArgs(accountingDocumentConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentConfirmationUpdate(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentConfirmationBatchUpdateArgs(accountingDocumentConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentConfirmationList(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		
		List<AccountingDocumentConfirmation> accountingDocumentConfirmationCreateList=new ArrayList<AccountingDocumentConfirmation>();
		List<AccountingDocumentConfirmation> accountingDocumentConfirmationUpdateList=new ArrayList<AccountingDocumentConfirmation>();
		
		for(AccountingDocumentConfirmation accountingDocumentConfirmation: accountingDocumentConfirmationList){
			if(isUpdateRequest(accountingDocumentConfirmation)){
				accountingDocumentConfirmationUpdateList.add( accountingDocumentConfirmation);
				continue;
			}
			accountingDocumentConfirmationCreateList.add(accountingDocumentConfirmation);
		}
		
		return new Object[]{accountingDocumentConfirmationCreateList,accountingDocumentConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentConfirmation accountingDocumentConfirmation){
 		return accountingDocumentConfirmation.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentConfirmationSQL(AccountingDocumentConfirmation accountingDocumentConfirmation){
 		if(isUpdateRequest(accountingDocumentConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentConfirmationParameters(AccountingDocumentConfirmation accountingDocumentConfirmation){
 		if(isUpdateRequest(accountingDocumentConfirmation) ){
 			return prepareAccountingDocumentConfirmationUpdateParameters(accountingDocumentConfirmation);
 		}
 		return prepareAccountingDocumentConfirmationCreateParameters(accountingDocumentConfirmation);
 	}
 	protected Object[] prepareAccountingDocumentConfirmationUpdateParameters(AccountingDocumentConfirmation accountingDocumentConfirmation){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = accountingDocumentConfirmation.getWho();
 		parameters[1] = accountingDocumentConfirmation.getComments();
 		parameters[2] = accountingDocumentConfirmation.getMakeDate();		
 		parameters[3] = accountingDocumentConfirmation.getId();
 		parameters[4] = accountingDocumentConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentConfirmationCreateParameters(AccountingDocumentConfirmation accountingDocumentConfirmation){
		Object[] parameters = new Object[4];
		String newAccountingDocumentConfirmationId=getNextId();
		accountingDocumentConfirmation.setId(newAccountingDocumentConfirmationId);
		parameters[0] =  accountingDocumentConfirmation.getId();
 
 		parameters[1] = accountingDocumentConfirmation.getWho();
 		parameters[2] = accountingDocumentConfirmation.getComments();
 		parameters[3] = accountingDocumentConfirmation.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentConfirmation saveInternalAccountingDocumentConfirmation(AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options){
		
		saveAccountingDocumentConfirmation(accountingDocumentConfirmation);

		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentConfirmation, options);
	 		removeAccountingDocumentList(accountingDocumentConfirmation, options);
	 		
 		}		
		
		return accountingDocumentConfirmation;
		
	}
	
	
	
	//======================================================================================
	
		
	protected AccountingDocumentConfirmation saveAccountingDocumentList(AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options){
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentConfirmation;
		}
		if(accountingDocumentList.isEmpty()){
			return accountingDocumentConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingDocumentDAO().saveAccountingDocumentList(accountingDocumentList,options);
		
		return accountingDocumentConfirmation;
	
	}
	
	protected AccountingDocumentConfirmation removeAccountingDocumentList(AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentConfirmation;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentConfirmation;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentConfirmation;
	
	}
	
	
	
 	
 	
	
	
	
		

	public AccountingDocumentConfirmation present(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentConfirmation,options);

		return accountingDocumentConfirmation;
	
	}
		
	
  	
 	protected AccountingDocumentConfirmation presentAccountingDocumentList(
			AccountingDocumentConfirmation accountingDocumentConfirmation,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();		
		if(accountingDocumentList == null){
			return accountingDocumentConfirmation;			
		}
		
		String targetObjectName = "accountingDocument";
		int accountingDocumentListSize = accountingDocumentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingDocumentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountingDocumentConfirmation;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingDocumentListSize;
		if(accountingDocumentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingDocumentDAO().countAccountingDocumentByConfirmation(accountingDocumentConfirmation.getId(), options);			
		}
		//accountingDocumentConfirmation.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountingDocumentConfirmation.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingDocumentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingDocumentListSize,currentPage,rowsPerPage) ;
			accountingDocumentList = accountingDocumentList.subListOf(fromIndex, toIndex);
			accountingDocumentList.setTotalCount(count);
			accountingDocumentList.setCurrentPageNumber(currentPage);			
			accountingDocumentConfirmation.setAccountingDocumentList(accountingDocumentList);
			return accountingDocumentConfirmation;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingDocumentList 
			= getAccountingDocumentDAO().findAccountingDocumentByConfirmation(accountingDocumentConfirmation.getId(),start, rowsPerPage, options );
		accountingDocumentList.setTotalCount(count);
		accountingDocumentList.setCurrentPageNumber(currentPage);
		accountingDocumentConfirmation.setAccountingDocumentList(accountingDocumentList );	

		return accountingDocumentConfirmation;
	}			
		


	protected String getTableName(){
		return AccountingDocumentConfirmationTable.TABLE_NAME;
	}
}


