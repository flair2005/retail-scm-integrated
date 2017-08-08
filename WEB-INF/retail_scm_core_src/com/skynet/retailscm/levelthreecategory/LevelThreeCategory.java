
package com.skynet.retailscm.levelthreecategory;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;

@JsonSerialize(using = LevelThreeCategorySerializer.class)
public class LevelThreeCategory extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String DISPLAY_NAME_PROPERTY          = "displayName"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PRODUCT_LIST                             = "productList"       ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		LevelTwoCategory    	mParentCategory     ;
	protected		String              	mDisplayName        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Product>  	mProductList        ;
	
		
	public 	LevelThreeCategory(){
		//lazy load for all the properties
	}
	
	public 	LevelThreeCategory(LevelTwoCategory parentCategory, String displayName
)
	{
		setParentCategory(parentCategory);
		setDisplayName(displayName);

		this.mProductList = new SmartList<Product>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(DISPLAY_NAME_PROPERTY.equals(property)){
			changeDisplayNameProperty(newValueExpr);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setParentCategory(LevelTwoCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelTwoCategory getParentCategory(){
		return this.mParentCategory;
	}
	
	
	public void setDisplayName(String displayName){
		this.mDisplayName = trimString(displayName);;
	}
	public String getDisplayName(){
		return this.mDisplayName;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<Product> getProductList(){
		if(this.mProductList == null){
			this.mProductList = new SmartList<Product>();
		}
		return this.mProductList;	
	}
	public  void setProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setParentCategory(this);
		}
		
		this.mProductList = productList;
		
	}
	
	public  void addProduct(Product product){
		product.setParentCategory(this);
		getProductList().add(product);
	}
	public  void addProducts(SmartList<Product> productList){
		for( Product product:productList){
			product.setParentCategory(this);
		}
		getProductList().addAll(productList);
	}
	
	public  void removeProduct(Product product){
	
		boolean result = getProductList().planToRemove(product);
        if(!result){
        	String message = "Product("+product.getId()+") with version='"+product.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveProductList", product);
		//the constant "toProduct" will be replaced after refactoried.
	
	}
	
	public void copyProductFrom(Product product) {
		// TODO Auto-generated method stub
		
        Product productInList = findTheProduct(product);
        Product newProduct = new Product();
        productInList.copyTo(newProduct);
        newProduct.setVersion(0);//will trigger copy
        getProductList().add(newProduct);
	}
	
	public  Product findTheProduct(Product product){
		
		int index =  getProductList().indexOf(product);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Product("+product.getId()+") with version='"+product.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProductList(){
		getProductList().clear();
	}
	
	
	
	
 	
	
	public LevelThreeCategory copyTo(LevelThreeCategory dest){

		dest.setId(getId());
		dest.setParentCategory(getParentCategory());
		dest.setDisplayName(getDisplayName());
		dest.setVersion(getVersion());
		dest.setProductList(getProductList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("level_three_category{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparent_category='level_two_category("+getParentCategory().getId()+")';");
 		}
		stringBuilder.append("\tdisplay_name='"+getDisplayName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

