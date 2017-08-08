
package com.skynet.retailscm.retailstoreorderapproval;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;

@JsonSerialize(using = RetailStoreOrderApprovalSerializer.class)
public class RetailStoreOrderApproval extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String APPROVE_TIME_PROPERTY          = "approveTime"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_ORDER_LIST                  = "retailStoreOrderList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Date                	mApproveTime        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<RetailStoreOrder>	mRetailStoreOrderList;
	
		
	public 	RetailStoreOrderApproval(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreOrderApproval(String who, Date approveTime
)
	{
		setWho(who);
		setApproveTime(approveTime);

		this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(APPROVE_TIME_PROPERTY.equals(property)){
			changeApproveTimeProperty(newValueExpr);
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
			
			
			
	protected void changeApproveTimeProperty(String newValueExpr){
		Date oldValue = getApproveTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setApproveTime(newValue);
		//they are surely different each other
		this.onChangeProperty(APPROVE_TIME_PROPERTY, oldValue, newValue);
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
	
	
	public void setApproveTime(Date approveTime){
		this.mApproveTime = approveTime;;
	}
	public Date getApproveTime(){
		return this.mApproveTime;
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
			retailStoreOrder.setApproval(this);
		}
		
		this.mRetailStoreOrderList = retailStoreOrderList;
		
	}
	
	public  void addRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		retailStoreOrder.setApproval(this);
		getRetailStoreOrderList().add(retailStoreOrder);
	}
	public  void addRetailStoreOrders(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setApproval(this);
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
	
	
	
	
 	
	
	public RetailStoreOrderApproval copyTo(RetailStoreOrderApproval dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setApproveTime(getApproveTime());
		dest.setVersion(getVersion());
		dest.setRetailStoreOrderList(getRetailStoreOrderList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_order_approval{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tapprove_time='"+getApproveTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

