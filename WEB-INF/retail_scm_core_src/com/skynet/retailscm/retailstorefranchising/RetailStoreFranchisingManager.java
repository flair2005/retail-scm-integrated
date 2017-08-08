
package com.skynet.retailscm.retailstorefranchising;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreFranchisingManager{

	public RetailStoreFranchising createRetailStoreFranchising(RetailScmUserContext userContext, String comment
) throws Exception;	
	public RetailStoreFranchising updateRetailStoreFranchising(RetailScmUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreFranchisingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreFranchising addRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreFranchising removeRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreFranchising updateRetailStore(RetailScmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


