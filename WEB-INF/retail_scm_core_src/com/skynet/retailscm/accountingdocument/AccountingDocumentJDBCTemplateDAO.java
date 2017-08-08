
package com.skynet.retailscm.accountingdocument;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.skynet.retailscm.originalvoucher.OriginalVoucher;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPosting;

import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLineDAO;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreationDAO;
import com.skynet.retailscm.originalvoucher.OriginalVoucherDAO;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPostingDAO;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditingDAO;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentTypeDAO;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmationDAO;
import com.skynet.retailscm.accountingperiod.AccountingPeriodDAO;

import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentTypeTable;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLineTable;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmationTable;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditingTable;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPostingTable;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreationTable;
import com.skynet.retailscm.originalvoucher.OriginalVoucherTable;
import com.skynet.retailscm.accountingperiod.AccountingPeriodTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class AccountingDocumentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountingDocumentDAO{
 
 	
 	private  AccountingDocumentTypeDAO  accountingDocumentTypeDAO;
 	public void setAccountingDocumentTypeDAO(AccountingDocumentTypeDAO accountingDocumentTypeDAO){
	 	this.accountingDocumentTypeDAO = accountingDocumentTypeDAO;
 	}
 	public AccountingDocumentTypeDAO getAccountingDocumentTypeDAO(){
	 	return this.accountingDocumentTypeDAO;
 	}
 
 	
 	private  AccountingDocumentPostingDAO  accountingDocumentPostingDAO;
 	public void setAccountingDocumentPostingDAO(AccountingDocumentPostingDAO accountingDocumentPostingDAO){
	 	this.accountingDocumentPostingDAO = accountingDocumentPostingDAO;
 	}
 	public AccountingDocumentPostingDAO getAccountingDocumentPostingDAO(){
	 	return this.accountingDocumentPostingDAO;
 	}
 
 	
 	private  AccountingDocumentCreationDAO  accountingDocumentCreationDAO;
 	public void setAccountingDocumentCreationDAO(AccountingDocumentCreationDAO accountingDocumentCreationDAO){
	 	this.accountingDocumentCreationDAO = accountingDocumentCreationDAO;
 	}
 	public AccountingDocumentCreationDAO getAccountingDocumentCreationDAO(){
	 	return this.accountingDocumentCreationDAO;
 	}
 
 	
 	private  AccountingPeriodDAO  accountingPeriodDAO;
 	public void setAccountingPeriodDAO(AccountingPeriodDAO accountingPeriodDAO){
	 	this.accountingPeriodDAO = accountingPeriodDAO;
 	}
 	public AccountingPeriodDAO getAccountingPeriodDAO(){
	 	return this.accountingPeriodDAO;
 	}
 
 	
 	private  AccountingDocumentAuditingDAO  accountingDocumentAuditingDAO;
 	public void setAccountingDocumentAuditingDAO(AccountingDocumentAuditingDAO accountingDocumentAuditingDAO){
	 	this.accountingDocumentAuditingDAO = accountingDocumentAuditingDAO;
 	}
 	public AccountingDocumentAuditingDAO getAccountingDocumentAuditingDAO(){
	 	return this.accountingDocumentAuditingDAO;
 	}
 
 	
 	private  AccountingDocumentConfirmationDAO  accountingDocumentConfirmationDAO;
 	public void setAccountingDocumentConfirmationDAO(AccountingDocumentConfirmationDAO accountingDocumentConfirmationDAO){
	 	this.accountingDocumentConfirmationDAO = accountingDocumentConfirmationDAO;
 	}
 	public AccountingDocumentConfirmationDAO getAccountingDocumentConfirmationDAO(){
	 	return this.accountingDocumentConfirmationDAO;
 	}

		
	
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
	protected AccountingDocument load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocument(accessKey, options);
	}
	*/
	public AccountingDocument load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocument(AccountingDocumentTable.withId(id), options);
	}
	
	
	
	public AccountingDocument save(AccountingDocument accountingDocument,Map<String,Object> options){
		
		String methodName="save(AccountingDocument accountingDocument,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocument, methodName, "accountingDocument");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocument(accountingDocument,options);
	}
	public AccountingDocument clone(String accountingDocumentId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentTable.withId(accountingDocumentId),options);
	}
	
	protected AccountingDocument clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocument newAccountingDocument = loadInternalAccountingDocument(accessKey, options);
		newAccountingDocument.setVersion(0);
		
		
 		
 		if(isSaveOriginalVoucherListEnabled(options)){
 			for(OriginalVoucher item: newAccountingDocument.getOriginalVoucherList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAccountingDocumentLineListEnabled(options)){
 			for(AccountingDocumentLine item: newAccountingDocument.getAccountingDocumentLineList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocument(newAccountingDocument,options);
		
		return newAccountingDocument;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountingDocumentId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountingDocumentId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountingDocumentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountingDocumentId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentId, int version)";
		assertMethodArgumentNotNull(accountingDocumentId, methodName, "accountingDocumentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","accounting_document_date","accounting_period","document_type","creation","confirmation","auditing","posting","current_status"};
		return AccountingDocumentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractAccountingPeriodEnabled = true;
 	//private static final String ACCOUNTINGPERIOD = "accountingPeriod";
 	protected boolean isExtractAccountingPeriodEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.ACCOUNTINGPERIOD);
 	}
 	
 	
 	//private boolean saveAccountingPeriodEnabled = true;
 	protected boolean isSaveAccountingPeriodEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.ACCOUNTINGPERIOD);
 	}
 	

 	
  
 	//private boolean extractDocumentTypeEnabled = true;
 	//private static final String DOCUMENTTYPE = "documentType";
 	protected boolean isExtractDocumentTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.DOCUMENTTYPE);
 	}
 	
 	
 	//private boolean saveDocumentTypeEnabled = true;
 	protected boolean isSaveDocumentTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.DOCUMENTTYPE);
 	}
 	

 	
  
 	//private boolean extractCreationEnabled = true;
 	//private static final String CREATION = "creation";
 	protected boolean isExtractCreationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.CREATION);
 	}
 	
 	
 	//private boolean saveCreationEnabled = true;
 	protected boolean isSaveCreationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.CREATION);
 	}
 	

 	
  
 	//private boolean extractConfirmationEnabled = true;
 	//private static final String CONFIRMATION = "confirmation";
 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.CONFIRMATION);
 	}
 	
 	
 	//private boolean saveConfirmationEnabled = true;
 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.CONFIRMATION);
 	}
 	

 	
  
 	//private boolean extractAuditingEnabled = true;
 	//private static final String AUDITING = "auditing";
 	protected boolean isExtractAuditingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.AUDITING);
 	}
 	
 	
 	//private boolean saveAuditingEnabled = true;
 	protected boolean isSaveAuditingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.AUDITING);
 	}
 	

 	
  
 	//private boolean extractPostingEnabled = true;
 	//private static final String POSTING = "posting";
 	protected boolean isExtractPostingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.POSTING);
 	}
 	
 	
 	//private boolean savePostingEnabled = true;
 	protected boolean isSavePostingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.POSTING);
 	}
 	

 	
 
		
	//protected static final String ORIGINAL_VOUCHER_LIST = "originalVoucherList";
	
	protected boolean isExtractOriginalVoucherListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingDocumentTokens.ORIGINAL_VOUCHER_LIST);
		
 	}

	protected boolean isSaveOriginalVoucherListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentTokens.ORIGINAL_VOUCHER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String ACCOUNTING_DOCUMENT_LINE_LIST = "accountingDocumentLineList";
	
	protected boolean isExtractAccountingDocumentLineListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingDocumentTokens.ACCOUNTING_DOCUMENT_LINE_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentLineListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentTokens.ACCOUNTING_DOCUMENT_LINE_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingDocumentMapper getAccountingDocumentMapper(){
		return new AccountingDocumentMapper();
	}
	protected AccountingDocument extractAccountingDocument(String accountingDocumentId) throws Exception{
		String SQL = "select * from accounting_document_data where id = ?";	
		try{
		
			AccountingDocument accountingDocument = queryForObject(SQL, new Object[]{accountingDocumentId}, getAccountingDocumentMapper());
			return accountingDocument;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentNotFoundException("AccountingDocument("+accountingDocumentId+") is not found!");
		}
		
		
	}
	protected AccountingDocument extractAccountingDocument(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from accounting_document_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountingDocument accountingDocument = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountingDocumentMapper());
			return accountingDocument;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentNotFoundException("AccountingDocument("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountingDocument loadInternalAccountingDocument(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocument accountingDocument = extractAccountingDocument(accessKey, loadOptions);
 	
 		if(isExtractAccountingPeriodEnabled(loadOptions)){
	 		extractAccountingPeriod(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractDocumentTypeEnabled(loadOptions)){
	 		extractDocumentType(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractCreationEnabled(loadOptions)){
	 		extractCreation(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractAuditingEnabled(loadOptions)){
	 		extractAuditing(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractPostingEnabled(loadOptions)){
	 		extractPosting(accountingDocument, loadOptions);
 		}
 
		
		if(isExtractOriginalVoucherListEnabled(loadOptions)){
	 		extractOriginalVoucherList(accountingDocument, loadOptions);
 		}		
		
		if(isExtractAccountingDocumentLineListEnabled(loadOptions)){
	 		extractAccountingDocumentLineList(accountingDocument, loadOptions);
 		}		
		
		return accountingDocument;
		
	}



	
	
	 

 	protected AccountingDocument extractAccountingPeriod(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getAccountingPeriod() == null){
			return accountingDocument;
		}
		String accountingPeriodId = accountingDocument.getAccountingPeriod().getId();
		if( accountingPeriodId == null){
			return accountingDocument;
		}
		AccountingPeriod accountingPeriod = getAccountingPeriodDAO().load(accountingPeriodId,options);
		if(accountingPeriod != null){
			accountingDocument.setAccountingPeriod(accountingPeriod);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractDocumentType(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getDocumentType() == null){
			return accountingDocument;
		}
		String documentTypeId = accountingDocument.getDocumentType().getId();
		if( documentTypeId == null){
			return accountingDocument;
		}
		AccountingDocumentType documentType = getAccountingDocumentTypeDAO().load(documentTypeId,options);
		if(documentType != null){
			accountingDocument.setDocumentType(documentType);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractCreation(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getCreation() == null){
			return accountingDocument;
		}
		String creationId = accountingDocument.getCreation().getId();
		if( creationId == null){
			return accountingDocument;
		}
		AccountingDocumentCreation creation = getAccountingDocumentCreationDAO().load(creationId,options);
		if(creation != null){
			accountingDocument.setCreation(creation);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractConfirmation(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getConfirmation() == null){
			return accountingDocument;
		}
		String confirmationId = accountingDocument.getConfirmation().getId();
		if( confirmationId == null){
			return accountingDocument;
		}
		AccountingDocumentConfirmation confirmation = getAccountingDocumentConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			accountingDocument.setConfirmation(confirmation);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractAuditing(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getAuditing() == null){
			return accountingDocument;
		}
		String auditingId = accountingDocument.getAuditing().getId();
		if( auditingId == null){
			return accountingDocument;
		}
		AccountingDocumentAuditing auditing = getAccountingDocumentAuditingDAO().load(auditingId,options);
		if(auditing != null){
			accountingDocument.setAuditing(auditing);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractPosting(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getPosting() == null){
			return accountingDocument;
		}
		String postingId = accountingDocument.getPosting().getId();
		if( postingId == null){
			return accountingDocument;
		}
		AccountingDocumentPosting posting = getAccountingDocumentPostingDAO().load(postingId,options);
		if(posting != null){
			accountingDocument.setPosting(posting);
		}
		
 		
 		return accountingDocument;
 	}
 		
 
		
	protected AccountingDocument extractOriginalVoucherList(AccountingDocument accountingDocument, Map<String,Object> options){
		
		SmartList<OriginalVoucher> originalVoucherList = getOriginalVoucherDAO().findOriginalVoucherByBelongsTo(accountingDocument.getId(),options);
		if(originalVoucherList != null){
			accountingDocument.setOriginalVoucherList(originalVoucherList);
		}
		
		return accountingDocument;
	
	}	
		
	protected AccountingDocument extractAccountingDocumentLineList(AccountingDocument accountingDocument, Map<String,Object> options){
		
		SmartList<AccountingDocumentLine> accountingDocumentLineList = getAccountingDocumentLineDAO().findAccountingDocumentLineByBelongsTo(accountingDocument.getId(),options);
		if(accountingDocumentLineList != null){
			accountingDocument.setAccountingDocumentLineList(accountingDocumentLineList);
		}
		
		return accountingDocument;
	
	}	
		
		
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where accounting_period = ?";
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingPeriodId}, getAccountingDocumentMapper());	
 		return accountingDocumentList;
 	}
 	
 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where accounting_period = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingPeriodId,start, count}, getAccountingDocumentMapper());
		
 		return accountingDocumentList;
 	}
 	
 	public int countAccountingDocumentByAccountingPeriod(String accountingPeriodId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where accounting_period = ?";
		Integer count = queryInt(SQL, new Object[]{accountingPeriodId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where document_type = ?";
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentTypeId}, getAccountingDocumentMapper());	
 		return accountingDocumentList;
 	}
 	
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where document_type = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentTypeId,start, count}, getAccountingDocumentMapper());
		
 		return accountingDocumentList;
 	}
 	
 	public int countAccountingDocumentByDocumentType(String accountingDocumentTypeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where document_type = ?";
		Integer count = queryInt(SQL, new Object[]{accountingDocumentTypeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByCreation(String accountingDocumentCreationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where creation = ?";
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentCreationId}, getAccountingDocumentMapper());	
 		return accountingDocumentList;
 	}
 	
 	public SmartList<AccountingDocument> findAccountingDocumentByCreation(String accountingDocumentCreationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where creation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentCreationId,start, count}, getAccountingDocumentMapper());
		
 		return accountingDocumentList;
 	}
 	
 	public int countAccountingDocumentByCreation(String accountingDocumentCreationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where creation = ?";
		Integer count = queryInt(SQL, new Object[]{accountingDocumentCreationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByConfirmation(String accountingDocumentConfirmationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ?";
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentConfirmationId}, getAccountingDocumentMapper());	
 		return accountingDocumentList;
 	}
 	
 	public SmartList<AccountingDocument> findAccountingDocumentByConfirmation(String accountingDocumentConfirmationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentConfirmationId,start, count}, getAccountingDocumentMapper());
		
 		return accountingDocumentList;
 	}
 	
 	public int countAccountingDocumentByConfirmation(String accountingDocumentConfirmationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where confirmation = ?";
		Integer count = queryInt(SQL, new Object[]{accountingDocumentConfirmationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByAuditing(String accountingDocumentAuditingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where auditing = ?";
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentAuditingId}, getAccountingDocumentMapper());	
 		return accountingDocumentList;
 	}
 	
 	public SmartList<AccountingDocument> findAccountingDocumentByAuditing(String accountingDocumentAuditingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where auditing = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentAuditingId,start, count}, getAccountingDocumentMapper());
		
 		return accountingDocumentList;
 	}
 	
 	public int countAccountingDocumentByAuditing(String accountingDocumentAuditingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where auditing = ?";
		Integer count = queryInt(SQL, new Object[]{accountingDocumentAuditingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByPosting(String accountingDocumentPostingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where posting = ?";
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentPostingId}, getAccountingDocumentMapper());	
 		return accountingDocumentList;
 	}
 	
 	public SmartList<AccountingDocument> findAccountingDocumentByPosting(String accountingDocumentPostingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where posting = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountingDocument> accountingDocumentList = queryForList(SQL, new Object[]{accountingDocumentPostingId,start, count}, getAccountingDocumentMapper());
		
 		return accountingDocumentList;
 	}
 	
 	public int countAccountingDocumentByPosting(String accountingDocumentPostingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where posting = ?";
		Integer count = queryInt(SQL, new Object[]{accountingDocumentPostingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected AccountingDocument saveAccountingDocument(AccountingDocument  accountingDocument){
	
		String SQL=this.getSaveAccountingDocumentSQL(accountingDocument);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentParameters(accountingDocument);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocument.incVersion();
		return accountingDocument;
	
	}
	public SmartList<AccountingDocument> saveAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentList(accountingDocumentList);
		
		batchAccountingDocumentCreate((List<AccountingDocument>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentUpdate((List<AccountingDocument>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocument accountingDocument:accountingDocumentList){
			if(accountingDocument.isChanged()){
				accountingDocument.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentList;
	}

	public SmartList<AccountingDocument> removeAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentList, options);
		
		return accountingDocumentList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentBatchCreateArgs(List<AccountingDocument> accountingDocumentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocument accountingDocument:accountingDocumentList ){
			Object [] parameters = prepareAccountingDocumentCreateParameters(accountingDocument);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentBatchUpdateArgs(List<AccountingDocument> accountingDocumentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocument accountingDocument:accountingDocumentList ){
			if(!accountingDocument.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentUpdateParameters(accountingDocument);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentCreate(List<AccountingDocument> accountingDocumentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentBatchCreateArgs(accountingDocumentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentUpdate(List<AccountingDocument> accountingDocumentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentBatchUpdateArgs(accountingDocumentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentList(List<AccountingDocument> accountingDocumentList){
		
		List<AccountingDocument> accountingDocumentCreateList=new ArrayList<AccountingDocument>();
		List<AccountingDocument> accountingDocumentUpdateList=new ArrayList<AccountingDocument>();
		
		for(AccountingDocument accountingDocument: accountingDocumentList){
			if(isUpdateRequest(accountingDocument)){
				accountingDocumentUpdateList.add( accountingDocument);
				continue;
			}
			accountingDocumentCreateList.add(accountingDocument);
		}
		
		return new Object[]{accountingDocumentCreateList,accountingDocumentUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocument accountingDocument){
 		return accountingDocument.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentSQL(AccountingDocument accountingDocument){
 		if(isUpdateRequest(accountingDocument)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentParameters(AccountingDocument accountingDocument){
 		if(isUpdateRequest(accountingDocument) ){
 			return prepareAccountingDocumentUpdateParameters(accountingDocument);
 		}
 		return prepareAccountingDocumentCreateParameters(accountingDocument);
 	}
 	protected Object[] prepareAccountingDocumentUpdateParameters(AccountingDocument accountingDocument){
 		Object[] parameters = new Object[11];
 
 		parameters[0] = accountingDocument.getName();
 		parameters[1] = accountingDocument.getAccountingDocumentDate(); 	
 		if(accountingDocument.getAccountingPeriod() != null){
 			parameters[2] = accountingDocument.getAccountingPeriod().getId();
 		}
  	
 		if(accountingDocument.getDocumentType() != null){
 			parameters[3] = accountingDocument.getDocumentType().getId();
 		}
  	
 		if(accountingDocument.getCreation() != null){
 			parameters[4] = accountingDocument.getCreation().getId();
 		}
  	
 		if(accountingDocument.getConfirmation() != null){
 			parameters[5] = accountingDocument.getConfirmation().getId();
 		}
  	
 		if(accountingDocument.getAuditing() != null){
 			parameters[6] = accountingDocument.getAuditing().getId();
 		}
  	
 		if(accountingDocument.getPosting() != null){
 			parameters[7] = accountingDocument.getPosting().getId();
 		}
 
 		parameters[8] = accountingDocument.getCurrentStatus();		
 		parameters[9] = accountingDocument.getId();
 		parameters[10] = accountingDocument.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentCreateParameters(AccountingDocument accountingDocument){
		Object[] parameters = new Object[10];
		String newAccountingDocumentId=getNextId();
		accountingDocument.setId(newAccountingDocumentId);
		parameters[0] =  accountingDocument.getId();
 
 		parameters[1] = accountingDocument.getName();
 		parameters[2] = accountingDocument.getAccountingDocumentDate(); 	
 		if(accountingDocument.getAccountingPeriod() != null){
 			parameters[3] = accountingDocument.getAccountingPeriod().getId();
 		
 		}
 		 	
 		if(accountingDocument.getDocumentType() != null){
 			parameters[4] = accountingDocument.getDocumentType().getId();
 		
 		}
 		 	
 		if(accountingDocument.getCreation() != null){
 			parameters[5] = accountingDocument.getCreation().getId();
 		
 		}
 		 	
 		if(accountingDocument.getConfirmation() != null){
 			parameters[6] = accountingDocument.getConfirmation().getId();
 		
 		}
 		 	
 		if(accountingDocument.getAuditing() != null){
 			parameters[7] = accountingDocument.getAuditing().getId();
 		
 		}
 		 	
 		if(accountingDocument.getPosting() != null){
 			parameters[8] = accountingDocument.getPosting().getId();
 		
 		}
 		
 		parameters[9] = accountingDocument.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocument saveInternalAccountingDocument(AccountingDocument accountingDocument, Map<String,Object> options){
		
		saveAccountingDocument(accountingDocument);
 	
 		if(isSaveAccountingPeriodEnabled(options)){
	 		saveAccountingPeriod(accountingDocument, options);
 		}
  	
 		if(isSaveDocumentTypeEnabled(options)){
	 		saveDocumentType(accountingDocument, options);
 		}
  	
 		if(isSaveCreationEnabled(options)){
	 		saveCreation(accountingDocument, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(accountingDocument, options);
 		}
  	
 		if(isSaveAuditingEnabled(options)){
	 		saveAuditing(accountingDocument, options);
 		}
  	
 		if(isSavePostingEnabled(options)){
	 		savePosting(accountingDocument, options);
 		}
 
		
		if(isSaveOriginalVoucherListEnabled(options)){
	 		saveOriginalVoucherList(accountingDocument, options);
	 		removeOriginalVoucherList(accountingDocument, options);
	 		
 		}		
		
		if(isSaveAccountingDocumentLineListEnabled(options)){
	 		saveAccountingDocumentLineList(accountingDocument, options);
	 		removeAccountingDocumentLineList(accountingDocument, options);
	 		
 		}		
		
		return accountingDocument;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AccountingDocument saveAccountingPeriod(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getAccountingPeriod() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingPeriodDAO().save(accountingDocument.getAccountingPeriod(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument saveDocumentType(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getDocumentType() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentTypeDAO().save(accountingDocument.getDocumentType(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument saveCreation(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getCreation() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentCreationDAO().save(accountingDocument.getCreation(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument saveConfirmation(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getConfirmation() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentConfirmationDAO().save(accountingDocument.getConfirmation(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument saveAuditing(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getAuditing() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentAuditingDAO().save(accountingDocument.getAuditing(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument savePosting(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getPosting() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentPostingDAO().save(accountingDocument.getPosting(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected AccountingDocument saveOriginalVoucherList(AccountingDocument accountingDocument, Map<String,Object> options){
		SmartList<OriginalVoucher> originalVoucherList = accountingDocument.getOriginalVoucherList();
		if(originalVoucherList == null){
			return accountingDocument;
		}
		if(originalVoucherList.isEmpty()){
			return accountingDocument;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOriginalVoucherDAO().saveOriginalVoucherList(originalVoucherList,options);
		
		return accountingDocument;
	
	}
	
	protected AccountingDocument removeOriginalVoucherList(AccountingDocument accountingDocument, Map<String,Object> options){
	
	
		SmartList<OriginalVoucher> originalVoucherList = accountingDocument.getOriginalVoucherList();
		if(originalVoucherList == null){
			return accountingDocument;
		}	
	
		SmartList<OriginalVoucher> toRemoveOriginalVoucherList = originalVoucherList.getToRemoveList();
		
		if(toRemoveOriginalVoucherList == null){
			return accountingDocument;
		}
		if(toRemoveOriginalVoucherList.isEmpty()){
			return accountingDocument;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOriginalVoucherDAO().removeOriginalVoucherList(toRemoveOriginalVoucherList,options);
		
		return accountingDocument;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected AccountingDocument saveAccountingDocumentLineList(AccountingDocument accountingDocument, Map<String,Object> options){
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();
		if(accountingDocumentLineList == null){
			return accountingDocument;
		}
		if(accountingDocumentLineList.isEmpty()){
			return accountingDocument;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingDocumentLineDAO().saveAccountingDocumentLineList(accountingDocumentLineList,options);
		
		return accountingDocument;
	
	}
	
	protected AccountingDocument removeAccountingDocumentLineList(AccountingDocument accountingDocument, Map<String,Object> options){
	
	
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();
		if(accountingDocumentLineList == null){
			return accountingDocument;
		}	
	
		SmartList<AccountingDocumentLine> toRemoveAccountingDocumentLineList = accountingDocumentLineList.getToRemoveList();
		
		if(toRemoveAccountingDocumentLineList == null){
			return accountingDocument;
		}
		if(toRemoveAccountingDocumentLineList.isEmpty()){
			return accountingDocument;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentLineDAO().removeAccountingDocumentLineList(toRemoveAccountingDocumentLineList,options);
		
		return accountingDocument;
	
	}
	
	
	
 	
 	
	
	
	
		

	public AccountingDocument present(AccountingDocument accountingDocument,Map<String, Object> options){
	
		presentOriginalVoucherList(accountingDocument,options);
		presentAccountingDocumentLineList(accountingDocument,options);

		return accountingDocument;
	
	}
		
	
  	
 	protected AccountingDocument presentOriginalVoucherList(
			AccountingDocument accountingDocument,
			Map<String, Object> options) {

		SmartList<OriginalVoucher> originalVoucherList = accountingDocument.getOriginalVoucherList();		
		if(originalVoucherList == null){
			return accountingDocument;			
		}
		
		String targetObjectName = "originalVoucher";
		int originalVoucherListSize = originalVoucherList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(originalVoucherListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountingDocument;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = originalVoucherListSize;
		if(originalVoucherListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getOriginalVoucherDAO().countOriginalVoucherByBelongsTo(accountingDocument.getId(), options);			
		}
		//accountingDocument.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountingDocument.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(originalVoucherListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(originalVoucherListSize,currentPage,rowsPerPage) ;
			originalVoucherList = originalVoucherList.subListOf(fromIndex, toIndex);
			originalVoucherList.setTotalCount(count);
			originalVoucherList.setCurrentPageNumber(currentPage);			
			accountingDocument.setOriginalVoucherList(originalVoucherList);
			return accountingDocument;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		originalVoucherList 
			= getOriginalVoucherDAO().findOriginalVoucherByBelongsTo(accountingDocument.getId(),start, rowsPerPage, options );
		originalVoucherList.setTotalCount(count);
		originalVoucherList.setCurrentPageNumber(currentPage);
		accountingDocument.setOriginalVoucherList(originalVoucherList );	

		return accountingDocument;
	}			
		
	
  	
 	protected AccountingDocument presentAccountingDocumentLineList(
			AccountingDocument accountingDocument,
			Map<String, Object> options) {

		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();		
		if(accountingDocumentLineList == null){
			return accountingDocument;			
		}
		
		String targetObjectName = "accountingDocumentLine";
		int accountingDocumentLineListSize = accountingDocumentLineList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingDocumentLineListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountingDocument;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingDocumentLineListSize;
		if(accountingDocumentLineListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingDocumentLineDAO().countAccountingDocumentLineByBelongsTo(accountingDocument.getId(), options);			
		}
		//accountingDocument.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountingDocument.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingDocumentLineListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingDocumentLineListSize,currentPage,rowsPerPage) ;
			accountingDocumentLineList = accountingDocumentLineList.subListOf(fromIndex, toIndex);
			accountingDocumentLineList.setTotalCount(count);
			accountingDocumentLineList.setCurrentPageNumber(currentPage);			
			accountingDocument.setAccountingDocumentLineList(accountingDocumentLineList);
			return accountingDocument;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingDocumentLineList 
			= getAccountingDocumentLineDAO().findAccountingDocumentLineByBelongsTo(accountingDocument.getId(),start, rowsPerPage, options );
		accountingDocumentLineList.setTotalCount(count);
		accountingDocumentLineList.setCurrentPageNumber(currentPage);
		accountingDocument.setAccountingDocumentLineList(accountingDocumentLineList );	

		return accountingDocument;
	}			
		


	protected String getTableName(){
		return AccountingDocumentTable.TABLE_NAME;
	}
}


