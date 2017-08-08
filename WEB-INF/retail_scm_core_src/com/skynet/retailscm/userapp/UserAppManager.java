
package com.skynet.retailscm.userapp;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface UserAppManager{

	public UserApp createUserApp(RetailScmUserContext userContext, String title, String secUserId, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location
) throws Exception;	
	public UserApp updateUserApp(RetailScmUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public UserApp transferToAnotherSecUser(RetailScmUserContext userContext, String userAppId, String anotherSecUserId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String userAppId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  UserApp addObjectAccess(RetailScmUserContext userContext, String userAppId, String displayName, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9 ,String [] tokensExpr)  throws Exception;
	public  UserApp removeObjectAccess(RetailScmUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateObjectAccess(RetailScmUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


