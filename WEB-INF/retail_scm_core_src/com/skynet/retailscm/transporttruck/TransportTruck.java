
package com.skynet.retailscm.transporttruck;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttask.TransportTask;

@JsonSerialize(using = TransportTruckSerializer.class)
public class TransportTruck extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PLATE_NUMBER_PROPERTY          = "plateNumber"       ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String VEHICLE_LICENSE_NUMBER_PROPERTY = "vehicleLicenseNumber";
	public static final String ENGINE_NUMBER_PROPERTY         = "engineNumber"      ;
	public static final String MAKE_DATE_PROPERTY             = "makeDate"          ;
	public static final String MILEAGE_PROPERTY               = "mileage"           ;
	public static final String BODY_COLOR_PROPERTY            = "bodyColor"         ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mPlateNumber        ;
	protected		String              	mContactNumber      ;
	protected		String              	mVehicleLicenseNumber;
	protected		String              	mEngineNumber       ;
	protected		Date                	mMakeDate           ;
	protected		String              	mMileage            ;
	protected		String              	mBodyColor          ;
	protected		TransportFleet      	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportTask>	mTransportTaskList  ;
	
		
	public 	TransportTruck(){
		//lazy load for all the properties
	}
	
	public 	TransportTruck(String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor, TransportFleet owner
)
	{
		setName(name);
		setPlateNumber(plateNumber);
		setContactNumber(contactNumber);
		setVehicleLicenseNumber(vehicleLicenseNumber);
		setEngineNumber(engineNumber);
		setMakeDate(makeDate);
		setMileage(mileage);
		setBodyColor(bodyColor);
		setOwner(owner);

		this.mTransportTaskList = new SmartList<TransportTask>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(PLATE_NUMBER_PROPERTY.equals(property)){
			changePlateNumberProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
		}
		if(VEHICLE_LICENSE_NUMBER_PROPERTY.equals(property)){
			changeVehicleLicenseNumberProperty(newValueExpr);
		}
		if(ENGINE_NUMBER_PROPERTY.equals(property)){
			changeEngineNumberProperty(newValueExpr);
		}
		if(MAKE_DATE_PROPERTY.equals(property)){
			changeMakeDateProperty(newValueExpr);
		}
		if(MILEAGE_PROPERTY.equals(property)){
			changeMileageProperty(newValueExpr);
		}
		if(BODY_COLOR_PROPERTY.equals(property)){
			changeBodyColorProperty(newValueExpr);
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
			
			
			
	protected void changePlateNumberProperty(String newValueExpr){
		String oldValue = getPlateNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPlateNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(PLATE_NUMBER_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeVehicleLicenseNumberProperty(String newValueExpr){
		String oldValue = getVehicleLicenseNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setVehicleLicenseNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(VEHICLE_LICENSE_NUMBER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeEngineNumberProperty(String newValueExpr){
		String oldValue = getEngineNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setEngineNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(ENGINE_NUMBER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMakeDateProperty(String newValueExpr){
		Date oldValue = getMakeDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMakeDate(newValue);
		//they are surely different each other
		this.onChangeProperty(MAKE_DATE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMileageProperty(String newValueExpr){
		String oldValue = getMileage();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMileage(newValue);
		//they are surely different each other
		this.onChangeProperty(MILEAGE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeBodyColorProperty(String newValueExpr){
		String oldValue = getBodyColor();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setBodyColor(newValue);
		//they are surely different each other
		this.onChangeProperty(BODY_COLOR_PROPERTY, oldValue, newValue);
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
	
	
	public void setPlateNumber(String plateNumber){
		this.mPlateNumber = trimString(plateNumber);;
	}
	public String getPlateNumber(){
		return this.mPlateNumber;
	}
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	
	
	public void setVehicleLicenseNumber(String vehicleLicenseNumber){
		this.mVehicleLicenseNumber = trimString(vehicleLicenseNumber);;
	}
	public String getVehicleLicenseNumber(){
		return this.mVehicleLicenseNumber;
	}
	
	
	public void setEngineNumber(String engineNumber){
		this.mEngineNumber = trimString(engineNumber);;
	}
	public String getEngineNumber(){
		return this.mEngineNumber;
	}
	
	
	public void setMakeDate(Date makeDate){
		this.mMakeDate = makeDate;;
	}
	public Date getMakeDate(){
		return this.mMakeDate;
	}
	
	
	public void setMileage(String mileage){
		this.mMileage = trimString(mileage);;
	}
	public String getMileage(){
		return this.mMileage;
	}
	
	
	public void setBodyColor(String bodyColor){
		this.mBodyColor = trimString(bodyColor);;
	}
	public String getBodyColor(){
		return this.mBodyColor;
	}
	
	
	public void setOwner(TransportFleet owner){
		this.mOwner = owner;;
	}
	public TransportFleet getOwner(){
		return this.mOwner;
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
			transportTask.setTruck(this);
		}
		
		this.mTransportTaskList = transportTaskList;
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setTruck(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTasks(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setTruck(this);
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
	
	
	
	
 	
	
	public TransportTruck copyTo(TransportTruck dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setPlateNumber(getPlateNumber());
		dest.setContactNumber(getContactNumber());
		dest.setVehicleLicenseNumber(getVehicleLicenseNumber());
		dest.setEngineNumber(getEngineNumber());
		dest.setMakeDate(getMakeDate());
		dest.setMileage(getMileage());
		dest.setBodyColor(getBodyColor());
		dest.setOwner(getOwner());
		dest.setVersion(getVersion());
		dest.setTransportTaskList(getTransportTaskList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("transport_truck{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tplate_number='"+getPlateNumber()+"';");
		stringBuilder.append("\tcontact_number='"+getContactNumber()+"';");
		stringBuilder.append("\tvehicle_license_number='"+getVehicleLicenseNumber()+"';");
		stringBuilder.append("\tengine_number='"+getEngineNumber()+"';");
		stringBuilder.append("\tmake_date='"+getMakeDate()+"';");
		stringBuilder.append("\tmileage='"+getMileage()+"';");
		stringBuilder.append("\tbody_color='"+getBodyColor()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='transport_fleet("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

