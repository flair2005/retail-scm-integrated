
package com.skynet.retailscm.accountingdocument;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.skynet.retailscm.originalvoucher.OriginalVoucher;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPosting;

import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreationDAO;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPostingDAO;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditingDAO;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentTypeDAO;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmationDAO;
import com.skynet.retailscm.accountingperiod.AccountingPeriodDAO;

import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingdocument.AccountingDocument;


import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentTypeTable;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLineTable;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmationTable;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditingTable;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPostingTable;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreationTable;
import com.skynet.retailscm.originalvoucher.OriginalVoucherTable;
import com.skynet.retailscm.accountingperiod.AccountingPeriodTable;




public class AccountingDocumentManagerImpl extends RetailScmCheckerManager implements AccountingDocumentManager {
	
	private static final String SERVICE_TYPE = "AccountingDocument";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountingDocumentDAO  accountingDocumentDAO;
 	public void setAccountingDocumentDAO(AccountingDocumentDAO  accountingDocumentDAO){
 	
 		if(accountingDocumentDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentDAO to null.");
 		}
	 	this.accountingDocumentDAO = accountingDocumentDAO;
 	}
 	public AccountingDocumentDAO getAccountingDocumentDAO(){
 		if(this.accountingDocumentDAO == null){
 			throw new IllegalStateException("The AccountingDocumentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentDAO;
 	}
 	
 	protected AccountingDocument saveAccountingDocument(RetailScmUserContext userContext, AccountingDocument accountingDocument, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentDAO().save(accountingDocument, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocument(userContext, accountingDocument, tokens);
 	}
 	
 	protected AccountingDocument saveAccountingDocumentDetail(RetailScmUserContext userContext, AccountingDocument accountingDocument) throws Exception{	

 		
 		return saveAccountingDocument(userContext, accountingDocument, allTokens());
 	}
 	
 	public AccountingDocument loadAccountingDocument(RetailScmUserContext userContext, String accountingDocumentId, String [] tokensExpr) throws Exception{				
 
 		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocument, tokens);
 	}
 	
 	protected AccountingDocument present(RetailScmUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocument,tokens);
		
		
		return this.getAccountingDocumentDAO().present(accountingDocument, tokens);
	}
 
 	
 	
 	public AccountingDocument loadAccountingDocumentDetail(RetailScmUserContext userContext, String accountingDocumentId) throws Exception{	
 		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, allTokens());

 		return present(userContext,accountingDocument, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountingDocumentId) throws Exception{	
 		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, allTokens());

 		return present(userContext,accountingDocument, allTokens());
		
 	}
 	protected AccountingDocument saveAccountingDocument(RetailScmUserContext userContext, AccountingDocument accountingDocument, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentDAO().save(accountingDocument, tokens);
 	}
 	protected AccountingDocument loadAccountingDocument(RetailScmUserContext userContext, String accountingDocumentId, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentDAO().load(accountingDocumentId, tokens);
 	}

	



 	 
 	
