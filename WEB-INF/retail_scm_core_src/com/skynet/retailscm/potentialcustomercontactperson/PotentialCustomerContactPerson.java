
package com.skynet.retailscm.potentialcustomercontactperson;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;

@JsonSerialize(using = PotentialCustomerContactPersonSerializer.class)
public class PotentialCustomerContactPerson extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String POTENTIAL_CUSTOMER_PROPERTY    = "potentialCustomer" ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String POTENTIAL_CUSTOMER_CONTACT_LIST          = "potentialCustomerContactList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mMobile             ;
	protected		PotentialCustomer   	mPotentialCustomer  ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<PotentialCustomerContact>	mPotentialCustomerContactList;
	
		
	public 	PotentialCustomerContactPerson(){
		//lazy load for all the properties
	}
	
	public 	PotentialCustomerContactPerson(String name, String mobile, PotentialCustomer potentialCustomer, String description
)
	{
		setName(name);
		setMobile(mobile);
		setPotentialCustomer(potentialCustomer);
		setDescription(description);

		this.mPotentialCustomerContactList = new SmartList<PotentialCustomerContact>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PROPERTY.equals(property)){
			changeMobileProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
	
		
	public void setPotentialCustomer(PotentialCustomer potentialCustomer){
		this.mPotentialCustomer = potentialCustomer;;
	}
	public PotentialCustomer getPotentialCustomer(){
		return this.mPotentialCustomer;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<PotentialCustomerContact> getPotentialCustomerContactList(){
		if(this.mPotentialCustomerContactList == null){
			this.mPotentialCustomerContactList = new SmartList<PotentialCustomerContact>();
		}
		return this.mPotentialCustomerContactList;	
	}
	public  void setPotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		for( PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			potentialCustomerContact.setContactTo(this);
		}
		
		this.mPotentialCustomerContactList = potentialCustomerContactList;
		
	}
	
	public  void addPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
		potentialCustomerContact.setContactTo(this);
		getPotentialCustomerContactList().add(potentialCustomerContact);
	}
	public  void addPotentialCustomerContacts(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		for( PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			potentialCustomerContact.setContactTo(this);
		}
		getPotentialCustomerContactList().addAll(potentialCustomerContactList);
	}
	
	public  void removePotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
	
		boolean result = getPotentialCustomerContactList().planToRemove(potentialCustomerContact);
        if(!result){
        	String message = "PotentialCustomerContact("+potentialCustomerContact.getId()+") with version='"+potentialCustomerContact.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemovePotentialCustomerContactList", potentialCustomerContact);
		//the constant "toPotentialCustomerContact" will be replaced after refactoried.
	
	}
	
	public void copyPotentialCustomerContactFrom(PotentialCustomerContact potentialCustomerContact) {
		// TODO Auto-generated method stub
		
        PotentialCustomerContact potentialCustomerContactInList = findThePotentialCustomerContact(potentialCustomerContact);
        PotentialCustomerContact newPotentialCustomerContact = new PotentialCustomerContact();
        potentialCustomerContactInList.copyTo(newPotentialCustomerContact);
        newPotentialCustomerContact.setVersion(0);//will trigger copy
        getPotentialCustomerContactList().add(newPotentialCustomerContact);
	}
	
	public  PotentialCustomerContact findThePotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
		
		int index =  getPotentialCustomerContactList().indexOf(potentialCustomerContact);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "PotentialCustomerContact("+potentialCustomerContact.getId()+") with version='"+potentialCustomerContact.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getPotentialCustomerContactList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPotentialCustomerContactList(){
		getPotentialCustomerContactList().clear();
	}
	
	
	
	
 	
	
	public PotentialCustomerContactPerson copyTo(PotentialCustomerContactPerson dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setMobile(getMobile());
		dest.setPotentialCustomer(getPotentialCustomer());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());
		dest.setPotentialCustomerContactList(getPotentialCustomerContactList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("potential_customer_contact_person{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		if(getPotentialCustomer() != null ){
 			stringBuilder.append("\tpotential_customer='potential_customer("+getPotentialCustomer().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

