
package com.skynet.retailscm.accountingdocumentconfirmation;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class AccountingDocumentConfirmationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="accountingDocumentConfirmation";
	
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
	protected AccountingDocumentConfirmationTokens(){
		//ensure not initialized outside the class
	}
	
	public AccountingDocumentConfirmationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AccountingDocumentConfirmationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AccountingDocumentConfirmationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static AccountingDocumentConfirmationTokens start(){
		return new AccountingDocumentConfirmationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static AccountingDocumentConfirmationTokens allTokens(){
		
		return start()
			.withAccountingDocumentList();
	
	}
	protected static AccountingDocumentConfirmationTokens withoutListsTokens(){
		
		return start();
	
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

	protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	public String getAccountingDocumentList(){
		return ACCOUNTING_DOCUMENT_LIST;
	}
	public AccountingDocumentConfirmationTokens withAccountingDocumentList(){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
		return this;
	}	
		
}

