
package com.skynet.retailscm.accountingdocumentposting;

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




public class AccountingDocumentPostingManagerImpl extends RetailScmCheckerManager implements AccountingDocumentPostingManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentPosting";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountingDocumentPostingDAO  accountingDocumentPostingDAO;
 	public void setAccountingDocumentPostingDAO(AccountingDocumentPostingDAO  accountingDocumentPostingDAO){
 	
 		if(accountingDocumentPostingDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentPostingDAO to null.");
 		}
	 	this.accountingDocumentPostingDAO = accountingDocumentPostingDAO;
 	}
 	public AccountingDocumentPostingDAO getAccountingDocumentPostingDAO(){
 		if(this.accountingDocumentPostingDAO == null){
 			throw new IllegalStateException("The AccountingDocumentPostingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentPostingDAO;
 	}
 	
 	protected AccountingDocumentPosting saveAccountingDocumentPosting(RetailScmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentPostingDAO().save(accountingDocumentPosting, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens);
 	}
 	
 	protected AccountingDocumentPosting saveAccountingDocumentPostingDetail(RetailScmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting) throws Exception{	

 		
 		return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, allTokens());
 	}
 	
 	public AccountingDocumentPosting loadAccountingDocumentPosting(RetailScmUserContext userContext, String accountingDocumentPostingId, String [] tokensExpr) throws Exception{				
 
 		AccountingDocumentPostingManagerException exception = new AccountingDocumentPostingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentPosting(userContext, accountingDocumentPostingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentPosting, tokens);
 	}
 	
 	protected AccountingDocumentPosting present(RetailScmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentPosting,tokens);
		
		
		return this.getAccountingDocumentPostingDAO().present(accountingDocumentPosting, tokens);
	}
 
 	
 	
 	public AccountingDocumentPosting loadAccountingDocumentPostingDetail(RetailScmUserContext userContext, String accountingDocumentPostingId) throws Exception{	
 		AccountingDocumentPostingManagerException exception = new AccountingDocumentPostingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentPosting(userContext, accountingDocumentPostingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, allTokens());

 		return present(userContext,accountingDocumentPosting, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountingDocumentPostingId) throws Exception{	
 		AccountingDocumentPostingManagerException exception = new AccountingDocumentPostingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentPosting(userContext, accountingDocumentPostingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, allTokens());

 		return present(userContext,accountingDocumentPosting, allTokens());
		
 	}
 	protected AccountingDocumentPosting saveAccountingDocumentPosting(RetailScmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentPostingDAO().save(accountingDocumentPosting, tokens);
 	}
 	protected AccountingDocumentPosting loadAccountingDocumentPosting(RetailScmUserContext userContext, String accountingDocumentPostingId, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentPostingDAO().load(accountingDocumentPostingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentPosting, tokens);
		
		addAction(userContext, accountingDocumentPosting, tokens,"@create","createAccountingDocumentPosting","createAccountingDocumentPosting/","main","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"@update","updateAccountingDocumentPosting","updateAccountingDocumentPosting/"+accountingDocumentPosting.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"@copy","cloneAccountingDocumentPosting","cloneAccountingDocumentPosting/"+accountingDocumentPosting.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentPosting createAccountingDocumentPosting(RetailScmUserContext userContext,String who, String comments, Date makeDate
) throws Exception
	{
		
		AccountingDocumentPostingManagerException exception = new AccountingDocumentPostingManagerException("Error Occured");

		

		checkWhoOfAccountingDocumentPosting(userContext,  who, exception);
		checkCommentsOfAccountingDocumentPosting(userContext,  comments, exception);
		checkMakeDateOfAccountingDocumentPosting(userContext,  makeDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountingDocumentPosting accountingDocumentPosting=createNewAccountingDocumentPosting();	

		accountingDocumentPosting.setWho(who);
		accountingDocumentPosting.setComments(comments);
		accountingDocumentPosting.setMakeDate(makeDate);

		return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, emptyOptions());
		

		
	}
	protected AccountingDocumentPosting createNewAccountingDocumentPosting() 
	{
		
		return new AccountingDocumentPosting();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentPosting(RetailScmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountingDocumentPostingManagerException exception = new AccountingDocumentPostingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentPosting(userContext, accountingDocumentPostingId, exception);
		checkVersionOfAccountingDocumentPosting(userContext, accountingDocumentPostingVersion, exception);
		

		if(AccountingDocumentPosting.WHO_PROPERTY.equals(property)){
			checkWhoOfAccountingDocumentPosting(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingDocumentPosting.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfAccountingDocumentPosting(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingDocumentPosting.MAKE_DATE_PROPERTY.equals(property)){
			checkMakeDateOfAccountingDocumentPosting(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public AccountingDocumentPosting clone(RetailScmUserContext userContext, String fromAccountingDocumentPostingId) throws Exception{
		
		return this.getAccountingDocumentPostingDAO().clone(fromAccountingDocumentPostingId, this.allTokens());
	}
	
	public AccountingDocumentPosting updateAccountingDocumentPosting(RetailScmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentPosting(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		if(accountingDocumentPosting.getVersion() != accountingDocumentPostingVersion){
			String message = "The target version("+accountingDocumentPosting.getVersion()+") is not equals to version("+accountingDocumentPostingVersion+") provided";
			throw new AccountingDocumentPostingManagerException(message);
		}
		synchronized(accountingDocumentPosting){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentPosting.
			
			accountingDocumentPosting.changePropery(property, newValueExpr);
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentPostingTokens tokens(){
		return AccountingDocumentPostingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentPostingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentPostingTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception {
		
		deleteInternal(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception{
		getAccountingDocumentPostingDAO().delete(accountingDocumentPostingId, accountingDocumentPostingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentPostingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountingDocumentPostingDAO().deleteAll();
	}

	protected void checkParamsForAddingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId,String [] tokensExpr) throws Exception{
		
		

		AccountingDocumentPostingManagerException exception = new AccountingDocumentPostingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentPosting(userContext, accountingDocumentPostingId, exception);

		checkNameOfAccountingDocument(userContext,  name, exception);
		checkAccountingDocumentDateOfAccountingDocument(userContext,  accountingDocumentDate, exception);		
		
		checkIdOfAccountingPeriod(userContext,  accountingPeriodId, exception);		
		
		checkIdOfAccountingDocumentType(userContext,  documentTypeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountingDocumentPosting addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentPostingId,name, accountingDocumentDate, accountingPeriodId, documentTypeId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId);
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		synchronized(accountingDocumentPosting){ 
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentPosting.addAccountingDocument( accountingDocument );		
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentPostingManagerException exception = new AccountingDocumentPostingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentPosting(userContext, accountingDocumentPostingId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentPosting removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentPostingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		synchronized(accountingDocumentPosting){ 
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentPosting.removeAccountingDocument( accountingDocument );		
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentPostingManagerException exception = new AccountingDocumentPostingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentPosting(userContext, accountingDocumentPostingId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentPosting copyAccountingDocumentFrom(RetailScmUserContext userContext, String accountingDocumentPostingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentPostingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		synchronized(accountingDocumentPosting){ 
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentPosting.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountingDocumentPostingManagerException exception = new AccountingDocumentPostingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentPosting(userContext, accountingDocumentPostingId, exception);
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
	
	public  AccountingDocumentPosting updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentPostingId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		
		synchronized(accountingDocumentPosting){ 
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentPosting.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentPosting.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentPostingManagerException(accountingDocument+"Not found" );
			}
			
			accountingDocument.changePropery(property, newValueExpr);

			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


