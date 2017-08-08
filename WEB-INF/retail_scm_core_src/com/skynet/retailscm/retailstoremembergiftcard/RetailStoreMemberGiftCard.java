
package com.skynet.retailscm.retailstoremembergiftcard;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;

@JsonSerialize(using = RetailStoreMemberGiftCardSerializer.class)
public class RetailStoreMemberGiftCard extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String NUMBER_PROPERTY                = "number"            ;
	public static final String REMAIN_PROPERTY                = "remain"            ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST = "retailStoreMemberGiftCardConsumeRecordList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		RetailStoreMember   	mOwner              ;
	protected		String              	mNumber             ;
	protected		double              	mRemain             ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<RetailStoreMemberGiftCardConsumeRecord>	mRetailStoreMemberGiftCardConsumeRecordList;
	
		
	public 	RetailStoreMemberGiftCard(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreMemberGiftCard(String name, RetailStoreMember owner, String number, double remain
)
	{
		setName(name);
		setOwner(owner);
		setNumber(number);
		setRemain(remain);

		this.mRetailStoreMemberGiftCardConsumeRecordList = new SmartList<RetailStoreMemberGiftCardConsumeRecord>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(NUMBER_PROPERTY.equals(property)){
			changeNumberProperty(newValueExpr);
		}
		if(REMAIN_PROPERTY.equals(property)){
			changeRemainProperty(newValueExpr);
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
			
			
			
	protected void changeRemainProperty(String newValueExpr){
		double oldValue = getRemain();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setRemain(newValue);
		//they are surely different each other
		this.onChangeProperty(REMAIN_PROPERTY, oldValue, newValue);
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
	
	
	public void setOwner(RetailStoreMember owner){
		this.mOwner = owner;;
	}
	public RetailStoreMember getOwner(){
		return this.mOwner;
	}
	
	
	public void setNumber(String number){
		this.mNumber = trimString(number);;
	}
	public String getNumber(){
		return this.mNumber;
	}
	
	
	public void setRemain(double remain){
		this.mRemain = remain;;
	}
	public double getRemain(){
		return this.mRemain;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<RetailStoreMemberGiftCardConsumeRecord> getRetailStoreMemberGiftCardConsumeRecordList(){
		if(this.mRetailStoreMemberGiftCardConsumeRecordList == null){
			this.mRetailStoreMemberGiftCardConsumeRecordList = new SmartList<RetailStoreMemberGiftCardConsumeRecord>();
		}
		return this.mRetailStoreMemberGiftCardConsumeRecordList;	
	}
	public  void setRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setOwner(this);
		}
		
		this.mRetailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList;
		
	}
	
	public  void addRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		retailStoreMemberGiftCardConsumeRecord.setOwner(this);
		getRetailStoreMemberGiftCardConsumeRecordList().add(retailStoreMemberGiftCardConsumeRecord);
	}
	public  void addRetailStoreMemberGiftCardConsumeRecords(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setOwner(this);
		}
		getRetailStoreMemberGiftCardConsumeRecordList().addAll(retailStoreMemberGiftCardConsumeRecordList);
	}
	
	public  void removeRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
	
		boolean result = getRetailStoreMemberGiftCardConsumeRecordList().planToRemove(retailStoreMemberGiftCardConsumeRecord);
        if(!result){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecord.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecord.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreMemberGiftCardConsumeRecordList", retailStoreMemberGiftCardConsumeRecord);
		//the constant "toRetailStoreMemberGiftCardConsumeRecord" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreMemberGiftCardConsumeRecordFrom(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {
		// TODO Auto-generated method stub
		
        RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordInList = findTheRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord);
        RetailStoreMemberGiftCardConsumeRecord newRetailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
        retailStoreMemberGiftCardConsumeRecordInList.copyTo(newRetailStoreMemberGiftCardConsumeRecord);
        newRetailStoreMemberGiftCardConsumeRecord.setVersion(0);//will trigger copy
        getRetailStoreMemberGiftCardConsumeRecordList().add(newRetailStoreMemberGiftCardConsumeRecord);
	}
	
	public  RetailStoreMemberGiftCardConsumeRecord findTheRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		
		int index =  getRetailStoreMemberGiftCardConsumeRecordList().indexOf(retailStoreMemberGiftCardConsumeRecord);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecord.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecord.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreMemberGiftCardConsumeRecordList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberGiftCardConsumeRecordList(){
		getRetailStoreMemberGiftCardConsumeRecordList().clear();
	}
	
	
	
	
 	
	
	public RetailStoreMemberGiftCard copyTo(RetailStoreMemberGiftCard dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setOwner(getOwner());
		dest.setNumber(getNumber());
		dest.setRemain(getRemain());
		dest.setVersion(getVersion());
		dest.setRetailStoreMemberGiftCardConsumeRecordList(getRetailStoreMemberGiftCardConsumeRecordList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_member_gift_card{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_member("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tnumber='"+getNumber()+"';");
		stringBuilder.append("\tremain='"+getRemain()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

