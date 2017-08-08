
package com.skynet.retailscm.userapp;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.secuser.SecUser;
import com.skynet.retailscm.objectaccess.ObjectAccess;

@JsonSerialize(using = UserAppSerializer.class)
public class UserApp extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String SEC_USER_PROPERTY              = "secUser"           ;
	public static final String APP_ICON_PROPERTY              = "appIcon"           ;
	public static final String FULL_ACCESS_PROPERTY           = "fullAccess"        ;
	public static final String PERMISSION_PROPERTY            = "permission"        ;
	public static final String OBJECT_TYPE_PROPERTY           = "objectType"        ;
	public static final String OBJECT_ID_PROPERTY             = "objectId"          ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String OBJECT_ACCESS_LIST                       = "objectAccessList"  ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		SecUser             	mSecUser            ;
	protected		String              	mAppIcon            ;
	protected		boolean             	mFullAccess         ;
	protected		String              	mPermission         ;
	protected		String              	mObjectType         ;
	protected		String              	mObjectId           ;
	protected		String              	mLocation           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ObjectAccess>	mObjectAccessList   ;
	
		
	public 	UserApp(){
		//lazy load for all the properties
	}
	
	public 	UserApp(String title, SecUser secUser, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location
)
	{
		setTitle(title);
		setSecUser(secUser);
		setAppIcon(appIcon);
		setFullAccess(fullAccess);
		setPermission(permission);
		setObjectType(objectType);
		setObjectId(objectId);
		setLocation(location);

		this.mObjectAccessList = new SmartList<ObjectAccess>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(APP_ICON_PROPERTY.equals(property)){
			changeAppIconProperty(newValueExpr);
		}
		if(FULL_ACCESS_PROPERTY.equals(property)){
			changeFullAccessProperty(newValueExpr);
		}
		if(PERMISSION_PROPERTY.equals(property)){
			changePermissionProperty(newValueExpr);
		}
		if(OBJECT_TYPE_PROPERTY.equals(property)){
			changeObjectTypeProperty(newValueExpr);
		}
		if(OBJECT_ID_PROPERTY.equals(property)){
			changeObjectIdProperty(newValueExpr);
		}
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTitle(newValue);
		//they are surely different each other
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAppIconProperty(String newValueExpr){
		String oldValue = getAppIcon();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAppIcon(newValue);
		//they are surely different each other
		this.onChangeProperty(APP_ICON_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeFullAccessProperty(String newValueExpr){
		boolean oldValue = getFullAccess();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFullAccess(newValue);
		//they are surely different each other
		this.onChangeProperty(FULL_ACCESS_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changePermissionProperty(String newValueExpr){
		String oldValue = getPermission();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPermission(newValue);
		//they are surely different each other
		this.onChangeProperty(PERMISSION_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeObjectTypeProperty(String newValueExpr){
		String oldValue = getObjectType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setObjectType(newValue);
		//they are surely different each other
		this.onChangeProperty(OBJECT_TYPE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeObjectIdProperty(String newValueExpr){
		String oldValue = getObjectId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setObjectId(newValue);
		//they are surely different each other
		this.onChangeProperty(OBJECT_ID_PROPERTY, oldValue, newValue);
		return;
             
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	
	
	public void setSecUser(SecUser secUser){
		this.mSecUser = secUser;;
	}
	public SecUser getSecUser(){
		return this.mSecUser;
	}
	
	
	public void setAppIcon(String appIcon){
		this.mAppIcon = trimString(appIcon);;
	}
	public String getAppIcon(){
		return this.mAppIcon;
	}
	
	
	public void setFullAccess(boolean fullAccess){
		this.mFullAccess = fullAccess;;
	}
	public boolean getFullAccess(){
		return this.mFullAccess;
	}
	
	
	public void setPermission(String permission){
		this.mPermission = trimString(permission);;
	}
	public String getPermission(){
		return this.mPermission;
	}
	
	
	public void setObjectType(String objectType){
		this.mObjectType = trimString(objectType);;
	}
	public String getObjectType(){
		return this.mObjectType;
	}
	
	
	public void setObjectId(String objectId){
		this.mObjectId = trimString(objectId);;
	}
	public String getObjectId(){
		return this.mObjectId;
	}
	
	
	public void setLocation(String location){
		this.mLocation = trimString(location);;
	}
	public String getLocation(){
		return this.mLocation;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<ObjectAccess> getObjectAccessList(){
		if(this.mObjectAccessList == null){
			this.mObjectAccessList = new SmartList<ObjectAccess>();
		}
		return this.mObjectAccessList;	
	}
	public  void setObjectAccessList(SmartList<ObjectAccess> objectAccessList){
		for( ObjectAccess objectAccess:objectAccessList){
			objectAccess.setApp(this);
		}
		
		this.mObjectAccessList = objectAccessList;
		
	}
	
	public  void addObjectAccess(ObjectAccess objectAccess){
		objectAccess.setApp(this);
		getObjectAccessList().add(objectAccess);
	}
	public  void addObjectAccesses(SmartList<ObjectAccess> objectAccessList){
		for( ObjectAccess objectAccess:objectAccessList){
			objectAccess.setApp(this);
		}
		getObjectAccessList().addAll(objectAccessList);
	}
	
	public  void removeObjectAccess(ObjectAccess objectAccess){
	
		boolean result = getObjectAccessList().planToRemove(objectAccess);
        if(!result){
        	String message = "ObjectAccess("+objectAccess.getId()+") with version='"+objectAccess.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveObjectAccessList", objectAccess);
		//the constant "toObjectAccess" will be replaced after refactoried.
	
	}
	
	public void copyObjectAccessFrom(ObjectAccess objectAccess) {
		// TODO Auto-generated method stub
		
        ObjectAccess objectAccessInList = findTheObjectAccess(objectAccess);
        ObjectAccess newObjectAccess = new ObjectAccess();
        objectAccessInList.copyTo(newObjectAccess);
        newObjectAccess.setVersion(0);//will trigger copy
        getObjectAccessList().add(newObjectAccess);
	}
	
	public  ObjectAccess findTheObjectAccess(ObjectAccess objectAccess){
		
		int index =  getObjectAccessList().indexOf(objectAccess);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ObjectAccess("+objectAccess.getId()+") with version='"+objectAccess.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getObjectAccessList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpObjectAccessList(){
		getObjectAccessList().clear();
	}
	
	
	
	
 	
	
	public UserApp copyTo(UserApp dest){

		dest.setId(getId());
		dest.setTitle(getTitle());
		dest.setSecUser(getSecUser());
		dest.setAppIcon(getAppIcon());
		dest.setFullAccess(getFullAccess());
		dest.setPermission(getPermission());
		dest.setObjectType(getObjectType());
		dest.setObjectId(getObjectId());
		dest.setLocation(getLocation());
		dest.setVersion(getVersion());
		dest.setObjectAccessList(getObjectAccessList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("user_app{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getSecUser() != null ){
 			stringBuilder.append("\tsec_user='sec_user("+getSecUser().getId()+")';");
 		}
		stringBuilder.append("\tapp_icon='"+getAppIcon()+"';");
		stringBuilder.append("\tfull_access='"+getFullAccess()+"';");
		stringBuilder.append("\tpermission='"+getPermission()+"';");
		stringBuilder.append("\tobject_type='"+getObjectType()+"';");
		stringBuilder.append("\tobject_id='"+getObjectId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

