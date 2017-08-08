
package com.skynet.retailscm.levelonecategory;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.catalog.Catalog;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;

@JsonSerialize(using = LevelOneCategorySerializer.class)
public class LevelOneCategory extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CATALOG_PROPERTY               = "catalog"           ;
	public static final String DISPLAY_NAME_PROPERTY          = "displayName"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_TWO_CATEGORY_LIST                  = "levelTwoCategoryList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Catalog             	mCatalog            ;
	protected		String              	mDisplayName        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelTwoCategory>	mLevelTwoCategoryList;
	
		
	public 	LevelOneCategory(){
		//lazy load for all the properties
	}
	
	public 	LevelOneCategory(Catalog catalog, String displayName
)
	{
		setCatalog(catalog);
		setDisplayName(displayName);

		this.mLevelTwoCategoryList = new SmartList<LevelTwoCategory>();	
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
	
	
	public void setCatalog(Catalog catalog){
		this.mCatalog = catalog;;
	}
	public Catalog getCatalog(){
		return this.mCatalog;
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
	
	
	public  SmartList<LevelTwoCategory> getLevelTwoCategoryList(){
		if(this.mLevelTwoCategoryList == null){
			this.mLevelTwoCategoryList = new SmartList<LevelTwoCategory>();
		}
		return this.mLevelTwoCategoryList;	
	}
	public  void setLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList){
		for( LevelTwoCategory levelTwoCategory:levelTwoCategoryList){
			levelTwoCategory.setParentCategory(this);
		}
		
		this.mLevelTwoCategoryList = levelTwoCategoryList;
		
	}
	
	public  void addLevelTwoCategory(LevelTwoCategory levelTwoCategory){
		levelTwoCategory.setParentCategory(this);
		getLevelTwoCategoryList().add(levelTwoCategory);
	}
	public  void addLevelTwoCategorys(SmartList<LevelTwoCategory> levelTwoCategoryList){
		for( LevelTwoCategory levelTwoCategory:levelTwoCategoryList){
			levelTwoCategory.setParentCategory(this);
		}
		getLevelTwoCategoryList().addAll(levelTwoCategoryList);
	}
	
	public  void removeLevelTwoCategory(LevelTwoCategory levelTwoCategory){
	
		boolean result = getLevelTwoCategoryList().planToRemove(levelTwoCategory);
        if(!result){
        	String message = "LevelTwoCategory("+levelTwoCategory.getId()+") with version='"+levelTwoCategory.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveLevelTwoCategoryList", levelTwoCategory);
		//the constant "toLevelTwoCategory" will be replaced after refactoried.
	
	}
	
	public void copyLevelTwoCategoryFrom(LevelTwoCategory levelTwoCategory) {
		// TODO Auto-generated method stub
		
        LevelTwoCategory levelTwoCategoryInList = findTheLevelTwoCategory(levelTwoCategory);
        LevelTwoCategory newLevelTwoCategory = new LevelTwoCategory();
        levelTwoCategoryInList.copyTo(newLevelTwoCategory);
        newLevelTwoCategory.setVersion(0);//will trigger copy
        getLevelTwoCategoryList().add(newLevelTwoCategory);
	}
	
	public  LevelTwoCategory findTheLevelTwoCategory(LevelTwoCategory levelTwoCategory){
		
		int index =  getLevelTwoCategoryList().indexOf(levelTwoCategory);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "LevelTwoCategory("+levelTwoCategory.getId()+") with version='"+levelTwoCategory.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getLevelTwoCategoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelTwoCategoryList(){
		getLevelTwoCategoryList().clear();
	}
	
	
	
	
 	
	
	public LevelOneCategory copyTo(LevelOneCategory dest){

		dest.setId(getId());
		dest.setCatalog(getCatalog());
		dest.setDisplayName(getDisplayName());
		dest.setVersion(getVersion());
		dest.setLevelTwoCategoryList(getLevelTwoCategoryList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("level_one_category{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getCatalog() != null ){
 			stringBuilder.append("\tcatalog='catalog("+getCatalog().getId()+")';");
 		}
		stringBuilder.append("\tdisplay_name='"+getDisplayName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

