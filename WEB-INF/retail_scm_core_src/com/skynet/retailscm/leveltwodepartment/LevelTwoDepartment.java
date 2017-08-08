
package com.skynet.retailscm.leveltwodepartment;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartment;

@JsonSerialize(using = LevelTwoDepartmentSerializer.class)
public class LevelTwoDepartment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_THREE_DEPARTMENT_LIST              = "levelThreeDepartmentList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		LevelOneDepartment  	mBelongsTo          ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		Date                	mFounded            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelThreeDepartment>	mLevelThreeDepartmentList;
	
		
	public 	LevelTwoDepartment(){
		//lazy load for all the properties
	}
	
	public 	LevelTwoDepartment(LevelOneDepartment belongsTo, String name, String description, Date founded
)
	{
		setBelongsTo(belongsTo);
		setName(name);
		setDescription(description);
		setFounded(founded);

		this.mLevelThreeDepartmentList = new SmartList<LevelThreeDepartment>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
	
	
	public void setBelongsTo(LevelOneDepartment belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public LevelOneDepartment getBelongsTo(){
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
	
	
	public  SmartList<LevelThreeDepartment> getLevelThreeDepartmentList(){
		if(this.mLevelThreeDepartmentList == null){
			this.mLevelThreeDepartmentList = new SmartList<LevelThreeDepartment>();
		}
		return this.mLevelThreeDepartmentList;	
	}
	public  void setLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList){
		for( LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList){
			levelThreeDepartment.setBelongsTo(this);
		}
		
		this.mLevelThreeDepartmentList = levelThreeDepartmentList;
		
	}
	
	public  void addLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment){
		levelThreeDepartment.setBelongsTo(this);
		getLevelThreeDepartmentList().add(levelThreeDepartment);
	}
	public  void addLevelThreeDepartments(SmartList<LevelThreeDepartment> levelThreeDepartmentList){
		for( LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList){
			levelThreeDepartment.setBelongsTo(this);
		}
		getLevelThreeDepartmentList().addAll(levelThreeDepartmentList);
	}
	
	public  void removeLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment){
	
		boolean result = getLevelThreeDepartmentList().planToRemove(levelThreeDepartment);
        if(!result){
        	String message = "LevelThreeDepartment("+levelThreeDepartment.getId()+") with version='"+levelThreeDepartment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveLevelThreeDepartmentList", levelThreeDepartment);
		//the constant "toLevelThreeDepartment" will be replaced after refactoried.
	
	}
	
	public void copyLevelThreeDepartmentFrom(LevelThreeDepartment levelThreeDepartment) {
		// TODO Auto-generated method stub
		
        LevelThreeDepartment levelThreeDepartmentInList = findTheLevelThreeDepartment(levelThreeDepartment);
        LevelThreeDepartment newLevelThreeDepartment = new LevelThreeDepartment();
        levelThreeDepartmentInList.copyTo(newLevelThreeDepartment);
        newLevelThreeDepartment.setVersion(0);//will trigger copy
        getLevelThreeDepartmentList().add(newLevelThreeDepartment);
	}
	
	public  LevelThreeDepartment findTheLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment){
		
		int index =  getLevelThreeDepartmentList().indexOf(levelThreeDepartment);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "LevelThreeDepartment("+levelThreeDepartment.getId()+") with version='"+levelThreeDepartment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getLevelThreeDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelThreeDepartmentList(){
		getLevelThreeDepartmentList().clear();
	}
	
	
	
	
 	
	
	public LevelTwoDepartment copyTo(LevelTwoDepartment dest){

		dest.setId(getId());
		dest.setBelongsTo(getBelongsTo());
		dest.setName(getName());
		dest.setDescription(getDescription());
		dest.setFounded(getFounded());
		dest.setVersion(getVersion());
		dest.setLevelThreeDepartmentList(getLevelThreeDepartmentList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("level_two_department{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongs_to='level_one_department("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

