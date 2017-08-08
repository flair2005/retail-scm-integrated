
package com.skynet.retailscm.accountingperiod;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.accountingdocument.AccountingDocument;
import com.skynet.retailscm.accountset.AccountSet;

@JsonSerialize(using = AccountingPeriodSerializer.class)
public class AccountingPeriod extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String START_DATE_PROPERTY            = "startDate"         ;
	public static final String END_DATE_PROPERTY              = "endDate"           ;
	public static final String ACCOUNT_SET_PROPERTY           = "accountSet"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ACCOUNTING_DOCUMENT_LIST                 = "accountingDocumentList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Date                	mStartDate          ;
	protected		Date                	mEndDate            ;
	protected		AccountSet          	mAccountSet         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AccountingDocument>	mAccountingDocumentList;
	
		
	public 	AccountingPeriod(){
		//lazy load for all the properties
	}
	
	public 	AccountingPeriod(String name, Date startDate, Date endDate, AccountSet accountSet
)
	{
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
		setAccountSet(accountSet);

		this.mAccountingDocumentList = new SmartList<AccountingDocument>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(START_DATE_PROPERTY.equals(property)){
			changeStartDateProperty(newValueExpr);
		}
		if(END_DATE_PROPERTY.equals(property)){
			changeEndDateProperty(newValueExpr);
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
			
			
			
	protected void changeStartDateProperty(String newValueExpr){
		Date oldValue = getStartDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setStartDate(newValue);
		//they are surely different each other
		this.onChangeProperty(START_DATE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeEndDateProperty(String newValueExpr){
		Date oldValue = getEndDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setEndDate(newValue);
		//they are surely different each other
		this.onChangeProperty(END_DATE_PROPERTY, oldValue, newValue);
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
	
	
	public void setStartDate(Date startDate){
		this.mStartDate = startDate;;
	}
	public Date getStartDate(){
		return this.mStartDate;
	}
	
	
	public void setEndDate(Date endDate){
		this.mEndDate = endDate;;
	}
	public Date getEndDate(){
		return this.mEndDate;
	}
	
	
	public void setAccountSet(AccountSet accountSet){
		this.mAccountSet = accountSet;;
	}
	public AccountSet getAccountSet(){
		return this.mAccountSet;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<AccountingDocument> getAccountingDocumentList(){
		if(this.mAccountingDocumentList == null){
			this.mAccountingDocumentList = new SmartList<AccountingDocument>();
		}
		return this.mAccountingDocumentList;	
	}
	public  void setAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList){
		for( AccountingDocument accountingDocument:accountingDocumentList){
			accountingDocument.setAccountingPeriod(this);
		}
		
		this.mAccountingDocumentList = accountingDocumentList;
		
	}
	
	public  void addAccountingDocument(AccountingDocument accountingDocument){
		accountingDocument.setAccountingPeriod(this);
		getAccountingDocumentList().add(accountingDocument);
	}
	public  void addAccountingDocuments(SmartList<AccountingDocument> accountingDocumentList){
		for( AccountingDocument accountingDocument:accountingDocumentList){
			accountingDocument.setAccountingPeriod(this);
		}
		getAccountingDocumentList().addAll(accountingDocumentList);
	}
	
	public  void removeAccountingDocument(AccountingDocument accountingDocument){
	
		boolean result = getAccountingDocumentList().planToRemove(accountingDocument);
        if(!result){
        	String message = "AccountingDocument("+accountingDocument.getId()+") with version='"+accountingDocument.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveAccountingDocumentList", accountingDocument);
		//the constant "toAccountingDocument" will be replaced after refactoried.
	
	}
	
	public void copyAccountingDocumentFrom(AccountingDocument accountingDocument) {
		// TODO Auto-generated method stub
		
        AccountingDocument accountingDocumentInList = findTheAccountingDocument(accountingDocument);
        AccountingDocument newAccountingDocument = new AccountingDocument();
        accountingDocumentInList.copyTo(newAccountingDocument);
        newAccountingDocument.setVersion(0);//will trigger copy
        getAccountingDocumentList().add(newAccountingDocument);
	}
	
	public  AccountingDocument findTheAccountingDocument(AccountingDocument accountingDocument){
		
		int index =  getAccountingDocumentList().indexOf(accountingDocument);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "AccountingDocument("+accountingDocument.getId()+") with version='"+accountingDocument.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getAccountingDocumentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingDocumentList(){
		getAccountingDocumentList().clear();
	}
	
	
	
	
 	
	
	public AccountingPeriod copyTo(AccountingPeriod dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setStartDate(getStartDate());
		dest.setEndDate(getEndDate());
		dest.setAccountSet(getAccountSet());
		dest.setVersion(getVersion());
		dest.setAccountingDocumentList(getAccountingDocumentList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("accounting_period{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tstart_date='"+getStartDate()+"';");
		stringBuilder.append("\tend_date='"+getEndDate()+"';");
		if(getAccountSet() != null ){
 			stringBuilder.append("\taccount_set='account_set("+getAccountSet().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

