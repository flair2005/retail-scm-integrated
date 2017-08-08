
package com.skynet.retailscm.consumerordershipment;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ConsumerOrderShipmentSerializer.class)
public class ConsumerOrderShipment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String SHIP_TIME_PROPERTY             = "shipTime"          ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Date                	mShipTime           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ConsumerOrderShipment(){
		//lazy load for all the properties
	}
	
	public 	ConsumerOrderShipment(String who, Date shipTime
)
	{
		setWho(who);
		setShipTime(shipTime);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(SHIP_TIME_PROPERTY.equals(property)){
			changeShipTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeWhoProperty(String newValueExpr){
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setWho(newValue);
		//they are surely different each other
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeShipTimeProperty(String newValueExpr){
		Date oldValue = getShipTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setShipTime(newValue);
		//they are surely different each other
		this.onChangeProperty(SHIP_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	
	
	public void setShipTime(Date shipTime){
		this.mShipTime = shipTime;;
	}
	public Date getShipTime(){
		return this.mShipTime;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public ConsumerOrderShipment copyTo(ConsumerOrderShipment dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setShipTime(getShipTime());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("consumer_order_shipment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tship_time='"+getShipTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

