
package com.skynet.retailscm.secuser;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.userdomain.UserDomain;
import com.skynet.retailscm.userapp.UserApp;

@JsonSerialize(using = SecUserSerializer.class)
public class SecUser extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOGIN_PROPERTY                 = "login"             ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String PWD_PROPERTY                   = "pwd"               ;
	public static final String LAST_LOGIN_PROPERTY            = "lastLogin"         ;
	public static final String DOMAIN_PROPERTY                = "domain"            ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_APP_LIST                            = "userAppList"       ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mLogin              ;
	protected		String              	mMobile             ;
	protected		String              	mEmail              ;
	protected		String              	mPwd                ;
	protected		Date                	mLastLogin          ;
	protected		UserDomain          	mDomain             ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<UserApp>  	mUserAppList        ;
	
		
	public 	SecUser(){
		//lazy load for all the properties
	}
	
	public 	SecUser(String login, String mobile, String email, String pwd, Date lastLogin, UserDomain domain
)
	{
		setLogin(login);
		setMobile(mobile);
		setEmail(email);
		setPwd(pwd);
		setLastLogin(lastLogin);
		setDomain(domain);

		this.mUserAppList = new SmartList<UserApp>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(LOGIN_PROPERTY.equals(property)){
			changeLoginProperty(newValueExpr);
		}
		if(MOBILE_PROPERTY.equals(property)){
			changeMobileProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
		}
		if(PWD_PROPERTY.equals(property)){
			changePwdProperty(newValueExpr);
		}
		if(LAST_LOGIN_PROPERTY.equals(property)){
			changeLastLoginProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLoginProperty(String newValueExpr){
		String oldValue = getLogin();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLogin(newValue);
		//they are surely different each other
		this.onChangeProperty(LOGIN_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMobileProperty(String newValueExpr){
		String oldValue = getMobile();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMobile(newValue);
		//they are surely different each other
		this.onChangeProperty(MOBILE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeEmailProperty(String newValueExpr){
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setEmail(newValue);
		//they are surely different each other
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changePwdProperty(String newValueExpr){
		String oldValue = getPwd();
		String newValue = parseString(hashStringWithSHA256(newValueExpr));
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPwd(newValue);
		//they are surely different each other
		this.onChangeProperty(PWD_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLastLoginProperty(String newValueExpr){
		Date oldValue = getLastLogin();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLastLogin(newValue);
		//they are surely different each other
		this.onChangeProperty(LAST_LOGIN_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setLogin(String login){
		this.mLogin = trimString(login);;
	}
	public String getLogin(){
		return this.mLogin;
	}
	
	
	public void setMobile(String mobile){
		this.mMobile = trimString(mobile);;
	}
	public String getMobile(){
		return this.mMobile;
	}
	
	
	
	public String getMaskedMobile(){
		String mobilePhoneNumber = getMobile();
		if(mobilePhoneNumber == null){
			return null;
		}
		if(mobilePhoneNumber.length()!=11){
			return mobilePhoneNumber;//残缺的手机号，无需屏蔽
		}
		return mobilePhoneNumber.substring(0,3)
			+"****"
			+mobilePhoneNumber.substring(7);
	}
	
		
	public void setEmail(String email){
		this.mEmail = trimString(email);;
	}
	public String getEmail(){
		return this.mEmail;
	}
	
	
	public void setPwd(String pwd){
		this.mPwd = trimString(pwd);;
	}
	public String getPwd(){
		return this.mPwd;
	}
	
	
	public void setClearTextOfPwd(String clearTextOfPwd){
	
		String hashedPwd = hashStringWithSHA256(clearTextOfPwd);
		setPwd(hashedPwd);
		
	}
	public String getMaskedPwd(){
	
		return "**********";
		
	}
	
		
	public void setLastLogin(Date lastLogin){
		this.mLastLogin = lastLogin;;
	}
	public Date getLastLogin(){
		return this.mLastLogin;
	}
	
	
	public void setDomain(UserDomain domain){
		this.mDomain = domain;;
	}
	public UserDomain getDomain(){
		return this.mDomain;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<UserApp> getUserAppList(){
		if(this.mUserAppList == null){
			this.mUserAppList = new SmartList<UserApp>();
		}
		return this.mUserAppList;	
	}
	public  void setUserAppList(SmartList<UserApp> userAppList){
		for( UserApp userApp:userAppList){
			userApp.setSecUser(this);
		}
		
		this.mUserAppList = userAppList;
		
	}
	
	public  void addUserApp(UserApp userApp){
		userApp.setSecUser(this);
		getUserAppList().add(userApp);
	}
	public  void addUserApps(SmartList<UserApp> userAppList){
		for( UserApp userApp:userAppList){
			userApp.setSecUser(this);
		}
		getUserAppList().addAll(userAppList);
	}
	
	public  void removeUserApp(UserApp userApp){
	
		boolean result = getUserAppList().planToRemove(userApp);
        if(!result){
        	String message = "UserApp("+userApp.getId()+") with version='"+userApp.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveUserAppList", userApp);
		//the constant "toUserApp" will be replaced after refactoried.
	
	}
	
	public void copyUserAppFrom(UserApp userApp) {
		// TODO Auto-generated method stub
		
        UserApp userAppInList = findTheUserApp(userApp);
        UserApp newUserApp = new UserApp();
        userAppInList.copyTo(newUserApp);
        newUserApp.setVersion(0);//will trigger copy
        getUserAppList().add(newUserApp);
	}
	
	public  UserApp findTheUserApp(UserApp userApp){
		
		int index =  getUserAppList().indexOf(userApp);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "UserApp("+userApp.getId()+") with version='"+userApp.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getUserAppList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpUserAppList(){
		getUserAppList().clear();
	}
	
	
	
	
 	
	
	public SecUser copyTo(SecUser dest){

		dest.setId(getId());
		dest.setLogin(getLogin());
		dest.setMobile(getMobile());
		dest.setEmail(getEmail());
		dest.setPwd(getPwd());
		dest.setLastLogin(getLastLogin());
		dest.setDomain(getDomain());
		dest.setVersion(getVersion());
		dest.setUserAppList(getUserAppList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("sec_user{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlogin='"+getLogin()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tpwd='"+getPwd()+"';");
		stringBuilder.append("\tlast_login='"+getLastLogin()+"';");
		if(getDomain() != null ){
 			stringBuilder.append("\tdomain='user_domain("+getDomain().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

