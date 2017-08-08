
package com.skynet.retailscm.employeeperformance;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = EmployeePerformanceSerializer.class)
public class EmployeePerformance extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String PERFORMANCE_COMMENT_PROPERTY   = "performanceComment";
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		String              	mPerformanceComment ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeePerformance(){
		//lazy load for all the properties
	}
	
	public 	EmployeePerformance(Employee employee, String performanceComment
)
	{
		setEmployee(employee);
		setPerformanceComment(performanceComment);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(PERFORMANCE_COMMENT_PROPERTY.equals(property)){
			changePerformanceCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changePerformanceCommentProperty(String newValueExpr){
		String oldValue = getPerformanceComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPerformanceComment(newValue);
		//they are surely different each other
		this.onChangeProperty(PERFORMANCE_COMMENT_PROPERTY, oldValue, newValue);
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
	
	
	public void setPerformanceComment(String performanceComment){
		this.mPerformanceComment = trimString(performanceComment);;
	}
	public String getPerformanceComment(){
		return this.mPerformanceComment;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public EmployeePerformance copyTo(EmployeePerformance dest){

		dest.setId(getId());
		dest.setEmployee(getEmployee());
		dest.setPerformanceComment(getPerformanceComment());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("employee_performance{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tperformance_comment='"+getPerformanceComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

