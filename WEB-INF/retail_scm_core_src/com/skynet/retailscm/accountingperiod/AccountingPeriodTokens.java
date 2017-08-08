
package com.skynet.retailscm.accountingperiod;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class AccountingPeriodTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="accountingPeriod";
	
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
	protected AccountingPeriodTokens(){
		//ensure not initialized outside the class
	}
	
	public AccountingPeriodTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AccountingPeriodTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AccountingPeriodTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static AccountingPeriodTokens start(){
		return new AccountingPeriodTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static AccountingPeriodTokens allTokens(){
		
		return start()
			.withAccountSet()
			.withAccountingDocumentList();
	
	}
	protected static AccountingPeriodTokens withoutListsTokens(){
		
		return start()
			.withAccountSet();
	
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

	protected static final String ACCOUNTSET = "accountSet";
	public String getAccountSet(){
		return ACCOUNTSET;
	}
	public AccountingPeriodTokens withAccountSet(){		
		addSimpleOptions(ACCOUNTSET);
		return this;
	}
	
	
	protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	public String getAccountingDocumentList(){
		return ACCOUNTING_DOCUMENT_LIST;
	}
	public AccountingPeriodTokens withAccountingDocumentList(){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
		return this;
	}	
		
}

