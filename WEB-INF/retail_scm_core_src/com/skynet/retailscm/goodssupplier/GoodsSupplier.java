
package com.skynet.retailscm.goodssupplier;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.supplierproduct.SupplierProduct;

@JsonSerialize(using = GoodsSupplierSerializer.class)
public class GoodsSupplier extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SUPPLY_PRODUCT_PROPERTY        = "supplyProduct"     ;
	public static final String BELONG_TO_PROPERTY             = "belongTo"          ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SUPPLIER_PRODUCT_LIST                    = "supplierProductList";
	public static final String SUPPLY_ORDER_LIST                        = "supplyOrderList"   ;
	public static final String ACCOUNT_SET_LIST                         = "accountSetList"    ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mSupplyProduct      ;
	protected		RetailStoreCountryCenter	mBelongTo           ;
	protected		String              	mContactNumber      ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<SupplierProduct>	mSupplierProductList;
	protected		SmartList<SupplyOrder>	mSupplyOrderList    ;
	protected		SmartList<AccountSet>	mAccountSetList     ;
	
		
	public 	GoodsSupplier(){
		//lazy load for all the properties
	}
	
	public 	GoodsSupplier(String name, String supplyProduct, RetailStoreCountryCenter belongTo, String contactNumber, String description
)
	{
		setName(name);
		setSupplyProduct(supplyProduct);
		setBelongTo(belongTo);
		setContactNumber(contactNumber);
		setDescription(description);

		this.mSupplierProductList = new SmartList<SupplierProduct>();
		this.mSupplyOrderList = new SmartList<SupplyOrder>();
		this.mAccountSetList = new SmartList<AccountSet>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SUPPLY_PRODUCT_PROPERTY.equals(property)){
			changeSupplyProductProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			
	protected void changeSupplyProductProperty(String newValueExpr){
		String oldValue = getSupplyProduct();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setSupplyProduct(newValue);
		//they are surely different each other
		this.onChangeProperty(SUPPLY_PRODUCT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeContactNumberProperty(String newValueExpr){
		String oldValue = getContactNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setContactNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(CONTACT_NUMBER_PROPERTY, oldValue, newValue);
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
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	
	
	public void setSupplyProduct(String supplyProduct){
		this.mSupplyProduct = trimString(supplyProduct);;
	}
	public String getSupplyProduct(){
		return this.mSupplyProduct;
	}
	
	
	public void setBelongTo(RetailStoreCountryCenter belongTo){
		this.mBelongTo = belongTo;;
	}
	public RetailStoreCountryCenter getBelongTo(){
		return this.mBelongTo;
	}
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	
	
	
	public String getMaskedContactNumber(){
		String mobilePhoneNumber = getContactNumber();
		if(mobilePhoneNumber == null){
			return null;
		}
		if(mobilePhoneNumber.length()!=11){
			return mobilePhoneNumber;//残缺的手机号，无需屏蔽
		}
		return mobilePhoneNumber.substring(0,3)
			+"****"
			+mobilePhoneNumber.substring(7);
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
	
	
	public  SmartList<SupplierProduct> getSupplierProductList(){
		if(this.mSupplierProductList == null){
			this.mSupplierProductList = new SmartList<SupplierProduct>();
		}
		return this.mSupplierProductList;	
	}
	public  void setSupplierProductList(SmartList<SupplierProduct> supplierProductList){
		for( SupplierProduct supplierProduct:supplierProductList){
			supplierProduct.setSupplier(this);
		}
		
		this.mSupplierProductList = supplierProductList;
		
	}
	
	public  void addSupplierProduct(SupplierProduct supplierProduct){
		supplierProduct.setSupplier(this);
		getSupplierProductList().add(supplierProduct);
	}
	public  void addSupplierProducts(SmartList<SupplierProduct> supplierProductList){
		for( SupplierProduct supplierProduct:supplierProductList){
			supplierProduct.setSupplier(this);
		}
		getSupplierProductList().addAll(supplierProductList);
	}
	
	public  void removeSupplierProduct(SupplierProduct supplierProduct){
	
		boolean result = getSupplierProductList().planToRemove(supplierProduct);
        if(!result){
        	String message = "SupplierProduct("+supplierProduct.getId()+") with version='"+supplierProduct.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSupplierProductList", supplierProduct);
		//the constant "toSupplierProduct" will be replaced after refactoried.
	
	}
	
	public void copySupplierProductFrom(SupplierProduct supplierProduct) {
		// TODO Auto-generated method stub
		
        SupplierProduct supplierProductInList = findTheSupplierProduct(supplierProduct);
        SupplierProduct newSupplierProduct = new SupplierProduct();
        supplierProductInList.copyTo(newSupplierProduct);
        newSupplierProduct.setVersion(0);//will trigger copy
        getSupplierProductList().add(newSupplierProduct);
	}
	
	public  SupplierProduct findTheSupplierProduct(SupplierProduct supplierProduct){
		
		int index =  getSupplierProductList().indexOf(supplierProduct);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SupplierProduct("+supplierProduct.getId()+") with version='"+supplierProduct.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSupplierProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplierProductList(){
		getSupplierProductList().clear();
	}
	
	
	
	
	public  SmartList<SupplyOrder> getSupplyOrderList(){
		if(this.mSupplyOrderList == null){
			this.mSupplyOrderList = new SmartList<SupplyOrder>();
		}
		return this.mSupplyOrderList;	
	}
	public  void setSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setSeller(this);
		}
		
		this.mSupplyOrderList = supplyOrderList;
		
	}
	
	public  void addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setSeller(this);
		getSupplyOrderList().add(supplyOrder);
	}
	public  void addSupplyOrders(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setSeller(this);
		}
		getSupplyOrderList().addAll(supplyOrderList);
	}
	
	public  void removeSupplyOrder(SupplyOrder supplyOrder){
	
		boolean result = getSupplyOrderList().planToRemove(supplyOrder);
        if(!result){
        	String message = "SupplyOrder("+supplyOrder.getId()+") with version='"+supplyOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSupplyOrderList", supplyOrder);
		//the constant "toSupplyOrder" will be replaced after refactoried.
	
	}
	
	public void copySupplyOrderFrom(SupplyOrder supplyOrder) {
		// TODO Auto-generated method stub
		
        SupplyOrder supplyOrderInList = findTheSupplyOrder(supplyOrder);
        SupplyOrder newSupplyOrder = new SupplyOrder();
        supplyOrderInList.copyTo(newSupplyOrder);
        newSupplyOrder.setVersion(0);//will trigger copy
        getSupplyOrderList().add(newSupplyOrder);
	}
	
	public  SupplyOrder findTheSupplyOrder(SupplyOrder supplyOrder){
		
		int index =  getSupplyOrderList().indexOf(supplyOrder);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SupplyOrder("+supplyOrder.getId()+") with version='"+supplyOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSupplyOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderList(){
		getSupplyOrderList().clear();
	}
	
	
	
	
	public  SmartList<AccountSet> getAccountSetList(){
		if(this.mAccountSetList == null){
			this.mAccountSetList = new SmartList<AccountSet>();
		}
		return this.mAccountSetList;	
	}
	public  void setAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setGoodsSupplier(this);
		}
		
		this.mAccountSetList = accountSetList;
		
	}
	
	public  void addAccountSet(AccountSet accountSet){
		accountSet.setGoodsSupplier(this);
		getAccountSetList().add(accountSet);
	}
	public  void addAccountSets(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setGoodsSupplier(this);
		}
		getAccountSetList().addAll(accountSetList);
	}
	
	public  void removeAccountSet(AccountSet accountSet){
	
		boolean result = getAccountSetList().planToRemove(accountSet);
        if(!result){
        	String message = "AccountSet("+accountSet.getId()+") with version='"+accountSet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveAccountSetList", accountSet);
		//the constant "toAccountSet" will be replaced after refactoried.
	
	}
	
	public void copyAccountSetFrom(AccountSet accountSet) {
		// TODO Auto-generated method stub
		
        AccountSet accountSetInList = findTheAccountSet(accountSet);
        AccountSet newAccountSet = new AccountSet();
        accountSetInList.copyTo(newAccountSet);
        newAccountSet.setVersion(0);//will trigger copy
        getAccountSetList().add(newAccountSet);
	}
	
	public  AccountSet findTheAccountSet(AccountSet accountSet){
		
		int index =  getAccountSetList().indexOf(accountSet);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "AccountSet("+accountSet.getId()+") with version='"+accountSet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getAccountSetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountSetList(){
		getAccountSetList().clear();
	}
	
	
	
	
 	
	
	public GoodsSupplier copyTo(GoodsSupplier dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setSupplyProduct(getSupplyProduct());
		dest.setBelongTo(getBelongTo());
		dest.setContactNumber(getContactNumber());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());
		dest.setSupplierProductList(getSupplierProductList());
		dest.setSupplyOrderList(getSupplyOrderList());
		dest.setAccountSetList(getAccountSetList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("goods_supplier{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tsupply_product='"+getSupplyProduct()+"';");
		if(getBelongTo() != null ){
 			stringBuilder.append("\tbelong_to='retail_store_country_center("+getBelongTo().getId()+")';");
 		}
		stringBuilder.append("\tcontact_number='"+getContactNumber()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

