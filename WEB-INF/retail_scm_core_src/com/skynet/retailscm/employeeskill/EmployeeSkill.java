
package com.skynet.retailscm.employeeskill;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.skilltype.SkillType;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeSkillSerializer.class)
public class EmployeeSkill extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String SKILL_TYPE_PROPERTY            = "skillType"         ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		SkillType           	mSkillType          ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeSkill(){
		//lazy load for all the properties
	}
	
	public 	EmployeeSkill(Employee employee, SkillType skillType, String description
)
	{
		setEmployee(employee);
		setSkillType(skillType);
		setDescription(description);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDescription(newValue);
		//they are surely different each other
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
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
	
	
	public void setSkillType(SkillType skillType){
		this.mSkillType = skillType;;
	}
	public SkillType getSkillType(){
		return this.mSkillType;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public EmployeeSkill copyTo(EmployeeSkill dest){

		dest.setId(getId());
		dest.setEmployee(getEmployee());
		dest.setSkillType(getSkillType());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_skill{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='employee("+getEmployee().getId()+")';");
 		}
		if(getSkillType() != null ){
 			stringBuilder.append("\tskill_type='skill_type("+getSkillType().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

