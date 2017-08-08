
package com.skynet.retailscm.supplyordershipment;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.consumerorder.ConsumerOrder;

@JsonSerialize(using = SupplyOrderShipmentSerializer.class)
public class SupplyOrderShipment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String SHIP_TIME_PROPERTY             = "shipTime"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LIST                      = "consumerOrderList" ;
	public static final String SUPPLY_ORDER_LIST                        = "supplyOrderList"   ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Date                	mShipTime           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrder>	mConsumerOrderList  ;
	protected		SmartList<SupplyOrder>	mSupplyOrderList    ;
	
		
	public 	SupplyOrderShipment(){
		//lazy load for all the properties
	}
	
	public 	SupplyOrderShipment(String who, Date shipTime
)
	{
		setWho(who);
		setShipTime(shipTime);

		this.mConsumerOrderList = new SmartList<ConsumerOrder>();
		this.mSupplyOrderList = new SmartList<SupplyOrder>();	
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
	
	
	public  SmartList<ConsumerOrder> getConsumerOrderList(){
		if(this.mConsumerOrderList == null){
			this.mConsumerOrderList = new SmartList<ConsumerOrder>();
		}
		return this.mConsumerOrderList;	
	}
	public  void setConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setShipment(this);
		}
		
		this.mConsumerOrderList = consumerOrderList;
		
	}
	
	public  void addConsumerOrder(ConsumerOrder consumerOrder){
		consumerOrder.setShipment(this);
		getConsumerOrderList().add(consumerOrder);
	}
	public  void addConsumerOrders(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setShipment(this);
		}
		getConsumerOrderList().addAll(consumerOrderList);
	}
	
	public  void removeConsumerOrder(ConsumerOrder consumerOrder){
	
		boolean result = getConsumerOrderList().planToRemove(consumerOrder);
        if(!result){
        	String message = "ConsumerOrder("+consumerOrder.getId()+") with version='"+consumerOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveConsumerOrderList", consumerOrder);
		//the constant "toConsumerOrder" will be replaced after refactoried.
	
	}
	
	public void copyConsumerOrderFrom(ConsumerOrder consumerOrder) {
		// TODO Auto-generated method stub
		
        ConsumerOrder consumerOrderInList = findTheConsumerOrder(consumerOrder);
        ConsumerOrder newConsumerOrder = new ConsumerOrder();
        consumerOrderInList.copyTo(newConsumerOrder);
        newConsumerOrder.setVersion(0);//will trigger copy
        getConsumerOrderList().add(newConsumerOrder);
	}
	
	public  ConsumerOrder findTheConsumerOrder(ConsumerOrder consumerOrder){
		
		int index =  getConsumerOrderList().indexOf(consumerOrder);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ConsumerOrder("+consumerOrder.getId()+") with version='"+consumerOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getConsumerOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpConsumerOrderList(){
		getConsumerOrderList().clear();
	}
	
	
	
	
	public  SmartList<SupplyOrder> getSupplyOrderList(){
		if(this.mSupplyOrderList == null){
			this.mSupplyOrderList = new SmartList<SupplyOrder>();
		}
		return this.mSupplyOrderList;	
	}
	public  void setSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setShipment(this);
		}
		
		this.mSupplyOrderList = supplyOrderList;
		
	}
	
	public  void addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setShipment(this);
		getSupplyOrderList().add(supplyOrder);
	}
	public  void addSupplyOrders(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setShipment(this);
		}
		getSupplyOrderList().addAll(supplyOrderList);
	}
	
	public  void removeSupplyOrder(SupplyOrder supplyOrder){
	
		boolean result = getSupplyOrderList().planToRemove(supplyOrder);
        if(!result){
        	String message = "SupplyOrder("+supplyOrder.getId()+") with version='"+supplyOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSupplyOrderList", supplyOrder);
		//the constant "toSupplyOrder" will be replaced after refactoried.
	
	}
	
	public void copySupplyOrderFrom(SupplyOrder supplyOrder) {
		// TODO Auto-generated method stub
		
        SupplyOrder supplyOrderInList = findTheSupplyOrder(supplyOrder);
        SupplyOrder newSupplyOrder = new SupplyOrder();
        supplyOrderInList.copyTo(newSupplyOrder);
        newSupplyOrder.setVersion(0);//will trigger copy
        getSupplyOrderList().add(newSupplyOrder);
	}
	
	public  SupplyOrder findTheSupplyOrder(SupplyOrder supplyOrder){
		
		int index =  getSupplyOrderList().indexOf(supplyOrder);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SupplyOrder("+supplyOrder.getId()+") with version='"+supplyOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSupplyOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderList(){
		getSupplyOrderList().clear();
	}
	
	
	
	
 	
	
	public SupplyOrderShipment copyTo(SupplyOrderShipment dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setShipTime(getShipTime());
		dest.setVersion(getVersion());
		dest.setConsumerOrderList(getConsumerOrderList());
		dest.setSupplyOrderList(getSupplyOrderList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("supply_order_shipment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tship_time='"+getShipTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

