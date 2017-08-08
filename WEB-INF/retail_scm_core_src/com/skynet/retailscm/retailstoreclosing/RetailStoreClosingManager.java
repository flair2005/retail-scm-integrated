
package com.skynet.retailscm.retailstoreclosing;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreClosingManager{

	public RetailStoreClosing createRetailStoreClosing(RetailScmUserContext userContext, String comment
) throws Exception;	
	public RetailStoreClosing updateRetailStoreClosing(RetailScmUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreClosingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreClosing addRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreClosing removeRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreClosing updateRetailStore(RetailScmUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


