
package com.skynet.retailscm.interviewtype;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class InterviewTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="interviewType";
	
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
	protected InterviewTypeTokens(){
		//ensure not initialized outside the class
	}
	
	public InterviewTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static InterviewTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected InterviewTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static InterviewTypeTokens start(){
		return new InterviewTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static InterviewTypeTokens allTokens(){
		
		return start()
			.withCompany()
			.withEmployeeInterviewList();
	
	}
	protected static InterviewTypeTokens withoutListsTokens(){
		
		return start()
			.withCompany();
	
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

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	public InterviewTypeTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String EMPLOYEE_INTERVIEW_LIST = "employeeInterviewList";
	public String getEmployeeInterviewList(){
		return EMPLOYEE_INTERVIEW_LIST;
	}
	public InterviewTypeTokens withEmployeeInterviewList(){		
		addSimpleOptions(EMPLOYEE_INTERVIEW_LIST);
		return this;
	}	
		
}

