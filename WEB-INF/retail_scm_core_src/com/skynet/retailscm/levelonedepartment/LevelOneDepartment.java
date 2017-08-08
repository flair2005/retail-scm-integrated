
package com.skynet.retailscm.levelonedepartment;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;

@JsonSerialize(using = LevelOneDepartmentSerializer.class)
public class LevelOneDepartment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String MANAGER_PROPERTY               = "manager"           ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_TWO_DEPARTMENT_LIST                = "levelTwoDepartmentList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		RetailStoreCountryCenter	mBelongsTo          ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		String              	mManager            ;
	protected		Date                	mFounded            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelTwoDepartment>	mLevelTwoDepartmentList;
	
		
	public 	LevelOneDepartment(){
		//lazy load for all the properties
	}
	
	public 	LevelOneDepartment(RetailStoreCountryCenter belongsTo, String name, String description, String manager, Date founded
)
	{
		setBelongsTo(belongsTo);
		setName(name);
		setDescription(description);
		setManager(manager);
		setFounded(founded);

		this.mLevelTwoDepartmentList = new SmartList<LevelTwoDepartment>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(MANAGER_PROPERTY.equals(property)){
			changeManagerProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
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
			
			
			
	protected void changeManagerProperty(String newValueExpr){
		String oldValue = getManager();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setManager(newValue);
		//they are surely different each other
		this.onChangeProperty(MANAGER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFounded(newValue);
		//they are surely different each other
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setBelongsTo(RetailStoreCountryCenter belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public RetailStoreCountryCenter getBelongsTo(){
		return this.mBelongsTo;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	
	
	public void setManager(String manager){
		this.mManager = trimString(manager);;
	}
	public String getManager(){
		return this.mManager;
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<LevelTwoDepartment> getLevelTwoDepartmentList(){
		if(this.mLevelTwoDepartmentList == null){
			this.mLevelTwoDepartmentList = new SmartList<LevelTwoDepartment>();
		}
		return this.mLevelTwoDepartmentList;	
	}
	public  void setLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList){
		for( LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList){
			levelTwoDepartment.setBelongsTo(this);
		}
		
		this.mLevelTwoDepartmentList = levelTwoDepartmentList;
		
	}
	
	public  void addLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment){
		levelTwoDepartment.setBelongsTo(this);
		getLevelTwoDepartmentList().add(levelTwoDepartment);
	}
	public  void addLevelTwoDepartments(SmartList<LevelTwoDepartment> levelTwoDepartmentList){
		for( LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList){
			levelTwoDepartment.setBelongsTo(this);
		}
		getLevelTwoDepartmentList().addAll(levelTwoDepartmentList);
	}
	
	public  void removeLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment){
	
		boolean result = getLevelTwoDepartmentList().planToRemove(levelTwoDepartment);
        if(!result){
        	String message = "LevelTwoDepartment("+levelTwoDepartment.getId()+") with version='"+levelTwoDepartment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveLevelTwoDepartmentList", levelTwoDepartment);
		//the constant "toLevelTwoDepartment" will be replaced after refactoried.
	
	}
	
	public void copyLevelTwoDepartmentFrom(LevelTwoDepartment levelTwoDepartment) {
		// TODO Auto-generated method stub
		
        LevelTwoDepartment levelTwoDepartmentInList = findTheLevelTwoDepartment(levelTwoDepartment);
        LevelTwoDepartment newLevelTwoDepartment = new LevelTwoDepartment();
        levelTwoDepartmentInList.copyTo(newLevelTwoDepartment);
        newLevelTwoDepartment.setVersion(0);//will trigger copy
        getLevelTwoDepartmentList().add(newLevelTwoDepartment);
	}
	
	public  LevelTwoDepartment findTheLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment){
		
		int index =  getLevelTwoDepartmentList().indexOf(levelTwoDepartment);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "LevelTwoDepartment("+levelTwoDepartment.getId()+") with version='"+levelTwoDepartment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getLevelTwoDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelTwoDepartmentList(){
		getLevelTwoDepartmentList().clear();
	}
	
	
	
	
 	
	
	public LevelOneDepartment copyTo(LevelOneDepartment dest){

		dest.setId(getId());
		dest.setBelongsTo(getBelongsTo());
		dest.setName(getName());
		dest.setDescription(getDescription());
		dest.setManager(getManager());
		dest.setFounded(getFounded());
		dest.setVersion(getVersion());
		dest.setLevelTwoDepartmentList(getLevelTwoDepartmentList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("level_one_department{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongs_to='retail_store_country_center("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tmanager='"+getManager()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

