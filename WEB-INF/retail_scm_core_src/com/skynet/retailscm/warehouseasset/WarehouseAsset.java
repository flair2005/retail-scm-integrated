
package com.skynet.retailscm.warehouseasset;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.warehouse.Warehouse;

@JsonSerialize(using = WarehouseAssetSerializer.class)
public class WarehouseAsset extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String POSITION_PROPERTY              = "position"          ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mPosition           ;
	protected		Warehouse           	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	WarehouseAsset(){
		//lazy load for all the properties
	}
	
	public 	WarehouseAsset(String name, String position, Warehouse owner
)
	{
		setName(name);
		setPosition(position);
		setOwner(owner);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(POSITION_PROPERTY.equals(property)){
			changePositionProperty(newValueExpr);
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
			
			
			
	protected void changePositionProperty(String newValueExpr){
		String oldValue = getPosition();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPosition(newValue);
		//they are surely different each other
		this.onChangeProperty(POSITION_PROPERTY, oldValue, newValue);
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
	
	
	public void setPosition(String position){
		this.mPosition = trimString(position);;
	}
	public String getPosition(){
		return this.mPosition;
	}
	
	
	public void setOwner(Warehouse owner){
		this.mOwner = owner;;
	}
	public Warehouse getOwner(){
		return this.mOwner;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public WarehouseAsset copyTo(WarehouseAsset dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setPosition(getPosition());
		dest.setOwner(getOwner());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("warehouse_asset{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tposition='"+getPosition()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='warehouse("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

