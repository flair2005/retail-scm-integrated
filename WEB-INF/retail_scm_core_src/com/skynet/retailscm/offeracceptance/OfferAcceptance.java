
package com.skynet.retailscm.offeracceptance;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = OfferAcceptanceSerializer.class)
public class OfferAcceptance extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String ACCEPT_TIME_PROPERTY           = "acceptTime"        ;
	public static final String COMMENTS_PROPERTY              = "comments"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LIST                            = "employeeList"      ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Date                	mAcceptTime         ;
	protected		String              	mComments           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Employee> 	mEmployeeList       ;
	
		
	public 	OfferAcceptance(){
		//lazy load for all the properties
	}
	
	public 	OfferAcceptance(String who, Date acceptTime, String comments
)
	{
		setWho(who);
		setAcceptTime(acceptTime);
		setComments(comments);

		this.mEmployeeList = new SmartList<Employee>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(ACCEPT_TIME_PROPERTY.equals(property)){
			changeAcceptTimeProperty(newValueExpr);
		}
		if(COMMENTS_PROPERTY.equals(property)){
			changeCommentsProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeWhoProperty(String newValueExpr){
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setWho(newValue);
		//they are surely different each other
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAcceptTimeProperty(String newValueExpr){
		Date oldValue = getAcceptTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAcceptTime(newValue);
		//they are surely different each other
		this.onChangeProperty(ACCEPT_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeCommentsProperty(String newValueExpr){
		String oldValue = getComments();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setComments(newValue);
		//they are surely different each other
		this.onChangeProperty(COMMENTS_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	
	
	public void setAcceptTime(Date acceptTime){
		this.mAcceptTime = acceptTime;;
	}
	public Date getAcceptTime(){
		return this.mAcceptTime;
	}
	
	
	public void setComments(String comments){
		this.mComments = trimString(comments);;
	}
	public String getComments(){
		return this.mComments;
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
			employee.setOfferAcceptance(this);
		}
		
		this.mEmployeeList = employeeList;
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setOfferAcceptance(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployees(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setOfferAcceptance(this);
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
	
	
	
	
 	
	
	public OfferAcceptance copyTo(OfferAcceptance dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setAcceptTime(getAcceptTime());
		dest.setComments(getComments());
		dest.setVersion(getVersion());
		dest.setEmployeeList(getEmployeeList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("offer_acceptance{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\taccept_time='"+getAcceptTime()+"';");
		stringBuilder.append("\tcomments='"+getComments()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

