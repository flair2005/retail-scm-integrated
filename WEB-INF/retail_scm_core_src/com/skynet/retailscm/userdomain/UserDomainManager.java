
package com.skynet.retailscm.userdomain;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface UserDomainManager{

	public UserDomain createUserDomain(RetailScmUserContext userContext, String name
) throws Exception;	
	public UserDomain updateUserDomain(RetailScmUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String userDomainId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  UserDomain addSecUser(RetailScmUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, Date lastLogin ,String [] tokensExpr)  throws Exception;
	public  UserDomain removeSecUser(RetailScmUserContext userContext, String userDomainId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateSecUser(RetailScmUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


