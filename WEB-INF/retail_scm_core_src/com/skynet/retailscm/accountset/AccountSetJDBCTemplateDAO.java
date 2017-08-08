
package com.skynet.retailscm.accountset;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.goodssupplier.GoodsSupplierDAO;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentTypeDAO;
import com.skynet.retailscm.accountingsubject.AccountingSubjectDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;
import com.skynet.retailscm.accountingperiod.AccountingPeriodDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentTypeTable;
import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.accountingsubject.AccountingSubjectTable;
import com.skynet.retailscm.goodssupplier.GoodsSupplierTable;
import com.skynet.retailscm.accountingperiod.AccountingPeriodTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class AccountSetJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccountSetDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  GoodsSupplierDAO  goodsSupplierDAO;
 	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
	 	return this.goodsSupplierDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}

		
	
  	private  AccountingSubjectDAO  accountingSubjectDAO;
 	public void setAccountingSubjectDAO(AccountingSubjectDAO pAccountingSubjectDAO){
 	
 		if(pAccountingSubjectDAO == null){
 			throw new IllegalStateException("Do not try to set accountingSubjectDAO to null.");
 		}
	 	this.accountingSubjectDAO = pAccountingSubjectDAO;
 	}
 	public AccountingSubjectDAO getAccountingSubjectDAO(){
 		if(this.accountingSubjectDAO == null){
 			throw new IllegalStateException("The accountingSubjectDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingSubjectDAO;
 	}	
 	
			
		
	
  	private  AccountingPeriodDAO  accountingPeriodDAO;
 	public void setAccountingPeriodDAO(AccountingPeriodDAO pAccountingPeriodDAO){
 	
 		if(pAccountingPeriodDAO == null){
 			throw new IllegalStateException("Do not try to set accountingPeriodDAO to null.");
 		}
	 	this.accountingPeriodDAO = pAccountingPeriodDAO;
 	}
 	public AccountingPeriodDAO getAccountingPeriodDAO(){
 		if(this.accountingPeriodDAO == null){
 			throw new IllegalStateException("The accountingPeriodDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingPeriodDAO;
 	}	
 	
			
		
	
  	private  AccountingDocumentTypeDAO  accountingDocumentTypeDAO;
 	public void setAccountingDocumentTypeDAO(AccountingDocumentTypeDAO pAccountingDocumentTypeDAO){
 	
 		if(pAccountingDocumentTypeDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentTypeDAO to null.");
 		}
	 	this.accountingDocumentTypeDAO = pAccountingDocumentTypeDAO;
 	}
 	public AccountingDocumentTypeDAO getAccountingDocumentTypeDAO(){
 		if(this.accountingDocumentTypeDAO == null){
 			throw new IllegalStateException("The accountingDocumentTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentTypeDAO;
 	}	
 	
			
		

	
	/*
	protected AccountSet load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountSet(accessKey, options);
	}
	*/
	public AccountSet load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountSet(AccountSetTable.withId(id), options);
	}
	
	
	
	public AccountSet save(AccountSet accountSet,Map<String,Object> options){
		
		String methodName="save(AccountSet accountSet,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountSet, methodName, "accountSet");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountSet(accountSet,options);
	}
	public AccountSet clone(String accountSetId, Map<String,Object> options) throws Exception{
	
		return clone(AccountSetTable.withId(accountSetId),options);
	}
	
	protected AccountSet clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountSetId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountSet newAccountSet = loadInternalAccountSet(accessKey, options);
		newAccountSet.setVersion(0);
		
		
 		
 		if(isSaveAccountingSubjectListEnabled(options)){
 			for(AccountingSubject item: newAccountSet.getAccountingSubjectList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAccountingPeriodListEnabled(options)){
 			for(AccountingPeriod item: newAccountSet.getAccountingPeriodList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAccountingDocumentTypeListEnabled(options)){
 			for(AccountingDocumentType item: newAccountSet.getAccountingDocumentTypeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountSet(newAccountSet,options);
		
		return newAccountSet;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accountSetId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accountSetId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccountSetVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountSetNotFoundException(
					"The " + this.getTableName() + "(" + accountSetId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accountSetId, int version) throws Exception{
	
		String methodName="delete(String accountSetId, int version)";
		assertMethodArgumentNotNull(accountSetId, methodName, "accountSetId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountSetId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountSetId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","year_set","effective_date","accounting_system","domestic_currency_code","domestic_currency_name","opening_bank","account_number","country_center","retail_store","goods_supplier"};
		return AccountSetTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "account_set";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountSetTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCountryCenterEnabled = true;
 	//private static final String COUNTRYCENTER = "countryCenter";
 	protected boolean isExtractCountryCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountSetTokens.COUNTRYCENTER);
 	}
 	
 	
 	//private boolean saveCountryCenterEnabled = true;
 	protected boolean isSaveCountryCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountSetTokens.COUNTRYCENTER);
 	}
 	

 	
  
 	//private boolean extractRetailStoreEnabled = true;
 	//private static final String RETAILSTORE = "retailStore";
 	protected boolean isExtractRetailStoreEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountSetTokens.RETAILSTORE);
 	}
 	
 	
 	//private boolean saveRetailStoreEnabled = true;
 	protected boolean isSaveRetailStoreEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountSetTokens.RETAILSTORE);
 	}
 	

 	
  
 	//private boolean extractGoodsSupplierEnabled = true;
 	//private static final String GOODSSUPPLIER = "goodsSupplier";
 	protected boolean isExtractGoodsSupplierEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountSetTokens.GOODSSUPPLIER);
 	}
 	
 	
 	//private boolean saveGoodsSupplierEnabled = true;
 	protected boolean isSaveGoodsSupplierEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountSetTokens.GOODSSUPPLIER);
 	}
 	

 	
 
		
	//protected static final String ACCOUNTING_SUBJECT_LIST = "accountingSubjectList";
	
	protected boolean isExtractAccountingSubjectListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountSetTokens.ACCOUNTING_SUBJECT_LIST);
		
 	}

	protected boolean isSaveAccountingSubjectListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountSetTokens.ACCOUNTING_SUBJECT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String ACCOUNTING_PERIOD_LIST = "accountingPeriodList";
	
	protected boolean isExtractAccountingPeriodListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountSetTokens.ACCOUNTING_PERIOD_LIST);
		
 	}

	protected boolean isSaveAccountingPeriodListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountSetTokens.ACCOUNTING_PERIOD_LIST);
		
 	}
 	
 	
			
		
	//protected static final String ACCOUNTING_DOCUMENT_TYPE_LIST = "accountingDocumentTypeList";
	
	protected boolean isExtractAccountingDocumentTypeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountSetTokens.ACCOUNTING_DOCUMENT_TYPE_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountSetTokens.ACCOUNTING_DOCUMENT_TYPE_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountSetMapper getAccountSetMapper(){
		return new AccountSetMapper();
	}
	protected AccountSet extractAccountSet(String accountSetId) throws Exception{
		String SQL = "select * from account_set_data where id = ?";	
		try{
		
			AccountSet accountSet = queryForObject(SQL, new Object[]{accountSetId}, getAccountSetMapper());
			return accountSet;
		}catch(EmptyResultDataAccessException e){
			throw new AccountSetNotFoundException("AccountSet("+accountSetId+") is not found!");
		}
		
		
	}
	protected AccountSet extractAccountSet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from account_set_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			AccountSet accountSet = queryForObject(SQL, new Object[]{accessKey.getValue()}, getAccountSetMapper());
			return accountSet;
		}catch(EmptyResultDataAccessException e){
			throw new AccountSetNotFoundException("AccountSet("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected AccountSet loadInternalAccountSet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountSet accountSet = extractAccountSet(accessKey, loadOptions);
 	
 		if(isExtractCountryCenterEnabled(loadOptions)){
	 		extractCountryCenter(accountSet, loadOptions);
 		}
  	
 		if(isExtractRetailStoreEnabled(loadOptions)){
	 		extractRetailStore(accountSet, loadOptions);
 		}
  	
 		if(isExtractGoodsSupplierEnabled(loadOptions)){
	 		extractGoodsSupplier(accountSet, loadOptions);
 		}
 
		
		if(isExtractAccountingSubjectListEnabled(loadOptions)){
	 		extractAccountingSubjectList(accountSet, loadOptions);
 		}		
		
		if(isExtractAccountingPeriodListEnabled(loadOptions)){
	 		extractAccountingPeriodList(accountSet, loadOptions);
 		}		
		
		if(isExtractAccountingDocumentTypeListEnabled(loadOptions)){
	 		extractAccountingDocumentTypeList(accountSet, loadOptions);
 		}		
		
		return accountSet;
		
	}



	
	
	 

 	protected AccountSet extractCountryCenter(AccountSet accountSet, Map<String,Object> options) throws Exception{

		if(accountSet.getCountryCenter() == null){
			return accountSet;
		}
		String countryCenterId = accountSet.getCountryCenter().getId();
		if( countryCenterId == null){
			return accountSet;
		}
		RetailStoreCountryCenter countryCenter = getRetailStoreCountryCenterDAO().load(countryCenterId,options);
		if(countryCenter != null){
			accountSet.setCountryCenter(countryCenter);
		}
		
 		
 		return accountSet;
 	}
 		
  

 	protected AccountSet extractRetailStore(AccountSet accountSet, Map<String,Object> options) throws Exception{

		if(accountSet.getRetailStore() == null){
			return accountSet;
		}
		String retailStoreId = accountSet.getRetailStore().getId();
		if( retailStoreId == null){
			return accountSet;
		}
		RetailStore retailStore = getRetailStoreDAO().load(retailStoreId,options);
		if(retailStore != null){
			accountSet.setRetailStore(retailStore);
		}
		
 		
 		return accountSet;
 	}
 		
  

 	protected AccountSet extractGoodsSupplier(AccountSet accountSet, Map<String,Object> options) throws Exception{

		if(accountSet.getGoodsSupplier() == null){
			return accountSet;
		}
		String goodsSupplierId = accountSet.getGoodsSupplier().getId();
		if( goodsSupplierId == null){
			return accountSet;
		}
		GoodsSupplier goodsSupplier = getGoodsSupplierDAO().load(goodsSupplierId,options);
		if(goodsSupplier != null){
			accountSet.setGoodsSupplier(goodsSupplier);
		}
		
 		
 		return accountSet;
 	}
 		
 
		
	protected AccountSet extractAccountingSubjectList(AccountSet accountSet, Map<String,Object> options){
		
		SmartList<AccountingSubject> accountingSubjectList = getAccountingSubjectDAO().findAccountingSubjectByAccountSet(accountSet.getId(),options);
		if(accountingSubjectList != null){
			accountSet.setAccountingSubjectList(accountingSubjectList);
		}
		
		return accountSet;
	
	}	
		
	protected AccountSet extractAccountingPeriodList(AccountSet accountSet, Map<String,Object> options){
		
		SmartList<AccountingPeriod> accountingPeriodList = getAccountingPeriodDAO().findAccountingPeriodByAccountSet(accountSet.getId(),options);
		if(accountingPeriodList != null){
			accountSet.setAccountingPeriodList(accountingPeriodList);
		}
		
		return accountSet;
	
	}	
		
	protected AccountSet extractAccountingDocumentTypeList(AccountSet accountSet, Map<String,Object> options){
		
		SmartList<AccountingDocumentType> accountingDocumentTypeList = getAccountingDocumentTypeDAO().findAccountingDocumentTypeByAccountingPeriod(accountSet.getId(),options);
		if(accountingDocumentTypeList != null){
			accountSet.setAccountingDocumentTypeList(accountingDocumentTypeList);
		}
		
		return accountSet;
	
	}	
		
		
  	
 	public SmartList<AccountSet> findAccountSetByCountryCenter(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where country_center = ?";
		SmartList<AccountSet> accountSetList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getAccountSetMapper());	
 		return accountSetList;
 	}
 	
 	public SmartList<AccountSet> findAccountSetByCountryCenter(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where country_center = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountSet> accountSetList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getAccountSetMapper());
		
 		return accountSetList;
 	}
 	
 	public int countAccountSetByCountryCenter(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where country_center = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<AccountSet> findAccountSetByRetailStore(String retailStoreId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where retail_store = ?";
		SmartList<AccountSet> accountSetList = queryForList(SQL, new Object[]{retailStoreId}, getAccountSetMapper());	
 		return accountSetList;
 	}
 	
 	public SmartList<AccountSet> findAccountSetByRetailStore(String retailStoreId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where retail_store = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountSet> accountSetList = queryForList(SQL, new Object[]{retailStoreId,start, count}, getAccountSetMapper());
		
 		return accountSetList;
 	}
 	
 	public int countAccountSetByRetailStore(String retailStoreId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where retail_store = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<AccountSet> findAccountSetByGoodsSupplier(String goodsSupplierId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where goods_supplier = ?";
		SmartList<AccountSet> accountSetList = queryForList(SQL, new Object[]{goodsSupplierId}, getAccountSetMapper());	
 		return accountSetList;
 	}
 	
 	public SmartList<AccountSet> findAccountSetByGoodsSupplier(String goodsSupplierId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where goods_supplier = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<AccountSet> accountSetList = queryForList(SQL, new Object[]{goodsSupplierId,start, count}, getAccountSetMapper());
		
 		return accountSetList;
 	}
 	
 	public int countAccountSetByGoodsSupplier(String goodsSupplierId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where goods_supplier = ?";
		Integer count = queryInt(SQL, new Object[]{goodsSupplierId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected AccountSet saveAccountSet(AccountSet  accountSet){
	
		String SQL=this.getSaveAccountSetSQL(accountSet);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountSetParameters(accountSet);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountSet.incVersion();
		return accountSet;
	
	}
	public SmartList<AccountSet> saveAccountSetList(SmartList<AccountSet> accountSetList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountSetList(accountSetList);
		
		batchAccountSetCreate((List<AccountSet>)lists[CREATE_LIST_INDEX]);
		
		batchAccountSetUpdate((List<AccountSet>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountSet accountSet:accountSetList){
			if(accountSet.isChanged()){
				accountSet.incVersion();
			}
			
		
		}
		
		
		return accountSetList;
	}

	public SmartList<AccountSet> removeAccountSetList(SmartList<AccountSet> accountSetList,Map<String,Object> options){
		
		
		super.removeList(accountSetList, options);
		
		return accountSetList;
		
		
	}
	
	protected List<Object[]> prepareAccountSetBatchCreateArgs(List<AccountSet> accountSetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountSet accountSet:accountSetList ){
			Object [] parameters = prepareAccountSetCreateParameters(accountSet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountSetBatchUpdateArgs(List<AccountSet> accountSetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountSet accountSet:accountSetList ){
			if(!accountSet.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountSetUpdateParameters(accountSet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountSetCreate(List<AccountSet> accountSetList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountSetBatchCreateArgs(accountSetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountSetUpdate(List<AccountSet> accountSetList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountSetBatchUpdateArgs(accountSetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountSetList(List<AccountSet> accountSetList){
		
		List<AccountSet> accountSetCreateList=new ArrayList<AccountSet>();
		List<AccountSet> accountSetUpdateList=new ArrayList<AccountSet>();
		
		for(AccountSet accountSet: accountSetList){
			if(isUpdateRequest(accountSet)){
				accountSetUpdateList.add( accountSet);
				continue;
			}
			accountSetCreateList.add(accountSet);
		}
		
		return new Object[]{accountSetCreateList,accountSetUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountSet accountSet){
 		return accountSet.getVersion() > 0;
 	}
 	protected String getSaveAccountSetSQL(AccountSet accountSet){
 		if(isUpdateRequest(accountSet)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountSetParameters(AccountSet accountSet){
 		if(isUpdateRequest(accountSet) ){
 			return prepareAccountSetUpdateParameters(accountSet);
 		}
 		return prepareAccountSetCreateParameters(accountSet);
 	}
 	protected Object[] prepareAccountSetUpdateParameters(AccountSet accountSet){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = accountSet.getName();
 		parameters[1] = accountSet.getYearSet();
 		parameters[2] = accountSet.getEffectiveDate();
 		parameters[3] = accountSet.getAccountingSystem();
 		parameters[4] = accountSet.getDomesticCurrencyCode();
 		parameters[5] = accountSet.getDomesticCurrencyName();
 		parameters[6] = accountSet.getOpeningBank();
 		parameters[7] = accountSet.getAccountNumber(); 	
 		if(accountSet.getCountryCenter() != null){
 			parameters[8] = accountSet.getCountryCenter().getId();
 		}
  	
 		if(accountSet.getRetailStore() != null){
 			parameters[9] = accountSet.getRetailStore().getId();
 		}
  	
 		if(accountSet.getGoodsSupplier() != null){
 			parameters[10] = accountSet.getGoodsSupplier().getId();
 		}
 		
 		parameters[11] = accountSet.getId();
 		parameters[12] = accountSet.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountSetCreateParameters(AccountSet accountSet){
		Object[] parameters = new Object[12];
		String newAccountSetId=getNextId();
		accountSet.setId(newAccountSetId);
		parameters[0] =  accountSet.getId();
 
 		parameters[1] = accountSet.getName();
 		parameters[2] = accountSet.getYearSet();
 		parameters[3] = accountSet.getEffectiveDate();
 		parameters[4] = accountSet.getAccountingSystem();
 		parameters[5] = accountSet.getDomesticCurrencyCode();
 		parameters[6] = accountSet.getDomesticCurrencyName();
 		parameters[7] = accountSet.getOpeningBank();
 		parameters[8] = accountSet.getAccountNumber(); 	
 		if(accountSet.getCountryCenter() != null){
 			parameters[9] = accountSet.getCountryCenter().getId();
 		
 		}
 		 	
 		if(accountSet.getRetailStore() != null){
 			parameters[10] = accountSet.getRetailStore().getId();
 		
 		}
 		 	
 		if(accountSet.getGoodsSupplier() != null){
 			parameters[11] = accountSet.getGoodsSupplier().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected AccountSet saveInternalAccountSet(AccountSet accountSet, Map<String,Object> options){
		
		saveAccountSet(accountSet);
 	
 		if(isSaveCountryCenterEnabled(options)){
	 		saveCountryCenter(accountSet, options);
 		}
  	
 		if(isSaveRetailStoreEnabled(options)){
	 		saveRetailStore(accountSet, options);
 		}
  	
 		if(isSaveGoodsSupplierEnabled(options)){
	 		saveGoodsSupplier(accountSet, options);
 		}
 
		
		if(isSaveAccountingSubjectListEnabled(options)){
	 		saveAccountingSubjectList(accountSet, options);
	 		removeAccountingSubjectList(accountSet, options);
	 		
 		}		
		
		if(isSaveAccountingPeriodListEnabled(options)){
	 		saveAccountingPeriodList(accountSet, options);
	 		removeAccountingPeriodList(accountSet, options);
	 		
 		}		
		
		if(isSaveAccountingDocumentTypeListEnabled(options)){
	 		saveAccountingDocumentTypeList(accountSet, options);
	 		removeAccountingDocumentTypeList(accountSet, options);
	 		
 		}		
		
		return accountSet;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AccountSet saveCountryCenter(AccountSet accountSet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountSet.getCountryCenter() == null){
 			return accountSet;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(accountSet.getCountryCenter(),options);
 		return accountSet;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountSet saveRetailStore(AccountSet accountSet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountSet.getRetailStore() == null){
 			return accountSet;//do nothing when it is null
 		}
 		
 		getRetailStoreDAO().save(accountSet.getRetailStore(),options);
 		return accountSet;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountSet saveGoodsSupplier(AccountSet accountSet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountSet.getGoodsSupplier() == null){
 			return accountSet;//do nothing when it is null
 		}
 		
 		getGoodsSupplierDAO().save(accountSet.getGoodsSupplier(),options);
 		return accountSet;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected AccountSet saveAccountingSubjectList(AccountSet accountSet, Map<String,Object> options){
		SmartList<AccountingSubject> accountingSubjectList = accountSet.getAccountingSubjectList();
		if(accountingSubjectList == null){
			return accountSet;
		}
		if(accountingSubjectList.isEmpty()){
			return accountSet;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingSubjectDAO().saveAccountingSubjectList(accountingSubjectList,options);
		
		return accountSet;
	
	}
	
	protected AccountSet removeAccountingSubjectList(AccountSet accountSet, Map<String,Object> options){
	
	
		SmartList<AccountingSubject> accountingSubjectList = accountSet.getAccountingSubjectList();
		if(accountingSubjectList == null){
			return accountSet;
		}	
	
		SmartList<AccountingSubject> toRemoveAccountingSubjectList = accountingSubjectList.getToRemoveList();
		
		if(toRemoveAccountingSubjectList == null){
			return accountSet;
		}
		if(toRemoveAccountingSubjectList.isEmpty()){
			return accountSet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingSubjectDAO().removeAccountingSubjectList(toRemoveAccountingSubjectList,options);
		
		return accountSet;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected AccountSet saveAccountingPeriodList(AccountSet accountSet, Map<String,Object> options){
		SmartList<AccountingPeriod> accountingPeriodList = accountSet.getAccountingPeriodList();
		if(accountingPeriodList == null){
			return accountSet;
		}
		if(accountingPeriodList.isEmpty()){
			return accountSet;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingPeriodDAO().saveAccountingPeriodList(accountingPeriodList,options);
		
		return accountSet;
	
	}
	
	protected AccountSet removeAccountingPeriodList(AccountSet accountSet, Map<String,Object> options){
	
	
		SmartList<AccountingPeriod> accountingPeriodList = accountSet.getAccountingPeriodList();
		if(accountingPeriodList == null){
			return accountSet;
		}	
	
		SmartList<AccountingPeriod> toRemoveAccountingPeriodList = accountingPeriodList.getToRemoveList();
		
		if(toRemoveAccountingPeriodList == null){
			return accountSet;
		}
		if(toRemoveAccountingPeriodList.isEmpty()){
			return accountSet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingPeriodDAO().removeAccountingPeriodList(toRemoveAccountingPeriodList,options);
		
		return accountSet;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected AccountSet saveAccountingDocumentTypeList(AccountSet accountSet, Map<String,Object> options){
		SmartList<AccountingDocumentType> accountingDocumentTypeList = accountSet.getAccountingDocumentTypeList();
		if(accountingDocumentTypeList == null){
			return accountSet;
		}
		if(accountingDocumentTypeList.isEmpty()){
			return accountSet;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountingDocumentTypeDAO().saveAccountingDocumentTypeList(accountingDocumentTypeList,options);
		
		return accountSet;
	
	}
	
	protected AccountSet removeAccountingDocumentTypeList(AccountSet accountSet, Map<String,Object> options){
	
	
		SmartList<AccountingDocumentType> accountingDocumentTypeList = accountSet.getAccountingDocumentTypeList();
		if(accountingDocumentTypeList == null){
			return accountSet;
		}	
	
		SmartList<AccountingDocumentType> toRemoveAccountingDocumentTypeList = accountingDocumentTypeList.getToRemoveList();
		
		if(toRemoveAccountingDocumentTypeList == null){
			return accountSet;
		}
		if(toRemoveAccountingDocumentTypeList.isEmpty()){
			return accountSet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentTypeDAO().removeAccountingDocumentTypeList(toRemoveAccountingDocumentTypeList,options);
		
		return accountSet;
	
	}
	
	
	
 	
 	
	
	
	
		

	public AccountSet present(AccountSet accountSet,Map<String, Object> options){
	
		presentAccountingSubjectList(accountSet,options);
		presentAccountingPeriodList(accountSet,options);
		presentAccountingDocumentTypeList(accountSet,options);

		return accountSet;
	
	}
		
	
  	
 	protected AccountSet presentAccountingSubjectList(
			AccountSet accountSet,
			Map<String, Object> options) {

		SmartList<AccountingSubject> accountingSubjectList = accountSet.getAccountingSubjectList();		
		if(accountingSubjectList == null){
			return accountSet;			
		}
		
		String targetObjectName = "accountingSubject";
		int accountingSubjectListSize = accountingSubjectList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingSubjectListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountSet;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingSubjectListSize;
		if(accountingSubjectListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingSubjectDAO().countAccountingSubjectByAccountSet(accountSet.getId(), options);			
		}
		//accountSet.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountSet.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingSubjectListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingSubjectListSize,currentPage,rowsPerPage) ;
			accountingSubjectList = accountingSubjectList.subListOf(fromIndex, toIndex);
			accountingSubjectList.setTotalCount(count);
			accountingSubjectList.setCurrentPageNumber(currentPage);			
			accountSet.setAccountingSubjectList(accountingSubjectList);
			return accountSet;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingSubjectList 
			= getAccountingSubjectDAO().findAccountingSubjectByAccountSet(accountSet.getId(),start, rowsPerPage, options );
		accountingSubjectList.setTotalCount(count);
		accountingSubjectList.setCurrentPageNumber(currentPage);
		accountSet.setAccountingSubjectList(accountingSubjectList );	

		return accountSet;
	}			
		
	
  	
 	protected AccountSet presentAccountingPeriodList(
			AccountSet accountSet,
			Map<String, Object> options) {

		SmartList<AccountingPeriod> accountingPeriodList = accountSet.getAccountingPeriodList();		
		if(accountingPeriodList == null){
			return accountSet;			
		}
		
		String targetObjectName = "accountingPeriod";
		int accountingPeriodListSize = accountingPeriodList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingPeriodListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountSet;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingPeriodListSize;
		if(accountingPeriodListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingPeriodDAO().countAccountingPeriodByAccountSet(accountSet.getId(), options);			
		}
		//accountSet.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountSet.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingPeriodListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingPeriodListSize,currentPage,rowsPerPage) ;
			accountingPeriodList = accountingPeriodList.subListOf(fromIndex, toIndex);
			accountingPeriodList.setTotalCount(count);
			accountingPeriodList.setCurrentPageNumber(currentPage);			
			accountSet.setAccountingPeriodList(accountingPeriodList);
			return accountSet;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingPeriodList 
			= getAccountingPeriodDAO().findAccountingPeriodByAccountSet(accountSet.getId(),start, rowsPerPage, options );
		accountingPeriodList.setTotalCount(count);
		accountingPeriodList.setCurrentPageNumber(currentPage);
		accountSet.setAccountingPeriodList(accountingPeriodList );	

		return accountSet;
	}			
		
	
  	
 	protected AccountSet presentAccountingDocumentTypeList(
			AccountSet accountSet,
			Map<String, Object> options) {

		SmartList<AccountingDocumentType> accountingDocumentTypeList = accountSet.getAccountingDocumentTypeList();		
		if(accountingDocumentTypeList == null){
			return accountSet;			
		}
		
		String targetObjectName = "accountingDocumentType";
		int accountingDocumentTypeListSize = accountingDocumentTypeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountingDocumentTypeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return accountSet;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountingDocumentTypeListSize;
		if(accountingDocumentTypeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountingDocumentTypeDAO().countAccountingDocumentTypeByAccountingPeriod(accountSet.getId(), options);			
		}
		//accountSet.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//accountSet.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountingDocumentTypeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountingDocumentTypeListSize,currentPage,rowsPerPage) ;
			accountingDocumentTypeList = accountingDocumentTypeList.subListOf(fromIndex, toIndex);
			accountingDocumentTypeList.setTotalCount(count);
			accountingDocumentTypeList.setCurrentPageNumber(currentPage);			
			accountSet.setAccountingDocumentTypeList(accountingDocumentTypeList);
			return accountSet;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountingDocumentTypeList 
			= getAccountingDocumentTypeDAO().findAccountingDocumentTypeByAccountingPeriod(accountSet.getId(),start, rowsPerPage, options );
		accountingDocumentTypeList.setTotalCount(count);
		accountingDocumentTypeList.setCurrentPageNumber(currentPage);
		accountSet.setAccountingDocumentTypeList(accountingDocumentTypeList );	

		return accountSet;
	}			
		


	protected String getTableName(){
		return AccountSetTable.TABLE_NAME;
	}
}