 	private  AccountingDocumentTypeDAO  accountingDocumentTypeDAO;
 	public void setAccountingDocumentTypeDAO(AccountingDocumentTypeDAO accountingDocumentTypeDAO){
	 	this.accountingDocumentTypeDAO = accountingDocumentTypeDAO;
 	}
 	//------------------------------------
 	public AccountingDocumentTypeDAO getAccountingDocumentTypeDAO(){
	 	return this.accountingDocumentTypeDAO;
 	}
 
 	
 	private  AccountingDocumentPostingDAO  accountingDocumentPostingDAO;
 	public void setAccountingDocumentPostingDAO(AccountingDocumentPostingDAO accountingDocumentPostingDAO){
	 	this.accountingDocumentPostingDAO = accountingDocumentPostingDAO;
 	}
 	//------------------------------------
 	public AccountingDocumentPostingDAO getAccountingDocumentPostingDAO(){
	 	return this.accountingDocumentPostingDAO;
 	}
 
 	
 	private  AccountingDocumentCreationDAO  accountingDocumentCreationDAO;
 	public void setAccountingDocumentCreationDAO(AccountingDocumentCreationDAO accountingDocumentCreationDAO){
	 	this.accountingDocumentCreationDAO = accountingDocumentCreationDAO;
 	}
 	//------------------------------------
 	public AccountingDocumentCreationDAO getAccountingDocumentCreationDAO(){
	 	return this.accountingDocumentCreationDAO;
 	}
 
 	
 	private  AccountingPeriodDAO  accountingPeriodDAO;
 	public void setAccountingPeriodDAO(AccountingPeriodDAO accountingPeriodDAO){
	 	this.accountingPeriodDAO = accountingPeriodDAO;
 	}
 	//------------------------------------
 	public AccountingPeriodDAO getAccountingPeriodDAO(){
	 	return this.accountingPeriodDAO;
 	}
 
 	
 	private  AccountingDocumentAuditingDAO  accountingDocumentAuditingDAO;
 	public void setAccountingDocumentAuditingDAO(AccountingDocumentAuditingDAO accountingDocumentAuditingDAO){
	 	this.accountingDocumentAuditingDAO = accountingDocumentAuditingDAO;
 	}
 	//------------------------------------
 	public AccountingDocumentAuditingDAO getAccountingDocumentAuditingDAO(){
	 	return this.accountingDocumentAuditingDAO;
 	}
 
 	
 	private  AccountingDocumentConfirmationDAO  accountingDocumentConfirmationDAO;
 	public void setAccountingDocumentConfirmationDAO(AccountingDocumentConfirmationDAO accountingDocumentConfirmationDAO){
	 	this.accountingDocumentConfirmationDAO = accountingDocumentConfirmationDAO;
 	}
 	//------------------------------------
 	public AccountingDocumentConfirmationDAO getAccountingDocumentConfirmationDAO(){
	 	return this.accountingDocumentConfirmationDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocument, tokens);
		
