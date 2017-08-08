
package com.skynet.retailscm.employee;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class EmployeeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="employee";
	
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
	protected EmployeeTokens(){
		//ensure not initialized outside the class
	}
	
	public EmployeeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static EmployeeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected EmployeeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static EmployeeTokens start(){
		return new EmployeeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static EmployeeTokens allTokens(){
		
		return start()
			.withCompany()
			.withDepartment()
			.withOccupation()
			.withResponsibleFor()
			.withCurrentSalaryGrade()
			.withJobApplication()
			.withProfessionInterview()
			.withHrInterview()
			.withOfferApproval()
			.withOfferAcceptance()
			.withEmployeeBoarding()
			.withTermination()
			.withEmployeeCompanyTrainingList()
			.withEmployeeSkillList()
			.withEmployeePerformanceList()
			.withEmployeeWorkExperienceList()
			.withEmployeeLeaveList()
			.withEmployeeInterviewList()
			.withEmployeeAttendanceList()
			.withEmployeeQualifierList()
			.withEmployeeEducationList()
			.withEmployeeAwardList()
			.withEmployeeSalarySheetList()
			.withPayingOffList();
	
	}
	protected static EmployeeTokens withoutListsTokens(){
		
		return start()
			.withCompany()
			.withDepartment()
			.withOccupation()
			.withResponsibleFor()
			.withCurrentSalaryGrade()
			.withJobApplication()
			.withProfessionInterview()
			.withHrInterview()
			.withOfferApproval()
			.withOfferAcceptance()
			.withEmployeeBoarding()
			.withTermination();
	
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
	public EmployeeTokens withCompany(){		
		addSimpleOptions(COMPANY);
		return this;
	}
	
	
	protected static final String DEPARTMENT = "department";
	public String getDepartment(){
		return DEPARTMENT;
	}
	public EmployeeTokens withDepartment(){		
		addSimpleOptions(DEPARTMENT);
		return this;
	}
	
	
	protected static final String OCCUPATION = "occupation";
	public String getOccupation(){
		return OCCUPATION;
	}
	public EmployeeTokens withOccupation(){		
		addSimpleOptions(OCCUPATION);
		return this;
	}
	
	
	protected static final String RESPONSIBLEFOR = "responsibleFor";
	public String getResponsibleFor(){
		return RESPONSIBLEFOR;
	}
	public EmployeeTokens withResponsibleFor(){		
		addSimpleOptions(RESPONSIBLEFOR);
		return this;
	}
	
	
	protected static final String CURRENTSALARYGRADE = "currentSalaryGrade";
	public String getCurrentSalaryGrade(){
		return CURRENTSALARYGRADE;
	}
	public EmployeeTokens withCurrentSalaryGrade(){		
		addSimpleOptions(CURRENTSALARYGRADE);
		return this;
	}
	
	
	protected static final String JOBAPPLICATION = "jobApplication";
	public String getJobApplication(){
		return JOBAPPLICATION;
	}
	public EmployeeTokens withJobApplication(){		
		addSimpleOptions(JOBAPPLICATION);
		return this;
	}
	
	
	protected static final String PROFESSIONINTERVIEW = "professionInterview";
	public String getProfessionInterview(){
		return PROFESSIONINTERVIEW;
	}
	public EmployeeTokens withProfessionInterview(){		
		addSimpleOptions(PROFESSIONINTERVIEW);
		return this;
	}
	
	
	protected static final String HRINTERVIEW = "hrInterview";
	public String getHrInterview(){
		return HRINTERVIEW;
	}
	public EmployeeTokens withHrInterview(){		
		addSimpleOptions(HRINTERVIEW);
		return this;
	}
	
	
	protected static final String OFFERAPPROVAL = "offerApproval";
	public String getOfferApproval(){
		return OFFERAPPROVAL;
	}
	public EmployeeTokens withOfferApproval(){		
		addSimpleOptions(OFFERAPPROVAL);
		return this;
	}
	
	
	protected static final String OFFERACCEPTANCE = "offerAcceptance";
	public String getOfferAcceptance(){
		return OFFERACCEPTANCE;
	}
	public EmployeeTokens withOfferAcceptance(){		
		addSimpleOptions(OFFERACCEPTANCE);
		return this;
	}
	
	
	protected static final String EMPLOYEEBOARDING = "employeeBoarding";
	public String getEmployeeBoarding(){
		return EMPLOYEEBOARDING;
	}
	public EmployeeTokens withEmployeeBoarding(){		
		addSimpleOptions(EMPLOYEEBOARDING);
		return this;
	}
	
	
	protected static final String TERMINATION = "termination";
	public String getTermination(){
		return TERMINATION;
	}
	public EmployeeTokens withTermination(){		
		addSimpleOptions(TERMINATION);
		return this;
	}
	
	
	protected static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";
	public String getEmployeeCompanyTrainingList(){
		return EMPLOYEE_COMPANY_TRAINING_LIST;
	}
	public EmployeeTokens withEmployeeCompanyTrainingList(){		
		addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_SKILL_LIST = "employeeSkillList";
	public String getEmployeeSkillList(){
		return EMPLOYEE_SKILL_LIST;
	}
	public EmployeeTokens withEmployeeSkillList(){		
		addSimpleOptions(EMPLOYEE_SKILL_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_PERFORMANCE_LIST = "employeePerformanceList";
	public String getEmployeePerformanceList(){
		return EMPLOYEE_PERFORMANCE_LIST;
	}
	public EmployeeTokens withEmployeePerformanceList(){		
		addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_WORK_EXPERIENCE_LIST = "employeeWorkExperienceList";
	public String getEmployeeWorkExperienceList(){
		return EMPLOYEE_WORK_EXPERIENCE_LIST;
	}
	public EmployeeTokens withEmployeeWorkExperienceList(){		
		addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_LEAVE_LIST = "employeeLeaveList";
	public String getEmployeeLeaveList(){
		return EMPLOYEE_LEAVE_LIST;
	}
	public EmployeeTokens withEmployeeLeaveList(){		
		addSimpleOptions(EMPLOYEE_LEAVE_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_INTERVIEW_LIST = "employeeInterviewList";
	public String getEmployeeInterviewList(){
		return EMPLOYEE_INTERVIEW_LIST;
	}
	public EmployeeTokens withEmployeeInterviewList(){		
		addSimpleOptions(EMPLOYEE_INTERVIEW_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_ATTENDANCE_LIST = "employeeAttendanceList";
	public String getEmployeeAttendanceList(){
		return EMPLOYEE_ATTENDANCE_LIST;
	}
	public EmployeeTokens withEmployeeAttendanceList(){		
		addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_QUALIFIER_LIST = "employeeQualifierList";
	public String getEmployeeQualifierList(){
		return EMPLOYEE_QUALIFIER_LIST;
	}
	public EmployeeTokens withEmployeeQualifierList(){		
		addSimpleOptions(EMPLOYEE_QUALIFIER_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_EDUCATION_LIST = "employeeEducationList";
	public String getEmployeeEducationList(){
		return EMPLOYEE_EDUCATION_LIST;
	}
	public EmployeeTokens withEmployeeEducationList(){		
		addSimpleOptions(EMPLOYEE_EDUCATION_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_AWARD_LIST = "employeeAwardList";
	public String getEmployeeAwardList(){
		return EMPLOYEE_AWARD_LIST;
	}
	public EmployeeTokens withEmployeeAwardList(){		
		addSimpleOptions(EMPLOYEE_AWARD_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_SALARY_SHEET_LIST = "employeeSalarySheetList";
	public String getEmployeeSalarySheetList(){
		return EMPLOYEE_SALARY_SHEET_LIST;
	}
	public EmployeeTokens withEmployeeSalarySheetList(){		
		addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST);
		return this;
	}	
		
	protected static final String PAYING_OFF_LIST = "payingOffList";
	public String getPayingOffList(){
		return PAYING_OFF_LIST;
	}
	public EmployeeTokens withPayingOffList(){		
		addSimpleOptions(PAYING_OFF_LIST);
		return this;
	}	
		
}

