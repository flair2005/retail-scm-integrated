
package com.skynet.retailscm.secuser;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SecUserManager{

	public SecUser createSecUser(RetailScmUserContext userContext, String login, String mobile, String email, String pwd, Date lastLogin, String domainId
) throws Exception;	
	public SecUser updateSecUser(RetailScmUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SecUser transferToAnotherDomain(RetailScmUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String secUserId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SecUser addUserApp(RetailScmUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location ,String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(RetailScmUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(RetailScmUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


