
package com.skynet.retailscm.employee;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeManager{

	public Employee createEmployee(RetailScmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount
) throws Exception;	
	public Employee updateEmployee(RetailScmUserContext userContext,String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public Employee transferToAnotherCompany(RetailScmUserContext userContext, String employeeId, String anotherCompanyId)  throws Exception;
 	public Employee transferToAnotherDepartment(RetailScmUserContext userContext, String employeeId, String anotherDepartmentId)  throws Exception;
 	public Employee transferToAnotherOccupation(RetailScmUserContext userContext, String employeeId, String anotherOccupationId)  throws Exception;
 	public Employee transferToAnotherResponsibleFor(RetailScmUserContext userContext, String employeeId, String anotherResponsibleForId)  throws Exception;
 	public Employee transferToAnotherCurrentSalaryGrade(RetailScmUserContext userContext, String employeeId, String anotherCurrentSalaryGradeId)  throws Exception;
 	public Employee applyJob(RetailScmUserContext userContext, String employeeId, Date applicationTime, String who, String comments
)  throws Exception;
	public Employee interviewWithProfession(RetailScmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
)  throws Exception;
	public Employee interviewByHr(RetailScmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
)  throws Exception;
	public Employee approveOffer(RetailScmUserContext userContext, String employeeId, String who, Date approveTime, String comments
)  throws Exception;
	public Employee acceptOffer(RetailScmUserContext userContext, String employeeId, String who, Date acceptTime, String comments
)  throws Exception;
	public Employee boardEmployee(RetailScmUserContext userContext, String employeeId, String who, Date employTime, String comments
)  throws Exception;
	public Employee terminate(RetailScmUserContext userContext, String employeeId, String reasonId, String typeId, String comment
)  throws Exception;


	public void delete(RetailScmUserContext userContext, String employeeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Employee addEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, String trainingId ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeSkill(RetailScmUserContext userContext, String employeeId, String skillTypeId, String description ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeSkill(RetailScmUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeSkill(RetailScmUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeePerformance(RetailScmUserContext userContext, String employeeId, String performanceComment ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeePerformance(RetailScmUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeePerformance(RetailScmUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, Date start, Date end, String company, String description ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeLeave(RetailScmUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeLeave(RetailScmUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeLeave(RetailScmUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeInterview(RetailScmUserContext userContext, String employeeId, String interviewTypeId, String remark ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeInterview(RetailScmUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeInterview(RetailScmUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeAttendance(RetailScmUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeAttendance(RetailScmUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeAttendance(RetailScmUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeQualifier(RetailScmUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeQualifier(RetailScmUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeQualifier(RetailScmUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeEducation(RetailScmUserContext userContext, String employeeId, Date completeTime, String type, String remark ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeEducation(RetailScmUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeEducation(RetailScmUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeAward(RetailScmUserContext userContext, String employeeId, Date completeTime, String type, String remark ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeAward(RetailScmUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeAward(RetailScmUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance ,String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Employee addPayingOff(RetailScmUserContext userContext, String employeeId, String who, Date paidTime, double amount ,String [] tokensExpr)  throws Exception;
	public  Employee removePayingOff(RetailScmUserContext userContext, String employeeId, String payingOffId, int payingOffVersion,String [] tokensExpr)  throws Exception;
	public  Employee updatePayingOff(RetailScmUserContext userContext, String employeeId, String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


