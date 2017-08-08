
package com.skynet.retailscm.retailstorecreation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreCreationManager{

	public RetailStoreCreation createRetailStoreCreation(RetailScmUserContext userContext, String comment
) throws Exception;	
	public RetailStoreCreation updateRetailStoreCreation(RetailScmUserContext userContext,String retailStoreCreationId, int retailStoreCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreCreationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreCreation addRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCreation removeRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCreation updateRetailStore(RetailScmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


