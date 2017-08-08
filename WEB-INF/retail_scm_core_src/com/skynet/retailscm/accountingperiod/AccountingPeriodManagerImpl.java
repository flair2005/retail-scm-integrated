
package com.skynet.retailscm.accountingperiod;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.accountingdocument.AccountingDocument;
import com.skynet.retailscm.accountset.AccountSet;

import com.skynet.retailscm.accountset.AccountSetDAO;

import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPosting;


import com.skynet.retailscm.accountingdocument.AccountingDocumentTable;
import com.skynet.retailscm.accountset.AccountSetTable;




public class AccountingPeriodManagerImpl extends RetailScmCheckerManager implements AccountingPeriodManager {
	
	private static final String SERVICE_TYPE = "AccountingPeriod";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountingPeriodDAO  accountingPeriodDAO;
 	public void setAccountingPeriodDAO(AccountingPeriodDAO  accountingPeriodDAO){
 	
 		if(accountingPeriodDAO == null){
 			throw new IllegalStateException("Do not try to set accountingPeriodDAO to null.");
 		}
	 	this.accountingPeriodDAO = accountingPeriodDAO;
 	}
 	public AccountingPeriodDAO getAccountingPeriodDAO(){
 		if(this.accountingPeriodDAO == null){
 			throw new IllegalStateException("The AccountingPeriodDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingPeriodDAO;
 	}
 	
 	protected AccountingPeriod saveAccountingPeriod(RetailScmUserContext userContext, AccountingPeriod accountingPeriod, String [] tokensExpr) throws Exception{	
 		//return getAccountingPeriodDAO().save(accountingPeriod, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingPeriod(userContext, accountingPeriod, tokens);
 	}
 	
 	protected AccountingPeriod saveAccountingPeriodDetail(RetailScmUserContext userContext, AccountingPeriod accountingPeriod) throws Exception{	

 		
 		return saveAccountingPeriod(userContext, accountingPeriod, allTokens());
 	}
 	
 	public AccountingPeriod loadAccountingPeriod(RetailScmUserContext userContext, String accountingPeriodId, String [] tokensExpr) throws Exception{				
 
 		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");
		
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingPeriod, tokens);
 	}
 	
 	protected AccountingPeriod present(RetailScmUserContext userContext, AccountingPeriod accountingPeriod, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingPeriod,tokens);
		
		
		return this.getAccountingPeriodDAO().present(accountingPeriod, tokens);
	}
 
 	
 	
 	public AccountingPeriod loadAccountingPeriodDetail(RetailScmUserContext userContext, String accountingPeriodId) throws Exception{	
 		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");
		
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, allTokens());

 		return present(userContext,accountingPeriod, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountingPeriodId) throws Exception{	
 		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");
		
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingPeriod accountingPeriod = loadAccountingPeriod( userContext, accountingPeriodId, allTokens());

 		return present(userContext,accountingPeriod, allTokens());
		
 	}
 	protected AccountingPeriod saveAccountingPeriod(RetailScmUserContext userContext, AccountingPeriod accountingPeriod, Map<String,Object>tokens) throws Exception{	
 		return getAccountingPeriodDAO().save(accountingPeriod, tokens);
 	}
 	protected AccountingPeriod loadAccountingPeriod(RetailScmUserContext userContext, String accountingPeriodId, Map<String,Object>tokens) throws Exception{	
 		return getAccountingPeriodDAO().load(accountingPeriodId, tokens);
 	}

	



 	 
 	
