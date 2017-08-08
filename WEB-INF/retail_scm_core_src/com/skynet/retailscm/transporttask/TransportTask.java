
package com.skynet.retailscm.transporttask;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttasktrack.TransportTaskTrack;
import com.skynet.retailscm.truckdriver.TruckDriver;

@JsonSerialize(using = TransportTaskSerializer.class)
public class TransportTask extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String START_PROPERTY                 = "start"             ;
	public static final String BEGIN_TIME_PROPERTY            = "beginTime"         ;
	public static final String END_PROPERTY                   = "end"               ;
	public static final String DRIVER_PROPERTY                = "driver"            ;
	public static final String TRUCK_PROPERTY                 = "truck"             ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_LIST                               = "goodsList"         ;
	public static final String TRANSPORT_TASK_TRACK_LIST                = "transportTaskTrackList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mStart              ;
	protected		Date                	mBeginTime          ;
	protected		RetailStore         	mEnd                ;
	protected		TruckDriver         	mDriver             ;
	protected		TransportTruck      	mTruck              ;
	protected		TransportFleet      	mBelongsTo          ;
	protected		double              	mLatitude           ;
	protected		double              	mLongitude          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Goods>    	mGoodsList          ;
	protected		SmartList<TransportTaskTrack>	mTransportTaskTrackList;
	
		
	public 	TransportTask(){
		//lazy load for all the properties
	}
	
	public 	TransportTask(String name, String start, Date beginTime, RetailStore end, TruckDriver driver, TransportTruck truck, TransportFleet belongsTo, double latitude, double longitude
)
	{
		setName(name);
		setStart(start);
		setBeginTime(beginTime);
		setEnd(end);
		setDriver(driver);
		setTruck(truck);
		setBelongsTo(belongsTo);
		setLatitude(latitude);
		setLongitude(longitude);

		this.mGoodsList = new SmartList<Goods>();
		this.mTransportTaskTrackList = new SmartList<TransportTaskTrack>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(START_PROPERTY.equals(property)){
			changeStartProperty(newValueExpr);
		}
		if(BEGIN_TIME_PROPERTY.equals(property)){
			changeBeginTimeProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
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
			
			
			
	protected void changeStartProperty(String newValueExpr){
		String oldValue = getStart();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setStart(newValue);
		//they are surely different each other
		this.onChangeProperty(START_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeBeginTimeProperty(String newValueExpr){
		Date oldValue = getBeginTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setBeginTime(newValue);
		//they are surely different each other
		this.onChangeProperty(BEGIN_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLatitudeProperty(String newValueExpr){
		double oldValue = getLatitude();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLatitude(newValue);
		//they are surely different each other
		this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLongitudeProperty(String newValueExpr){
		double oldValue = getLongitude();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLongitude(newValue);
		//they are surely different each other
		this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
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
	
	
	public void setStart(String start){
		this.mStart = trimString(start);;
	}
	public String getStart(){
		return this.mStart;
	}
	
	
	public void setBeginTime(Date beginTime){
		this.mBeginTime = beginTime;;
	}
	public Date getBeginTime(){
		return this.mBeginTime;
	}
	
	
	public void setEnd(RetailStore end){
		this.mEnd = end;;
	}
	public RetailStore getEnd(){
		return this.mEnd;
	}
	
	
	public void setDriver(TruckDriver driver){
		this.mDriver = driver;;
	}
	public TruckDriver getDriver(){
		return this.mDriver;
	}
	
	
	public void setTruck(TransportTruck truck){
		this.mTruck = truck;;
	}
	public TransportTruck getTruck(){
		return this.mTruck;
	}
	
	
	public void setBelongsTo(TransportFleet belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public TransportFleet getBelongsTo(){
		return this.mBelongsTo;
	}
	
	
	public void setLatitude(double latitude){
		this.mLatitude = latitude;;
	}
	public double getLatitude(){
		return this.mLatitude;
	}
	
	
	public void setLongitude(double longitude){
		this.mLongitude = longitude;;
	}
	public double getLongitude(){
		return this.mLongitude;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<Goods> getGoodsList(){
		if(this.mGoodsList == null){
			this.mGoodsList = new SmartList<Goods>();
		}
		return this.mGoodsList;	
	}
	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setTransportTask(this);
		}
		
		this.mGoodsList = goodsList;
		
	}
	
	public  void addGoods(Goods goods){
		goods.setTransportTask(this);
		getGoodsList().add(goods);
	}
	public  void addGoodses(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setTransportTask(this);
		}
		getGoodsList().addAll(goodsList);
	}
	
	public  void removeGoods(Goods goods){
	
		boolean result = getGoodsList().planToRemove(goods);
        if(!result){
        	String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveGoodsList", goods);
		//the constant "toGoods" will be replaced after refactoried.
	
	}
	
	public void copyGoodsFrom(Goods goods) {
		// TODO Auto-generated method stub
		
        Goods goodsInList = findTheGoods(goods);
        Goods newGoods = new Goods();
        goodsInList.copyTo(newGoods);
        newGoods.setVersion(0);//will trigger copy
        getGoodsList().add(newGoods);
	}
	
	public  Goods findTheGoods(Goods goods){
		
		int index =  getGoodsList().indexOf(goods);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getGoodsList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsList(){
		getGoodsList().clear();
	}
	
	
	
	
	public  SmartList<TransportTaskTrack> getTransportTaskTrackList(){
		if(this.mTransportTaskTrackList == null){
			this.mTransportTaskTrackList = new SmartList<TransportTaskTrack>();
		}
		return this.mTransportTaskTrackList;	
	}
	public  void setTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList){
		for( TransportTaskTrack transportTaskTrack:transportTaskTrackList){
			transportTaskTrack.setMovement(this);
		}
		
		this.mTransportTaskTrackList = transportTaskTrackList;
		
	}
	
	public  void addTransportTaskTrack(TransportTaskTrack transportTaskTrack){
		transportTaskTrack.setMovement(this);
		getTransportTaskTrackList().add(transportTaskTrack);
	}
	public  void addTransportTaskTracks(SmartList<TransportTaskTrack> transportTaskTrackList){
		for( TransportTaskTrack transportTaskTrack:transportTaskTrackList){
			transportTaskTrack.setMovement(this);
		}
		getTransportTaskTrackList().addAll(transportTaskTrackList);
	}
	
	public  void removeTransportTaskTrack(TransportTaskTrack transportTaskTrack){
	
		boolean result = getTransportTaskTrackList().planToRemove(transportTaskTrack);
        if(!result){
        	String message = "TransportTaskTrack("+transportTaskTrack.getId()+") with version='"+transportTaskTrack.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTransportTaskTrackList", transportTaskTrack);
		//the constant "toTransportTaskTrack" will be replaced after refactoried.
	
	}
	
	public void copyTransportTaskTrackFrom(TransportTaskTrack transportTaskTrack) {
		// TODO Auto-generated method stub
		
        TransportTaskTrack transportTaskTrackInList = findTheTransportTaskTrack(transportTaskTrack);
        TransportTaskTrack newTransportTaskTrack = new TransportTaskTrack();
        transportTaskTrackInList.copyTo(newTransportTaskTrack);
        newTransportTaskTrack.setVersion(0);//will trigger copy
        getTransportTaskTrackList().add(newTransportTaskTrack);
	}
	
	public  TransportTaskTrack findTheTransportTaskTrack(TransportTaskTrack transportTaskTrack){
		
		int index =  getTransportTaskTrackList().indexOf(transportTaskTrack);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "TransportTaskTrack("+transportTaskTrack.getId()+") with version='"+transportTaskTrack.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTransportTaskTrackList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskTrackList(){
		getTransportTaskTrackList().clear();
	}
	
	
	
	
 	
	
	public TransportTask copyTo(TransportTask dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setStart(getStart());
		dest.setBeginTime(getBeginTime());
		dest.setEnd(getEnd());
		dest.setDriver(getDriver());
		dest.setTruck(getTruck());
		dest.setBelongsTo(getBelongsTo());
		dest.setLatitude(getLatitude());
		dest.setLongitude(getLongitude());
		dest.setVersion(getVersion());
		dest.setGoodsList(getGoodsList());
		dest.setTransportTaskTrackList(getTransportTaskTrackList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("transport_task{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tstart='"+getStart()+"';");
		stringBuilder.append("\tbegin_time='"+getBeginTime()+"';");
		if(getEnd() != null ){
 			stringBuilder.append("\tend='retail_store("+getEnd().getId()+")';");
 		}
		if(getDriver() != null ){
 			stringBuilder.append("\tdriver='truck_driver("+getDriver().getId()+")';");
 		}
		if(getTruck() != null ){
 			stringBuilder.append("\ttruck='transport_truck("+getTruck().getId()+")';");
 		}
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongs_to='transport_fleet("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

