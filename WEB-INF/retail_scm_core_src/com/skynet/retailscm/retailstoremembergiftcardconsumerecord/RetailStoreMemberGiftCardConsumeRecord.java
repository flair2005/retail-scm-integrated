
package com.skynet.retailscm.retailstoremembergiftcardconsumerecord;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.consumerorder.ConsumerOrder;

@JsonSerialize(using = RetailStoreMemberGiftCardConsumeRecordSerializer.class)
public class RetailStoreMemberGiftCardConsumeRecord extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String OCCURE_TIME_PROPERTY           = "occureTime"        ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String NUMBER_PROPERTY                = "number"            ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Date                	mOccureTime         ;
	protected		RetailStoreMemberGiftCard	mOwner              ;
	protected		ConsumerOrder       	mBizOrder           ;
	protected		String              	mNumber             ;
	protected		double              	mAmount             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	RetailStoreMemberGiftCardConsumeRecord(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreMemberGiftCardConsumeRecord(Date occureTime, RetailStoreMemberGiftCard owner, ConsumerOrder bizOrder, String number, double amount
)
	{
		setOccureTime(occureTime);
		setOwner(owner);
		setBizOrder(bizOrder);
		setNumber(number);
		setAmount(amount);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(OCCURE_TIME_PROPERTY.equals(property)){
			changeOccureTimeProperty(newValueExpr);
		}
		if(NUMBER_PROPERTY.equals(property)){
			changeNumberProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeOccureTimeProperty(String newValueExpr){
		Date oldValue = getOccureTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setOccureTime(newValue);
		//they are surely different each other
		this.onChangeProperty(OCCURE_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeNumberProperty(String newValueExpr){
		String oldValue = getNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(NUMBER_PROPERTY, oldValue, newValue);
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
	
	
	public void setOccureTime(Date occureTime){
		this.mOccureTime = occureTime;;
	}
	public Date getOccureTime(){
		return this.mOccureTime;
	}
	
	
	public void setOwner(RetailStoreMemberGiftCard owner){
		this.mOwner = owner;;
	}
	public RetailStoreMemberGiftCard getOwner(){
		return this.mOwner;
	}
	
	
	public void setBizOrder(ConsumerOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public ConsumerOrder getBizOrder(){
		return this.mBizOrder;
	}
	
	
	public void setNumber(String number){
		this.mNumber = trimString(number);;
	}
	public String getNumber(){
		return this.mNumber;
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
	
	
 	
	
	public RetailStoreMemberGiftCardConsumeRecord copyTo(RetailStoreMemberGiftCardConsumeRecord dest){

		dest.setId(getId());
		dest.setOccureTime(getOccureTime());
		dest.setOwner(getOwner());
		dest.setBizOrder(getBizOrder());
		dest.setNumber(getNumber());
		dest.setAmount(getAmount());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_member_gift_card_consume_record{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\toccure_time='"+getOccureTime()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_member_gift_card("+getOwner().getId()+")';");
 		}
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbiz_order='consumer_order("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tnumber='"+getNumber()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

