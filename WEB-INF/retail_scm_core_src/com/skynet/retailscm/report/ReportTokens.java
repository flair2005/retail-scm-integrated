
package com.skynet.retailscm.report;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class ReportTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="report";
	
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
	protected ReportTokens(){
		//ensure not initialized outside the class
	}
	
	public ReportTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ReportTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ReportTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ReportTokens start(){
		return new ReportTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ReportTokens allTokens(){
		
		return start()
			.withOwner()
			.withReportLineList();
	
	}
	protected static ReportTokens withoutListsTokens(){
		
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
	public ReportTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
	protected static final String REPORT_LINE_LIST = "reportLineList";
	public String getReportLineList(){
		return REPORT_LINE_LIST;
	}
	public ReportTokens withReportLineList(){		
		addSimpleOptions(REPORT_LINE_LIST);
		return this;
	}	
		
}

