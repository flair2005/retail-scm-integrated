
package com.skynet.retailscm.accountingperiod;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.accountingdocument.AccountingDocument;
import com.skynet.retailscm.accountset.AccountSet;

import com.skynet.retailscm.accountset.AccountSetDAO;
import com.skynet.retailscm.accountingdocument.AccountingDocumentDAO;

import com.skynet.retailscm.accountingdocument.AccountingDocumentTable;
import com.skynet.retailscm.accountset.AccountSetTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class AccountingPeriodJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountingPeriodDAO{
 
 	
 	private  AccountSetDAO  accountSetDAO;
 	public void setAccountSetDAO(AccountSetDAO accountSetDAO){
	 	this.accountSetDAO = accountSetDAO;
 	}
 	public AccountSetDAO getAccountSetDAO(){
	 	return this.accountSetDAO;
 	}

		
	
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
	protected AccountingPeriod load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingPeriod(accessKey, options);
	}
	*/
	public AccountingPeriod load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingPeriod(AccountingPeriodTable.withId(id), options);
	}
	
	
	
	public AccountingPeriod save(AccountingPeriod accountingPeriod,Map<String,Object> options){
		
		String methodName="save(AccountingPeriod accountingPeriod,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingPeriod, methodName, "accountingPeriod");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingPeriod(accountingPeriod,options);
	}
	public AccountingPeriod clone(String accountingPeriodId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingPeriodTable.withId(accountingPeriodId),options);
	}
	
	protected AccountingPeriod clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingPeriodId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingPeriod newAccountingPeriod = loadInternalAccountingPeriod(accessKey, options);
		newAccountingPeriod.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingPeriod.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingPeriod(newAccountingPeriod,options);
		
		return newAccountingPeriod;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountingPeriodId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountingPeriodId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountingPeriodVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingPeriodNotFoundException(
					"The " + this.getTableName() + "(" + accountingPeriodId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountingPeriodId, int version) throws Exception{
	
		String methodName="delete(String accountingPeriodId, int version)";
		assertMethodArgumentNotNull(accountingPeriodId, methodName, "accountingPeriodId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingPeriodId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingPeriodId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","start_date","end_date","account_set"};
		return AccountingPeriodTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_period";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingPeriodTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractAccountSetEnabled = true;
 	//private static final String ACCOUNTSET = "accountSet";
 	protected boolean isExtractAccountSetEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingPeriodTokens.ACCOUNTSET);
 	}
 	
 	
 	//private boolean saveAccountSetEnabled = true;
 	protected boolean isSaveAccountSetEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingPeriodTokens.ACCOUNTSET);
 	}
 	

 	
 
		
	//protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingPeriodTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingPeriodTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingPeriodMapper getAccountingPeriodMapper(){
		return new AccountingPeriodMapper();
	}
	protected AccountingPeriod extractAccountingPeriod(String accountingPeriodId) throws Exception{
		String SQL = "select * from accounting_period_data where id = ?";	
		try{
		
			AccountingPeriod accountingPeriod = queryForObject(SQL, new Object[]{accountingPeriodId}, getAccountingPeriodMapper());
			return accountingPeriod;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingPeriodNotFoundException("AccountingPeriod("+accountingPeriodId+") is not found!");
		}
		
		
	}
	protected AccountingPeriod extractAccountingPeriod(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from accounting_period_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountingPeriod accountingPeriod = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountingPeriodMapper());
			return accountingPeriod;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingPeriodNotFoundException("AccountingPeriod("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountingPeriod loadInternalAccountingPeriod(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingPeriod accountingPeriod = extractAccountingPeriod(accessKey, loadOptions);
 	
 		if(isExtractAccountSetEnabled(loadOptions)){
	 		extractAccountSet(accountingPeriod, loadOptions);
 		}
 
		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingPeriod, loadOptions);
 		}		
		
		return accountingPeriod;
		
	}



	
	
	 

 	protected AccountingPeriod extractAccountSet(AccountingPeriod accountingPeriod, Map<String,Object> options) throws Exception{

		if(accountingPeriod.getAccountSet() == null){
			return accountingPeriod;
		}
		String accountSetId = accountingPeriod.getAccountSet().getId();
		if( accountSetId == null){
			return accountingPeriod;
		}
		AccountSet accountSet = getAccountSetDAO().load(accountSetId,options);
		if(accountSet != null){
			accountingPeriod.setAccountSet(accountSet);
		}
		
 		
 		return accountingPeriod;
 	}
 		
 
		
	protected AccountingPeriod extractAccountingDocumentList(AccountingPeriod accountingPeriod, Map<String,Object> options){
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByAccountingPeriod(accountingPeriod.getId(),options);
		if(accountingDocumentList != null){
			accountingPeriod.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingPeriod;
	
	}	
		
		
  	
 	public SmartList<AccountingPeriod> findAccountingPeriodByAccountSet(String accountSetId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where account_set = ?";
		SmartList<AccountingPeriod> accountingPeriodList = queryForList(SQL, new Object[]{accountSetId}, getAccountingPeriodMapper());	
 		return accountingPeriodList;
 	}
 	
 	public SmartList<AccountingPeriod> findAccountingPeriodByAccountSet(String accountSetId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where account_set = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingPeriod> accountingPeriodList = queryForList(SQL, new Object[]{accountSetId,start, count}, getAccountingPeriodMapper());
		
 		return accountingPeriodList;
 	}
 	
 	public int countAccountingPeriodByAccountSet(String accountSetId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where account_set = ?";
		Integer count = queryInt(SQL, new Object[]{accountSetId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected AccountingPeriod saveAccountingPeriod(AccountingPeriod  accountingPeriod){
	
		String SQL=this.getSaveAccountingPeriodSQL(accountingPeriod);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingPeriodParameters(accountingPeriod);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingPeriod.incVersion();
		return accountingPeriod;
	
	}
	public SmartList<AccountingPeriod> saveAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingPeriodList(accountingPeriodList);
		
		batchAccountingPeriodCreate((List<AccountingPeriod>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingPeriodUpdate((List<AccountingPeriod>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingPeriod accountingPeriod:accountingPeriodList){
			if(accountingPeriod.isChanged()){
				accountingPeriod.incVersion();
			}
			
		
		}
		
		
		return accountingPeriodList;
	}

	public SmartList<AccountingPeriod> removeAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList,Map<String,Object> options){
		
		
		super.removeList(accountingPeriodList, options);
		
		return accountingPeriodList;
		
		
	}
	
	protected List<Object[]> prepareAccountingPeriodBatchCreateArgs(List<AccountingPeriod> accountingPeriodList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingPeriod accountingPeriod:accountingPeriodList ){
			Object [] parameters = prepareAccountingPeriodCreateParameters(accountingPeriod);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingPeriodBatchUpdateArgs(List<AccountingPeriod> accountingPeriodList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingPeriod accountingPeriod:accountingPeriodList ){
			if(!accountingPeriod.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingPeriodUpdateParameters(accountingPeriod);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingPeriodCreate(List<AccountingPeriod> accountingPeriodList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingPeriodBatchCreateArgs(accountingPeriodList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingPeriodUpdate(List<AccountingPeriod> accountingPeriodList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingPeriodBatchUpdateArgs(accountingPeriodList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingPeriodList(List<AccountingPeriod> accountingPeriodList){
		
		List<AccountingPeriod> accountingPeriodCreateList=new ArrayList<AccountingPeriod>();
		List<AccountingPeriod> accountingPeriodUpdateList=new ArrayList<AccountingPeriod>();
		
		for(AccountingPeriod accountingPeriod: accountingPeriodList){
			if(isUpdateRequest(accountingPeriod)){
				accountingPeriodUpdateList.add( accountingPeriod);
				continue;
			}
			accountingPeriodCreateList.add(accountingPeriod);
		}
		
		return new Object[]{accountingPeriodCreateList,accountingPeriodUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingPeriod accountingPeriod){
 		return accountingPeriod.getVersion() > 0;
 	}
 	protected String getSaveAccountingPeriodSQL(AccountingPeriod accountingPeriod){
 		if(isUpdateRequest(accountingPeriod)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingPeriodParameters(AccountingPeriod accountingPeriod){
 		if(isUpdateRequest(accountingPeriod) ){
 			return prepareAccountingPeriodUpdateParameters(accountingPeriod);
 		}
 		return prepareAccountingPeriodCreateParameters(accountingPeriod);
 	}
 	protected Object[] prepareAccountingPeriodUpdateParameters(AccountingPeriod accountingPeriod){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = accountingPeriod.getName();
 		parameters[1] = accountingPeriod.getStartDate();
 		parameters[2] = accountingPeriod.getEndDate(); 	
 		if(accountingPeriod.getAccountSet() != null){
 			parameters[3] = accountingPeriod.getAccountSet().getId();
 		}
 		
 		parameters[4] = accountingPeriod.getId();
 		parameters[5] = accountingPeriod.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingPeriodCreateParameters(AccountingPeriod accountingPeriod){
		Object[] parameters = new Object[5];
		String newAccountingPeriodId=getNextId();
		accountingPeriod.setId(newAccountingPeriodId);
		parameters[0] =  accountingPeriod.getId();
 
 		parameters[1] = accountingPeriod.getName();
 		parameters[2] = accountingPeriod.getStartDate();
 		parameters[3] = accountingPeriod.getEndDate(); 	
 		if(accountingPeriod.getAccountSet() != null){
 			parameters[4] = accountingPeriod.getAccountSet().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected AccountingPeriod saveInternalAccountingPeriod(AccountingPeriod accountingPeriod, Map<String,Object> options){
		
		saveAccountingPeriod(accountingPeriod);
 	
 		if(isSaveAccountSetEnabled(options)){
	 		saveAccountSet(accountingPeriod, options);
 		}
 
		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingPeriod, options);
	 		removeAccountingDocumentList(accountingPeriod, options);
	 		
 		}		
		
		return accountingPeriod;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AccountingPeriod saveAccountSet(AccountingPeriod accountingPeriod, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingPeriod.getAccountSet() == null){
 			return accountingPeriod;//do nothing when it is null
 		}
 		
 		getAccountSetDAO().save(accountingPeriod.getAccountSet(),options);
 		return accountingPeriod;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected AccountingPeriod saveAccountingDocumentList(AccountingPeriod accountingPeriod, Map<String,Object> options){
		SmartList<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingPeriod;
		}
		if(accountingDocumentList.isEmpty()){
			return accountingPeriod;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingDocumentDAO().saveAccountingDocumentList(accountingDocumentList,options);
		
		return accountingPeriod;
	
	}
	
	protected AccountingPeriod removeAccountingDocumentList(AccountingPeriod accountingPeriod, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingPeriod;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingPeriod;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingPeriod;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingPeriod;
	
	}
	
	
	
 	
 	
	
	
	
		

	public AccountingPeriod present(AccountingPeriod accountingPeriod,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingPeriod,options);

		return accountingPeriod;
	
	}
		
	
  	
 	protected AccountingPeriod presentAccountingDocumentList(
			AccountingPeriod accountingPeriod,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();		
		if(accountingDocumentList == null){
			return accountingPeriod;			
		}
		
		String targetObjectName = "accountingDocument";
		int accountingDocumentListSize = accountingDocumentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingDocumentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountingPeriod;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingDocumentListSize;
		if(accountingDocumentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingDocumentDAO().countAccountingDocumentByAccountingPeriod(accountingPeriod.getId(), options);			
		}
		//accountingPeriod.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountingPeriod.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingDocumentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingDocumentListSize,currentPage,rowsPerPage) ;
			accountingDocumentList = accountingDocumentList.subListOf(fromIndex, toIndex);
			accountingDocumentList.setTotalCount(count);
			accountingDocumentList.setCurrentPageNumber(currentPage);			
			accountingPeriod.setAccountingDocumentList(accountingDocumentList);
			return accountingPeriod;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingDocumentList 
			= getAccountingDocumentDAO().findAccountingDocumentByAccountingPeriod(accountingPeriod.getId(),start, rowsPerPage, options );
		accountingDocumentList.setTotalCount(count);
		accountingDocumentList.setCurrentPageNumber(currentPage);
		accountingPeriod.setAccountingDocumentList(accountingDocumentList );	

		return accountingPeriod;
	}			
		


	protected String getTableName(){
		return AccountingPeriodTable.TABLE_NAME;
	}
}


