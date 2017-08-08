
package com.skynet.retailscm.accountingsubject;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;

@JsonSerialize(using = AccountingSubjectSerializer.class)
public class AccountingSubject extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String ACCOUNTING_SUBJECT_CODE_PROPERTY = "accountingSubjectCode";
	public static final String ACCOUNTING_SUBJECT_NAME_PROPERTY = "accountingSubjectName";
	public static final String ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY = "accountingSubjectClassCode";
	public static final String ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY = "accountingSubjectClassName";
	public static final String ACCOUNT_SET_PROPERTY           = "accountSet"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ACCOUNTING_DOCUMENT_LINE_LIST            = "accountingDocumentLineList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mAccountingSubjectCode;
	protected		String              	mAccountingSubjectName;
	protected		int                 	mAccountingSubjectClassCode;
	protected		String              	mAccountingSubjectClassName;
	protected		AccountSet          	mAccountSet         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AccountingDocumentLine>	mAccountingDocumentLineList;
	
		
	public 	AccountingSubject(){
		//lazy load for all the properties
	}
	
	public 	AccountingSubject(String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName, AccountSet accountSet
)
	{
		setAccountingSubjectCode(accountingSubjectCode);
		setAccountingSubjectName(accountingSubjectName);
		setAccountingSubjectClassCode(accountingSubjectClassCode);
		setAccountingSubjectClassName(accountingSubjectClassName);
		setAccountSet(accountSet);

		this.mAccountingDocumentLineList = new SmartList<AccountingDocumentLine>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(ACCOUNTING_SUBJECT_CODE_PROPERTY.equals(property)){
			changeAccountingSubjectCodeProperty(newValueExpr);
		}
		if(ACCOUNTING_SUBJECT_NAME_PROPERTY.equals(property)){
			changeAccountingSubjectNameProperty(newValueExpr);
		}
		if(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY.equals(property)){
			changeAccountingSubjectClassCodeProperty(newValueExpr);
		}
		if(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY.equals(property)){
			changeAccountingSubjectClassNameProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeAccountingSubjectCodeProperty(String newValueExpr){
		String oldValue = getAccountingSubjectCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAccountingSubjectCode(newValue);
		//they are surely different each other
		this.onChangeProperty(ACCOUNTING_SUBJECT_CODE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAccountingSubjectNameProperty(String newValueExpr){
		String oldValue = getAccountingSubjectName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAccountingSubjectName(newValue);
		//they are surely different each other
		this.onChangeProperty(ACCOUNTING_SUBJECT_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAccountingSubjectClassCodeProperty(String newValueExpr){
		int oldValue = getAccountingSubjectClassCode();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAccountingSubjectClassCode(newValue);
		//they are surely different each other
		this.onChangeProperty(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAccountingSubjectClassNameProperty(String newValueExpr){
		String oldValue = getAccountingSubjectClassName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAccountingSubjectClassName(newValue);
		//they are surely different each other
		this.onChangeProperty(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setAccountingSubjectCode(String accountingSubjectCode){
		this.mAccountingSubjectCode = trimString(accountingSubjectCode);;
	}
	public String getAccountingSubjectCode(){
		return this.mAccountingSubjectCode;
	}
	
	
	public void setAccountingSubjectName(String accountingSubjectName){
		this.mAccountingSubjectName = trimString(accountingSubjectName);;
	}
	public String getAccountingSubjectName(){
		return this.mAccountingSubjectName;
	}
	
	
	public void setAccountingSubjectClassCode(int accountingSubjectClassCode){
		this.mAccountingSubjectClassCode = accountingSubjectClassCode;;
	}
	public int getAccountingSubjectClassCode(){
		return this.mAccountingSubjectClassCode;
	}
	
	
	public void setAccountingSubjectClassName(String accountingSubjectClassName){
		this.mAccountingSubjectClassName = trimString(accountingSubjectClassName);;
	}
	public String getAccountingSubjectClassName(){
		return this.mAccountingSubjectClassName;
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
	
	
	public  SmartList<AccountingDocumentLine> getAccountingDocumentLineList(){
		if(this.mAccountingDocumentLineList == null){
			this.mAccountingDocumentLineList = new SmartList<AccountingDocumentLine>();
		}
		return this.mAccountingDocumentLineList;	
	}
	public  void setAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		for( AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			accountingDocumentLine.setAccountingSubject(this);
		}
		
		this.mAccountingDocumentLineList = accountingDocumentLineList;
		
	}
	
	public  void addAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
		accountingDocumentLine.setAccountingSubject(this);
		getAccountingDocumentLineList().add(accountingDocumentLine);
	}
	public  void addAccountingDocumentLines(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		for( AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			accountingDocumentLine.setAccountingSubject(this);
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
	
	
	
	
 	
	
	public AccountingSubject copyTo(AccountingSubject dest){

		dest.setId(getId());
		dest.setAccountingSubjectCode(getAccountingSubjectCode());
		dest.setAccountingSubjectName(getAccountingSubjectName());
		dest.setAccountingSubjectClassCode(getAccountingSubjectClassCode());
		dest.setAccountingSubjectClassName(getAccountingSubjectClassName());
		dest.setAccountSet(getAccountSet());
		dest.setVersion(getVersion());
		dest.setAccountingDocumentLineList(getAccountingDocumentLineList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("accounting_subject{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\taccounting_subject_code='"+getAccountingSubjectCode()+"';");
		stringBuilder.append("\taccounting_subject_name='"+getAccountingSubjectName()+"';");
		stringBuilder.append("\taccounting_subject_class_code='"+getAccountingSubjectClassCode()+"';");
		stringBuilder.append("\taccounting_subject_class_name='"+getAccountingSubjectClassName()+"';");
		if(getAccountSet() != null ){
 			stringBuilder.append("\taccount_set='account_set("+getAccountSet().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

