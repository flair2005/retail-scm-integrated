
package com.skynet.retailscm.employee;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
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

import com.skynet.retailscm.employeeleave.EmployeeLeaveDAO;
import com.skynet.retailscm.employeeinterview.EmployeeInterviewDAO;
import com.skynet.retailscm.employeeperformance.EmployeePerformanceDAO;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartmentDAO;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;
import com.skynet.retailscm.responsibilitytype.ResponsibilityTypeDAO;
import com.skynet.retailscm.hrinterview.HrInterviewDAO;
import com.skynet.retailscm.termination.TerminationDAO;
import com.skynet.retailscm.employeeaward.EmployeeAwardDAO;
import com.skynet.retailscm.occupationtype.OccupationTypeDAO;
import com.skynet.retailscm.payingoff.PayingOffDAO;
import com.skynet.retailscm.employeeattendance.EmployeeAttendanceDAO;
import com.skynet.retailscm.jobapplication.JobApplicationDAO;
import com.skynet.retailscm.employeeskill.EmployeeSkillDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.employeeworkexperience.EmployeeWorkExperienceDAO;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.skynet.retailscm.professioninterview.ProfessionInterviewDAO;
import com.skynet.retailscm.offerapproval.OfferApprovalDAO;
import com.skynet.retailscm.offeracceptance.OfferAcceptanceDAO;
import com.skynet.retailscm.salarygrade.SalaryGradeDAO;
import com.skynet.retailscm.employeeeducation.EmployeeEducationDAO;
import com.skynet.retailscm.employeeboarding.EmployeeBoardingDAO;
import com.skynet.retailscm.employeequalifier.EmployeeQualifierDAO;

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


