
package com.skynet.retailscm.accountingsubject;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;

import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLineDAO;
import com.skynet.retailscm.accountset.AccountSetDAO;

import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLineTable;
import com.skynet.retailscm.accountset.AccountSetTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class AccountingSubjectJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountingSubjectDAO{
 
 	
 	private  AccountSetDAO  accountSetDAO;
 	public void setAccountSetDAO(AccountSetDAO accountSetDAO){
	 	this.accountSetDAO = accountSetDAO;
 	}
 	public AccountSetDAO getAccountSetDAO(){
	 	return this.accountSetDAO;
 	}

		
	
  	private  AccountingDocumentLineDAO  accountingDocumentLineDAO;
 	public void setAccountingDocumentLineDAO(AccountingDocumentLineDAO pAccountingDocumentLineDAO){
 	
 		if(pAccountingDocumentLineDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentLineDAO to null.");
 		}
	 	this.accountingDocumentLineDAO = pAccountingDocumentLineDAO;
 	}
 	public AccountingDocumentLineDAO getAccountingDocumentLineDAO(){
 		if(this.accountingDocumentLineDAO == null){
 			throw new IllegalStateException("The accountingDocumentLineDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentLineDAO;
 	}	
 	
			
		

	
	/*
	protected AccountingSubject load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingSubject(accessKey, options);
	}
	*/
	public AccountingSubject load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingSubject(AccountingSubjectTable.withId(id), options);
	}
	
	
	
	public AccountingSubject save(AccountingSubject accountingSubject,Map<String,Object> options){
		
		String methodName="save(AccountingSubject accountingSubject,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingSubject, methodName, "accountingSubject");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingSubject(accountingSubject,options);
	}
	public AccountingSubject clone(String accountingSubjectId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingSubjectTable.withId(accountingSubjectId),options);
	}
	
	protected AccountingSubject clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingSubjectId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingSubject newAccountingSubject = loadInternalAccountingSubject(accessKey, options);
		newAccountingSubject.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentLineListEnabled(options)){
 			for(AccountingDocumentLine item: newAccountingSubject.getAccountingDocumentLineList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingSubject(newAccountingSubject,options);
		
		return newAccountingSubject;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountingSubjectId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountingSubjectId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountingSubjectVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingSubjectNotFoundException(
					"The " + this.getTableName() + "(" + accountingSubjectId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountingSubjectId, int version) throws Exception{
	
		String methodName="delete(String accountingSubjectId, int version)";
		assertMethodArgumentNotNull(accountingSubjectId, methodName, "accountingSubjectId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingSubjectId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingSubjectId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"accounting_subject_code","accounting_subject_name","accounting_subject_class_code","accounting_subject_class_name","account_set"};
		return AccountingSubjectTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_subject";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingSubjectTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractAccountSetEnabled = true;
 	//private static final String ACCOUNTSET = "accountSet";
 	protected boolean isExtractAccountSetEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingSubjectTokens.ACCOUNTSET);
 	}
 	
 	
 	//private boolean saveAccountSetEnabled = true;
 	protected boolean isSaveAccountSetEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingSubjectTokens.ACCOUNTSET);
 	}
 	

 	
 
		
	//protected static final String ACCOUNTING_DOCUMENT_LINE_LIST = "accountingDocumentLineList";
	
	protected boolean isExtractAccountingDocumentLineListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingSubjectTokens.ACCOUNTING_DOCUMENT_LINE_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentLineListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingSubjectTokens.ACCOUNTING_DOCUMENT_LINE_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingSubjectMapper getAccountingSubjectMapper(){
		return new AccountingSubjectMapper();
	}
	protected AccountingSubject extractAccountingSubject(String accountingSubjectId) throws Exception{
		String SQL = "select * from accounting_subject_data where id = ?";	
		try{
		
			AccountingSubject accountingSubject = queryForObject(SQL, new Object[]{accountingSubjectId}, getAccountingSubjectMapper());
			return accountingSubject;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingSubjectNotFoundException("AccountingSubject("+accountingSubjectId+") is not found!");
		}
		
		
	}
	protected AccountingSubject extractAccountingSubject(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from accounting_subject_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountingSubject accountingSubject = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountingSubjectMapper());
			return accountingSubject;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingSubjectNotFoundException("AccountingSubject("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountingSubject loadInternalAccountingSubject(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingSubject accountingSubject = extractAccountingSubject(accessKey, loadOptions);
 	
 		if(isExtractAccountSetEnabled(loadOptions)){
	 		extractAccountSet(accountingSubject, loadOptions);
 		}
 
		
		if(isExtractAccountingDocumentLineListEnabled(loadOptions)){
	 		extractAccountingDocumentLineList(accountingSubject, loadOptions);
 		}		
		
		return accountingSubject;
		
	}



	
	
	 

 	protected AccountingSubject extractAccountSet(AccountingSubject accountingSubject, Map<String,Object> options) throws Exception{

		if(accountingSubject.getAccountSet() == null){
			return accountingSubject;
		}
		String accountSetId = accountingSubject.getAccountSet().getId();
		if( accountSetId == null){
			return accountingSubject;
		}
		AccountSet accountSet = getAccountSetDAO().load(accountSetId,options);
		if(accountSet != null){
			accountingSubject.setAccountSet(accountSet);
		}
		
 		
 		return accountingSubject;
 	}
 		
 
		
	protected AccountingSubject extractAccountingDocumentLineList(AccountingSubject accountingSubject, Map<String,Object> options){
		
		SmartList<AccountingDocumentLine> accountingDocumentLineList = getAccountingDocumentLineDAO().findAccountingDocumentLineByAccountingSubject(accountingSubject.getId(),options);
		if(accountingDocumentLineList != null){
			accountingSubject.setAccountingDocumentLineList(accountingDocumentLineList);
		}
		
		return accountingSubject;
	
	}	
		
		
  	
 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where account_set = ?";
		SmartList<AccountingSubject> accountingSubjectList = queryForList(SQL, new Object[]{accountSetId}, getAccountingSubjectMapper());	
 		return accountingSubjectList;
 	}
 	
 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where account_set = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingSubject> accountingSubjectList = queryForList(SQL, new Object[]{accountSetId,start, count}, getAccountingSubjectMapper());
		
 		return accountingSubjectList;
 	}
 	
 	public int countAccountingSubjectByAccountSet(String accountSetId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where account_set = ?";
		Integer count = queryInt(SQL, new Object[]{accountSetId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected AccountingSubject saveAccountingSubject(AccountingSubject  accountingSubject){
	
		String SQL=this.getSaveAccountingSubjectSQL(accountingSubject);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingSubjectParameters(accountingSubject);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingSubject.incVersion();
		return accountingSubject;
	
	}
	public SmartList<AccountingSubject> saveAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingSubjectList(accountingSubjectList);
		
		batchAccountingSubjectCreate((List<AccountingSubject>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingSubjectUpdate((List<AccountingSubject>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingSubject accountingSubject:accountingSubjectList){
			if(accountingSubject.isChanged()){
				accountingSubject.incVersion();
			}
			
		
		}
		
		
		return accountingSubjectList;
	}

	public SmartList<AccountingSubject> removeAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options){
		
		
		super.removeList(accountingSubjectList, options);
		
		return accountingSubjectList;
		
		
	}
	
	protected List<Object[]> prepareAccountingSubjectBatchCreateArgs(List<AccountingSubject> accountingSubjectList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingSubject accountingSubject:accountingSubjectList ){
			Object [] parameters = prepareAccountingSubjectCreateParameters(accountingSubject);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingSubjectBatchUpdateArgs(List<AccountingSubject> accountingSubjectList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingSubject accountingSubject:accountingSubjectList ){
			if(!accountingSubject.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingSubjectUpdateParameters(accountingSubject);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingSubjectCreate(List<AccountingSubject> accountingSubjectList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingSubjectBatchCreateArgs(accountingSubjectList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingSubjectUpdate(List<AccountingSubject> accountingSubjectList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingSubjectBatchUpdateArgs(accountingSubjectList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingSubjectList(List<AccountingSubject> accountingSubjectList){
		
		List<AccountingSubject> accountingSubjectCreateList=new ArrayList<AccountingSubject>();
		List<AccountingSubject> accountingSubjectUpdateList=new ArrayList<AccountingSubject>();
		
		for(AccountingSubject accountingSubject: accountingSubjectList){
			if(isUpdateRequest(accountingSubject)){
				accountingSubjectUpdateList.add( accountingSubject);
				continue;
			}
			accountingSubjectCreateList.add(accountingSubject);
		}
		
		return new Object[]{accountingSubjectCreateList,accountingSubjectUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingSubject accountingSubject){
 		return accountingSubject.getVersion() > 0;
 	}
 	protected String getSaveAccountingSubjectSQL(AccountingSubject accountingSubject){
 		if(isUpdateRequest(accountingSubject)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingSubjectParameters(AccountingSubject accountingSubject){
 		if(isUpdateRequest(accountingSubject) ){
 			return prepareAccountingSubjectUpdateParameters(accountingSubject);
 		}
 		return prepareAccountingSubjectCreateParameters(accountingSubject);
 	}
 	protected Object[] prepareAccountingSubjectUpdateParameters(AccountingSubject accountingSubject){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = accountingSubject.getAccountingSubjectCode();
 		parameters[1] = accountingSubject.getAccountingSubjectName();
 		parameters[2] = accountingSubject.getAccountingSubjectClassCode();
 		parameters[3] = accountingSubject.getAccountingSubjectClassName(); 	
 		if(accountingSubject.getAccountSet() != null){
 			parameters[4] = accountingSubject.getAccountSet().getId();
 		}
 		
 		parameters[5] = accountingSubject.getId();
 		parameters[6] = accountingSubject.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingSubjectCreateParameters(AccountingSubject accountingSubject){
		Object[] parameters = new Object[6];
		String newAccountingSubjectId=getNextId();
		accountingSubject.setId(newAccountingSubjectId);
		parameters[0] =  accountingSubject.getId();
 
 		parameters[1] = accountingSubject.getAccountingSubjectCode();
 		parameters[2] = accountingSubject.getAccountingSubjectName();
 		parameters[3] = accountingSubject.getAccountingSubjectClassCode();
 		parameters[4] = accountingSubject.getAccountingSubjectClassName(); 	
 		if(accountingSubject.getAccountSet() != null){
 			parameters[5] = accountingSubject.getAccountSet().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected AccountingSubject saveInternalAccountingSubject(AccountingSubject accountingSubject, Map<String,Object> options){
		
		saveAccountingSubject(accountingSubject);
 	
 		if(isSaveAccountSetEnabled(options)){
	 		saveAccountSet(accountingSubject, options);
 		}
 
		
		if(isSaveAccountingDocumentLineListEnabled(options)){
	 		saveAccountingDocumentLineList(accountingSubject, options);
	 		removeAccountingDocumentLineList(accountingSubject, options);
	 		
 		}		
		
		return accountingSubject;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AccountingSubject saveAccountSet(AccountingSubject accountingSubject, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingSubject.getAccountSet() == null){
 			return accountingSubject;//do nothing when it is null
 		}
 		
 		getAccountSetDAO().save(accountingSubject.getAccountSet(),options);
 		return accountingSubject;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected AccountingSubject saveAccountingDocumentLineList(AccountingSubject accountingSubject, Map<String,Object> options){
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();
		if(accountingDocumentLineList == null){
			return accountingSubject;
		}
		if(accountingDocumentLineList.isEmpty()){
			return accountingSubject;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingDocumentLineDAO().saveAccountingDocumentLineList(accountingDocumentLineList,options);
		
		return accountingSubject;
	
	}
	
	protected AccountingSubject removeAccountingDocumentLineList(AccountingSubject accountingSubject, Map<String,Object> options){
	
	
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();
		if(accountingDocumentLineList == null){
			return accountingSubject;
		}	
	
		SmartList<AccountingDocumentLine> toRemoveAccountingDocumentLineList = accountingDocumentLineList.getToRemoveList();
		
		if(toRemoveAccountingDocumentLineList == null){
			return accountingSubject;
		}
		if(toRemoveAccountingDocumentLineList.isEmpty()){
			return accountingSubject;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentLineDAO().removeAccountingDocumentLineList(toRemoveAccountingDocumentLineList,options);
		
		return accountingSubject;
	
	}
	
	
	
 	
 	
	
	
	
		

	public AccountingSubject present(AccountingSubject accountingSubject,Map<String, Object> options){
	
		presentAccountingDocumentLineList(accountingSubject,options);

		return accountingSubject;
	
	}
		
	
  	
 	protected AccountingSubject presentAccountingDocumentLineList(
			AccountingSubject accountingSubject,
			Map<String, Object> options) {

		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();		
		if(accountingDocumentLineList == null){
			return accountingSubject;			
		}
		
		String targetObjectName = "accountingDocumentLine";
		int accountingDocumentLineListSize = accountingDocumentLineList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingDocumentLineListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountingSubject;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingDocumentLineListSize;
		if(accountingDocumentLineListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingDocumentLineDAO().countAccountingDocumentLineByAccountingSubject(accountingSubject.getId(), options);			
		}
		//accountingSubject.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountingSubject.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingDocumentLineListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingDocumentLineListSize,currentPage,rowsPerPage) ;
			accountingDocumentLineList = accountingDocumentLineList.subListOf(fromIndex, toIndex);
			accountingDocumentLineList.setTotalCount(count);
			accountingDocumentLineList.setCurrentPageNumber(currentPage);			
			accountingSubject.setAccountingDocumentLineList(accountingDocumentLineList);
			return accountingSubject;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingDocumentLineList 
			= getAccountingDocumentLineDAO().findAccountingDocumentLineByAccountingSubject(accountingSubject.getId(),start, rowsPerPage, options );
		accountingDocumentLineList.setTotalCount(count);
		accountingDocumentLineList.setCurrentPageNumber(currentPage);
		accountingSubject.setAccountingDocumentLineList(accountingDocumentLineList );	

		return accountingSubject;
	}			
		


	protected String getTableName(){
		return AccountingSubjectTable.TABLE_NAME;
	}
}


