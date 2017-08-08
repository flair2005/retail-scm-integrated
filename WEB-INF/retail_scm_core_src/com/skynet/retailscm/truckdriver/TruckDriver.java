
package com.skynet.retailscm.truckdriver;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttask.TransportTask;

@JsonSerialize(using = TruckDriverSerializer.class)
public class TruckDriver extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DRIVER_LICENSE_NUMBER_PROPERTY = "driverLicenseNumber";
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mDriverLicenseNumber;
	protected		String              	mContactNumber      ;
	protected		TransportFleet      	mBelongsTo          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportTask>	mTransportTaskList  ;
	
		
	public 	TruckDriver(){
		//lazy load for all the properties
	}
	
	public 	TruckDriver(String name, String driverLicenseNumber, String contactNumber, TransportFleet belongsTo
)
	{
		setName(name);
		setDriverLicenseNumber(driverLicenseNumber);
		setContactNumber(contactNumber);
		setBelongsTo(belongsTo);

		this.mTransportTaskList = new SmartList<TransportTask>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)){
			changeDriverLicenseNumberProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
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
			
			
			
	protected void changeDriverLicenseNumberProperty(String newValueExpr){
		String oldValue = getDriverLicenseNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDriverLicenseNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(DRIVER_LICENSE_NUMBER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeContactNumberProperty(String newValueExpr){
		String oldValue = getContactNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setContactNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(CONTACT_NUMBER_PROPERTY, oldValue, newValue);
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
	
	
	public void setDriverLicenseNumber(String driverLicenseNumber){
		this.mDriverLicenseNumber = trimString(driverLicenseNumber);;
	}
	public String getDriverLicenseNumber(){
		return this.mDriverLicenseNumber;
	}
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	
	
	
	public String getMaskedContactNumber(){
		String mobilePhoneNumber = getContactNumber();
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
	
		
	public void setBelongsTo(TransportFleet belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public TransportFleet getBelongsTo(){
		return this.mBelongsTo;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<TransportTask> getTransportTaskList(){
		if(this.mTransportTaskList == null){
			this.mTransportTaskList = new SmartList<TransportTask>();
		}
		return this.mTransportTaskList;	
	}
	public  void setTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setDriver(this);
		}
		
		this.mTransportTaskList = transportTaskList;
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setDriver(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTasks(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setDriver(this);
		}
		getTransportTaskList().addAll(transportTaskList);
	}
	
	public  void removeTransportTask(TransportTask transportTask){
	
		boolean result = getTransportTaskList().planToRemove(transportTask);
        if(!result){
        	String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTransportTaskList", transportTask);
		//the constant "toTransportTask" will be replaced after refactoried.
	
	}
	
	public void copyTransportTaskFrom(TransportTask transportTask) {
		// TODO Auto-generated method stub
		
        TransportTask transportTaskInList = findTheTransportTask(transportTask);
        TransportTask newTransportTask = new TransportTask();
        transportTaskInList.copyTo(newTransportTask);
        newTransportTask.setVersion(0);//will trigger copy
        getTransportTaskList().add(newTransportTask);
	}
	
	public  TransportTask findTheTransportTask(TransportTask transportTask){
		
		int index =  getTransportTaskList().indexOf(transportTask);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTransportTaskList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskList(){
		getTransportTaskList().clear();
	}
	
	
	
	
 	
	
	public TruckDriver copyTo(TruckDriver dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setDriverLicenseNumber(getDriverLicenseNumber());
		dest.setContactNumber(getContactNumber());
		dest.setBelongsTo(getBelongsTo());
		dest.setVersion(getVersion());
		dest.setTransportTaskList(getTransportTaskList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("truck_driver{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdriver_license_number='"+getDriverLicenseNumber()+"';");
		stringBuilder.append("\tcontact_number='"+getContactNumber()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongs_to='transport_fleet("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

