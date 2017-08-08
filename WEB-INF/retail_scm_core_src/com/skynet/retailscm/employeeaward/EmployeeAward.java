
package com.skynet.retailscm.employeeaward;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeAwardSerializer.class)
public class EmployeeAward extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String COMPLETE_TIME_PROPERTY         = "completeTime"      ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		Date                	mCompleteTime       ;
	protected		String              	mType               ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeAward(){
		//lazy load for all the properties
	}
	
	public 	EmployeeAward(Employee employee, Date completeTime, String type, String remark
)
	{
		setEmployee(employee);
		setCompleteTime(completeTime);
		setType(type);
		setRemark(remark);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(COMPLETE_TIME_PROPERTY.equals(property)){
			changeCompleteTimeProperty(newValueExpr);
		}
		if(TYPE_PROPERTY.equals(property)){
			changeTypeProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCompleteTimeProperty(String newValueExpr){
		Date oldValue = getCompleteTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCompleteTime(newValue);
		//they are surely different each other
		this.onChangeProperty(COMPLETE_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeTypeProperty(String newValueExpr){
		String oldValue = getType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setType(newValue);
		//they are surely different each other
		this.onChangeProperty(TYPE_PROPERTY, oldValue, newValue);
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
	
	
	public void setCompleteTime(Date completeTime){
		this.mCompleteTime = completeTime;;
	}
	public Date getCompleteTime(){
		return this.mCompleteTime;
	}
	
	
	public void setType(String type){
		this.mType = trimString(type);;
	}
	public String getType(){
		return this.mType;
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
	
	
 	
	
	public EmployeeAward copyTo(EmployeeAward dest){

		dest.setId(getId());
		dest.setEmployee(getEmployee());
		dest.setCompleteTime(getCompleteTime());
		dest.setType(getType());
		dest.setRemark(getRemark());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_award{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tcomplete_time='"+getCompleteTime()+"';");
		stringBuilder.append("\ttype='"+getType()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

