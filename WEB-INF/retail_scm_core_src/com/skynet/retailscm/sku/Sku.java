
package com.skynet.retailscm.sku;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.goods.Goods;

@JsonSerialize(using = SkuSerializer.class)
public class Sku extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String DISPLAY_NAME_PROPERTY          = "displayName"       ;
	public static final String SIZE_PROPERTY                  = "size"              ;
	public static final String PRODUCT_PROPERTY               = "product"           ;
	public static final String BARCODE_PROPERTY               = "barcode"           ;
	public static final String PACKAGE_TYPE_PROPERTY          = "packageType"       ;
	public static final String NET_CONTENT_PROPERTY           = "netContent"        ;
	public static final String PRICE_PROPERTY                 = "price"             ;
	public static final String PICTURE_PROPERTY               = "picture"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_LIST                               = "goodsList"         ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mDisplayName        ;
	protected		String              	mSize               ;
	protected		Product             	mProduct            ;
	protected		String              	mBarcode            ;
	protected		String              	mPackageType        ;
	protected		String              	mNetContent         ;
	protected		double              	mPrice              ;
	protected		String              	mPicture            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Goods>    	mGoodsList          ;
	
		
	public 	Sku(){
		//lazy load for all the properties
	}
	
	public 	Sku(String displayName, String size, Product product, String barcode, String packageType, String netContent, double price, String picture
)
	{
		setDisplayName(displayName);
		setSize(size);
		setProduct(product);
		setBarcode(barcode);
		setPackageType(packageType);
		setNetContent(netContent);
		setPrice(price);
		setPicture(picture);

		this.mGoodsList = new SmartList<Goods>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(DISPLAY_NAME_PROPERTY.equals(property)){
			changeDisplayNameProperty(newValueExpr);
		}
		if(SIZE_PROPERTY.equals(property)){
			changeSizeProperty(newValueExpr);
		}
		if(BARCODE_PROPERTY.equals(property)){
			changeBarcodeProperty(newValueExpr);
		}
		if(PACKAGE_TYPE_PROPERTY.equals(property)){
			changePackageTypeProperty(newValueExpr);
		}
		if(NET_CONTENT_PROPERTY.equals(property)){
			changeNetContentProperty(newValueExpr);
		}
		if(PRICE_PROPERTY.equals(property)){
			changePriceProperty(newValueExpr);
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
			
			
			
	protected void changeSizeProperty(String newValueExpr){
		String oldValue = getSize();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setSize(newValue);
		//they are surely different each other
		this.onChangeProperty(SIZE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeBarcodeProperty(String newValueExpr){
		String oldValue = getBarcode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setBarcode(newValue);
		//they are surely different each other
		this.onChangeProperty(BARCODE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changePackageTypeProperty(String newValueExpr){
		String oldValue = getPackageType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPackageType(newValue);
		//they are surely different each other
		this.onChangeProperty(PACKAGE_TYPE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeNetContentProperty(String newValueExpr){
		String oldValue = getNetContent();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setNetContent(newValue);
		//they are surely different each other
		this.onChangeProperty(NET_CONTENT_PROPERTY, oldValue, newValue);
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
	
	
	public void setSize(String size){
		this.mSize = trimString(size);;
	}
	public String getSize(){
		return this.mSize;
	}
	
	
	public void setProduct(Product product){
		this.mProduct = product;;
	}
	public Product getProduct(){
		return this.mProduct;
	}
	
	
	public void setBarcode(String barcode){
		this.mBarcode = trimString(barcode);;
	}
	public String getBarcode(){
		return this.mBarcode;
	}
	
	
	public void setPackageType(String packageType){
		this.mPackageType = trimString(packageType);;
	}
	public String getPackageType(){
		return this.mPackageType;
	}
	
	
	public void setNetContent(String netContent){
		this.mNetContent = trimString(netContent);;
	}
	public String getNetContent(){
		return this.mNetContent;
	}
	
	
	public void setPrice(double price){
		this.mPrice = price;;
	}
	public double getPrice(){
		return this.mPrice;
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
	
	
	public  SmartList<Goods> getGoodsList(){
		if(this.mGoodsList == null){
			this.mGoodsList = new SmartList<Goods>();
		}
		return this.mGoodsList;	
	}
	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setSku(this);
		}
		
		this.mGoodsList = goodsList;
		
	}
	
	public  void addGoods(Goods goods){
		goods.setSku(this);
		getGoodsList().add(goods);
	}
	public  void addGoodses(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setSku(this);
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
	
	
	
	
 	
	
	public Sku copyTo(Sku dest){

		dest.setId(getId());
		dest.setDisplayName(getDisplayName());
		dest.setSize(getSize());
		dest.setProduct(getProduct());
		dest.setBarcode(getBarcode());
		dest.setPackageType(getPackageType());
		dest.setNetContent(getNetContent());
		dest.setPrice(getPrice());
		dest.setPicture(getPicture());
		dest.setVersion(getVersion());
		dest.setGoodsList(getGoodsList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("sku{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tdisplay_name='"+getDisplayName()+"';");
		stringBuilder.append("\tsize='"+getSize()+"';");
		if(getProduct() != null ){
 			stringBuilder.append("\tproduct='product("+getProduct().getId()+")';");
 		}
		stringBuilder.append("\tbarcode='"+getBarcode()+"';");
		stringBuilder.append("\tpackage_type='"+getPackageType()+"';");
		stringBuilder.append("\tnet_content='"+getNetContent()+"';");
		stringBuilder.append("\tprice='"+getPrice()+"';");
		stringBuilder.append("\tpicture='"+getPicture()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

