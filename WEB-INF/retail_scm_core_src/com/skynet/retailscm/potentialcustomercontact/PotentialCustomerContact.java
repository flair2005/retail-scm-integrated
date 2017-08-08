
package com.skynet.retailscm.potentialcustomercontact;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;

@JsonSerialize(using = PotentialCustomerContactSerializer.class)
public class PotentialCustomerContact extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CONTACT_DATE_PROPERTY          = "contactDate"       ;
	public static final String CONTACT_METHOD_PROPERTY        = "contactMethod"     ;
	public static final String POTENTIAL_CUSTOMER_PROPERTY    = "potentialCustomer" ;
	public static final String CITY_PARTNER_PROPERTY          = "cityPartner"       ;
	public static final String CONTACT_TO_PROPERTY            = "contactTo"         ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Date                	mContactDate        ;
	protected		String              	mContactMethod      ;
	protected		PotentialCustomer   	mPotentialCustomer  ;
	protected		CityPartner         	mCityPartner        ;
	protected		PotentialCustomerContactPerson	mContactTo          ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	PotentialCustomerContact(){
		//lazy load for all the properties
	}
	
	public 	PotentialCustomerContact(String name, Date contactDate, String contactMethod, PotentialCustomer potentialCustomer, CityPartner cityPartner, PotentialCustomerContactPerson contactTo, String description
)
	{
		setName(name);
		setContactDate(contactDate);
		setContactMethod(contactMethod);
		setPotentialCustomer(potentialCustomer);
		setCityPartner(cityPartner);
		setContactTo(contactTo);
		setDescription(description);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CONTACT_DATE_PROPERTY.equals(property)){
			changeContactDateProperty(newValueExpr);
		}
		if(CONTACT_METHOD_PROPERTY.equals(property)){
			changeContactMethodProperty(newValueExpr);
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
			
			
			
	protected void changeContactDateProperty(String newValueExpr){
		Date oldValue = getContactDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setContactDate(newValue);
		//they are surely different each other
		this.onChangeProperty(CONTACT_DATE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeContactMethodProperty(String newValueExpr){
		String oldValue = getContactMethod();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setContactMethod(newValue);
		//they are surely different each other
		this.onChangeProperty(CONTACT_METHOD_PROPERTY, oldValue, newValue);
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
	
	
	public void setContactDate(Date contactDate){
		this.mContactDate = contactDate;;
	}
	public Date getContactDate(){
		return this.mContactDate;
	}
	
	
	public void setContactMethod(String contactMethod){
		this.mContactMethod = trimString(contactMethod);;
	}
	public String getContactMethod(){
		return this.mContactMethod;
	}
	
	
	public void setPotentialCustomer(PotentialCustomer potentialCustomer){
		this.mPotentialCustomer = potentialCustomer;;
	}
	public PotentialCustomer getPotentialCustomer(){
		return this.mPotentialCustomer;
	}
	
	
	public void setCityPartner(CityPartner cityPartner){
		this.mCityPartner = cityPartner;;
	}
	public CityPartner getCityPartner(){
		return this.mCityPartner;
	}
	
	
	public void setContactTo(PotentialCustomerContactPerson contactTo){
		this.mContactTo = contactTo;;
	}
	public PotentialCustomerContactPerson getContactTo(){
		return this.mContactTo;
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
	
	
 	
	
	public PotentialCustomerContact copyTo(PotentialCustomerContact dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setContactDate(getContactDate());
		dest.setContactMethod(getContactMethod());
		dest.setPotentialCustomer(getPotentialCustomer());
		dest.setCityPartner(getCityPartner());
		dest.setContactTo(getContactTo());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("potential_customer_contact{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcontact_date='"+getContactDate()+"';");
		stringBuilder.append("\tcontact_method='"+getContactMethod()+"';");
		if(getPotentialCustomer() != null ){
 			stringBuilder.append("\tpotential_customer='potential_customer("+getPotentialCustomer().getId()+")';");
 		}
		if(getCityPartner() != null ){
 			stringBuilder.append("\tcity_partner='city_partner("+getCityPartner().getId()+")';");
 		}
		if(getContactTo() != null ){
 			stringBuilder.append("\tcontact_to='potential_customer_contact_person("+getContactTo().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

