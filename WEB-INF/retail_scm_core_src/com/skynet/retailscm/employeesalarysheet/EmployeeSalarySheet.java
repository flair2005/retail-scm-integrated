
package com.skynet.retailscm.employeesalarysheet;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.salarygrade.SalaryGrade;

@JsonSerialize(using = EmployeeSalarySheetSerializer.class)
public class EmployeeSalarySheet extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String CURRENT_SALARY_GRADE_PROPERTY  = "currentSalaryGrade";
	public static final String BASE_SALARY_PROPERTY           = "baseSalary"        ;
	public static final String BONUS_PROPERTY                 = "bonus"             ;
	public static final String REWARD_PROPERTY                = "reward"            ;
	public static final String PERSONAL_TAX_PROPERTY          = "personalTax"       ;
	public static final String SOCIAL_SECURITY_PROPERTY       = "socialSecurity"    ;
	public static final String HOUSING_FOUND_PROPERTY         = "housingFound"      ;
	public static final String JOB_INSURANCE_PROPERTY         = "jobInsurance"      ;
	public static final String PAYING_OFF_PROPERTY            = "payingOff"         ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		SalaryGrade         	mCurrentSalaryGrade ;
	protected		double              	mBaseSalary         ;
	protected		double              	mBonus              ;
	protected		double              	mReward             ;
	protected		double              	mPersonalTax        ;
	protected		double              	mSocialSecurity     ;
	protected		double              	mHousingFound       ;
	protected		double              	mJobInsurance       ;
	protected		PayingOff           	mPayingOff          ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeSalarySheet(){
		//lazy load for all the properties
	}
	
	public 	EmployeeSalarySheet(Employee employee, SalaryGrade currentSalaryGrade, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance, String currentStatus
)
	{
		setEmployee(employee);
		setCurrentSalaryGrade(currentSalaryGrade);
		setBaseSalary(baseSalary);
		setBonus(bonus);
		setReward(reward);
		setPersonalTax(personalTax);
		setSocialSecurity(socialSecurity);
		setHousingFound(housingFound);
		setJobInsurance(jobInsurance);
		setCurrentStatus(currentStatus);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(BASE_SALARY_PROPERTY.equals(property)){
			changeBaseSalaryProperty(newValueExpr);
		}
		if(BONUS_PROPERTY.equals(property)){
			changeBonusProperty(newValueExpr);
		}
		if(REWARD_PROPERTY.equals(property)){
			changeRewardProperty(newValueExpr);
		}
		if(PERSONAL_TAX_PROPERTY.equals(property)){
			changePersonalTaxProperty(newValueExpr);
		}
		if(SOCIAL_SECURITY_PROPERTY.equals(property)){
			changeSocialSecurityProperty(newValueExpr);
		}
		if(HOUSING_FOUND_PROPERTY.equals(property)){
			changeHousingFoundProperty(newValueExpr);
		}
		if(JOB_INSURANCE_PROPERTY.equals(property)){
			changeJobInsuranceProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeBaseSalaryProperty(String newValueExpr){
		double oldValue = getBaseSalary();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setBaseSalary(newValue);
		//they are surely different each other
		this.onChangeProperty(BASE_SALARY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeBonusProperty(String newValueExpr){
		double oldValue = getBonus();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setBonus(newValue);
		//they are surely different each other
		this.onChangeProperty(BONUS_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeRewardProperty(String newValueExpr){
		double oldValue = getReward();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setReward(newValue);
		//they are surely different each other
		this.onChangeProperty(REWARD_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changePersonalTaxProperty(String newValueExpr){
		double oldValue = getPersonalTax();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPersonalTax(newValue);
		//they are surely different each other
		this.onChangeProperty(PERSONAL_TAX_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeSocialSecurityProperty(String newValueExpr){
		double oldValue = getSocialSecurity();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setSocialSecurity(newValue);
		//they are surely different each other
		this.onChangeProperty(SOCIAL_SECURITY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeHousingFoundProperty(String newValueExpr){
		double oldValue = getHousingFound();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setHousingFound(newValue);
		//they are surely different each other
		this.onChangeProperty(HOUSING_FOUND_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeJobInsuranceProperty(String newValueExpr){
		double oldValue = getJobInsurance();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setJobInsurance(newValue);
		//they are surely different each other
		this.onChangeProperty(JOB_INSURANCE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setEmployee(Employee employee){
		this.mEmployee = employee;;
	}
	public Employee getEmployee(){
		return this.mEmployee;
	}
	
	
	public void setCurrentSalaryGrade(SalaryGrade currentSalaryGrade){
		this.mCurrentSalaryGrade = currentSalaryGrade;;
	}
	public SalaryGrade getCurrentSalaryGrade(){
		return this.mCurrentSalaryGrade;
	}
	
	
	public void setBaseSalary(double baseSalary){
		this.mBaseSalary = baseSalary;;
	}
	public double getBaseSalary(){
		return this.mBaseSalary;
	}
	
	
	public void setBonus(double bonus){
		this.mBonus = bonus;;
	}
	public double getBonus(){
		return this.mBonus;
	}
	
	
	public void setReward(double reward){
		this.mReward = reward;;
	}
	public double getReward(){
		return this.mReward;
	}
	
	
	public void setPersonalTax(double personalTax){
		this.mPersonalTax = personalTax;;
	}
	public double getPersonalTax(){
		return this.mPersonalTax;
	}
	
	
	public void setSocialSecurity(double socialSecurity){
		this.mSocialSecurity = socialSecurity;;
	}
	public double getSocialSecurity(){
		return this.mSocialSecurity;
	}
	
	
	public void setHousingFound(double housingFound){
		this.mHousingFound = housingFound;;
	}
	public double getHousingFound(){
		return this.mHousingFound;
	}
	
	
	public void setJobInsurance(double jobInsurance){
		this.mJobInsurance = jobInsurance;;
	}
	public double getJobInsurance(){
		return this.mJobInsurance;
	}
	
	
	public void setPayingOff(PayingOff payingOff){
		this.mPayingOff = payingOff;;
	}
	public PayingOff getPayingOff(){
		return this.mPayingOff;
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
	
	
 	
	
	public EmployeeSalarySheet copyTo(EmployeeSalarySheet dest){

		dest.setId(getId());
		dest.setEmployee(getEmployee());
		dest.setCurrentSalaryGrade(getCurrentSalaryGrade());
		dest.setBaseSalary(getBaseSalary());
		dest.setBonus(getBonus());
		dest.setReward(getReward());
		dest.setPersonalTax(getPersonalTax());
		dest.setSocialSecurity(getSocialSecurity());
		dest.setHousingFound(getHousingFound());
		dest.setJobInsurance(getJobInsurance());
		dest.setPayingOff(getPayingOff());
		dest.setCurrentStatus(getCurrentStatus());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_salary_sheet{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='employee("+getEmployee().getId()+")';");
 		}
		if(getCurrentSalaryGrade() != null ){
 			stringBuilder.append("\tcurrent_salary_grade='salary_grade("+getCurrentSalaryGrade().getId()+")';");
 		}
		stringBuilder.append("\tbase_salary='"+getBaseSalary()+"';");
		stringBuilder.append("\tbonus='"+getBonus()+"';");
		stringBuilder.append("\treward='"+getReward()+"';");
		stringBuilder.append("\tpersonal_tax='"+getPersonalTax()+"';");
		stringBuilder.append("\tsocial_security='"+getSocialSecurity()+"';");
		stringBuilder.append("\thousing_found='"+getHousingFound()+"';");
		stringBuilder.append("\tjob_insurance='"+getJobInsurance()+"';");
		if(getPayingOff() != null ){
 			stringBuilder.append("\tpaying_off='paying_off("+getPayingOff().getId()+")';");
 		}
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

