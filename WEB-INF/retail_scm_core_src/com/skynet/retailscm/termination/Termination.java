
package com.skynet.retailscm.termination;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.terminationreason.TerminationReason;
import com.skynet.retailscm.terminationtype.TerminationType;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = TerminationSerializer.class)
public class Termination extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String REASON_PROPERTY                = "reason"            ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String COMMENT_PROPERTY               = "comment"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LIST                            = "employeeList"      ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		TerminationReason   	mReason             ;
	protected		TerminationType     	mType               ;
	protected		String              	mComment            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Employee> 	mEmployeeList       ;
	
		
	public 	Termination(){
		//lazy load for all the properties
	}
	
	public 	Termination(TerminationReason reason, TerminationType type, String comment
)
	{
		setReason(reason);
		setType(type);
		setComment(comment);

		this.mEmployeeList = new SmartList<Employee>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(COMMENT_PROPERTY.equals(property)){
			changeCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCommentProperty(String newValueExpr){
		String oldValue = getComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setComment(newValue);
		//they are surely different each other
		this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setReason(TerminationReason reason){
		this.mReason = reason;;
	}
	public TerminationReason getReason(){
		return this.mReason;
	}
	
	
	public void setType(TerminationType type){
		this.mType = type;;
	}
	public TerminationType getType(){
		return this.mType;
	}
	
	
	public void setComment(String comment){
		this.mComment = trimString(comment);;
	}
	public String getComment(){
		return this.mComment;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<Employee> getEmployeeList(){
		if(this.mEmployeeList == null){
			this.mEmployeeList = new SmartList<Employee>();
		}
		return this.mEmployeeList;	
	}
	public  void setEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setTermination(this);
		}
		
		this.mEmployeeList = employeeList;
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setTermination(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployees(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setTermination(this);
		}
		getEmployeeList().addAll(employeeList);
	}
	
	public  void removeEmployee(Employee employee){
	
		boolean result = getEmployeeList().planToRemove(employee);
        if(!result){
        	String message = "Employee("+employee.getId()+") with version='"+employee.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeList", employee);
		//the constant "toEmployee" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeFrom(Employee employee) {
		// TODO Auto-generated method stub
		
        Employee employeeInList = findTheEmployee(employee);
        Employee newEmployee = new Employee();
        employeeInList.copyTo(newEmployee);
        newEmployee.setVersion(0);//will trigger copy
        getEmployeeList().add(newEmployee);
	}
	
	public  Employee findTheEmployee(Employee employee){
		
		int index =  getEmployeeList().indexOf(employee);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Employee("+employee.getId()+") with version='"+employee.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeList(){
		getEmployeeList().clear();
	}
	
	
	
	
 	
	
	public Termination copyTo(Termination dest){

		dest.setId(getId());
		dest.setReason(getReason());
		dest.setType(getType());
		dest.setComment(getComment());
		dest.setVersion(getVersion());
		dest.setEmployeeList(getEmployeeList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("termination{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getReason() != null ){
 			stringBuilder.append("\treason='termination_reason("+getReason().getId()+")';");
 		}
		if(getType() != null ){
 			stringBuilder.append("\ttype='termination_type("+getType().getId()+")';");
 		}
		stringBuilder.append("\tcomment='"+getComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

