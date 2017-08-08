
package com.skynet.retailscm.goodspackaging;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.goods.Goods;

@JsonSerialize(using = GoodsPackagingSerializer.class)
public class GoodsPackaging extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PACKAGE_NAME_PROPERTY          = "packageName"       ;
	public static final String RFID_PROPERTY                  = "rfid"              ;
	public static final String PACKAGE_TIME_PROPERTY          = "packageTime"       ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_LIST                               = "goodsList"         ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mPackageName        ;
	protected		String              	mRfid               ;
	protected		Date                	mPackageTime        ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Goods>    	mGoodsList          ;
	
		
	public 	GoodsPackaging(){
		//lazy load for all the properties
	}
	
	public 	GoodsPackaging(String packageName, String rfid, Date packageTime, String description
)
	{
		setPackageName(packageName);
		setRfid(rfid);
		setPackageTime(packageTime);
		setDescription(description);

		this.mGoodsList = new SmartList<Goods>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(PACKAGE_NAME_PROPERTY.equals(property)){
			changePackageNameProperty(newValueExpr);
		}
		if(RFID_PROPERTY.equals(property)){
			changeRfidProperty(newValueExpr);
		}
		if(PACKAGE_TIME_PROPERTY.equals(property)){
			changePackageTimeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changePackageNameProperty(String newValueExpr){
		String oldValue = getPackageName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPackageName(newValue);
		//they are surely different each other
		this.onChangeProperty(PACKAGE_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeRfidProperty(String newValueExpr){
		String oldValue = getRfid();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setRfid(newValue);
		//they are surely different each other
		this.onChangeProperty(RFID_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changePackageTimeProperty(String newValueExpr){
		Date oldValue = getPackageTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPackageTime(newValue);
		//they are surely different each other
		this.onChangeProperty(PACKAGE_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDescription(newValue);
		//they are surely different each other
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setPackageName(String packageName){
		this.mPackageName = trimString(packageName);;
	}
	public String getPackageName(){
		return this.mPackageName;
	}
	
	
	public void setRfid(String rfid){
		this.mRfid = trimString(rfid);;
	}
	public String getRfid(){
		return this.mRfid;
	}
	
	
	public void setPackageTime(Date packageTime){
		this.mPackageTime = packageTime;;
	}
	public Date getPackageTime(){
		return this.mPackageTime;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<Goods> getGoodsList(){
		if(this.mGoodsList == null){
			this.mGoodsList = new SmartList<Goods>();
		}
		return this.mGoodsList;	
	}
	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setPackaging(this);
		}
		
		this.mGoodsList = goodsList;
		
	}
	
	public  void addGoods(Goods goods){
		goods.setPackaging(this);
		getGoodsList().add(goods);
	}
	public  void addGoodses(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setPackaging(this);
		}
		getGoodsList().addAll(goodsList);
	}
	
	public  void removeGoods(Goods goods){
	
		boolean result = getGoodsList().planToRemove(goods);
        if(!result){
        	String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveGoodsList", goods);
		//the constant "toGoods" will be replaced after refactoried.
	
	}
	
	public void copyGoodsFrom(Goods goods) {
		// TODO Auto-generated method stub
		
        Goods goodsInList = findTheGoods(goods);
        Goods newGoods = new Goods();
        goodsInList.copyTo(newGoods);
        newGoods.setVersion(0);//will trigger copy
        getGoodsList().add(newGoods);
	}
	
	public  Goods findTheGoods(Goods goods){
		
		int index =  getGoodsList().indexOf(goods);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getGoodsList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsList(){
		getGoodsList().clear();
	}
	
	
	
	
 	
	
	public GoodsPackaging copyTo(GoodsPackaging dest){

		dest.setId(getId());
		dest.setPackageName(getPackageName());
		dest.setRfid(getRfid());
		dest.setPackageTime(getPackageTime());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());
		dest.setGoodsList(getGoodsList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("goods_packaging{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tpackage_name='"+getPackageName()+"';");
		stringBuilder.append("\trfid='"+getRfid()+"';");
		stringBuilder.append("\tpackage_time='"+getPackageTime()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

