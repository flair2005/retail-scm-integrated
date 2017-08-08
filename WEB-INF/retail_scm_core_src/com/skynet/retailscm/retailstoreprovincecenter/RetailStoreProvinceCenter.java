
package com.skynet.retailscm.retailstoreprovincecenter;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

@JsonSerialize(using = RetailStoreProvinceCenterSerializer.class)
public class RetailStoreProvinceCenter extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String COUNTRY_PROPERTY               = "country"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PROVINCE_CENTER_DEPARTMENT_LIST          = "provinceCenterDepartmentList";
	public static final String PROVINCE_CENTER_EMPLOYEE_LIST            = "provinceCenterEmployeeList";
	public static final String RETAIL_STORE_CITY_SERVICE_CENTER_LIST    = "retailStoreCityServiceCenterList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Date                	mFounded            ;
	protected		RetailStoreCountryCenter	mCountry            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ProvinceCenterDepartment>	mProvinceCenterDepartmentList;
	protected		SmartList<ProvinceCenterEmployee>	mProvinceCenterEmployeeList;
	protected		SmartList<RetailStoreCityServiceCenter>	mRetailStoreCityServiceCenterList;
	
		
	public 	RetailStoreProvinceCenter(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreProvinceCenter(String name, Date founded, RetailStoreCountryCenter country
)
	{
		setName(name);
		setFounded(founded);
		setCountry(country);

		this.mProvinceCenterDepartmentList = new SmartList<ProvinceCenterDepartment>();
		this.mProvinceCenterEmployeeList = new SmartList<ProvinceCenterEmployee>();
		this.mRetailStoreCityServiceCenterList = new SmartList<RetailStoreCityServiceCenter>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
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
	
	
	public void setCountry(RetailStoreCountryCenter country){
		this.mCountry = country;;
	}
	public RetailStoreCountryCenter getCountry(){
		return this.mCountry;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<ProvinceCenterDepartment> getProvinceCenterDepartmentList(){
		if(this.mProvinceCenterDepartmentList == null){
			this.mProvinceCenterDepartmentList = new SmartList<ProvinceCenterDepartment>();
		}
		return this.mProvinceCenterDepartmentList;	
	}
	public  void setProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList){
		for( ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList){
			provinceCenterDepartment.setProvinceCenter(this);
		}
		
		this.mProvinceCenterDepartmentList = provinceCenterDepartmentList;
		
	}
	
	public  void addProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartment){
		provinceCenterDepartment.setProvinceCenter(this);
		getProvinceCenterDepartmentList().add(provinceCenterDepartment);
	}
	public  void addProvinceCenterDepartments(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList){
		for( ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList){
			provinceCenterDepartment.setProvinceCenter(this);
		}
		getProvinceCenterDepartmentList().addAll(provinceCenterDepartmentList);
	}
	
	public  void removeProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartment){
	
		boolean result = getProvinceCenterDepartmentList().planToRemove(provinceCenterDepartment);
        if(!result){
        	String message = "ProvinceCenterDepartment("+provinceCenterDepartment.getId()+") with version='"+provinceCenterDepartment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveProvinceCenterDepartmentList", provinceCenterDepartment);
		//the constant "toProvinceCenterDepartment" will be replaced after refactoried.
	
	}
	
	public void copyProvinceCenterDepartmentFrom(ProvinceCenterDepartment provinceCenterDepartment) {
		// TODO Auto-generated method stub
		
        ProvinceCenterDepartment provinceCenterDepartmentInList = findTheProvinceCenterDepartment(provinceCenterDepartment);
        ProvinceCenterDepartment newProvinceCenterDepartment = new ProvinceCenterDepartment();
        provinceCenterDepartmentInList.copyTo(newProvinceCenterDepartment);
        newProvinceCenterDepartment.setVersion(0);//will trigger copy
        getProvinceCenterDepartmentList().add(newProvinceCenterDepartment);
	}
	
	public  ProvinceCenterDepartment findTheProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartment){
		
		int index =  getProvinceCenterDepartmentList().indexOf(provinceCenterDepartment);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ProvinceCenterDepartment("+provinceCenterDepartment.getId()+") with version='"+provinceCenterDepartment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getProvinceCenterDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProvinceCenterDepartmentList(){
		getProvinceCenterDepartmentList().clear();
	}
	
	
	
	
	public  SmartList<ProvinceCenterEmployee> getProvinceCenterEmployeeList(){
		if(this.mProvinceCenterEmployeeList == null){
			this.mProvinceCenterEmployeeList = new SmartList<ProvinceCenterEmployee>();
		}
		return this.mProvinceCenterEmployeeList;	
	}
	public  void setProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		for( ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			provinceCenterEmployee.setProvinceCenter(this);
		}
		
		this.mProvinceCenterEmployeeList = provinceCenterEmployeeList;
		
	}
	
	public  void addProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
		provinceCenterEmployee.setProvinceCenter(this);
		getProvinceCenterEmployeeList().add(provinceCenterEmployee);
	}
	public  void addProvinceCenterEmployees(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		for( ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			provinceCenterEmployee.setProvinceCenter(this);
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
	
	
	
	
	public  SmartList<RetailStoreCityServiceCenter> getRetailStoreCityServiceCenterList(){
		if(this.mRetailStoreCityServiceCenterList == null){
			this.mRetailStoreCityServiceCenterList = new SmartList<RetailStoreCityServiceCenter>();
		}
		return this.mRetailStoreCityServiceCenterList;	
	}
	public  void setRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		for( RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList){
			retailStoreCityServiceCenter.setBelongsTo(this);
		}
		
		this.mRetailStoreCityServiceCenterList = retailStoreCityServiceCenterList;
		
	}
	
	public  void addRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
		retailStoreCityServiceCenter.setBelongsTo(this);
		getRetailStoreCityServiceCenterList().add(retailStoreCityServiceCenter);
	}
	public  void addRetailStoreCityServiceCenters(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		for( RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList){
			retailStoreCityServiceCenter.setBelongsTo(this);
		}
		getRetailStoreCityServiceCenterList().addAll(retailStoreCityServiceCenterList);
	}
	
	public  void removeRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
	
		boolean result = getRetailStoreCityServiceCenterList().planToRemove(retailStoreCityServiceCenter);
        if(!result){
        	String message = "RetailStoreCityServiceCenter("+retailStoreCityServiceCenter.getId()+") with version='"+retailStoreCityServiceCenter.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreCityServiceCenterList", retailStoreCityServiceCenter);
		//the constant "toRetailStoreCityServiceCenter" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreCityServiceCenterFrom(RetailStoreCityServiceCenter retailStoreCityServiceCenter) {
		// TODO Auto-generated method stub
		
        RetailStoreCityServiceCenter retailStoreCityServiceCenterInList = findTheRetailStoreCityServiceCenter(retailStoreCityServiceCenter);
        RetailStoreCityServiceCenter newRetailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
        retailStoreCityServiceCenterInList.copyTo(newRetailStoreCityServiceCenter);
        newRetailStoreCityServiceCenter.setVersion(0);//will trigger copy
        getRetailStoreCityServiceCenterList().add(newRetailStoreCityServiceCenter);
	}
	
	public  RetailStoreCityServiceCenter findTheRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
		
		int index =  getRetailStoreCityServiceCenterList().indexOf(retailStoreCityServiceCenter);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreCityServiceCenter("+retailStoreCityServiceCenter.getId()+") with version='"+retailStoreCityServiceCenter.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreCityServiceCenterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreCityServiceCenterList(){
		getRetailStoreCityServiceCenterList().clear();
	}
	
	
	
	
 	
	
	public RetailStoreProvinceCenter copyTo(RetailStoreProvinceCenter dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setFounded(getFounded());
		dest.setCountry(getCountry());
		dest.setVersion(getVersion());
		dest.setProvinceCenterDepartmentList(getProvinceCenterDepartmentList());
		dest.setProvinceCenterEmployeeList(getProvinceCenterEmployeeList());
		dest.setRetailStoreCityServiceCenterList(getRetailStoreCityServiceCenterList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_province_center{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getCountry() != null ){
 			stringBuilder.append("\tcountry='retail_store_country_center("+getCountry().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

