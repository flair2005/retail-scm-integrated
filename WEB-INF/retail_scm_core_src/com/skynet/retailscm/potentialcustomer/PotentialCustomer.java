
package com.skynet.retailscm.potentialcustomer;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.citypartner.CityPartner;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

@JsonSerialize(using = PotentialCustomerSerializer.class)
public class PotentialCustomer extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String CITY_SERVICE_CENTER_PROPERTY   = "cityServiceCenter" ;
	public static final String CITY_PARTNER_PROPERTY          = "cityPartner"       ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST   = "potentialCustomerContactPersonList";
	public static final String POTENTIAL_CUSTOMER_CONTACT_LIST          = "potentialCustomerContactList";
	public static final String EVENT_ATTENDANCE_LIST                    = "eventAttendanceList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mMobile             ;
	protected		RetailStoreCityServiceCenter	mCityServiceCenter  ;
	protected		CityPartner         	mCityPartner        ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<PotentialCustomerContactPerson>	mPotentialCustomerContactPersonList;
	protected		SmartList<PotentialCustomerContact>	mPotentialCustomerContactList;
	protected		SmartList<EventAttendance>	mEventAttendanceList;
	
		
	public 	PotentialCustomer(){
		//lazy load for all the properties
	}
	
	public 	PotentialCustomer(String name, String mobile, RetailStoreCityServiceCenter cityServiceCenter, CityPartner cityPartner, String description
)
	{
		setName(name);
		setMobile(mobile);
		setCityServiceCenter(cityServiceCenter);
		setCityPartner(cityPartner);
		setDescription(description);

		this.mPotentialCustomerContactPersonList = new SmartList<PotentialCustomerContactPerson>();
		this.mPotentialCustomerContactList = new SmartList<PotentialCustomerContact>();
		this.mEventAttendanceList = new SmartList<EventAttendance>();	
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
	
		
	public void setCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter){
		this.mCityServiceCenter = cityServiceCenter;;
	}
	public RetailStoreCityServiceCenter getCityServiceCenter(){
		return this.mCityServiceCenter;
	}
	
	
	public void setCityPartner(CityPartner cityPartner){
		this.mCityPartner = cityPartner;;
	}
	public CityPartner getCityPartner(){
		return this.mCityPartner;
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
	
	
	public  SmartList<PotentialCustomerContactPerson> getPotentialCustomerContactPersonList(){
		if(this.mPotentialCustomerContactPersonList == null){
			this.mPotentialCustomerContactPersonList = new SmartList<PotentialCustomerContactPerson>();
		}
		return this.mPotentialCustomerContactPersonList;	
	}
	public  void setPotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		for( PotentialCustomerContactPerson potentialCustomerContactPerson:potentialCustomerContactPersonList){
			potentialCustomerContactPerson.setPotentialCustomer(this);
		}
		
		this.mPotentialCustomerContactPersonList = potentialCustomerContactPersonList;
		
	}
	
	public  void addPotentialCustomerContactPerson(PotentialCustomerContactPerson potentialCustomerContactPerson){
		potentialCustomerContactPerson.setPotentialCustomer(this);
		getPotentialCustomerContactPersonList().add(potentialCustomerContactPerson);
	}
	public  void addPotentialCustomerContactPersons(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		for( PotentialCustomerContactPerson potentialCustomerContactPerson:potentialCustomerContactPersonList){
			potentialCustomerContactPerson.setPotentialCustomer(this);
		}
		getPotentialCustomerContactPersonList().addAll(potentialCustomerContactPersonList);
	}
	
	public  void removePotentialCustomerContactPerson(PotentialCustomerContactPerson potentialCustomerContactPerson){
	
		boolean result = getPotentialCustomerContactPersonList().planToRemove(potentialCustomerContactPerson);
        if(!result){
        	String message = "PotentialCustomerContactPerson("+potentialCustomerContactPerson.getId()+") with version='"+potentialCustomerContactPerson.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemovePotentialCustomerContactPersonList", potentialCustomerContactPerson);
		//the constant "toPotentialCustomerContactPerson" will be replaced after refactoried.
	
	}
	
	public void copyPotentialCustomerContactPersonFrom(PotentialCustomerContactPerson potentialCustomerContactPerson) {
		// TODO Auto-generated method stub
		
        PotentialCustomerContactPerson potentialCustomerContactPersonInList = findThePotentialCustomerContactPerson(potentialCustomerContactPerson);
        PotentialCustomerContactPerson newPotentialCustomerContactPerson = new PotentialCustomerContactPerson();
        potentialCustomerContactPersonInList.copyTo(newPotentialCustomerContactPerson);
        newPotentialCustomerContactPerson.setVersion(0);//will trigger copy
        getPotentialCustomerContactPersonList().add(newPotentialCustomerContactPerson);
	}
	
	public  PotentialCustomerContactPerson findThePotentialCustomerContactPerson(PotentialCustomerContactPerson potentialCustomerContactPerson){
		
		int index =  getPotentialCustomerContactPersonList().indexOf(potentialCustomerContactPerson);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "PotentialCustomerContactPerson("+potentialCustomerContactPerson.getId()+") with version='"+potentialCustomerContactPerson.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getPotentialCustomerContactPersonList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPotentialCustomerContactPersonList(){
		getPotentialCustomerContactPersonList().clear();
	}
	
	
	
	
	public  SmartList<PotentialCustomerContact> getPotentialCustomerContactList(){
		if(this.mPotentialCustomerContactList == null){
			this.mPotentialCustomerContactList = new SmartList<PotentialCustomerContact>();
		}
		return this.mPotentialCustomerContactList;	
	}
	public  void setPotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		for( PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			potentialCustomerContact.setPotentialCustomer(this);
		}
		
		this.mPotentialCustomerContactList = potentialCustomerContactList;
		
	}
	
	public  void addPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
		potentialCustomerContact.setPotentialCustomer(this);
		getPotentialCustomerContactList().add(potentialCustomerContact);
	}
	public  void addPotentialCustomerContacts(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		for( PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			potentialCustomerContact.setPotentialCustomer(this);
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
	
	
	
	
	public  SmartList<EventAttendance> getEventAttendanceList(){
		if(this.mEventAttendanceList == null){
			this.mEventAttendanceList = new SmartList<EventAttendance>();
		}
		return this.mEventAttendanceList;	
	}
	public  void setEventAttendanceList(SmartList<EventAttendance> eventAttendanceList){
		for( EventAttendance eventAttendance:eventAttendanceList){
			eventAttendance.setPotentialCustomer(this);
		}
		
		this.mEventAttendanceList = eventAttendanceList;
		
	}
	
	public  void addEventAttendance(EventAttendance eventAttendance){
		eventAttendance.setPotentialCustomer(this);
		getEventAttendanceList().add(eventAttendance);
	}
	public  void addEventAttendances(SmartList<EventAttendance> eventAttendanceList){
		for( EventAttendance eventAttendance:eventAttendanceList){
			eventAttendance.setPotentialCustomer(this);
		}
		getEventAttendanceList().addAll(eventAttendanceList);
	}
	
	public  void removeEventAttendance(EventAttendance eventAttendance){
	
		boolean result = getEventAttendanceList().planToRemove(eventAttendance);
        if(!result){
        	String message = "EventAttendance("+eventAttendance.getId()+") with version='"+eventAttendance.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEventAttendanceList", eventAttendance);
		//the constant "toEventAttendance" will be replaced after refactoried.
	
	}
	
	public void copyEventAttendanceFrom(EventAttendance eventAttendance) {
		// TODO Auto-generated method stub
		
        EventAttendance eventAttendanceInList = findTheEventAttendance(eventAttendance);
        EventAttendance newEventAttendance = new EventAttendance();
        eventAttendanceInList.copyTo(newEventAttendance);
        newEventAttendance.setVersion(0);//will trigger copy
        getEventAttendanceList().add(newEventAttendance);
	}
	
	public  EventAttendance findTheEventAttendance(EventAttendance eventAttendance){
		
		int index =  getEventAttendanceList().indexOf(eventAttendance);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EventAttendance("+eventAttendance.getId()+") with version='"+eventAttendance.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEventAttendanceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEventAttendanceList(){
		getEventAttendanceList().clear();
	}
	
	
	
	
 	
	
	public PotentialCustomer copyTo(PotentialCustomer dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setMobile(getMobile());
		dest.setCityServiceCenter(getCityServiceCenter());
		dest.setCityPartner(getCityPartner());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());
		dest.setPotentialCustomerContactPersonList(getPotentialCustomerContactPersonList());
		dest.setPotentialCustomerContactList(getPotentialCustomerContactList());
		dest.setEventAttendanceList(getEventAttendanceList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("potential_customer{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		if(getCityServiceCenter() != null ){
 			stringBuilder.append("\tcity_service_center='retail_store_city_service_center("+getCityServiceCenter().getId()+")';");
 		}
		if(getCityPartner() != null ){
 			stringBuilder.append("\tcity_partner='city_partner("+getCityPartner().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

