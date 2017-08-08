
package com.skynet.retailscm.accountingdocumentline;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingdocument.AccountingDocument;

@JsonSerialize(using = AccountingDocumentLineSerializer.class)
public class AccountingDocumentLine extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String DIRECT_PROPERTY                = "direct"            ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String ACCOUNTING_SUBJECT_PROPERTY    = "accountingSubject" ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mCode               ;
	protected		String              	mDirect             ;
	protected		double              	mAmount             ;
	protected		AccountingDocument  	mBelongsTo          ;
	protected		AccountingSubject   	mAccountingSubject  ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	AccountingDocumentLine(){
		//lazy load for all the properties
	}
	
	public 	AccountingDocumentLine(String name, String code, String direct, double amount, AccountingDocument belongsTo, AccountingSubject accountingSubject
)
	{
		setName(name);
		setCode(code);
		setDirect(direct);
		setAmount(amount);
		setBelongsTo(belongsTo);
		setAccountingSubject(accountingSubject);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(DIRECT_PROPERTY.equals(property)){
			changeDirectProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
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
			
			
			
	protected void changeCodeProperty(String newValueExpr){
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCode(newValue);
		//they are surely different each other
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDirectProperty(String newValueExpr){
		String oldValue = getDirect();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDirect(newValue);
		//they are surely different each other
		this.onChangeProperty(DIRECT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAmountProperty(String newValueExpr){
		double oldValue = getAmount();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAmount(newValue);
		//they are surely different each other
		this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
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
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	
	
	public void setDirect(String direct){
		this.mDirect = trimString(direct);;
	}
	public String getDirect(){
		return this.mDirect;
	}
	
	
	public void setAmount(double amount){
		this.mAmount = amount;;
	}
	public double getAmount(){
		return this.mAmount;
	}
	
	
	public void setBelongsTo(AccountingDocument belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public AccountingDocument getBelongsTo(){
		return this.mBelongsTo;
	}
	
	
	public void setAccountingSubject(AccountingSubject accountingSubject){
		this.mAccountingSubject = accountingSubject;;
	}
	public AccountingSubject getAccountingSubject(){
		return this.mAccountingSubject;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public AccountingDocumentLine copyTo(AccountingDocumentLine dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setCode(getCode());
		dest.setDirect(getDirect());
		dest.setAmount(getAmount());
		dest.setBelongsTo(getBelongsTo());
		dest.setAccountingSubject(getAccountingSubject());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("accounting_document_line{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		stringBuilder.append("\tdirect='"+getDirect()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongs_to='accounting_document("+getBelongsTo().getId()+")';");
 		}
		if(getAccountingSubject() != null ){
 			stringBuilder.append("\taccounting_subject='accounting_subject("+getAccountingSubject().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

