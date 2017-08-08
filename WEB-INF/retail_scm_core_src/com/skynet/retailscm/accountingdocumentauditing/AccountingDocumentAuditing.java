
package com.skynet.retailscm.accountingdocumentauditing;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.accountingdocument.AccountingDocument;

@JsonSerialize(using = AccountingDocumentAuditingSerializer.class)
public class AccountingDocumentAuditing extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String COMMENTS_PROPERTY              = "comments"          ;
	public static final String MAKE_DATE_PROPERTY             = "makeDate"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ACCOUNTING_DOCUMENT_LIST                 = "accountingDocumentList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		String              	mComments           ;
	protected		Date                	mMakeDate           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AccountingDocument>	mAccountingDocumentList;
	
		
	public 	AccountingDocumentAuditing(){
		//lazy load for all the properties
	}
	
	public 	AccountingDocumentAuditing(String who, String comments, Date makeDate
)
	{
		setWho(who);
		setComments(comments);
		setMakeDate(makeDate);

		this.mAccountingDocumentList = new SmartList<AccountingDocument>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(COMMENTS_PROPERTY.equals(property)){
			changeCommentsProperty(newValueExpr);
		}
		if(MAKE_DATE_PROPERTY.equals(property)){
			changeMakeDateProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeWhoProperty(String newValueExpr){
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setWho(newValue);
		//they are surely different each other
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeCommentsProperty(String newValueExpr){
		String oldValue = getComments();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setComments(newValue);
		//they are surely different each other
		this.onChangeProperty(COMMENTS_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMakeDateProperty(String newValueExpr){
		Date oldValue = getMakeDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMakeDate(newValue);
		//they are surely different each other
		this.onChangeProperty(MAKE_DATE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	
	
	public void setComments(String comments){
		this.mComments = trimString(comments);;
	}
	public String getComments(){
		return this.mComments;
	}
	
	
	public void setMakeDate(Date makeDate){
		this.mMakeDate = makeDate;;
	}
	public Date getMakeDate(){
		return this.mMakeDate;
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
			accountingDocument.setAuditing(this);
		}
		
		this.mAccountingDocumentList = accountingDocumentList;
		
	}
	
	public  void addAccountingDocument(AccountingDocument accountingDocument){
		accountingDocument.setAuditing(this);
		getAccountingDocumentList().add(accountingDocument);
	}
	public  void addAccountingDocuments(SmartList<AccountingDocument> accountingDocumentList){
		for( AccountingDocument accountingDocument:accountingDocumentList){
			accountingDocument.setAuditing(this);
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
	
	
	
	
 	
	
	public AccountingDocumentAuditing copyTo(AccountingDocumentAuditing dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setComments(getComments());
		dest.setMakeDate(getMakeDate());
		dest.setVersion(getVersion());
		dest.setAccountingDocumentList(getAccountingDocumentList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("accounting_document_auditing{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tcomments='"+getComments()+"';");
		stringBuilder.append("\tmake_date='"+getMakeDate()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

