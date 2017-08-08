
package com.skynet.retailscm.accountingdocumenttype;

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




public class AccountingDocumentTypeManagerImpl extends RetailScmCheckerManager implements AccountingDocumentTypeManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountingDocumentTypeDAO  accountingDocumentTypeDAO;
 	public void setAccountingDocumentTypeDAO(AccountingDocumentTypeDAO  accountingDocumentTypeDAO){
 	
 		if(accountingDocumentTypeDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentTypeDAO to null.");
 		}
	 	this.accountingDocumentTypeDAO = accountingDocumentTypeDAO;
 	}
 	public AccountingDocumentTypeDAO getAccountingDocumentTypeDAO(){
 		if(this.accountingDocumentTypeDAO == null){
 			throw new IllegalStateException("The AccountingDocumentTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentTypeDAO;
 	}
 	
 	protected AccountingDocumentType saveAccountingDocumentType(RetailScmUserContext userContext, AccountingDocumentType accountingDocumentType, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentTypeDAO().save(accountingDocumentType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentType(userContext, accountingDocumentType, tokens);
 	}
 	
 	protected AccountingDocumentType saveAccountingDocumentTypeDetail(RetailScmUserContext userContext, AccountingDocumentType accountingDocumentType) throws Exception{	

 		
 		return saveAccountingDocumentType(userContext, accountingDocumentType, allTokens());
 	}
 	
 	public AccountingDocumentType loadAccountingDocumentType(RetailScmUserContext userContext, String accountingDocumentTypeId, String [] tokensExpr) throws Exception{				
 
 		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");
		
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType( userContext, accountingDocumentTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentType, tokens);
 	}
 	
 	protected AccountingDocumentType present(RetailScmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentType,tokens);
		
		
		return this.getAccountingDocumentTypeDAO().present(accountingDocumentType, tokens);
	}
 
 	
 	
 	public AccountingDocumentType loadAccountingDocumentTypeDetail(RetailScmUserContext userContext, String accountingDocumentTypeId) throws Exception{	
 		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");
		
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType( userContext, accountingDocumentTypeId, allTokens());

 		return present(userContext,accountingDocumentType, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountingDocumentTypeId) throws Exception{	
 		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");
		
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType( userContext, accountingDocumentTypeId, allTokens());

 		return present(userContext,accountingDocumentType, allTokens());
		
 	}
 	protected AccountingDocumentType saveAccountingDocumentType(RetailScmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentTypeDAO().save(accountingDocumentType, tokens);
 	}
 	protected AccountingDocumentType loadAccountingDocumentType(RetailScmUserContext userContext, String accountingDocumentTypeId, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentTypeDAO().load(accountingDocumentTypeId, tokens);
 	}

	



 	 
 	
 	private  AccountSetDAO  accountSetDAO;
 	public void setAccountSetDAO(AccountSetDAO accountSetDAO){
	 	this.accountSetDAO = accountSetDAO;
 	}
 	//------------------------------------
 	public AccountSetDAO getAccountSetDAO(){
	 	return this.accountSetDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentType, tokens);
		
		addAction(userContext, accountingDocumentType, tokens,"@create","createAccountingDocumentType","createAccountingDocumentType/","main","primary");
		addAction(userContext, accountingDocumentType, tokens,"@update","updateAccountingDocumentType","updateAccountingDocumentType/"+accountingDocumentType.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentType, tokens,"@copy","cloneAccountingDocumentType","cloneAccountingDocumentType/"+accountingDocumentType.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.transfer_to_accounting_period","transferToAnotherAccountingPeriod","transferToAnotherAccountingPeriod/"+accountingDocumentType.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentType.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentType.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentType.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentType, tokens,"accounting_document_type.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentType.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentType accountingDocumentType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentType createAccountingDocumentType(RetailScmUserContext userContext,String name, String description, String accountingPeriodId
) throws Exception
	{
		
		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");

		

		checkNameOfAccountingDocumentType(userContext,  name, exception);
		checkDescriptionOfAccountingDocumentType(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountingDocumentType accountingDocumentType=createNewAccountingDocumentType();	

		accountingDocumentType.setName(name);
		accountingDocumentType.setDescription(description);
		AccountSet accountingPeriod = loadAccountSet(accountingPeriodId,emptyOptions());
		accountingDocumentType.setAccountingPeriod(accountingPeriod);

		return saveAccountingDocumentType(userContext, accountingDocumentType, emptyOptions());
		

		
	}
	protected AccountingDocumentType createNewAccountingDocumentType() 
	{
		
		return new AccountingDocumentType();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentType(RetailScmUserContext userContext,String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");
		
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);
		checkVersionOfAccountingDocumentType(userContext, accountingDocumentTypeVersion, exception);
		

		if(AccountingDocumentType.NAME_PROPERTY.equals(property)){
			checkNameOfAccountingDocumentType(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingDocumentType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfAccountingDocumentType(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public AccountingDocumentType clone(RetailScmUserContext userContext, String fromAccountingDocumentTypeId) throws Exception{
		
		return this.getAccountingDocumentTypeDAO().clone(fromAccountingDocumentTypeId, this.allTokens());
	}
	
	public AccountingDocumentType updateAccountingDocumentType(RetailScmUserContext userContext,String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentType(userContext, accountingDocumentTypeId, accountingDocumentTypeVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		if(accountingDocumentType.getVersion() != accountingDocumentTypeVersion){
			String message = "The target version("+accountingDocumentType.getVersion()+") is not equals to version("+accountingDocumentTypeVersion+") provided";
			throw new AccountingDocumentTypeManagerException(message);
		}
		synchronized(accountingDocumentType){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentType.
			
			accountingDocumentType.changePropery(property, newValueExpr);
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentTypeTokens tokens(){
		return AccountingDocumentTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentTypeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentTypeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherAccountingPeriod(RetailScmUserContext userContext, String accountingDocumentTypeId, String anotherAccountingPeriodId) throws Exception
 	{
 		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");
 		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId,exception);
 		checkIdOfAccountSet(userContext, anotherAccountingPeriodId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountingDocumentType transferToAnotherAccountingPeriod(RetailScmUserContext userContext, String accountingDocumentTypeId, String anotherAccountingPeriodId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountingPeriod(userContext, accountingDocumentTypeId,anotherAccountingPeriodId);
 
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());	
		synchronized(accountingDocumentType){
			//will be good when the accountingDocumentType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountSet accountingPeriod = loadAccountSet(anotherAccountingPeriodId, emptyOptions());		
			accountingDocumentType.setAccountingPeriod(accountingPeriod);		
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, emptyOptions());
			
			return present(userContext,accountingDocumentType, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected AccountSet loadAccountSet(String newAccountingPeriodId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountSetDAO().load(newAccountingPeriodId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception {
		
		deleteInternal(userContext, accountingDocumentTypeId, accountingDocumentTypeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountingDocumentTypeId, int accountingDocumentTypeVersion) throws Exception{
		getAccountingDocumentTypeDAO().delete(accountingDocumentTypeId, accountingDocumentTypeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountingDocumentTypeDAO().deleteAll();
	}

	protected void checkParamsForAddingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId,String [] tokensExpr) throws Exception{
		
		

		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");
		
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);

		checkNameOfAccountingDocument(userContext,  name, exception);
		checkAccountingDocumentDateOfAccountingDocument(userContext,  accountingDocumentDate, exception);		
		
		checkIdOfAccountingPeriod(userContext,  accountingPeriodId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountingDocumentType addAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocument(userContext,accountingDocumentTypeId,name, accountingDocumentDate, accountingPeriodId,tokensExpr);
		
		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId);
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		synchronized(accountingDocumentType){ 
			//Will be good when the accountingDocumentType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentType.addAccountingDocument( accountingDocument );		
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountingDocument createAccountingDocument(RetailScmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId) throws Exception{

		AccountingDocument accountingDocument = new AccountingDocument();
		
		
		accountingDocument.setName(name);		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);		
		AccountingPeriod  accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(accountingPeriodId);		
		accountingDocument.setAccountingPeriod(accountingPeriod);
	
		
		return accountingDocument;
	
		
	}
	
	protected AccountingDocument createIndexedAccountingDocument(String id, int version){

		AccountingDocument accountingDocument = new AccountingDocument();
		accountingDocument.setId(id);
		accountingDocument.setVersion(version);
		return accountingDocument;			
		
	}
	protected void checkParamsForRemovingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");
		
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentType removeAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentTypeId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		synchronized(accountingDocumentType){ 
			//Will be good when the accountingDocumentType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentType.removeAccountingDocument( accountingDocument );		
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		

		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");
		
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);
		checkIdOfAccountingDocument(userContext, accountingDocumentId, exception);
		checkVersionOfAccountingDocument(userContext, accountingDocumentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingDocumentType copyAccountingDocumentFrom(RetailScmUserContext userContext, String accountingDocumentTypeId, 
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentTypeId, accountingDocumentId, accountingDocumentVersion,tokensExpr);
		
		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		synchronized(accountingDocumentType){ 
			//Will be good when the accountingDocumentType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentType.copyAccountingDocumentFrom( accountingDocument );		
			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountingDocumentTypeManagerException exception = new AccountingDocumentTypeManagerException("Error Occured");
		
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);
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
	
	public  AccountingDocumentType updateAccountingDocument(RetailScmUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentTypeId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountingDocumentType accountingDocumentType = loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
		
		synchronized(accountingDocumentType){ 
			//Will be good when the accountingDocumentType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentType.removeAccountingDocument( accountingDocument );	
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		
			AccountingDocument accountingDocument = accountingDocumentType.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentTypeManagerException(accountingDocument+"Not found" );
			}
			
			accountingDocument.changePropery(property, newValueExpr);

			accountingDocumentType = saveAccountingDocumentType(userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentType, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


