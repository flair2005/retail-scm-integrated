
package com.skynet.retailscm.objectaccess;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ObjectAccessManager{

	public ObjectAccess createObjectAccess(RetailScmUserContext userContext, String displayName, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId
) throws Exception;	
	public ObjectAccess updateObjectAccess(RetailScmUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ObjectAccess transferToAnotherApp(RetailScmUserContext userContext, String objectAccessId, String anotherAppId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String objectAccessId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


