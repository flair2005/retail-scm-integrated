
package com.skynet.retailscm.employeeleave;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.leavetype.LeaveType;

@JsonSerialize(using = EmployeeLeaveSerializer.class)
public class EmployeeLeave extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String LEAVE_DURATION_HOUR_PROPERTY   = "leaveDurationHour" ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mWho                ;
	protected		LeaveType           	mType               ;
	protected		int                 	mLeaveDurationHour  ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeLeave(){
		//lazy load for all the properties
	}
	
	public 	EmployeeLeave(Employee who, LeaveType type, int leaveDurationHour, String remark
)
	{
		setWho(who);
		setType(type);
		setLeaveDurationHour(leaveDurationHour);
		setRemark(remark);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			changeLeaveDurationHourProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLeaveDurationHourProperty(String newValueExpr){
		int oldValue = getLeaveDurationHour();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLeaveDurationHour(newValue);
		//they are surely different each other
		this.onChangeProperty(LEAVE_DURATION_HOUR_PROPERTY, oldValue, newValue);
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
	
	
	public void setWho(Employee who){
		this.mWho = who;;
	}
	public Employee getWho(){
		return this.mWho;
	}
	
	
	public void setType(LeaveType type){
		this.mType = type;;
	}
	public LeaveType getType(){
		return this.mType;
	}
	
	
	public void setLeaveDurationHour(int leaveDurationHour){
		this.mLeaveDurationHour = leaveDurationHour;;
	}
	public int getLeaveDurationHour(){
		return this.mLeaveDurationHour;
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
	
	
 	
	
	public EmployeeLeave copyTo(EmployeeLeave dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setType(getType());
		dest.setLeaveDurationHour(getLeaveDurationHour());
		dest.setRemark(getRemark());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_leave{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getWho() != null ){
 			stringBuilder.append("\twho='employee("+getWho().getId()+")';");
 		}
		if(getType() != null ){
 			stringBuilder.append("\ttype='leave_type("+getType().getId()+")';");
 		}
		stringBuilder.append("\tleave_duration_hour='"+getLeaveDurationHour()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

