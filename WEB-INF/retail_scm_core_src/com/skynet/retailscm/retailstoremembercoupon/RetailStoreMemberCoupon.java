
package com.skynet.retailscm.retailstoremembercoupon;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;

@JsonSerialize(using = RetailStoreMemberCouponSerializer.class)
public class RetailStoreMemberCoupon extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String NUMBER_PROPERTY                = "number"            ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		RetailStoreMember   	mOwner              ;
	protected		String              	mNumber             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	RetailStoreMemberCoupon(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreMemberCoupon(String name, RetailStoreMember owner, String number
)
	{
		setName(name);
		setOwner(owner);
		setNumber(number);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(NUMBER_PROPERTY.equals(property)){
			changeNumberProperty(newValueExpr);
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
			
			
			
	protected void changeNumberProperty(String newValueExpr){
		String oldValue = getNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(NUMBER_PROPERTY, oldValue, newValue);
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
	
	
	public void setNumber(String number){
		this.mNumber = trimString(number);;
	}
	public String getNumber(){
		return this.mNumber;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public RetailStoreMemberCoupon copyTo(RetailStoreMemberCoupon dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setOwner(getOwner());
		dest.setNumber(getNumber());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_member_coupon{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_member("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tnumber='"+getNumber()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

