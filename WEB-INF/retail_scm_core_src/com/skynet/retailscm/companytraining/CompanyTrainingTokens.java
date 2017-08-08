
package com.skynet.retailscm.companytraining;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class CompanyTrainingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="companyTraining";
	
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
	protected CompanyTrainingTokens(){
		//ensure not initialized outside the class
	}
	
	public CompanyTrainingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static CompanyTrainingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected CompanyTrainingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static CompanyTrainingTokens start(){
		return new CompanyTrainingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static CompanyTrainingTokens allTokens(){
		
		return start()
			.withCompany()
			.withInstructor()
			.withTrainingCourseType()
			.withEmployeeCompanyTrainingList();
	
	}
	protected static CompanyTrainingTokens withoutListsTokens(){
		
		return start()
			.withCompany()
			.withInstructor()
			.withTrainingCourseType();
	
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
	public CompanyTrainingTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String INSTRUCTOR = "instructor";
	public String getInstructor(){
		return INSTRUCTOR;
	}
	public CompanyTrainingTokens withInstructor(){		
		addSimpleOptions(INSTRUCTOR);
		return this;
	}
	
	
	protected static final String TRAININGCOURSETYPE = "trainingCourseType";
	public String getTrainingCourseType(){
		return TRAININGCOURSETYPE;
	}
	public CompanyTrainingTokens withTrainingCourseType(){		
		addSimpleOptions(TRAININGCOURSETYPE);
		return this;
	}
	
	
	protected static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";
	public String getEmployeeCompanyTrainingList(){
		return EMPLOYEE_COMPANY_TRAINING_LIST;
	}
	public CompanyTrainingTokens withEmployeeCompanyTrainingList(){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST);
		return this;
	}	
		
}

