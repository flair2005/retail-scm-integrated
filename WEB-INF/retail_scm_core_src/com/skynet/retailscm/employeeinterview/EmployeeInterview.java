
package com.skynet.retailscm.employeeinterview;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.interviewtype.InterviewType;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeInterviewSerializer.class)
public class EmployeeInterview extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String INTERVIEW_TYPE_PROPERTY        = "interviewType"     ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		InterviewType       	mInterviewType      ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeInterview(){
		//lazy load for all the properties
	}
	
	public 	EmployeeInterview(Employee employee, InterviewType interviewType, String remark
)
	{
		setEmployee(employee);
		setInterviewType(interviewType);
		setRemark(remark);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeRemarkProperty(String newValueExpr){
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setRemark(newValue);
		//they are surely different each other
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
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
	
	
	public void setInterviewType(InterviewType interviewType){
		this.mInterviewType = interviewType;;
	}
	public InterviewType getInterviewType(){
		return this.mInterviewType;
	}
	
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public EmployeeInterview copyTo(EmployeeInterview dest){

		dest.setId(getId());
		dest.setEmployee(getEmployee());
		dest.setInterviewType(getInterviewType());
		dest.setRemark(getRemark());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_interview{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='employee("+getEmployee().getId()+")';");
 		}
		if(getInterviewType() != null ){
 			stringBuilder.append("\tinterview_type='interview_type("+getInterviewType().getId()+")';");
 		}
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

