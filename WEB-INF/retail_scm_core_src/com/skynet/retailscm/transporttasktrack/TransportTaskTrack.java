
package com.skynet.retailscm.transporttasktrack;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.transporttask.TransportTask;

@JsonSerialize(using = TransportTaskTrackSerializer.class)
public class TransportTaskTrack extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TRACK_TIME_PROPERTY            = "trackTime"         ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String MOVEMENT_PROPERTY              = "movement"          ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Date                	mTrackTime          ;
	protected		double              	mLatitude           ;
	protected		double              	mLongitude          ;
	protected		TransportTask       	mMovement           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	TransportTaskTrack(){
		//lazy load for all the properties
	}
	
	public 	TransportTaskTrack(Date trackTime, double latitude, double longitude, TransportTask movement
)
	{
		setTrackTime(trackTime);
		setLatitude(latitude);
		setLongitude(longitude);
		setMovement(movement);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(TRACK_TIME_PROPERTY.equals(property)){
			changeTrackTimeProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTrackTimeProperty(String newValueExpr){
		Date oldValue = getTrackTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTrackTime(newValue);
		//they are surely different each other
		this.onChangeProperty(TRACK_TIME_PROPERTY, oldValue, newValue);
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
	
	
	public void setTrackTime(Date trackTime){
		this.mTrackTime = trackTime;;
	}
	public Date getTrackTime(){
		return this.mTrackTime;
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
	
	
	public void setMovement(TransportTask movement){
		this.mMovement = movement;;
	}
	public TransportTask getMovement(){
		return this.mMovement;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public TransportTaskTrack copyTo(TransportTaskTrack dest){

		dest.setId(getId());
		dest.setTrackTime(getTrackTime());
		dest.setLatitude(getLatitude());
		dest.setLongitude(getLongitude());
		dest.setMovement(getMovement());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("transport_task_track{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttrack_time='"+getTrackTime()+"';");
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		if(getMovement() != null ){
 			stringBuilder.append("\tmovement='transport_task("+getMovement().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

