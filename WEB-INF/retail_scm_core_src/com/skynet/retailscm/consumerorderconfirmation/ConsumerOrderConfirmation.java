
package com.skynet.retailscm.consumerorderconfirmation;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ConsumerOrderConfirmationSerializer.class)
public class ConsumerOrderConfirmation extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String CONFIRM_TIME_PROPERTY          = "confirmTime"       ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Date                	mConfirmTime        ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ConsumerOrderConfirmation(){
		//lazy load for all the properties
	}
	
	public 	ConsumerOrderConfirmation(String who, Date confirmTime
)
	{
		setWho(who);
		setConfirmTime(confirmTime);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(CONFIRM_TIME_PROPERTY.equals(property)){
			changeConfirmTimeProperty(newValueExpr);
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
			
			
			
	protected void changeConfirmTimeProperty(String newValueExpr){
		Date oldValue = getConfirmTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setConfirmTime(newValue);
		//they are surely different each other
		this.onChangeProperty(CONFIRM_TIME_PROPERTY, oldValue, newValue);
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
	
	
	public void setConfirmTime(Date confirmTime){
		this.mConfirmTime = confirmTime;;
	}
	public Date getConfirmTime(){
		return this.mConfirmTime;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public ConsumerOrderConfirmation copyTo(ConsumerOrderConfirmation dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setConfirmTime(getConfirmTime());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("consumer_order_confirmation{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tconfirm_time='"+getConfirmTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

