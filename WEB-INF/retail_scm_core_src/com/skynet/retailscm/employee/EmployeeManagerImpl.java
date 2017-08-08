
package com.skynet.retailscm.employee;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.termination.Termination;
import com.skynet.retailscm.offeracceptance.OfferAcceptance;
import com.skynet.retailscm.employeeinterview.EmployeeInterview;
import com.skynet.retailscm.employeeperformance.EmployeePerformance;
import com.skynet.retailscm.professioninterview.ProfessionInterview;
import com.skynet.retailscm.offerapproval.OfferApproval;
import com.skynet.retailscm.employeeleave.EmployeeLeave;
import com.skynet.retailscm.employeeattendance.EmployeeAttendance;
import com.skynet.retailscm.employeeskill.EmployeeSkill;
import com.skynet.retailscm.employeequalifier.EmployeeQualifier;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.hrinterview.HrInterview;
import com.skynet.retailscm.employeeboarding.EmployeeBoarding;
import com.skynet.retailscm.occupationtype.OccupationType;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.employeeeducation.EmployeeEducation;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.employeeaward.EmployeeAward;
import com.skynet.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.responsibilitytype.ResponsibilityType;
import com.skynet.retailscm.salarygrade.SalaryGrade;
import com.skynet.retailscm.jobapplication.JobApplication;

import com.skynet.retailscm.jobapplication.JobApplicationDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartmentDAO;
import com.skynet.retailscm.professioninterview.ProfessionInterviewDAO;
import com.skynet.retailscm.offerapproval.OfferApprovalDAO;
import com.skynet.retailscm.offeracceptance.OfferAcceptanceDAO;
import com.skynet.retailscm.responsibilitytype.ResponsibilityTypeDAO;
import com.skynet.retailscm.salarygrade.SalaryGradeDAO;
import com.skynet.retailscm.hrinterview.HrInterviewDAO;
import com.skynet.retailscm.termination.TerminationDAO;
import com.skynet.retailscm.occupationtype.OccupationTypeDAO;
import com.skynet.retailscm.employeeboarding.EmployeeBoardingDAO;

import com.skynet.retailscm.scoring.Scoring;
import com.skynet.retailscm.skilltype.SkillType;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.interviewtype.InterviewType;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.salarygrade.SalaryGrade;
import com.skynet.retailscm.leavetype.LeaveType;

import com.skynet.retailscm.terminationreason.TerminationReason;
import com.skynet.retailscm.terminationtype.TerminationType;
import com.skynet.retailscm.terminationreason.TerminationReasonDAO;
import com.skynet.retailscm.terminationtype.TerminationTypeDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.jobapplication.JobApplicationTable;
import com.skynet.retailscm.employeeaward.EmployeeAwardTable;
import com.skynet.retailscm.employeeperformance.EmployeePerformanceTable;
import com.skynet.retailscm.employeeinterview.EmployeeInterviewTable;
import com.skynet.retailscm.salarygrade.SalaryGradeTable;
import com.skynet.retailscm.offeracceptance.OfferAcceptanceTable;
import com.skynet.retailscm.hrinterview.HrInterviewTable;
import com.skynet.retailscm.offerapproval.OfferApprovalTable;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTrainingTable;
import com.skynet.retailscm.employeeworkexperience.EmployeeWorkExperienceTable;
import com.skynet.retailscm.employeeeducation.EmployeeEducationTable;
import com.skynet.retailscm.employeeskill.EmployeeSkillTable;
import com.skynet.retailscm.occupationtype.OccupationTypeTable;
import com.skynet.retailscm.professioninterview.ProfessionInterviewTable;
import com.skynet.retailscm.termination.TerminationTable;
import com.skynet.retailscm.responsibilitytype.ResponsibilityTypeTable;
import com.skynet.retailscm.employeeattendance.EmployeeAttendanceTable;
import com.skynet.retailscm.employeeboarding.EmployeeBoardingTable;
import com.skynet.retailscm.employeequalifier.EmployeeQualifierTable;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartmentTable;
import com.skynet.retailscm.employeeleave.EmployeeLeaveTable;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheetTable;
import com.skynet.retailscm.payingoff.PayingOffTable;




public class EmployeeManagerImpl extends RetailScmCheckerManager implements EmployeeManager {
	
