
package com.skynet.retailscm.consumerorderdelivery;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ConsumerOrderDeliverySerializer.class)
public class ConsumerOrderDelivery extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String DELIVERY_TIME_PROPERTY         = "deliveryTime"      ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Date                	mDeliveryTime       ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ConsumerOrderDelivery(){
		//lazy load for all the properties
	}
	
	public 	ConsumerOrderDelivery(String who, Date deliveryTime
)
	{
		setWho(who);
		setDeliveryTime(deliveryTime);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(DELIVERY_TIME_PROPERTY.equals(property)){
			changeDeliveryTimeProperty(newValueExpr);
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
			
			
			
	protected void changeDeliveryTimeProperty(String newValueExpr){
		Date oldValue = getDeliveryTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDeliveryTime(newValue);
		//they are surely different each other
		this.onChangeProperty(DELIVERY_TIME_PROPERTY, oldValue, newValue);
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
	
	
	public void setDeliveryTime(Date deliveryTime){
		this.mDeliveryTime = deliveryTime;;
	}
	public Date getDeliveryTime(){
		return this.mDeliveryTime;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public ConsumerOrderDelivery copyTo(ConsumerOrderDelivery dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setDeliveryTime(getDeliveryTime());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("consumer_order_delivery{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tdelivery_time='"+getDeliveryTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

