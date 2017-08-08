
package com.skynet.retailscm.userdomain;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.secuser.SecUser;

@JsonSerialize(using = UserDomainSerializer.class)
public class UserDomain extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SEC_USER_LIST                            = "secUserList"       ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<SecUser>  	mSecUserList        ;
	
		
	public 	UserDomain(){
		//lazy load for all the properties
	}
	
	public 	UserDomain(String name
)
	{
		setName(name);

		this.mSecUserList = new SmartList<SecUser>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<SecUser> getSecUserList(){
		if(this.mSecUserList == null){
			this.mSecUserList = new SmartList<SecUser>();
		}
		return this.mSecUserList;	
	}
	public  void setSecUserList(SmartList<SecUser> secUserList){
		for( SecUser secUser:secUserList){
			secUser.setDomain(this);
		}
		
		this.mSecUserList = secUserList;
		
	}
	
	public  void addSecUser(SecUser secUser){
		secUser.setDomain(this);
		getSecUserList().add(secUser);
	}
	public  void addSecUsers(SmartList<SecUser> secUserList){
		for( SecUser secUser:secUserList){
			secUser.setDomain(this);
		}
		getSecUserList().addAll(secUserList);
	}
	
	public  void removeSecUser(SecUser secUser){
	
		boolean result = getSecUserList().planToRemove(secUser);
        if(!result){
        	String message = "SecUser("+secUser.getId()+") with version='"+secUser.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSecUserList", secUser);
		//the constant "toSecUser" will be replaced after refactoried.
	
	}
	
	public void copySecUserFrom(SecUser secUser) {
		// TODO Auto-generated method stub
		
        SecUser secUserInList = findTheSecUser(secUser);
        SecUser newSecUser = new SecUser();
        secUserInList.copyTo(newSecUser);
        newSecUser.setVersion(0);//will trigger copy
        getSecUserList().add(newSecUser);
	}
	
	public  SecUser findTheSecUser(SecUser secUser){
		
		int index =  getSecUserList().indexOf(secUser);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SecUser("+secUser.getId()+") with version='"+secUser.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSecUserList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSecUserList(){
		getSecUserList().clear();
	}
	
	
	
	
 	
	
	public UserDomain copyTo(UserDomain dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setVersion(getVersion());
		dest.setSecUserList(getSecUserList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("user_domain{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

