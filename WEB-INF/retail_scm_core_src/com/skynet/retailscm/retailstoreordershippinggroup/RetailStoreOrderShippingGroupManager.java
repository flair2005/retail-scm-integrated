
package com.skynet.retailscm.retailstoreordershippinggroup;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderShippingGroupManager{

	public RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String name, String bizOrderId, double amount
) throws Exception;	
	public RetailStoreOrderShippingGroup updateRetailStoreOrderShippingGroup(RetailScmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreOrderShippingGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String retailStoreOrderShippingGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreOrderShippingGroupId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


