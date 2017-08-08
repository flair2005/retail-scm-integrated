
package com.skynet.retailscm.accountingdocument;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.skynet.retailscm.originalvoucher.OriginalVoucher;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPosting;

@JsonSerialize(using = AccountingDocumentSerializer.class)
public class AccountingDocument extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String ACCOUNTING_DOCUMENT_DATE_PROPERTY = "accountingDocumentDate";
	public static final String ACCOUNTING_PERIOD_PROPERTY     = "accountingPeriod"  ;
	public static final String DOCUMENT_TYPE_PROPERTY         = "documentType"      ;
	public static final String CREATION_PROPERTY              = "creation"          ;
	public static final String CONFIRMATION_PROPERTY          = "confirmation"      ;
	public static final String AUDITING_PROPERTY              = "auditing"          ;
	public static final String POSTING_PROPERTY               = "posting"           ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ORIGINAL_VOUCHER_LIST                    = "originalVoucherList";
	public static final String ACCOUNTING_DOCUMENT_LINE_LIST            = "accountingDocumentLineList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Date                	mAccountingDocumentDate;
	protected		AccountingPeriod    	mAccountingPeriod   ;
	protected		AccountingDocumentType	mDocumentType       ;
	protected		AccountingDocumentCreation	mCreation           ;
	protected		AccountingDocumentConfirmation	mConfirmation       ;
	protected		AccountingDocumentAuditing	mAuditing           ;
	protected		AccountingDocumentPosting	mPosting            ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<OriginalVoucher>	mOriginalVoucherList;
	protected		SmartList<AccountingDocumentLine>	mAccountingDocumentLineList;
	
		
	public 	AccountingDocument(){
		//lazy load for all the properties
	}
	
	public 	AccountingDocument(String name, Date accountingDocumentDate, AccountingPeriod accountingPeriod, AccountingDocumentType documentType, String currentStatus
)
	{
		setName(name);
		setAccountingDocumentDate(accountingDocumentDate);
		setAccountingPeriod(accountingPeriod);
		setDocumentType(documentType);
		setCurrentStatus(currentStatus);

		this.mOriginalVoucherList = new SmartList<OriginalVoucher>();
		this.mAccountingDocumentLineList = new SmartList<AccountingDocumentLine>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			changeAccountingDocumentDateProperty(newValueExpr);
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
			
			
			
	protected void changeAccountingDocumentDateProperty(String newValueExpr){
		Date oldValue = getAccountingDocumentDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAccountingDocumentDate(newValue);
		//they are surely different each other
		this.onChangeProperty(ACCOUNTING_DOCUMENT_DATE_PROPERTY, oldValue, newValue);
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
	
	
	public void setAccountingDocumentDate(Date accountingDocumentDate){
		this.mAccountingDocumentDate = accountingDocumentDate;;
	}
	public Date getAccountingDocumentDate(){
		return this.mAccountingDocumentDate;
	}
	
	
	public void setAccountingPeriod(AccountingPeriod accountingPeriod){
		this.mAccountingPeriod = accountingPeriod;;
	}
	public AccountingPeriod getAccountingPeriod(){
		return this.mAccountingPeriod;
	}
	
	
	public void setDocumentType(AccountingDocumentType documentType){
		this.mDocumentType = documentType;;
	}
	public AccountingDocumentType getDocumentType(){
		return this.mDocumentType;
	}
	
	
	public void setCreation(AccountingDocumentCreation creation){
		this.mCreation = creation;;
	}
	public AccountingDocumentCreation getCreation(){
		return this.mCreation;
	}
	
	
	public void setConfirmation(AccountingDocumentConfirmation confirmation){
		this.mConfirmation = confirmation;;
	}
	public AccountingDocumentConfirmation getConfirmation(){
		return this.mConfirmation;
	}
	
	
	public void setAuditing(AccountingDocumentAuditing auditing){
		this.mAuditing = auditing;;
	}
	public AccountingDocumentAuditing getAuditing(){
		return this.mAuditing;
	}
	
	
	public void setPosting(AccountingDocumentPosting posting){
		this.mPosting = posting;;
	}
	public AccountingDocumentPosting getPosting(){
		return this.mPosting;
	}
	
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<OriginalVoucher> getOriginalVoucherList(){
		if(this.mOriginalVoucherList == null){
			this.mOriginalVoucherList = new SmartList<OriginalVoucher>();
		}
		return this.mOriginalVoucherList;	
	}
	public  void setOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setBelongsTo(this);
		}
		
		this.mOriginalVoucherList = originalVoucherList;
		
	}
	
	public  void addOriginalVoucher(OriginalVoucher originalVoucher){
		originalVoucher.setBelongsTo(this);
		getOriginalVoucherList().add(originalVoucher);
	}
	public  void addOriginalVouchers(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setBelongsTo(this);
		}
		getOriginalVoucherList().addAll(originalVoucherList);
	}
	
	public  void removeOriginalVoucher(OriginalVoucher originalVoucher){
	
		boolean result = getOriginalVoucherList().planToRemove(originalVoucher);
        if(!result){
        	String message = "OriginalVoucher("+originalVoucher.getId()+") with version='"+originalVoucher.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveOriginalVoucherList", originalVoucher);
		//the constant "toOriginalVoucher" will be replaced after refactoried.
	
	}
	
	public void copyOriginalVoucherFrom(OriginalVoucher originalVoucher) {
		// TODO Auto-generated method stub
		
        OriginalVoucher originalVoucherInList = findTheOriginalVoucher(originalVoucher);
        OriginalVoucher newOriginalVoucher = new OriginalVoucher();
        originalVoucherInList.copyTo(newOriginalVoucher);
        newOriginalVoucher.setVersion(0);//will trigger copy
        getOriginalVoucherList().add(newOriginalVoucher);
	}
	
	public  OriginalVoucher findTheOriginalVoucher(OriginalVoucher originalVoucher){
		
		int index =  getOriginalVoucherList().indexOf(originalVoucher);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "OriginalVoucher("+originalVoucher.getId()+") with version='"+originalVoucher.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getOriginalVoucherList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpOriginalVoucherList(){
		getOriginalVoucherList().clear();
	}
	
	
	
	
	public  SmartList<AccountingDocumentLine> getAccountingDocumentLineList(){
		if(this.mAccountingDocumentLineList == null){
			this.mAccountingDocumentLineList = new SmartList<AccountingDocumentLine>();
		}
		return this.mAccountingDocumentLineList;	
	}
	public  void setAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		for( AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			accountingDocumentLine.setBelongsTo(this);
		}
		
		this.mAccountingDocumentLineList = accountingDocumentLineList;
		
	}
	
	public  void addAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
		accountingDocumentLine.setBelongsTo(this);
		getAccountingDocumentLineList().add(accountingDocumentLine);
	}
	public  void addAccountingDocumentLines(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		for( AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			accountingDocumentLine.setBelongsTo(this);
		}
		getAccountingDocumentLineList().addAll(accountingDocumentLineList);
	}
	
	public  void removeAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
	
		boolean result = getAccountingDocumentLineList().planToRemove(accountingDocumentLine);
        if(!result){
        	String message = "AccountingDocumentLine("+accountingDocumentLine.getId()+") with version='"+accountingDocumentLine.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveAccountingDocumentLineList", accountingDocumentLine);
		//the constant "toAccountingDocumentLine" will be replaced after refactoried.
	
	}
	
	public void copyAccountingDocumentLineFrom(AccountingDocumentLine accountingDocumentLine) {
		// TODO Auto-generated method stub
		
        AccountingDocumentLine accountingDocumentLineInList = findTheAccountingDocumentLine(accountingDocumentLine);
        AccountingDocumentLine newAccountingDocumentLine = new AccountingDocumentLine();
        accountingDocumentLineInList.copyTo(newAccountingDocumentLine);
        newAccountingDocumentLine.setVersion(0);//will trigger copy
        getAccountingDocumentLineList().add(newAccountingDocumentLine);
	}
	
	public  AccountingDocumentLine findTheAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
		
		int index =  getAccountingDocumentLineList().indexOf(accountingDocumentLine);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "AccountingDocumentLine("+accountingDocumentLine.getId()+") with version='"+accountingDocumentLine.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getAccountingDocumentLineList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingDocumentLineList(){
		getAccountingDocumentLineList().clear();
	}
	
	
	
	
 	
	
	public AccountingDocument copyTo(AccountingDocument dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setAccountingDocumentDate(getAccountingDocumentDate());
		dest.setAccountingPeriod(getAccountingPeriod());
		dest.setDocumentType(getDocumentType());
		dest.setCreation(getCreation());
		dest.setConfirmation(getConfirmation());
		dest.setAuditing(getAuditing());
		dest.setPosting(getPosting());
		dest.setCurrentStatus(getCurrentStatus());
		dest.setVersion(getVersion());
		dest.setOriginalVoucherList(getOriginalVoucherList());
		dest.setAccountingDocumentLineList(getAccountingDocumentLineList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("accounting_document{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\taccounting_document_date='"+getAccountingDocumentDate()+"';");
		if(getAccountingPeriod() != null ){
 			stringBuilder.append("\taccounting_period='accounting_period("+getAccountingPeriod().getId()+")';");
 		}
		if(getDocumentType() != null ){
 			stringBuilder.append("\tdocument_type='accounting_document_type("+getDocumentType().getId()+")';");
 		}
		if(getCreation() != null ){
 			stringBuilder.append("\tcreation='accounting_document_creation("+getCreation().getId()+")';");
 		}
		if(getConfirmation() != null ){
 			stringBuilder.append("\tconfirmation='accounting_document_confirmation("+getConfirmation().getId()+")';");
 		}
		if(getAuditing() != null ){
 			stringBuilder.append("\tauditing='accounting_document_auditing("+getAuditing().getId()+")';");
 		}
		if(getPosting() != null ){
 			stringBuilder.append("\tposting='accounting_document_posting("+getPosting().getId()+")';");
 		}
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

