
package com.skynet.retailscm.leavetype;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeleave.EmployeeLeave;

@JsonSerialize(using = LeaveTypeSerializer.class)
public class LeaveType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String DETAIL_DESCRIPTION_PROPERTY    = "detailDescription" ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LEAVE_LIST                      = "employeeLeaveList" ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mDescription        ;
	protected		String              	mDetailDescription  ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeLeave>	mEmployeeLeaveList  ;
	
		
	public 	LeaveType(){
		//lazy load for all the properties
	}
	
	public 	LeaveType(String code, RetailStoreCountryCenter company, String description, String detailDescription
)
	{
		setCode(code);
		setCompany(company);
		setDescription(description);
		setDetailDescription(detailDescription);

		this.mEmployeeLeaveList = new SmartList<EmployeeLeave>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
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
	
	
	public  SmartList<EmployeeLeave> getEmployeeLeaveList(){
		if(this.mEmployeeLeaveList == null){
			this.mEmployeeLeaveList = new SmartList<EmployeeLeave>();
		}
		return this.mEmployeeLeaveList;	
	}
	public  void setEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setType(this);
		}
		
		this.mEmployeeLeaveList = employeeLeaveList;
		
	}
	
	public  void addEmployeeLeave(EmployeeLeave employeeLeave){
		employeeLeave.setType(this);
		getEmployeeLeaveList().add(employeeLeave);
	}
	public  void addEmployeeLeaves(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setType(this);
		}
		getEmployeeLeaveList().addAll(employeeLeaveList);
	}
	
	public  void removeEmployeeLeave(EmployeeLeave employeeLeave){
	
		boolean result = getEmployeeLeaveList().planToRemove(employeeLeave);
        if(!result){
        	String message = "EmployeeLeave("+employeeLeave.getId()+") with version='"+employeeLeave.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeLeaveList", employeeLeave);
		//the constant "toEmployeeLeave" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeLeaveFrom(EmployeeLeave employeeLeave) {
		// TODO Auto-generated method stub
		
        EmployeeLeave employeeLeaveInList = findTheEmployeeLeave(employeeLeave);
        EmployeeLeave newEmployeeLeave = new EmployeeLeave();
        employeeLeaveInList.copyTo(newEmployeeLeave);
        newEmployeeLeave.setVersion(0);//will trigger copy
        getEmployeeLeaveList().add(newEmployeeLeave);
	}
	
	public  EmployeeLeave findTheEmployeeLeave(EmployeeLeave employeeLeave){
		
		int index =  getEmployeeLeaveList().indexOf(employeeLeave);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeLeave("+employeeLeave.getId()+") with version='"+employeeLeave.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeLeaveList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeLeaveList(){
		getEmployeeLeaveList().clear();
	}
	
	
	
	
 	
	
	public LeaveType copyTo(LeaveType dest){

		dest.setId(getId());
		dest.setCode(getCode());
		dest.setCompany(getCompany());
		dest.setDescription(getDescription());
		dest.setDetailDescription(getDetailDescription());
		dest.setVersion(getVersion());
		dest.setEmployeeLeaveList(getEmployeeLeaveList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("leave_type{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='retail_store_country_center("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tdetail_description='"+getDetailDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

