
package com.skynet.retailscm.salarygrade;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class SalaryGradeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="salaryGrade";
	
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
	protected SalaryGradeTokens(){
		//ensure not initialized outside the class
	}
	
	public SalaryGradeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SalaryGradeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SalaryGradeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SalaryGradeTokens start(){
		return new SalaryGradeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SalaryGradeTokens allTokens(){
		
		return start()
			.withCompany()
			.withEmployeeList()
			.withEmployeeSalarySheetList();
	
	}
	protected static SalaryGradeTokens withoutListsTokens(){
		
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
	public SalaryGradeTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String EMPLOYEE_LIST = "employeeList";
	public String getEmployeeList(){
		return EMPLOYEE_LIST;
	}
	public SalaryGradeTokens withEmployeeList(){		
		addSimpleOptions(EMPLOYEE_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_SALARY_SHEET_LIST = "employeeSalarySheetList";
	public String getEmployeeSalarySheetList(){
		return EMPLOYEE_SALARY_SHEET_LIST;
	}
	public SalaryGradeTokens withEmployeeSalarySheetList(){		
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST);
		return this;
	}	
		
}

