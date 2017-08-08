
package com.skynet.retailscm.accountingdocumentconfirmation;

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




public class AccountingDocumentConfirmationManagerImpl extends RetailScmCheckerManager implements AccountingDocumentConfirmationManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentConfirmation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountingDocumentConfirmationDAO  accountingDocumentConfirmationDAO;
 	public void setAccountingDocumentConfirmationDAO(AccountingDocumentConfirmationDAO  accountingDocumentConfirmationDAO){
 	
 		if(accountingDocumentConfirmationDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentConfirmationDAO to null.");
 		}
	 	this.accountingDocumentConfirmationDAO = accountingDocumentConfirmationDAO;
 	}
 	public AccountingDocumentConfirmationDAO getAccountingDocumentConfirmationDAO(){
 		if(this.accountingDocumentConfirmationDAO == null){
 			throw new IllegalStateException("The AccountingDocumentConfirmationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentConfirmationDAO;
 	}
 	
 	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmation(RetailScmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentConfirmationDAO().save(accountingDocumentConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens);
 	}
 	
 	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmationDetail(RetailScmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation) throws Exception{	

 		
 		return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, allTokens());
 	}
 	
 	public AccountingDocumentConfirmation loadAccountingDocumentConfirmation(RetailScmUserContext userContext, String accountingDocumentConfirmationId, String [] tokensExpr) throws Exception{				
 
 		AccountingDocumentConfirmationManagerException exception = new AccountingDocumentConfirmationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentConfirmation, tokens);
 	}
 	
 	protected AccountingDocumentConfirmation present(RetailScmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentConfirmation,tokens);
		
		
		return this.getAccountingDocumentConfirmationDAO().present(accountingDocumentConfirmation, tokens);
	}
 
 	
 	
 	public AccountingDocumentConfirmation loadAccountingDocumentConfirmationDetail(RetailScmUserContext userContext, String accountingDocumentConfirmationId) throws Exception{	
 		AccountingDocumentConfirmationManagerException exception = new AccountingDocumentConfirmationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, allTokens());

 		return present(userContext,accountingDocumentConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountingDocumentConfirmationId) throws Exception{	
 		AccountingDocumentConfirmationManagerException exception = new AccountingDocumentConfirmationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, allTokens());

 		return present(userContext,accountingDocumentConfirmation, allTokens());
		
 	}
 	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmation(RetailScmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentConfirmationDAO().save(accountingDocumentConfirmation, tokens);
 	}
 	protected AccountingDocumentConfirmation loadAccountingDocumentConfirmation(RetailScmUserContext userContext, String accountingDocumentConfirmationId, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentConfirmationDAO().load(accountingDocumentConfirmationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentConfirmation, tokens);
		
		addAction(userContext, accountingDocumentConfirmation, tokens,"@create","createAccountingDocumentConfirmation","createAccountingDocumentConfirmation/","main","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"@update","updateAccountingDocumentConfirmation","updateAccountingDocumentConfirmation/"+accountingDocumentConfirmation.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"@copy","cloneAccountingDocumentConfirmation","cloneAccountingDocumentConfirmation/"+accountingDocumentConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentConfirmation createAccountingDocumentConfirmation(RetailScmUserContext userContext,String who, String comments, Date makeDate
) throws Exception
	{
		
		AccountingDocumentConfirmationManagerException exception = new AccountingDocumentConfirmationManagerException("Error Occured");

		

		checkWhoOfAccountingDocumentConfirmation(userContext,  who, exception);
		checkCommentsOfAccountingDocumentConfirmation(userContext,  comments, exception);
		checkMakeDateOfAccountingDocumentConfirmation(userContext,  makeDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountingDocumentConfirmation accountingDocumentConfirmation=createNewAccountingDocumentConfirmation();	

		accountingDocumentConfirmation.setWho(who);
		accountingDocumentConfirmation.setComments(comments);
		accountingDocumentConfirmation.setMakeDate(makeDate);

		return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, emptyOptions());
		

		
	}
	protected AccountingDocumentConfirmation createNewAccountingDocumentConfirmation() 
	{
		
		return new AccountingDocumentConfirmation();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentConfirmation(RetailScmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountingDocumentConfirmationManagerException exception = new AccountingDocumentConfirmationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, exception);
		checkVersionOfAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationVersion, exception);
		

		if(AccountingDocumentConfirmation.WHO_PROPERTY.equals(property)){
			checkWhoOfAccountingDocumentConfirmation(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingDocumentConfirmation.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfAccountingDocumentConfirmation(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingDocumentConfirmation.MAKE_DATE_PROPERTY.equals(property)){
			checkMakeDateOfAccountingDocumentConfirmation(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public AccountingDocumentConfirmation clone(RetailScmUserContext userContext, String fromAccountingDocumentConfirmationId) throws Exception{
		
		return this.getAccountingDocumentConfirmationDAO().clone(fromAccountingDocumentConfirmationId, this.allTokens());
	}
	
	public AccountingDocumentConfirmation updateAccountingDocumentConfirmation(RetailScmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		if(accountingDocumentConfirmation.getVersion() != accountingDocumentConfirmationVersion){
			String message = "The target version("+accountingDocumentConfirmation.getVersion()+") is not equals to version("+accountingDocumentConfirmationVersion+") provided";
			throw new AccountingDocumentConfirmationManagerException(message);
		}
		synchronized(accountingDocumentConfirmation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentConfirmation.
			
			accountingDocumentConfirmation.changePropery(property, newValueExpr);
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentConfirmationTokens tokens(){
		return AccountingDocumentConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentConfirmationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentConfirmationTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception {
		
		deleteInternal(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception{
		getAccountingDocumentConfirmationDAO().delete(accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountingDocumentConfirmationDAO().deleteAll();
	}

	protected void checkParamsForAddingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId,String [] tokensExpr) throws Exception{
		
		

		AccountingDocumentConfirmationManagerException exception = new AccountingDocumentConfirmationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, exception);

		checkNameOfAccountingDocument(userContext,  name, exception);
		checkAccountingDocumentDateOfAccountingDocument(userContext,  accountingDocumentDate, exception);		
		
		checkIdOfAccountingPeriod(userContext,  accountingPeriodId, exception);		
		
		checkIdOfAccountingDocumentType(userContext,  documentTypeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountingDocumentConfirmation addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentConfirmationId,name, accountingDocumentDate, accountingPeriodId, documentTypeId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId);
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		synchronized(accountingDocumentConfirmation){ 
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentConfirmation.addAccountingDocument( accountingDocument );		
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentConfirmationManagerException exception = new AccountingDocumentConfirmationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentConfirmation removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentConfirmationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		synchronized(accountingDocumentConfirmation){ 
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentConfirmation.removeAccountingDocument( accountingDocument );		
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentConfirmationManagerException exception = new AccountingDocumentConfirmationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentConfirmation copyAccountingDocumentFrom(RetailScmUserContext userContext, String accountingDocumentConfirmationId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentConfirmationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		synchronized(accountingDocumentConfirmation){ 
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentConfirmation.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountingDocumentConfirmationManagerException exception = new AccountingDocumentConfirmationManagerException("Error Occured");
		
		checkIdOfAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, exception);
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
	
	public  AccountingDocumentConfirmation updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentConfirmationId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		
		synchronized(accountingDocumentConfirmation){ 
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentConfirmation.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentConfirmation.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentConfirmationManagerException(accountingDocument+"Not found" );
			}
			
			accountingDocument.changePropery(property, newValueExpr);

			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


