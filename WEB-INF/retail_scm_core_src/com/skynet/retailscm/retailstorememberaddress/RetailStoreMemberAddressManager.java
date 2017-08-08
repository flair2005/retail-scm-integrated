
package com.skynet.retailscm.retailstorememberaddress;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreMemberAddressManager{

	public RetailStoreMemberAddress createRetailStoreMemberAddress(RetailScmUserContext userContext, String name, String ownerId, String mobilePhone, String address
) throws Exception;	
	public RetailStoreMemberAddress updateRetailStoreMemberAddress(RetailScmUserContext userContext,String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreMemberAddress transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberAddressId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreMemberAddressId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


