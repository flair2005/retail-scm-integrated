
package com.skynet.retailscm.accountset;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;

@JsonSerialize(using = AccountSetSerializer.class)
public class AccountSet extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String YEAR_SET_PROPERTY              = "yearSet"           ;
	public static final String EFFECTIVE_DATE_PROPERTY        = "effectiveDate"     ;
	public static final String ACCOUNTING_SYSTEM_PROPERTY     = "accountingSystem"  ;
	public static final String DOMESTIC_CURRENCY_CODE_PROPERTY = "domesticCurrencyCode";
	public static final String DOMESTIC_CURRENCY_NAME_PROPERTY = "domesticCurrencyName";
	public static final String OPENING_BANK_PROPERTY          = "openingBank"       ;
	public static final String ACCOUNT_NUMBER_PROPERTY        = "accountNumber"     ;
	public static final String COUNTRY_CENTER_PROPERTY        = "countryCenter"     ;
	public static final String RETAIL_STORE_PROPERTY          = "retailStore"       ;
	public static final String GOODS_SUPPLIER_PROPERTY        = "goodsSupplier"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ACCOUNTING_SUBJECT_LIST                  = "accountingSubjectList";
	public static final String ACCOUNTING_PERIOD_LIST                   = "accountingPeriodList";
	public static final String ACCOUNTING_DOCUMENT_TYPE_LIST            = "accountingDocumentTypeList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mYearSet            ;
	protected		Date                	mEffectiveDate      ;
	protected		String              	mAccountingSystem   ;
	protected		String              	mDomesticCurrencyCode;
	protected		String              	mDomesticCurrencyName;
	protected		String              	mOpeningBank        ;
	protected		String              	mAccountNumber      ;
	protected		RetailStoreCountryCenter	mCountryCenter      ;
	protected		RetailStore         	mRetailStore        ;
	protected		GoodsSupplier       	mGoodsSupplier      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AccountingSubject>	mAccountingSubjectList;
	protected		SmartList<AccountingPeriod>	mAccountingPeriodList;
	protected		SmartList<AccountingDocumentType>	mAccountingDocumentTypeList;
	
		
	public 	AccountSet(){
		//lazy load for all the properties
	}
	
	public 	AccountSet(String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, RetailStoreCountryCenter countryCenter, RetailStore retailStore, GoodsSupplier goodsSupplier
)
	{
		setName(name);
		setYearSet(yearSet);
		setEffectiveDate(effectiveDate);
		setAccountingSystem(accountingSystem);
		setDomesticCurrencyCode(domesticCurrencyCode);
		setDomesticCurrencyName(domesticCurrencyName);
		setOpeningBank(openingBank);
		setAccountNumber(accountNumber);
		setCountryCenter(countryCenter);
		setRetailStore(retailStore);
		setGoodsSupplier(goodsSupplier);

		this.mAccountingSubjectList = new SmartList<AccountingSubject>();
		this.mAccountingPeriodList = new SmartList<AccountingPeriod>();
		this.mAccountingDocumentTypeList = new SmartList<AccountingDocumentType>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(YEAR_SET_PROPERTY.equals(property)){
			changeYearSetProperty(newValueExpr);
		}
		if(EFFECTIVE_DATE_PROPERTY.equals(property)){
			changeEffectiveDateProperty(newValueExpr);
		}
		if(ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			changeAccountingSystemProperty(newValueExpr);
		}
		if(DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			changeDomesticCurrencyCodeProperty(newValueExpr);
		}
		if(DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			changeDomesticCurrencyNameProperty(newValueExpr);
		}
		if(OPENING_BANK_PROPERTY.equals(property)){
			changeOpeningBankProperty(newValueExpr);
		}
		if(ACCOUNT_NUMBER_PROPERTY.equals(property)){
			changeAccountNumberProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setName(newValue);
		//they are surely different each other
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeYearSetProperty(String newValueExpr){
		String oldValue = getYearSet();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setYearSet(newValue);
		//they are surely different each other
		this.onChangeProperty(YEAR_SET_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeEffectiveDateProperty(String newValueExpr){
		Date oldValue = getEffectiveDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setEffectiveDate(newValue);
		//they are surely different each other
		this.onChangeProperty(EFFECTIVE_DATE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAccountingSystemProperty(String newValueExpr){
		String oldValue = getAccountingSystem();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAccountingSystem(newValue);
		//they are surely different each other
		this.onChangeProperty(ACCOUNTING_SYSTEM_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDomesticCurrencyCodeProperty(String newValueExpr){
		String oldValue = getDomesticCurrencyCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDomesticCurrencyCode(newValue);
		//they are surely different each other
		this.onChangeProperty(DOMESTIC_CURRENCY_CODE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDomesticCurrencyNameProperty(String newValueExpr){
		String oldValue = getDomesticCurrencyName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDomesticCurrencyName(newValue);
		//they are surely different each other
		this.onChangeProperty(DOMESTIC_CURRENCY_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeOpeningBankProperty(String newValueExpr){
		String oldValue = getOpeningBank();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setOpeningBank(newValue);
		//they are surely different each other
		this.onChangeProperty(OPENING_BANK_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAccountNumberProperty(String newValueExpr){
		String oldValue = getAccountNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAccountNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(ACCOUNT_NUMBER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	
	
	public void setYearSet(String yearSet){
		this.mYearSet = trimString(yearSet);;
	}
	public String getYearSet(){
		return this.mYearSet;
	}
	
	
	public void setEffectiveDate(Date effectiveDate){
		this.mEffectiveDate = effectiveDate;;
	}
	public Date getEffectiveDate(){
		return this.mEffectiveDate;
	}
	
	
	public void setAccountingSystem(String accountingSystem){
		this.mAccountingSystem = trimString(accountingSystem);;
	}
	public String getAccountingSystem(){
		return this.mAccountingSystem;
	}
	
	
	public void setDomesticCurrencyCode(String domesticCurrencyCode){
		this.mDomesticCurrencyCode = trimString(domesticCurrencyCode);;
	}
	public String getDomesticCurrencyCode(){
		return this.mDomesticCurrencyCode;
	}
	
	
	public void setDomesticCurrencyName(String domesticCurrencyName){
		this.mDomesticCurrencyName = trimString(domesticCurrencyName);;
	}
	public String getDomesticCurrencyName(){
		return this.mDomesticCurrencyName;
	}
	
	
	public void setOpeningBank(String openingBank){
		this.mOpeningBank = trimString(openingBank);;
	}
	public String getOpeningBank(){
		return this.mOpeningBank;
	}
	
	
	public void setAccountNumber(String accountNumber){
		this.mAccountNumber = trimString(accountNumber);;
	}
	public String getAccountNumber(){
		return this.mAccountNumber;
	}
	
	
	public void setCountryCenter(RetailStoreCountryCenter countryCenter){
		this.mCountryCenter = countryCenter;;
	}
	public RetailStoreCountryCenter getCountryCenter(){
		return this.mCountryCenter;
	}
	
	
	public void setRetailStore(RetailStore retailStore){
		this.mRetailStore = retailStore;;
	}
	public RetailStore getRetailStore(){
		return this.mRetailStore;
	}
	
	
	public void setGoodsSupplier(GoodsSupplier goodsSupplier){
		this.mGoodsSupplier = goodsSupplier;;
	}
	public GoodsSupplier getGoodsSupplier(){
		return this.mGoodsSupplier;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<AccountingSubject> getAccountingSubjectList(){
		if(this.mAccountingSubjectList == null){
			this.mAccountingSubjectList = new SmartList<AccountingSubject>();
		}
		return this.mAccountingSubjectList;	
	}
	public  void setAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList){
		for( AccountingSubject accountingSubject:accountingSubjectList){
			accountingSubject.setAccountSet(this);
		}
		
		this.mAccountingSubjectList = accountingSubjectList;
		
	}
	
	public  void addAccountingSubject(AccountingSubject accountingSubject){
		accountingSubject.setAccountSet(this);
		getAccountingSubjectList().add(accountingSubject);
	}
	public  void addAccountingSubjects(SmartList<AccountingSubject> accountingSubjectList){
		for( AccountingSubject accountingSubject:accountingSubjectList){
			accountingSubject.setAccountSet(this);
		}
		getAccountingSubjectList().addAll(accountingSubjectList);
	}
	
	public  void removeAccountingSubject(AccountingSubject accountingSubject){
	
		boolean result = getAccountingSubjectList().planToRemove(accountingSubject);
        if(!result){
        	String message = "AccountingSubject("+accountingSubject.getId()+") with version='"+accountingSubject.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveAccountingSubjectList", accountingSubject);
		//the constant "toAccountingSubject" will be replaced after refactoried.
	
	}
	
	public void copyAccountingSubjectFrom(AccountingSubject accountingSubject) {
		// TODO Auto-generated method stub
		
        AccountingSubject accountingSubjectInList = findTheAccountingSubject(accountingSubject);
        AccountingSubject newAccountingSubject = new AccountingSubject();
        accountingSubjectInList.copyTo(newAccountingSubject);
        newAccountingSubject.setVersion(0);//will trigger copy
        getAccountingSubjectList().add(newAccountingSubject);
	}
	
	public  AccountingSubject findTheAccountingSubject(AccountingSubject accountingSubject){
		
		int index =  getAccountingSubjectList().indexOf(accountingSubject);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "AccountingSubject("+accountingSubject.getId()+") with version='"+accountingSubject.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getAccountingSubjectList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingSubjectList(){
		getAccountingSubjectList().clear();
	}
	
	
	
	
	public  SmartList<AccountingPeriod> getAccountingPeriodList(){
		if(this.mAccountingPeriodList == null){
			this.mAccountingPeriodList = new SmartList<AccountingPeriod>();
		}
		return this.mAccountingPeriodList;	
	}
	public  void setAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList){
		for( AccountingPeriod accountingPeriod:accountingPeriodList){
			accountingPeriod.setAccountSet(this);
		}
		
		this.mAccountingPeriodList = accountingPeriodList;
		
	}
	
	public  void addAccountingPeriod(AccountingPeriod accountingPeriod){
		accountingPeriod.setAccountSet(this);
		getAccountingPeriodList().add(accountingPeriod);
	}
	public  void addAccountingPeriods(SmartList<AccountingPeriod> accountingPeriodList){
		for( AccountingPeriod accountingPeriod:accountingPeriodList){
			accountingPeriod.setAccountSet(this);
		}
		getAccountingPeriodList().addAll(accountingPeriodList);
	}
	
	public  void removeAccountingPeriod(AccountingPeriod accountingPeriod){
	
		boolean result = getAccountingPeriodList().planToRemove(accountingPeriod);
        if(!result){
        	String message = "AccountingPeriod("+accountingPeriod.getId()+") with version='"+accountingPeriod.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveAccountingPeriodList", accountingPeriod);
		//the constant "toAccountingPeriod" will be replaced after refactoried.
	
	}
	
	public void copyAccountingPeriodFrom(AccountingPeriod accountingPeriod) {
		// TODO Auto-generated method stub
		
        AccountingPeriod accountingPeriodInList = findTheAccountingPeriod(accountingPeriod);
        AccountingPeriod newAccountingPeriod = new AccountingPeriod();
        accountingPeriodInList.copyTo(newAccountingPeriod);
        newAccountingPeriod.setVersion(0);//will trigger copy
        getAccountingPeriodList().add(newAccountingPeriod);
	}
	
	public  AccountingPeriod findTheAccountingPeriod(AccountingPeriod accountingPeriod){
		
		int index =  getAccountingPeriodList().indexOf(accountingPeriod);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "AccountingPeriod("+accountingPeriod.getId()+") with version='"+accountingPeriod.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getAccountingPeriodList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingPeriodList(){
		getAccountingPeriodList().clear();
	}
	
	
	
	
	public  SmartList<AccountingDocumentType> getAccountingDocumentTypeList(){
		if(this.mAccountingDocumentTypeList == null){
			this.mAccountingDocumentTypeList = new SmartList<AccountingDocumentType>();
		}
		return this.mAccountingDocumentTypeList;	
	}
	public  void setAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList){
		for( AccountingDocumentType accountingDocumentType:accountingDocumentTypeList){
			accountingDocumentType.setAccountingPeriod(this);
		}
		
		this.mAccountingDocumentTypeList = accountingDocumentTypeList;
		
	}
	
	public  void addAccountingDocumentType(AccountingDocumentType accountingDocumentType){
		accountingDocumentType.setAccountingPeriod(this);
		getAccountingDocumentTypeList().add(accountingDocumentType);
	}
	public  void addAccountingDocumentTypes(SmartList<AccountingDocumentType> accountingDocumentTypeList){
		for( AccountingDocumentType accountingDocumentType:accountingDocumentTypeList){
			accountingDocumentType.setAccountingPeriod(this);
		}
		getAccountingDocumentTypeList().addAll(accountingDocumentTypeList);
	}
	
	public  void removeAccountingDocumentType(AccountingDocumentType accountingDocumentType){
	
		boolean result = getAccountingDocumentTypeList().planToRemove(accountingDocumentType);
        if(!result){
        	String message = "AccountingDocumentType("+accountingDocumentType.getId()+") with version='"+accountingDocumentType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveAccountingDocumentTypeList", accountingDocumentType);
		//the constant "toAccountingDocumentType" will be replaced after refactoried.
	
	}
	
	public void copyAccountingDocumentTypeFrom(AccountingDocumentType accountingDocumentType) {
		// TODO Auto-generated method stub
		
        AccountingDocumentType accountingDocumentTypeInList = findTheAccountingDocumentType(accountingDocumentType);
        AccountingDocumentType newAccountingDocumentType = new AccountingDocumentType();
        accountingDocumentTypeInList.copyTo(newAccountingDocumentType);
        newAccountingDocumentType.setVersion(0);//will trigger copy
        getAccountingDocumentTypeList().add(newAccountingDocumentType);
	}
	
	public  AccountingDocumentType findTheAccountingDocumentType(AccountingDocumentType accountingDocumentType){
		
		int index =  getAccountingDocumentTypeList().indexOf(accountingDocumentType);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "AccountingDocumentType("+accountingDocumentType.getId()+") with version='"+accountingDocumentType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getAccountingDocumentTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingDocumentTypeList(){
		getAccountingDocumentTypeList().clear();
	}
	
	
	
	
 	
	
	public AccountSet copyTo(AccountSet dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setYearSet(getYearSet());
		dest.setEffectiveDate(getEffectiveDate());
		dest.setAccountingSystem(getAccountingSystem());
		dest.setDomesticCurrencyCode(getDomesticCurrencyCode());
		dest.setDomesticCurrencyName(getDomesticCurrencyName());
		dest.setOpeningBank(getOpeningBank());
		dest.setAccountNumber(getAccountNumber());
		dest.setCountryCenter(getCountryCenter());
		dest.setRetailStore(getRetailStore());
		dest.setGoodsSupplier(getGoodsSupplier());
		dest.setVersion(getVersion());
		dest.setAccountingSubjectList(getAccountingSubjectList());
		dest.setAccountingPeriodList(getAccountingPeriodList());
		dest.setAccountingDocumentTypeList(getAccountingDocumentTypeList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("account_set{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tyear_set='"+getYearSet()+"';");
		stringBuilder.append("\teffective_date='"+getEffectiveDate()+"';");
		stringBuilder.append("\taccounting_system='"+getAccountingSystem()+"';");
		stringBuilder.append("\tdomestic_currency_code='"+getDomesticCurrencyCode()+"';");
		stringBuilder.append("\tdomestic_currency_name='"+getDomesticCurrencyName()+"';");
		stringBuilder.append("\topening_bank='"+getOpeningBank()+"';");
		stringBuilder.append("\taccount_number='"+getAccountNumber()+"';");
		if(getCountryCenter() != null ){
 			stringBuilder.append("\tcountry_center='retail_store_country_center("+getCountryCenter().getId()+")';");
 		}
		if(getRetailStore() != null ){
 			stringBuilder.append("\tretail_store='retail_store("+getRetailStore().getId()+")';");
 		}
		if(getGoodsSupplier() != null ){
 			stringBuilder.append("\tgoods_supplier='goods_supplier("+getGoodsSupplier().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

