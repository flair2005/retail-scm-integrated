
package com.skynet.retailscm.leveltwocategory;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.levelonecategory.LevelOneCategory;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;

@JsonSerialize(using = LevelTwoCategorySerializer.class)
public class LevelTwoCategory extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String DISPLAY_NAME_PROPERTY          = "displayName"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_THREE_CATEGORY_LIST                = "levelThreeCategoryList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		LevelOneCategory    	mParentCategory     ;
	protected		String              	mDisplayName        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelThreeCategory>	mLevelThreeCategoryList;
	
		
	public 	LevelTwoCategory(){
		//lazy load for all the properties
	}
	
	public 	LevelTwoCategory(LevelOneCategory parentCategory, String displayName
)
	{
		setParentCategory(parentCategory);
		setDisplayName(displayName);

		this.mLevelThreeCategoryList = new SmartList<LevelThreeCategory>();	
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
	
	
	public void setParentCategory(LevelOneCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelOneCategory getParentCategory(){
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
	
	
	public  SmartList<LevelThreeCategory> getLevelThreeCategoryList(){
		if(this.mLevelThreeCategoryList == null){
			this.mLevelThreeCategoryList = new SmartList<LevelThreeCategory>();
		}
		return this.mLevelThreeCategoryList;	
	}
	public  void setLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList){
		for( LevelThreeCategory levelThreeCategory:levelThreeCategoryList){
			levelThreeCategory.setParentCategory(this);
		}
		
		this.mLevelThreeCategoryList = levelThreeCategoryList;
		
	}
	
	public  void addLevelThreeCategory(LevelThreeCategory levelThreeCategory){
		levelThreeCategory.setParentCategory(this);
		getLevelThreeCategoryList().add(levelThreeCategory);
	}
	public  void addLevelThreeCategorys(SmartList<LevelThreeCategory> levelThreeCategoryList){
		for( LevelThreeCategory levelThreeCategory:levelThreeCategoryList){
			levelThreeCategory.setParentCategory(this);
		}
		getLevelThreeCategoryList().addAll(levelThreeCategoryList);
	}
	
	public  void removeLevelThreeCategory(LevelThreeCategory levelThreeCategory){
	
		boolean result = getLevelThreeCategoryList().planToRemove(levelThreeCategory);
        if(!result){
        	String message = "LevelThreeCategory("+levelThreeCategory.getId()+") with version='"+levelThreeCategory.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveLevelThreeCategoryList", levelThreeCategory);
		//the constant "toLevelThreeCategory" will be replaced after refactoried.
	
	}
	
	public void copyLevelThreeCategoryFrom(LevelThreeCategory levelThreeCategory) {
		// TODO Auto-generated method stub
		
        LevelThreeCategory levelThreeCategoryInList = findTheLevelThreeCategory(levelThreeCategory);
        LevelThreeCategory newLevelThreeCategory = new LevelThreeCategory();
        levelThreeCategoryInList.copyTo(newLevelThreeCategory);
        newLevelThreeCategory.setVersion(0);//will trigger copy
        getLevelThreeCategoryList().add(newLevelThreeCategory);
	}
	
	public  LevelThreeCategory findTheLevelThreeCategory(LevelThreeCategory levelThreeCategory){
		
		int index =  getLevelThreeCategoryList().indexOf(levelThreeCategory);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "LevelThreeCategory("+levelThreeCategory.getId()+") with version='"+levelThreeCategory.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getLevelThreeCategoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelThreeCategoryList(){
		getLevelThreeCategoryList().clear();
	}
	
	
	
	
 	
	
	public LevelTwoCategory copyTo(LevelTwoCategory dest){

		dest.setId(getId());
		dest.setParentCategory(getParentCategory());
		dest.setDisplayName(getDisplayName());
		dest.setVersion(getVersion());
		dest.setLevelThreeCategoryList(getLevelThreeCategoryList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("level_two_category{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparent_category='level_one_category("+getParentCategory().getId()+")';");
 		}
		stringBuilder.append("\tdisplay_name='"+getDisplayName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

