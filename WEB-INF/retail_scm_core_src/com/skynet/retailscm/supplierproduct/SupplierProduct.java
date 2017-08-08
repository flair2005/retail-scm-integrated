
package com.skynet.retailscm.supplierproduct;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.productsupplyduration.ProductSupplyDuration;

@JsonSerialize(using = SupplierProductSerializer.class)
public class SupplierProduct extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PRODUCT_NAME_PROPERTY          = "productName"       ;
	public static final String PRODUCT_DESCRIPTION_PROPERTY   = "productDescription";
	public static final String PRODUCT_UNIT_PROPERTY          = "productUnit"       ;
	public static final String SUPPLIER_PROPERTY              = "supplier"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PRODUCT_SUPPLY_DURATION_LIST             = "productSupplyDurationList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mProductName        ;
	protected		String              	mProductDescription ;
	protected		String              	mProductUnit        ;
	protected		GoodsSupplier       	mSupplier           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ProductSupplyDuration>	mProductSupplyDurationList;
	
		
	public 	SupplierProduct(){
		//lazy load for all the properties
	}
	
	public 	SupplierProduct(String productName, String productDescription, String productUnit, GoodsSupplier supplier
)
	{
		setProductName(productName);
		setProductDescription(productDescription);
		setProductUnit(productUnit);
		setSupplier(supplier);

		this.mProductSupplyDurationList = new SmartList<ProductSupplyDuration>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(PRODUCT_NAME_PROPERTY.equals(property)){
			changeProductNameProperty(newValueExpr);
		}
		if(PRODUCT_DESCRIPTION_PROPERTY.equals(property)){
			changeProductDescriptionProperty(newValueExpr);
		}
		if(PRODUCT_UNIT_PROPERTY.equals(property)){
			changeProductUnitProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeProductNameProperty(String newValueExpr){
		String oldValue = getProductName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setProductName(newValue);
		//they are surely different each other
		this.onChangeProperty(PRODUCT_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeProductDescriptionProperty(String newValueExpr){
		String oldValue = getProductDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setProductDescription(newValue);
		//they are surely different each other
		this.onChangeProperty(PRODUCT_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeProductUnitProperty(String newValueExpr){
		String oldValue = getProductUnit();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setProductUnit(newValue);
		//they are surely different each other
		this.onChangeProperty(PRODUCT_UNIT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setProductName(String productName){
		this.mProductName = trimString(productName);;
	}
	public String getProductName(){
		return this.mProductName;
	}
	
	
	public void setProductDescription(String productDescription){
		this.mProductDescription = trimString(productDescription);;
	}
	public String getProductDescription(){
		return this.mProductDescription;
	}
	
	
	public void setProductUnit(String productUnit){
		this.mProductUnit = trimString(productUnit);;
	}
	public String getProductUnit(){
		return this.mProductUnit;
	}
	
	
	public void setSupplier(GoodsSupplier supplier){
		this.mSupplier = supplier;;
	}
	public GoodsSupplier getSupplier(){
		return this.mSupplier;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<ProductSupplyDuration> getProductSupplyDurationList(){
		if(this.mProductSupplyDurationList == null){
			this.mProductSupplyDurationList = new SmartList<ProductSupplyDuration>();
		}
		return this.mProductSupplyDurationList;	
	}
	public  void setProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList){
		for( ProductSupplyDuration productSupplyDuration:productSupplyDurationList){
			productSupplyDuration.setProduct(this);
		}
		
		this.mProductSupplyDurationList = productSupplyDurationList;
		
	}
	
	public  void addProductSupplyDuration(ProductSupplyDuration productSupplyDuration){
		productSupplyDuration.setProduct(this);
		getProductSupplyDurationList().add(productSupplyDuration);
	}
	public  void addProductSupplyDurations(SmartList<ProductSupplyDuration> productSupplyDurationList){
		for( ProductSupplyDuration productSupplyDuration:productSupplyDurationList){
			productSupplyDuration.setProduct(this);
		}
		getProductSupplyDurationList().addAll(productSupplyDurationList);
	}
	
	public  void removeProductSupplyDuration(ProductSupplyDuration productSupplyDuration){
	
		boolean result = getProductSupplyDurationList().planToRemove(productSupplyDuration);
        if(!result){
        	String message = "ProductSupplyDuration("+productSupplyDuration.getId()+") with version='"+productSupplyDuration.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveProductSupplyDurationList", productSupplyDuration);
		//the constant "toProductSupplyDuration" will be replaced after refactoried.
	
	}
	
	public void copyProductSupplyDurationFrom(ProductSupplyDuration productSupplyDuration) {
		// TODO Auto-generated method stub
		
        ProductSupplyDuration productSupplyDurationInList = findTheProductSupplyDuration(productSupplyDuration);
        ProductSupplyDuration newProductSupplyDuration = new ProductSupplyDuration();
        productSupplyDurationInList.copyTo(newProductSupplyDuration);
        newProductSupplyDuration.setVersion(0);//will trigger copy
        getProductSupplyDurationList().add(newProductSupplyDuration);
	}
	
	public  ProductSupplyDuration findTheProductSupplyDuration(ProductSupplyDuration productSupplyDuration){
		
		int index =  getProductSupplyDurationList().indexOf(productSupplyDuration);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ProductSupplyDuration("+productSupplyDuration.getId()+") with version='"+productSupplyDuration.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getProductSupplyDurationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProductSupplyDurationList(){
		getProductSupplyDurationList().clear();
	}
	
	
	
	
 	
	
	public SupplierProduct copyTo(SupplierProduct dest){

		dest.setId(getId());
		dest.setProductName(getProductName());
		dest.setProductDescription(getProductDescription());
		dest.setProductUnit(getProductUnit());
		dest.setSupplier(getSupplier());
		dest.setVersion(getVersion());
		dest.setProductSupplyDurationList(getProductSupplyDurationList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("supplier_product{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tproduct_name='"+getProductName()+"';");
		stringBuilder.append("\tproduct_description='"+getProductDescription()+"';");
		stringBuilder.append("\tproduct_unit='"+getProductUnit()+"';");
		if(getSupplier() != null ){
 			stringBuilder.append("\tsupplier='goods_supplier("+getSupplier().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

