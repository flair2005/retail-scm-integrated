
package com.skynet.retailscm.employeeattendance;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeAttendanceSerializer.class)
public class EmployeeAttendance extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String ENTER_TIME_PROPERTY            = "enterTime"         ;
	public static final String LEAVE_TIME_PROPERTY            = "leaveTime"         ;
	public static final String DURATION_HOURS_PROPERTY        = "durationHours"     ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		Date                	mEnterTime          ;
	protected		Date                	mLeaveTime          ;
	protected		int                 	mDurationHours      ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeAttendance(){
		//lazy load for all the properties
	}
	
	public 	EmployeeAttendance(Employee employee, Date enterTime, Date leaveTime, int durationHours, String remark
)
	{
		setEmployee(employee);
		setEnterTime(enterTime);
		setLeaveTime(leaveTime);
		setDurationHours(durationHours);
		setRemark(remark);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(ENTER_TIME_PROPERTY.equals(property)){
			changeEnterTimeProperty(newValueExpr);
		}
		if(LEAVE_TIME_PROPERTY.equals(property)){
			changeLeaveTimeProperty(newValueExpr);
		}
		if(DURATION_HOURS_PROPERTY.equals(property)){
			changeDurationHoursProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeEnterTimeProperty(String newValueExpr){
		Date oldValue = getEnterTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setEnterTime(newValue);
		//they are surely different each other
		this.onChangeProperty(ENTER_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLeaveTimeProperty(String newValueExpr){
		Date oldValue = getLeaveTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLeaveTime(newValue);
		//they are surely different each other
		this.onChangeProperty(LEAVE_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDurationHoursProperty(String newValueExpr){
		int oldValue = getDurationHours();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDurationHours(newValue);
		//they are surely different each other
		this.onChangeProperty(DURATION_HOURS_PROPERTY, oldValue, newValue);
		return;
             
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
	
	
	public void setEnterTime(Date enterTime){
		this.mEnterTime = enterTime;;
	}
	public Date getEnterTime(){
		return this.mEnterTime;
	}
	
	
	public void setLeaveTime(Date leaveTime){
		this.mLeaveTime = leaveTime;;
	}
	public Date getLeaveTime(){
		return this.mLeaveTime;
	}
	
	
	public void setDurationHours(int durationHours){
		this.mDurationHours = durationHours;;
	}
	public int getDurationHours(){
		return this.mDurationHours;
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
	
	
 	
	
	public EmployeeAttendance copyTo(EmployeeAttendance dest){

		dest.setId(getId());
		dest.setEmployee(getEmployee());
		dest.setEnterTime(getEnterTime());
		dest.setLeaveTime(getLeaveTime());
		dest.setDurationHours(getDurationHours());
		dest.setRemark(getRemark());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_attendance{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tenter_time='"+getEnterTime()+"';");
		stringBuilder.append("\tleave_time='"+getLeaveTime()+"';");
		stringBuilder.append("\tduration_hours='"+getDurationHours()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

