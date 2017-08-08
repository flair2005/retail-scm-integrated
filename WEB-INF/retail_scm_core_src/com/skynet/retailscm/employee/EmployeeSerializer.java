
package com.skynet.retailscm.employee;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.BaseJsonSerializer;

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


public class EmployeeSerializer extends BaseJsonSerializer<Employee>{

	

	@Override
	public void serialize(Employee employee, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employee,jgen,provider);
		
		jgen.writeStringField(Employee.ID_PROPERTY,employee.getId());
		writeCompany(Employee.COMPANY_PROPERTY,employee,jgen,provider);
		jgen.writeStringField(Employee.TITLE_PROPERTY,employee.getTitle());
		writeDepartment(Employee.DEPARTMENT_PROPERTY,employee,jgen,provider);
		jgen.writeStringField(Employee.FAMILY_NAME_PROPERTY,employee.getFamilyName());
		jgen.writeStringField(Employee.GIVEN_NAME_PROPERTY,employee.getGivenName());
		jgen.writeStringField(Employee.EMAIL_PROPERTY,employee.getEmail());
		jgen.writeStringField(Employee.CITY_PROPERTY,employee.getCity());
		jgen.writeStringField(Employee.ADDRESS_PROPERTY,employee.getAddress());
		jgen.writeStringField(Employee.CELL_PHONE_PROPERTY,employee.getCellPhone());
		writeOccupation(Employee.OCCUPATION_PROPERTY,employee,jgen,provider);
		writeResponsibleFor(Employee.RESPONSIBLE_FOR_PROPERTY,employee,jgen,provider);
		writeCurrentSalaryGrade(Employee.CURRENT_SALARY_GRADE_PROPERTY,employee,jgen,provider);
		jgen.writeStringField(Employee.SALARY_ACCOUNT_PROPERTY,employee.getSalaryAccount());
		writeJobApplication(Employee.JOB_APPLICATION_PROPERTY,employee,jgen,provider);
		writeProfessionInterview(Employee.PROFESSION_INTERVIEW_PROPERTY,employee,jgen,provider);
		writeHrInterview(Employee.HR_INTERVIEW_PROPERTY,employee,jgen,provider);
		writeOfferApproval(Employee.OFFER_APPROVAL_PROPERTY,employee,jgen,provider);
		writeOfferAcceptance(Employee.OFFER_ACCEPTANCE_PROPERTY,employee,jgen,provider);
		writeEmployeeBoarding(Employee.EMPLOYEE_BOARDING_PROPERTY,employee,jgen,provider);
		writeTermination(Employee.TERMINATION_PROPERTY,employee,jgen,provider);
		jgen.writeStringField(Employee.CURRENT_STATUS_PROPERTY,employee.getCurrentStatus());
		jgen.writeNumberField(Employee.VERSION_PROPERTY,employee.getVersion());
		writeEmployeeCompanyTrainingList(Employee.EMPLOYEE_COMPANY_TRAINING_LIST,employee,jgen,provider);
		writeEmployeeSkillList(Employee.EMPLOYEE_SKILL_LIST,employee,jgen,provider);
		writeEmployeePerformanceList(Employee.EMPLOYEE_PERFORMANCE_LIST,employee,jgen,provider);
		writeEmployeeWorkExperienceList(Employee.EMPLOYEE_WORK_EXPERIENCE_LIST,employee,jgen,provider);
		writeEmployeeLeaveList(Employee.EMPLOYEE_LEAVE_LIST,employee,jgen,provider);
		writeEmployeeInterviewList(Employee.EMPLOYEE_INTERVIEW_LIST,employee,jgen,provider);
		writeEmployeeAttendanceList(Employee.EMPLOYEE_ATTENDANCE_LIST,employee,jgen,provider);
		writeEmployeeQualifierList(Employee.EMPLOYEE_QUALIFIER_LIST,employee,jgen,provider);
		writeEmployeeEducationList(Employee.EMPLOYEE_EDUCATION_LIST,employee,jgen,provider);
		writeEmployeeAwardList(Employee.EMPLOYEE_AWARD_LIST,employee,jgen,provider);
		writeEmployeeSalarySheetList(Employee.EMPLOYEE_SALARY_SHEET_LIST,employee,jgen,provider);
		writePayingOffList(Employee.PAYING_OFF_LIST,employee,jgen,provider);
		
