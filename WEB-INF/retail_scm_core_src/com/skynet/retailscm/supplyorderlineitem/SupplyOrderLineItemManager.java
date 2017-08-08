
package com.skynet.retailscm.supplyorderlineitem;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderLineItemManager{

	public SupplyOrderLineItem createSupplyOrderLineItem(RetailScmUserContext userContext, String bizOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement
) throws Exception;	
	public SupplyOrderLineItem updateSupplyOrderLineItem(RetailScmUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SupplyOrderLineItem transferToAnotherBizOrder(RetailScmUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String supplyOrderLineItemId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


