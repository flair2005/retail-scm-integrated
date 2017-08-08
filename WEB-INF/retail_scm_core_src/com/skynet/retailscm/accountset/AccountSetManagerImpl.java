
package com.skynet.retailscm.accountset;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.goodssupplier.GoodsSupplierDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;

import com.skynet.retailscm.accountset.AccountSet;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentTypeTable;
import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.accountingsubject.AccountingSubjectTable;
import com.skynet.retailscm.goodssupplier.GoodsSupplierTable;
import com.skynet.retailscm.accountingperiod.AccountingPeriodTable;




public class AccountSetManagerImpl extends RetailScmCheckerManager implements AccountSetManager {
	
	private static final String SERVICE_TYPE = "AccountSet";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  AccountSetDAO  accountSetDAO;
 	public void setAccountSetDAO(AccountSetDAO  accountSetDAO){
 	
 		if(accountSetDAO == null){
 			throw new IllegalStateException("Do not try to set accountSetDAO to null.");
 		}
	 	this.accountSetDAO = accountSetDAO;
 	}
 	public AccountSetDAO getAccountSetDAO(){
 		if(this.accountSetDAO == null){
 			throw new IllegalStateException("The AccountSetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountSetDAO;
 	}
 	
 	protected AccountSet saveAccountSet(RetailScmUserContext userContext, AccountSet accountSet, String [] tokensExpr) throws Exception{	
 		//return getAccountSetDAO().save(accountSet, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountSet(userContext, accountSet, tokens);
 	}
 	
 	protected AccountSet saveAccountSetDetail(RetailScmUserContext userContext, AccountSet accountSet) throws Exception{	

 		
 		return saveAccountSet(userContext, accountSet, allTokens());
 	}
 	
 	public AccountSet loadAccountSet(RetailScmUserContext userContext, String accountSetId, String [] tokensExpr) throws Exception{				
 
 		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountSet accountSet = loadAccountSet( userContext, accountSetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountSet, tokens);
 	}
 	
 	protected AccountSet present(RetailScmUserContext userContext, AccountSet accountSet, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountSet,tokens);
		
		
		return this.getAccountSetDAO().present(accountSet, tokens);
	}
 
 	
 	
 	public AccountSet loadAccountSetDetail(RetailScmUserContext userContext, String accountSetId) throws Exception{	
 		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountSet accountSet = loadAccountSet( userContext, accountSetId, allTokens());

 		return present(userContext,accountSet, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String accountSetId) throws Exception{	
 		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		AccountSet accountSet = loadAccountSet( userContext, accountSetId, allTokens());

 		return present(userContext,accountSet, allTokens());
		
 	}
 	protected AccountSet saveAccountSet(RetailScmUserContext userContext, AccountSet accountSet, Map<String,Object>tokens) throws Exception{	
 		return getAccountSetDAO().save(accountSet, tokens);
 	}
 	protected AccountSet loadAccountSet(RetailScmUserContext userContext, String accountSetId, Map<String,Object>tokens) throws Exception{	
 		return getAccountSetDAO().load(accountSetId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  GoodsSupplierDAO  goodsSupplierDAO;
 	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	//------------------------------------
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
	 	return this.goodsSupplierDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	//------------------------------------
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountSet accountSet, Map<String, Object> tokens){
		super.addActions(userContext, accountSet, tokens);
		
		addAction(userContext, accountSet, tokens,"@create","createAccountSet","createAccountSet/","main","primary");
		addAction(userContext, accountSet, tokens,"@update","updateAccountSet","updateAccountSet/"+accountSet.getId()+"/","main","primary");
		addAction(userContext, accountSet, tokens,"@copy","cloneAccountSet","cloneAccountSet/"+accountSet.getId()+"/","main","primary");
		
		addAction(userContext, accountSet, tokens,"account_set.transfer_to_country_center","transferToAnotherCountryCenter","transferToAnotherCountryCenter/"+accountSet.getId()+"/","main","primary");
		addAction(userContext, accountSet, tokens,"account_set.transfer_to_retail_store","transferToAnotherRetailStore","transferToAnotherRetailStore/"+accountSet.getId()+"/","main","primary");
		addAction(userContext, accountSet, tokens,"account_set.transfer_to_goods_supplier","transferToAnotherGoodsSupplier","transferToAnotherGoodsSupplier/"+accountSet.getId()+"/","main","primary");
		addAction(userContext, accountSet, tokens,"account_set.addAccountingSubject","addAccountingSubject","addAccountingSubject/"+accountSet.getId()+"/","accountingSubjectList","primary");
		addAction(userContext, accountSet, tokens,"account_set.removeAccountingSubject","removeAccountingSubject","removeAccountingSubject/"+accountSet.getId()+"/","accountingSubjectList","primary");
		addAction(userContext, accountSet, tokens,"account_set.updateAccountingSubject","updateAccountingSubject","updateAccountingSubject/"+accountSet.getId()+"/","accountingSubjectList","primary");
		addAction(userContext, accountSet, tokens,"account_set.copyAccountingSubjectFrom","copyAccountingSubjectFrom","copyAccountingSubjectFrom/"+accountSet.getId()+"/","accountingSubjectList","primary");
		addAction(userContext, accountSet, tokens,"account_set.addAccountingPeriod","addAccountingPeriod","addAccountingPeriod/"+accountSet.getId()+"/","accountingPeriodList","primary");
		addAction(userContext, accountSet, tokens,"account_set.removeAccountingPeriod","removeAccountingPeriod","removeAccountingPeriod/"+accountSet.getId()+"/","accountingPeriodList","primary");
		addAction(userContext, accountSet, tokens,"account_set.updateAccountingPeriod","updateAccountingPeriod","updateAccountingPeriod/"+accountSet.getId()+"/","accountingPeriodList","primary");
		addAction(userContext, accountSet, tokens,"account_set.copyAccountingPeriodFrom","copyAccountingPeriodFrom","copyAccountingPeriodFrom/"+accountSet.getId()+"/","accountingPeriodList","primary");
		addAction(userContext, accountSet, tokens,"account_set.addAccountingDocumentType","addAccountingDocumentType","addAccountingDocumentType/"+accountSet.getId()+"/","accountingDocumentTypeList","primary");
		addAction(userContext, accountSet, tokens,"account_set.removeAccountingDocumentType","removeAccountingDocumentType","removeAccountingDocumentType/"+accountSet.getId()+"/","accountingDocumentTypeList","primary");
		addAction(userContext, accountSet, tokens,"account_set.updateAccountingDocumentType","updateAccountingDocumentType","updateAccountingDocumentType/"+accountSet.getId()+"/","accountingDocumentTypeList","primary");
		addAction(userContext, accountSet, tokens,"account_set.copyAccountingDocumentTypeFrom","copyAccountingDocumentTypeFrom","copyAccountingDocumentTypeFrom/"+accountSet.getId()+"/","accountingDocumentTypeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, AccountSet accountSet, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AccountSet createAccountSet(RetailScmUserContext userContext,String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId, String goodsSupplierId
) throws Exception
	{
		
		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");

		

		checkNameOfAccountSet(userContext,  name, exception);
		checkYearSetOfAccountSet(userContext,  yearSet, exception);
		checkEffectiveDateOfAccountSet(userContext,  effectiveDate, exception);
		checkAccountingSystemOfAccountSet(userContext,  accountingSystem, exception);
		checkDomesticCurrencyCodeOfAccountSet(userContext,  domesticCurrencyCode, exception);
		checkDomesticCurrencyNameOfAccountSet(userContext,  domesticCurrencyName, exception);
		checkOpeningBankOfAccountSet(userContext,  openingBank, exception);
		checkAccountNumberOfAccountSet(userContext,  accountNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		AccountSet accountSet=createNewAccountSet();	

		accountSet.setName(name);
		accountSet.setYearSet(yearSet);
		accountSet.setEffectiveDate(effectiveDate);
		accountSet.setAccountingSystem(accountingSystem);
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);
		accountSet.setDomesticCurrencyName(domesticCurrencyName);
		accountSet.setOpeningBank(openingBank);
		accountSet.setAccountNumber(accountNumber);
		RetailStoreCountryCenter countryCenter = loadRetailStoreCountryCenter(countryCenterId,emptyOptions());
		accountSet.setCountryCenter(countryCenter);
		RetailStore retailStore = loadRetailStore(retailStoreId,emptyOptions());
		accountSet.setRetailStore(retailStore);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(goodsSupplierId,emptyOptions());
		accountSet.setGoodsSupplier(goodsSupplier);

		return saveAccountSet(userContext, accountSet, emptyOptions());
		

		
	}
	protected AccountSet createNewAccountSet() 
	{
		
		return new AccountSet();		
	}
	
	protected void checkParamsForUpdatingAccountSet(RetailScmUserContext userContext,String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);
		

		if(AccountSet.NAME_PROPERTY.equals(property)){
			checkNameOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		if(AccountSet.YEAR_SET_PROPERTY.equals(property)){
			checkYearSetOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		if(AccountSet.EFFECTIVE_DATE_PROPERTY.equals(property)){
			checkEffectiveDateOfAccountSet(userContext, parseDate(newValueExpr), exception);
		}
		if(AccountSet.ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			checkAccountingSystemOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		if(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			checkDomesticCurrencyCodeOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		if(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			checkDomesticCurrencyNameOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		if(AccountSet.OPENING_BANK_PROPERTY.equals(property)){
			checkOpeningBankOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		if(AccountSet.ACCOUNT_NUMBER_PROPERTY.equals(property)){
			checkAccountNumberOfAccountSet(userContext, parseString(newValueExpr), exception);
		}		

				

				

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public AccountSet clone(RetailScmUserContext userContext, String fromAccountSetId) throws Exception{
		
		return this.getAccountSetDAO().clone(fromAccountSetId, this.allTokens());
	}
	
	public AccountSet updateAccountSet(RetailScmUserContext userContext,String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAccountSet(userContext, accountSetId, accountSetVersion, property, newValueExpr, tokensExpr);
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		if(accountSet.getVersion() != accountSetVersion){
			String message = "The target version("+accountSet.getVersion()+") is not equals to version("+accountSetVersion+") provided";
			throw new AccountSetManagerException(message);
		}
		synchronized(accountSet){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountSet.
			
			accountSet.changePropery(property, newValueExpr);
			accountSet = saveAccountSet(userContext, accountSet, tokens().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
			//return saveAccountSet(userContext, accountSet, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AccountSetTokens tokens(){
		return AccountSetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountSetTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountSetTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCountryCenter(RetailScmUserContext userContext, String accountSetId, String anotherCountryCenterId) throws Exception
 	{
 		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
 		checkIdOfAccountSet(userContext, accountSetId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCountryCenterId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountSet transferToAnotherCountryCenter(RetailScmUserContext userContext, String accountSetId, String anotherCountryCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCountryCenter(userContext, accountSetId,anotherCountryCenterId);
 
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());	
		synchronized(accountSet){
			//will be good when the accountSet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter countryCenter = loadRetailStoreCountryCenter(anotherCountryCenterId, emptyOptions());		
			accountSet.setCountryCenter(countryCenter);		
			accountSet = saveAccountSet(userContext, accountSet, emptyOptions());
			
			return present(userContext,accountSet, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherRetailStore(RetailScmUserContext userContext, String accountSetId, String anotherRetailStoreId) throws Exception
 	{
 		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
 		checkIdOfAccountSet(userContext, accountSetId,exception);
 		checkIdOfRetailStore(userContext, anotherRetailStoreId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountSet transferToAnotherRetailStore(RetailScmUserContext userContext, String accountSetId, String anotherRetailStoreId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStore(userContext, accountSetId,anotherRetailStoreId);
 
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());	
		synchronized(accountSet){
			//will be good when the accountSet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore retailStore = loadRetailStore(anotherRetailStoreId, emptyOptions());		
			accountSet.setRetailStore(retailStore);		
			accountSet = saveAccountSet(userContext, accountSet, emptyOptions());
			
			return present(userContext,accountSet, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherGoodsSupplier(RetailScmUserContext userContext, String accountSetId, String anotherGoodsSupplierId) throws Exception
 	{
 		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
 		checkIdOfAccountSet(userContext, accountSetId,exception);
 		checkIdOfGoodsSupplier(userContext, anotherGoodsSupplierId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public AccountSet transferToAnotherGoodsSupplier(RetailScmUserContext userContext, String accountSetId, String anotherGoodsSupplierId) throws Exception
 	{
 		checkParamsForTransferingAnotherGoodsSupplier(userContext, accountSetId,anotherGoodsSupplierId);
 
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());	
		synchronized(accountSet){
			//will be good when the accountSet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsSupplier goodsSupplier = loadGoodsSupplier(anotherGoodsSupplierId, emptyOptions());		
			accountSet.setGoodsSupplier(goodsSupplier);		
			accountSet = saveAccountSet(userContext, accountSet, emptyOptions());
			
			return present(userContext,accountSet, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCountryCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCountryCenterId, options);
 	}
	
	 	
 	protected GoodsSupplier loadGoodsSupplier(String newGoodsSupplierId, Map<String,Object> options) throws Exception
 	{
		
 		return getGoodsSupplierDAO().load(newGoodsSupplierId, options);
 	}
	
	 	
 	protected RetailStore loadRetailStore(String newRetailStoreId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreDAO().load(newRetailStoreId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String accountSetId, int accountSetVersion) throws Exception {
		
		deleteInternal(userContext, accountSetId, accountSetVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String accountSetId, int accountSetVersion) throws Exception{
		getAccountSetDAO().delete(accountSetId, accountSetVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountSetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getAccountSetDAO().deleteAll();
	}

	protected void checkParamsForAddingAccountingSubject(RetailScmUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName,String [] tokensExpr) throws Exception{
		
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);

		checkAccountingSubjectCodeOfAccountingSubject(userContext,  accountingSubjectCode, exception);
		checkAccountingSubjectNameOfAccountingSubject(userContext,  accountingSubjectName, exception);
		checkAccountingSubjectClassCodeOfAccountingSubject(userContext,  accountingSubjectClassCode, exception);
		checkAccountingSubjectClassNameOfAccountingSubject(userContext,  accountingSubjectClassName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountSet addAccountingSubject(RetailScmUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingSubject(userContext,accountSetId,accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName,tokensExpr);
		
		AccountingSubject accountingSubject = createAccountingSubject(userContext,accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName);
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.addAccountingSubject( accountingSubject );		
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountingSubject createAccountingSubject(RetailScmUserContext userContext, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName) throws Exception{

		AccountingSubject accountingSubject = new AccountingSubject();
		
		
		accountingSubject.setAccountingSubjectCode(accountingSubjectCode);		
		accountingSubject.setAccountingSubjectName(accountingSubjectName);		
		accountingSubject.setAccountingSubjectClassCode(accountingSubjectClassCode);		
		accountingSubject.setAccountingSubjectClassName(accountingSubjectClassName);
	
		
		return accountingSubject;
	
		
	}
	
	protected AccountingSubject createIndexedAccountingSubject(String id, int version){

		AccountingSubject accountingSubject = new AccountingSubject();
		accountingSubject.setId(id);
		accountingSubject.setVersion(version);
		return accountingSubject;			
		
	}
	protected void checkParamsForRemovingAccountingSubject(RetailScmUserContext userContext, String accountSetId, 
		String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr) throws Exception{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);
		checkVersionOfAccountingSubject(userContext, accountingSubjectVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountSet removeAccountingSubject(RetailScmUserContext userContext, String accountSetId, 
		String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingSubject(userContext,accountSetId, accountingSubjectId, accountingSubjectVersion,tokensExpr);
		
		AccountingSubject accountingSubject = createIndexedAccountingSubject(accountingSubjectId, accountingSubjectVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.removeAccountingSubject( accountingSubject );		
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingSubject(RetailScmUserContext userContext, String accountSetId, 
		String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr) throws Exception{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkIdOfAccountingSubject(userContext, accountingSubjectId, exception);
		checkVersionOfAccountingSubject(userContext, accountingSubjectVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountSet copyAccountingSubjectFrom(RetailScmUserContext userContext, String accountSetId, 
		String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingSubject(userContext,accountSetId, accountingSubjectId, accountingSubjectVersion,tokensExpr);
		
		AccountingSubject accountingSubject = createIndexedAccountingSubject(accountingSubjectId, accountingSubjectVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.copyAccountingSubjectFrom( accountingSubject );		
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingSubject(RetailScmUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
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
	
	public  AccountSet updateAccountingSubject(RetailScmUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingSubject(userContext, accountSetId, accountingSubjectId, accountingSubjectVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountSet.removeAccountingSubject( accountingSubject );	
			//make changes to AcceleraterAccount.
			AccountingSubject accountingSubjectIndex = createIndexedAccountingSubject(accountingSubjectId, accountingSubjectVersion);
		
			AccountingSubject accountingSubject = accountSet.findTheAccountingSubject(accountingSubjectIndex);
			if(accountingSubject == null){
				throw new AccountSetManagerException(accountingSubject+"Not found" );
			}
			
			accountingSubject.changePropery(property, newValueExpr);

			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingSubjectList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingAccountingPeriod(RetailScmUserContext userContext, String accountSetId, String name, Date startDate, Date endDate,String [] tokensExpr) throws Exception{
		
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);

		checkNameOfAccountingPeriod(userContext,  name, exception);
		checkStartDateOfAccountingPeriod(userContext,  startDate, exception);
		checkEndDateOfAccountingPeriod(userContext,  endDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountSet addAccountingPeriod(RetailScmUserContext userContext, String accountSetId, String name, Date startDate, Date endDate, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingPeriod(userContext,accountSetId,name, startDate, endDate,tokensExpr);
		
		AccountingPeriod accountingPeriod = createAccountingPeriod(userContext,name, startDate, endDate);
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.addAccountingPeriod( accountingPeriod );		
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountingPeriod createAccountingPeriod(RetailScmUserContext userContext, String name, Date startDate, Date endDate) throws Exception{

		AccountingPeriod accountingPeriod = new AccountingPeriod();
		
		
		accountingPeriod.setName(name);		
		accountingPeriod.setStartDate(startDate);		
		accountingPeriod.setEndDate(endDate);
	
		
		return accountingPeriod;
	
		
	}
	
	protected AccountingPeriod createIndexedAccountingPeriod(String id, int version){

		AccountingPeriod accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(id);
		accountingPeriod.setVersion(version);
		return accountingPeriod;			
		
	}
	protected void checkParamsForRemovingAccountingPeriod(RetailScmUserContext userContext, String accountSetId, 
		String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr) throws Exception{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);
		checkVersionOfAccountingPeriod(userContext, accountingPeriodVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountSet removeAccountingPeriod(RetailScmUserContext userContext, String accountSetId, 
		String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingPeriod(userContext,accountSetId, accountingPeriodId, accountingPeriodVersion,tokensExpr);
		
		AccountingPeriod accountingPeriod = createIndexedAccountingPeriod(accountingPeriodId, accountingPeriodVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.removeAccountingPeriod( accountingPeriod );		
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingPeriod(RetailScmUserContext userContext, String accountSetId, 
		String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr) throws Exception{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkIdOfAccountingPeriod(userContext, accountingPeriodId, exception);
		checkVersionOfAccountingPeriod(userContext, accountingPeriodVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountSet copyAccountingPeriodFrom(RetailScmUserContext userContext, String accountSetId, 
		String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingPeriod(userContext,accountSetId, accountingPeriodId, accountingPeriodVersion,tokensExpr);
		
		AccountingPeriod accountingPeriod = createIndexedAccountingPeriod(accountingPeriodId, accountingPeriodVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.copyAccountingPeriodFrom( accountingPeriod );		
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingPeriod(RetailScmUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
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
	
	public  AccountSet updateAccountingPeriod(RetailScmUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingPeriod(userContext, accountSetId, accountingPeriodId, accountingPeriodVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountSet.removeAccountingPeriod( accountingPeriod );	
			//make changes to AcceleraterAccount.
			AccountingPeriod accountingPeriodIndex = createIndexedAccountingPeriod(accountingPeriodId, accountingPeriodVersion);
		
			AccountingPeriod accountingPeriod = accountSet.findTheAccountingPeriod(accountingPeriodIndex);
			if(accountingPeriod == null){
				throw new AccountSetManagerException(accountingPeriod+"Not found" );
			}
			
			accountingPeriod.changePropery(property, newValueExpr);

			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingPeriodList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, String name, String description,String [] tokensExpr) throws Exception{
		
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);

		checkNameOfAccountingDocumentType(userContext,  name, exception);
		checkDescriptionOfAccountingDocumentType(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  AccountSet addAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, String name, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountingDocumentType(userContext,accountSetId,name, description,tokensExpr);
		
		AccountingDocumentType accountingDocumentType = createAccountingDocumentType(userContext,name, description);
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.addAccountingDocumentType( accountingDocumentType );		
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountingDocumentType createAccountingDocumentType(RetailScmUserContext userContext, String name, String description) throws Exception{

		AccountingDocumentType accountingDocumentType = new AccountingDocumentType();
		
		
		accountingDocumentType.setName(name);		
		accountingDocumentType.setDescription(description);
	
		
		return accountingDocumentType;
	
		
	}
	
	protected AccountingDocumentType createIndexedAccountingDocumentType(String id, int version){

		AccountingDocumentType accountingDocumentType = new AccountingDocumentType();
		accountingDocumentType.setId(id);
		accountingDocumentType.setVersion(version);
		return accountingDocumentType;			
		
	}
	protected void checkParamsForRemovingAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, 
		String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr) throws Exception{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);
		checkVersionOfAccountingDocumentType(userContext, accountingDocumentTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountSet removeAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, 
		String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountingDocumentType(userContext,accountSetId, accountingDocumentTypeId, accountingDocumentTypeVersion,tokensExpr);
		
		AccountingDocumentType accountingDocumentType = createIndexedAccountingDocumentType(accountingDocumentTypeId, accountingDocumentTypeVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.removeAccountingDocumentType( accountingDocumentType );		
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, 
		String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr) throws Exception{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkIdOfAccountingDocumentType(userContext, accountingDocumentTypeId, exception);
		checkVersionOfAccountingDocumentType(userContext, accountingDocumentTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  AccountSet copyAccountingDocumentTypeFrom(RetailScmUserContext userContext, String accountSetId, 
		String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountingDocumentType(userContext,accountSetId, accountingDocumentTypeId, accountingDocumentTypeVersion,tokensExpr);
		
		AccountingDocumentType accountingDocumentType = createIndexedAccountingDocumentType(accountingDocumentTypeId, accountingDocumentTypeVersion);
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountSet.copyAccountingDocumentTypeFrom( accountingDocumentType );		
			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		AccountSetManagerException exception = new AccountSetManagerException("Error Occured");
		
		checkIdOfAccountSet(userContext, accountSetId, exception);
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
	
	public  AccountSet updateAccountingDocumentType(RetailScmUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountingDocumentType(userContext, accountSetId, accountingDocumentTypeId, accountingDocumentTypeVersion, property, newValueExpr,  tokensExpr);
		
		
		AccountSet accountSet = loadAccountSet(userContext, accountSetId, allTokens());
		
		synchronized(accountSet){ 
			//Will be good when the accountSet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountSet.removeAccountingDocumentType( accountingDocumentType );	
			//make changes to AcceleraterAccount.
			AccountingDocumentType accountingDocumentTypeIndex = createIndexedAccountingDocumentType(accountingDocumentTypeId, accountingDocumentTypeVersion);
		
			AccountingDocumentType accountingDocumentType = accountSet.findTheAccountingDocumentType(accountingDocumentTypeIndex);
			if(accountingDocumentType == null){
				throw new AccountSetManagerException(accountingDocumentType+"Not found" );
			}
			
			accountingDocumentType.changePropery(property, newValueExpr);

			accountSet = saveAccountSet(userContext, accountSet, tokens().withAccountingDocumentTypeList().done());
			return present(userContext,accountSet, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


