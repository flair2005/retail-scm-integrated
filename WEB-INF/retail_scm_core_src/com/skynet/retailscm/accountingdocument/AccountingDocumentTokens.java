
package com.skynet.retailscm.accountingdocument;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class AccountingDocumentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="accountingDocument";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected AccountingDocumentTokens(){
		//ensure not initialized outside the class
	}
	
	public AccountingDocumentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AccountingDocumentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AccountingDocumentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static AccountingDocumentTokens start(){
		return new AccountingDocumentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static AccountingDocumentTokens allTokens(){
		
		return start()
			.withAccountingPeriod()
			.withDocumentType()
			.withCreation()
			.withConfirmation()
			.withAuditing()
			.withPosting()
			.withOriginalVoucherList()
			.withAccountingDocumentLineList();
	
	}
	protected static AccountingDocumentTokens withoutListsTokens(){
		
		return start()
			.withAccountingPeriod()
			.withDocumentType()
			.withCreation()
			.withConfirmation()
			.withAuditing()
			.withPosting();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String ACCOUNTINGPERIOD = "accountingPeriod";
	public String getAccountingPeriod(){
		return ACCOUNTINGPERIOD;
	}
	public AccountingDocumentTokens withAccountingPeriod(){		
		addSimpleOptions(ACCOUNTINGPERIOD);
		return this;
	}
	
	
	protected static final String DOCUMENTTYPE = "documentType";
	public String getDocumentType(){
		return DOCUMENTTYPE;
	}
	public AccountingDocumentTokens withDocumentType(){		
		addSimpleOptions(DOCUMENTTYPE);
		return this;
	}
	
	
	protected static final String CREATION = "creation";
	public String getCreation(){
		return CREATION;
	}
	public AccountingDocumentTokens withCreation(){		
		addSimpleOptions(CREATION);
		return this;
	}
	
	
	protected static final String CONFIRMATION = "confirmation";
	public String getConfirmation(){
		return CONFIRMATION;
	}
	public AccountingDocumentTokens withConfirmation(){		
		addSimpleOptions(CONFIRMATION);
		return this;
	}
	
	
	protected static final String AUDITING = "auditing";
	public String getAuditing(){
		return AUDITING;
	}
	public AccountingDocumentTokens withAuditing(){		
		addSimpleOptions(AUDITING);
		return this;
	}
	
	
	protected static final String POSTING = "posting";
	public String getPosting(){
		return POSTING;
	}
	public AccountingDocumentTokens withPosting(){		
		addSimpleOptions(POSTING);
		return this;
	}
	
	
	protected static final String ORIGINAL_VOUCHER_LIST = "originalVoucherList";
	public String getOriginalVoucherList(){
		return ORIGINAL_VOUCHER_LIST;
	}
	public AccountingDocumentTokens withOriginalVoucherList(){		
		addSimpleOptions(ORIGINAL_VOUCHER_LIST);
		return this;
	}	
		
	protected static final String ACCOUNTING_DOCUMENT_LINE_LIST = "accountingDocumentLineList";
	public String getAccountingDocumentLineList(){
		return ACCOUNTING_DOCUMENT_LINE_LIST;
	}
	public AccountingDocumentTokens withAccountingDocumentLineList(){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LINE_LIST);
		return this;
	}	
		
}

