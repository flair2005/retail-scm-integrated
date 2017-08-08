
package com.skynet.retailscm.accountingsubject;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;

import com.skynet.retailscm.accountset.AccountSetDAO;

import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingdocument.AccountingDocument;


import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLineTable;
import com.skynet.retailscm.accountset.AccountSetTable;




public class AccountingSubjectManagerImpl extends RetailScmCheckerManager implements AccountingSubjectManager {
	
	private static final String SERVICE_TYPE = "AccountingSubject";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountingSubjectDAO  accountingSubjectDAO;
 	public void setAccountingSubjectDAO(AccountingSubjectDAO  accountingSubjectDAO){
 	
 		if(accountingSubjectDAO == null){
 			throw new IllegalStateException("Do not try to set accountingSubjectDAO to null.");
 		}
	 	this.accountingSubjectDAO = accountingSubjectDAO;
 	}
 	public AccountingSubjectDAO getAccountingSubjectDAO(){
 		if(this.accountingSubjectDAO == null){
 			throw new IllegalStateException("The AccountingSubjectDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingSubjectDAO;
 	}
 	
 	protected AccountingSubject saveAccountingSubject(RetailScmUserContext userContext, AccountingSubject accountingSubject, String [] tokensExpr) throws Exception{	
 		//return getAccountingSubjectDAO().save(accountingSubject, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingSubject(userContext, accountingSubject, tokens);
 	}
 	
 	protected AccountingSubject saveAccountingSubjectDetail(RetailScmUserContext userContext, AccountingSubject accountingSubject) throws Exception{	

 		
 		return saveAccountingSubject(userContext, accountingSubject, allTokens());
 	}
 	
 	public AccountingSubject loadAccountingSubject(RetailScmUserContext userContext, String accountingSubjectId, String [] tokensExpr) throws Exception{				
 
 		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");
		
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingSubject accountingSubject = loadAccountingSubject( userContext, accountingSubjectId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingSubject, tokens);
 	}
 	
 	protected AccountingSubject present(RetailScmUserContext userContext, AccountingSubject accountingSubject, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingSubject,tokens);
		
		
		return this.getAccountingSubjectDAO().present(accountingSubject, tokens);
	}
 
 	
 	
 	public AccountingSubject loadAccountingSubjectDetail(RetailScmUserContext userContext, String accountingSubjectId) throws Exception{	
 		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");
		
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingSubject accountingSubject = loadAccountingSubject( userContext, accountingSubjectId, allTokens());

 		return present(userContext,accountingSubject, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountingSubjectId) throws Exception{	
 		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");
		
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingSubject accountingSubject = loadAccountingSubject( userContext, accountingSubjectId, allTokens());

 		return present(userContext,accountingSubject, allTokens());
		
 	}
 	protected AccountingSubject saveAccountingSubject(RetailScmUserContext userContext, AccountingSubject accountingSubject, Map<String,Object>tokens) throws Exception{	
 		return getAccountingSubjectDAO().save(accountingSubject, tokens);
 	}
 	protected AccountingSubject loadAccountingSubject(RetailScmUserContext userContext, String accountingSubjectId, Map<String,Object>tokens) throws Exception{	
 		return getAccountingSubjectDAO().load(accountingSubjectId, tokens);
 	}

	



 	 
 	
 	private  AccountSetDAO  accountSetDAO;
 	public void setAccountSetDAO(AccountSetDAO accountSetDAO){
	 	this.accountSetDAO = accountSetDAO;
 	}
 	//------------------------------------
 	public AccountSetDAO getAccountSetDAO(){
	 	return this.accountSetDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingSubject accountingSubject, Map<String, Object> tokens){
		super.addActions(userContext, accountingSubject, tokens);
		
		addAction(userContext, accountingSubject, tokens,"@create","createAccountingSubject","createAccountingSubject/","main","primary");
		addAction(userContext, accountingSubject, tokens,"@update","updateAccountingSubject","updateAccountingSubject/"+accountingSubject.getId()+"/","main","primary");
		addAction(userContext, accountingSubject, tokens,"@copy","cloneAccountingSubject","cloneAccountingSubject/"+accountingSubject.getId()+"/","main","primary");
		
		addAction(userContext, accountingSubject, tokens,"accounting_subject.transfer_to_account_set","transferToAnotherAccountSet","transferToAnotherAccountSet/"+accountingSubject.getId()+"/","main","primary");
		addAction(userContext, accountingSubject, tokens,"accounting_subject.addAccountingDocumentLine","addAccountingDocumentLine","addAccountingDocumentLine/"+accountingSubject.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingSubject, tokens,"accounting_subject.removeAccountingDocumentLine","removeAccountingDocumentLine","removeAccountingDocumentLine/"+accountingSubject.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingSubject, tokens,"accounting_subject.updateAccountingDocumentLine","updateAccountingDocumentLine","updateAccountingDocumentLine/"+accountingSubject.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingSubject, tokens,"accounting_subject.copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom/"+accountingSubject.getId()+"/","accountingDocumentLineList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingSubject accountingSubject, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingSubject createAccountingSubject(RetailScmUserContext userContext,String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName, String accountSetId
) throws Exception
	{
		
		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");

		

		checkAccountingSubjectCodeOfAccountingSubject(userContext,  accountingSubjectCode, exception);
		checkAccountingSubjectNameOfAccountingSubject(userContext,  accountingSubjectName, exception);
		checkAccountingSubjectClassCodeOfAccountingSubject(userContext,  accountingSubjectClassCode, exception);
		checkAccountingSubjectClassNameOfAccountingSubject(userContext,  accountingSubjectClassName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountingSubject accountingSubject=createNewAccountingSubject();	

		accountingSubject.setAccountingSubjectCode(accountingSubjectCode);
		accountingSubject.setAccountingSubjectName(accountingSubjectName);
		accountingSubject.setAccountingSubjectClassCode(accountingSubjectClassCode);
		accountingSubject.setAccountingSubjectClassName(accountingSubjectClassName);
		AccountSet accountSet = loadAccountSet(accountSetId,emptyOptions());
		accountingSubject.setAccountSet(accountSet);

		return saveAccountingSubject(userContext, accountingSubject, emptyOptions());
		

		
	}
	protected AccountingSubject createNewAccountingSubject() 
	{
		
		return new AccountingSubject();		
	}
	
	protected void checkParamsForUpdatingAccountingSubject(RetailScmUserContext userContext,String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");
		
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);
		checkVersionOfAccountingSubject(userContext, accountingSubjectVersion, exception);
		

		if(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY.equals(property)){
			checkAccountingSubjectCodeOfAccountingSubject(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY.equals(property)){
			checkAccountingSubjectNameOfAccountingSubject(userContext, parseString(newValueExpr), exception);
		}
		if(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY.equals(property)){
			checkAccountingSubjectClassCodeOfAccountingSubject(userContext, parseInt(newValueExpr), exception);
		}
		if(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY.equals(property)){
			checkAccountingSubjectClassNameOfAccountingSubject(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public AccountingSubject clone(RetailScmUserContext userContext, String fromAccountingSubjectId) throws Exception{
		
		return this.getAccountingSubjectDAO().clone(fromAccountingSubjectId, this.allTokens());
	}
	
	public AccountingSubject updateAccountingSubject(RetailScmUserContext userContext,String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingSubject(userContext, accountingSubjectId, accountingSubjectVersion, property, newValueExpr, tokensExpr);
		
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		if(accountingSubject.getVersion() != accountingSubjectVersion){
			String message = "The target version("+accountingSubject.getVersion()+") is not equals to version("+accountingSubjectVersion+") provided";
			throw new AccountingSubjectManagerException(message);
		}
		synchronized(accountingSubject){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingSubject.
			
			accountingSubject.changePropery(property, newValueExpr);
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().done());
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
			//return saveAccountingSubject(userContext, accountingSubject, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingSubjectTokens tokens(){
		return AccountingSubjectTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingSubjectTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingSubjectTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherAccountSet(RetailScmUserContext userContext, String accountingSubjectId, String anotherAccountSetId) throws Exception
 	{
 		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");
 		checkIdOfAccountingSubject(userContext, accountingSubjectId,exception);
 		checkIdOfAccountSet(userContext, anotherAccountSetId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountingSubject transferToAnotherAccountSet(RetailScmUserContext userContext, String accountingSubjectId, String anotherAccountSetId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountSet(userContext, accountingSubjectId,anotherAccountSetId);
 
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());	
		synchronized(accountingSubject){
			//will be good when the accountingSubject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountSet accountSet = loadAccountSet(anotherAccountSetId, emptyOptions());		
			accountingSubject.setAccountSet(accountSet);		
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, emptyOptions());
			
			return present(userContext,accountingSubject, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected AccountSet loadAccountSet(String newAccountSetId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountSetDAO().load(newAccountSetId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String accountingSubjectId, int accountingSubjectVersion) throws Exception {
		
		deleteInternal(userContext, accountingSubjectId, accountingSubjectVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountingSubjectId, int accountingSubjectVersion) throws Exception{
		getAccountingSubjectDAO().delete(accountingSubjectId, accountingSubjectVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingSubjectManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountingSubjectDAO().deleteAll();
	}

	protected void checkParamsForAddingAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, String name, String code, String direct, double amount, String belongsToId,String [] tokensExpr) throws Exception{
		
		

		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");
		
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);

		checkNameOfAccountingDocumentLine(userContext,  name, exception);
		checkCodeOfAccountingDocumentLine(userContext,  code, exception);
		checkDirectOfAccountingDocumentLine(userContext,  direct, exception);
		checkAmountOfAccountingDocumentLine(userContext,  amount, exception);		
		
		checkIdOfAccountingDocument(userContext,  belongsToId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountingSubject addAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, String name, String code, String direct, double amount, String belongsToId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocumentLine(userContext,accountingSubjectId,name, code, direct, amount, belongsToId,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createAccountingDocumentLine(userContext,name, code, direct, amount, belongsToId);
		
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		synchronized(accountingSubject){ 
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingSubject.addAccountingDocumentLine( accountingDocumentLine );		
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountingDocumentLine createAccountingDocumentLine(RetailScmUserContext userContext, String name, String code, String direct, double amount, String belongsToId) throws Exception{

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		
		
		accountingDocumentLine.setName(name);		
		accountingDocumentLine.setCode(code);		
		accountingDocumentLine.setDirect(direct);		
		accountingDocumentLine.setAmount(amount);		
		AccountingDocument  belongsTo = new AccountingDocument();
		belongsTo.setId(belongsToId);		
		accountingDocumentLine.setBelongsTo(belongsTo);
	
		
		return accountingDocumentLine;
	
		
	}
	
	protected AccountingDocumentLine createIndexedAccountingDocumentLine(String id, int version){

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		accountingDocumentLine.setId(id);
		accountingDocumentLine.setVersion(version);
		return accountingDocumentLine;			
		
	}
	protected void checkParamsForRemovingAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		

		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");
		
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);
		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId, exception);
		checkVersionOfAccountingDocumentLine(userContext, accountingDocumentLineVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingSubject removeAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocumentLine(userContext,accountingSubjectId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		synchronized(accountingSubject){ 
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingSubject.removeAccountingDocumentLine( accountingDocumentLine );		
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		

		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");
		
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);
		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId, exception);
		checkVersionOfAccountingDocumentLine(userContext, accountingDocumentLineVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountingSubject copyAccountingDocumentLineFrom(RetailScmUserContext userContext, String accountingSubjectId, 
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocumentLine(userContext,accountingSubjectId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		synchronized(accountingSubject){ 
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingSubject.copyAccountingDocumentLineFrom( accountingDocumentLine );		
			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountingSubjectManagerException exception = new AccountingSubjectManagerException("Error Occured");
		
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);
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
	
	public  AccountingSubject updateAccountingDocumentLine(RetailScmUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocumentLine(userContext, accountingSubjectId, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId, allTokens());
		
		synchronized(accountingSubject){ 
			//Will be good when the accountingSubject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingSubject.removeAccountingDocumentLine( accountingDocumentLine );	
			//make changes to AcceleraterAccount.
			AccountingDocumentLine accountingDocumentLineIndex = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		
			AccountingDocumentLine accountingDocumentLine = accountingSubject.findTheAccountingDocumentLine(accountingDocumentLineIndex);
			if(accountingDocumentLine == null){
				throw new AccountingSubjectManagerException(accountingDocumentLine+"Not found" );
			}
			
			accountingDocumentLine.changePropery(property, newValueExpr);

			accountingSubject = saveAccountingSubject(userContext, accountingSubject, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingSubject, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


