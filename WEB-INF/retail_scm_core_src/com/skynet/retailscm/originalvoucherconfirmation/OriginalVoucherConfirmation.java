
package com.skynet.retailscm.originalvoucherconfirmation;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.originalvoucher.OriginalVoucher;

@JsonSerialize(using = OriginalVoucherConfirmationSerializer.class)
public class OriginalVoucherConfirmation extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String COMMENTS_PROPERTY              = "comments"          ;
	public static final String MAKE_DATE_PROPERTY             = "makeDate"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ORIGINAL_VOUCHER_LIST                    = "originalVoucherList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		String              	mComments           ;
	protected		Date                	mMakeDate           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<OriginalVoucher>	mOriginalVoucherList;
	
		
	public 	OriginalVoucherConfirmation(){
		//lazy load for all the properties
	}
	
	public 	OriginalVoucherConfirmation(String who, String comments, Date makeDate
)
	{
		setWho(who);
		setComments(comments);
		setMakeDate(makeDate);

		this.mOriginalVoucherList = new SmartList<OriginalVoucher>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(COMMENTS_PROPERTY.equals(property)){
			changeCommentsProperty(newValueExpr);
		}
		if(MAKE_DATE_PROPERTY.equals(property)){
			changeMakeDateProperty(newValueExpr);
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
			
			
			
	protected void changeCommentsProperty(String newValueExpr){
		String oldValue = getComments();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setComments(newValue);
		//they are surely different each other
		this.onChangeProperty(COMMENTS_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMakeDateProperty(String newValueExpr){
		Date oldValue = getMakeDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMakeDate(newValue);
		//they are surely different each other
		this.onChangeProperty(MAKE_DATE_PROPERTY, oldValue, newValue);
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
	
	
	public void setComments(String comments){
		this.mComments = trimString(comments);;
	}
	public String getComments(){
		return this.mComments;
	}
	
	
	public void setMakeDate(Date makeDate){
		this.mMakeDate = makeDate;;
	}
	public Date getMakeDate(){
		return this.mMakeDate;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<OriginalVoucher> getOriginalVoucherList(){
		if(this.mOriginalVoucherList == null){
			this.mOriginalVoucherList = new SmartList<OriginalVoucher>();
		}
		return this.mOriginalVoucherList;	
	}
	public  void setOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setConfirmation(this);
		}
		
		this.mOriginalVoucherList = originalVoucherList;
		
	}
	
	public  void addOriginalVoucher(OriginalVoucher originalVoucher){
		originalVoucher.setConfirmation(this);
		getOriginalVoucherList().add(originalVoucher);
	}
	public  void addOriginalVouchers(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setConfirmation(this);
		}
		getOriginalVoucherList().addAll(originalVoucherList);
	}
	
	public  void removeOriginalVoucher(OriginalVoucher originalVoucher){
	
		boolean result = getOriginalVoucherList().planToRemove(originalVoucher);
        if(!result){
        	String message = "OriginalVoucher("+originalVoucher.getId()+") with version='"+originalVoucher.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveOriginalVoucherList", originalVoucher);
		//the constant "toOriginalVoucher" will be replaced after refactoried.
	
	}
	
	public void copyOriginalVoucherFrom(OriginalVoucher originalVoucher) {
		// TODO Auto-generated method stub
		
        OriginalVoucher originalVoucherInList = findTheOriginalVoucher(originalVoucher);
        OriginalVoucher newOriginalVoucher = new OriginalVoucher();
        originalVoucherInList.copyTo(newOriginalVoucher);
        newOriginalVoucher.setVersion(0);//will trigger copy
        getOriginalVoucherList().add(newOriginalVoucher);
	}
	
	public  OriginalVoucher findTheOriginalVoucher(OriginalVoucher originalVoucher){
		
		int index =  getOriginalVoucherList().indexOf(originalVoucher);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "OriginalVoucher("+originalVoucher.getId()+") with version='"+originalVoucher.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getOriginalVoucherList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpOriginalVoucherList(){
		getOriginalVoucherList().clear();
	}
	
	
	
	
 	
	
	public OriginalVoucherConfirmation copyTo(OriginalVoucherConfirmation dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setComments(getComments());
		dest.setMakeDate(getMakeDate());
		dest.setVersion(getVersion());
		dest.setOriginalVoucherList(getOriginalVoucherList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("original_voucher_confirmation{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tcomments='"+getComments()+"';");
		stringBuilder.append("\tmake_date='"+getMakeDate()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

