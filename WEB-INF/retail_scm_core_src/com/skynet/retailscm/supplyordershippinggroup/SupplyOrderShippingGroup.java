
package com.skynet.retailscm.supplyordershippinggroup;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.supplyorder.SupplyOrder;

@JsonSerialize(using = SupplyOrderShippingGroupSerializer.class)
public class SupplyOrderShippingGroup extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		SupplyOrder         	mBizOrder           ;
	protected		double              	mAmount             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	SupplyOrderShippingGroup(){
		//lazy load for all the properties
	}
	
	public 	SupplyOrderShippingGroup(String name, SupplyOrder bizOrder, double amount
)
	{
		setName(name);
		setBizOrder(bizOrder);
		setAmount(amount);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
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
			
			
			
	protected void changeAmountProperty(String newValueExpr){
		double oldValue = getAmount();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAmount(newValue);
		//they are surely different each other
		this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
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
	
	
	public void setBizOrder(SupplyOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public SupplyOrder getBizOrder(){
		return this.mBizOrder;
	}
	
	
	public void setAmount(double amount){
		this.mAmount = amount;;
	}
	public double getAmount(){
		return this.mAmount;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public SupplyOrderShippingGroup copyTo(SupplyOrderShippingGroup dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setBizOrder(getBizOrder());
		dest.setAmount(getAmount());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("supply_order_shipping_group{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbiz_order='supply_order("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

