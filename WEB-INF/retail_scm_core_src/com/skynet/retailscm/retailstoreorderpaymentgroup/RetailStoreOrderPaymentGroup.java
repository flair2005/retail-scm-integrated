
package com.skynet.retailscm.retailstoreorderpaymentgroup;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;

@JsonSerialize(using = RetailStoreOrderPaymentGroupSerializer.class)
public class RetailStoreOrderPaymentGroup extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String CARD_NUMBER_PROPERTY           = "cardNumber"        ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		RetailStoreOrder    	mBizOrder           ;
	protected		String              	mCardNumber         ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	RetailStoreOrderPaymentGroup(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreOrderPaymentGroup(String name, RetailStoreOrder bizOrder, String cardNumber
)
	{
		setName(name);
		setBizOrder(bizOrder);
		setCardNumber(cardNumber);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CARD_NUMBER_PROPERTY.equals(property)){
			changeCardNumberProperty(newValueExpr);
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
			
			
			
	protected void changeCardNumberProperty(String newValueExpr){
		String oldValue = getCardNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCardNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(CARD_NUMBER_PROPERTY, oldValue, newValue);
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
	
	
	public void setBizOrder(RetailStoreOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public RetailStoreOrder getBizOrder(){
		return this.mBizOrder;
	}
	
	
	public void setCardNumber(String cardNumber){
		this.mCardNumber = trimString(cardNumber);;
	}
	public String getCardNumber(){
		return this.mCardNumber;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public RetailStoreOrderPaymentGroup copyTo(RetailStoreOrderPaymentGroup dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setBizOrder(getBizOrder());
		dest.setCardNumber(getCardNumber());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_order_payment_group{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbiz_order='retail_store_order("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tcard_number='"+getCardNumber()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

