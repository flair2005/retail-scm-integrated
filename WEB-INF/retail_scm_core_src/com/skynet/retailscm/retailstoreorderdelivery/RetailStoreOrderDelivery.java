
package com.skynet.retailscm.retailstoreorderdelivery;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;

@JsonSerialize(using = RetailStoreOrderDeliverySerializer.class)
public class RetailStoreOrderDelivery extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String DELIVERY_TIME_PROPERTY         = "deliveryTime"      ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_ORDER_LIST                  = "retailStoreOrderList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Date                	mDeliveryTime       ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<RetailStoreOrder>	mRetailStoreOrderList;
	
		
	public 	RetailStoreOrderDelivery(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreOrderDelivery(String who, Date deliveryTime
)
	{
		setWho(who);
		setDeliveryTime(deliveryTime);

		this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();	
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
	
	
	public  SmartList<RetailStoreOrder> getRetailStoreOrderList(){
		if(this.mRetailStoreOrderList == null){
			this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();
		}
		return this.mRetailStoreOrderList;	
	}
	public  void setRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setDelivery(this);
		}
		
		this.mRetailStoreOrderList = retailStoreOrderList;
		
	}
	
	public  void addRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		retailStoreOrder.setDelivery(this);
		getRetailStoreOrderList().add(retailStoreOrder);
	}
	public  void addRetailStoreOrders(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setDelivery(this);
		}
		getRetailStoreOrderList().addAll(retailStoreOrderList);
	}
	
	public  void removeRetailStoreOrder(RetailStoreOrder retailStoreOrder){
	
		boolean result = getRetailStoreOrderList().planToRemove(retailStoreOrder);
        if(!result){
        	String message = "RetailStoreOrder("+retailStoreOrder.getId()+") with version='"+retailStoreOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreOrderList", retailStoreOrder);
		//the constant "toRetailStoreOrder" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreOrderFrom(RetailStoreOrder retailStoreOrder) {
		// TODO Auto-generated method stub
		
        RetailStoreOrder retailStoreOrderInList = findTheRetailStoreOrder(retailStoreOrder);
        RetailStoreOrder newRetailStoreOrder = new RetailStoreOrder();
        retailStoreOrderInList.copyTo(newRetailStoreOrder);
        newRetailStoreOrder.setVersion(0);//will trigger copy
        getRetailStoreOrderList().add(newRetailStoreOrder);
	}
	
	public  RetailStoreOrder findTheRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		
		int index =  getRetailStoreOrderList().indexOf(retailStoreOrder);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreOrder("+retailStoreOrder.getId()+") with version='"+retailStoreOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderList(){
		getRetailStoreOrderList().clear();
	}
	
	
	
	
 	
	
	public RetailStoreOrderDelivery copyTo(RetailStoreOrderDelivery dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setDeliveryTime(getDeliveryTime());
		dest.setVersion(getVersion());
		dest.setRetailStoreOrderList(getRetailStoreOrderList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_order_delivery{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tdelivery_time='"+getDeliveryTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