		writeEndObject(employee,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = employee.getCompany();
		
		if(company == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,company.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,company.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,company.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,company.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,company.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,company.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,company.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,company.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,company.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,company.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeDepartment(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		LevelThreeDepartment department = employee.getDepartment();
		
		if(department == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(LevelThreeDepartment.ID_PROPERTY,department.getId()); 
		jgen.writeStringField(LevelThreeDepartment.NAME_PROPERTY,department.getName()); 
		jgen.writeStringField(LevelThreeDepartment.DESCRIPTION_PROPERTY,department.getDescription()); 
		jgen.writeObjectField(LevelThreeDepartment.FOUNDED_PROPERTY,department.getFounded()); 
		jgen.writeNumberField(LevelThreeDepartment.VERSION_PROPERTY,department.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeOccupation(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		OccupationType occupation = employee.getOccupation();
		
		if(occupation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(OccupationType.ID_PROPERTY,occupation.getId()); 
		jgen.writeStringField(OccupationType.CODE_PROPERTY,occupation.getCode()); 
		jgen.writeStringField(OccupationType.DESCRIPTION_PROPERTY,occupation.getDescription()); 
		jgen.writeStringField(OccupationType.DETAIL_DESCRIPTION_PROPERTY,occupation.getDetailDescription()); 
		jgen.writeNumberField(OccupationType.VERSION_PROPERTY,occupation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeResponsibleFor(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ResponsibilityType responsibleFor = employee.getResponsibleFor();
		
		if(responsibleFor == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(ResponsibilityType.ID_PROPERTY,responsibleFor.getId()); 
		jgen.writeStringField(ResponsibilityType.CODE_PROPERTY,responsibleFor.getCode()); 
		jgen.writeStringField(ResponsibilityType.BASE_DESCRIPTION_PROPERTY,responsibleFor.getBaseDescription()); 
		jgen.writeStringField(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY,responsibleFor.getDetailDescription()); 
		jgen.writeNumberField(ResponsibilityType.VERSION_PROPERTY,responsibleFor.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeCurrentSalaryGrade(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SalaryGrade currentSalaryGrade = employee.getCurrentSalaryGrade();
		
		if(currentSalaryGrade == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SalaryGrade.ID_PROPERTY,currentSalaryGrade.getId()); 
		jgen.writeStringField(SalaryGrade.CODE_PROPERTY,currentSalaryGrade.getCode()); 
		jgen.writeStringField(SalaryGrade.NAME_PROPERTY,currentSalaryGrade.getName()); 
		jgen.writeStringField(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY,currentSalaryGrade.getDetailDescription()); 
		jgen.writeNumberField(SalaryGrade.VERSION_PROPERTY,currentSalaryGrade.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeJobApplication(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		JobApplication jobApplication = employee.getJobApplication();
		
		if(jobApplication == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(JobApplication.ID_PROPERTY,jobApplication.getId()); 
		jgen.writeObjectField(JobApplication.APPLICATION_TIME_PROPERTY,jobApplication.getApplicationTime()); 
		jgen.writeStringField(JobApplication.WHO_PROPERTY,jobApplication.getWho()); 
		jgen.writeStringField(JobApplication.COMMENTS_PROPERTY,jobApplication.getComments()); 
		jgen.writeNumberField(JobApplication.VERSION_PROPERTY,jobApplication.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProfessionInterview(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ProfessionInterview professionInterview = employee.getProfessionInterview();
		
		if(professionInterview == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(ProfessionInterview.ID_PROPERTY,professionInterview.getId()); 
		jgen.writeStringField(ProfessionInterview.WHO_PROPERTY,professionInterview.getWho()); 
		jgen.writeObjectField(ProfessionInterview.INTERVIEW_TIME_PROPERTY,professionInterview.getInterviewTime()); 
		jgen.writeStringField(ProfessionInterview.COMMENTS_PROPERTY,professionInterview.getComments()); 
		jgen.writeNumberField(ProfessionInterview.VERSION_PROPERTY,professionInterview.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeHrInterview(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		HrInterview hrInterview = employee.getHrInterview();
		
		if(hrInterview == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(HrInterview.ID_PROPERTY,hrInterview.getId()); 
		jgen.writeStringField(HrInterview.WHO_PROPERTY,hrInterview.getWho()); 
		jgen.writeObjectField(HrInterview.INTERVIEW_TIME_PROPERTY,hrInterview.getInterviewTime()); 
		jgen.writeStringField(HrInterview.COMMENTS_PROPERTY,hrInterview.getComments()); 
		jgen.writeNumberField(HrInterview.VERSION_PROPERTY,hrInterview.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeOfferApproval(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		OfferApproval offerApproval = employee.getOfferApproval();
		
		if(offerApproval == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(OfferApproval.ID_PROPERTY,offerApproval.getId()); 
		jgen.writeStringField(OfferApproval.WHO_PROPERTY,offerApproval.getWho()); 
		jgen.writeObjectField(OfferApproval.APPROVE_TIME_PROPERTY,offerApproval.getApproveTime()); 
		jgen.writeStringField(OfferApproval.COMMENTS_PROPERTY,offerApproval.getComments()); 
		jgen.writeNumberField(OfferApproval.VERSION_PROPERTY,offerApproval.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeOfferAcceptance(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		OfferAcceptance offerAcceptance = employee.getOfferAcceptance();
		
		if(offerAcceptance == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(OfferAcceptance.ID_PROPERTY,offerAcceptance.getId()); 
		jgen.writeStringField(OfferAcceptance.WHO_PROPERTY,offerAcceptance.getWho()); 
		jgen.writeObjectField(OfferAcceptance.ACCEPT_TIME_PROPERTY,offerAcceptance.getAcceptTime()); 
		jgen.writeStringField(OfferAcceptance.COMMENTS_PROPERTY,offerAcceptance.getComments()); 
		jgen.writeNumberField(OfferAcceptance.VERSION_PROPERTY,offerAcceptance.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeEmployeeBoarding(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		EmployeeBoarding employeeBoarding = employee.getEmployeeBoarding();
		
		if(employeeBoarding == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(EmployeeBoarding.ID_PROPERTY,employeeBoarding.getId()); 
		jgen.writeStringField(EmployeeBoarding.WHO_PROPERTY,employeeBoarding.getWho()); 
		jgen.writeObjectField(EmployeeBoarding.EMPLOY_TIME_PROPERTY,employeeBoarding.getEmployTime()); 
		jgen.writeStringField(EmployeeBoarding.COMMENTS_PROPERTY,employeeBoarding.getComments()); 
		jgen.writeNumberField(EmployeeBoarding.VERSION_PROPERTY,employeeBoarding.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeTermination(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Termination termination = employee.getTermination();
		
		if(termination == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Termination.ID_PROPERTY,termination.getId()); 
		jgen.writeStringField(Termination.COMMENT_PROPERTY,termination.getComment()); 
		jgen.writeNumberField(Termination.VERSION_PROPERTY,termination.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeEmployeeCompanyTrainingList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeCompanyTraining> employeeCompanyTrainingList = employee.getEmployeeCompanyTrainingList();
		
		if(employeeCompanyTrainingList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeCompanyTrainingList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeCompanyTraining employeeCompanyTraining: employeeCompanyTrainingList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeCompanyTraining.ID_PROPERTY,employeeCompanyTraining.getId());
			jgen.writeStringField(EmployeeCompanyTraining.CURRENT_STATUS_PROPERTY,employeeCompanyTraining.getCurrentStatus());
			jgen.writeNumberField(EmployeeCompanyTraining.VERSION_PROPERTY,employeeCompanyTraining.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeSkillList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();
		
		if(employeeSkillList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeSkillList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeSkill employeeSkill: employeeSkillList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeSkill.ID_PROPERTY,employeeSkill.getId());
			jgen.writeStringField(EmployeeSkill.DESCRIPTION_PROPERTY,employeeSkill.getDescription());
			jgen.writeNumberField(EmployeeSkill.VERSION_PROPERTY,employeeSkill.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeePerformanceList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeePerformance> employeePerformanceList = employee.getEmployeePerformanceList();
		
		if(employeePerformanceList == null){
			return;//do nothing when null found for this field.
		}
		if(employeePerformanceList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeePerformance employeePerformance: employeePerformanceList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeePerformance.ID_PROPERTY,employeePerformance.getId());
			jgen.writeStringField(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY,employeePerformance.getPerformanceComment());
			jgen.writeNumberField(EmployeePerformance.VERSION_PROPERTY,employeePerformance.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeWorkExperienceList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeWorkExperience> employeeWorkExperienceList = employee.getEmployeeWorkExperienceList();
		
		if(employeeWorkExperienceList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeWorkExperienceList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeWorkExperience employeeWorkExperience: employeeWorkExperienceList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeWorkExperience.ID_PROPERTY,employeeWorkExperience.getId());
			jgen.writeObjectField(EmployeeWorkExperience.START_PROPERTY,employeeWorkExperience.getStart());
			jgen.writeObjectField(EmployeeWorkExperience.END_PROPERTY,employeeWorkExperience.getEnd());
			jgen.writeStringField(EmployeeWorkExperience.COMPANY_PROPERTY,employeeWorkExperience.getCompany());
			jgen.writeStringField(EmployeeWorkExperience.DESCRIPTION_PROPERTY,employeeWorkExperience.getDescription());
			jgen.writeNumberField(EmployeeWorkExperience.VERSION_PROPERTY,employeeWorkExperience.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeLeaveList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();
		
		if(employeeLeaveList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeLeaveList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeLeave employeeLeave: employeeLeaveList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeLeave.ID_PROPERTY,employeeLeave.getId());
			jgen.writeNumberField(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY,employeeLeave.getLeaveDurationHour());
			jgen.writeStringField(EmployeeLeave.REMARK_PROPERTY,employeeLeave.getRemark());
			jgen.writeNumberField(EmployeeLeave.VERSION_PROPERTY,employeeLeave.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeInterviewList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();
		
		if(employeeInterviewList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeInterviewList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeInterview employeeInterview: employeeInterviewList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeInterview.ID_PROPERTY,employeeInterview.getId());
			jgen.writeStringField(EmployeeInterview.REMARK_PROPERTY,employeeInterview.getRemark());
			jgen.writeNumberField(EmployeeInterview.VERSION_PROPERTY,employeeInterview.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeAttendanceList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeAttendance> employeeAttendanceList = employee.getEmployeeAttendanceList();
		
		if(employeeAttendanceList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeAttendanceList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeAttendance employeeAttendance: employeeAttendanceList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeAttendance.ID_PROPERTY,employeeAttendance.getId());
			jgen.writeObjectField(EmployeeAttendance.ENTER_TIME_PROPERTY,employeeAttendance.getEnterTime());
			jgen.writeObjectField(EmployeeAttendance.LEAVE_TIME_PROPERTY,employeeAttendance.getLeaveTime());
			jgen.writeNumberField(EmployeeAttendance.DURATION_HOURS_PROPERTY,employeeAttendance.getDurationHours());
			jgen.writeStringField(EmployeeAttendance.REMARK_PROPERTY,employeeAttendance.getRemark());
			jgen.writeNumberField(EmployeeAttendance.VERSION_PROPERTY,employeeAttendance.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeQualifierList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeQualifier> employeeQualifierList = employee.getEmployeeQualifierList();
		
		if(employeeQualifierList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeQualifierList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeQualifier employeeQualifier: employeeQualifierList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeQualifier.ID_PROPERTY,employeeQualifier.getId());
			jgen.writeObjectField(EmployeeQualifier.QUALIFIED_TIME_PROPERTY,employeeQualifier.getQualifiedTime());
			jgen.writeStringField(EmployeeQualifier.TYPE_PROPERTY,employeeQualifier.getType());
			jgen.writeStringField(EmployeeQualifier.LEVEL_PROPERTY,employeeQualifier.getLevel());
			jgen.writeStringField(EmployeeQualifier.REMARK_PROPERTY,employeeQualifier.getRemark());
			jgen.writeNumberField(EmployeeQualifier.VERSION_PROPERTY,employeeQualifier.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeEducationList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeEducation> employeeEducationList = employee.getEmployeeEducationList();
		
		if(employeeEducationList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeEducationList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeEducation employeeEducation: employeeEducationList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeEducation.ID_PROPERTY,employeeEducation.getId());
			jgen.writeObjectField(EmployeeEducation.COMPLETE_TIME_PROPERTY,employeeEducation.getCompleteTime());
			jgen.writeStringField(EmployeeEducation.TYPE_PROPERTY,employeeEducation.getType());
			jgen.writeStringField(EmployeeEducation.REMARK_PROPERTY,employeeEducation.getRemark());
			jgen.writeNumberField(EmployeeEducation.VERSION_PROPERTY,employeeEducation.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeAwardList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeAward> employeeAwardList = employee.getEmployeeAwardList();
		
		if(employeeAwardList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeAwardList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeAward employeeAward: employeeAwardList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeAward.ID_PROPERTY,employeeAward.getId());
			jgen.writeObjectField(EmployeeAward.COMPLETE_TIME_PROPERTY,employeeAward.getCompleteTime());
			jgen.writeStringField(EmployeeAward.TYPE_PROPERTY,employeeAward.getType());
			jgen.writeStringField(EmployeeAward.REMARK_PROPERTY,employeeAward.getRemark());
			jgen.writeNumberField(EmployeeAward.VERSION_PROPERTY,employeeAward.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeSalarySheetList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
		
		if(employeeSalarySheetList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeSalarySheetList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeSalarySheet employeeSalarySheet: employeeSalarySheetList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeSalarySheet.ID_PROPERTY,employeeSalarySheet.getId());
			jgen.writeNumberField(EmployeeSalarySheet.BASE_SALARY_PROPERTY,employeeSalarySheet.getBaseSalary());
			jgen.writeNumberField(EmployeeSalarySheet.BONUS_PROPERTY,employeeSalarySheet.getBonus());
			jgen.writeNumberField(EmployeeSalarySheet.REWARD_PROPERTY,employeeSalarySheet.getReward());
			jgen.writeNumberField(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY,employeeSalarySheet.getPersonalTax());
			jgen.writeNumberField(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY,employeeSalarySheet.getSocialSecurity());
			jgen.writeNumberField(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY,employeeSalarySheet.getHousingFound());
			jgen.writeNumberField(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY,employeeSalarySheet.getJobInsurance());
			jgen.writeStringField(EmployeeSalarySheet.CURRENT_STATUS_PROPERTY,employeeSalarySheet.getCurrentStatus());
			jgen.writeNumberField(EmployeeSalarySheet.VERSION_PROPERTY,employeeSalarySheet.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writePayingOffList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PayingOff> payingOffList = employee.getPayingOffList();
		
		if(payingOffList == null){
			return;//do nothing when null found for this field.
		}
		if(payingOffList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(PayingOff payingOff: payingOffList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(PayingOff.ID_PROPERTY,payingOff.getId());
			jgen.writeStringField(PayingOff.WHO_PROPERTY,payingOff.getWho());
			jgen.writeObjectField(PayingOff.PAID_TIME_PROPERTY,payingOff.getPaidTime());
			jgen.writeNumberField(PayingOff.AMOUNT_PROPERTY,payingOff.getAmount());
			jgen.writeNumberField(PayingOff.VERSION_PROPERTY,payingOff.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


