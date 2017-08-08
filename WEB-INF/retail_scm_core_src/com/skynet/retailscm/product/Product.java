
package com.skynet.retailscm.product;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;

@JsonSerialize(using = ProductSerializer.class)
public class Product extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String DISPLAY_NAME_PROPERTY          = "displayName"       ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String ORIGIN_PROPERTY                = "origin"            ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String BRAND_PROPERTY                 = "brand"             ;
	public static final String PICTURE_PROPERTY               = "picture"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SKU_LIST                                 = "skuList"           ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mDisplayName        ;
	protected		LevelThreeCategory  	mParentCategory     ;
	protected		String              	mOrigin             ;
	protected		String              	mRemark             ;
	protected		String              	mBrand              ;
	protected		String              	mPicture            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Sku>      	mSkuList            ;
	
		
	public 	Product(){
		//lazy load for all the properties
	}
	
	public 	Product(String displayName, LevelThreeCategory parentCategory, String origin, String remark, String brand, String picture
)
	{
		setDisplayName(displayName);
		setParentCategory(parentCategory);
		setOrigin(origin);
		setRemark(remark);
		setBrand(brand);
		setPicture(picture);

		this.mSkuList = new SmartList<Sku>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(DISPLAY_NAME_PROPERTY.equals(property)){
			changeDisplayNameProperty(newValueExpr);
		}
		if(ORIGIN_PROPERTY.equals(property)){
			changeOriginProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}
		if(BRAND_PROPERTY.equals(property)){
			changeBrandProperty(newValueExpr);
		}
		if(PICTURE_PROPERTY.equals(property)){
			changePictureProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeDisplayNameProperty(String newValueExpr){
		String oldValue = getDisplayName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDisplayName(newValue);
		//they are surely different each other
		this.onChangeProperty(DISPLAY_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeOriginProperty(String newValueExpr){
		String oldValue = getOrigin();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setOrigin(newValue);
		//they are surely different each other
		this.onChangeProperty(ORIGIN_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeRemarkProperty(String newValueExpr){
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setRemark(newValue);
		//they are surely different each other
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeBrandProperty(String newValueExpr){
		String oldValue = getBrand();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setBrand(newValue);
		//they are surely different each other
		this.onChangeProperty(BRAND_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changePictureProperty(String newValueExpr){
		String oldValue = getPicture();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPicture(newValue);
		//they are surely different each other
		this.onChangeProperty(PICTURE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setDisplayName(String displayName){
		this.mDisplayName = trimString(displayName);;
	}
	public String getDisplayName(){
		return this.mDisplayName;
	}
	
	
	public void setParentCategory(LevelThreeCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelThreeCategory getParentCategory(){
		return this.mParentCategory;
	}
	
	
	public void setOrigin(String origin){
		this.mOrigin = trimString(origin);;
	}
	public String getOrigin(){
		return this.mOrigin;
	}
	
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	
	
	public void setBrand(String brand){
		this.mBrand = trimString(brand);;
	}
	public String getBrand(){
		return this.mBrand;
	}
	
	
	public void setPicture(String picture){
		this.mPicture = trimString(picture);;
	}
	public String getPicture(){
		return this.mPicture;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<Sku> getSkuList(){
		if(this.mSkuList == null){
			this.mSkuList = new SmartList<Sku>();
		}
		return this.mSkuList;	
	}
	public  void setSkuList(SmartList<Sku> skuList){
		for( Sku sku:skuList){
			sku.setProduct(this);
		}
		
		this.mSkuList = skuList;
		
	}
	
	public  void addSku(Sku sku){
		sku.setProduct(this);
		getSkuList().add(sku);
	}
	public  void addSkues(SmartList<Sku> skuList){
		for( Sku sku:skuList){
			sku.setProduct(this);
		}
		getSkuList().addAll(skuList);
	}
	
	public  void removeSku(Sku sku){
	
		boolean result = getSkuList().planToRemove(sku);
        if(!result){
        	String message = "Sku("+sku.getId()+") with version='"+sku.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSkuList", sku);
		//the constant "toSku" will be replaced after refactoried.
	
	}
	
	public void copySkuFrom(Sku sku) {
		// TODO Auto-generated method stub
		
        Sku skuInList = findTheSku(sku);
        Sku newSku = new Sku();
        skuInList.copyTo(newSku);
        newSku.setVersion(0);//will trigger copy
        getSkuList().add(newSku);
	}
	
	public  Sku findTheSku(Sku sku){
		
		int index =  getSkuList().indexOf(sku);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Sku("+sku.getId()+") with version='"+sku.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSkuList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSkuList(){
		getSkuList().clear();
	}
	
	
	
	
 	
	
	public Product copyTo(Product dest){

		dest.setId(getId());
		dest.setDisplayName(getDisplayName());
		dest.setParentCategory(getParentCategory());
		dest.setOrigin(getOrigin());
		dest.setRemark(getRemark());
		dest.setBrand(getBrand());
		dest.setPicture(getPicture());
		dest.setVersion(getVersion());
		dest.setSkuList(getSkuList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("product{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tdisplay_name='"+getDisplayName()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparent_category='level_three_category("+getParentCategory().getId()+")';");
 		}
		stringBuilder.append("\torigin='"+getOrigin()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tbrand='"+getBrand()+"';");
		stringBuilder.append("\tpicture='"+getPicture()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

