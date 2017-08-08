
package com.skynet.retailscm.transportfleet;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.truckdriver.TruckDriver;

@JsonSerialize(using = TransportFleetSerializer.class)
public class TransportFleet extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_TRUCK_LIST                     = "transportTruckList";
	public static final String TRUCK_DRIVER_LIST                        = "truckDriverList"   ;
	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mContactNumber      ;
	protected		RetailStoreCountryCenter	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportTruck>	mTransportTruckList ;
	protected		SmartList<TruckDriver>	mTruckDriverList    ;
	protected		SmartList<TransportTask>	mTransportTaskList  ;
	
		
	public 	TransportFleet(){
		//lazy load for all the properties
	}
	
	public 	TransportFleet(String name, String contactNumber, RetailStoreCountryCenter owner
)
	{
		setName(name);
		setContactNumber(contactNumber);
		setOwner(owner);

		this.mTransportTruckList = new SmartList<TransportTruck>();
		this.mTruckDriverList = new SmartList<TruckDriver>();
		this.mTransportTaskList = new SmartList<TransportTask>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	
	
	public void setOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
	}
	public RetailStoreCountryCenter getOwner(){
		return this.mOwner;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<TransportTruck> getTransportTruckList(){
		if(this.mTransportTruckList == null){
			this.mTransportTruckList = new SmartList<TransportTruck>();
		}
		return this.mTransportTruckList;	
	}
	public  void setTransportTruckList(SmartList<TransportTruck> transportTruckList){
		for( TransportTruck transportTruck:transportTruckList){
			transportTruck.setOwner(this);
		}
		
		this.mTransportTruckList = transportTruckList;
		
	}
	
	public  void addTransportTruck(TransportTruck transportTruck){
		transportTruck.setOwner(this);
		getTransportTruckList().add(transportTruck);
	}
	public  void addTransportTrucks(SmartList<TransportTruck> transportTruckList){
		for( TransportTruck transportTruck:transportTruckList){
			transportTruck.setOwner(this);
		}
		getTransportTruckList().addAll(transportTruckList);
	}
	
	public  void removeTransportTruck(TransportTruck transportTruck){
	
		boolean result = getTransportTruckList().planToRemove(transportTruck);
        if(!result){
        	String message = "TransportTruck("+transportTruck.getId()+") with version='"+transportTruck.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTransportTruckList", transportTruck);
		//the constant "toTransportTruck" will be replaced after refactoried.
	
	}
	
	public void copyTransportTruckFrom(TransportTruck transportTruck) {
		// TODO Auto-generated method stub
		
        TransportTruck transportTruckInList = findTheTransportTruck(transportTruck);
        TransportTruck newTransportTruck = new TransportTruck();
        transportTruckInList.copyTo(newTransportTruck);
        newTransportTruck.setVersion(0);//will trigger copy
        getTransportTruckList().add(newTransportTruck);
	}
	
	public  TransportTruck findTheTransportTruck(TransportTruck transportTruck){
		
		int index =  getTransportTruckList().indexOf(transportTruck);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "TransportTruck("+transportTruck.getId()+") with version='"+transportTruck.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTransportTruckList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTruckList(){
		getTransportTruckList().clear();
	}
	
	
	
	
	public  SmartList<TruckDriver> getTruckDriverList(){
		if(this.mTruckDriverList == null){
			this.mTruckDriverList = new SmartList<TruckDriver>();
		}
		return this.mTruckDriverList;	
	}
	public  void setTruckDriverList(SmartList<TruckDriver> truckDriverList){
		for( TruckDriver truckDriver:truckDriverList){
			truckDriver.setBelongsTo(this);
		}
		
		this.mTruckDriverList = truckDriverList;
		
	}
	
	public  void addTruckDriver(TruckDriver truckDriver){
		truckDriver.setBelongsTo(this);
		getTruckDriverList().add(truckDriver);
	}
	public  void addTruckDrivers(SmartList<TruckDriver> truckDriverList){
		for( TruckDriver truckDriver:truckDriverList){
			truckDriver.setBelongsTo(this);
		}
		getTruckDriverList().addAll(truckDriverList);
	}
	
	public  void removeTruckDriver(TruckDriver truckDriver){
	
		boolean result = getTruckDriverList().planToRemove(truckDriver);
        if(!result){
        	String message = "TruckDriver("+truckDriver.getId()+") with version='"+truckDriver.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTruckDriverList", truckDriver);
		//the constant "toTruckDriver" will be replaced after refactoried.
	
	}
	
	public void copyTruckDriverFrom(TruckDriver truckDriver) {
		// TODO Auto-generated method stub
		
        TruckDriver truckDriverInList = findTheTruckDriver(truckDriver);
        TruckDriver newTruckDriver = new TruckDriver();
        truckDriverInList.copyTo(newTruckDriver);
        newTruckDriver.setVersion(0);//will trigger copy
        getTruckDriverList().add(newTruckDriver);
	}
	
	public  TruckDriver findTheTruckDriver(TruckDriver truckDriver){
		
		int index =  getTruckDriverList().indexOf(truckDriver);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "TruckDriver("+truckDriver.getId()+") with version='"+truckDriver.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTruckDriverList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTruckDriverList(){
		getTruckDriverList().clear();
	}
	
	
	
	
	public  SmartList<TransportTask> getTransportTaskList(){
		if(this.mTransportTaskList == null){
			this.mTransportTaskList = new SmartList<TransportTask>();
		}
		return this.mTransportTaskList;	
	}
	public  void setTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setBelongsTo(this);
		}
		
		this.mTransportTaskList = transportTaskList;
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setBelongsTo(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTasks(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setBelongsTo(this);
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
	
	
	
	
 	
	
	public TransportFleet copyTo(TransportFleet dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setContactNumber(getContactNumber());
		dest.setOwner(getOwner());
		dest.setVersion(getVersion());
		dest.setTransportTruckList(getTransportTruckList());
		dest.setTruckDriverList(getTruckDriverList());
		dest.setTransportTaskList(getTransportTaskList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("transport_fleet{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcontact_number='"+getContactNumber()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_country_center("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

