
package com.skynet.retailscm.employeequalifier;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeQualifierSerializer.class)
public class EmployeeQualifier extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String QUALIFIED_TIME_PROPERTY        = "qualifiedTime"     ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String LEVEL_PROPERTY                 = "level"             ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		Date                	mQualifiedTime      ;
	protected		String              	mType               ;
	protected		String              	mLevel              ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeQualifier(){
		//lazy load for all the properties
	}
	
	public 	EmployeeQualifier(Employee employee, Date qualifiedTime, String type, String level, String remark
)
	{
		setEmployee(employee);
		setQualifiedTime(qualifiedTime);
		setType(type);
		setLevel(level);
		setRemark(remark);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(QUALIFIED_TIME_PROPERTY.equals(property)){
			changeQualifiedTimeProperty(newValueExpr);
		}
		if(TYPE_PROPERTY.equals(property)){
			changeTypeProperty(newValueExpr);
		}
		if(LEVEL_PROPERTY.equals(property)){
			changeLevelProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeQualifiedTimeProperty(String newValueExpr){
		Date oldValue = getQualifiedTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setQualifiedTime(newValue);
		//they are surely different each other
		this.onChangeProperty(QUALIFIED_TIME_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeLevelProperty(String newValueExpr){
		String oldValue = getLevel();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLevel(newValue);
		//they are surely different each other
		this.onChangeProperty(LEVEL_PROPERTY, oldValue, newValue);
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
	
	
	public void setQualifiedTime(Date qualifiedTime){
		this.mQualifiedTime = qualifiedTime;;
	}
	public Date getQualifiedTime(){
		return this.mQualifiedTime;
	}
	
	
	public void setType(String type){
		this.mType = trimString(type);;
	}
	public String getType(){
		return this.mType;
	}
	
	
	public void setLevel(String level){
		this.mLevel = trimString(level);;
	}
	public String getLevel(){
		return this.mLevel;
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
	
	
 	
	
	public EmployeeQualifier copyTo(EmployeeQualifier dest){

		dest.setId(getId());
		dest.setEmployee(getEmployee());
		dest.setQualifiedTime(getQualifiedTime());
		dest.setType(getType());
		dest.setLevel(getLevel());
		dest.setRemark(getRemark());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_qualifier{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tqualified_time='"+getQualifiedTime()+"';");
		stringBuilder.append("\ttype='"+getType()+"';");
		stringBuilder.append("\tlevel='"+getLevel()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

