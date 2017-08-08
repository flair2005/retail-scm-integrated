
package com.skynet.retailscm.retailstorememberaddress;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;

@JsonSerialize(using = RetailStoreMemberAddressSerializer.class)
public class RetailStoreMemberAddress extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String MOBILE_PHONE_PROPERTY          = "mobilePhone"       ;
	public static final String ADDRESS_PROPERTY               = "address"           ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		RetailStoreMember   	mOwner              ;
	protected		String              	mMobilePhone        ;
	protected		String              	mAddress            ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	RetailStoreMemberAddress(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreMemberAddress(String name, RetailStoreMember owner, String mobilePhone, String address
)
	{
		setName(name);
		setOwner(owner);
		setMobilePhone(mobilePhone);
		setAddress(address);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PHONE_PROPERTY.equals(property)){
			changeMobilePhoneProperty(newValueExpr);
		}
		if(ADDRESS_PROPERTY.equals(property)){
			changeAddressProperty(newValueExpr);
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
			
			
			
	protected void changeMobilePhoneProperty(String newValueExpr){
		String oldValue = getMobilePhone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMobilePhone(newValue);
		//they are surely different each other
		this.onChangeProperty(MOBILE_PHONE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAddressProperty(String newValueExpr){
		String oldValue = getAddress();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAddress(newValue);
		//they are surely different each other
		this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
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
	
	
	public void setOwner(RetailStoreMember owner){
		this.mOwner = owner;;
	}
	public RetailStoreMember getOwner(){
		return this.mOwner;
	}
	
	
	public void setMobilePhone(String mobilePhone){
		this.mMobilePhone = trimString(mobilePhone);;
	}
	public String getMobilePhone(){
		return this.mMobilePhone;
	}
	
	
	
	public String getMaskedMobilePhone(){
		String mobilePhoneNumber = getMobilePhone();
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
	
		
	public void setAddress(String address){
		this.mAddress = trimString(address);;
	}
	public String getAddress(){
		return this.mAddress;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public RetailStoreMemberAddress copyTo(RetailStoreMemberAddress dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setOwner(getOwner());
		dest.setMobilePhone(getMobilePhone());
		dest.setAddress(getAddress());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_member_address{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_member("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tmobile_phone='"+getMobilePhone()+"';");
		stringBuilder.append("\taddress='"+getAddress()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

