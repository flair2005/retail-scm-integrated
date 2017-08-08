
package com.skynet.retailscm.view;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ViewManager{

	public View createView(RetailScmUserContext userContext, String who, String assessment, Date interviewTime
) throws Exception;	
	public View updateView(RetailScmUserContext userContext,String viewId, int viewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String viewId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