import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeDAO{
 
 	
 	private  TerminationDAO  terminationDAO;
 	public void setTerminationDAO(TerminationDAO terminationDAO){
	 	this.terminationDAO = terminationDAO;
 	}
 	public TerminationDAO getTerminationDAO(){
	 	return this.terminationDAO;
 	}
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  ResponsibilityTypeDAO  responsibilityTypeDAO;
 	public void setResponsibilityTypeDAO(ResponsibilityTypeDAO responsibilityTypeDAO){
	 	this.responsibilityTypeDAO = responsibilityTypeDAO;
 	}
 	public ResponsibilityTypeDAO getResponsibilityTypeDAO(){
	 	return this.responsibilityTypeDAO;
 	}
 
 	
 	private  SalaryGradeDAO  salaryGradeDAO;
 	public void setSalaryGradeDAO(SalaryGradeDAO salaryGradeDAO){
	 	this.salaryGradeDAO = salaryGradeDAO;
 	}
 	public SalaryGradeDAO getSalaryGradeDAO(){
	 	return this.salaryGradeDAO;
 	}
 
 	
 	private  LevelThreeDepartmentDAO  levelThreeDepartmentDAO;
 	public void setLevelThreeDepartmentDAO(LevelThreeDepartmentDAO levelThreeDepartmentDAO){
	 	this.levelThreeDepartmentDAO = levelThreeDepartmentDAO;
 	}
 	public LevelThreeDepartmentDAO getLevelThreeDepartmentDAO(){
	 	return this.levelThreeDepartmentDAO;
 	}
 
 	
 	private  OccupationTypeDAO  occupationTypeDAO;
 	public void setOccupationTypeDAO(OccupationTypeDAO occupationTypeDAO){
	 	this.occupationTypeDAO = occupationTypeDAO;
 	}
 	public OccupationTypeDAO getOccupationTypeDAO(){
	 	return this.occupationTypeDAO;
 	}
 
 	
 	private  JobApplicationDAO  jobApplicationDAO;
 	public void setJobApplicationDAO(JobApplicationDAO jobApplicationDAO){
	 	this.jobApplicationDAO = jobApplicationDAO;
 	}
 	public JobApplicationDAO getJobApplicationDAO(){
	 	return this.jobApplicationDAO;
 	}
 
 	
 	private  OfferAcceptanceDAO  offerAcceptanceDAO;
 	public void setOfferAcceptanceDAO(OfferAcceptanceDAO offerAcceptanceDAO){
	 	this.offerAcceptanceDAO = offerAcceptanceDAO;
 	}
 	public OfferAcceptanceDAO getOfferAcceptanceDAO(){
	 	return this.offerAcceptanceDAO;
 	}
 
 	
 	private  OfferApprovalDAO  offerApprovalDAO;
 	public void setOfferApprovalDAO(OfferApprovalDAO offerApprovalDAO){
	 	this.offerApprovalDAO = offerApprovalDAO;
 	}
 	public OfferApprovalDAO getOfferApprovalDAO(){
	 	return this.offerApprovalDAO;
 	}
 
 	
 	private  ProfessionInterviewDAO  professionInterviewDAO;
 	public void setProfessionInterviewDAO(ProfessionInterviewDAO professionInterviewDAO){
	 	this.professionInterviewDAO = professionInterviewDAO;
 	}
 	public ProfessionInterviewDAO getProfessionInterviewDAO(){
	 	return this.professionInterviewDAO;
 	}
 
 	
 	private  HrInterviewDAO  hrInterviewDAO;
 	public void setHrInterviewDAO(HrInterviewDAO hrInterviewDAO){
	 	this.hrInterviewDAO = hrInterviewDAO;
 	}
 	public HrInterviewDAO getHrInterviewDAO(){
	 	return this.hrInterviewDAO;
 	}
 
 	
 	private  EmployeeBoardingDAO  employeeBoardingDAO;
 	public void setEmployeeBoardingDAO(EmployeeBoardingDAO employeeBoardingDAO){
	 	this.employeeBoardingDAO = employeeBoardingDAO;
 	}
 	public EmployeeBoardingDAO getEmployeeBoardingDAO(){
	 	return this.employeeBoardingDAO;
 	}

		
	
  	private  EmployeeCompanyTrainingDAO  employeeCompanyTrainingDAO;
 	public void setEmployeeCompanyTrainingDAO(EmployeeCompanyTrainingDAO pEmployeeCompanyTrainingDAO){
 	
 		if(pEmployeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set employeeCompanyTrainingDAO to null.");
 		}
	 	this.employeeCompanyTrainingDAO = pEmployeeCompanyTrainingDAO;
 	}
 	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO(){
 		if(this.employeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("The employeeCompanyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeCompanyTrainingDAO;
 	}	
 	
			
		
	
  	private  EmployeeSkillDAO  employeeSkillDAO;
 	public void setEmployeeSkillDAO(EmployeeSkillDAO pEmployeeSkillDAO){
 	
 		if(pEmployeeSkillDAO == null){
 			throw new IllegalStateException("Do not try to set employeeSkillDAO to null.");
 		}
	 	this.employeeSkillDAO = pEmployeeSkillDAO;
 	}
 	public EmployeeSkillDAO getEmployeeSkillDAO(){
 		if(this.employeeSkillDAO == null){
 			throw new IllegalStateException("The employeeSkillDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeSkillDAO;
 	}	
 	
			
		
	
  	private  EmployeePerformanceDAO  employeePerformanceDAO;
 	public void setEmployeePerformanceDAO(EmployeePerformanceDAO pEmployeePerformanceDAO){
 	
 		if(pEmployeePerformanceDAO == null){
 			throw new IllegalStateException("Do not try to set employeePerformanceDAO to null.");
 		}
	 	this.employeePerformanceDAO = pEmployeePerformanceDAO;
 	}
 	public EmployeePerformanceDAO getEmployeePerformanceDAO(){
 		if(this.employeePerformanceDAO == null){
 			throw new IllegalStateException("The employeePerformanceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeePerformanceDAO;
 	}	
 	
			
		
	
  	private  EmployeeWorkExperienceDAO  employeeWorkExperienceDAO;
 	public void setEmployeeWorkExperienceDAO(EmployeeWorkExperienceDAO pEmployeeWorkExperienceDAO){
 	
 		if(pEmployeeWorkExperienceDAO == null){
 			throw new IllegalStateException("Do not try to set employeeWorkExperienceDAO to null.");
 		}
	 	this.employeeWorkExperienceDAO = pEmployeeWorkExperienceDAO;
 	}
 	public EmployeeWorkExperienceDAO getEmployeeWorkExperienceDAO(){
 		if(this.employeeWorkExperienceDAO == null){
 			throw new IllegalStateException("The employeeWorkExperienceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeWorkExperienceDAO;
 	}	
 	
			
		
	
  	private  EmployeeLeaveDAO  employeeLeaveDAO;
 	public void setEmployeeLeaveDAO(EmployeeLeaveDAO pEmployeeLeaveDAO){
 	
 		if(pEmployeeLeaveDAO == null){
 			throw new IllegalStateException("Do not try to set employeeLeaveDAO to null.");
 		}
	 	this.employeeLeaveDAO = pEmployeeLeaveDAO;
 	}
 	public EmployeeLeaveDAO getEmployeeLeaveDAO(){
 		if(this.employeeLeaveDAO == null){
 			throw new IllegalStateException("The employeeLeaveDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeLeaveDAO;
 	}	
 	
			
		
	
  	private  EmployeeInterviewDAO  employeeInterviewDAO;
 	public void setEmployeeInterviewDAO(EmployeeInterviewDAO pEmployeeInterviewDAO){
 	
 		if(pEmployeeInterviewDAO == null){
 			throw new IllegalStateException("Do not try to set employeeInterviewDAO to null.");
 		}
	 	this.employeeInterviewDAO = pEmployeeInterviewDAO;
 	}
 	public EmployeeInterviewDAO getEmployeeInterviewDAO(){
 		if(this.employeeInterviewDAO == null){
 			throw new IllegalStateException("The employeeInterviewDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeInterviewDAO;
 	}	
 	
			
		
	
  	private  EmployeeAttendanceDAO  employeeAttendanceDAO;
 	public void setEmployeeAttendanceDAO(EmployeeAttendanceDAO pEmployeeAttendanceDAO){
 	
 		if(pEmployeeAttendanceDAO == null){
 			throw new IllegalStateException("Do not try to set employeeAttendanceDAO to null.");
 		}
	 	this.employeeAttendanceDAO = pEmployeeAttendanceDAO;
 	}
 	public EmployeeAttendanceDAO getEmployeeAttendanceDAO(){
 		if(this.employeeAttendanceDAO == null){
 			throw new IllegalStateException("The employeeAttendanceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeAttendanceDAO;
 	}	
 	
			
		
	
  	private  EmployeeQualifierDAO  employeeQualifierDAO;
 	public void setEmployeeQualifierDAO(EmployeeQualifierDAO pEmployeeQualifierDAO){
 	
 		if(pEmployeeQualifierDAO == null){
 			throw new IllegalStateException("Do not try to set employeeQualifierDAO to null.");
 		}
	 	this.employeeQualifierDAO = pEmployeeQualifierDAO;
 	}
 	public EmployeeQualifierDAO getEmployeeQualifierDAO(){
 		if(this.employeeQualifierDAO == null){
 			throw new IllegalStateException("The employeeQualifierDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeQualifierDAO;
 	}	
 	
			
		
	
  	private  EmployeeEducationDAO  employeeEducationDAO;
 	public void setEmployeeEducationDAO(EmployeeEducationDAO pEmployeeEducationDAO){
 	
 		if(pEmployeeEducationDAO == null){
 			throw new IllegalStateException("Do not try to set employeeEducationDAO to null.");
 		}
	 	this.employeeEducationDAO = pEmployeeEducationDAO;
 	}
 	public EmployeeEducationDAO getEmployeeEducationDAO(){
 		if(this.employeeEducationDAO == null){
 			throw new IllegalStateException("The employeeEducationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeEducationDAO;
 	}	
 	
			
		
	
  	private  EmployeeAwardDAO  employeeAwardDAO;
 	public void setEmployeeAwardDAO(EmployeeAwardDAO pEmployeeAwardDAO){
 	
 		if(pEmployeeAwardDAO == null){
 			throw new IllegalStateException("Do not try to set employeeAwardDAO to null.");
 		}
	 	this.employeeAwardDAO = pEmployeeAwardDAO;
 	}
 	public EmployeeAwardDAO getEmployeeAwardDAO(){
 		if(this.employeeAwardDAO == null){
 			throw new IllegalStateException("The employeeAwardDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeAwardDAO;
 	}	
 	
			
		
	
  	private  EmployeeSalarySheetDAO  employeeSalarySheetDAO;
 	public void setEmployeeSalarySheetDAO(EmployeeSalarySheetDAO pEmployeeSalarySheetDAO){
 	
 		if(pEmployeeSalarySheetDAO == null){
 			throw new IllegalStateException("Do not try to set employeeSalarySheetDAO to null.");
 		}
	 	this.employeeSalarySheetDAO = pEmployeeSalarySheetDAO;
 	}
 	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO(){
 		if(this.employeeSalarySheetDAO == null){
 			throw new IllegalStateException("The employeeSalarySheetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeSalarySheetDAO;
 	}	
 	
			
		
	
  	private  PayingOffDAO  payingOffDAO;
 	public void setPayingOffDAO(PayingOffDAO pPayingOffDAO){
 	
 		if(pPayingOffDAO == null){
 			throw new IllegalStateException("Do not try to set payingOffDAO to null.");
 		}
	 	this.payingOffDAO = pPayingOffDAO;
 	}
 	public PayingOffDAO getPayingOffDAO(){
 		if(this.payingOffDAO == null){
 			throw new IllegalStateException("The payingOffDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.payingOffDAO;
 	}	
 	
			
		

	
	/*
	protected Employee load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployee(accessKey, options);
	}
	*/
	public Employee load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployee(EmployeeTable.withId(id), options);
	}
	
	
	
	public Employee save(Employee employee,Map<String,Object> options){
		
		String methodName="save(Employee employee,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employee, methodName, "employee");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployee(employee,options);
	}
	public Employee clone(String employeeId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeTable.withId(employeeId),options);
	}
	
	protected Employee clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Employee newEmployee = loadInternalEmployee(accessKey, options);
		newEmployee.setVersion(0);
		
		
 		
 		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
 			for(EmployeeCompanyTraining item: newEmployee.getEmployeeCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeSkillListEnabled(options)){
 			for(EmployeeSkill item: newEmployee.getEmployeeSkillList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeePerformanceListEnabled(options)){
 			for(EmployeePerformance item: newEmployee.getEmployeePerformanceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeWorkExperienceListEnabled(options)){
 			for(EmployeeWorkExperience item: newEmployee.getEmployeeWorkExperienceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeLeaveListEnabled(options)){
 			for(EmployeeLeave item: newEmployee.getEmployeeLeaveList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeInterviewListEnabled(options)){
 			for(EmployeeInterview item: newEmployee.getEmployeeInterviewList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeAttendanceListEnabled(options)){
 			for(EmployeeAttendance item: newEmployee.getEmployeeAttendanceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeQualifierListEnabled(options)){
 			for(EmployeeQualifier item: newEmployee.getEmployeeQualifierList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeEducationListEnabled(options)){
 			for(EmployeeEducation item: newEmployee.getEmployeeEducationList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeAwardListEnabled(options)){
 			for(EmployeeAward item: newEmployee.getEmployeeAwardList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeSalarySheetListEnabled(options)){
 			for(EmployeeSalarySheet item: newEmployee.getEmployeeSalarySheetList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePayingOffListEnabled(options)){
 			for(PayingOff item: newEmployee.getPayingOffList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalEmployee(newEmployee,options);
		
		return newEmployee;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeNotFoundException(
					"The " + this.getTableName() + "(" + employeeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeId, int version) throws Exception{
	
		String methodName="delete(String employeeId, int version)";
		assertMethodArgumentNotNull(employeeId, methodName, "employeeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"company","title","department","family_name","given_name","email","city","address","cell_phone","occupation","responsible_for","current_salary_grade","salary_account","job_application","profession_interview","hr_interview","offer_approval","offer_acceptance","employee_boarding","termination","current_status"};
		return EmployeeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.COMPANY);
 	}
 	

 	
  
 	//private boolean extractDepartmentEnabled = true;
 	//private static final String DEPARTMENT = "department";
 	protected boolean isExtractDepartmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.DEPARTMENT);
 	}
 	
 	
 	//private boolean saveDepartmentEnabled = true;
 	protected boolean isSaveDepartmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.DEPARTMENT);
 	}
 	

 	
  
 	//private boolean extractOccupationEnabled = true;
 	//private static final String OCCUPATION = "occupation";
 	protected boolean isExtractOccupationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.OCCUPATION);
 	}
 	
 	
 	//private boolean saveOccupationEnabled = true;
 	protected boolean isSaveOccupationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.OCCUPATION);
 	}
 	

 	
  
 	//private boolean extractResponsibleForEnabled = true;
 	//private static final String RESPONSIBLEFOR = "responsibleFor";
 	protected boolean isExtractResponsibleForEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.RESPONSIBLEFOR);
 	}
 	
 	
 	//private boolean saveResponsibleForEnabled = true;
 	protected boolean isSaveResponsibleForEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.RESPONSIBLEFOR);
 	}
 	

 	
  
 	//private boolean extractCurrentSalaryGradeEnabled = true;
 	//private static final String CURRENTSALARYGRADE = "currentSalaryGrade";
 	protected boolean isExtractCurrentSalaryGradeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.CURRENTSALARYGRADE);
 	}
 	
 	
 	//private boolean saveCurrentSalaryGradeEnabled = true;
 	protected boolean isSaveCurrentSalaryGradeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.CURRENTSALARYGRADE);
 	}
 	

 	
  
 	//private boolean extractJobApplicationEnabled = true;
 	//private static final String JOBAPPLICATION = "jobApplication";
 	protected boolean isExtractJobApplicationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.JOBAPPLICATION);
 	}
 	
 	
 	//private boolean saveJobApplicationEnabled = true;
 	protected boolean isSaveJobApplicationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.JOBAPPLICATION);
 	}
 	

 	
  
 	//private boolean extractProfessionInterviewEnabled = true;
 	//private static final String PROFESSIONINTERVIEW = "professionInterview";
 	protected boolean isExtractProfessionInterviewEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.PROFESSIONINTERVIEW);
 	}
 	
 	
 	//private boolean saveProfessionInterviewEnabled = true;
 	protected boolean isSaveProfessionInterviewEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.PROFESSIONINTERVIEW);
 	}
 	

 	
  
 	//private boolean extractHrInterviewEnabled = true;
 	//private static final String HRINTERVIEW = "hrInterview";
 	protected boolean isExtractHrInterviewEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.HRINTERVIEW);
 	}
 	
 	
 	//private boolean saveHrInterviewEnabled = true;
 	protected boolean isSaveHrInterviewEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.HRINTERVIEW);
 	}
 	

 	
  
 	//private boolean extractOfferApprovalEnabled = true;
 	//private static final String OFFERAPPROVAL = "offerApproval";
 	protected boolean isExtractOfferApprovalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.OFFERAPPROVAL);
 	}
 	
 	
 	//private boolean saveOfferApprovalEnabled = true;
 	protected boolean isSaveOfferApprovalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.OFFERAPPROVAL);
 	}
 	

 	
  
 	//private boolean extractOfferAcceptanceEnabled = true;
 	//private static final String OFFERACCEPTANCE = "offerAcceptance";
 	protected boolean isExtractOfferAcceptanceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.OFFERACCEPTANCE);
 	}
 	
 	
 	//private boolean saveOfferAcceptanceEnabled = true;
 	protected boolean isSaveOfferAcceptanceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.OFFERACCEPTANCE);
 	}
 	

 	
  
 	//private boolean extractEmployeeBoardingEnabled = true;
 	//private static final String EMPLOYEEBOARDING = "employeeBoarding";
 	protected boolean isExtractEmployeeBoardingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.EMPLOYEEBOARDING);
 	}
 	
 	
 	//private boolean saveEmployeeBoardingEnabled = true;
 	protected boolean isSaveEmployeeBoardingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.EMPLOYEEBOARDING);
 	}
 	

 	
  
 	//private boolean extractTerminationEnabled = true;
 	//private static final String TERMINATION = "termination";
 	protected boolean isExtractTerminationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeTokens.TERMINATION);
 	}
 	
 	
 	//private boolean saveTerminationEnabled = true;
 	protected boolean isSaveTerminationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeTokens.TERMINATION);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";
	
	protected boolean isExtractEmployeeCompanyTrainingListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
		
 	}

	protected boolean isSaveEmployeeCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_SKILL_LIST = "employeeSkillList";
	
	protected boolean isExtractEmployeeSkillListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_SKILL_LIST);
		
 	}

	protected boolean isSaveEmployeeSkillListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_SKILL_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_PERFORMANCE_LIST = "employeePerformanceList";
	
	protected boolean isExtractEmployeePerformanceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_PERFORMANCE_LIST);
		
 	}

	protected boolean isSaveEmployeePerformanceListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_PERFORMANCE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_WORK_EXPERIENCE_LIST = "employeeWorkExperienceList";
	
	protected boolean isExtractEmployeeWorkExperienceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_WORK_EXPERIENCE_LIST);
		
 	}

	protected boolean isSaveEmployeeWorkExperienceListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_WORK_EXPERIENCE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_LEAVE_LIST = "employeeLeaveList";
	
	protected boolean isExtractEmployeeLeaveListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_LEAVE_LIST);
		
 	}

	protected boolean isSaveEmployeeLeaveListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_LEAVE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_INTERVIEW_LIST = "employeeInterviewList";
	
	protected boolean isExtractEmployeeInterviewListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_INTERVIEW_LIST);
		
 	}

	protected boolean isSaveEmployeeInterviewListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_INTERVIEW_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_ATTENDANCE_LIST = "employeeAttendanceList";
	
	protected boolean isExtractEmployeeAttendanceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_ATTENDANCE_LIST);
		
 	}

	protected boolean isSaveEmployeeAttendanceListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_ATTENDANCE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_QUALIFIER_LIST = "employeeQualifierList";
	
	protected boolean isExtractEmployeeQualifierListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_QUALIFIER_LIST);
		
 	}

	protected boolean isSaveEmployeeQualifierListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_QUALIFIER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_EDUCATION_LIST = "employeeEducationList";
	
	protected boolean isExtractEmployeeEducationListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_EDUCATION_LIST);
		
 	}

	protected boolean isSaveEmployeeEducationListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_EDUCATION_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_AWARD_LIST = "employeeAwardList";
	
	protected boolean isExtractEmployeeAwardListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_AWARD_LIST);
		
 	}

	protected boolean isSaveEmployeeAwardListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_AWARD_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_SALARY_SHEET_LIST = "employeeSalarySheetList";
	
	protected boolean isExtractEmployeeSalarySheetListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.EMPLOYEE_SALARY_SHEET_LIST);
		
 	}

	protected boolean isSaveEmployeeSalarySheetListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.EMPLOYEE_SALARY_SHEET_LIST);
		
 	}
 	
 	
			
		
	//protected static final String PAYING_OFF_LIST = "payingOffList";
	
	protected boolean isExtractPayingOffListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,EmployeeTokens.PAYING_OFF_LIST);
		
 	}

	protected boolean isSavePayingOffListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeTokens.PAYING_OFF_LIST);
		
 	}
 	
 	
			
		

	

	protected EmployeeMapper getEmployeeMapper(){
		return new EmployeeMapper();
	}
	protected Employee extractEmployee(String employeeId) throws Exception{
		String SQL = "select * from employee_data where id = ?";	
		try{
		
			Employee employee = queryForObject(SQL, new Object[]{employeeId}, getEmployeeMapper());
			return employee;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeNotFoundException("Employee("+employeeId+") is not found!");
		}
		
		
	}
	protected Employee extractEmployee(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Employee employee = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeMapper());
			return employee;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeNotFoundException("Employee("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Employee loadInternalEmployee(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Employee employee = extractEmployee(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(employee, loadOptions);
 		}
  	
 		if(isExtractDepartmentEnabled(loadOptions)){
	 		extractDepartment(employee, loadOptions);
 		}
  	
 		if(isExtractOccupationEnabled(loadOptions)){
	 		extractOccupation(employee, loadOptions);
 		}
  	
 		if(isExtractResponsibleForEnabled(loadOptions)){
	 		extractResponsibleFor(employee, loadOptions);
 		}
  	
 		if(isExtractCurrentSalaryGradeEnabled(loadOptions)){
	 		extractCurrentSalaryGrade(employee, loadOptions);
 		}
  	
 		if(isExtractJobApplicationEnabled(loadOptions)){
	 		extractJobApplication(employee, loadOptions);
 		}
  	
 		if(isExtractProfessionInterviewEnabled(loadOptions)){
	 		extractProfessionInterview(employee, loadOptions);
 		}
  	
 		if(isExtractHrInterviewEnabled(loadOptions)){
	 		extractHrInterview(employee, loadOptions);
 		}
  	
 		if(isExtractOfferApprovalEnabled(loadOptions)){
	 		extractOfferApproval(employee, loadOptions);
 		}
  	
 		if(isExtractOfferAcceptanceEnabled(loadOptions)){
	 		extractOfferAcceptance(employee, loadOptions);
 		}
  	
 		if(isExtractEmployeeBoardingEnabled(loadOptions)){
	 		extractEmployeeBoarding(employee, loadOptions);
 		}
  	
 		if(isExtractTerminationEnabled(loadOptions)){
	 		extractTermination(employee, loadOptions);
 		}
 
		
		if(isExtractEmployeeCompanyTrainingListEnabled(loadOptions)){
	 		extractEmployeeCompanyTrainingList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeeSkillListEnabled(loadOptions)){
	 		extractEmployeeSkillList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeePerformanceListEnabled(loadOptions)){
	 		extractEmployeePerformanceList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeeWorkExperienceListEnabled(loadOptions)){
	 		extractEmployeeWorkExperienceList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeeLeaveListEnabled(loadOptions)){
	 		extractEmployeeLeaveList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeeInterviewListEnabled(loadOptions)){
	 		extractEmployeeInterviewList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeeAttendanceListEnabled(loadOptions)){
	 		extractEmployeeAttendanceList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeeQualifierListEnabled(loadOptions)){
	 		extractEmployeeQualifierList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeeEducationListEnabled(loadOptions)){
	 		extractEmployeeEducationList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeeAwardListEnabled(loadOptions)){
	 		extractEmployeeAwardList(employee, loadOptions);
 		}		
		
		if(isExtractEmployeeSalarySheetListEnabled(loadOptions)){
	 		extractEmployeeSalarySheetList(employee, loadOptions);
 		}		
		
		if(isExtractPayingOffListEnabled(loadOptions)){
	 		extractPayingOffList(employee, loadOptions);
 		}		
		
		return employee;
		
	}



	
	
	 

 	protected Employee extractCompany(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getCompany() == null){
			return employee;
		}
		String companyId = employee.getCompany().getId();
		if( companyId == null){
			return employee;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			employee.setCompany(company);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractDepartment(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getDepartment() == null){
			return employee;
		}
		String departmentId = employee.getDepartment().getId();
		if( departmentId == null){
			return employee;
		}
		LevelThreeDepartment department = getLevelThreeDepartmentDAO().load(departmentId,options);
		if(department != null){
			employee.setDepartment(department);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractOccupation(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getOccupation() == null){
			return employee;
		}
		String occupationId = employee.getOccupation().getId();
		if( occupationId == null){
			return employee;
		}
		OccupationType occupation = getOccupationTypeDAO().load(occupationId,options);
		if(occupation != null){
			employee.setOccupation(occupation);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractResponsibleFor(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getResponsibleFor() == null){
			return employee;
		}
		String responsibleForId = employee.getResponsibleFor().getId();
		if( responsibleForId == null){
			return employee;
		}
		ResponsibilityType responsibleFor = getResponsibilityTypeDAO().load(responsibleForId,options);
		if(responsibleFor != null){
			employee.setResponsibleFor(responsibleFor);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractCurrentSalaryGrade(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getCurrentSalaryGrade() == null){
			return employee;
		}
		String currentSalaryGradeId = employee.getCurrentSalaryGrade().getId();
		if( currentSalaryGradeId == null){
			return employee;
		}
		SalaryGrade currentSalaryGrade = getSalaryGradeDAO().load(currentSalaryGradeId,options);
		if(currentSalaryGrade != null){
			employee.setCurrentSalaryGrade(currentSalaryGrade);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractJobApplication(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getJobApplication() == null){
			return employee;
		}
		String jobApplicationId = employee.getJobApplication().getId();
		if( jobApplicationId == null){
			return employee;
		}
		JobApplication jobApplication = getJobApplicationDAO().load(jobApplicationId,options);
		if(jobApplication != null){
			employee.setJobApplication(jobApplication);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractProfessionInterview(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getProfessionInterview() == null){
			return employee;
		}
		String professionInterviewId = employee.getProfessionInterview().getId();
		if( professionInterviewId == null){
			return employee;
		}
		ProfessionInterview professionInterview = getProfessionInterviewDAO().load(professionInterviewId,options);
		if(professionInterview != null){
			employee.setProfessionInterview(professionInterview);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractHrInterview(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getHrInterview() == null){
			return employee;
		}
		String hrInterviewId = employee.getHrInterview().getId();
		if( hrInterviewId == null){
			return employee;
		}
		HrInterview hrInterview = getHrInterviewDAO().load(hrInterviewId,options);
		if(hrInterview != null){
			employee.setHrInterview(hrInterview);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractOfferApproval(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getOfferApproval() == null){
			return employee;
		}
		String offerApprovalId = employee.getOfferApproval().getId();
		if( offerApprovalId == null){
			return employee;
		}
		OfferApproval offerApproval = getOfferApprovalDAO().load(offerApprovalId,options);
		if(offerApproval != null){
			employee.setOfferApproval(offerApproval);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractOfferAcceptance(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getOfferAcceptance() == null){
			return employee;
		}
		String offerAcceptanceId = employee.getOfferAcceptance().getId();
		if( offerAcceptanceId == null){
			return employee;
		}
		OfferAcceptance offerAcceptance = getOfferAcceptanceDAO().load(offerAcceptanceId,options);
		if(offerAcceptance != null){
			employee.setOfferAcceptance(offerAcceptance);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractEmployeeBoarding(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getEmployeeBoarding() == null){
			return employee;
		}
		String employeeBoardingId = employee.getEmployeeBoarding().getId();
		if( employeeBoardingId == null){
			return employee;
		}
		EmployeeBoarding employeeBoarding = getEmployeeBoardingDAO().load(employeeBoardingId,options);
		if(employeeBoarding != null){
			employee.setEmployeeBoarding(employeeBoarding);
		}
		
 		
 		return employee;
 	}
 		
  

 	protected Employee extractTermination(Employee employee, Map<String,Object> options) throws Exception{

		if(employee.getTermination() == null){
			return employee;
		}
		String terminationId = employee.getTermination().getId();
		if( terminationId == null){
			return employee;
		}
		Termination termination = getTerminationDAO().load(terminationId,options);
		if(termination != null){
			employee.setTermination(termination);
		}
		
 		
 		return employee;
 	}
 		
 
		
	protected Employee extractEmployeeCompanyTrainingList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingByEmployee(employee.getId(),options);
		if(employeeCompanyTrainingList != null){
			employee.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeeSkillList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeSkill> employeeSkillList = getEmployeeSkillDAO().findEmployeeSkillByEmployee(employee.getId(),options);
		if(employeeSkillList != null){
			employee.setEmployeeSkillList(employeeSkillList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeePerformanceList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeePerformance> employeePerformanceList = getEmployeePerformanceDAO().findEmployeePerformanceByEmployee(employee.getId(),options);
		if(employeePerformanceList != null){
			employee.setEmployeePerformanceList(employeePerformanceList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeeWorkExperienceList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeWorkExperience> employeeWorkExperienceList = getEmployeeWorkExperienceDAO().findEmployeeWorkExperienceByEmployee(employee.getId(),options);
		if(employeeWorkExperienceList != null){
			employee.setEmployeeWorkExperienceList(employeeWorkExperienceList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeeLeaveList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeLeave> employeeLeaveList = getEmployeeLeaveDAO().findEmployeeLeaveByWho(employee.getId(),options);
		if(employeeLeaveList != null){
			employee.setEmployeeLeaveList(employeeLeaveList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeeInterviewList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeInterview> employeeInterviewList = getEmployeeInterviewDAO().findEmployeeInterviewByEmployee(employee.getId(),options);
		if(employeeInterviewList != null){
			employee.setEmployeeInterviewList(employeeInterviewList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeeAttendanceList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeAttendance> employeeAttendanceList = getEmployeeAttendanceDAO().findEmployeeAttendanceByEmployee(employee.getId(),options);
		if(employeeAttendanceList != null){
			employee.setEmployeeAttendanceList(employeeAttendanceList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeeQualifierList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeQualifier> employeeQualifierList = getEmployeeQualifierDAO().findEmployeeQualifierByEmployee(employee.getId(),options);
		if(employeeQualifierList != null){
			employee.setEmployeeQualifierList(employeeQualifierList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeeEducationList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeEducation> employeeEducationList = getEmployeeEducationDAO().findEmployeeEducationByEmployee(employee.getId(),options);
		if(employeeEducationList != null){
			employee.setEmployeeEducationList(employeeEducationList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeeAwardList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeAward> employeeAwardList = getEmployeeAwardDAO().findEmployeeAwardByEmployee(employee.getId(),options);
		if(employeeAwardList != null){
			employee.setEmployeeAwardList(employeeAwardList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractEmployeeSalarySheetList(Employee employee, Map<String,Object> options){
		
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = getEmployeeSalarySheetDAO().findEmployeeSalarySheetByEmployee(employee.getId(),options);
		if(employeeSalarySheetList != null){
			employee.setEmployeeSalarySheetList(employeeSalarySheetList);
		}
		
		return employee;
	
	}	
		
	protected Employee extractPayingOffList(Employee employee, Map<String,Object> options){
		
		SmartList<PayingOff> payingOffList = getPayingOffDAO().findPayingOffByPaidFor(employee.getId(),options);
		if(payingOffList != null){
			employee.setPayingOffList(payingOffList);
		}
		
		return employee;
	
	}	
		
		
  	
 	public SmartList<Employee> findEmployeeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByDepartment(String levelThreeDepartmentId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where department = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{levelThreeDepartmentId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByDepartment(String levelThreeDepartmentId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where department = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{levelThreeDepartmentId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByDepartment(String levelThreeDepartmentId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where department = ?";
		Integer count = queryInt(SQL, new Object[]{levelThreeDepartmentId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByOccupation(String occupationTypeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where occupation = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{occupationTypeId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByOccupation(String occupationTypeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where occupation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{occupationTypeId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByOccupation(String occupationTypeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where occupation = ?";
		Integer count = queryInt(SQL, new Object[]{occupationTypeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByResponsibleFor(String responsibilityTypeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where responsible_for = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{responsibilityTypeId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByResponsibleFor(String responsibilityTypeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where responsible_for = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{responsibilityTypeId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByResponsibleFor(String responsibilityTypeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where responsible_for = ?";
		Integer count = queryInt(SQL, new Object[]{responsibilityTypeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByCurrentSalaryGrade(String salaryGradeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where current_salary_grade = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{salaryGradeId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByCurrentSalaryGrade(String salaryGradeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where current_salary_grade = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{salaryGradeId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByCurrentSalaryGrade(String salaryGradeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where current_salary_grade = ?";
		Integer count = queryInt(SQL, new Object[]{salaryGradeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByJobApplication(String jobApplicationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where job_application = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{jobApplicationId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByJobApplication(String jobApplicationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where job_application = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{jobApplicationId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByJobApplication(String jobApplicationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where job_application = ?";
		Integer count = queryInt(SQL, new Object[]{jobApplicationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByProfessionInterview(String professionInterviewId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where profession_interview = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{professionInterviewId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByProfessionInterview(String professionInterviewId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where profession_interview = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{professionInterviewId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByProfessionInterview(String professionInterviewId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where profession_interview = ?";
		Integer count = queryInt(SQL, new Object[]{professionInterviewId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByHrInterview(String hrInterviewId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where hr_interview = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{hrInterviewId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByHrInterview(String hrInterviewId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where hr_interview = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{hrInterviewId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByHrInterview(String hrInterviewId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where hr_interview = ?";
		Integer count = queryInt(SQL, new Object[]{hrInterviewId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByOfferApproval(String offerApprovalId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where offer_approval = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{offerApprovalId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByOfferApproval(String offerApprovalId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where offer_approval = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{offerApprovalId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByOfferApproval(String offerApprovalId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where offer_approval = ?";
		Integer count = queryInt(SQL, new Object[]{offerApprovalId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByOfferAcceptance(String offerAcceptanceId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where offer_acceptance = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{offerAcceptanceId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByOfferAcceptance(String offerAcceptanceId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where offer_acceptance = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{offerAcceptanceId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByOfferAcceptance(String offerAcceptanceId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where offer_acceptance = ?";
		Integer count = queryInt(SQL, new Object[]{offerAcceptanceId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByEmployeeBoarding(String employeeBoardingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee_boarding = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{employeeBoardingId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByEmployeeBoarding(String employeeBoardingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee_boarding = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{employeeBoardingId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByEmployeeBoarding(String employeeBoardingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee_boarding = ?";
		Integer count = queryInt(SQL, new Object[]{employeeBoardingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Employee> findEmployeeByTermination(String terminationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where termination = ?";
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{terminationId}, getEmployeeMapper());	
 		return employeeList;
 	}
 	
 	public SmartList<Employee> findEmployeeByTermination(String terminationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where termination = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Employee> employeeList = queryForList(SQL, new Object[]{terminationId,start, count}, getEmployeeMapper());
		
 		return employeeList;
 	}
 	
 	public int countEmployeeByTermination(String terminationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where termination = ?";
		Integer count = queryInt(SQL, new Object[]{terminationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected Employee saveEmployee(Employee  employee){
	
		String SQL=this.getSaveEmployeeSQL(employee);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeParameters(employee);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employee.incVersion();
		return employee;
	
	}
	public SmartList<Employee> saveEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeList(employeeList);
		
		batchEmployeeCreate((List<Employee>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeUpdate((List<Employee>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Employee employee:employeeList){
			if(employee.isChanged()){
				employee.incVersion();
			}
			
		
		}
		
		
		return employeeList;
	}

	public SmartList<Employee> removeEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		
		
		super.removeList(employeeList, options);
		
		return employeeList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeBatchCreateArgs(List<Employee> employeeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Employee employee:employeeList ){
			Object [] parameters = prepareEmployeeCreateParameters(employee);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeBatchUpdateArgs(List<Employee> employeeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Employee employee:employeeList ){
			if(!employee.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeUpdateParameters(employee);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeCreate(List<Employee> employeeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeBatchCreateArgs(employeeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeUpdate(List<Employee> employeeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeBatchUpdateArgs(employeeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeList(List<Employee> employeeList){
		
		List<Employee> employeeCreateList=new ArrayList<Employee>();
		List<Employee> employeeUpdateList=new ArrayList<Employee>();
		
		for(Employee employee: employeeList){
			if(isUpdateRequest(employee)){
				employeeUpdateList.add( employee);
				continue;
			}
			employeeCreateList.add(employee);
		}
		
		return new Object[]{employeeCreateList,employeeUpdateList};
	}
	
	protected boolean isUpdateRequest(Employee employee){
 		return employee.getVersion() > 0;
 	}
 	protected String getSaveEmployeeSQL(Employee employee){
 		if(isUpdateRequest(employee)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeParameters(Employee employee){
 		if(isUpdateRequest(employee) ){
 			return prepareEmployeeUpdateParameters(employee);
 		}
 		return prepareEmployeeCreateParameters(employee);
 	}
 	protected Object[] prepareEmployeeUpdateParameters(Employee employee){
 		Object[] parameters = new Object[23];
  	
 		if(employee.getCompany() != null){
 			parameters[0] = employee.getCompany().getId();
 		}
 
 		parameters[1] = employee.getTitle(); 	
 		if(employee.getDepartment() != null){
 			parameters[2] = employee.getDepartment().getId();
 		}
 
 		parameters[3] = employee.getFamilyName();
 		parameters[4] = employee.getGivenName();
 		parameters[5] = employee.getEmail();
 		parameters[6] = employee.getCity();
 		parameters[7] = employee.getAddress();
 		parameters[8] = employee.getCellPhone(); 	
 		if(employee.getOccupation() != null){
 			parameters[9] = employee.getOccupation().getId();
 		}
  	
 		if(employee.getResponsibleFor() != null){
 			parameters[10] = employee.getResponsibleFor().getId();
 		}
  	
 		if(employee.getCurrentSalaryGrade() != null){
 			parameters[11] = employee.getCurrentSalaryGrade().getId();
 		}
 
 		parameters[12] = employee.getSalaryAccount(); 	
 		if(employee.getJobApplication() != null){
 			parameters[13] = employee.getJobApplication().getId();
 		}
  	
 		if(employee.getProfessionInterview() != null){
 			parameters[14] = employee.getProfessionInterview().getId();
 		}
  	
 		if(employee.getHrInterview() != null){
 			parameters[15] = employee.getHrInterview().getId();
 		}
  	
 		if(employee.getOfferApproval() != null){
 			parameters[16] = employee.getOfferApproval().getId();
 		}
  	
 		if(employee.getOfferAcceptance() != null){
 			parameters[17] = employee.getOfferAcceptance().getId();
 		}
  	
 		if(employee.getEmployeeBoarding() != null){
 			parameters[18] = employee.getEmployeeBoarding().getId();
 		}
  	
 		if(employee.getTermination() != null){
 			parameters[19] = employee.getTermination().getId();
 		}
 
 		parameters[20] = employee.getCurrentStatus();		
 		parameters[21] = employee.getId();
 		parameters[22] = employee.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeCreateParameters(Employee employee){
		Object[] parameters = new Object[22];
		String newEmployeeId=getNextId();
		employee.setId(newEmployeeId);
		parameters[0] =  employee.getId();
  	
 		if(employee.getCompany() != null){
 			parameters[1] = employee.getCompany().getId();
 		
 		}
 		
 		parameters[2] = employee.getTitle(); 	
 		if(employee.getDepartment() != null){
 			parameters[3] = employee.getDepartment().getId();
 		
 		}
 		
 		parameters[4] = employee.getFamilyName();
 		parameters[5] = employee.getGivenName();
 		parameters[6] = employee.getEmail();
 		parameters[7] = employee.getCity();
 		parameters[8] = employee.getAddress();
 		parameters[9] = employee.getCellPhone(); 	
 		if(employee.getOccupation() != null){
 			parameters[10] = employee.getOccupation().getId();
 		
 		}
 		 	
 		if(employee.getResponsibleFor() != null){
 			parameters[11] = employee.getResponsibleFor().getId();
 		
 		}
 		 	
 		if(employee.getCurrentSalaryGrade() != null){
 			parameters[12] = employee.getCurrentSalaryGrade().getId();
 		
 		}
 		
 		parameters[13] = employee.getSalaryAccount(); 	
 		if(employee.getJobApplication() != null){
 			parameters[14] = employee.getJobApplication().getId();
 		
 		}
 		 	
 		if(employee.getProfessionInterview() != null){
 			parameters[15] = employee.getProfessionInterview().getId();
 		
 		}
 		 	
 		if(employee.getHrInterview() != null){
 			parameters[16] = employee.getHrInterview().getId();
 		
 		}
 		 	
 		if(employee.getOfferApproval() != null){
 			parameters[17] = employee.getOfferApproval().getId();
 		
 		}
 		 	
 		if(employee.getOfferAcceptance() != null){
 			parameters[18] = employee.getOfferAcceptance().getId();
 		
 		}
 		 	
 		if(employee.getEmployeeBoarding() != null){
 			parameters[19] = employee.getEmployeeBoarding().getId();
 		
 		}
 		 	
 		if(employee.getTermination() != null){
 			parameters[20] = employee.getTermination().getId();
 		
 		}
 		
 		parameters[21] = employee.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected Employee saveInternalEmployee(Employee employee, Map<String,Object> options){
		
		saveEmployee(employee);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(employee, options);
 		}
  	
 		if(isSaveDepartmentEnabled(options)){
	 		saveDepartment(employee, options);
 		}
  	
 		if(isSaveOccupationEnabled(options)){
	 		saveOccupation(employee, options);
 		}
  	
 		if(isSaveResponsibleForEnabled(options)){
	 		saveResponsibleFor(employee, options);
 		}
  	
 		if(isSaveCurrentSalaryGradeEnabled(options)){
	 		saveCurrentSalaryGrade(employee, options);
 		}
  	
 		if(isSaveJobApplicationEnabled(options)){
	 		saveJobApplication(employee, options);
 		}
  	
 		if(isSaveProfessionInterviewEnabled(options)){
	 		saveProfessionInterview(employee, options);
 		}
  	
 		if(isSaveHrInterviewEnabled(options)){
	 		saveHrInterview(employee, options);
 		}
  	
 		if(isSaveOfferApprovalEnabled(options)){
	 		saveOfferApproval(employee, options);
 		}
  	
 		if(isSaveOfferAcceptanceEnabled(options)){
	 		saveOfferAcceptance(employee, options);
 		}
  	
 		if(isSaveEmployeeBoardingEnabled(options)){
	 		saveEmployeeBoarding(employee, options);
 		}
  	
 		if(isSaveTerminationEnabled(options)){
	 		saveTermination(employee, options);
 		}
 
		
		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
	 		saveEmployeeCompanyTrainingList(employee, options);
	 		removeEmployeeCompanyTrainingList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeeSkillListEnabled(options)){
	 		saveEmployeeSkillList(employee, options);
	 		removeEmployeeSkillList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeePerformanceListEnabled(options)){
	 		saveEmployeePerformanceList(employee, options);
	 		removeEmployeePerformanceList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeeWorkExperienceListEnabled(options)){
	 		saveEmployeeWorkExperienceList(employee, options);
	 		removeEmployeeWorkExperienceList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeeLeaveListEnabled(options)){
	 		saveEmployeeLeaveList(employee, options);
	 		removeEmployeeLeaveList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeeInterviewListEnabled(options)){
	 		saveEmployeeInterviewList(employee, options);
	 		removeEmployeeInterviewList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeeAttendanceListEnabled(options)){
	 		saveEmployeeAttendanceList(employee, options);
	 		removeEmployeeAttendanceList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeeQualifierListEnabled(options)){
	 		saveEmployeeQualifierList(employee, options);
	 		removeEmployeeQualifierList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeeEducationListEnabled(options)){
	 		saveEmployeeEducationList(employee, options);
	 		removeEmployeeEducationList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeeAwardListEnabled(options)){
	 		saveEmployeeAwardList(employee, options);
	 		removeEmployeeAwardList(employee, options);
	 		
 		}		
		
		if(isSaveEmployeeSalarySheetListEnabled(options)){
	 		saveEmployeeSalarySheetList(employee, options);
	 		removeEmployeeSalarySheetList(employee, options);
	 		
 		}		
		
		if(isSavePayingOffListEnabled(options)){
	 		savePayingOffList(employee, options);
	 		removePayingOffList(employee, options);
	 		
 		}		
		
		return employee;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Employee saveCompany(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getCompany() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(employee.getCompany(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveDepartment(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getDepartment() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getLevelThreeDepartmentDAO().save(employee.getDepartment(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveOccupation(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getOccupation() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getOccupationTypeDAO().save(employee.getOccupation(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveResponsibleFor(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getResponsibleFor() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getResponsibilityTypeDAO().save(employee.getResponsibleFor(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveCurrentSalaryGrade(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getCurrentSalaryGrade() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getSalaryGradeDAO().save(employee.getCurrentSalaryGrade(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveJobApplication(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getJobApplication() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getJobApplicationDAO().save(employee.getJobApplication(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveProfessionInterview(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getProfessionInterview() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getProfessionInterviewDAO().save(employee.getProfessionInterview(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveHrInterview(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getHrInterview() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getHrInterviewDAO().save(employee.getHrInterview(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveOfferApproval(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getOfferApproval() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getOfferApprovalDAO().save(employee.getOfferApproval(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveOfferAcceptance(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getOfferAcceptance() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getOfferAcceptanceDAO().save(employee.getOfferAcceptance(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveEmployeeBoarding(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getEmployeeBoarding() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getEmployeeBoardingDAO().save(employee.getEmployeeBoarding(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Employee saveTermination(Employee employee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employee.getTermination() == null){
 			return employee;//do nothing when it is null
 		}
 		
 		getTerminationDAO().save(employee.getTermination(),options);
 		return employee;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected Employee saveEmployeeCompanyTrainingList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = employee.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			return employee;
		}
		if(employeeCompanyTrainingList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeCompanyTrainingDAO().saveEmployeeCompanyTrainingList(employeeCompanyTrainingList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeCompanyTrainingList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = employee.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			return employee;
		}	
	
		SmartList<EmployeeCompanyTraining> toRemoveEmployeeCompanyTrainingList = employeeCompanyTrainingList.getToRemoveList();
		
		if(toRemoveEmployeeCompanyTrainingList == null){
			return employee;
		}
		if(toRemoveEmployeeCompanyTrainingList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeCompanyTrainingDAO().removeEmployeeCompanyTrainingList(toRemoveEmployeeCompanyTrainingList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeeSkillList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();
		if(employeeSkillList == null){
			return employee;
		}
		if(employeeSkillList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeSkillDAO().saveEmployeeSkillList(employeeSkillList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeSkillList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();
		if(employeeSkillList == null){
			return employee;
		}	
	
		SmartList<EmployeeSkill> toRemoveEmployeeSkillList = employeeSkillList.getToRemoveList();
		
		if(toRemoveEmployeeSkillList == null){
			return employee;
		}
		if(toRemoveEmployeeSkillList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeSkillDAO().removeEmployeeSkillList(toRemoveEmployeeSkillList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeePerformanceList(Employee employee, Map<String,Object> options){
		SmartList<EmployeePerformance> employeePerformanceList = employee.getEmployeePerformanceList();
		if(employeePerformanceList == null){
			return employee;
		}
		if(employeePerformanceList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeePerformanceDAO().saveEmployeePerformanceList(employeePerformanceList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeePerformanceList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeePerformance> employeePerformanceList = employee.getEmployeePerformanceList();
		if(employeePerformanceList == null){
			return employee;
		}	
	
		SmartList<EmployeePerformance> toRemoveEmployeePerformanceList = employeePerformanceList.getToRemoveList();
		
		if(toRemoveEmployeePerformanceList == null){
			return employee;
		}
		if(toRemoveEmployeePerformanceList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeePerformanceDAO().removeEmployeePerformanceList(toRemoveEmployeePerformanceList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeeWorkExperienceList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeWorkExperience> employeeWorkExperienceList = employee.getEmployeeWorkExperienceList();
		if(employeeWorkExperienceList == null){
			return employee;
		}
		if(employeeWorkExperienceList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeWorkExperienceDAO().saveEmployeeWorkExperienceList(employeeWorkExperienceList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeWorkExperienceList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeWorkExperience> employeeWorkExperienceList = employee.getEmployeeWorkExperienceList();
		if(employeeWorkExperienceList == null){
			return employee;
		}	
	
		SmartList<EmployeeWorkExperience> toRemoveEmployeeWorkExperienceList = employeeWorkExperienceList.getToRemoveList();
		
		if(toRemoveEmployeeWorkExperienceList == null){
			return employee;
		}
		if(toRemoveEmployeeWorkExperienceList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeWorkExperienceDAO().removeEmployeeWorkExperienceList(toRemoveEmployeeWorkExperienceList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeeLeaveList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();
		if(employeeLeaveList == null){
			return employee;
		}
		if(employeeLeaveList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeLeaveDAO().saveEmployeeLeaveList(employeeLeaveList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeLeaveList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();
		if(employeeLeaveList == null){
			return employee;
		}	
	
		SmartList<EmployeeLeave> toRemoveEmployeeLeaveList = employeeLeaveList.getToRemoveList();
		
		if(toRemoveEmployeeLeaveList == null){
			return employee;
		}
		if(toRemoveEmployeeLeaveList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeLeaveDAO().removeEmployeeLeaveList(toRemoveEmployeeLeaveList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeeInterviewList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();
		if(employeeInterviewList == null){
			return employee;
		}
		if(employeeInterviewList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeInterviewDAO().saveEmployeeInterviewList(employeeInterviewList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeInterviewList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();
		if(employeeInterviewList == null){
			return employee;
		}	
	
		SmartList<EmployeeInterview> toRemoveEmployeeInterviewList = employeeInterviewList.getToRemoveList();
		
		if(toRemoveEmployeeInterviewList == null){
			return employee;
		}
		if(toRemoveEmployeeInterviewList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeInterviewDAO().removeEmployeeInterviewList(toRemoveEmployeeInterviewList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeeAttendanceList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeAttendance> employeeAttendanceList = employee.getEmployeeAttendanceList();
		if(employeeAttendanceList == null){
			return employee;
		}
		if(employeeAttendanceList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeAttendanceDAO().saveEmployeeAttendanceList(employeeAttendanceList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeAttendanceList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeAttendance> employeeAttendanceList = employee.getEmployeeAttendanceList();
		if(employeeAttendanceList == null){
			return employee;
		}	
	
		SmartList<EmployeeAttendance> toRemoveEmployeeAttendanceList = employeeAttendanceList.getToRemoveList();
		
		if(toRemoveEmployeeAttendanceList == null){
			return employee;
		}
		if(toRemoveEmployeeAttendanceList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeAttendanceDAO().removeEmployeeAttendanceList(toRemoveEmployeeAttendanceList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeeQualifierList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeQualifier> employeeQualifierList = employee.getEmployeeQualifierList();
		if(employeeQualifierList == null){
			return employee;
		}
		if(employeeQualifierList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeQualifierDAO().saveEmployeeQualifierList(employeeQualifierList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeQualifierList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeQualifier> employeeQualifierList = employee.getEmployeeQualifierList();
		if(employeeQualifierList == null){
			return employee;
		}	
	
		SmartList<EmployeeQualifier> toRemoveEmployeeQualifierList = employeeQualifierList.getToRemoveList();
		
		if(toRemoveEmployeeQualifierList == null){
			return employee;
		}
		if(toRemoveEmployeeQualifierList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeQualifierDAO().removeEmployeeQualifierList(toRemoveEmployeeQualifierList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeeEducationList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeEducation> employeeEducationList = employee.getEmployeeEducationList();
		if(employeeEducationList == null){
			return employee;
		}
		if(employeeEducationList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeEducationDAO().saveEmployeeEducationList(employeeEducationList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeEducationList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeEducation> employeeEducationList = employee.getEmployeeEducationList();
		if(employeeEducationList == null){
			return employee;
		}	
	
		SmartList<EmployeeEducation> toRemoveEmployeeEducationList = employeeEducationList.getToRemoveList();
		
		if(toRemoveEmployeeEducationList == null){
			return employee;
		}
		if(toRemoveEmployeeEducationList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeEducationDAO().removeEmployeeEducationList(toRemoveEmployeeEducationList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeeAwardList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeAward> employeeAwardList = employee.getEmployeeAwardList();
		if(employeeAwardList == null){
			return employee;
		}
		if(employeeAwardList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeAwardDAO().saveEmployeeAwardList(employeeAwardList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeAwardList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeAward> employeeAwardList = employee.getEmployeeAwardList();
		if(employeeAwardList == null){
			return employee;
		}	
	
		SmartList<EmployeeAward> toRemoveEmployeeAwardList = employeeAwardList.getToRemoveList();
		
		if(toRemoveEmployeeAwardList == null){
			return employee;
		}
		if(toRemoveEmployeeAwardList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeAwardDAO().removeEmployeeAwardList(toRemoveEmployeeAwardList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee saveEmployeeSalarySheetList(Employee employee, Map<String,Object> options){
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
		if(employeeSalarySheetList == null){
			return employee;
		}
		if(employeeSalarySheetList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeSalarySheetDAO().saveEmployeeSalarySheetList(employeeSalarySheetList,options);
		
		return employee;
	
	}
	
	protected Employee removeEmployeeSalarySheetList(Employee employee, Map<String,Object> options){
	
	
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
		if(employeeSalarySheetList == null){
			return employee;
		}	
	
		SmartList<EmployeeSalarySheet> toRemoveEmployeeSalarySheetList = employeeSalarySheetList.getToRemoveList();
		
		if(toRemoveEmployeeSalarySheetList == null){
			return employee;
		}
		if(toRemoveEmployeeSalarySheetList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeSalarySheetDAO().removeEmployeeSalarySheetList(toRemoveEmployeeSalarySheetList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Employee savePayingOffList(Employee employee, Map<String,Object> options){
		SmartList<PayingOff> payingOffList = employee.getPayingOffList();
		if(payingOffList == null){
			return employee;
		}
		if(payingOffList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getPayingOffDAO().savePayingOffList(payingOffList,options);
		
		return employee;
	
	}
	
	protected Employee removePayingOffList(Employee employee, Map<String,Object> options){
	
	
		SmartList<PayingOff> payingOffList = employee.getPayingOffList();
		if(payingOffList == null){
			return employee;
		}	
	
		SmartList<PayingOff> toRemovePayingOffList = payingOffList.getToRemoveList();
		
		if(toRemovePayingOffList == null){
			return employee;
		}
		if(toRemovePayingOffList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPayingOffDAO().removePayingOffList(toRemovePayingOffList,options);
		
		return employee;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Employee present(Employee employee,Map<String, Object> options){
	
		presentEmployeeCompanyTrainingList(employee,options);
		presentEmployeeSkillList(employee,options);
		presentEmployeePerformanceList(employee,options);
		presentEmployeeWorkExperienceList(employee,options);
		presentEmployeeLeaveList(employee,options);
		presentEmployeeInterviewList(employee,options);
		presentEmployeeAttendanceList(employee,options);
		presentEmployeeQualifierList(employee,options);
		presentEmployeeEducationList(employee,options);
		presentEmployeeAwardList(employee,options);
		presentEmployeeSalarySheetList(employee,options);
		presentPayingOffList(employee,options);

		return employee;
	
	}
		
	
  	
 	protected Employee presentEmployeeCompanyTrainingList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = employee.getEmployeeCompanyTrainingList();		
		if(employeeCompanyTrainingList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeCompanyTraining";
		int employeeCompanyTrainingListSize = employeeCompanyTrainingList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeCompanyTrainingListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeCompanyTrainingListSize;
		if(employeeCompanyTrainingListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeCompanyTrainingListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeCompanyTrainingListSize,currentPage,rowsPerPage) ;
			employeeCompanyTrainingList = employeeCompanyTrainingList.subListOf(fromIndex, toIndex);
			employeeCompanyTrainingList.setTotalCount(count);
			employeeCompanyTrainingList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeCompanyTrainingList 
			= getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingByEmployee(employee.getId(),start, rowsPerPage, options );
		employeeCompanyTrainingList.setTotalCount(count);
		employeeCompanyTrainingList.setCurrentPageNumber(currentPage);
		employee.setEmployeeCompanyTrainingList(employeeCompanyTrainingList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeeSkillList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();		
		if(employeeSkillList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeSkill";
		int employeeSkillListSize = employeeSkillList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeSkillListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeSkillListSize;
		if(employeeSkillListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeSkillDAO().countEmployeeSkillByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeSkillListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeSkillListSize,currentPage,rowsPerPage) ;
			employeeSkillList = employeeSkillList.subListOf(fromIndex, toIndex);
			employeeSkillList.setTotalCount(count);
			employeeSkillList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeSkillList(employeeSkillList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeSkillList 
			= getEmployeeSkillDAO().findEmployeeSkillByEmployee(employee.getId(),start, rowsPerPage, options );
		employeeSkillList.setTotalCount(count);
		employeeSkillList.setCurrentPageNumber(currentPage);
		employee.setEmployeeSkillList(employeeSkillList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeePerformanceList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeePerformance> employeePerformanceList = employee.getEmployeePerformanceList();		
		if(employeePerformanceList == null){
			return employee;			
		}
		
		String targetObjectName = "employeePerformance";
		int employeePerformanceListSize = employeePerformanceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeePerformanceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeePerformanceListSize;
		if(employeePerformanceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeePerformanceDAO().countEmployeePerformanceByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeePerformanceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeePerformanceListSize,currentPage,rowsPerPage) ;
			employeePerformanceList = employeePerformanceList.subListOf(fromIndex, toIndex);
			employeePerformanceList.setTotalCount(count);
			employeePerformanceList.setCurrentPageNumber(currentPage);			
			employee.setEmployeePerformanceList(employeePerformanceList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeePerformanceList 
			= getEmployeePerformanceDAO().findEmployeePerformanceByEmployee(employee.getId(),start, rowsPerPage, options );
		employeePerformanceList.setTotalCount(count);
		employeePerformanceList.setCurrentPageNumber(currentPage);
		employee.setEmployeePerformanceList(employeePerformanceList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeeWorkExperienceList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeWorkExperience> employeeWorkExperienceList = employee.getEmployeeWorkExperienceList();		
		if(employeeWorkExperienceList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeWorkExperience";
		int employeeWorkExperienceListSize = employeeWorkExperienceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeWorkExperienceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeWorkExperienceListSize;
		if(employeeWorkExperienceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeWorkExperienceDAO().countEmployeeWorkExperienceByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeWorkExperienceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeWorkExperienceListSize,currentPage,rowsPerPage) ;
			employeeWorkExperienceList = employeeWorkExperienceList.subListOf(fromIndex, toIndex);
			employeeWorkExperienceList.setTotalCount(count);
			employeeWorkExperienceList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeWorkExperienceList(employeeWorkExperienceList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeWorkExperienceList 
			= getEmployeeWorkExperienceDAO().findEmployeeWorkExperienceByEmployee(employee.getId(),start, rowsPerPage, options );
		employeeWorkExperienceList.setTotalCount(count);
		employeeWorkExperienceList.setCurrentPageNumber(currentPage);
		employee.setEmployeeWorkExperienceList(employeeWorkExperienceList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeeLeaveList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();		
		if(employeeLeaveList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeLeave";
		int employeeLeaveListSize = employeeLeaveList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeLeaveListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeLeaveListSize;
		if(employeeLeaveListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeLeaveDAO().countEmployeeLeaveByWho(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeLeaveListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeLeaveListSize,currentPage,rowsPerPage) ;
			employeeLeaveList = employeeLeaveList.subListOf(fromIndex, toIndex);
			employeeLeaveList.setTotalCount(count);
			employeeLeaveList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeLeaveList(employeeLeaveList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeLeaveList 
			= getEmployeeLeaveDAO().findEmployeeLeaveByWho(employee.getId(),start, rowsPerPage, options );
		employeeLeaveList.setTotalCount(count);
		employeeLeaveList.setCurrentPageNumber(currentPage);
		employee.setEmployeeLeaveList(employeeLeaveList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeeInterviewList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();		
		if(employeeInterviewList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeInterview";
		int employeeInterviewListSize = employeeInterviewList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeInterviewListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeInterviewListSize;
		if(employeeInterviewListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeInterviewDAO().countEmployeeInterviewByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeInterviewListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeInterviewListSize,currentPage,rowsPerPage) ;
			employeeInterviewList = employeeInterviewList.subListOf(fromIndex, toIndex);
			employeeInterviewList.setTotalCount(count);
			employeeInterviewList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeInterviewList(employeeInterviewList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeInterviewList 
			= getEmployeeInterviewDAO().findEmployeeInterviewByEmployee(employee.getId(),start, rowsPerPage, options );
		employeeInterviewList.setTotalCount(count);
		employeeInterviewList.setCurrentPageNumber(currentPage);
		employee.setEmployeeInterviewList(employeeInterviewList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeeAttendanceList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeAttendance> employeeAttendanceList = employee.getEmployeeAttendanceList();		
		if(employeeAttendanceList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeAttendance";
		int employeeAttendanceListSize = employeeAttendanceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeAttendanceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeAttendanceListSize;
		if(employeeAttendanceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeAttendanceDAO().countEmployeeAttendanceByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeAttendanceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeAttendanceListSize,currentPage,rowsPerPage) ;
			employeeAttendanceList = employeeAttendanceList.subListOf(fromIndex, toIndex);
			employeeAttendanceList.setTotalCount(count);
			employeeAttendanceList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeAttendanceList(employeeAttendanceList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeAttendanceList 
			= getEmployeeAttendanceDAO().findEmployeeAttendanceByEmployee(employee.getId(),start, rowsPerPage, options );
		employeeAttendanceList.setTotalCount(count);
		employeeAttendanceList.setCurrentPageNumber(currentPage);
		employee.setEmployeeAttendanceList(employeeAttendanceList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeeQualifierList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeQualifier> employeeQualifierList = employee.getEmployeeQualifierList();		
		if(employeeQualifierList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeQualifier";
		int employeeQualifierListSize = employeeQualifierList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeQualifierListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeQualifierListSize;
		if(employeeQualifierListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeQualifierDAO().countEmployeeQualifierByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeQualifierListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeQualifierListSize,currentPage,rowsPerPage) ;
			employeeQualifierList = employeeQualifierList.subListOf(fromIndex, toIndex);
			employeeQualifierList.setTotalCount(count);
			employeeQualifierList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeQualifierList(employeeQualifierList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeQualifierList 
			= getEmployeeQualifierDAO().findEmployeeQualifierByEmployee(employee.getId(),start, rowsPerPage, options );
		employeeQualifierList.setTotalCount(count);
		employeeQualifierList.setCurrentPageNumber(currentPage);
		employee.setEmployeeQualifierList(employeeQualifierList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeeEducationList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeEducation> employeeEducationList = employee.getEmployeeEducationList();		
		if(employeeEducationList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeEducation";
		int employeeEducationListSize = employeeEducationList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeEducationListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeEducationListSize;
		if(employeeEducationListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeEducationDAO().countEmployeeEducationByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeEducationListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeEducationListSize,currentPage,rowsPerPage) ;
			employeeEducationList = employeeEducationList.subListOf(fromIndex, toIndex);
			employeeEducationList.setTotalCount(count);
			employeeEducationList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeEducationList(employeeEducationList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeEducationList 
			= getEmployeeEducationDAO().findEmployeeEducationByEmployee(employee.getId(),start, rowsPerPage, options );
		employeeEducationList.setTotalCount(count);
		employeeEducationList.setCurrentPageNumber(currentPage);
		employee.setEmployeeEducationList(employeeEducationList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeeAwardList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeAward> employeeAwardList = employee.getEmployeeAwardList();		
		if(employeeAwardList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeAward";
		int employeeAwardListSize = employeeAwardList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeAwardListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeAwardListSize;
		if(employeeAwardListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeAwardDAO().countEmployeeAwardByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeAwardListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeAwardListSize,currentPage,rowsPerPage) ;
			employeeAwardList = employeeAwardList.subListOf(fromIndex, toIndex);
			employeeAwardList.setTotalCount(count);
			employeeAwardList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeAwardList(employeeAwardList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeAwardList 
			= getEmployeeAwardDAO().findEmployeeAwardByEmployee(employee.getId(),start, rowsPerPage, options );
		employeeAwardList.setTotalCount(count);
		employeeAwardList.setCurrentPageNumber(currentPage);
		employee.setEmployeeAwardList(employeeAwardList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentEmployeeSalarySheetList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();		
		if(employeeSalarySheetList == null){
			return employee;			
		}
		
		String targetObjectName = "employeeSalarySheet";
		int employeeSalarySheetListSize = employeeSalarySheetList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeSalarySheetListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeSalarySheetListSize;
		if(employeeSalarySheetListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeSalarySheetDAO().countEmployeeSalarySheetByEmployee(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeSalarySheetListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeSalarySheetListSize,currentPage,rowsPerPage) ;
			employeeSalarySheetList = employeeSalarySheetList.subListOf(fromIndex, toIndex);
			employeeSalarySheetList.setTotalCount(count);
			employeeSalarySheetList.setCurrentPageNumber(currentPage);			
			employee.setEmployeeSalarySheetList(employeeSalarySheetList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeSalarySheetList 
			= getEmployeeSalarySheetDAO().findEmployeeSalarySheetByEmployee(employee.getId(),start, rowsPerPage, options );
		employeeSalarySheetList.setTotalCount(count);
		employeeSalarySheetList.setCurrentPageNumber(currentPage);
		employee.setEmployeeSalarySheetList(employeeSalarySheetList );	

		return employee;
	}			
		
	
  	
 	protected Employee presentPayingOffList(
			Employee employee,
			Map<String, Object> options) {

		SmartList<PayingOff> payingOffList = employee.getPayingOffList();		
		if(payingOffList == null){
			return employee;			
		}
		
		String targetObjectName = "payingOff";
		int payingOffListSize = payingOffList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(payingOffListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return employee;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = payingOffListSize;
		if(payingOffListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getPayingOffDAO().countPayingOffByPaidFor(employee.getId(), options);			
		}
		//employee.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//employee.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(payingOffListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(payingOffListSize,currentPage,rowsPerPage) ;
			payingOffList = payingOffList.subListOf(fromIndex, toIndex);
			payingOffList.setTotalCount(count);
			payingOffList.setCurrentPageNumber(currentPage);			
			employee.setPayingOffList(payingOffList);
			return employee;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		payingOffList 
			= getPayingOffDAO().findPayingOffByPaidFor(employee.getId(),start, rowsPerPage, options );
		payingOffList.setTotalCount(count);
		payingOffList.setCurrentPageNumber(currentPage);
		employee.setPayingOffList(payingOffList );	

		return employee;
	}			
		


	protected String getTableName(){
		return EmployeeTable.TABLE_NAME;
	}
}


