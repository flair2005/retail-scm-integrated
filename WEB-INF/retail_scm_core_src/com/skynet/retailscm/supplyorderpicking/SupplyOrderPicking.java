
package com.skynet.retailscm.supplyorderpicking;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.supplyorder.SupplyOrder;

@JsonSerialize(using = SupplyOrderPickingSerializer.class)
public class SupplyOrderPicking extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String PROCESS_TIME_PROPERTY          = "processTime"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SUPPLY_ORDER_LIST                        = "supplyOrderList"   ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Date                	mProcessTime        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<SupplyOrder>	mSupplyOrderList    ;
	
		
	public 	SupplyOrderPicking(){
		//lazy load for all the properties
	}
	
	public 	SupplyOrderPicking(String who, Date processTime
)
	{
		setWho(who);
		setProcessTime(processTime);

		this.mSupplyOrderList = new SmartList<SupplyOrder>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(PROCESS_TIME_PROPERTY.equals(property)){
			changeProcessTimeProperty(newValueExpr);
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
			
			
			
	protected void changeProcessTimeProperty(String newValueExpr){
		Date oldValue = getProcessTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setProcessTime(newValue);
		//they are surely different each other
		this.onChangeProperty(PROCESS_TIME_PROPERTY, oldValue, newValue);
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
	
	
	public void setProcessTime(Date processTime){
		this.mProcessTime = processTime;;
	}
	public Date getProcessTime(){
		return this.mProcessTime;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<SupplyOrder> getSupplyOrderList(){
		if(this.mSupplyOrderList == null){
			this.mSupplyOrderList = new SmartList<SupplyOrder>();
		}
		return this.mSupplyOrderList;	
	}
	public  void setSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setPicking(this);
		}
		
		this.mSupplyOrderList = supplyOrderList;
		
	}
	
	public  void addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setPicking(this);
		getSupplyOrderList().add(supplyOrder);
	}
	public  void addSupplyOrders(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setPicking(this);
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
	
	
	
	
 	
	
	public SupplyOrderPicking copyTo(SupplyOrderPicking dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setProcessTime(getProcessTime());
		dest.setVersion(getVersion());
		dest.setSupplyOrderList(getSupplyOrderList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("supply_order_picking{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tprocess_time='"+getProcessTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

