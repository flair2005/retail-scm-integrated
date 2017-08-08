
package com.skynet.retailscm.retailstoreorderlineitem;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;

@JsonSerialize(using = RetailStoreOrderLineItemSerializer.class)
public class RetailStoreOrderLineItem extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String SKU_ID_PROPERTY                = "skuId"             ;
	public static final String SKU_NAME_PROPERTY              = "skuName"           ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String QUANTITY_PROPERTY              = "quantity"          ;
	public static final String UNIT_OF_MEASUREMENT_PROPERTY   = "unitOfMeasurement" ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		RetailStoreOrder    	mBizOrder           ;
	protected		String              	mSkuId              ;
	protected		String              	mSkuName            ;
	protected		double              	mAmount             ;
	protected		int                 	mQuantity           ;
	protected		String              	mUnitOfMeasurement  ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	RetailStoreOrderLineItem(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreOrderLineItem(RetailStoreOrder bizOrder, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement
)
	{
		setBizOrder(bizOrder);
		setSkuId(skuId);
		setSkuName(skuName);
		setAmount(amount);
		setQuantity(quantity);
		setUnitOfMeasurement(unitOfMeasurement);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(SKU_ID_PROPERTY.equals(property)){
			changeSkuIdProperty(newValueExpr);
		}
		if(SKU_NAME_PROPERTY.equals(property)){
			changeSkuNameProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}
		if(QUANTITY_PROPERTY.equals(property)){
			changeQuantityProperty(newValueExpr);
		}
		if(UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
			changeUnitOfMeasurementProperty(newValueExpr);
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
			
			
			
	protected void changeQuantityProperty(String newValueExpr){
		int oldValue = getQuantity();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setQuantity(newValue);
		//they are surely different each other
		this.onChangeProperty(QUANTITY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeUnitOfMeasurementProperty(String newValueExpr){
		String oldValue = getUnitOfMeasurement();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setUnitOfMeasurement(newValue);
		//they are surely different each other
		this.onChangeProperty(UNIT_OF_MEASUREMENT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setBizOrder(RetailStoreOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public RetailStoreOrder getBizOrder(){
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
	
	
	public void setAmount(double amount){
		this.mAmount = amount;;
	}
	public double getAmount(){
		return this.mAmount;
	}
	
	
	public void setQuantity(int quantity){
		this.mQuantity = quantity;;
	}
	public int getQuantity(){
		return this.mQuantity;
	}
	
	
	public void setUnitOfMeasurement(String unitOfMeasurement){
		this.mUnitOfMeasurement = trimString(unitOfMeasurement);;
	}
	public String getUnitOfMeasurement(){
		return this.mUnitOfMeasurement;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public RetailStoreOrderLineItem copyTo(RetailStoreOrderLineItem dest){

		dest.setId(getId());
		dest.setBizOrder(getBizOrder());
		dest.setSkuId(getSkuId());
		dest.setSkuName(getSkuName());
		dest.setAmount(getAmount());
		dest.setQuantity(getQuantity());
		dest.setUnitOfMeasurement(getUnitOfMeasurement());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_order_line_item{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbiz_order='retail_store_order("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tsku_id='"+getSkuId()+"';");
		stringBuilder.append("\tsku_name='"+getSkuName()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tquantity='"+getQuantity()+"';");
		stringBuilder.append("\tunit_of_measurement='"+getUnitOfMeasurement()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