		addAction(userContext, accountingDocument, tokens,"@create","createAccountingDocument","createAccountingDocument/","main","primary");
		addAction(userContext, accountingDocument, tokens,"@update","updateAccountingDocument","updateAccountingDocument/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"@copy","cloneAccountingDocument","cloneAccountingDocument/"+accountingDocument.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_accounting_period","transferToAnotherAccountingPeriod","transferToAnotherAccountingPeriod/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_document_type","transferToAnotherDocumentType","transferToAnotherDocumentType/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.create","create","create/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.confirm","confirm","confirm/"+accountingDocument.getId()+"/","main","success");
		addAction(userContext, accountingDocument, tokens,"accounting_document.audit","audit","audit/"+accountingDocument.getId()+"/","main","success");
		addAction(userContext, accountingDocument, tokens,"accounting_document.post","post","post/"+accountingDocument.getId()+"/","main","danger");
		addAction(userContext, accountingDocument, tokens,"accounting_document.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.addAccountingDocumentLine","addAccountingDocumentLine","addAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.removeAccountingDocumentLine","removeAccountingDocumentLine","removeAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.updateAccountingDocumentLine","updateAccountingDocumentLine","updateAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocument createAccountingDocument(RetailScmUserContext userContext,String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId
) throws Exception
	{
		
		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");

		

		checkNameOfAccountingDocument(userContext,  name, exception);
		checkAccountingDocumentDateOfAccountingDocument(userContext,  accountingDocumentDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountingDocument accountingDocument=createNewAccountingDocument();	

		accountingDocument.setName(name);
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);
		AccountingPeriod accountingPeriod = loadAccountingPeriod(accountingPeriodId,emptyOptions());
		accountingDocument.setAccountingPeriod(accountingPeriod);
		AccountingDocumentType documentType = loadAccountingDocumentType(documentTypeId,emptyOptions());
		accountingDocument.setDocumentType(documentType);

		return saveAccountingDocument(userContext, accountingDocument, emptyOptions());
		

		
	}
	protected AccountingDocument createNewAccountingDocument() 
	{
		
		return new AccountingDocument();		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailScmUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
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
	
	
	
	public AccountingDocument clone(RetailScmUserContext userContext, String fromAccountingDocumentId) throws Exception{
		
		return this.getAccountingDocumentDAO().clone(fromAccountingDocumentId, this.allTokens());
	}
	
	public AccountingDocument updateAccountingDocument(RetailScmUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentId, accountingDocumentVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		if(accountingDocument.getVersion() != accountingDocumentVersion){
			String message = "The target version("+accountingDocument.getVersion()+") is not equals to version("+accountingDocumentVersion+") provided";
			throw new AccountingDocumentManagerException(message);
		}
		synchronized(accountingDocument){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocument.
			
			accountingDocument.changePropery(property, newValueExpr);
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			//return saveAccountingDocument(userContext, accountingDocument, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentTokens tokens(){
		return AccountingDocumentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={"CREATED","CONFIRMED","AUDITED","POSTED"};
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
	
	protected void checkParamsForTransferingAnotherAccountingPeriod(RetailScmUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId) throws Exception
 	{
 		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
 		checkIdOfAccountingDocument(userContext, accountingDocumentId,exception);
 		checkIdOfAccountingPeriod(userContext, anotherAccountingPeriodId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountingDocument transferToAnotherAccountingPeriod(RetailScmUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountingPeriod(userContext, accountingDocumentId,anotherAccountingPeriodId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingPeriod accountingPeriod = loadAccountingPeriod(anotherAccountingPeriodId, emptyOptions());		
			accountingDocument.setAccountingPeriod(accountingPeriod);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherDocumentType(RetailScmUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId) throws Exception
 	{
 		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
 		checkIdOfAccountingDocument(userContext, accountingDocumentId,exception);
 		checkIdOfAccountingDocumentType(userContext, anotherDocumentTypeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountingDocument transferToAnotherDocumentType(RetailScmUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherDocumentType(userContext, accountingDocumentId,anotherDocumentTypeId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentType documentType = loadAccountingDocumentType(anotherDocumentTypeId, emptyOptions());		
			accountingDocument.setDocumentType(documentType);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForCreation(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
 		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkWhoOfAccountingDocumentCreation(userContext,who,exception);
		checkCommentsOfAccountingDocumentCreation(userContext,comments,exception);
		checkMakeDateOfAccountingDocumentCreation(userContext,makeDate,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public AccountingDocument create(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForCreation(userContext, accountingDocumentId, who, comments, makeDate);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForAccountingDocumentCreation(userContext,accountingDocument);
 		

			accountingDocument.setCurrentStatus("CREATED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			AccountingDocumentCreation creation = createAccountingDocumentCreation(who, comments, makeDate);		
			accountingDocument.setCreation(creation);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withCreation().done());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	protected AccountingDocumentCreation createAccountingDocumentCreation(String who, String comments, Date makeDate){
 		AccountingDocumentCreation creation = new AccountingDocumentCreation(who, comments, makeDate);
 		return getAccountingDocumentCreationDAO().save(creation,emptyOptions());
 	}
 	protected void checkIfEligibleForAccountingDocumentCreation(RetailScmUserContext userContext, AccountingDocument accountingDocument) throws Exception{
 		
 		
 		String currentStatus = accountingDocument.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'CREATED'";
 			throw new AccountingDocumentManagerException(message);
 		}
 		
 		if(!("CREATED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'CREATED'";
 			throw new AccountingDocumentManagerException(message);
 		}
 		
 		
 		AccountingDocumentCreation creation = accountingDocument.getCreation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = creation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( creation != null){
				throw new AccountingDocumentManagerException("The AccountingDocument("+accountingDocument.getId()+") has already been CREATED");
		}
 		
 		
 	}
	
 	protected void checkParamsForConfirmation(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
 		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkWhoOfAccountingDocumentConfirmation(userContext,who,exception);
		checkCommentsOfAccountingDocumentConfirmation(userContext,comments,exception);
		checkMakeDateOfAccountingDocumentConfirmation(userContext,makeDate,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public AccountingDocument confirm(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForConfirmation(userContext, accountingDocumentId, who, comments, makeDate);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForAccountingDocumentConfirmation(userContext,accountingDocument);
 		

			accountingDocument.setCurrentStatus("CONFIRMED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			AccountingDocumentConfirmation confirmation = createAccountingDocumentConfirmation(who, comments, makeDate);		
			accountingDocument.setConfirmation(confirmation);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withConfirmation().done());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	protected AccountingDocumentConfirmation createAccountingDocumentConfirmation(String who, String comments, Date makeDate){
 		AccountingDocumentConfirmation confirmation = new AccountingDocumentConfirmation(who, comments, makeDate);
 		return getAccountingDocumentConfirmationDAO().save(confirmation,emptyOptions());
 	}
 	protected void checkIfEligibleForAccountingDocumentConfirmation(RetailScmUserContext userContext, AccountingDocument accountingDocument) throws Exception{
 		
 		
 		String currentStatus = accountingDocument.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new AccountingDocumentManagerException(message);
 		}
 		
 		if(!("CONFIRMED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new AccountingDocumentManagerException(message);
 		}
 		
 		
 		AccountingDocumentConfirmation confirmation = accountingDocument.getConfirmation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = confirmation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( confirmation != null){
				throw new AccountingDocumentManagerException("The AccountingDocument("+accountingDocument.getId()+") has already been CONFIRMED");
		}
 		
 		
 	}
	
 	protected void checkParamsForAuditing(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
 		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkWhoOfAccountingDocumentAuditing(userContext,who,exception);
		checkCommentsOfAccountingDocumentAuditing(userContext,comments,exception);
		checkMakeDateOfAccountingDocumentAuditing(userContext,makeDate,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public AccountingDocument audit(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForAuditing(userContext, accountingDocumentId, who, comments, makeDate);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForAccountingDocumentAuditing(userContext,accountingDocument);
 		

			accountingDocument.setCurrentStatus("AUDITED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			AccountingDocumentAuditing auditing = createAccountingDocumentAuditing(who, comments, makeDate);		
			accountingDocument.setAuditing(auditing);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAuditing().done());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	protected AccountingDocumentAuditing createAccountingDocumentAuditing(String who, String comments, Date makeDate){
 		AccountingDocumentAuditing auditing = new AccountingDocumentAuditing(who, comments, makeDate);
 		return getAccountingDocumentAuditingDAO().save(auditing,emptyOptions());
 	}
 	protected void checkIfEligibleForAccountingDocumentAuditing(RetailScmUserContext userContext, AccountingDocument accountingDocument) throws Exception{
 		
 		
 		String currentStatus = accountingDocument.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'AUDITED'";
 			throw new AccountingDocumentManagerException(message);
 		}
 		
 		if(!("AUDITED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'AUDITED'";
 			throw new AccountingDocumentManagerException(message);
 		}
 		
 		
 		AccountingDocumentAuditing auditing = accountingDocument.getAuditing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = auditing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( auditing != null){
				throw new AccountingDocumentManagerException("The AccountingDocument("+accountingDocument.getId()+") has already been AUDITED");
		}
 		
 		
 	}
	
 	protected void checkParamsForPosting(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
 		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkWhoOfAccountingDocumentPosting(userContext,who,exception);
		checkCommentsOfAccountingDocumentPosting(userContext,comments,exception);
		checkMakeDateOfAccountingDocumentPosting(userContext,makeDate,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public AccountingDocument post(RetailScmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForPosting(userContext, accountingDocumentId, who, comments, makeDate);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForAccountingDocumentPosting(userContext,accountingDocument);
 		

			accountingDocument.setCurrentStatus("POSTED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			AccountingDocumentPosting posting = createAccountingDocumentPosting(who, comments, makeDate);		
			accountingDocument.setPosting(posting);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withPosting().done());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}
 	protected AccountingDocumentPosting createAccountingDocumentPosting(String who, String comments, Date makeDate){
 		AccountingDocumentPosting posting = new AccountingDocumentPosting(who, comments, makeDate);
 		return getAccountingDocumentPostingDAO().save(posting,emptyOptions());
 	}
 	protected void checkIfEligibleForAccountingDocumentPosting(RetailScmUserContext userContext, AccountingDocument accountingDocument) throws Exception{
 		
 		
 		String currentStatus = accountingDocument.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'POSTED'";
 			throw new AccountingDocumentManagerException(message);
 		}
 		
 		if(!("POSTED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'POSTED'";
 			throw new AccountingDocumentManagerException(message);
 		}
 		
 		
 		AccountingDocumentPosting posting = accountingDocument.getPosting();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = posting 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( posting != null){
				throw new AccountingDocumentManagerException("The AccountingDocument("+accountingDocument.getId()+") has already been POSTED");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected AccountingDocumentType loadAccountingDocumentType(String newDocumentTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountingDocumentTypeDAO().load(newDocumentTypeId, options);
 	}
	
	 	
 	protected AccountingDocumentPosting loadAccountingDocumentPosting(String newPostingId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountingDocumentPostingDAO().load(newPostingId, options);
 	}
	
	 	
 	protected AccountingDocumentCreation loadAccountingDocumentCreation(String newCreationId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountingDocumentCreationDAO().load(newCreationId, options);
 	}
	
	 	
 	protected AccountingPeriod loadAccountingPeriod(String newAccountingPeriodId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountingPeriodDAO().load(newAccountingPeriodId, options);
 	}
	
	 	
 	protected AccountingDocumentAuditing loadAccountingDocumentAuditing(String newAuditingId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountingDocumentAuditingDAO().load(newAuditingId, options);
 	}
	
	 	
 	protected AccountingDocumentConfirmation loadAccountingDocumentConfirmation(String newConfirmationId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountingDocumentConfirmationDAO().load(newConfirmationId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String accountingDocumentId, int accountingDocumentVersion) throws Exception {
		
		deleteInternal(userContext, accountingDocumentId, accountingDocumentVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountingDocumentId, int accountingDocumentVersion) throws Exception{
		getAccountingDocumentDAO().delete(accountingDocumentId, accountingDocumentVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountingDocumentDAO().deleteAll();
	}

	protected void checkParamsForAddingOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage,String [] tokensExpr) throws Exception{
		
		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);

		checkTitleOfOriginalVoucher(userContext,  title, exception);
		checkMadeByOfOriginalVoucher(userContext,  madeBy, exception);
		checkReceivedByOfOriginalVoucher(userContext,  receivedBy, exception);
		checkVoucherTypeOfOriginalVoucher(userContext,  voucherType, exception);
		checkVoucherImageOfOriginalVoucher(userContext,  voucherImage, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountingDocument addOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOriginalVoucher(userContext,accountingDocumentId,title, madeBy, receivedBy, voucherType, voucherImage,tokensExpr);
		
		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage);
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.addOriginalVoucher( originalVoucher );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}
	protected OriginalVoucher createOriginalVoucher(RetailScmUserContext userContext, String title, String madeBy, String receivedBy, String voucherType, String voucherImage) throws Exception{

		OriginalVoucher originalVoucher = new OriginalVoucher();
		
		
		originalVoucher.setTitle(title);		
		originalVoucher.setMadeBy(madeBy);		
		originalVoucher.setReceivedBy(receivedBy);		
		originalVoucher.setVoucherType(voucherType);		
		originalVoucher.setVoucherImage(voucherImage);
	
		
		return originalVoucher;
	
		
	}
	
	protected OriginalVoucher createIndexedOriginalVoucher(String id, int version){

		OriginalVoucher originalVoucher = new OriginalVoucher();
		originalVoucher.setId(id);
		originalVoucher.setVersion(version);
		return originalVoucher;			
		
	}
	protected void checkParamsForRemovingOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocument removeOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOriginalVoucher(userContext,accountingDocumentId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.removeOriginalVoucher( originalVoucher );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocument copyOriginalVoucherFrom(RetailScmUserContext userContext, String accountingDocumentId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOriginalVoucher(userContext,accountingDocumentId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.copyOriginalVoucherFrom( originalVoucher );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);
		

		if(OriginalVoucher.TITLE_PROPERTY.equals(property)){
			checkTitleOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
		if(OriginalVoucher.MADE_BY_PROPERTY.equals(property)){
			checkMadeByOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
		if(OriginalVoucher.RECEIVED_BY_PROPERTY.equals(property)){
			checkReceivedByOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
		if(OriginalVoucher.VOUCHER_TYPE_PROPERTY.equals(property)){
			checkVoucherTypeOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
		if(OriginalVoucher.VOUCHER_IMAGE_PROPERTY.equals(property)){
			checkVoucherImageOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  AccountingDocument updateOriginalVoucher(RetailScmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOriginalVoucher(userContext, accountingDocumentId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocument.removeOriginalVoucher( originalVoucher );	
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		
			OriginalVoucher originalVoucher = accountingDocument.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new AccountingDocumentManagerException(originalVoucher+"Not found" );
			}
			
			originalVoucher.changePropery(property, newValueExpr);

			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, String name, String code, String direct, double amount, String accountingSubjectId,String [] tokensExpr) throws Exception{
		
		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);

		checkNameOfAccountingDocumentLine(userContext,  name, exception);
		checkCodeOfAccountingDocumentLine(userContext,  code, exception);
		checkDirectOfAccountingDocumentLine(userContext,  direct, exception);
		checkAmountOfAccountingDocumentLine(userContext,  amount, exception);		
		
		checkIdOfAccountingSubject(userContext,  accountingSubjectId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountingDocument addAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, String name, String code, String direct, double amount, String accountingSubjectId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocumentLine(userContext,accountingDocumentId,name, code, direct, amount, accountingSubjectId,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createAccountingDocumentLine(userContext,name, code, direct, amount, accountingSubjectId);
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.addAccountingDocumentLine( accountingDocumentLine );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountingDocumentLine createAccountingDocumentLine(RetailScmUserContext userContext, String name, String code, String direct, double amount, String accountingSubjectId) throws Exception{

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		
		
		accountingDocumentLine.setName(name);		
		accountingDocumentLine.setCode(code);		
		accountingDocumentLine.setDirect(direct);		
		accountingDocumentLine.setAmount(amount);		
		AccountingSubject  accountingSubject = new AccountingSubject();
		accountingSubject.setId(accountingSubjectId);		
		accountingDocumentLine.setAccountingSubject(accountingSubject);
	
		
		return accountingDocumentLine;
	
		
	}
	
	protected AccountingDocumentLine createIndexedAccountingDocumentLine(String id, int version){

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		accountingDocumentLine.setId(id);
		accountingDocumentLine.setVersion(version);
		return accountingDocumentLine;			
		
	}
	protected void checkParamsForRemovingAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId, exception);
		checkVersionOfAccountingDocumentLine(userContext, accountingDocumentLineVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocument removeAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocumentLine(userContext,accountingDocumentId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.removeAccountingDocumentLine( accountingDocumentLine );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId, exception);
		checkVersionOfAccountingDocumentLine(userContext, accountingDocumentLineVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocument copyAccountingDocumentLineFrom(RetailScmUserContext userContext, String accountingDocumentId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocumentLine(userContext,accountingDocumentId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.copyAccountingDocumentLineFrom( accountingDocumentLine );		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountingDocumentManagerException exception = new AccountingDocumentManagerException("Error Occured");
		
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId, exception);
		checkVersionOfAccountingDocumentLine(userContext, accountingDocumentLineVersion, exception);
		

		if(AccountingDocumentLine.NAME_PROPERTY.equals(property)){
			checkNameOfAccountingDocumentLine(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountingDocumentLine.CODE_PROPERTY.equals(property)){
			checkCodeOfAccountingDocumentLine(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountingDocumentLine.DIRECT_PROPERTY.equals(property)){
			checkDirectOfAccountingDocumentLine(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountingDocumentLine.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfAccountingDocumentLine(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  AccountingDocument updateAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocumentLine(userContext, accountingDocumentId, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		
		synchronized(accountingDocument){ 
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocument.removeAccountingDocumentLine( accountingDocumentLine );	
			//make changes to AcceleraterAccount.
			AccountingDocumentLine accountingDocumentLineIndex = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		
			AccountingDocumentLine accountingDocumentLine = accountingDocument.findTheAccountingDocumentLine(accountingDocumentLineIndex);
			if(accountingDocumentLine == null){
				throw new AccountingDocumentManagerException(accountingDocumentLine+"Not found" );
			}
			
			accountingDocumentLine.changePropery(property, newValueExpr);

			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


