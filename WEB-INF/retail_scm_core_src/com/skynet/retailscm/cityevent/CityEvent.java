
package com.skynet.retailscm.cityevent;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

@JsonSerialize(using = CityEventSerializer.class)
public class CityEvent extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String CITY_SERVICE_CENTER_PROPERTY   = "cityServiceCenter" ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EVENT_ATTENDANCE_LIST                    = "eventAttendanceList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mMobile             ;
	protected		RetailStoreCityServiceCenter	mCityServiceCenter  ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EventAttendance>	mEventAttendanceList;
	
		
	public 	CityEvent(){
		//lazy load for all the properties
	}
	
	public 	CityEvent(String name, String mobile, RetailStoreCityServiceCenter cityServiceCenter, String description
)
	{
		setName(name);
		setMobile(mobile);
		setCityServiceCenter(cityServiceCenter);
		setDescription(description);

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
	
	
	public  SmartList<EventAttendance> getEventAttendanceList(){
		if(this.mEventAttendanceList == null){
			this.mEventAttendanceList = new SmartList<EventAttendance>();
		}
		return this.mEventAttendanceList;	
	}
	public  void setEventAttendanceList(SmartList<EventAttendance> eventAttendanceList){
		for( EventAttendance eventAttendance:eventAttendanceList){
			eventAttendance.setCityEvent(this);
		}
		
		this.mEventAttendanceList = eventAttendanceList;
		
	}
	
	public  void addEventAttendance(EventAttendance eventAttendance){
		eventAttendance.setCityEvent(this);
		getEventAttendanceList().add(eventAttendance);
	}
	public  void addEventAttendances(SmartList<EventAttendance> eventAttendanceList){
		for( EventAttendance eventAttendance:eventAttendanceList){
			eventAttendance.setCityEvent(this);
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
	
	
	
	
 	
	
	public CityEvent copyTo(CityEvent dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setMobile(getMobile());
		dest.setCityServiceCenter(getCityServiceCenter());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());
		dest.setEventAttendanceList(getEventAttendanceList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("city_event{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		if(getCityServiceCenter() != null ){
 			stringBuilder.append("\tcity_service_center='retail_store_city_service_center("+getCityServiceCenter().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

