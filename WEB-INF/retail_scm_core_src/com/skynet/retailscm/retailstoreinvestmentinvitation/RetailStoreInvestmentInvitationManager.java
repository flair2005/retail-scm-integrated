
package com.skynet.retailscm.retailstoreinvestmentinvitation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreInvestmentInvitationManager{

	public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(RetailScmUserContext userContext, String comment
) throws Exception;	
	public RetailStoreInvestmentInvitation updateRetailStoreInvestmentInvitation(RetailScmUserContext userContext,String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreInvestmentInvitation addRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreInvestmentInvitation removeRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreInvestmentInvitation updateRetailStore(RetailScmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


