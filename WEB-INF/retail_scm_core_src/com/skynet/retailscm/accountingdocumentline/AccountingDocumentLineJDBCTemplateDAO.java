
package com.skynet.retailscm.accountingdocumentline;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingdocument.AccountingDocument;

import com.skynet.retailscm.accountingdocument.AccountingDocumentDAO;
import com.skynet.retailscm.accountingsubject.AccountingSubjectDAO;

import com.skynet.retailscm.accountingsubject.AccountingSubjectTable;
import com.skynet.retailscm.accountingdocument.AccountingDocumentTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class AccountingDocumentLineJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountingDocumentLineDAO{
 
 	
 	private  AccountingSubjectDAO  accountingSubjectDAO;
 	public void setAccountingSubjectDAO(AccountingSubjectDAO accountingSubjectDAO){
	 	this.accountingSubjectDAO = accountingSubjectDAO;
 	}
 	public AccountingSubjectDAO getAccountingSubjectDAO(){
	 	return this.accountingSubjectDAO;
 	}
 
 	
 	private  AccountingDocumentDAO  accountingDocumentDAO;
 	public void setAccountingDocumentDAO(AccountingDocumentDAO accountingDocumentDAO){
	 	this.accountingDocumentDAO = accountingDocumentDAO;
 	}
 	public AccountingDocumentDAO getAccountingDocumentDAO(){
	 	return this.accountingDocumentDAO;
 	}

		

	
	/*
	protected AccountingDocumentLine load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentLine(accessKey, options);
	}
	*/
	public AccountingDocumentLine load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentLine(AccountingDocumentLineTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentLine save(AccountingDocumentLine accountingDocumentLine,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentLine accountingDocumentLine,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentLine, methodName, "accountingDocumentLine");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentLine(accountingDocumentLine,options);
	}
	public AccountingDocumentLine clone(String accountingDocumentLineId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentLineTable.withId(accountingDocumentLineId),options);
	}
	
	protected AccountingDocumentLine clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentLineId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentLine newAccountingDocumentLine = loadInternalAccountingDocumentLine(accessKey, options);
		newAccountingDocumentLine.setVersion(0);
		
		

		
		saveInternalAccountingDocumentLine(newAccountingDocumentLine,options);
		
		return newAccountingDocumentLine;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountingDocumentLineId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountingDocumentLineId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountingDocumentLineVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentLineNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentLineId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountingDocumentLineId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentLineId, int version)";
		assertMethodArgumentNotNull(accountingDocumentLineId, methodName, "accountingDocumentLineId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentLineId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentLineId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","code","direct","amount","belongs_to","accounting_subject"};
		return AccountingDocumentLineTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_line";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentLineTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentLineTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentLineTokens.BELONGSTO);
 	}
 	

 	
  
 	//private boolean extractAccountingSubjectEnabled = true;
 	//private static final String ACCOUNTINGSUBJECT = "accountingSubject";
 	protected boolean isExtractAccountingSubjectEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentLineTokens.ACCOUNTINGSUBJECT);
 	}
 	
 	
 	//private boolean saveAccountingSubjectEnabled = true;
 	protected boolean isSaveAccountingSubjectEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentLineTokens.ACCOUNTINGSUBJECT);
 	}
 	

 	
 
		

	

	protected AccountingDocumentLineMapper getAccountingDocumentLineMapper(){
		return new AccountingDocumentLineMapper();
	}
	protected AccountingDocumentLine extractAccountingDocumentLine(String accountingDocumentLineId) throws Exception{
		String SQL = "select * from accounting_document_line_data where id = ?";	
		try{
		
			AccountingDocumentLine accountingDocumentLine = queryForObject(SQL, new Object[]{accountingDocumentLineId}, getAccountingDocumentLineMapper());
			return accountingDocumentLine;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentLineNotFoundException("AccountingDocumentLine("+accountingDocumentLineId+") is not found!");
		}
		
		
	}
	protected AccountingDocumentLine extractAccountingDocumentLine(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from accounting_document_line_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountingDocumentLine accountingDocumentLine = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountingDocumentLineMapper());
			return accountingDocumentLine;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentLineNotFoundException("AccountingDocumentLine("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountingDocumentLine loadInternalAccountingDocumentLine(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentLine accountingDocumentLine = extractAccountingDocumentLine(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(accountingDocumentLine, loadOptions);
 		}
  	
 		if(isExtractAccountingSubjectEnabled(loadOptions)){
	 		extractAccountingSubject(accountingDocumentLine, loadOptions);
 		}
 
		
		return accountingDocumentLine;
		
	}



	
	
	 

 	protected AccountingDocumentLine extractBelongsTo(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options) throws Exception{

		if(accountingDocumentLine.getBelongsTo() == null){
			return accountingDocumentLine;
		}
		String belongsToId = accountingDocumentLine.getBelongsTo().getId();
		if( belongsToId == null){
			return accountingDocumentLine;
		}
		AccountingDocument belongsTo = getAccountingDocumentDAO().load(belongsToId,options);
		if(belongsTo != null){
			accountingDocumentLine.setBelongsTo(belongsTo);
		}
		
 		
 		return accountingDocumentLine;
 	}
 		
  

 	protected AccountingDocumentLine extractAccountingSubject(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options) throws Exception{

		if(accountingDocumentLine.getAccountingSubject() == null){
			return accountingDocumentLine;
		}
		String accountingSubjectId = accountingDocumentLine.getAccountingSubject().getId();
		if( accountingSubjectId == null){
			return accountingDocumentLine;
		}
		AccountingSubject accountingSubject = getAccountingSubjectDAO().load(accountingSubjectId,options);
		if(accountingSubject != null){
			accountingDocumentLine.setAccountingSubject(accountingSubject);
		}
		
 		
 		return accountingDocumentLine;
 	}
 		
 
		
		
  	
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByBelongsTo(String accountingDocumentId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		SmartList<AccountingDocumentLine> accountingDocumentLineList = queryForList(SQL, new Object[]{accountingDocumentId}, getAccountingDocumentLineMapper());	
 		return accountingDocumentLineList;
 	}
 	
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByBelongsTo(String accountingDocumentId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingDocumentLine> accountingDocumentLineList = queryForList(SQL, new Object[]{accountingDocumentId,start, count}, getAccountingDocumentLineMapper());
		
 		return accountingDocumentLineList;
 	}
 	
 	public int countAccountingDocumentLineByBelongsTo(String accountingDocumentId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where belongs_to = ?";
		Integer count = queryInt(SQL, new Object[]{accountingDocumentId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByAccountingSubject(String accountingSubjectId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where accounting_subject = ?";
		SmartList<AccountingDocumentLine> accountingDocumentLineList = queryForList(SQL, new Object[]{accountingSubjectId}, getAccountingDocumentLineMapper());	
 		return accountingDocumentLineList;
 	}
 	
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByAccountingSubject(String accountingSubjectId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where accounting_subject = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingDocumentLine> accountingDocumentLineList = queryForList(SQL, new Object[]{accountingSubjectId,start, count}, getAccountingDocumentLineMapper());
		
 		return accountingDocumentLineList;
 	}
 	
 	public int countAccountingDocumentLineByAccountingSubject(String accountingSubjectId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where accounting_subject = ?";
		Integer count = queryInt(SQL, new Object[]{accountingSubjectId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected AccountingDocumentLine saveAccountingDocumentLine(AccountingDocumentLine  accountingDocumentLine){
	
		String SQL=this.getSaveAccountingDocumentLineSQL(accountingDocumentLine);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentLineParameters(accountingDocumentLine);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentLine.incVersion();
		return accountingDocumentLine;
	
	}
	public SmartList<AccountingDocumentLine> saveAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentLineList(accountingDocumentLineList);
		
		batchAccountingDocumentLineCreate((List<AccountingDocumentLine>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentLineUpdate((List<AccountingDocumentLine>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			if(accountingDocumentLine.isChanged()){
				accountingDocumentLine.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentLineList;
	}

	public SmartList<AccountingDocumentLine> removeAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentLineList, options);
		
		return accountingDocumentLineList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentLineBatchCreateArgs(List<AccountingDocumentLine> accountingDocumentLineList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList ){
			Object [] parameters = prepareAccountingDocumentLineCreateParameters(accountingDocumentLine);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentLineBatchUpdateArgs(List<AccountingDocumentLine> accountingDocumentLineList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList ){
			if(!accountingDocumentLine.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentLineUpdateParameters(accountingDocumentLine);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentLineCreate(List<AccountingDocumentLine> accountingDocumentLineList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentLineBatchCreateArgs(accountingDocumentLineList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentLineUpdate(List<AccountingDocumentLine> accountingDocumentLineList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentLineBatchUpdateArgs(accountingDocumentLineList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentLineList(List<AccountingDocumentLine> accountingDocumentLineList){
		
		List<AccountingDocumentLine> accountingDocumentLineCreateList=new ArrayList<AccountingDocumentLine>();
		List<AccountingDocumentLine> accountingDocumentLineUpdateList=new ArrayList<AccountingDocumentLine>();
		
		for(AccountingDocumentLine accountingDocumentLine: accountingDocumentLineList){
			if(isUpdateRequest(accountingDocumentLine)){
				accountingDocumentLineUpdateList.add( accountingDocumentLine);
				continue;
			}
			accountingDocumentLineCreateList.add(accountingDocumentLine);
		}
		
		return new Object[]{accountingDocumentLineCreateList,accountingDocumentLineUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentLine accountingDocumentLine){
 		return accountingDocumentLine.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentLineSQL(AccountingDocumentLine accountingDocumentLine){
 		if(isUpdateRequest(accountingDocumentLine)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentLineParameters(AccountingDocumentLine accountingDocumentLine){
 		if(isUpdateRequest(accountingDocumentLine) ){
 			return prepareAccountingDocumentLineUpdateParameters(accountingDocumentLine);
 		}
 		return prepareAccountingDocumentLineCreateParameters(accountingDocumentLine);
 	}
 	protected Object[] prepareAccountingDocumentLineUpdateParameters(AccountingDocumentLine accountingDocumentLine){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = accountingDocumentLine.getName();
 		parameters[1] = accountingDocumentLine.getCode();
 		parameters[2] = accountingDocumentLine.getDirect();
 		parameters[3] = accountingDocumentLine.getAmount(); 	
 		if(accountingDocumentLine.getBelongsTo() != null){
 			parameters[4] = accountingDocumentLine.getBelongsTo().getId();
 		}
  	
 		if(accountingDocumentLine.getAccountingSubject() != null){
 			parameters[5] = accountingDocumentLine.getAccountingSubject().getId();
 		}
 		
 		parameters[6] = accountingDocumentLine.getId();
 		parameters[7] = accountingDocumentLine.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentLineCreateParameters(AccountingDocumentLine accountingDocumentLine){
		Object[] parameters = new Object[7];
		String newAccountingDocumentLineId=getNextId();
		accountingDocumentLine.setId(newAccountingDocumentLineId);
		parameters[0] =  accountingDocumentLine.getId();
 
 		parameters[1] = accountingDocumentLine.getName();
 		parameters[2] = accountingDocumentLine.getCode();
 		parameters[3] = accountingDocumentLine.getDirect();
 		parameters[4] = accountingDocumentLine.getAmount(); 	
 		if(accountingDocumentLine.getBelongsTo() != null){
 			parameters[5] = accountingDocumentLine.getBelongsTo().getId();
 		
 		}
 		 	
 		if(accountingDocumentLine.getAccountingSubject() != null){
 			parameters[6] = accountingDocumentLine.getAccountingSubject().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentLine saveInternalAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options){
		
		saveAccountingDocumentLine(accountingDocumentLine);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(accountingDocumentLine, options);
 		}
  	
 		if(isSaveAccountingSubjectEnabled(options)){
	 		saveAccountingSubject(accountingDocumentLine, options);
 		}
 
		
		return accountingDocumentLine;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AccountingDocumentLine saveBelongsTo(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocumentLine.getBelongsTo() == null){
 			return accountingDocumentLine;//do nothing when it is null
 		}
 		
 		getAccountingDocumentDAO().save(accountingDocumentLine.getBelongsTo(),options);
 		return accountingDocumentLine;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocumentLine saveAccountingSubject(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocumentLine.getAccountingSubject() == null){
 			return accountingDocumentLine;//do nothing when it is null
 		}
 		
 		getAccountingSubjectDAO().save(accountingDocumentLine.getAccountingSubject(),options);
 		return accountingDocumentLine;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public AccountingDocumentLine present(AccountingDocumentLine accountingDocumentLine,Map<String, Object> options){
	

		return accountingDocumentLine;
	
	}
		


	protected String getTableName(){
		return AccountingDocumentLineTable.TABLE_NAME;
	}
}


