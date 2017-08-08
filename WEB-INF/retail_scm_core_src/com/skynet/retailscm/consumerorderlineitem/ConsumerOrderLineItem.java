
package com.skynet.retailscm.consumerorderlineitem;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.consumerorder.ConsumerOrder;

@JsonSerialize(using = ConsumerOrderLineItemSerializer.class)
public class ConsumerOrderLineItem extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String SKU_ID_PROPERTY                = "skuId"             ;
	public static final String SKU_NAME_PROPERTY              = "skuName"           ;
	public static final String PRICE_PROPERTY                 = "price"             ;
	public static final String QUANTITY_PROPERTY              = "quantity"          ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		ConsumerOrder       	mBizOrder           ;
	protected		String              	mSkuId              ;
	protected		String              	mSkuName            ;
	protected		double              	mPrice              ;
	protected		double              	mQuantity           ;
	protected		double              	mAmount             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ConsumerOrderLineItem(){
		//lazy load for all the properties
	}
	
	public 	ConsumerOrderLineItem(ConsumerOrder bizOrder, String skuId, String skuName, double price, double quantity, double amount
)
	{
		setBizOrder(bizOrder);
		setSkuId(skuId);
		setSkuName(skuName);
		setPrice(price);
		setQuantity(quantity);
		setAmount(amount);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(SKU_ID_PROPERTY.equals(property)){
			changeSkuIdProperty(newValueExpr);
		}
		if(SKU_NAME_PROPERTY.equals(property)){
			changeSkuNameProperty(newValueExpr);
		}
		if(PRICE_PROPERTY.equals(property)){
			changePriceProperty(newValueExpr);
		}
		if(QUANTITY_PROPERTY.equals(property)){
			changeQuantityProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeSkuIdProperty(String newValueExpr){
		String oldValue = getSkuId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setSkuId(newValue);
		//they are surely different each other
		this.onChangeProperty(SKU_ID_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeSkuNameProperty(String newValueExpr){
		String oldValue = getSkuName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setSkuName(newValue);
		//they are surely different each other
		this.onChangeProperty(SKU_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changePriceProperty(String newValueExpr){
		double oldValue = getPrice();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPrice(newValue);
		//they are surely different each other
		this.onChangeProperty(PRICE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeQuantityProperty(String newValueExpr){
		double oldValue = getQuantity();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setQuantity(newValue);
		//they are surely different each other
		this.onChangeProperty(QUANTITY_PROPERTY, oldValue, newValue);
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
	
	
	public void setBizOrder(ConsumerOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public ConsumerOrder getBizOrder(){
		return this.mBizOrder;
	}
	
	
	public void setSkuId(String skuId){
		this.mSkuId = trimString(skuId);;
	}
	public String getSkuId(){
		return this.mSkuId;
	}
	
	
	public void setSkuName(String skuName){
		this.mSkuName = trimString(skuName);;
	}
	public String getSkuName(){
		return this.mSkuName;
	}
	
	
	public void setPrice(double price){
		this.mPrice = price;;
	}
	public double getPrice(){
		return this.mPrice;
	}
	
	
	public void setQuantity(double quantity){
		this.mQuantity = quantity;;
	}
	public double getQuantity(){
		return this.mQuantity;
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
	
	
 	
	
	public ConsumerOrderLineItem copyTo(ConsumerOrderLineItem dest){

		dest.setId(getId());
		dest.setBizOrder(getBizOrder());
		dest.setSkuId(getSkuId());
		dest.setSkuName(getSkuName());
		dest.setPrice(getPrice());
		dest.setQuantity(getQuantity());
		dest.setAmount(getAmount());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("consumer_order_line_item{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbiz_order='consumer_order("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tsku_id='"+getSkuId()+"';");
		stringBuilder.append("\tsku_name='"+getSkuName()+"';");
		stringBuilder.append("\tprice='"+getPrice()+"';");
		stringBuilder.append("\tquantity='"+getQuantity()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

