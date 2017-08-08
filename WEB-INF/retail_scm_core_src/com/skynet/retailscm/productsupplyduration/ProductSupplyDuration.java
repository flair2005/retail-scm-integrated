
package com.skynet.retailscm.productsupplyduration;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.supplierproduct.SupplierProduct;

@JsonSerialize(using = ProductSupplyDurationSerializer.class)
public class ProductSupplyDuration extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String QUANTITY_PROPERTY              = "quantity"          ;
	public static final String DURATION_PROPERTY              = "duration"          ;
	public static final String PRICE_PROPERTY                 = "price"             ;
	public static final String PRODUCT_PROPERTY               = "product"           ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		int                 	mQuantity           ;
	protected		String              	mDuration           ;
	protected		double              	mPrice              ;
	protected		SupplierProduct     	mProduct            ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ProductSupplyDuration(){
		//lazy load for all the properties
	}
	
	public 	ProductSupplyDuration(int quantity, String duration, double price, SupplierProduct product
)
	{
		setQuantity(quantity);
		setDuration(duration);
		setPrice(price);
		setProduct(product);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(QUANTITY_PROPERTY.equals(property)){
			changeQuantityProperty(newValueExpr);
		}
		if(DURATION_PROPERTY.equals(property)){
			changeDurationProperty(newValueExpr);
		}
		if(PRICE_PROPERTY.equals(property)){
			changePriceProperty(newValueExpr);
		}

      
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
			
			
			
	protected void changeDurationProperty(String newValueExpr){
		String oldValue = getDuration();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDuration(newValue);
		//they are surely different each other
		this.onChangeProperty(DURATION_PROPERTY, oldValue, newValue);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setQuantity(int quantity){
		this.mQuantity = quantity;;
	}
	public int getQuantity(){
		return this.mQuantity;
	}
	
	
	public void setDuration(String duration){
		this.mDuration = trimString(duration);;
	}
	public String getDuration(){
		return this.mDuration;
	}
	
	
	public void setPrice(double price){
		this.mPrice = price;;
	}
	public double getPrice(){
		return this.mPrice;
	}
	
	
	public void setProduct(SupplierProduct product){
		this.mProduct = product;;
	}
	public SupplierProduct getProduct(){
		return this.mProduct;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public ProductSupplyDuration copyTo(ProductSupplyDuration dest){

		dest.setId(getId());
		dest.setQuantity(getQuantity());
		dest.setDuration(getDuration());
		dest.setPrice(getPrice());
		dest.setProduct(getProduct());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("product_supply_duration{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tquantity='"+getQuantity()+"';");
		stringBuilder.append("\tduration='"+getDuration()+"';");
		stringBuilder.append("\tprice='"+getPrice()+"';");
		if(getProduct() != null ){
 			stringBuilder.append("\tproduct='supplier_product("+getProduct().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

