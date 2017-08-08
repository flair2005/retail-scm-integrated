
package com.skynet.retailscm.employeecompanytraining;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.scoring.Scoring;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeCompanyTrainingSerializer.class)
public class EmployeeCompanyTraining extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String TRAINING_PROPERTY              = "training"          ;
	public static final String SCORING_PROPERTY               = "scoring"           ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		CompanyTraining     	mTraining           ;
	protected		Scoring             	mScoring            ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeCompanyTraining(){
		//lazy load for all the properties
	}
	
	public 	EmployeeCompanyTraining(Employee employee, CompanyTraining training, String currentStatus
)
	{
		setEmployee(employee);
		setTraining(training);
		setCurrentStatus(currentStatus);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	

      
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
	
	
	public void setTraining(CompanyTraining training){
		this.mTraining = training;;
	}
	public CompanyTraining getTraining(){
		return this.mTraining;
	}
	
	
	public void setScoring(Scoring scoring){
		this.mScoring = scoring;;
	}
	public Scoring getScoring(){
		return this.mScoring;
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
	
	
 	
	
	public EmployeeCompanyTraining copyTo(EmployeeCompanyTraining dest){

		dest.setId(getId());
		dest.setEmployee(getEmployee());
		dest.setTraining(getTraining());
		dest.setScoring(getScoring());
		dest.setCurrentStatus(getCurrentStatus());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_company_training{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='employee("+getEmployee().getId()+")';");
 		}
		if(getTraining() != null ){
 			stringBuilder.append("\ttraining='company_training("+getTraining().getId()+")';");
 		}
		if(getScoring() != null ){
 			stringBuilder.append("\tscoring='scoring("+getScoring().getId()+")';");
 		}
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

