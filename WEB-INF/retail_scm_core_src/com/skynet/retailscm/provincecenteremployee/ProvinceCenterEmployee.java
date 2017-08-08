
package com.skynet.retailscm.provincecenteremployee;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

@JsonSerialize(using = ProvinceCenterEmployeeSerializer.class)
public class ProvinceCenterEmployee extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String DEPARTMENT_PROPERTY            = "department"        ;
	public static final String PROVINCE_CENTER_PROPERTY       = "provinceCenter"    ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mMobile             ;
	protected		String              	mEmail              ;
	protected		Date                	mFounded            ;
	protected		ProvinceCenterDepartment	mDepartment         ;
	protected		RetailStoreProvinceCenter	mProvinceCenter     ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ProvinceCenterEmployee(){
		//lazy load for all the properties
	}
	
	public 	ProvinceCenterEmployee(String name, String mobile, String email, Date founded, ProvinceCenterDepartment department, RetailStoreProvinceCenter provinceCenter
)
	{
		setName(name);
		setMobile(mobile);
		setEmail(email);
		setFounded(founded);
		setDepartment(department);
		setProvinceCenter(provinceCenter);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PROPERTY.equals(property)){
			changeMobileProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
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
			
			
			
	protected void changeMobileProperty(String newValueExpr){
		String oldValue = getMobile();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMobile(newValue);
		//they are surely different each other
		this.onChangeProperty(MOBILE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeEmailProperty(String newValueExpr){
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setEmail(newValue);
		//they are surely different each other
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
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
	
	
	public void setMobile(String mobile){
		this.mMobile = trimString(mobile);;
	}
	public String getMobile(){
		return this.mMobile;
	}
	
	
	
	public String getMaskedMobile(){
		String mobilePhoneNumber = getMobile();
		if(mobilePhoneNumber == null){
			return null;
		}
		if(mobilePhoneNumber.length()!=11){
			return mobilePhoneNumber;//残缺的手机号，无需屏蔽
		}
		return mobilePhoneNumber.substring(0,3)
			+"****"
			+mobilePhoneNumber.substring(7);
	}
	
		
	public void setEmail(String email){
		this.mEmail = trimString(email);;
	}
	public String getEmail(){
		return this.mEmail;
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	
	
	public void setDepartment(ProvinceCenterDepartment department){
		this.mDepartment = department;;
	}
	public ProvinceCenterDepartment getDepartment(){
		return this.mDepartment;
	}
	
	
	public void setProvinceCenter(RetailStoreProvinceCenter provinceCenter){
		this.mProvinceCenter = provinceCenter;;
	}
	public RetailStoreProvinceCenter getProvinceCenter(){
		return this.mProvinceCenter;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public ProvinceCenterEmployee copyTo(ProvinceCenterEmployee dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setMobile(getMobile());
		dest.setEmail(getEmail());
		dest.setFounded(getFounded());
		dest.setDepartment(getDepartment());
		dest.setProvinceCenter(getProvinceCenter());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("province_center_employee{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getDepartment() != null ){
 			stringBuilder.append("\tdepartment='province_center_department("+getDepartment().getId()+")';");
 		}
		if(getProvinceCenter() != null ){
 			stringBuilder.append("\tprovince_center='retail_store_province_center("+getProvinceCenter().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

