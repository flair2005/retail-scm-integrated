
package com.skynet.retailscm.accountingdocumentauditing;

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




public class AccountingDocumentAuditingManagerImpl extends RetailScmCheckerManager implements AccountingDocumentAuditingManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentAuditing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountingDocumentAuditingDAO  accountingDocumentAuditingDAO;
 	public void setAccountingDocumentAuditingDAO(AccountingDocumentAuditingDAO  accountingDocumentAuditingDAO){
 	
 		if(accountingDocumentAuditingDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentAuditingDAO to null.");
 		}
	 	this.accountingDocumentAuditingDAO = accountingDocumentAuditingDAO;
 	}
 	public AccountingDocumentAuditingDAO getAccountingDocumentAuditingDAO(){
 		if(this.accountingDocumentAuditingDAO == null){
 			throw new IllegalStateException("The AccountingDocumentAuditingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentAuditingDAO;
 	}
 	
 	protected AccountingDocumentAuditing saveAccountingDocumentAuditing(RetailScmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentAuditingDAO().save(accountingDocumentAuditing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens);
 	}
 	
 	protected AccountingDocumentAuditing saveAccountingDocumentAuditingDetail(RetailScmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing) throws Exception{	

 		
 		return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, allTokens());
 	}
 	
 	public AccountingDocumentAuditing loadAccountingDocumentAuditing(RetailScmUserContext userContext, String accountingDocumentAuditingId, String [] tokensExpr) throws Exception{				
 
 		AccountingDocumentAuditingManagerException exception = new AccountingDocumentAuditingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentAuditing, tokens);
 	}
 	
 	protected AccountingDocumentAuditing present(RetailScmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentAuditing,tokens);
		
		
		return this.getAccountingDocumentAuditingDAO().present(accountingDocumentAuditing, tokens);
	}
 
 	
 	
 	public AccountingDocumentAuditing loadAccountingDocumentAuditingDetail(RetailScmUserContext userContext, String accountingDocumentAuditingId) throws Exception{	
 		AccountingDocumentAuditingManagerException exception = new AccountingDocumentAuditingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, allTokens());

 		return present(userContext,accountingDocumentAuditing, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountingDocumentAuditingId) throws Exception{	
 		AccountingDocumentAuditingManagerException exception = new AccountingDocumentAuditingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, allTokens());

 		return present(userContext,accountingDocumentAuditing, allTokens());
		
 	}
 	protected AccountingDocumentAuditing saveAccountingDocumentAuditing(RetailScmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentAuditingDAO().save(accountingDocumentAuditing, tokens);
 	}
 	protected AccountingDocumentAuditing loadAccountingDocumentAuditing(RetailScmUserContext userContext, String accountingDocumentAuditingId, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentAuditingDAO().load(accountingDocumentAuditingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentAuditing, tokens);
		
		addAction(userContext, accountingDocumentAuditing, tokens,"@create","createAccountingDocumentAuditing","createAccountingDocumentAuditing/","main","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"@update","updateAccountingDocumentAuditing","updateAccountingDocumentAuditing/"+accountingDocumentAuditing.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"@copy","cloneAccountingDocumentAuditing","cloneAccountingDocumentAuditing/"+accountingDocumentAuditing.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentAuditing createAccountingDocumentAuditing(RetailScmUserContext userContext,String who, String comments, Date makeDate
) throws Exception
	{
		
		AccountingDocumentAuditingManagerException exception = new AccountingDocumentAuditingManagerException("Error Occured");

		

		checkWhoOfAccountingDocumentAuditing(userContext,  who, exception);
		checkCommentsOfAccountingDocumentAuditing(userContext,  comments, exception);
		checkMakeDateOfAccountingDocumentAuditing(userContext,  makeDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountingDocumentAuditing accountingDocumentAuditing=createNewAccountingDocumentAuditing();	

		accountingDocumentAuditing.setWho(who);
		accountingDocumentAuditing.setComments(comments);
		accountingDocumentAuditing.setMakeDate(makeDate);

		return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, emptyOptions());
		

		
	}
	protected AccountingDocumentAuditing createNewAccountingDocumentAuditing() 
	{
		
		return new AccountingDocumentAuditing();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentAuditing(RetailScmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountingDocumentAuditingManagerException exception = new AccountingDocumentAuditingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, exception);
		checkVersionOfAccountingDocumentAuditing(userContext, accountingDocumentAuditingVersion, exception);
		

		if(AccountingDocumentAuditing.WHO_PROPERTY.equals(property)){
			checkWhoOfAccountingDocumentAuditing(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingDocumentAuditing.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfAccountingDocumentAuditing(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingDocumentAuditing.MAKE_DATE_PROPERTY.equals(property)){
			checkMakeDateOfAccountingDocumentAuditing(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public AccountingDocumentAuditing clone(RetailScmUserContext userContext, String fromAccountingDocumentAuditingId) throws Exception{
		
		return this.getAccountingDocumentAuditingDAO().clone(fromAccountingDocumentAuditingId, this.allTokens());
	}
	
	public AccountingDocumentAuditing updateAccountingDocumentAuditing(RetailScmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		if(accountingDocumentAuditing.getVersion() != accountingDocumentAuditingVersion){
			String message = "The target version("+accountingDocumentAuditing.getVersion()+") is not equals to version("+accountingDocumentAuditingVersion+") provided";
			throw new AccountingDocumentAuditingManagerException(message);
		}
		synchronized(accountingDocumentAuditing){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentAuditing.
			
			accountingDocumentAuditing.changePropery(property, newValueExpr);
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentAuditingTokens tokens(){
		return AccountingDocumentAuditingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentAuditingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentAuditingTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception {
		
		deleteInternal(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception{
		getAccountingDocumentAuditingDAO().delete(accountingDocumentAuditingId, accountingDocumentAuditingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentAuditingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountingDocumentAuditingDAO().deleteAll();
	}

	protected void checkParamsForAddingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId,String [] tokensExpr) throws Exception{
		
		

		AccountingDocumentAuditingManagerException exception = new AccountingDocumentAuditingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, exception);

		checkNameOfAccountingDocument(userContext,  name, exception);
		checkAccountingDocumentDateOfAccountingDocument(userContext,  accountingDocumentDate, exception);		
		
		checkIdOfAccountingPeriod(userContext,  accountingPeriodId, exception);		
		
		checkIdOfAccountingDocumentType(userContext,  documentTypeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountingDocumentAuditing addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentAuditingId,name, accountingDocumentDate, accountingPeriodId, documentTypeId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId);
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		synchronized(accountingDocumentAuditing){ 
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentAuditing.addAccountingDocument( accountingDocument );		
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentAuditingManagerException exception = new AccountingDocumentAuditingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentAuditing removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentAuditingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		synchronized(accountingDocumentAuditing){ 
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentAuditing.removeAccountingDocument( accountingDocument );		
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentAuditingManagerException exception = new AccountingDocumentAuditingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentAuditing copyAccountingDocumentFrom(RetailScmUserContext userContext, String accountingDocumentAuditingId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentAuditingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		synchronized(accountingDocumentAuditing){ 
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentAuditing.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountingDocumentAuditingManagerException exception = new AccountingDocumentAuditingManagerException("Error Occured");
		
		checkIdOfAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, exception);
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
	
	public  AccountingDocumentAuditing updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentAuditingId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		
		synchronized(accountingDocumentAuditing){ 
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentAuditing.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentAuditing.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentAuditingManagerException(accountingDocument+"Not found" );
			}
			
			accountingDocument.changePropery(property, newValueExpr);

			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


