
package com.skynet.retailscm.consumerorderpriceadjustment;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.consumerorder.ConsumerOrder;

@JsonSerialize(using = ConsumerOrderPriceAdjustmentSerializer.class)
public class ConsumerOrderPriceAdjustment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String PROVIDER_PROPERTY              = "provider"          ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		ConsumerOrder       	mBizOrder           ;
	protected		double              	mAmount             ;
	protected		String              	mProvider           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ConsumerOrderPriceAdjustment(){
		//lazy load for all the properties
	}
	
	public 	ConsumerOrderPriceAdjustment(String name, ConsumerOrder bizOrder, double amount, String provider
)
	{
		setName(name);
		setBizOrder(bizOrder);
		setAmount(amount);
		setProvider(provider);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}
		if(PROVIDER_PROPERTY.equals(property)){
			changeProviderProperty(newValueExpr);
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
			
			
			
	protected void changeProviderProperty(String newValueExpr){
		String oldValue = getProvider();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setProvider(newValue);
		//they are surely different each other
		this.onChangeProperty(PROVIDER_PROPERTY, oldValue, newValue);
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
	
	
	public void setBizOrder(ConsumerOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public ConsumerOrder getBizOrder(){
		return this.mBizOrder;
	}
	
	
	public void setAmount(double amount){
		this.mAmount = amount;;
	}
	public double getAmount(){
		return this.mAmount;
	}
	
	
	public void setProvider(String provider){
		this.mProvider = trimString(provider);;
	}
	public String getProvider(){
		return this.mProvider;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public ConsumerOrderPriceAdjustment copyTo(ConsumerOrderPriceAdjustment dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setBizOrder(getBizOrder());
		dest.setAmount(getAmount());
		dest.setProvider(getProvider());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("consumer_order_price_adjustment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbiz_order='consumer_order("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tprovider='"+getProvider()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

