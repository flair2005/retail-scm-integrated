
package com.skynet.retailscm.accountingdocumentcreation;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.accountingdocument.AccountingDocument;


import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPosting;


import com.skynet.retailscm.accountingdocument.AccountingDocumentTable;




public class AccountingDocumentCreationManagerImpl extends RetailScmCheckerManager implements AccountingDocumentCreationManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentCreation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountingDocumentCreationDAO  accountingDocumentCreationDAO;
 	public void setAccountingDocumentCreationDAO(AccountingDocumentCreationDAO  accountingDocumentCreationDAO){
 	
 		if(accountingDocumentCreationDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentCreationDAO to null.");
 		}
	 	this.accountingDocumentCreationDAO = accountingDocumentCreationDAO;
 	}
 	public AccountingDocumentCreationDAO getAccountingDocumentCreationDAO(){
 		if(this.accountingDocumentCreationDAO == null){
 			throw new IllegalStateException("The AccountingDocumentCreationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentCreationDAO;
 	}
 	
 	protected AccountingDocumentCreation saveAccountingDocumentCreation(RetailScmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentCreationDAO().save(accountingDocumentCreation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens);
 	}
 	
 	protected AccountingDocumentCreation saveAccountingDocumentCreationDetail(RetailScmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation) throws Exception{	

 		
 		return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, allTokens());
 	}
 	
 	public AccountingDocumentCreation loadAccountingDocumentCreation(RetailScmUserContext userContext, String accountingDocumentCreationId, String [] tokensExpr) throws Exception{				
 
 		AccountingDocumentCreationManagerException exception = new AccountingDocumentCreationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentCreation(userContext, accountingDocumentCreationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentCreation, tokens);
 	}
 	
 	protected AccountingDocumentCreation present(RetailScmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentCreation,tokens);
		
		
		return this.getAccountingDocumentCreationDAO().present(accountingDocumentCreation, tokens);
	}
 
 	
 	
 	public AccountingDocumentCreation loadAccountingDocumentCreationDetail(RetailScmUserContext userContext, String accountingDocumentCreationId) throws Exception{	
 		AccountingDocumentCreationManagerException exception = new AccountingDocumentCreationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentCreation(userContext, accountingDocumentCreationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, allTokens());

 		return present(userContext,accountingDocumentCreation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountingDocumentCreationId) throws Exception{	
 		AccountingDocumentCreationManagerException exception = new AccountingDocumentCreationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentCreation(userContext, accountingDocumentCreationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, allTokens());

 		return present(userContext,accountingDocumentCreation, allTokens());
		
 	}
 	protected AccountingDocumentCreation saveAccountingDocumentCreation(RetailScmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentCreationDAO().save(accountingDocumentCreation, tokens);
 	}
 	protected AccountingDocumentCreation loadAccountingDocumentCreation(RetailScmUserContext userContext, String accountingDocumentCreationId, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentCreationDAO().load(accountingDocumentCreationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentCreation, tokens);
		
		addAction(userContext, accountingDocumentCreation, tokens,"@create","createAccountingDocumentCreation","createAccountingDocumentCreation/","main","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"@update","updateAccountingDocumentCreation","updateAccountingDocumentCreation/"+accountingDocumentCreation.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"@copy","cloneAccountingDocumentCreation","cloneAccountingDocumentCreation/"+accountingDocumentCreation.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentCreation createAccountingDocumentCreation(RetailScmUserContext userContext,String who, String comments, Date makeDate
) throws Exception
	{
		
		AccountingDocumentCreationManagerException exception = new AccountingDocumentCreationManagerException("Error Occured");

		

		checkWhoOfAccountingDocumentCreation(userContext,  who, exception);
		checkCommentsOfAccountingDocumentCreation(userContext,  comments, exception);
		checkMakeDateOfAccountingDocumentCreation(userContext,  makeDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountingDocumentCreation accountingDocumentCreation=createNewAccountingDocumentCreation();	

		accountingDocumentCreation.setWho(who);
		accountingDocumentCreation.setComments(comments);
		accountingDocumentCreation.setMakeDate(makeDate);

		return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, emptyOptions());
		

		
	}
	protected AccountingDocumentCreation createNewAccountingDocumentCreation() 
	{
		
		return new AccountingDocumentCreation();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentCreation(RetailScmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountingDocumentCreationManagerException exception = new AccountingDocumentCreationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentCreation(userContext, accountingDocumentCreationId, exception);
		checkVersionOfAccountingDocumentCreation(userContext, accountingDocumentCreationVersion, exception);
		

		if(AccountingDocumentCreation.WHO_PROPERTY.equals(property)){
			checkWhoOfAccountingDocumentCreation(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingDocumentCreation.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfAccountingDocumentCreation(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingDocumentCreation.MAKE_DATE_PROPERTY.equals(property)){
			checkMakeDateOfAccountingDocumentCreation(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public AccountingDocumentCreation clone(RetailScmUserContext userContext, String fromAccountingDocumentCreationId) throws Exception{
		
		return this.getAccountingDocumentCreationDAO().clone(fromAccountingDocumentCreationId, this.allTokens());
	}
	
	public AccountingDocumentCreation updateAccountingDocumentCreation(RetailScmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentCreation(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		if(accountingDocumentCreation.getVersion() != accountingDocumentCreationVersion){
			String message = "The target version("+accountingDocumentCreation.getVersion()+") is not equals to version("+accountingDocumentCreationVersion+") provided";
			throw new AccountingDocumentCreationManagerException(message);
		}
		synchronized(accountingDocumentCreation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentCreation.
			
			accountingDocumentCreation.changePropery(property, newValueExpr);
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentCreationTokens tokens(){
		return AccountingDocumentCreationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentCreationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentCreationTokens.mergeAll(tokens).done();
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
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception {
		
		deleteInternal(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception{
		getAccountingDocumentCreationDAO().delete(accountingDocumentCreationId, accountingDocumentCreationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentCreationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountingDocumentCreationDAO().deleteAll();
	}

	protected void checkParamsForAddingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId,String [] tokensExpr) throws Exception{
		
		

		AccountingDocumentCreationManagerException exception = new AccountingDocumentCreationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentCreation(userContext, accountingDocumentCreationId, exception);

		checkNameOfAccountingDocument(userContext,  name, exception);
		checkAccountingDocumentDateOfAccountingDocument(userContext,  accountingDocumentDate, exception);		
		
		checkIdOfAccountingPeriod(userContext,  accountingPeriodId, exception);		
		
		checkIdOfAccountingDocumentType(userContext,  documentTypeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountingDocumentCreation addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentCreationId,name, accountingDocumentDate, accountingPeriodId, documentTypeId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId);
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		synchronized(accountingDocumentCreation){ 
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentCreation.addAccountingDocument( accountingDocument );		
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountingDocument createAccountingDocument(RetailScmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId) throws Exception{

		AccountingDocument accountingDocument = new AccountingDocument();
		
		
		accountingDocument.setName(name);		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);		
		AccountingPeriod  accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(accountingPeriodId);		
		accountingDocument.setAccountingPeriod(accountingPeriod);		
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
	protected void checkParamsForRemovingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentCreationManagerException exception = new AccountingDocumentCreationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentCreation(userContext, accountingDocumentCreationId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentCreation removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentCreationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		synchronized(accountingDocumentCreation){ 
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentCreation.removeAccountingDocument( accountingDocument );		
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentCreationManagerException exception = new AccountingDocumentCreationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentCreation(userContext, accountingDocumentCreationId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentCreation copyAccountingDocumentFrom(RetailScmUserContext userContext, String accountingDocumentCreationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentCreationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		synchronized(accountingDocumentCreation){ 
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentCreation.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountingDocumentCreationManagerException exception = new AccountingDocumentCreationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentCreation(userContext, accountingDocumentCreationId, exception);
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
	
	public  AccountingDocumentCreation updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentCreationId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		
		synchronized(accountingDocumentCreation){ 
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentCreation.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentCreation.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentCreationManagerException(accountingDocument+"Not found" );
			}
			
			accountingDocument.changePropery(property, newValueExpr);

			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