 	private  AccountSetDAO  accountSetDAO;
 	public void setAccountSetDAO(AccountSetDAO accountSetDAO){
	 	this.accountSetDAO = accountSetDAO;
 	}
 	//------------------------------------
 	public AccountSetDAO getAccountSetDAO(){
	 	return this.accountSetDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingPeriod accountingPeriod, Map<String, Object> tokens){
		super.addActions(userContext, accountingPeriod, tokens);
		
		addAction(userContext, accountingPeriod, tokens,"@create","createAccountingPeriod","createAccountingPeriod/","main","primary");
		addAction(userContext, accountingPeriod, tokens,"@update","updateAccountingPeriod","updateAccountingPeriod/"+accountingPeriod.getId()+"/","main","primary");
		addAction(userContext, accountingPeriod, tokens,"@copy","cloneAccountingPeriod","cloneAccountingPeriod/"+accountingPeriod.getId()+"/","main","primary");
		
		addAction(userContext, accountingPeriod, tokens,"accounting_period.transfer_to_account_set","transferToAnotherAccountSet","transferToAnotherAccountSet/"+accountingPeriod.getId()+"/","main","primary");
		addAction(userContext, accountingPeriod, tokens,"accounting_period.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingPeriod.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingPeriod, tokens,"accounting_period.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingPeriod.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingPeriod, tokens,"accounting_period.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingPeriod.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingPeriod, tokens,"accounting_period.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingPeriod.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingPeriod accountingPeriod, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingPeriod createAccountingPeriod(RetailScmUserContext userContext,String name, Date startDate, Date endDate, String accountSetId
) throws Exception
	{
		
		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");

		

		checkNameOfAccountingPeriod(userContext,  name, exception);
		checkStartDateOfAccountingPeriod(userContext,  startDate, exception);
		checkEndDateOfAccountingPeriod(userContext,  endDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountingPeriod accountingPeriod=createNewAccountingPeriod();	

		accountingPeriod.setName(name);
		accountingPeriod.setStartDate(startDate);
		accountingPeriod.setEndDate(endDate);
		AccountSet accountSet = loadAccountSet(accountSetId,emptyOptions());
		accountingPeriod.setAccountSet(accountSet);

		return saveAccountingPeriod(userContext, accountingPeriod, emptyOptions());
		

		
	}
	protected AccountingPeriod createNewAccountingPeriod() 
	{
		
		return new AccountingPeriod();		
	}
	
	protected void checkParamsForUpdatingAccountingPeriod(RetailScmUserContext userContext,String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");
		
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);
		checkVersionOfAccountingPeriod(userContext, accountingPeriodVersion, exception);
		

		if(AccountingPeriod.NAME_PROPERTY.equals(property)){
			checkNameOfAccountingPeriod(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingPeriod.START_DATE_PROPERTY.equals(property)){
			checkStartDateOfAccountingPeriod(userContext, parseDate(newValueExpr), exception);
		}
		if(AccountingPeriod.END_DATE_PROPERTY.equals(property)){
			checkEndDateOfAccountingPeriod(userContext, parseDate(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public AccountingPeriod clone(RetailScmUserContext userContext, String fromAccountingPeriodId) throws Exception{
		
		return this.getAccountingPeriodDAO().clone(fromAccountingPeriodId, this.allTokens());
	}
	
	public AccountingPeriod updateAccountingPeriod(RetailScmUserContext userContext,String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingPeriod(userContext, accountingPeriodId, accountingPeriodVersion, property, newValueExpr, tokensExpr);
		
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
		if(accountingPeriod.getVersion() != accountingPeriodVersion){
			String message = "The target version("+accountingPeriod.getVersion()+") is not equals to version("+accountingPeriodVersion+") provided";
			throw new AccountingPeriodManagerException(message);
		}
		synchronized(accountingPeriod){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingPeriod.
			
			accountingPeriod.changePropery(property, newValueExpr);
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().done());
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
			//return saveAccountingPeriod(userContext, accountingPeriod, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingPeriodTokens tokens(){
		return AccountingPeriodTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingPeriodTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingPeriodTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={};
 	protected String getNextStatus(RetailScmUserContext userContext, String currentStatus){
 	
 		if(currentStatus == null){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE[0];
 		}
 	
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throw new IllegalArgumentException("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		//this is not the last one, just return it.
 		
 		return STATUS_SEQUENCE[index+1];
 	
 	}/**/
	
	protected void checkParamsForTransferingAnotherAccountSet(RetailScmUserContext userContext, String accountingPeriodId, String anotherAccountSetId) throws Exception
 	{
 		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");
 		checkIdOfAccountingPeriod(userContext, accountingPeriodId,exception);
 		checkIdOfAccountSet(userContext, anotherAccountSetId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountingPeriod transferToAnotherAccountSet(RetailScmUserContext userContext, String accountingPeriodId, String anotherAccountSetId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountSet(userContext, accountingPeriodId,anotherAccountSetId);
 
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());	
		synchronized(accountingPeriod){
			//will be good when the accountingPeriod loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountSet accountSet = loadAccountSet(anotherAccountSetId, emptyOptions());		
			accountingPeriod.setAccountSet(accountSet);		
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, emptyOptions());
			
			return present(userContext,accountingPeriod, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected AccountSet loadAccountSet(String newAccountSetId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountSetDAO().load(newAccountSetId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String accountingPeriodId, int accountingPeriodVersion) throws Exception {
		
		deleteInternal(userContext, accountingPeriodId, accountingPeriodVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountingPeriodId, int accountingPeriodVersion) throws Exception{
		getAccountingPeriodDAO().delete(accountingPeriodId, accountingPeriodVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingPeriodManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountingPeriodDAO().deleteAll();
	}

	protected void checkParamsForAddingAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String documentTypeId,String [] tokensExpr) throws Exception{
		
		

		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");
		
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);

		checkNameOfAccountingDocument(userContext,  name, exception);
		checkAccountingDocumentDateOfAccountingDocument(userContext,  accountingDocumentDate, exception);		
		
		checkIdOfAccountingDocumentType(userContext,  documentTypeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountingPeriod addAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String documentTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingPeriodId,name, accountingDocumentDate, documentTypeId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, documentTypeId);
		
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
		synchronized(accountingPeriod){ 
			//Will be good when the accountingPeriod loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingPeriod.addAccountingDocument( accountingDocument );		
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountingDocument createAccountingDocument(RetailScmUserContext userContext, String name, Date accountingDocumentDate, String documentTypeId) throws Exception{

		AccountingDocument accountingDocument = new AccountingDocument();
		
		
		accountingDocument.setName(name);		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);		
		AccountingDocumentType  documentType = new AccountingDocumentType();
		documentType.setId(documentTypeId);		
		accountingDocument.setDocumentType(documentType);
	
		
		return accountingDocument;
	
		
	}
	
	protected AccountingDocument createIndexedAccountingDocument(String id, int version){

		AccountingDocument accountingDocument = new AccountingDocument();
		accountingDocument.setId(id);
		accountingDocument.setVersion(version);
		return accountingDocument;			
		
	}
	protected void checkParamsForRemovingAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");
		
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingPeriod removeAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingPeriodId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
		synchronized(accountingPeriod){ 
			//Will be good when the accountingPeriod loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingPeriod.removeAccountingDocument( accountingDocument );		
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");
		
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingPeriod copyAccountingDocumentFrom(RetailScmUserContext userContext, String accountingPeriodId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingPeriodId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
		synchronized(accountingPeriod){ 
			//Will be good when the accountingPeriod loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingPeriod.copyAccountingDocumentFrom( accountingDocument );		
			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountingPeriodManagerException exception = new AccountingPeriodManagerException("Error Occured");
		
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
			checkNameOfAccountingDocument(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			checkAccountingDocumentDateOfAccountingDocument(userContext, parseDate(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  AccountingPeriod updateAccountingDocument(RetailScmUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingPeriodId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId, allTokens());
		
		synchronized(accountingPeriod){ 
			//Will be good when the accountingPeriod loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingPeriod.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingPeriod.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingPeriodManagerException(accountingDocument+"Not found" );
			}
			
			accountingDocument.changePropery(property, newValueExpr);

			accountingPeriod = saveAccountingPeriod(userContext, accountingPeriod, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingPeriod, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


