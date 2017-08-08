
package com.skynet.retailscm.accountingdocumenttype;

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

public class AccountingDocumentTypeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountingDocumentTypeDAO{
 
 	
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
	protected AccountingDocumentType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentType(accessKey, options);
	}
	*/
	public AccountingDocumentType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentType(AccountingDocumentTypeTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentType save(AccountingDocumentType accountingDocumentType,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentType accountingDocumentType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentType, methodName, "accountingDocumentType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentType(accountingDocumentType,options);
	}
	public AccountingDocumentType clone(String accountingDocumentTypeId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentTypeTable.withId(accountingDocumentTypeId),options);
	}
	
	protected AccountingDocumentType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentType newAccountingDocumentType = loadInternalAccountingDocumentType(accessKey, options);
		newAccountingDocumentType.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentType.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentType(newAccountingDocumentType,options);
		
		return newAccountingDocumentType;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountingDocumentTypeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountingDocumentTypeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountingDocumentTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentTypeNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountingDocumentTypeId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentTypeId, int version)";
		assertMethodArgumentNotNull(accountingDocumentTypeId, methodName, "accountingDocumentTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentTypeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentTypeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","description","accounting_period"};
		return AccountingDocumentTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_type";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentTypeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractAccountingPeriodEnabled = true;
 	//private static final String ACCOUNTINGPERIOD = "accountingPeriod";
 	protected boolean isExtractAccountingPeriodEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTypeTokens.ACCOUNTINGPERIOD);
 	}
 	
 	
 	//private boolean saveAccountingPeriodEnabled = true;
 	protected boolean isSaveAccountingPeriodEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTypeTokens.ACCOUNTINGPERIOD);
 	}
 	

 	
 
		
	//protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingDocumentTypeTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentTypeTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingDocumentTypeMapper getAccountingDocumentTypeMapper(){
		return new AccountingDocumentTypeMapper();
	}
	protected AccountingDocumentType extractAccountingDocumentType(String accountingDocumentTypeId) throws Exception{
		String SQL = "select * from accounting_document_type_data where id = ?";	
		try{
		
			AccountingDocumentType accountingDocumentType = queryForObject(SQL, new Object[]{accountingDocumentTypeId}, getAccountingDocumentTypeMapper());
			return accountingDocumentType;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentTypeNotFoundException("AccountingDocumentType("+accountingDocumentTypeId+") is not found!");
		}
		
		
	}
	protected AccountingDocumentType extractAccountingDocumentType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from accounting_document_type_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountingDocumentType accountingDocumentType = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountingDocumentTypeMapper());
			return accountingDocumentType;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentTypeNotFoundException("AccountingDocumentType("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountingDocumentType loadInternalAccountingDocumentType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentType accountingDocumentType = extractAccountingDocumentType(accessKey, loadOptions);
 	
 		if(isExtractAccountingPeriodEnabled(loadOptions)){
	 		extractAccountingPeriod(accountingDocumentType, loadOptions);
 		}
 
		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentType, loadOptions);
 		}		
		
		return accountingDocumentType;
		
	}



	
	
	 

 	protected AccountingDocumentType extractAccountingPeriod(AccountingDocumentType accountingDocumentType, Map<String,Object> options) throws Exception{

		if(accountingDocumentType.getAccountingPeriod() == null){
			return accountingDocumentType;
		}
		String accountingPeriodId = accountingDocumentType.getAccountingPeriod().getId();
		if( accountingPeriodId == null){
			return accountingDocumentType;
		}
		AccountSet accountingPeriod = getAccountSetDAO().load(accountingPeriodId,options);
		if(accountingPeriod != null){
			accountingDocumentType.setAccountingPeriod(accountingPeriod);
		}
		
 		
 		return accountingDocumentType;
 	}
 		
 
		
	protected AccountingDocumentType extractAccountingDocumentList(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByDocumentType(accountingDocumentType.getId(),options);
		if(accountingDocumentList != null){
			accountingDocumentType.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentType;
	
	}	
		
		
  	
 	public SmartList<AccountingDocumentType> findAccountingDocumentTypeByAccountingPeriod(String accountSetId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where accounting_period = ?";
		SmartList<AccountingDocumentType> accountingDocumentTypeList = queryForList(SQL, new Object[]{accountSetId}, getAccountingDocumentTypeMapper());	
 		return accountingDocumentTypeList;
 	}
 	
 	public SmartList<AccountingDocumentType> findAccountingDocumentTypeByAccountingPeriod(String accountSetId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where accounting_period = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingDocumentType> accountingDocumentTypeList = queryForList(SQL, new Object[]{accountSetId,start, count}, getAccountingDocumentTypeMapper());
		
 		return accountingDocumentTypeList;
 	}
 	
 	public int countAccountingDocumentTypeByAccountingPeriod(String accountSetId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where accounting_period = ?";
		Integer count = queryInt(SQL, new Object[]{accountSetId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected AccountingDocumentType saveAccountingDocumentType(AccountingDocumentType  accountingDocumentType){
	
		String SQL=this.getSaveAccountingDocumentTypeSQL(accountingDocumentType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentTypeParameters(accountingDocumentType);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentType.incVersion();
		return accountingDocumentType;
	
	}
	public SmartList<AccountingDocumentType> saveAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentTypeList(accountingDocumentTypeList);
		
		batchAccountingDocumentTypeCreate((List<AccountingDocumentType>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentTypeUpdate((List<AccountingDocumentType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentType accountingDocumentType:accountingDocumentTypeList){
			if(accountingDocumentType.isChanged()){
				accountingDocumentType.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentTypeList;
	}

	public SmartList<AccountingDocumentType> removeAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentTypeList, options);
		
		return accountingDocumentTypeList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentTypeBatchCreateArgs(List<AccountingDocumentType> accountingDocumentTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentType accountingDocumentType:accountingDocumentTypeList ){
			Object [] parameters = prepareAccountingDocumentTypeCreateParameters(accountingDocumentType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentTypeBatchUpdateArgs(List<AccountingDocumentType> accountingDocumentTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentType accountingDocumentType:accountingDocumentTypeList ){
			if(!accountingDocumentType.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentTypeUpdateParameters(accountingDocumentType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentTypeCreate(List<AccountingDocumentType> accountingDocumentTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentTypeBatchCreateArgs(accountingDocumentTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentTypeUpdate(List<AccountingDocumentType> accountingDocumentTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentTypeBatchUpdateArgs(accountingDocumentTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentTypeList(List<AccountingDocumentType> accountingDocumentTypeList){
		
		List<AccountingDocumentType> accountingDocumentTypeCreateList=new ArrayList<AccountingDocumentType>();
		List<AccountingDocumentType> accountingDocumentTypeUpdateList=new ArrayList<AccountingDocumentType>();
		
		for(AccountingDocumentType accountingDocumentType: accountingDocumentTypeList){
			if(isUpdateRequest(accountingDocumentType)){
				accountingDocumentTypeUpdateList.add( accountingDocumentType);
				continue;
			}
			accountingDocumentTypeCreateList.add(accountingDocumentType);
		}
		
		return new Object[]{accountingDocumentTypeCreateList,accountingDocumentTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentType accountingDocumentType){
 		return accountingDocumentType.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentTypeSQL(AccountingDocumentType accountingDocumentType){
 		if(isUpdateRequest(accountingDocumentType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentTypeParameters(AccountingDocumentType accountingDocumentType){
 		if(isUpdateRequest(accountingDocumentType) ){
 			return prepareAccountingDocumentTypeUpdateParameters(accountingDocumentType);
 		}
 		return prepareAccountingDocumentTypeCreateParameters(accountingDocumentType);
 	}
 	protected Object[] prepareAccountingDocumentTypeUpdateParameters(AccountingDocumentType accountingDocumentType){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = accountingDocumentType.getName();
 		parameters[1] = accountingDocumentType.getDescription(); 	
 		if(accountingDocumentType.getAccountingPeriod() != null){
 			parameters[2] = accountingDocumentType.getAccountingPeriod().getId();
 		}
 		
 		parameters[3] = accountingDocumentType.getId();
 		parameters[4] = accountingDocumentType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentTypeCreateParameters(AccountingDocumentType accountingDocumentType){
		Object[] parameters = new Object[4];
		String newAccountingDocumentTypeId=getNextId();
		accountingDocumentType.setId(newAccountingDocumentTypeId);
		parameters[0] =  accountingDocumentType.getId();
 
 		parameters[1] = accountingDocumentType.getName();
 		parameters[2] = accountingDocumentType.getDescription(); 	
 		if(accountingDocumentType.getAccountingPeriod() != null){
 			parameters[3] = accountingDocumentType.getAccountingPeriod().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentType saveInternalAccountingDocumentType(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
		
		saveAccountingDocumentType(accountingDocumentType);
 	
 		if(isSaveAccountingPeriodEnabled(options)){
	 		saveAccountingPeriod(accountingDocumentType, options);
 		}
 
		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentType, options);
	 		removeAccountingDocumentList(accountingDocumentType, options);
	 		
 		}		
		
		return accountingDocumentType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AccountingDocumentType saveAccountingPeriod(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocumentType.getAccountingPeriod() == null){
 			return accountingDocumentType;//do nothing when it is null
 		}
 		
 		getAccountSetDAO().save(accountingDocumentType.getAccountingPeriod(),options);
 		return accountingDocumentType;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected AccountingDocumentType saveAccountingDocumentList(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentType;
		}
		if(accountingDocumentList.isEmpty()){
			return accountingDocumentType;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingDocumentDAO().saveAccountingDocumentList(accountingDocumentList,options);
		
		return accountingDocumentType;
	
	}
	
	protected AccountingDocumentType removeAccountingDocumentList(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentType;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentType;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentType;
	
	}
	
	
	
 	
 	
	
	
	
		

	public AccountingDocumentType present(AccountingDocumentType accountingDocumentType,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentType,options);

		return accountingDocumentType;
	
	}
		
	
  	
 	protected AccountingDocumentType presentAccountingDocumentList(
			AccountingDocumentType accountingDocumentType,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();		
		if(accountingDocumentList == null){
			return accountingDocumentType;			
		}
		
		String targetObjectName = "accountingDocument";
		int accountingDocumentListSize = accountingDocumentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingDocumentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountingDocumentType;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingDocumentListSize;
		if(accountingDocumentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingDocumentDAO().countAccountingDocumentByDocumentType(accountingDocumentType.getId(), options);			
		}
		//accountingDocumentType.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountingDocumentType.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingDocumentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingDocumentListSize,currentPage,rowsPerPage) ;
			accountingDocumentList = accountingDocumentList.subListOf(fromIndex, toIndex);
			accountingDocumentList.setTotalCount(count);
			accountingDocumentList.setCurrentPageNumber(currentPage);			
			accountingDocumentType.setAccountingDocumentList(accountingDocumentList);
			return accountingDocumentType;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingDocumentList 
			= getAccountingDocumentDAO().findAccountingDocumentByDocumentType(accountingDocumentType.getId(),start, rowsPerPage, options );
		accountingDocumentList.setTotalCount(count);
		accountingDocumentList.setCurrentPageNumber(currentPage);
		accountingDocumentType.setAccountingDocumentList(accountingDocumentList );	

		return accountingDocumentType;
	}			
		


	protected String getTableName(){
		return AccountingDocumentTypeTable.TABLE_NAME;
	}
}


