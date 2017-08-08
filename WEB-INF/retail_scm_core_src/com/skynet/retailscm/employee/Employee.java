
package com.skynet.retailscm.employee;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

@JsonSerialize(using = EmployeeSerializer.class)
public class Employee extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String DEPARTMENT_PROPERTY            = "department"        ;
	public static final String FAMILY_NAME_PROPERTY           = "familyName"        ;
	public static final String GIVEN_NAME_PROPERTY            = "givenName"         ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String CITY_PROPERTY                  = "city"              ;
	public static final String ADDRESS_PROPERTY               = "address"           ;
	public static final String CELL_PHONE_PROPERTY            = "cellPhone"         ;
	public static final String OCCUPATION_PROPERTY            = "occupation"        ;
	public static final String RESPONSIBLE_FOR_PROPERTY       = "responsibleFor"    ;
	public static final String CURRENT_SALARY_GRADE_PROPERTY  = "currentSalaryGrade";
	public static final String SALARY_ACCOUNT_PROPERTY        = "salaryAccount"     ;
	public static final String JOB_APPLICATION_PROPERTY       = "jobApplication"    ;
	public static final String PROFESSION_INTERVIEW_PROPERTY  = "professionInterview";
	public static final String HR_INTERVIEW_PROPERTY          = "hrInterview"       ;
	public static final String OFFER_APPROVAL_PROPERTY        = "offerApproval"     ;
	public static final String OFFER_ACCEPTANCE_PROPERTY      = "offerAcceptance"   ;
	public static final String EMPLOYEE_BOARDING_PROPERTY     = "employeeBoarding"  ;
	public static final String TERMINATION_PROPERTY           = "termination"       ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_COMPANY_TRAINING_LIST           = "employeeCompanyTrainingList";
	public static final String EMPLOYEE_SKILL_LIST                      = "employeeSkillList" ;
	public static final String EMPLOYEE_PERFORMANCE_LIST                = "employeePerformanceList";
	public static final String EMPLOYEE_WORK_EXPERIENCE_LIST            = "employeeWorkExperienceList";
	public static final String EMPLOYEE_LEAVE_LIST                      = "employeeLeaveList" ;
	public static final String EMPLOYEE_INTERVIEW_LIST                  = "employeeInterviewList";
	public static final String EMPLOYEE_ATTENDANCE_LIST                 = "employeeAttendanceList";
	public static final String EMPLOYEE_QUALIFIER_LIST                  = "employeeQualifierList";
	public static final String EMPLOYEE_EDUCATION_LIST                  = "employeeEducationList";
	public static final String EMPLOYEE_AWARD_LIST                      = "employeeAwardList" ;
	public static final String EMPLOYEE_SALARY_SHEET_LIST               = "employeeSalarySheetList";
	public static final String PAYING_OFF_LIST                          = "payingOffList"     ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mTitle              ;
	protected		LevelThreeDepartment	mDepartment         ;
	protected		String              	mFamilyName         ;
	protected		String              	mGivenName          ;
	protected		String              	mEmail              ;
	protected		String              	mCity               ;
	protected		String              	mAddress            ;
	protected		String              	mCellPhone          ;
	protected		OccupationType      	mOccupation         ;
	protected		ResponsibilityType  	mResponsibleFor     ;
	protected		SalaryGrade         	mCurrentSalaryGrade ;
	protected		String              	mSalaryAccount      ;
	protected		JobApplication      	mJobApplication     ;
	protected		ProfessionInterview 	mProfessionInterview;
	protected		HrInterview         	mHrInterview        ;
	protected		OfferApproval       	mOfferApproval      ;
	protected		OfferAcceptance     	mOfferAcceptance    ;
	protected		EmployeeBoarding    	mEmployeeBoarding   ;
	protected		Termination         	mTermination        ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeCompanyTraining>	mEmployeeCompanyTrainingList;
	protected		SmartList<EmployeeSkill>	mEmployeeSkillList  ;
	protected		SmartList<EmployeePerformance>	mEmployeePerformanceList;
	protected		SmartList<EmployeeWorkExperience>	mEmployeeWorkExperienceList;
	protected		SmartList<EmployeeLeave>	mEmployeeLeaveList  ;
	protected		SmartList<EmployeeInterview>	mEmployeeInterviewList;
	protected		SmartList<EmployeeAttendance>	mEmployeeAttendanceList;
	protected		SmartList<EmployeeQualifier>	mEmployeeQualifierList;
	protected		SmartList<EmployeeEducation>	mEmployeeEducationList;
	protected		SmartList<EmployeeAward>	mEmployeeAwardList  ;
	protected		SmartList<EmployeeSalarySheet>	mEmployeeSalarySheetList;
	protected		SmartList<PayingOff>	mPayingOffList      ;
	
		
	public 	Employee(){
		//lazy load for all the properties
	}
	
	public 	Employee(RetailStoreCountryCenter company, String title, LevelThreeDepartment department, String familyName, String givenName, String email, String city, String address, String cellPhone, OccupationType occupation, ResponsibilityType responsibleFor, SalaryGrade currentSalaryGrade, String salaryAccount, String currentStatus
)
	{
		setCompany(company);
		setTitle(title);
		setDepartment(department);
		setFamilyName(familyName);
		setGivenName(givenName);
		setEmail(email);
		setCity(city);
		setAddress(address);
		setCellPhone(cellPhone);
		setOccupation(occupation);
		setResponsibleFor(responsibleFor);
		setCurrentSalaryGrade(currentSalaryGrade);
		setSalaryAccount(salaryAccount);
		setCurrentStatus(currentStatus);

		this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();
		this.mEmployeeSkillList = new SmartList<EmployeeSkill>();
		this.mEmployeePerformanceList = new SmartList<EmployeePerformance>();
		this.mEmployeeWorkExperienceList = new SmartList<EmployeeWorkExperience>();
		this.mEmployeeLeaveList = new SmartList<EmployeeLeave>();
		this.mEmployeeInterviewList = new SmartList<EmployeeInterview>();
		this.mEmployeeAttendanceList = new SmartList<EmployeeAttendance>();
		this.mEmployeeQualifierList = new SmartList<EmployeeQualifier>();
		this.mEmployeeEducationList = new SmartList<EmployeeEducation>();
		this.mEmployeeAwardList = new SmartList<EmployeeAward>();
		this.mEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();
		this.mPayingOffList = new SmartList<PayingOff>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(FAMILY_NAME_PROPERTY.equals(property)){
			changeFamilyNameProperty(newValueExpr);
		}
		if(GIVEN_NAME_PROPERTY.equals(property)){
			changeGivenNameProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
		}
		if(CITY_PROPERTY.equals(property)){
			changeCityProperty(newValueExpr);
		}
		if(ADDRESS_PROPERTY.equals(property)){
			changeAddressProperty(newValueExpr);
		}
		if(CELL_PHONE_PROPERTY.equals(property)){
			changeCellPhoneProperty(newValueExpr);
		}
		if(SALARY_ACCOUNT_PROPERTY.equals(property)){
			changeSalaryAccountProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTitle(newValue);
		//they are surely different each other
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeFamilyNameProperty(String newValueExpr){
		String oldValue = getFamilyName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFamilyName(newValue);
		//they are surely different each other
		this.onChangeProperty(FAMILY_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeGivenNameProperty(String newValueExpr){
		String oldValue = getGivenName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setGivenName(newValue);
		//they are surely different each other
		this.onChangeProperty(GIVEN_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeEmailProperty(String newValueExpr){
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setEmail(newValue);
		//they are surely different each other
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeCityProperty(String newValueExpr){
		String oldValue = getCity();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCity(newValue);
		//they are surely different each other
		this.onChangeProperty(CITY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAddressProperty(String newValueExpr){
		String oldValue = getAddress();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAddress(newValue);
		//they are surely different each other
		this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeCellPhoneProperty(String newValueExpr){
		String oldValue = getCellPhone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCellPhone(newValue);
		//they are surely different each other
		this.onChangeProperty(CELL_PHONE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeSalaryAccountProperty(String newValueExpr){
		String oldValue = getSalaryAccount();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setSalaryAccount(newValue);
		//they are surely different each other
		this.onChangeProperty(SALARY_ACCOUNT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	
	
	public void setDepartment(LevelThreeDepartment department){
		this.mDepartment = department;;
	}
	public LevelThreeDepartment getDepartment(){
		return this.mDepartment;
	}
	
	
	public void setFamilyName(String familyName){
		this.mFamilyName = trimString(familyName);;
	}
	public String getFamilyName(){
		return this.mFamilyName;
	}
	
	
	public void setGivenName(String givenName){
		this.mGivenName = trimString(givenName);;
	}
	public String getGivenName(){
		return this.mGivenName;
	}
	
	
	public void setEmail(String email){
		this.mEmail = trimString(email);;
	}
	public String getEmail(){
		return this.mEmail;
	}
	
	
	public void setCity(String city){
		this.mCity = trimString(city);;
	}
	public String getCity(){
		return this.mCity;
	}
	
	
	public void setAddress(String address){
		this.mAddress = trimString(address);;
	}
	public String getAddress(){
		return this.mAddress;
	}
	
	
	public void setCellPhone(String cellPhone){
		this.mCellPhone = trimString(cellPhone);;
	}
	public String getCellPhone(){
		return this.mCellPhone;
	}
	
	
	
	public String getMaskedCellPhone(){
		String mobilePhoneNumber = getCellPhone();
		if(mobilePhoneNumber == null){
			return null;
		}
		if(mobilePhoneNumber.length()!=11){
			return mobilePhoneNumber;//残缺的手机号，无需屏蔽
		}
		return mobilePhoneNumber.substring(0,3)
			+"****"
			+mobilePhoneNumber.substring(7);
	}
	
		
	public void setOccupation(OccupationType occupation){
		this.mOccupation = occupation;;
	}
	public OccupationType getOccupation(){
		return this.mOccupation;
	}
	
	
	public void setResponsibleFor(ResponsibilityType responsibleFor){
		this.mResponsibleFor = responsibleFor;;
	}
	public ResponsibilityType getResponsibleFor(){
		return this.mResponsibleFor;
	}
	
	
	public void setCurrentSalaryGrade(SalaryGrade currentSalaryGrade){
		this.mCurrentSalaryGrade = currentSalaryGrade;;
	}
	public SalaryGrade getCurrentSalaryGrade(){
		return this.mCurrentSalaryGrade;
	}
	
	
	public void setSalaryAccount(String salaryAccount){
		this.mSalaryAccount = trimString(salaryAccount);;
	}
	public String getSalaryAccount(){
		return this.mSalaryAccount;
	}
	
	
	public void setJobApplication(JobApplication jobApplication){
		this.mJobApplication = jobApplication;;
	}
	public JobApplication getJobApplication(){
		return this.mJobApplication;
	}
	
	
	public void setProfessionInterview(ProfessionInterview professionInterview){
		this.mProfessionInterview = professionInterview;;
	}
	public ProfessionInterview getProfessionInterview(){
		return this.mProfessionInterview;
	}
	
	
	public void setHrInterview(HrInterview hrInterview){
		this.mHrInterview = hrInterview;;
	}
	public HrInterview getHrInterview(){
		return this.mHrInterview;
	}
	
	
	public void setOfferApproval(OfferApproval offerApproval){
		this.mOfferApproval = offerApproval;;
	}
	public OfferApproval getOfferApproval(){
		return this.mOfferApproval;
	}
	
	
	public void setOfferAcceptance(OfferAcceptance offerAcceptance){
		this.mOfferAcceptance = offerAcceptance;;
	}
	public OfferAcceptance getOfferAcceptance(){
		return this.mOfferAcceptance;
	}
	
	
	public void setEmployeeBoarding(EmployeeBoarding employeeBoarding){
		this.mEmployeeBoarding = employeeBoarding;;
	}
	public EmployeeBoarding getEmployeeBoarding(){
		return this.mEmployeeBoarding;
	}
	
	
	public void setTermination(Termination termination){
		this.mTermination = termination;;
	}
	public Termination getTermination(){
		return this.mTermination;
	}
	
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<EmployeeCompanyTraining> getEmployeeCompanyTrainingList(){
		if(this.mEmployeeCompanyTrainingList == null){
			this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();
		}
		return this.mEmployeeCompanyTrainingList;	
	}
	public  void setEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setEmployee(this);
		}
		
		this.mEmployeeCompanyTrainingList = employeeCompanyTrainingList;
		
	}
	
	public  void addEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		employeeCompanyTraining.setEmployee(this);
		getEmployeeCompanyTrainingList().add(employeeCompanyTraining);
	}
	public  void addEmployeeCompanyTrainings(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setEmployee(this);
		}
		getEmployeeCompanyTrainingList().addAll(employeeCompanyTrainingList);
	}
	
	public  void removeEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
	
		boolean result = getEmployeeCompanyTrainingList().planToRemove(employeeCompanyTraining);
        if(!result){
        	String message = "EmployeeCompanyTraining("+employeeCompanyTraining.getId()+") with version='"+employeeCompanyTraining.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeCompanyTrainingList", employeeCompanyTraining);
		//the constant "toEmployeeCompanyTraining" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeCompanyTrainingFrom(EmployeeCompanyTraining employeeCompanyTraining) {
		// TODO Auto-generated method stub
		
        EmployeeCompanyTraining employeeCompanyTrainingInList = findTheEmployeeCompanyTraining(employeeCompanyTraining);
        EmployeeCompanyTraining newEmployeeCompanyTraining = new EmployeeCompanyTraining();
        employeeCompanyTrainingInList.copyTo(newEmployeeCompanyTraining);
        newEmployeeCompanyTraining.setVersion(0);//will trigger copy
        getEmployeeCompanyTrainingList().add(newEmployeeCompanyTraining);
	}
	
	public  EmployeeCompanyTraining findTheEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		
		int index =  getEmployeeCompanyTrainingList().indexOf(employeeCompanyTraining);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeCompanyTraining("+employeeCompanyTraining.getId()+") with version='"+employeeCompanyTraining.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeCompanyTrainingList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeCompanyTrainingList(){
		getEmployeeCompanyTrainingList().clear();
	}
	
	
	
	
	public  SmartList<EmployeeSkill> getEmployeeSkillList(){
		if(this.mEmployeeSkillList == null){
			this.mEmployeeSkillList = new SmartList<EmployeeSkill>();
		}
		return this.mEmployeeSkillList;	
	}
	public  void setEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setEmployee(this);
		}
		
		this.mEmployeeSkillList = employeeSkillList;
		
	}
	
	public  void addEmployeeSkill(EmployeeSkill employeeSkill){
		employeeSkill.setEmployee(this);
		getEmployeeSkillList().add(employeeSkill);
	}
	public  void addEmployeeSkills(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setEmployee(this);
		}
		getEmployeeSkillList().addAll(employeeSkillList);
	}
	
	public  void removeEmployeeSkill(EmployeeSkill employeeSkill){
	
		boolean result = getEmployeeSkillList().planToRemove(employeeSkill);
        if(!result){
        	String message = "EmployeeSkill("+employeeSkill.getId()+") with version='"+employeeSkill.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeSkillList", employeeSkill);
		//the constant "toEmployeeSkill" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeSkillFrom(EmployeeSkill employeeSkill) {
		// TODO Auto-generated method stub
		
        EmployeeSkill employeeSkillInList = findTheEmployeeSkill(employeeSkill);
        EmployeeSkill newEmployeeSkill = new EmployeeSkill();
        employeeSkillInList.copyTo(newEmployeeSkill);
        newEmployeeSkill.setVersion(0);//will trigger copy
        getEmployeeSkillList().add(newEmployeeSkill);
	}
	
	public  EmployeeSkill findTheEmployeeSkill(EmployeeSkill employeeSkill){
		
		int index =  getEmployeeSkillList().indexOf(employeeSkill);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeSkill("+employeeSkill.getId()+") with version='"+employeeSkill.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeSkillList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeSkillList(){
		getEmployeeSkillList().clear();
	}
	
	
	
	
	public  SmartList<EmployeePerformance> getEmployeePerformanceList(){
		if(this.mEmployeePerformanceList == null){
			this.mEmployeePerformanceList = new SmartList<EmployeePerformance>();
		}
		return this.mEmployeePerformanceList;	
	}
	public  void setEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList){
		for( EmployeePerformance employeePerformance:employeePerformanceList){
			employeePerformance.setEmployee(this);
		}
		
		this.mEmployeePerformanceList = employeePerformanceList;
		
	}
	
	public  void addEmployeePerformance(EmployeePerformance employeePerformance){
		employeePerformance.setEmployee(this);
		getEmployeePerformanceList().add(employeePerformance);
	}
	public  void addEmployeePerformances(SmartList<EmployeePerformance> employeePerformanceList){
		for( EmployeePerformance employeePerformance:employeePerformanceList){
			employeePerformance.setEmployee(this);
		}
		getEmployeePerformanceList().addAll(employeePerformanceList);
	}
	
	public  void removeEmployeePerformance(EmployeePerformance employeePerformance){
	
		boolean result = getEmployeePerformanceList().planToRemove(employeePerformance);
        if(!result){
        	String message = "EmployeePerformance("+employeePerformance.getId()+") with version='"+employeePerformance.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeePerformanceList", employeePerformance);
		//the constant "toEmployeePerformance" will be replaced after refactoried.
	
	}
	
	public void copyEmployeePerformanceFrom(EmployeePerformance employeePerformance) {
		// TODO Auto-generated method stub
		
        EmployeePerformance employeePerformanceInList = findTheEmployeePerformance(employeePerformance);
        EmployeePerformance newEmployeePerformance = new EmployeePerformance();
        employeePerformanceInList.copyTo(newEmployeePerformance);
        newEmployeePerformance.setVersion(0);//will trigger copy
        getEmployeePerformanceList().add(newEmployeePerformance);
	}
	
	public  EmployeePerformance findTheEmployeePerformance(EmployeePerformance employeePerformance){
		
		int index =  getEmployeePerformanceList().indexOf(employeePerformance);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeePerformance("+employeePerformance.getId()+") with version='"+employeePerformance.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeePerformanceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeePerformanceList(){
		getEmployeePerformanceList().clear();
	}
	
	
	
	
	public  SmartList<EmployeeWorkExperience> getEmployeeWorkExperienceList(){
		if(this.mEmployeeWorkExperienceList == null){
			this.mEmployeeWorkExperienceList = new SmartList<EmployeeWorkExperience>();
		}
		return this.mEmployeeWorkExperienceList;	
	}
	public  void setEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList){
		for( EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList){
			employeeWorkExperience.setEmployee(this);
		}
		
		this.mEmployeeWorkExperienceList = employeeWorkExperienceList;
		
	}
	
	public  void addEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience){
		employeeWorkExperience.setEmployee(this);
		getEmployeeWorkExperienceList().add(employeeWorkExperience);
	}
	public  void addEmployeeWorkExperiences(SmartList<EmployeeWorkExperience> employeeWorkExperienceList){
		for( EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList){
			employeeWorkExperience.setEmployee(this);
		}
		getEmployeeWorkExperienceList().addAll(employeeWorkExperienceList);
	}
	
	public  void removeEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience){
	
		boolean result = getEmployeeWorkExperienceList().planToRemove(employeeWorkExperience);
        if(!result){
        	String message = "EmployeeWorkExperience("+employeeWorkExperience.getId()+") with version='"+employeeWorkExperience.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeWorkExperienceList", employeeWorkExperience);
		//the constant "toEmployeeWorkExperience" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeWorkExperienceFrom(EmployeeWorkExperience employeeWorkExperience) {
		// TODO Auto-generated method stub
		
        EmployeeWorkExperience employeeWorkExperienceInList = findTheEmployeeWorkExperience(employeeWorkExperience);
        EmployeeWorkExperience newEmployeeWorkExperience = new EmployeeWorkExperience();
        employeeWorkExperienceInList.copyTo(newEmployeeWorkExperience);
        newEmployeeWorkExperience.setVersion(0);//will trigger copy
        getEmployeeWorkExperienceList().add(newEmployeeWorkExperience);
	}
	
	public  EmployeeWorkExperience findTheEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience){
		
		int index =  getEmployeeWorkExperienceList().indexOf(employeeWorkExperience);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeWorkExperience("+employeeWorkExperience.getId()+") with version='"+employeeWorkExperience.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeWorkExperienceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeWorkExperienceList(){
		getEmployeeWorkExperienceList().clear();
	}
	
	
	
	
	public  SmartList<EmployeeLeave> getEmployeeLeaveList(){
		if(this.mEmployeeLeaveList == null){
			this.mEmployeeLeaveList = new SmartList<EmployeeLeave>();
		}
		return this.mEmployeeLeaveList;	
	}
	public  void setEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setWho(this);
		}
		
		this.mEmployeeLeaveList = employeeLeaveList;
		
	}
	
	public  void addEmployeeLeave(EmployeeLeave employeeLeave){
		employeeLeave.setWho(this);
		getEmployeeLeaveList().add(employeeLeave);
	}
	public  void addEmployeeLeaves(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setWho(this);
		}
		getEmployeeLeaveList().addAll(employeeLeaveList);
	}
	
	public  void removeEmployeeLeave(EmployeeLeave employeeLeave){
	
		boolean result = getEmployeeLeaveList().planToRemove(employeeLeave);
        if(!result){
        	String message = "EmployeeLeave("+employeeLeave.getId()+") with version='"+employeeLeave.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeLeaveList", employeeLeave);
		//the constant "toEmployeeLeave" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeLeaveFrom(EmployeeLeave employeeLeave) {
		// TODO Auto-generated method stub
		
        EmployeeLeave employeeLeaveInList = findTheEmployeeLeave(employeeLeave);
        EmployeeLeave newEmployeeLeave = new EmployeeLeave();
        employeeLeaveInList.copyTo(newEmployeeLeave);
        newEmployeeLeave.setVersion(0);//will trigger copy
        getEmployeeLeaveList().add(newEmployeeLeave);
	}
	
	public  EmployeeLeave findTheEmployeeLeave(EmployeeLeave employeeLeave){
		
		int index =  getEmployeeLeaveList().indexOf(employeeLeave);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeLeave("+employeeLeave.getId()+") with version='"+employeeLeave.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeLeaveList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeLeaveList(){
		getEmployeeLeaveList().clear();
	}
	
	
	
	
	public  SmartList<EmployeeInterview> getEmployeeInterviewList(){
		if(this.mEmployeeInterviewList == null){
			this.mEmployeeInterviewList = new SmartList<EmployeeInterview>();
		}
		return this.mEmployeeInterviewList;	
	}
	public  void setEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setEmployee(this);
		}
		
		this.mEmployeeInterviewList = employeeInterviewList;
		
	}
	
	public  void addEmployeeInterview(EmployeeInterview employeeInterview){
		employeeInterview.setEmployee(this);
		getEmployeeInterviewList().add(employeeInterview);
	}
	public  void addEmployeeInterviews(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setEmployee(this);
		}
		getEmployeeInterviewList().addAll(employeeInterviewList);
	}
	
	public  void removeEmployeeInterview(EmployeeInterview employeeInterview){
	
		boolean result = getEmployeeInterviewList().planToRemove(employeeInterview);
        if(!result){
        	String message = "EmployeeInterview("+employeeInterview.getId()+") with version='"+employeeInterview.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeInterviewList", employeeInterview);
		//the constant "toEmployeeInterview" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeInterviewFrom(EmployeeInterview employeeInterview) {
		// TODO Auto-generated method stub
		
        EmployeeInterview employeeInterviewInList = findTheEmployeeInterview(employeeInterview);
        EmployeeInterview newEmployeeInterview = new EmployeeInterview();
        employeeInterviewInList.copyTo(newEmployeeInterview);
        newEmployeeInterview.setVersion(0);//will trigger copy
        getEmployeeInterviewList().add(newEmployeeInterview);
	}
	
	public  EmployeeInterview findTheEmployeeInterview(EmployeeInterview employeeInterview){
		
		int index =  getEmployeeInterviewList().indexOf(employeeInterview);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeInterview("+employeeInterview.getId()+") with version='"+employeeInterview.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeInterviewList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeInterviewList(){
		getEmployeeInterviewList().clear();
	}
	
	
	
	
	public  SmartList<EmployeeAttendance> getEmployeeAttendanceList(){
		if(this.mEmployeeAttendanceList == null){
			this.mEmployeeAttendanceList = new SmartList<EmployeeAttendance>();
		}
		return this.mEmployeeAttendanceList;	
	}
	public  void setEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList){
		for( EmployeeAttendance employeeAttendance:employeeAttendanceList){
			employeeAttendance.setEmployee(this);
		}
		
		this.mEmployeeAttendanceList = employeeAttendanceList;
		
	}
	
	public  void addEmployeeAttendance(EmployeeAttendance employeeAttendance){
		employeeAttendance.setEmployee(this);
		getEmployeeAttendanceList().add(employeeAttendance);
	}
	public  void addEmployeeAttendances(SmartList<EmployeeAttendance> employeeAttendanceList){
		for( EmployeeAttendance employeeAttendance:employeeAttendanceList){
			employeeAttendance.setEmployee(this);
		}
		getEmployeeAttendanceList().addAll(employeeAttendanceList);
	}
	
	public  void removeEmployeeAttendance(EmployeeAttendance employeeAttendance){
	
		boolean result = getEmployeeAttendanceList().planToRemove(employeeAttendance);
        if(!result){
        	String message = "EmployeeAttendance("+employeeAttendance.getId()+") with version='"+employeeAttendance.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeAttendanceList", employeeAttendance);
		//the constant "toEmployeeAttendance" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeAttendanceFrom(EmployeeAttendance employeeAttendance) {
		// TODO Auto-generated method stub
		
        EmployeeAttendance employeeAttendanceInList = findTheEmployeeAttendance(employeeAttendance);
        EmployeeAttendance newEmployeeAttendance = new EmployeeAttendance();
        employeeAttendanceInList.copyTo(newEmployeeAttendance);
        newEmployeeAttendance.setVersion(0);//will trigger copy
        getEmployeeAttendanceList().add(newEmployeeAttendance);
	}
	
	public  EmployeeAttendance findTheEmployeeAttendance(EmployeeAttendance employeeAttendance){
		
		int index =  getEmployeeAttendanceList().indexOf(employeeAttendance);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeAttendance("+employeeAttendance.getId()+") with version='"+employeeAttendance.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeAttendanceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeAttendanceList(){
		getEmployeeAttendanceList().clear();
	}
	
	
	
	
	public  SmartList<EmployeeQualifier> getEmployeeQualifierList(){
		if(this.mEmployeeQualifierList == null){
			this.mEmployeeQualifierList = new SmartList<EmployeeQualifier>();
		}
		return this.mEmployeeQualifierList;	
	}
	public  void setEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList){
		for( EmployeeQualifier employeeQualifier:employeeQualifierList){
			employeeQualifier.setEmployee(this);
		}
		
		this.mEmployeeQualifierList = employeeQualifierList;
		
	}
	
	public  void addEmployeeQualifier(EmployeeQualifier employeeQualifier){
		employeeQualifier.setEmployee(this);
		getEmployeeQualifierList().add(employeeQualifier);
	}
	public  void addEmployeeQualifiers(SmartList<EmployeeQualifier> employeeQualifierList){
		for( EmployeeQualifier employeeQualifier:employeeQualifierList){
			employeeQualifier.setEmployee(this);
		}
		getEmployeeQualifierList().addAll(employeeQualifierList);
	}
	
	public  void removeEmployeeQualifier(EmployeeQualifier employeeQualifier){
	
		boolean result = getEmployeeQualifierList().planToRemove(employeeQualifier);
        if(!result){
        	String message = "EmployeeQualifier("+employeeQualifier.getId()+") with version='"+employeeQualifier.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeQualifierList", employeeQualifier);
		//the constant "toEmployeeQualifier" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeQualifierFrom(EmployeeQualifier employeeQualifier) {
		// TODO Auto-generated method stub
		
        EmployeeQualifier employeeQualifierInList = findTheEmployeeQualifier(employeeQualifier);
        EmployeeQualifier newEmployeeQualifier = new EmployeeQualifier();
        employeeQualifierInList.copyTo(newEmployeeQualifier);
        newEmployeeQualifier.setVersion(0);//will trigger copy
        getEmployeeQualifierList().add(newEmployeeQualifier);
	}
	
	public  EmployeeQualifier findTheEmployeeQualifier(EmployeeQualifier employeeQualifier){
		
		int index =  getEmployeeQualifierList().indexOf(employeeQualifier);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeQualifier("+employeeQualifier.getId()+") with version='"+employeeQualifier.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeQualifierList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeQualifierList(){
		getEmployeeQualifierList().clear();
	}
	
	
	
	
	public  SmartList<EmployeeEducation> getEmployeeEducationList(){
		if(this.mEmployeeEducationList == null){
			this.mEmployeeEducationList = new SmartList<EmployeeEducation>();
		}
		return this.mEmployeeEducationList;	
	}
	public  void setEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList){
		for( EmployeeEducation employeeEducation:employeeEducationList){
			employeeEducation.setEmployee(this);
		}
		
		this.mEmployeeEducationList = employeeEducationList;
		
	}
	
	public  void addEmployeeEducation(EmployeeEducation employeeEducation){
		employeeEducation.setEmployee(this);
		getEmployeeEducationList().add(employeeEducation);
	}
	public  void addEmployeeEducations(SmartList<EmployeeEducation> employeeEducationList){
		for( EmployeeEducation employeeEducation:employeeEducationList){
			employeeEducation.setEmployee(this);
		}
		getEmployeeEducationList().addAll(employeeEducationList);
	}
	
	public  void removeEmployeeEducation(EmployeeEducation employeeEducation){
	
		boolean result = getEmployeeEducationList().planToRemove(employeeEducation);
        if(!result){
        	String message = "EmployeeEducation("+employeeEducation.getId()+") with version='"+employeeEducation.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeEducationList", employeeEducation);
		//the constant "toEmployeeEducation" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeEducationFrom(EmployeeEducation employeeEducation) {
		// TODO Auto-generated method stub
		
        EmployeeEducation employeeEducationInList = findTheEmployeeEducation(employeeEducation);
        EmployeeEducation newEmployeeEducation = new EmployeeEducation();
        employeeEducationInList.copyTo(newEmployeeEducation);
        newEmployeeEducation.setVersion(0);//will trigger copy
        getEmployeeEducationList().add(newEmployeeEducation);
	}
	
	public  EmployeeEducation findTheEmployeeEducation(EmployeeEducation employeeEducation){
		
		int index =  getEmployeeEducationList().indexOf(employeeEducation);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeEducation("+employeeEducation.getId()+") with version='"+employeeEducation.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeEducationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeEducationList(){
		getEmployeeEducationList().clear();
	}
	
	
	
	
	public  SmartList<EmployeeAward> getEmployeeAwardList(){
		if(this.mEmployeeAwardList == null){
			this.mEmployeeAwardList = new SmartList<EmployeeAward>();
		}
		return this.mEmployeeAwardList;	
	}
	public  void setEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList){
		for( EmployeeAward employeeAward:employeeAwardList){
			employeeAward.setEmployee(this);
		}
		
		this.mEmployeeAwardList = employeeAwardList;
		
	}
	
	public  void addEmployeeAward(EmployeeAward employeeAward){
		employeeAward.setEmployee(this);
		getEmployeeAwardList().add(employeeAward);
	}
	public  void addEmployeeAwards(SmartList<EmployeeAward> employeeAwardList){
		for( EmployeeAward employeeAward:employeeAwardList){
			employeeAward.setEmployee(this);
		}
		getEmployeeAwardList().addAll(employeeAwardList);
	}
	
	public  void removeEmployeeAward(EmployeeAward employeeAward){
	
		boolean result = getEmployeeAwardList().planToRemove(employeeAward);
        if(!result){
        	String message = "EmployeeAward("+employeeAward.getId()+") with version='"+employeeAward.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeAwardList", employeeAward);
		//the constant "toEmployeeAward" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeAwardFrom(EmployeeAward employeeAward) {
		// TODO Auto-generated method stub
		
        EmployeeAward employeeAwardInList = findTheEmployeeAward(employeeAward);
        EmployeeAward newEmployeeAward = new EmployeeAward();
        employeeAwardInList.copyTo(newEmployeeAward);
        newEmployeeAward.setVersion(0);//will trigger copy
        getEmployeeAwardList().add(newEmployeeAward);
	}
	
	public  EmployeeAward findTheEmployeeAward(EmployeeAward employeeAward){
		
		int index =  getEmployeeAwardList().indexOf(employeeAward);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeAward("+employeeAward.getId()+") with version='"+employeeAward.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeAwardList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeAwardList(){
		getEmployeeAwardList().clear();
	}
	
	
	
	
	public  SmartList<EmployeeSalarySheet> getEmployeeSalarySheetList(){
		if(this.mEmployeeSalarySheetList == null){
			this.mEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();
		}
		return this.mEmployeeSalarySheetList;	
	}
	public  void setEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setEmployee(this);
		}
		
		this.mEmployeeSalarySheetList = employeeSalarySheetList;
		
	}
	
	public  void addEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		employeeSalarySheet.setEmployee(this);
		getEmployeeSalarySheetList().add(employeeSalarySheet);
	}
	public  void addEmployeeSalarySheets(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setEmployee(this);
		}
		getEmployeeSalarySheetList().addAll(employeeSalarySheetList);
	}
	
	public  void removeEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
	
		boolean result = getEmployeeSalarySheetList().planToRemove(employeeSalarySheet);
        if(!result){
        	String message = "EmployeeSalarySheet("+employeeSalarySheet.getId()+") with version='"+employeeSalarySheet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeSalarySheetList", employeeSalarySheet);
		//the constant "toEmployeeSalarySheet" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeSalarySheetFrom(EmployeeSalarySheet employeeSalarySheet) {
		// TODO Auto-generated method stub
		
        EmployeeSalarySheet employeeSalarySheetInList = findTheEmployeeSalarySheet(employeeSalarySheet);
        EmployeeSalarySheet newEmployeeSalarySheet = new EmployeeSalarySheet();
        employeeSalarySheetInList.copyTo(newEmployeeSalarySheet);
        newEmployeeSalarySheet.setVersion(0);//will trigger copy
        getEmployeeSalarySheetList().add(newEmployeeSalarySheet);
	}
	
	public  EmployeeSalarySheet findTheEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		
		int index =  getEmployeeSalarySheetList().indexOf(employeeSalarySheet);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeSalarySheet("+employeeSalarySheet.getId()+") with version='"+employeeSalarySheet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeSalarySheetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeSalarySheetList(){
		getEmployeeSalarySheetList().clear();
	}
	
	
	
	
	public  SmartList<PayingOff> getPayingOffList(){
		if(this.mPayingOffList == null){
			this.mPayingOffList = new SmartList<PayingOff>();
		}
		return this.mPayingOffList;	
	}
	public  void setPayingOffList(SmartList<PayingOff> payingOffList){
		for( PayingOff payingOff:payingOffList){
			payingOff.setPaidFor(this);
		}
		
		this.mPayingOffList = payingOffList;
		
	}
	
	public  void addPayingOff(PayingOff payingOff){
		payingOff.setPaidFor(this);
		getPayingOffList().add(payingOff);
	}
	public  void addPayingOffs(SmartList<PayingOff> payingOffList){
		for( PayingOff payingOff:payingOffList){
			payingOff.setPaidFor(this);
		}
		getPayingOffList().addAll(payingOffList);
	}
	
	public  void removePayingOff(PayingOff payingOff){
	
		boolean result = getPayingOffList().planToRemove(payingOff);
        if(!result){
        	String message = "PayingOff("+payingOff.getId()+") with version='"+payingOff.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemovePayingOffList", payingOff);
		//the constant "toPayingOff" will be replaced after refactoried.
	
	}
	
	public void copyPayingOffFrom(PayingOff payingOff) {
		// TODO Auto-generated method stub
		
        PayingOff payingOffInList = findThePayingOff(payingOff);
        PayingOff newPayingOff = new PayingOff();
        payingOffInList.copyTo(newPayingOff);
        newPayingOff.setVersion(0);//will trigger copy
        getPayingOffList().add(newPayingOff);
	}
	
	public  PayingOff findThePayingOff(PayingOff payingOff){
		
		int index =  getPayingOffList().indexOf(payingOff);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "PayingOff("+payingOff.getId()+") with version='"+payingOff.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getPayingOffList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPayingOffList(){
		getPayingOffList().clear();
	}
	
	
	
	
 	
	
	public Employee copyTo(Employee dest){

		dest.setId(getId());
		dest.setCompany(getCompany());
		dest.setTitle(getTitle());
		dest.setDepartment(getDepartment());
		dest.setFamilyName(getFamilyName());
		dest.setGivenName(getGivenName());
		dest.setEmail(getEmail());
		dest.setCity(getCity());
		dest.setAddress(getAddress());
		dest.setCellPhone(getCellPhone());
		dest.setOccupation(getOccupation());
		dest.setResponsibleFor(getResponsibleFor());
		dest.setCurrentSalaryGrade(getCurrentSalaryGrade());
		dest.setSalaryAccount(getSalaryAccount());
		dest.setJobApplication(getJobApplication());
		dest.setProfessionInterview(getProfessionInterview());
		dest.setHrInterview(getHrInterview());
		dest.setOfferApproval(getOfferApproval());
		dest.setOfferAcceptance(getOfferAcceptance());
		dest.setEmployeeBoarding(getEmployeeBoarding());
		dest.setTermination(getTermination());
		dest.setCurrentStatus(getCurrentStatus());
		dest.setVersion(getVersion());
		dest.setEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());
		dest.setEmployeeSkillList(getEmployeeSkillList());
		dest.setEmployeePerformanceList(getEmployeePerformanceList());
		dest.setEmployeeWorkExperienceList(getEmployeeWorkExperienceList());
		dest.setEmployeeLeaveList(getEmployeeLeaveList());
		dest.setEmployeeInterviewList(getEmployeeInterviewList());
		dest.setEmployeeAttendanceList(getEmployeeAttendanceList());
		dest.setEmployeeQualifierList(getEmployeeQualifierList());
		dest.setEmployeeEducationList(getEmployeeEducationList());
		dest.setEmployeeAwardList(getEmployeeAwardList());
		dest.setEmployeeSalarySheetList(getEmployeeSalarySheetList());
		dest.setPayingOffList(getPayingOffList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='retail_store_country_center("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getDepartment() != null ){
 			stringBuilder.append("\tdepartment='level_three_department("+getDepartment().getId()+")';");
 		}
		stringBuilder.append("\tfamily_name='"+getFamilyName()+"';");
		stringBuilder.append("\tgiven_name='"+getGivenName()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tcity='"+getCity()+"';");
		stringBuilder.append("\taddress='"+getAddress()+"';");
		stringBuilder.append("\tcell_phone='"+getCellPhone()+"';");
		if(getOccupation() != null ){
 			stringBuilder.append("\toccupation='occupation_type("+getOccupation().getId()+")';");
 		}
		if(getResponsibleFor() != null ){
 			stringBuilder.append("\tresponsible_for='responsibility_type("+getResponsibleFor().getId()+")';");
 		}
		if(getCurrentSalaryGrade() != null ){
 			stringBuilder.append("\tcurrent_salary_grade='salary_grade("+getCurrentSalaryGrade().getId()+")';");
 		}
		stringBuilder.append("\tsalary_account='"+getSalaryAccount()+"';");
		if(getJobApplication() != null ){
 			stringBuilder.append("\tjob_application='job_application("+getJobApplication().getId()+")';");
 		}
		if(getProfessionInterview() != null ){
 			stringBuilder.append("\tprofession_interview='profession_interview("+getProfessionInterview().getId()+")';");
 		}
		if(getHrInterview() != null ){
 			stringBuilder.append("\thr_interview='hr_interview("+getHrInterview().getId()+")';");
 		}
		if(getOfferApproval() != null ){
 			stringBuilder.append("\toffer_approval='offer_approval("+getOfferApproval().getId()+")';");
 		}
		if(getOfferAcceptance() != null ){
 			stringBuilder.append("\toffer_acceptance='offer_acceptance("+getOfferAcceptance().getId()+")';");
 		}
		if(getEmployeeBoarding() != null ){
 			stringBuilder.append("\temployee_boarding='employee_boarding("+getEmployeeBoarding().getId()+")';");
 		}
		if(getTermination() != null ){
 			stringBuilder.append("\ttermination='termination("+getTermination().getId()+")';");
 		}
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

