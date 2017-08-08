
package com.skynet.retailscm.employeeworkexperience;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeWorkExperienceSerializer.class)
public class EmployeeWorkExperience extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String START_PROPERTY                 = "start"             ;
	public static final String END_PROPERTY                   = "end"               ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		Date                	mStart              ;
	protected		Date                	mEnd                ;
	protected		String              	mCompany            ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeWorkExperience(){
		//lazy load for all the properties
	}
	
	public 	EmployeeWorkExperience(Employee employee, Date start, Date end, String company, String description
)
	{
		setEmployee(employee);
		setStart(start);
		setEnd(end);
		setCompany(company);
		setDescription(description);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(START_PROPERTY.equals(property)){
			changeStartProperty(newValueExpr);
		}
		if(END_PROPERTY.equals(property)){
			changeEndProperty(newValueExpr);
		}
		if(COMPANY_PROPERTY.equals(property)){
			changeCompanyProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeStartProperty(String newValueExpr){
		Date oldValue = getStart();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setStart(newValue);
		//they are surely different each other
		this.onChangeProperty(START_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeEndProperty(String newValueExpr){
		Date oldValue = getEnd();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setEnd(newValue);
		//they are surely different each other
		this.onChangeProperty(END_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeCompanyProperty(String newValueExpr){
		String oldValue = getCompany();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCompany(newValue);
		//they are surely different each other
		this.onChangeProperty(COMPANY_PROPERTY, oldValue, newValue);
		return;
             
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
	
	
	public void setStart(Date start){
		this.mStart = start;;
	}
	public Date getStart(){
		return this.mStart;
	}
	
	
	public void setEnd(Date end){
		this.mEnd = end;;
	}
	public Date getEnd(){
		return this.mEnd;
	}
	
	
	public void setCompany(String company){
		this.mCompany = trimString(company);;
	}
	public String getCompany(){
		return this.mCompany;
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
	
	
 	
	
	public EmployeeWorkExperience copyTo(EmployeeWorkExperience dest){

		dest.setId(getId());
		dest.setEmployee(getEmployee());
		dest.setStart(getStart());
		dest.setEnd(getEnd());
		dest.setCompany(getCompany());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_work_experience{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tstart='"+getStart()+"';");
		stringBuilder.append("\tend='"+getEnd()+"';");
		stringBuilder.append("\tcompany='"+getCompany()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

