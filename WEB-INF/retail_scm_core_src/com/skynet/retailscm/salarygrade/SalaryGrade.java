
package com.skynet.retailscm.salarygrade;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = SalaryGradeSerializer.class)
public class SalaryGrade extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DETAIL_DESCRIPTION_PROPERTY    = "detailDescription" ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LIST                            = "employeeList"      ;
	public static final String EMPLOYEE_SALARY_SHEET_LIST               = "employeeSalarySheetList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mName               ;
	protected		String              	mDetailDescription  ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Employee> 	mEmployeeList       ;
	protected		SmartList<EmployeeSalarySheet>	mEmployeeSalarySheetList;
	
		
	public 	SalaryGrade(){
		//lazy load for all the properties
	}
	
	public 	SalaryGrade(String code, RetailStoreCountryCenter company, String name, String detailDescription
)
	{
		setCode(code);
		setCompany(company);
		setName(name);
		setDetailDescription(detailDescription);

		this.mEmployeeList = new SmartList<Employee>();
		this.mEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
			
			
			
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setName(newValue);
		//they are surely different each other
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
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
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
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
			employee.setCurrentSalaryGrade(this);
		}
		
		this.mEmployeeList = employeeList;
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setCurrentSalaryGrade(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployees(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setCurrentSalaryGrade(this);
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
	
	
	
	
	public  SmartList<EmployeeSalarySheet> getEmployeeSalarySheetList(){
		if(this.mEmployeeSalarySheetList == null){
			this.mEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();
		}
		return this.mEmployeeSalarySheetList;	
	}
	public  void setEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setCurrentSalaryGrade(this);
		}
		
		this.mEmployeeSalarySheetList = employeeSalarySheetList;
		
	}
	
	public  void addEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		employeeSalarySheet.setCurrentSalaryGrade(this);
		getEmployeeSalarySheetList().add(employeeSalarySheet);
	}
	public  void addEmployeeSalarySheets(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setCurrentSalaryGrade(this);
		}
		getEmployeeSalarySheetList().addAll(employeeSalarySheetList);
	}
	
	public  void removeEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
	
		boolean result = getEmployeeSalarySheetList().planToRemove(employeeSalarySheet);
        if(!result){
        	String message = "EmployeeSalarySheet("+employeeSalarySheet.getId()+") with version='"+employeeSalarySheet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeSalarySheetList", employeeSalarySheet);
		//the constant "toEmployeeSalarySheet" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeSalarySheetFrom(EmployeeSalarySheet employeeSalarySheet) {
		// TODO Auto-generated method stub
		
        EmployeeSalarySheet employeeSalarySheetInList = findTheEmployeeSalarySheet(employeeSalarySheet);
        EmployeeSalarySheet newEmployeeSalarySheet = new EmployeeSalarySheet();
        employeeSalarySheetInList.copyTo(newEmployeeSalarySheet);
        newEmployeeSalarySheet.setVersion(0);//will trigger copy
        getEmployeeSalarySheetList().add(newEmployeeSalarySheet);
	}
	
	public  EmployeeSalarySheet findTheEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		
		int index =  getEmployeeSalarySheetList().indexOf(employeeSalarySheet);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeSalarySheet("+employeeSalarySheet.getId()+") with version='"+employeeSalarySheet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeSalarySheetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeSalarySheetList(){
		getEmployeeSalarySheetList().clear();
	}
	
	
	
	
 	
	
	public SalaryGrade copyTo(SalaryGrade dest){

		dest.setId(getId());
		dest.setCode(getCode());
		dest.setCompany(getCompany());
		dest.setName(getName());
		dest.setDetailDescription(getDetailDescription());
		dest.setVersion(getVersion());
		dest.setEmployeeList(getEmployeeList());
		dest.setEmployeeSalarySheetList(getEmployeeSalarySheetList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("salary_grade{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='retail_store_country_center("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdetail_description='"+getDetailDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

