
package com.skynet.retailscm.goodsallocation;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.goodsshelf.GoodsShelf;

@JsonSerialize(using = GoodsAllocationSerializer.class)
public class GoodsAllocation extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String GOODS_SHELF_PROPERTY           = "goodsShelf"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_LIST                               = "goodsList"         ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mLocation           ;
	protected		double              	mLatitude           ;
	protected		double              	mLongitude          ;
	protected		GoodsShelf          	mGoodsShelf         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Goods>    	mGoodsList          ;
	
		
	public 	GoodsAllocation(){
		//lazy load for all the properties
	}
	
	public 	GoodsAllocation(String location, double latitude, double longitude, GoodsShelf goodsShelf
)
	{
		setLocation(location);
		setLatitude(latitude);
		setLongitude(longitude);
		setGoodsShelf(goodsShelf);

		this.mGoodsList = new SmartList<Goods>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
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
	
	
	public void setGoodsShelf(GoodsShelf goodsShelf){
		this.mGoodsShelf = goodsShelf;;
	}
	public GoodsShelf getGoodsShelf(){
		return this.mGoodsShelf;
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
			goods.setGoodsAllocation(this);
		}
		
		this.mGoodsList = goodsList;
		
	}
	
	public  void addGoods(Goods goods){
		goods.setGoodsAllocation(this);
		getGoodsList().add(goods);
	}
	public  void addGoodses(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setGoodsAllocation(this);
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
	
	
	
	
 	
	
	public GoodsAllocation copyTo(GoodsAllocation dest){

		dest.setId(getId());
		dest.setLocation(getLocation());
		dest.setLatitude(getLatitude());
		dest.setLongitude(getLongitude());
		dest.setGoodsShelf(getGoodsShelf());
		dest.setVersion(getVersion());
		dest.setGoodsList(getGoodsList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("goods_allocation{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		if(getGoodsShelf() != null ){
 			stringBuilder.append("\tgoods_shelf='goods_shelf("+getGoodsShelf().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

