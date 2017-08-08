
package com.skynet.retailscm.accountingdocumenttype;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.accountingdocument.AccountingDocument;
import com.skynet.retailscm.accountset.AccountSet;

@JsonSerialize(using = AccountingDocumentTypeSerializer.class)
public class AccountingDocumentType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String ACCOUNTING_PERIOD_PROPERTY     = "accountingPeriod"  ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ACCOUNTING_DOCUMENT_LIST                 = "accountingDocumentList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		AccountSet          	mAccountingPeriod   ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AccountingDocument>	mAccountingDocumentList;
	
		
	public 	AccountingDocumentType(){
		//lazy load for all the properties
	}
	
	public 	AccountingDocumentType(String name, String description, AccountSet accountingPeriod
)
	{
		setName(name);
		setDescription(description);
		setAccountingPeriod(accountingPeriod);

		this.mAccountingDocumentList = new SmartList<AccountingDocument>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDescription(newValue);
		//they are surely different each other
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
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
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	
	
	public void setAccountingPeriod(AccountSet accountingPeriod){
		this.mAccountingPeriod = accountingPeriod;;
	}
	public AccountSet getAccountingPeriod(){
		return this.mAccountingPeriod;
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
			accountingDocument.setDocumentType(this);
		}
		
		this.mAccountingDocumentList = accountingDocumentList;
		
	}
	
	public  void addAccountingDocument(AccountingDocument accountingDocument){
		accountingDocument.setDocumentType(this);
		getAccountingDocumentList().add(accountingDocument);
	}
	public  void addAccountingDocuments(SmartList<AccountingDocument> accountingDocumentList){
		for( AccountingDocument accountingDocument:accountingDocumentList){
			accountingDocument.setDocumentType(this);
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
	
	
	
	
 	
	
	public AccountingDocumentType copyTo(AccountingDocumentType dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setDescription(getDescription());
		dest.setAccountingPeriod(getAccountingPeriod());
		dest.setVersion(getVersion());
		dest.setAccountingDocumentList(getAccountingDocumentList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("accounting_document_type{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		if(getAccountingPeriod() != null ){
 			stringBuilder.append("\taccounting_period='account_set("+getAccountingPeriod().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

