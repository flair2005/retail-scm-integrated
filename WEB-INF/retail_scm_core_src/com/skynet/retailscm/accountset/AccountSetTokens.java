
package com.skynet.retailscm.accountset;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class AccountSetTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="accountSet";
	
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
	protected AccountSetTokens(){
		//ensure not initialized outside the class
	}
	
	public AccountSetTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AccountSetTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AccountSetTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static AccountSetTokens start(){
		return new AccountSetTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static AccountSetTokens allTokens(){
		
		return start()
			.withCountryCenter()
			.withRetailStore()
			.withGoodsSupplier()
			.withAccountingSubjectList()
			.withAccountingPeriodList()
			.withAccountingDocumentTypeList();
	
	}
	protected static AccountSetTokens withoutListsTokens(){
		
		return start()
			.withCountryCenter()
			.withRetailStore()
			.withGoodsSupplier();
	
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

	protected static final String COUNTRYCENTER = "countryCenter";
	public String getCountryCenter(){
		return COUNTRYCENTER;
	}
	public AccountSetTokens withCountryCenter(){		
		addSimpleOptions(COUNTRYCENTER);
		return this;
	}
	
	
	protected static final String RETAILSTORE = "retailStore";
	public String getRetailStore(){
		return RETAILSTORE;
	}
	public AccountSetTokens withRetailStore(){		
		addSimpleOptions(RETAILSTORE);
		return this;
	}
	
	
	protected static final String GOODSSUPPLIER = "goodsSupplier";
	public String getGoodsSupplier(){
		return GOODSSUPPLIER;
	}
	public AccountSetTokens withGoodsSupplier(){		
		addSimpleOptions(GOODSSUPPLIER);
		return this;
	}
	
	
	protected static final String ACCOUNTING_SUBJECT_LIST = "accountingSubjectList";
	public String getAccountingSubjectList(){
		return ACCOUNTING_SUBJECT_LIST;
	}
	public AccountSetTokens withAccountingSubjectList(){		
		addSimpleOptions(ACCOUNTING_SUBJECT_LIST);
		return this;
	}	
		
	protected static final String ACCOUNTING_PERIOD_LIST = "accountingPeriodList";
	public String getAccountingPeriodList(){
		return ACCOUNTING_PERIOD_LIST;
	}
	public AccountSetTokens withAccountingPeriodList(){		
		addSimpleOptions(ACCOUNTING_PERIOD_LIST);
		return this;
	}	
		
	protected static final String ACCOUNTING_DOCUMENT_TYPE_LIST = "accountingDocumentTypeList";
	public String getAccountingDocumentTypeList(){
		return ACCOUNTING_DOCUMENT_TYPE_LIST;
	}
	public AccountSetTokens withAccountingDocumentTypeList(){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_TYPE_LIST);
		return this;
	}	
		
}

