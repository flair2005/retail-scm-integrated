
package com.skynet.retailscm.originalvoucher;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.skynet.retailscm.accountingdocument.AccountingDocument;

@JsonSerialize(using = OriginalVoucherSerializer.class)
public class OriginalVoucher extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String MADE_BY_PROPERTY               = "madeBy"            ;
	public static final String RECEIVED_BY_PROPERTY           = "receivedBy"        ;
	public static final String VOUCHER_TYPE_PROPERTY          = "voucherType"       ;
	public static final String VOUCHER_IMAGE_PROPERTY         = "voucherImage"      ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String CREATION_PROPERTY              = "creation"          ;
	public static final String CONFIRMATION_PROPERTY          = "confirmation"      ;
	public static final String AUDITING_PROPERTY              = "auditing"          ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		String              	mMadeBy             ;
	protected		String              	mReceivedBy         ;
	protected		String              	mVoucherType        ;
	protected		String              	mVoucherImage       ;
	protected		AccountingDocument  	mBelongsTo          ;
	protected		OriginalVoucherCreation	mCreation           ;
	protected		OriginalVoucherConfirmation	mConfirmation       ;
	protected		OriginalVoucherAuditing	mAuditing           ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	OriginalVoucher(){
		//lazy load for all the properties
	}
	
	public 	OriginalVoucher(String title, String madeBy, String receivedBy, String voucherType, String voucherImage, AccountingDocument belongsTo, String currentStatus
)
	{
		setTitle(title);
		setMadeBy(madeBy);
		setReceivedBy(receivedBy);
		setVoucherType(voucherType);
		setVoucherImage(voucherImage);
		setBelongsTo(belongsTo);
		setCurrentStatus(currentStatus);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(MADE_BY_PROPERTY.equals(property)){
			changeMadeByProperty(newValueExpr);
		}
		if(RECEIVED_BY_PROPERTY.equals(property)){
			changeReceivedByProperty(newValueExpr);
		}
		if(VOUCHER_TYPE_PROPERTY.equals(property)){
			changeVoucherTypeProperty(newValueExpr);
		}
		if(VOUCHER_IMAGE_PROPERTY.equals(property)){
			changeVoucherImageProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTitle(newValue);
		//they are surely different each other
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMadeByProperty(String newValueExpr){
		String oldValue = getMadeBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMadeBy(newValue);
		//they are surely different each other
		this.onChangeProperty(MADE_BY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeReceivedByProperty(String newValueExpr){
		String oldValue = getReceivedBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setReceivedBy(newValue);
		//they are surely different each other
		this.onChangeProperty(RECEIVED_BY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeVoucherTypeProperty(String newValueExpr){
		String oldValue = getVoucherType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setVoucherType(newValue);
		//they are surely different each other
		this.onChangeProperty(VOUCHER_TYPE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeVoucherImageProperty(String newValueExpr){
		String oldValue = getVoucherImage();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setVoucherImage(newValue);
		//they are surely different each other
		this.onChangeProperty(VOUCHER_IMAGE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	
	
	public void setMadeBy(String madeBy){
		this.mMadeBy = trimString(madeBy);;
	}
	public String getMadeBy(){
		return this.mMadeBy;
	}
	
	
	public void setReceivedBy(String receivedBy){
		this.mReceivedBy = trimString(receivedBy);;
	}
	public String getReceivedBy(){
		return this.mReceivedBy;
	}
	
	
	public void setVoucherType(String voucherType){
		this.mVoucherType = trimString(voucherType);;
	}
	public String getVoucherType(){
		return this.mVoucherType;
	}
	
	
	public void setVoucherImage(String voucherImage){
		this.mVoucherImage = trimString(voucherImage);;
	}
	public String getVoucherImage(){
		return this.mVoucherImage;
	}
	
	
	public void setBelongsTo(AccountingDocument belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public AccountingDocument getBelongsTo(){
		return this.mBelongsTo;
	}
	
	
	public void setCreation(OriginalVoucherCreation creation){
		this.mCreation = creation;;
	}
	public OriginalVoucherCreation getCreation(){
		return this.mCreation;
	}
	
	
	public void setConfirmation(OriginalVoucherConfirmation confirmation){
		this.mConfirmation = confirmation;;
	}
	public OriginalVoucherConfirmation getConfirmation(){
		return this.mConfirmation;
	}
	
	
	public void setAuditing(OriginalVoucherAuditing auditing){
		this.mAuditing = auditing;;
	}
	public OriginalVoucherAuditing getAuditing(){
		return this.mAuditing;
	}
	
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public OriginalVoucher copyTo(OriginalVoucher dest){

		dest.setId(getId());
		dest.setTitle(getTitle());
		dest.setMadeBy(getMadeBy());
		dest.setReceivedBy(getReceivedBy());
		dest.setVoucherType(getVoucherType());
		dest.setVoucherImage(getVoucherImage());
		dest.setBelongsTo(getBelongsTo());
		dest.setCreation(getCreation());
		dest.setConfirmation(getConfirmation());
		dest.setAuditing(getAuditing());
		dest.setCurrentStatus(getCurrentStatus());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("original_voucher{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tmade_by='"+getMadeBy()+"';");
		stringBuilder.append("\treceived_by='"+getReceivedBy()+"';");
		stringBuilder.append("\tvoucher_type='"+getVoucherType()+"';");
		stringBuilder.append("\tvoucher_image='"+getVoucherImage()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongs_to='accounting_document("+getBelongsTo().getId()+")';");
 		}
		if(getCreation() != null ){
 			stringBuilder.append("\tcreation='original_voucher_creation("+getCreation().getId()+")';");
 		}
		if(getConfirmation() != null ){
 			stringBuilder.append("\tconfirmation='original_voucher_confirmation("+getConfirmation().getId()+")';");
 		}
		if(getAuditing() != null ){
 			stringBuilder.append("\tauditing='original_voucher_auditing("+getAuditing().getId()+")';");
 		}
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

