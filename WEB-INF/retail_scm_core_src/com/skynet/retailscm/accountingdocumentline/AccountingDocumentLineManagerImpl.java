
package com.skynet.retailscm.accountingdocumentline;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingdocument.AccountingDocument;

import com.skynet.retailscm.accountingdocument.AccountingDocumentDAO;
import com.skynet.retailscm.accountingsubject.AccountingSubjectDAO;



import com.skynet.retailscm.accountingsubject.AccountingSubjectTable;
import com.skynet.retailscm.accountingdocument.AccountingDocumentTable;




public class AccountingDocumentLineManagerImpl extends RetailScmCheckerManager implements AccountingDocumentLineManager {
	
	private static final String SERVICE_TYPE = "AccountingDocumentLine";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountingDocumentLineDAO  accountingDocumentLineDAO;
 	public void setAccountingDocumentLineDAO(AccountingDocumentLineDAO  accountingDocumentLineDAO){
 	
 		if(accountingDocumentLineDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentLineDAO to null.");
 		}
	 	this.accountingDocumentLineDAO = accountingDocumentLineDAO;
 	}
 	public AccountingDocumentLineDAO getAccountingDocumentLineDAO(){
 		if(this.accountingDocumentLineDAO == null){
 			throw new IllegalStateException("The AccountingDocumentLineDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentLineDAO;
 	}
 	
 	protected AccountingDocumentLine saveAccountingDocumentLine(RetailScmUserContext userContext, AccountingDocumentLine accountingDocumentLine, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentLineDAO().save(accountingDocumentLine, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentLine(userContext, accountingDocumentLine, tokens);
 	}
 	
 	protected AccountingDocumentLine saveAccountingDocumentLineDetail(RetailScmUserContext userContext, AccountingDocumentLine accountingDocumentLine) throws Exception{	

 		
 		return saveAccountingDocumentLine(userContext, accountingDocumentLine, allTokens());
 	}
 	
 	public AccountingDocumentLine loadAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentLineId, String [] tokensExpr) throws Exception{				
 
 		AccountingDocumentLineManagerException exception = new AccountingDocumentLineManagerException("Error Occured");
		
		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine( userContext, accountingDocumentLineId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentLine, tokens);
 	}
 	
 	protected AccountingDocumentLine present(RetailScmUserContext userContext, AccountingDocumentLine accountingDocumentLine, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentLine,tokens);
		
		
		return this.getAccountingDocumentLineDAO().present(accountingDocumentLine, tokens);
	}
 
 	
 	
 	public AccountingDocumentLine loadAccountingDocumentLineDetail(RetailScmUserContext userContext, String accountingDocumentLineId) throws Exception{	
 		AccountingDocumentLineManagerException exception = new AccountingDocumentLineManagerException("Error Occured");
		
		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine( userContext, accountingDocumentLineId, allTokens());

 		return present(userContext,accountingDocumentLine, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountingDocumentLineId) throws Exception{	
 		AccountingDocumentLineManagerException exception = new AccountingDocumentLineManagerException("Error Occured");
		
		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine( userContext, accountingDocumentLineId, allTokens());

 		return present(userContext,accountingDocumentLine, allTokens());
		
 	}
 	protected AccountingDocumentLine saveAccountingDocumentLine(RetailScmUserContext userContext, AccountingDocumentLine accountingDocumentLine, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentLineDAO().save(accountingDocumentLine, tokens);
 	}
 	protected AccountingDocumentLine loadAccountingDocumentLine(RetailScmUserContext userContext, String accountingDocumentLineId, Map<String,Object>tokens) throws Exception{	
 		return getAccountingDocumentLineDAO().load(accountingDocumentLineId, tokens);
 	}

	



 	 
 	
 	private  AccountingSubjectDAO  accountingSubjectDAO;
 	public void setAccountingSubjectDAO(AccountingSubjectDAO accountingSubjectDAO){
	 	this.accountingSubjectDAO = accountingSubjectDAO;
 	}
 	//------------------------------------
 	public AccountingSubjectDAO getAccountingSubjectDAO(){
	 	return this.accountingSubjectDAO;
 	}
 
 	
 	private  AccountingDocumentDAO  accountingDocumentDAO;
 	public void setAccountingDocumentDAO(AccountingDocumentDAO accountingDocumentDAO){
	 	this.accountingDocumentDAO = accountingDocumentDAO;
 	}
 	//------------------------------------
 	public AccountingDocumentDAO getAccountingDocumentDAO(){
	 	return this.accountingDocumentDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentLine accountingDocumentLine, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentLine, tokens);
		
		addAction(userContext, accountingDocumentLine, tokens,"@create","createAccountingDocumentLine","createAccountingDocumentLine/","main","primary");
		addAction(userContext, accountingDocumentLine, tokens,"@update","updateAccountingDocumentLine","updateAccountingDocumentLine/"+accountingDocumentLine.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentLine, tokens,"@copy","cloneAccountingDocumentLine","cloneAccountingDocumentLine/"+accountingDocumentLine.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentLine, tokens,"accounting_document_line.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+accountingDocumentLine.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentLine, tokens,"accounting_document_line.transfer_to_accounting_subject","transferToAnotherAccountingSubject","transferToAnotherAccountingSubject/"+accountingDocumentLine.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountingDocumentLine accountingDocumentLine, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountingDocumentLine createAccountingDocumentLine(RetailScmUserContext userContext,String name, String code, String direct, double amount, String belongsToId, String accountingSubjectId
) throws Exception
	{
		
		AccountingDocumentLineManagerException exception = new AccountingDocumentLineManagerException("Error Occured");

		

		checkNameOfAccountingDocumentLine(userContext,  name, exception);
		checkCodeOfAccountingDocumentLine(userContext,  code, exception);
		checkDirectOfAccountingDocumentLine(userContext,  direct, exception);
		checkAmountOfAccountingDocumentLine(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountingDocumentLine accountingDocumentLine=createNewAccountingDocumentLine();	

		accountingDocumentLine.setName(name);
		accountingDocumentLine.setCode(code);
		accountingDocumentLine.setDirect(direct);
		accountingDocumentLine.setAmount(amount);
		AccountingDocument belongsTo = loadAccountingDocument(belongsToId,emptyOptions());
		accountingDocumentLine.setBelongsTo(belongsTo);
		AccountingSubject accountingSubject = loadAccountingSubject(accountingSubjectId,emptyOptions());
		accountingDocumentLine.setAccountingSubject(accountingSubject);

		return saveAccountingDocumentLine(userContext, accountingDocumentLine, emptyOptions());
		

		
	}
	protected AccountingDocumentLine createNewAccountingDocumentLine() 
	{
		
		return new AccountingDocumentLine();		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentLine(RetailScmUserContext userContext,String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountingDocumentLineManagerException exception = new AccountingDocumentLineManagerException("Error Occured");
		
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
	
	
	
	public AccountingDocumentLine clone(RetailScmUserContext userContext, String fromAccountingDocumentLineId) throws Exception{
		
		return this.getAccountingDocumentLineDAO().clone(fromAccountingDocumentLineId, this.allTokens());
	}
	
	public AccountingDocumentLine updateAccountingDocumentLine(RetailScmUserContext userContext,String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountingDocumentLine(userContext, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr, tokensExpr);
		
		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine(userContext, accountingDocumentLineId, allTokens());
		if(accountingDocumentLine.getVersion() != accountingDocumentLineVersion){
			String message = "The target version("+accountingDocumentLine.getVersion()+") is not equals to version("+accountingDocumentLineVersion+") provided";
			throw new AccountingDocumentLineManagerException(message);
		}
		synchronized(accountingDocumentLine){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentLine.
			
			accountingDocumentLine.changePropery(property, newValueExpr);
			accountingDocumentLine = saveAccountingDocumentLine(userContext, accountingDocumentLine, tokens().done());
			return present(userContext,accountingDocumentLine, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentLine(userContext, accountingDocumentLine, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountingDocumentLineTokens tokens(){
		return AccountingDocumentLineTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentLineTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentLineTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailScmUserContext userContext, String accountingDocumentLineId, String anotherBelongsToId) throws Exception
 	{
 		AccountingDocumentLineManagerException exception = new AccountingDocumentLineManagerException("Error Occured");
 		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId,exception);
 		checkIdOfAccountingDocument(userContext, anotherBelongsToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountingDocumentLine transferToAnotherBelongsTo(RetailScmUserContext userContext, String accountingDocumentLineId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, accountingDocumentLineId,anotherBelongsToId);
 
		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine(userContext, accountingDocumentLineId, allTokens());	
		synchronized(accountingDocumentLine){
			//will be good when the accountingDocumentLine loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocument belongsTo = loadAccountingDocument(anotherBelongsToId, emptyOptions());		
			accountingDocumentLine.setBelongsTo(belongsTo);		
			accountingDocumentLine = saveAccountingDocumentLine(userContext, accountingDocumentLine, emptyOptions());
			
			return present(userContext,accountingDocumentLine, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherAccountingSubject(RetailScmUserContext userContext, String accountingDocumentLineId, String anotherAccountingSubjectId) throws Exception
 	{
 		AccountingDocumentLineManagerException exception = new AccountingDocumentLineManagerException("Error Occured");
 		checkIdOfAccountingDocumentLine(userContext, accountingDocumentLineId,exception);
 		checkIdOfAccountingSubject(userContext, anotherAccountingSubjectId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountingDocumentLine transferToAnotherAccountingSubject(RetailScmUserContext userContext, String accountingDocumentLineId, String anotherAccountingSubjectId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountingSubject(userContext, accountingDocumentLineId,anotherAccountingSubjectId);
 
		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine(userContext, accountingDocumentLineId, allTokens());	
		synchronized(accountingDocumentLine){
			//will be good when the accountingDocumentLine loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingSubject accountingSubject = loadAccountingSubject(anotherAccountingSubjectId, emptyOptions());		
			accountingDocumentLine.setAccountingSubject(accountingSubject);		
			accountingDocumentLine = saveAccountingDocumentLine(userContext, accountingDocumentLine, emptyOptions());
			
			return present(userContext,accountingDocumentLine, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected AccountingSubject loadAccountingSubject(String newAccountingSubjectId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountingSubjectDAO().load(newAccountingSubjectId, options);
 	}
	
	 	
 	protected AccountingDocument loadAccountingDocument(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountingDocumentDAO().load(newBelongsToId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String accountingDocumentLineId, int accountingDocumentLineVersion) throws Exception {
		
		deleteInternal(userContext, accountingDocumentLineId, accountingDocumentLineVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountingDocumentLineId, int accountingDocumentLineVersion) throws Exception{
		getAccountingDocumentLineDAO().delete(accountingDocumentLineId, accountingDocumentLineVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentLineManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountingDocumentLineDAO().deleteAll();
	}


}


