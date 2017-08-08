
package com.skynet.retailscm.responsibilitytype;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = ResponsibilityTypeSerializer.class)
public class ResponsibilityType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String BASE_DESCRIPTION_PROPERTY      = "baseDescription"   ;
	public static final String DETAIL_DESCRIPTION_PROPERTY    = "detailDescription" ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LIST                            = "employeeList"      ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mBaseDescription    ;
	protected		String              	mDetailDescription  ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Employee> 	mEmployeeList       ;
	
		
	public 	ResponsibilityType(){
		//lazy load for all the properties
	}
	
	public 	ResponsibilityType(String code, RetailStoreCountryCenter company, String baseDescription, String detailDescription
)
	{
		setCode(code);
		setCompany(company);
		setBaseDescription(baseDescription);
		setDetailDescription(detailDescription);

		this.mEmployeeList = new SmartList<Employee>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(BASE_DESCRIPTION_PROPERTY.equals(property)){
			changeBaseDescriptionProperty(newValueExpr);
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			changeDetailDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCodeProperty(String newValueExpr){
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCode(newValue);
		//they are surely different each other
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeBaseDescriptionProperty(String newValueExpr){
		String oldValue = getBaseDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setBaseDescription(newValue);
		//they are surely different each other
		this.onChangeProperty(BASE_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDetailDescriptionProperty(String newValueExpr){
		String oldValue = getDetailDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDetailDescription(newValue);
		//they are surely different each other
		this.onChangeProperty(DETAIL_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	
	
	public void setBaseDescription(String baseDescription){
		this.mBaseDescription = trimString(baseDescription);;
	}
	public String getBaseDescription(){
		return this.mBaseDescription;
	}
	
	
	public void setDetailDescription(String detailDescription){
		this.mDetailDescription = trimString(detailDescription);;
	}
	public String getDetailDescription(){
		return this.mDetailDescription;
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
			employee.setResponsibleFor(this);
		}
		
		this.mEmployeeList = employeeList;
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setResponsibleFor(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployees(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setResponsibleFor(this);
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
	
	
	
	
 	
	
	public ResponsibilityType copyTo(ResponsibilityType dest){

		dest.setId(getId());
		dest.setCode(getCode());
		dest.setCompany(getCompany());
		dest.setBaseDescription(getBaseDescription());
		dest.setDetailDescription(getDetailDescription());
		dest.setVersion(getVersion());
		dest.setEmployeeList(getEmployeeList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("responsibility_type{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='retail_store_country_center("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tbase_description='"+getBaseDescription()+"';");
		stringBuilder.append("\tdetail_description='"+getDetailDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

