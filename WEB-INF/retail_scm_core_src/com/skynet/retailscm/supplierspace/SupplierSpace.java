
package com.skynet.retailscm.supplierspace;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.goodsshelf.GoodsShelf;

@JsonSerialize(using = SupplierSpaceSerializer.class)
public class SupplierSpace extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String TOTAL_AREA_PROPERTY            = "totalArea"         ;
	public static final String WAREHOUSE_PROPERTY             = "warehouse"         ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_SHELF_LIST                         = "goodsShelfList"    ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mLocation           ;
	protected		String              	mContactNumber      ;
	protected		String              	mTotalArea          ;
	protected		Warehouse           	mWarehouse          ;
	protected		double              	mLatitude           ;
	protected		double              	mLongitude          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<GoodsShelf>	mGoodsShelfList     ;
	
		
	public 	SupplierSpace(){
		//lazy load for all the properties
	}
	
	public 	SupplierSpace(String location, String contactNumber, String totalArea, Warehouse warehouse, double latitude, double longitude
)
	{
		setLocation(location);
		setContactNumber(contactNumber);
		setTotalArea(totalArea);
		setWarehouse(warehouse);
		setLatitude(latitude);
		setLongitude(longitude);

		this.mGoodsShelfList = new SmartList<GoodsShelf>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
		}
		if(TOTAL_AREA_PROPERTY.equals(property)){
			changeTotalAreaProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLocationProperty(String newValueExpr){
		String oldValue = getLocation();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLocation(newValue);
		//they are surely different each other
		this.onChangeProperty(LOCATION_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeTotalAreaProperty(String newValueExpr){
		String oldValue = getTotalArea();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTotalArea(newValue);
		//they are surely different each other
		this.onChangeProperty(TOTAL_AREA_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLatitudeProperty(String newValueExpr){
		double oldValue = getLatitude();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLatitude(newValue);
		//they are surely different each other
		this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLongitudeProperty(String newValueExpr){
		double oldValue = getLongitude();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLongitude(newValue);
		//they are surely different each other
		this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setLocation(String location){
		this.mLocation = trimString(location);;
	}
	public String getLocation(){
		return this.mLocation;
	}
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	
	
	public void setTotalArea(String totalArea){
		this.mTotalArea = trimString(totalArea);;
	}
	public String getTotalArea(){
		return this.mTotalArea;
	}
	
	
	public void setWarehouse(Warehouse warehouse){
		this.mWarehouse = warehouse;;
	}
	public Warehouse getWarehouse(){
		return this.mWarehouse;
	}
	
	
	public void setLatitude(double latitude){
		this.mLatitude = latitude;;
	}
	public double getLatitude(){
		return this.mLatitude;
	}
	
	
	public void setLongitude(double longitude){
		this.mLongitude = longitude;;
	}
	public double getLongitude(){
		return this.mLongitude;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<GoodsShelf> getGoodsShelfList(){
		if(this.mGoodsShelfList == null){
			this.mGoodsShelfList = new SmartList<GoodsShelf>();
		}
		return this.mGoodsShelfList;	
	}
	public  void setGoodsShelfList(SmartList<GoodsShelf> goodsShelfList){
		for( GoodsShelf goodsShelf:goodsShelfList){
			goodsShelf.setSupplierSpace(this);
		}
		
		this.mGoodsShelfList = goodsShelfList;
		
	}
	
	public  void addGoodsShelf(GoodsShelf goodsShelf){
		goodsShelf.setSupplierSpace(this);
		getGoodsShelfList().add(goodsShelf);
	}
	public  void addGoodsShelfs(SmartList<GoodsShelf> goodsShelfList){
		for( GoodsShelf goodsShelf:goodsShelfList){
			goodsShelf.setSupplierSpace(this);
		}
		getGoodsShelfList().addAll(goodsShelfList);
	}
	
	public  void removeGoodsShelf(GoodsShelf goodsShelf){
	
		boolean result = getGoodsShelfList().planToRemove(goodsShelf);
        if(!result){
        	String message = "GoodsShelf("+goodsShelf.getId()+") with version='"+goodsShelf.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveGoodsShelfList", goodsShelf);
		//the constant "toGoodsShelf" will be replaced after refactoried.
	
	}
	
	public void copyGoodsShelfFrom(GoodsShelf goodsShelf) {
		// TODO Auto-generated method stub
		
        GoodsShelf goodsShelfInList = findTheGoodsShelf(goodsShelf);
        GoodsShelf newGoodsShelf = new GoodsShelf();
        goodsShelfInList.copyTo(newGoodsShelf);
        newGoodsShelf.setVersion(0);//will trigger copy
        getGoodsShelfList().add(newGoodsShelf);
	}
	
	public  GoodsShelf findTheGoodsShelf(GoodsShelf goodsShelf){
		
		int index =  getGoodsShelfList().indexOf(goodsShelf);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "GoodsShelf("+goodsShelf.getId()+") with version='"+goodsShelf.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getGoodsShelfList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsShelfList(){
		getGoodsShelfList().clear();
	}
	
	
	
	
 	
	
	public SupplierSpace copyTo(SupplierSpace dest){

		dest.setId(getId());
		dest.setLocation(getLocation());
		dest.setContactNumber(getContactNumber());
		dest.setTotalArea(getTotalArea());
		dest.setWarehouse(getWarehouse());
		dest.setLatitude(getLatitude());
		dest.setLongitude(getLongitude());
		dest.setVersion(getVersion());
		dest.setGoodsShelfList(getGoodsShelfList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("supplier_space{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tcontact_number='"+getContactNumber()+"';");
		stringBuilder.append("\ttotal_area='"+getTotalArea()+"';");
		if(getWarehouse() != null ){
 			stringBuilder.append("\twarehouse='warehouse("+getWarehouse().getId()+")';");
 		}
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

