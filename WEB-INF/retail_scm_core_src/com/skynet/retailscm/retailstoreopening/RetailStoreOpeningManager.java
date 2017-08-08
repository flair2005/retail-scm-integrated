
package com.skynet.retailscm.retailstoreopening;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOpeningManager{

	public RetailStoreOpening createRetailStoreOpening(RetailScmUserContext userContext, String comment
) throws Exception;	
	public RetailStoreOpening updateRetailStoreOpening(RetailScmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreOpeningId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreOpening addRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOpening removeRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOpening updateRetailStore(RetailScmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


