
package com.skynet.retailscm.catalog;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.levelonecategory.LevelOneCategory;

@JsonSerialize(using = CatalogSerializer.class)
public class Catalog extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String DISPLAY_NAME_PROPERTY          = "displayName"       ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_ONE_CATEGORY_LIST                  = "levelOneCategoryList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mDisplayName        ;
	protected		RetailStoreCountryCenter	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelOneCategory>	mLevelOneCategoryList;
	
		
	public 	Catalog(){
		//lazy load for all the properties
	}
	
	public 	Catalog(String displayName, RetailStoreCountryCenter owner
)
	{
		setDisplayName(displayName);
		setOwner(owner);

		this.mLevelOneCategoryList = new SmartList<LevelOneCategory>();	
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
	
	
	public void setDisplayName(String displayName){
		this.mDisplayName = trimString(displayName);;
	}
	public String getDisplayName(){
		return this.mDisplayName;
	}
	
	
	public void setOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
	}
	public RetailStoreCountryCenter getOwner(){
		return this.mOwner;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<LevelOneCategory> getLevelOneCategoryList(){
		if(this.mLevelOneCategoryList == null){
			this.mLevelOneCategoryList = new SmartList<LevelOneCategory>();
		}
		return this.mLevelOneCategoryList;	
	}
	public  void setLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList){
		for( LevelOneCategory levelOneCategory:levelOneCategoryList){
			levelOneCategory.setCatalog(this);
		}
		
		this.mLevelOneCategoryList = levelOneCategoryList;
		
	}
	
	public  void addLevelOneCategory(LevelOneCategory levelOneCategory){
		levelOneCategory.setCatalog(this);
		getLevelOneCategoryList().add(levelOneCategory);
	}
	public  void addLevelOneCategorys(SmartList<LevelOneCategory> levelOneCategoryList){
		for( LevelOneCategory levelOneCategory:levelOneCategoryList){
			levelOneCategory.setCatalog(this);
		}
		getLevelOneCategoryList().addAll(levelOneCategoryList);
	}
	
	public  void removeLevelOneCategory(LevelOneCategory levelOneCategory){
	
		boolean result = getLevelOneCategoryList().planToRemove(levelOneCategory);
        if(!result){
        	String message = "LevelOneCategory("+levelOneCategory.getId()+") with version='"+levelOneCategory.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveLevelOneCategoryList", levelOneCategory);
		//the constant "toLevelOneCategory" will be replaced after refactoried.
	
	}
	
	public void copyLevelOneCategoryFrom(LevelOneCategory levelOneCategory) {
		// TODO Auto-generated method stub
		
        LevelOneCategory levelOneCategoryInList = findTheLevelOneCategory(levelOneCategory);
        LevelOneCategory newLevelOneCategory = new LevelOneCategory();
        levelOneCategoryInList.copyTo(newLevelOneCategory);
        newLevelOneCategory.setVersion(0);//will trigger copy
        getLevelOneCategoryList().add(newLevelOneCategory);
	}
	
	public  LevelOneCategory findTheLevelOneCategory(LevelOneCategory levelOneCategory){
		
		int index =  getLevelOneCategoryList().indexOf(levelOneCategory);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "LevelOneCategory("+levelOneCategory.getId()+") with version='"+levelOneCategory.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getLevelOneCategoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelOneCategoryList(){
		getLevelOneCategoryList().clear();
	}
	
	
	
	
 	
	
	public Catalog copyTo(Catalog dest){

		dest.setId(getId());
		dest.setDisplayName(getDisplayName());
		dest.setOwner(getOwner());
		dest.setVersion(getVersion());
		dest.setLevelOneCategoryList(getLevelOneCategoryList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("catalog{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tdisplay_name='"+getDisplayName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_country_center("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

