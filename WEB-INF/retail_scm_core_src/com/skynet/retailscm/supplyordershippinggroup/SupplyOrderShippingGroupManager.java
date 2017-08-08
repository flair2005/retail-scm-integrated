
package com.skynet.retailscm.supplyordershippinggroup;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderShippingGroupManager{

	public SupplyOrderShippingGroup createSupplyOrderShippingGroup(RetailScmUserContext userContext, String name, String bizOrderId, double amount
) throws Exception;	
	public SupplyOrderShippingGroup updateSupplyOrderShippingGroup(RetailScmUserContext userContext,String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SupplyOrderShippingGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String supplyOrderShippingGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String supplyOrderShippingGroupId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


