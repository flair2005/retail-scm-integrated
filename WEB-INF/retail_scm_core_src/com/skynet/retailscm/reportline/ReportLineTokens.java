
package com.skynet.retailscm.reportline;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class ReportLineTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="reportLine";
	
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
	protected ReportLineTokens(){
		//ensure not initialized outside the class
	}
	
	public ReportLineTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ReportLineTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ReportLineTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ReportLineTokens start(){
		return new ReportLineTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ReportLineTokens allTokens(){
		
		return start()
			.withOwner();
	
	}
	protected static ReportLineTokens withoutListsTokens(){
		
		return start()
			.withOwner();
	
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

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	public ReportLineTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
}