	private static final String SERVICE_TYPE = "Employee";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO  employeeDAO){
 	
 		if(employeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The EmployeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeDAO;
 	}
 	
 	protected Employee saveEmployee(RetailScmUserContext userContext, Employee employee, String [] tokensExpr) throws Exception{	
 		//return getEmployeeDAO().save(employee, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployee(userContext, employee, tokens);
 	}
 	
 	protected Employee saveEmployeeDetail(RetailScmUserContext userContext, Employee employee) throws Exception{	

 		
 		return saveEmployee(userContext, employee, allTokens());
 	}
 	
 	public Employee loadEmployee(RetailScmUserContext userContext, String employeeId, String [] tokensExpr) throws Exception{				
 
 		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Employee employee = loadEmployee( userContext, employeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employee, tokens);
 	}
 	
 	protected Employee present(RetailScmUserContext userContext, Employee employee, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employee,tokens);
		
		
		return this.getEmployeeDAO().present(employee, tokens);
	}
 
 	
 	
 	public Employee loadEmployeeDetail(RetailScmUserContext userContext, String employeeId) throws Exception{	
 		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Employee employee = loadEmployee( userContext, employeeId, allTokens());

 		return present(userContext,employee, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeId) throws Exception{	
 		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Employee employee = loadEmployee( userContext, employeeId, allTokens());

 		return present(userContext,employee, allTokens());
		
 	}
 	protected Employee saveEmployee(RetailScmUserContext userContext, Employee employee, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeDAO().save(employee, tokens);
 	}
 	protected Employee loadEmployee(RetailScmUserContext userContext, String employeeId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeDAO().load(employeeId, tokens);
 	}

	



 	 
 	
 	private  TerminationDAO  terminationDAO;
 	public void setTerminationDAO(TerminationDAO terminationDAO){
	 	this.terminationDAO = terminationDAO;
 	}
 	//------------------------------------
 	public TerminationDAO getTerminationDAO(){
	 	return this.terminationDAO;
 	}
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  OfferAcceptanceDAO  offerAcceptanceDAO;
 	public void setOfferAcceptanceDAO(OfferAcceptanceDAO offerAcceptanceDAO){
	 	this.offerAcceptanceDAO = offerAcceptanceDAO;
 	}
 	//------------------------------------
 	public OfferAcceptanceDAO getOfferAcceptanceDAO(){
	 	return this.offerAcceptanceDAO;
 	}
 
 	
 	private  OfferApprovalDAO  offerApprovalDAO;
 	public void setOfferApprovalDAO(OfferApprovalDAO offerApprovalDAO){
	 	this.offerApprovalDAO = offerApprovalDAO;
 	}
 	//------------------------------------
 	public OfferApprovalDAO getOfferApprovalDAO(){
	 	return this.offerApprovalDAO;
 	}
 
 	
 	private  TerminationReasonDAO  terminationReasonDAO;
 	public void setTerminationReasonDAO(TerminationReasonDAO terminationReasonDAO){
	 	this.terminationReasonDAO = terminationReasonDAO;
 	}
 	//------------------------------------
 	public TerminationReasonDAO getTerminationReasonDAO(){
	 	return this.terminationReasonDAO;
 	}
 
 	
 	private  HrInterviewDAO  hrInterviewDAO;
 	public void setHrInterviewDAO(HrInterviewDAO hrInterviewDAO){
	 	this.hrInterviewDAO = hrInterviewDAO;
 	}
 	//------------------------------------
 	public HrInterviewDAO getHrInterviewDAO(){
	 	return this.hrInterviewDAO;
 	}
 
 	
 	private  ResponsibilityTypeDAO  responsibilityTypeDAO;
 	public void setResponsibilityTypeDAO(ResponsibilityTypeDAO responsibilityTypeDAO){
	 	this.responsibilityTypeDAO = responsibilityTypeDAO;
 	}
 	//------------------------------------
 	public ResponsibilityTypeDAO getResponsibilityTypeDAO(){
	 	return this.responsibilityTypeDAO;
 	}
 
 	
 	private  SalaryGradeDAO  salaryGradeDAO;
 	public void setSalaryGradeDAO(SalaryGradeDAO salaryGradeDAO){
	 	this.salaryGradeDAO = salaryGradeDAO;
 	}
 	//------------------------------------
 	public SalaryGradeDAO getSalaryGradeDAO(){
	 	return this.salaryGradeDAO;
 	}
 
 	
 	private  TerminationTypeDAO  terminationTypeDAO;
 	public void setTerminationTypeDAO(TerminationTypeDAO terminationTypeDAO){
	 	this.terminationTypeDAO = terminationTypeDAO;
 	}
 	//------------------------------------
 	public TerminationTypeDAO getTerminationTypeDAO(){
	 	return this.terminationTypeDAO;
 	}
 
 	
 	private  LevelThreeDepartmentDAO  levelThreeDepartmentDAO;
 	public void setLevelThreeDepartmentDAO(LevelThreeDepartmentDAO levelThreeDepartmentDAO){
	 	this.levelThreeDepartmentDAO = levelThreeDepartmentDAO;
 	}
 	//------------------------------------
 	public LevelThreeDepartmentDAO getLevelThreeDepartmentDAO(){
	 	return this.levelThreeDepartmentDAO;
 	}
 
 	
 	private  OccupationTypeDAO  occupationTypeDAO;
 	public void setOccupationTypeDAO(OccupationTypeDAO occupationTypeDAO){
	 	this.occupationTypeDAO = occupationTypeDAO;
 	}
 	//------------------------------------
 	public OccupationTypeDAO getOccupationTypeDAO(){
	 	return this.occupationTypeDAO;
 	}
 
 	
 	private  JobApplicationDAO  jobApplicationDAO;
 	public void setJobApplicationDAO(JobApplicationDAO jobApplicationDAO){
	 	this.jobApplicationDAO = jobApplicationDAO;
 	}
 	//------------------------------------
 	public JobApplicationDAO getJobApplicationDAO(){
	 	return this.jobApplicationDAO;
 	}
 
 	
 	private  ProfessionInterviewDAO  professionInterviewDAO;
 	public void setProfessionInterviewDAO(ProfessionInterviewDAO professionInterviewDAO){
	 	this.professionInterviewDAO = professionInterviewDAO;
 	}
 	//------------------------------------
 	public ProfessionInterviewDAO getProfessionInterviewDAO(){
	 	return this.professionInterviewDAO;
 	}
 
 	
 	private  EmployeeBoardingDAO  employeeBoardingDAO;
 	public void setEmployeeBoardingDAO(EmployeeBoardingDAO employeeBoardingDAO){
	 	this.employeeBoardingDAO = employeeBoardingDAO;
 	}
 	//------------------------------------
 	public EmployeeBoardingDAO getEmployeeBoardingDAO(){
	 	return this.employeeBoardingDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Employee employee, Map<String, Object> tokens){
		super.addActions(userContext, employee, tokens);
		
		addAction(userContext, employee, tokens,"@create","createEmployee","createEmployee/","main","primary");
		addAction(userContext, employee, tokens,"@update","updateEmployee","updateEmployee/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"@copy","cloneEmployee","cloneEmployee/"+employee.getId()+"/","main","primary");
		
		addAction(userContext, employee, tokens,"employee.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.transfer_to_department","transferToAnotherDepartment","transferToAnotherDepartment/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.transfer_to_occupation","transferToAnotherOccupation","transferToAnotherOccupation/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.transfer_to_responsible_for","transferToAnotherResponsibleFor","transferToAnotherResponsibleFor/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.transfer_to_current_salary_grade","transferToAnotherCurrentSalaryGrade","transferToAnotherCurrentSalaryGrade/"+employee.getId()+"/","main","primary");
		addAction(userContext, employee, tokens,"employee.applyJob","applyJob","applyJob/"+employee.getId()+"/","main","info");
		addAction(userContext, employee, tokens,"employee.interviewWithProfession","interviewWithProfession","interviewWithProfession/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.interviewByHr","interviewByHr","interviewByHr/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.approveOffer","approveOffer","approveOffer/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.acceptOffer","acceptOffer","acceptOffer/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.boardEmployee","boardEmployee","boardEmployee/"+employee.getId()+"/","main","success");
		addAction(userContext, employee, tokens,"employee.terminate","terminate","terminate/"+employee.getId()+"/","main","danger");
		addAction(userContext, employee, tokens,"employee.addEmployeeCompanyTraining","addEmployeeCompanyTraining","addEmployeeCompanyTraining/"+employee.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeCompanyTraining","removeEmployeeCompanyTraining","removeEmployeeCompanyTraining/"+employee.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeCompanyTraining","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+employee.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom/"+employee.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeSkill","addEmployeeSkill","addEmployeeSkill/"+employee.getId()+"/","employeeSkillList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeSkill","removeEmployeeSkill","removeEmployeeSkill/"+employee.getId()+"/","employeeSkillList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeSkill","updateEmployeeSkill","updateEmployeeSkill/"+employee.getId()+"/","employeeSkillList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeSkillFrom","copyEmployeeSkillFrom","copyEmployeeSkillFrom/"+employee.getId()+"/","employeeSkillList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeePerformance","addEmployeePerformance","addEmployeePerformance/"+employee.getId()+"/","employeePerformanceList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeePerformance","removeEmployeePerformance","removeEmployeePerformance/"+employee.getId()+"/","employeePerformanceList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeePerformance","updateEmployeePerformance","updateEmployeePerformance/"+employee.getId()+"/","employeePerformanceList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeePerformanceFrom","copyEmployeePerformanceFrom","copyEmployeePerformanceFrom/"+employee.getId()+"/","employeePerformanceList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeWorkExperience","addEmployeeWorkExperience","addEmployeeWorkExperience/"+employee.getId()+"/","employeeWorkExperienceList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeWorkExperience","removeEmployeeWorkExperience","removeEmployeeWorkExperience/"+employee.getId()+"/","employeeWorkExperienceList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeWorkExperience","updateEmployeeWorkExperience","updateEmployeeWorkExperience/"+employee.getId()+"/","employeeWorkExperienceList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeWorkExperienceFrom","copyEmployeeWorkExperienceFrom","copyEmployeeWorkExperienceFrom/"+employee.getId()+"/","employeeWorkExperienceList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeLeave","addEmployeeLeave","addEmployeeLeave/"+employee.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeLeave","removeEmployeeLeave","removeEmployeeLeave/"+employee.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeLeave","updateEmployeeLeave","updateEmployeeLeave/"+employee.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeLeaveFrom","copyEmployeeLeaveFrom","copyEmployeeLeaveFrom/"+employee.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeInterview","addEmployeeInterview","addEmployeeInterview/"+employee.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeInterview","removeEmployeeInterview","removeEmployeeInterview/"+employee.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeInterview","updateEmployeeInterview","updateEmployeeInterview/"+employee.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeInterviewFrom","copyEmployeeInterviewFrom","copyEmployeeInterviewFrom/"+employee.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeAttendance","addEmployeeAttendance","addEmployeeAttendance/"+employee.getId()+"/","employeeAttendanceList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeAttendance","removeEmployeeAttendance","removeEmployeeAttendance/"+employee.getId()+"/","employeeAttendanceList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeAttendance","updateEmployeeAttendance","updateEmployeeAttendance/"+employee.getId()+"/","employeeAttendanceList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeAttendanceFrom","copyEmployeeAttendanceFrom","copyEmployeeAttendanceFrom/"+employee.getId()+"/","employeeAttendanceList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeQualifier","addEmployeeQualifier","addEmployeeQualifier/"+employee.getId()+"/","employeeQualifierList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeQualifier","removeEmployeeQualifier","removeEmployeeQualifier/"+employee.getId()+"/","employeeQualifierList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeQualifier","updateEmployeeQualifier","updateEmployeeQualifier/"+employee.getId()+"/","employeeQualifierList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeQualifierFrom","copyEmployeeQualifierFrom","copyEmployeeQualifierFrom/"+employee.getId()+"/","employeeQualifierList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeEducation","addEmployeeEducation","addEmployeeEducation/"+employee.getId()+"/","employeeEducationList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeEducation","removeEmployeeEducation","removeEmployeeEducation/"+employee.getId()+"/","employeeEducationList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeEducation","updateEmployeeEducation","updateEmployeeEducation/"+employee.getId()+"/","employeeEducationList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeEducationFrom","copyEmployeeEducationFrom","copyEmployeeEducationFrom/"+employee.getId()+"/","employeeEducationList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeAward","addEmployeeAward","addEmployeeAward/"+employee.getId()+"/","employeeAwardList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeAward","removeEmployeeAward","removeEmployeeAward/"+employee.getId()+"/","employeeAwardList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeAward","updateEmployeeAward","updateEmployeeAward/"+employee.getId()+"/","employeeAwardList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeAwardFrom","copyEmployeeAwardFrom","copyEmployeeAwardFrom/"+employee.getId()+"/","employeeAwardList","primary");
		addAction(userContext, employee, tokens,"employee.addEmployeeSalarySheet","addEmployeeSalarySheet","addEmployeeSalarySheet/"+employee.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, employee, tokens,"employee.removeEmployeeSalarySheet","removeEmployeeSalarySheet","removeEmployeeSalarySheet/"+employee.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, employee, tokens,"employee.updateEmployeeSalarySheet","updateEmployeeSalarySheet","updateEmployeeSalarySheet/"+employee.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, employee, tokens,"employee.copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom","copyEmployeeSalarySheetFrom/"+employee.getId()+"/","employeeSalarySheetList","primary");
		addAction(userContext, employee, tokens,"employee.addPayingOff","addPayingOff","addPayingOff/"+employee.getId()+"/","payingOffList","primary");
		addAction(userContext, employee, tokens,"employee.removePayingOff","removePayingOff","removePayingOff/"+employee.getId()+"/","payingOffList","primary");
		addAction(userContext, employee, tokens,"employee.updatePayingOff","updatePayingOff","updatePayingOff/"+employee.getId()+"/","payingOffList","primary");
		addAction(userContext, employee, tokens,"employee.copyPayingOffFrom","copyPayingOffFrom","copyPayingOffFrom/"+employee.getId()+"/","payingOffList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Employee employee, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Employee createEmployee(RetailScmUserContext userContext,String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount
) throws Exception
	{
		
		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");

		

		checkTitleOfEmployee(userContext,  title, exception);
		checkFamilyNameOfEmployee(userContext,  familyName, exception);
		checkGivenNameOfEmployee(userContext,  givenName, exception);
		checkEmailOfEmployee(userContext,  email, exception);
		checkCityOfEmployee(userContext,  city, exception);
		checkAddressOfEmployee(userContext,  address, exception);
		checkCellPhoneOfEmployee(userContext,  cellPhone, exception);
		checkSalaryAccountOfEmployee(userContext,  salaryAccount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Employee employee=createNewEmployee();	

		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		employee.setCompany(company);
		employee.setTitle(title);
		LevelThreeDepartment department = loadLevelThreeDepartment(departmentId,emptyOptions());
		employee.setDepartment(department);
		employee.setFamilyName(familyName);
		employee.setGivenName(givenName);
		employee.setEmail(email);
		employee.setCity(city);
		employee.setAddress(address);
		employee.setCellPhone(cellPhone);
		OccupationType occupation = loadOccupationType(occupationId,emptyOptions());
		employee.setOccupation(occupation);
		ResponsibilityType responsibleFor = loadResponsibilityType(responsibleForId,emptyOptions());
		employee.setResponsibleFor(responsibleFor);
		SalaryGrade currentSalaryGrade = loadSalaryGrade(currentSalaryGradeId,emptyOptions());
		employee.setCurrentSalaryGrade(currentSalaryGrade);
		employee.setSalaryAccount(salaryAccount);

		return saveEmployee(userContext, employee, emptyOptions());
		

		
	}
	protected Employee createNewEmployee() 
	{
		
		return new Employee();		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext,String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);
		
		

		
		if(Employee.TITLE_PROPERTY.equals(property)){
			checkTitleOfEmployee(userContext, parseString(newValueExpr), exception);
		}		

		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
			checkFamilyNameOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
			checkGivenNameOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		if(Employee.EMAIL_PROPERTY.equals(property)){
			checkEmailOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		if(Employee.CITY_PROPERTY.equals(property)){
			checkCityOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		if(Employee.ADDRESS_PROPERTY.equals(property)){
			checkAddressOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
			checkCellPhoneOfEmployee(userContext, parseString(newValueExpr), exception);
		}		

				

				

		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
			checkSalaryAccountOfEmployee(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public Employee clone(RetailScmUserContext userContext, String fromEmployeeId) throws Exception{
		
		return this.getEmployeeDAO().clone(fromEmployeeId, this.allTokens());
	}
	
	public Employee updateEmployee(RetailScmUserContext userContext,String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployee(userContext, employeeId, employeeVersion, property, newValueExpr, tokensExpr);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		if(employee.getVersion() != employeeVersion){
			String message = "The target version("+employee.getVersion()+") is not equals to version("+employeeVersion+") provided";
			throw new EmployeeManagerException(message);
		}
		synchronized(employee){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Employee.
			
			employee.changePropery(property, newValueExpr);
			employee = saveEmployee(userContext, employee, tokens().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
			//return saveEmployee(userContext, employee, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeTokens tokens(){
		return EmployeeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={"JOB_APPLIED","PASSED_WITH_PROFESSION","PASSED_BY_HR","OFFER_APPROVED","OFFER_ACCEPTED","EMPLOYEE_BOARDED","TERMINATED"};
 	protected String getNextStatus(RetailScmUserContext userContext, String currentStatus){
 	
 		if(currentStatus == null){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE[0];
 		}
 	
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throw new IllegalArgumentException("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		//this is not the last one, just return it.
 		
 		return STATUS_SEQUENCE[index+1];
 	
 	}/**/
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String employeeId, String anotherCompanyId) throws Exception
 	{
 		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
 		checkIdOfEmployee(userContext, employeeId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Employee transferToAnotherCompany(RetailScmUserContext userContext, String employeeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, employeeId,anotherCompanyId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			employee.setCompany(company);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherDepartment(RetailScmUserContext userContext, String employeeId, String anotherDepartmentId) throws Exception
 	{
 		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
 		checkIdOfEmployee(userContext, employeeId,exception);
 		checkIdOfLevelThreeDepartment(userContext, anotherDepartmentId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Employee transferToAnotherDepartment(RetailScmUserContext userContext, String employeeId, String anotherDepartmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherDepartment(userContext, employeeId,anotherDepartmentId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelThreeDepartment department = loadLevelThreeDepartment(anotherDepartmentId, emptyOptions());		
			employee.setDepartment(department);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherOccupation(RetailScmUserContext userContext, String employeeId, String anotherOccupationId) throws Exception
 	{
 		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
 		checkIdOfEmployee(userContext, employeeId,exception);
 		checkIdOfOccupationType(userContext, anotherOccupationId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Employee transferToAnotherOccupation(RetailScmUserContext userContext, String employeeId, String anotherOccupationId) throws Exception
 	{
 		checkParamsForTransferingAnotherOccupation(userContext, employeeId,anotherOccupationId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OccupationType occupation = loadOccupationType(anotherOccupationId, emptyOptions());		
			employee.setOccupation(occupation);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherResponsibleFor(RetailScmUserContext userContext, String employeeId, String anotherResponsibleForId) throws Exception
 	{
 		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
 		checkIdOfEmployee(userContext, employeeId,exception);
 		checkIdOfResponsibilityType(userContext, anotherResponsibleForId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Employee transferToAnotherResponsibleFor(RetailScmUserContext userContext, String employeeId, String anotherResponsibleForId) throws Exception
 	{
 		checkParamsForTransferingAnotherResponsibleFor(userContext, employeeId,anotherResponsibleForId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ResponsibilityType responsibleFor = loadResponsibilityType(anotherResponsibleForId, emptyOptions());		
			employee.setResponsibleFor(responsibleFor);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherCurrentSalaryGrade(RetailScmUserContext userContext, String employeeId, String anotherCurrentSalaryGradeId) throws Exception
 	{
 		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
 		checkIdOfEmployee(userContext, employeeId,exception);
 		checkIdOfSalaryGrade(userContext, anotherCurrentSalaryGradeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Employee transferToAnotherCurrentSalaryGrade(RetailScmUserContext userContext, String employeeId, String anotherCurrentSalaryGradeId) throws Exception
 	{
 		checkParamsForTransferingAnotherCurrentSalaryGrade(userContext, employeeId,anotherCurrentSalaryGradeId);
 
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SalaryGrade currentSalaryGrade = loadSalaryGrade(anotherCurrentSalaryGradeId, emptyOptions());		
			employee.setCurrentSalaryGrade(currentSalaryGrade);		
			employee = saveEmployee(userContext, employee, emptyOptions());
			
			return present(userContext,employee, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForJobApplication(RetailScmUserContext userContext, String employeeId, Date applicationTime, String who, String comments
) throws Exception
 	{
 		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkApplicationTimeOfJobApplication(userContext,applicationTime,exception);
		checkWhoOfJobApplication(userContext,who,exception);
		checkCommentsOfJobApplication(userContext,comments,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public Employee applyJob(RetailScmUserContext userContext, String employeeId, Date applicationTime, String who, String comments
) throws Exception
 	{
		checkParamsForJobApplication(userContext, employeeId, applicationTime, who, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForJobApplication(userContext,employee);
 		

			employee.setCurrentStatus("JOB_APPLIED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			JobApplication jobApplication = createJobApplication(applicationTime, who, comments);		
			employee.setJobApplication(jobApplication);		
			employee = saveEmployee(userContext, employee, tokens().withJobApplication().done());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	protected JobApplication createJobApplication(Date applicationTime, String who, String comments){
 		JobApplication jobApplication = new JobApplication(applicationTime, who, comments);
 		return getJobApplicationDAO().save(jobApplication,emptyOptions());
 	}
 	protected void checkIfEligibleForJobApplication(RetailScmUserContext userContext, Employee employee) throws Exception{
 		
 		
 		String currentStatus = employee.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'JOB_APPLIED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		if(!("JOB_APPLIED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'JOB_APPLIED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		
 		JobApplication jobApplication = employee.getJobApplication();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = jobApplication 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( jobApplication != null){
				throw new EmployeeManagerException("The Employee("+employee.getId()+") has already been JOB_APPLIED");
		}
 		
 		
 	}
	
 	protected void checkParamsForProfessionInterview(RetailScmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
) throws Exception
 	{
 		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkWhoOfProfessionInterview(userContext,who,exception);
		checkInterviewTimeOfProfessionInterview(userContext,interviewTime,exception);
		checkCommentsOfProfessionInterview(userContext,comments,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public Employee interviewWithProfession(RetailScmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
) throws Exception
 	{
		checkParamsForProfessionInterview(userContext, employeeId, who, interviewTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForProfessionInterview(userContext,employee);
 		

			employee.setCurrentStatus("PASSED_WITH_PROFESSION");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			ProfessionInterview professionInterview = createProfessionInterview(who, interviewTime, comments);		
			employee.setProfessionInterview(professionInterview);		
			employee = saveEmployee(userContext, employee, tokens().withProfessionInterview().done());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	protected ProfessionInterview createProfessionInterview(String who, Date interviewTime, String comments){
 		ProfessionInterview professionInterview = new ProfessionInterview(who, interviewTime, comments);
 		return getProfessionInterviewDAO().save(professionInterview,emptyOptions());
 	}
 	protected void checkIfEligibleForProfessionInterview(RetailScmUserContext userContext, Employee employee) throws Exception{
 		
 		
 		String currentStatus = employee.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'PASSED_WITH_PROFESSION'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		if(!("PASSED_WITH_PROFESSION".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'PASSED_WITH_PROFESSION'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		
 		ProfessionInterview professionInterview = employee.getProfessionInterview();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = professionInterview 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( professionInterview != null){
				throw new EmployeeManagerException("The Employee("+employee.getId()+") has already been PASSED_WITH_PROFESSION");
		}
 		
 		
 	}
	
 	protected void checkParamsForHrInterview(RetailScmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
) throws Exception
 	{
 		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkWhoOfHrInterview(userContext,who,exception);
		checkInterviewTimeOfHrInterview(userContext,interviewTime,exception);
		checkCommentsOfHrInterview(userContext,comments,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public Employee interviewByHr(RetailScmUserContext userContext, String employeeId, String who, Date interviewTime, String comments
) throws Exception
 	{
		checkParamsForHrInterview(userContext, employeeId, who, interviewTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForHrInterview(userContext,employee);
 		

			employee.setCurrentStatus("PASSED_BY_HR");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			HrInterview hrInterview = createHrInterview(who, interviewTime, comments);		
			employee.setHrInterview(hrInterview);		
			employee = saveEmployee(userContext, employee, tokens().withHrInterview().done());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	protected HrInterview createHrInterview(String who, Date interviewTime, String comments){
 		HrInterview hrInterview = new HrInterview(who, interviewTime, comments);
 		return getHrInterviewDAO().save(hrInterview,emptyOptions());
 	}
 	protected void checkIfEligibleForHrInterview(RetailScmUserContext userContext, Employee employee) throws Exception{
 		
 		
 		String currentStatus = employee.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'PASSED_BY_HR'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		if(!("PASSED_BY_HR".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'PASSED_BY_HR'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		
 		HrInterview hrInterview = employee.getHrInterview();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = hrInterview 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( hrInterview != null){
				throw new EmployeeManagerException("The Employee("+employee.getId()+") has already been PASSED_BY_HR");
		}
 		
 		
 	}
	
 	protected void checkParamsForOfferApproval(RetailScmUserContext userContext, String employeeId, String who, Date approveTime, String comments
) throws Exception
 	{
 		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkWhoOfOfferApproval(userContext,who,exception);
		checkApproveTimeOfOfferApproval(userContext,approveTime,exception);
		checkCommentsOfOfferApproval(userContext,comments,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public Employee approveOffer(RetailScmUserContext userContext, String employeeId, String who, Date approveTime, String comments
) throws Exception
 	{
		checkParamsForOfferApproval(userContext, employeeId, who, approveTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForOfferApproval(userContext,employee);
 		

			employee.setCurrentStatus("OFFER_APPROVED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OfferApproval offerApproval = createOfferApproval(who, approveTime, comments);		
			employee.setOfferApproval(offerApproval);		
			employee = saveEmployee(userContext, employee, tokens().withOfferApproval().done());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	protected OfferApproval createOfferApproval(String who, Date approveTime, String comments){
 		OfferApproval offerApproval = new OfferApproval(who, approveTime, comments);
 		return getOfferApprovalDAO().save(offerApproval,emptyOptions());
 	}
 	protected void checkIfEligibleForOfferApproval(RetailScmUserContext userContext, Employee employee) throws Exception{
 		
 		
 		String currentStatus = employee.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'OFFER_APPROVED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		if(!("OFFER_APPROVED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'OFFER_APPROVED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		
 		OfferApproval offerApproval = employee.getOfferApproval();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = offerApproval 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( offerApproval != null){
				throw new EmployeeManagerException("The Employee("+employee.getId()+") has already been OFFER_APPROVED");
		}
 		
 		
 	}
	
 	protected void checkParamsForOfferAcceptance(RetailScmUserContext userContext, String employeeId, String who, Date acceptTime, String comments
) throws Exception
 	{
 		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkWhoOfOfferAcceptance(userContext,who,exception);
		checkAcceptTimeOfOfferAcceptance(userContext,acceptTime,exception);
		checkCommentsOfOfferAcceptance(userContext,comments,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public Employee acceptOffer(RetailScmUserContext userContext, String employeeId, String who, Date acceptTime, String comments
) throws Exception
 	{
		checkParamsForOfferAcceptance(userContext, employeeId, who, acceptTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForOfferAcceptance(userContext,employee);
 		

			employee.setCurrentStatus("OFFER_ACCEPTED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OfferAcceptance offerAcceptance = createOfferAcceptance(who, acceptTime, comments);		
			employee.setOfferAcceptance(offerAcceptance);		
			employee = saveEmployee(userContext, employee, tokens().withOfferAcceptance().done());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	protected OfferAcceptance createOfferAcceptance(String who, Date acceptTime, String comments){
 		OfferAcceptance offerAcceptance = new OfferAcceptance(who, acceptTime, comments);
 		return getOfferAcceptanceDAO().save(offerAcceptance,emptyOptions());
 	}
 	protected void checkIfEligibleForOfferAcceptance(RetailScmUserContext userContext, Employee employee) throws Exception{
 		
 		
 		String currentStatus = employee.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'OFFER_ACCEPTED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		if(!("OFFER_ACCEPTED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'OFFER_ACCEPTED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		
 		OfferAcceptance offerAcceptance = employee.getOfferAcceptance();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = offerAcceptance 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( offerAcceptance != null){
				throw new EmployeeManagerException("The Employee("+employee.getId()+") has already been OFFER_ACCEPTED");
		}
 		
 		
 	}
	
 	protected void checkParamsForEmployeeBoarding(RetailScmUserContext userContext, String employeeId, String who, Date employTime, String comments
) throws Exception
 	{
 		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkWhoOfEmployeeBoarding(userContext,who,exception);
		checkEmployTimeOfEmployeeBoarding(userContext,employTime,exception);
		checkCommentsOfEmployeeBoarding(userContext,comments,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public Employee boardEmployee(RetailScmUserContext userContext, String employeeId, String who, Date employTime, String comments
) throws Exception
 	{
		checkParamsForEmployeeBoarding(userContext, employeeId, who, employTime, comments);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForEmployeeBoarding(userContext,employee);
 		

			employee.setCurrentStatus("EMPLOYEE_BOARDED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			EmployeeBoarding employeeBoarding = createEmployeeBoarding(who, employTime, comments);		
			employee.setEmployeeBoarding(employeeBoarding);		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeBoarding().done());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	protected EmployeeBoarding createEmployeeBoarding(String who, Date employTime, String comments){
 		EmployeeBoarding employeeBoarding = new EmployeeBoarding(who, employTime, comments);
 		return getEmployeeBoardingDAO().save(employeeBoarding,emptyOptions());
 	}
 	protected void checkIfEligibleForEmployeeBoarding(RetailScmUserContext userContext, Employee employee) throws Exception{
 		
 		
 		String currentStatus = employee.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'EMPLOYEE_BOARDED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		if(!("EMPLOYEE_BOARDED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'EMPLOYEE_BOARDED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		
 		EmployeeBoarding employeeBoarding = employee.getEmployeeBoarding();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = employeeBoarding 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( employeeBoarding != null){
				throw new EmployeeManagerException("The Employee("+employee.getId()+") has already been EMPLOYEE_BOARDED");
		}
 		
 		
 	}
	
 	protected void checkParamsForTermination(RetailScmUserContext userContext, String employeeId, String reasonId, String typeId, String comment
) throws Exception
 	{
 		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfTerminationReason(userContext,reasonId,exception);
		checkIdOfTerminationType(userContext,typeId,exception);
		checkCommentOfTermination(userContext,comment,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public Employee terminate(RetailScmUserContext userContext, String employeeId, String reasonId, String typeId, String comment
) throws Exception
 	{
		checkParamsForTermination(userContext, employeeId, reasonId, typeId, comment);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForTermination(userContext,employee);
 		

			employee.setCurrentStatus("TERMINATED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively
			TerminationReason reason = loadTerminationReason(reasonId, emptyOptions());
			TerminationType type = loadTerminationType(typeId, emptyOptions());


			Termination termination = createTermination(reason, type, comment);		
			employee.setTermination(termination);		
			employee = saveEmployee(userContext, employee, tokens().withTermination().done());
			
			return present(userContext,employee, allTokens());
			
		}

 	}
 	protected Termination createTermination(TerminationReason reason, TerminationType type, String comment){
 		Termination termination = new Termination(reason, type, comment);
 		return getTerminationDAO().save(termination,emptyOptions());
 	}
 	protected void checkIfEligibleForTermination(RetailScmUserContext userContext, Employee employee) throws Exception{
 		
 		
 		String currentStatus = employee.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'TERMINATED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		if(!("TERMINATED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'TERMINATED'";
 			throw new EmployeeManagerException(message);
 		}
 		
 		
 		Termination termination = employee.getTermination();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = termination 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( termination != null){
				throw new EmployeeManagerException("The Employee("+employee.getId()+") has already been TERMINATED");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected Termination loadTermination(String newTerminationId, Map<String,Object> options) throws Exception
 	{
		
 		return getTerminationDAO().load(newTerminationId, options);
 	}
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	 	
 	protected OfferAcceptance loadOfferAcceptance(String newOfferAcceptanceId, Map<String,Object> options) throws Exception
 	{
		
 		return getOfferAcceptanceDAO().load(newOfferAcceptanceId, options);
 	}
	
	 	
 	protected OfferApproval loadOfferApproval(String newOfferApprovalId, Map<String,Object> options) throws Exception
 	{
		
 		return getOfferApprovalDAO().load(newOfferApprovalId, options);
 	}
	
	 	
 	protected TerminationReason loadTerminationReason(String newReasonId, Map<String,Object> options) throws Exception
 	{
		
 		return getTerminationReasonDAO().load(newReasonId, options);
 	}
	
	 	
 	protected HrInterview loadHrInterview(String newHrInterviewId, Map<String,Object> options) throws Exception
 	{
		
 		return getHrInterviewDAO().load(newHrInterviewId, options);
 	}
	
	 	
 	protected ResponsibilityType loadResponsibilityType(String newResponsibleForId, Map<String,Object> options) throws Exception
 	{
		
 		return getResponsibilityTypeDAO().load(newResponsibleForId, options);
 	}
	
	 	
 	protected SalaryGrade loadSalaryGrade(String newCurrentSalaryGradeId, Map<String,Object> options) throws Exception
 	{
		
 		return getSalaryGradeDAO().load(newCurrentSalaryGradeId, options);
 	}
	
	 	
 	protected TerminationType loadTerminationType(String newTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return getTerminationTypeDAO().load(newTypeId, options);
 	}
	
	 	
 	protected LevelThreeDepartment loadLevelThreeDepartment(String newDepartmentId, Map<String,Object> options) throws Exception
 	{
		
 		return getLevelThreeDepartmentDAO().load(newDepartmentId, options);
 	}
	
	 	
 	protected OccupationType loadOccupationType(String newOccupationId, Map<String,Object> options) throws Exception
 	{
		
 		return getOccupationTypeDAO().load(newOccupationId, options);
 	}
	
	 	
 	protected JobApplication loadJobApplication(String newJobApplicationId, Map<String,Object> options) throws Exception
 	{
		
 		return getJobApplicationDAO().load(newJobApplicationId, options);
 	}
	
	 	
 	protected ProfessionInterview loadProfessionInterview(String newProfessionInterviewId, Map<String,Object> options) throws Exception
 	{
		
 		return getProfessionInterviewDAO().load(newProfessionInterviewId, options);
 	}
	
	 	
 	protected EmployeeBoarding loadEmployeeBoarding(String newEmployeeBoardingId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeBoardingDAO().load(newEmployeeBoardingId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeId, int employeeVersion) throws Exception {
		
		deleteInternal(userContext, employeeId, employeeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeId, int employeeVersion) throws Exception{
		getEmployeeDAO().delete(employeeId, employeeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, String trainingId,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		
		
		checkIdOfCompanyTraining(userContext,  trainingId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, String trainingId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeCompanyTraining(userContext,employeeId,trainingId,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,trainingId);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeCompanyTraining( employeeCompanyTraining );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeCompanyTraining createEmployeeCompanyTraining(RetailScmUserContext userContext, String trainingId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		CompanyTraining  training = new CompanyTraining();
		training.setId(trainingId);		
		employeeCompanyTraining.setTraining(training);
	
		
		return employeeCompanyTraining;
	
		
	}
	
	protected EmployeeCompanyTraining createIndexedEmployeeCompanyTraining(String id, int version){

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTraining.setId(id);
		employeeCompanyTraining.setVersion(version);
		return employeeCompanyTraining;			
		
	}
	protected void checkParamsForRemovingEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeCompanyTraining(userContext,employeeId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeCompanyTraining( employeeCompanyTraining );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeCompanyTrainingFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeCompanyTraining(userContext,employeeId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeCompanyTrainingFrom( employeeCompanyTraining );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, exception);
		checkVersionOfEmployeeCompanyTraining(userContext, employeeCompanyTrainingVersion, exception);
		

	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeCompanyTraining( employeeCompanyTraining );	
			//make changes to AcceleraterAccount.
			EmployeeCompanyTraining employeeCompanyTrainingIndex = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		
			EmployeeCompanyTraining employeeCompanyTraining = employee.findTheEmployeeCompanyTraining(employeeCompanyTrainingIndex);
			if(employeeCompanyTraining == null){
				throw new EmployeeManagerException(employeeCompanyTraining+"Not found" );
			}
			
			employeeCompanyTraining.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeSkill(RetailScmUserContext userContext, String employeeId, String skillTypeId, String description,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		
		
		checkIdOfSkillType(userContext,  skillTypeId, exception);
		checkDescriptionOfEmployeeSkill(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeSkill(RetailScmUserContext userContext, String employeeId, String skillTypeId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSkill(userContext,employeeId,skillTypeId, description,tokensExpr);
		
		EmployeeSkill employeeSkill = createEmployeeSkill(userContext,skillTypeId, description);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeSkill( employeeSkill );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeSkill createEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, String description) throws Exception{

		EmployeeSkill employeeSkill = new EmployeeSkill();
		
		
		SkillType  skillType = new SkillType();
		skillType.setId(skillTypeId);		
		employeeSkill.setSkillType(skillType);		
		employeeSkill.setDescription(description);
	
		
		return employeeSkill;
	
		
	}
	
	protected EmployeeSkill createIndexedEmployeeSkill(String id, int version){

		EmployeeSkill employeeSkill = new EmployeeSkill();
		employeeSkill.setId(id);
		employeeSkill.setVersion(version);
		return employeeSkill;			
		
	}
	protected void checkParamsForRemovingEmployeeSkill(RetailScmUserContext userContext, String employeeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		checkVersionOfEmployeeSkill(userContext, employeeSkillVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeSkill(RetailScmUserContext userContext, String employeeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSkill(userContext,employeeId, employeeSkillId, employeeSkillVersion,tokensExpr);
		
		EmployeeSkill employeeSkill = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeSkill( employeeSkill );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeSkill(RetailScmUserContext userContext, String employeeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		checkVersionOfEmployeeSkill(userContext, employeeSkillVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeSkillFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSkill(userContext,employeeId, employeeSkillId, employeeSkillVersion,tokensExpr);
		
		EmployeeSkill employeeSkill = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeSkillFrom( employeeSkill );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeSkill(RetailScmUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		checkVersionOfEmployeeSkill(userContext, employeeSkillVersion, exception);
		

		if(EmployeeSkill.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfEmployeeSkill(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeSkill(RetailScmUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSkill(userContext, employeeId, employeeSkillId, employeeSkillVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeSkill( employeeSkill );	
			//make changes to AcceleraterAccount.
			EmployeeSkill employeeSkillIndex = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		
			EmployeeSkill employeeSkill = employee.findTheEmployeeSkill(employeeSkillIndex);
			if(employeeSkill == null){
				throw new EmployeeManagerException(employeeSkill+"Not found" );
			}
			
			employeeSkill.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeSkillList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeePerformance(RetailScmUserContext userContext, String employeeId, String performanceComment,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);

		checkPerformanceCommentOfEmployeePerformance(userContext,  performanceComment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeePerformance(RetailScmUserContext userContext, String employeeId, String performanceComment, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeePerformance(userContext,employeeId,performanceComment,tokensExpr);
		
		EmployeePerformance employeePerformance = createEmployeePerformance(userContext,performanceComment);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeePerformance( employeePerformance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeePerformance createEmployeePerformance(RetailScmUserContext userContext, String performanceComment) throws Exception{

		EmployeePerformance employeePerformance = new EmployeePerformance();
		
		
		employeePerformance.setPerformanceComment(performanceComment);
	
		
		return employeePerformance;
	
		
	}
	
	protected EmployeePerformance createIndexedEmployeePerformance(String id, int version){

		EmployeePerformance employeePerformance = new EmployeePerformance();
		employeePerformance.setId(id);
		employeePerformance.setVersion(version);
		return employeePerformance;			
		
	}
	protected void checkParamsForRemovingEmployeePerformance(RetailScmUserContext userContext, String employeeId, 
		String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeePerformance(userContext, employeePerformanceId, exception);
		checkVersionOfEmployeePerformance(userContext, employeePerformanceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeePerformance(RetailScmUserContext userContext, String employeeId, 
		String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeePerformance(userContext,employeeId, employeePerformanceId, employeePerformanceVersion,tokensExpr);
		
		EmployeePerformance employeePerformance = createIndexedEmployeePerformance(employeePerformanceId, employeePerformanceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeePerformance( employeePerformance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeePerformance(RetailScmUserContext userContext, String employeeId, 
		String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeePerformance(userContext, employeePerformanceId, exception);
		checkVersionOfEmployeePerformance(userContext, employeePerformanceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeePerformanceFrom(RetailScmUserContext userContext, String employeeId, 
		String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeePerformance(userContext,employeeId, employeePerformanceId, employeePerformanceVersion,tokensExpr);
		
		EmployeePerformance employeePerformance = createIndexedEmployeePerformance(employeePerformanceId, employeePerformanceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeePerformanceFrom( employeePerformance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeePerformance(RetailScmUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeePerformance(userContext, employeePerformanceId, exception);
		checkVersionOfEmployeePerformance(userContext, employeePerformanceVersion, exception);
		

		if(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY.equals(property)){
			checkPerformanceCommentOfEmployeePerformance(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeePerformance(RetailScmUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeePerformance(userContext, employeeId, employeePerformanceId, employeePerformanceVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeePerformance( employeePerformance );	
			//make changes to AcceleraterAccount.
			EmployeePerformance employeePerformanceIndex = createIndexedEmployeePerformance(employeePerformanceId, employeePerformanceVersion);
		
			EmployeePerformance employeePerformance = employee.findTheEmployeePerformance(employeePerformanceIndex);
			if(employeePerformance == null){
				throw new EmployeeManagerException(employeePerformance+"Not found" );
			}
			
			employeePerformance.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeePerformanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, Date start, Date end, String company, String description,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);

		checkStartOfEmployeeWorkExperience(userContext,  start, exception);
		checkEndOfEmployeeWorkExperience(userContext,  end, exception);
		checkCompanyOfEmployeeWorkExperience(userContext,  company, exception);
		checkDescriptionOfEmployeeWorkExperience(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, Date start, Date end, String company, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeWorkExperience(userContext,employeeId,start, end, company, description,tokensExpr);
		
		EmployeeWorkExperience employeeWorkExperience = createEmployeeWorkExperience(userContext,start, end, company, description);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeWorkExperience( employeeWorkExperience );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeWorkExperience createEmployeeWorkExperience(RetailScmUserContext userContext, Date start, Date end, String company, String description) throws Exception{

		EmployeeWorkExperience employeeWorkExperience = new EmployeeWorkExperience();
		
		
		employeeWorkExperience.setStart(start);		
		employeeWorkExperience.setEnd(end);		
		employeeWorkExperience.setCompany(company);		
		employeeWorkExperience.setDescription(description);
	
		
		return employeeWorkExperience;
	
		
	}
	
	protected EmployeeWorkExperience createIndexedEmployeeWorkExperience(String id, int version){

		EmployeeWorkExperience employeeWorkExperience = new EmployeeWorkExperience();
		employeeWorkExperience.setId(id);
		employeeWorkExperience.setVersion(version);
		return employeeWorkExperience;			
		
	}
	protected void checkParamsForRemovingEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, 
		String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeWorkExperience(userContext, employeeWorkExperienceId, exception);
		checkVersionOfEmployeeWorkExperience(userContext, employeeWorkExperienceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, 
		String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeWorkExperience(userContext,employeeId, employeeWorkExperienceId, employeeWorkExperienceVersion,tokensExpr);
		
		EmployeeWorkExperience employeeWorkExperience = createIndexedEmployeeWorkExperience(employeeWorkExperienceId, employeeWorkExperienceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeWorkExperience( employeeWorkExperience );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, 
		String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeWorkExperience(userContext, employeeWorkExperienceId, exception);
		checkVersionOfEmployeeWorkExperience(userContext, employeeWorkExperienceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeWorkExperienceFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeWorkExperience(userContext,employeeId, employeeWorkExperienceId, employeeWorkExperienceVersion,tokensExpr);
		
		EmployeeWorkExperience employeeWorkExperience = createIndexedEmployeeWorkExperience(employeeWorkExperienceId, employeeWorkExperienceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeWorkExperienceFrom( employeeWorkExperience );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeWorkExperience(userContext, employeeWorkExperienceId, exception);
		checkVersionOfEmployeeWorkExperience(userContext, employeeWorkExperienceVersion, exception);
		

		if(EmployeeWorkExperience.START_PROPERTY.equals(property)){
			checkStartOfEmployeeWorkExperience(userContext, parseDate(newValueExpr), exception);
		}
		
		if(EmployeeWorkExperience.END_PROPERTY.equals(property)){
			checkEndOfEmployeeWorkExperience(userContext, parseDate(newValueExpr), exception);
		}
		
		if(EmployeeWorkExperience.COMPANY_PROPERTY.equals(property)){
			checkCompanyOfEmployeeWorkExperience(userContext, parseString(newValueExpr), exception);
		}
		
		if(EmployeeWorkExperience.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfEmployeeWorkExperience(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeWorkExperience(userContext, employeeId, employeeWorkExperienceId, employeeWorkExperienceVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeWorkExperience( employeeWorkExperience );	
			//make changes to AcceleraterAccount.
			EmployeeWorkExperience employeeWorkExperienceIndex = createIndexedEmployeeWorkExperience(employeeWorkExperienceId, employeeWorkExperienceVersion);
		
			EmployeeWorkExperience employeeWorkExperience = employee.findTheEmployeeWorkExperience(employeeWorkExperienceIndex);
			if(employeeWorkExperience == null){
				throw new EmployeeManagerException(employeeWorkExperience+"Not found" );
			}
			
			employeeWorkExperience.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeWorkExperienceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeLeave(RetailScmUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		
		
		checkIdOfLeaveType(userContext,  typeId, exception);
		checkLeaveDurationHourOfEmployeeLeave(userContext,  leaveDurationHour, exception);
		checkRemarkOfEmployeeLeave(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeLeave(RetailScmUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeLeave(userContext,employeeId,typeId, leaveDurationHour, remark,tokensExpr);
		
		EmployeeLeave employeeLeave = createEmployeeLeave(userContext,typeId, leaveDurationHour, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeLeave( employeeLeave );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeLeave createEmployeeLeave(RetailScmUserContext userContext, String typeId, int leaveDurationHour, String remark) throws Exception{

		EmployeeLeave employeeLeave = new EmployeeLeave();
		
		
		LeaveType  type = new LeaveType();
		type.setId(typeId);		
		employeeLeave.setType(type);		
		employeeLeave.setLeaveDurationHour(leaveDurationHour);		
		employeeLeave.setRemark(remark);
	
		
		return employeeLeave;
	
		
	}
	
	protected EmployeeLeave createIndexedEmployeeLeave(String id, int version){

		EmployeeLeave employeeLeave = new EmployeeLeave();
		employeeLeave.setId(id);
		employeeLeave.setVersion(version);
		return employeeLeave;			
		
	}
	protected void checkParamsForRemovingEmployeeLeave(RetailScmUserContext userContext, String employeeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeLeave(userContext, employeeLeaveId, exception);
		checkVersionOfEmployeeLeave(userContext, employeeLeaveVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeLeave(RetailScmUserContext userContext, String employeeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeLeave(userContext,employeeId, employeeLeaveId, employeeLeaveVersion,tokensExpr);
		
		EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeLeave( employeeLeave );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeLeave(RetailScmUserContext userContext, String employeeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeLeave(userContext, employeeLeaveId, exception);
		checkVersionOfEmployeeLeave(userContext, employeeLeaveVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeLeaveFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeLeave(userContext,employeeId, employeeLeaveId, employeeLeaveVersion,tokensExpr);
		
		EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeLeaveFrom( employeeLeave );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeLeave(RetailScmUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeLeave(userContext, employeeLeaveId, exception);
		checkVersionOfEmployeeLeave(userContext, employeeLeaveVersion, exception);
		

		if(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			checkLeaveDurationHourOfEmployeeLeave(userContext, parseInt(newValueExpr), exception);
		}
		
		if(EmployeeLeave.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeLeave(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeLeave(RetailScmUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeLeave(userContext, employeeId, employeeLeaveId, employeeLeaveVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeLeave( employeeLeave );	
			//make changes to AcceleraterAccount.
			EmployeeLeave employeeLeaveIndex = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		
			EmployeeLeave employeeLeave = employee.findTheEmployeeLeave(employeeLeaveIndex);
			if(employeeLeave == null){
				throw new EmployeeManagerException(employeeLeave+"Not found" );
			}
			
			employeeLeave.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeLeaveList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeInterview(RetailScmUserContext userContext, String employeeId, String interviewTypeId, String remark,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		
		
		checkIdOfInterviewType(userContext,  interviewTypeId, exception);
		checkRemarkOfEmployeeInterview(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeInterview(RetailScmUserContext userContext, String employeeId, String interviewTypeId, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeInterview(userContext,employeeId,interviewTypeId, remark,tokensExpr);
		
		EmployeeInterview employeeInterview = createEmployeeInterview(userContext,interviewTypeId, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeInterview( employeeInterview );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeInterview createEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, String remark) throws Exception{

		EmployeeInterview employeeInterview = new EmployeeInterview();
		
		
		InterviewType  interviewType = new InterviewType();
		interviewType.setId(interviewTypeId);		
		employeeInterview.setInterviewType(interviewType);		
		employeeInterview.setRemark(remark);
	
		
		return employeeInterview;
	
		
	}
	
	protected EmployeeInterview createIndexedEmployeeInterview(String id, int version){

		EmployeeInterview employeeInterview = new EmployeeInterview();
		employeeInterview.setId(id);
		employeeInterview.setVersion(version);
		return employeeInterview;			
		
	}
	protected void checkParamsForRemovingEmployeeInterview(RetailScmUserContext userContext, String employeeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		checkVersionOfEmployeeInterview(userContext, employeeInterviewVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeInterview(RetailScmUserContext userContext, String employeeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeInterview(userContext,employeeId, employeeInterviewId, employeeInterviewVersion,tokensExpr);
		
		EmployeeInterview employeeInterview = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeInterview( employeeInterview );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeInterview(RetailScmUserContext userContext, String employeeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		checkVersionOfEmployeeInterview(userContext, employeeInterviewVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeInterviewFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeInterview(userContext,employeeId, employeeInterviewId, employeeInterviewVersion,tokensExpr);
		
		EmployeeInterview employeeInterview = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeInterviewFrom( employeeInterview );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeInterview(RetailScmUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		checkVersionOfEmployeeInterview(userContext, employeeInterviewVersion, exception);
		

		if(EmployeeInterview.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeInterview(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeInterview(RetailScmUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeInterview(userContext, employeeId, employeeInterviewId, employeeInterviewVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeInterview( employeeInterview );	
			//make changes to AcceleraterAccount.
			EmployeeInterview employeeInterviewIndex = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		
			EmployeeInterview employeeInterview = employee.findTheEmployeeInterview(employeeInterviewIndex);
			if(employeeInterview == null){
				throw new EmployeeManagerException(employeeInterview+"Not found" );
			}
			
			employeeInterview.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeInterviewList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeAttendance(RetailScmUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);

		checkEnterTimeOfEmployeeAttendance(userContext,  enterTime, exception);
		checkLeaveTimeOfEmployeeAttendance(userContext,  leaveTime, exception);
		checkDurationHoursOfEmployeeAttendance(userContext,  durationHours, exception);
		checkRemarkOfEmployeeAttendance(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeAttendance(RetailScmUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeAttendance(userContext,employeeId,enterTime, leaveTime, durationHours, remark,tokensExpr);
		
		EmployeeAttendance employeeAttendance = createEmployeeAttendance(userContext,enterTime, leaveTime, durationHours, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeAttendance( employeeAttendance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeAttendance createEmployeeAttendance(RetailScmUserContext userContext, Date enterTime, Date leaveTime, int durationHours, String remark) throws Exception{

		EmployeeAttendance employeeAttendance = new EmployeeAttendance();
		
		
		employeeAttendance.setEnterTime(enterTime);		
		employeeAttendance.setLeaveTime(leaveTime);		
		employeeAttendance.setDurationHours(durationHours);		
		employeeAttendance.setRemark(remark);
	
		
		return employeeAttendance;
	
		
	}
	
	protected EmployeeAttendance createIndexedEmployeeAttendance(String id, int version){

		EmployeeAttendance employeeAttendance = new EmployeeAttendance();
		employeeAttendance.setId(id);
		employeeAttendance.setVersion(version);
		return employeeAttendance;			
		
	}
	protected void checkParamsForRemovingEmployeeAttendance(RetailScmUserContext userContext, String employeeId, 
		String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeAttendance(userContext, employeeAttendanceId, exception);
		checkVersionOfEmployeeAttendance(userContext, employeeAttendanceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeAttendance(RetailScmUserContext userContext, String employeeId, 
		String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeAttendance(userContext,employeeId, employeeAttendanceId, employeeAttendanceVersion,tokensExpr);
		
		EmployeeAttendance employeeAttendance = createIndexedEmployeeAttendance(employeeAttendanceId, employeeAttendanceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeAttendance( employeeAttendance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeAttendance(RetailScmUserContext userContext, String employeeId, 
		String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeAttendance(userContext, employeeAttendanceId, exception);
		checkVersionOfEmployeeAttendance(userContext, employeeAttendanceVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeAttendanceFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeAttendance(userContext,employeeId, employeeAttendanceId, employeeAttendanceVersion,tokensExpr);
		
		EmployeeAttendance employeeAttendance = createIndexedEmployeeAttendance(employeeAttendanceId, employeeAttendanceVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeAttendanceFrom( employeeAttendance );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeAttendance(RetailScmUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeAttendance(userContext, employeeAttendanceId, exception);
		checkVersionOfEmployeeAttendance(userContext, employeeAttendanceVersion, exception);
		

		if(EmployeeAttendance.ENTER_TIME_PROPERTY.equals(property)){
			checkEnterTimeOfEmployeeAttendance(userContext, parseDate(newValueExpr), exception);
		}
		
		if(EmployeeAttendance.LEAVE_TIME_PROPERTY.equals(property)){
			checkLeaveTimeOfEmployeeAttendance(userContext, parseDate(newValueExpr), exception);
		}
		
		if(EmployeeAttendance.DURATION_HOURS_PROPERTY.equals(property)){
			checkDurationHoursOfEmployeeAttendance(userContext, parseInt(newValueExpr), exception);
		}
		
		if(EmployeeAttendance.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeAttendance(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeAttendance(RetailScmUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeAttendance(userContext, employeeId, employeeAttendanceId, employeeAttendanceVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeAttendance( employeeAttendance );	
			//make changes to AcceleraterAccount.
			EmployeeAttendance employeeAttendanceIndex = createIndexedEmployeeAttendance(employeeAttendanceId, employeeAttendanceVersion);
		
			EmployeeAttendance employeeAttendance = employee.findTheEmployeeAttendance(employeeAttendanceIndex);
			if(employeeAttendance == null){
				throw new EmployeeManagerException(employeeAttendance+"Not found" );
			}
			
			employeeAttendance.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeAttendanceList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeQualifier(RetailScmUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);

		checkQualifiedTimeOfEmployeeQualifier(userContext,  qualifiedTime, exception);
		checkTypeOfEmployeeQualifier(userContext,  type, exception);
		checkLevelOfEmployeeQualifier(userContext,  level, exception);
		checkRemarkOfEmployeeQualifier(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeQualifier(RetailScmUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeQualifier(userContext,employeeId,qualifiedTime, type, level, remark,tokensExpr);
		
		EmployeeQualifier employeeQualifier = createEmployeeQualifier(userContext,qualifiedTime, type, level, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeQualifier( employeeQualifier );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeQualifier createEmployeeQualifier(RetailScmUserContext userContext, Date qualifiedTime, String type, String level, String remark) throws Exception{

		EmployeeQualifier employeeQualifier = new EmployeeQualifier();
		
		
		employeeQualifier.setQualifiedTime(qualifiedTime);		
		employeeQualifier.setType(type);		
		employeeQualifier.setLevel(level);		
		employeeQualifier.setRemark(remark);
	
		
		return employeeQualifier;
	
		
	}
	
	protected EmployeeQualifier createIndexedEmployeeQualifier(String id, int version){

		EmployeeQualifier employeeQualifier = new EmployeeQualifier();
		employeeQualifier.setId(id);
		employeeQualifier.setVersion(version);
		return employeeQualifier;			
		
	}
	protected void checkParamsForRemovingEmployeeQualifier(RetailScmUserContext userContext, String employeeId, 
		String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeQualifier(userContext, employeeQualifierId, exception);
		checkVersionOfEmployeeQualifier(userContext, employeeQualifierVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeQualifier(RetailScmUserContext userContext, String employeeId, 
		String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeQualifier(userContext,employeeId, employeeQualifierId, employeeQualifierVersion,tokensExpr);
		
		EmployeeQualifier employeeQualifier = createIndexedEmployeeQualifier(employeeQualifierId, employeeQualifierVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeQualifier( employeeQualifier );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeQualifier(RetailScmUserContext userContext, String employeeId, 
		String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeQualifier(userContext, employeeQualifierId, exception);
		checkVersionOfEmployeeQualifier(userContext, employeeQualifierVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeQualifierFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeQualifier(userContext,employeeId, employeeQualifierId, employeeQualifierVersion,tokensExpr);
		
		EmployeeQualifier employeeQualifier = createIndexedEmployeeQualifier(employeeQualifierId, employeeQualifierVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeQualifierFrom( employeeQualifier );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeQualifier(RetailScmUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeQualifier(userContext, employeeQualifierId, exception);
		checkVersionOfEmployeeQualifier(userContext, employeeQualifierVersion, exception);
		

		if(EmployeeQualifier.QUALIFIED_TIME_PROPERTY.equals(property)){
			checkQualifiedTimeOfEmployeeQualifier(userContext, parseDate(newValueExpr), exception);
		}
		
		if(EmployeeQualifier.TYPE_PROPERTY.equals(property)){
			checkTypeOfEmployeeQualifier(userContext, parseString(newValueExpr), exception);
		}
		
		if(EmployeeQualifier.LEVEL_PROPERTY.equals(property)){
			checkLevelOfEmployeeQualifier(userContext, parseString(newValueExpr), exception);
		}
		
		if(EmployeeQualifier.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeQualifier(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeQualifier(RetailScmUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeQualifier(userContext, employeeId, employeeQualifierId, employeeQualifierVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeQualifier( employeeQualifier );	
			//make changes to AcceleraterAccount.
			EmployeeQualifier employeeQualifierIndex = createIndexedEmployeeQualifier(employeeQualifierId, employeeQualifierVersion);
		
			EmployeeQualifier employeeQualifier = employee.findTheEmployeeQualifier(employeeQualifierIndex);
			if(employeeQualifier == null){
				throw new EmployeeManagerException(employeeQualifier+"Not found" );
			}
			
			employeeQualifier.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeQualifierList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeEducation(RetailScmUserContext userContext, String employeeId, Date completeTime, String type, String remark,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);

		checkCompleteTimeOfEmployeeEducation(userContext,  completeTime, exception);
		checkTypeOfEmployeeEducation(userContext,  type, exception);
		checkRemarkOfEmployeeEducation(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeEducation(RetailScmUserContext userContext, String employeeId, Date completeTime, String type, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeEducation(userContext,employeeId,completeTime, type, remark,tokensExpr);
		
		EmployeeEducation employeeEducation = createEmployeeEducation(userContext,completeTime, type, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeEducation( employeeEducation );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeEducation createEmployeeEducation(RetailScmUserContext userContext, Date completeTime, String type, String remark) throws Exception{

		EmployeeEducation employeeEducation = new EmployeeEducation();
		
		
		employeeEducation.setCompleteTime(completeTime);		
		employeeEducation.setType(type);		
		employeeEducation.setRemark(remark);
	
		
		return employeeEducation;
	
		
	}
	
	protected EmployeeEducation createIndexedEmployeeEducation(String id, int version){

		EmployeeEducation employeeEducation = new EmployeeEducation();
		employeeEducation.setId(id);
		employeeEducation.setVersion(version);
		return employeeEducation;			
		
	}
	protected void checkParamsForRemovingEmployeeEducation(RetailScmUserContext userContext, String employeeId, 
		String employeeEducationId, int employeeEducationVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeEducation(userContext, employeeEducationId, exception);
		checkVersionOfEmployeeEducation(userContext, employeeEducationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeEducation(RetailScmUserContext userContext, String employeeId, 
		String employeeEducationId, int employeeEducationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeEducation(userContext,employeeId, employeeEducationId, employeeEducationVersion,tokensExpr);
		
		EmployeeEducation employeeEducation = createIndexedEmployeeEducation(employeeEducationId, employeeEducationVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeEducation( employeeEducation );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeEducation(RetailScmUserContext userContext, String employeeId, 
		String employeeEducationId, int employeeEducationVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeEducation(userContext, employeeEducationId, exception);
		checkVersionOfEmployeeEducation(userContext, employeeEducationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeEducationFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeEducationId, int employeeEducationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeEducation(userContext,employeeId, employeeEducationId, employeeEducationVersion,tokensExpr);
		
		EmployeeEducation employeeEducation = createIndexedEmployeeEducation(employeeEducationId, employeeEducationVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeEducationFrom( employeeEducation );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeEducation(RetailScmUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeEducation(userContext, employeeEducationId, exception);
		checkVersionOfEmployeeEducation(userContext, employeeEducationVersion, exception);
		

		if(EmployeeEducation.COMPLETE_TIME_PROPERTY.equals(property)){
			checkCompleteTimeOfEmployeeEducation(userContext, parseDate(newValueExpr), exception);
		}
		
		if(EmployeeEducation.TYPE_PROPERTY.equals(property)){
			checkTypeOfEmployeeEducation(userContext, parseString(newValueExpr), exception);
		}
		
		if(EmployeeEducation.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeEducation(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeEducation(RetailScmUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeEducation(userContext, employeeId, employeeEducationId, employeeEducationVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeEducation( employeeEducation );	
			//make changes to AcceleraterAccount.
			EmployeeEducation employeeEducationIndex = createIndexedEmployeeEducation(employeeEducationId, employeeEducationVersion);
		
			EmployeeEducation employeeEducation = employee.findTheEmployeeEducation(employeeEducationIndex);
			if(employeeEducation == null){
				throw new EmployeeManagerException(employeeEducation+"Not found" );
			}
			
			employeeEducation.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeEducationList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeAward(RetailScmUserContext userContext, String employeeId, Date completeTime, String type, String remark,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);

		checkCompleteTimeOfEmployeeAward(userContext,  completeTime, exception);
		checkTypeOfEmployeeAward(userContext,  type, exception);
		checkRemarkOfEmployeeAward(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeAward(RetailScmUserContext userContext, String employeeId, Date completeTime, String type, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeAward(userContext,employeeId,completeTime, type, remark,tokensExpr);
		
		EmployeeAward employeeAward = createEmployeeAward(userContext,completeTime, type, remark);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeAward( employeeAward );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeAward createEmployeeAward(RetailScmUserContext userContext, Date completeTime, String type, String remark) throws Exception{

		EmployeeAward employeeAward = new EmployeeAward();
		
		
		employeeAward.setCompleteTime(completeTime);		
		employeeAward.setType(type);		
		employeeAward.setRemark(remark);
	
		
		return employeeAward;
	
		
	}
	
	protected EmployeeAward createIndexedEmployeeAward(String id, int version){

		EmployeeAward employeeAward = new EmployeeAward();
		employeeAward.setId(id);
		employeeAward.setVersion(version);
		return employeeAward;			
		
	}
	protected void checkParamsForRemovingEmployeeAward(RetailScmUserContext userContext, String employeeId, 
		String employeeAwardId, int employeeAwardVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeAward(userContext, employeeAwardId, exception);
		checkVersionOfEmployeeAward(userContext, employeeAwardVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeAward(RetailScmUserContext userContext, String employeeId, 
		String employeeAwardId, int employeeAwardVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeAward(userContext,employeeId, employeeAwardId, employeeAwardVersion,tokensExpr);
		
		EmployeeAward employeeAward = createIndexedEmployeeAward(employeeAwardId, employeeAwardVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeAward( employeeAward );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeAward(RetailScmUserContext userContext, String employeeId, 
		String employeeAwardId, int employeeAwardVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeAward(userContext, employeeAwardId, exception);
		checkVersionOfEmployeeAward(userContext, employeeAwardVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeAwardFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeAwardId, int employeeAwardVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeAward(userContext,employeeId, employeeAwardId, employeeAwardVersion,tokensExpr);
		
		EmployeeAward employeeAward = createIndexedEmployeeAward(employeeAwardId, employeeAwardVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeAwardFrom( employeeAward );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeAward(RetailScmUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeAward(userContext, employeeAwardId, exception);
		checkVersionOfEmployeeAward(userContext, employeeAwardVersion, exception);
		

		if(EmployeeAward.COMPLETE_TIME_PROPERTY.equals(property)){
			checkCompleteTimeOfEmployeeAward(userContext, parseDate(newValueExpr), exception);
		}
		
		if(EmployeeAward.TYPE_PROPERTY.equals(property)){
			checkTypeOfEmployeeAward(userContext, parseString(newValueExpr), exception);
		}
		
		if(EmployeeAward.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeAward(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeAward(RetailScmUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeAward(userContext, employeeId, employeeAwardId, employeeAwardVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeAward( employeeAward );	
			//make changes to AcceleraterAccount.
			EmployeeAward employeeAwardIndex = createIndexedEmployeeAward(employeeAwardId, employeeAwardVersion);
		
			EmployeeAward employeeAward = employee.findTheEmployeeAward(employeeAwardIndex);
			if(employeeAward == null){
				throw new EmployeeManagerException(employeeAward+"Not found" );
			}
			
			employeeAward.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeAwardList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		
		
		checkIdOfSalaryGrade(userContext,  currentSalaryGradeId, exception);
		checkBaseSalaryOfEmployeeSalarySheet(userContext,  baseSalary, exception);
		checkBonusOfEmployeeSalarySheet(userContext,  bonus, exception);
		checkRewardOfEmployeeSalarySheet(userContext,  reward, exception);
		checkPersonalTaxOfEmployeeSalarySheet(userContext,  personalTax, exception);
		checkSocialSecurityOfEmployeeSalarySheet(userContext,  socialSecurity, exception);
		checkHousingFoundOfEmployeeSalarySheet(userContext,  housingFound, exception);
		checkJobInsuranceOfEmployeeSalarySheet(userContext,  jobInsurance, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSalarySheet(userContext,employeeId,currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createEmployeeSalarySheet(userContext,currentSalaryGradeId, baseSalary, bonus, reward, personalTax, socialSecurity, housingFound, jobInsurance);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addEmployeeSalarySheet( employeeSalarySheet );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeSalarySheet createEmployeeSalarySheet(RetailScmUserContext userContext, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance) throws Exception{

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		
		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employeeSalarySheet.setCurrentSalaryGrade(currentSalaryGrade);		
		employeeSalarySheet.setBaseSalary(baseSalary);		
		employeeSalarySheet.setBonus(bonus);		
		employeeSalarySheet.setReward(reward);		
		employeeSalarySheet.setPersonalTax(personalTax);		
		employeeSalarySheet.setSocialSecurity(socialSecurity);		
		employeeSalarySheet.setHousingFound(housingFound);		
		employeeSalarySheet.setJobInsurance(jobInsurance);
	
		
		return employeeSalarySheet;
	
		
	}
	
	protected EmployeeSalarySheet createIndexedEmployeeSalarySheet(String id, int version){

		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		employeeSalarySheet.setId(id);
		employeeSalarySheet.setVersion(version);
		return employeeSalarySheet;			
		
	}
	protected void checkParamsForRemovingEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		checkVersionOfEmployeeSalarySheet(userContext, employeeSalarySheetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removeEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSalarySheet(userContext,employeeId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removeEmployeeSalarySheet( employeeSalarySheet );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		checkVersionOfEmployeeSalarySheet(userContext, employeeSalarySheetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyEmployeeSalarySheetFrom(RetailScmUserContext userContext, String employeeId, 
		String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSalarySheet(userContext,employeeId, employeeSalarySheetId, employeeSalarySheetVersion,tokensExpr);
		
		EmployeeSalarySheet employeeSalarySheet = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyEmployeeSalarySheetFrom( employeeSalarySheet );		
			employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfEmployeeSalarySheet(userContext, employeeSalarySheetId, exception);
		checkVersionOfEmployeeSalarySheet(userContext, employeeSalarySheetVersion, exception);
		

		if(EmployeeSalarySheet.BASE_SALARY_PROPERTY.equals(property)){
			checkBaseSalaryOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.BONUS_PROPERTY.equals(property)){
			checkBonusOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.REWARD_PROPERTY.equals(property)){
			checkRewardOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY.equals(property)){
			checkPersonalTaxOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY.equals(property)){
			checkSocialSecurityOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY.equals(property)){
			checkHousingFoundOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY.equals(property)){
			checkJobInsuranceOfEmployeeSalarySheet(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updateEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSalarySheet(userContext, employeeId, employeeSalarySheetId, employeeSalarySheetVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removeEmployeeSalarySheet( employeeSalarySheet );	
			//make changes to AcceleraterAccount.
			EmployeeSalarySheet employeeSalarySheetIndex = createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
		
			EmployeeSalarySheet employeeSalarySheet = employee.findTheEmployeeSalarySheet(employeeSalarySheetIndex);
			if(employeeSalarySheet == null){
				throw new EmployeeManagerException(employeeSalarySheet+"Not found" );
			}
			
			employeeSalarySheet.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withEmployeeSalarySheetList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingPayingOff(RetailScmUserContext userContext, String employeeId, String who, Date paidTime, double amount,String [] tokensExpr) throws Exception{
		
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);

		checkWhoOfPayingOff(userContext,  who, exception);
		checkPaidTimeOfPayingOff(userContext,  paidTime, exception);
		checkAmountOfPayingOff(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  Employee addPayingOff(RetailScmUserContext userContext, String employeeId, String who, Date paidTime, double amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPayingOff(userContext,employeeId,who, paidTime, amount,tokensExpr);
		
		PayingOff payingOff = createPayingOff(userContext,who, paidTime, amount);
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.addPayingOff( payingOff );		
			employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
	}
	protected PayingOff createPayingOff(RetailScmUserContext userContext, String who, Date paidTime, double amount) throws Exception{

		PayingOff payingOff = new PayingOff();
		
		
		payingOff.setWho(who);		
		payingOff.setPaidTime(paidTime);		
		payingOff.setAmount(amount);
	
		
		return payingOff;
	
		
	}
	
	protected PayingOff createIndexedPayingOff(String id, int version){

		PayingOff payingOff = new PayingOff();
		payingOff.setId(id);
		payingOff.setVersion(version);
		return payingOff;			
		
	}
	protected void checkParamsForRemovingPayingOff(RetailScmUserContext userContext, String employeeId, 
		String payingOffId, int payingOffVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfPayingOff(userContext, payingOffId, exception);
		checkVersionOfPayingOff(userContext, payingOffVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee removePayingOff(RetailScmUserContext userContext, String employeeId, 
		String payingOffId, int payingOffVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPayingOff(userContext,employeeId, payingOffId, payingOffVersion,tokensExpr);
		
		PayingOff payingOff = createIndexedPayingOff(payingOffId, payingOffVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.removePayingOff( payingOff );		
			employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingPayingOff(RetailScmUserContext userContext, String employeeId, 
		String payingOffId, int payingOffVersion,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfPayingOff(userContext, payingOffId, exception);
		checkVersionOfPayingOff(userContext, payingOffVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Employee copyPayingOffFrom(RetailScmUserContext userContext, String employeeId, 
		String payingOffId, int payingOffVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPayingOff(userContext,employeeId, payingOffId, payingOffVersion,tokensExpr);
		
		PayingOff payingOff = createIndexedPayingOff(payingOffId, payingOffVersion);
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employee.copyPayingOffFrom( payingOff );		
			employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingPayingOff(RetailScmUserContext userContext, String employeeId, String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		EmployeeManagerException exception = new EmployeeManagerException("Error Occured");
		
		checkIdOfEmployee(userContext, employeeId, exception);
		checkIdOfPayingOff(userContext, payingOffId, exception);
		checkVersionOfPayingOff(userContext, payingOffVersion, exception);
		

		if(PayingOff.WHO_PROPERTY.equals(property)){
			checkWhoOfPayingOff(userContext, parseString(newValueExpr), exception);
		}
		
		if(PayingOff.PAID_TIME_PROPERTY.equals(property)){
			checkPaidTimeOfPayingOff(userContext, parseDate(newValueExpr), exception);
		}
		
		if(PayingOff.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfPayingOff(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  Employee updatePayingOff(RetailScmUserContext userContext, String employeeId, String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPayingOff(userContext, employeeId, payingOffId, payingOffVersion, property, newValueExpr,  tokensExpr);
		
		
		Employee employee = loadEmployee(userContext, employeeId, allTokens());
		
		synchronized(employee){ 
			//Will be good when the employee loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employee.removePayingOff( payingOff );	
			//make changes to AcceleraterAccount.
			PayingOff payingOffIndex = createIndexedPayingOff(payingOffId, payingOffVersion);
		
			PayingOff payingOff = employee.findThePayingOff(payingOffIndex);
			if(payingOff == null){
				throw new EmployeeManagerException(payingOff+"Not found" );
			}
			
			payingOff.changePropery(property, newValueExpr);

			employee = saveEmployee(userContext, employee, tokens().withPayingOffList().done());
			return present(userContext,employee, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


