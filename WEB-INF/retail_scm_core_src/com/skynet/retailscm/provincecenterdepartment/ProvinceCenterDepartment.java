
package com.skynet.retailscm.provincecenterdepartment;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;

@JsonSerialize(using = ProvinceCenterDepartmentSerializer.class)
public class ProvinceCenterDepartment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String PROVINCE_CENTER_PROPERTY       = "provinceCenter"    ;
	public static final String MANAGER_PROPERTY               = "manager"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PROVINCE_CENTER_EMPLOYEE_LIST            = "provinceCenterEmployeeList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Date                	mFounded            ;
	protected		RetailStoreProvinceCenter	mProvinceCenter     ;
	protected		String              	mManager            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ProvinceCenterEmployee>	mProvinceCenterEmployeeList;
	
		
	public 	ProvinceCenterDepartment(){
		//lazy load for all the properties
	}
	
	public 	ProvinceCenterDepartment(String name, Date founded, RetailStoreProvinceCenter provinceCenter, String manager
)
	{
		setName(name);
		setFounded(founded);
		setProvinceCenter(provinceCenter);
		setManager(manager);

		this.mProvinceCenterEmployeeList = new SmartList<ProvinceCenterEmployee>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
		}
		if(MANAGER_PROPERTY.equals(property)){
			changeManagerProperty(newValueExpr);
		}

      
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
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFounded(newValue);
		//they are surely different each other
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeManagerProperty(String newValueExpr){
		String oldValue = getManager();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setManager(newValue);
		//they are surely different each other
		this.onChangeProperty(MANAGER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	
	
	public void setProvinceCenter(RetailStoreProvinceCenter provinceCenter){
		this.mProvinceCenter = provinceCenter;;
	}
	public RetailStoreProvinceCenter getProvinceCenter(){
		return this.mProvinceCenter;
	}
	
	
	public void setManager(String manager){
		this.mManager = trimString(manager);;
	}
	public String getManager(){
		return this.mManager;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<ProvinceCenterEmployee> getProvinceCenterEmployeeList(){
		if(this.mProvinceCenterEmployeeList == null){
			this.mProvinceCenterEmployeeList = new SmartList<ProvinceCenterEmployee>();
		}
		return this.mProvinceCenterEmployeeList;	
	}
	public  void setProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		for( ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			provinceCenterEmployee.setDepartment(this);
		}
		
		this.mProvinceCenterEmployeeList = provinceCenterEmployeeList;
		
	}
	
	public  void addProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
		provinceCenterEmployee.setDepartment(this);
		getProvinceCenterEmployeeList().add(provinceCenterEmployee);
	}
	public  void addProvinceCenterEmployees(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		for( ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			provinceCenterEmployee.setDepartment(this);
		}
		getProvinceCenterEmployeeList().addAll(provinceCenterEmployeeList);
	}
	
	public  void removeProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
	
		boolean result = getProvinceCenterEmployeeList().planToRemove(provinceCenterEmployee);
        if(!result){
        	String message = "ProvinceCenterEmployee("+provinceCenterEmployee.getId()+") with version='"+provinceCenterEmployee.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveProvinceCenterEmployeeList", provinceCenterEmployee);
		//the constant "toProvinceCenterEmployee" will be replaced after refactoried.
	
	}
	
	public void copyProvinceCenterEmployeeFrom(ProvinceCenterEmployee provinceCenterEmployee) {
		// TODO Auto-generated method stub
		
        ProvinceCenterEmployee provinceCenterEmployeeInList = findTheProvinceCenterEmployee(provinceCenterEmployee);
        ProvinceCenterEmployee newProvinceCenterEmployee = new ProvinceCenterEmployee();
        provinceCenterEmployeeInList.copyTo(newProvinceCenterEmployee);
        newProvinceCenterEmployee.setVersion(0);//will trigger copy
        getProvinceCenterEmployeeList().add(newProvinceCenterEmployee);
	}
	
	public  ProvinceCenterEmployee findTheProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
		
		int index =  getProvinceCenterEmployeeList().indexOf(provinceCenterEmployee);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ProvinceCenterEmployee("+provinceCenterEmployee.getId()+") with version='"+provinceCenterEmployee.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getProvinceCenterEmployeeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProvinceCenterEmployeeList(){
		getProvinceCenterEmployeeList().clear();
	}
	
	
	
	
 	
	
	public ProvinceCenterDepartment copyTo(ProvinceCenterDepartment dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setFounded(getFounded());
		dest.setProvinceCenter(getProvinceCenter());
		dest.setManager(getManager());
		dest.setVersion(getVersion());
		dest.setProvinceCenterEmployeeList(getProvinceCenterEmployeeList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("province_center_department{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getProvinceCenter() != null ){
 			stringBuilder.append("\tprovince_center='retail_store_province_center("+getProvinceCenter().getId()+")';");
 		}
		stringBuilder.append("\tmanager='"+getManager()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

