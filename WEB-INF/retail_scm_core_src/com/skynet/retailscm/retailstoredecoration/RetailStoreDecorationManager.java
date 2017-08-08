
package com.skynet.retailscm.retailstoredecoration;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreDecorationManager{

	public RetailStoreDecoration createRetailStoreDecoration(RetailScmUserContext userContext, String comment
) throws Exception;	
	public RetailStoreDecoration updateRetailStoreDecoration(RetailScmUserContext userContext,String retailStoreDecorationId, int retailStoreDecorationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreDecorationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreDecoration addRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreDecoration removeRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreDecoration updateRetailStore(RetailScmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


