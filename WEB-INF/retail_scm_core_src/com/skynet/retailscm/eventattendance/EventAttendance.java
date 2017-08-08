
package com.skynet.retailscm.eventattendance;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;

@JsonSerialize(using = EventAttendanceSerializer.class)
public class EventAttendance extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String POTENTIAL_CUSTOMER_PROPERTY    = "potentialCustomer" ;
	public static final String CITY_EVENT_PROPERTY            = "cityEvent"         ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		PotentialCustomer   	mPotentialCustomer  ;
	protected		CityEvent           	mCityEvent          ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EventAttendance(){
		//lazy load for all the properties
	}
	
	public 	EventAttendance(String name, PotentialCustomer potentialCustomer, CityEvent cityEvent, String description
)
	{
		setName(name);
		setPotentialCustomer(potentialCustomer);
		setCityEvent(cityEvent);
		setDescription(description);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
	
	
	public void setPotentialCustomer(PotentialCustomer potentialCustomer){
		this.mPotentialCustomer = potentialCustomer;;
	}
	public PotentialCustomer getPotentialCustomer(){
		return this.mPotentialCustomer;
	}
	
	
	public void setCityEvent(CityEvent cityEvent){
		this.mCityEvent = cityEvent;;
	}
	public CityEvent getCityEvent(){
		return this.mCityEvent;
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
	
	
 	
	
	public EventAttendance copyTo(EventAttendance dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setPotentialCustomer(getPotentialCustomer());
		dest.setCityEvent(getCityEvent());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("event_attendance{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getPotentialCustomer() != null ){
 			stringBuilder.append("\tpotential_customer='potential_customer("+getPotentialCustomer().getId()+")';");
 		}
		if(getCityEvent() != null ){
 			stringBuilder.append("\tcity_event='city_event("+getCityEvent().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

