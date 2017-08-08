
package com.skynet.retailscm.originalvoucherconfirmation;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class OriginalVoucherConfirmationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="originalVoucherConfirmation";
	
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
	protected OriginalVoucherConfirmationTokens(){
		//ensure not initialized outside the class
	}
	
	public OriginalVoucherConfirmationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static OriginalVoucherConfirmationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected OriginalVoucherConfirmationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static OriginalVoucherConfirmationTokens start(){
		return new OriginalVoucherConfirmationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static OriginalVoucherConfirmationTokens allTokens(){
		
		return start()
			.withOriginalVoucherList();
	
	}
	protected static OriginalVoucherConfirmationTokens withoutListsTokens(){
		
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

	protected static final String ORIGINAL_VOUCHER_LIST = "originalVoucherList";
	public String getOriginalVoucherList(){
		return ORIGINAL_VOUCHER_LIST;
	}
	public OriginalVoucherConfirmationTokens withOriginalVoucherList(){		
		addSimpleOptions(ORIGINAL_VOUCHER_LIST);
		return this;
	}	
		
}

